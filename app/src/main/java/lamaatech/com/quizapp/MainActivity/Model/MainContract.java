package lamaatech.com.quizapp.MainActivity.Model;

import android.view.View;

/**
 * Created by MrHacker on 9/14/2017.
 */

public interface MainContract {
    interface IController {

    }

    interface IModel {

    }

    interface IView {

        void onSubmitButtonClicked(View view);

        void questionOneScore();

        void questionTwoScore();

        void questionThreeScore();

        void questionFourScore();
    }
}
