package com.example.pokegochi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.pokegochi.adapter.ActionsAdapter;
import com.example.pokegochi.model.Action;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ListActions extends AppCompatActivity {

    @BindView(R.id.listView)
    ListView listView;
    String nome,url;
    int treinamentoValue, saudeValue, carinhoValue,id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_actions);

        ButterKnife.bind(this);
        Bundle bundle = getIntent().getExtras();

        id = bundle.getInt("ID_POKEMON");
        nome = bundle.getString("NAME_POKEMON");
        url = bundle.getString("URL_POKEMON");
        carinhoValue = bundle.getInt("CARINHO_NUMBER");
        saudeValue = bundle.getInt("SAUDE_NUMBER");
        treinamentoValue = bundle.getInt("TREINAMENTO_NUMBER");

        ArrayList<Action> array = new ArrayList<>();

        array.add(new Action("Correr", "treinamento", 2));
        array.add(new Action("Malhar", "treinamento", 3));
        array.add(new Action("Nadar", "treinamento", 1));
        array.add(new Action("Lutar", "treinamento", 5));
        array.add(new Action("Yoga", "treinamento", 2));
        array.add(new Action("Meditação", "treinamento", 2));
        array.add(new Action("Cross-fit", "treinamento", 5));
        array.add(new Action("Comer fruta", "saúde", 3));
        array.add(new Action("Se Hidratar", "saúde", 4));
        array.add(new Action("Tomar sol", "saúde", 1));
        array.add(new Action("Bater em neonazista", "saúde", 5));
        array.add(new Action("Tomar Whey", "saúde", 5));
        array.add(new Action("Brincar", "carinho", 5));
        array.add(new Action("Cafuné", "carinho", 3));
        array.add(new Action("Bater-papo", "carinho", 2));
        array.add(new Action("Jogar Pokemon no Game boy", "carinho", 1));
        array.add(new Action("Passear", "carinho", 4));
        ActionsAdapter adapter = new ActionsAdapter(this, array);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long i) {
                Intent intent = new Intent(ListActions.this, ApplicationHome.class);
                Action actionSelected = array.get(position);

                if (actionSelected.tipo.equals("saúde"))
                    saudeValue += actionSelected.valor;
                if (actionSelected.tipo.equals("carinho"))
                    carinhoValue += actionSelected.valor;
                if (actionSelected.tipo.equals("treinamento"))
                    treinamentoValue += actionSelected.valor;

                intent.putExtra("NAME_POKEMON", nome);
                intent.putExtra("ID_POKEMON", id);
                intent.putExtra("URL_POKEMON", url);
                intent.putExtra("CARINHO_NUMBER", carinhoValue);
                intent.putExtra("SAUDE_NUMBER", saudeValue);
                intent.putExtra("TREINAMENTO_NUMBER", treinamentoValue);
                startActivity(intent);

            }
        });
    }
}
