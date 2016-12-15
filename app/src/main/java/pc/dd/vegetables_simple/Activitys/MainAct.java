package pc.dd.vegetables_simple.Activitys;

import android.support.v7.app.ActionBar;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import pc.dd.vegetables_simple.Adapters.PagerAdapterVeg;
import pc.dd.vegetables_simple.R;


public class MainAct extends AppCompatActivity implements ActionBar.TabListener {

    PagerAdapterVeg mPagerAdapterVeg;
    ViewPager mViewPager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_veg_main);

        //get tabs view
        setTabs();
    }

    public void setTabs(){
        //get action bar
        final android.support.v7.app.ActionBar actionBar = getSupportActionBar();

        //get viewpager
        mViewPager = (ViewPager) findViewById(R.id.pageview);
        mPagerAdapterVeg = new PagerAdapterVeg(getSupportFragmentManager());
        mViewPager.setAdapter(mPagerAdapterVeg);
        mViewPager.setOnPageChangeListener(
                new ViewPager.SimpleOnPageChangeListener() {
                    @Override
                    public void onPageSelected(int position) {
                        //not working in 7.1 and in my // delete after
                        getSupportActionBar().setSelectedNavigationItem(position); // change position tabs
                    }
                });

        // set mode for action bar
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
        actionBar.setHomeButtonEnabled(false);
        //actionBar.setDisplayShowTitleEnabled(false); //if we need not show title after

        // create response for tabs
        ActionBar.TabListener tabListener = new ActionBar.TabListener() {
            @Override
            public void onTabSelected(ActionBar.Tab tab, android.support.v4.app.FragmentTransaction ft) {
                //return
                mViewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(ActionBar.Tab tab, android.support.v4.app.FragmentTransaction ft) {

            }

            @Override
            public void onTabReselected(ActionBar.Tab tab, android.support.v4.app.FragmentTransaction ft) {

            }

        };

        // Add 2 tabs with name
        for (int i = 0; i < 2; i++) {
            actionBar.addTab(
                    actionBar.newTab()
                            .setText(mPagerAdapterVeg.getPageTitle(i))
                            .setTabListener((android.support.v7.app.ActionBar.TabListener) tabListener));
        }


    }


    @Override
    public void onTabSelected(ActionBar.Tab tab, android.support.v4.app.FragmentTransaction ft) {

    }

    @Override
    public void onTabUnselected(ActionBar.Tab tab, android.support.v4.app.FragmentTransaction ft) {

    }

    @Override
    public void onTabReselected(ActionBar.Tab tab, android.support.v4.app.FragmentTransaction ft) {

    }
}
