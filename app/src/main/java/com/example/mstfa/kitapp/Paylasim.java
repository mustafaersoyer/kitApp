package com.example.mstfa.kitapp;

import android.util.Log;
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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Paylasim {
    private String aciklama;
    private String baslik;
    private String kitap;

    public String getAciklama() {
        return aciklama;
    }

    public void setAciklama(String aciklama) {
        this.aciklama = aciklama;
    }

    public String getBaslik() {
        return baslik;
    }

    public void setBaslik(String baslik) {
        this.baslik = baslik;
    }

    public String getKitap() {
        return kitap;
    }

    public void setKitap(String kitap) {
        this.kitap = kitap;
    }


    final public ArrayList<Paylasim> getData(){

        final ArrayList<Paylasim> dataList=new ArrayList<>();
        for (int i = 0; i < 25; i++) {
            String baslik = "Mükemmel Kitap!";
            String aciklama = "Mükemmel bir kitaptı!";
            String kitap = "Kitap1";
            Paylasim gecici=new Paylasim();
            gecici.setBaslik(""+baslik);
            gecici.setAciklama("Açıklama: "+aciklama);
            gecici.setKitap("Kitap: "+kitap);
            dataList.add(gecici);
        }

        String url="http://192.168.1.102:80/kitapp/paylasim.php?";
        /*StringRequest jsonForGetRequest = new StringRequest(
                Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    final public void onResponse(String response) {
                        try {
                            JSONObject obj = new JSONObject(response);
                            JSONObject jsonBody;
                            int uzunluk = obj.length();
                            int i = 0;
                            while (i < uzunluk - 2) {
                                i++;
                                jsonBody = obj.getJSONObject("bilgi" + i);
                                String baslik = jsonBody.getString("pBaslik");
                                String aciklama = jsonBody.getString("pAciklama");
                                String kitap = jsonBody.getString("kitapAdi");
                                Paylasim gecici=new Paylasim();
                                gecici.setKitap("Arıza Açıklama: "+baslik);
                                gecici.setBaslik("Arıza Kodu: "+aciklama);
                                gecici.setAciklama("İnverter Adı: "+kitap);
                                dataList.add(gecici);
                                Log.d("denemededede","i:"+i);

                            }

                        } catch (JSONException e){
                            e.printStackTrace();

                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            final public void onErrorResponse(VolleyError error) {
                NetworkResponse response = error.networkResponse;
                if (response != null && response.data != null) {
                    JSONObject jsonObject = null;
                    String errorMessage = null;

                    switch (response.statusCode) {
                        case 400:
                            errorMessage = new String(response.data);
                            try {
                                jsonObject = new JSONObject(errorMessage);
                                String serverResponseMessage = (String) jsonObject.get("hataMesaj");

                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                    }
                }
            }
        }) {
            @Override
            final  public Map<String, String> getHeaders() throws AuthFailureError {

                Map<String, String> param = new HashMap<String, String>();

                return param;
            }

        };

        jsonForGetRequest.setRetryPolicy(new DefaultRetryPolicy(10000, DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));

        AppController.getInstance().addToRequestQueue(jsonForGetRequest);*/
        return dataList;

    }
    /*final  public void veriGetir(final CallBack onCallBack) {

        StringRequest jsonForGetRequest = new StringRequest(
                Request.Method.GET, "http://192.168.1.102:80/kitapp/paylasim.php?",
                new Response.Listener<String>() {
                    @Override
                    final public void onResponse(String response) {
                        // progress.dismiss();
                        try {
                            JSONObject obj = new JSONObject(response);
                            JSONObject jsonBody;
                            int uzunluk = obj.length();
                            int i = 0;
                            while (i < uzunluk - 2) {
                                i++;
                                jsonBody = obj.getJSONObject("bilgi" + i);
                                String baslik = jsonBody.getString("pBaslik");
                                String aciklama = jsonBody.getString("pAciklama");
                                String kitap = jsonBody.getString("kitapAdi");
                                Paylasim gecici=new Paylasim();
                                gecici.setAciklama("Açıklama: "+aciklama);
                                gecici.setBaslik("Arıza Kodu: "+baslik);
                                gecici.setKitap("İnverter Adı: "+kitap);
                                dataList.add(gecici);
                                Log.d("denemededede","i:"+i);

                            }
                            onCallBack.onSuccess(dataList);

                        } catch (JSONException e) {
                            e.printStackTrace();
                            Toast.makeText(this
                                    , "" + e, Toast.LENGTH_LONG).show();

                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            final public void onErrorResponse(VolleyError error) {
                //progress.dismiss();
                NetworkResponse response = error.networkResponse;
                if (response != null && response.data != null) {
                    JSONObject jsonObject = null;
                    String errorMessage = null;
                    switch (response.statusCode) {
                        case 400:
                            errorMessage = new String(response.data);
                            try {
                                jsonObject = new JSONObject(errorMessage);
                                String serverResponseMessage = (String) jsonObject.get("hataMesaj");
                                Toast.makeText(this, "" + serverResponseMessage, Toast.LENGTH_LONG).show();

                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                    }
                }
            }
        }) {
            @Override
            final public Map<String, String> getHeaders() throws AuthFailureError {

                Map<String, String> param = new HashMap<String, String>();

                return param;
            }

        };

        jsonForGetRequest.setRetryPolicy(new DefaultRetryPolicy(10000, DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));

        AppController.getInstance().addToRequestQueue(jsonForGetRequest);
    }*/

     /*public  void getData(){
        final ArrayList<Paylasim> List =new ArrayList<>();
       veriGetir(new CallBack() {
           @Override
           public void onSuccess(ArrayList<Paylasim> liste) {
                List = liste;

           }

           @Override
           public void onFail(String msg) {

           }

       });*/

    }

