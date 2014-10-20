package com.example.gameforresord;

import java.io.IOException;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;
import android.util.Log;
import android.webkit.JavascriptInterface;

public class AudioInterface {
	Context mContext;
	public MediaPlayer mp;

	// http://www.codeproject.com/Tips/677841/Playing-Audio-on-Android-from-an-HTML-File

	AudioInterface(Context c) {
		mContext = c;
	}

	// Play an audio file from the webpage
	@JavascriptInterface
	public void playAudio(String aud) { // String aud - file name passed
										// from the JavaScript function

		try {
			AssetFileDescriptor fileDescriptor = mContext.getAssets().openFd(
					aud);
			mp = new MediaPlayer();
			mp.setDataSource(fileDescriptor.getFileDescriptor(),
					fileDescriptor.getStartOffset(), fileDescriptor.getLength());
			fileDescriptor.close();
			mp.prepare();
			mp.start();
			mp.setLooping(true);
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			Log.e("music", "error");
			e.printStackTrace();
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			Log.e("music", "error");
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			Log.e("music", "error");
			e.printStackTrace();
		}
	}

	// 返回true 表示被暫停
	@JavascriptInterface
	public Boolean pauseAudio() {
		if (mp.isPlaying()) {
			mp.pause();
			return true;
		}
		else {
			mp.start();
			return false;
		}
		
		
		
	}
}
