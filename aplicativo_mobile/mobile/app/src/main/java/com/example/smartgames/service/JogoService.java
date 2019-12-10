package com.example.smartgames.service;

import com.example.smartgames.model.Jogo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface JogoService {

    /*TRAZ TODOS OS JOGOS*/
    @GET("jogos")
    Call<List<Jogo>> buscarJogos();

    /*TRAZ JOGOS DE ACORDO COM O TITULO*/
    @GET("jogos/titulo/{tituloJogo}")
    Call<List<Jogo>> buscarJogosPorTitulo(@Path("tituloJogo") String tituloJogo);

}
