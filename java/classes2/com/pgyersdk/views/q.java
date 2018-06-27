package com.pgyersdk.views;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class q
  extends g
{
  public q(Context paramContext)
  {
    super(paramContext);
  }
  
  public q(Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
  }
  
  protected View a(Context paramContext)
  {
    LinearLayout localLinearLayout = new LinearLayout(paramContext);
    localLinearLayout.setOrientation(1);
    localLinearLayout.setBackgroundColor(-1);
    localLinearLayout.setOnTouchListener(this.q);
    a(paramContext, localLinearLayout);
    this.b.setVisibility(8);
    return localLinearLayout;
  }
  
  protected View b(Context paramContext)
  {
    LinearLayout localLinearLayout = new LinearLayout(paramContext);
    localLinearLayout.setOrientation(1);
    localLinearLayout.setBackgroundColor(-1);
    localLinearLayout.setOnTouchListener(this.q);
    b(paramContext, localLinearLayout);
    this.b.setVisibility(8);
    return localLinearLayout;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/pgyersdk/views/q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */