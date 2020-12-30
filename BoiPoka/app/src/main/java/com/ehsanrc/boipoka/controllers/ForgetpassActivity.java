package com.ehsanrc.boipoka.controllers;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Paint;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.ehsanrc.boipoka.R;
import com.ehsanrc.boipoka.app.AppConfig;
import com.ehsanrc.boipoka.app.AppController;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;


public class ForgetpassActivity extends AppCompatActivity {

    private static final String TAG = ForgetpassActivity.class.getSimpleName();

    private EditText inputEmail;
    private ProgressDialog pDialog;
    ConnectionD	cd;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgetpass);

        inputEmail = (EditText) findViewById(R.id.e1);

        cd = new ConnectionD(this);
        // Progress dialog
        pDialog = new ProgressDialog(this);
        pDialog.setCancelable(false);


        findViewById(R.id.but1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String email = inputEmail.getText().toString().trim();

                // Check for empty data in the form
                if (email.trim().length() > 0) {
                    // login user

                    checkLogin(email);

                } else {
                    AlertDialog.Builder builder =
                            new AlertDialog.Builder(ForgetpassActivity.this, R.style.AppCompatAlertDialogStyle);

                    builder.setTitle("বার্তা");
                    builder.setMessage("আপনার তথ্য গুলো ঠিক ভাবে দিন ।");
                    builder.setCancelable(true);
                    builder.setNegativeButton("ঠিক আছে ", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    });
                    builder.show();

                }
            }
        });


    }

    /**
     * function to verify login details in mysql db
     * */
    private void checkLogin(final String email) {
        // Tag used to cancel the request
        String tag_string_req = "req_forget";

        pDialog.setMessage("রিসেট হচ্ছে...");
        showDialog();

        StringRequest strReq = new StringRequest(Request.Method.POST,
                AppConfig.URL_forget, new Response.Listener<String>() {

            @Override
            public void onResponse(String response) {
                Log.d(TAG, "forget Response: " + response.toString());

                hideDialog();
                try {
                        JSONObject object2 = new JSONObject(response);
                        String login_msg = object2.getString("forgot_password_msg");
                        AlertDialog.Builder builder =
                                new AlertDialog.Builder(ForgetpassActivity.this, R.style.AppCompatAlertDialogStyle);

                        builder.setTitle("বার্তা");
                        builder.setMessage(login_msg);
                        builder.setCancelable(true);
                        builder.setNegativeButton("ঠিক আছে ", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                Intent intent = new Intent(ForgetpassActivity.this,LoginActivity.class);
                                startActivity(intent);
                                finish();
                            }
                        });
                        builder.show();

                } catch (JSONException e) {
                    // JSON error
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e(TAG, "Forget Error: " + error.getMessage());
                hideDialog();
                AlertDialog.Builder builder =
                        new AlertDialog.Builder(ForgetpassActivity.this, R.style.AppCompatAlertDialogStyle);

                builder.setTitle("বার্তা");
                builder.setMessage("আবার চেষ্টা করুন ।");
                builder.setCancelable(true);
                builder.setNegativeButton("ঠিক আছে ", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                builder.show();
            }
        }) {

            @Override
            protected Map<String, String> getParams() {
                // Posting parameters to login url
                Map<String, String> params = new HashMap<String, String>();
                params.put("client", "android_app");
                params.put("verify_email", email);

                return params;
            }

        };
        // Adding request to request queue
        AppController.getInstance().addToRequestQueue(strReq, tag_string_req);
    }



    private void showDialog() {
        if (!pDialog.isShowing())
            pDialog.show();
    }

    private void hideDialog() {
        if (pDialog.isShowing())
            pDialog.dismiss();
    }


}







