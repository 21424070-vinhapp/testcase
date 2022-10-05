package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.util.Log;

import com.example.myapplication.adapter.ComponentAdapter;
import com.example.myapplication.my_interface.IClickItemComponentListener;

import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView rcvTest;
    ComponentAdapter mComponentAdapter;
    List<String> mFiles=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        InputStream inputStream = null;
        AssetManager assetManager = getAssets();
        try {
            String[] list=assetManager.list("data");
            for(int i=0; i<list.length; i++){
                Log.d("TestActivity", list[i]);
                mFiles.add(list[i]);
            }
        } catch (IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }

        initView(mFiles);
        rcvTest.setAdapter(mComponentAdapter);


//        InputStream inputStream = null;
//        AssetManager mngr = getAssets();
//        try {
//            inputStream =mngr.open("FOTA.yml");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        Yaml yaml = new Yaml(new Constructor(Welcome9.class));
//        Welcome9 data = (Welcome9) yaml.load(inputStream);
//        Log.d("BBB", "onCreate: " +data);
    }

    private void initView(List<String> files) {
        rcvTest=findViewById(R.id.rcvComponent);
//        List<String> dataFile=new ArrayList<>();
//        for (String data:
//             files) {
//            dataFile.add(data.split(".yml")[0]);
//            Log.d("BBB", "initView: "+ data.split(".yml")[0]);
//        }
        mComponentAdapter=new ComponentAdapter(files, new IClickItemComponentListener() {
            @Override
            public void onClick(String data) {
                onClickGoToSubComPonent(data);
            }
        });
    }

    private void onClickGoToSubComPonent(String data) {
        Intent intent=new Intent(this,MainActivity2.class);
        Bundle bundle=new Bundle();
        bundle.putString("dataKey",data);
        intent.putExtras(bundle);
        startActivity(intent);
    }
}