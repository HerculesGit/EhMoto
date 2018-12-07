package com.project.herco.ehmoto.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.project.herco.ehmoto.R;

public class LoginActivity extends AppCompatActivity {

    private final String FILE_PREFERENCES = "filePreferences";
    private TextInputEditText textLogin, textPassword;
    private TextView textEsqueciSenha;

    // para test
    private final String LOGIN = "jessy";
    private final String PASSWORD = "jessy123";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        textLogin = findViewById(R.id.login_login);
        textPassword= findViewById(R.id.login_password);

        checkPreferences();
    }

    public void onClickBtCarView(View view){

        int id = view.getId();
        if(id == R.id.login_bt_cardview_criar_conta){               // criar conta
            Snackbar snackbar = Snackbar
                    .make(view,"Funcao indisponivel",Snackbar.LENGTH_LONG);
            snackbar.show();

        } else if (id == R.id.login_bt_cardview_criar_login){       // criar login
            Log.i("INFO","clicked login");

            // validar dados
            if(validarDados()){
                Intent intent = new Intent(LoginActivity.this,HomeActivity.class);
                savePreferences();
                startActivity(intent);
                finish();
            } else {
                Snackbar snackbar = Snackbar
                        .make(view,"Ops! dados não encontrados",Snackbar.LENGTH_LONG);
                snackbar.show();
            }
        }
    }

    public void onClickEsqueciSenha(View view){
        if (view.getId() == R.id.login_text_esqueci_senha){
            Snackbar snackbar = Snackbar
                    .make(view,"Funcao ainda indisponivel",Snackbar.LENGTH_LONG);
            snackbar.show();
        }
    }

    private void savePreferences(){

        SharedPreferences preferences = getSharedPreferences(FILE_PREFERENCES,0);
        SharedPreferences.Editor editor = preferences.edit();       // para poder editar


        editor.putString("login",LOGIN);
        editor.putString("password",PASSWORD);
        editor.commit();                                            // salvar
    }

    /**
     * recuperar preferencias
     * */
    private void checkPreferences(){
        SharedPreferences preferences = getSharedPreferences(FILE_PREFERENCES,0);

        if(preferences.contains("login")){
            // verificar valor por enquanto isso nao faz sentido
            String login = preferences.getString("login","");
            String password = preferences.getString("password","");
            Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
            startActivity(intent);
            finish();
        }
    }

    private boolean validarDados(){
        Log.i("INFO","dados dos text:" + textLogin.getText() + ","+textPassword.getText());

        Log.i("INFO",LOGIN + "," +PASSWORD);
        if(textLogin.getText().toString().equals(LOGIN)){
            Log.i("INFO","login ok");
            if (textPassword.getText().toString().equals(PASSWORD)){
                Log.i("INFO","password ok");
                return true;
            }
        }
        return false;
    }

}
