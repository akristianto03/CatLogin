package com.example.catlogin;

import androidx.appcompat.app.AppCompatActivity;

import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.catlogin.model.Account;
import com.example.catlogin.model.SaveData;

public class MainActivity extends AppCompatActivity {

    TextView name, email;
    AppCompatButton delBtn;
    ImageView outBtn;
    Account account;

    int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = findViewById(R.id.name);
        email = findViewById(R.id.email);
        delBtn = findViewById(R.id.delBtn);
        outBtn = findViewById(R.id.outBtn);

        account = getIntent().getParcelableExtra("account");
        id = getIntent().getIntExtra("id", 0);

        setupViewNameEmail();
        setupOutButton();
        setupDelButton();

    }

    private void setupViewNameEmail() {
        name.setText(account.getName());
        email.setText(account.getEmail());
    }

    private void setupOutButton() {
        outBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(MainActivity.this, LoginActivity.class);
                in.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(in);
                finish();
            }
        });
    }

    private void setupDelButton() {
        delBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SaveData.savelist.remove(id);
                Toast.makeText(MainActivity.this, "Account Deleted", Toast.LENGTH_SHORT).show();

                Intent in = new Intent(MainActivity.this, LoginActivity.class);
                in.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(in);
                finish();
            }
        });
    }

}