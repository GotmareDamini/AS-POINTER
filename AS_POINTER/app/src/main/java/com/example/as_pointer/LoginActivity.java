package com.example.as_pointer;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
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

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class LoginActivity extends AppCompatActivity {
    private EditText email, password;
    private TextView link_register;
    private ProgressBar loading;
    private Button login;
    private static String URL_LOGIN = "https://as-pointer.000webhostapp.com/login.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_login );
        loading = (ProgressBar) findViewById( R.id.loading1 );
        email = (EditText) findViewById( R.id.LoginEmail );
        password = (EditText) findViewById( R.id.LoginPassword );
        link_register = (TextView) findViewById( R.id.Register_Link );
        login = (Button) findViewById( R.id.Login_submit );

        link_register.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity( new Intent( LoginActivity.this, Register.class ));
            }
        } );

        login.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LoginValidate(v);
                //String mEmail = email.getText().toString().trim();
                //String mPassword = password.getText().toString().trim();

              //  if (!mEmail.isEmpty() || !mPassword.isEmpty()) {
                //    Login(mEmail, mPassword);
                //} else {
                  //  email.setError( "Please Enter Email!" );
                  //  password.setError( "Please Enter Password!" );
                //}
            }
        } );
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
    public void LoginValidate(View view){
        final AlertDialog.Builder alert = new AlertDialog.Builder(LoginActivity.this);
//        email = (EditText) findViewById(R.id.LoginEmail);
//        password = (EditText) findViewById(R.id.LoginPassword);

        String mEmail = email.getText().toString().trim();
         String mPassword = password.getText().toString().trim();

        if(validateEmail(mEmail)){
            if(validatePassword(mPassword)){
                Login(mEmail,mPassword);
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
    }
//    backend
    private void Login(final String email, final String password){
        loading.setVisibility( View.VISIBLE );
        login.setVisibility( View.GONE );
       // final String json = "";
        final AlertDialog.Builder alert = new AlertDialog.Builder(LoginActivity.this);
        StringRequest stringRequest = new StringRequest( Request.Method.POST, URL_LOGIN,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        /*if(response == null && response.trim().isEmpty()){
                            Toast.makeText( LoginActivity.this, "response is empty", Toast.LENGTH_SHORT ).show();
                        }*/
                        try {
                            JSONObject jsonObject = new JSONObject( String.valueOf( response ) );
                            if (jsonObject.getString( "success" ).equals( "false" )) {

                                alert.setMessage( "Incorrect Email or Password!" ).setNegativeButton( "Cancel", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        dialog.cancel();
                                    }
                                } );
                                alert.setCancelable( true );
                                AlertDialog al = alert.create();
                                al.show();
                            } else {
                                Intent i = new Intent( LoginActivity.this, MainActivity.class );
                                startActivity( i );
                            }
                        } catch (JSONException e) {
                            Toast.makeText( LoginActivity.this, e.toString(), Toast.LENGTH_SHORT ).show();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        loading.setVisibility( View.GONE );
                        login.setVisibility( View.VISIBLE );
                        alert.setMessage(error.toString()).setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                            }
                        });
                        alert.setCancelable(true);
                        AlertDialog al = alert.create();
                        alert.show();
                        Toast.makeText( LoginActivity.this, "Login Error!" + error.toString(), Toast.LENGTH_SHORT ).show();
                    }
                } )
        {

            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put( "email", email );
                params.put( "password", password );
                return params;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue( this );
        requestQueue.add( stringRequest );
    }

}


