package com.example.as_pointer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Register extends AppCompatActivity {

    TextView tv_link;
    EditText Fullname, Email, Mobileno, Address, Password, Cpassword;
    Button register;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);


                Fullname = (EditText) findViewById(R.id.Name);
                Email = (EditText) findViewById(R.id.email);
                Mobileno = (EditText) findViewById(R.id.mobile);
                Address = (EditText) findViewById(R.id.address);
                Password = (EditText) findViewById(R.id.password);
                Cpassword = (EditText) findViewById(R.id.cpassword);

                register = (Button) findViewById(R.id.register);
                tv_link = (TextView) findViewById(R.id.link_login);


                register.setOnClickListener( new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        validateRegistration( Fullname,Email,Mobileno,Address,Password,Cpassword );
                    }
                } );
                TextView tv_link = (TextView) findViewById(R.id.link_login);
                tv_link.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {
                 Intent i = new Intent(Register.this, LoginActivity.class);
                    startActivity(i);
               }
            });
    }

/*
    Validation
*/
    private boolean validateRegistration(EditText name, EditText Email, EditText mobile, EditText address, EditText password, EditText cpassword) {


        String fname = name.getText().toString();
        String email = Email.getText().toString();
        String mobileno = mobile.getText().toString();
        String Add = address.getText().toString();
        String Npassword = password.getText().toString();
        String Ncpassword = cpassword.getText().toString();
        String emailPattern = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
        if(fname.length()==0) {
            Toast.makeText( Register.this, "Please enter Name!!", Toast.LENGTH_SHORT ).show();
            return false;
        }else if(fname.length()<3){
            Toast.makeText(Register.this, "Please enter valid Name!!", Toast.LENGTH_SHORT).show();
            return false;
        }else if(!fname.matches("[A-Z][a-zA-Z]*")){
            Toast.makeText(Register.this, "Name should contain only Characters!!", Toast.LENGTH_SHORT).show();
            return false;
        }else if(email.length()==0){
            Toast.makeText(Register.this, "Please enter Email!!", Toast.LENGTH_SHORT).show();
            return false;
        }else if(!email.matches(emailPattern)){
            Toast.makeText(Register.this, "Please Enter valid Email ID!!", Toast.LENGTH_SHORT).show();
            return false;
        }else if(mobileno.length()!=10){
            Toast.makeText(Register.this, "Please Enter Valid Mobile Number!!", Toast.LENGTH_SHORT).show();
            return false;
        }else if(Add.length()>200){
            Toast.makeText(Register.this, "Address can have maximum 200 characters!", Toast.LENGTH_SHORT).show();
            return false;
        }else if(Add.length()==0){
            Toast.makeText(Register.this, "Please Enter Address!!", Toast.LENGTH_SHORT).show();
            return false;
        }else if(Npassword.length()<8){
            Toast.makeText(Register.this, "Password must contain atleast 8 characters!!", Toast.LENGTH_SHORT).show();
            return false;
        }else if(Npassword!=Ncpassword){
            Toast.makeText(Register.this, "Password does not Match!!", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

}