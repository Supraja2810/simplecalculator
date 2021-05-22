package com.example.simplecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Spinner spinner;
    private int op;
    private Button btn;
    private EditText num1,num2;
    private TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = (Button)findViewById(R.id.result);
        spinner = (Spinner)findViewById(R.id.spinner);
        num1=(EditText)findViewById(R.id.editview1);
        num2=(EditText)findViewById(R.id.editview2);
        tv = (TextView)findViewById(R.id.textView);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.operations, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                switch(position)
                {
                    case 0:
                        op=1;
                        break;
                    case 1:
                        op=2;
                        break;
                    case 2:
                        op=3;
                        break;
                    case 3:
                        op=4;
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int n1,n2,result=0;
                n1 = Integer.parseInt(num1.getText().toString());
                n2 = Integer.parseInt(num2.getText().toString());
                if(op==1)
                    result = n1 + n2;
                else if(op==2)
                    result = n1-n2;
                else if(op==3)
                    result = n1*n2;
                else if(op==4)
                    result = n1/n2;
                tv.setText(String.valueOf(result));

                            }
        });
       }
}