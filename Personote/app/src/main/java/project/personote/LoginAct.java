package project.personote;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class LoginAct extends AppCompatActivity {
    Button loginButton, registerButton;
    TextView password;
    String pass = "1234";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        loginButton = (Button) findViewById(R.id.loginbutton);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              //  password = (TextView) findViewById(R.id.passwordText);
                /*if (password.getText().toString().equals(pass)) {*/
                    Intent intent = new Intent(LoginAct.this, NewNoteActivity.class);
                    startActivity(intent);
                /*} else {
                    AlertDialog.Builder dlgAlert = new AlertDialog.Builder(LoginAct.this);
                    dlgAlert.setMessage("Senha errada!");
                    dlgAlert.setTitle("Algo saiu errado:");
                    dlgAlert.setPositiveButton("OK", null);
                    dlgAlert.setCancelable(true);
                    dlgAlert.create().show();

                    dlgAlert.setPositiveButton("Ok",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                }
                            });
                }*/
            }
        });

        registerButton = (Button) findViewById(R.id.registerButton);
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginAct.this, RegisterActivity.class);
                startActivity(intent);
            }
        });
    }
}
