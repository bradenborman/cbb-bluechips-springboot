import React, { useState, useEffect } from "react";
import {
  BrowserRouter as ReactRouter,
  Route as ReactRoute
} from "react-router-dom";

import Cookies from "universal-cookie";

import { Navbar } from "../navbar/navbar";
import { Market } from "../market/Market";
import { Portfolio } from "../portfolio/portfolio";
import { Trade } from "../trade/trade";
import { Calculator } from "../calculator/calculator";
import { Transactions } from "../transactions/transactions";
import { Rules } from "../gamerules/rules";
import { Leaderboard } from "../leaderboard/leaderboard";
import { LoignSignup } from "../landingpage/loignSignup";
import { ActiveHomePageOption } from "../../models/enums/activeHomePageOption";

require("./cbbBluechips.scss");

export interface IAppProps {}

export const App: React.FC<IAppProps> = (props: IAppProps) => {
  const cookies = new Cookies();

  const [isLoggedIn, setIsLoggedIn] = useState<boolean>(
    cookies.get("_live") != undefined
  ); //_live is cookie used at login to flag front end for nav

  return (
    <ReactRouter>
      <div id="app-wrapper">
        <Navbar isLoggedIn={isLoggedIn} />
        <ReactRoute exact path={"/login"}>
          <LoignSignup
            setIsLoggedIn={setIsLoggedIn}
            selectedOption={ActiveHomePageOption.LOGIN}
          />
        </ReactRoute>
        <ReactRoute exact path={["/", "/portfolio"]}>
          <Portfolio />
        </ReactRoute>
        <ReactRoute exact path="/market">
          <Market />
        </ReactRoute>
        <ReactRoute exact path="/trade/:teamId">
          <Trade />
        </ReactRoute>
        <ReactRoute exact path="/calculator">
          <Calculator />
        </ReactRoute>
        <ReactRoute exact path="/transactions">
          <Transactions />
        </ReactRoute>
        <ReactRoute exact path={["/rules", "/how-to-play"]}>
          <Rules />
        </ReactRoute>
        <ReactRoute exact path="/leaderboard">
          <Leaderboard paypalDonationAmount={10} />
        </ReactRoute>
      </div>
    </ReactRouter>
  );
};
