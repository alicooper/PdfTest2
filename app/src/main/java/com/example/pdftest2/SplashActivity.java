package com.example.pdftest2;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.github.barteksc.pdfviewer.PDFView;

import java.io.File;

public class SplashActivity extends AppCompatActivity {

    TextView txt_pathShow;
    ImageButton btn_filePicker;
    Intent myFileIntent;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);

//        txt_pathShow = (TextView) findViewById(R.id.txt_path);
        btn_filePicker = findViewById(R.id.btn_openPdf);


        btn_filePicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myFileIntent = new Intent(Intent.ACTION_GET_CONTENT);
                myFileIntent.setType("*/*");
                startActivityForResult(myFileIntent, 10);
            }
        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case 10:
                if (resultCode == RESULT_OK) {
                    Uri path = data.getData();

                    Intent intent = new Intent(this ,ShowPdf.class);
                    intent.putExtra("path",path.toString());
                    startActivity(intent);
//                    Log.i("test",path);

                }
                break;
        }
    }



}
