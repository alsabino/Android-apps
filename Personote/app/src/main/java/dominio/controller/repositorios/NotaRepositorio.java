package dominio.controller.repositorios;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import dominio.controller.models.Nota;

/**
 * Created by alsabino on 26/04/2018.
 */

public class NotaRepositorio {

    private final SQLiteDatabase conexao;

    public NotaRepositorio(SQLiteDatabase conexao) {
        this.conexao = conexao;
    }

    public void insert(Nota nota) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("TITULO", nota.getTitulo());
        contentValues.put("TEXTO", nota.getTexto());

        SimpleDateFormat fmt = new SimpleDateFormat("dd-MM-yyyy");
        String data = fmt.format(nota.getData());

        contentValues.put("DATA", data);
        contentValues.put("FK_CLIMA_ID", nota.getClima().getId());

        conexao.insertOrThrow("NOTAS", null, contentValues);
    }

    public void delete(int id) {
        String[] parametros = new String[1];
        parametros[0] = String.valueOf(id);

        conexao.delete("NOTAS", "ID = ?", parametros);

    }

    public void update(Nota nota) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("TITULO", nota.getTitulo());
        contentValues.put("TEXTO", nota.getTexto());

        SimpleDateFormat fmt = new SimpleDateFormat("dd-MM-yyyy");
        String data = fmt.format(nota.getData());

        contentValues.put("DATA", data);
        contentValues.put("FK_CLIMA", nota.getClima().getId());

        String[] parametros = new String[1];
        parametros[0] = nota.getId().toString();

        conexao.update("NOTAS", contentValues, "ID = ?", parametros);
    }

    public List<Nota> findAll() {
        return null;
    }

    public Nota find() {
        return null;
    }
}
