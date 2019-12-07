package com.example.pokegochi.config;

import com.example.pokegochi.model.Pokemon;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface JsonPlaceHolderApi {
    @GET("pokemon/{name}")
    Call<Pokemon> getPokemon(@Path("name") String name);
}
