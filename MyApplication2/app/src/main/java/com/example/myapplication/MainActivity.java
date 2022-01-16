package com.example.myapplication;



import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.core.app.ActivityCompat;
public class MainActivity extends AppCompatActivity {
    private Button bouton;
    String phoneNo;
    EditText numeroTelephone;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        numeroTelephone = (EditText) findViewById(R.id.editText2);

        bouton = findViewById(R.id.buttonCall);
        bouton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                phoneNo = numeroTelephone.getText().toString();
                Intent callIntent = new Intent(Intent.ACTION_DIAL);
                callIntent.setData(Uri.parse("tel:" + phoneNo));
                if (ActivityCompat.checkSelfPermission(MainActivity.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED)
                {}
                startActivity(callIntent);
            }
        });
    }
}