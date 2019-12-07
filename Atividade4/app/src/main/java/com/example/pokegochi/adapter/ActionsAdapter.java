package com.example.pokegochi.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.pokegochi.R;
import com.example.pokegochi.model.Action;

import java.util.ArrayList;

public class ActionsAdapter extends ArrayAdapter<Action> {

    public ActionsAdapter(Context context, ArrayList<Action> actions) {
        super(context, 0, actions);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        Action action = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_list, parent, false);
        }
        // Lookup view for data population
        TextView nomeAction = (TextView) convertView.findViewById(R.id.nomeAction);
        TextView tipoAction = (TextView) convertView.findViewById(R.id.tipoAction);
        TextView valorAction = (TextView) convertView.findViewById(R.id.valorAction);
        // Populate the data into the template view using the data object
        nomeAction.setText(action.nome);
        tipoAction.setText(action.tipo);
        valorAction.setText(Integer.toString(action.valor));
        // Return the completed view to render on screen
        return convertView;
    }
}