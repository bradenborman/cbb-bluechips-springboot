import React from "react";
import { useHistory, useLocation } from "react-router";
import classNames from "classnames";
import { Nav, NavDropdown } from "react-bootstrap";

export interface INavbarProps {
  isLoggedIn: boolean;
  adminPriv: boolean;
}
export const Navbar: React.FC<INavbarProps> = (props: INavbarProps) => {
  let history = useHistory();
  let location: any = useLocation();

  const returnToHome = (e: any) => {
    if (location.pathname !== "/login") history.push("/portfolio");
  };

  const getAdminLink = (): JSX.Element => {
    if (props.adminPriv)
      return (
        <NavDropdown.Item href="/admin">
          <i className="fa fa-user-lock" />
          Admin
        </NavDropdown.Item>
      );
    else return null;
  };

  const getApplicationLinks = () => {
    if (props.isLoggedIn)
      return (
        <Nav className="justify-content-center">
          <Nav.Item>
            <Nav.Link href="/portfolio">Portfolio</Nav.Link>
          </Nav.Item>
          <Nav.Item>
            <Nav.Link href="/market">Market</Nav.Link>
          </Nav.Item>
          <Nav.Item>
            <Nav.Link href="/leaderboard">Leaderboard</Nav.Link>
          </Nav.Item>
          <NavDropdown title="Misc" id="nav-dropdown">
            <NavDropdown.Item href="/rules">
              <i className="fa fa-pencil-alt" />
              How to play
            </NavDropdown.Item>
            <NavDropdown.Item href="/transactions">
              <i className="fa fa-sticky-note" />
              Transactions
            </NavDropdown.Item>
            <NavDropdown.Item href="/calculator">
              <i className="fa fa-calculator" />
              Calculator
            </NavDropdown.Item>
            <NavDropdown.Item href="/groups">
              <i className="fa fa-users" />
              Groups
            </NavDropdown.Item>
            <NavDropdown.Divider />
            <NavDropdown.Item href="/settings">
              <i className="fa fa-user-cog" />
              Settings
            </NavDropdown.Item>
            {getAdminLink()}
            <NavDropdown.Divider />
            <NavDropdown.Item href="/user/logout">
              <i className="fa fa-sign-out-alt" />
              Logout
            </NavDropdown.Item>
          </NavDropdown>
        </Nav>
      );
  };

  return (
    <div id="header-wrapper">
      <header
        className={classNames("header", { "pad-bottom": !props.isLoggedIn })}
      >
        <h1 onClick={returnToHome}>CBB Bluechips</h1>
      </header>
      {getApplicationLinks()}
    </div>
  );
};
