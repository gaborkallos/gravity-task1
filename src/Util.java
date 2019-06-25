import sun.misc.FloatingDecimal;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Util {

    public List<String> readFile(String filename) {
        List<String> records = new ArrayList<String>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filename));
            String line;
            while ((line = reader.readLine()) != null) {
                records.add(line);
            }
            reader.close();
            return records;
        } catch (Exception e) {
            System.err.format("Exception occurred trying to read '%s'.", filename);
            e.printStackTrace();
            return null;
        }
    }

    public List<String> getCoordinateList(String line) {
        List<String> point = new ArrayList<>();
        Scanner s = new Scanner(line).useDelimiter("\t");
        for (Scanner it = s; it.hasNext(); ) {
            String coordinate = it.next();
            point.add(coordinate);
        }
        return point;
    }


    public HashMap<Integer, List<String>> getHashMap(String filename) {
        HashMap<Integer, List<String>> points = new HashMap<>();
        List<String> coordinates = readFile(filename);
        int i = 1;
        for (String point : coordinates) {
            List<String> temp = getCoordinateList(point);
            points.put(i, temp);
            i++;
        }
        return points;
    }

    public float distanceBetween(List<String> point1, List<String> point2) {
        float total = 0, diff;
        for (int i = 0; i < point1.size(); i++) {
            diff = Float.valueOf(point2.get(i)) - Float.valueOf(point1.get(i));
            total += diff * diff;
        }
        return (float) Math.sqrt(total);
    }

}
