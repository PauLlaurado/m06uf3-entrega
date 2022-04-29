package com.example.firebasetemplate;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.firebasetemplate.databinding.FragmentPostsBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.ListResult;
import com.google.firebase.storage.StorageReference;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;


public class PostsMyFragment extends PostsHomeFragment  {
    private FragmentPostsBinding binding;
    StorageReference storageRef = FirebaseStorage.getInstance().getReference(FirebaseAuth.getInstance().getUid());
    private ArrayList<Integer> getImages = new ArrayList();
    RecyclerView recyclerView;
    AdapterImages adapter;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_posts, container, false);
        recyclerView = view.findViewById(R.id.postsRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
getImages.add(R.drawable.ic_baseline_add_a_photo_24);
getImages.add(R.drawable.like_on);
getImages.add(R.drawable.like_off);
getImages.add(R.drawable.ic_launcher_foreground);
getImages.add(R.drawable.ic_launcher_background);



        storageRef.listAll().addOnCompleteListener(new OnCompleteListener<ListResult>() {
            @Override
            public void onComplete(@NonNull Task<ListResult> task) {
                for (StorageReference prefix : task.getResult().getPrefixes()) {
                }
                for (StorageReference item : task.getResult().getPrefixes()) {
                    int imagefirebase = item.hashCode();
                    getImages.add(imagefirebase);
                }
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {

            }
        });



        adapter=new AdapterImages(getImages,FirebaseAuth.getInstance().getCurrentUser().getDisplayName(), "contenido",FirebaseAuth.getInstance().getCurrentUser().getPhotoUrl());
        recyclerView.setAdapter(adapter);




        binding = FragmentPostsBinding.inflate(inflater, container, false);
        binding.getRoot();

        return view;

    }






    @SuppressLint("WrongThread")
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        binding.fab.setOnClickListener(v -> navController.navigate(R.id.newPostFragment));
    }







}
