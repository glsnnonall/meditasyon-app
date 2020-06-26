package com.gulsum.onal.Menu;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;
import com.gulsum.onal.Helper.PostModel;
import com.gulsum.onal.R;
import com.gulsum.onal.RecylerViewHelper.PostAdapter;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class RecentFragment extends Fragment {


    RecyclerView recyclerView;
    PostModel post;
    ArrayList<PostModel> model;
    private RecyclerView.LayoutManager mLayoutManager;
    PostAdapter adapter ;
    View view;
    public RecentFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        view  = inflater.inflate(R.layout.fragment_recent, container, false);

        getRecentPost();
        return view;
    }

    void getRecentPost(){
        model = new ArrayList<>();
        CollectionReference ref = FirebaseFirestore.getInstance().collection("recentPost");
        ref.get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if (task.isSuccessful()){
                    for (DocumentSnapshot doc : task.getResult().getDocuments()){
                        post = doc.toObject(PostModel.class);
                        model.add(post);
                        System.out.println("DEBUG:: " + post.getMainText()+"\n"+post.getSenderName());
                    }
                }


                recyclerView = (RecyclerView)view.findViewById(R.id.mainRec);
                recyclerView.setHasFixedSize(true);
                mLayoutManager = new LinearLayoutManager(getContext());
                adapter = new PostAdapter(model,getContext());
                recyclerView.setAdapter(adapter);
                recyclerView.setLayoutManager(mLayoutManager);
            }
        });
    }


}
