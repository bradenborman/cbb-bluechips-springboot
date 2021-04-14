package Borman.cbbbluechips.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@ConfigurationProperties(prefix="game-rules")
public class GameRules {

    private int startingPricePerShare;
    private Map<String, String> payoutMap;

    public int getStartingPricePerShare() {
        return startingPricePerShare;
    }

    public void setStartingPricePerShare(int startingPricePerShare) {
        this.startingPricePerShare = startingPricePerShare;
    }

    public Map<String, String> getPayoutMap() {
        return payoutMap;
    }

    public void setPayoutMap(Map<String, String> payoutMap) {
        this.payoutMap = payoutMap;
    }

}