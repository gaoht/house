package com.freelxl.baselibrary.a;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ImageView;
import android.widget.TextView;

public class b
{
  private final SparseArray<View> a;
  private int b;
  private View c;
  
  private b(Context paramContext, ViewGroup paramViewGroup, int paramInt1, int paramInt2)
  {
    this.b = paramInt2;
    this.a = new SparseArray();
    this.c = LayoutInflater.from(paramContext).inflate(paramInt1, paramViewGroup, false);
    this.c.setTag(this);
  }
  
  public static b get(Context paramContext, View paramView, ViewGroup paramViewGroup, int paramInt1, int paramInt2)
  {
    if (paramView == null) {
      return new b(paramContext, paramViewGroup, paramInt1, paramInt2);
    }
    return (b)paramView.getTag();
  }
  
  public b drawableLeft(Context paramContext, int paramInt1, int paramInt2)
  {
    paramContext = paramContext.getResources().getDrawable(paramInt2);
    paramContext.setBounds(0, 0, paramContext.getMinimumWidth(), paramContext.getMinimumHeight());
    ((TextView)getView(paramInt1)).setCompoundDrawables(paramContext, null, null, null);
    return this;
  }
  
  public View getConvertView()
  {
    return this.c;
  }
  
  public int getPosition()
  {
    return this.b;
  }
  
  public <T extends View> T getView(int paramInt)
  {
    View localView2 = (View)this.a.get(paramInt);
    View localView1 = localView2;
    if (localView2 == null)
    {
      localView1 = this.c.findViewById(paramInt);
      this.a.put(paramInt, localView1);
    }
    return localView1;
  }
  
  public b setBackgroundColor(int paramInt1, int paramInt2)
  {
    getView(paramInt1).setBackgroundColor(paramInt2);
    return this;
  }
  
  public b setBackgroundResource(int paramInt1, int paramInt2)
  {
    getView(paramInt1).setBackgroundResource(paramInt2);
    return this;
  }
  
  public b setChecked(int paramInt, boolean paramBoolean)
  {
    ((CompoundButton)getView(paramInt)).setChecked(paramBoolean);
    return this;
  }
  
  public b setEnabled(int paramInt, boolean paramBoolean)
  {
    getView(paramInt).setEnabled(paramBoolean);
    return this;
  }
  
  public b setImageBitmap(int paramInt, Bitmap paramBitmap)
  {
    ((ImageView)getView(paramInt)).setImageBitmap(paramBitmap);
    return this;
  }
  
  public b setImageResource(int paramInt1, int paramInt2)
  {
    ((ImageView)getView(paramInt1)).setImageResource(paramInt2);
    return this;
  }
  
  public b setOnCheckedChangeListener(int paramInt, CompoundButton.OnCheckedChangeListener paramOnCheckedChangeListener)
  {
    ((CompoundButton)getView(paramInt)).setOnCheckedChangeListener(paramOnCheckedChangeListener);
    return this;
  }
  
  public b setOnClickListener(int paramInt, View.OnClickListener paramOnClickListener)
  {
    getView(paramInt).setOnClickListener(paramOnClickListener);
    return this;
  }
  
  public b setTag(int paramInt1, int paramInt2, Object paramObject)
  {
    getView(paramInt1).setTag(paramInt2, paramObject);
    return this;
  }
  
  public b setTag(int paramInt, Object paramObject)
  {
    getView(paramInt).setTag(paramObject);
    return this;
  }
  
  public b setText(int paramInt, String paramString)
  {
    ((TextView)getView(paramInt)).setText(paramString);
    return this;
  }
  
  public b setTextColor(int paramInt1, int paramInt2)
  {
    ((TextView)getView(paramInt1)).setTextColor(paramInt2);
    return this;
  }
  
  public b setVisibility(int paramInt1, int paramInt2)
  {
    getView(paramInt1).setVisibility(paramInt2);
    return this;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/freelxl/baselibrary/a/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */