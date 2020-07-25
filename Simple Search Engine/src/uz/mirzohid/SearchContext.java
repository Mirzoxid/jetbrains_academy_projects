package uz.mirzohid;

import uz.mirzohid.search.Search;

import java.util.List;
import java.util.Map;

class SearchContext {
    private final Search search;

    SearchContext(Search search) {
        this.search = search;
    }

    /***
     * Invoke Strategy pattern execution
     * @param peoples peoples is data
     * @param peoplesSearchMap peoplesSearchMap is inverted indexes
     * @param searchQuery searchQuery is search phrases
     */
    public void searching(List<String> peoples, Map<String, List<Integer>> peoplesSearchMap, String searchQuery) {
        this.search.search(peoples, peoplesSearchMap, searchQuery);
    }
}
