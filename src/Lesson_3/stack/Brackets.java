package Lesson_3.stack;

public class Brackets {
    private final String text;

    public Brackets(String text) {
        this.text = text;
    }

    public void check() {
        Stack<Character> stack = new StackImpl<>(text.length());
        for (int i = 0; i < text.length(); i++) {
            char currentChar = text.charAt(i);
            checkCurrentChar(stack, i, currentChar);
        }

        if (!stack.isEmpty()) {
            System.out.println("Error: missing right delimiter");
        }
    }

    private void checkCurrentChar(Stack<Character> stack, int i, char currentChar) {
        switch (currentChar) {
            case '{':
            case '[':
            case '(':
                stack.push(currentChar);
                break;
            case '}':
            case ']':
            case ')':
                if (stack.isEmpty()) {
                    System.out.println("Error: " + currentChar + " at " + i);
                    break;
                }

                Character lastOpenedBracket = stack.pop();
                if (lastOpenedBracket == '{' && currentChar != '}' ||
                        lastOpenedBracket == '[' && currentChar != ']' ||
                        lastOpenedBracket == '(' && currentChar != ')') {
                    System.out.println("Error: " + currentChar + " at " + i);
                }
                break;
            default:
                break;
        }
    }

    public static void main(String[] args) {
        String text = "    public StackImpl(int maxSize) {        this.data = (E[]) new Object[maxSize];    }";
        new Brackets(text).check();
    }
}
