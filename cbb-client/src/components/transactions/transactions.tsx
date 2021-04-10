import React from "react";
import { Page } from "../general/page";

export interface ITransactionsProps {}
export const Transactions: React.FC<ITransactionsProps> = (
  props: ITransactionsProps
) => {
  return (
    <Page pageId="transactions">
      <h2>TEST</h2>
    </Page>
  );
};
