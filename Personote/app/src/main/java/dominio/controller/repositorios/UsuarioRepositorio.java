package dominio.controller.repositorios;

import android.content.ContentValues;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import dominio.controller.models.Usuario;

/**
 * Created by alsabino on 26/04/2018.
 */

public class UsuarioRepositorio {

    private SQLiteDatabase conexao;

    public UsuarioRepositorio(SQLiteDatabase conexao) {
        this.conexao = conexao;
    }

    public void insert(Usuario usuario) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("EMAIL", usuario.getEmail());
        contentValues.put("SENHA", usuario.getSenha());

        long newID = conexao.insertOrThrow("USUARIO", null, contentValues);
        if (newID <= 0) {
            throw new SQLException("Failed to insert row into ");
        }
    }

    public void delete(int id) {

    }

    public void update(Usuario usuario) {

    }

}
