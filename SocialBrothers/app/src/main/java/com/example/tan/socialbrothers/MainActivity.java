package com.example.tan.socialbrothers;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnTabReselectListener;
import com.roughike.bottombar.OnTabSelectListener;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FragmentManager fragmentManager = getFragmentManager();
        final FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        BottomBar bottomBar = (BottomBar) findViewById(R.id.bottomBar);
        bottomBar.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelected(@IdRes int tabId) {
                if (tabId == R.id.tab_friends) {
                    String titleToolbar = getString(R.string.tab_friends);
                    setTitle(titleToolbar);
                    CardView_Fragment fragment = new CardView_Fragment();
                    fragmentTransaction.add(R.id.fragment_container, fragment);
                    fragmentTransaction.commit();
                }
                if (tabId == R.id.tab_android) {
                    String titleToolbar = getString(R.string.tab_android);
                    setTitle(titleToolbar);
                    WebView_Fragment fragment = new WebView_Fragment();
                    fragmentTransaction.add(R.id.fragment_container, fragment);
                    fragmentTransaction.commit();
                }
                if (tabId == R.id.tab_favorites) {
                    String titleToolbar = getString(R.string.tab_fav);
                    setTitle(titleToolbar);
                }


            }
        });

        bottomBar.setOnTabReselectListener(new OnTabReselectListener() {
            @Override
            public void onTabReSelected(@IdRes int tabId) {
                if (tabId == R.id.tab_favorites) {
                    // The tab with id R.id.tab_favorites was reselected,
                    // change your content accordingly.
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_info) {
            Intent intent = new Intent(MainActivity.this, Losse_activity.class);
            startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }
}
