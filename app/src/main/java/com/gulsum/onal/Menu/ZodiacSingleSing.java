package com.gulsum.onal.Menu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.gulsum.onal.Helper.Utils;
import com.gulsum.onal.R;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import de.hdodenhof.circleimageview.CircleImageView;

public class ZodiacSingleSing extends AppCompatActivity {
    CircleImageView circleImageView;
    TextView username;
    String profileImage = "https://hthayat.haberturk.com/im/2015/03/18/ver1429277259/1028324_620x360.jpg";
    ProgressBar progressBar;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zodiac_single_sing);
        username = (TextView)findViewById(R.id.username);
        username.setText("@rezzankiraz");
        circleImageView = (CircleImageView)findViewById(R.id.profileImage);
        textView = (TextView)findViewById(R.id.text);
        progressBar = (ProgressBar)findViewById(R.id.progres);
        Picasso.get().load(profileImage).resize(256,256).centerCrop().into(circleImageView, new Callback() {
            @Override
            public void onSuccess() {
                progressBar.setVisibility(View.GONE);
            }

            @Override
            public void onError(Exception e) {

            }
        });

        textView.setText(getIntent().getStringExtra("text"));

        initActionBar();
    }
    private void initActionBar() {
        // Initialize the Toolbar( this is the new ActionBar in Lollipop)
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle(getIntent().getStringExtra("burc"));
        TextView title = (TextView)toolbar.findViewById(R.id.toolbar_title);
        ImageButton back = (ImageButton)toolbar.findViewById(R.id.back);
        back.setVisibility(View.VISIBLE);
        title.setText(getIntent().getStringExtra("burc"));

        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        getSupportActionBar().setTitle("");
        getSupportActionBar().setElevation(4);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                finish();

                Utils.back(ZodiacSingleSing.this);
            }
        });


    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();

        Utils.back(ZodiacSingleSing.this);
    }
}
