package com.example.guowe.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import org.xml.sax.SAXException;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

public class RSSfeed extends Activity implements OnItemClickListener {

    // 从网络获取RSS地址
    public final String RSS_URL = "http://www.hkr.se/Feeds/Feed.aspx?key=StartPageNews";

    public final String tag = "RSSReader";
    private Rss_feed feed = null;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rss_main);
        if (android.os.Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }
        try {
            feed = new RssFeed_SAXParser().getFeed(RSS_URL);
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        showListView();
    }

    /*
     * 把RSS内容绑定到ui界面进行显示
     */
    private void showListView() {

        ListView itemList = (ListView) this.findViewById(R.id.list);
        if (feed == null) {
            setTitle("访问的RSS无效");
            return;
        }
        SimpleAdapter simpleAdapter = new SimpleAdapter(this,
                feed.getAllItems(), android.R.layout.simple_list_item_2,
                new String[] { RssItem.TITLE, RssItem.PUBDATE }, new int[] {
                android.R.id.text1, android.R.id.text2 });
        itemList.setAdapter(simpleAdapter);
        itemList.setOnItemClickListener(this);
        itemList.setSelection(0);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {

        Intent intent = new Intent();
        intent.setClass(this, ShowDescriptionActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString("title", feed.getItem(position).getTitle());
        bundle.putString("description", feed.getItem(position).getDescription());
        bundle.putString("link", feed.getItem(position).getLink());
        bundle.putString("pubdate", feed.getItem(position).getPubdate());
        // 用android.intent.extra.INTENT的名字来传递参数
        intent.putExtra("android.intent.extra.rssItem", bundle);
        startActivityForResult(intent, 0);

    }

}