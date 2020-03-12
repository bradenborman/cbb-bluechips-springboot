package com.Borman.cbbbluechips.models.enums;

import java.util.*;

public enum Ads {

    CANDY_FACTORY("Candy Factory", "/ads/thecandyfactory_logo1.png", "https://thecandyfactory.biz/"),
    Georgetown_Dental("Georgetown Dental", "/ads/GeorgetownDental.png", "http://www.ident.ws/template.jsp?doc=gregorydstevens"),
    Campus_Bar_and_Grill("Campus Bar & Grill", "/ads/b12 transparent_.png", "http://campusbarandgrill.com/");

    private String name;
    private String imgSrc;
    private String website;

    Ads(String name, String imgSrc, String website) {
        this.name = name;
        this.imgSrc = imgSrc;
        this.website = website;
    }

    public String getName() {
        return name;
    }

    public String getImgSrc() {
        return imgSrc;
    }

    public String getWebsite() {
        return website;
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