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

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import cl.inacap.conciertos.dao.EventosDAO;
import cl.inacap.conciertos.dao.EventosDAOLista;
import cl.inacap.conciertos.dto.Evento;

public class MainActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {

    private EditText nombreTxt;
    private EditText valorTxt;
    private Button registrarBtn;
    private Spinner genero;
    private Spinner valoracion;
   
    private List<Evento> eventos = new ArrayList<>();
    private EditText fecha;
    private ListView eventosLv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.nombreTxt = findViewById(R.id.nombreTxt);
        this.valorTxt = findViewById(R.id.valorTxt);
        this.registrarBtn = findViewById(R.id.registrarBtn);
        this.eventosLv = findViewById(R.id.eventosLv);

        this.genero = (Spinner) findViewById(R.id.idestilo);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.categorias, android.R.layout.simple_spinner_item);

        genero.setAdapter(adapter);


        this.registrarBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            List<String> errores = new ArrayList<>();
            String nmb = nombreTxt.getText().toString().trim();
            String gnr = genero.toString().trim();
            int vlr = 0;
            if(nmb.isEmpty()){
                errores.add("Debe ingresar el nombre del artista");
            }
            if (gnr.isEmpty()){
                errores.add("Debe seleccionar una categoria");
            }

            try {
                if (vlr <= 0){
                    errores.add("el valor de la entrada debe ser mayor a 0")
                }
            }catch (Exception ex){
                errores.add("el valor de la entrada debe ser numerico");
            }
            

            if(errores.isEmpty()){
                    Evento e = new Evento();
                    e.getNombreartista(nmb);
                    e.getFecha(fecha);
                    e.getGenero(genero);
                    e.getValor(valorTxt);
                    e.getCalificacion(valoracion);

                    EventosDAO.add(e);

            }else{

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