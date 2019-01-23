package com.example.myapplication201900;

import android.graphics.Color;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Boolean isRecordMode=true;
    int count=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Button btn,btn2,btn3,btn4,save,reset;
        btn=findViewById(R.id.button);
        btn2=findViewById(R.id.button2);
        btn3=findViewById(R.id.button3);
        btn4=findViewById(R.id.button4);
        reset=findViewById(R.id.reset);
        save=findViewById(R.id.save);
        final ArrayList<Integer>arrayList=new ArrayList<>();
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MediaPlayer mp;
                if (isRecordMode) {
                    arrayList.add(1);
                }else {
                    if (arrayList.get(count).equals(1))count++;
                    else {
                        reset.setBackgroundColor(Color.WHITE);
                    }
                }
                mp=MediaPlayer.create(MainActivity.this,R.raw.btn);
                mp.start();
                btn.setBackgroundColor(Color.RED);
                if (mp.isPlaying()){
                    btn2.setEnabled(false);
                    btn3.setEnabled(false);
                    btn4.setEnabled(false);
                }
                mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        btn.setBackgroundResource(android.R.drawable.btn_default);
                        btn2.setEnabled(true);
                        btn3.setEnabled(true);
                        btn4.setEnabled(true);
                    }
                });
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MediaPlayer mediaPlayer;
                if (isRecordMode) {
                    arrayList.add(2);
                }else {
                    if (arrayList.get(count).equals(2))count++;
                    else {
                        reset.setBackgroundColor(Color.WHITE);

                    }
                }
                mediaPlayer=MediaPlayer.create(MainActivity.this,R.raw.btnn);
                mediaPlayer.start();
                btn2.setBackgroundColor(Color.GREEN);
                if (mediaPlayer.isPlaying()){
                    btn.setEnabled(false);
                    btn3.setEnabled(false);
                    btn4.setEnabled(false);

                }
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        btn2.setBackgroundResource(android.R.drawable.btn_default);
                        btn4.setEnabled(true);
                        btn3.setEnabled(true);
                        btn.setEnabled(true);
                    }
                });
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MediaPlayer mediaPlayer;
                if (isRecordMode) {
                    arrayList.add(3);
                }else {
                    if (arrayList.get(count).equals(3))count++;
                    else {
                        reset.setBackgroundColor(Color.WHITE);
                    }
                }
                mediaPlayer=MediaPlayer.create(MainActivity.this,R.raw.btnnn);
                mediaPlayer.start();
                btn3.setBackgroundColor(Color.BLUE);
                if (mediaPlayer.isPlaying()){
                    btn2.setEnabled(false);
                    btn4.setEnabled(false);
                    btn.setEnabled(false);
                }
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        btn3.setBackgroundResource(android.R.drawable.btn_default);
                        btn2.setEnabled(true);
                        btn4.setEnabled(true);
                        btn.setEnabled(true);
                    }
                });
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MediaPlayer mediaPlayer;
                if (isRecordMode) {
                    arrayList.add(4);
                }else {
                    if (arrayList.get(count).equals(4))count++;
                    else {
                        reset.setBackgroundColor(Color.WHITE);
                    }
                }
                mediaPlayer=MediaPlayer.create(MainActivity.this,R.raw.btnnnn);
                mediaPlayer.start();
                btn4.setBackgroundColor(Color.BLACK);
                if (mediaPlayer.isPlaying()){
                    btn2.setEnabled(false);
                    btn.setEnabled(false);
                    btn3.setEnabled(false);
                }
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        btn4.setBackgroundResource(android.R.drawable.btn_default);
                        btn.setEnabled(true);
                        btn2.setEnabled(true);
                        btn3.setEnabled(true);
                    }
                });
            }
        });
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isRecordMode=false;
            }
        });
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reset.setBackgroundResource(android.R.drawable.btn_default);
                arrayList.clear();
                isRecordMode=true;
            }
        });
    }
}
