import { ITeam } from "../models/team";
import { IMatchup } from "../models/matchup";
import { ILeaderBoardUser } from "../models/leaderboardUser";
import { ITransactionRecord } from "../models/transactionRecord";

export const team1: ITeam = {
  teamId: 1,
  teamName: "Duke",
  seed: 45,
  sharesOutstanding: 36,
  imgSrcName: "Duke.png",
  marketPrice: 5000,
  isLocked: true,
  pointSpread: 7.5,
  priceHistory: ["64:5000", "32:4500", "16:6400"],
  teamplayingNextName: "Kentucky"
};

export const team2: ITeam = {
  teamId: 2,
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
  startTime: "2:30 PM"
};

export const matchup2: IMatchup = {
  team1: {
    teamId: 3,
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
    teamId: 4,
    teamName: "Utah",
    seed: 10,
    sharesOutstanding: 79,
    imgSrcName: "Utah.png",
    marketPrice: 5000,
    isLocked: false,
    pointSpread: -5,
    priceHistory: ["64:5000"]
  },
  startTime: "5:30 PM"
};

export const matchup3: IMatchup = {
  team1: {
    teamId: 3,
    teamName: "Tennessee",
    seed: 1,
    sharesOutstanding: 64,
    imgSrcName: "Tennessee.png",
    marketPrice: 5000,
    isLocked: false,
    pointSpread: 5,
    priceHistory: ["64:5000"]
  },
  team2: {
    teamId: 4,
    teamName: "Virginia",
    seed: 10,
    sharesOutstanding: 79,
    imgSrcName: "Virginia.png",
    marketPrice: 5000,
    isLocked: false,
    pointSpread: -5,
    priceHistory: ["64:5000"]
  },
  startTime: "8:30 PM"
};

export const matchup4: IMatchup = {
  team1: {
    teamId: 3,
    teamName: "Michigan",
    seed: 1,
    sharesOutstanding: 64,
    imgSrcName: "Michigan.png",
    marketPrice: 5000,
    isLocked: false,
    pointSpread: 5,
    priceHistory: ["64:5000"]
  },
  team2: {
    teamId: 4,
    teamName: "Dayton",
    seed: 10,
    sharesOutstanding: 79,
    imgSrcName: "Dayton.png",
    marketPrice: 5000,
    isLocked: false,
    pointSpread: -5,
    priceHistory: ["64:5000"]
  },
  startTime: "8:45 PM"
};

export const transactionTestData: ITransactionRecord[] = [
  {
    username: "Mike Atkinson",
    action: "BUY",
    teamTraded: "Baylor",
    amount: 52000,
    dateTime: "	04/09/2021 02:33 PM"
  },
  {
    username: "Mike Atkinson",
    action: "BUY",
    teamTraded: "Baylor",
    amount: 52000,
    dateTime: "	04/09/2021 02:33 PM"
  },
  {
    username: "Braden Borman",
    action: "BUY",
    teamTraded: "Duke",
    amount: 52000,
    dateTime: "	04/09/2021 02:33 PM"
  },
  {
    username: "Braden Borman",
    action: "BUY",
    teamTraded: "Baylor",
    amount: 52000,
    dateTime: "	04/09/2021 02:33 PM"
  },
  {
    username: "Mike Atkinson",
    action: "BUY",
    teamTraded: "Duke",
    amount: 52000,
    dateTime: "	04/09/2021 02:33 PM"
  },
  {
    username: "Mike Atkinson",
    action: "SELL",
    teamTraded: "Duke",
    amount: 52000,
    dateTime: "	04/09/2021 02:33 PM"
  }
];
