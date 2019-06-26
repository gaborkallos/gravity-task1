import sun.misc.FloatingDecimal;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class DistanceCounter {

    private List<String> readFile(String filename) {
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
    public void writeTextFile(String filename, HashMap<Integer, List<String>> result){
        try (FileWriter writer = new FileWriter(filename);
             BufferedWriter bw = new BufferedWriter(writer)) {

            for (Integer key : result.keySet()) {
                bw.write(key + ":" + Math.round(Float.valueOf(result.get(key).get(0))) +
                        "\t" + Math.round(Float.valueOf(result.get(key).get(1))) + "\n");
            }

        } catch (Exception e) {
            System.err.format("Exception: %s%n", e);
        }

    }

    private List<String> getCoordinateList(String line) {
        List<String> point = new ArrayList<>();
        Scanner s = new Scanner(line).useDelimiter("\t");
        for (Scanner it = s; it.hasNext(); ) {
            String coordinate = it.next();
            point.add(coordinate);
        }
        return point;
    }


    HashMap<Integer, List<String>> getHashMap(String filename) {
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

    private float distanceBetween(List<String> point1, List<String> point2) {
        float total = 0, diff;
        for (int i = 0; i < point1.size(); i++) {
            diff = Float.valueOf(point2.get(i)) - Float.valueOf(point1.get(i));
            total += diff * diff;
        }
        return (float) Math.sqrt(total);
    }

    HashMap getResult(HashMap<Integer, List<String>> points) {
        float minimumDistance = distanceBetween(points.get(1), points.get(2));
        int point1 = 0;
        int point2 = 0;
        HashMap<Integer, List<String>> result = new HashMap<>();
        for (int i = 1; i < points.size() + 1; i++) {
            for (int j = i + 1; j < points.size() + 1; j++) {
                if (distanceBetween(points.get(i), points.get(j)) < minimumDistance) {
                    minimumDistance = distanceBetween(points.get(i), points.get(j));
                    point1 = i;
                    point2 = j;
                }
            }
        }
        result.put(point1, points.get(point1));
        result.put(point2, points.get(point2));
        return result;
    }


}
