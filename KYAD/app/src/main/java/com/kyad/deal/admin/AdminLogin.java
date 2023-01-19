package com.kyad.deal.admin;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.kyad.deal.Util.Util;
import com.kyad.deal.R;

import java.util.Calendar;

public class AdminLogin extends AppCompatActivity {

    EditText code, username, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_login);

        code = findViewById(R.id.code);
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);

        findViewById(R.id.submit).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Submit(username.getText(), password.getText(), code.getText());
            }
        });

    }


    private void Submit(Editable user, Editable pass, Editable cd) {
        if (user == null || user.equals("")) {
            Toast.makeText(this, this.getString(R.string.enter_username), Toast.LENGTH_SHORT).show();
        } else if (pass == null || pass.equals("")) {
            Toast.makeText(this, this.getString(R.string.password), Toast.LENGTH_SHORT).show();
        } else if (cd == null || cd.equals("")) {
            Toast.makeText(this, "Enter code", Toast.LENGTH_SHORT).show();
        } else {
            Calendar rightNow = Calendar.getInstance();
            int code = rightNow.get(Calendar.HOUR);

            if (Util.Admin.equals(user.toString()) && Util.Password.equals(pass.toString()) && code == Integer.parseInt(cd.toString())) {
                Intent mainIntent = new Intent(AdminLogin.this, AddproductActivity.class);
                startActivity(mainIntent);
                finish();
            } else {
                Toast.makeText(this, "One or more credentials are wrong...\nPlease try again", Toast.LENGTH_SHORT).show();
            }
        }
    }
}


