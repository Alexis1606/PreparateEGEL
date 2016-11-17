package calejo.preparateegel;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;

import static calejo.preparateegel.PreguntasWebService.pregunta;

public class ExamenRapido extends AppCompatActivity {
    String rCorrecta;
    PreguntasWebService pregunta;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_examen_rapido);

        pregunta = new PreguntasWebService();
        pregunta.obtenerPregunta();
        this.setTextInicio(pregunta);
        rCorrecta = pregunta.respuesta_correcta;
    }

    void setTextInicio(PreguntasWebService pregunta){
        String preguntaA = pregunta.preguntaM;
        if (preguntaA == null || preguntaA.equals("")) {
            Intent intent = new Intent(this,ExamenRapido.class);
            startActivity(intent);

        }
        String r1 = pregunta.respuesta1;
        String r2 = pregunta.respuesta2;
        String r3 = pregunta.respuesta3;
        String r4 = pregunta.respuesta4;
        TextView tPregunta =  (TextView)findViewById(R.id.tPregunta);
        RadioButton rR1 = (RadioButton)findViewById(R.id.rR1);
        RadioButton rR2 = (RadioButton)findViewById(R.id.rR2);
        RadioButton rR3 = (RadioButton)findViewById(R.id.rR3);
        RadioButton rR4 = (RadioButton)findViewById(R.id.rR4);
        tPregunta.setText(preguntaA);
        rR1.setText(r1);
        rR2.setText(r2);
        rR3.setText(r3);
        rR4.setText(r4);
    }

    void setText(PreguntasWebService pregunta){
        String preguntaA = pregunta.preguntaM;
        String r1 = pregunta.respuesta1;
        String r2 = pregunta.respuesta2;
        String r3 = pregunta.respuesta3;
        String r4 = pregunta.respuesta4;
        TextView tPregunta =  (TextView)findViewById(R.id.tPregunta);
        RadioButton rR1 = (RadioButton)findViewById(R.id.rR1);
        RadioButton rR2 = (RadioButton)findViewById(R.id.rR2);
        RadioButton rR3 = (RadioButton)findViewById(R.id.rR3);
        RadioButton rR4 = (RadioButton)findViewById(R.id.rR4);
        tPregunta.setText(preguntaA);
        rR1.setText(r1);
        rR2.setText(r2);
        rR3.setText(r3);
        rR4.setText(r4);
    }

    public void siguiente(View view){
        pregunta = new PreguntasWebService();
        pregunta.obtenerPregunta();
        this.setText(pregunta);
        rCorrecta = pregunta.respuesta_correcta;

    }
}
