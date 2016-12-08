package calejo.preparateegel;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Menu_UVM_2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu__uvm_2);
    }

    public void abrirExamenRapido (View view){
        final Intent intent = new Intent(this,defuvm2rapido.class);
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
        final Intent intent = new Intent(this,defuvm2completo.class);
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
