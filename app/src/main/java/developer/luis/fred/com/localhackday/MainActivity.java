package developer.luis.fred.com.localhackday;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.io.IOException;
import java.sql.SQLClientInfoException;

import Database.DBHelper;

public class MainActivity extends AppCompatActivity  implements View.OnClickListener {
   public static Context globalContext = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        globalContext = this;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        UiInitialization();
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();

        DrawerLayout mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, toolbar, R.string.open,R.string.close);
        mDrawerLayout.setDrawerListener(mDrawerToggle);
        mDrawerToggle.syncState();
        NavigationView navigationView = (NavigationView) findViewById(R.id.navigation_view);
        navigationView.setNavigationItemSelectedListener(Navigation_Drawer_Listener);

        DesignPagerAdapter adapter = new DesignPagerAdapter(getSupportFragmentManager()); //instanciamos un contenedor de contenedores
        ViewPager viewPager = (ViewPager)findViewById(R.id.viewpager); //paginas y se mete en el adapter
        viewPager.setAdapter(adapter);
        TabLayout tabLayout = (TabLayout)findViewById(R.id.tablayout); //lugar en el xml donde se mete
        tabLayout.setupWithViewPager(viewPager);

        /*MainActivityFragment firstFragment = new MainActivityFragment();
        getSupportFragmentManager().beginTransaction().add(R.id.fragment_container, firstFragment).commit();*/
        test();
    }

    public void test(){
        DBHelper obj_helper;
        SQLiteDatabase obj_sql;
        obj_helper = new DBHelper(this);
        try {
            obj_sql = obj_helper.loadDataBase(this,obj_helper);
            String regreso = obj_helper.getGrupo(obj_sql);
            Log.d("************************************" , regreso + "");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void UiInitialization (){
        FloatingActionButton Fab_main = (FloatingActionButton) findViewById(R.id.fab_main);
        Fab_main.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.fab_main : {
                Snackbar.make(view, "SnackBar", Snackbar.LENGTH_LONG).setAction("Action", null).show();
                break;
            }
        }
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
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {

        int count = getFragmentManager().getBackStackEntryCount();

        if (count == 0) {
            super.onBackPressed();
            //additional code
        } else {
            getFragmentManager().popBackStack();
        }

    }

    public NavigationView.OnNavigationItemSelectedListener Navigation_Drawer_Listener = new NavigationView.OnNavigationItemSelectedListener() {

        // This method will trigger on item Click of navigation menu
        @Override
        public boolean onNavigationItemSelected(MenuItem menuItem) {


            //Checking if the item is in checked state or not, if not make it in checked state
            if(menuItem.isChecked()) menuItem.setChecked(false);
            else menuItem.setChecked(true);

            //Closing drawer on item click
            DrawerLayout drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
            drawerLayout.closeDrawers();

            //Check to see which item was being clicked and perform appropriate action
            switch (menuItem.getItemId()){


                // For rest of the options we just show a toast on click
                default:
                    Snackbar.make(getCurrentFocus(), "Default Snackbar ", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                    return true;

            }
        }
    };
}


