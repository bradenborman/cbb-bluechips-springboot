import React from "react";

export interface INewFeaturesProps {}
export const NewFeatures: React.FC<INewFeaturesProps> = (
  props: INewFeaturesProps
) => {
  return (
    <div id="newFeatures">
      <h4>2022 New Features</h4>
      <div className="feature">
        <i className="fas fa-sms"></i> <b>Text Alerts</b>
        <p>
          Subscribe to "text alerts" for instant price changing text
          notifications once games have been played!
        </p>
      </div>
      <div className="feature">
        <i className="fab fa-rocketchat"></i> <b>Comment Threads</b>
        <p>User can post questions or comments where others may reply.</p>
      </div>
      <div className="feature">
        <i className="fas fa-chart-bar"></i> <b>Posted Point Spread</b>
        <p>
          No longer will a trip to ESPN be necessary for gathering information
          on the on the point spread
        </p>
      </div>
      <div className="feature">
        <i className="fas fa-user-friends"></i> <b>Groups</b>
        <p>Keep tabs of all your buddies!</p>
      </div>
      <div className="feature">
        <p>
          <a href="/rules">How to play CBB Bluechips</a>
        </p>
      </div>
    </div>
  );
};
