package edu.url.android.laboratorio.ejemplo;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class FilesActivity extends AppCompatActivity {

    @BindView(R.id.btnSelectFile)
    Button btnSelectFile;

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
        if(requestCode==123 && resultCode==RESULT_OK) {
            Uri selectedfile = data.getData(); //The uri with the location of the file
            Toast.makeText(this,selectedfile.toString(),Toast.LENGTH_LONG).show();
            Toast.makeText(this,selectedfile.getPath(),Toast.LENGTH_LONG).show();

        }
    }
}
