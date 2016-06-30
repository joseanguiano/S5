package com.joseanguiano.newpetagram;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.joseanguiano.newpetagram.R;
import com.joseanguiano.newpetagram.MascotaAdaptador;
import com.joseanguiano.newpetagram.Mascota;

import java.util.ArrayList;

/**
 * Created by JoseAnguiano on 29/06/2016.
 */

public class InicioPet extends Fragment {

    ArrayList<Mascota> mascotas;
    private RecyclerView listaMascotas;

    public InicioPet() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_inicio_pet, container, false);

        listaMascotas = (RecyclerView) v.findViewById(R.id.rvContactos);

        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        listaMascotas.setLayoutManager(llm);

        inicializarListaMascotas();
        inicializarAdaptador();


        return v;
    }

    public void inicializarAdaptador(){
        MascotaAdaptador adaptador = new MascotaAdaptador(mascotas, getActivity());
        listaMascotas.setAdapter(adaptador);
    }

    public void inicializarListaMascotas(){
        mascotas = new ArrayList<Mascota>();

        mascotas.add(new Mascota("Vaca", 0, R.drawable.vacahd));
        mascotas.add(new Mascota("Serpiente", 0, R.drawable.serpientehd));
        mascotas.add(new Mascota("Conejo", 0, R.drawable.conejouhd));
        mascotas.add(new Mascota("Cordero", 0, R.drawable.corderohd));
        mascotas.add(new Mascota("Perro", 0, R.drawable.perrohd));
        mascotas.add(new Mascota("Pollo", 0, R.drawable.pollohd));
        mascotas.add(new Mascota("Vaca", 0, R.drawable.vacahd));
        mascotas.add(new Mascota("Perro", 0, R.drawable.perrohd));
    }

}
