package com.example.gibo.assing3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;

public class Main3Activity extends AppCompatActivity {
    TabHost tabHost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        init();
    }


    public void init() {
        tabHost = (TabHost) findViewById(R.id.tabhost);
        tabHost.setup();
        tabHost.addTab(tabHost.newTabSpec("C").setIndicator("BMI 계산기").setContent(new TabHost.TabContentFactory() {


            @Override
            public View createTabContent(String tag) {

                return getTabView();
            }
        }));
        tabHost.addTab(tabHost.newTabSpec("A").setIndicator("면적 계산기").setContent(new TabHost.TabContentFactory() {
            @Override
            public View createTabContent(String tag) {

                return  getTabView1();
            }
        }));

    }


    View getTabView() {
        final View view =
                View.inflate(Main3Activity.this, R.layout.bmcal, null);

        Button btn = (Button) view.findViewById(R.id.bt1);
        final EditText et1 = (EditText)view.findViewById(R.id.et1);
        final EditText et2 = (EditText)view.findViewById(R.id.et2);
        final TextView tv1 = (TextView)view.findViewById(R.id.tv1);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String s_height = et1.getText().toString();
                String s_weight = et2.getText().toString();
                double height = Integer.parseInt(s_height)*0.01;
                double weight = Integer.parseInt(s_weight);
                double bmi = weight/(height*height);
                if (bmi < 18.5){
                    tv1.setText("체중부족");
                }else if (18.5 <= bmi && bmi < 23){
                    tv1.setText("정상");
                }else if(23 <= bmi && bmi < 25){
                    tv1.setText("과체중");
                }else if(25 <= bmi){
                    tv1.setText("비만");
                }
            }
        });
        return view;
    }

    View getTabView1(){
        final View view =
                View.inflate(Main3Activity.this, R.layout.areacal, null);

        Button btn1 = (Button)view.findViewById(R.id.btn1);
        Button btn2 = (Button)view.findViewById(R.id.btn2);
        final EditText ett1 = (EditText)view.findViewById(R.id.ett1);
        final TextView tvw1 = (TextView)view.findViewById(R.id.tvw1);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s_val = ett1.getText().toString();
                float val = (float) (Integer.parseInt(s_val) * 3.305785);
                tvw1.setText(val+"평");
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s_val = ett1.getText().toString();
                float val = (float) (Integer.parseInt(s_val) / 3.305785);
                tvw1.setText(val+"제곱미터");
            }
        });

        return view;
    }
}