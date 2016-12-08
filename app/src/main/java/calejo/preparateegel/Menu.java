package calejo.preparateegel;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

public class Menu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_menu);
    }


    public void abrirExamenRapido (View view){
        final Intent intent = new Intent(this,examen_scroll_uvm.class);
        AlertDialog.Builder Respuesta  = new AlertDialog.Builder(this);
        Respuesta.setMessage("Este modo incluye 10 preguntas a contestar");
        Respuesta.setTitle("Examen Rápido");
        Respuesta.setPositiveButton("EMPEZAR",new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                startActivity(intent);
            }
        });
        Respuesta.setNegativeButton("Cancelar",null);
        Respuesta.setCancelable(true);
        Respuesta.create().show();
        //startActivity(intent);
    }

    public void abrirExamenCompleto (View view){
        final Intent intent = new Intent(this,examenCompletoScroll.class);
        AlertDialog.Builder Respuesta  = new AlertDialog.Builder(this);
        Respuesta.setMessage("Este modo incluye 70 preguntas a contestar");
        Respuesta.setTitle("Examen Completo");
        Respuesta.setPositiveButton("EMPEZAR",new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                startActivity(intent);
            }
        });
        Respuesta.setNegativeButton("Cancelar",null);
        Respuesta.setCancelable(true);
        Respuesta.create().show();
        //startActivity(intent);
    }
    public void abrirConfiguracion (View view){
        Intent intent = new Intent(this,ConfigScroll.class);
        startActivity(intent);
    }
    public void abrirFeedback (View view){
        Intent intent = new Intent(this,Retro.class);
        startActivity(intent);
    }

}
