import React, { useState } from "react";
import { Row, Col, Tabs, Tab } from "react-bootstrap";
import { NewFeatures } from "./components/newfeatures";
import { SignUp } from "./components/signup";
import { Login } from "./components/login";
import { ActiveHomePageOption } from "../../models/enums/activeHomePageOption";
import queryString from "query-string";
import { useLocation } from "react-router";

export interface LoignSignup {
  setIsLoggedIn: (x: boolean) => void;
}
export const LoignSignup: React.FC<LoignSignup> = (props: LoignSignup) => {
  const { search } = useLocation();
  const urlParams = queryString.parse(search);

  const [selectedOption, setSelectedOption] = useState<ActiveHomePageOption>(
    urlParams.email != null
      ? ActiveHomePageOption.LOGIN
      : ActiveHomePageOption.SIGNUP
  );

  const [emailToAttemptLogin, setEmailToAttemptLogin] = useState<string>(
    urlParams.email?.toString()
  );

  return (
    <div id="landing-page" className="container">
      <div className="main">
        <Row>
          <Col lg={6} className="section">
            <Tabs
              defaultActiveKey={selectedOption}
              id="uncontrolled-tab-example"
            >
              <Tab
                eventKey={ActiveHomePageOption.SIGNUP}
                title={
                  <span>
                    <i className="fas fa-user-plus"></i> Sign Up
                  </span>
                }
              >
                <SignUp />
              </Tab>
              <Tab
                eventKey={ActiveHomePageOption.LOGIN}
                title={
                  <span>
                    <i className="fas fa-sign-in-alt"></i> Login
                  </span>
                }
              >
                <Login
                  emailToAttemptLogin={emailToAttemptLogin}
                  setIsLoggedIn={props.setIsLoggedIn}
                />
              </Tab>
            </Tabs>

            {/* <GoogleLogin /> */}
          </Col>
          <div className="my-hr"></div>
          <Col lg={6} className="section">
            <NewFeatures />
          </Col>
        </Row>
      </div>
    </div>
  );
};
