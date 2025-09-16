package com.example.albert;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Credits extends AppCompatActivity
{
    TextView textSum;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_credits);
        textSum = findViewById(R.id.sum);

        Intent get = getIntent();
        int x1 = get.getIntExtra("last",-1111111111);
        textSum.setText(Integer.toString(x1));

    }

    public void finishhh(View view)
    {
        finish();
    }
}