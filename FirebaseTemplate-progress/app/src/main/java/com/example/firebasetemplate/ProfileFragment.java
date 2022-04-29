package com.example.firebasetemplate;

import android.os.Bundle;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RelativeLayout;

import com.bumptech.glide.Glide;
import com.example.firebasetemplate.databinding.FragmentProfileBinding;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserInfo;
import com.google.firebase.auth.UserProfileChangeRequest;


public class ProfileFragment extends AppFragment {
    private FragmentProfileBinding binding;
    private EditText EditTextemail, EditTextusername, EditTextpass;
    private Button update,save;
    private ImageButton imageButtonprofile;
    private String id,email,username;


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_profile, container, false).getRootView();






        return (binding = FragmentProfileBinding.inflate(inflater, container, false)).getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if (user != null) {
            for (UserInfo profile : user.getProviderData()) {


                username = profile.getDisplayName();
                email = profile.getEmail();

            }
        }




        super.onViewCreated(view, savedInstanceState);
        binding.imageprofile.setOnClickListener(v -> seleccionarImagen());

        appViewModel.uriImagenSeleccionada.observe(getViewLifecycleOwner(), uri -> {
            Glide.with(this).load(uri).into(binding.imageprofile);
        });

        EditTextemail =view.findViewById(R.id.email2);
        EditTextusername =view.findViewById(R.id.username);
        EditTextpass =view.findViewById(R.id.pass);
        imageButtonprofile=view.findViewById(R.id.imageprofile);
        update=view.findViewById(R.id.update);
        save=view.findViewById(R.id.save);

        EditTextusername.setText(username);
        EditTextemail.setText(email);

        ConstraintLayout.LayoutParams params = (ConstraintLayout.LayoutParams) imageButtonprofile.getLayoutParams();

        params.height=225;
        params.width=225;

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                save.setVisibility(View.VISIBLE);
                save.setEnabled(true);
                EditTextpass.setEnabled(true);
                EditTextemail.setEnabled(true);
                EditTextusername.setEnabled(true);


            }
        });
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance().getCurrentUser().updateEmail(EditTextemail.getText().toString());
                FirebaseAuth.getInstance().getCurrentUser().updatePassword(EditTextpass.getText().toString());
                UserProfileChangeRequest profilename=new UserProfileChangeRequest.Builder().setDisplayName(EditTextusername.getText().toString()).build();
                UserProfileChangeRequest profileimage=new UserProfileChangeRequest.Builder().setPhotoUri(appViewModel.uriImagenSeleccionada.getValue()).build();

                FirebaseAuth.getInstance().getCurrentUser().updateProfile(profilename);
                FirebaseAuth.getInstance().getCurrentUser().updateProfile(profileimage);
                save.setVisibility(View.GONE);
                save.setEnabled(false);

            }
        });
    }
    private void seleccionarImagen() {
        galeria.launch("image/*");
    }

    private final ActivityResultLauncher<String> galeria = registerForActivityResult(new ActivityResultContracts.GetContent(), uri -> {
        appViewModel.setUriImagenSeleccionada(uri);
        id=uri.getLastPathSegment();

    });


}