package Calculator.Application;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        decimalFormat = new DecimalFormat("#.##########");

        inputScreen = findViewById(R.id.input_screen);
        resultScreen = findViewById(R.id.output_text);

        assignId(button0, R.id.btn0);
        assignId(button1, R.id.btn1);
        assignId(button2, R.id.btn2);
        assignId(button3, R.id.btn3);
        assignId(button4, R.id.btn4);
        assignId(button5, R.id.btn5);
        assignId(button6, R.id.btn6);
        assignId(button7, R.id.btn7);
        assignId(button8, R.id.btn8);
        assignId(button9, R.id.btn9);

        assignId(buttonDot, R.id.btn_dot);
        assignId(buttonClear, R.id.btn_clear);
        assignId(buttonMinus, R.id.btn_minus);
        assignId(buttonPlus, R.id.btn_plus);
        assignId(buttonDivision, R.id.btn_division);
        assignId(buttonMultiply, R.id.btn_multiply);
        assignId(buttonResult, R.id.btn_result);

        button0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inputScreen.setText(inputScreen.getText()+"0");
            }
        });

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inputScreen.setText(inputScreen.getText()+"1");
            }
        });

        button0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inputScreen.setText(inputScreen.getText()+"0");
            }
        });
    }

    void assignId(MaterialButton button, int id) {
        button = findViewById(id);
        button.setOnClickListener((View.OnClickListener) this);
    }

    private void allCalculations(){
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
                firstValue = this.firstValue/secondValue;
        } else {
            try {
                firstValue = Double.parseDouble(inputScreen.getText().toString());
            } catch(Exception e) {

            }
        }
    }
}