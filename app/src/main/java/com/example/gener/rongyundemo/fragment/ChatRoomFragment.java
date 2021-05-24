package com.example.gener.rongyundemo.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.gener.rongyundemo.R;

public class ChatRoomFragment extends Fragment {

    public static ChatRoomFragment getInstance(String flag){
        Bundle bundle = new Bundle();
        bundle.putString(ChatRoomFragment.class.getSimpleName(),flag);
        ChatRoomFragment addressFragment = new ChatRoomFragment();
        addressFragment.setArguments(bundle);
        return addressFragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.fragment_chat_room, container, false);
        return inflate;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }
}
