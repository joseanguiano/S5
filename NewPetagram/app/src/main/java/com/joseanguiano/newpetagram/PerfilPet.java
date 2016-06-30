package com.joseanguiano.newpetagram;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * Created by JoseAnguiano on 29/06/2016.
 */

public class PerfilPet extends Fragment {

    ArrayList<Mascota> mascotas;
    private RecyclerView listaMascotas;

    public PerfilPet() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_perfil_pet, container, false);

        listaMascotas = (RecyclerView) v.findViewById(R.id.rvFotosPerfil);

        GridLayoutManager llm = new GridLayoutManager(getActivity(), 3);
        listaMascotas.setLayoutManager(llm);

        inicializarListaMascotas();
        inicializarAdaptador();


        return v;
    }

    public void inicializarAdaptador(){
        FotosPerfilAdaptador adaptador = new FotosPerfilAdaptador(mascotas, getActivity());
        listaMascotas.setAdapter(adaptador);
    }

    public void inicializarListaMascotas(){
        mascotas = new ArrayList<Mascota>();

        mascotas.add(new Mascota("Vaca", 12, R.drawable.vacahd));
        mascotas.add(new Mascota("Pollo", 4, R.drawable.pollohd));
        mascotas.add(new Mascota("Cordero", 6, R.drawable.corderohd));
        mascotas.add(new Mascota("Serpiente", 7, R.drawable.serpientehd));
        mascotas.add(new Mascota("Conejo", 15, R.drawable.conejouhd));


    }


}
