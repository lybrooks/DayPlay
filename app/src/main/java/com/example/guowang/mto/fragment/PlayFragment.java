package com.example.guowang.mto.fragment;

import android.os.Bundle;
import android.os.SystemClock;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.example.guowang.mto.R;
import com.example.guowang.mto.utils.L;

public class PlayFragment extends Fragment {
    ProgressBar mProgressBar;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_play, container, false);
        iniView(view);
        return view;
    }

    int n = 0;

    private void iniView(View view) {
        mProgressBar = (ProgressBar) view.findViewById(R.id.song_progress_normal);

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    n++;
                    if (n < 100) {
                        SystemClock.sleep(1000);
                        mProgressBar.setProgress(n);
                    } else {
                        break;
                    }
                }
            }
        }

        ).

                start();
    }

    public static PlayFragment newInstance() {
        return new PlayFragment();

    }

}
