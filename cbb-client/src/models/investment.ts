export interface IInvestment {
  teamId: string;
  teamName: string;
  amountOwned: number;
  nextPointSpread: string;
  outOfPlay: boolean;
  locked: boolean;
  marketPrice: number;
}