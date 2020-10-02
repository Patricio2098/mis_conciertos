package cl.inacap.conciertos.dao;

import java.util.ArrayList;
import java.util.List;

import cl.inacap.conciertos.dto.Evento;

public class EventosDAOLista implements EventosDAO{
    private List<Evento> eventos = new ArrayList<>();

    @Override
    public List<Evento> getAll() {
        return eventos;
    }

    @Override
    public Evento save(Evento e) {
        eventos.add(e);
        return e;
    }
}
