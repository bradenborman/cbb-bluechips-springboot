import React from "react";
import { Row, Col, Tabs, Tab } from "react-bootstrap";
import { NewFeatures } from "./components/newfeatures";
import { SignUp } from "./components/signup";
import { Login } from "./components/login";

export interface LoignSignup {}
export const LoignSignup: React.FC<LoignSignup> = (props: LoignSignup) => {
  return (
    <div id="landing-page" className="container">
      <div className="main">
        <Row>
          <Col lg={6} className="section">
            <Tabs defaultActiveKey="signup" id="uncontrolled-tab-example">
              <Tab
                eventKey="signup"
                title={
                  <span>
                    <i className="fas fa-user-plus"></i> Sign Up
                  </span>
                }
              >
                <SignUp />
              </Tab>
              <Tab
                eventKey="login"
                title={
                  <span>
                    <i className="fas fa-sign-in-alt"></i> Login
                  </span>
                }
              >
                <Login />
              </Tab>
            </Tabs>
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
