import React from "react";
import { Row, Col, Card } from "react-bootstrap";
import { TeamCard } from "./teamcard";
import { IMatchup } from "../../../models/matchup";
import classNames from "classnames";

export interface IMatchupProps {
  matchup: IMatchup;
}

export const Matchup: React.FC<IMatchupProps> = (props: IMatchupProps) => {
  const matchupTxt =
    props.matchup.team1.teamName + " vs " + props.matchup.team2.teamName;

  return (
    <Row className="match-up">
      <Col>
        <Card className="match-up-card">
          <Card.Header className="match-up-header">
            <Card.Text>
              {matchupTxt}
              <span className="start-time">
                <i className="fas fa-clock" /> {props.matchup.startTime}
              </span>
              <i
                className={classNames(
                  { "fa fa-unlock": !props.matchup.team1.isLocked },
                  { "fa fa-lock": props.matchup.team1.isLocked }
                )}
              />
            </Card.Text>
          </Card.Header>
          <Card.Body className="match-up-body">
            <Row>
              <Col lg={6}>
                <TeamCard team={props.matchup.team1} />
              </Col>
              <Col lg={6}>
                <TeamCard team={props.matchup.team2} />
              </Col>
            </Row>
          </Card.Body>
        </Card>
      </Col>
    </Row>
  );
};
