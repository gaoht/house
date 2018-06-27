package com.ziroom.ziroomcustomer.newchat.chatcenter.views;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.TextView;
import com.ziroom.ziroomcustomer.newchat.chatcenter.b.i.a;
import java.util.List;
import java.util.Random;

public class LooperTextView
  extends FrameLayout
{
  private List<i.a> a;
  private int b = 0;
  private long c;
  private Drawable d;
  private Drawable e;
  private TextView f;
  private TextView g;
  private Animation h;
  private Animation i;
  
  public LooperTextView(Context paramContext)
  {
    super(paramContext);
    a();
    c();
  }
  
  public LooperTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
    c();
  }
  
  public LooperTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
    c();
  }
  
  public LooperTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    super(paramContext, paramAttributeSet, paramInt1, paramInt2);
    a();
    c();
  }
  
  private Drawable a(int paramInt)
  {
    Drawable localDrawable = getResources().getDrawable(paramInt);
    localDrawable.setBounds(0, 0, sp2px(10.0F), sp2px(10.0F));
    return localDrawable;
  }
  
  private Animation a(float paramFloat1, float paramFloat2)
  {
    TranslateAnimation localTranslateAnimation = new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, paramFloat1, 1, paramFloat2);
    localTranslateAnimation.setDuration(1000L);
    localTranslateAnimation.setStartOffset(3000L);
    localTranslateAnimation.setInterpolator(new DecelerateInterpolator());
    return localTranslateAnimation;
  }
  
  private void a()
  {
    this.d = a(2130838765);
    this.e = a(2130838765);
    this.f = b();
    this.g = b();
    this.f.setCompoundDrawablePadding(sp2px(4.0F));
    this.g.setCompoundDrawablePadding(sp2px(4.0F));
    addView(this.g);
    addView(this.f);
  }
  
  private void a(TextView paramTextView)
  {
    if (new Random().nextBoolean()) {
      paramTextView.setCompoundDrawables(this.d, null, null, null);
    }
    for (;;)
    {
      String str = getNextTip();
      if (!TextUtils.isEmpty(str)) {
        paramTextView.setText(str + "");
      }
      return;
      paramTextView.setCompoundDrawables(this.e, null, null, null);
    }
  }
  
  private TextView b()
  {
    TextView localTextView = new TextView(getContext());
    localTextView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1, 16));
    localTextView.setCompoundDrawablePadding(10);
    localTextView.setGravity(16);
    localTextView.setLines(1);
    localTextView.setEllipsize(TextUtils.TruncateAt.END);
    localTextView.setTextColor(Color.parseColor("#ffa000"));
    localTextView.setTextSize(1, 12.0F);
    return localTextView;
  }
  
  private void c()
  {
    this.h = a(0.0F, -1.0F);
    this.i = a(1.0F, 0.0F);
    this.i.setAnimationListener(new Animation.AnimationListener()
    {
      public void onAnimationEnd(Animation paramAnonymousAnimation)
      {
        LooperTextView.a(LooperTextView.this);
      }
      
      public void onAnimationRepeat(Animation paramAnonymousAnimation) {}
      
      public void onAnimationStart(Animation paramAnonymousAnimation) {}
    });
  }
  
  private void d()
  {
    if (System.currentTimeMillis() - this.c < 1000L) {
      return;
    }
    this.c = System.currentTimeMillis();
    e();
  }
  
  private void e()
  {
    if (this.b % 2 == 0)
    {
      a(this.f);
      this.g.startAnimation(this.h);
      this.f.startAnimation(this.i);
      bringChildToFront(this.g);
      return;
    }
    a(this.g);
    this.f.startAnimation(this.h);
    this.g.startAnimation(this.i);
    bringChildToFront(this.f);
  }
  
  private String getNextTip()
  {
    if (isListEmpty(this.a)) {
      return null;
    }
    List localList = this.a;
    int j = this.b;
    this.b = (j + 1);
    return ((i.a)localList.get(j % this.a.size())).getTitle();
  }
  
  public static boolean isListEmpty(List paramList)
  {
    return (paramList == null) || (paramList.isEmpty());
  }
  
  public i.a getCurrentData()
  {
    if (this.b > 1) {}
    for (int j = (this.b - 2) % this.a.size();; j = this.b % this.a.size()) {
      return (i.a)this.a.get(j);
    }
  }
  
  public int getCurrentIndex()
  {
    return this.b % this.a.size();
  }
  
  public void setTipList(List<i.a> paramList)
  {
    this.a = paramList;
    this.b = 0;
    a(this.f);
    e();
  }
  
  public int sp2px(float paramFloat)
  {
    return (int)(getContext().getResources().getDisplayMetrics().scaledDensity * paramFloat + 0.5F);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newchat/chatcenter/views/LooperTextView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */