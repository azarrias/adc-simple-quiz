package es.pue.android.simplequiz;

public class Question {

    private int question;
    private boolean answer;

    public Question(int q, boolean a) {
        this.question = q;
        this.answer = a;
    }

    public int getQuestion() {
        return question;
    }

    public boolean isAnswerTrue() {
        return answer;
    }
}
