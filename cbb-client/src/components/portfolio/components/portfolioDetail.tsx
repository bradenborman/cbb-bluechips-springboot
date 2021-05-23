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
    <Card.Text className="portfolio-header-detail">
      <span className="detail-header">{props.heading}</span>: {props.children}
    </Card.Text>
  );
};
