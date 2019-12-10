package com.example.smartgames;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button btnEntrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getWindow().setStatusBarColor(Color.parseColor("#FFFFFF"));

        btnEntrar = findViewById(R.id.btn_entrar);

        btnEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                /*PROGRESS DIALOG PARA CARREGAR A LISTA NA PROXIMA ACTIVITY*/
                final ProgressDialog progressDialog = new ProgressDialog(MainActivity.this);
                progressDialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
                progressDialog.show();
                progressDialog.setContentView(R.layout.layout_progressbar);

                /*INTENT PARA ABRIR A LISTA DE JOGOS*/
                Intent intentEntrar = new Intent(MainActivity.this, ListaJogosActivity.class);
                startActivity(intentEntrar);
                finish();
                progressDialog.dismiss();
            }
        });

    }
}
