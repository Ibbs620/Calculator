package com.example.calculator;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.math.RoundingMode;
import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {
    private TextView showNumber;
    private String text = "0";
    private double num1 = 0;
    private double num2 = 0;
    private char op;
    private boolean equalPressed = false;
    private boolean opPressed = false;
    private NumberFormat dc = NumberFormat.getInstance();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        showNumber = findViewById(R.id.display);
        showNumber.setText(text);
        dc.setRoundingMode(RoundingMode.HALF_UP);
    }


    public void zero_pressed(View view) {
        if (text.length() == 12) return;
        if (text.equals("0")) return;
        if (equalPressed && !opPressed) {
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
        if (text.length() == 12) return;
        if (text.equals("0")) text = "";
        if (equalPressed && !opPressed) {
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
        if (text.length() == 12) return;
        if (text.equals("0")) text = "";
        if (equalPressed && !opPressed) {
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
        if (text.length() == 12) return;
        if (text.equals("0")) text = "";
        if (equalPressed && !opPressed) {
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
        if (text.length() == 12) return;
        if (text.equals("0")) text = "";
        if (equalPressed && !opPressed) {
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
        if (text.length() == 12) return;
        if (text.equals("0")) text = "";
        if (equalPressed && !opPressed) {
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
        if (text.length() == 12) return;
        if (text.equals("0")) text = "";
        if (equalPressed && !opPressed) {
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
        if (text.length() == 12) return;
        if (text.equals("0")) text = "";
        if (equalPressed && !opPressed) {
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
        if (text.length() == 12) return;
        if (text.equals("0")) text = "";
        if (equalPressed && !opPressed) {
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
        if (text.length() == 12) return;
        if (text.equals("0")) text = "";
        if (equalPressed && !opPressed) {
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
        if (text.length() == 13) return;
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == '.') return;
        }
        text += ".";
        showNumber.setText(text);
    }

    public void neg_pressed(View view) {
        if (text.equals("0")) return;
        if (text.charAt(0) != '-') text = "-" + text;
        else {
            text = text.substring(1);
        }
        showNumber.setText(text);
    }

    public void equal_pressed(View view) {
        if (opPressed) return;
        num2 = Double.parseDouble(text);
        switch (op) {
            case '+':
                num1 += num2;
                break;
            case '-':
                num1 -= num2;
                break;
            case '/':
                if (num2 == 0) {
                    text = "Error";
                    showNumber.setText(text);
                    text = "0";
                    num2 = 0;
                    equalPressed = true;
                }
                num1 /= num2;
                break;
            case '*':
                int i = 0;
                while (num1 % 1 != 0 && num2 % 1 != 0) {
                    i++;
                    num1 *= 10;
                    num2 *= 10;
                }
                num1 *= num2;
                i *= 2;
                while (i > 0) {
                    num1 /= 10;
                    i--;
                }
                break;
            case '^':
                num1 = Math.pow(num1, num2);
                break;
            default:
        }
        if (num1 > 9.99999999999E+11) {
            for (int i = text.length() - 1; i >= 0; i--) {
                if (text.charAt(i) == 'E') {
                    text = text.substring(0, 11) + text.substring(i, text.length() - 1);
                    break;
                }
            }
        } else if (num1 > 10000000) {
            text = dc.format(num1);
            StringBuilder text2 = new StringBuilder();
            for (int i = 0; i <= text.length() - 1; i++) {
                if (text.charAt(i) != ',') text2.append(text.charAt(i));
            }
            text = text2.toString();
        } else {
            text = Double.toString(num1);
            if (num1 % 1 == 0) text = text.substring(0, text.length() - 2);
        }
        showNumber.setText(text);
        text = "0";
        num2 = 0;
        equalPressed = true;
    }

    public void plus_pressed(View view) {
        op = '+';
        if (opPressed) return;
        if (num1 != 0 && num2 != 0) {
            num1 += num2;
            num2 = 0;
            text = Double.toString(num1);
            showNumber.setText(text);
        } else if (num1 == 0) num1 = Double.parseDouble(text);
        else num2 = Double.parseDouble(text);
        text = "";
        opPressed = true;
    }

    public void minus_pressed(View view) {
        op = '-';
        if (opPressed) return;
        if (num1 != 0 && num2 != 0) {
            num1 -= num2;
            num2 = 0;
            text = Double.toString(num1);
            showNumber.setText(text);
        } else if (num1 == 0) num1 = Double.parseDouble(text);
        else num2 = Double.parseDouble(text);
        text = "";
        opPressed = true;
    }

    public void divide_pressed(View view) {
        op = '/';
        if (opPressed) return;
        if (num1 != 0 && num2 != 0) {
            num1 /= num2;
            num2 = 0;
            text = Double.toString(num1);
            showNumber.setText(text);
        } else if (num1 == 0) num1 = Double.parseDouble(text);
        else num2 = Double.parseDouble(text);
        text = "";
        opPressed = true;
    }

    public void multiply_pressed(View view) {
        op = '*';
        if (opPressed) return;
        if (num1 != 0 && num2 != 0) {
            num1 *= num2;
            num2 = 0;
            text = Double.toString(num1);
            showNumber.setText(text);
        } else if (num1 == 0) num1 = Double.parseDouble(text);
        else num2 = Double.parseDouble(text);
        text = "";
        opPressed = true;
    }

    public void power_pressed(View view) {
        op = '^';
        if (opPressed) return;
        if (num1 != 0 && num2 != 0) {
            Toast.makeText(this, "Please press enter", Toast.LENGTH_SHORT).show();
        } else if (num1 == 0) num1 = Double.parseDouble(text);
        else num2 = Double.parseDouble(text);
        text = "";
        opPressed = true;
    }

    public void back_pressed(View view) {
        if (text.equals("0")) return;
        if (text.length() == 1 || (text.charAt(0) == '-' && text.length() == 2)) text = "0";
        else text = text.substring(0, text.length() - 1);
        showNumber.setText(text);
    }

    public void clr_pressed(View view) {
        text = "0";
        num1 = 0;
        num2 = 0;
        showNumber.setText(text);
    }
}
