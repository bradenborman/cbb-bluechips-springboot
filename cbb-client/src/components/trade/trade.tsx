import React from "react";
import { useParams } from "react-router";
import { Row, Col, Card } from "react-bootstrap";
import { Link } from "react-router-dom";
import { Page } from "../general/page";
import { ITeam } from "../../models/team";
import { team1 } from "../../data/test-data";
import { TransactionSlider } from "./components/transactionSlider";
export interface ITradeProps {}
export const Trade: React.FC<ITradeProps> = (props: ITradeProps) => {
  let { teamId } = useParams();

  const team: ITeam = team1;

  //TODO: show capital available
  //TODO: show team data: name, current price, point spread
  //TODO: show text on screen that says what team would have to win buy to make any money if favored or would have to not lose by if underdog
  //TODO: show countdown timer to when team locks
  //TODO: option to place order in as team is locked: (go ahead and purcahse, but override insert timestamp to start of game so it doesnt appear until game starts -> change transactions to only show current time and before)

  return (
    <Page pageId="trade-wrapper">
      <Row>
        <Col lg={12}>
          <Card>
            <Card.Header>
              <Card.Body>
                <Row>
                  <Col sm={12} md={6} lg={4}>
                    <TransactionSlider buy max={10} />
                  </Col>
                  <Col sm={12} md={6} lg={4}>
                    <TransactionSlider sell max={5} />
                  </Col>
                  <Col md={12} lg={4}>
                    <div id="top-holders" className="text-center">
                      <h3>Top Shareholders:</h3>
                      <div>M. Atkinson: 40</div>
                      <div>K. Borman: 23</div>
                      <div>Z. Lavy: 22</div>
                    </div>
                  </Col>
                </Row>
              </Card.Body>
            </Card.Header>
          </Card>
        </Col>
      </Row>
    </Page>
  );
};
