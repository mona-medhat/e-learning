package com.example.android.registeration_gp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.ValidationStyle;

public class MainActivity extends AppCompatActivity {

    EditText name , email , password;
    Button signup;
    Spinner type;
    String user_type;
    AwesomeValidation awesomeValidation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        awesomeValidation = new AwesomeValidation(ValidationStyle.BASIC);
        //UpdateUI();
        name = (EditText) findViewById(R.id.name);
        email = (EditText) findViewById(R.id.email);
        password = (EditText) findViewById(R.id.password);
        type = (Spinner) findViewById(R.id.type);
        signup = (Button) findViewById(R.id.signup);

        ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1,
                getResources().getStringArray(R.array.type));
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        type.setAdapter(spinnerAdapter);

        type.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                user_type = adapterView.getItemAtPosition(i).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Register();
            }
        });
    }

    private void Register(){
        String regexPassword = "(?=.*[a-z])(?=.*[A-Z])(?=.*[\\d])(?=.*[~`!@#\\$%\\^&\\*\\(\\)\\-_\\+=\\{\\}\\[\\]\\|\\;:\"<>,./\\?]).{8,}";
        awesomeValidation.addValidation(MainActivity.this, R.id.name, "[a-zA-Z\\s]+" , R.string.nameerr);
        awesomeValidation.addValidation(MainActivity.this, R.id.email, android.util.Patterns.EMAIL_ADDRESS, R.string.emailerr);
        awesomeValidation.addValidation(MainActivity.this, R.id.password, regexPassword, R.string.passworderr);
        if(awesomeValidation.validate()){
            Toast.makeText(MainActivity.this, "Data received successfully", Toast.LENGTH_SHORT).show();
            String user_name = name.getText().toString().trim();
            String user_email = email.getText().toString().trim();
            String user_password = password.getText().toString().trim();
            //save user_name,user_email,user_password,user_type to database
        }
        else{
            Toast.makeText(MainActivity.this, "ERROR", Toast.LENGTH_SHORT).show();
        }

    }
}
