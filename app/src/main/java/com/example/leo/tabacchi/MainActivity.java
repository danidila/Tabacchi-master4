package com.example.leo.tabacchi;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;

import com.example.leo.tabacchi.fragments.TabacchiListFragment;
import com.example.leo.tabacchi.fragments.TabacchiMapFragment;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationServices;

public class MainActivity extends AppCompatActivity implements GoogleApiClient.OnConnectionFailedListener,GoogleApiClient.ConnectionCallbacks {

    private ViewPager pager;
    private PagerAdapter adapter;
    private TabLayout mTabLayout;
    private GoogleApiClient mGoogleApiClient;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mGoogleApiClient=new GoogleApiClient.Builder(this)
                .addApi(LocationServices.API)
                .addConnectionCallbacks(this)
                .addOnConnectionFailedListener(this)
                .build();

        Toolbar toolbar= (Toolbar) findViewById(R.id.appbar);
        setSupportActionBar(toolbar);
        toolbar.setSubtitle(R.string.subtitle);

        pager= (ViewPager) findViewById(R.id.pager);
        adapter=new PagerAdapter(getSupportFragmentManager());

        adapter.addFragment(new TabacchiMapFragment(),"Dove sono?");
        adapter.addFragment(new TabacchiListFragment(),"Elenco");

        pager.setAdapter(adapter);

        mTabLayout= (TabLayout) findViewById(R.id.tablayout);
        mTabLayout.setupWithViewPager(pager);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mGoogleApiClient.connect();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mGoogleApiClient.disconnect();
    }

    @Override
    public void onConnected(@Nullable Bundle bundle) {
        Toast.makeText(this,"Connessione Riuscita!!!",Toast.LENGTH_LONG).show();
    }

    @Override
    public void onConnectionSuspended(int i) {

    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }
}
