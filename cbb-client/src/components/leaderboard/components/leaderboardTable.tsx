import React, { useState } from "react";
import { leadboardUsersTestdata } from "../../../data/test-data";
import { Table, Pagination } from "react-bootstrap";
import { ILeaderBoardUser } from "../../../models/leaderboardUser";
import { OverlayTrigger } from "react-bootstrap";
import { Tooltip } from "react-bootstrap";

export interface ILeaderBoardTableProps {
  leaders: ILeaderBoardUser[];
}
export const LeaderBoardTable: React.FC<ILeaderBoardTableProps> = (
  props: ILeaderBoardTableProps
) => {
  const paginationPageLimit: number = Math.ceil(props.leaders.length);
  const [paginationIndex, setPaginationIndex] = useState<number>(1);

  const applyIndexChangeNegitive = (): void => {
    if (paginationIndex >= 11) setPaginationIndex(paginationIndex - 10);
  };

  const applyIndexChangePositive = (): void => {
    if (isNextPage()) setPaginationIndex(paginationIndex + 10);
  };

  const isNextPage = (): boolean => {
    return !(paginationIndex + 10 > paginationPageLimit);
  };

  const mappedLeaderboardUser = (
    users: ILeaderBoardUser[]
  ): JSX.Element[] | JSX.Element => {
    var x = leadboardUsersTestdata
      .slice(paginationIndex - 1, paginationIndex + 9)
      .map((user, index) => {
        return (
          <tr key={index}>
            <td>{user.ranking}</td>
            <td>{user.name}</td>
            <td>${user.networth.toLocaleString()}</td>
          </tr>
        );
      });

    if (x.length < 10) {
      while (x.length < 10) {
        const y = (
          <tr key={x.length + 1}>
            <td></td>
            <td>
              <span className="vaccant">Vaccant</span>
            </td>
            <td></td>
          </tr>
        );
        x = [...x, y];
      }
    }
    return x;
  };

  return (
    <Table hover id="leadersTable">
      <thead>
        <tr>
          <th scope="col">Ranking</th>
          <th scope="col">
            <i className="fa fa-user-circle"></i> Name
          </th>
          <th scope="col">Networth</th>
        </tr>
      </thead>
      <tbody>{mappedLeaderboardUser(props.leaders)}</tbody>
      <tfoot>
        <tr>
          <td colSpan={3}>
            <div className="leaderboard-pagination-wrapper">
              <Pagination>
                <Pagination.First
                  className="pagination-option"
                  disabled={paginationIndex == 1}
                  onClick={e => setPaginationIndex(1)}
                />
                <Pagination.Prev
                  className="pagination-option"
                  disabled={paginationIndex == 1}
                  onClick={e => applyIndexChangeNegitive()}
                />
                <Pagination.Item className="pagination-option">
                  {Math.ceil(paginationIndex / 10)}
                </Pagination.Item>
                <Pagination.Next
                  className="pagination-option"
                  disabled={!isNextPage()}
                  onClick={e => applyIndexChangePositive()}
                />
                <Pagination.Last
                  className="pagination-option"
                  disabled={!isNextPage()}
                  onClick={e =>
                    setPaginationIndex(
                      Math.floor(paginationPageLimit / 10) * 10 + 1
                    )
                  }
                />
              </Pagination>
            </div>
          </td>
        </tr>
      </tfoot>
    </Table>
  );
};
