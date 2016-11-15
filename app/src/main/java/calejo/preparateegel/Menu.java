package calejo.preparateegel;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Menu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }


    public void abrirExamenRapido (View view){
        Intent intent = new Intent(this,ExamenRapido.class);
        startActivity(intent);
    }

    public void abrirExamenCompleto (View view){
        Intent intent = new Intent(this,ExamenCompleto.class);
        startActivity(intent);
    }
    public void abrirConfiguracion (View view){
        Intent intent = new Intent(this,Config.class);
        startActivity(intent);
    }
    public void abrirFeedback (View view){
        Intent intent = new Intent(this,Retro.class);
        startActivity(intent);
    }

}
