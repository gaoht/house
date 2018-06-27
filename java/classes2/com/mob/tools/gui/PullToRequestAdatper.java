package com.mob.tools.gui;

import android.content.Context;
import android.view.View;

public abstract class PullToRequestAdatper
{
  private Context context;
  private PullToRequestView parent;
  
  public PullToRequestAdatper(PullToRequestView paramPullToRequestView)
  {
    this.context = paramPullToRequestView.getContext();
    this.parent = paramPullToRequestView;
  }
  
  public abstract Scrollable getBodyView();
  
  public Context getContext()
  {
    return this.context;
  }
  
  public abstract View getFooterView();
  
  public abstract View getHeaderView();
  
  protected PullToRequestView getParent()
  {
    return this.parent;
  }
  
  public abstract boolean isPullDownReady();
  
  public abstract boolean isPullUpReady();
  
  public void notifyDataSetChanged()
  {
    this.parent.stopPulling();
  }
  
  public void onPullDown(int paramInt) {}
  
  public void onPullUp(int paramInt) {}
  
  public void onRefresh() {}
  
  public void onRequestNext() {}
  
  public void onReversed() {}
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/mob/tools/gui/PullToRequestAdatper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */