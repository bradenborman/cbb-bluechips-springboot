package com.Borman.cbbbluechips.models.enums;

import java.util.*;

public enum Ads {

    CANDY_FACTORY("Candy Factory", "/ads/candy-factory.png"),
    ADDISONS_BAR_GRILL("Addison's Bar and Grill", "/ads/addisons.jpg"),
    SHELTER_INSURANCE("Shelter Insurance", "/ads/shelterinsurance.jpg");

    private String name;
    private String imgSrc;

    Ads(String name, String imgSrc) {
        this.name = name;
        this.imgSrc = imgSrc;
    }

    public String getName() {
        return name;
    }

    public String getImgSrc() {
        return imgSrc;
    }

    public static List<Ads> getDisplayAdds() {
        List<Ads> addsToPickFrom = Arrays.asList(Ads.values());
        Collections.shuffle(addsToPickFrom);
        return new ArrayList<Ads>() {{
            add(addsToPickFrom.get(0));
            add(addsToPickFrom.get(1));
            add(addsToPickFrom.get(2));
        }};
    }

}