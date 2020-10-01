package cl.inacap.conciertos.dao;

import java.util.List;

import cl.inacap.conciertos.dto.Evento;

public interface EventosDAO {

    List<Evento> getAll();
    Evento save(Evento e);
}
