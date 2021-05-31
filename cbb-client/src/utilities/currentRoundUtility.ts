export const getDisplayTextCurrentRound = (round: string): string => {
  switch (Number(round)) {
    case 64:
    case 32:
      return `Round of ${round}`;
    case 16:
      return "Sweet Sixteen";
    case 8:
      return "Elite Eight";
    case 4:
      return "Final Four";
    case 2:
      return "Championship";
    default:
      return "No round set";
  }
};
