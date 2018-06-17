package com.example.guowe.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class ShowDescriptionActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.description_detail);
        String content =null;

        Intent intent = getIntent();
        if(intent!=null){
            Bundle bundle = intent.getBundleExtra("android.intent.extra.rssItem");
            if(bundle==null){
                content = "Error";
            }else{

                content = bundle.getString("title") + "\n\n"
                        + bundle.getString("pubdate") + "\n\n"
                        + bundle.getString("description").replace('\n', ' ')
                        + "\n\nClick Link Below:\n" + bundle.getString("link");

            }
        }else{
            content = "Error";
        }

        TextView contentText = (TextView) this.findViewById(R.id.content);
        contentText.setText(content);

        Button backButton = (Button) this.findViewById(R.id.back);
        backButton.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

}
