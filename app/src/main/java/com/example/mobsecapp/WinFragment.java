package com.example.mobsecapp;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class WinFragment extends Fragment {
    String WIN_NAME = "Admin";
    private String username;

    public WinFragment() {
        // Required empty public constructor
    }
    public static WinFragment newInstance(String username) {
        WinFragment fragment = new WinFragment();
        Bundle args = new Bundle();
        args.putString("username", username);
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            username = getArguments().getString("username");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_win, container, false);
        TextView greeting = view.findViewById(R.id.tvWinName);
        TextView win = view.findViewById(R.id.tvWin);
        if (username.equals(WIN_NAME)){
            greeting.setText(String.format(getString(R.string.congratulations), username));
            win.setText(R.string.win_prompt);
            win.setTextColor(Color.GREEN);
        }
        else {
            greeting.setText(String.format(getString(R.string.commiserations), username));
            win.setText(R.string.lose_prompt);
            win.setTextColor(Color.RED);
        }
        Button winButton = view.findViewById(R.id.btnFinish);
        winButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                requireActivity().finish();
            }
        });
        return view;
    }
}