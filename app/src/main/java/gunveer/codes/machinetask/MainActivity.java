package gunveer.codes.machinetask;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import gunveer.codes.machinetask.Fetcher;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.JsonRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static gunveer.codes.machinetask.Fetcher.dataFetcheds;

public class MainActivity extends AppCompatActivity {

    Button btnView;
    RecyclerView recyclerView;
    RecyclerView.Adapter recAdapter;
static Context context;
    //ArrayList<DataFetched> dataFetcheds;

    public static Context getContext() {
        return context;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnView = findViewById(R.id.btnView);

        recyclerView = findViewById(R.id.recyclerView);

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        recAdapter =  new RecViewAdapter(dataFetcheds, MainActivity.this);
        recyclerView.setAdapter(recAdapter);


        btnView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Fetcher fetcher = new Fetcher(MainActivity.this);
                fetcher.dataGet(new Fetcher.VolleyResponseListener() {
                    @Override
                    public void onError(String message) {
                        Toast.makeText(MainActivity.this, "Some Error", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onResponse(ArrayList<DataFetched> dataFetcheds) {


                        recyclerView.setHasFixedSize(true);
                        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                        recAdapter =  new RecViewAdapter(dataFetcheds, MainActivity.this);
                        recyclerView.setAdapter(recAdapter);


                    }
                });



            }
        });

    }
}