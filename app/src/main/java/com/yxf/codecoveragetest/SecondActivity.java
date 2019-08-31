package com.yxf.codecoveragetest;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by xifeng.yang on 2019/8/30.
 */
public class SecondActivity extends AppCompatActivity implements View.OnClickListener {

    private Button mShowToastBtn;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        mShowToastBtn = findViewById(R.id.btn_show_toast);

        mShowToastBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_show_toast:
                Toast.makeText(this, "Toast测试", Toast.LENGTH_SHORT).show();
                break;
        }
    }


}
