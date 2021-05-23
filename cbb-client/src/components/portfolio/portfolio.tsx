import React, { useEffect, useState } from "react";
import { Row, Col, Card } from "react-bootstrap";
import { Link } from "react-router-dom";
import { PortfolioDetail } from "./components/portfolioDetail";
import { Page } from "../general/page";
import { InvestmentTable } from "./components/investmentTable";
import { Investment } from "./components/investment";
import { portfilioTip1, portfilioTip2 } from "../../data/staticMessages";
import { IInvestment } from "../../models/investment";
import axios from "axios";
import { IGamedata } from "../../models/gameData";
import { IUserGamedata } from "../../models/userGameData";

export interface IPortfolioProps {}

export const Portfolio: React.FC<IPortfolioProps> = (
  props: IPortfolioProps
) => {
  //TODO: cleanup first info card make sleeker
  //TODO: display upcoming games in card

  const [userInvestments, setUserInvestments] = useState<IInvestment[]>();
  const [gameData, setGameData] = useState<IGamedata>();
  const [userGameData, setUserGameGata] = useState<IUserGamedata>();

  useEffect(() => {
    axios
      .get("/api/user-investments")
      .then(response => {
        setUserInvestments(response.data);
      })
      .catch(error => {
        console.log(error);
      });
  }, []);

  useEffect(() => {
    axios
      .get("/api/cbb-game-data")
      .then(response => {
        setGameData(response.data);
      })
      .catch(error => {
        console.log(error);
      });
  }, []);

  useEffect(() => {
    axios
      .get("/api/user-game-data")
      .then(response => {
        console.log(response.data);
        setUserGameGata(response.data);
      })
      .catch(error => {
        console.log(error);
      });
  }, []);

  const investments =
    userInvestments != null
      ? userInvestments.map((investment, index) => {
          return <Investment key={index} investment={investment} />;
        })
      : null;

  const grandTotalUserInvested: number =
    userInvestments != null
      ? userInvestments.reduce(
          (total, inv) => (total = total + inv.marketPrice),
          0
        )
      : 0;

  const investmentCardBody = (): JSX.Element => {
    if (userInvestments == null) {
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

  const getUserGameDataItems = (): JSX.Element => {
    if (userGameData != null || userGameData != undefined) {
      return (
        <div>
          <PortfolioDetail heading="Networth">
            ${userGameData?.netWorth?.toLocaleString()}
          </PortfolioDetail>
          <PortfolioDetail heading="Capital">
            ${userGameData?.cash?.toLocaleString()}
          </PortfolioDetail>
          <PortfolioDetail heading="My leaderboard Pos">
            {userGameData?.leaderboardPosition}
          </PortfolioDetail>
          <PortfolioDetail heading="Transactions made">
            {userGameData?.userTransactionCount?.toLocaleString()}
          </PortfolioDetail>
          <PortfolioDetail heading="Leader Value">
            {userGameData?.userTransactionCount?.toLocaleString()}
          </PortfolioDetail>
        </div>
      );
    }

    return (
      <div>
        <p>Loading..</p>
      </div>
    );
  };

  const getGameDataItems = (): JSX.Element => {
    if (gameData != null) {
      return (
        <div>
          <PortfolioDetail heading="Total Money in play">
            {gameData.totalMoneyInPlay.toLocaleString()}
          </PortfolioDetail>
          <PortfolioDetail heading="Total Transactions">
            {gameData.totalTransactionsCount}
          </PortfolioDetail>
          <PortfolioDetail heading="Current Round">
            {" "}
            Round of {gameData.currentRound}
          </PortfolioDetail>
          <PortfolioDetail heading="Total Games left">
            {gameData.gamesLeft}
          </PortfolioDetail>
        </div>
      );
    }

    return (
      <div>
        <p>Loading..</p>
      </div>
    );
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
                <Col>{getUserGameDataItems()}</Col>
                <Col>{getGameDataItems()}</Col>
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
                <span id="investmentTotalAmt">
                  (${grandTotalUserInvested.toLocaleString()})
                </span>
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
              <a href="/user/logout" className="label">
                Logout
              </a>
            </Card.Body>
          </Card>
        </Col>
      </Row>
    </Page>
  );
};
