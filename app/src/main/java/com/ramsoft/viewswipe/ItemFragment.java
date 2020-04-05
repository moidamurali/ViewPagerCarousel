package com.ramsoft.viewswipe;
/*
 * 
 * Copyright (C) 2020 Murali Mohan
 * 
 *  */

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public final class ItemFragment extends Fragment {

    private TextView title;
    private RelativeLayout card;
    private int colorVal;
    String[] values = new String[]{"Google", "Samsung", "HTC", "Motorola", "RealMe", "Oppo"};

    public static ItemFragment newInstance(String content, Context c, int colorCode) {

        ItemFragment fragment = new ItemFragment();
        fragment.mContent = content;
        fragment.colorVal = colorCode;
        return fragment;
    }

    private String mContent = "???";
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        ViewGroup Rootview = (ViewGroup) inflater.inflate(R.layout.list_item,
                container, false);
        int bg = Color.rgb((int) Math.floor(Math.random() * 128) + 64,
                (int) Math.floor(Math.random() * 128) + 64,
                (int) Math.floor(Math.random() * 128) + 64);
        ListView listView = (ListView) Rootview.findViewById(R.id.list_View);

        listView.setAdapter(new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_1, values){
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                TextView textView = (TextView) super.getView(position, convertView, parent);
                textView.setTextColor(Color.WHITE);
                return textView;
            }

        });
        card = (RelativeLayout) Rootview.findViewById(R.id.card);
        //card.setBackgroundColor(bg);
        //card.setBackgroundColor(colorVal);
        card.setBackgroundResource(colorVal);
        title = (TextView) Rootview.findViewById(R.id.title);
        title.setText("" + mContent);
        title.setTextColor(Color.WHITE);
        Button show = (Button) Rootview.findViewById(R.id.viewSwitcher);
        listView.setOnItemClickListener(new OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
                                    long arg3) {
                Toast.makeText(getActivity(), values[arg2], Toast.LENGTH_SHORT)
                        .show();

            }
        });
        show.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), DetailViewActivity.class);
                startActivity(i);

            }
        });
        return Rootview;
    }
}
