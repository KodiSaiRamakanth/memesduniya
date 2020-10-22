package com.example.memesduniya;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.memesduniya.recyclerview.Adapter;
import com.example.memesduniya.retrofit.model.Photosmodel;
import com.example.memesduniya.retrofit.repository.Api;
import com.example.memesduniya.retrofit.repository.Retroclient;
import com.example.memesduniya.retrofit.viewmodel.photosViewModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    photosViewModel mViewmodel;
    Adapter adapter;
    RecyclerView recyclerView;
TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.text123);
        mViewmodel = ViewModelProviders.of(this).get(photosViewModel.class);
        mViewmodel.getTest().setValue("hello world");


        /*Create handle for the RetrofitInstance interface*/
        Api service = Retroclient.getRetrofitInstance().create(Api.class);
        Call<List<Photosmodel>> call = service.getAllPhotos();
        call.enqueue(new Callback<List<Photosmodel>>() {
            @Override
            public void onResponse(Call<List<Photosmodel>> call, Response<List<Photosmodel>> response) {

                
                generateDataList(response.body());
                Log.i("TAG", "onResponse: ");
            }

            @Override
            public void onFailure(Call<List<Photosmodel>> call, Throwable t) {
            }
        });

    }
    private void generateDataList(List<Photosmodel> photoList) {
        recyclerView = findViewById(R.id.recycle);
        adapter = new Adapter(this,photoList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }


}