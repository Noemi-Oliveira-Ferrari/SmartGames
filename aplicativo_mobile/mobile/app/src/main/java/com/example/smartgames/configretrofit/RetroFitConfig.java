package com.example.smartgames.configretrofit;

import com.example.smartgames.service.JogoService;

import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

public class RetroFitConfig {

    private Retrofit retroFit;

    /*CONEXAO COM A API PASSANDO O IP LOCAL*/
    public RetroFitConfig(){
        retroFit = new Retrofit.Builder()
                .baseUrl("http://192.168.1.37:8080/")
                .addConverterFactory(JacksonConverterFactory.create())
                .build();
    }

    public JogoService getJogoService(){
        return this.retroFit.create(JogoService.class);
    }
}

