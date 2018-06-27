package com.ziroom.ziroomcustomer.home.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.os.Build.VERSION;
import android.text.DynamicLayout;
import android.text.Layout;
import android.text.Layout.Alignment;
import android.text.Selection;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.R.styleable;
import java.lang.reflect.Field;

public class StoryTextView
  extends TextView
{
  private String a;
  private String b;
  private String c;
  private String d = " ";
  private String e = " ";
  private boolean f = true;
  private boolean g = true;
  private boolean h = true;
  private int i = 6;
  private int j = Color.parseColor("#ffa000");
  private int k = Color.parseColor("#ffa000");
  private int l = 1436129689;
  private int m = 1436129689;
  private int n = 0;
  private d o;
  private TextView.BufferType p = TextView.BufferType.NORMAL;
  private TextPaint q;
  private Layout r;
  private int s = -1;
  private int t = 0;
  private int u = 0;
  private CharSequence v;
  private a w;
  private c x;
  
  public StoryTextView(Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  public StoryTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext, paramAttributeSet);
    a();
  }
  
  @TargetApi(11)
  public StoryTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext, paramAttributeSet);
    a();
  }
  
  private int a(String paramString)
  {
    if (paramString == null) {
      return 0;
    }
    return paramString.length();
  }
  
  private View.OnClickListener a(View paramView)
  {
    try
    {
      Field localField = Class.forName("android.view.View").getDeclaredField("mOnClickListener");
      localField.setAccessible(true);
      paramView = (View.OnClickListener)localField.get(paramView);
      return paramView;
    }
    catch (Exception paramView)
    {
      paramView.printStackTrace();
    }
    return null;
  }
  
  private void a()
  {
    this.o = new d(null);
    setMovementMethod(new b());
    if (TextUtils.isEmpty(this.a)) {
      this.a = "..";
    }
    if (TextUtils.isEmpty(this.b)) {
      this.b = "阅读故事";
    }
    if (TextUtils.isEmpty(this.c)) {
      this.c = getResources().getString(2131297522);
    }
    if (this.f)
    {
      this.w = new a(null);
      setOnClickListener(this.w);
    }
    getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener()
    {
      public void onGlobalLayout()
      {
        ViewTreeObserver localViewTreeObserver = StoryTextView.this.getViewTreeObserver();
        if (Build.VERSION.SDK_INT >= 16) {
          localViewTreeObserver.removeOnGlobalLayoutListener(this);
        }
        for (;;)
        {
          StoryTextView.a(StoryTextView.this, StoryTextView.a(StoryTextView.this), StoryTextView.b(StoryTextView.this));
          return;
          localViewTreeObserver.removeGlobalOnLayoutListener(this);
        }
      }
    });
  }
  
  private void a(Context paramContext, AttributeSet paramAttributeSet)
  {
    if (paramAttributeSet == null) {}
    do
    {
      return;
      paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.ExpandableTextViewENTIRE);
    } while (paramContext == null);
    int i2 = paramContext.getIndexCount();
    int i1 = 0;
    if (i1 < i2)
    {
      int i3 = paramContext.getIndex(i1);
      if (i3 == 0) {
        this.i = paramContext.getInteger(i3, 6);
      }
      for (;;)
      {
        i1 += 1;
        break;
        if (i3 == 1) {
          this.a = paramContext.getString(i3);
        } else if (i3 == 2) {
          this.b = paramContext.getString(i3);
        } else if (i3 == 3) {
          this.c = paramContext.getString(i3);
        } else if (i3 == 6) {
          this.f = paramContext.getBoolean(i3, true);
        } else if (i3 == 7) {
          this.g = paramContext.getBoolean(i3, true);
        } else if (i3 == 8) {
          this.h = paramContext.getBoolean(i3, true);
        } else if (i3 == 9) {
          this.j = paramContext.getColor(i3, this.j);
        } else if (i3 == 10) {
          this.k = paramContext.getColor(i3, this.k);
        } else if (i3 == 11) {
          this.l = paramContext.getInteger(i3, 1436129689);
        } else if (i3 == 12) {
          this.m = paramContext.getInteger(i3, 1436129689);
        } else if (i3 == 13) {
          this.n = paramContext.getInteger(i3, 0);
        } else if (i3 == 4) {
          this.d = paramContext.getString(i3);
        } else if (i3 == 5) {
          this.e = paramContext.getString(i3);
        }
      }
    }
    paramContext.recycle();
  }
  
  private void a(CharSequence paramCharSequence, TextView.BufferType paramBufferType)
  {
    super.setText(paramCharSequence, paramBufferType);
  }
  
  private View.OnClickListener b(View paramView)
  {
    for (;;)
    {
      try
      {
        Field localField = Class.forName("android.view.View").getDeclaredField("mListenerInfo");
        if (localField == null) {
          break label70;
        }
        localField.setAccessible(true);
        paramView = localField.get(paramView);
        localField = Class.forName("android.view.View$ListenerInfo").getDeclaredField("mOnClickListener");
        if ((localField != null) && (paramView != null))
        {
          localField.setAccessible(true);
          paramView = (View.OnClickListener)localField.get(paramView);
          return paramView;
        }
      }
      catch (Exception paramView)
      {
        paramView.printStackTrace();
      }
      return null;
      label70:
      paramView = null;
    }
  }
  
  private String b(String paramString)
  {
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    return str;
  }
  
  private CharSequence getNewTextByConfig()
  {
    if (TextUtils.isEmpty(this.v)) {
      this.v = " ";
    }
    this.r = getLayout();
    if (this.r != null) {
      this.t = this.r.getWidth();
    }
    if (this.t <= 0)
    {
      if (getWidth() != 0) {
        break label133;
      }
      if (this.u == 0)
      {
        localObject1 = this.v;
        return (CharSequence)localObject1;
      }
    }
    label133:
    for (this.t = (this.u - getPaddingLeft() - getPaddingRight());; this.t = (getWidth() - getPaddingLeft() - getPaddingRight()))
    {
      this.q = getPaint();
      this.s = -1;
      switch (this.n)
      {
      default: 
        return this.v;
      }
    }
    this.r = new DynamicLayout(this.v + this.b, this.q, this.t, Layout.Alignment.ALIGN_NORMAL, 1.0F, 0.0F, false);
    this.s = this.r.getLineCount();
    if (this.s <= this.i)
    {
      localObject1 = new SpannableStringBuilder(this.v, 0, this.v.length());
      ((SpannableStringBuilder)localObject1).append(b(this.d) + b(this.b));
      ((SpannableStringBuilder)localObject1).setSpan(this.o, ((SpannableStringBuilder)localObject1).length() - a(this.b), ((SpannableStringBuilder)localObject1).length(), 33);
      return (CharSequence)localObject1;
    }
    int i2 = getValidLayout().getLineEnd(this.i - 1);
    int i6 = getValidLayout().getLineStart(this.i - 1);
    int i3 = a(this.a);
    if (this.g) {}
    int i4;
    for (int i1 = a(this.b) + a(this.d);; i1 = 0)
    {
      i4 = i2 - i3 - i1;
      if (i4 > 0) {
        break;
      }
      return this.v.subSequence(0, i2);
    }
    int i5 = getValidLayout().getWidth() - (int)(this.q.measureText(this.v.subSequence(i6, i4).toString()) + 0.5D);
    Object localObject2 = this.q;
    StringBuilder localStringBuilder = new StringBuilder().append(b(this.a));
    if (this.g) {}
    float f1;
    for (Object localObject1 = b(this.b) + b(this.d);; localObject1 = "")
    {
      f1 = ((TextPaint)localObject2).measureText((String)localObject1);
      if (i5 <= f1) {
        break label743;
      }
      i2 = 0;
      i1 = 0;
      for (;;)
      {
        i3 = i1;
        if (i5 <= i2 + f1) {
          break;
        }
        i1 += 1;
        i3 = i1;
        if (i4 + i1 > this.v.length()) {
          break;
        }
        i2 = (int)(this.q.measureText(this.v.subSequence(i4, i4 + i1).toString()) + 0.5D);
      }
    }
    for (i1 = i3 - 1 + i4;; i1 = i3 + i4)
    {
      localObject2 = new SpannableStringBuilder(this.v, 0, i1).append(this.a);
      localObject1 = localObject2;
      if (!this.g) {
        break;
      }
      ((SpannableStringBuilder)localObject2).append(b(this.d) + b(this.b));
      ((SpannableStringBuilder)localObject2).setSpan(this.o, ((SpannableStringBuilder)localObject2).length() - a(this.b), ((SpannableStringBuilder)localObject2).length(), 33);
      return (CharSequence)localObject2;
      label743:
      i2 = 0;
      i1 = 0;
      for (;;)
      {
        i3 = i1;
        if (i2 + i5 >= f1) {
          break;
        }
        i1 -= 1;
        i3 = i1;
        if (i4 + i1 <= i6) {
          break;
        }
        i2 = (int)(this.q.measureText(this.v.subSequence(i4 + i1, i4).toString()) + 0.5D);
      }
    }
    if (!this.h) {
      return this.v;
    }
    this.r = new DynamicLayout(this.v, this.q, this.t, Layout.Alignment.ALIGN_NORMAL, 1.0F, 0.0F, false);
    this.s = this.r.getLineCount();
    if (this.s <= this.i) {
      return this.v;
    }
    localObject1 = new SpannableStringBuilder(this.v).append(this.e).append(this.c);
    ((SpannableStringBuilder)localObject1).setSpan(this.o, ((SpannableStringBuilder)localObject1).length() - a(this.c), ((SpannableStringBuilder)localObject1).length(), 33);
    return (CharSequence)localObject1;
  }
  
  private Layout getValidLayout()
  {
    if (this.r != null) {
      return this.r;
    }
    return getLayout();
  }
  
  public int getExpandState()
  {
    return this.n;
  }
  
  public View.OnClickListener getOnClickListener(View paramView)
  {
    if (Build.VERSION.SDK_INT >= 14) {
      return b(paramView);
    }
    return a(paramView);
  }
  
  public void setExpandListener(c paramc)
  {
    this.x = paramc;
  }
  
  public void setText(CharSequence paramCharSequence, TextView.BufferType paramBufferType)
  {
    this.v = paramCharSequence;
    this.p = paramBufferType;
    a(getNewTextByConfig(), paramBufferType);
  }
  
  public void updateForRecyclerView(CharSequence paramCharSequence, int paramInt)
  {
    this.u = paramInt;
    setText(paramCharSequence);
  }
  
  public void updateForRecyclerView(CharSequence paramCharSequence, int paramInt1, int paramInt2)
  {
    this.u = paramInt1;
    this.n = paramInt2;
    setText(paramCharSequence);
  }
  
  public void updateForRecyclerView(CharSequence paramCharSequence, TextView.BufferType paramBufferType, int paramInt)
  {
    this.u = paramInt;
    setText(paramCharSequence, paramBufferType);
  }
  
  private class a
    implements View.OnClickListener
  {
    private a() {}
    
    @Instrumented
    public void onClick(View paramView)
    {
      VdsAgent.onClick(this, paramView);
    }
  }
  
  public class b
    extends LinkMovementMethod
  {
    private StoryTextView.d b;
    
    public b() {}
    
    private StoryTextView.d a(TextView paramTextView, Spannable paramSpannable, MotionEvent paramMotionEvent)
    {
      int i = (int)paramMotionEvent.getX();
      int j = (int)paramMotionEvent.getY();
      int k = paramTextView.getTotalPaddingLeft();
      int m = paramTextView.getTotalPaddingTop();
      int n = paramTextView.getScrollX();
      int i1 = paramTextView.getScrollY();
      paramTextView = paramTextView.getLayout();
      i = paramTextView.getOffsetForHorizontal(paramTextView.getLineForVertical(j - m + i1), i - k + n);
      paramTextView = (StoryTextView.d[])paramSpannable.getSpans(i, i, StoryTextView.d.class);
      if (paramTextView.length > 0) {
        return paramTextView[0];
      }
      return null;
    }
    
    public boolean onTouchEvent(TextView paramTextView, Spannable paramSpannable, MotionEvent paramMotionEvent)
    {
      if (paramMotionEvent.getAction() == 0)
      {
        this.b = a(paramTextView, paramSpannable, paramMotionEvent);
        if (this.b != null)
        {
          this.b.setPressed(true);
          Selection.setSelection(paramSpannable, paramSpannable.getSpanStart(this.b), paramSpannable.getSpanEnd(this.b));
        }
      }
      do
      {
        return true;
        if (paramMotionEvent.getAction() != 2) {
          break;
        }
        paramTextView = a(paramTextView, paramSpannable, paramMotionEvent);
      } while ((this.b == null) || (paramTextView == this.b));
      this.b.setPressed(false);
      this.b = null;
      Selection.removeSelection(paramSpannable);
      return true;
      if (this.b != null)
      {
        this.b.setPressed(false);
        super.onTouchEvent(paramTextView, paramSpannable, paramMotionEvent);
      }
      this.b = null;
      Selection.removeSelection(paramSpannable);
      return true;
    }
  }
  
  public static abstract interface c
  {
    public abstract void onExpand(StoryTextView paramStoryTextView);
    
    public abstract void onShrink(StoryTextView paramStoryTextView);
  }
  
  private class d
    extends ClickableSpan
  {
    private boolean b;
    
    private d() {}
    
    @Instrumented
    public void onClick(View paramView)
    {
      VdsAgent.onClick(this, paramView);
    }
    
    public void setPressed(boolean paramBoolean)
    {
      this.b = paramBoolean;
    }
    
    public void updateDrawState(TextPaint paramTextPaint)
    {
      super.updateDrawState(paramTextPaint);
      switch (StoryTextView.c(StoryTextView.this))
      {
      default: 
        paramTextPaint.setUnderlineText(false);
        return;
      case 0: 
        paramTextPaint.setColor(StoryTextView.d(StoryTextView.this));
        if (this.b) {}
        for (i = StoryTextView.e(StoryTextView.this);; i = 0)
        {
          paramTextPaint.bgColor = i;
          break;
        }
      }
      paramTextPaint.setColor(StoryTextView.f(StoryTextView.this));
      if (this.b) {}
      for (int i = StoryTextView.g(StoryTextView.this);; i = 0)
      {
        paramTextPaint.bgColor = i;
        break;
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/home/view/StoryTextView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */