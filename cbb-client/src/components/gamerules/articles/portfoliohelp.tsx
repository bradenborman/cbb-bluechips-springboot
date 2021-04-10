import React from "react";
import { Row, Col } from "react-bootstrap";

export interface IPortfolioHelpProps {}
export const PortfolioHelp: React.FC<IPortfolioHelpProps> = (
  props: IPortfolioHelpProps
) => {
  return (
    <Row id="portfolioHelp">
      <Col md={6}>
        <div className="how-img">
          <img
            data-aos-delay="300"
            data-aos="fade-right"
            aos-duration="1000"
            alt="Investments"
            id="investments_exampleImg"
            className="img-fluid"
            src="img/how_to_imgs/investments_example.png"
          />
        </div>
      </Col>
      <Col md={6}>
        <h4>Your Portfolio</h4>
        <p className="text-muted">
          Your portfolio is easy to manage, and it is fun to watch your
          investments grow with each game! While on the portfolio page, you can
          see a list of all the teams you are currently vested in. You’ll see
          the number of shares of each team you own, the current market price of
          each team’s share, and the total amount of money you have invested in
          each of your teams.
        </p>
      </Col>
    </Row>
  );
};
