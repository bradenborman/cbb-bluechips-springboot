import React from "react";
import { Row, Col } from "react-bootstrap";
import { useHistory } from "react-router";

export interface ILetsPlayProps {}
export const LetsPlay: React.FC<ILetsPlayProps> = (props: ILetsPlayProps) => {
  let history = useHistory();

  const handlPortfolioLinkClick = (e: any) => {
    history.push("/portfolio");
  };

  return (
    <Row>
      <Col md={12}>
        <h4>Let’s Play!!!</h4>
        <p className="text-muted">
          In order to have your One Shining Moment, you need to do homework and
          figure out how each team will perform against the point spread.
          Develop your investment strategy and strap in for the long haul. The
          market will make wild swings, and investors will move in and out of
          the top 10 after almost every game. Do you have what it takes to amass
          the most cash during this year’s tournament??? Sign up below and get
          ready to experience March Madness like you never have before with
          College Basketball Bluechips!
        </p>
        <div>
          <button
            type="button"
            onClick={handlPortfolioLinkClick}
            className="btn btn-outline-primary btn-lg"
          >
            Back to Portfolio
          </button>
        </div>
      </Col>
    </Row>
  );
};
