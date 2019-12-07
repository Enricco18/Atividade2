package com.example.pokegochi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.pokegochi.config.JsonPlaceHolderApi;
import com.example.pokegochi.model.Pokemon;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class TestActivity extends AppCompatActivity {
    JsonPlaceHolderApi jsonPlaceHolderApi;
    @BindView(R.id.textView2)
    TextView txtView;
    @BindView(R.id.editText)
    EditText text;
    @BindView(R.id.button)
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        ButterKnife.bind(this);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://pokeapi.co/api/v2/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        jsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApi.class);

    }


    public void getMyPokemon(View view){

        retrofit2.Call<Pokemon> call = jsonPlaceHolderApi.getPokemon(text.getText().toString().toLowerCase());
        call.enqueue(new Callback<Pokemon>() {
            @Override
            public void onResponse(retrofit2.Call<Pokemon> call, Response<Pokemon> response) {
                if(!response.isSuccessful()){
                    txtView.setText(response.code());
                    return;
                }
                Pokemon pokemon = response.body();
                String namePokemon = pokemon.getName();
                int idPokemon = pokemon.getId();
                String urlPokemon= pokemon.getSprites().getFront_default();


                Intent intent = new Intent(TestActivity.this,ApplicationHome.class);

                intent.putExtra("NAME_POKEMON",namePokemon);
                intent.putExtra("ID_POKEMON",idPokemon);
                intent.putExtra("URL_POKEMON",urlPokemon);
                intent.putExtra("CARINHO_NUMBER",00);
                intent.putExtra("SAUDE_NUMBER",00);
                intent.putExtra("TREINAMENTO_NUMBER",00);
                startActivity(intent);


            }

            @Override
            public void onFailure(Call<Pokemon> call, Throwable t) {
                Log.e("error", "onFailure: "+ t.getMessage());
                txtView.setText(t.getMessage());
            }
        });



    }

}


