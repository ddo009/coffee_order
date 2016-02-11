package com.example.donghaechoi.coffee_order;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by donghaechoi on 2016. 2. 9..
 */
public class NewAccountActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText mEditNewId;
    private EditText mEditNewPassword;
    //    private EditText mEditNewName;
//    private CheckBox mCheckBoxMan;
//    private CheckBox mCheckBoxWoman;
    private Button mCompleteButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_account_activity);

        mEditNewId = (EditText) findViewById(R.id.edit_newid);
        mEditNewPassword = (EditText) findViewById(R.id.edit_newpassword);
//        mCheckBoxMan = (CheckBox) findViewById(R.id.check_man);
//        mCheckBoxWoman = (CheckBox) findViewById(R.id.check_woman);
        mCompleteButton = (Button) findViewById(R.id.complete_newaccount);
        mCompleteButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (mEditNewId.length() < 6) {
            Toast.makeText(NewAccountActivity.this, "아이디는 6글자 이상이어야 합니다", Toast.LENGTH_SHORT).show();
        } else if (mEditNewPassword.length() < 6) {
            Toast.makeText(NewAccountActivity.this, "비밀번호는 6글자 이상이어야 합니다.", Toast.LENGTH_SHORT).show();
        } else {
            Intent intent = new Intent();
            intent.putExtra("newid", mEditNewId.getText().toString());
            intent.putExtra("newpassword", mEditNewPassword.getText().toString());
//        intent.putExtra("newname", mEditNewName.getText().toString());
            setResult(RESULT_OK, intent);
            finish();
        }
    }
}
