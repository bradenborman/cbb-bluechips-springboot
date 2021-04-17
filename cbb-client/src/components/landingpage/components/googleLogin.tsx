import React from "react";
import { Button, Row, Col } from "react-bootstrap";

export interface IGoogleLoginProps {}
export const GoogleLogin: React.FC<IGoogleLoginProps> = (
  props: IGoogleLoginProps
) => {
  return (
    <div id="googleLogin">
      <Row>
        <Col>
          <Button variant="success">
            <i className="fab fa-google" /> Login with Google
          </Button>
        </Col>
      </Row>
    </div>
  );
};
