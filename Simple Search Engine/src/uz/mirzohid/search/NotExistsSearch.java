package uz.mirzohid.search;

import java.util.List;
import java.util.Map;

public class NotExistsSearch implements Search {

    @Override
    public void search(List<String> peoples, Map<String, List<Integer>> peoplesSearchMap, String searchQuery) {
        StringBuilder queryResult = new StringBuilder();
        List<Integer> printRes = null;
        for (String qS : searchQuery.toLowerCase().split(" ")) {
            List<Integer> results = peoplesSearchMap.get(qS);
            if (printRes == null) {
                printRes = results;
            } else {
                for (Integer result : results) {
                    if (!printRes.contains(result)) {
                        printRes.add(result);
                    }
                }
            }
        }

        if (printRes != null && printRes.size() != 0) {
            for (int i = 0; i < peoples.size(); i++) {
                if (!printRes.contains(i)) {
                    queryResult.append(peoples.get(i)).append("\n");
                }
            }
            System.out.println(queryResult.toString());
        } else {
            System.out.println("No matching people found.");
        }
    }
}
