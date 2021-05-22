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
    teamName: "Michigan",
    seed: 10,
    sharesOutstanding: 79,
    imgSrcName: "Michigan.png",
    marketPrice: 5000,
    isLocked: false,
    pointSpread: -5,
    priceHistory: ["64:5000"]
  },
  startTime: "5:30 PM"
};

export const leadboardUsersTestdata: ILeaderBoardUser[] = [
  {
    ranking: 1,
    name: "M. Atkinson",
    networth: 530800
  },
  {
    ranking: 2,
    name: "J. Hughes",
    networth: 372950
  },
  {
    ranking: 3,
    name: "T. Borman",
    networth: 297750
  },
  {
    ranking: 4,
    name: "B. Pezold",
    networth: 290100
  },
  {
    ranking: 5,
    name: "K. Borman	",
    networth: 223050
  },
  {
    ranking: 6,
    name: "R. Hawkins	",
    networth: 220350
  },
  {
    ranking: 7,
    name: "M. Atkinson",
    networth: 530800
  },
  {
    ranking: 8,
    name: "J. Hughes",
    networth: 372950
  },
  {
    ranking: 9,
    name: "T. Borman",
    networth: 297750
  },
  {
    ranking: 10,
    name: "B. Pezold",
    networth: 290100
  },
  {
    ranking: 11,
    name: "K. Borman	",
    networth: 223050
  },
  {
    ranking: 12,
    name: "R. Hawkins	",
    networth: 220350
  },
  {
    ranking: 13,
    name: "M. Atkinson",
    networth: 530800
  },
  {
    ranking: 14,
    name: "J. Hughes",
    networth: 372950
  },
  {
    ranking: 15,
    name: "T. Borman",
    networth: 297750
  },
  {
    ranking: 16,
    name: "B. Pezold",
    networth: 290100
  },
  {
    ranking: 17,
    name: "K. Borman	",
    networth: 223050
  },
  {
    ranking: 18,
    name: "R. Hawkins	",
    networth: 220350
  },
  {
    ranking: 19,
    name: "B. Pezold",
    networth: 290100
  },
  {
    ranking: 20,
    name: "K. Borman	",
    networth: 223050
  },
  {
    ranking: 21,
    name: "R. Hawkins	",
    networth: 220350
  },
  {
    ranking: 22,
    name: "M. Atkinson",
    networth: 530800
  },
  {
    ranking: 23,
    name: "J. Hughes",
    networth: 372950
  },
  {
    ranking: 24,
    name: "T. Borman",
    networth: 297750
  },
  {
    ranking: 25,
    name: "B. Pezold",
    networth: 290100
  },
  {
    ranking: 26,
    name: "K. Borman	",
    networth: 223050
  },
  {
    ranking: 27,
    name: "R. Hawkins	",
    networth: 220350
  },
  {
    ranking: 1,
    name: "M. Atkinson",
    networth: 530800
  },
  {
    ranking: 2,
    name: "J. Hughes",
    networth: 372950
  },
  {
    ranking: 3,
    name: "T. Borman",
    networth: 297750
  },
  {
    ranking: 4,
    name: "B. Pezold",
    networth: 290100
  },
  {
    ranking: 5,
    name: "K. Borman	",
    networth: 223050
  },
  {
    ranking: 6,
    name: "R. Hawkins	",
    networth: 220350
  },
  {
    ranking: 7,
    name: "M. Atkinson",
    networth: 530800
  },
  {
    ranking: 8,
    name: "J. Hughes",
    networth: 372950
  },
  {
    ranking: 9,
    name: "T. Borman",
    networth: 297750
  },
  {
    ranking: 10,
    name: "B. Pezold",
    networth: 290100
  },
  {
    ranking: 11,
    name: "K. Borman	",
    networth: 223050
  },
  {
    ranking: 12,
    name: "R. Hawkins	",
    networth: 220350
  },
  {
    ranking: 13,
    name: "M. Atkinson",
    networth: 530800
  },
  {
    ranking: 14,
    name: "J. Hughes",
    networth: 372950
  },
  {
    ranking: 15,
    name: "T. Borman",
    networth: 297750
  },
  {
    ranking: 16,
    name: "B. Pezold",
    networth: 290100
  },
  {
    ranking: 17,
    name: "K. Borman	",
    networth: 223050
  },
  {
    ranking: 18,
    name: "R. Hawkins	",
    networth: 220350
  },
  {
    ranking: 19,
    name: "B. Pezold",
    networth: 290100
  },
  {
    ranking: 20,
    name: "K. Borman	",
    networth: 223050
  },
  {
    ranking: 21,
    name: "R. Hawkins	",
    networth: 220350
  },
  {
    ranking: 22,
    name: "M. Atkinson",
    networth: 530800
  },
  {
    ranking: 23,
    name: "J. Hughes",
    networth: 372950
  },
  {
    ranking: 24,
    name: "T. Borman",
    networth: 297750
  },
  {
    ranking: 25,
    name: "B. Pezold",
    networth: 290100
  },
  {
    ranking: 26,
    name: "K. Borman	",
    networth: 223050
  },
  {
    ranking: 27,
    name: "R. Hawkins	",
    networth: 220350
  }
];

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
