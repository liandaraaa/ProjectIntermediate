package com.project.lianda.hijabstylestore.UI;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.project.lianda.hijabstylestore.Adapter.hijabAdapter;
import com.project.lianda.hijabstylestore.Model.hijabModel;
import com.project.lianda.hijabstylestore.R;

import java.util.ArrayList;
import java.util.List;

public class Katalog extends AppCompatActivity {

    public static String[] nama =
            {"HSS Pashmina", "HSS Bergo", "HSS Rectangle",
                    "HSS Argi Ciffon",
                    "HSS Argi Cotton",
                    "HSS Argi Rayon"};
    public static String[] deskripsi =
            {"Bahan Spandek, Warna Navy/Merah/Black", "Bahan Kaos, warna Merah/Cokelat",
                    "Bahan Satin, warna Ungu/Hitam/Cream", "Warna kombinasi, motif bervariasi",
                    "Warna Hitam/Putih/Cokelat", "Kombinasi dua warna, pemakaian praktis"};
    public static String[] harga =
            {"Rp. 45.000,-", "Rp. 20.000,-", "Rp. 30.000,-", "Rp. 35.000,-", "Rp. 25.000,-",
                    "Rp.28.000"};
    public static int[] foto =
            {R.drawable.pashmina, R.drawable.bergoceka, R.drawable.persegiempat,
                    R.drawable.ciffon, R.drawable.cotton, R.drawable.rayon};

    private ListView listView;
    private ArrayList list;
    public CardView cardView;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_katalog);

        context = this;


        listView = (ListView)findViewById(R.id.lv_main);
        list = new ArrayList<>();

        hijabModel hijabModel = null;

        for (int i = 0; i < nama.length; i++) {
            hijabModel item = new hijabModel(foto[i], nama[i], deskripsi[i], harga[i]);
            list.add(item);
        }


        hijabAdapter adapter = new hijabAdapter(Katalog.this, nama, deskripsi, harga, foto);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                            @Override
                                            public void onItemClick (AdapterView<?> parent, View view, int p, long id){
                                                hijabModel hijab = (hijabModel)list.get(p);
                                                Intent intent = new Intent(getApplicationContext(), detailHijab.class );

                                                intent.putExtra(detailHijab.KEY_ITEM, hijab);
                                                startActivity(intent);
                                            }
                                        }

        );

    }

    @Override
    public boolean onCreateOptionsMenu (Menu menu) {
        getMenuInflater().inflate(R.menu.menu_detail_hijab, menu);
        return true;
    }


}

