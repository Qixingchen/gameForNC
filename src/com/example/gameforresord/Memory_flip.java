package com.example.gameforresord;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.HeterogeneousExpandableList;

public class Memory_flip extends Activity {
	WebView GameWebView;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_memory_flip);
	}
	@Override
	public void onResume() {
	    super.onResume();  // Always call the superclass method first

	    GameWebView = (WebView) findViewById(R.id.memoryFlipWebviewLayout);
	    GameWebView.loadUrl(getString(R.string.gameWebviewUrl));
	    WebSettings webSettings = GameWebView.getSettings();
	    webSettings.setJavaScriptEnabled(true);

	}
}
