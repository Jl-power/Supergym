package com.example.supergym;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;

import java.security.SecureRandom;

public class Help extends AppCompatActivity {

    Button buttonr;
    TextView buttonb;
    EditText textemail;
    RequestQueue requestQueue;
    JSONArray jsonArray;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);
        textemail = findViewById(R.id.editTextemail);
        buttonr = findViewById(R.id.buttonrecuperar);
        buttonb = findViewById(R.id.buttoncancelarhelp);

        if(ActivityCompat.checkSelfPermission(Help.this, Manifest.permission.SEND_SMS) != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(Help.this, new String[]{Manifest.permission.SEND_SMS},1);
        }

        buttonb.setOnClickListener(view -> {
            Intent i = new Intent(Help.this,MainActivity.class);
            startActivity(i);
        });

        buttonr.setOnClickListener(view ->{
            verificaremail();
        });
    }

    private void verificaremail() {
        requestQueue = Volley.newRequestQueue(this);
        String url = "https://lsptrainer.000webhostapp.com/verificaremail.php?email="+textemail.getText().toString();
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    jsonArray = new JSONArray(response);
                    String telefono=jsonArray.getString(0);
                    String token = enviartoken(telefono);
                    Toast.makeText(getApplicationContext(),"Token enviado! revisa tus sms",Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(Help.this,Token.class);
                    i.putExtra("token",token);
                    i.putExtra("email", textemail.getText().toString());
                    startActivity(i);

                } catch (JSONException e) {
                    e.printStackTrace();
                    Toast.makeText(getApplicationContext(), "El usuario no existe", Toast.LENGTH_SHORT).show();
                }
            }
        }, new Response.ErrorListener(){
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        requestQueue.add(stringRequest);
    }

    private String enviartoken(String telefono) {
        String token = generateRandomString(4);
        SmsManager smsManager = SmsManager.getDefault();
        smsManager.sendTextMessage(telefono,null,"Supergym Token de Seguridad:" + token, null,null);
        return token;
    }

    public static String generateRandomString(int length) {
        String CHAR_LOWER = "abcdefghijklmnopqrstuvwxyz";
        String CHAR_UPPER = CHAR_LOWER.toUpperCase();
        String NUMBER = "0123456789";

        String DATA_FOR_RANDOM_STRING = CHAR_LOWER + CHAR_UPPER + NUMBER;
        SecureRandom random = new SecureRandom();

        if (length < 1) throw new IllegalArgumentException();

        StringBuilder sb = new StringBuilder(length);

        for (int i = 0; i < length; i++) {
            // 0-62 (exclusivo), retorno aleatorio 0-61
            int rndCharAt = random.nextInt(DATA_FOR_RANDOM_STRING.length());
            char rndChar = DATA_FOR_RANDOM_STRING.charAt(rndCharAt);
            sb.append(rndChar);
        }

        return sb.toString();
    }

}
