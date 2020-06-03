package com.sherwood.timerapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView clock;

    int displayHours = 0;
    int displayMinutes = 0;
    int displaySeconds = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        clock = findViewById(R.id.txt_clock_display_value);

        setTimeButton( 0, (ImageButton) findViewById(R.id.btn_arrow_hour_up),
                                (ImageButton) findViewById(R.id.btn_arrow_hour_down) );

        setTimeButton( 1, (ImageButton) findViewById(R.id.btn_arrow_minute_up),
                                (ImageButton) findViewById(R.id.btn_arrow_minute_down) );

        setTimeButton( 2, (ImageButton) findViewById(R.id.btn_arrow_second_up),
                                (ImageButton) findViewById(R.id.btn_arrow_second_down) );
    }
    private void setTimeButton(final int level, ImageButton upBtn, ImageButton downBtn){
        upBtn.setOnClickListener(
            new Button.OnClickListener() {
                public void onClick(View v){
                    setTimeValue(false, level);
                }
            }
        );
        downBtn.setOnClickListener(
            new Button.OnClickListener() {
                public void onClick(View v){
                    setTimeValue(true, level);
                }
            }
        );
    }
    private void setTimeValue(boolean isDown, int level){
        switch (level) {
            case 0:
                if( !isDown && displayHours < 99 ){
                    displayHours++;
                }
                if( isDown && displayHours > 0 ){
                    displayHours--;
                }
                break;
            case 1:
                if( !isDown && displayMinutes < 59 ){
                    displayMinutes++;
                }
                if( isDown && displayMinutes > 0 ){
                    displayMinutes--;
                }
                break;
            case 2:
                if( !isDown && displaySeconds < 59 ){
                    displaySeconds++;
                }
                if( isDown && displaySeconds > 0 ){
                    displaySeconds--;
                }
                break;
        }

        clock.setText(String.format("%02d", displayHours) + ":"
                    + String.format("%02d", displayMinutes) + ":"
                    + String.format("%02d", displaySeconds));
    }
}
