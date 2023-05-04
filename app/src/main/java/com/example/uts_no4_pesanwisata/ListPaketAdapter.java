package com.example.uts_no4_pesanwisata;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class ListPaketAdapter extends BaseAdapter {
    static class ViewHolder {
        TextView tvNama;
        TextView tvDeskripsi;
        TextView tvHarga;
    }

    private LayoutInflater inflater;
    private int itemLayoutId;
    private ArrayList<ListPaketItem> listPaket;

    ListPaketAdapter(Context context, int itemLayoutId, ArrayList<ListPaketItem> listPaket) {
        super();
        this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.itemLayoutId = itemLayoutId;
        this.listPaket = new ArrayList<>(listPaket);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = inflater.inflate(itemLayoutId, parent, false);
            holder = new ViewHolder();
            holder.tvNama = convertView.findViewById(R.id.itemPaket_tvNama);
            holder.tvDeskripsi = convertView.findViewById(R.id.itemPaket_tvDeskripsi);
            holder.tvHarga = convertView.findViewById(R.id.itemPaket_tvHarga);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.tvNama.setText(listPaket.get(position).getNama());
        holder.tvDeskripsi.setText(listPaket.get(position).getDeskripsi());
        holder.tvHarga.setText(listPaket.get(position).getHarga());
        return convertView;
    }

    @Override
    public int getCount() {
        return listPaket.size();
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
