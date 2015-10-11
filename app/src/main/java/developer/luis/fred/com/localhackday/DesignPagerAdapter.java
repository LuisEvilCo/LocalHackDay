package developer.luis.fred.com.localhackday;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

class DesignPagerAdapter extends FragmentStatePagerAdapter {
    public DesignPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return DesignFragment.newInstance(position);
    }

    @Override
    public int getCount() {
        //Number of tabs in the view
        return 3; //numero de tab
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position){
            case 0:{
                return "Horario";
            }
            case 1:{
                return  "Mapa";
            }
            default:{
                return "Coming Soon " + position;
            }
        }
    }
}