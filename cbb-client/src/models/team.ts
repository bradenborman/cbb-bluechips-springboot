export interface ITeam {
  teamId: number;
  teamName: string;
  seed: number;
  marketPrice: number;
  sharesOutstanding: number;
  imgSrcName: string;
  priceHistory?: string[];
  isLocked: boolean;
  pointSpread: number;
  teamplayingNextName?: string;
}
