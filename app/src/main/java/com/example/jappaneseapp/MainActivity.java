package com.example.jappaneseapp;

import android.content.Intent;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;

public class MainActivity extends AppCompatActivity {
    
    private TypedArray imgs;
    private ImageView image;
    private TextView romangi;
    private ImageView exitImage;
    private int sessionId;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        image = (ImageView) findViewById(R.id.jappanesechar);
        romangi = (TextView) findViewById(R.id.romanji);
        exitImage = (ImageView) findViewById(R.id.exitImage);
        sessionId = getIntent().getIntExtra("EXTRA_SESSION_ID", 0);
        
        
        if (sessionId == 1) {
            imgs = getResources().obtainTypedArray(R.array.hiraganaImages);
            Drawable drawable = imgs.getDrawable(0);
            image.setImageDrawable(drawable);
        } else if (sessionId == 2) {
            imgs = getResources().obtainTypedArray(R.array.katatanaImages);
            Drawable drawable = imgs.getDrawable(0);
            image.setImageDrawable(drawable);
        }
        
        final TypedArray romanjiArray = getResources().obtainTypedArray(R.array.romanji);
        
        exitImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                launchActivity();
                finish();
            }
        });
        
        image.setOnTouchListener(new OnSwipeTouchListener(MainActivity.this) {
            
            int i = 0;
            
            public void onSwipeTop() {
                Toast.makeText(MainActivity.this, "top", Toast.LENGTH_SHORT).show();
            }
            
            public void onSwipeRight() {
                
                i -= 1;
                
                if (i < 0) {
                    i = 45;
                }
                
                
                String textView = (String) romanjiArray.getText(i);
                romangi.setText(textView);
                
                Drawable drawable = imgs.getDrawable(i);
                image.setImageDrawable(drawable);
                
            }
            
            public void onSwipeLeft() {
                
                
                i += 1;
                
                if (i > 45) {
                    i = 0;
                }
                
                String textView = (String) romanjiArray.getText(i);
                romangi.setText((CharSequence) textView);
                
                Drawable drawable = imgs.getDrawable(i);
                image.setImageDrawable(drawable);
                
                
            }
            
            public void onSwipeBottom() {
                Toast.makeText(MainActivity.this, "bottom", Toast.LENGTH_SHORT).show();
            }
            
        });
        
        
    }
    
    
    private void launchActivity() {
        
        Intent intent = new Intent(this, Interface.class);
        startActivity(intent);
    }
    
}
