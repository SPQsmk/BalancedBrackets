import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

public class Brackets {
    public static void main(String[] args) {
        HashMap<Character, Character> brackets = new HashMap<>();
        brackets.put('}', '{');
        brackets.put(']', '[');
        brackets.put(')', '(');

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        if (!isCorrect(input, brackets)) {
            System.out.println("Not ok");
        } else {
            System.out.println("Ok");
        }
    }

    public static boolean isCorrect(String input, Map<Character, Character> brackets) {
        Stack<Character> stack = new Stack<>();

        for (char c : input.toCharArray()) {
            if (brackets.containsValue(c))
                stack.push(c);
            else if (brackets.containsKey(c))
                if (stack.isEmpty() || !(brackets.get(c) == stack.pop())) {
                    return false;
                }
        }

        return stack.isEmpty();
    }
}