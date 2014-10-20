package com.example.gameforresord;

import com.example.gameforresord.R;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class AnswerQuestionActivity extends Activity {
     int i=1;
    private TextView tv1,tv2;
    private LinearLayout q1ab,q2ab;
    private LinearLayout q1cd,q2cd;
    private Button last;
    private Button next;
    private Button finish;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_answer_question);
		tv1=(TextView) findViewById(R.id.question1);
		tv2=(TextView)findViewById(R.id.question2);
		q1ab=(LinearLayout)findViewById(R.id.firstab);
		q1cd=(LinearLayout)findViewById(R.id.firstcd);
		q2ab=(LinearLayout)findViewById(R.id.secondab);
		q2cd=(LinearLayout)findViewById(R.id.secondcd);
		last = (Button)findViewById(R.id.last);
		next=(Button)findViewById(R.id.next);
		finish=(Button)findViewById(R.id.finish);
		
		 tv2.setVisibility(View.GONE);
		 q2ab.setVisibility(View.GONE);
		 q2cd.setVisibility(View.GONE);
		 finish.setVisibility(View.GONE);
		 tv1.setVisibility(0);
	     q1ab.setVisibility(0);
		 q1cd.setVisibility(0);
		
		last.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				i--;
				System.out.println(i);
				choose(i);
			}
		});
		
		next.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				i++;
				System.out.println(i);
				choose(i);
			}
		});
       finish.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			System.out.println(511);
//		    通过AlertDialog.Builder这个类来实例化我们的一个AlertDialog的对象
            AlertDialog.Builder builder = new AlertDialog.Builder(AnswerQuestionActivity.this);
            //    设置Title的内容
            builder.setTitle("最终结果");
            //    设置Content来显示一个信息
            builder.setMessage("恭喜你一共回答对了5道题！按照规定，将获得本餐厅8折优惠！");
            //    设置一个PositiveButton
            builder.setPositiveButton("确定", new DialogInterface.OnClickListener()
            {
                @Override
                public void onClick(DialogInterface dialog, int which)
                {
                	AnswerQuestionActivity.this.finish();
                }
            });
            builder.show();

		}
	});
		
	}
	public void choose(int i){
		if(i<=0){
			AnswerQuestionActivity.this.finish();
		}
		else if(i == 1){
			 finish.setVisibility(View.GONE);
			 tv2.setVisibility(View.GONE);
			 q2ab.setVisibility(View.GONE);
			 q2cd.setVisibility(View.GONE);
			 tv1.setVisibility(0);
		     q1ab.setVisibility(0);
			 q1cd.setVisibility(0);
		}
		else if(i == 2){
			finish.setVisibility(View.GONE);
			tv1.setVisibility(View.GONE);
			q1ab.setVisibility(View.GONE);
			q1cd.setVisibility(View.GONE);
			tv2.setVisibility(0);
			q2ab.setVisibility(0);
			q2cd.setVisibility(0);
		}
		else if(i==3){
			 finish.setVisibility(View.GONE);
			 tv2.setVisibility(View.GONE);
			 q2ab.setVisibility(View.GONE);
			 q2cd.setVisibility(View.GONE);
			 tv1.setVisibility(0);
		     q1ab.setVisibility(0);
			 q1cd.setVisibility(0);
		}
		else if(i == 4){
			finish.setVisibility(View.GONE);
			tv1.setVisibility(View.GONE);
			q1ab.setVisibility(View.GONE);
			q1cd.setVisibility(View.GONE);
			tv2.setVisibility(0);
			q2ab.setVisibility(0);
			q2cd.setVisibility(0);
		}
		else if(i == 5){
			tv2.setVisibility(View.GONE);
			q2ab.setVisibility(View.GONE);
			q2cd.setVisibility(View.GONE);
			last.setVisibility(View.GONE);
			next.setVisibility(View.GONE);
			finish.setVisibility(0);
			tv1.setVisibility(0);
		    q1ab.setVisibility(0);
			q1cd.setVisibility(0);
		}
	}
}
