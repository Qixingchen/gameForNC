package com.example.gameforresord;

import android.content.Context;
import android.widget.Toast;

public class ReturnTouchNumber {

	Context mContext;

	/** Instantiate the interface and set the context */
	ReturnTouchNumber(Context c) {
		mContext = c;
	}

	public void returnans(int k) {
		Toast.makeText(mContext, String.valueOf(k), Toast.LENGTH_LONG).show();
	}

}
