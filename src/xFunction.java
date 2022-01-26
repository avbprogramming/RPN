import java.util.ArrayList;

public class xFunction {
    public static ArrayList<Double> xFunction(double min, double max, double step) {
        ArrayList<Double> arrayList = new ArrayList<>();
        for (double i = min; i <= max; i += step) {
            arrayList.add(i);
        }
        if (arrayList.get(arrayList.size() - 1) < max) {
            arrayList.add(max);
        }
        return arrayList;
    }
}