import React from "react";
import { Row } from "react-bootstrap";

export interface ISocialMediaLinksProps {}
export const SocialMediaLinks: React.FC<ISocialMediaLinksProps> = (
  props: ISocialMediaLinksProps
) => {
  //TODO: breakdown into interface with classname, link value, text etc

  return (
    <Row className="text-center">
      <div className="social__container">
        <div className="social__item">
          <a
            target="_blank"
            href="https://www.facebook.com/cbbbluechips"
            rel="noopener"
            className="social__icon--facebook"
          >
            <i className="icon--facebook"></i>
          </a>
        </div>
        <div className="social__item">
          <a
            target="_blank"
            href="https://www.linkedin.com/in/bradenborman/"
            rel="noopener"
            className="social__icon--linkedin"
          >
            <i className="icon--linkedin"></i>
          </a>
        </div>
        <div className="social__item">
          <a
            target="_blank"
            href="https://github.com/bradenborman/"
            rel="noopener"
            className="social__icon--github"
          >
            <i className="icon--github"></i>
          </a>
        </div>
      </div>
    </Row>
  );
};
