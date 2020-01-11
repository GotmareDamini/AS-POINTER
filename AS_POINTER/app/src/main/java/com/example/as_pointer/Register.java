package com.example.as_pointer;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class Register extends AppCompatActivity {

    private TextView tv_link;
    private EditText first_name,last_name, email, address, password,mobile, Cpassword;
    private Button register;
    private ProgressBar loading;
    private static String URL_REGIST = "https://as-pointer.000webhostapp.com/register.php";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

                loading = (ProgressBar) findViewById( R.id.loading );
                first_name = (EditText) findViewById(R.id.F_Name);
                email = (EditText) findViewById(R.id.r_email);
                last_name = (EditText) findViewById(R.id.L_name);
                address = (EditText) findViewById(R.id.r_address);
                password = (EditText) findViewById(R.id.r_password);
                Cpassword = (EditText) findViewById(R.id.r_cpassword);
                mobile = (EditText) findViewById(R.id.r_mobile);
                register = (Button) findViewById(R.id.register);
                tv_link = (TextView) findViewById(R.id.link_login);


                register.setOnClickListener( new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        //Register_user();
                       validateRegistration( first_name,last_name,email,address,mobile,password,Cpassword );
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
    private boolean validateRegistration(EditText f_name, EditText l_name, EditText Email, EditText address, EditText mobile, EditText password, EditText cpassword) {
        String fname = f_name.getText().toString();
        String email = Email.getText().toString();
        String L_name = l_name.getText().toString();
        String m_mobile = mobile.getText().toString();
        String Add = address.getText().toString();
        String Npassword = password.getText().toString();
        String Conf_pass = cpassword.getText().toString();
        String emailPattern = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
        if(fname.length()==0) {
            Toast.makeText( Register.this, "Please enter Name!!", Toast.LENGTH_SHORT ).show();
            return false;
        }else if(fname.length()<2){
            Toast.makeText(Register.this, "Please enter valid First Name!!", Toast.LENGTH_SHORT).show();
            return false;
        }else if(L_name.length()<3){
            Toast.makeText(Register.this, "Please enter valid Last Name!!", Toast.LENGTH_SHORT).show();
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
        }else if(Add.length()>200){
            Toast.makeText(Register.this, "Address can have maximum 200 characters!", Toast.LENGTH_SHORT).show();
            return false;
        }else if(Add.length()==0){
            Toast.makeText(Register.this, "Please Enter Address!!", Toast.LENGTH_SHORT).show();
            return false;
        }else if(m_mobile.length()<10){
            Toast.makeText(Register.this, "Please Enter valid Mobile Number!!", Toast.LENGTH_SHORT).show();
            return false;
        }else if(Npassword.length()<8){
            Toast.makeText(Register.this, "Password must contain atleast 8 characters!!", Toast.LENGTH_SHORT).show();
            return false;
        }else if(!Npassword.equals(Conf_pass)){
            Toast.makeText(Register.this, "Password does not Match!!", Toast.LENGTH_SHORT).show();
            return false;
        }else{
            Register_user();
        }
        return true;
    }

    private void Register_user(){
        loading.setVisibility( View.VISIBLE );
        register.setVisibility( View.GONE );
        final String first_name = this.first_name.getText().toString().trim();
        final String email = this.email.getText().toString().trim();
        final String last_name = this.last_name.getText().toString().trim();
        final String address = this.address.getText().toString().trim();
        final String password = this.password.getText().toString().trim();
        final String mobile = this.mobile.getText().toString().trim();
       // final Integer mobile = Integer.valueOf( mobileno );
        final AlertDialog.Builder alert = new AlertDialog.Builder(Register.this);
        StringRequest StringRequest = new StringRequest( Request.Method.POST, URL_REGIST,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
//                        if(response != null && !response.trim().isEmpty()){
//                            Toast.makeText( Register.this, "response is empty", Toast.LENGTH_SHORT ).show();
//                        }
//                        JSONObject jsonObject;
//                        try {
//                             jsonObject = new JSONObject( response );
//                            Toast.makeText( Register.this, response, Toast.LENGTH_SHORT ).show();
//                           String success = jsonObject.getString( "succcess" );
//                            if(success.equals( "true" )){
//                                Toast.makeText( Register.this,"Register Successfully!",Toast.LENGTH_SHORT ).show();
//                                startActivity(new Intent( Register.this, LoginActivity.class ));
//
//                            }else{
//                                Toast.makeText( Register.this, jsonObject.getString( "success" ), Toast.LENGTH_SHORT ).show();
//                            }
//                        } catch (JSONException e) {
//                            Toast.makeText( Register.this,"Register Error!" + e.toString(),Toast.LENGTH_SHORT ).show();
//                            loading.setVisibility( View.GONE );
//                            register.setVisibility( View.VISIBLE );
//                        }
//                    }
//
//                },

                        try {
                            JSONObject jsonObject = new JSONObject( String.valueOf( response ) );
                            register.setVisibility( View.VISIBLE );
                            if (jsonObject.getString( "success" ).equals( "false" )) {
                                alert.setMessage( "Email ID Already Exist!" ).setNegativeButton( "Cancel", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        dialog.cancel();
                                    }
                                } );
                                alert.setCancelable( true );
                                AlertDialog al = alert.create();
                                al.show();
                            } else {
                                Toast.makeText( Register.this,"Register Successfully!",Toast.LENGTH_SHORT ).show();
                                Intent i = new Intent( Register.this, LoginActivity.class );
                                startActivity( i );
                            }
                        } catch (JSONException e) {
                            Toast.makeText( Register.this, e.toString(), Toast.LENGTH_SHORT ).show();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText( Register.this,"Register Error!" + error.toString(),Toast.LENGTH_SHORT ).show();
                        loading.setVisibility( View.GONE );
                        register.setVisibility( View.VISIBLE );

                    }
                } )

        {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {

                Map<String, String> params = new HashMap<>();
                params.put( "first_name", first_name );
                params.put( "last_name", last_name );
                params.put( "email", email );
                params.put( "address", address );
                params.put( "mobile", mobile );
                params.put( "password", password );

                return params;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue( this );
        requestQueue.add( StringRequest );
    }

}