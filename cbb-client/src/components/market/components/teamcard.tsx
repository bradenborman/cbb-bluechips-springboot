import React from "react";
import { Container, Row, Col, Card, Button } from "react-bootstrap";
import { ITeam } from "../../../models/team";

export interface ITeamCardProps {
  team: ITeam;
}

export const TeamCard: React.FC<ITeamCardProps> = (props: ITeamCardProps) => {
  const formattedMarketPrice = props.team.marketPrice.toLocaleString();
  const tradeTxt = props.team.isLocked ? (
    <span>
      <i className="fa fa-lock" /> Locked
    </span>
  ) : (
    <Button variant="primary">Trade</Button>
  );
  const pointSpradTxt = props.team.pointSpread;

  return (
    <Card className="team-card">
      <Card.Title className="team-name">
        <img
          className="team-icon"
          src={"/img/teams/" + props.team.imgSrcName}
          loading="lazy"
        />
        {props.team.teamName}
        <Card.Text className="current-market-price">
          ${formattedMarketPrice}
        </Card.Text>
      </Card.Title>
      <Card.Body>
        <Card.Text className="point-spread-bar">
          {"(" + pointSpradTxt + ") " + "vs " + props.team.teamplayingNextName}
        </Card.Text>
        <Card.Text className="price-chart"></Card.Text>
        <Card.Text className="trade-btn">{tradeTxt}</Card.Text>
      </Card.Body>
      <Card.Footer>
        <Card.Text as={"span"} className="seed-info">
          Seed: {props.team.seed}
        </Card.Text>
        <Card.Text as={"span"} className="shares-outstanding">
          Shares OutStanding: {props.team.sharesOutstanding}
        </Card.Text>
      </Card.Footer>
    </Card>
  );
};
