package com.example.smartgames;

import android.app.ProgressDialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.smartgames.adapter.AdapterListaJogos;
import com.example.smartgames.configretrofit.RetroFitConfig;
import com.example.smartgames.model.Jogo;

import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListaJogosActivity extends AppCompatActivity {

    /*ATRIBUTOS E VIEWS DA LISTA*/
    private AdapterListaJogos listaJogos;
    private ListView listView;
    private EditText etTituloJogo;
    private Button btnPesquisar;
    ArrayList<Jogo> lista = new ArrayList<Jogo>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_jogos);

        getWindow().setStatusBarColor(Color.parseColor("#FFFFFF"));

        etTituloJogo = findViewById(R.id.et_buscar_jogo);
        btnPesquisar = findViewById(R.id.btn_buscar_jogo);

        /*DIZENDO QUEM É A LISTA QUE SERÁ ADAPTADA*/
        listView = findViewById(R.id.lv_jogos);
        listaJogos =  new AdapterListaJogos(ListaJogosActivity.this, lista);

        /*CHAMADA DE TODOS OS JOGOS EXISTENTES NO BANCO*/
        Call<List<Jogo>> call = new RetroFitConfig().getJogoService().buscarJogos();
        call.enqueue(new Callback<List<Jogo>>() {
            @Override
            public void onResponse(Call<List<Jogo>> call, Response<List<Jogo>> response) {
                lista = (ArrayList<Jogo>) response.body();

                /*VERIFICANDO O RESULTADO DA CALL PELO RESPONSE BODY*/
                if(lista != null){
                    /*LOOPING PARA CRIAR A LISTA*/
                    for(Jogo jogo : lista){
                        listaJogos.add(jogo);
                    }
                    listView.setAdapter(listaJogos);
                }
            }
            /*CASO A CHAMADA NÃO SEJA ATENDIDA PELA API*/
            @Override
            public void onFailure(Call<List<Jogo>> call, Throwable t) {
                Log.i("JOGO LISTA", t.getMessage());
            }

        });


         /*OUVINTE DO BOTÃO QUE ACIONA O MÉTODO DE PESQUISA DO JOGO POR NOME*/
        btnPesquisar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listaJogos = null;

                String tituloJogo = etTituloJogo.getText().toString();

                /*CHAMANDO O JOGO PELO NOME*/
                Call<List<Jogo>> call = new RetroFitConfig().getJogoService().buscarJogosPorTitulo(tituloJogo);
                call.enqueue(new Callback<List<Jogo>>() {
                    @Override
                    public void onResponse(Call<List<Jogo>> call, Response<List<Jogo>> response) {
                        lista = (ArrayList<Jogo>) response.body();

                        if(lista != null){

                            /*CRIANDO A NOVA LISTA COM O RESULTADO DA PESQUISA*/
                            listaJogos = new AdapterListaJogos(ListaJogosActivity.this, lista);
                            ListView listView = (ListView) findViewById(R.id.lv_jogos);

                            listView.setAdapter(listaJogos);

                        }
                    }
                    @Override
                    public void onFailure(Call<List<Jogo>> call, Throwable t) {
                        Log.i("JOGO LISTA", t.getMessage());
                    }

                });

            }
        });
    }

    /*MÉTODO PARA VERIFICAR SE O USUÁRIO DESEJA SAIR DA APLICAÇÃO*/
    int contVoltar = 0;
    @Override
    public void onBackPressed() {

        if (contVoltar == 1) {
            super.onBackPressed();
            return;
        }
        contVoltar = 1;
        Toast.makeText(this, "Para fechar o aplicativo, pressione Voltar mais uma vez", Toast.LENGTH_SHORT).show();

    }

}
