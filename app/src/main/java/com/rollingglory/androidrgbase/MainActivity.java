package com.rollingglory.androidrgbase;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.rollingglory.androidrgbase.base.BaseActivity;
import com.rollingglory.androidrgbase.page.color.ColorFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @BindView(R.id.drawer_layout) DrawerLayout drawer;
    @BindView(R.id.toolbar) Toolbar toolbar;
    @BindView(R.id.nav_view) NavigationView navigationView;
    @BindView(R.id.fab) FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        setSupportActionBar(toolbar);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });
        initNavigationDrawer();

        Fragment fragment = HomeFragment.newInstance();
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.fl_content, fragment).commit();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            FragmentManager fm = getSupportFragmentManager();
            if (fm.getBackStackEntryCount() > 0) {
                fm.popBackStack();
            } else {
                // find home fragment, if not visible, show home instead of close app
                Fragment fragment = fm.findFragmentByTag("home");
                String tag;
                if(fragment == null || !fragment.isVisible()) {
                    tag = "home";
                    FragmentManager fragmentManager = getSupportFragmentManager();
                    fragmentManager.beginTransaction().replace(R.id.fl_content, fragment, tag).commit();
                } else {
                    super.onBackPressed();
                }
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void initNavigationDrawer() {
        navigationView.setNavigationItemSelectedListener(this);

        View header = navigationView.getHeaderView(0);
        header.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int size = navigationView.getMenu().size();
                for(int i=0; i<size; i++) {
                    navigationView.getMenu().getItem(i).setChecked(false);
                }
                changeFragment(HomeFragment.newInstance(), "home");
                drawer.closeDrawer(GravityCompat.START);
            }
        });

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        if(item.isChecked()) {
            drawer.closeDrawers();
            return true;
        }

        Fragment fragment;
        Class fragmentClass = null;
        String tag = null;
        switch (item.getItemId()) {
            case R.id.nav_color:
                fragmentClass = ColorFragment.class;
                tag = "color";
                break;
            case R.id.nav_typography:
                break;
            case R.id.nav_button:
                break;
            case R.id.nav_form:
                break;
            default:
                fragmentClass = HomeFragment.class;
                tag = "home";
        }

        try {
            if(fragmentClass != null) {
                fragment = (Fragment) fragmentClass.newInstance();
                changeFragment(fragment, tag);
                item.setChecked(true);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void changeFragment(Fragment fragment, String tag) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        // clear backstack. remove this block to keep backstack (back to prev fragment when back is pressed)
        int count = fragmentManager.getBackStackEntryCount();
        for(int i = 0; i < count; ++i) {
            fragmentManager.popBackStack();
        }
        //fragmentManager.beginTransaction().replace(R.id.fl_content, fragment, tag).addToBackStack(null).commit();
        fragmentManager.beginTransaction().replace(R.id.fl_content, fragment, tag).commit();
    }
}
