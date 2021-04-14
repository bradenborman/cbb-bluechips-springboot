import React, { useState } from "react";
import { Page } from "../general/page";
import {
  Card,
  Row,
  Col,
  InputGroup,
  FormControl,
  Button
} from "react-bootstrap";
import { calculatorTip1 } from "../../data/staticMessages";

export interface ICalculatorProps {}
export const Calculator: React.FC<ICalculatorProps> = (
  props: ICalculatorProps
) => {
  const [teamOneScore, setTeamOneScore] = useState<number>(66);
  const [teamTwoScore, setTeamTwoScore] = useState<number>(70);
  const [teamOnePointSpread, setTeamOnePointSpread] = useState<number>(-4.5);

  return (
    <Page pageId="calculator">
      <Row>
        <Col xl={8}>
          <Card>
            <Card.Body>
              <Row>
                <Col xl={6}>
                  <Row>
                    <Col className="teamSection" xl={12}>
                      <label>Team A</label>
                      <InputGroup className="mb-4">
                        <InputGroup.Prepend>
                          <InputGroup.Text className="bg-info">
                            Score:
                          </InputGroup.Text>
                        </InputGroup.Prepend>
                        <FormControl
                          type="text"
                          value={teamOneScore}
                          maxLength={3}
                        />
                        <InputGroup.Append>
                          <InputGroup.Text className="bg-info">
                            PS:
                          </InputGroup.Text>
                        </InputGroup.Append>
                        <FormControl value={teamOnePointSpread} />
                      </InputGroup>
                    </Col>
                    <Col className="teamSection" xl={12}>
                      <label>Team B</label>
                      <InputGroup className="mb-1">
                        <InputGroup.Prepend>
                          <InputGroup.Text className="bg-info">
                            Score:
                          </InputGroup.Text>
                        </InputGroup.Prepend>
                        <FormControl
                          type="text"
                          value={teamTwoScore}
                          maxLength={3}
                        />
                        <InputGroup.Append>
                          <InputGroup.Text className="bg-info">
                            PS:
                          </InputGroup.Text>
                        </InputGroup.Append>
                        <FormControl value={teamOnePointSpread * -1} />
                      </InputGroup>
                    </Col>
                  </Row>
                </Col>
                <Col id="calculation-results" xl={6}>
                  <label>Results</label>
                </Col>
              </Row>
            </Card.Body>
          </Card>
        </Col>
        <Col xl={4}>
          <Card>
            <Card.Body>
              <Card.Text>{calculatorTip1}</Card.Text>
            </Card.Body>
          </Card>
        </Col>
      </Row>
    </Page>
  );
};
