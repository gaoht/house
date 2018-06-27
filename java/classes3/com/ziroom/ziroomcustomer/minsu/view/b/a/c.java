package com.ziroom.ziroomcustomer.minsu.view.b.a;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v7.widget.RecyclerView.u;
import android.text.util.Linkify;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.widget.Checkable;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RatingBar;
import android.widget.TextView;

public class c
  extends RecyclerView.u
{
  private SparseArray<View> a;
  private int b;
  private View c;
  private Context d;
  private int e;
  
  public c(Context paramContext, View paramView)
  {
    super(paramView);
    this.d = paramContext;
    this.c = paramView;
    this.a = new SparseArray();
  }
  
  public c(Context paramContext, View paramView, ViewGroup paramViewGroup, int paramInt)
  {
    super(paramView);
    this.d = paramContext;
    this.c = paramView;
    this.b = paramInt;
    this.a = new SparseArray();
    this.c.setTag(this);
  }
  
  public static c get(Context paramContext, View paramView)
  {
    return new c(paramContext, paramView);
  }
  
  public static c get(Context paramContext, View paramView, ViewGroup paramViewGroup, int paramInt1, int paramInt2)
  {
    if (paramView == null)
    {
      paramContext = new c(paramContext, LayoutInflater.from(paramContext).inflate(paramInt1, paramViewGroup, false), paramViewGroup, paramInt2);
      paramContext.e = paramInt1;
      return paramContext;
    }
    paramContext = (c)paramView.getTag();
    paramContext.b = paramInt2;
    return paramContext;
  }
  
  public static c get(Context paramContext, ViewGroup paramViewGroup, int paramInt)
  {
    return new c(paramContext, LayoutInflater.from(paramContext).inflate(paramInt, paramViewGroup, false));
  }
  
  public View getConvertView()
  {
    return this.c;
  }
  
  public int getLayoutId()
  {
    return this.e;
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
  
  public c linkify(int paramInt)
  {
    Linkify.addLinks((TextView)getView(paramInt), 15);
    return this;
  }
  
  @SuppressLint({"NewApi"})
  public c setAlpha(int paramInt, float paramFloat)
  {
    if (Build.VERSION.SDK_INT >= 11)
    {
      getView(paramInt).setAlpha(paramFloat);
      return this;
    }
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(paramFloat, paramFloat);
    localAlphaAnimation.setDuration(0L);
    localAlphaAnimation.setFillAfter(true);
    getView(paramInt).startAnimation(localAlphaAnimation);
    return this;
  }
  
  public c setBackgroundColor(int paramInt1, int paramInt2)
  {
    getView(paramInt1).setBackgroundColor(paramInt2);
    return this;
  }
  
  public c setBackgroundRes(int paramInt1, int paramInt2)
  {
    getView(paramInt1).setBackgroundResource(paramInt2);
    return this;
  }
  
  public c setChecked(int paramInt, boolean paramBoolean)
  {
    ((Checkable)getView(paramInt)).setChecked(paramBoolean);
    return this;
  }
  
  public c setImageBitmap(int paramInt, Bitmap paramBitmap)
  {
    ((ImageView)getView(paramInt)).setImageBitmap(paramBitmap);
    return this;
  }
  
  public c setImageDrawable(int paramInt, Drawable paramDrawable)
  {
    ((ImageView)getView(paramInt)).setImageDrawable(paramDrawable);
    return this;
  }
  
  public c setImageResource(int paramInt1, int paramInt2)
  {
    ((ImageView)getView(paramInt1)).setImageResource(paramInt2);
    return this;
  }
  
  public c setMax(int paramInt1, int paramInt2)
  {
    ((ProgressBar)getView(paramInt1)).setMax(paramInt2);
    return this;
  }
  
  public c setOnClickListener(int paramInt, View.OnClickListener paramOnClickListener)
  {
    getView(paramInt).setOnClickListener(paramOnClickListener);
    return this;
  }
  
  public c setOnLongClickListener(int paramInt, View.OnLongClickListener paramOnLongClickListener)
  {
    getView(paramInt).setOnLongClickListener(paramOnLongClickListener);
    return this;
  }
  
  public c setOnTouchListener(int paramInt, View.OnTouchListener paramOnTouchListener)
  {
    getView(paramInt).setOnTouchListener(paramOnTouchListener);
    return this;
  }
  
  public c setProgress(int paramInt1, int paramInt2)
  {
    ((ProgressBar)getView(paramInt1)).setProgress(paramInt2);
    return this;
  }
  
  public c setProgress(int paramInt1, int paramInt2, int paramInt3)
  {
    ProgressBar localProgressBar = (ProgressBar)getView(paramInt1);
    localProgressBar.setMax(paramInt3);
    localProgressBar.setProgress(paramInt2);
    return this;
  }
  
  public c setRating(int paramInt, float paramFloat)
  {
    ((RatingBar)getView(paramInt)).setRating(paramFloat);
    return this;
  }
  
  public c setRating(int paramInt1, float paramFloat, int paramInt2)
  {
    RatingBar localRatingBar = (RatingBar)getView(paramInt1);
    localRatingBar.setMax(paramInt2);
    localRatingBar.setRating(paramFloat);
    return this;
  }
  
  public c setTag(int paramInt1, int paramInt2, Object paramObject)
  {
    getView(paramInt1).setTag(paramInt2, paramObject);
    return this;
  }
  
  public c setTag(int paramInt, Object paramObject)
  {
    getView(paramInt).setTag(paramObject);
    return this;
  }
  
  public c setText(int paramInt, String paramString)
  {
    ((TextView)getView(paramInt)).setText(paramString);
    return this;
  }
  
  public c setTextColor(int paramInt1, int paramInt2)
  {
    ((TextView)getView(paramInt1)).setTextColor(paramInt2);
    return this;
  }
  
  public c setTextColorRes(int paramInt1, int paramInt2)
  {
    ((TextView)getView(paramInt1)).setTextColor(this.d.getResources().getColor(paramInt2));
    return this;
  }
  
  public c setTypeface(Typeface paramTypeface, int... paramVarArgs)
  {
    int j = paramVarArgs.length;
    int i = 0;
    while (i < j)
    {
      TextView localTextView = (TextView)getView(paramVarArgs[i]);
      localTextView.setTypeface(paramTypeface);
      localTextView.setPaintFlags(localTextView.getPaintFlags() | 0x80);
      i += 1;
    }
    return this;
  }
  
  public c setVisibility(int paramInt1, int paramInt2)
  {
    getView(paramInt1).setVisibility(paramInt2);
    return this;
  }
  
  public c setVisible(int paramInt, boolean paramBoolean)
  {
    View localView = getView(paramInt);
    if (paramBoolean) {}
    for (paramInt = 0;; paramInt = 8)
    {
      localView.setVisibility(paramInt);
      return this;
    }
  }
  
  public void updatePosition(int paramInt)
  {
    this.b = paramInt;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/view/b/a/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */