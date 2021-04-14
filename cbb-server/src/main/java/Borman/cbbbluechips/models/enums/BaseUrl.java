package Borman.cbbbluechips.models.enums;

public enum BaseUrl {

    LOCAL("http://localhost:8080"),
    DEPLOYED("https://www.cbb-bluechips.com");

    private String url;

    BaseUrl(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

}