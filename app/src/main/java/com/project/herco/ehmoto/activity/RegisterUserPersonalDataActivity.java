package com.project.herco.ehmoto.activity;

import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.project.herco.ehmoto.R;

public class RegisterUserPersonalDataActivity extends AppCompatActivity {

    private TextInputEditText textInputNome, textInputSobrenome,
            textInputCpf, textInputEstado, textInputCidade;
    private TextView textViewNameProfile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_user_personal_data);

        textInputNome= findViewById(R.id.rupd_text_input_nome);
        textInputSobrenome= findViewById(R.id.rupd_text_input_sobrenome);
        textInputCpf= findViewById(R.id.rupd_text_input_cpf);
        textInputEstado= findViewById(R.id.rupd_text_input_estado);
        textInputCidade= findViewById(R.id.rupd_text_input_cidade);

        textViewNameProfile = findViewById(R.id.rupd_imagem_name_profile);

        this.autoCompletar();
    }

    public void onClickcardViewAvancar(View view){
        if(validarCampos()){
            autoCompletar();
            Log.i("INFO","Clicked CardView Avançar rupd");
            //Intent intent = new Intent(RegisterUserPersonalDataActivity.this, );
        }
    }


    private boolean validarCampos(){
        if(textInputNome.getText().length()==0){
            textInputNome.setError("Campo obrigatório");
            return false;
        }
        if(textInputSobrenome.getText().length()==0){
            textInputSobrenome.setError("Campo obrigatório");
            return false;
        }
        if(textInputCpf.getText().length()==0){
            textInputCpf.setError("Campo obrigatório");
            return false;
        }
        if(textInputEstado.getText().length()==0){
            textInputEstado.setError("Campo obrigatório");
            return false;
        }
        if(textInputCidade.getText().length()==0){
            textInputCidade.setError("Campo obrigatório");
            return false;
        }

        return true;
    }

    private void autoCompletar(){
        textInputNome.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                // perdeu foco
                if(hasFocus){
                    cleanInputTextAndComplete();
                }
            }
        });
        textInputSobrenome.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                // perdeu foco
                if(hasFocus){
                    cleanInputTextAndComplete();
                }
            }
        });
        textInputCpf.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                // perdeu foco
                if(hasFocus){
                    cleanInputTextAndComplete();

                }
            }
        });
    }

    private void cleanInputTextAndComplete(){
        textViewNameProfile.setText("");

        textViewNameProfile.setText(textInputNome.getText().toString() +" "+
            textInputSobrenome.getText().toString()
        );
    }



}
