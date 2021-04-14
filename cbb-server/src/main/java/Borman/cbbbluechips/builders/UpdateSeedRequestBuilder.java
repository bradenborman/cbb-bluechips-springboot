package Borman.cbbbluechips.builders;

import Borman.cbbbluechips.models.UpdateSeedRequest;

public final class UpdateSeedRequestBuilder {
    private String teamName;
    private String newSeed;

    private UpdateSeedRequestBuilder() {
    }

    public static UpdateSeedRequestBuilder anUpdateSeedRequest() {
        return new UpdateSeedRequestBuilder();
    }

    public UpdateSeedRequestBuilder withTeamName(String teamName) {
        this.teamName = teamName;
        return this;
    }

    public UpdateSeedRequestBuilder withNewSeed(String newSeed) {
        this.newSeed = newSeed;
        return this;
    }

    public UpdateSeedRequest build() {
        return new UpdateSeedRequest(teamName, newSeed);
    }
}
