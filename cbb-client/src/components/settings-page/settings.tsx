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
    string
  >("");

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
        setIsUserSubscribedToMessages(response.data.isSubscribedToMessages);
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

  const handlePhoneChangeUpdate = (e: any) => {
    setPhoneNumber(e.target.value);
    setPhoneNumberThinking(true);
    debounced(e.target.value);
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
        <Col lg={10}></Col>
        <Col lg={2}>
          <button onClick={handleDeleteAccount} className="btn-block">
            Delete Account
          </button>

          <div id="phone-number-input-wrapper">
            <label htmlFor="phoneNumberInput">Phone Number</label>
            <InputGroup className="mb-3">
              <FormControl
                aria-label="Small"
                aria-describedby="inputGroup-sizing-sm"
                id="phoneNumberInput"
                value={phoneNumber}
                onChange={handlePhoneChangeUpdate}
              />
              <InputGroup.Prepend>
                <InputGroup.Text>
                  {getPhoneNumberUpdateStatusIcon()}
                </InputGroup.Text>
              </InputGroup.Prepend>
            </InputGroup>
          </div>
        </Col>
      </Row>
    </Page>
  );
};
