package com.example.catlogin;

import androidx.appcompat.app.AppCompatActivity;

import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.catlogin.model.Account;
import com.example.catlogin.model.SaveData;

import java.util.ArrayList;

public class LoginActivity extends AppCompatActivity {

    EditText emailTxt, passTxt;
    AppCompatButton logBtn;
    TextView regBtn;
    String email, pass;

    ArrayList<Account> acc = SaveData.savelist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        emailTxt = findViewById(R.id.emailTxt);
        passTxt = findViewById(R.id.passTxt);
        logBtn = findViewById(R.id.logBtn);
        regBtn = findViewById(R.id.regBtn);

        setupTextWatch();
        setupLoginButton();
        setupSignUpButton();

    }

    private TextWatcher loginWatch = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            email = emailTxt.getText().toString().trim();
            pass = passTxt.getText().toString().trim();

            if (!email.isEmpty() && !pass.isEmpty()) {
                logBtn.setEnabled(true);
            }else {
                logBtn.setEnabled(false);
            }
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };

    private void setupTextWatch(){
        emailTxt.addTextChangedListener(loginWatch);
        passTxt.addTextChangedListener(loginWatch);
    }

    private void setupLoginButton(){
        logBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //sign in code
                boolean login = false;
                for (int i = 0; i < acc.size(); i++) {
                    Account account = acc.get(i);
                    if (email.equals(account.getEmail()) && pass.equals(account.getPass())) {
                        Intent in = new Intent(LoginActivity.this, MainActivity.class);
                        in.putExtra("account", account);
                        in.putExtra("id", i);

                        login = true;
                        in.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(in);
                        Toast.makeText(LoginActivity.this, "Logged In !", Toast.LENGTH_SHORT).show();
                        finish();
                    }
                }

                if (login == false) {
                    Toast.makeText(LoginActivity.this, "Unable to Login, Wrong email/password", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

    private void setupSignUpButton(){
        regBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(LoginActivity.this, RegActivity.class);
                in.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(in);
                finish();
            }
        });
    }

}