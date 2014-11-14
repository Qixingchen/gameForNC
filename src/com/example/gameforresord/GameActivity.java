package com.example.gameforresord;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import com.example.gameforresord.R;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.LayoutParams;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

public class GameActivity extends Activity {

	private float pre_height;
	private float pre_width;

	private Button presentBtn;
	private Button questionBtn;
	private Button memoryBtn;
	private Button guessBtn;
	private Button more1Btn;
	private Button more2Btn;

	private ViewPager adViewPager;
	private LinearLayout pagerLayout;
	private List<View> pageViews;
	private ImageView[] imageViews;
	private ImageView imageView;
	private AdPageAdapter adapter;
	private AtomicInteger atomicInteger = new AtomicInteger(0);
	private boolean isContinue = true;
	private Context activityContext;
	private MaterialDialog mMaterialDialog;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_game);
		activityContext = getApplicationContext();

		presentBtn = (Button) findViewById(R.id.game_present);
		questionBtn = (Button) findViewById(R.id.game_question);
		memoryBtn = (Button) findViewById(R.id.game_memory);
		guessBtn = (Button) findViewById(R.id.game_guess);
		more1Btn = (Button) findViewById(R.id.game_more1);
		more2Btn = (Button) findViewById(R.id.game_more2);

		presentBtn.setOnTouchListener(new OnTouchListener() {

			@Override
			public boolean onTouch(View v, MotionEvent event) {
				Log.e("touchevent", event.toString());
				// TODO Auto-generated method stub
				LinearLayout.LayoutParams btn_params = new LinearLayout.LayoutParams(
						LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);

				pre_width = v.getWidth();
				pre_height = v.getHeight();

				if (event.getAction() == MotionEvent.ACTION_DOWN) {// press
					System.out.println("press");
					btn_params.height = (int) (pre_height * 13 / 14);
					btn_params.width = (int) (pre_width * 18 / 19);
					presentBtn.setLayoutParams(btn_params);
				} else if (event.getAction() == MotionEvent.ACTION_UP) { // normal
					pre_width = pre_width * 19 / 18;
					pre_height = pre_height * 14 / 13;// 恢复
					System.out.println("normal");
					System.out.println("pre_width");
					System.out.println(pre_width);
					btn_params.height = (int) pre_height;
					btn_params.width = (int) pre_width;
					System.out.println("pre_height");
					System.out.println(pre_height);
					presentBtn.setLayoutParams(btn_params);
				}
				return false;
			}
		});

		questionBtn.setOnTouchListener(new OnTouchListener() {

			@Override
			public boolean onTouch(View v, MotionEvent event) {
				Log.e("touchevent", event.toString());
				// TODO Auto-generated method stub
				LinearLayout.LayoutParams btn_params = new LinearLayout.LayoutParams(
						LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);

				pre_width = v.getWidth();
				pre_height = v.getHeight();

				if (event.getAction() == MotionEvent.ACTION_DOWN) {// press
					System.out.println("press");
					btn_params.height = (int) (pre_height * 13 / 14);
					btn_params.width = (int) (pre_width * 18 / 19);
					questionBtn.setLayoutParams(btn_params);
				} else if (event.getAction() == MotionEvent.ACTION_UP) { // normal
					pre_width = pre_width * 19 / 18;
					pre_height = pre_height * 14 / 13;// 恢复
					System.out.println("normal");
					System.out.println("pre_width");
					System.out.println(pre_width);
					btn_params.height = (int) pre_height;
					btn_params.width = (int) pre_width;
					System.out.println("pre_height");
					System.out.println(pre_height);
					questionBtn.setLayoutParams(btn_params);
				}
				return false;
			}
		});

		questionBtn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent question = new Intent(GameActivity.this,
						AnswerQuestionActivity.class);
				startActivity(question);
			}
		});

		memoryBtn.setOnTouchListener(new OnTouchListener() {

			@Override
			public boolean onTouch(View v, MotionEvent event) {
				// TODO Auto-generated method stub
				LinearLayout.LayoutParams btn_params = new LinearLayout.LayoutParams(
						LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);

				pre_width = v.getWidth();
				pre_height = v.getHeight();

				if (event.getAction() == MotionEvent.ACTION_DOWN) {// press
					System.out.println("press");
					btn_params.height = (int) (pre_height * 13 / 14);
					btn_params.width = (int) (pre_width * 18 / 19);
					memoryBtn.setLayoutParams(btn_params);
				} else if (event.getAction() == MotionEvent.ACTION_UP) { // normal
					pre_width = pre_width * 19 / 18;
					pre_height = pre_height * 14 / 13;// 恢复
					System.out.println("normal");
					System.out.println("pre_width");
					System.out.println(pre_width);
					btn_params.height = (int) pre_height;
					btn_params.width = (int) pre_width;
					System.out.println("pre_height");
					System.out.println(pre_height);
					memoryBtn.setLayoutParams(btn_params);
				}
				return false;
			}
		});

		memoryBtn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				mMaterialDialog = new MaterialDialog(GameActivity.this)
						.setTitle(
								getString(R.string.MemoryFlip_introductionTitle))
						.setMessage(
								getString(R.string.MemoryFlip_introductionMessage))
						.setPositiveButton(
								getString(R.string.MemoryFlip_introductionOk),
								new View.OnClickListener() {
									@Override
									public void onClick(View v) {
										mMaterialDialog.dismiss();
										Intent question = new Intent(
												GameActivity.this,
												Memory_flip.class);
										startActivity(question);
									}
								})
						.setNegativeButton(
								getString(R.string.MemoryFlip_introductionCancel),
								new View.OnClickListener() {
									@Override
									public void onClick(View v) {
										mMaterialDialog.dismiss();

									}
								});

				mMaterialDialog.show();

			}
		});

		guessBtn.setOnTouchListener(new OnTouchListener() {

			@Override
			public boolean onTouch(View v, MotionEvent event) {
				// TODO Auto-generated method stub
				LinearLayout.LayoutParams btn_params = new LinearLayout.LayoutParams(
						LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);

				pre_width = v.getWidth();
				pre_height = v.getHeight();

				if (event.getAction() == MotionEvent.ACTION_DOWN) {// press
					System.out.println("press");
					btn_params.height = (int) (pre_height * 13 / 14);
					btn_params.width = (int) (pre_width * 18 / 19);
					guessBtn.setLayoutParams(btn_params);
				} else if (event.getAction() == MotionEvent.ACTION_UP) { // normal
					pre_width = pre_width * 19 / 18;
					pre_height = pre_height * 14 / 13;// 恢复
					System.out.println("normal");
					System.out.println("pre_width");
					System.out.println(pre_width);
					btn_params.height = (int) pre_height;
					btn_params.width = (int) pre_width;
					System.out.println("pre_height");
					System.out.println(pre_height);
					guessBtn.setLayoutParams(btn_params);
				}
				return false;
			}
		});

		guessBtn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent guess = new Intent(GameActivity.this,
						GameGuessActivity.class);
				startActivity(guess);
			}
		});

		more1Btn.setOnTouchListener(new OnTouchListener() {

			@Override
			public boolean onTouch(View v, MotionEvent event) {
				// TODO Auto-generated method stub
				LinearLayout.LayoutParams btn_params = new LinearLayout.LayoutParams(
						LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);

				pre_width = v.getWidth();
				pre_height = v.getHeight();

				if (event.getAction() == MotionEvent.ACTION_DOWN) {// press
					System.out.println("press");
					btn_params.height = (int) (pre_height * 13 / 14);
					btn_params.width = (int) (pre_width * 18 / 19);
					more1Btn.setLayoutParams(btn_params);
				} else if (event.getAction() == MotionEvent.ACTION_UP) { // normal
					pre_width = pre_width * 19 / 18;
					pre_height = pre_height * 14 / 13;// 恢复
					System.out.println("normal");
					System.out.println("pre_width");
					System.out.println(pre_width);
					btn_params.height = (int) pre_height;
					btn_params.width = (int) pre_width;
					System.out.println("pre_height");
					System.out.println(pre_height);
					more1Btn.setLayoutParams(btn_params);
				}
				return false;
			}
		});

		more2Btn.setOnTouchListener(new OnTouchListener() {

			@Override
			public boolean onTouch(View v, MotionEvent event) {
				// TODO Auto-generated method stub
				LinearLayout.LayoutParams btn_params = new LinearLayout.LayoutParams(
						LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);

				pre_width = v.getWidth();
				pre_height = v.getHeight();

				if (event.getAction() == MotionEvent.ACTION_DOWN) {// press
					System.out.println("press");
					btn_params.height = (int) (pre_height * 13 / 14);
					btn_params.width = (int) (pre_width * 18 / 19);
					more2Btn.setLayoutParams(btn_params);
				} else if (event.getAction() == MotionEvent.ACTION_UP) { // normal
					pre_width = pre_width * 19 / 18;
					pre_height = pre_height * 14 / 13;// 恢复
					System.out.println("normal");
					System.out.println("pre_width");
					System.out.println(pre_width);
					btn_params.height = (int) pre_height;
					btn_params.width = (int) pre_width;
					System.out.println("pre_height");
					System.out.println(pre_height);
					more2Btn.setLayoutParams(btn_params);
				}
				return false;
			}
		});

		initViewPager();
	}

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();

	}

	private void initViewPager() {

		// 从布局文件中获取ViewPager父容器
		pagerLayout = (LinearLayout) findViewById(R.id.view_pager_content);

		// 创建ViewPager
		adViewPager = new ViewPager(this);

		// 获取屏幕像素相关信息
		DisplayMetrics dm = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(dm);

		// 根据屏幕信息设置ViewPager广告容器的宽高
		adViewPager.setLayoutParams(new RelativeLayout.LayoutParams(
				dm.widthPixels, dm.heightPixels / 3));

		// 将ViewPager容器设置到布局文件父容器中
		pagerLayout.addView(adViewPager);

		initPageAdapter();

		initCirclePoint();

		adViewPager.setAdapter(adapter);
		adViewPager.setOnPageChangeListener(new AdPageChangeListener());

		new Thread(new Runnable() {
			@Override
			public void run() {
				while (true) {
					if (isContinue) {
						viewHandler.sendEmptyMessage(atomicInteger.get());
						atomicOption();
					}
				}
			}
		}).start();
	}

	private void atomicOption() {
		atomicInteger.incrementAndGet();
		if (atomicInteger.get() > imageViews.length - 1) {
			atomicInteger.getAndAdd(-5);
		}
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {

		}
	}

	private final Handler viewHandler = new Handler() {

		@Override
		public void handleMessage(Message msg) {
			adViewPager.setCurrentItem(msg.what);
			super.handleMessage(msg);
		}

	};

	private void initPageAdapter() {
		pageViews = new ArrayList<View>();

		ImageView img1 = new ImageView(this);
		img1.setBackgroundResource(R.drawable.dish_1);
		pageViews.add(img1);

		ImageView img2 = new ImageView(this);
		img2.setBackgroundResource(R.drawable.dish_2);
		pageViews.add(img2);

		ImageView img3 = new ImageView(this);
		img3.setBackgroundResource(R.drawable.res_1);
		pageViews.add(img3);

		// ImageView img4 = new ImageView(this);
		// img4.setBackgroundResource(R.drawable.view_add_4);
		// pageViews.add(img4);
		//
		// ImageView img5 = new ImageView(this);
		// img5.setBackgroundResource(R.drawable.view_add_5);
		// pageViews.add(img5);
		//
		// ImageView img6 = new ImageView(this);
		// img6.setBackgroundResource(R.drawable.view_add_6);
		// pageViews.add(img6);

		adapter = new AdPageAdapter(pageViews);
	}

	private void initCirclePoint() {
		ViewGroup group = (ViewGroup) findViewById(R.id.viewGroup);
		imageViews = new ImageView[pageViews.size()];
		// 广告栏的小圆点图标

		for (int i = 0; i < pageViews.size(); i++) {

			// 创建一个ImageView, 并设置宽高. 将该对象放入到数组中
			imageView = new ImageView(this);
			imageView.setLayoutParams(new LinearLayout.LayoutParams(10, 10));
			imageViews[i] = imageView;

			// 初始值, 默认第0个选中
			if (i == 0) {
				imageViews[i].setBackgroundResource(R.drawable.point_focused);
			} else {
				imageViews[i].setBackgroundResource(R.drawable.point_unfocused);
			}

			// 将小圆点放入到布局中
			group.addView(imageViews[i]);
		}
	}

	private final class AdPageChangeListener implements OnPageChangeListener {

		@Override
		public void onPageScrollStateChanged(int arg0) {
		}

		@Override
		public void onPageScrolled(int arg0, float arg1, int arg2) {
		}

		@Override
		public void onPageSelected(int arg0) {

			// 获取当前显示的页面是哪个页面
			atomicInteger.getAndSet(arg0);

			// 重新设置原点布局集合
			for (int i = 0; i < imageViews.length; i++) {
				imageViews[arg0]
						.setBackgroundResource(R.drawable.point_focused);
				if (arg0 != i) {
					imageViews[i]
							.setBackgroundResource(R.drawable.point_unfocused);
				}
			}
		}
	}

	private final class AdPageAdapter extends PagerAdapter {
		private List<View> views = null;

		/**
		 * 初始化数据源, 即View数组
		 */
		public AdPageAdapter(List<View> views) {
			this.views = views;
		}

		@Override
		public void destroyItem(View container, int position, Object object) {
			((ViewPager) container).removeView(views.get(position));
		}

		@Override
		public int getCount() {
			return views.size();
		}

		@Override
		public Object instantiateItem(View container, int position) {
			((ViewPager) container).addView(views.get(position), 0);
			return views.get(position);
		}

		@Override
		public boolean isViewFromObject(View view, Object object) {
			return view == object;
		}
	}
}
