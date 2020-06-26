package com.gulsum.onal.Menu;


import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gulsum.onal.R;

import co.mobiwise.library.MusicPlayerView;

/**
 * A simple {@link Fragment} subclass.
 */
public class MeditaionMusicFragment extends Fragment {

    MediaPlayer player;

    View view;
    MusicPlayerView mpv;
    public MeditaionMusicFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view =   inflater.inflate(R.layout.fragment_meditaion_music, container, false);
        mpv = (MusicPlayerView)view.findViewById(R.id.mpv);
        mpv.setMax(128);
        mpv.setProgress(0);

        mpv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mpv.isRotating()) {
                   pause();
                    mpv.stop();
                } else {
                    if (player == null) {
                        player = MediaPlayer.create(getContext(), R.raw.hayat);
                        player.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                            @Override
                            public void onCompletion(MediaPlayer mp) {
                                stopPlayer();
                            }
                        });
                    }
                    player.start();
                    mpv.start();
                }

            }
        });





        return view;


    }
    public void play(int resId) {
        if (player == null) {
            player = MediaPlayer.create(getContext(), resId);
            player.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {
                    stopPlayer();
                }
            });
        }
        player.start();
    }
    public void pause() {
        if (player != null) {
            player.pause();
        }
    }
    public void stop(View v) {
        stopPlayer();
    }
    private void stopPlayer() {
        if (player != null) {
            player.release();
            player = null;
        }
    }
    @Override
    public void onStop() {
        super.onStop();
        stopPlayer();
    }

}
