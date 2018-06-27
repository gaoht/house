package com.facebook.common.lifecycle;

import android.view.View;

public abstract interface AttachDetachListener
{
  public abstract void onAttachToView(View paramView);
  
  public abstract void onDetachFromView(View paramView);
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/facebook/common/lifecycle/AttachDetachListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */