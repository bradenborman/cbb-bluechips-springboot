import React, { useState } from "react";
import { Row, Col, Button } from "react-bootstrap";

export interface ILoginProps {}
export const Login: React.FC<ILoginProps> = (props: ILoginProps) => {
  // const [firstName, setFirstName] = useState<string>(),
  //   [lastName, setLastName] = useState<string>(),
  //   [emailAddress, setEmailAddress] = useState<string>(),
  //   [pinNumber, setPinNumber] = useState<number>();

  return (
    <div>
      <h2>Returning Users</h2>
      <Row>
        <Col md={12}>
          <div className="form-group">
            <input
              type="text"
              name="email"
              id="email"
              className="form-control"
              required
            />
            <label
              className="form-control-placeholder floatingLbl"
              id="email_newLBL"
              htmlFor="email_new"
            >
              Email
            </label>
          </div>
        </Col>
        <Col md={12}>
          <div className="form-group">
            <input
              type="password"
              maxLength={12}
              name="password"
              id="password"
              className="form-control"
              required
            />
            <label
              className="form-control-placeholder floatingLbl"
              id="password_newLBL"
              htmlFor="password_new"
            >
              Password
            </label>
          </div>
        </Col>
        <Col xl={12}>
          <div className="text-center">
            <Button variant="link">Forgot Password?</Button>
          </div>
        </Col>
        <Col lg={4}>
          <Button className="btn-block">Submit</Button>
        </Col>
      </Row>
    </div>
  );
};
