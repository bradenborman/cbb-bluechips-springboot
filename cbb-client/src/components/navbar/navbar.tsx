import React from "react";

export interface INavbarProps {}
export const Navbar: React.FC<INavbarProps> = (props: INavbarProps) => {
  return (
    <header className="header">
      <div id="logo"></div>
      <h1>College Basketball's Bluechips</h1>
    </header>
  );
};
