import React from "react";
import { Table } from "react-bootstrap";
import { Investment } from "./investment";

export interface IInvestmentTableProps {
  children: any;
}
export const InvestmentTable: React.FC<IInvestmentTableProps> = (
  props: IInvestmentTableProps
) => {
  return (
    <Table hover responsive>
      <thead>
        <tr>
          <th scope="col"></th>
          <th scope="col">
            <span className="hideSmall">Institution</span>
          </th>
          <th scope="col">Amt Owned</th>
          <th scope="col">Market Price</th>
          <th scope="col">Total Value</th>
          <th scope="col"></th>
        </tr>
      </thead>
      <tbody id="investment-records">{[props.children]}</tbody>
    </Table>
  );
};
