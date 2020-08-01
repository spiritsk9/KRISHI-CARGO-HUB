package com.example.sample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.sample.Common.Common;

public class ViewBillActivity extends AppCompatActivity {

    private TextView tvName;
    private TextView tvSource;
    private TextView tvTotalAmt;
    private TextView tvDestination;
    private TextView tvDistnace;
    private TextView tvQty;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_bill);
        init();
    }

    private void init() {
        initView();
        initData();
    }

    private void initData() {
        tvName.setText(Common.currentUser.getName());
        tvSource.setText(Common.currentUser.getSource());
        tvDestination .setText(Common.currentUser.getDestination());
        tvDistnace .setText(Common.currentUser.getDistance());
        tvQty.setText(Common.currentUser.getQuantity());
        tvTotalAmt.setText(Common.currentUser.getTotalPrice());
    }

    private void initView() {
        tvName = (TextView) findViewById(R.id.tv_name);
        tvSource = (TextView) findViewById(R.id.tv_source);
        tvDestination = (TextView) findViewById(R.id.tv_desti);
        tvDistnace = (TextView) findViewById(R.id.tv_dist);
        tvQty = (TextView) findViewById(R.id.tv_qty);
        tvTotalAmt = (TextView) findViewById(R.id.tv_total);
    }
}
