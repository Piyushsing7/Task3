import java.util.HashMap;
import java.util.Scanner;

public class AnagramCheck {
    public static boolean areAnagrams(String str1, String str2) {
        // Remove spaces and convert to lowercase for uniform comparison
        str1 = str1.replaceAll("\\s", "").toLowerCase();
        str2 = str2.replaceAll("\\s", "").toLowerCase();
        
        // If lengths are not equal, they cannot be anagrams
        if (str1.length() != str2.length()) {
            return false;
        }
        
        // Use a hashmap to count character frequencies
        HashMap<Character, Integer> charCount = new HashMap<>();
        
        for (char c : str1.toCharArray()) {
            charCount.put(c, charCount.getOrDefault(c, 0) + 1);
        }
        
        for (char c : str2.toCharArray()) {
            if (!charCount.containsKey(c) || charCount.get(c) == 0) {
                return false;
            }
            charCount.put(c, charCount.get(c) - 1);
        }
        
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter first string: ");
        String str1 = scanner.nextLine();
        
        System.out.print("Enter second string: ");
        String str2 = scanner.nextLine();
        
        if (areAnagrams(str1, str2)) {
            System.out.println("True");
        } else {
            System.out.println("False");
        }
        
        scanner.close();
    }
}
