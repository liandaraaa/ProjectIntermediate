package com.project.lianda.hijabstylestore.Adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.project.lianda.hijabstylestore.Model.hijabModel;
import com.project.lianda.hijabstylestore.R;
import com.project.lianda.hijabstylestore.UI.Katalog;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;

import static android.content.Intent.getIntent;
import static com.project.lianda.hijabstylestore.UI.detailHijab.KEY_ITEM;
import static java.lang.Integer.valueOf;

/**
 * Created by lenovo on 23/03/2017.
 */

public class hijabAdapter extends BaseAdapter {

    Context context;
    String[] resultnama;
    String[] resultdeskripsi;
    String[] resultharga;
    int[] gambar;

    private static LayoutInflater inflater = null;
    public hijabAdapter(Katalog katalog, String[] nama, String[] deskripsi, String[] harga, int[] foto) {
        resultnama = nama;
        resultdeskripsi = deskripsi;
        resultharga = harga;
        context = katalog;
        gambar = foto;

        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return resultnama.length;
    }

    @Override
    public Object getItem(int p) {
        return p;
    }

    @Override
    public long getItemId(int p){
        return p;
    }

    @Override
    public View getView (int p, View convertView, ViewGroup parent) {
        ViewHolder holder = new ViewHolder();
        View view;

        view = inflater.inflate(R.layout.item_list, null);
        holder.ivgambar = (ImageView)view.findViewById(R.id.gambar_hijab);
        holder.txtnama = (TextView)view.findViewById(R.id.nama_hijab);
        holder.txtdeskripsi = (TextView)view.findViewById(R.id.deskripsi_hijab);
        holder.txtharga = (TextView)view.findViewById(R.id.harga_hijab);

        holder.ivgambar.setImageResource(gambar[p]);
        holder.txtnama.setText(resultnama[p]);
        holder.txtdeskripsi.setText(resultdeskripsi[p]);
        holder.txtharga.setText(resultharga[p]);

        return view;
    }

    public class ViewHolder {
        ImageView ivgambar;
        TextView txtnama, txtdeskripsi, txtharga;
    }
}