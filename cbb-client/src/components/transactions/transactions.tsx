import React, { useState } from "react";
import { Page } from "../general/page";
import { Row, Col, Table, Card } from "react-bootstrap";
import { transactionTestData } from "../../data/test-data";
import { ITransactionRecord } from "../../models/transactionRecord";

export interface ITransactionsProps {}
export const Transactions: React.FC<ITransactionsProps> = (
  props: ITransactionsProps
) => {
  const testData: ITransactionRecord[] = transactionTestData;

  const [activeFilter, setActiveFilter] = useState<string>();

  const handleFilterChange = (filter: string): void => {
    setActiveFilter(filter);
  };

  const mappedData = transactionTestData
    .filter((row: ITransactionRecord) => {
      if (activeFilter != null && activeFilter != undefined)
        return row.username == activeFilter || row.teamTraded == activeFilter;
      return true;
    })
    .map((record, index) => {
      return (
        <tr key={index}>
          <td
            onClick={e => handleFilterChange(record.username)}
            className="name"
          >
            {record.username}
          </td>
          <td>
            <span className="badge badge-primary">{record.action}</span>
          </td>
          <td
            onClick={e => handleFilterChange(record.teamTraded)}
            className="team"
          >
            {record.teamTraded}
          </td>
          <td>${record.amount.toLocaleString()}</td>
          <td>{record.dateTime}</td>
        </tr>
      );
    });

  const getActiveFilterText = (): JSX.Element => {
    if (activeFilter != null && activeFilter != undefined)
      return (
        <span onClick={e => setActiveFilter(null)}>
          <i className="fa fa-minus-circle" /> {activeFilter}
        </span>
      );
    return <span>N/A</span>;
  };

  return (
    <Page pageId="transactions">
      <Row>
        <Col lg={12}>
          <Card>
            <Table responsive>
              <thead>
                <tr>
                  <td colSpan={5}>Active Filter: {getActiveFilterText()}</td>
                </tr>
                <tr className="thead-light">
                  <th>
                    <i className="fas fa-user"></i> Name
                  </th>
                  <th>Action</th>
                  <th>Team</th>
                  <th>
                    <i className="fas fa-dollar-sign"></i> Amount
                  </th>
                  <th>
                    <i className="fas fa-clock"></i> Date
                  </th>
                </tr>
              </thead>
              <tbody id="myTable">{mappedData}</tbody>
            </Table>
          </Card>
        </Col>
      </Row>
    </Page>
  );
};
