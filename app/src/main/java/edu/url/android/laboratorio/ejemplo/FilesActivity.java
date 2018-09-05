package edu.url.android.laboratorio.ejemplo;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class FilesActivity extends AppCompatActivity {

    @BindView(R.id.btnSelectFile)
    Button btnSelectFile;
    @BindView(R.id.textoArchivo)
    TextView textoArchivo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_files);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btnSelectFile)
    public void onViewClicked() {
        Intent intent = new Intent()
                .addCategory(Intent.CATEGORY_OPENABLE)
                .setType("*/*")
                .setAction(Intent.ACTION_OPEN_DOCUMENT);

        startActivityForResult(Intent.createChooser(intent, "Select a file"), 123);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 123 && resultCode == RESULT_OK) {
            Uri selectedfile = data.getData(); //The uri with the location of the file
            Toast.makeText(this, selectedfile.toString(), Toast.LENGTH_LONG).show();
            Toast.makeText(this, selectedfile.getPath(), Toast.LENGTH_LONG).show();

            try{
                textoArchivo.setText(readTextFromUri(selectedfile));
            } catch (IOException e)
            {
                Toast.makeText(this, "Hubo un error al obtener el texto del archivo", Toast.LENGTH_LONG).show();
            }
        }
    }

    private String readTextFromUri(Uri uri) throws IOException {
        InputStream inputStream = getContentResolver().openInputStream(uri);
        BufferedReader reader = new BufferedReader(new InputStreamReader(
                inputStream));
        StringBuilder stringBuilder = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            stringBuilder.append(line);
        }
        inputStream.close();
        reader.close();
        return stringBuilder.toString();
    }

}
