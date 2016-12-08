package calejo.preparateegel;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class ConfigScroll extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_config_scroll);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


    }

    public void Cambio (View view){
        Intent intent = new Intent(this,SeleccionUniversidad.class);
        startActivity(intent);
    }

    public void Acerca (View view){
        Intent intent = new Intent(this,Acerca.class);
        startActivity(intent);
    }
}
