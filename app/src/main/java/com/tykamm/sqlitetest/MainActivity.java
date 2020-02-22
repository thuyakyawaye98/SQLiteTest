package com.tykamm.sqlitetest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void buSave(View view) {
        EditText edtname=findViewById(R.id.username);
        EditText edtpasword=findViewById(R.id.password);
        String name=edtname.getText().toString().trim();
        String password=edtpasword.getText().toString().trim();
        MyDatabase db=new MyDatabase(getApplicationContext());
        db.saveStudentData(name,password);
    }
    public void buLoad(View view) {
        MyDatabase db=new MyDatabase(getApplicationContext());
        TextView result=findViewById(R.id.txtresult);
        result.setText(db.loadStudentData());
    }

    public void buUpdate(View view) {

        MyDatabase db=new MyDatabase(getApplicationContext());
        EditText edtname=findViewById(R.id.username);
        EditText edtpasword=findViewById(R.id.password);
        String name=edtname.getText().toString().trim();
        String password=edtpasword.getText().toString().trim();

        if(db.updateStudent(name,password)>0){
            TextView result=findViewById(R.id.txtresult);
            result.setText(db.loadStudentData());
        }
    }

    public void buDelete(View view) {
        MyDatabase db=new MyDatabase(getApplicationContext());
        if(db.deleteStudent()>0){
            TextView result=findViewById(R.id.txtresult);
            result.setText(db.loadStudentData());
        }
    }
}
