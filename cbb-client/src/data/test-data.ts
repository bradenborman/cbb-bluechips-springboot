import { ITeam } from "../models/team";
import { IMatchup } from "../models/matchup";

export const team1: ITeam = {
  teamId: 1,
  teamName: "Duke",
  seed: 45,
  sharesOutstanding: 36,
  imgSrcName: "Duke.png",
  marketPrice: 5000,
  isLocked: true,
  pointSpread: 7.5,
  priceHistory: ["64:5000", "32:4500"],
  teamplayingNextName: "Kentucky"
};

export const team2: ITeam = {
  teamId: 1,
  teamName: "Kentucky",
  seed: 6,
  sharesOutstanding: 84,
  imgSrcName: "Kentucky.png",
  marketPrice: 5000,
  isLocked: true,
  pointSpread: -7.5,
  priceHistory: ["64:5000", "32:6500"],
  teamplayingNextName: "Duke"
};

export const matchup1: IMatchup = {
  team1,
  team2,
  startTime: "2:30PM"
};

export const matchup2: IMatchup = {
  team1: {
    teamId: 1,
    teamName: "Alabama",
    seed: 1,
    sharesOutstanding: 64,
    imgSrcName: "Alabama.png",
    marketPrice: 5000,
    isLocked: false,
    pointSpread: 5,
    priceHistory: ["64:5000"]
  },
  team2: {
    teamId: 1,
    teamName: "Michigan",
    seed: 10,
    sharesOutstanding: 79,
    imgSrcName: "Michigan.png",
    marketPrice: 5000,
    isLocked: false,
    pointSpread: -5,
    priceHistory: ["64:5000"]
  },
  startTime: "5:30PM"
};
