package com.leaf.statusbarutil;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import com.leaf.library.StatusBarUtil;

import java.util.Random;

public class ColorActivity extends AppCompatActivity {

    private int mColor;
    private Random random;
    private Toolbar mToolbar;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.set_color);

        mToolbar = findViewById(R.id.toolbar);
        Button mChangeColor = findViewById(R.id.change_color);
        TextView mVersionText = findViewById(R.id.version_text);
        SeekBar mSeekBar = findViewById(R.id.mSeekBar);
        TextView mAlphaText = findViewById(R.id.alpha_text);

        changeColor();

        mChangeColor.setOnClickListener(v -> {
            changeColor();
        });

        mSeekBar.setMax(255);
        mSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                StatusBarUtil.setColor(ColorActivity.this, mColor, progress);
                mAlphaText.setText(String.valueOf(progress));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        mVersionText.setText(
                "手机厂商" + AppUtils.getDeviceBrand() + "\n" +
                        "手机型号" + AppUtils.getSystemModel() + "\n" +
                        "Android系统版本号" + AppUtils.getSystemVersion()
        );
    }

    public void changeColor() {
        random = new Random();
        mColor = 0xff000000 | random.nextInt(0xffffff);
        mToolbar.setBackgroundColor(mColor);
        //TODO 状态栏
        StatusBarUtil.setColor(ColorActivity.this, mColor);
    }
}
