import React, { useEffect } from "react";
import { Container } from "react-bootstrap";
import AOS from "aos";
import { HowToPlay } from "./articles/howtoplay";
import { IntroHelp } from "./articles/introhelp";
import { PortfolioHelp } from "./articles/portfoliohelp";
import { MarketHelp } from "./articles/markethelp";
import { TradeHelp } from "./articles/tradehelp";
import { GroupHelp } from "./articles/grouphelp";
import { SocialMediaLinks } from "./articles/socialmedialinks";
import { LetsPlay } from "./articles/letsplay";
import { TermsConditionsPreivew } from "./articles/termsconditionspreivew";

export interface IRulesProps {}
export const Rules: React.FC<IRulesProps> = (props: IRulesProps) => {
  useEffect(() => {
    AOS.init();
  });

  // TODO: Update imgs when ready
  // TODO: only load js and css on this componets somehow

  return (
    <Container fluid>
      <div className="article-wrapper">
        <IntroHelp signedIn={true} />
        <HowToPlay />
        <PortfolioHelp />
        <MarketHelp />
        <TradeHelp />
        <GroupHelp />
        <LetsPlay />
        <TermsConditionsPreivew />
        <SocialMediaLinks />
      </div>
    </Container>
  );
};
