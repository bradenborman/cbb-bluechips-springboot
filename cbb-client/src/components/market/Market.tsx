import React from "react";
import { Container } from "react-bootstrap";
import { Link } from "react-router-dom";
import { Matchup } from "./components/matchup";
import { matchup1, matchup2 } from "../../data/test-data";

export interface IMarketProps {}

export const Market: React.FC<IMarketProps> = (props: IMarketProps) => {
  return (
    <div id="market-wrapper">
      <Container>
        <nav>
          <Link to="/portfolio">Portfolio</Link>
        </nav>
        <Matchup matchup={matchup1} />
        <Matchup matchup={matchup2} />
      </Container>
    </div>
  );
};
