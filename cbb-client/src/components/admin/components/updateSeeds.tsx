import React, { useEffect, useState } from "react";
import { Card } from "react-bootstrap";

import axios from "axios";
import { ITeam } from "../../../models/team";

export interface IUpdateSeedsProps {}

export const UpdateSeeds: React.FC<IUpdateSeedsProps> = (
  props: IUpdateSeedsProps
) => {
  const [allTeamsData, setAllTeamsData] = useState<ITeam[]>();

  useEffect(() => {
    axios
      .get("/api/admin/all-teams")
      .then(response => {
        console.log(response);
        setAllTeamsData(response.data);
      })
      .catch(error => {
        console.log(error);
      });
  }, []);

  const seedInput = (team: ITeam): JSX.Element => {
    return (
      <div>
        {team.teamName}
        <input className="team-seed-input" value={team.seed} />
      </div>
    );
  };

  const getInputs = (): JSX.Element | null => {
    if (allTeamsData != null) return <div>{seedInput(allTeamsData[0])}</div>;
    return null;
  };

  return (
    <Card id="seed-settings-wrapper">
      <Card.Header>
        <h2>Update Seeds</h2>
      </Card.Header>
      <Card.Body>{getInputs()}</Card.Body>
    </Card>
  );
};
