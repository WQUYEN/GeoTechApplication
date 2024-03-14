package quyenvvph20946.fpl.geoteachapplication.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.json.JSONException;
import org.json.JSONObject;

import java.net.URISyntaxException;
import java.text.SimpleDateFormat;
import java.util.List;

import io.socket.client.IO;
import io.socket.client.Socket;
import io.socket.emitter.Emitter;
import quyenvvph20946.fpl.geoteachapplication.R;
import quyenvvph20946.fpl.geoteachapplication.adapter.NotificationAdapter;
import quyenvvph20946.fpl.geoteachapplication.api.BaseApi;
import quyenvvph20946.fpl.geoteachapplication.databinding.FragmentNotificationBinding;
import quyenvvph20946.fpl.geoteachapplication.model.Notifi;


public class FragmentNotification extends Fragment {

    private FragmentNotificationBinding binding;
    private NotificationAdapter notificationAdapter;
    private List<Notifi> notifiList;

    SimpleDateFormat sdf = new SimpleDateFormat("hh:mm a");

    // socket để thao tác
    private Socket mSocket;
    {
        try {
            mSocket = IO.socket("http://" + BaseApi.LOCALHOT +":3000");
        } catch (URISyntaxException e) {}
    }


    public FragmentNotification() {
        // Required empty public constructor
    }

    public static FragmentNotification newInstance() {
        FragmentNotification fragment = new FragmentNotification();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentNotificationBinding.inflate(getLayoutInflater());
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
//        initView();
//        initController();
//        getListNotify();
//        initSocket();
    }



}