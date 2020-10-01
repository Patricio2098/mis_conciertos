package cl.inacap.conciertos.adapters;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import cl.inacap.conciertos.R;
import cl.inacap.conciertos.dto.Evento;

public class EventosArrayAdapter extends ArrayAdapter<Evento> {
    private Activity activity;
    private List<Evento> eventos;

    public EventosArrayAdapter(@NonNull Activity context, int resource, @NonNull List<Evento> objects) {
        super(context, resource, objects);
        this.activity = context;
        this.eventos = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = this.activity.getLayoutInflater();
        View fila = inflater.inflate(R.layout.eventos_list, null, true);

        return fila;
    }
}
