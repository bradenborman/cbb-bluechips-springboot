package Borman.cbbbluechips.utilities;

import Borman.cbbbluechips.models.SearchTag;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class SearchTagUtility {


    public static List<SearchTag> parseTags(String params) {
        return params != null ? Arrays.stream(params.split("<->")).map(SearchTag::new).collect(Collectors.toList()) : Collections.emptyList();
    }

}