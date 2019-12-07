package com.example.pokegochi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ApplicationHome extends AppCompatActivity {
    int id;
    String name, url;

    @BindView(R.id.textView3)
    TextView nameText;

    @BindView(R.id.textView4)
    TextView idText;

    @BindView(R.id.imageView)
    ImageView spritePokemon;

    @BindView(R.id.carinhoNumber)
    TextView carinhoNumber;
    @BindView(R.id.carinhoStatus)
    TextView carinhoStatus;
    @BindView(R.id.saudeNumber)
    TextView saudeNumber;
    @BindView(R.id.saudeStatus)
    TextView saudeStatus;
    @BindView(R.id.treinamentoNumber)
    TextView treinamentoNumber;
    @BindView(R.id.treinamentoStatus)
    TextView treinamentoStatus;

    @BindView(R.id.action)
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_application_home);

        ButterKnife.bind(this);

        Bundle bundle = getIntent().getExtras();

        id = bundle.getInt("ID_POKEMON");
        name = bundle.getString("NAME_POKEMON");
        url = bundle.getString("URL_POKEMON");




        carinhoNumber.setText(Integer.toString(bundle.getInt("CARINHO_NUMBER")));
        saudeNumber.setText(Integer.toString(bundle.getInt("SAUDE_NUMBER")));
        treinamentoNumber.setText(Integer.toString(bundle.getInt("TREINAMENTO_NUMBER")));
        setStatus(carinhoNumber,carinhoStatus);
        setStatus(saudeNumber,saudeStatus);
        setStatus(treinamentoNumber,treinamentoStatus);

        nameText.setText(name);
        idText.setText(Integer.toString(id));
        Picasso.get().load(url).resize(400, 400)
                .centerCrop().into(spritePokemon);
    }
    public void setStatus(TextView number, TextView status){
        int numberInt =Integer.parseInt(number.getText().toString());
        if(numberInt<=5 && numberInt>=0){
            status.setText("Níveis críticos!");
            return;
        }
        if(numberInt<=15){
            status.setText("Níveis estáveis! Precisa de melhoras");
            return;
        }
        else {
            status.setText("Tudo Perfeito!");
            return;
        }

    }

    public void goToAction(View view ){
        Intent intent = new Intent(ApplicationHome.this,ListActions.class);

        intent.putExtra("NAME_POKEMON",nameText.getText());
        intent.putExtra("ID_POKEMON",Integer.parseInt(idText.getText().toString()));
        intent.putExtra("URL_POKEMON",url);
        intent.putExtra("CARINHO_NUMBER",Integer.parseInt(carinhoNumber.getText().toString()));
        intent.putExtra("SAUDE_NUMBER",Integer.parseInt(saudeNumber.getText().toString()));
        intent.putExtra("TREINAMENTO_NUMBER",Integer.parseInt(treinamentoNumber.getText().toString()));
        startActivity(intent);
    }
}
