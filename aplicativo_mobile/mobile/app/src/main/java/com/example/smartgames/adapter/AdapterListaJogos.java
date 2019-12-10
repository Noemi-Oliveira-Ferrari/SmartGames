package com.example.smartgames.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.smartgames.DetalhesJogoActivity;
import com.example.smartgames.R;
import com.example.smartgames.model.Jogo;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;

public class AdapterListaJogos extends ArrayAdapter<Jogo> {

    /*ATRIBUTOS E VIEWS*/
    private Context context;
    private ArrayList<Jogo> listaJogos;
    private ImageView ivFotoJogo;
    private TextView tvTituloJogo;
    private TextView tvConsoleJogo;
    private TextView tvAvaliacaoJogo;
    private RatingBar rbAvaliacao;
    private CardView cvListaJogo;

    /*CONSTRUTOR DA LISTA*/
    public AdapterListaJogos(@NonNull Context context, ArrayList<Jogo> listaJogos) {
        super(context, 0, listaJogos);
        this.context = context;
        this.listaJogos = listaJogos;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        final Jogo listaJogos = this.listaJogos.get(position);
        /*LAYOUT DA LISTA*/
        convertView = LayoutInflater.from(this.context).inflate(R.layout.layout_lista_jogos, null);

        /*ENCONTRANDO AS VIEWS NO XML*/
        ivFotoJogo = convertView.findViewById(R.id.civ_foto_jogo);
        tvTituloJogo = convertView.findViewById(R.id.tv_nome_jogo);
        tvConsoleJogo = convertView.findViewById(R.id.tv_nome_plataforma);
        tvAvaliacaoJogo = convertView.findViewById(R.id.tv_nota_jogo);
        rbAvaliacao = convertView.findViewById(R.id.rb_avaliacao);
        cvListaJogo = convertView.findViewById(R.id.cv_lista_jogo);

        /*SETANDO OS VALORES QUE VIERAM DA LISTA NAS VIEWS*/
        String fotoJogo = listaJogos.getFotoMobile();
        Picasso.get().load(fotoJogo).into(ivFotoJogo);
        tvTituloJogo.setText(listaJogos.getTituloJogo());
        tvConsoleJogo.setText(listaJogos.getConsole().getTituloConsole());
        tvAvaliacaoJogo.setText(String.valueOf(listaJogos.getAvaliacao()));
        rbAvaliacao.setStepSize(1);
        rbAvaliacao.setProgress(listaJogos.getAvaliacao());

        /*OUVINTE DO CARD PARA ABRIR DETALHES DO JOGO PASSANDO O OBJETO SERIALIZADO*/
        cvListaJogo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentDetalhesJogo = new Intent(context, DetalhesJogoActivity.class);
                intentDetalhesJogo.putExtra("jogo", listaJogos);
                getContext().startActivity(intentDetalhesJogo);
            }
        });

        return convertView;
    }



}
