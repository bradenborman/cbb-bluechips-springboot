import React, { useEffect, useState } from "react";
import { Page } from "../general/page";
import { Row, Col } from "react-bootstrap";
import { useDebouncedCallback } from "use-debounce";

import axios from "axios";

export interface ISettingsProps {}

export const Settings: React.FC<ISettingsProps> = (props: ISettingsProps) => {
  //TODO addvalitadtion for phone number and color for success

  const [phoneNumber, setPhoneNumber] = useState<string>("");
  const [isUserSubscribedToMessages, setIsUserSubscribedToMessages] = useState<
    string
  >("");

  const debounced = useDebouncedCallback((phoneNumber: any) => {
    axios
      .post(`/api/update-phone-number?phoneNumber=${phoneNumber}`)
      .then(response => {
        alert(response.status);
      })
      .catch(x => {
        console.log(x);
      });
  }, 1200);

  useEffect(() => {
    axios
      .get("/api/user-phone-number-details")
      .then(response => {
        setPhoneNumber(response.data.phoneNumber);
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
    debounced(e.target.value);
  };

  return (
    <Page pageId="settings-wrapper">
      <Row>
        <Col lg={10}></Col>
        <Col lg={2}>
          <button onClick={handleDeleteAccount} className="btn-block">
            Delete Account
          </button>
          <input value={phoneNumber} onChange={handlePhoneChangeUpdate} />
        </Col>
      </Row>
    </Page>
  );
};
