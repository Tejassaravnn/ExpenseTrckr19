package expensetracker.tejas.expensetrckr19;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.LayoutInflater;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private static final String FILE_NAME="sure.txt";
    private static final String FILE_NAME1="amt.txt";
    private List<Product> mProdutcList;
    private ProductListAdapter adapter;
    private ListView ls;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ls=(ListView)findViewById(R.id.list_product);
        mProdutcList=new ArrayList<>();

        mProdutcList.add(new Product(1,"Grocery",500));
        mProdutcList.add(new Product(2,"Medics",500));
        mProdutcList.add(new Product(3,"Food",500));

        load();

        adapter=new ProductListAdapter(getApplicationContext(),mProdutcList);
        ls.setAdapter(adapter);
        ls.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent i=new Intent(MainActivity.this,pop.class);
                startActivity(i);
            }
        });
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    private void load()
    {
        FileInputStream fis=null;
        FileInputStream fis1=null;
        int count=0;
        try {
            //in=new dviews(context);
            fis=openFileInput(FILE_NAME);
            fis1=openFileInput(FILE_NAME1);
            InputStreamReader isr=new InputStreamReader(fis);
            InputStreamReader isr1=new InputStreamReader(fis1);
            BufferedReader br=new BufferedReader(isr);
            BufferedReader br1=new BufferedReader(isr1);
            // mlayout=(GridLayout)findViewById(R.id.mylayout);
            // StringBuilder sb=new StringBuilder();
            String text;
            String str;
            String text1;
            String str1;

            while((text=br.readLine())!=null)
            {
                str=text;
                text1=br1.readLine();
                int d;
                if(text1==null)
                    d=0;
                else
                    d=Integer.parseInt(text1);
                mProdutcList.add(new Product(++count,str,d));
                // mlayout.addView(in.dtv(getApplicationContext(),str),1);
            }
            fis.close();
        } catch (Exception e) {
            //e.printStackTrace();
        }
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
            load();
        } else {
            super.onBackPressed();
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

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        View rootView=null;
        LayoutInflater inflater=null;
        ViewGroup container=null;
        int id = item.getItemId();

        if (id == R.id.add) {
            // Handle the camera action
            Intent i=new Intent(MainActivity.this,main.class);
            startActivity(i);

        } else if (id == R.id.stats) {
            Intent i=new Intent(MainActivity.this,stats.class);
            startActivity(i);

        } else if (id == R.id.nav_slideshow) {

        }


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
