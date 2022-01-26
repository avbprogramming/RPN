import java.util.ArrayList;
import java.util.Stack;
import java.lang.StringBuilder;

public class OPZ {

    public static void main(String[] args) {

        // String infix = "(( 5 + 4 / 4 ) * ( -100 + 12 ) * 2 )";
        String infix = "( 4.0 - x )";
        if (parsing(infix)) {
            if (checkInfix.checkInfix(infix.toCharArray())) {
                String postfix = convert(infix);
                System.out.println(postfix);

                ArrayList<String> s = calculationX.calculationX(postfix, 1.0, 10, 1.0);
                for (int i = 0; i < s.size(); i++) {
                    System.out.println("Ответ: " + s.get(i));
                }
            } else {
                String postfix = convert(infix);
                System.out.println(postfix);
                calculation str = new calculation();
                String[] postfixArray = postfix.split(" ");
                int result = str.calculation(postfixArray);
                System.out.println("Ответ: " + result);
            }
        } else {
            System.out.println("Слишком много скобок.");
            System.out.print(" " + parsing(infix));
        }
    }


    public static String convert(String expression) {
        StringBuilder sb = new StringBuilder();
        // Используем стек для отслеживания операций
        Stack<Character> op = new Stack<Character>();
        // приобразуем 2 и более пробелов в один пробел
        while (expression.indexOf("  ") >= 0) //2 пробела в кавычках
        {
            expression = expression.replace("  ", " "); //2 пробела в кавычках
            System.out.println(expression);
        }
        // Преобразование строки выражения в массив символов
        char[] chars = expression.toCharArray();
        int N = chars.length;
        for (int i = 0; i < N; i++) {
            char ch = chars[i];

            if (Character.isDigit(ch) || (ch == 'x')) {
                // Число, просто + к результату
                boolean flag = (i < chars.length), flag2 = true;
                if (flag == true) {
                    if (ch == 'x') {
                        sb.append(chars[i++]);
                    } else if (Character.isDigit(chars[i]) || (flag2 == true && ch == '.')) {
                        //  while (i < chars.length && (Character.isDigit(chars[i]) || Character.isLetter('x'))) {
                        while (flag) {
                            if (ch == '.')
                                if (flag2 == true)
                                {
                                    flag2 = false;
                                }
                                else {
                                    System.out.println("Ошибка 2 точки в одном числе.");
                                    flag = false;
                                    break;
                                }
                            sb.append(chars[i++]);
                            flag = (i < chars.length);
                            if (flag == true) flag = (Character.isDigit(chars[i]) || (flag2 == true && chars[i] == '.'));
                        }
                    }
                }
                // пробел в качестве разделителя
                sb.append(' ');
            } else if (ch == '(') {
                // Левая скобка, поместить в стек
                op.push(ch);
            } else if (ch == ')') {
                // Правая скобка, извлекайте и добавляйте к результату, пока не встретите левую скобку
                while (op.peek() != '(') {
                    sb.append(op.pop()).append(' ');
                }
                // Не забыть вытащить левую скобку
                op.pop();
            } else if (isOperator(ch)) {
                if ((ch == '-') && ((i == 0) || ((i - 1 > 0) && chars[i - 1] == '(') || (i - 2 > 0) && (chars[i - 1] == ' ') && (chars[i - 2] == '('))) {
                    // и если он унарный
                    sb.append(chars[i]);
                    i++;
                    while (Character.isDigit(chars[i]) || Character.isLetter('x')) {
                        sb.append(chars[i++]);
                    }
                    // пробел в качестве разделителя
                    sb.append(' ');
                } else {
                    // Оператор, сначала извлекаем все операторы с более высоким приоритетом, а затем помещаем их в стек
                    while (!op.isEmpty() && priority(op.peek()) >= priority(ch)) {
                        sb.append(op.pop()).append(' ');
                    }
                    op.push(ch);
                }
            }
        }
        // Вытаскиваем все, что осталось в стеке, и добавляем к результату
        while (!op.isEmpty()) {
            sb.append(op.pop()).append(' ');
        }
        return sb.toString();
    }


    // Проверка, является ли символ оператором
    private static boolean isOperator(char ch) {
        return ch == '^' || ch == '*' || ch == '/' || ch == '+' || ch == '-';
    }

    // Определение приоритета оператора
    private static int priority(char operator) {
        switch (operator) {
            case '^':
                return 3;
            case '*':
            case '/':
                return 2;
            case '+':
            case '-':
                return 1;
        }
        return 0;
    }


    // проверка кол-ва скобок
    public static boolean parsing(String str) {
        int check = 0;
        for (int i = 0; i < str.length(); i++) {
            if (check < 0) {
                return false;
            }
            String symbol = str.substring(i, i + 1);
            if (symbol.equals("(") || symbol.equals("{") || symbol.equals("[")) {
                check++;
                continue;
            }
            if (symbol.equals(")") || symbol.equals("}") || symbol.equals("]"))
                check--;
        }
        if (check == 0) {
            return true;
        } else {
            return false;
        }
    }
}







