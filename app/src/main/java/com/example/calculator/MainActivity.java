package com.example.calculator;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.math.RoundingMode;
import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {

    private TextView showNumber; //Textview to show answer
    private String text = "0"; //Text containing number input
    private double num1 = 0; //Stores first number used in operations
    private double num2 = 0; //Stores second number used in operations
    private char op; //Stores the last pressed operator button
    private boolean equalPressed = false; //Checks if the last button pressed was (=)
    private boolean opPressed = false; //Checks if the last button pressed was an operator
    private NumberFormat dc = NumberFormat.getInstance(); //Formats numbers


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        showNumber = findViewById(R.id.display);
        showNumber.setText(text);
        dc.setRoundingMode(RoundingMode.HALF_UP);
    }

    public void operation() { //Performs selected operation
        num2 = Double.parseDouble(text);
        switch (op) {
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
                num1 *= num2;
                break;
            case '^':
                num1 = Math.pow(num1, num2);
                break;
            default:
        }
        num2 = 0;
        text = format_num(num1);
        showNumber.setText(text);
    }

    public String format_num(double num) { //Formats number in decimal or scientific notation based on size
        String text; 
        if (num == 0) { //Prevents a bug where 0 is displayed in scientific notation
            text = "0";
        } else if (num >= 10000000 && num < 9.99999999999E11 || num <= -10000000 && num > -9.99999999999E11) { //Prevents numbers under 12 digits from being displayed as scientific notation
            text = dc.format(num);
            text = dc.format(num);
            StringBuilder text2 = new StringBuilder();
            for (int i = 0; i <= text.length() - 1; i++) { //Remove commas from formatted number
                if (text.charAt(i) != ',') text2.append(text.charAt(i));
            }
            text = text2.toString();
        } else if (num >= 1.0E100 || num <= -1.0E100 || Math.log10(num) <= -100 || (num > -1 && num < -1.0E-100)) { //Formats small numbers in scientific notation
            text = "Overflow";
        } else { //Handles all other numbers
            text = Double.toString(num);
            //Display large numbers in scientific notation with enough digits to fit on screen
            if (num > 9.99999999999E11) text = String.format("%.7e", num);
            else if (num < -9.99999999999E11) text = String.format("%.6e", num);
            else if (Math.log10(num) < -11) text = String.format("%.6e", num);
            else if (num > -1 && num < -0.00000000001) text = String.format("%.6e", num);
            else if (num % 1 == 0) text = text.substring(0, text.length() - 2); //Removes trailing .0s on whole numbers
        }
        return text;
    }

    public void zero_pressed(View view) { //onClick handler for the 0 button
        if (text.length() == 12) return;
        if (text.equals("0")) return;
        if (equalPressed && !opPressed) { //Resets numbers if the = button was pressed last
            num1 = 0;
            num2 = 0;
            text = "";
            equalPressed = false;
        }
        text += "0";
        showNumber.setText(text);
        opPressed = false;
    }

    public void one_pressed(View view) { //onClick handler for the 1 button
        if (text.length() == 12) return;
        if (text.equals("0")) text = "";
        if (equalPressed && !opPressed) { //Resets numbers if the = button was pressed last
            num1 = 0;
            num2 = 0;
            text = "";
            equalPressed = false;
        }
        text += "1";
        showNumber.setText(text);
        opPressed = false;
    }

    public void two_pressed(View view) { //onClick handler for the 2 button
        if (text.length() == 12) return;
        if (text.equals("0")) text = "";
        if (equalPressed && !opPressed) { //Resets numbers if the = button was pressed last
            num1 = 0;
            num2 = 0;
            text = "";
            equalPressed = false;
        }
        text += "2";
        showNumber.setText(text);
        opPressed = false;
    }

    public void three_pressed(View view) { //onClick handler for the 3 button
        if (text.length() == 12) return;
        if (text.equals("0")) text = "";
        if (equalPressed && !opPressed) { //Resets numbers if the = button was pressed last
            num1 = 0;
            num2 = 0;
            text = "";
            equalPressed = false;
        }
        text += "3";
        showNumber.setText(text);
        opPressed = false;
    }

    public void four_pressed(View view) {  //onClick handler for the 4 button
        if (text.length() == 12) return;
        if (text.equals("0")) text = "";
        if (equalPressed && !opPressed) { //Resets numbers if the = button was pressed last
            num1 = 0;
            num2 = 0;
            text = "";
            equalPressed = false;
        }
        text += "4";
        showNumber.setText(text);
        opPressed = false;
    }

    public void five_pressed(View view) { //onClick handler for the 5 button
        if (text.length() == 12) return;
        if (text.equals("0")) text = "";
        if (equalPressed && !opPressed) { //Resets numbers if the = button was pressed last
            num1 = 0;
            num2 = 0;
            text = "";
            equalPressed = false;
        }
        text += "5";
        showNumber.setText(text);
        opPressed = false;
    }

    public void six_pressed(View view) { //onClick handler for the 6 button
        if (text.length() == 12) return;
        if (text.equals("0")) text = "";
        if (equalPressed && !opPressed) { //Resets numbers if the = button was pressed last
            num1 = 0;
            num2 = 0;
            text = "";
            equalPressed = false;
        }
        text += "6";
        showNumber.setText(text);
        opPressed = false;
    }

    public void seven_pressed(View view) { //onClick handler for the 7 button
        if (text.length() == 12) return;
        if (text.equals("0")) text = "";
        if (equalPressed && !opPressed) { //Resets numbers if the = button was pressed last
            num1 = 0;
            num2 = 0;
            text = "";
            equalPressed = false;
        }
        text += "7";
        showNumber.setText(text);
        opPressed = false;
    }

    public void eight_pressed(View view) { //onClick handler for the 8 button
        if (text.length() == 12) return;
        if (text.equals("0")) text = "";
        if (equalPressed && !opPressed) { //Resets numbers if the = button was pressed last
            num1 = 0;
            num2 = 0;
            text = "";
            equalPressed = false;
        }
        text += "8";
        showNumber.setText(text);
        opPressed = false;
    }

    public void nine_pressed(View view) { //onClick handler for the 9 button
        if (text.length() == 12) return;
        if (text.equals("0")) text = "";
        if (equalPressed && !opPressed) { //Resets numbers if the = button was pressed last
            num1 = 0;
            num2 = 0;
            text = "";
            equalPressed = false;
        }
        text += "9";
        showNumber.setText(text);
        opPressed = false;
    }

    public void dec_pressed(View view) { //onClick handler for the . button
        if (text.length() == 13) return;
        for (int i = 0; i < text.length(); i++) { //Prevents addition of extra decimal points when one is already present
            if (text.charAt(i) == '.') return;
        }
        text += ".";
        showNumber.setText(text);
        opPressed = false;
        equalPressed = false;
    }

    public void neg_pressed(View view) { //onClick handler for the +/- button
        if (opPressed) return; //Prevents crashes
        if (text.equals("0")) return;
        if (text.charAt(0) != '-') text = "-" + text; //Flips sign at beginning of number
        else {
            text = text.substring(1);
        }
        showNumber.setText(text);
    }

    public void equal_pressed(View view) { //onClick handler for the = button
        if (opPressed) return; //Prevents crashes
        operation(); 
        equalPressed = true;
    }

    public void plus_pressed(View view) { //onClick handler for the + button
        if (opPressed) return; //Prevents crashes
        if (num1 == 0) num1 = Double.parseDouble(text); //If numbers are reset, save entered values.
        else { //Allows for chain operations to be done without the use of the equal sign
            operation(); 
        }
        op = '+';
        text = "";
        opPressed = true;
        equalPressed = false;
    }

    public void minus_pressed(View view) { //onClick handler for the - button
        if (opPressed) return; //Prevents crashes
        if (num1 == 0) num1 = Double.parseDouble(text); //If numbers are reset, save entered values.
        else { //Allows for chain operations to be done without the use of the equal sign
            operation(); 
        }
        op = '-';
        text = "";
        opPressed = true;
        equalPressed = false;
    }

    public void divide_pressed(View view) { //onClick handler for the / button
        if (opPressed) return; //Prevents crashes
        if (num1 == 0) num1 = Double.parseDouble(text); //If numbers are reset, save entered values.
        else { //Allows for chain operations to be done without the use of the equal sign
            operation(); 
        }
        op = '/';
        text = "";
        opPressed = true;
        equalPressed = false;
    }

    public void multiply_pressed(View view) { //onClick handler for the x button
        if (opPressed) return; //Prevents crashes
        if (num1 == 0) num1 = Double.parseDouble(text); //If numbers are reset, save entered values.
        else { //Allows for chain operations to be done without the use of the equal sign
            operation(); 
        }
        op = '*';
        text = "";
        opPressed = true;
        equalPressed = false;
    }

    public void power_pressed(View view) { //onClick handler for the ^ button
        if (opPressed) return; //Prevents crashes
        if (equalPressed) {
            num1 = Double.parseDouble(text);
        } else if (num1 == 0) num1 = Double.parseDouble(text);
        else { //Allows for chain operations to be done without the use of the equal sign 
            operation();
        }
        op = '^';
        text = "";
        opPressed = true;
        equalPressed = false;
    }

    public void back_pressed(View view) { //onClick handler for the delete button
        if (text.equals("0")) return;
        if (text.length() == 1 || (text.charAt(0) == '-' && text.length() == 2)) text = "0";
        else text = text.substring(0, text.length() - 1);
        showNumber.setText(text);
    }

    public void clr_pressed(View view) { //onClick handler for the clear button
        text = "0";
        num1 = 0;
        num2 = 0;
        showNumber.setText(text);
    }
}
