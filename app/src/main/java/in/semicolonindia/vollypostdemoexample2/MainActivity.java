package in.semicolonindia.vollypostdemoexample2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import in.semicolonindia.vollypostdemoexample2.Adapter.RecyclerAdapter;

public class MainActivity extends AppCompatActivity {

    private static final String JSON_URL = "http://semicolonindia.in/school-crm-demo/index.php?mobile/get_event_calendar";
    RecyclerView recyclerView;
    RecyclerAdapter recyclerAdapter;
    List<ItemDetails> itemDetailsList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerview1);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        itemDetailsList = new ArrayList<>();

        loadItemDetails();
    }

    private void loadItemDetails() {
        final ProgressBar progressBar = (ProgressBar) findViewById(R.id.progressBar);
        //making the progressbar visible
        progressBar.setVisibility(View.VISIBLE);

        StringRequest stringRequest = new StringRequest(Request.Method.POST, JSON_URL,
                new Response.Listener<String>() {

                    @Override
                    public void onResponse(String response) {

                        progressBar.setVisibility(View.INVISIBLE);

                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            if (!jsonObject.getBoolean("error")) {
                                JSONArray noticeArray = jsonObject.getJSONArray("noticeboard");
                                for (int i = 0; i < noticeArray.length(); i++) {

                                    JSONObject noticeObject = noticeArray.getJSONObject(i);
                                    ItemDetails itemDetails = new ItemDetails(noticeObject.getString("notice_id"),
                                            noticeObject.getString("notice_title"),
                                            noticeObject.getString("date_added"),
                                            noticeObject.getString("notice"));

                                    itemDetailsList.add(itemDetails);
                                }

                            }
                            else {
                                Toast.makeText(getApplicationContext(), "error", Toast.LENGTH_LONG).show();
                            }

                            recyclerAdapter = new RecyclerAdapter(getApplicationContext(), itemDetailsList);
                            recyclerView.setAdapter(recyclerAdapter);


                        } catch (JSONException e) {
                            e.printStackTrace();
                        }


                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e("status Response", String.valueOf(error));

                       /* Toast.makeText(getApplicationContext(),
                                error.getMessage(), Toast.LENGTH_SHORT).show();
*/
                    }
                }) {

            protected Map<String, String> getParams() throws AuthFailureError {
                // Post params to be sent to the server
                HashMap<String, String> params = new HashMap<>();
                params.put("TAG", "get_event_calendar");
                params.put("authenticate", "false");



                return params;
            }
        };


        //creating a request queue
        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
        //adding the string request to request queue
        requestQueue.add(stringRequest);
    }

}




