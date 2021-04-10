import React from "react";
import { Page } from "../general/page";
import { Row, Col, Table, Card } from "react-bootstrap";
import { transactionTestData } from "../../data/test-data";
import { ITransactionRecord } from "../../models/transactionRecord";

export interface ITransactionsProps {}
export const Transactions: React.FC<ITransactionsProps> = (
  props: ITransactionsProps
) => {
  const testData: ITransactionRecord[] = transactionTestData;

  const mappedData = transactionTestData.map((record, index) => {
    return (
      <tr key={index}>
        <td className="name">{record.username}</td>
        <td>
          <span className="badge badge-primary">{record.action}</span>
        </td>
        <td>{record.teamTraded}</td>
        <td>${record.amount.toLocaleString()}</td>
        <td>{record.dateTime}</td>
      </tr>
    );
  });

  return (
    <Page pageId="transactions">
      <Row>
        <Col lg={12}>
          <Card>
            <Table responsive>
              <thead>
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
