package dominio.controller.repositorios;

import android.content.ContentValues;

import java.util.List;

import dominio.controller.models.Clima;

/**
 * Created by alsabino on 26/04/2018.
 */

public class ClimaRepositorio {

    public void insert(Clima clima) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("TEMPERATURA", clima.getTemperatura());
        contentValues.put("CLIMA", clima.getClima());
    }

    public void delete(int id) {

    }

    public void update(Clima clima) {

    }

    public List<Clima> findAll(int id) {
        return null;
    }

    public Clima find() {
        return null;
    }
}
