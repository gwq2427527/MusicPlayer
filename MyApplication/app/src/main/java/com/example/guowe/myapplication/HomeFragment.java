package com.example.guowe.myapplication;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/**
 * Created by guowe on 2016/3/29.
 */
public class HomeFragment extends Fragment {
    private WebView webview;
    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {


        return inflater.inflate( R.layout.fragment_two, container, false);
    }
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        // TODO Auto-generated method stub

        setView();
        setListener();
        super.onActivityCreated(savedInstanceState);
    }


    private void setListener() {
        // TODO Auto-generated method stub
        webview.loadUrl("http://www.hkr.se");

        webview.setWebViewClient(new WebViewClient(){
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });

    }




    private void setView() {
        // TODO Auto-generated method stub
        webview=(WebView)getView().findViewById(R.id.webView);

    }
}

