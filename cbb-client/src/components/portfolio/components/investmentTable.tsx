import React from "react";
import { Table } from "react-bootstrap";

export interface IInvestmentTableProps {}
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
      <tbody id="investment-records">
        <tr>
          <td className="logoTd">
            <img id="6052" className="logo" src="/img/teams/Baylor.png" />
          </td>
          <td>
            <span className="hideSmall">
              <span>Baylor</span>
            </span>
          </td>
          <td>4</td>
          <td>$9,500</td>
          <td>$38,000</td>
          <td className="hideSmall">
            <button
              id="6052btn"
              type="button"
              className="tradeBTN btn btn-primary"
            >
              Trade
            </button>
          </td>
        </tr>
      </tbody>
    </Table>
  );
};
