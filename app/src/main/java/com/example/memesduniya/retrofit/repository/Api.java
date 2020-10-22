package com.example.memesduniya.retrofit.repository;

import com.example.memesduniya.retrofit.model.Photosmodel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Api {
    @GET("/allphoto")
    Call<List<Photosmodel>> getAllPhotos();
}
