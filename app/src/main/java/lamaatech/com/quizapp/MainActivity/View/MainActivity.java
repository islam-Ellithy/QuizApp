package lamaatech.com.quizapp.MainActivity.View;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import lamaatech.com.quizapp.MainActivity.Model.MainContract;
import lamaatech.com.quizapp.R;

public class MainActivity extends AppCompatActivity implements MainContract.IView {

    //Question one answer Radio button answer 'Dolphin'
    //radioButtonDolphin  radiobutton
    //radioButtonDog      radiobutton
    //Question Two answer 'Cat' via edit text
    //Question Three 3 checkboxes 2 anwers are Cat & Dog
    //Question Four one edittext answer is Dog

    @BindView(R.id.editTextQuestionTwoAnswerCat)
    protected EditText editTextQuestionTwoAnswerCat;
    @BindView(R.id.editTextQuestionFourAnswerDog)
    protected EditText editTextQuestionFourAnswerDog;
    @BindView(R.id.radioGroupQuestionOneDolphine)
    protected RadioGroup radioGroup;
    @BindView(R.id.checkboxQuestionThreeChoiceCat)
    protected CheckBox checkboxQuestionThreeChoiceCat;
    @BindView(R.id.checkboxQuestionThreeChoiceDog)
    protected CheckBox checkboxQuestionThreeChoiceDog;
    @BindView(R.id.checkboxQuestionThreeChoiceBed)
    protected CheckBox checkboxQuestionThreeChoiceBed;
    @BindView(R.id.toolbar)
    protected Toolbar toolbar;
    private Integer score = 0;
    private static final int SCORE_VALUE = 10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    @Override
    public @OnClick(R.id.submitButton)
    void onSubmitButtonClicked() {
        questionOneScore();
        questionTwoScore();
        questionThreeScore();
        questionFourScore();
        Toast.makeText(this, String.valueOf(score), Toast.LENGTH_SHORT).show();

        Intent intent = new Intent(MainActivity.this,ScoreActivity.class);

        intent.putExtra("score",score);

        startActivity(intent);

        score = 0;
    }

    @Override
    public void questionOneScore() {
        //answer is dolphin radioButton answer
        int checkedId = radioGroup.getCheckedRadioButtonId();
        if (checkedId == R.id.radioButtonQuestionOneDolphin) {
            score += SCORE_VALUE;
        }
    }

    @Override
    public void questionTwoScore() {
        String answer = editTextQuestionTwoAnswerCat.getText().toString();

        if (answer.equalsIgnoreCase("Cat"))
            score += SCORE_VALUE;
    }

    @Override
    public void questionThreeScore() {
        if (checkboxQuestionThreeChoiceCat.isChecked()) {
            if (checkboxQuestionThreeChoiceDog.isChecked())
                if (!checkboxQuestionThreeChoiceBed.isChecked())
                    score += SCORE_VALUE;
                else
                    score += 0;
        }
    }

    @Override
    public void questionFourScore() {
        String answer = editTextQuestionFourAnswerDog.getText().toString();
        if (answer.equalsIgnoreCase("Dog"))
            score += SCORE_VALUE;
    }
}
