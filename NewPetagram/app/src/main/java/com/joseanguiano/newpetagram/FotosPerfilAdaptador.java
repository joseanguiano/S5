package com.joseanguiano.newpetagram;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by JoseAnguiano on 29/06/2016.
 */

public class FotosPerfilAdaptador extends RecyclerView.Adapter<FotosPerfilAdaptador.FotosPerfilViewHolder>{

    ArrayList<Mascota> mascotas;
    Activity activity;

    public FotosPerfilAdaptador(ArrayList<Mascota> mascotas, Activity activity) {
        this.mascotas = mascotas;
        this.activity = activity;
    }

    @Override
    public FotosPerfilViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_fotos_perfil, parent, false);
        return new FotosPerfilViewHolder(v);
    }

    @Override
    public void onBindViewHolder(FotosPerfilViewHolder fotosPerfilViewHolder, int position) {

        final Mascota mascota = mascotas.get(position);
        fotosPerfilViewHolder.tvLikesCVPerfil.setText(String.valueOf(mascota.getLikes()));
        fotosPerfilViewHolder.imgFotoPerfil.setImageResource(mascota.getFoto());

    }

    @Override
    public int getItemCount() {
        return mascotas.size();
    }

    public static class FotosPerfilViewHolder extends RecyclerView.ViewHolder{

        private ImageView imgFotoPerfil;
        private TextView tvLikesCVPerfil;

        public FotosPerfilViewHolder(View itemView) {
            super(itemView);
            imgFotoPerfil         = (ImageView)   itemView.findViewById(R.id.imgFotoPerfil);
            tvLikesCVPerfil       = (TextView)    itemView.findViewById(R.id.tvLikesCVPerfil);
        }
    }
}
