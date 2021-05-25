import React from "react";
import { Card } from "react-bootstrap";

export interface IPortfolioDetailProps {
  heading: string;
  children: any;
}
export const PortfolioDetail: React.FC<IPortfolioDetailProps> = (
  props: IPortfolioDetailProps
) => {
  return (
    <div className="portfolio-header-detail">
      <div className="detail-header">{props.heading}</div>
      <div className="detail-fact">{props.children}</div>
    </div>
  );
};
