package Borman.cbbbluechips.analysis;

import java.text.DecimalFormat;

public class AnalysisBreakdown {

    private String teamName;
    private int timesTraded;
    private double netProfit;

    public AnalysisBreakdown(String teamName, int timesTraded, double netProfit) {
        this.teamName = teamName;
        this.timesTraded = timesTraded;
        this.netProfit = netProfit;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public int getTimesTraded() {
        return timesTraded;
    }

    public void setTimesTraded(int timesTraded) {
        this.timesTraded = timesTraded;
    }

    public double getNetProfit() {
        return netProfit;
    }

    public void setNetProfit(double netProfit) {
        this.netProfit = netProfit;
    }

    public void upTimesTraded() {
        this.timesTraded = ++timesTraded;
    }

    public String getNetProfitDisplayString() {
        DecimalFormat formatter = new DecimalFormat("$#,###;-$#,###");
        return formatter.format(netProfit);
    }

    public String getLossOrAheadClass() {
        if (this.netProfit > 0)
            return "ahead";
        else if (this.netProfit < 0)
            return "loss";
        return "";
    }
}
