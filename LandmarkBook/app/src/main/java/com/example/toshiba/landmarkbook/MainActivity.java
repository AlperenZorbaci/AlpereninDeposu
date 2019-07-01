package com.example.toshiba.landmarkbook;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    static Bitmap selectedImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = (ListView) findViewById(R.id.listView);
        final ArrayList<String> LandmarkNames = new ArrayList<String>();
        LandmarkNames.add("Pisa");
        LandmarkNames.add("Colosseum");
        LandmarkNames.add("Eiffel");
        LandmarkNames.add("London Bridge");

        Bitmap pisa = BitmapFactory.decodeResource(getApplicationContext().getResources(), R.drawable.pisa);
        Bitmap colesseum = BitmapFactory.decodeResource(getApplicationContext().getResources(), R.drawable.colosseum);
        Bitmap eiffel = BitmapFactory.decodeResource(getApplicationContext().getResources(), R.drawable.eiffel);
        Bitmap londonbridge = BitmapFactory.decodeResource(getApplicationContext().getResources(), R.drawable.londonbridge);

        final ArrayList<Bitmap> LandmarkImages = new ArrayList<>();

        LandmarkImages.add(pisa);
        LandmarkImages.add(colesseum);
        LandmarkImages.add(eiffel);
        LandmarkImages.add(londonbridge);

        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, LandmarkNames);
        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getApplicationContext(), DetailActivity.class);
                intent.putExtra("", LandmarkNames.get(position));
                //selectedImage = LandmarkImages.get(position);

                Bitmap bitmap = LandmarkImages.get(position);
                Globals globals = Globals.getInstance();
                globals.setData(bitmap);
                startActivity(intent);
            }
        });
    }
}