package fr.esilv.s8.androidapplication.Activities;

/**
 * Created by Ramez Aissaoui on 20/03/2017.
 */

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

import java.util.List;

import fr.esilv.s8.androidapplication.Adapters.VideosAdapter;
import fr.esilv.s8.androidapplication.Interfaces.OnVideoSelectedListener;
import fr.esilv.s8.androidapplication.Models.Example;
import fr.esilv.s8.androidapplication.Models.Item;
import fr.esilv.s8.androidapplication.R;

public class VideoActivity extends AppCompatActivity implements OnVideoSelectedListener {

    private static final String VIDEOS_URL = "https://www.googleapis.com/youtube/v3/search?part=snippet&type=video&key=AIzaSyCzRbBdQ7YsZo2JSMnNE4pIuNnQrS-OaiQ&q=";
    private RecyclerView recyclerView;
    String query="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_videos);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        getVideos();

        Intent intent = getIntent();
        startActivity(intent);
    }

    private void getVideos() {
        //String query=onEvent(QueryEvent event);
        String query="eminem";
        StringRequest videosRequest = new StringRequest(VIDEOS_URL+query, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                //parse data from webservice to get Contracts as Java object
                Example videos = new Gson().fromJson(response, Example.class);

                setAdapter(videos.getItems());
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("Videos", "Error");
            }
        });

        Volley.newRequestQueue(this).add(videosRequest);
    }

    private void setAdapter(List<Item> items) {
        VideosAdapter adapter = new VideosAdapter(items);
        //adapter.OnVideoSelectedListener(this);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onVideoSelected(Item video) {

    }

    public void showFragment(View view) {
        view.setVisibility(View.GONE);
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        //the id passed as parameter is the id of the FrameLayout defined in activity_videos.xml.
        fragmentTransaction.replace(R.id.contentFrame, new SecondFragment());
        //the transaction has to be committed for changes to happen.
        fragmentTransaction.commit();
    }

    /*@Override
    public void onContractSelected(Contract contract) {
        StationsActivity.start(this, contract.getName());
    }*/
}
