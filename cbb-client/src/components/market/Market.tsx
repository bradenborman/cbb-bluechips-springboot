import React from "react";
import { Link } from "react-router-dom";
import { Matchup } from "./components/matchup";
import { matchup1, matchup2 } from "../../data/test-data";
import { Page } from "../general/page";

export interface IMarketProps {}

export const Market: React.FC<IMarketProps> = (props: IMarketProps) => {
  return (
    <Page pageId="market-wrapper">
      <Matchup matchup={matchup1} />
      <Matchup matchup={matchup2} />
    </Page>
  );
};
