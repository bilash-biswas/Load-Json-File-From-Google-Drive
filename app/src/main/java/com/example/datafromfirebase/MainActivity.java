package com.example.datafromfirebase;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.Request.Method;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.datafromfirebase.databinding.ActivityMainBinding;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    ArrayList<DataModel> modelArrayList;
    MyAdapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        //String url = "https://jsonkeeper.com/b/63OH";
        //Picasso.get().load("https://media.geeksforgeeks.org/img-practice/banner/fork-cpp-thumbnail.png").into(binding.idIVCourse);
        String url = "https://drive.google.com/uc?export=download&id=1m-lmKoCB7vDjKnZ8YHlLQj1WXxhaLpH4";

        modelArrayList = new ArrayList<>();


        RequestQueue queue = Volley.newRequestQueue(MainActivity.this);

        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                binding.progressBar.setVisibility(View.GONE);
                binding.recyclerView.setVisibility(View.VISIBLE);
                try {

                    for (int i =0; i<response.length();i++){


                        JSONObject jsonObject = response.getJSONObject(i);
                        DataModel dataModel = new DataModel(
                                jsonObject.getString("name"),
                                jsonObject.getString("language"),
                                jsonObject.getString("id"),
                                jsonObject.getString("bio"),
                                jsonObject.getString("version")
                        );

                        modelArrayList.add(dataModel);
                    }
                    runOnUiThread(() -> myAdapter.notifyDataSetChanged());
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MainActivity.this, error.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            }
        });

        queue.add(jsonArrayRequest);

        binding.recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        myAdapter = new MyAdapter(modelArrayList, getApplicationContext());
        binding.recyclerView.setAdapter(myAdapter);


    }
}