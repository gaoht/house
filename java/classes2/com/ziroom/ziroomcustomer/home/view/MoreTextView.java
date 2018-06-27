package com.ziroom.ziroomcustomer.home.view;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.view.animation.Transformation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.R.styleable;

public class MoreTextView
  extends LinearLayout
{
  protected TextView a;
  protected ImageView b;
  protected float c;
  protected int d;
  protected String e;
  public int f = -16777216;
  public int g = 12;
  public int h = 3;
  
  public MoreTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
    a(paramContext, paramAttributeSet);
    b();
  }
  
  public static int dip2px(Context paramContext, float paramFloat)
  {
    return (int)(paramContext.getResources().getDisplayMetrics().density * paramFloat + 0.5F);
  }
  
  protected void a()
  {
    setOrientation(1);
    setGravity(5);
    this.a = new TextView(getContext());
    addView(this.a, -1, -2);
    this.b = new ImageView(getContext());
    int i = dip2px(getContext(), 5.0F);
    this.b.setPadding(i, i, i, i);
    this.b.setImageResource(2130837593);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
    addView(this.b, localLayoutParams);
  }
  
  protected void a(int paramInt1, float paramFloat, final int paramInt2, String paramString)
  {
    this.a.setTextColor(paramInt1);
    this.a.setTextSize(0, paramFloat);
    this.a.setText(paramString);
    this.a.setHeight(this.a.getLineHeight() * paramInt2);
    post(new Runnable()
    {
      public void run()
      {
        ImageView localImageView = MoreTextView.this.b;
        if (MoreTextView.this.a.getLineCount() > paramInt2) {}
        for (int i = 0;; i = 8)
        {
          localImageView.setVisibility(i);
          return;
        }
      }
    });
  }
  
  protected void a(Context paramContext, AttributeSet paramAttributeSet)
  {
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.MoreTextStyle);
    int i = paramContext.getColor(1, this.f);
    this.c = paramContext.getDimensionPixelSize(0, this.g);
    this.d = paramContext.getInt(2, this.h);
    this.e = paramContext.getString(3);
    a(i, this.c, this.d, this.e);
    paramContext.recycle();
  }
  
  protected void b()
  {
    setOnClickListener(new View.OnClickListener()
    {
      boolean a;
      
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        boolean bool;
        final int j;
        final int i;
        if (!this.a)
        {
          bool = true;
          this.a = bool;
          MoreTextView.this.a.clearAnimation();
          j = MoreTextView.this.a.getHeight();
          if (!this.a) {
            break label157;
          }
          i = MoreTextView.this.a.getLineHeight();
          int k = MoreTextView.this.a.getLineCount();
          paramAnonymousView = new RotateAnimation(0.0F, 180.0F, 1, 0.5F, 1, 0.5F);
          paramAnonymousView.setDuration('Ş');
          paramAnonymousView.setFillAfter(true);
          MoreTextView.this.b.startAnimation(paramAnonymousView);
          i = i * k - j;
        }
        for (;;)
        {
          paramAnonymousView = new Animation()
          {
            protected void applyTransformation(float paramAnonymous2Float, Transformation paramAnonymous2Transformation)
            {
              MoreTextView.this.a.setHeight((int)(j + i * paramAnonymous2Float));
            }
          };
          paramAnonymousView.setDuration('Ş');
          MoreTextView.this.a.startAnimation(paramAnonymousView);
          return;
          bool = false;
          break;
          label157:
          i = MoreTextView.this.a.getLineHeight() * MoreTextView.this.d - j;
          paramAnonymousView = new RotateAnimation(180.0F, 0.0F, 1, 0.5F, 1, 0.5F);
          paramAnonymousView.setDuration('Ş');
          paramAnonymousView.setFillAfter(true);
          MoreTextView.this.b.startAnimation(paramAnonymousView);
        }
      }
    });
  }
  
  public TextView getTextView()
  {
    return this.a;
  }
  
  public void setText(CharSequence paramCharSequence)
  {
    this.a.setText(paramCharSequence);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/home/view/MoreTextView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */