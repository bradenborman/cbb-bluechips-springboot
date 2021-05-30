import React from "react";
import { Card } from "react-bootstrap";

export interface IPointSpreadsProps {}

export const PointSpreads: React.FC<IPointSpreadsProps> = (
  props: IPointSpreadsProps
) => {
  return (
    <Card>
      <Card.Header>
        <h2>Point Spreads</h2>
      </Card.Header>
    </Card>
  );
};
