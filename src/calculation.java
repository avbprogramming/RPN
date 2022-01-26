import java.util.*;

// https://habr.com/ru/post/337558/
public class calculation {
    public static int calculation(String[] tokens) {
        // Инициализируем стек и переменную
        Stack<String> stack = new Stack<>();
        int x, y;
        String result;
        String choice;
        int value;
        String p = "";
        // Перебор каждого символа в массиве строки
        for (String token : tokens) {
            // Если символ не является специальным символом ('+', '-', '*', '/'), то поместите символ в стек
            if (!Objects.equals(token, "+") && !Objects.equals(token, "-")
                    && !Objects.equals(token, "*") && !Objects.equals(token, "/")) {
                stack.push(token);
                continue;
            } else {
                // иначе, если символ является специальным символом, используйте switch для выполнения действия
                choice = token;
            }
            switch (choice) {
                case "-":
                    // Выполнение операции «-», извлекая первые два символа, а затем снова сохраняя их обратно в стек
                    x = Integer.parseInt(stack.pop());
                    y = Integer.parseInt(stack.pop());
                    value = y - x;
                    result = p + value;
                    stack.push(result);
                    break;

                case "+":
                    // Выполнение операции «+», извлекая первые два символа, а затем снова сохраняя их обратно в стек
                    x = Integer.parseInt(stack.pop());
                    y = Integer.parseInt(stack.pop());
                    value = x + y;
                    result = p + value;
                    stack.push(result);
                    break;
                case "*":
                    // Выполнение операции «*», извлекая первые два символа, а затем снова сохраняя их обратно в стек
                    x = Integer.parseInt(stack.pop());
                    y = Integer.parseInt(stack.pop());
                    value = x * y;
                    result = p + value;
                    stack.push(result);
                    break;
                case "/":
                    // Выполнение операции «/», извлекая первые два символа, а затем снова сохраняя их обратно в стек
                    x = Integer.parseInt(stack.pop());
                    y = Integer.parseInt(stack.pop());
                    value = y / x;
                    result = p + value;
                    stack.push(result);
                    break;

                default:
            }
        }
        // Метод преобразования строки в целое число
        return Integer.parseInt(stack.pop());
    }
}