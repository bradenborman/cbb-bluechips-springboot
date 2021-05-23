import React, { useRef, useState, useEffect } from "react";
import { useHistory, useLocation } from "react-router";
import classNames from "classnames";

export interface INavbarProps {}
export const Navbar: React.FC<INavbarProps> = (props: INavbarProps) => {
  let history = useHistory();
  let location: any = useLocation();

  const [sticky, setSticky] = useState<boolean>(false);

  const headerRef = useRef(null);

  const handleScroll = () => {
    if (headerRef.current) {
      setSticky(headerRef.current.getBoundingClientRect().top <= 0);
    }
  };

  useEffect(() => {
    //  alert(sticky)
  }, [sticky]);

  useEffect(() => {
    window.addEventListener("scroll", handleScroll);

    return () => {
      window.removeEventListener("scroll", () => handleScroll);
    };
  }, []);

  const returnToHome = (e: any) => {
    if (location.pathname !== "/login") history.push("/portfolio");
  };

  return (
    <div id="header-wrapper">
      <header
        ref={headerRef}
        className={classNames("header", { stuck: sticky })}
      >
        <h1 onClick={returnToHome}>College Basketball's Bluechips</h1>
      </header>
    </div>
  );
};
