package edu.url.android.laboratorio.ejemplo;

import java.util.ArrayList;
import java.util.List;

public class PlayList {
    public String Nombre;
    public List<Cancion> Canciones;

    public PlayList(String nombre) {
        Nombre = nombre;
        Canciones = new ArrayList<>();
    }
}
