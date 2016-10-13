package com.example.admin.a12_10_16_turn2.fragments;


import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.admin.a12_10_16_turn2.R;
import com.example.admin.a12_10_16_turn2.adapter.FlickrModeAdapter;
import com.example.admin.a12_10_16_turn2.constants.Constants;
import com.example.admin.a12_10_16_turn2.jsonmodels.JsonFlickrFeed;
import com.example.admin.a12_10_16_turn2.jsonmodels.JsonFlickrItem;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;


/**
 * A simple {@link Fragment} subclass.
 */
public class FlickrFragment extends Fragment {
    private static final String TAG = FlickrFragment.class.toString() ;
    @BindView(R.id.lv_bodyflick)
    ListView lvBodyFlick;


    public FlickrFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_flickr, container, false);
        setupUI();
        ButterKnife.bind(this, view);
        return view;
    }

    private void setupUI() {
        OkHttpClient client = new OkHttpClient();

       Request request = new Request.Builder().url(Constants.FLICK_API).build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.d(TAG,"onFailure");
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String bodyString = response.body().string();
                bodyString = bodyString.substring(
                        bodyString.indexOf("{"),
                        bodyString.length() - 1
                );
                if(bodyString != null){
                    Gson gson =  new Gson();
                    JsonFlickrFeed jsonFlickrFeed =  gson.fromJson(bodyString, JsonFlickrFeed.class);
                    List<JsonFlickrItem> flickrItems =  jsonFlickrFeed.getItems();
                    FlickrFragment.this.updatebody(flickrItems);
                }
            }
        });
    }

    private void updatebody(final List<JsonFlickrItem> flickrItems) {
        Activity parent = getActivity();
        parent.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                lvBodyFlick.setAdapter(new FlickrModeAdapter(
                        getContext(),
                        R.layout.layout_flickr,
                        flickrItems
                ));
            }
        });
    }

}
