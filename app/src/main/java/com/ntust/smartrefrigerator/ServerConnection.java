package com.ntust.smartrefrigerator;

import android.app.Activity;
import android.content.Context;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.w3c.dom.Text;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by petingo on 2017/5/7.
 */

public class ServerConnection {
    public static void postNewComment(final Context context, final String content, final String urlDif){
        final String url = "http://karta0910489.pythonanywhere.com/" + urlDif;
        RequestQueue queue = Volley.newRequestQueue(context);
        StringRequest sr = new StringRequest(Request.Method.POST,url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if(urlDif.equals("search")){
                    TextView tvCheckFood = (TextView) ((Activity)context).findViewById(R.id.tvCheckFood);
                    String[] result = response.split("<a>");
                    tvCheckFood.setText(result[1].replace("</br>","\n").replace(" ",""));
                }
                //Toast.makeText(context, response, Toast.LENGTH_SHORT).show();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
            }
        }){
            @Override
            protected Map<String,String> getParams(){
                Map<String,String> params = new HashMap<String, String>();
                params.put("detail",content);
                return params;
            }

            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String,String> params = new HashMap<String, String>();
                params.put("Upgrade-Insecure-Requests", "1");
                return params;
            }
        };
        queue.add(sr);
    }
}
