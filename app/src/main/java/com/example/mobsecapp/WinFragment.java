package com.example.mobsecapp;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class WinFragment extends Fragment implements View.OnClickListener {

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
    public void onClick(View v){
        if (v.getId() == R.id.btnFinish){
            Intent intent = new Intent(getActivity(), MainActivity.class);
            startActivity(intent);
        }
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
        greeting.setText("Congratulations, " + username + "!");
        win.setText("You won!");
        Button winButton = view.findViewById(R.id.btnFinish);
        winButton.setOnClickListener(this);
        return view;
    }
}