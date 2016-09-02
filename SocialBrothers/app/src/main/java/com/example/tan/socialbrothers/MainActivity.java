package com.example.tan.socialbrothers;

import android.annotation.TargetApi;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.IdRes;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnTabReselectListener;
import com.roughike.bottombar.OnTabSelectListener;

public class MainActivity extends AppCompatActivity {

    // Fragments
    CardView_Fragment cardFrag;
    WebView_Fragment webFrag;
    PrefFragment prefFrag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //bottom navigation
        BottomBar bottomBar = (BottomBar) findViewById(R.id.bottomBar);
        bottomBar.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelected(@IdRes int tabId) {
                final FragmentManager fragmentManager = getFragmentManager();
                final FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                if (tabId == R.id.tab_friends) {
                    String titleToolbar = getString(R.string.tab_friends);
                    setTitle(titleToolbar);
                    cardFrag = new CardView_Fragment();
                    fragmentTransaction.replace(R.id.fragment_container, cardFrag);

                }
                if (tabId == R.id.tab_android) {
                    String titleToolbar = getString(R.string.tab_android);
                    setTitle(titleToolbar);
                    webFrag = new WebView_Fragment();
                    fragmentTransaction.replace(R.id.fragment_container, webFrag);

                }
                if (tabId == R.id.tab_favorites) {
                    String titleToolbar = getString(R.string.tab_fav);
                    setTitle(titleToolbar);
                    prefFrag = new PrefFragment();
                    fragmentTransaction.replace(R.id.fragment_container, prefFrag);

                }
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
                loadPreferences();

            }
        });


    }

    @Override
    protected void onResume() {
        super.onResume();
        loadPreferences();
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

    //PrefFragment Settings
    @TargetApi(Build.VERSION_CODES.M)
    private void loadPreferences() {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);

        boolean isBackgroundDark = sharedPreferences.getBoolean("background_color", false);
        if (isBackgroundDark) {
            Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
            toolbar.setBackgroundColor(Color.parseColor("#66D9FF"));

        }
        if (!isBackgroundDark) {
            Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
            toolbar.setBackgroundColor(getColor(R.color.colorPrimary));
        }
    }
}
