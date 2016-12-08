package calejo.preparateegel;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class SeleccionUniversidad extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seleccion_universidad);
    }

    public void menuUVM (View view){
        Intent intent = new Intent(this,Menu.class);
        startActivity(intent);
    }
    public void menuTEC (View view){
        Intent intent = new Intent(this,menuTec.class);
        startActivity(intent);
    }

    public void menuUVM2 (View view){
        Intent intent = new Intent(this,Menu_UVM_2.class);
        startActivity(intent);
    }
}
