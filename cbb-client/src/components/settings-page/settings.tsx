import React, { useEffect, useState } from "react";
import { Page } from "../general/page";
import { Row, Col, InputGroup, FormControl } from "react-bootstrap";
import { useDebouncedCallback } from "use-debounce";
import Loader from "react-loader-spinner";

import axios from "axios";

export interface ISettingsProps {}

export const Settings: React.FC<ISettingsProps> = (props: ISettingsProps) => {
  //TODO addvalitadtion for phone number and color for success

  const [phoneNumberThinking, setPhoneNumberThinking] = useState<boolean>(true);
  const [phoneNumberUpdateError, setPhoneNumberUpdateError] = useState<boolean>(
    false
  );
  const [phoneNumber, setPhoneNumber] = useState<string>("");
  const [isUserSubscribedToMessages, setIsUserSubscribedToMessages] = useState<
    boolean
  >(false);

  const debounced = useDebouncedCallback((phoneNumber: any) => {
    axios
      .post(`/api/update-phone-number?phoneNumber=${phoneNumber}`)
      .then(response => {
        setPhoneNumberThinking(false);
      })
      .catch(x => {
        console.log(x);
        setPhoneNumberUpdateError(true);
      });
  }, 1200);

  useEffect(() => {
    axios
      .get("/api/user-phone-number-details")
      .then(response => {
        setPhoneNumber(response.data.phoneNumber);
        setPhoneNumberThinking(false);
        setIsUserSubscribedToMessages(response.data.subscribedToMessages);
      })
      .catch(error => {
        console.log(error);
      });
  }, []);

  const handleDeleteAccount = (e: any) => {
    if (confirm("Are you sure you want to delete your account?")) {
      axios
        .delete("/api/delete-user")
        .then(response => {
          window.location.href = "/user/logout";
        })
        .catch(error => {
          console.log(error);
        });
    }
  };

  const callForupdateTextAlert = (subscribed: boolean) => {
    if (
      (subscribed && phoneNumber != "" && phoneNumber != null) ||
      !subscribed
    ) {
      axios
        .post(`/api/update-text-alert-status?textStatus=${subscribed}`)
        .then(response => {
          setIsUserSubscribedToMessages(subscribed);
        })
        .catch(error => {
          console.log(error);
        });
    }
  };

  const handlePhoneChangeUpdate = (e: any) => {
    setPhoneNumber(e.target.value);
    setPhoneNumberThinking(true);
    debounced(e.target.value);

    if (e.target.value == null || e.target.value == "")
      setIsUserSubscribedToMessages(false);
  };

  const getPhoneNumberUpdateStatusIcon = (): JSX.Element => {
    if (phoneNumberThinking)
      return <Loader type="Puff" color="#00BFFF" width={15} height={15} />;
    else if (phoneNumberUpdateError)
      return <i className="fa fa-exclamation"></i>;
    else return <i className="fa fa-check" />;
  };

  return (
    <Page pageId="settings-wrapper">
      <Row>
        <Col id="game-settings" lg={8} md={7}>
          <h2>Game Settings</h2>
        </Col>
        <Col id="user-settings" lg={4} md={5}>
          <h2>User Settings</h2>
          <div className="wrapper" id="phone-number-input-wrapper">
            <label htmlFor="phoneNumberInput">
              <span className="topic">Phone Number</span>
            </label>
            <InputGroup className="mb-3">
              <FormControl
                aria-label="Small"
                aria-describedby="inputGroup-sizing-sm"
                id="phoneNumberInput"
                value={phoneNumber}
                type="tel"
                pattern="[0-9]+"
                maxLength={10}
                onChange={handlePhoneChangeUpdate}
              />
              <InputGroup.Prepend>
                <InputGroup.Text>
                  {getPhoneNumberUpdateStatusIcon()}
                </InputGroup.Text>
              </InputGroup.Prepend>
            </InputGroup>
          </div>

          <div className="wrapper" id="text-alert-status-wrapper">
            <p>
              <span className="topic">Text Alerts</span> are sent out as a team
              you own in your porfilio changes price. This quick notification
              allows you to know when the team is un-locked and open for
              trading.
            </p>
            <label htmlFor="phoneNumberInput">
              I wish to subscribe to text alerts
            </label>
            <input
              checked={isUserSubscribedToMessages || false}
              onChange={e => {
                callForupdateTextAlert(!isUserSubscribedToMessages);
              }}
              type="checkbox"
            />
          </div>

          <div className="wrapper" id="delete-account-wrapper">
            <p>
              <span className="topic">Leaving CBB Bluechips</span> is easy.
              Click the button below and all data will be removed. This is
              permanent; no un-doing.
            </p>
            <button onClick={handleDeleteAccount} className="btn-block">
              Delete Account
            </button>
          </div>
        </Col>
      </Row>
    </Page>
  );
};
