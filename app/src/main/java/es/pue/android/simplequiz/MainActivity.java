package es.pue.android.simplequiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MainActivity extends AppCompatActivity {

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

        tv.setText(questions.get(currentQuestionIndex).getQuestion());

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentQuestionIndex += 1;
                tv.setText(questions.get(currentQuestionIndex).getQuestion());
            }
        });
    }
}
