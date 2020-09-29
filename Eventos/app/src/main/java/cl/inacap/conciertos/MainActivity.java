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
    private Spinner ;
    private Spinner ;
    private ListView eventosLv;
    private List<Evento> eventos = new ArrayList<>();
    private ArrayAdapter <Evento> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.nombreTxt = findViewById(R.id.nombreTxt);
        this.valorTxt = findViewById(R.id.valorTxt);
        this.registrarBtn = findViewById(R.id.registrarBtn);
        this.eventosLv = findViewById(R.id.eventosLv);
        this.adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, eventos);
        this.eventosLv.setAdapter(adapter);

        this.registrarBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                List<String> errores = new ArrayList<>();
                String nombreTxt = null;
                String vlr = valorTxt.getText().toString().trim();
                int valor = 0;

                try {
                    if (editText.getText().toString().isEmpty())
                    nombreTxt = editText.getText().toString();
                }catch (Exception ex){
                    errores.add("Debe ingresar el nombre del artista");
                }
                try {
                    valor = Integer.parseInt(vlr);
                    if (valor < 0 ){
                        throw new NumberFormatException();
                    }
                }catch (NumberFormatException ex){
                    errores.add("el valor de la entrada debe ser mayor a 0");
                }
                if(errores.isEmpty()){

                }else{
                    mostrarErrores(errores);
                }

            }
        });
    }
}