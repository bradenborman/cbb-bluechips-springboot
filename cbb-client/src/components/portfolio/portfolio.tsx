import React from "react";
import { Row, Col, Card, Table } from "react-bootstrap";
import { Link } from "react-router-dom";
import { PortfolioDetail } from "./components/portfolioDetail";
import { Page } from "../general/page";
import { InvestmentTable } from "./components/investmentTable";

export interface IPortfolioProps {}

export const Portfolio: React.FC<IPortfolioProps> = (
  props: IPortfolioProps
) => {
  return (
    <Page pageId="portfolio-wrapper">
      <Row className="game-data">
        <Col lg={6}>
          <Card className="card-details">
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
          <Card className="card-details">
            <Card.Header>
              <Card.Title className="portfolio-header-title">
                <i className="fa fa-tachometer-alt"></i>Gameflow:
              </Card.Title>
            </Card.Header>
            <Card.Body>
              <PortfolioDetail heading="Leader Value">$150,200</PortfolioDetail>
              <PortfolioDetail heading="Total Money in play">
                $820,350
              </PortfolioDetail>
              <PortfolioDetail heading="Total Transactions">
                254
              </PortfolioDetail>
              <PortfolioDetail heading="Current Round">
                Round of 32
              </PortfolioDetail>
              <PortfolioDetail heading="Total Games left">34</PortfolioDetail>
            </Card.Body>
          </Card>
        </Col>
      </Row>
      <Row>
        <Col xl={8}>
          <Card className="portfolio-investments">
            <Card.Header>
              <Card.Title className="portfolio-header-title">
                <i className="fa fa-money-bill-alt"></i>My Investments <br />
                ($42,600)
              </Card.Title>
            </Card.Header>
            <InvestmentTable />
          </Card>
        </Col>
        <Col xl={4}>
          <Card className="portfolioLinks">
            <Card.Body>
              <Link to={"/market"}>Market</Link>
              <Link to={"/leaderboard"}>Leaderboard</Link>
              <Link to={"/rules"}>Rules</Link>
            </Card.Body>
          </Card>
        </Col>
      </Row>
    </Page>
  );
};
