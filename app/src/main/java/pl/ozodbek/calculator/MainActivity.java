package pl.ozodbek.calculator;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;


import pl.ozodbek.calculator.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    protected double value1, value2, finalResult;
    protected char operation;
    StringBuilder textBlr = new StringBuilder();

    private @NonNull ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

    }

    public void ButtonVClick(@NonNull View view) {
        StringBuilder valueBlr = new StringBuilder(binding.editresult.getText().toString());

        switch (view.getId()) {
            case R.id.zerobtn:
                valueBlr.append("0");
                textBlr.append("0");
                break;
            case R.id.commabtn:
                if (textBlr.indexOf(".") == -1) {
                    if (valueBlr.length() > 0) {
                        valueBlr.append(".");
                        textBlr.append(".");
                    }
                }
                break;
            case R.id.onebtn:
                valueBlr.append("1");
                textBlr.append("1");
                break;
            case R.id.twobtn:
                valueBlr.append("2");
                textBlr.append("2");
                break;
            case R.id.threebtn:
                valueBlr.append("3");
                textBlr.append("3");
                break;
            case R.id.fourbtn:
                valueBlr.append("4");
                textBlr.append("4");
                break;
            case R.id.fivebtn:
                valueBlr.append("5");
                textBlr.append("5");
                break;
            case R.id.sixbtn:
                valueBlr.append("6");
                textBlr.append("6");
                break;
            case R.id.sevenbtn:
                valueBlr.append("7");
                textBlr.append("7");
                break;
            case R.id.eightbtn:
                valueBlr.append("8");
                textBlr.append("8");
                break;
            case R.id.ninebtn:
                valueBlr.append("9");
                textBlr.append("9");
                break;
            case R.id.clearbtn:
                valueBlr.setLength(0);
                textBlr.setLength(0);
                break;

            case R.id.deletebtn:
                if (valueBlr.length() > 0) {
                    valueBlr.deleteCharAt(valueBlr.length() - 1);
                }

                if (textBlr.length() > 0) {
                    textBlr.deleteCharAt(textBlr.length() - 1);
                }

                if (textBlr.indexOf("=") != -1) {
                    valueBlr.setLength(0);
                    textBlr.setLength(0);
                }
                break;
        }
        binding.editresult.setText(valueBlr.toString());
        binding.textresult.setText(textBlr.toString());
    }

    public void OperationClicked(@NonNull View view) {
        switch (view.getId()) {

            case R.id.plusbtn:
                operation = '+';
                break;

            case R.id.minusbtn:
                operation = '-';
                break;

            case R.id.multiplybtn:
                operation = 'x';
                break;

            case R.id.dividebtn:
                operation = '/';
                break;
        }
        if (binding.editresult.getText().length() > 0) {
            String value = binding.editresult.getText().toString();
            value1 = Double.parseDouble(value);
            textBlr.append(operation);
            binding.textresult.setText(textBlr.toString());
            binding.editresult.setText("");
        }
    }

    public void EqualsClicked(@NonNull View view) {
        if (binding.editresult.getText().length() > 0) {
            String value = binding.editresult.getText().toString();
            value2 = Double.parseDouble(value);

        }

        switch (operation) {
            case '+':
                finalResult = value1 + value2;
                break;
            case '-':
                finalResult = value1 - value2;
                break;
            case 'x':
                finalResult = value1 * value2;
                break;
            case '/':
                finalResult = value1 / value2;
                break;
        }
        textBlr.append("\n=" + finalResult);
        binding.editresult.setText(String.valueOf(finalResult));
        binding.textresult.setText(textBlr.toString());
    }
}