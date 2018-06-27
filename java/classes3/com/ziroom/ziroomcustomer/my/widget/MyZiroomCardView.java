package com.ziroom.ziroomcustomer.my.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.text.SpannableString;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;

public class MyZiroomCardView
  extends LinearLayout
  implements View.OnClickListener
{
  View a;
  TextView b;
  TextView c;
  ImageView d;
  TextView e;
  TextView f;
  TextView g;
  LinearLayout h;
  TextView i;
  TextView j;
  private Context k;
  private float l;
  private a m;
  
  public MyZiroomCardView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public MyZiroomCardView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public MyZiroomCardView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.k = paramContext;
    this.l = this.k.getResources().getDisplayMetrics().density;
    a();
  }
  
  private void a()
  {
    setOrientation(1);
    inflate(this.k, 2130904394, this);
    setBackgroundColor(Color.parseColor("#ffffff"));
    this.a = findViewById(2131695422);
    this.b = ((TextView)findViewById(2131689541));
    this.c = ((TextView)findViewById(2131690326));
    this.d = ((ImageView)findViewById(2131690724));
    this.e = ((TextView)findViewById(2131695423));
    this.f = ((TextView)findViewById(2131695424));
    this.g = ((TextView)findViewById(2131695425));
    this.h = ((LinearLayout)findViewById(2131691838));
    this.i = ((TextView)findViewById(2131695427));
    this.j = ((TextView)findViewById(2131689835));
  }
  
  @Instrumented
  public void onClick(View paramView)
  {
    VdsAgent.onClick(this, paramView);
    if (this.m == null) {
      return;
    }
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131690326: 
    case 2131690724: 
      this.m.onMoreClick();
      return;
    case 2131691838: 
      this.m.onContentClick();
      return;
    }
    this.m.onButtonClick();
  }
  
  public MyZiroomCardView setButton(String paramString1, int paramInt, String paramString2)
  {
    if (paramString1.startsWith("#")) {
      this.i.setTextColor(Color.parseColor(paramString1));
    }
    this.i.setBackgroundResource(paramInt);
    this.i.setText(paramString2);
    return this;
  }
  
  public void setCardClickListener(a parama)
  {
    this.m = parama;
  }
  
  public MyZiroomCardView setColorSpace(String paramString)
  {
    if (paramString.startsWith("#")) {
      this.a.setBackgroundColor(Color.parseColor(paramString));
    }
    return this;
  }
  
  public MyZiroomCardView setCount(int paramInt)
  {
    if (paramInt > 1)
    {
      this.c.setVisibility(0);
      this.d.setVisibility(0);
      return this;
    }
    this.c.setVisibility(8);
    this.d.setVisibility(8);
    return this;
  }
  
  public MyZiroomCardView setLine1(String paramString)
  {
    this.e.setText(paramString);
    return this;
  }
  
  public MyZiroomCardView setLine2(String paramString)
  {
    this.f.setText(paramString);
    return this;
  }
  
  public MyZiroomCardView setLine3(SpannableString paramSpannableString)
  {
    this.g.setText(paramSpannableString);
    return this;
  }
  
  public MyZiroomCardView setTips(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      this.j.setVisibility(8);
      return this;
    }
    this.j.setText(paramString);
    return this;
  }
  
  public MyZiroomCardView setTitle(String paramString)
  {
    this.b.setText(paramString);
    return this;
  }
  
  public static abstract interface a
  {
    public abstract void onButtonClick();
    
    public abstract void onContentClick();
    
    public abstract void onMoreClick();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/my/widget/MyZiroomCardView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */