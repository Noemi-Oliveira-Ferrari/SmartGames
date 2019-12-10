package com.example.smartgames;

import androidx.fragment.app.FragmentActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.smartgames.model.Jogo;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap gmMap;
    private Button btnOutrosJogos;
    private Button btnVoltarDetalhes;
    private String latitude;
    private String longitude;
    private Jogo jogo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        getWindow().setStatusBarColor(Color.parseColor("#FFFFFF"));

        /*MAPA*/
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        btnOutrosJogos = findViewById(R.id.btn_outros_jogos);
        btnVoltarDetalhes = findViewById(R.id.btn_voltar_detalhes);

        /*OUVINTE DO BOTÃO PARA VOLTAR AOS DETALHES DO JOGO*/
        btnVoltarDetalhes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        /*VOLTAR PARA A LISTA DE JOGOS*/
        btnOutrosJogos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentOutrosJogos = new Intent(MapsActivity.this, ListaJogosActivity.class);
                startActivity(intentOutrosJogos);
            }
        });

        /*PEGANDO O JOGO QUE VEIO SERIALIZADO DA INTENT*/
        Intent intent = getIntent();
        if(intent.getSerializableExtra("lojaMapa") != null) {
            jogo = (Jogo) intent.getSerializableExtra("lojaMapa");

            latitude = jogo.getLoja().getEndereco().getCoordenadas().getLatitude();
            longitude = jogo.getLoja().getEndereco().getCoordenadas().getLongitude();
        }

    }

    /*ABRIR O MAPA COM A LOCALIZAÇÃO DA LOJA*/
    @Override
    public void onMapReady(GoogleMap googleMap) {

        gmMap = googleMap;
        LatLng lngLatLoja = new LatLng(Double.parseDouble(latitude), Double.parseDouble(longitude));
        CameraUpdate pontoLoja = CameraUpdateFactory.newLatLngZoom(lngLatLoja, 15);
        gmMap.animateCamera(pontoLoja);
        gmMap.addMarker(new MarkerOptions().position(lngLatLoja).title("SmartGames"));
    }
}
