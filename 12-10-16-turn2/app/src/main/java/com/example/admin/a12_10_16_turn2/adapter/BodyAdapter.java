package com.example.admin.a12_10_16_turn2.adapter;

import android.content.ClipData;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.admin.a12_10_16_turn2.R;
import com.example.admin.a12_10_16_turn2.jsonmodels.Item;

import java.util.List;

/**
 * Created by admin on 13/10/2016.
 */

public class BodyAdapter extends ArrayAdapter<Item> {
    public BodyAdapter(Context context, int resource, Item[] objects) {
        super(context, resource, objects);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater layoutInflater = LayoutInflater.from(this.getContext());

        convertView = layoutInflater.inflate(R.layout.layout_json, parent, false);

        Item item = getItem(position);

        TextView tvTitle = (TextView) convertView.findViewById(R.id.tv_title);
        TextView tvBody = (TextView) convertView.findViewById(R.id.tv_body);
        TextView tvUserId = (TextView) convertView.findViewById(R.id.tv_user_id);

        tvTitle.setText(item.getTitle());
        tvBody.setText(item.getBody());
        tvUserId.setText(item.getUserId());

        return convertView;
    }
}
