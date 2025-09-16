package com.example.albert;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity
{
    EditText screenEditText;
    int sum = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        screenEditText = findViewById(R.id.editTextNumber);
    }
    public void writeToEditText(View view)
    {
        String op = ((Button) view).getText().toString();
        screenEditText.setText(screenEditText.getText().toString() + op);
        screenEditText.setSelection(screenEditText.getText().length());

    }
    public void equal(View view)
    {
        String text = screenEditText.getText().toString();

        char oprishin = '+';
        String currentNumber = "";

        for (int i = 0; i < text.length(); i++)
        {
            char c = text.charAt(i);

            if ((c == '+' || c == '-' || c == '*' || c == '/') && !(i == 0 && c == '-'))
            {
                int num = Integer.parseInt(currentNumber);
                switch (oprishin)
                {
                    case '+':
                        sum += num; break;
                    case '-':
                        sum -= num; break;
                    case '*':
                        sum *= num; break;
                    case '/':
                        sum /= num; break;
                }

                oprishin = c;
                currentNumber = "";
            }
            else
            {
                currentNumber += c;

            }
        }


        if (!currentNumber.isEmpty())
        {
            int num = Integer.parseInt(currentNumber);
            switch (oprishin)
            {
                case '+':
                    sum += num; break;
                case '-':
                    sum -= num; break;
                case '*':
                    sum *= num; break;
                case '/':
                    sum /= num; break;
            }
        }
        screenEditText.setText(String.valueOf(sum));
        screenEditText.setSelection(screenEditText.getText().length());
        }

    public void clear(View view)
    {
        screenEditText.setText("");
    }

    public void goCredit(View view)
    {
        Intent lastSum = new Intent (this, Credits.class);
        lastSum.putExtra("last", sum);
        startActivity(lastSum);
    }
}
