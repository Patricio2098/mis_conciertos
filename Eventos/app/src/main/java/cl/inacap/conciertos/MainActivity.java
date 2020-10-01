package cl.inacap.conciertos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

import cl.inacap.conciertos.dto.Evento;

public class MainActivity extends AppCompatActivity {

    private EditText nombreTxt;
    private EditText valorTxt;
    private Button registrarBtn;
    private Spinner estilo;
    private Spinner valoracion;
    private ListView eventosLv;
    private List<Evento> eventos = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.nombreTxt = findViewById(R.id.nombreTxt);
        this.valorTxt = findViewById(R.id.valorTxt);
        this.registrarBtn = findViewById(R.id.registrarBtn);
        this.eventosLv = findViewById(R.id.eventosLv);
        this.estilo = (Spinner) findViewById(R.id.idestilo);
        this.valoracion = (Spinner) findViewById(R.id.idvaloracion);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.categorias, android.R.layout.simple_spinner_item);

        estilo.setAdapter(adapter);

        
        this.registrarBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
}