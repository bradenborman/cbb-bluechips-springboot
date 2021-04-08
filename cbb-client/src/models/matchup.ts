import { ITeam } from "./team";

export interface IMatchup {
  team1: ITeam;
  team2: ITeam;
  startTime: string;
}
