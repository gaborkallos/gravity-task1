import java.util.HashMap;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        DistanceCounter myDC = new DistanceCounter();
        HashMap<Integer, List<String>> points = myDC.getHashMap("src/sample_in_out/sample_input_2_8.tsv");
        myDC.writeTextFile("output_2_8.txt", myDC.getResult(points));

    }

}
