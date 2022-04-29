package com.example.firebasetemplate;

import androidx.annotation.NonNull;
import androidx.navigation.ActionOnlyNavDirections;
import androidx.navigation.NavDirections;

public class SignInFragmentDirections {
  private SignInFragmentDirections() {
  }

  @NonNull
  public static NavDirections actionSignInFragmentToRegisterFragment() {
    return new ActionOnlyNavDirections(R.id.action_signInFragment_to_registerFragment);
  }

  @NonNull
  public static NavDirections actionSignInFragmentToPostsHomeFragment() {
    return new ActionOnlyNavDirections(R.id.action_signInFragment_to_postsHomeFragment);
  }
}
