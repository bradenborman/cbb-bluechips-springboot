import React from "react";
import { Container } from "react-bootstrap";

export interface IPageProps {
  pageId: string;
  children: any;
}
export const Page: React.FC<IPageProps> = (props: IPageProps) => {
  return <Container id={props.pageId}>{props.children}</Container>;
};
