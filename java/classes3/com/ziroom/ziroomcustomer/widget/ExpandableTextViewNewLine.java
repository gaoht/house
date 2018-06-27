package com.ziroom.ziroomcustomer.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.text.Layout;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.Transformation;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.R.styleable;

public class ExpandableTextViewNewLine
  extends LinearLayout
  implements View.OnClickListener
{
  protected TextView a;
  protected TextView b;
  private boolean c;
  private boolean d = true;
  private int e;
  private int f;
  private int g;
  private int h;
  private Drawable i;
  private Drawable j;
  private int k;
  private String l;
  private String m;
  private int n;
  private float o;
  private int p;
  private int q;
  private boolean r;
  private b s;
  private SparseBooleanArray t;
  private int u;
  private Runnable v = new Runnable()
  {
    public void run()
    {
      ExpandableTextViewNewLine.a(ExpandableTextViewNewLine.this, ExpandableTextViewNewLine.this.getHeight() - ExpandableTextViewNewLine.this.a.getHeight());
    }
  };
  
  public ExpandableTextViewNewLine(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ExpandableTextViewNewLine(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext, paramAttributeSet);
  }
  
  @TargetApi(11)
  public ExpandableTextViewNewLine(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext, paramAttributeSet);
  }
  
  private static int a(TextView paramTextView)
  {
    return paramTextView.getLayout().getLineTop(paramTextView.getLineCount()) + (paramTextView.getCompoundPaddingTop() + paramTextView.getCompoundPaddingBottom());
  }
  
  private void a()
  {
    this.a = ((TextView)findViewById(2131696487));
    this.a.setTextColor(this.p);
    this.a.setTextSize(0, this.o);
    this.a.setOnClickListener(this);
    this.b = ((TextView)findViewById(2131696488));
    Object localObject = new LinearLayout.LayoutParams(-2, -2);
    TextView localTextView;
    if (this.k == 0)
    {
      ((LinearLayout.LayoutParams)localObject).gravity = 8388611;
      this.b.setLayoutParams((ViewGroup.LayoutParams)localObject);
      localTextView = this.b;
      if (!this.d) {
        break label199;
      }
      localObject = this.m;
      label107:
      localTextView.setText((CharSequence)localObject);
      this.b.setTextColor(this.q);
      localTextView = this.b;
      if (!this.d) {
        break label207;
      }
    }
    label199:
    label207:
    for (localObject = this.i;; localObject = this.j)
    {
      localTextView.setCompoundDrawablesWithIntrinsicBounds((Drawable)localObject, null, null, null);
      this.b.setCompoundDrawablePadding(10);
      this.b.setOnClickListener(this);
      return;
      if (this.k == 1)
      {
        ((LinearLayout.LayoutParams)localObject).gravity = 1;
        break;
      }
      if (this.k != 2) {
        break;
      }
      ((LinearLayout.LayoutParams)localObject).gravity = 8388613;
      break;
      localObject = this.l;
      break label107;
    }
  }
  
  private void a(Context paramContext, AttributeSet paramAttributeSet)
  {
    LayoutInflater.from(paramContext).inflate(2130904807, this, true);
    setOrientation(1);
    setVisibility(8);
    paramContext = getContext().obtainStyledAttributes(paramAttributeSet, R.styleable.ExpandableTextViewNewLine);
    this.g = paramContext.getInt(0, 8);
    this.n = paramContext.getInt(1, 300);
    this.o = paramContext.getDimension(2, 16.0F);
    this.p = paramContext.getColor(3, -16777216);
    this.i = paramContext.getDrawable(4);
    this.j = paramContext.getDrawable(6);
    this.k = paramContext.getInt(9, 2);
    this.m = paramContext.getString(5);
    this.l = paramContext.getString(7);
    this.q = paramContext.getColor(8, -16777216);
    if ((this.i != null) || ((this.j != null) || (this.m == null))) {
      this.m = "查看更多";
    }
    if (this.l == null) {
      this.l = "收起";
    }
    paramContext.recycle();
  }
  
  public CharSequence getText()
  {
    if (this.a == null) {
      return "";
    }
    return this.a.getText();
  }
  
  @Instrumented
  public void onClick(View paramView)
  {
    VdsAgent.onClick(this, paramView);
    if (this.b.getVisibility() != 0) {
      return;
    }
    boolean bool;
    if (!this.d)
    {
      bool = true;
      this.d = bool;
      TextView localTextView = this.b;
      if (!this.d) {
        break label161;
      }
      paramView = this.m;
      label47:
      localTextView.setText(paramView);
      localTextView = this.b;
      if (!this.d) {
        break label169;
      }
      paramView = this.i;
      label69:
      localTextView.setCompoundDrawablesWithIntrinsicBounds(paramView, null, null, null);
      if (this.t != null) {
        this.t.put(this.u, this.d);
      }
      this.r = true;
      if (!this.d) {
        break label177;
      }
    }
    label161:
    label169:
    label177:
    for (paramView = new a(this, getHeight(), this.e);; paramView = new a(this, getHeight(), getHeight() + this.f - this.a.getHeight()))
    {
      paramView.setFillAfter(true);
      paramView.setAnimationListener(new Animation.AnimationListener()
      {
        public void onAnimationEnd(Animation paramAnonymousAnimation)
        {
          boolean bool = false;
          ExpandableTextViewNewLine.this.clearAnimation();
          ExpandableTextViewNewLine.a(ExpandableTextViewNewLine.this, false);
          if (ExpandableTextViewNewLine.a(ExpandableTextViewNewLine.this) != null)
          {
            paramAnonymousAnimation = ExpandableTextViewNewLine.a(ExpandableTextViewNewLine.this);
            TextView localTextView = ExpandableTextViewNewLine.this.a;
            if (!ExpandableTextViewNewLine.b(ExpandableTextViewNewLine.this)) {
              bool = true;
            }
            paramAnonymousAnimation.onExpandStateChanged(localTextView, bool);
          }
        }
        
        public void onAnimationRepeat(Animation paramAnonymousAnimation) {}
        
        public void onAnimationStart(Animation paramAnonymousAnimation) {}
      });
      clearAnimation();
      startAnimation(paramView);
      return;
      bool = false;
      break;
      paramView = this.l;
      break label47;
      paramView = this.j;
      break label69;
    }
  }
  
  protected void onFinishInflate()
  {
    a();
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    return this.r;
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    if ((!this.c) || (getVisibility() == 8)) {
      super.onMeasure(paramInt1, paramInt2);
    }
    do
    {
      do
      {
        return;
        this.c = false;
        this.b.setVisibility(8);
        this.a.setMaxLines(Integer.MAX_VALUE);
        super.onMeasure(paramInt1, paramInt2);
      } while (this.a.getLineCount() <= this.g);
      this.f = a(this.a);
      if (this.d) {
        this.a.setMaxLines(this.g);
      }
      this.b.setVisibility(0);
      super.onMeasure(paramInt1, paramInt2);
    } while (!this.d);
    this.a.post(this.v);
    this.e = getMeasuredHeight();
  }
  
  public void setOnExpandStateChangeListener(b paramb)
  {
    this.s = paramb;
  }
  
  public void setOrientation(int paramInt)
  {
    if (paramInt == 0) {
      throw new IllegalArgumentException("ExpandableTextView only supports Vertical Orientation.");
    }
    super.setOrientation(paramInt);
  }
  
  public void setText(CharSequence paramCharSequence)
  {
    this.c = true;
    this.a.setText(paramCharSequence);
    if (TextUtils.isEmpty(paramCharSequence)) {}
    for (int i1 = 8;; i1 = 0)
    {
      setVisibility(i1);
      return;
    }
  }
  
  public void setText(CharSequence paramCharSequence, SparseBooleanArray paramSparseBooleanArray, int paramInt)
  {
    this.t = paramSparseBooleanArray;
    this.u = paramInt;
    boolean bool = paramSparseBooleanArray.get(paramInt, true);
    clearAnimation();
    this.d = bool;
    TextView localTextView = this.b;
    if (this.d)
    {
      paramSparseBooleanArray = this.m;
      localTextView.setText(paramSparseBooleanArray);
      localTextView = this.b;
      if (!this.d) {
        break label106;
      }
    }
    label106:
    for (paramSparseBooleanArray = this.i;; paramSparseBooleanArray = this.j)
    {
      localTextView.setCompoundDrawablesWithIntrinsicBounds(paramSparseBooleanArray, null, null, null);
      setText(paramCharSequence);
      getLayoutParams().height = -2;
      requestLayout();
      return;
      paramSparseBooleanArray = this.l;
      break;
    }
  }
  
  class a
    extends Animation
  {
    private final View b;
    private final int c;
    private final int d;
    
    public a(View paramView, int paramInt1, int paramInt2)
    {
      this.b = paramView;
      this.c = paramInt1;
      this.d = paramInt2;
      setDuration(ExpandableTextViewNewLine.c(ExpandableTextViewNewLine.this));
    }
    
    protected void applyTransformation(float paramFloat, Transformation paramTransformation)
    {
      int i = (int)((this.d - this.c) * paramFloat + this.c);
      ExpandableTextViewNewLine.this.a.setMaxHeight(i - ExpandableTextViewNewLine.d(ExpandableTextViewNewLine.this));
      this.b.getLayoutParams().height = i;
      this.b.requestLayout();
    }
    
    public void initialize(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      super.initialize(paramInt1, paramInt2, paramInt3, paramInt4);
    }
    
    public boolean willChangeBounds()
    {
      return true;
    }
  }
  
  public static abstract interface b
  {
    public abstract void onExpandStateChanged(TextView paramTextView, boolean paramBoolean);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/widget/ExpandableTextViewNewLine.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */