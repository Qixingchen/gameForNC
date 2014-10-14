package com.example.gameforresord;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.app.ActionBar.LayoutParams;
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
import android.os.Build;

public class GameActivity extends ActionBarActivity {

	private Button presentBtn;
	private Button questionBtn;
	private Button memoryBtn;
	private Button guessBtn;
	private Button more1Btn;
	private Button more2Btn;
	
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
		
		presentBtn.setOnTouchListener(new OnTouchListener() {
			
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				// TODO Auto-generated method stub
				
//				LinearLayout.LayoutParams btn_params = new LinearLayout.LayoutParams(
//						LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
				
//				float pre_height,pre_width;
//				pre_width = v.getWidth();
//				pre_height = v.getHeight();
				
				if(event.getAction()==MotionEvent.ACTION_DOWN){//press
//					btn_params.height = (int) (pre_height*9/10);
//					btn_params.width = (int) (pre_width*6/7);
//					presentBtn.setLayoutParams(btn_params);
	            }else{ //normal  
//	            	btn_params.height =  (int) pre_height;
//					btn_params.width =   (int) pre_width;
//					presentBtn.setLayoutParams(btn_params);
	            }  
				return false;
			}
		});
	}
}
