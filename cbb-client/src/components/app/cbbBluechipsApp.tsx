import React, { useState, useEffect } from "react";
import {
  BrowserRouter as ReactRouter,
  Route as ReactRoute
} from "react-router-dom";

import { Navbar } from "../navbar/navbar";
import { Market } from "../market/Market";
import { Portfolio } from "../portfolio/portfolio";
import { Trade } from "../trade/trade";
import { Calculator } from "../calculator/calculator";
import { Transactions } from "../transactions/transactions";
import { Rules } from "../gamerules/rules";
import { Leaderboard } from "../leaderboard/leaderboard";
import { LoignSignup } from "../landingpage/landingpage";
import { ActiveHomePageOption } from "../../models/enums/activeHomePageOption";

require("./cbbBluechips.scss");

export interface IAppProps {}

export const App: React.FC<IAppProps> = (props: IAppProps) => {
  return (
    <ReactRouter>
      <div id="app-wrapper">
        <Navbar />
        <ReactRoute exact path={["/login"]}>
          <LoignSignup selectedOption={ActiveHomePageOption.LOGIN} />
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
        <ReactRoute exact path="/rules">
          <Rules />
        </ReactRoute>
        <ReactRoute exact path="/leaderboard">
          <Leaderboard paypalDonationAmount={10} />
        </ReactRoute>
      </div>
    </ReactRouter>
  );
};
