import React from "react";
import { Card } from "react-bootstrap";

export interface IUserSettingsProps {}

export const UserSettings: React.FC<IUserSettingsProps> = (
  props: IUserSettingsProps
) => {
  return (
    <Card>
      <Card.Header>
        <h2>User Settings</h2>
      </Card.Header>
      <ul>
        <li>Edit User</li>
        <li>Delete User</li>
      </ul>
    </Card>
  );
};
