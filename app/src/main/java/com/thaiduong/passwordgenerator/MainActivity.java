package com.thaiduong.passwordgenerator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
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

        int passwordLength = Integer.parseInt(lengthInput.getText().toString());

        String lowercaseLetters = "abcdefghijklmnopqrstuvwxyz";
        String uppercaseLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

        String numbers = "1234567890";
        String specialCharacters = "~!@#$%^&*()[]{};:<>,.?/|+-";

        return password;
    }
}
