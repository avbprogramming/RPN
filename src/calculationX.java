import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;
import java.util.Stack;


// https://stackoverflow.com/questions/42519055/java-using-try-catch-exception-to-check-if-user-input-is-double

public class calculationX {
    public static ArrayList<String> calculationX(String postfix, double min, double max, double step) {
        ArrayList<Double> arrayList = xFunction.xFunction(min, max, step);
        ArrayList<String> returnA = new ArrayList<>();
        String returnCalculation = null;
        String returnCalculationX = null;
        String[] splitString = postfix.split(" ");
        String sX, sY;
        System.out.println(Arrays.toString(splitString));
        for (int i = 0; i < arrayList.size(); i++) {
            Stack<String> stack = new Stack<>();
            double x, y, value;
            String result, choice;
            String p = "";
            // Перебор каждого символа в массиве строки
            for (String token : splitString) {
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
                        sX = stack.pop();
                        if (sX.equals("x")) {
                            x = arrayList.get(i);
                        }
                        else
                            x = Double.parseDouble(sX);
                        sY = stack.pop();
                        if (sY.equals("x")) {
                            y = arrayList.get(i);
                        }
                        else
                            y = Double.parseDouble(sY);
                        value = y - x;
                        result = p + value;
                        stack.push(result);
                        break;

                    case "+":
                        // Выполнение операции «+», извлекая первые два символа, а затем снова сохраняя их обратно в стек
                        sX = stack.pop();
                        if (sX.equals("x")) {
                            x = arrayList.get(i);
                        }
                        else
                            x = Double.parseDouble(sX);
                        sY = stack.pop();
                        if (sY.equals("x")) {
                            y = arrayList.get(i);
                        }
                        else
                            y = Double.parseDouble(sY);
                        value = x + y;
                        result = p + value;
                        stack.push(result);
                        break;
                    case "*":
                        // Выполнение операции «*», извлекая первые два символа, а затем снова сохраняя их обратно в стек
                        sX = stack.pop();
                        if (sX.equals("x")) {
                            x = arrayList.get(i);
                        }
                        else
                            x = Double.parseDouble(sX);
                        sY = stack.pop();
                        if (sY.equals("x")) {
                            y = arrayList.get(i);
                        }
                        else
                            y = Double.parseDouble(sY);
                        value = x * y;
                        result = p + value;
                        stack.push(result);
                        break;
                    case "/":
                        // Выполнение операции «/», извлекая первые два символа, а затем снова сохраняя их обратно в стек
                        sX = stack.pop();
                        if (sX.equals("x")) {
                            x = arrayList.get(i);
                        }
                        else
                            x = Double.parseDouble(sX);
                        sY = stack.pop();
                        if (sY.equals("x")) {
                            y = arrayList.get(i);
                        }
                        else
                            y = Double.parseDouble(sY);
                        value = y / x;
                        result = p + value;
                        stack.push(result);
                        break;
                    default:
                }
            }
            // Метод преобразования строки в целое число
            returnCalculation = String.valueOf(Double.parseDouble(stack.pop()));
            returnA.add(returnCalculation);
        }
        return returnA;
    }
}
