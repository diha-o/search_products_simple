package pc.dd.vegetables_simple.Adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import pc.dd.vegetables_simple.Fragments.CategoryFragment;
import pc.dd.vegetables_simple.Fragments.SavedProductsInMainAct;


public class PagerAdapterVeg extends FragmentStatePagerAdapter {

    public PagerAdapterVeg(FragmentManager fm) {
        super(fm);
    }



    @Override
    public Fragment getItem(int position) {
       switch (position) {
            case 0:
                return new CategoryFragment();
            case 1:
            default:
                return new SavedProductsInMainAct();
        }
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        //name of tabs in main act below
        switch (position){
            case 0:
                return "Search";
            case 1:
            default:
                return "Added";
        }

    }
}
