package com.thaiduong.passwordgenerator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText lengthInput;

    private CheckBox lowercaseCheckBox;
    private CheckBox uppercaseCheckBox;
    private CheckBox numberCheckBox;
    private CheckBox specialCharacterCheckBox;

    private TextView passwordTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lengthInput = findViewById(R.id.lengthInput);

        lowercaseCheckBox = findViewById(R.id.lowercaseCheckBox);
        uppercaseCheckBox = findViewById(R.id.uppercaseCheckBox);
        numberCheckBox = findViewById(R.id.numberCheckBox);
        specialCharacterCheckBox = findViewById(R.id.specialCharacterCheckBox);

        passwordTextView = findViewById(R.id.password);
    }

    public void onGenerateButtonClicked(View view)
    {
        passwordTextView.setText(GeneratePassword());
    }

    private String GeneratePassword()
    {
        String password = "";
        String passwordBase = "";

        int passwordLength = getNumber(lengthInput);

        String lowercaseLetters = "abcdefghijklmnopqrstuvwxyz";
        String uppercaseLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

        String numbers = "1234567890";
        String specialCharacters = "~!@#$%^&*()[]{};:<>,.?/|+-";

        if (passwordLength < 0)
        {
            password = "Password length cannot be negative!";
        }
        if (passwordLength == 0)
        {
            password = "Password length cannot be zero!";
        }
        if (passwordLength > 30)
        {
            password = "Password cannot be longer that 30 characters!";
        }

        if (!lowercaseCheckBox.isChecked() && !uppercaseCheckBox.isChecked() && !numberCheckBox.isChecked() && !specialCharacterCheckBox.isChecked())
        {
            password = "Please check at least one box above!";
        }
        else
        {
            if (lowercaseCheckBox.isChecked())
            {
                passwordBase += lowercaseLetters;
            }
            if (uppercaseCheckBox.isChecked())
            {
                passwordBase += uppercaseLetters;
            }
            if (numberCheckBox.isChecked())
            {
                passwordBase += numbers;
            }
            if (specialCharacterCheckBox.isChecked())
            {
                passwordBase += specialCharacters;
            }
        }

        return password;
    }

    private int getNumber(EditText editText)
    {
        if (TextUtils.isEmpty(editText.getText()))
        {
            return 0;
        }
            else
        {
            return Integer.parseInt(editText.getText().toString());
        }
    }
}
