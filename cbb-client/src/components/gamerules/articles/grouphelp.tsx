import React from "react";
import { Row, Col } from "react-bootstrap";

export interface IGroupHelpProps {}
export const GroupHelp: React.FC<IGroupHelpProps> = (
  props: IGroupHelpProps
) => {
  return (
    <Row id="groupHelp">
      <Col md={5}>
        <h4>Groups</h4>
        <h4 className="subheading">Keep tabs of all your buddies</h4>
        <p className="text-muted">
          New this year is the ability to create and join a group. Although the
          gameRules are determined from the Global CBB Leaderboard, making a
          group is a good way to keep track of people of common interest. Groups
          can, but dont have to be, password/code protected. When creating
          simpling leave blank for an open/public group, or enter a password
          that will be required to enter upon others joining. Once you create a
          group, you are automatically joined. Groups with 0 members in them
          will be automatically removed as well. There is no limit to how many
          groups you can join and you are free to leave at any time by clicking
          the minus button at the top right of a group.
          <br />
          <br />
          On the group leaderboard page, there is a link that can be copied and
          shared places like: Facebook messenger groups, email, texts group,
          etc. If a user is not logged in while clicking the link, they will be
          redirected to login. If they do not have an account, they will be
          redirected the same and user will switch to "New Signup" and will be
          promted to login again after. After user has logged in or user used a
          device that was already logged in at time of clicking the link, they
          will automatically join the group even if it is password protected.
        </p>
      </Col>
      <Col md={7}>
        <div className="how-img">
          <img
            data-aos-delay="300"
            data-aos="fade-left"
            aos-duration="1000"
            className="img-fluid"
            id="group_exampleImg"
            alt="Groups Example"
            src="img/how_to_imgs/groups_inputs.png"
          />
        </div>
      </Col>
    </Row>
  );
};
