package com.ziroom.ziroomcustomer.newServiceList.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.R.styleable;

public class RatingStar
  extends LinearLayout
{
  private Context a;
  private a b;
  private int c = 0;
  private ImageView d;
  private ImageView e;
  private ImageView f;
  private ImageView g;
  private ImageView h;
  private Drawable i;
  private Drawable j;
  private float k;
  private float l;
  private float m;
  private boolean n;
  
  public RatingStar(Context paramContext)
  {
    super(paramContext);
    this.a = paramContext;
  }
  
  public RatingStar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.a = paramContext;
    setAttributes(paramAttributeSet);
  }
  
  private void a()
  {
    this.d.setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        RatingStar.a(RatingStar.this, 1);
      }
    });
    this.e.setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        RatingStar.a(RatingStar.this, 2);
      }
    });
    this.f.setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        RatingStar.a(RatingStar.this, 3);
      }
    });
    this.g.setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        RatingStar.a(RatingStar.this, 4);
      }
    });
    this.h.setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        RatingStar.a(RatingStar.this, 5);
      }
    });
  }
  
  private void a(int paramInt)
  {
    if (this.n)
    {
      this.c = paramInt;
      if (paramInt == 1)
      {
        this.d.setImageDrawable(this.j);
        this.e.setImageDrawable(this.i);
        this.f.setImageDrawable(this.i);
        this.g.setImageDrawable(this.i);
        this.h.setImageDrawable(this.i);
        if (this.b != null) {
          this.b.starScore(this.c);
        }
      }
    }
    do
    {
      return;
      if (paramInt == 2)
      {
        this.d.setImageDrawable(this.j);
        this.e.setImageDrawable(this.j);
        this.f.setImageDrawable(this.i);
        this.g.setImageDrawable(this.i);
        this.h.setImageDrawable(this.i);
        break;
      }
      if (paramInt == 3)
      {
        this.d.setImageDrawable(this.j);
        this.e.setImageDrawable(this.j);
        this.f.setImageDrawable(this.j);
        this.g.setImageDrawable(this.i);
        this.h.setImageDrawable(this.i);
        break;
      }
      if (paramInt == 4)
      {
        this.d.setImageDrawable(this.j);
        this.e.setImageDrawable(this.j);
        this.f.setImageDrawable(this.j);
        this.g.setImageDrawable(this.j);
        this.h.setImageDrawable(this.i);
        break;
      }
      if (paramInt != 5) {
        break;
      }
      this.d.setImageDrawable(this.j);
      this.e.setImageDrawable(this.j);
      this.f.setImageDrawable(this.j);
      this.g.setImageDrawable(this.j);
      this.h.setImageDrawable(this.j);
      break;
      this.c = paramInt;
      if (paramInt == 1)
      {
        this.d.setImageDrawable(this.j);
        this.e.setImageDrawable(this.i);
        this.f.setImageDrawable(this.i);
        this.g.setImageDrawable(this.i);
        this.h.setImageDrawable(this.i);
        return;
      }
      if (paramInt == 2)
      {
        this.d.setImageDrawable(this.j);
        this.e.setImageDrawable(this.j);
        this.f.setImageDrawable(this.i);
        this.g.setImageDrawable(this.i);
        this.h.setImageDrawable(this.i);
        return;
      }
      if (paramInt == 3)
      {
        this.d.setImageDrawable(this.j);
        this.e.setImageDrawable(this.j);
        this.f.setImageDrawable(this.j);
        this.g.setImageDrawable(this.i);
        this.h.setImageDrawable(this.i);
        return;
      }
      if (paramInt == 4)
      {
        this.d.setImageDrawable(this.j);
        this.e.setImageDrawable(this.j);
        this.f.setImageDrawable(this.j);
        this.g.setImageDrawable(this.j);
        this.h.setImageDrawable(this.i);
        return;
      }
    } while (paramInt != 5);
    this.d.setImageDrawable(this.j);
    this.e.setImageDrawable(this.j);
    this.f.setImageDrawable(this.j);
    this.g.setImageDrawable(this.j);
    this.h.setImageDrawable(this.j);
  }
  
  private void a(TypedArray paramTypedArray)
  {
    this.k = paramTypedArray.getDimension(4, 0.0F);
    this.l = paramTypedArray.getDimension(2, 24.0F);
    this.m = paramTypedArray.getDimension(3, 24.0F);
    this.i = paramTypedArray.getDrawable(0);
    this.j = paramTypedArray.getDrawable(1);
    this.n = paramTypedArray.getBoolean(5, true);
    setOrientation(0);
    this.d = new ImageView(this.a);
    a(this.d, true);
    this.e = new ImageView(this.a);
    a(this.e, true);
    this.f = new ImageView(this.a);
    a(this.f, true);
    this.g = new ImageView(this.a);
    a(this.g, true);
    this.h = new ImageView(this.a);
    a(this.h, false);
    if (this.n) {
      a();
    }
  }
  
  private void a(ImageView paramImageView, boolean paramBoolean)
  {
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams((int)this.l, (int)this.m);
    if (paramBoolean) {
      localLayoutParams.rightMargin = ((int)this.k);
    }
    paramImageView.setImageDrawable(this.i);
    addView(paramImageView, localLayoutParams);
  }
  
  private void setAttributes(AttributeSet paramAttributeSet)
  {
    paramAttributeSet = this.a.obtainStyledAttributes(paramAttributeSet, R.styleable.ZRCustomRatingStar);
    a(paramAttributeSet);
    paramAttributeSet.recycle();
  }
  
  public boolean isImgIsClick()
  {
    return this.n;
  }
  
  public void setImgIsClick(boolean paramBoolean)
  {
    this.n = paramBoolean;
  }
  
  public void setOnStarScoreListener(a parama)
  {
    this.b = parama;
  }
  
  public void setStarScore(int paramInt)
  {
    a(paramInt);
  }
  
  public static abstract interface a
  {
    public abstract void starScore(int paramInt);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newServiceList/view/RatingStar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */