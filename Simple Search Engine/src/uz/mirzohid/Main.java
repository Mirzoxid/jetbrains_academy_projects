package uz.mirzohid;

import uz.mirzohid.search.AllExistsSearch;
import uz.mirzohid.search.AnyExistsSearch;
import uz.mirzohid.search.NotExistsSearch;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        /*
          Don't forget to enter --data./res/text.txt as a parameter before starting the program!
         */
        Scanner dataSc = new Scanner(new File(args[1]));
        Scanner scanner = new Scanner(System.in);
        List<String> peoples = fillPeople(dataSc);
        Map<String, List<Integer>> peoplesSearchMap = fillPeopleSearchMap(peoples);
        dataSc.close();

        while (true) {
            System.out.println("=== Menu ===");
            System.out.println("1. Find a person");
            System.out.println("2. Print all people");
            System.out.println("0. Exit");
            int i = Integer.parseInt(scanner.nextLine());
            if (i == 0) {
                System.out.println("Bye!");
                break;
            }
            switch (i) {
                case 1:
                    searchPeople(peoples, peoplesSearchMap, scanner);
                    break;
                case 2:
                    printPeople(peoples);
                    break;
                default:
                    System.out.println("Incorrect option! Try again.");
                    break;
            }
        }
    }

    /***
     * Load data
     * @param scanner scanner is data load in file
     * @return List
     * */
    public static List<String> fillPeople(Scanner scanner) {
        List<String> peoplesTmp = new ArrayList<>();
        for (int i = 0; scanner.hasNext(); i++) {
            peoplesTmp.add(scanner.nextLine());
        }
        return peoplesTmp;
    }

    /***
     * Fill Inverted Index
     * @param list for create Inverted index
     * @return Inverted index
     */
    public static Map<String, List<Integer>> fillPeopleSearchMap(List<String> list) {
        Map<String, List<Integer>> peoplesTmp = new HashMap<>();
        for (int i = 0; i < list.size(); i++) {
            String sLine = list.get(i);
            for (String phrase : sLine.split(" ")) {
                List<Integer> integers = peoplesTmp.get(phrase.toLowerCase());
                if (integers == null) {
                    integers = new ArrayList<>();
                }
                integers.add(i);
                peoplesTmp.put(phrase.toLowerCase(), integers);
            }
        }
        return peoplesTmp;
    }

    /***
     * Search method
     * @param peoples data
     * @param peoplesSearchMap inverted index data
     * @param scanner for read search data
     */
    public static void searchPeople(List<String> peoples, Map<String, List<Integer>> peoplesSearchMap, Scanner scanner) {
        System.out.println("Select a matching strategy: ALL, ANY, NONE");
        String selectType = scanner.nextLine();
        SearchContext context = null;
        switch (selectType) {
            case "ALL":
                context = new SearchContext(new AllExistsSearch());
                break;
            case "ANY":
                context = new SearchContext(new AnyExistsSearch());
                break;
            case "NONE":
                context = new SearchContext(new NotExistsSearch());
                break;
            default:
                break;
        }
        System.out.println("Enter a name or email to search all suitable people.");
        String qS = scanner.nextLine();
        if (context != null) {
            context.searching(peoples, peoplesSearchMap, qS);
        }
    }

    /***
     * Print all data
     * @param peoples data for print
     */
    public static void printPeople(List<String> peoples) {
        System.out.println("=== List of people ===");
        for (String s : peoples) {
            System.out.println(s);
        }
    }
}
