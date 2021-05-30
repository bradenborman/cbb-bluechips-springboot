import React from "react";
import { Card, ToggleButton } from "react-bootstrap";

export interface IGameSettingsProps {}

export const GameSettings: React.FC<IGameSettingsProps> = (
  props: IGameSettingsProps
) => {
  return (
    <Card id="game-settings-wrapper">
      <Card.Header>
        <h2>Game Settings</h2>
      </Card.Header>
      <Card.Body>
        <form id="current-round-form">
          <label>Current Round</label>
          <div id="current-round-radio-wrapper">
            <span>
              <input type="radio" name="cr" value="64" checked required />
              64
            </span>
            <span>
              <input type="radio" name="cr" value="32" />
              32
            </span>
            <span>
              <input type="radio" name="cr" value="16" />
              16
            </span>
            <span>
              <input type="radio" name="cr" value="8" />8
            </span>
            <span>
              <input type="radio" name="cr" value="4" />4
            </span>
            <span>
              <input type="radio" name="cr" value="2" />2
            </span>
            <span>
              <input type="radio" name="cr" value="1" />1
            </span>
          </div>
          <button type="submit">Submit</button>
        </form>

        <form id="sign-up-allowed-form">
          <input type="checkbox" checked />
          <label>Sign Up Allowed</label>
          <button type="submit">Submit</button>
        </form>

        <form id="delete-players-form">
          <button type="submit">Delete all players..</button>
        </form>
        <form id="reset-game-form">
          <button type="submit">Reset Game..</button>
        </form>
      </Card.Body>
    </Card>
  );
};
