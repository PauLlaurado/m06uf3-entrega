package com.example.firebasetemplate;

import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdapterImages extends RecyclerView.Adapter<AdapterImages.ViewHolderImages> {
    ArrayList<Integer>images;
    String name;
    String contenido;
    Uri imagenperfil;

    public AdapterImages(ArrayList<Integer> images, String name,String contenido, Uri imagenperfil) {
        this.images = images;
        this.name = name;
        this.contenido=contenido;
        this.imagenperfil=imagenperfil;
    }

    @Override
    public ViewHolderImages onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_post,null,false);
        return new ViewHolderImages(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderImages holder, int position) {
    holder.textViewname.setText(name);
    holder.imageView.setImageResource(images.get(position));
    holder.textViewcontenido.setText("contenido");
    holder.imageViewperfil.setImageURI(imagenperfil);
    }

    @Override
    public int getItemCount() {
        return images.size();
    }

    public class ViewHolderImages extends RecyclerView.ViewHolder {
        TextView textViewname;
        TextView textViewcontenido;
        ImageView imageView;
        ImageView imageViewperfil;

        public ViewHolderImages(@NonNull View itemView) {
            super(itemView);
            textViewname=itemView.findViewById(R.id.autor);
            imageView=itemView.findViewById(R.id.imagen);
            textViewcontenido=itemView.findViewById(R.id.contenido);
            imageViewperfil=itemView.findViewById(R.id.autorFoto);

        }
    }
}
