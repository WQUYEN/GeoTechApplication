package quyenvvph20946.fpl.geoteachapplication.fragment.fragment_home;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import quyenvvph20946.fpl.geoteachapplication.R;

public class FragmentPageOutStanding extends Fragment {



    public FragmentPageOutStanding() {

    }

    public static FragmentPageOutStanding newInstance() {
        FragmentPageOutStanding fragment = new FragmentPageOutStanding();
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
        return inflater.inflate(R.layout.fragment_page_out_standing, container, false);
    }
}