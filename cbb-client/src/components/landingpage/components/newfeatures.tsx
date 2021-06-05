import React from "react";

export interface INewFeaturesProps {}
export const NewFeatures: React.FC<INewFeaturesProps> = (
  props: INewFeaturesProps
) => {
  return (
    <div id="newFeatures">
      <h4>2022 New Features</h4>
      <div className="feature">
        <i className="fas fa-clock"></i> <b>Time of games</b>
        <p>
          No longer will you have to visit another site to see the time of the
          games played
        </p>
      </div>
      <div className="feature">
        <i className="fas"></i> <b>Matchups</b>
        {/* Icon need */}
        <p>Market grouped by sportsDataMatchupResponses rather than seed.</p>
      </div>
      <div className="feature">
        <i className="fas"></i> <b>Re-worked front end</b>
        {/* Icon need */}
        <p>CBB 2022 is written in React and will be much quicker to navigate</p>
      </div>
      <div className="feature">
        <p>
          <a href="/rules">How to play CBB Bluechips</a>
        </p>
      </div>
    </div>
  );
};
