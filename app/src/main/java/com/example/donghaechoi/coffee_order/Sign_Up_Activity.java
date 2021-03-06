package com.example.donghaechoi.coffee_order;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by donghaechoi on 2016. 2. 9..
 */
public class Sign_Up_Activity extends AppCompatActivity implements View.OnClickListener {

    private TextView mIdTextView;
    private Button mChangeInfoButton;
    private TextView mOrderToReady;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup_activity);

        Intent intent = getIntent();

        mIdTextView = (TextView) findViewById(R.id.on_id);
        mIdTextView.setText(mIdTextView.getText().toString() + intent.getStringExtra("id"));
        mChangeInfoButton = (Button) findViewById(R.id.order_button);
        mChangeInfoButton.setOnClickListener(this);
        mOrderToReady = (TextView) findViewById(R.id.order_to_ready);

    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(this, OrderActivity.class);
        startActivityForResult(intent, 1000);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1000) {
            if (resultCode == RESULT_OK) {
                if (data != null) {
                    mOrderToReady.setText(data.getStringExtra("check") + " " + data.getStringExtra("order") + "잔");
                    Toast.makeText(Sign_Up_Activity.this, "주문이 완료되었습니다.", Toast.LENGTH_SHORT).show();
                }
            }
        }
    }
}
