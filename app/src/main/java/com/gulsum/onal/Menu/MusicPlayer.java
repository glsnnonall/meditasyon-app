package com.gulsum.onal.Menu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.media.MediaMetadataRetriever;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.TextView;

import com.gulsum.onal.Helper.Utils;
import com.gulsum.onal.R;

import java.lang.reflect.Field;
import java.util.ArrayList;

import co.mobiwise.library.MusicPlayerView;
import okhttp3.internal.Util;

public class MusicPlayer extends AppCompatActivity {

    MediaPlayer player;
    ArrayList<String> musicList;
    MusicPlayerView mpv;
    ArrayAdapter arrayAdapter;
    int selectedIndex = 0;
    TextView musicName;
    int seek = 0;
     @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music_player);
         selectedIndex = getIntent().getIntExtra("selectedIndex",0);
         seek = getIntent().getIntExtra("seek",0);
         musicName = (TextView)findViewById(R.id.musicName);
        musicList = new ArrayList<>();
        Field[] fields = R.raw.class.getFields();
        for ( int i = 0 ; i < fields.length ; i++){
            musicList.add(fields[i].getName());
        }

        System.out.println("resId "+getResources().getIdentifier(musicList.get(selectedIndex),"raw",getPackageName()));

        mpv = (MusicPlayerView)findViewById(R.id.mpv);


        mpv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mpv.isRotating()) {
                    pause();
                    mpv.stop();
                } else {
                    if (player == null) {
                        if (selectedIndex <= musicList.size()){
                            musicName.setText(musicList.get(selectedIndex));
                            play(getResources().getIdentifier(musicList.get(selectedIndex),"raw",getPackageName()));
                            player.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                                @Override
                                public void onCompletion(MediaPlayer mp) {
                                    stopPlayer();
                                }
                            });
                        }else {
                            selectedIndex = 0;
                            musicName.setText(musicList.get(selectedIndex));

                            play(getResources().getIdentifier(musicList.get(selectedIndex),"raw",getPackageName()));
                            player.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                                @Override
                                public void onCompletion(MediaPlayer mp) {
                                    stopPlayer();
                                }
                            });
                        }

                    }
                    player.start();
                    mpv.start();
                }

            }
        });

    }

    public void play(int resID) {
        if (player == null) {
            player = MediaPlayer.create(MusicPlayer.this, resID);
            int duration = player.getDuration();
            mpv.setMax(duration / 1000);
            mpv.setProgress(0);
            player.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {
                    stopPlayer();
                }
            });
        }
        player.start();
    }
    public void playSeek(int resID,int seek) {
        if (player == null) {
            player = MediaPlayer.create(MusicPlayer.this, resID);
            int duration = player.getDuration();
            mpv.setMax(duration / 1000);
            mpv.setProgress(seek);
            player.seekTo(seek * 1000);
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

    public void showList(View view) {
        Intent i = new Intent(MusicPlayer.this,MusicList.class);
        i.putExtra("list",musicList);
        i.putExtra("selectedIndex",selectedIndex);
        startActivity(i);
        Utils.go(MusicPlayer.this);
    }

    public void nextMusic(View view) {
         if (selectedIndex < 3){

             stopPlayer();

             selectedIndex++;
             if (selectedIndex >= musicList.size()){
                 selectedIndex = 0;
             }
             musicName.setText(musicList.get(selectedIndex));

             play(getResources().getIdentifier(musicList.get(selectedIndex),"raw",getPackageName()));
             mpv.start();

         }else {

             stopPlayer();

             selectedIndex = 0;
             play(getResources().getIdentifier(musicList.get(selectedIndex),"raw",getPackageName()));
             mpv.start();
         }
    }

    public void backMusic(View view) {
        if (selectedIndex <= 3 && selectedIndex != 0 ){

            stopPlayer();




            selectedIndex = selectedIndex - 1 ;
            musicName.setText(musicList.get(selectedIndex));

            play(getResources().getIdentifier(musicList.get(selectedIndex),"raw",getPackageName()));
            mpv.start();
            player.start();
        }else  if ( selectedIndex == 0){


            stopPlayer();

            selectedIndex = 0;
            musicName.setText(musicList.get(selectedIndex));

            play(getResources().getIdentifier(musicList.get(selectedIndex),"raw",getPackageName()));
            mpv.start();
            player.start();
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Utils.back(MusicPlayer.this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        if (seek != 0){
            mpv.start();
            playSeek(getResources().getIdentifier(musicList.get(selectedIndex),"raw",getPackageName()),seek);
        }

    }
}
