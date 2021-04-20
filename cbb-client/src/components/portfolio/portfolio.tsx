import React from "react";
import { Row, Col, Card, Table } from "react-bootstrap";
import { Link } from "react-router-dom";
import { PortfolioDetail } from "./components/portfolioDetail";
import { Page } from "../general/page";
import { InvestmentTable } from "./components/investmentTable";
import { Investment } from "./components/investment";
import { portfilioTip1, portfilioTip2 } from "../../data/staticMessages";

export interface IPortfolioProps {}

export const Portfolio: React.FC<IPortfolioProps> = (
  props: IPortfolioProps
) => {
  //TODO: cleanup first info card make sleeker
  //TODO: display upcoming games in card

  const investments = [<Investment />, <Investment />];

  const investmentCardBody = (): JSX.Element => {
    if (investments == null) {
      return (
        <Card.Body id="emptyPortfolioTips">
          <Card.Text id="main">
            Please visit the <Link to={"/market"}>Market</Link> to fill
            portfolio.
          </Card.Text>
          <Card.Text className="secondary">
            <b>
              <u>Tip:</u>
            </b>{" "}
            {portfilioTip1}
          </Card.Text>
          <Card.Text className="secondary">{portfilioTip2}</Card.Text>
        </Card.Body>
      );
    }
    return <InvestmentTable>{investments}</InvestmentTable>;
  };

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
              <Row noGutters={true}>
                <Col>
                  <PortfolioDetail heading="Networth">$100,000</PortfolioDetail>
                  <PortfolioDetail heading="Capital">$100,000</PortfolioDetail>
                  <PortfolioDetail heading="Ranking">12</PortfolioDetail>
                  <PortfolioDetail heading="Leader Value">
                    $150,200
                  </PortfolioDetail>
                </Col>
                <Col>
                  <PortfolioDetail heading="Total Money in play">
                    $820,350
                  </PortfolioDetail>
                  <PortfolioDetail heading="Total Transactions">
                    254
                  </PortfolioDetail>
                  <PortfolioDetail heading="Current Round">
                    Round of 32
                  </PortfolioDetail>
                  <PortfolioDetail heading="Total Games left">
                    34
                  </PortfolioDetail>
                </Col>
              </Row>
            </Card.Body>
          </Card>
        </Col>
        <Col lg={6}>
          <Card className="card-details">
            <Card.Header>
              <Card.Title className="portfolio-header-title">
                <i className="fa fa-clock"></i>Upcoming Games
              </Card.Title>
            </Card.Header>
            <Card.Body></Card.Body>
          </Card>
        </Col>
      </Row>
      <Row>
        <Col xl={8}>
          <Card className="portfolio-investments">
            <Card.Header>
              <Card.Title className="portfolio-header-title">
                <i className="fa fa-money-bill-alt"></i>My Investments
                <span id="investmentTotalAmt">($42,600)</span>
              </Card.Title>
            </Card.Header>
            {investmentCardBody()}
          </Card>
        </Col>
        <Col xl={4}>
          <Card className="portfolioLinks">
            <Card.Body>
              <Link to={"/market"}>Market</Link>
              <Link to={"/transactions"}>Transactions</Link>
              <Link to={"/leaderboard"}>Leaderboard</Link>
              <Link to={"/groups"}>Groups</Link>
              <Link to={"/rules"}>How to Play</Link>
              <Link to={"/calculator"}>Calculator</Link>
              <Link to={"/settings"}>Settings</Link>
              <Link to={"/user/logout"}>Logout</Link>
            </Card.Body>
          </Card>
        </Col>
      </Row>
    </Page>
  );
};
