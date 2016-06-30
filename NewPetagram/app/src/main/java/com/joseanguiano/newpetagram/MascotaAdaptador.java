package com.joseanguiano.newpetagram;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by JoseAnguiano on 29/06/2016.
 */

public class MascotaAdaptador extends RecyclerView.Adapter<MascotaAdaptador.MascotaViewHolder>{

    ArrayList<Mascota> mascotas;
    Activity activity;



    public MascotaAdaptador(ArrayList<Mascota> mascotas, Activity activity) {
        this.mascotas = mascotas;
        this.activity = activity;
    }

    @Override
    public MascotaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_petagram, parent, false);
        return new MascotaViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final MascotaViewHolder mascotaViewHolder, int position) {

        ConstructorMascotas constructorMascotas = new ConstructorMascotas(activity);

        final Mascota mascota = mascotas.get(position);
        mascotaViewHolder.tvNombreCV.setText(mascota.getNombre());
        mascotaViewHolder.tvLikesCV.setText(Integer.toString(constructorMascotas.obtenerLikesMascota(mascota)));
        mascotaViewHolder.imgFoto.setImageResource(mascota.getFoto());

        mascotaViewHolder.imgFoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(activity, mascota.getNombre(), Toast.LENGTH_SHORT).show();
            }
        });

        mascotaViewHolder.btnLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int verificarMascota;
                ConstructorMascotas constructorMascotas = new ConstructorMascotas(activity);

                verificarMascota = constructorMascotas.verificarMascota(mascota);

                if (verificarMascota == 0){
                    constructorMascotas.insertarMascota(mascota);
                    Toast.makeText(activity, "Like: " + mascota.getNombre(), Toast.LENGTH_SHORT).show();
                } else {
                    constructorMascotas.insertarLikeMascota(mascota);
                    mascotaViewHolder.tvLikesCV.setText(Integer.toString(constructorMascotas.obtenerLikesMascota(mascota)));
                    Toast.makeText(activity, "Like: " + mascota.getNombre(), Toast.LENGTH_SHORT).show();
                }


            }
        });
    }

    @Override
    public int getItemCount() {
        return mascotas.size();
    }

    public static class MascotaViewHolder extends RecyclerView.ViewHolder{

        private ImageView imgFoto;
        private TextView tvNombreCV;
        private TextView tvLikesCV;
        private ImageButton btnLike;

        public MascotaViewHolder(View itemView) {
            super(itemView);
            imgFoto         = (ImageView)   itemView.findViewById(R.id.imgFoto);
            tvNombreCV      = (TextView)    itemView.findViewById(R.id.tvNombreCV);
            tvLikesCV       = (TextView)    itemView.findViewById(R.id.tvLikesCV);
            btnLike         = (ImageButton) itemView.findViewById(R.id.btnLike);
        }
    }
}
