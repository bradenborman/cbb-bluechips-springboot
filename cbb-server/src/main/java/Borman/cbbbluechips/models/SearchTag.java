package Borman.cbbbluechips.models;

public class SearchTag {

    private String paramName;
    private String searchValue;

    public SearchTag(String paramName, String searchValue) {
        this.paramName = paramName;
        this.searchValue = searchValue;
    }

    public String getParamName() {
        return paramName;
    }

    public void setParamName(String paramName) {
        this.paramName = paramName;
    }


    public String getSearchValue() {
        return searchValue;
    }

    public void setSearchValue(String searchValue) {
        this.searchValue = searchValue;
    }

    @Override
    public String toString() {
        return searchValue;
    }

}