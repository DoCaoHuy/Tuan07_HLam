package com.example.student.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SoAActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText txtSoA;
    private TextView lblKQ;
    private Button btnOpen;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_so_a);

        txtSoA = (EditText)findViewById(R.id.txt_A_SoA);
        lblKQ = (TextView)findViewById(R.id.lbl_A_KetQua);
        btnOpen = (Button) findViewById(R.id.btn_A_OpenActivity);

        btnOpen.setOnClickListener(this);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 1){
            if(resultCode == RESULT_OK){
                Bundle bundle = data.getBundleExtra("databack");
                Double kq = bundle.getDouble("ketqua");
                lblKQ.setText(kq + "");
            }
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_A_OpenActivity:
                if(txtSoA.getText().toString().trim().equals("")){
                    Toast.makeText(this, "Phai nhap so A", Toast.LENGTH_SHORT).show();
                    return;
                }
                Intent intent = new Intent(this, SoBActivity.class);
                Bundle bundle = new Bundle();
                bundle.putDouble("soa", Double.parseDouble(txtSoA.getText().toString()));
                intent.putExtra("data", bundle);
                startActivityForResult(intent, 1);
                break;
        }
    }


}
