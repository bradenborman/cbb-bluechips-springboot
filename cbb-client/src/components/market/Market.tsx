import React from "react";
import { Container, Row, Col, Card, Button } from "react-bootstrap";

export interface IMarketProps {}

export const Market: React.FC<IMarketProps> = (props: IMarketProps) => {
  return (
    <div id="market-wrapper">
      <Container>
        <Row>
          <Col>
            <Card>
              <Card.Header className="match-up-header">
                <Card.Text>
                  <i className="fas fa-clock" /> 2:30 PM
                  <i className="fa fa-unlock" />
                </Card.Text>
              </Card.Header>
              <Card.Body className="match-up-body">
                <Row>
                  <Col>
                    <Card>
                      <Card.Title className="team-name">
                        <img
                          className="team-icon"
                          src="https://cdn.worldvectorlogo.com/logos/duke-blue-devils-1.svg"
                        />
                        Duke
                      </Card.Title>
                      <Card.Body>
                        <Card.Text className="price-chart"></Card.Text>
                        <Card.Text className="trade-btn">
                          <Button variant="primary">Trade</Button>
                        </Card.Text>
                      </Card.Body>
                      <Card.Footer className="shares-outstanding">
                        Shares OutStanding: 356
                      </Card.Footer>
                    </Card>
                  </Col>
                  <Col>
                    <Card>
                      <Card.Title className="team-name">
                        <img
                          className="team-icon"
                          src="https://a.espncdn.com/combiner/i?img=%2Fi%2Fteamlogos%2Fncaa%2F500%2F96.png"
                        />
                        Kentucky
                      </Card.Title>
                      <Card.Body>
                        <Card.Text className="price-chart"></Card.Text>
                        <Card.Text className="trade-btn">
                          <Button variant="primary">Trade</Button>
                        </Card.Text>
                      </Card.Body>
                      <Card.Footer className="shares-outstanding">
                        Shares OutStanding: 321
                      </Card.Footer>
                    </Card>
                  </Col>
                </Row>
              </Card.Body>
            </Card>
          </Col>
        </Row>
      </Container>
    </div>
  );
};
