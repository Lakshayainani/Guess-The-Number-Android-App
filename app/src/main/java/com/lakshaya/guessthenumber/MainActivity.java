package com.lakshaya.guessthenumber;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    int randomNumber, counter;
    Random r = new Random();
    String message = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView HelpText = findViewById(R.id.textView);
        EditText userinput = findViewById(R.id.userInput);
        Button check = findViewById(R.id.Check);
        userinput.setHint("defautlt: 100, enter a value greater than 100");
        HelpText.setText("Enter the Upper Range of the Number you want me to guess!");
        check.setText("Start!");
        //randomNumber = r.nextInt(101);
        counter = 0;
    }

    public void checkGuess(View view) {
        EditText guessedNumber = findViewById(R.id.userInput);
        TextView output = findViewById(R.id.Output);
        TextView textView = findViewById(R.id.textView);
        Button check = findViewById(R.id.Check);

        if (check.getText().equals("Start!")) {
            String usrinpt = guessedNumber.getText().toString().trim();
            //check if the entered value is a number
            if (usrinpt.equals("")) {
                output.setText("No Number Entered , setting the upper limit as 100.");
                randomNumber = r.nextInt(101);
            }else if(Integer.parseInt(usrinpt)<100){
                output.setText("Number Entered is less then 100, setting the upper limit as 100.");
                randomNumber = r.nextInt(101);
            }
            else {
                output.setText("setting the upper limit as: " + usrinpt);
                randomNumber = r.nextInt(Integer.parseInt(usrinpt));
            }
            check.setText("Check!");
            guessedNumber.setHint("Enter the predicted number");
            textView.setText("I have guessed a number between 1 and 100 , Try to predict that in minimum number of tries");
        }
        //if the button says Check continue to play the game
        else if (check.getText().equals("Check!")) {
            String usrinpt = guessedNumber.getText().toString().trim();
            //check if the entered value is a number
            if (usrinpt.equals("")) {
                output.setText("Enter a Number to continue!!!");
            } else {
                //string to integer conversion
                int guessedNumberValue = Integer.parseInt(usrinpt);
                counter++;
                message = comparision(guessedNumberValue, randomNumber);
                guessedNumber.setText("");
                output.setText(message + "\nThe Number of Attempts = " + counter);
            }

        }

        //if the button text is Play again start a new game
        else {
            playAgain();

        }
        System.out.println(randomNumber);
    }

    String comparision(int inputnumber, int randomnumber) {
        String msg = "";
        Button check = findViewById(R.id.Check);
        if (inputnumber == randomnumber) {
            msg = inputnumber + " is Correct Guess!!";
            check.setText("Play Again!");
        } else if (inputnumber > randomnumber) {
            msg = inputnumber + " is Greater then the guessed number!";
        } else {
            msg = inputnumber + " is Smaller then the guessed number!";
        }

        return msg;
    }

    private void playAgain() {
        TextView output = findViewById(R.id.Output);
        Button check = findViewById(R.id.Check);

//        output.setText("I Have guessed another Number, Try Again");
//        check.setText("Check!");
//        randomNumber = r.nextInt(101);
        TextView HelpText = findViewById(R.id.textView);
        EditText userinput = findViewById(R.id.userInput);
        userinput.setHint("defautlt: 100, enter a value greater than 100");
        HelpText.setText("Enter the Upper Range of the Number you want me to guess!");
        check.setText("Start!");
        output.setText("");
        counter = 0;
    }
}
