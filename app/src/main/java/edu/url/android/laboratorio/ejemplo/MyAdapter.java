package edu.url.android.laboratorio.ejemplo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class MyAdapter extends BaseAdapter {
    private Context context;
    private int layout;
    private List<Cancion> canciones;

    public MyAdapter(Context context, int layout, List<Cancion> canciones) {
        this.context = context;
        this.layout = layout;
        this.canciones = canciones;
    }

    @Override
    public int getCount() {
        return this.canciones.size();
    }

    @Override
    public Object getItem(int position) {
        return this.canciones.get(position);
    }

    @Override
    public long getItemId(int id) {
        return id;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {
        View v = convertView;
        LayoutInflater layoutInflater = LayoutInflater.from(this.context);
        v = layoutInflater.inflate(this.layout,null);

        Cancion cancionActual = canciones.get(position);
        TextView textViewNombre = (TextView) v.findViewById(R.id.txtNombre);
        textViewNombre.setText(cancionActual.Nombre);
        TextView textViewDuracion = (TextView)v.findViewById(R.id.txtDuracion);
        textViewDuracion.setText(cancionActual.Duracion.toString());
        TextView textViewAutor = (TextView)v.findViewById(R.id.txtAutor);
        textViewAutor.setText(cancionActual.Autor);
        TextView textViewAnio = (TextView)v.findViewById(R.id.txtAnio);
        textViewAnio.setText(Integer.toString(cancionActual.Anio));

        return v;
    }
}
