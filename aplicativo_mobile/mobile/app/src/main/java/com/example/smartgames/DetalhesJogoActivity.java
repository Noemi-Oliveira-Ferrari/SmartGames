package com.example.smartgames;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.DimenRes;
import androidx.annotation.Dimension;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;

import com.example.smartgames.model.Jogo;
import com.squareup.picasso.Picasso;


public class DetalhesJogoActivity extends AppCompatActivity {

    /*ATRIBUTOS E VIEWS*/
    private Jogo jogo;

    private TextView tvDescricaoJogo;
    private TextView tvTituloJogo;
    private TextView tvAnoJogo;
    private TextView tvGeneroJogo;
    private ImageView ivFotoJogo;
    private RatingBar rbAvalicoesJogo;

    private TextView tvNomeLoja;
    private TextView tvRuaLoja;
    private TextView tvEnderecoLoja;
    private TextView tvClassificacaoJogo;
    private View vClassificacaoJogo;
    private Button btnMapaLoja;

    private Button btnVoltar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhes_jogo);

        getWindow().setStatusBarColor(Color.parseColor("#FFFFFF"));

        /*ENCONTRANDO VIEWS NO XML*/
        tvDescricaoJogo = findViewById(R.id.tv_desc_jogo);
        tvDescricaoJogo.setMovementMethod(new ScrollingMovementMethod());

        tvTituloJogo = findViewById(R.id.tv_nome_jogo);
        tvAnoJogo = findViewById(R.id.tv_ano_jogo);
        tvGeneroJogo = findViewById(R.id.tv_genero_jogo);
        ivFotoJogo = findViewById(R.id.iv_foto_jogo);
        rbAvalicoesJogo = findViewById(R.id.rb_avaliacao_jogo);

        tvNomeLoja = findViewById(R.id.tv_nome_loja);
        tvRuaLoja = findViewById(R.id.tv_logradouro_loja);
        tvEnderecoLoja = findViewById(R.id.tv_endereco_loja);
        vClassificacaoJogo = findViewById(R.id.v_classificacao_jogo);
        tvClassificacaoJogo = findViewById(R.id.tv_classificacao_jogo);
        btnMapaLoja = findViewById(R.id.btn_mapa_loja);


        /*OUVINTE DO BOTÃO PARA VOLTAR A LISTA DE JOGOS*/
        btnVoltar = findViewById(R.id.btn_voltar_lista);
        btnVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        /*VERIFICANDO A EXISTÊNCIA DO JOGO PASSADO PELA INTENT ANTERIOR*/
        Intent intent = getIntent();
        if(intent.getSerializableExtra("jogo") != null) {
            jogo = (Jogo) intent.getSerializableExtra("jogo");

            int classificacaoIndicativa = jogo.getIdade();
            String fotoJogo = jogo.getFotoMobile();

            /*SETANDO OS ATRIBUTOS/DETALHES DO JOGO*/
            Picasso.get().load(fotoJogo).fit().into(ivFotoJogo);

            tvDescricaoJogo.setText(jogo.getDescricao());
            tvTituloJogo.setText(jogo.getTituloJogo());
            tvAnoJogo.setText(jogo.getAnoLancamento());
            tvGeneroJogo.setText(jogo.getGenero().getTituloGenero());
            rbAvalicoesJogo.setStepSize(1);
            rbAvalicoesJogo.setProgress(jogo.getAvaliacao());
            tvNomeLoja.setText(jogo.getLoja().getTituloLojaShopping());
            tvRuaLoja.setText(jogo.getLoja().getEndereco().getLogradouro()+", "+ jogo.getLoja().getEndereco().getNumero());
            tvEnderecoLoja.setText( jogo.getLoja().getEndereco().getBairro() + ", "+jogo.getLoja().getEndereco().getUf().getUf());

            if(classificacaoIndicativa == 0){
                tvClassificacaoJogo.setText("L");
            }else{
                tvClassificacaoJogo.setText(String.valueOf(classificacaoIndicativa));
            }

            String cor = corIdade(jogo.getIdade());
            vClassificacaoJogo.setBackgroundColor(Color.parseColor(cor));

            /*ABRIR MAPA COM A LOCALIZAÇÃO DA LOJA*/
            btnMapaLoja.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent intentMapa = new Intent(DetalhesJogoActivity.this, MapsActivity.class);
                    intentMapa.putExtra("lojaMapa", jogo);
                    startActivity(intentMapa);

                }
            });

        }

    }


    /*FUNÇÃO PARA PASSAR A COR EM HEXADECIMAL DA VIEW DE CLASSIFICAÇÃO DE ACORDO COM A IDADE*/
    private String corIdade(int idade){
        String cor = null;

        switch(idade) {
            case 0:
                cor = "#77FF00";
                break;
            case 10:
                cor = "#FF00C2FF";
                break;
            case 12:
                 cor = "#FFFFDD00";
                break;
            case 14:
                cor = "#FFFF7700";
                break;
            case 16:
                cor = "#FFC70000";
                break;
            case 18:
                cor = "#000000";
                break;
        }

        return cor;
    }

}
