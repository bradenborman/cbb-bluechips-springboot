import React, { useState, useEffect } from "react";
import {
  BrowserRouter as ReactRouter,
  Route as ReactRoute
} from "react-router-dom";

import { Navbar } from "../navbar/navbar";
import { Market } from "../market/Market";
import { Portfolio } from "../portfolio/portfolio";

require("./cbbBluechips.scss");

export interface IAppProps {}

export const App: React.FC<IAppProps> = (props: IAppProps) => {
  return (
    <ReactRouter>
      <div id="app-wrapper">
        <Navbar />
        <ReactRoute path="/portfolio">
          <Portfolio />
        </ReactRoute>
        <ReactRoute path="/market">
          <Market />
        </ReactRoute>
      </div>
    </ReactRouter>
  );
};
