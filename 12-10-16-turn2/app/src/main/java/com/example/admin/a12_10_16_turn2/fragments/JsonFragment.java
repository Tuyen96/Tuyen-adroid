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
import com.example.admin.a12_10_16_turn2.adapter.BodyAdapter;
import com.example.admin.a12_10_16_turn2.constants.Constants;
import com.example.admin.a12_10_16_turn2.jsonmodels.Item;
import com.google.gson.Gson;

import java.io.IOException;

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
public class JsonFragment extends Fragment {
    public static final String TAG = JsonFragment.class.toString() ;

@BindView(R.id.lv_bodyjson)
    ListView lvBodyJson;

    public JsonFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_json, container, false);
        setupUI();
        ButterKnife.bind(this, view);
        return view;
    }

    private void setupUI() {
        OkHttpClient client = new OkHttpClient();
        final Request request = new Request.Builder().url(Constants.FAKE_JSON_API).build();
        client.newCall(request).enqueue(new Callback() {


            @Override
            public void onFailure(Call call, IOException e) {
                Log.d(TAG, "onFailure");
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String bodyString = response.body().string();
                Log.d(TAG, "onResponse: " + bodyString);
                if(bodyString != null){
                    Gson gson = new Gson();
                    Item[] items = gson.fromJson(bodyString, Item[].class);
                    Log.d(TAG, items.length + "");
                    JsonFragment.this.updateBody(items);
                }
            }
        });
    }


    private void updateBody(final Item[] items) {
        Activity parent = getActivity();
        parent.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                BodyAdapter bodyAdapter = new BodyAdapter(
                        getContext(),
                        R.layout.layout_json,
                        items
                );
                lvBodyJson.setAdapter(bodyAdapter);
            }
        });
    }

}
