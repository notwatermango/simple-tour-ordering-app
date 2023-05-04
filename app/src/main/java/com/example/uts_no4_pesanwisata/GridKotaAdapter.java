package com.example.uts_no4_pesanwisata;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class GridKotaAdapter extends BaseAdapter {
    private ArrayList<GridKotaItem> listKota;
    private LayoutInflater inflater;
    private int layoutId;

    static class ViewHolder {
        ImageView imageView;
        TextView textView;
    }

    GridKotaAdapter(Context context, int layoutId, ArrayList<GridKotaItem> listKota) {
        super();
        this.layoutId = layoutId;
        this.listKota = new ArrayList<>(listKota);
        this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = inflater.inflate(layoutId, parent, false);
            holder = new ViewHolder();
            holder.imageView = convertView.findViewById(R.id.gridItemKota_ivImageKota);
            holder.textView = convertView.findViewById(R.id.gridItemKota_tvNamaKota);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.imageView.setImageResource(listKota.get(position).getImageKota());
        holder.textView.setText(listKota.get(position).getNamaKota());
        return convertView;
    }

    @Override
    public int getCount() {
        return listKota.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }
}
