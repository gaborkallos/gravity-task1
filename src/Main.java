import java.util.HashMap;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        Util myUtil = new Util();
        HashMap<Integer, List<String>> points = myUtil.getHashMap("src/sample_in_out/sample_input_2_8.tsv");
        float minimumDistance = myUtil.distanceBetween(points.get(1), points.get(2));
        int point1 = 0;
        int point2 = 0;
        for (int i = 1; i < points.size() + 1; i++) {
            for (int j = i + 1; j < points.size() + 1; j++) {
                if (myUtil.distanceBetween(points.get(i), points.get(j)) < minimumDistance) {
                    minimumDistance = myUtil.distanceBetween(points.get(i), points.get(j));
                    point1 = i;
                    point2 = j;
                }
            }
        }

        System.out.println(point1 + ": " + points.get(point1));
        System.out.println(point2 + ": " + points.get(point2));
    }

}
