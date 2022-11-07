package Calculator.Application;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    // Домашнее задание 4 урока

    private static final String ADDITION = "+";
    private static final String MINUS = "-";
    private static final String MULTIPLY = "*";
    private static final String DIVISION = "/";

    private String currentSymbol;

    private double firstValue = Double.NaN;
    private double secondValue;
    private DecimalFormat decimalFormat;


    TextView inputScreen, resultScreen;
    MaterialButton buttonResult, buttonClear, buttonDot;
    MaterialButton buttonPlus, buttonMinus, buttonDivision, buttonMultiply;
    MaterialButton button7, button8, button9, button6, button5, button4, button3, button2, button1, button0;
    MaterialButton goToThemeButton;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputScreen = findViewById(R.id.input_screen);
        resultScreen = findViewById(R.id.output_text);


        /* if (savedInstanceState != null) {
          firstValue = savedInstanceState.getDouble("calculations");
          secondValue = savedInstanceState.getDouble("result");
          inputScreen.setText(decimalFormat.format(firstValue));
          resultScreen.setText(decimalFormat.format(secondValue));
        } */

        decimalFormat = new DecimalFormat("#.##########");



        button0 = findViewById(R.id.btn0);
        button1 = findViewById(R.id.btn1);
        button2 = findViewById(R.id.btn2);
        button3 = findViewById(R.id.btn3);
        button4 = findViewById(R.id.btn4);
        button5 = findViewById(R.id.btn5);
        button6 = findViewById(R.id.btn6);
        button7 = findViewById(R.id.btn7);
        button8 = findViewById(R.id.btn8);
        button9 = findViewById(R.id.btn9);

        buttonDot = findViewById(R.id.btn_dot);
        buttonClear = findViewById(R.id.btn_clear);
        buttonMinus = findViewById(R.id.btn_minus);
        buttonPlus = findViewById(R.id.btn_plus);
        buttonDivision = findViewById(R.id.btn_division);
        buttonMultiply = findViewById(R.id.btn_multiply);
        buttonResult = findViewById(R.id.btn_result);

        goToThemeButton = findViewById(R.id.goToThemeButton);

        button0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inputScreen.setText(inputScreen.getText() + "0");
            }
        });

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inputScreen.setText(inputScreen.getText() + "1");
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inputScreen.setText(inputScreen.getText() + "2");
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inputScreen.setText(inputScreen.getText() + "3");
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inputScreen.setText(inputScreen.getText() + "4");
            }
        });

        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inputScreen.setText(inputScreen.getText() + "5");
            }
        });

        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inputScreen.setText(inputScreen.getText() + "6");
            }
        });

        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inputScreen.setText(inputScreen.getText() + "7");
            }
        });

        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inputScreen.setText(inputScreen.getText() + "8");
            }
        });

        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inputScreen.setText(inputScreen.getText() + "9");
            }
        });

        goToThemeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent openMenu = new Intent(MainActivity.this, ThemeMenu.class);
                startActivity(openMenu);
            }
        });

        buttonPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                allCalculations();
                currentSymbol = ADDITION;
                resultScreen.setText(decimalFormat.format(firstValue) + "+");
                inputScreen.setText(null);
            }
        });

        buttonMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                allCalculations();
                currentSymbol = MINUS;
                resultScreen.setText(decimalFormat.format(firstValue) + "-");
                inputScreen.setText(null);
            }
        });

        buttonMultiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                allCalculations();
                currentSymbol = MULTIPLY;
                resultScreen.setText(decimalFormat.format(firstValue) + "*");
                inputScreen.setText(null);
            }
        });

        buttonDivision.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                allCalculations();
                currentSymbol = DIVISION;
                resultScreen.setText(decimalFormat.format(firstValue) + "/");
                inputScreen.setText(null);
            }
        });

        buttonDot.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inputScreen.setText(inputScreen.getText() + ".");
            }
        }));

        buttonClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (inputScreen.getText().length() > 0) {
                    CharSequence currentText = inputScreen.getText();
                    inputScreen.setText(currentText.subSequence(0, currentText.length() - 1));
                } else {
                    firstValue = Double.NaN;
                    secondValue = Double.NaN;
                    inputScreen.setText("");
                    resultScreen.setText("");
                }
            }
        });

        buttonResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                allCalculations();
                resultScreen.setText(decimalFormat.format(firstValue));
                firstValue = Double.NaN;
                currentSymbol = "0";
            }
        });
    }

    private void allCalculations() {
        if (!Double.isNaN(firstValue)) {
            secondValue = Double.parseDouble(inputScreen.getText().toString());
            inputScreen.setText(null);

            if (currentSymbol == ADDITION)
                firstValue = this.firstValue + secondValue;
            else if (currentSymbol == MINUS)
                firstValue = this.firstValue - secondValue;
            else if (currentSymbol == MULTIPLY)
                firstValue = this.firstValue * secondValue;
            else if (currentSymbol == DIVISION)
                firstValue = this.firstValue / secondValue;
        } else {
            try {
                firstValue = Double.parseDouble(inputScreen.getText().toString());
            } catch (Exception e) {

            }
        }
    }
    @Override
    protected void onSaveInstanceState(@NonNull Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putDouble("calculations", firstValue);
        savedInstanceState.putDouble("result", secondValue);
    }
}