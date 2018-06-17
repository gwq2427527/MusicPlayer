package com.example.guowe.myapplication;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by guowe on 2016/3/29.
 */
public class RssFragment  extends Fragment {
    Button b1;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.rss_fragment,container,false);




        b1=(Button)view.findViewById(R.id.buttonRss);

        b1.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(getActivity(), RSSfeed.class);
                Bundle bundle = new Bundle();
                intent.putExtra("android.intent.extra.rssItem", bundle);
                getActivity().startActivityForResult(intent, 0);


            }
        });
        return view;
    }
    }

