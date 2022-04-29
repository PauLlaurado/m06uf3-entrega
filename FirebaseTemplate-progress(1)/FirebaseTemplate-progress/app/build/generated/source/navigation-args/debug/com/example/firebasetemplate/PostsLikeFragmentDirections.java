package com.example.firebasetemplate;

import androidx.annotation.NonNull;
import androidx.navigation.NavDirections;

public class PostsLikeFragmentDirections {
  private PostsLikeFragmentDirections() {
  }

  @NonNull
  public static NavDirections actionPostsHomeFragmentToNewPostFragment() {
    return NavigationDirections.actionPostsHomeFragmentToNewPostFragment();
  }

  @NonNull
  public static NavDirections actionPostsHomeFragmentToSignOutFragment() {
    return NavigationDirections.actionPostsHomeFragmentToSignOutFragment();
  }

  @NonNull
  public static NavDirections actionPostsHomeFragmentToProfileFragment() {
    return NavigationDirections.actionPostsHomeFragmentToProfileFragment();
  }

  @NonNull
  public static NavigationDirections.ActionPostsHomeFragmentToViewPostFragment actionPostsHomeFragmentToViewPostFragment(
      ) {
    return NavigationDirections.actionPostsHomeFragmentToViewPostFragment();
  }
}
