package com.example.admin.a12_10_16_turn2;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.admin.a12_10_16_turn2.fragments.FlickrFragment;
import com.example.admin.a12_10_16_turn2.fragments.JsonFragment;

import java.io.IOException;

import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = MainActivity.class.toString();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
       changeFragment(new FlickrFragment(),true,null);
      // changeFragment(new JsonFragment(),true,null);

    }

    public void changeFragment(Fragment fragment, boolean addtoBackStack, String tag) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction()
                .replace(R.id.fl_container, fragment);
        if(addtoBackStack){
            fragmentTransaction.addToBackStack(tag);
        }
        fragmentTransaction.commit();

    }


}
