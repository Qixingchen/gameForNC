package com.example.gameforresord;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.GridView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

public class GameGuessActivity extends Activity implements OnClickListener {
	private Button answeronebutton, answertwobutton, answerthreebutton,answerfourbutton,answerfivebutton;
	private String answerone = null, answertwo = null, answerthree = null, answerfour = null, answerfive = null;
	private TextView rightnum, time;
	private String bump = "火烧飞鱼大变番茄龙凤八宝粥一撮脚毛火龙果炒小米虾阿凡达中国化小当家调皮的猫驴打滚骑马射箭";
	private CountDownTimer cdt;
	private GridView gridview;
	private String answer[] = { "成龙", "周杰伦", "周星驰", "梁朝伟", "黄宏", "陈佩斯", "马三立", "丫蛋",
			"巩汉林","杨坤" };
	private int i, j;
	// private GridViewDate gvd = new GridViewDate();
	private List<Map<String, Object>> list;
	// private int a = 0;
	public static final String APP_ID = "wx0ef31f9f0ab2b668";
	private static final int THUMB_SIZE = 150;

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		// 隐藏系统任务栏
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.activity_guess);
		init();
		// datalist=rand.listdate(inputStream, answer)
		rightnum = (TextView)findViewById(R.id.game_rightnum);
		time = (TextView)findViewById(R.id.game_timelimit);
		/**********************************/
		answeronebutton.setOnClickListener(this);
		answertwobutton.setOnClickListener(this);
		answerthreebutton.setOnClickListener(this);
		/******************/

	}


	private void init() {
		answeronebutton = (Button) findViewById(R.id.game_answerone);
		answertwobutton = (Button) findViewById(R.id.game_answertwo);
		answerthreebutton = (Button) findViewById(R.id.game_answerthree);
		answerfourbutton = (Button) findViewById(R.id.game_answerfour);
		answerfivebutton = (Button) findViewById(R.id.game_answerfive);
		time = (TextView) findViewById(R.id.game_timelimit);
		gridview = (GridView) findViewById(R.id.game_gridView1);
	}

	@Override
	public void onClick(View v) {
		int id = v.getId();
		switch (id) {
		case R.id.game_answerone:
			answeronebutton.setText("");
			break;
		case R.id.game_answertwo:
			answertwobutton.setText("");
			break;
		case R.id.game_answerthree:
			answerthreebutton.setText("");
			break;
		case R.id.game_answerfour:
			answerfourbutton.setText("");
			break;
		case R.id.game_answerfive:
			answerfivebutton.setText("");
			break;
		}
	}

	public void anwone() {
		answeronebutton.setVisibility(View.GONE);
		answertwobutton.setVisibility(View.VISIBLE);
		answerthreebutton.setVisibility(View.GONE);
		answerfourbutton.setVisibility(View.GONE);
		answerfivebutton.setVisibility(View.GONE);
		Log.d("GameActivity", "GridView");
		gridview.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				answertwobutton.setText(list.get(position).get("textview")
						.toString());
				answertwo = list.get(position).get("textview").toString();
				if (answertwo.equals(answer[i])) {
					answertwobutton.setTextColor(Color.GREEN);
					i++;
				} else {
					answertwobutton.setTextColor(Color.RED);
				}

			}

		});
	}

	public void anwtwo() {
		answeronebutton.setVisibility(View.VISIBLE);
		answertwobutton.setVisibility(View.GONE);
		answerthreebutton.setVisibility(View.VISIBLE);
		answerfourbutton.setVisibility(View.GONE);
		answerfivebutton.setVisibility(View.GONE);
		gridview.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				if ((answeronebutton.getText().toString()).equals("")) {
					answeronebutton.setText(list.get(position).get("textview")
							.toString());
					answerone = list.get(position).get("textview").toString();
					if ((answerone + answerthree).equals(answer[i])) {
						i++;
						answeronebutton.setTextColor(Color.GREEN);
						answerthreebutton.setTextColor(Color.GREEN);
					}
				} else if ((answerthreebutton.getText().toString()).equals("")) {
					answerthreebutton.setText(list.get(position)
							.get("textview").toString());
					answerthree = list.get(position).get("textview").toString();
					if ((answerone + answerthree).equals(answer[i])) {
						i++;
						answeronebutton.setTextColor(Color.GREEN);
						answerthreebutton.setTextColor(Color.GREEN);
					}
				}
			}

		});
	}

	public void anwthree() {
		answeronebutton.setVisibility(View.VISIBLE);
		answertwobutton.setVisibility(View.VISIBLE);
		answerthreebutton.setVisibility(View.VISIBLE);
		answerfourbutton.setVisibility(View.GONE);
		answerfivebutton.setVisibility(View.GONE);
		gridview.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {

				if ((answeronebutton.getText().toString()).equals("")) {
					answeronebutton.setText(list.get(position).get("textview")
							.toString());
					answerone = list.get(position).get("textview").toString();
					if ((answerone + answertwo + answerthree).equals(answer[i])) {
						i++;
						answeronebutton.setTextColor(Color.GREEN);
						answertwobutton.setTextColor(Color.GREEN);
						answerthreebutton.setTextColor(Color.GREEN);
					}
				} else if ((answertwobutton.getText().toString()).equals("")) {
					answertwobutton.setText(list.get(position).get("textview")
							.toString());
					answertwo = list.get(position).get("textview").toString();
					if ((answerone + answertwo + answerthree).equals(answer[i])) {
						i++;
						answeronebutton.setTextColor(Color.GREEN);
						answertwobutton.setTextColor(Color.GREEN);
						answerthreebutton.setTextColor(Color.GREEN);
					}

				} else if ((answerthreebutton.getText().toString()).equals("")) {
					answerthreebutton.setText(list.get(position)
							.get("textview").toString());
					answerthree = list.get(position).get("textview").toString();
					if ((answerone + answertwo + answerthree).equals(answer[i])) {
						i++;
						answeronebutton.setTextColor(Color.GREEN);
						answertwobutton.setTextColor(Color.GREEN);
						answerthreebutton.setTextColor(Color.GREEN);
					}
				}
			}

		});

	}
	public void anwfour() {
		answeronebutton.setVisibility(View.VISIBLE);
		answertwobutton.setVisibility(View.VISIBLE);
		answerthreebutton.setVisibility(View.VISIBLE);
		answerfourbutton.setVisibility(View.VISIBLE);
		answerfivebutton.setVisibility(View.GONE);
		gridview.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {

				if ((answeronebutton.getText().toString()).equals("")) {
					answeronebutton.setText(list.get(position).get("textview")
							.toString());
					answerone = list.get(position).get("textview").toString();
					if ((answerone + answertwo + answerthree + answerfour).equals(answer[i])) {
						i++;
						answeronebutton.setTextColor(Color.GREEN);
						answertwobutton.setTextColor(Color.GREEN);
						answerthreebutton.setTextColor(Color.GREEN);
						answerfourbutton.setTextColor(Color.GREEN);
					}
				} else if ((answertwobutton.getText().toString()).equals("")) {
					answertwobutton.setText(list.get(position).get("textview")
							.toString());
					answertwo = list.get(position).get("textview").toString();
					if ((answerone + answertwo + answerthree + answerfour).equals(answer[i])) {
						i++;
						answeronebutton.setTextColor(Color.GREEN);
						answertwobutton.setTextColor(Color.GREEN);
						answerthreebutton.setTextColor(Color.GREEN);
						answerfourbutton.setTextColor(Color.GREEN);
					}

				} else if ((answerthreebutton.getText().toString()).equals("")) {
					answerthreebutton.setText(list.get(position)
							.get("textview").toString());
					answerthree = list.get(position).get("textview").toString();
					if ((answerone + answertwo + answerthree + answerfour).equals(answer[i])) {
						i++;
						answeronebutton.setTextColor(Color.GREEN);
						answertwobutton.setTextColor(Color.GREEN);
						answerthreebutton.setTextColor(Color.GREEN);
						answerfourbutton.setTextColor(Color.GREEN);
					}
				}else if ((answerfourbutton.getText().toString()).equals("")) {
					answerfourbutton.setText(list.get(position)
							.get("textview").toString());
					answerfour = list.get(position).get("textview").toString();
					if ((answerone + answertwo + answerthree + answerfour).equals(answer[i])) {
						i++;
						answeronebutton.setTextColor(Color.GREEN);
						answertwobutton.setTextColor(Color.GREEN);
						answerthreebutton.setTextColor(Color.GREEN);
						answerfourbutton.setTextColor(Color.GREEN);
					}
				}
				

			}

		});

	}
	public void anwfive() {
		answeronebutton.setVisibility(View.VISIBLE);
		answertwobutton.setVisibility(View.VISIBLE);
		answerthreebutton.setVisibility(View.VISIBLE);
		answerfourbutton.setVisibility(View.VISIBLE);
		answerfivebutton.setVisibility(View.VISIBLE);
		gridview.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {

				if ((answeronebutton.getText().toString()).equals("")) {
					answeronebutton.setText(list.get(position).get("textview")
							.toString());
					answerone = list.get(position).get("textview").toString();
					if ((answerone + answertwo + answerthree + answerfour + answerfive).equals(answer[i])) {
						i++;
						answeronebutton.setTextColor(Color.GREEN);
						answertwobutton.setTextColor(Color.GREEN);
						answerthreebutton.setTextColor(Color.GREEN);
						answerfourbutton.setTextColor(Color.GREEN);
						answerfivebutton.setTextColor(Color.GREEN);
					}
				} else if ((answertwobutton.getText().toString()).equals("")) {
					answertwobutton.setText(list.get(position).get("textview")
							.toString());
					answertwo = list.get(position).get("textview").toString();
					if ((answerone + answertwo + answerthree + answerfour + answerfive).equals(answer[i])) {
						i++;
						answeronebutton.setTextColor(Color.GREEN);
						answertwobutton.setTextColor(Color.GREEN);
						answerthreebutton.setTextColor(Color.GREEN);
						answerfourbutton.setTextColor(Color.GREEN);
						answerfivebutton.setTextColor(Color.GREEN);
					}

				} else if ((answerthreebutton.getText().toString()).equals("")) {
					answerthreebutton.setText(list.get(position)
							.get("textview").toString());
					answerthree = list.get(position).get("textview").toString();
					if ((answerone + answertwo + answerthree + answerfour + answerfive).equals(answer[i])) {
						i++;
						answeronebutton.setTextColor(Color.GREEN);
						answertwobutton.setTextColor(Color.GREEN);
						answerthreebutton.setTextColor(Color.GREEN);
						answerfourbutton.setTextColor(Color.GREEN);
						answerfivebutton.setTextColor(Color.GREEN);
					}
				}else if ((answerfourbutton.getText().toString()).equals("")) {
					answerfourbutton.setText(list.get(position)
							.get("textview").toString());
					answerfour = list.get(position).get("textview").toString();
					if ((answerone + answertwo + answerthree + answerfour + answerfive).equals(answer[i])) {
						i++;
						answeronebutton.setTextColor(Color.GREEN);
						answertwobutton.setTextColor(Color.GREEN);
						answerthreebutton.setTextColor(Color.GREEN);
						answerfourbutton.setTextColor(Color.GREEN);
						answerfivebutton.setTextColor(Color.GREEN);
					}
				}else if ((answerfourbutton.getText().toString()).equals("")) {
					answerfivebutton.setText(list.get(position)
							.get("textview").toString());
					answerfive = list.get(position).get("textview").toString();
					if ((answerone + answertwo + answerthree + answerfour + answerfive).equals(answer[i])) {
						i++;
						answeronebutton.setTextColor(Color.GREEN);
						answertwobutton.setTextColor(Color.GREEN);
						answerthreebutton.setTextColor(Color.GREEN);
						answerfourbutton.setTextColor(Color.GREEN);
						answerfivebutton.setTextColor(Color.GREEN);
					}
				}
				

			}

		});

	}
	/******************** 每一关都执行的方法 *****************************/
	public void anw() {
		rightnum.setText("当前答对题目数：" + (i + 1));
		cdt = new CountDownTimer(20000, 100) {

			@Override
			public void onTick(long millisUntilFinished) {

				time.setText(String.valueOf(millisUntilFinished / 1000));
			}

			@Override
			public void onFinish() {
				Log.d("onFinish", "Finish");
			}

		}.start();
		if (answer[i].length() == 1) {
			anwone();
		}
		else if (answer[i].length() == 2) {
			anwtwo();
		}
		else if (answer[i].length() == 3) {
			anwthree();
		}else if (answer[i].length() == 4) {
			anwfour();
		}else if (answer[i].length() == 5) {
			anwfive();
		}

	}
	/********************** GRIDVIEW适配数据 *************************/
	public void gridlist() {
		int btm=0,n;int[] rightpl = null;
		for(n=0;n<answer[i].length();n++){
			rightpl[n]= btm + (int)(Math.random()*20%(16/answer[i].length()));
			btm+=16/answer[i].length();
		}
		n=0;
		// datalist=rand.listdate(inputStream, answer)
		 char[] word=answer[i].toCharArray(),
	        		temp=bump.toCharArray(); 
		list = new ArrayList<Map<String, Object>>();
		for (int z = 0; z < 16; z++) {
			Map<String, Object> listitem = new HashMap<String, Object>();
			if(n<answer[i].length()&&z==rightpl[n]){
				n++;listitem.put("textview", word[n]);
			}else{
				listitem.put("textview", temp[(int) (Math.random()*temp.length)]);
			}
			list.add(listitem);
		}
		SimpleAdapter simpleAdapter = new SimpleAdapter(this, list,
				R.layout.game_gridview_item, new String[] { "textview" },
				new int[] { R.id.gridviewtextview });
		gridview.setAdapter(simpleAdapter);
	}

	@Override
	protected void onStart() {
		gridlist();
		/***************************************************/
		// 判断当前答案为几个字
		anw();
		/***************************************************/

		super.onStart();
	}

	@Override
	protected void onPause() {
		Log.d("onPause", "Pause");
		cdt.cancel();
		super.onPause();
	}

	@Override
	protected void onResume() {
		Log.d("onResume", "Resume");
		super.onResume();
	}

	@Override
	protected void onStop() {
		Log.d("onStop", "Stop");
		super.onStop();
	}

	@Override
	protected void onDestroy() {
		Log.d("onDestroy", "Destroy");
		super.onDestroy();
		cdt = null;
	}

}
