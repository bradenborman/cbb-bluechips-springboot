import React from "react";
import { useParams } from "react-router";
import { Row, Col, Card } from "react-bootstrap";
import { Link } from "react-router-dom";
import { Page } from "../general/page";
export interface ITradeProps {}
export const Trade: React.FC<ITradeProps> = (props: ITradeProps) => {
  let { teamId } = useParams();

  return (
    <Page pageId="trade-wrapper">
      <nav>
        <Link to="/portfolio">Portfolio</Link>
        <Link to="/market">Market</Link>
      </nav>
      <Row>
        <Col lg={12}>
          <Card>
            <Card.Header>
              <Card.Title>Team Id: {teamId}</Card.Title>
            </Card.Header>
          </Card>
        </Col>
      </Row>
    </Page>
  );
};
