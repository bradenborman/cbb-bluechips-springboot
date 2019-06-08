package com.Borman.cbbbluechips.builders;

import com.Borman.cbbbluechips.models.UpdatePointSpreadRequest;

public final class UpdatePointSpreadRequestBuilder {
    private String teamName;
    private String nextPointSpread;

    private UpdatePointSpreadRequestBuilder() {
    }

    public static UpdatePointSpreadRequestBuilder anUpdatePointSpreadRequest() {
        return new UpdatePointSpreadRequestBuilder();
    }

    public UpdatePointSpreadRequestBuilder withTeamName(String teamName) {
        this.teamName = teamName;
        return this;
    }

    public UpdatePointSpreadRequestBuilder withNextPointSpread(String nextPointSpread) {
        this.nextPointSpread = nextPointSpread;
        return this;
    }

    public UpdatePointSpreadRequest build() {
        UpdatePointSpreadRequest updatePointSpreadRequest = new UpdatePointSpreadRequest();
        updatePointSpreadRequest.setTeamName(teamName);
        updatePointSpreadRequest.setNextPointSpread(nextPointSpread);
        return updatePointSpreadRequest;
    }
}
