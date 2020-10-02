package cl.inacap.conciertos;

import android.app.DatePickerDialog;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import cl.inacap.conciertos.adapters.EventosArrayAdapter;
import cl.inacap.conciertos.dao.EventosDAO;
import cl.inacap.conciertos.dao.EventosDAOLista;
import cl.inacap.conciertos.dto.Evento;

public class MainActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {

    private EditText nombreTxt;
    private EditText valorTxt;
    private Button registrarBtn;
    private Spinner genero;
    private Spinner clasificacion;
    private EditText fecha;
    private ListView eventosLv;
    private List<Evento> eventos;
    private EventosArrayAdapter adpt;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        adpt = new EventosArrayAdapter(this, R.layout.eventos_list, eventos);
        eventosLv = findViewById(R.id.eventosLv);
        eventosLv.setAdapter(adpt);

        this.nombreTxt = findViewById(R.id.nombreTxt);
        this.valorTxt = findViewById(R.id.valorTxt);
        this.registrarBtn = findViewById(R.id.registrarBtn);

        this.genero = (Spinner) findViewById(R.id.idestilo);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.categorias, android.R.layout.simple_spinner_item);

        genero.setAdapter(adapter);

        this.clasificacion = findViewById(R.id.idvaloracion);

        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(this, R.array.clasificacion, android.R.layout.simple_spinner_item);
        clasificacion.setAdapter(adapter1);

        this.registrarBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                List <String> errores = new ArrayList<>();

                try{
                    String nombre = nombreTxt.toString().trim();
                    String valor = valorTxt.getText().toString().trim();
                    String gen = genero.toString().trim();
                    String val = clasificacion.toString().trim();
                    int vlr = 0;

                    if (gen.isEmpty()){
                        errores.add("debe indicar el genero");
                    }
                    if (val.isEmpty()){
                        errores.add("debe indicar la valoracion");
                    }
                    try{
                        vlr = Integer.parseInt(valor);
                        if(vlr <= 0){
                            throw new NumberFormatException();
                        }
                    }catch (NumberFormatException ex){
                        errores.add("El valor de la entrada debe ser mayor a 0");
                    }

                    if(errores.isEmpty()) {
                        if (nombre.isEmpty()){
                            errores.add("Debe Ingresar el nombre");
                        }
                        Evento e = new Evento();
                        e.setNombreartista(nombre);
                        e.setGenero(gen);
                        e.setValor(vlr);
                        e.setCalificacion(val);
                        eventos.add(e);
                        Toast.makeText(getApplicationContext(), "Se a generado el evento con exito", Toast.LENGTH_SHORT).show();
                    }

                }catch (Exception ex){
                    Toast.makeText(getApplicationContext(), "A ocurrido un error", Toast.LENGTH_SHORT).show();
                }
            }
        });

        this.fecha = (EditText) findViewById(R.id.idcalendario);
        this.fecha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DialogFragment dateFragment = new DatePickerFragment();
                dateFragment.show(getSupportFragmentManager(), "date picker");
            }

        });

    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        Calendar c = Calendar.getInstance();
        c.set(Calendar.YEAR, year);
        c.set(Calendar.MONTH, month);
        c.set(Calendar.DAY_OF_MONTH, dayOfMonth);
        String currentDateString = DateFormat.getDateInstance(SimpleDateFormat.SHORT).format(c.getTime());

        EditText editText = (EditText) findViewById(R.id.idcalendario);
        editText.setText(currentDateString);

    }


}