package com.example.mstfa.kitapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

import java.util.HashMap;
import java.util.Map;

public class Paylasimlar extends AppCompatActivity {
    TextView txtPaylasimBaslik,txtPaylasimKitapAdi,txtPaylasimAciklama;
    Button btnYazarlar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paylasimlar);

        txtPaylasimAciklama = (TextView) findViewById(R.id.txtPaylasimAciklama);
        txtPaylasimBaslik = (TextView) findViewById(R.id.txtPaylasimBaslik);
        txtPaylasimKitapAdi = (TextView) findViewById(R.id.txtPaylasimKitapAdi);
        btnYazarlar = (Button) findViewById(R.id.btnYazarlar);

        btnYazarlar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Paylasimlar.this,Yazarlar.class);
                startActivity(i);
            }
        });

        StringRequest jsonForGetRequest = new StringRequest(
                Request.Method.GET,"http://192.168.1.102:80/kitapp/paylasim.php?",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject obj = new JSONObject(response);
                            JSONObject jsonBody = obj.getJSONObject("bilgi1");
                            txtPaylasimAciklama.setText(jsonBody.getString("pAciklama"));
                            txtPaylasimKitapAdi.setText(jsonBody.getString("kitapAdi"));
                            txtPaylasimBaslik.setText(jsonBody.getString("pBaslik"));
                            Toast.makeText(Paylasimlar.this, "onResponse", Toast.LENGTH_SHORT).show();
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {

                NetworkResponse response = error.networkResponse;
                if(response != null && response.data != null){
                    JSONObject jsonObject = null;
                    String errorMessage = null;

                    switch(response.statusCode){
                        case 400:
                            errorMessage = new String(response.data);

                            try {

                                jsonObject = new JSONObject(errorMessage);
                                String serverResponseMessage =  (String)jsonObject.get("hataMesaj");
                                Toast.makeText(getApplicationContext(),""+serverResponseMessage,Toast.LENGTH_LONG).show();


                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                    }
                }
            }


        }) {

            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {

                Map<String, String> param = new HashMap<String, String>();

                return param;
            }


        };


        jsonForGetRequest.setRetryPolicy(new DefaultRetryPolicy(10000,DefaultRetryPolicy.DEFAULT_MAX_RETRIES,DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));

        AppController.getInstance().addToRequestQueue(jsonForGetRequest);
    }
}
