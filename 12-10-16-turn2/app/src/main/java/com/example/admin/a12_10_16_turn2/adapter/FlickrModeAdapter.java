package com.example.admin.a12_10_16_turn2.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.admin.a12_10_16_turn2.R;
import com.example.admin.a12_10_16_turn2.jsonmodels.JsonFlickrItem;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

import java.util.List;

/**
 * Created by admin on 13/10/2016.
 */

public class FlickrModeAdapter extends ArrayAdapter<JsonFlickrItem> {
    public FlickrModeAdapter(Context context, int resource, List<JsonFlickrItem> objects) {
        super(context, resource, objects);
    }
    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        LayoutInflater layoutInflater = LayoutInflater.from(this.getContext());
        convertView =  layoutInflater.inflate(R.layout.layout_flickr, parent, false);
        JsonFlickrItem item = getItem(position);

        TextView tvTitle = (TextView) convertView.findViewById(R.id.tv_title_flick);
        TextView tvLink = (TextView) convertView.findViewById(R.id.tv_link_flick);
        TextView tvDateTaken = (TextView) convertView.findViewById(R.id.tv_date_taken_flick);
        ImageView ivMedia = (ImageView) convertView.findViewById(R.id.iv_media_flick);

        tvTitle.setText(item.getTitle());
        tvLink.setText(item.getLink());
        tvDateTaken.setText(item.getDateTaken());
        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(getContext()).build();
        ImageLoader.getInstance().init(config);
        ImageLoader.getInstance().displayImage(item.getMedia().getM(), ivMedia);

        return convertView;
    }
}
