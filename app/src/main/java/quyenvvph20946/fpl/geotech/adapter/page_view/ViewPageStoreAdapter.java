package quyenvvph20946.fpl.geotech.adapter.page_view;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import quyenvvph20946.fpl.geotech.view.infor_shop.FragmentProductStore;
import quyenvvph20946.fpl.geotech.view.infor_shop.FragmentStore;

public class ViewPageStoreAdapter extends FragmentPagerAdapter {

    public ViewPageStoreAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }
    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new FragmentStore();
            case 1:
                return new FragmentProductStore();
            default:
                return null;
        }
    }
    @Override
    public int getCount() {
        return 2;
    }
}

