import React, { useState, useEffect } from "react";
import classNames from "classnames";
import { ITeam } from "../../../models/team";
import { Col } from "react-bootstrap";
import { useDebouncedCallback } from "use-debounce";

import axios from "axios";

export interface ISetSeedInputProps {
  team: ITeam;
}
export const SetSeedInput: React.FC<ISetSeedInputProps> = (
  props: ISetSeedInputProps
) => {
  const [activeSeed, setActiveSeed] = useState<string>(
    props.team?.seed?.toString()
  );

  const makeUpdateCall = useDebouncedCallback((newSeed: any) => {
    axios
      .post(`/api/admin/update-seed`, {
        teamName: props.team.teamName,
        newSeed: activeSeed
      })
      .then(response => {
        console.log(response);
      })
      .catch(x => {
        console.log(x);
      });
  }, 1500);

  const handleChange = (e: any) => {
    if (!isNaN(e.target.value)) {
      setActiveSeed(e.target.value);
      makeUpdateCall(e.target.value);
    }
  };

  return (
    <Col
      className={classNames({
        set: props.team.seed > 0 || Number(activeSeed) > 0
      })}
      lg={4}
    >
      <input
        className="team-seed-input"
        maxLength={2}
        onChange={handleChange}
        value={activeSeed}
      />
      {props.team.teamName}
    </Col>
  );
};
