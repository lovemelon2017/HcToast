package com.hanchao.hstoast;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import com.hanchao.hctoast.HcToastUtil;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.click_tv).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                View inflate = LayoutInflater.from(MainActivity.this).inflate(R.layout.main_toast_layout, null);
//                HcToastUtil.showCustom("666",inflate);
                HcToastUtil.showShort("啦啦啦");
            }
        });

    }
}
