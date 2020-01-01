package com.thaiduong.passwordgenerator;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Random random = new Random();
    private EditText lengthInput;
    private CheckBox lowercaseCheckBox;
    private CheckBox uppercaseCheckBox;
    private CheckBox numberCheckBox;
    private CheckBox specialCharacterCheckBox;
    private TextView passwordTextView;
    private Boolean passwordGenerated;
    private String password = "";

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

        passwordGenerated = false;
    }

    public void onGenerateButtonClicked(View view) {
        passwordTextView.setText(GeneratePassword());
    }

    private String GeneratePassword() {
        String passwordBase = "";

        int passwordLength = getNumber(lengthInput);

        String lowercaseLetters = "abcdefghijklmnopqrstuvwxyz";
        String uppercaseLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

        String numbers = "1234567890";
        String specialCharacters = "~!@#$%^&*()[]{};:<>,.?/|+-";

        if (passwordLength < 0) {
            Toast.makeText(this, "Password length cannot be negative!", Toast.LENGTH_SHORT).show();
        }
        if (passwordLength == 0) {
            Toast.makeText(this, "Password length cannot be zero!", Toast.LENGTH_SHORT).show();
        }
        if (passwordLength > 30) {
            Toast.makeText(this, "Password cannot be longer than 30 characters!", Toast.LENGTH_SHORT).show();
        }

        if (!lowercaseCheckBox.isChecked() && !uppercaseCheckBox.isChecked() && !numberCheckBox.isChecked() && !specialCharacterCheckBox.isChecked()) {
            Toast.makeText(this, "Please check at least one box above!", Toast.LENGTH_SHORT).show();
        }
        if (lowercaseCheckBox.isChecked() || uppercaseCheckBox.isChecked() || numberCheckBox.isChecked() || specialCharacterCheckBox.isChecked()) {
            password = "";
            if (lowercaseCheckBox.isChecked()) {
                passwordBase += lowercaseLetters;
            }
            if (uppercaseCheckBox.isChecked()) {
                passwordBase += uppercaseLetters;
            }
            if (numberCheckBox.isChecked()) {
                passwordBase += numbers;
            }
            if (specialCharacterCheckBox.isChecked()) {
                passwordBase += specialCharacters;
            }

            for (int i = 0; i < passwordLength; i++) {
                password += passwordBase.charAt(random.nextInt(passwordBase.length()));
            }
            passwordGenerated = true;
        }

        return password;
    }

    private int getNumber(EditText editText) {
        if (TextUtils.isEmpty(editText.getText())) {
            return 0;
        } else {
            return Integer.parseInt(editText.getText().toString());
        }
    }

    public void onCopyButtonPressed(View view) {
        if (!passwordGenerated) {
            Toast.makeText(this, "Password not generated yet!", Toast.LENGTH_SHORT).show();
        } else {
            ClipboardManager clipboardManager = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
            ClipData clipData = ClipData.newPlainText(password, password);

            assert clipboardManager != null;
            clipboardManager.setPrimaryClip(clipData);
            Toast.makeText(this, "Password copied", Toast.LENGTH_SHORT).show();
        }
    }
}
