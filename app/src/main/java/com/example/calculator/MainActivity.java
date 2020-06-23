package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.SoundEffectConstants;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.math.RoundingMode;
import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    private TextView showNumber;
    private String text = "0";
    private double num1 = 0;
    private double num2 = 0;
    private char op;
    private boolean found = false;
    private boolean equalPressed = false;
    private boolean opPressed = false;
    private DecimalFormat dc = new DecimalFormat("#.###########");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        showNumber = (TextView) findViewById(R.id.display);
        showNumber.setText(text);
        dc.setRoundingMode(RoundingMode.HALF_UP);
    }


    public void zero_pressed(View view) {
        if(text.length() == 12) return;
        if(text == "0") return;
        if(equalPressed && !opPressed) {
            num1 = 0;
            num2 = 0;
            text = "";
            equalPressed = false;
        }
        text += "0";
        showNumber.setText(text);
        opPressed = false;
    }
    public void one_pressed(View view) {
        if(text.length() == 12) return;
        if(text == "0") text = "";
        if(equalPressed && !opPressed) {
            num1 = 0;
            num2 = 0;
            text = "";
            equalPressed = false;
        }
        text += "1";
        showNumber.setText(text);
        opPressed = false;
    }
    public void two_pressed(View view) {
        if(text.length() == 12) return;
        if(text == "0") text = "";
        if(equalPressed && !opPressed) {
            num1 = 0;
            num2 = 0;
            text = "";
            equalPressed = false;
        }
        text += "2";
        showNumber.setText(text);
        opPressed = false;
    }
    public void three_pressed(View view) {
        if(text.length() == 12) return;
        if(text == "0") text = "";
        if(equalPressed && !opPressed) {
            num1 = 0;
            num2 = 0;
            text = "";
            equalPressed = false;
        }
        text += "3";
        showNumber.setText(text);
        opPressed = false;
    }
    public void four_pressed(View view) {
        if(text.length() == 12) return;
        if(text == "0") text = "";
        if(equalPressed && !opPressed) {
            num1 = 0;
            num2 = 0;
            text = "";
            equalPressed = false;
        }
        text += "4";
        showNumber.setText(text);
        opPressed = false;
    }
    public void five_pressed(View view) {
        if(text.length() == 12) return;
        if(text == "0") text = "";
        if(equalPressed && !opPressed) {
            num1 = 0;
            num2 = 0;
            text = "";
            equalPressed = false;
        }
        text += "5";
        showNumber.setText(text);
        opPressed = false;
    }
    public void six_pressed(View view) {
        if(text.length() == 12) return;
        if(text == "0") text = "";
        if(equalPressed && !opPressed) {
            num1 = 0;
            num2 = 0;
            text = "";
            equalPressed = false;
        }
        text += "6";
        showNumber.setText(text);
        opPressed = false;
    }
    public void seven_pressed(View view) {
        if(text.length() == 12) return;
        if(text == "0") text = "";
        if(equalPressed && !opPressed) {
            num1 = 0;
            num2 = 0;
            text = "";
            equalPressed = false;
        }
        text += "7";
        showNumber.setText(text);
        opPressed = false;
    }
    public void eight_pressed(View view) {
        if(text.length() == 12) return;
        if(text == "0") text = "";
        if(equalPressed && !opPressed) {
            num1 = 0;
            num2 = 0;
            text = "";
            equalPressed = false;
        }
        text += "8";
        showNumber.setText(text);
        opPressed = false;
    }
    public void nine_pressed(View view) {
        if(text.length() == 12) return;
        if(text == "0") text = "";
        if(equalPressed && !opPressed) {
            num1 = 0;
            num2 = 0;
            text = "";
            equalPressed = false;
        }
        text += "9";
        showNumber.setText(text);
        opPressed = false;
    }
    public void dec_pressed(View view) {
        if(text.length() == 13) return;
        for(int i = 0; i < text.length(); i++){
            if(text.charAt(i) == '.') return;
        }
        text += ".";
        showNumber.setText(text);
    }
    public void neg_pressed(View view) {
        if(text.length() == 0) return;
        if(text.charAt(0) != '-') text = "-" + text;
        else text = text.substring(1,text.length());
        showNumber.setText(text);
     }
    public void equal_pressed(View view) {
        if(opPressed) return;
        num2 = Double.parseDouble(text);
        switch (op){
            case '+':
                num1 += num2;
                break;
            case '-':
                num1 -= num2;
                break;
            case '/':
                num1 /= num2;
                break;
            case '*':
                int i = 0;
                while(num1 % 1 != 0 && num2 % 1 != 0){
                    i++;
                    num1 *= 10;
                    num2 *= 10;
                }
                num1 *= num2;
                i *= 2;
                while(i > 0){
                    num1 /= 10;
                    i--;
                }
                break;
            case '^':
                num1 = Math.pow(num1, num2);
                break;
            default:
        }
        text = Double.toString(num1);
        if(num1 % 1 == 0) text = text.substring(0, text.length()-2);
        showNumber.setText(text);
        text = "0";
        num2 = 0;
        equalPressed = true;
    }
    public void plus_pressed(View view) {
        op = '+';
        if(opPressed) return;
        if(num1 != 0 && num2 != 0){
            num1 += num2;
            num2 = 0;
            num1 = Math.round(num1 * 12) /12;
            text = Double.toString(num1);
            showNumber.setText(text);
        }
        else if(num1 == 0) num1 = Double.parseDouble(text);
        else num2 = Double.parseDouble(text);
        text = "";
        opPressed = true;
    }
    public void minus_pressed(View view) {
        op = '-';
        if(opPressed) return;
        if(num1 != 0 && num2 != 0){
            num1 -= num2;
            num2 = 0;
            num1 = Math.round(num1 * 12) /12;
            text = Double.toString(num1);
            showNumber.setText(text);
        }
        else if(num1 == 0) num1 = Double.parseDouble(text);
        else num2 = Double.parseDouble(text);
        text = "";
        opPressed = true;
    }
    public void divide_pressed(View view) {
        op = '/';
        if(opPressed) return;
        if(num1 != 0 && num2 != 0){
            num1 /= num2;
            num2 = 0;
            num1 = Math.round(num1 * 12) /12;
            text = Double.toString(num1);
            showNumber.setText(text);
        }
        else if(num1 == 0) num1 = Double.parseDouble(text);
        else num2 = Double.parseDouble(text);
        text = "";
        opPressed = true;
    }
    public void multiply_pressed(View view) {
        op = '*';
        if(opPressed) return;
        if(num1 != 0 && num2 != 0){
            num1 *= num2;
            num2 = 0;
            num1 = Math.round(num1 * 12) /12;
            text = Double.toString(num1);
            showNumber.setText(text);
        }
        else if(num1 == 0) num1 = Double.parseDouble(text);
        else num2 = Double.parseDouble(text);
        text = "";
        opPressed = true;
    }
    public void power_pressed(View view) {
        op = '^';
        if(opPressed) return;
        if(num1 != 0 && num2 != 0){
            Toast.makeText(this, "Please press enter", Toast.LENGTH_SHORT).show();
        }
        else if(num1 == 0) num1 = Double.parseDouble(text);
        else num2 = Double.parseDouble(text);
        text = "";
        opPressed = true;
    }
    public void back_pressed(View view) {
        if(text.length() == 0) return;
        String text2 = text.substring(0,text.length()-1);
        text = text2;
        if(text.length() == 0) text = "0";
        if(text.length() == 1) if(text.charAt(0) == '-') text = "";
        showNumber.setText(text);
    }
    public void clr_pressed(View view) {
        text = "0";
        num1 = 0;
        num2 = 0;
        showNumber.setText(text);
    }
}
