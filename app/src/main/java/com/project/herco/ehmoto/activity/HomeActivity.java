package com.project.herco.ehmoto.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.project.herco.ehmoto.R;

public class HomeActivity extends AppCompatActivity {

    private Toolbar mTopToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        mTopToolbar = findViewById(R.id.my_toolbar);
        mTopToolbar.setTitle("");
        setSupportActionBar(mTopToolbar);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // inflate menu
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        // aqui pode ser adicionado ids os itens que vao para a toolbar
        if (id == R.id.action_favorite){
            Intent intent = new Intent(HomeActivity.this,DashboardActivity.class);
            Toast.makeText(HomeActivity.this, "Action Clicked",Toast.LENGTH_LONG).show();
            startActivity(intent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
