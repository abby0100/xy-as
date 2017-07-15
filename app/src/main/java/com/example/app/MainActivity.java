package com.example.app;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;


public class MainActivity extends Activity {

    private static final String LOT_TAG = "MainActivity";
    private WebView mWebView;
    private Button buttonWebview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonWebview = (Button) findViewById(R.id.button_webview);
        buttonWebview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openBrowser();
                buttonWebview.setVisibility(View.GONE);
                mWebView.setVisibility(View.VISIBLE);
            }
        });
    }

    private void openBrowser() {
        mWebView = (WebView) findViewById(R.id.activity_main_webview);
        mWebView.loadUrl("http://www.baidu.com/");
        // Force links and redirects to open in the WebView instead of in a browser
        mWebView.setWebViewClient(new WebViewClient());

        // Enable Javascript
        WebSettings webSettings = mWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        Log.d(LOT_TAG, "onKeyDown keyCode: " + keyCode);
        if (KeyEvent.KEYCODE_BACK == keyCode) {
            buttonWebview.setVisibility(View.VISIBLE);
            mWebView.setVisibility(View.GONE);
            return true;
        } else {
            return super.onKeyDown(keyCode, event);
        }
    }
}