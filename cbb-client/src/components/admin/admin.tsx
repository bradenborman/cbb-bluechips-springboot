import React from "react";
import { Page } from "../general/page";
import { Row, Col, Card, Nav, Button, Tab, ListGroup } from "react-bootstrap";

export interface IAdminProps {}

export const Admin: React.FC<IAdminProps> = (props: IAdminProps) => {
  return (
    <Page pageId="admin-wrapper">
      <Tab.Container id="list-group-tabs-example" defaultActiveKey="#link1">
        <Row>
          <Col sm={3}>
            <ListGroup>
              <ListGroup.Item action href="#link1">
                Game Settings
              </ListGroup.Item>
              <ListGroup.Item action href="#link2">
                Update Seeds
              </ListGroup.Item>
              <ListGroup.Item action href="#link3">
                Set Point Spreads
              </ListGroup.Item>
              <ListGroup.Item action href="#link4">
                Define Matchups
              </ListGroup.Item>
              <ListGroup.Item action href="#link5">
                User Settings
              </ListGroup.Item>
            </ListGroup>
          </Col>
          <Col sm={4}>
            <Tab.Content>
              <Tab.Pane eventKey="#link1">
                <Card>
                  <Card.Header>
                    <h2>Game Settings</h2>
                  </Card.Header>
                  <ul>
                    <li>Set current round</li>
                    <li>Sign up toggle</li>
                    <li>Reset Game</li>
                    <li>Delete Players</li>
                  </ul>
                </Card>
              </Tab.Pane>
              <Tab.Pane eventKey="#link2">
                <h2>Update Seeds</h2>
              </Tab.Pane>
              <Tab.Pane eventKey="#link3">
                <h2>Set Point Spreads</h2>
              </Tab.Pane>
              <Tab.Pane eventKey="#link4">
                <h2>Define Matchups</h2>
              </Tab.Pane>
              <Tab.Pane eventKey="#link5">
                <h2>User Settings</h2>
                <ul>
                  <li>Edit User</li>
                  <li>Delete User</li>
                </ul>
              </Tab.Pane>
            </Tab.Content>
          </Col>
        </Row>
      </Tab.Container>
    </Page>
  );
};
