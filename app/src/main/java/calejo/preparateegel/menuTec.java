package calejo.preparateegel;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class menuTec extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_tec);
    }

    public void abrirExamenRapido (View view){
        Intent intent = new Intent(this,tec_rapido_scroll.class);
        startActivity(intent);
    }

    public void abrirExamenCompleto (View view){
        Intent intent = new Intent(this,tec_Completo_Scroll.class);
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
