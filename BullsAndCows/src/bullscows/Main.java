package bullscows;


import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please, enter the secret code's length:");
        try {
            String ss = sc.next();
            int num = Integer.parseInt(ss);
            if (num <= 0 || num > 36) {
                throw new RuntimeException("Error: maximum number of possible symbols in the code is 36 (0-9, a-z).");
            } else {
                startGame(num);
            }
        } catch (NumberFormatException e) {
            System.out.println("Error: " + e.getMessage().substring(18) + " isn't a valid number.");
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void startGame(int num) {
        String[] possibles = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
        Scanner sc = new Scanner(System.in);
        System.out.println("Input the number of possible symbols in the code:");
        int possSym = Integer.parseInt(sc.next());
        if (possSym < num) {
            throw new RuntimeException("Error: it's not possible to generate a code with a length of " + num + " with " + possSym + " unique symbols.");
        }
        if (possSym > 36) {
            throw new RuntimeException("Error: maximum number of possible symbols in the code is 36 (0-9, a-z).");
        }
        if (possSym > 10) {
            System.out.println("The secret is prepared: " + listToString(Collections.nCopies(num, "*")) + " (0-9, a-" + possibles[possSym - 1] + ").");
        } else {
            System.out.println("The secret is prepared: " + listToString(Collections.nCopies(num, "*")) + " (0-" + possibles[possSym - 1] + ").");
        }
        System.out.println("Okay, let's start a game!");
        List<String> secretCode = generateSecretCode(num, possSym, possibles);
        int turn = 1;
        while (true) {
            System.out.println("Turn " + turn);
            List<String> tryPass = Arrays.stream(sc.next().split("")).collect(Collectors.toList());
            if (checkSecretCode(secretCode, tryPass)) {
                System.out.println("Congratulations! You guessed the secret code.");
                break;
            }
            turn++;
        }
    }

    private static List<String> generateSecretCode(int secretCodeLength, int possSym, String[] possibles) {
        List<String> list = new ArrayList<>();
        while (list.size() < secretCodeLength) {
            int rndNum = new Random().nextInt(possSym);
            if (!list.contains(possibles[rndNum])) {
                list.add(possibles[rndNum]);
            }
        }
        System.out.println(listToString(list));
        return list;
    }

    private static boolean checkSecretCode(List<String> password, List<String> tryPass) {
        boolean isWin = false;
        int bulls = 0;
        int cows = 0;
        for (int i = 0; i < tryPass.size(); i++) {
            int index = password.indexOf(tryPass.get(i));
            if (index == -1) {
                continue;
            }
            if (index == i && tryPass.get(i).equals(password.get(index))) {
                bulls++;
            } else if (tryPass.get(i).equals(password.get(index))) {
                cows++;
            }
        }
        if (bulls == password.size()) {
            isWin = true;
        }
        System.out.printf("%s", resultString(bulls, cows));
        return isWin;
    }

    private static String resultString(int bulls, int cows) {
        String res = "Grade: ";
        if (bulls == 0 && cows == 0) {
            res += "None.";
        }
        if (bulls > 0) {
            if (bulls > 1) {
                res += bulls + " bull(s)";
            } else {
                res += bulls + " bull";
            }
            res += cows > 0 ? " " : ".";
        }
        if (cows > 0) {
            if (bulls > 0) {
                res += " and ";
            }
            if (cows > 1) {
                res += cows + " cows.";
            } else {
                res += +cows + " cow.";
            }
        }
        return res + "\n";
    }

    private static String listToString(List list) {
        return Arrays.toString(list.toArray())
                .replace(", ", "")
                .replace("[", "")
                .replace("]", "");
    }
}
