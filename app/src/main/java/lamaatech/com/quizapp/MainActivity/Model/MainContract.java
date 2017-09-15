package lamaatech.com.quizapp.MainActivity.Model;

/**
 * Created by MrHacker on 9/14/2017.
 */

public interface MainContract {
    interface IController {

    }

    interface IModel {

    }

    interface IView {

        void onSubmitButtonClicked();

        void questionOneScore();

        void questionTwoScore();

        void questionThreeScore();

        void questionFourScore();
    }
}
