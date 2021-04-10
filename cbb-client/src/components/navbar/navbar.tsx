import React from "react";
import { useHistory } from "react-router";

export interface INavbarProps {}
export const Navbar: React.FC<INavbarProps> = (props: INavbarProps) => {
  let history = useHistory();

  const returnToHome = (e: any) => {
    history.push("/portfolio");
  };

  return (
    <header className="header">
      <h1 onClick={returnToHome}>College Basketball's Bluechips</h1>
    </header>
  );
};
