import React from "react";
import { Container, Row, Col, Card } from "react-bootstrap";
import { Link } from "react-router-dom";
import { PortfolioDetail } from "./components/portfolioDetail";

export interface IPortfolioProps {}

export const Portfolio: React.FC<IPortfolioProps> = (
  props: IPortfolioProps
) => {
  return (
    <div id="portfolio-wrapper">
      <Container>
        <Row className="game-data">
          <Col lg={6}>
            <Card>
              <Card.Header>
                <Card.Title className="portfolio-header-title">
                  <i className="fa fa-folder" />
                  Portfolio: Braden Borman
                </Card.Title>
              </Card.Header>
              <Card.Body>
                <PortfolioDetail heading="Networth">$100,000</PortfolioDetail>
                <PortfolioDetail heading="Capital">$100,000</PortfolioDetail>
                <PortfolioDetail heading="Ranking">12</PortfolioDetail>
              </Card.Body>
            </Card>
          </Col>
          <Col lg={6}>
            <Card>
              <Card.Header>
                <Card.Title className="portfolio-header-title">
                  <i className="fa fa-tachometer-alt"></i>Gameflow:
                </Card.Title>
              </Card.Header>
              <Card.Body>
                <PortfolioDetail heading="Leader Value">
                  $150,200
                </PortfolioDetail>
                <PortfolioDetail heading="Total Transactions">
                  254
                </PortfolioDetail>
                <PortfolioDetail heading="Current Round">
                  Final Four
                </PortfolioDetail>
              </Card.Body>
            </Card>
          </Col>
        </Row>
        <Row>
          <Col xl={8}>
            <Card className="portfolio-investments">
              <Card.Header>
                <Card.Title className="portfolio-header-title">
                  <i className="fa fa-money-bill-alt"></i> My Investments
                </Card.Title>
              </Card.Header>
              <Card.Body></Card.Body>
            </Card>
          </Col>
          <Col xl={4}>
            <Card className="portfolioLinks">
              <Card.Body>
                <Link to={"/market"}>Market</Link>
              </Card.Body>
            </Card>
          </Col>
        </Row>
      </Container>
    </div>
  );
};
