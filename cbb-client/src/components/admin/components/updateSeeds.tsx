import React, { useState, useEffect } from "react";
import { Card } from "react-bootstrap";
import axios from "axios";
import { ITeam } from "../../../models/team";

export interface IUpdateSeedsProps {}

export const UpdateSeeds: React.FC<IUpdateSeedsProps> = (
  props: IUpdateSeedsProps
) => {
  const [allTeams, setAllTeams] = useState<ITeam[]>();

  useEffect(() => {
    axios
      .get("/api/admin/all-teams")
      .then(response => {
        setAllTeams(response.data);
      })
      .catch(error => {
        console.log(error);
      });
  }, []);

  return (
    <Card>
      <Card.Header>
        <h2>Update Seeds</h2>
      </Card.Header>
      <Card.Body>{allTeams?.length}</Card.Body>
    </Card>
  );
};
