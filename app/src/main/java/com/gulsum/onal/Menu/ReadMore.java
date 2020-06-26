package com.gulsum.onal.Menu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.gulsum.onal.Helper.PostModel;
import com.gulsum.onal.R;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import de.hdodenhof.circleimageview.CircleImageView;

public class ReadMore extends AppCompatActivity {
    PostModel post;
    TextView title,name,mainText;
    CircleImageView circleImageView;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read_more);
        title = (TextView)findViewById(R.id.title);
        mainText = (TextView)findViewById(R.id.mainText);
        name = (TextView)findViewById(R.id.name);
        circleImageView = (CircleImageView) findViewById(R.id.profileImage);
        Bundle extras = getIntent().getExtras();
        Intent intentIncoming = getIntent();
        if(extras != null) {
            post = (PostModel) intentIncoming.getParcelableExtra("post");
            title.setText(post.getTitle());
            name.setText(post.getSenderName());
            mainText.setText(post.getMainText());
            Picasso.get().load(post.getProfileImage()).resize(256,256).centerCrop().placeholder(android.R.color.darker_gray)
                    .into(circleImageView, new Callback() {
                        @Override
                        public void onSuccess() {

                        }

                        @Override
                        public void onError(Exception e) {

                        }
                    });
        }
    }
}
