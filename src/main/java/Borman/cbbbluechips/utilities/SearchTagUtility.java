package Borman.cbbbluechips.utilities;

import Borman.cbbbluechips.models.SearchTag;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class SearchTagUtility {

    public static List<SearchTag> parseTags(Map<String, String> params) {
        return (params != null && !params.isEmpty()) ?
                params.entrySet().stream()
                .map(e -> new SearchTag(e.getKey(), e.getValue())).collect(Collectors.toList()) : Collections.emptyList();
    }

}