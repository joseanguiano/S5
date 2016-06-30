package com.joseanguiano.newpetagram;

import java.util.ArrayList;

/**
 * Created by JoseAnguiano on 29/06/2016.
 */
public interface IFavoritos {

    public void generarLinealLayoutVertical();

    public MascotaAdaptador crearAdaptador(ArrayList<Mascota> mascotas);

    public void inicializarAdaptadorRV(MascotaAdaptador adaptador);

    public void generarToolbar();
}
