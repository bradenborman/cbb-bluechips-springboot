import React, { useEffect, useState } from "react";
import { Card, Row } from "react-bootstrap";
import Loader from "react-loader-spinner";

import axios from "axios";
import { ITeam } from "../../../models/team";
import { SetSeedInput } from "../components/setSeedInput";

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

  const getInputs = (): JSX.Element[] | JSX.Element | null => {
    if (allTeamsData == null || allTeamsData == undefined)
      return (
        <div className="loading-wrapper">
          <Loader type="TailSpin" color="#00BFFF" height={100} width={100} />
        </div>
      );
    else
      return allTeamsData.map((team: ITeam, index) => (
        <SetSeedInput key={index} team={team} />
      ));
  };

  return (
    <Card id="seed-settings-wrapper">
      <Card.Header>
        <h2>Update Seeds</h2>
      </Card.Header>
      <Card.Body>
        <Row>{getInputs()}</Row>
      </Card.Body>
    </Card>
  );
};
