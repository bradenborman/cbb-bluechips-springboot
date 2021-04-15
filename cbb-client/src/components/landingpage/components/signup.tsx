import React from "react";
import { Row, Col, FormControl, Button } from "react-bootstrap";

export interface ISignUpProps {}
export const SignUp: React.FC<ISignUpProps> = (props: ISignUpProps) => {
  return (
    <div>
      <h2>New Users</h2>
      <Row>
        <Col md={12}>
          <div className="form-group">
            <input
              type="text"
              maxLength={30}
              name="fname"
              id="fname"
              className="form-control"
              required
            />
            <label
              className="form-control-placeholder floatingLbl"
              id="fnameLBL"
              htmlFor="fname"
            >
              First Name
            </label>
          </div>
        </Col>
        <Col md={12}>
          <div className="form-group">
            <input
              type="text"
              maxLength={30}
              name="lname"
              id="lname"
              className="form-control"
              required
            />
            <label
              className="form-control-placeholder floatingLbl"
              id="lnameLBL"
              htmlFor="lname"
            >
              Last Name
            </label>
          </div>
        </Col>
        <Col md={12}>
          <div className="form-group">
            <input
              type="text"
              name="email_new"
              id="email_new"
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
              name="password_new"
              id="password_new"
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
        <Col lg={4}>
          <Button className="btn-block">Submit</Button>
        </Col>
      </Row>
    </div>
  );
};
