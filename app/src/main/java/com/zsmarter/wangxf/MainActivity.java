package com.zsmarter.wangxf;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.zsmarter.wangxf.WaterMask.WaterTsActivity;
import com.zsmarter.wangxf.keyboard.KeyBoardActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button btn_keyboard_full,btn_keyboard_float,btn_water_mask;
    RelativeLayout rl_main;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initListener();
    }

    private void initListener() {
        btn_keyboard_full.setOnClickListener(this);
        btn_keyboard_float.setOnClickListener(this);
        btn_water_mask.setOnClickListener(this);
        rl_main.setOnClickListener(this);
    }

    private void initView() {
        rl_main = (RelativeLayout) findViewById(R.id.activity_main);
        btn_keyboard_float = (Button) findViewById(R.id.float_keyboard);
        btn_keyboard_full = (Button) findViewById(R.id.full_keyboard);
        btn_water_mask = (Button) findViewById(R.id.water_mask);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.full_keyboard:
                openKeyBoard("full");
                break;
            case R.id.float_keyboard:
                openKeyBoard("float");
                break;
            case R.id.water_mask:
                openWaterActivity();
                break;
            case R.id.activity_main:
                Toast.makeText(this,"main",Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
    }

    private void openWaterActivity() {
        startActivity(new Intent(this, WaterTsActivity.class));
    }

    private void openKeyBoard(String type) {
        Intent intent = new Intent();
        intent.setClass(this,KeyBoardActivity.class);//打开一个activity
        intent.putExtra("type",type);
        startActivity(intent);
    }


}
