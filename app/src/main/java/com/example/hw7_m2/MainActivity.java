package com.example.hw7_m2;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView textView;
    private Integer first, second, sum, result, umResult, dResult;
    private Boolean isOparationClick;
    private String opeation;
    private  Button button;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.text_view);
        button=findViewById(R.id.btn_next);

        button.setOnClickListener(view -> {
            String resultat = textView.getText().toString();
            Intent intent=new Intent(MainActivity.this, TwoActivity.class);
            intent.putExtra("key", resultat.toString());
            startActivity(intent);
            finish();
        });

    }

    public void onOperationClick(View view) {

        String textButton = ((Button) view).getText().toString();
        switch (textButton) {
            case "+":
                first = Integer.valueOf(textView.getText().toString());
                opeation = "+";
                break;
            case "-":
                first = Integer.valueOf(textView.getText().toString());
                opeation = "-";
                break;
            case "x":
                first = Integer.valueOf(textView.getText().toString());
                opeation = "x";
                break;
            case "/":
                first = Integer.valueOf(textView.getText().toString());
                opeation = "/";
                break;
            case "=":

                button.setVisibility(View.VISIBLE);
                second = Integer.valueOf(textView.getText().toString());
                switch (opeation) {
                    case "+":
                        sum = first + second;
                        textView.setText(sum.toString());
                        break;
                    case "-":
                        result = first - second;
                        textView.setText(result.toString());
                        break;
                    case "x":
                        umResult = first * second;
                        textView.setText(umResult.toString());
                        break;
                    case "/":
                        if (second!=0){
                        dResult=first/second;
                        textView.setText(dResult.toString());
                        }else if (second==0) {
                            textView.setText("нельзя делить на ноль");
                        }
                        break;
                }

                break;
        }
        isOparationClick = true;
    }


    public void onNumberClick(View view) {
        String textButton = ((Button) view).getText().toString();
        if (textButton.equals("AC")) {
            textView.setText("0");
            first = 0;
        } else if (textView.getText().toString().equals("0") || isOparationClick) {
            textView.setText(textButton);
        } else {
            textView.append(textButton);
        }
        isOparationClick = false;
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}

    /*if (textButton.equals("+")){
                    second = Double.valueOf(textView.getText().toString());
                    sum = first + second;
                    textView.setText(sum.toString());
                } else if (textButton.equals("-")) {
                    second = Double.valueOf(textView.getText().toString());
                    sum = first - second;
                    textView.setText(sum.toString());
                } else if (textButton.equals("/")) {
                    second = Double.valueOf(textView.getText().toString());
                    sum = first / second;
                    textView.setText(sum.toString());
                } else if (textButton.equals("x")) {
                    second = Double.valueOf(textView.getText().toString());
                    sum = first * second;
                    textView.setText(sum.toString());
                } else if (textButton.equals("%")) {
                    second = Double.valueOf(textView.getText().toString());
                    sum = (first / 100) * second;
                    textView.setText(sum.toString());
                }*/