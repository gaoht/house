package com.ziroom.ziroomcustomer.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.R.styleable;

public class ExpandableTextView
  extends TextView
{
  private CharSequence a;
  private CharSequence b;
  private TextView.BufferType c;
  private boolean d = true;
  private int e;
  private Drawable f;
  private Drawable g;
  private int h;
  
  public ExpandableTextView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ExpandableTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.f = paramContext.getResources().getDrawable(2130839894);
    this.g = paramContext.getResources().getDrawable(2130838393);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.ExpandableTextView);
    this.e = paramContext.getInt(0, 10);
    paramContext.recycle();
    this.f.setBounds(0, 0, this.f.getMinimumWidth(), this.f.getMinimumHeight());
    this.g.setBounds(0, 0, this.g.getMinimumWidth(), this.g.getMinimumHeight());
    setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        ExpandableTextView.a(ExpandableTextView.this);
      }
    });
  }
  
  private CharSequence a(CharSequence paramCharSequence)
  {
    if ((this.a != null) && (this.a.length() > this.e))
    {
      this.h = 1;
      return new SpannableStringBuilder(this.a, 0, this.e + 1).append("....");
    }
    this.h = 0;
    return this.a;
  }
  
  private void a()
  {
    Drawable localDrawable;
    if (this.h == 1)
    {
      if (!this.d)
      {
        localDrawable = this.f;
        setCompoundDrawables(null, null, localDrawable, null);
      }
    }
    else {
      if (this.d) {
        break label60;
      }
    }
    label60:
    for (boolean bool = true;; bool = false)
    {
      this.d = bool;
      b();
      requestFocusFromTouch();
      return;
      localDrawable = this.g;
      break;
    }
  }
  
  private void b()
  {
    super.setText(getDisplayableText(), this.c);
  }
  
  private CharSequence getDisplayableText()
  {
    if (this.d) {
      return this.b;
    }
    return this.a;
  }
  
  public CharSequence getOriginalText()
  {
    return this.a;
  }
  
  public int getTrimLength()
  {
    return this.e;
  }
  
  public int getType()
  {
    return this.h;
  }
  
  public void setText(CharSequence paramCharSequence, TextView.BufferType paramBufferType)
  {
    this.a = paramCharSequence;
    this.b = a(paramCharSequence);
    this.c = paramBufferType;
    b();
  }
  
  public void setTrimLength(int paramInt)
  {
    this.e = paramInt;
    this.b = a(this.a);
    b();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/widget/ExpandableTextView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */