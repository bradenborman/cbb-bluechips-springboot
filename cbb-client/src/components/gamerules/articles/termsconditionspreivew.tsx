import React from "react";
import { Row, Col } from "react-bootstrap";
import { Link } from "react-router-dom";

export interface ITermsConditionsPreivewProps {}
export const TermsConditionsPreivew: React.FC<ITermsConditionsPreivewProps> = (
  props: ITermsConditionsPreivewProps
) => {
  return (
    <Row>
      <Col md={12} className="text-center">
        <p>
          *No purchase necessary to win a prize. Winners must be 18 years or
          older to qualify to win a prize.
          <br />
          Prizes will be awarded to the top 10 eligible investors after the
          final game of the <span>NCAA</span> College Basketball Tournament.
          <br />
          Game is played from March 14th 2021 - April 05th 2021.
          <br />
          First prize is $200 cash, second prize is $100 cash, third through
          tenth places will receive a $20 gift card to local Columbia, MO
          restaurants and shops.
        </p>
        <p>
          <Link to={"/terms-and-services"}>Full Terms and Services</Link>
        </p>
      </Col>
    </Row>
  );
};
