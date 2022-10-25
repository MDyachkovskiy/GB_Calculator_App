package Calculator.Application;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    TextView inputScreen, resultScreen;
    MaterialButton buttonResult, buttonClear, buttonDot;
    MaterialButton buttonPlus, buttonMinus, buttonDivision, buttonMultiply;
    MaterialButton button7,button8,button9, button6, button5, button4, button3, button2, button1, button0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inputScreen = findViewById(R.id.input_screen);
        resultScreen = findViewById(R.id.output_text);
        assignId(button0,R.id.btn0);
        assignId(button1,R.id.btn1);
        assignId(button2,R.id.btn2);
        assignId(button3,R.id.btn3);
        assignId(button4,R.id.btn4);
        assignId(button5,R.id.btn5);
        assignId(button6,R.id.btn6);
        assignId(button7,R.id.btn7);
        assignId(button8,R.id.btn8);
        assignId(button9,R.id.btn9);
        assignId(buttonDot,R.id.btn_dot);
        assignId(buttonClear,R.id.btn_clear);
        assignId(buttonMinus,R.id.btn_minus);
        assignId(buttonPlus,R.id.btn_plus);
        assignId(buttonDivision,R.id.btn_division);
        assignId(buttonMultiply,R.id.btn_multiply);
        assignId(buttonResult,R.id.btn_result);

    }

    void assignId(MaterialButton button, int id){
        button = findViewById(id);
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

    }
}