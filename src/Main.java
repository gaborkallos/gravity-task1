import java.util.HashMap;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        DistanceCounter myDC = new DistanceCounter();
        String inputRoot = "src/sample_in_out/";
        String outputRoot = "src/output/";
        String inFileName = "sample_input_100_100.tsv";
        String outFileName = "output_100_100.txt";
        try {
            HashMap<Integer, List<String>> points = myDC.getHashMap(inputRoot + inFileName);
            myDC.writeTextFile(outputRoot+outFileName, myDC.getResult(points));
        } catch (Exception e) {
        System.err.format("Exception occurred trying to read '%s'.", inFileName);
            e.printStackTrace();
        }
    }
}
