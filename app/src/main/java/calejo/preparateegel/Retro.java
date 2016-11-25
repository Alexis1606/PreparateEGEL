package calejo.preparateegel;

import android.content.Context;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import cz.msebera.android.httpclient.HttpEntity;
import cz.msebera.android.httpclient.HttpResponse;
import cz.msebera.android.httpclient.NameValuePair;
import cz.msebera.android.httpclient.client.ClientProtocolException;
import cz.msebera.android.httpclient.client.HttpClient;
import cz.msebera.android.httpclient.client.entity.UrlEncodedFormEntity;
import cz.msebera.android.httpclient.client.methods.HttpPost;
import cz.msebera.android.httpclient.impl.client.DefaultHttpClient;
import cz.msebera.android.httpclient.message.BasicNameValuePair;

public class Retro extends AppCompatActivity {

    EditText editTextComentario;
    ImageButton Feliz, Serio, Triste, General;
    String Comentario;
    String Calificacion;
    Button buttonSubmit ;

    String DataParseUrl = " ";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retro);

        editTextComentario = (EditText)findViewById(R.id.Comentario);

        buttonSubmit = (Button)findViewById(R.id.button2);
        Feliz = (ImageButton)findViewById(R.id.Feliz);
        Serio = (ImageButton)findViewById(R.id.Serio);
        Triste = (ImageButton)findViewById(R.id.Triste);


        buttonSubmit.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

                Comentario = GetDataFromEditText();

                SendDataToServer(Comentario);

            }
        });

    }

    public String GetDataFromEditText(){

        return Comentario = editTextComentario.getText().toString();
    }

    public void SendDataToServer(final String name) {
        class SendPostReqAsyncTask extends AsyncTask<String, Void, String> {
            @Override
            protected String doInBackground(String... params) {

                String QuickName = name;

                List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();

                nameValuePairs.add(new BasicNameValuePair("name", QuickName));



                String DataParseUrl = "http://ec2-54-86-71-49.compute-1.amazonaws.com/Pipes.php?sql=insert%20into%20Feedback%20(comentario,calificacion)%20values(%27" + QuickName + "%27,5);&server=alexis.c2g7lahthau8.us-east-1.rds.amazonaws.com&user=preparate&password=Pr3p4r4t3!&dataBase=preparate";


                try {
                    HttpClient httpClient = new DefaultHttpClient();

                    HttpPost httpPost = new HttpPost(DataParseUrl);

                    httpPost.setEntity(new UrlEncodedFormEntity(nameValuePairs));

                    HttpResponse response = httpClient.execute(httpPost);

                    HttpEntity entity = response.getEntity();


                } catch (ClientProtocolException e) {

                } catch (IOException e) {

                }
                return "Data Submit Successfully";
            }

            @Override
            protected void onPostExecute(String result) {
                super.onPostExecute(result);

                Toast.makeText(Retro.this, "Data Submit Successfully", Toast.LENGTH_LONG).show();

            }
        }
        SendPostReqAsyncTask sendPostReqAsyncTask = new SendPostReqAsyncTask();
        sendPostReqAsyncTask.execute(name);
    }

}