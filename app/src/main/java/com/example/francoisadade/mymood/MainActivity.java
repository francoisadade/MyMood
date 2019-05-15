package com.example.francoisadade.mymood;


import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.google.gson.Gson;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends Activity implements GestureDetector.OnGestureListener {

    Map<String, Integer> images = new HashMap<>();
    Map<String, Integer> colors = new HashMap<>();
    ImageView smiley;
    RelativeLayout page;
    GestureDetector mGestureDetector;
    ImageView comment, history;
    public static final String PREFERENCE_NAME = "MyMood";
    private static final String INCREMENT = "increment";

    SharedPreferences pref;
    SharedPreferences.Editor mEditor;
    Mood mMood;
    Date today;


    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mGestureDetector = new GestureDetector(this);
        pref =  getSharedPreferences(PREFERENCE_NAME, MODE_PRIVATE);
        mEditor = pref.edit();

        smiley = findViewById(R.id.smiley);
        page = findViewById(R.id.allpage);
        smiley.setTag(R.drawable.smiley_happy);
        comment = findViewById(R.id.imgComment);
        history= findViewById(R.id.imgHistory);

        images.put("sad", R.drawable.smiley_sad);
        images.put("disappointed", R.drawable.smiley_disappointed);
        images.put("happy", R.drawable.smiley_happy);
        images.put("normal", R.drawable.smiley_normal);
        images.put("super_happy", R.drawable.smiley_super_happy);


        colors.put("sad", R.color.faded_red);
        colors.put("disappointed", R.color.warm_grey);
        colors.put("happy", R.color.light_sage);
        colors.put("normal", R.color.cornflower_blue_65);
        colors.put("super_happy", R.color.banana_yellow);

        smiley.setTag(R.drawable.smiley_happy);

        today = new Date();

        mMood = new Mood(colors.get("happy"), null, today);
        mMood.setColor(colors.get("happy"));

        Timer timer = new Timer();

        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                Calendar cal = Calendar.getInstance();
                Date date=cal.getTime();
                DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
                String formattedDate=dateFormat.format(date);
                if(formattedDate.equals("23:59:00")){
                    saveHumeur(mMood);
                    mMood = new Mood(colors.get("happy"), null, today);
                    mMood.setColor(colors.get("happy"));
                    smiley.setImageResource(images.get("happy"));
                    page.setBackgroundColor(getResources().getColor(colors.get("happy")));
                    smiley.setTag(R.drawable.smiley_happy);
                }
            }
        }, 0, 1000);

        comment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                LayoutInflater lf = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
                View view = lf.inflate(R.layout.comment_layout, null);

                final EditText edtText = view.findViewById(R.id.edtComment);

                builder.setView(view);

                builder.setPositiveButton("Valider", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String comment = edtText.getText().toString();
                        mMood.setComment(comment);
                        //saveHumeur(mMood);
                    }
                });

                builder.setNegativeButton("ANNULER", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });

                builder.setCancelable(false);
                builder.create().show();
            }
        });

        history.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, HistoryActivity.class));
            }
        });

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return mGestureDetector.onTouchEvent(event);
    }

    private void onSwipTopToDown() {

        int tag = (int) smiley.getTag();
        int color = 0;
        if (tag == R.drawable.smiley_sad){

            smiley.setImageResource(images.get("disappointed"));
            page.setBackgroundColor(getResources().getColor(colors.get("disappointed")));
            color = colors.get("disappointed");
            smiley.setTag(R.drawable.smiley_disappointed);

        } else if(tag == R.drawable.smiley_disappointed){
            smiley.setImageResource(images.get("normal"));
            page.setBackgroundColor(getResources().getColor(colors.get("normal")));
            color = colors.get("normal");
            smiley.setTag(R.drawable.smiley_normal);

        } else if (tag == R.drawable.smiley_normal){
            smiley.setImageResource(images.get("happy"));
            page.setBackgroundColor(getResources().getColor(colors.get("happy")));
            color = colors.get("happy");
            smiley.setTag(R.drawable.smiley_happy);

        } else if (tag == R.drawable.smiley_happy){
            smiley.setImageResource(images.get("super_happy"));
            page.setBackgroundColor(getResources().getColor(colors.get("super_happy")));
            color = colors.get("super_happy");
            smiley.setTag(R.drawable.smiley_super_happy);

        } else if (tag == R.drawable.smiley_super_happy){
            smiley.setImageResource(images.get("sad"));
            page.setBackgroundColor(getResources().getColor(colors.get("sad")));
            color = colors.get("sad");
            smiley.setTag(R.drawable.smiley_sad);
        }

        mMood.setColor(color);

    }

    private void onSwipDownToTop(){
        int tag = (int) smiley.getTag();
        int color = 0;
        if (tag == R.drawable.smiley_disappointed){
            smiley.setImageResource(images.get("sad"));
            page.setBackgroundColor(getResources().getColor(colors.get("sad")));
            color = colors.get("sad");
            smiley.setTag(R.drawable.smiley_sad);

        } else if (tag == R.drawable.smiley_sad) {
            smiley.setImageResource(images.get("super_happy"));
            page.setBackgroundColor(getResources().getColor(colors.get("super_happy")));
            color = colors.get("super_happy");
            smiley.setTag(R.drawable.smiley_super_happy);

        } else if (tag == R.drawable.smiley_super_happy) {
            smiley.setImageResource(images.get("happy"));
            page.setBackgroundColor(getResources().getColor(colors.get("happy")));
            color = colors.get("Happy");
            smiley.setTag(R.drawable.smiley_happy);

        } else if (tag == R.drawable.smiley_happy) {
            smiley.setImageResource(images.get("normal"));
            page.setBackgroundColor(getResources().getColor(colors.get("normal")));
            color = colors.get("normal");
            smiley.setTag(R.drawable.smiley_normal);

        } else if (tag == R.drawable.smiley_normal) {
            smiley.setImageResource(images.get("disappointed"));
            page.setBackgroundColor(getResources().getColor(colors.get("disappointed")));
            color = colors.get("disappointed");
            smiley.setTag(R.drawable.smiley_disappointed);

        }
        mMood.setColor(color);
    }

    @Override
    public boolean onDown(MotionEvent e) {
        return false;
    }

    @Override
    public void onShowPress(MotionEvent e) {

    }

    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        return false;
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        return false;
    }

    @Override
    public void onLongPress(MotionEvent e) {

    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        if (e1.getRawY() < e2.getRawY()) {
            onSwipTopToDown();
        } else {
            onSwipDownToTop();
        }
        return true;
    }

    private void saveHumeur(Mood mood){
        int i = pref.getInt(INCREMENT, 1);
        Gson gson = new Gson();

        String hum = gson.toJson(mood);
        if(i <= 7){
            mEditor.putString("day" + i, hum);

            mEditor.putInt(INCREMENT, i + 1);
        } else {
            i = 1;
            mEditor.putString("day" + i, hum);
            mEditor.putInt(INCREMENT, 2);
            mEditor.commit();
        }
        mEditor.commit();
    }



}

