package edu.url.android.laboratorio.ejemplo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Biblioteca {
    Map<String,Cancion> Canciones;

    public Biblioteca() {
        Canciones = new TreeMap<String,Cancion>();
        Canciones.put("Like a Rolling Stone",new Cancion("Like a Rolling Stone",2.5,"Bob Dylan",1965));
        Canciones.put("(I Can't Get No) Satisfaction",new Cancion("(I Can't Get No) Satisfaction",2.5,"The Rolling Stones",1965));
        Canciones.put("Imagine",new Cancion("Imagine",2.5,"John Lennon",1971));
        Canciones.put("What's Going On",new Cancion("What's Going On",2.5,"Marvin Gaye",1971));
        Canciones.put("Respect",new Cancion("Respect",2.5,"Aretha Franklin",1967));
        Canciones.put("Good Vibrations",new Cancion("Good Vibrations",2.5,"Beach Boys",1966));
        Canciones.put("Johnny B. Goode",new Cancion("Johnny B. Goode",  2.5,"Chuck Berry",1958));
        Canciones.put("Hey Jude",new Cancion("Hey Jude",2.5,"The Beatles",1968));
        Canciones.put("Smells Like Teen Spirit",new Cancion("Smells Like Teen Spirit",2.5,"Nirvana",1991));
        Canciones.put("What'd I Say",new Cancion("What'd I Say",2.5,"Ray Charles",1959));


    }
}
