package quyenvvph20946.fpl.geoteachapplication.view.fragment.fragment_home;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import quyenvvph20946.fpl.geoteachapplication.R;

public class FragmentPageDiscount extends Fragment {


    public FragmentPageDiscount() {

    }

    public static FragmentPageDiscount newInstance() {
        FragmentPageDiscount fragment = new FragmentPageDiscount();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_page_discount, container, false);
    }
}