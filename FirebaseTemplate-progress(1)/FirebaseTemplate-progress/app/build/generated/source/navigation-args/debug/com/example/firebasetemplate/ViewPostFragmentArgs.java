package com.example.firebasetemplate;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.SavedStateHandle;
import androidx.navigation.NavArgs;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.HashMap;

public class ViewPostFragmentArgs implements NavArgs {
  private final HashMap arguments = new HashMap();

  private ViewPostFragmentArgs() {
  }

  @SuppressWarnings("unchecked")
  private ViewPostFragmentArgs(HashMap argumentsMap) {
    this.arguments.putAll(argumentsMap);
  }

  @NonNull
  @SuppressWarnings("unchecked")
  public static ViewPostFragmentArgs fromBundle(@NonNull Bundle bundle) {
    ViewPostFragmentArgs __result = new ViewPostFragmentArgs();
    bundle.setClassLoader(ViewPostFragmentArgs.class.getClassLoader());
    if (bundle.containsKey("postid")) {
      String postid;
      postid = bundle.getString("postid");
      __result.arguments.put("postid", postid);
    } else {
      __result.arguments.put("postid", null);
    }
    return __result;
  }

  @NonNull
  @SuppressWarnings("unchecked")
  public static ViewPostFragmentArgs fromSavedStateHandle(
      @NonNull SavedStateHandle savedStateHandle) {
    ViewPostFragmentArgs __result = new ViewPostFragmentArgs();
    if (savedStateHandle.contains("postid")) {
      String postid;
      postid = savedStateHandle.get("postid");
      __result.arguments.put("postid", postid);
    } else {
      __result.arguments.put("postid", null);
    }
    return __result;
  }

  @SuppressWarnings("unchecked")
  @Nullable
  public String getPostid() {
    return (String) arguments.get("postid");
  }

  @SuppressWarnings("unchecked")
  @NonNull
  public Bundle toBundle() {
    Bundle __result = new Bundle();
    if (arguments.containsKey("postid")) {
      String postid = (String) arguments.get("postid");
      __result.putString("postid", postid);
    } else {
      __result.putString("postid", null);
    }
    return __result;
  }

  @SuppressWarnings("unchecked")
  @NonNull
  public SavedStateHandle toSavedStateHandle() {
    SavedStateHandle __result = new SavedStateHandle();
    if (arguments.containsKey("postid")) {
      String postid = (String) arguments.get("postid");
      __result.set("postid", postid);
    } else {
      __result.set("postid", null);
    }
    return __result;
  }

  @Override
  public boolean equals(Object object) {
    if (this == object) {
        return true;
    }
    if (object == null || getClass() != object.getClass()) {
        return false;
    }
    ViewPostFragmentArgs that = (ViewPostFragmentArgs) object;
    if (arguments.containsKey("postid") != that.arguments.containsKey("postid")) {
      return false;
    }
    if (getPostid() != null ? !getPostid().equals(that.getPostid()) : that.getPostid() != null) {
      return false;
    }
    return true;
  }

  @Override
  public int hashCode() {
    int result = 1;
    result = 31 * result + (getPostid() != null ? getPostid().hashCode() : 0);
    return result;
  }

  @Override
  public String toString() {
    return "ViewPostFragmentArgs{"
        + "postid=" + getPostid()
        + "}";
  }

  public static final class Builder {
    private final HashMap arguments = new HashMap();

    @SuppressWarnings("unchecked")
    public Builder(@NonNull ViewPostFragmentArgs original) {
      this.arguments.putAll(original.arguments);
    }

    public Builder() {
    }

    @NonNull
    public ViewPostFragmentArgs build() {
      ViewPostFragmentArgs result = new ViewPostFragmentArgs(arguments);
      return result;
    }

    @NonNull
    @SuppressWarnings("unchecked")
    public Builder setPostid(@Nullable String postid) {
      this.arguments.put("postid", postid);
      return this;
    }

    @SuppressWarnings({"unchecked","GetterOnBuilder"})
    @Nullable
    public String getPostid() {
      return (String) arguments.get("postid");
    }
  }
}
