import React from "react";
import { Row, Col } from "react-bootstrap";
import { useHistory } from "react-router";

export interface IIntroHelpProps {
  signedIn: boolean;
}
export const IntroHelp: React.FC<IIntroHelpProps> = (
  props: IIntroHelpProps
) => {
  let history = useHistory();

  const handlePointSpreadCalcLinkClick = (e: any) => {
    history.push("/calculator");
  };
  const handlPortfolioLinkClick = (e: any) => {
    history.push("/portfolio");
  };

  const getActionButtons = (): JSX.Element => {
    if (props.signedIn)
      return (
        <div>
          <button
            type="button"
            onClick={handlPortfolioLinkClick}
            className="btn btn-outline-primary btn-lg"
          >
            Back to Portfolio
          </button>
          <button
            type="button"
            onClick={handlePointSpreadCalcLinkClick}
            className="btn btn-outline-primary btn-lg"
          >
            Point-spread Calculator
          </button>
        </div>
      );

    return (
      <button
        type="button"
        onClick={e => alert()}
        className="btn btn-outline-primary btn-lg"
      >
        Sign Up
      </button>
    );
  };

  return (
    <Row id="introHelp">
      <Col md={4}>
        <div className="how-img">
          <img
            id="bustedImg"
            className="rounded-circle img-fluid"
            src="img/how_to_imgs/busted.jpg"
            alt="Busted Bracket Img"
          />
        </div>
      </Col>
      <Col md={8}>
        <h4>Wave goodbye</h4>
        <h4 className="subheading">to busted brackets</h4>
        <p className="text-muted">
          Welcome to{" "}
          <span className="theme-font">College Basketball Bluechips</span>,
          March Madness’s newest game. College Basketball Bluechips combines our
          favorite part of March Madness (PICKING THE WINNERS!!!) with the art
          of day trading! Show off your ability to pick winners, and back it up
          with a savvy investment strategy. The best part, even if you pick a
          loser, you can still cash out and make your money back, your bracket
          is never busted here!
        </p>
        <div className="text-center">
          College Basketball Bluechips is completely free to play.
          <br />
          The top 10 Investors at the end of the tournament will split $500 in
          cash and prizes!**
          <br />
          Sign up below, and learn the rules of the game now!
        </div>
        <div id="action-button-wrapper">{getActionButtons()}</div>
      </Col>
    </Row>
  );
};
