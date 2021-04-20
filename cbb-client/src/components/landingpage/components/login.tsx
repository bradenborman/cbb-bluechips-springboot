import React, { useState } from "react";
import { Row, Col, Button } from "react-bootstrap";
import axios, { AxiosRequestConfig } from "axios";

export interface ILoginProps {}
export const Login: React.FC<ILoginProps> = (props: ILoginProps) => {
  const [email, setEmail] = useState<string>(),
    [password, setPassword] = useState<string>();

  const handleSubmit = (e: any) => {
    e.preventDefault();

    const config: AxiosRequestConfig = {
      headers: {
        "Content-Type": "application/x-www-form-urlencoded"
      }
    };

    axios.post(
      "/user/login?email=" + email + "&password=" + password,
      {},
      config
    );
  };

  return (
    <div>
      <h2>Returning Users</h2>
      <form onSubmit={handleSubmit}>
        <Row>
          <Col md={12}>
            <div className="form-group">
              <input
                type="text"
                name="email"
                id="email"
                className="form-control"
                value={email}
                onChange={e => setEmail(e.target.value)}
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
                value={password}
                className="form-control"
                onChange={e => setPassword(e.target.value)}
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
            <Button type="submit" className="btn-block">
              Submit
            </Button>
          </Col>
        </Row>
      </form>
    </div>
  );
};
