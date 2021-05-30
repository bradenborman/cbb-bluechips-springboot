import React from "react";
import { Page } from "../general/page";
import { Row, Col, Tab, ListGroup } from "react-bootstrap";
import { GameSettings } from "./components/gameSettings";
// import { UpdateSeeds } from "./components/UpdateSeeds";
import { PointSpreads } from "./components/pointSpreads";
import { MatchupMaker } from "./components/matchupMaker";
import { UserSettings } from "./components/userSettings";

export interface IAdminProps {}

export const Admin: React.FC<IAdminProps> = (props: IAdminProps) => {
  return (
    <Page pageId="admin-wrapper">
      <Tab.Container id="admin-menu" defaultActiveKey="#game-settings">
        <Row>
          <Col lg={3}>
            <ListGroup>
              <ListGroup.Item action href="#game-settings">
                Game Settings
              </ListGroup.Item>
              <ListGroup.Item action href="#update-seeds">
                Update Seeds
              </ListGroup.Item>
              <ListGroup.Item action href="#set-point-spreads">
                Set Point Spreads
              </ListGroup.Item>
              <ListGroup.Item action href="#matchups">
                Define Matchups
              </ListGroup.Item>
              <ListGroup.Item action href="#link5">
                User Settings
              </ListGroup.Item>
            </ListGroup>
          </Col>
          <Col lg={9}>
            <Tab.Content>
              <Tab.Pane eventKey="#game-settings">
                <GameSettings />
              </Tab.Pane>
              <Tab.Pane eventKey="#update-seeds">
                <h2>TEST</h2>
              </Tab.Pane>
              <Tab.Pane eventKey="#set-point-spreads">
                <PointSpreads />
              </Tab.Pane>
              <Tab.Pane eventKey="#matchups">
                <MatchupMaker />
              </Tab.Pane>
              <Tab.Pane eventKey="#link5">
                <UserSettings />
              </Tab.Pane>
            </Tab.Content>
          </Col>
        </Row>
      </Tab.Container>
    </Page>
  );
};
