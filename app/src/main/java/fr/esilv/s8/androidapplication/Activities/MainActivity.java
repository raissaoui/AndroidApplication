package fr.esilv.s8.androidapplication.Activities;

/**
 * Created by Ramez Aissaoui on 21/03/2017.
 */

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import de.greenrobot.event.EventBus;
import fr.esilv.s8.androidapplication.R;

public class MainActivity extends AppCompatActivity {
    private EditText editText;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, VideoActivity.class);
                intent.putExtra("search", editText.getText().toString());
                startActivity(intent);
            }
        });*/
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_main, menu);
        Bundle bundle= new Bundle();

        final MenuItem searchItem = menu.findItem(R.id.action_search);
        final SearchView searchView = (SearchView) MenuItemCompat.getActionView(searchItem);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {

                EventBus.getDefault().post(new QueryEvent(query));
                invalidateOptionsMenu();

                return false;

            }

            @Override
            public boolean onQueryTextChange(String s) {
                return false;
            }
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, VideoActivity.class);
                //intent.putExtra("search", editText.getText().toString());
                startActivity(intent);
            }
        });

        /*searchView.setOnSearchClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, VideoActivity.class);
                //intent.putExtra("search", editText.getText().toString());
                startActivity(intent);
            }
        });*/
        return true;
    }

}