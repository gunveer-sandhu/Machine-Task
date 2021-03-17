package gunveer.codes.machinetask;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.view.menu.MenuView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.JsonObject;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static android.content.ContentValues.TAG;

public class Fetcher {
    public static final String url = "https://api.jsonbin.io/b/5da98dd0120fad237297b2fd";
    Context context;
    static ArrayList<DataFetched> dataFetcheds = new ArrayList<>();



    public Fetcher(Context context) {
        this.context = context;
    }

    public interface VolleyResponseListener{
        void onError(String message);

        void onResponse(ArrayList<DataFetched> dataFetcheds);
    }

    public void dataGet(VolleyResponseListener volleyResponseListener){




        RequestQueue requestQueue = Volley.newRequestQueue(context);
        requestQueue.add(new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {

                try {


                    for(int i = 0; i<response.length(); i++) {
                        DataFetched dataFetched = new DataFetched();
                        JSONObject something = response.getJSONObject(i);
                        dataFetched.setId(something.getInt("id"));
                        dataFetched.setFull_name(something.getString("full_name"));
                        dataFetched.setContact(something.getString("contact"));
                        dataFetched.setEmail_id(something.getString("email_id"));
                        dataFetched.setMembership_number(something.getString("membership_number"));
                        dataFetched.setAddress(something.getString("address"));
                        dataFetched.setList_year(something.getString("list_year"));
                        dataFetched.setData_type(something.getString("data_type"));
                        dataFetched.setDesignation(something.getString("designation"));
                        dataFetched.setProfile_pic_url(something.getString("profile_pic_url"));


                        dataFetcheds.add(dataFetched);
                    }
                    volleyResponseListener.onResponse(dataFetcheds);

                } catch (JSONException e) {
                    Log.e(TAG, "onResponse: " + e);
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(context, error.toString(), Toast.LENGTH_SHORT).show();
            }
        }) {
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String> headers = new HashMap<>();

                String auth = "$2b$10$Lp7zj4F3Un4QTExnLKmi3uZuXmx5gx2hbtoj2nmR8iF75RyVkxQd6";
                headers.put("Content-Type", "application/json");
                headers.put("secret-key", auth);
                return headers;
            }
        });

    }

}
