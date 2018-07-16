package com.potato.wahidsadique.androiddumbstructure.ui.activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.view.View;

import com.potato.wahidsadique.androiddumbstructure.R;
import com.potato.wahidsadique.androiddumbstructure.utility.GlobalConstants;

public class NewsActivity extends AppCompatActivity {
    private WebView newsWebView;
    private String newsSourceUrl, newsSourceName;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);
        initializeWidgets();
        initializeData();
        eventListeners();
    }

    private void initializeWidgets() {
        newsWebView = findViewById(R.id.newsWebView);
        progressBar = findViewById(R.id.news_progress_bar);
    }

    private void initializeData() {
        newsSourceUrl = getIntent().getStringExtra(GlobalConstants.EXT_TAG_URL);
        newsSourceName = getIntent().getStringExtra(GlobalConstants.EXT_TAG_NAME);
        newsWebView.setWebViewClient(new NewsWebViewClient());
        newsWebView.loadUrl(newsSourceUrl);
        getSupportActionBar().setTitle(newsSourceName);
        progressBar.setVisibility(View.GONE);
    }

    private void eventListeners() {

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home: {
                Intent intent = new Intent(this, HomeTabActivity.class);
                startActivity(intent);
                finish();
                return true;
            }
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private class NewsWebViewClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            return false;
        }

        @Override
        public void onPageFinished(WebView view, String url) {
            progressBar.setVisibility(View.GONE);
            NewsActivity.this.progressBar.setProgress(100);
            super.onPageFinished(view, url);
        }

        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            progressBar.setVisibility(View.VISIBLE);
            NewsActivity.this.progressBar.setProgress(0);
            super.onPageStarted(view, url, favicon);
        }
    }

    void setValue(int progress) {
        this.progressBar.setProgress(progress);
    }
}
