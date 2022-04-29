package com.example.firebasetemplate;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.navigation.ActionOnlyNavDirections;
import androidx.navigation.NavDirections;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.HashMap;

public class NavigationDirections {
  private NavigationDirections() {
  }

  @NonNull
  public static NavDirections actionPostsHomeFragmentToNewPostFragment() {
    return new ActionOnlyNavDirections(R.id.action_postsHomeFragment_to_newPostFragment);
  }

  @NonNull
  public static NavDirections actionPostsHomeFragmentToSignOutFragment() {
    return new ActionOnlyNavDirections(R.id.action_postsHomeFragment_to_signOutFragment);
  }

  @NonNull
  public static NavDirections actionPostsHomeFragmentToProfileFragment() {
    return new ActionOnlyNavDirections(R.id.action_postsHomeFragment_to_profileFragment);
  }

  @NonNull
  public static ActionPostsHomeFragmentToViewPostFragment actionPostsHomeFragmentToViewPostFragment(
      ) {
    return new ActionPostsHomeFragmentToViewPostFragment();
  }

  public static class ActionPostsHomeFragmentToViewPostFragment implements NavDirections {
    private final HashMap arguments = new HashMap();

    private ActionPostsHomeFragmentToViewPostFragment() {
    }

    @NonNull
    @SuppressWarnings("unchecked")
    public ActionPostsHomeFragmentToViewPostFragment setPostid(@Nullable String postid) {
      this.arguments.put("postid", postid);
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    @NonNull
    public Bundle getArguments() {
      Bundle __result = new Bundle();
      if (arguments.containsKey("postid")) {
        String postid = (String) arguments.get("postid");
        __result.putString("postid", postid);
      } else {
        __result.putString("postid", null);
      }
      return __result;
    }

    @Override
    public int getActionId() {
      return R.id.action_postsHomeFragment_to_viewPostFragment;
    }

    @SuppressWarnings("unchecked")
    @Nullable
    public String getPostid() {
      return (String) arguments.get("postid");
    }

    @Override
    public boolean equals(Object object) {
      if (this == object) {
          return true;
      }
      if (object == null || getClass() != object.getClass()) {
          return false;
      }
      ActionPostsHomeFragmentToViewPostFragment that = (ActionPostsHomeFragmentToViewPostFragment) object;
      if (arguments.containsKey("postid") != that.arguments.containsKey("postid")) {
        return false;
      }
      if (getPostid() != null ? !getPostid().equals(that.getPostid()) : that.getPostid() != null) {
        return false;
      }
      if (getActionId() != that.getActionId()) {
        return false;
      }
      return true;
    }

    @Override
    public int hashCode() {
      int result = 1;
      result = 31 * result + (getPostid() != null ? getPostid().hashCode() : 0);
      result = 31 * result + getActionId();
      return result;
    }

    @Override
    public String toString() {
      return "ActionPostsHomeFragmentToViewPostFragment(actionId=" + getActionId() + "){"
          + "postid=" + getPostid()
          + "}";
    }
  }
}
