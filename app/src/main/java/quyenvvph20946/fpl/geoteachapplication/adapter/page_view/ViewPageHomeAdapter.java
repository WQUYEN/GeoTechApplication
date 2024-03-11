package quyenvvph20946.fpl.geoteachapplication.adapter.page_view;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.hn_2025_online_shop.view.fragment.fragment_home.FragementPageSelling;
import com.example.hn_2025_online_shop.view.fragment.fragment_home.FragmentPageDiscount;
import com.example.hn_2025_online_shop.view.fragment.fragment_home.FragmentPageOutstanding;

public class ViewPageHomeAdapter extends FragmentStateAdapter {

    public ViewPageHomeAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0:
                return new FragementPageSelling();
            case 1:
                return new FragmentPageDiscount();
            case 2:
                return new FragmentPageOutstanding();
            default:
                return null;
        }
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
