package com.example.djcustomerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.util.Calendar;

public class CustomerRegistrationActivity extends AppCompatActivity {
    private EditText DOB;
    private EditText etUsername;
    private EditText etPassword;
    private EditText etConfirmPassword;
    private EditText etFullName;
    private EditText etMoNumber;
    private EditText etEmail;
    private String username;
    private String password;
    private String confirmPassword;
    private String fullName;
    private String number;
    private String email;
    private String gender;
    DatePickerDialog datePickerDialog;

    private RadioGroup radioGroup;
    private RadioButton rButton,maButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_registration);

        DOB = findViewById(R.id.DOB);
        etFullName = findViewById(R.id.etFullname);
        etUsername = findViewById(R.id.etUsername);
        etPassword = findViewById(R.id.etPassword);
        etConfirmPassword = findViewById(R.id.etConfirmPassword);
        etMoNumber = findViewById(R.id.etmobileNo);
        etEmail = findViewById(R.id.emailadd);
        radioGroup = findViewById(R.id.radioGrp);
        rButton = findViewById(R.id.radioF);

        Button register = findViewById(R.id.btnRegister);
        Button login = findViewById(R.id.btnLogin);

        DOB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar calendar = Calendar.getInstance();
                final int year = calendar.get(Calendar.YEAR);
                final int month = calendar.get(Calendar.MONTH);
                final int day = calendar.get(Calendar.DAY_OF_MONTH);

                datePickerDialog = new DatePickerDialog(CustomerRegistrationActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                        DOB.setText(year+"-"+(month+1)+"-"+day);
                    }
                },year,month,day);
                datePickerDialog.show();

            }
        });
    }
}
