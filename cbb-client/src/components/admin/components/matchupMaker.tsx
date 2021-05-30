import React from "react";
import { Card } from "react-bootstrap";

export interface IMatchupMakerProps {}

export const MatchupMaker: React.FC<IMatchupMakerProps> = (
  props: IMatchupMakerProps
) => {
  return (
    <Card>
      <Card.Header>
        <h2>Matchups</h2>
      </Card.Header>
    </Card>
  );
};
