import React from "react";
import { Page } from "../general/page";
import { Card, Row, Col } from "react-bootstrap";
import { calculatorTip1 } from "../../data/staticMessages";

export interface ICalculatorProps {}
export const Calculator: React.FC<ICalculatorProps> = (
  props: ICalculatorProps
) => {
  return (
    <Page pageId="calculator">
      <Row>
        <Col xl={8}>
          <Card>
            <Card.Body>
              <label>Team 1 score:</label>
              <input />

              <label>Team 2 score:</label>
              <input />
            </Card.Body>
          </Card>
        </Col>
        <Col xl={4}>
          <Card>
            <Card.Body>
              <Card.Text>{calculatorTip1}</Card.Text>
            </Card.Body>
          </Card>
        </Col>
      </Row>
    </Page>
  );
};
