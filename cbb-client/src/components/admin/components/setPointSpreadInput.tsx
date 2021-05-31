import React, { useState, useEffect } from "react";
import classNames from "classnames";
import { ITeam } from "../../../models/team";
import { Col } from "react-bootstrap";
import { useDebouncedCallback } from "use-debounce";

import axios from "axios";

export interface ISetPointSpreadInputProps {
  team: ITeam;
}
export const SetPointSpreadInput: React.FC<ISetPointSpreadInputProps> = (
  props: ISetPointSpreadInputProps
) => {
  const [activePointSpread, setActivePointSpread] = useState<string>(
    props.team?.pointSpread?.toString()
  );

  const makeUpdateCall = useDebouncedCallback((newSeed: any) => {
    alert(
      "would make call for team: " +
        props.team.teamName +
        " for point spread of " +
        activePointSpread
    );
    // axios
    //     .post(`/api/admin/update-seed`, {
    //         teamName: props.team.teamName,
    //         newSeed: activeSeed
    //     })
    //     .then(response => {
    //         console.log(response);
    //     })
    //     .catch(x => {
    //         console.log(x);
    //     });
  }, 1500);

  const handleChange = (e: any) => {
    setActivePointSpread(e.target.value);
    makeUpdateCall(e.target.value);
  };

  return (
    <Col lg={4}>
      <input
        className="team-point-spread-input"
        maxLength={2}
        type="number"
        step={0.5}
        onChange={handleChange}
        value={activePointSpread}
      />
      {props.team.teamName}
    </Col>
  );
};
