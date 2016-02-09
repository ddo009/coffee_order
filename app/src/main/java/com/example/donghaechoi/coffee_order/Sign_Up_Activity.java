package com.example.donghaechoi.coffee_order;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by donghaechoi on 2016. 2. 9..
 */
public class Sign_Up_Activity extends AppCompatActivity implements View.OnClickListener {

    private TextView mIdTextView;
    private TextView mPasswordTextView;
    private Button mChangeInfoButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup_activity);

        Intent intent = getIntent();

        mIdTextView = (TextView) findViewById(R.id.on_id);
        mIdTextView.setText(mIdTextView.getText().toString() + intent.getStringExtra("id"));
        mChangeInfoButton = (Button) findViewById(R.id.order_button);
        mChangeInfoButton.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(this, OrderActivity.class);
        startActivity(intent);
    }

}
