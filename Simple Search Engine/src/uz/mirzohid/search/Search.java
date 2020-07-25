package uz.mirzohid.search;

import java.util.List;
import java.util.Map;

public interface Search {
    /***
     * Search and print data
     * @param peoples peoples is data
     * @param peoplesSearchMap peoplesSearchMap is inverted indexes
     * @param searchQuery searchQuery is search phrases
     */
    void search(List<String> peoples, Map<String, List<Integer>> peoplesSearchMap, String searchQuery);
}
