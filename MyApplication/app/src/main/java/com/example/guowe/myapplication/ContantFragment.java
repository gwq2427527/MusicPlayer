package com.example.guowe.myapplication;

import android.app.Fragment;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by guowe on 2016/3/29.
 */
public class ContantFragment extends Fragment {
    private Button b1;
    private Button b2;
    private ContantFragment data;
    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {


        return inflater.inflate( R.layout.fragment_three, container, false);
    }
    public void onActivityCreated(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onActivityCreated(savedInstanceState);
        b1=(Button)getView().findViewById(R.id.call);
        b2=(Button)getView().findViewById(R.id.email);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent in = new Intent();
                in.setAction(Intent.ACTION_CALL);
                in.setData(Uri.parse("tel:0700181598"));
                startActivity(in);
                System.out.println("------------------------------------");


            }
        });


        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent data=new Intent(Intent.ACTION_SENDTO);
                data.setData(Uri.parse("mailto:info@hkr.se"));
                data.putExtra(Intent.EXTRA_SUBJECT, "Title");
                data.putExtra(Intent.EXTRA_TEXT, "Details");
                startActivity(data);


            }
        });
    }
}
