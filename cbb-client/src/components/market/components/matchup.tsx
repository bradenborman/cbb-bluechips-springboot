import React, { useState } from "react";
import { Row, Col, Card } from "react-bootstrap";
import { TeamCard } from "./teamcard";
import { IMatchup } from "../../../models/matchup";
import classNames from "classnames";

export interface IMatchupProps {
  matchup: IMatchup;
}

export const Matchup: React.FC<IMatchupProps> = (props: IMatchupProps) => {
  const [collapsed, setCollapsed] = useState<boolean>(true);

  const matchupPreview = (): JSX.Element => {
    return (
      <div className="team-name-matchup-wrapper">
        <div className="team-name-with-img">
          <img
            className="team-icon"
            src={"/img/teams/" + props.matchup.team1.imgSrcName}
            loading="lazy"
          />
          {props.matchup.team1.teamName}
        </div>
        <div className="vs">vs</div>
        <div className="team-name-with-img">
          {props.matchup.team2.teamName}
          <img
            className="team-icon"
            src={"/img/teams/" + props.matchup.team2.imgSrcName}
            loading="lazy"
          />
        </div>
      </div>
    );
  };

  return (
    <Row className="match-up">
      <Col>
        <Card className="match-up-card">
          <Card.Header className="match-up-header">
            <Card.Text>
              {matchupPreview()}
              <span className="start-time">
                <i className="fas fa-clock" /> {props.matchup.startTime}
              </span>
              {/* <i
                className={classNames(
                  { "fa fa-unlock": !props.matchup.team1.isLocked },
                  { "fa fa-lock": props.matchup.team1.isLocked }
                )}
              /> */}
            </Card.Text>
          </Card.Header>
          <Card.Body
            className={classNames("match-up-body", { collapsed: collapsed })}
          >
            <Row>
              <Col lg={6}>
                <TeamCard team={props.matchup.team1} />
              </Col>
              <Col lg={6}>
                <TeamCard team={props.matchup.team2} />
              </Col>
            </Row>
          </Card.Body>
          <div
            onClick={e => setCollapsed(!collapsed)}
            className="match-up-expander-wrapper"
          >
            <i
              className={classNames("fa fa-caret-down", {
                collapsed: collapsed
              })}
            />
          </div>
        </Card>
      </Col>
    </Row>
  );
};
