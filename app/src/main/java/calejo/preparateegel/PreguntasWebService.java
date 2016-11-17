package calejo.preparateegel;

import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

/**
 * Created by CarlitosJr1 on 17/11/16.
 */

public class PreguntasWebService {

    static String pregunta = "";

    public static class StringTokenizerExample {
        public static void main(String args[]) { // creating TestStringTokenizer
            // object.
            JavaHttpUrlConnectionReader();
            PreguntasWebService obj = new PreguntasWebService();
            // method call
            obj.displayTokens();

        }

    }

    StringTokenizer str = new StringTokenizer(pregunta, "|");

    public void displayTokens() {
        while (str.hasMoreTokens()) {
            System.out.println(str.nextToken());
        }
    }

    public static void JavaHttpUrlConnectionReader() {
        try {
            String myUrl = "http://ec2-54-86-71-49.compute-1.amazonaws.com/Pipes.php?sql=SELECT%20*%20FROM%20preguntas%20order%20by%20rand()%20limit%201;&server=alexis.c2g7lahthau8.us-east-1.rds.amazonaws.com&user=preparate&password=Pr3p4r4t3!&dataBase=preparate";
            // if your url can contain weird characters you will want to
            // encode it here, something like this:
            // myUrl = URLEncoder.encode(myUrl, "UTF-8");

            pregunta = doHttpUrlConnectionAction(myUrl);
            System.out.println(pregunta);
        } catch (Exception e) {
        }
    }

    private static String doHttpUrlConnectionAction(String desiredUrl) throws Exception {
        URL url = null;
        BufferedReader reader = null;
        StringBuilder stringBuilder;

        try {
            // create the HttpURLConnection
            url = new URL(desiredUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            // just want to do an HTTP GET here
            connection.setRequestMethod("GET");

            // uncomment this if you want to write output to this url
            // connection.setDoOutput(true);

            // give it 15 seconds to respond
            connection.setReadTimeout(15 * 1000);
            connection.connect();

            // read the output from the server
            reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            stringBuilder = new StringBuilder();

            String line = null;
            while ((line = reader.readLine()) != null) {
                stringBuilder.append(line + "\n");
            }
            return stringBuilder.toString();
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        } finally {
            // close the reader; this can throw an exception too, so
            // wrap it in another try/catch block.
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException ioe) {
                    ioe.printStackTrace();
                }
            }
        }
    }

}
