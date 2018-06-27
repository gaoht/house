package com.ziroom.ziroomcustomer.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.base.ApplicationEx;

public class LinearLayoutForListView
  extends LinearLayout
{
  private BaseAdapter a;
  private a b;
  private Context c;
  private boolean d = true;
  private int e;
  private int f;
  
  public LinearLayoutForListView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public LinearLayoutForListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public LinearLayoutForListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.c = paramContext;
  }
  
  public void setAdapter(BaseAdapter paramBaseAdapter)
  {
    this.a = paramBaseAdapter;
    removeAllViews();
    if (this.a.getCount() < 1) {
      return;
    }
    final int i = 0;
    label23:
    if (i < this.a.getCount())
    {
      paramBaseAdapter = this.a.getView(i, null, null);
      if (this.b != null) {
        paramBaseAdapter.setOnClickListener(new View.OnClickListener()
        {
          @Instrumented
          public void onClick(View paramAnonymousView)
          {
            VdsAgent.onClick(this, paramAnonymousView);
            LinearLayoutForListView.a(LinearLayoutForListView.this).onItemClick(i);
          }
        });
      }
      addView(paramBaseAdapter);
      if (this.d) {
        break label84;
      }
    }
    for (;;)
    {
      i += 1;
      break label23;
      break;
      label84:
      paramBaseAdapter = new View(ApplicationEx.c);
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, 2);
      localLayoutParams.leftMargin = this.e;
      localLayoutParams.rightMargin = this.f;
      paramBaseAdapter.setLayoutParams(localLayoutParams);
      paramBaseAdapter.setBackgroundColor(Color.parseColor("#eeeeee"));
      if (i != this.a.getCount() - 1) {
        addView(paramBaseAdapter);
      }
    }
  }
  
  public void setDividerIndent(int paramInt1, int paramInt2)
  {
    float f1 = this.c.getResources().getDisplayMetrics().density;
    this.e = ((int)(paramInt1 * f1));
    this.f = ((int)(f1 * paramInt2));
  }
  
  public void setDividerVisibility(boolean paramBoolean)
  {
    this.d = paramBoolean;
  }
  
  public void setOnItemClickListener(a parama)
  {
    this.b = parama;
  }
  
  public static abstract interface a
  {
    public abstract void onItemClick(int paramInt);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/widget/LinearLayoutForListView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */