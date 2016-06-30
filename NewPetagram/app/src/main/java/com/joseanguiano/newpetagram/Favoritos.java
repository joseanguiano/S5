package com.joseanguiano.newpetagram;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by JoseAnguiano on 29/06/2016.
 */

public class Favoritos extends AppCompatActivity implements IFavoritos{

    ArrayList<Mascota> mascotas;
    private RecyclerView listaMascotas;
    private IFavoritosPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favoritos);


        listaMascotas = (RecyclerView) findViewById(R.id.rvContactos2);

        presenter = new FavoritosPresenter(this, getBaseContext());
    }

    public void inicializarAdaptador(){
        MascotaAdaptador adaptador = new MascotaAdaptador(mascotas, this);
        listaMascotas.setAdapter(adaptador);
    }

    public void inicializarFavs(){
        mascotas = new ArrayList<Mascota>();

        mascotas.add(new Mascota("Perro", 15, R.drawable.perrohd));
        mascotas.add(new Mascota("Vaca", 12, R.drawable.vacahd));
        mascotas.add(new Mascota("Serpiente", 10, R.drawable.serpientehd));
        mascotas.add(new Mascota("Cprdero", 10, R.drawable.corderohd));
        mascotas.add(new Mascota("Conejo", 7, R.drawable.conejouhd));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.fav_actions, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_contacto:
                Toast.makeText(this, R.string.contacto_toolbar, Toast.LENGTH_SHORT).show();
                Intent intent2 = new Intent(Favoritos.this, Contacto.class);
                startActivity(intent2);
                break;
            case R.id.action_about:
                Toast.makeText(this, R.string.about_toolbar, Toast.LENGTH_SHORT).show();
                Intent intent3 = new Intent(Favoritos.this, About.class);
                startActivity(intent3);
                break;
        }
        return super.onOptionsItemSelected(item);
    }


    @Override
    public void generarLinealLayoutVertical() {
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        listaMascotas.setLayoutManager(llm);
    }

    @Override
    public MascotaAdaptador crearAdaptador(ArrayList<Mascota> mascotas) {
        MascotaAdaptador adaptador = new MascotaAdaptador(mascotas, this);
        return adaptador;
    }

    @Override
    public void inicializarAdaptadorRV(MascotaAdaptador adaptador) {
        listaMascotas.setAdapter(adaptador);
    }

    @Override
    public void generarToolbar() {
        Toolbar miActionBar = (Toolbar) findViewById(R.id.miActionBar);
        setSupportActionBar(miActionBar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setIcon(R.drawable.year);
        getSupportActionBar().setTitle(R.string.favs);
    }
}
