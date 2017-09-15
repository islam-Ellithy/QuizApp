package lamaatech.com.quizapp.MainActivity.View;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import lamaatech.com.quizapp.MainActivity.Model.MainContract;
import lamaatech.com.quizapp.R;

public class MainActivity extends AppCompatActivity implements MainContract.IView {

    private EditText editTextQuestionTwoAnswerCat;
    private EditText editTextQuestionFourAnswerDog;
    private RadioGroup radioGroup;
    private CheckBox checkboxQuestionThreeChoiceCat;
    private CheckBox checkboxQuestionThreeChoiceDog;
    private CheckBox checkboxQuestionThreeChoiceBed;
    private Integer score = 0;
    private static final int SCORE_VALUE = 10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        bindView();

    }

    private void bindView() {
        //Question one answer Radio button answer 'Dolphin'
        radioGroup = (RadioGroup) findViewById(R.id.radioGroupQuestionOneDolphine);
        //radioButtonDolphin  radiobutton
        //radioButtonDog      radiobutton

        //Question Two answer 'Cat' via edit text
        editTextQuestionTwoAnswerCat = (EditText) findViewById(R.id.editTextQuestionTwoAnswerCat);

        //Question Three 3 checkboxes 2 anwers are Cat & Dog
        checkboxQuestionThreeChoiceCat = (CheckBox) findViewById(R.id.checkboxQuestionThreeChoiceCat);
        checkboxQuestionThreeChoiceDog = (CheckBox) findViewById(R.id.checkboxQuestionThreeChoiceDog);
        checkboxQuestionThreeChoiceBed = (CheckBox) findViewById(R.id.checkboxQuestionThreeChoiceBed);

        //Question Four one edittext answer is Dog
        editTextQuestionFourAnswerDog = (EditText) findViewById(R.id.editTextQuestionFourAnswerDog);
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
    public void onSubmitButtonClicked(View view) {
        questionOneScore();
        questionTwoScore();
        questionThreeScore();
        questionFourScore();
        Toast.makeText(this, String.valueOf(score), Toast.LENGTH_SHORT).show();
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
