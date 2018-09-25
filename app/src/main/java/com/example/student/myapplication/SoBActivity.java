package com.example.student.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SoBActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView lblSoA;
    private EditText txtSoB;
    private Button btnTinh;
    private Double x;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_so_b);

        lblSoA = (TextView) findViewById(R.id.lbl_B_SoA);
        txtSoB = (EditText)findViewById(R.id.txt_B_SoB);
        btnTinh = (Button)findViewById(R.id.btn_B_Tinh);

        Intent intent = getIntent();
        Bundle bundle = intent.getBundleExtra("data");
        x = bundle.getDouble("soa");

        lblSoA.setText(x + "");

        btnTinh.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_B_Tinh:
                if(txtSoB.getText().toString().trim().equals("")){
                    Toast.makeText(this, "Phai nhap so B", Toast.LENGTH_SHORT).show();
                    return;
                }else {
                    Intent intent = new Intent();
                    Bundle bundle = new Bundle();
                    bundle.putDouble("ketqua", x + Double.parseDouble(txtSoB.getText().toString()));
                    intent.putExtra("databack", bundle);
                    setResult(RESULT_OK, intent);
                    finish();
                }
                break;
        }
    }
}
