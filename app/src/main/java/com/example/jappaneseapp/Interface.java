package com.example.jappaneseapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class Interface extends AppCompatActivity {
    private int sessionId;
    private Button hiragana;
    private Button katatana;
    private Button kanji;
    private Button study;
    private Button quiz;
    private LinearLayout first;
    private LinearLayout second;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interface);
        
        hiragana = (Button) findViewById(R.id.hiraganaButton);
        katatana = (Button) findViewById(R.id.katakanaButton);
        kanji = (Button) findViewById(R.id.kanjiButton);
        study = (Button) findViewById(R.id.studyButton);
        quiz = (Button) findViewById(R.id.quizButton);
        
        first = (LinearLayout) findViewById(R.id.firstMenu);
        second = (LinearLayout) findViewById(R.id.secondMenu);
        
        hiragana.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sessionId = 1;
                first.setVisibility(View.GONE);
                second.setVisibility(View.VISIBLE);
                
            }
        });
        
        katatana.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sessionId = 2;
                first.setVisibility(View.GONE);
                second.setVisibility(View.VISIBLE);
                
            }
        });
        
        kanji.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                first.setVisibility(View.GONE);
                second.setVisibility(View.VISIBLE);
                
            }
        });
        
        study.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                
                launchActivity(sessionId);
                finish();
            }
        });
        
        quiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                
                launchActivity(sessionId);
                finish();
            }
        });
        
        
    }
    
    private void launchActivity(int sessionId) {
        
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("EXTRA_SESSION_ID", sessionId);
        startActivity(intent);
        
    }
}
