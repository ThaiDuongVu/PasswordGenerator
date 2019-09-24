package com.thaiduong.passwordgenerator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText numberInput;

    private CheckBox lowercaseCheckBox;
    private CheckBox uppercaseCheckBox;
    private CheckBox numberCheckBox;
    private CheckBox specialCharacterCheckBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
