package fr.esilv.s8.androidapplication.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import fr.esilv.s8.androidapplication.Models.Item;
import fr.esilv.s8.androidapplication.R;
import fr.esilv.s8.androidapplication.Interfaces.OnVideoSelectedListener;

/**
 * Created by Ramez Aissaoui on 26/03/2017.
 */

public class SearchActivity extends AppCompatActivity implements OnVideoSelectedListener {


    private EditText editText;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        editText = (EditText) findViewById(R.id.editText);
        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SearchActivity.this, VideoActivity.class);
                intent.putExtra("search", editText.getText().toString());
                startActivity(intent);
            }
        });
    }

    @Override
    public void onVideoSelected(Item video) {
        VideoActivity.start(this,video);
    }



}