package com.example.firebasetemplate;

import androidx.annotation.NonNull;
import androidx.navigation.ActionOnlyNavDirections;
import androidx.navigation.NavDirections;

public class RegisterFragmentDirections {
  private RegisterFragmentDirections() {
  }

  @NonNull
  public static NavDirections actionRegisterFragmentToPostsHomeFragment() {
    return new ActionOnlyNavDirections(R.id.action_registerFragment_to_postsHomeFragment);
  }
}
