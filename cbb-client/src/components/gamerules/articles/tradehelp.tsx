import React from "react";
import { Row, Col } from "react-bootstrap";

export interface ITradeHelpProps {}
export const TradeHelp: React.FC<ITradeHelpProps> = (
  props: ITradeHelpProps
) => {
  return (
    <Row id="tradeHelp">
      <Col md={7}>
        <div className="how-img">
          <img
            data-aos-delay="300"
            data-aos="fade-right"
            aos-duration="1000"
            className="img-fluid"
            id="trading_exampleImg"
            alt="Trading Example"
            src="img/how_to_imgs/Trading_Example.png"
          />
        </div>
      </Col>
      <Col md={5}>
        <h4>Buying & Selling</h4>
        <p className="text-muted">
          When you’re ready to make an investment, or to cash-in on your stocks,
          click the "Trade" button on your team’s card and you will be taken to
          the Trading Screen. Here you’ll see basic team info as well as two
          sliders. Buying and selling is simple; slide the bar to increase and
          decrease the amount of each team’s stock that you want to buy or sell.
        </p>
      </Col>
    </Row>
  );
};
