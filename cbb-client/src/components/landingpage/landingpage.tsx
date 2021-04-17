import React from "react";
import { Row, Col, Tabs, Tab } from "react-bootstrap";
import { NewFeatures } from "./components/newfeatures";
import { SignUp } from "./components/signup";
import { Login } from "./components/login";
import { ActiveHomePageOption } from "../../models/enums/activeHomePageOption";
import { GoogleLogin } from "./components/googleLogin";

export interface LoignSignup {
  selectedOption: ActiveHomePageOption;
}
export const LoignSignup: React.FC<LoignSignup> = (props: LoignSignup) => {
  return (
    <div id="landing-page" className="container">
      <div className="main">
        <Row>
          <Col lg={6} className="section">
            <Tabs
              defaultActiveKey={props.selectedOption}
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
                <Login />
              </Tab>
            </Tabs>

            <GoogleLogin />
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
