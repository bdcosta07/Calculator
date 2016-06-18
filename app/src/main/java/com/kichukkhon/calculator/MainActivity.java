package com.kichukkhon.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.text.DecimalFormat;

import static java.lang.Math.sqrt;

public class MainActivity extends AppCompatActivity {

    TextView showResult;
    String input = "";
    double num = 0;
    double tempNum = 0;
    Character operator = '+';
    int numCount = 0;
    Character tempOperator = '+';
    int digitCount = 0;
    double lastAns = 0.0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        showResult = (TextView) findViewById(R.id.txtResult);
    }

    public void btn7Click(View view) {
        insert("7");
    }

    public void btn8Click(View view) {
        insert("8");
    }

    public void btn9Click(View view) {
        insert("9");
    }

    public void btn4Click(View view) {
        insert("4");

    }

    public void btn5Click(View view) {
        insert("5");
    }


    public void btn6Click(View view) {
        insert("6");
    }

    public void btn1Click(View view) {
        insert("1");
    }

    public void btn2Click(View view) {
        insert("2");
    }

    public void btn3Click(View view) {
        insert("3");
    }

    public void btn0Click(View view) {
        insert("0");
    }


    public void btnCancelClick(View view) {
        clearAll();
        lastAns = 0;
        showResult.setText("0");
    }

    public void btnSignClick(View view) {
    }

    public void btnPowerClick(View view) {
        operator = '^';
        calculate();
        tempOperator = '^';
    }

    public void btnSqrClick(View view) {
        try {
            num = Double.parseDouble(input);
            //input="";

            num = num * num;
            input = Double.toString(num);

            if (num == (int) num) {
                showResult.setText(String.valueOf((int) num));

            } else
                showResult.setText(String.valueOf(num));
        } catch (NumberFormatException ex) {
            showResult.setText("Try putting number first");
        }
    }

    public void btnSqrtClick(View view) {
        try {
            num = Double.parseDouble(input);
            //input = "";
            //operator = '√';

            num = sqrt(num);
            input = Double.toString(num);

            if (num == (int) num) {
                showResult.setText(String.valueOf((int) num));

            } else
                showResult.setText(String.valueOf(num));
        } catch (NumberFormatException ex) {
            showResult.setText("Try putting number first");
        }

    }

    public void btnPercentClick(View view) {
        //operator = '%';
        //calculate();
        //tempOperator = '%';
        try {
            num = Double.parseDouble(input);
            double percentNum = tempNum == 0 ? 1 : tempNum;
            num = percentNum * num / 100;
            input = String.valueOf(num);
            showResult.setText(input);
        } catch (NumberFormatException ex) {

        }
    }


    public void btnDivClick(View view) {
        operator = '÷';
        calculate();
        tempOperator = '÷';
    }


    public void btnMultiClick(View view) {
        operator = '*';
        calculate();
        tempOperator = '*';
    }


    public void btnSubClick(View view) {
        operator = '-';
        calculate();
        tempOperator = '-';
    }

    public void btnPlusClick(View view) {
        operator = '+';
        calculate();
        tempOperator = '+';
    }


    public void btnPointClick(View view) {
        if (!input.contains("."))
            insert(".");
    }

    public void btnEqlClick(View view) {
        if (!input.equals("")) {
            num = Double.parseDouble(input);

            if (operator == '÷')
                num = tempNum / num;
            else if (operator == '*')
                num = tempNum * num;
            else if (operator == '+')
                num = tempNum + num;
            else if (operator == '-')
                num = tempNum - num;
            else if (operator == '^')
                num = Math.pow(tempNum, num);


            if (num == (int) num) {
                showResult.setText(String.valueOf((int) num));
            } else
                showResult.setText(String.valueOf(num));

            lastAns = num;
            clearAll();
        }
    }

    public void insert(String displayNum) {
        /*input = input + Integer.toString(displayNum);
        //num = Double.parseDouble(input);
        showResult.setText(input);*/

        if (digitCount == 0 && displayNum.equals(".")) {
            input = "0.";
        } else {
            input += displayNum;
        }

        try {
            int val = Integer.parseInt(input);
            input = String.valueOf(val);
        } catch (NumberFormatException e) {

        }

        showResult.setText(input);

        digitCount++;
    }

    public void calculate() {
        digitCount = 0;

        if (input.equals("") && lastAns > 0)
            input = Double.toString(lastAns);

        if (!input.equals("")) {
            num = Double.parseDouble(input);
            input = "";


            if (tempOperator == '÷') {
                /*if(num==0)
                    showResult.setText("Can't divide by 0");
                else*/
                tempNum = tempNum / num;
            } else if (tempOperator == '*')
                tempNum = tempNum * num;
            else if (tempOperator == '+')
                tempNum = tempNum + num;
            else if (tempOperator == '-')
                tempNum = tempNum - num;
            else if (tempOperator == '^')
                tempNum = Math.pow(tempNum, num);


            /*if (tempNum == (int) tempNum) {
                showResult.setText(String.valueOf((int) tempNum)+" "+operator);

            } else
                showResult.setText(String.valueOf(tempNum)+" "+operator);*/
        }

        if (tempNum == (int) tempNum) {
            showResult.setText(String.valueOf((int) tempNum) + " " + operator);

        } else
            showResult.setText(String.valueOf(tempNum) + " " + operator);
    }

    public void clearAll() {
        input = "";
        num = 0;
        tempNum = 0;
        operator = '+';
        tempOperator = '+';
        numCount = 0;
    }


}
