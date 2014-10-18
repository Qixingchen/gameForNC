package com.example.gameforresord;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

    private String ans[]={"��������","��������","�������׻�","ˮ������"};
    private String bump = "���շ����䷬������˱���һ���ë��������С��Ϻ�������й���С���ҵ�Ƥ��è¿����������";
    private int now,sum,v,c; 
    ImageView photo;
    TextView hint,urans;
    Button typein[][];
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        hint=(TextView)findViewById(R.id.hint);
        urans=(TextView)findViewById(R.id.uranswer);
        photo = (ImageView)findViewById(R.id.image);
        typein = new Button[4][7];
        
        setContentView(R.layout.activity_main);
        int i,j;
        identifybutton();
        updatetypein();
        updateimage();
        hint.setText("�²�����"+ans[now].length()+"��)");
        for(i=1;i<=3;i++){
        	for(j=1;j<=6;j++){
        		if(i==1&&j==6){
        			continue;
        		}else{
	        		typein[i][j].setOnClickListener(new OnClickListener() {
						
						@Override
						public void onClick(View v) {
							// TODO Auto-generated method stub
							if(urans.getText().equals("��Ĵ�")){
								urans.setText("");
							}
							Button tmp=(Button) v;
							urans.append(tmp.getText());
							v.setVisibility(View.INVISIBLE);
							confirm();
						}
					});
        		}
        	}
        }
    }
    private void identifybutton(){
        int i,j,n=0;
        for(i=1;i<=3;i++){
        	for(j=1;j<=6;j++){
        		if(i==1&&j==6){
        			continue;
        		}else{
	        		typein[i][j] = (Button)findViewById(R.id.button1_1+n);
	        		n++;
        		}
        	}
        }
    }
    private void updatetypein(){
    	int i,j,x=1,y=5;
        char[] word=ans[now].toCharArray(),
        		temp=bump.toCharArray(); 
        for(i=1;i<=3;i++){
        	for(j=1;j<=6;j++){
        		if(i==1&&j==6){
        			continue;
        		}else{
        			typein[i][j].setText("");
        		}
        	}
        }
        for(i=0;i<word.length;i++){
        	while(x!=1&&y!=5&&typein[x][y].getText().equals("")){
        		x=(int) (Math.random()*10%3+1);
        		y=(int) (Math.random()*10%6+1);
        	}
        	typein[x][y].setText(word[i]);
        }
        for(i=1;i<=3;i++){
        	for(j=1;j<=6;j++){
        		if(i==1&&j==6){
        			continue;
        		}else{
	        		if(typein[i][j].getText().equals("")){
	        			x=(int) (Math.random()*temp.length);
	        			if(temp[x]!='0'){
	        				typein[i][j].setText(temp[x]);
	        				temp[x]='0';
	        			}
	        		}
        		}
        	}
        }
    }
    private void updateimage(){
    	
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    private void confirm(){
		int i,j;
    	if(urans.getText().length()==ans[now].length()){
        	if(urans.getText().equals(ans[now])&&ans.length!=now+1){
        		now++;
        		for(i=1;i<=3;i++){
                	for(j=1;j<=6;j++){
                		if(typein[i][j].VISIBLE==View.INVISIBLE){
                			typein[i][j].setVisibility(View.VISIBLE);
                		}
                	}
                }
        		updatetypein();
                updateimage();
                urans.setText("��Ĵ�");
                hint.setText("�²�����"+ans[now].length()+"��)");
        	}else if(urans.getText().equals(ans[now])&&ans.length==now+1){
        		Toast.makeText(getApplicationContext(), "��ϲ������������", Toast.LENGTH_LONG).show();
        	}
        	else{
        		hint.setText("�����Ŷ");
        		urans.setText("��Ĵ�");
        		for(i=1;i<=3;i++){
                	for(j=1;j<=6;j++){
                		if(typein[i][j].VISIBLE==View.INVISIBLE){
                			typein[i][j].setVisibility(View.VISIBLE);
                		}
                	}
                }

        	}
    	}

    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */


}
