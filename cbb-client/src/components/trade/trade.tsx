import React from "react";
import { useParams } from "react-router";
import { Container, Row, Col, Card } from "react-bootstrap";
import { Link } from "react-router-dom";
export interface ITradeProps {}
export const Trade: React.FC<ITradeProps> = (props: ITradeProps) => {
  let { teamId } = useParams();

  return (
    <div id="trade-wrapper">
      <Container>
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
      </Container>
    </div>
  );
};
