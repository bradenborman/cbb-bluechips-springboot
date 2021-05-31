import React, { useEffect, useState } from "react";
import { Card, Row } from "react-bootstrap";
import axios from "axios";
import { ITeam } from "../../../models/team";
import Loader from "react-loader-spinner";
import { SetPointSpreadInput } from "../components/setPointSpreadInput";

export interface IPointSpreadsProps {}

export const PointSpreads: React.FC<IPointSpreadsProps> = (
  props: IPointSpreadsProps
) => {
  const [allTeamsData, setAllTeamsData] = useState<ITeam[]>();

  useEffect(() => {
    axios
      .get(`/api/admin/teams-playing-today`)
      .then(response => {
        console.log(response);
        setAllTeamsData(response.data);
      })
      .catch(error => {
        console.log(error);
      });
  }, []);

  const teamContainer = (): JSX.Element => {
    if (allTeamsData == null || allTeamsData == undefined)
      return (
        <div className="loading-wrapper">
          <Loader type="TailSpin" color="#00BFFF" height={100} width={100} />
        </div>
      );
    else {
      const inputs = allTeamsData.map((team, index) => {
        return <SetPointSpreadInput key={index} team={team} />;
      });

      return (
        <Row>
          {inputs.length > 0 ? (
            inputs
          ) : (
            <p className="non-playing-message">No teams playing today</p>
          )}
        </Row>
      );
    }
  };

  return (
    <Card id="set-point-spread-wrapper">
      <Card.Header>
        <h2>Point Spreads</h2>
      </Card.Header>
      <Card.Body>{teamContainer()}</Card.Body>
    </Card>
  );
};
