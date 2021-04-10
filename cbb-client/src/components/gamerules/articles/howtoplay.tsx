import React from "react";
import { Row, Col } from "react-bootstrap";

export interface IHowToPlayProps {}
export const HowToPlay: React.FC<IHowToPlayProps> = (
  props: IHowToPlayProps
) => {
  return (
    <Row id="howToPlay">
      <Col md={6}>
        <h4>How to Play</h4>
        <h4 className="subheading">First step towards becoming the champ.</h4>
        <p className="text-muted">
          Each Investor is gifted <span>$100,000</span> in fake seed money that
          is added to your portfolio. The goal of College Basketball Bluechips
          is to grow your investment into the biggest pile of cash at the end of
          March Madness.
          <br />
          <br />
          Every team in the <span>NCAA</span> College Basketball tournament is
          given a value. The better the team, the more expensive they are to
          buy. As an investor, you can buy shares of any team at their current
          market value before their game tips off.
          <br />
          <br />
          Team values will change based upon how well they perform against the
          official <span>ESPN</span> point spread for the game they are playing
          in. For instance, if Kansas is favored by 8 points in their game
          against Florida [Kansas (–8) vs Florida], but only wins by 1 point,
          Kansas’ value will decrease in increments of $100 per point from the
          spread (8 points) minus their margin of victory (1 point), and
          Florida’s value will increase by that same amount despite not winning
          the game. In this scenario, Florida’s value increases by $700, and
          Kansas’ value decreases by $700.
          <br />
          <br />
          <br />
          After each game, you can sell your shares of each team and invest in
          the next game!
          <br />
          <b>HINT:</b> the more games you invest in, the more likely you are to
          make a profit. Buy and sell often!!
        </p>
      </Col>
      <Col md={6}>
        <div className="how-img">
          <img
            data-aos-delay="300"
            data-aos="fade-left"
            aos-duration="1000"
            id="networth_viewImg"
            className="img-fluid"
            alt="Networth"
            src="img/how_to_imgs/networth_view.png"
          />
        </div>
      </Col>
    </Row>
  );
};
