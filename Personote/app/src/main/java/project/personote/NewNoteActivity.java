package project.personote;

import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import java.util.Calendar;
import java.util.Date;

import dominio.controller.database.DbConnector;
import dominio.controller.models.Clima;
import dominio.controller.models.Nota;
import dominio.controller.repositorios.NotaRepositorio;

public class NewNoteActivity extends AppCompatActivity {
    private SQLiteDatabase conexao;
    private DbConnector conector;
    private ConstraintLayout newNoteLayout;
    private EditText edtTitulo;
    private EditText edtTxt;
    private Date data;
    private Clima clima;
    private FloatingActionButton salvar;

    private NotaRepositorio notaRepositorio;
    private Nota nota;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_note);
        edtTitulo = (EditText) findViewById(R.id.titulo);
        edtTxt = (EditText) findViewById(R.id.nota);
        data = Calendar.getInstance().getTime();
        clima = null;

        newNoteLayout = (ConstraintLayout) findViewById(R.id.newNoteLayout);


        salvar = (FloatingActionButton) findViewById(R.id.savenote);
        salvar.setClickable(true);
        salvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                criarConexao();
                if (validarCampos()) {
                    confirmar();
                }
            }
        });

    }

    private void criarConexao() {
        try {
            conector = new DbConnector(NewNoteActivity.this);
            conexao = conector.getWritableDatabase();
            Snackbar.make(newNoteLayout, "Sucesso ao criar conexão", Snackbar.LENGTH_SHORT)
                    .setAction("OK", null).show();

            notaRepositorio = new NotaRepositorio(conexao);


        } catch (SQLException e) {
            AlertDialog.Builder alertDlg = new AlertDialog.Builder(NewNoteActivity.this);
            alertDlg.setTitle("Erro");
            alertDlg.setMessage("Erro ao criar conexão com banco: " + e.getMessage());
            alertDlg.setNeutralButton("OK", null);
            alertDlg.show();
        }
    }

    public boolean validarCampos() {
        String titulo = edtTitulo.getText().toString();
        String txt = edtTxt.getText().toString();
        nota = new Nota();
        nota.setTitulo(titulo);
        nota.setTexto(txt);

        //Mok CLima for tests
        clima = new Clima();
        clima.setClima("Quente");
        clima.setTemperatura(30L);
        clima.setId(1L);

        nota.setClima(clima);

        nota.setData(data);

        return true;
    }

    public void confirmar() {
        try {
            if (validarCampos() == true) {
                notaRepositorio.insert(nota);
            }
        } catch (SQLException e) {
            AlertDialog.Builder alertDlg = new AlertDialog.Builder(NewNoteActivity.this);
            alertDlg.setTitle("Erro");
            alertDlg.setMessage("Erro ao criar conexão com banco: " + e.getMessage());
            alertDlg.setNeutralButton("OK", null);
            alertDlg.show();
        }
    }
}
