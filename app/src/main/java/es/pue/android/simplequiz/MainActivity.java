package es.pue.android.simplequiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView tv;
    Button btnTrue;
    Button btnFalse;
    Button btnNext;

    List<Question> questions = new ArrayList<>();
    int currentQuestionIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv = (TextView)findViewById(R.id.textView);
        btnTrue = (Button)findViewById(R.id.btnTrue);
        btnFalse = (Button)findViewById(R.id.btnFalse);
        btnNext = (Button)findViewById(R.id.btnNext);

        questions.add(new Question(R.string.q1, true));
        questions.add(new Question(R.string.q2, true));
        questions.add(new Question(R.string.q3, true));
        questions.add(new Question(R.string.q4, true));
        questions.add(new Question(R.string.q5, true));

        tv.setText(questions.get(currentQuestionIndex).getQuestion());

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(currentQuestionIndex < questions.size() - 1)
                {
                    currentQuestionIndex += 1;
                    tv.setText(questions.get(currentQuestionIndex).getQuestion());
                }
                else
                {
                    currentQuestionIndex = questions.size() - 1;
                    Toast.makeText(v.getContext(), R.string.no_more_questions, Toast.LENGTH_LONG).show();
                }
            }
        });

        btnTrue.setOnClickListener(this);
        btnFalse.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();

        if (id == R.id.btnTrue) {
            checkAnswer(true);
        } else if (id == R.id.btnFalse) {
            checkAnswer(false);
        }
    }

    private void checkAnswer(boolean a) {
        boolean isAnswerTrue = questions.get(currentQuestionIndex).isAnswerTrue();
        int result = R.string.fail;

        if(isAnswerTrue == a) {
            result = R.string.success;
        }

        Toast.makeText(this, result, Toast.LENGTH_LONG).show();
    }
}
