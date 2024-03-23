package quyenvvph20946.fpl.geotech.adapter.page_view;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import quyenvvph20946.fpl.geotech.view.my_store.OrderStore.fragment.FragmentPageCancelledStore;
import quyenvvph20946.fpl.geotech.view.my_store.OrderStore.fragment.FragmentPageConfirmStore;
import quyenvvph20946.fpl.geotech.view.my_store.OrderStore.fragment.FragmentPageDeliveredStore;
import quyenvvph20946.fpl.geotech.view.my_store.OrderStore.fragment.FragmentPageWaitingDeliveryStore;

public class ViewPageOrderStoreAdapter extends FragmentStateAdapter {
    public ViewPageOrderStoreAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0:
                return new FragmentPageConfirmStore();
            case 1:
                return new FragmentPageWaitingDeliveryStore();
            case 2:
                return new FragmentPageDeliveredStore();
            case 3:
                return new FragmentPageCancelledStore();
            default:
                return null;
        }
    }

    @Override
    public int getItemCount() {
        return 4;
    }
}
