import React from "react";
import { Container } from "react-bootstrap";
import { Matchup } from "./components/matchup";
import { ITeam } from "../../models/team";
import { IMatchup } from "../../models/matchup";

export interface IMarketProps {}

export const Market: React.FC<IMarketProps> = (props: IMarketProps) => {
  const team1: ITeam = {
    teamId: 1,
    teamName: "Duke",
    seed: 45,
    sharesOutstanding: 36,
    imgSrcName: "Duke.png",
    marketPrice: 5000,
    isLocked: true,
    pointSpread: 7.5,
    teamplayingNextName: "Kentucky"
  };

  const team2: ITeam = {
    teamId: 1,
    teamName: "Kentucky",
    seed: 6,
    sharesOutstanding: 84,
    imgSrcName: "Kentucky.png",
    marketPrice: 5000,
    isLocked: true,
    pointSpread: -7.5,
    teamplayingNextName: "Duke"
  };

  const matchup1: IMatchup = {
    team1,
    team2,
    startTime: "2:30PM"
  };

  const matchup2: IMatchup = {
    team1: {
      teamId: 1,
      teamName: "Alabama",
      seed: 1,
      sharesOutstanding: 64,
      imgSrcName: "Alabama.png",
      marketPrice: 5000,
      isLocked: false,
      pointSpread: 5
    },
    team2: {
      teamId: 1,
      teamName: "Michigan",
      seed: 10,
      sharesOutstanding: 79,
      imgSrcName: "Michigan.png",
      marketPrice: 5000,
      isLocked: false,
      pointSpread: -5
    },
    startTime: "5:30PM"
  };

  return (
    <div id="market-wrapper">
      <Container>
        <Matchup matchup={matchup1} />
        <Matchup matchup={matchup2} />
      </Container>
    </div>
  );
};
