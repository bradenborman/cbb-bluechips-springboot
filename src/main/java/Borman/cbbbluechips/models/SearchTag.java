package Borman.cbbbluechips.models;

public class SearchTag {

    private String searchValue;

    public SearchTag(String searchValue) {
        this.searchValue = searchValue;
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