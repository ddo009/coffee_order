package com.example.donghaechoi.coffee_order;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.HashMap;

public class login_activity extends AppCompatActivity implements View.OnClickListener {

    private Button mSignUpButton;
    private Button mNewAccountButton;
    private EditText mEditId;
    private EditText mEditPassword;
    private HashMap<String, String> accountMap = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_activity);

        mSignUpButton = (Button) findViewById(R.id.signup_button);
        mNewAccountButton = (Button) findViewById(R.id.newaccount_button);
        mSignUpButton.setOnClickListener(this);
        mNewAccountButton.setOnClickListener(this);


        mEditId = (EditText) findViewById(R.id.edit_id);
        mEditPassword = (EditText) findViewById(R.id.edit_password);

    }

    @Override
    public void onClick(View v) {

        if (v.getId() == mSignUpButton.getId()) {
            if (accountMap.containsKey(mEditId.getText().toString())) {
                if (accountMap.get(mEditId.getText().toString()).equals(mEditPassword.getText().toString())) {
                    Intent intent = new Intent(this, Sign_Up_Activity.class);
                    intent.putExtra("id", mEditId.getText().toString());
                    Toast.makeText(login_activity.this, "로그인에 성공했습니다.", Toast.LENGTH_SHORT).show();
                    startActivity(intent);
                } else {
                    Toast.makeText(login_activity.this, "아이디나 비밀번호가 틀렸습니다", Toast.LENGTH_SHORT).show();
                }
            } else {
                Toast.makeText(login_activity.this, "아이디나 비밀번호가 틀렸습니다", Toast.LENGTH_SHORT).show();
            }
        } else if (v.getId() == mNewAccountButton.getId()) {
            Intent intent = new Intent(this, NewAccountActivity.class);
            startActivityForResult(intent, 1);
        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);


        if (requestCode == 1) {
            if (resultCode == RESULT_OK) {
                if (data != null) {
                    if (!accountMap.containsKey(data.getStringExtra("newid"))) {
                        accountMap.put(data.getStringExtra("newid"), data.getStringExtra("newpassword"));
                        Toast.makeText(login_activity.this, "회원 가입이 완료되었습니다.", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(login_activity.this, "이미 사용중인 아이디입니다.", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        }

    }
}

