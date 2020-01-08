package com.example.as_pointer;

import android.content.Intent;
import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        TextView tv_register = (TextView) findViewById(R.id.Register_Link);
        tv_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(LoginActivity.this,Register.class);
                startActivity(i);
            }
        });
        Button b = (Button) findViewById(R.id.Login_submit);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              //  Login(v);
                Intent i = new Intent(LoginActivity.this,MainActivity.class);
                startActivity(i);
            }
        });

    }

    // Check Validations
    public boolean validateEmail(String email){
        String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
        return email.matches(regex);
    }
    public boolean validatePassword(String password){
        if(password.length() < 8 || password.equals("")){
            return false;
        }else{
            return true;
        }
    }
/*
    // Login Function
    public void login(final EditText email,final EditText password){
        final AlertDialog.Builder alert = new AlertDialog.Builder(LoginActivity.this);
        StringRequest request = new StringRequest(Request.Method.POST, "http://AS-Pointer.000webhostapp.com/login.php", new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try{
                    JSONObject jsonObject = new JSONObject(response);
                    Button b = (Button) findViewById(R.id.Login_submit);
                    b.setVisibility(View.VISIBLE);
                    if(jsonObject.getString("success").equals("false")){

                        alert.setMessage("Incorrect Email or Password!").setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                            }
                        });
                        alert.setCancelable(true);
                        AlertDialog al = alert.create();
                        al.show();
                    }else{
                        Intent i = new Intent(LoginActivity.this, MapActivity.class);
                        startActivity(i);
                    }
                }catch(JSONException e){
                    Toast.makeText(LoginActivity.this, e.toString(), Toast.LENGTH_SHORT).show();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Button b = (Button) findViewById(R.id.Login_submit);
                b.setVisibility(View.VISIBLE);
                password.setText("");
                alert.setMessage(error.toString()).setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
                alert.setCancelable(true);
                AlertDialog al = alert.create();
                alert.show();
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> params = new HashMap<>();
                params.put("email",email.getText().toString());
                params.put("password",password.getText().toString());
                return params;
            }
        };
        Volley.newRequestQueue(this).add(request);
    }

    public void Login(View view){
        final AlertDialog.Builder alert = new AlertDialog.Builder(LoginActivity.this);
        EditText email,password;
        email = (EditText) findViewById(R.id.LoginEmail);
        password = (EditText) findViewById(R.id.LoginPassword);

        // Validatonsast.makeText(this, "false", Toast.LENGTH_SHORT).show();
        if(validateEmail(email.getText().toString())){
            if(validatePassword(password.getText().toString())){
                login(email,password);
            }else{
                alert.setMessage("Please Enter valid Password!").setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
                alert.setCancelable(true);
                AlertDialog al = alert.create();
                alert.show();
            }
        }else{
            alert.setMessage("Please Enter valid email address!").setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.cancel();
                }
            });
            alert.setCancelable(true);
            AlertDialog al = alert.create();
            alert.show();
        }
    }*/


}
