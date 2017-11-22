package com.example.riad.calculatorwebview;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.net.ConnectivityManager;
import java.io.InputStream;
import android.app.Activity;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.os.Handler;
import android.content.Context;
import android.net.NetworkInfo;
import android.util.Log;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    WebView myWebView =null;
    Handler mHandler=null;


    //@SuppressLint("JavascriptInterface")
    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Web View
        myWebView = (WebView)findViewById(R.id.webView1);
        myWebView.getSettings().setJavaScriptEnabled(true);
        myWebView.setWebViewClient(new WebViewClient());
        myWebView.addJavascriptInterface(new WebCalculatorView(this), "Android");

        ConnectivityManager connectivityManager = (ConnectivityManager) getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivityManager != null)
        {
            NetworkInfo netInfos = connectivityManager.getActiveNetworkInfo();
            if(netInfos != null)
            {
                if (netInfos.isConnected())
                {
                    myWebView.loadUrl("file:///android_asset/calculator.html"); //online
                }
            }
        }
        else
        {
            myWebView.loadUrl("file:///android_asset/calculator_offline.html"); //offline
        }
        mHandler = new Handler();
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
    @Override
    protected void onRestart() {
        super.onRestart();
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onResume() {
        super.onResume();
        //myWebView.loadUrl("file:///android_asset/calculator.html");
        ConnectivityManager connectivityManager = (ConnectivityManager) getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivityManager != null)
        {
            NetworkInfo netInfos = connectivityManager.getActiveNetworkInfo();
            if(netInfos != null) {
                if (netInfos.isConnected()){
                    myWebView.loadUrl("file:///android_asset/calculator.html"); //online
                }
            }
        }
        else{
            myWebView.loadUrl("file:///android_asset/calculator_offline.html"); //offline
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
    }
}

