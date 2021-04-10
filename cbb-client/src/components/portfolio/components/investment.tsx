import React from "react";
import { useHistory } from "react-router";

export interface IInvestmentProps {}

export const Investment: React.FC<IInvestmentProps> = (
  props: IInvestmentProps
) => {
  let history = useHistory();

  const handleTradeClick = (e: any) => {
    history.push("/trade/" + 1);
  };

  return (
    <tr>
      <td className="logoTd">
        <img
          id="6052"
          className="logo"
          src="/img/teams/Baylor.png"
          onClick={handleTradeClick}
        />
        <span className="pointSpread">4.5</span>
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
          type="button"
          className="tradeBTN btn btn-primary"
          onClick={handleTradeClick}
        >
          Trade
        </button>
      </td>
    </tr>
  );
};
