import React from "react";
import { Row, Col } from "react-bootstrap";

export interface IMarketHelpProps {}
export const MarketHelp: React.FC<IMarketHelpProps> = (
  props: IMarketHelpProps
) => {
  return (
    <Row id="marketHelp">
      <Col md={6}>
        <h4>The Market</h4>
        <h4 className="subheading">
          Where <span>winners</span> identify the <span>winners</span>
        </h4>
        <p className="text-muted">
          The Market is where you will find the team cards for all of the{" "}
          <span>NCAA</span> College Basketball Tournament Teams. This Market
          gives Investors access to inside information to aid in their decisions
          on buying and selling team stocks. Each Team Card has the following
          information:
        </p>
        <ul>
          <li>Team Name</li>
          <li>Current Market price</li>
          <li>Chart of price history</li>
          <li>Trade Button</li>
          <li>Ranking in the Tournament</li>
          <li>Shares Outstanding</li>
        </ul>
        <p className="text-muted">
          If a team has a game scheduled, it will also have a gray bar of
          additional information with the following:
        </p>
        <ul>
          <li>Point Spread for that game</li>
          <li>Next Opponent</li>
        </ul>
      </Col>
      <Col md={6}>
        <div className="how-img">
          <img
            data-aos-delay="300"
            data-aos="fade-left"
            aos-duration="1000"
            className="img-fluid"
            id="markets_exampleImg"
            alt="Market Example"
            src="img/how_to_imgs/MarketExample.png"
          />
        </div>
      </Col>
    </Row>
  );
};
