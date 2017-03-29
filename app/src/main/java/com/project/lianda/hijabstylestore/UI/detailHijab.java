package com.project.lianda.hijabstylestore.UI;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.project.lianda.hijabstylestore.Model.hijabModel;
import com.project.lianda.hijabstylestore.R;

import java.util.List;

public class detailHijab extends AppCompatActivity {

    public static String KEY_ITEM = "item";
    private TextView txtdetailnama;
    private TextView txtdetaildeskripsi;
    private TextView txtdetailharga;
    private ImageView imageDetail;
    private hijabModel item;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_hijab);
        getSupportActionBar().setTitle("Detail Hijab");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        txtdetailnama = (TextView)findViewById(R.id.txt_detailnama);
        txtdetaildeskripsi = (TextView)findViewById(R.id.txt_detaildeskripsi);
        txtdetailharga = (TextView)findViewById(R.id.txt_detailharga);
        imageDetail = (ImageView)findViewById(R.id.img_detail);

        item = (hijabModel)getIntent().getSerializableExtra(KEY_ITEM);

        imageDetail.setImageResource(item.getGambar());
        txtdetailnama.setText(item.getNama());
        txtdetaildeskripsi.setText(item.getDeskripsi());
        txtdetailharga.setText(item.getHarga());
    }

    @Override
    public boolean onCreateOptionsMenu (Menu menu) {
        getMenuInflater().inflate(R.menu.menu_detail_hijab, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected (MenuItem item){
        int id = item.getItemId();

        if (id == R.id.action_share) {
            share();
            return true;
        }

        if (id == android.R.id.home){
            finish();
        }

        return super.onOptionsItemSelected(item);
    }

    private void share() {
        Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_SEND);
        sendIntent.putExtra(Intent.EXTRA_TEXT, item.getNama()+" "+item.getDeskripsi()+" "+item.getHarga());
        sendIntent.putExtra(Intent.EXTRA_TITLE, "Kumpulan Hijab dengan beragam Style");
        sendIntent.setType("text/plain");
        startActivity(sendIntent);
    }
}