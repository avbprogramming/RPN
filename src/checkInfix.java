
public class checkInfix {
    public static boolean checkInfix(char[] chars) {
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == 'x') {
                return true;
            }
        } return false;
    }
}