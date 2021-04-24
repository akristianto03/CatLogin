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

public class RegActivity extends AppCompatActivity {

    EditText nameReg, emailReg, passReg;
    AppCompatButton signUpBtn;
    TextView loginBtn;

    String email, name, pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg);

        nameReg = findViewById(R.id.nameReg);
        emailReg = findViewById(R.id.emailReg);
        passReg = findViewById(R.id.passReg);
        signUpBtn = findViewById(R.id.signUpBtn);
        loginBtn = findViewById(R.id.loginBtn);

        setupTextWatch();
        setupSignUpButton();
        setupLoginButton();

    }

    private TextWatcher signupWatch = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            email = emailReg.getText().toString().trim();
            name = nameReg.getText().toString().trim();
            pass = passReg.getText().toString().trim();

            if (!email.isEmpty() && !pass.isEmpty() && !name.isEmpty()) {
                signUpBtn.setEnabled(true);
            }else {
                signUpBtn.setEnabled(false);
            }

        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };

    private void  setupTextWatch() {
        emailReg.addTextChangedListener(signupWatch);
        nameReg.addTextChangedListener(signupWatch);
        passReg.addTextChangedListener(signupWatch);
    }

    private void setupSignUpButton() {
        signUpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Account account = new Account(name, email, pass);
                SaveData.savelist.add(account);
                Toast.makeText(RegActivity.this, "Account Created!", Toast.LENGTH_SHORT).show();

                Intent in = new Intent(RegActivity.this, LoginActivity.class);
                in.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(in);
                finish();
            }
        });
    }

    private void setupLoginButton() {
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(RegActivity.this, LoginActivity.class);
                in.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(in);
                finish();
            }
        });
    }

}