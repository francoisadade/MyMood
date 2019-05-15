package com.example.francoisadade.mymood;

import android.content.SharedPreferences;
import android.graphics.Point;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class HistoryActivity extends AppCompatActivity {
    RelativeLayout mood7, mood6, mood5, mood4, mood3, mood2, mood1;
    ImageView mButton7, mButton6, mButton5, mButton4, mButton3, mButton2, mButton1;
    SharedPreferences pref;
    SharedPreferences.Editor mEditor;
    List<Mood> moods = new ArrayList<>();

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);


        mood7 = findViewById(R.id.rlt7days);
        mood6 = findViewById(R.id.rlt6days);
        mood5 = findViewById(R.id.rlt5days);
        mood4 = findViewById(R.id.rlt4days);
        mood3 = findViewById(R.id.rlt3days);
        mood2 = findViewById(R.id.rlt2days);
        mood1 = findViewById(R.id.rlt1days);

        mButton7 = findViewById(R.id.btnItem7Comment);
        mButton6 = findViewById(R.id.btnItem6Comment);
        mButton5 = findViewById(R.id.btnItem5Comment);
        mButton4 = findViewById(R.id.btnItem4Comment);
        mButton3 = findViewById(R.id.btnItem3Comment);
        mButton2 = findViewById(R.id.btnItem2Comment);
        mButton1 = findViewById(R.id.btnItem1Comment);

        getMoodsPreferences();

        displayContent();

    }

    int getScreenDim(){
        Display display = getWindowManager().getDefaultDisplay();
        Point point = new Point();
        display.getSize(point);

        return point.x;

    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    void displayContent(){
        if (moods.size() > 0){
            if (moods.size() == 1) {
                if (moods.get(0) != null) {
                    if (moods.get(0).getComment() != null) {
                        mButton1.setVisibility(View.VISIBLE);
                        mButton1.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Toast.makeText(HistoryActivity.this, moods.get(0).getComment(), Toast.LENGTH_SHORT).show();
                            }
                        });
                    }

                    mood1.setBackgroundColor(getColor(moods.get(0).getColor()));
                    ViewGroup.LayoutParams params = mood1.getLayoutParams();
                    int rt = getScreenDim();
                    float gt = moods.get(0).getWidth();
                    params.width = (int) (getScreenDim() * moods.get(0).getWidth());
                    mood1.setLayoutParams(params);
                }
            } else

            if (moods.size() == 2)
            {
                if (moods.get(0) != null){
                    if(moods.get(0).getComment() != null){
                        mButton2.setVisibility(View.VISIBLE);
                        mButton2.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Toast.makeText(HistoryActivity.this, moods.get(0).getComment(), Toast.LENGTH_SHORT).show();
                            }
                        });
                    }

                    mood2.setBackgroundColor(getColor(moods.get(0).getColor()));
                    ViewGroup.LayoutParams params = mood2.getLayoutParams();
                    int rt = getScreenDim();
                    float gt = moods.get(0).getWidth();
                    params.width = (int) (getScreenDim() * moods.get(0).getWidth());
                    mood2.setLayoutParams(params);

                    if (moods.get(1).getComment() != null){

                        mButton1.setVisibility(View.VISIBLE);
                        mButton1.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Toast.makeText(HistoryActivity.this, moods.get(1).getComment(), Toast.LENGTH_SHORT).show();
                            }
                        });
                    }

                    mood1.setBackgroundColor(getColor(moods.get(1).getColor()));
                    params = mood1.getLayoutParams();
                    params.width = (int) (getScreenDim() * moods.get(1).getWidth());
                    mood1.setLayoutParams(params);
                }
            } else

            if (moods.size() == 3)
            {
                if (moods.get(2) != null) {
                    if (moods.get(2).getComment() != null) {
                        mButton1.setVisibility(View.VISIBLE);
                        mButton1.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Toast.makeText(HistoryActivity.this, moods.get(2).getComment(), Toast.LENGTH_SHORT).show();
                            }
                        });
                    }
                    mood1.setBackgroundColor(getColor(moods.get(2).getColor()));
                    ViewGroup.LayoutParams params = mood1.getLayoutParams();
                    params.width = (int) (getScreenDim() * moods.get(2).getWidth());
                    mood1.setLayoutParams(params);

                }

                if (moods.get(1) != null) {
                    if (moods.get(1).getComment() != null) {
                        mButton2.setVisibility(View.VISIBLE);
                        mButton2.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Toast.makeText(HistoryActivity.this, moods.get(1).getComment(), Toast.LENGTH_SHORT).show();
                            }
                        });
                    }
                    mood2.setBackgroundColor(getColor(moods.get(1).getColor()));
                    ViewGroup.LayoutParams params = mood2.getLayoutParams();
                    params.width = (int) (getScreenDim() * moods.get(1).getWidth());
                    mood2.setLayoutParams(params);

                }

                if (moods.get(0) != null) {
                    if (moods.get(0).getComment() != null) {
                        mButton3.setVisibility(View.VISIBLE);
                        mButton3.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Toast.makeText(HistoryActivity.this, moods.get(0).getComment(), Toast.LENGTH_SHORT).show();
                            }
                        });
                    }
                    mood3.setBackgroundColor(getColor(moods.get(0).getColor()));
                    ViewGroup.LayoutParams params = mood3.getLayoutParams();
                    params.width = (int) (getScreenDim() * moods.get(0).getWidth());
                    mood3.setLayoutParams(params);

                }

            } else

            if (moods.size() == 4) {
                if (moods.get(3) != null) {
                    if (moods.get(3).getComment() != null) {
                        mButton1.setVisibility(View.VISIBLE);
                        mButton1.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Toast.makeText(HistoryActivity.this, moods.get(3).getComment(), Toast.LENGTH_SHORT).show();
                            }
                        });
                    }
                    mood1.setBackgroundColor(getColor(moods.get(3).getColor()));
                    ViewGroup.LayoutParams params = mood1.getLayoutParams();
                    params.width = (int) (getScreenDim() * moods.get(3).getWidth());
                    mood1.setLayoutParams(params);

                }

                if (moods.get(2) != null) {
                    if (moods.get(2).getComment() != null) {
                        mButton2.setVisibility(View.VISIBLE);
                        mButton2.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Toast.makeText(HistoryActivity.this, moods.get(2).getComment(), Toast.LENGTH_SHORT).show();
                            }
                        });
                    }
                    mood2.setBackgroundColor(getColor(moods.get(2).getColor()));
                    ViewGroup.LayoutParams params = mood2.getLayoutParams();
                    params.width = (int) (getScreenDim() * moods.get(2).getWidth());
                    mood2.setLayoutParams(params);

                }

                if (moods.get(1) != null) {
                    if (moods.get(1).getComment() != null) {
                        mButton3.setVisibility(View.VISIBLE);
                        mButton3.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Toast.makeText(HistoryActivity.this, moods.get(1).getComment(), Toast.LENGTH_SHORT).show();
                            }
                        });
                    }
                    mood3.setBackgroundColor(getColor(moods.get(1).getColor()));
                    ViewGroup.LayoutParams params = mood3.getLayoutParams();
                    params.width = (int) (getScreenDim() * moods.get(1).getWidth());
                    mood3.setLayoutParams(params);

                }

                if (moods.get(0) != null) {
                    if (moods.get(0).getComment() != null) {
                        mButton4.setVisibility(View.VISIBLE);
                        mButton4.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Toast.makeText(HistoryActivity.this, moods.get(0).getComment(), Toast.LENGTH_SHORT).show();
                            }
                        });
                    }
                    mood4.setBackgroundColor(getColor(moods.get(0).getColor()));
                    ViewGroup.LayoutParams params = mood4.getLayoutParams();
                    params.width = (int) (getScreenDim() * moods.get(0).getWidth());
                    mood4.setLayoutParams(params);

                }
            } else

            if (moods.size() == 5)
            {
                if (moods.get(4) != null) {
                    if (moods.get(4).getComment() != null) {
                        mButton1.setVisibility(View.VISIBLE);
                        mButton1.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Toast.makeText(HistoryActivity.this, moods.get(4).getComment(), Toast.LENGTH_SHORT).show();
                            }
                        });
                    }
                    mood1.setBackgroundColor(getColor(moods.get(4).getColor()));
                    ViewGroup.LayoutParams params = mood1.getLayoutParams();
                    params.width = (int) (getScreenDim() * moods.get(4).getWidth());
                    mood1.setLayoutParams(params);
                }

                if (moods.get(3) != null) {
                    if (moods.get(3).getComment() != null) {
                        mButton2.setVisibility(View.VISIBLE);
                        mButton2.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Toast.makeText(HistoryActivity.this, moods.get(3).getComment(), Toast.LENGTH_SHORT).show();
                            }
                        });
                    }
                    mood2.setBackgroundColor(getColor(moods.get(3).getColor()));
                    ViewGroup.LayoutParams params = mood2.getLayoutParams();
                    params.width = (int) (getScreenDim() * moods.get(3).getWidth());
                    mood2.setLayoutParams(params);

                }

                if (moods.get(2) != null) {
                    if (moods.get(2).getComment() != null) {
                        mButton3.setVisibility(View.VISIBLE);
                        mButton3.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Toast.makeText(HistoryActivity.this, moods.get(2).getComment(), Toast.LENGTH_SHORT).show();
                            }
                        });
                    }
                    mood3.setBackgroundColor(getColor(moods.get(2).getColor()));
                    ViewGroup.LayoutParams params = mood3.getLayoutParams();
                    params.width = (int) (getScreenDim() * moods.get(2).getWidth());
                    mood3.setLayoutParams(params);

                }

                if (moods.get(1) != null) {
                    if (moods.get(1).getComment() != null) {
                        mButton4.setVisibility(View.VISIBLE);
                        mButton4.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Toast.makeText(HistoryActivity.this, moods.get(1).getComment(), Toast.LENGTH_SHORT).show();
                            }
                        });
                    }
                    mood4.setBackgroundColor(getColor(moods.get(1).getColor()));
                    ViewGroup.LayoutParams params = mood4.getLayoutParams();
                    params.width = (int) (getScreenDim() * moods.get(1).getWidth());
                    mood4.setLayoutParams(params);

                }

                if (moods.get(0) != null) {
                    if (moods.get(0).getComment() != null) {
                        mButton5.setVisibility(View.VISIBLE);
                        mButton5.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Toast.makeText(HistoryActivity.this, moods.get(0).getComment(), Toast.LENGTH_SHORT).show();
                            }
                        });
                    }
                    mood5.setBackgroundColor(getColor(moods.get(0).getColor()));
                    ViewGroup.LayoutParams params = mood5.getLayoutParams();
                    params.width = (int) (getScreenDim() * moods.get(0).getWidth());
                    mood5.setLayoutParams(params);

                }
            } else

            if (moods.size() == 6)
            {

                if (moods.get(5) != null) {
                    if (moods.get(5).getComment() != null) {
                        mButton1.setVisibility(View.VISIBLE);
                        mButton1.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Toast.makeText(HistoryActivity.this, moods.get(5).getComment(), Toast.LENGTH_SHORT).show();
                            }
                        });
                    }
                    mood1.setBackgroundColor(getColor(moods.get(5).getColor()));
                    ViewGroup.LayoutParams params = mood1.getLayoutParams();
                    params.width = (int) (getScreenDim() * moods.get(5).getWidth());
                    mood1.setLayoutParams(params);
                }

                if (moods.get(4) != null) {
                    if (moods.get(4).getComment() != null) {
                        mButton2.setVisibility(View.VISIBLE);
                        mButton2.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Toast.makeText(HistoryActivity.this, moods.get(4).getComment(), Toast.LENGTH_SHORT).show();
                            }
                        });
                    }
                    mood2.setBackgroundColor(getColor(moods.get(4).getColor()));
                    ViewGroup.LayoutParams params = mood2.getLayoutParams();
                    params.width = (int) (getScreenDim() * moods.get(4).getWidth());
                    mood2.setLayoutParams(params);
                }

                if (moods.get(3) != null) {
                    if (moods.get(3).getComment() != null) {
                        mButton3.setVisibility(View.VISIBLE);
                        mButton3.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Toast.makeText(HistoryActivity.this, moods.get(3).getComment(), Toast.LENGTH_SHORT).show();
                            }
                        });
                    }
                    mood3.setBackgroundColor(getColor(moods.get(3).getColor()));
                    ViewGroup.LayoutParams params = mood3.getLayoutParams();
                    params.width = (int) (getScreenDim() * moods.get(3).getWidth());
                    mood3.setLayoutParams(params);

                }

                if (moods.get(2) != null) {
                    if (moods.get(2).getComment() != null) {
                        mButton4.setVisibility(View.VISIBLE);
                        mButton4.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Toast.makeText(HistoryActivity.this, moods.get(2).getComment(), Toast.LENGTH_SHORT).show();
                            }
                        });
                    }
                    mood4.setBackgroundColor(getColor(moods.get(2).getColor()));
                    ViewGroup.LayoutParams params = mood4.getLayoutParams();
                    params.width = (int) (getScreenDim() * moods.get(2).getWidth());
                    mood4.setLayoutParams(params);

                }

                if (moods.get(1) != null) {
                    if (moods.get(1).getComment() != null) {
                        mButton5.setVisibility(View.VISIBLE);
                        mButton5.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Toast.makeText(HistoryActivity.this, moods.get(1).getComment(), Toast.LENGTH_SHORT).show();
                            }
                        });
                    }
                    mood5.setBackgroundColor(getColor(moods.get(1).getColor()));
                    ViewGroup.LayoutParams params = mood5.getLayoutParams();
                    params.width = (int) (getScreenDim() * moods.get(1).getWidth());
                    mood5.setLayoutParams(params);

                }

                if (moods.get(0) != null) {
                    if (moods.get(0).getComment() != null) {
                        mButton6.setVisibility(View.VISIBLE);
                        mButton6.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Toast.makeText(HistoryActivity.this, moods.get(0).getComment(), Toast.LENGTH_SHORT).show();
                            }
                        });
                    }
                    mood6.setBackgroundColor(getColor(moods.get(0).getColor()));
                    ViewGroup.LayoutParams params = mood6.getLayoutParams();
                    params.width = (int) (getScreenDim() * moods.get(0).getWidth());
                    mood6.setLayoutParams(params);

                }
            } else

            if (moods.size() == 7) {
                if (moods.get(6) != null) {
                    if (moods.get(6).getComment() != null) {
                        mButton1.setVisibility(View.VISIBLE);
                        mButton1.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Toast.makeText(HistoryActivity.this, moods.get(6).getComment(), Toast.LENGTH_SHORT).show();
                            }
                        });
                    }
                    mood1.setBackgroundColor(getColor(moods.get(6).getColor()));
                    ViewGroup.LayoutParams params = mood1.getLayoutParams();
                    params.width = (int) (getScreenDim() * moods.get(6).getWidth());
                    mood1.setLayoutParams(params);
                }

                if (moods.get(5) != null) {
                    if (moods.get(5).getComment() != null) {
                        mButton2.setVisibility(View.VISIBLE);
                        mButton2.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Toast.makeText(HistoryActivity.this, moods.get(5).getComment(), Toast.LENGTH_SHORT).show();
                            }
                        });
                    }
                    mood2.setBackgroundColor(getColor(moods.get(5).getColor()));
                    ViewGroup.LayoutParams params = mood2.getLayoutParams();
                    params.width = (int) (getScreenDim() * moods.get(5).getWidth());
                    mood2.setLayoutParams(params);
                }

                if (moods.get(4) != null) {
                    if (moods.get(4).getComment() != null) {
                        mButton3.setVisibility(View.VISIBLE);
                        mButton3.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Toast.makeText(HistoryActivity.this, moods.get(4).getComment(), Toast.LENGTH_SHORT).show();
                            }
                        });
                    }
                    mood3.setBackgroundColor(getColor(moods.get(4).getColor()));
                    ViewGroup.LayoutParams params = mood3.getLayoutParams();
                    params.width = (int) (getScreenDim() * moods.get(4).getWidth());
                    mood3.setLayoutParams(params);
                }

                if (moods.get(3) != null) {
                    if (moods.get(3).getComment() != null) {
                        mButton4.setVisibility(View.VISIBLE);
                        mButton4.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Toast.makeText(HistoryActivity.this, moods.get(3).getComment(), Toast.LENGTH_SHORT).show();
                            }
                        });
                    }
                    mood4.setBackgroundColor(getColor(moods.get(3).getColor()));
                    ViewGroup.LayoutParams params = mood4.getLayoutParams();
                    params.width = (int) (getScreenDim() * moods.get(3).getWidth());
                    mood4.setLayoutParams(params);

                }

                if (moods.get(2) != null) {
                    if (moods.get(2).getComment() != null) {
                        mButton5.setVisibility(View.VISIBLE);
                        mButton5.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Toast.makeText(HistoryActivity.this, moods.get(2).getComment(), Toast.LENGTH_SHORT).show();
                            }
                        });
                    }
                    mood5.setBackgroundColor(getColor(moods.get(2).getColor()));
                    ViewGroup.LayoutParams params = mood5.getLayoutParams();
                    params.width = (int) (getScreenDim() * moods.get(2).getWidth());
                    mood5.setLayoutParams(params);

                }

                if (moods.get(1) != null) {
                    if (moods.get(1).getComment() != null) {
                        mButton6.setVisibility(View.VISIBLE);
                        mButton6.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Toast.makeText(HistoryActivity.this, moods.get(1).getComment(), Toast.LENGTH_SHORT).show();
                            }
                        });
                    }
                    mood6.setBackgroundColor(getColor(moods.get(1).getColor()));
                    ViewGroup.LayoutParams params = mood6.getLayoutParams();
                    params.width = (int) (getScreenDim() * moods.get(1).getWidth());
                    mood6.setLayoutParams(params);

                }

                if (moods.get(0) != null) {
                    if (moods.get(0).getComment() != null) {
                        mButton7.setVisibility(View.VISIBLE);
                        mButton7.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Toast.makeText(HistoryActivity.this, moods.get(0).getComment(), Toast.LENGTH_SHORT).show();
                            }
                        });
                    }
                    mood7.setBackgroundColor(getColor(moods.get(0).getColor()));
                    ViewGroup.LayoutParams params = mood7.getLayoutParams();
                    params.width = (int) (getScreenDim() * moods.get(0).getWidth());
                    mood7.setLayoutParams(params);

                }
            }
        }

    }

    void getMoodsPreferences(){
        pref = getSharedPreferences(MainActivity.PREFERENCE_NAME, MODE_PRIVATE);

        mEditor = pref.edit();
        Gson gson = new Gson();

        Map<String, String> savedMoods = (Map<String, String>) pref.getAll();
        for(int i = 1; i <= savedMoods.size(); i++){

            String hum = savedMoods.get("day" + i);

            if(hum != null){
                Mood mood = gson.fromJson(hum, Mood.class);

                moods.add(mood);
            }

        }
    }

}