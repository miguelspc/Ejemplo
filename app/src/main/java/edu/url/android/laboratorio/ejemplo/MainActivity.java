package edu.url.android.laboratorio.ejemplo;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnItemClick;

public class MainActivity extends AppCompatActivity {
    Biblioteca objBiblioteca;
    PlayList objPlayList;

    @BindView(R.id.btnBuscar)
    Button btnBuscar;
    @BindView(R.id.txtNombreCancion)
    EditText txtNombreCancion;
    @BindView(R.id.lstResultado)
    ListView lstResultado;
    @BindView(R.id.lstPlayList)
    ListView lstPlayList;
    @BindView(R.id.lblNombrePlayList)
    TextView lblNombrePlayList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        objBiblioteca = new Biblioteca();
        objPlayList = new PlayList("Mi playlist");
        lblNombrePlayList.setText(objPlayList.Nombre);

    }

    @OnClick(R.id.btnLimpiar)
    public void Limpiar()
    {
        txtNombreCancion.setText("");
        lstResultado.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, new ArrayList<String>()));


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main,menu );
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId()==R.id.action_about)
        {
            about();
        }

        return super.onOptionsItemSelected(item);
    }

    private void about() {
        Intent intent = new Intent(this,FilesActivity.class);
        startActivity(intent);

    }

    @OnClick(R.id.btnBuscar)
    public void MostrarMensaje() {
        Cancion result = objBiblioteca.Canciones.get(txtNombreCancion.getText().toString());
        if (result != null) {
            List<String> Resultados = new ArrayList<>();
            Resultados.add(result.Nombre + ". Duracion " + result.Duracion.toString() + ". Autor: " + result.Autor + ". Año: " + result.Anio);

            ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, Resultados);
            // Enlazamos el adaptador con nuestro List View
            lstResultado.setAdapter(adapter);

            Toast.makeText(MainActivity.this, "Canción encontrada.", Toast.LENGTH_LONG).show();
        } else {
            lstResultado.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, new ArrayList<String>()));
            Toast.makeText(MainActivity.this, "Canción no encontrada.", Toast.LENGTH_LONG).show();
        }
    }

    @OnItemClick(R.id.lstResultado)
    public void onItemClicked(AdapterView<?> adapterView, View view, int position, long id) {
        TextView abc = (TextView)view;
        String [] pedazos = abc.getText().toString().split("\\.");
        objPlayList.Canciones.add(objBiblioteca.Canciones.get(pedazos[0].trim()));
        MyAdapter adapter = new MyAdapter(this, R.layout.list_item, objPlayList.Canciones);
        // Enlazamos el adaptador con nuestro List View
        lstPlayList.setAdapter(adapter);
        Toast.makeText(MainActivity.this, pedazos[0] + " agregada a " + objPlayList.Nombre, Toast.LENGTH_LONG).show();
    }
}

