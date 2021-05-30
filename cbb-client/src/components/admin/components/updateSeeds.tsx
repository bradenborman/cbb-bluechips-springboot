import React from "react";
import { Card } from "react-bootstrap";

export interface IUpdateSeedsProps {}

export const UpdateSeeds: React.FC<IUpdateSeedsProps> = (
  props: IUpdateSeedsProps
) => {
  return (
    <Card>
      <Card.Header>
        <h2>Update Seeds</h2>
      </Card.Header>
    </Card>
  );
};
