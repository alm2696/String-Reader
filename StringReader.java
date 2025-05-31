import java.util.Scanner;
import java.util.Stack;

public class StringReader {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string with a ':' separator: ");
        String inputStr = scanner.nextLine();
        System.out.println(checkString(inputStr));
        scanner.close();
    }

    public static char checkString(String inputStr) {
        if (!inputStr.contains(":")) {
            return 'N';
        }
        String[] parts = inputStr.split(":");
        Stack<Character> stack = new Stack<>();
        for (char c : parts[0].toCharArray()) {
            stack.push(c);
        }
        int index = 0;
        while (!stack.isEmpty()) {
            if (index >= parts[1].length()) {
                return 'L';
            }
            if (stack.pop() != parts[1].charAt(index)) {
                return 'N';
            }
            index++;
        }
        if (index < parts[1].length()) {
            return 'R';
        }
        return 'E';
    }
}