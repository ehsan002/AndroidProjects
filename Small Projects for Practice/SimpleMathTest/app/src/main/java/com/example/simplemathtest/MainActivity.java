package com.example.simplemathtest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    TextView textViewTimer;
    TextView textViewProblem;
    TextView textViewScore;
    TextView textViewResult;
    TextView textViewFinalScore;

    ImageView imageView;

    Button buttonOption1;
    Button buttonOption2;
    Button buttonOption3;
    Button buttonOption4;
    Button buttonPlayAgain;
    Button buttonStart;

    GridLayout gridLayout;

    int countdownTime = 30, scoreCounter =0, attemptCounter = 0;
    boolean flag = true;

    Random random = new Random();
    int number1, number2;

    String resultText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.i("Random Number: ", Integer.toString(random.nextInt()%10));

        initializeViews();

    }

    public void checkResult(View view){

        Button button = (Button) view;
        attemptCounter++;

        if (button.getText().equals(resultText)){
            Log.i("Result", "Correct!");

            textViewResult.setText("Correct!");
            scoreCounter++;

        }else {
            textViewResult.setText("Wrong");
            Log.i("Result", "Wrong!");

        }
        textViewScore.setText(scoreCounter+" / "+attemptCounter);
        problemSetup();

    }

    void setButtons(){

        String[] buttonText = new String[4];
        int i, x = Math.abs(random.nextInt()%4);
        resultText = number2+number1+"";
        for (i = 0;i<buttonText.length;i++){
            if (i == x)
                buttonText[i] = resultText;
            else
                buttonText[i] = number2+number1+(i+1)*3+x+"";
        }

        for (i = 0;i<buttonText.length;i++){
            Log.i("Button Text", buttonText[i]);
        }

        buttonOption1.setText(buttonText[0]);
        buttonOption2.setText(buttonText[1]);
        buttonOption3.setText(buttonText[2]);
        buttonOption4.setText(buttonText[3]);

    }

    void problemSetup(){

        number1 = Math.abs(random.nextInt()%10);

        number2 = Math.abs(random.nextInt()%10);

        textViewProblem.setText(number1+" + "+number2);

        setButtons();

    }

    public void playAgain(View view){
        setupResultView();
    }

    private void setupResultView(){

        if (!flag){
            textViewTimer.setVisibility(View.INVISIBLE);
            textViewProblem.setVisibility(View.INVISIBLE);
            textViewScore.setVisibility(View.INVISIBLE);

            gridLayout.setVisibility(View.INVISIBLE);

            textViewResult.setVisibility(View.INVISIBLE);

            textViewFinalScore.setVisibility(View.VISIBLE);
            buttonPlayAgain.setVisibility(View.VISIBLE);

            textViewFinalScore.setText("You have answered\n"+scoreCounter+"\nquestions correctly\nout of\n"+attemptCounter);

        }else{

            imageView.setVisibility(View.INVISIBLE);
            buttonStart.setVisibility(View.INVISIBLE);

            textViewTimer.setVisibility(View.VISIBLE);
            textViewProblem.setVisibility(View.VISIBLE);
            textViewScore.setVisibility(View.VISIBLE);

            gridLayout.setVisibility(View.VISIBLE);

            textViewResult.setVisibility(View.VISIBLE);

            textViewFinalScore.setVisibility(View.INVISIBLE);
            buttonPlayAgain.setVisibility(View.INVISIBLE);
            textViewScore.setText("0 / 0");
            textViewResult.setText("");
            setTimer();
        }

        flag = !flag;

    }

    private void setTimer(){
        CountDownTimer countDownTimer = new CountDownTimer(countdownTime*1000+100, 1000){

            @Override
            public void onTick(long l) {
                textViewTimer.setText(Long.toString(l/1000));
                Log.i("Time", Long.toString(l));
            }

            @Override
            public void onFinish() {
                setupResultView();
                Log.i("Time", "Over!");
            }
        };
        countDownTimer.start();
    }

    private void initializeViews(){

        textViewTimer = findViewById(R.id.tvTimer);
        textViewProblem = findViewById(R.id.tvProblem);
        textViewScore = findViewById(R.id.tvCurrentScore);
        textViewResult = findViewById(R.id.tvResult);
        textViewFinalScore = findViewById(R.id.tvFinalScore);

        imageView = findViewById(R.id.welcomeImage);

        buttonOption1 = findViewById(R.id.btnOption1);
        buttonOption2 = findViewById(R.id.btnOption2);
        buttonOption3 = findViewById(R.id.btnOption3);
        buttonOption4 = findViewById(R.id.btnOption4);
        buttonPlayAgain = findViewById(R.id.btnPlayAgain);
        buttonStart = findViewById(R.id.btnStart);

        gridLayout = findViewById(R.id.gridLayout);

        problemSetup();

    }

}