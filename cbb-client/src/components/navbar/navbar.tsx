import React from "react";
import { useHistory, useLocation } from "react-router";

export interface INavbarProps {}
export const Navbar: React.FC<INavbarProps> = (props: INavbarProps) => {
  let history = useHistory();
  let location: any = useLocation();

  // Might use prop of isLoggedIn vs this because of rule page too being both log in and not

  const returnToHome = (e: any) => {
    if (location.pathname !== "/login") history.push("/portfolio");
  };

  return (
    <header className="header">
      <h1 onClick={returnToHome}>College Basketball's Bluechips</h1>
    </header>
  );
};
