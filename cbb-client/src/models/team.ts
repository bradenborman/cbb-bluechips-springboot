export interface ITeam {
  teamId: number;
  teamName: string;
  seed: number;
  marketPrice: number;
  sharesOutstanding: number;
  imgSrcName: string;
  priceHistory?: number[];
  isLocked: boolean;
  pointSpread: number;
  teamplayingNextName?: string;
}
