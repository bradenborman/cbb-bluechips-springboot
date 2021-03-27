import React, { useState, useEffect } from "react";
import { Navbar } from "../navbar/navbar";

require("./app.scss");

export interface IAppProps {}

export const App: React.FC<IAppProps> = (props: IAppProps) => {
  return (
    <div className="app-wrapper">
      <Navbar />
    </div>
  );
};
