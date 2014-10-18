package com.example.gameforresord;

import android.support.v4.app.Fragment;
import android.app.ActionBar.LayoutParams;
import android.app.Activity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;
import android.os.Build;

public class GameActivity extends Activity {

	private Button presentBtn;
	private Button questionBtn;
	private Button memoryBtn;
	private Button guessBtn;
	private Button more1Btn;
	private Button more2Btn;
	int pre_height;
	float pre_width;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_game);

		presentBtn = (Button) findViewById(R.id.game_present);
		questionBtn = (Button) findViewById(R.id.game_question);
		memoryBtn = (Button) findViewById(R.id.game_memory);
		guessBtn = (Button) findViewById(R.id.game_guess);
		more1Btn = (Button) findViewById(R.id.game_more1);
		more2Btn = (Button) findViewById(R.id.game_more2);

		LinearLayout.LayoutParams btn_params = new LinearLayout.LayoutParams(
				LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
		

		presentBtn.setOnTouchListener(new OnTouchListener() {

			/*
			 * (non-Javadoc)
			 * 
			 * @see android.view.View.OnTouchListener#onTouch(android.view.View,
			 * android.view.MotionEvent)
			 */
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				// TODO Auto-generated method stub

				LinearLayout.LayoutParams btn_params = new LinearLayout.LayoutParams(
						LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);

				if (event.getAction() == MotionEvent.ACTION_DOWN) {// press
					btn_params.height = (int) (pre_height * 9 / 10);
					btn_params.width = (int) (pre_width * 6 / 7);
					presentBtn.setLayoutParams(btn_params);
				} else { // normal
					btn_params.height = (int) pre_height;
					btn_params.width = (int) pre_width;
					presentBtn.setLayoutParams(btn_params);
				}
				return false;
			}
		});
	}
	
	@Override
	public void onResume() {
	    super.onResume();  // Always call the superclass method first

	    // Get the Camera instance as the activity achieves full user focus
	    pre_width = presentBtn.getWidth();
		pre_height = presentBtn.getHeight();
		Toast.makeText(
				getApplicationContext(),
				"pre_width:" + Float.toString(pre_width) + "pre_height:"
						+ Integer.toString(pre_height), Toast.LENGTH_SHORT)
				.show();
	}
}
