package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.AssetManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;

import java.io.IOException;
import java.io.InputStream;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Bundle bundle=getIntent().getExtras();
        String a=bundle.getString("dataKey");
        TextView tvtest=findViewById(R.id.test);
        tvtest.setText(a);
        InputStream inputStream = null;
        AssetManager mngr = getAssets();
        try {
            inputStream =mngr.open("data/"+a);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Yaml yaml = new Yaml(new Constructor(Welcome9.class));
        Welcome9 data = (Welcome9) yaml.load(inputStream);
        Log.d("BBB", "onCreate: " +data);
    }
}