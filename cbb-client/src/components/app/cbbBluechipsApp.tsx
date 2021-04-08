import React, { useState, useEffect } from "react";
import {
  BrowserRouter as ReactRouter,
  Route as ReactRoute
} from "react-router-dom";

import { Navbar } from "../navbar/navbar";
import { Market } from "../market/Market";

require("./cbbBluechips.scss");

export interface IAppProps {}

export const App: React.FC<IAppProps> = (props: IAppProps) => {
  return (
    <ReactRouter>
      <div id="app-wrapper">
        <Navbar />
        <ReactRoute path="/">
          <Market />
        </ReactRoute>
      </div>
    </ReactRouter>
  );
};
