package com.example.donghaechoi.coffee_order;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

/**
 * Created by donghaechoi on 2016. 2. 9..
 */
public class OrderActivity extends AppCompatActivity implements View.OnClickListener, CompoundButton.OnCheckedChangeListener {

    private Button mPlusButton;
    private Button mMinusButton;
    private TextView mOrder;
    private CheckBox mCheckBox;
    static int order = 0;
    private TextView mCheckText;
    private TextView mCheckTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.order_activity);

        mOrder = (TextView) findViewById(R.id.order);

        mPlusButton = (Button) findViewById(R.id.plus_button);
        mMinusButton = (Button) findViewById(R.id.minus_button);
        mPlusButton.setOnClickListener(this);
        mMinusButton.setOnClickListener(this);
        mCheckBox = (CheckBox) findViewById(R.id.checkbox_selc);
        mCheckBox.setOnCheckedChangeListener(this);
        mCheckText = (TextView) findViewById(R.id.checkbox_true);
        mCheckTextView = (TextView) findViewById(R.id.checkbox_text_view);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == mPlusButton.getId()) {
            order++;
            mOrder.setText(Integer.toString(order));
        } else if (v.getId() == mMinusButton.getId()) {
            if (order > 0) {
                order--;
                mOrder.setText(Integer.toString(order));
            }
        }
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if (mCheckBox.isClickable()) {
            mCheckText.setVisibility(View.VISIBLE);
            mCheckTextView.setVisibility(View.VISIBLE);
        } else {
            mCheckText.setVisibility(View.INVISIBLE);
            mCheckTextView.setVisibility(View.INVISIBLE);
        }
    }
}
