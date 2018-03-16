import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.ProcessBuilder.Redirect;

public class ProcessBuildingTest {

    public static void main(String[] args) {
        try {
            ProcessBuilder builder = new ProcessBuilder(
                    "curl",
                    "-X",
                    "http://54.86.241.117:8080/job/test/build/token=xyz");

            
            Process process = builder.start();

            BufferedReader bufferedReader = new BufferedReader(
                    new InputStreamReader(process.getInputStream()));
            String line = "";
            String output = "";
            while ((line = bufferedReader.readLine()) != null) {
                output += line + "\n";
            }
            System.out.println(output);
            int exitValue = process.waitFor();
            System.out.println("\n\nExit Value is " + exitValue);
        } 


catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
