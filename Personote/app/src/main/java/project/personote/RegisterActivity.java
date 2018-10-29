package project.personote;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import dominio.controller.database.DbConnector;
import dominio.controller.models.Usuario;
import dominio.controller.repositorios.UsuarioRepositorio;

public class RegisterActivity extends AppCompatActivity {

    private SQLiteDatabase conexao;
    private DbConnector conector;
    private ConstraintLayout registerAct;
    private UsuarioRepositorio usuarioRep;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        final TextView senha = (TextView) findViewById(R.id.passwordPin);
        final TextView email = (TextView) findViewById(R.id.emailText);

        Button btnCadastrar = (Button) findViewById(R.id.cadastrarButton);
        btnCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder dlgAlert = new AlertDialog.Builder(RegisterActivity.this);
                dlgAlert.setMessage("Alerta");
                dlgAlert.setPositiveButton("OK", null);
                dlgAlert.setCancelable(true);

                validarCamposObrigatorios(dlgAlert, senha, email);

                cadastrarEmailSenha(email, senha);
            }
        });
    }

    private void validarCamposObrigatorios(AlertDialog.Builder dlgAlert, TextView senha, TextView email) {
        if (senha.getText().toString().isEmpty() && email.getText().toString().isEmpty()) {
            dlgAlert.setTitle("E-mail e senha não preenchidos");
            dlgAlert.create().show();

            dlgAlert.setPositiveButton("Ok",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                        }
                    });
        } else if (email.getText().toString().isEmpty()) {
            dlgAlert.setTitle("E-mail não preenchido");
            dlgAlert.create().show();

            dlgAlert.setPositiveButton("Ok",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                        }
                    });
        } else if (senha.getText().toString().isEmpty()) {
            dlgAlert.setTitle("Senha não preenchida");
            dlgAlert.create().show();

            dlgAlert.setPositiveButton("Ok",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                        }
                    });
        }
    }

    private void cadastrarEmailSenha(TextView email, TextView senha) {
        criarConexao();
        String senhaConvertida = toMd5(senha.getText().toString());
        Usuario usuario = new Usuario(email.getText().toString(), senhaConvertida);
        confirmar(usuario);
    }

    private String toMd5(String s) {
        try {
            // Create MD5 Hash
            MessageDigest digest = java.security.MessageDigest.getInstance("MD5");
            digest.update(s.getBytes());
            byte messageDigest[] = digest.digest();

            // Create Hex String
            StringBuffer hexString = new StringBuffer();
            for (int i = 0; i < messageDigest.length; i++)
                hexString.append(Integer.toHexString(0xFF & messageDigest[i]));
            return hexString.toString();

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return "";
    }

    private void criarConexao() {
        try {
            conector = new DbConnector(RegisterActivity.this);

            conexao = conector.getWritableDatabase();

//            Snackbar.make(registerAct, "Sucesso ao criar conexão", Snackbar.LENGTH_SHORT)
//                    .setAction("OK", null).show();

            usuarioRep = new UsuarioRepositorio(conexao);
        } catch (SQLException e) {
            android.support.v7.app.AlertDialog.Builder alertDlg =
                    new android.support.v7.app.AlertDialog.Builder(RegisterActivity.this);
            alertDlg.setTitle("Erro");
            alertDlg.setMessage("Erro ao criar conexão com banco: " + e.getMessage());
            alertDlg.setNeutralButton("OK", null);
            alertDlg.show();
        }
    }

    public void confirmar(Usuario usuario) {
        try {
            usuarioRep.insert(usuario);
        } catch (SQLException e) {
            android.support.v7.app.AlertDialog.Builder alertDlg =
                    new android.support.v7.app.AlertDialog.Builder(RegisterActivity.this);
            alertDlg.setTitle("Erro");
            alertDlg.setMessage("Erro ao criar conexão com banco: " + e.getMessage());
            alertDlg.setNeutralButton("OK", null);
            alertDlg.show();
        }
    }
}

