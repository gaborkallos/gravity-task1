import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TestDistanceCounter {

    public DistanceCounter dc = new DistanceCounter();

    private String inputFile = "sample_input_10_100.tsv";
    private String exceptedOutputFile = "sample_output_10_100.txt";
    private String actualOutputFile = "output_10_100.txt";

    @Test
    void FileNotFoundTest() {
        assertThrows(Exception.class, () -> {
            dc.readFile("../src/sample_in_out/" + inputFile);
            System.out.println("Test - Read File: Failure!");
        });
        System.out.println("Test - Read File : Passed!");
    }

    @Test
    void getResult(){
        try {
            assertEquals(dc.getHashMap("src/sample_in_out/" + exceptedOutputFile),
                    dc.getHashMap("src/output/" + actualOutputFile),
                    "Test FAILED! Actual and excepted are not equals");
            System.out.println("Test - Excepted - Actual : Passed!");
        }catch (Exception e){
            System.out.println(e);
        }

    }
}
