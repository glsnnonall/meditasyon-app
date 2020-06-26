package com.gulsum.onal.Menu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import com.gulsum.onal.Helper.Utils;
import com.gulsum.onal.R;

import java.util.ArrayList;

public class MusicList extends AppCompatActivity {

    ArrayList<String> listMusic;
    ListView listView;
    ArrayAdapter arrayAdapter;
    int selectedIndex;
    MediaPlayer player;
    private Handler mHandler = new Handler();
    int seek = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music_list);
        listMusic = getIntent().getStringArrayListExtra("list");
        selectedIndex = getIntent().getIntExtra("selectedIndex",0);
        listView = (ListView)findViewById(R.id.list);
        arrayAdapter = new ArrayAdapter(MusicList.this,android.R.layout.simple_list_item_1,listMusic);
        listView.setAdapter(arrayAdapter);
        initActionBar();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                if (player != null){
                    player.release();

                }



                player = MediaPlayer.create(MusicList.this, getResources().getIdentifier(listMusic.get(position),"raw",getPackageName()));
                player.start();
                    selectedIndex = position;

                MusicList.this.runOnUiThread(new Runnable() {

                    @Override
                    public void run() {
                        if(player != null){
                            int mCurrentPosition = player.getCurrentPosition() / 1000;
                           // mSeekBar.setProgress(mCurrentPosition);
                        }
                        mHandler.postDelayed(this, 1000);
                        System.out.println("seek : "+mHandler.getLooper());
                        seek ++;
                        System.out.println("seek : "+ seek);
                    }
                });

            }
        });


    }
    public void play(int resID) {
        if (player == null) {
            player = MediaPlayer.create(MusicList.this, resID);
            int duration = player.getDuration();

            player.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {

                }
            });
        }
        player.start();
    }
    private void initActionBar() {
        // Initialize the Toolbar( this is the new ActionBar in Lollipop)
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle("Müzik Listesi");
        TextView title = (TextView)toolbar.findViewById(R.id.toolbar_title);
        ImageButton back = (ImageButton)toolbar.findViewById(R.id.back);
        back.setVisibility(View.VISIBLE);
        title.setText("Muzik Listesi");

        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        getSupportActionBar().setTitle("");
        getSupportActionBar().setElevation(4);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(MusicList.this,MusicPlayer.class);
                i.putExtra("selectedIndex",selectedIndex);
                i.putExtra("seek",seek);
                player.stop();
                startActivity(i);

                Utils.back(MusicList.this);
            }
        });


    }
}
