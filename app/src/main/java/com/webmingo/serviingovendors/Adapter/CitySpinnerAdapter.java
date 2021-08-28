package com.webmingo.serviingovendors.Adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;


import com.webmingo.serviingovendors.R;
import com.webmingo.serviingovendors.model.CityModel;

import java.util.ArrayList;

public class CitySpinnerAdapter extends BaseAdapter {
    Context context;
    ArrayList<CityModel>arrayListt;
    LayoutInflater inflter;

    public CitySpinnerAdapter(Context context, ArrayList<CityModel> arrayList) {
        this.context = context;
        this.arrayListt = arrayList;
        inflter = (LayoutInflater.from(context));

    }




    @Override
    public int getCount() {
        return arrayListt.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        view = inflter.inflate(R.layout.state_layout, null);
        TextView coinNames = (TextView) view.findViewById(R.id.coinName);
        //TextView coinSymbol = (TextView) view.findViewById(R.id.coinsymbols);

       // coinImages.setImageResource(coinImage[i]);

        if (arrayListt.get(position).getId().equalsIgnoreCase("00"))
        {
            coinNames.setText(arrayListt.get(position).getName());
            coinNames.setTextColor(Color.parseColor("#757575"));

        }
        else {
            coinNames.setText(arrayListt.get(position).getName());

        }




        return view;
    }
    }

