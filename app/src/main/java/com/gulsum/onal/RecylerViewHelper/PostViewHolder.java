package com.gulsum.onal.RecylerViewHelper;

import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.Timestamp;
import com.gulsum.onal.R;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import java.util.Calendar;

import de.hdodenhof.circleimageview.CircleImageView;

public class PostViewHolder extends RecyclerView.ViewHolder {
    public PostViewHolder(@NonNull View itemView) {
        super(itemView);

    }
    CircleImageView profileImage = (CircleImageView)itemView.findViewById(R.id.profileImage);
    TextView userName = (TextView)itemView.findViewById(R.id.username);
    TextView mainText = (TextView)itemView.findViewById(R.id.mainText);
    TextView timeAgo = (TextView)itemView.findViewById(R.id.time);
    TextView title = (TextView)itemView.findViewById(R.id.title);
    Button readMore = (Button)itemView.findViewById(R.id.readMore) ;
    ProgressBar progres = (ProgressBar)itemView.findViewById(R.id.progres);

    public void setUserName(String name){
        userName.setText(name);
    }
    public void setProfileImage(String image){
        Picasso.get().load(image).resize(256,256).placeholder(android.R.color.darker_gray).centerCrop().centerCrop().into(profileImage, new Callback() {
            @Override
            public void onSuccess() {
                progres.setVisibility(View.GONE);
            }

            @Override
            public void onError(Exception e) {

            }
        });
    }
    public void setMainText(String text){
        mainText.setText(text);
    }
    public void setTitle(String te){
        title.setText(te);
    }

    public  void setTimeAgo(Timestamp _time) {
        if (_time!=null){
            long time =_time.getSeconds();

            int SECOND_MILLIS = 1000;
            int MINUTE_MILLIS = 60 * SECOND_MILLIS;
            int HOUR_MILLIS = 60 * MINUTE_MILLIS;
            final int DAY_MILLIS = 24 * HOUR_MILLIS;
            if (time < 1000000000000L) {
                // if timestamp given in seconds, convert to millis
                time *= 1000;
            }

            long now = Calendar.getInstance().getTimeInMillis();
            if (time > now || time <= 0) {
                timeAgo.setText("");
            }

            // TODO: localize
            final long diff = now - time;
            if (diff < MINUTE_MILLIS) {
                timeAgo.setText("şimdi");
            } else if (diff < 2 * MINUTE_MILLIS) {
                timeAgo.setText("Birkaç dk önce");
            } else if (diff < 50 * MINUTE_MILLIS) {
                String _Time =String.valueOf(diff / MINUTE_MILLIS) + " dakika önce";
                timeAgo.setText(_Time);
            } else if (diff < 90 * MINUTE_MILLIS) {
                timeAgo.setText("bir saat önce");
            } else if (diff < 24 * HOUR_MILLIS) {
                String _Time =String.valueOf(diff / HOUR_MILLIS) + " saat önce";
                timeAgo.setText(_Time);

            } else if (diff < 48 * HOUR_MILLIS) {
                timeAgo.setText("dün");
            } else {
                String _Time =String.valueOf(diff / DAY_MILLIS)+ " gün önce";
                timeAgo.setText(_Time);

            }
        }

    }

}
