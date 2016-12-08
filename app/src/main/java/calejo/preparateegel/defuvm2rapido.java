package calejo.preparateegel;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;

public class defuvm2rapido extends AppCompatActivity {
    String rCorrecta;
    int cont = 0;
    PreguntasWebService pregunta;
    RadioButton rR1;
    RadioButton rR2;
    RadioButton rR3;
    RadioButton rR4;
    RadioButton rR5;
    int contadorCorrecto = 0;
    int contadorIncorrecto = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_defuvm2rapido);
        pregunta = new PreguntasWebService();
        pregunta.obtenerPregunta();
        this.setTextInicio(pregunta);
        rCorrecta = pregunta.respuesta_correcta;
    }

    void setTextInicio(PreguntasWebService pregunta) {
        String preguntaA = pregunta.preguntaM;
        if (preguntaA == null || preguntaA.equals("")) {
            Intent intent = new Intent(this, defuvm2rapido.class);
            startActivity(intent);

        }
        String r1 = pregunta.respuesta1;
        String r2 = pregunta.respuesta2;
        String r3 = pregunta.respuesta3;
        String r4 = pregunta.respuesta4;
        TextView tPregunta = (TextView) findViewById(R.id.tPregunta);
        RadioButton rR1 = (RadioButton) findViewById(R.id.rR1);
        RadioButton rR2 = (RadioButton) findViewById(R.id.rR2);
        RadioButton rR3 = (RadioButton) findViewById(R.id.rR3);
        RadioButton rR4 = (RadioButton) findViewById(R.id.rR4);
        RadioButton rR5 = (RadioButton) findViewById(R.id.rR5);
        tPregunta.setText(preguntaA);
        rR1.setText(r1);
        rR2.setText(r2);
        rR3.setText(r3);
        rR4.setText(r4);
    }

    void setText(PreguntasWebService pregunta) {
        String preguntaA = pregunta.preguntaM;
        String r1 = pregunta.respuesta1;
        String r2 = pregunta.respuesta2;
        String r3 = pregunta.respuesta3;
        String r4 = pregunta.respuesta4;
        TextView tPregunta = (TextView) findViewById(R.id.tPregunta);
        rR1 = (RadioButton) findViewById(R.id.rR1);
        rR2 = (RadioButton) findViewById(R.id.rR2);
        rR3 = (RadioButton) findViewById(R.id.rR3);
        rR4 = (RadioButton) findViewById(R.id.rR4);
        rR5 = (RadioButton) findViewById(R.id.rR5);
        tPregunta.setText(preguntaA);
        rR1.setText(r1);
        rR2.setText(r2);
        rR3.setText(r3);
        rR4.setText(r4);
    }

    public void salir() {
        Intent intent = new Intent(this, Menu_UVM_2.class);
        startActivity(intent);
    }

    public void siguiente(View view) throws InterruptedException {
        if (cont < 10) {

            this.setText(pregunta);
            if ((rR1.isChecked() && rCorrecta.equals("a")) || (rR2.isChecked() && rCorrecta.equals("b")) || (rR3.isChecked() && rCorrecta.equals("c")) || (rR4.isChecked() && rCorrecta.equals("d"))) {
                AlertDialog.Builder dlgAlert = new AlertDialog.Builder(this);
                dlgAlert.setMessage("Respuesta Correcta");
                dlgAlert.setTitle("Preparate EGEL");
                dlgAlert.setPositiveButton("OK", null);
                dlgAlert.setCancelable(true);
                dlgAlert.create().show();
                contadorCorrecto++;
                desseleccionar();
            } else {
                AlertDialog.Builder dlgAlert = new AlertDialog.Builder(this);
                switch (rCorrecta) {
                    case "a":
                        dlgAlert.setMessage("Respuesta Incorrecta\nRespuesta correcta: " + pregunta.respuesta1);
                        break;
                    case "b":
                        dlgAlert.setMessage("Respuesta Incorrecta\nRespuesta correcta: " + pregunta.respuesta2);
                        break;
                    case "c":
                        dlgAlert.setMessage("Respuesta Incorrecta\nRespuesta correcta: " + pregunta.respuesta3);
                        break;
                    case "d":
                        dlgAlert.setMessage("Respuesta Incorrecta\nRespuesta correcta: " + pregunta.respuesta4);
                        break;
                }
                //dlgAlert.setMessage("Respuesta Incorrecta\nRespuesta correcta: "+rCorrecta);
                dlgAlert.setTitle("Preparate EGEL");
                dlgAlert.setPositiveButton("OK", null);
                dlgAlert.setCancelable(true);
                dlgAlert.create().show();
                contadorIncorrecto++;
                desseleccionar();


            }
            pregunta = new PreguntasWebService();
            pregunta.obtenerPregunta();
            this.setText(pregunta);
            rCorrecta = pregunta.respuesta_correcta;
            cont++;
        } else {
            // Intent intent = new Intent(this,ExamenRapido.class);
            //startActivity(intent);
            AlertDialog.Builder Respuesta = new AlertDialog.Builder(this);
            Respuesta.setMessage("Respuestas correctas: " + contadorCorrecto);
            Respuesta.setTitle("Preparate EGEL");
            // Respuesta.setPositiveButton("OK", null );
            Respuesta.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
                    salir();
                }
            });
            Respuesta.setCancelable(true);
            Respuesta.create().show();
        }

    }

    public void desseleccionar() {

        /*
        rR1.setChecked(false);
        rR2.setChecked(false);
        rR3.setChecked(false);
        rR4.setChecked(false);
        */
        rR5.setVisibility(View.VISIBLE);
        rR5.setChecked(true);
       /* rR1.setSelected(false);
        rR2.setSelected(false);
        rR3.setSelected(false);
        rR4.setSelected(false);
        */
        rR5.setSelected(true);

        rR5.setVisibility(View.INVISIBLE);
    }
}



