package lamaatech.com.quizapp.MainActivity.View;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import lamaatech.com.quizapp.R;

public class ScoreActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);


        Intent intent = getIntent();

        int score = intent.getIntExtra("score",0);

        TextView scoreTextView = (TextView) findViewById(R.id.score);


        scoreTextView.setText(String.valueOf(score));



    }
}
