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
	AudioInterface musicplayer;
	ReturnTouchNumber returnans;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_memory_flip);
		
		musicplayer = new AudioInterface(getApplicationContext());
		returnans = new ReturnTouchNumber(getApplicationContext());

	}
	@Override
	public void onResume() {
	    super.onResume();  // Always call the superclass method first
	    
	    GameWebView = (WebView) findViewById(R.id.memoryFlipWebviewLayout);
	    GameWebView.loadUrl(getString(R.string.gameWebviewUrl));
	    WebSettings webSettings = GameWebView.getSettings();
	    webSettings.setJavaScriptEnabled(true);
	    
	    GameWebView.addJavascriptInterface(musicplayer, "musicplayer");
		GameWebView.addJavascriptInterface(returnans, "returnans");

	}	
	@Override
	public void onPause() {
		super.onPause(); // Always call the superclass method first

		musicplayer.mp.stop();
	}

}
