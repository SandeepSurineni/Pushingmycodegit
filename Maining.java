import javax.xml.bind.DatatypeConverter;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Maining {

  public static void main(String[] args) {
    try {
      URL url = new URL ("http://54.86.241.117:8080/job/test/build"); // Jenkins URL localhost:8080, job named 'test'
      
      String user = "admin"; // username
      String pass = "6c8a86cd74ac4648a69e983a85f4f8f5"; // password or API token
      String authStr = user +":"+  pass;
      String encoding = DatatypeConverter.printBase64Binary(authStr.getBytes("utf-8"));

      HttpURLConnection connection = (HttpURLConnection) url.openConnection();
      connection.setRequestMethod("POST");
      connection.setDoOutput(true);
      connection.setRequestProperty("Authorization", "Basic " + encoding);
      InputStream content = connection.getInputStream();
      BufferedReader in   =
          new BufferedReader (new InputStreamReader (content));
      String line;
      while ((line = in.readLine()) != null) {
        System.out.println(line);
      }
    } catch(Exception e) {
      e.printStackTrace();
    }
  }
}
