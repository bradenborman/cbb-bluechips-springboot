import React from "react";
import { useHistory, useLocation } from "react-router";
import classNames from "classnames";

export interface INavbarProps {}
export const Navbar: React.FC<INavbarProps> = (props: INavbarProps) => {
  let history = useHistory();
  let location: any = useLocation();

  const returnToHome = (e: any) => {
    if (location.pathname !== "/login") history.push("/portfolio");
  };

  return (
    <div id="header-wrapper">
      <header className={classNames("header")}>
        <h1 onClick={returnToHome}>CBB Bluechips</h1>
      </header>
    </div>
  );
};
