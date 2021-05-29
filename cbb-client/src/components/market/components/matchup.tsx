import React, { useState, useEffect } from "react";
import { Row, Col, Card } from "react-bootstrap";
import { TeamCard } from "./teamcard";
import { IMatchup } from "../../../models/matchup";
import classNames from "classnames";

import moment from "moment";

export interface IMatchupProps {
  matchup: IMatchup;
}

export const Matchup: React.FC<IMatchupProps> = (props: IMatchupProps) => {
  const [collapsed, setCollapsed] = useState<boolean>(true);
  const [countdownUntilLock, setCountdownUntilLock] = useState<string>(
    props.matchup.startTime
  );

  const startTimeParsed = moment(props.matchup.startTime, ["h:mm a"]);

  useEffect(() => {
    var interval = setInterval(() => {
      const rightNow = moment();
      if (
        startTimeParsed.diff(rightNow, "minutes") <= 15 &&
        rightNow.isBefore(startTimeParsed)
      ) {
        //GAME STARTS IN 15 mins or less
        let totalSeconds: number = startTimeParsed.diff(
          rightNow,
          "seconds",
          true
        );
        const mins = Math.floor(totalSeconds / 60);
        totalSeconds = Math.floor(totalSeconds - mins * 60);
        setCountdownUntilLock(
          mins + ":" + (totalSeconds < 10 ? "0" : "") + totalSeconds.toString()
        );
      } else if (rightNow.isAfter(startTimeParsed)) {
        setCountdownUntilLock("Game in progess");
        clearInterval(interval);
      }
    }, 1000);
  }, []);

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

  const getClockIcon = (): JSX.Element => {
    if (props.matchup.startTime == countdownUntilLock)
      return (
        <span className="start-time">
          <i className="fas fa-clock" /> {countdownUntilLock}
        </span>
      );
    else
      return (
        <span className="start-time">Starts in: {countdownUntilLock}</span>
      );
  };

  return (
    <Row className="match-up">
      <Col>
        <Card className="match-up-card">
          <Card.Header className="match-up-header">
            {matchupPreview()}
            {getClockIcon()}
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
