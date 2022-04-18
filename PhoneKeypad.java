import java.util.ArrayList;
import java.util.List;

// problem: https://leetcode.com/problems/letter-combinations-of-a-phone-number/

public class PhoneKeypad {
    public static void main(String[] args) {
        System.out.println(letterCombinations(""));
        System.out.println(letterCombinations("23"));
    }

    public static List<String> letterCombinations(String digits) {
        if (digits.equals("")) {
            return new ArrayList<String>();
        }
        String[] map = { " ", " ", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" }; // space for 0,1 and trim
                                                                                               // at 29 for single digit
                                                                                               // case
        int number = Integer.parseInt(digits);
        if (number < 10) {
            return keypad(number, 0, map);
        }
        return keypad(number / 10, number % 10, map);
    }

    private static List<String> keypad(int num1, int num2, String[] map) {
        if (num1 > 9) {
            List<String> list = keypad(num1 / 10, num1 % 10, map); // break until reach base
            List<String> bigSubset = new ArrayList<>(); // add on each subset "list"
            for (String elem : list) {
                for (Character c : map[num2].toCharArray()) {
                    bigSubset.add(elem + c.toString());
                }
            }
            return bigSubset;
        } else { // base case, from where code will go up
            List<String> subset = new ArrayList<>();
            for (Character e : map[num1].toCharArray()) {
                for (Character f : map[num2].toCharArray()) {
                    subset.add(e.toString().trim() + f.toString().trim());
                }
            }
            return subset;
        }
    }
}
