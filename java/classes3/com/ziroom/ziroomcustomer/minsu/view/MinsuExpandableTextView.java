package com.ziroom.ziroomcustomer.minsu.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
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

public class MinsuExpandableTextView
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
  private int i = 2;
  private String j;
  private String k;
  private int l;
  private float m;
  private int n;
  private int o;
  private boolean p;
  private b q;
  private SparseBooleanArray r;
  private int s;
  private Runnable t = new Runnable()
  {
    public void run()
    {
      MinsuExpandableTextView.a(MinsuExpandableTextView.this, MinsuExpandableTextView.this.getHeight() - MinsuExpandableTextView.this.a.getHeight());
    }
  };
  
  public MinsuExpandableTextView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public MinsuExpandableTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext, paramAttributeSet);
  }
  
  @TargetApi(11)
  public MinsuExpandableTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
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
    this.a = ((TextView)findViewById(2131689483));
    this.a.setTextColor(this.n);
    this.a.setTextSize(0, this.m);
    this.a.setOnClickListener(this);
    this.b = ((TextView)findViewById(2131689482));
    this.b.setTextSize(0, this.m);
    Object localObject = new LinearLayout.LayoutParams(-2, -2);
    TextView localTextView;
    if (this.i == 0)
    {
      ((LinearLayout.LayoutParams)localObject).gravity = 8388611;
      this.b.setLayoutParams((ViewGroup.LayoutParams)localObject);
      localTextView = this.b;
      if (!this.d) {
        break label186;
      }
    }
    label186:
    for (localObject = this.k;; localObject = this.j)
    {
      localTextView.setText((CharSequence)localObject);
      this.b.setTextColor(this.o);
      this.b.setCompoundDrawablePadding(10);
      this.b.setOnClickListener(this);
      return;
      if (this.i == 1)
      {
        ((LinearLayout.LayoutParams)localObject).gravity = 1;
        break;
      }
      if (this.i != 2) {
        break;
      }
      ((LinearLayout.LayoutParams)localObject).gravity = 8388613;
      break;
    }
  }
  
  private void a(Context paramContext, AttributeSet paramAttributeSet)
  {
    LayoutInflater.from(paramContext).inflate(2130904889, this, true);
    setOrientation(1);
    setVisibility(8);
    paramContext = getContext().obtainStyledAttributes(paramAttributeSet, R.styleable.MinsuExpandableTextView);
    this.g = paramContext.getInt(0, 8);
    this.l = paramContext.getInt(1, 300);
    this.m = paramContext.getDimension(2, 16.0F);
    this.n = paramContext.getColor(3, -16777216);
    this.i = paramContext.getInt(9, 2);
    this.k = paramContext.getString(5);
    this.j = paramContext.getString(7);
    this.o = paramContext.getColor(8, -16777216);
    if (this.k == null) {
      this.k = getContext().getString(2131296776);
    }
    if (this.j == null) {
      this.j = getContext().getString(2131296701);
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
        break label136;
      }
      paramView = this.k;
      label47:
      localTextView.setText(paramView);
      if (this.r != null) {
        this.r.put(this.s, this.d);
      }
      this.p = true;
      if (!this.d) {
        break label144;
      }
    }
    label136:
    label144:
    for (paramView = new a(this, getHeight(), this.e);; paramView = new a(this, getHeight(), getHeight() + this.f - this.a.getHeight()))
    {
      paramView.setFillAfter(true);
      paramView.setAnimationListener(new Animation.AnimationListener()
      {
        public void onAnimationEnd(Animation paramAnonymousAnimation)
        {
          boolean bool = false;
          MinsuExpandableTextView.this.clearAnimation();
          MinsuExpandableTextView.a(MinsuExpandableTextView.this, false);
          if (MinsuExpandableTextView.a(MinsuExpandableTextView.this) != null)
          {
            paramAnonymousAnimation = MinsuExpandableTextView.a(MinsuExpandableTextView.this);
            TextView localTextView = MinsuExpandableTextView.this.a;
            if (!MinsuExpandableTextView.b(MinsuExpandableTextView.this)) {
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
      paramView = this.j;
      break label47;
    }
  }
  
  protected void onFinishInflate()
  {
    a();
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    return this.p;
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
    this.a.post(this.t);
    this.e = getMeasuredHeight();
  }
  
  public void setOnExpandStateChangeListener(b paramb)
  {
    this.q = paramb;
  }
  
  public void setOrientation(int paramInt)
  {
    if (paramInt == 0) {
      throw new IllegalArgumentException("MinsuExpandableTextView only supports Vertical Orientation.");
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
    this.r = paramSparseBooleanArray;
    this.s = paramInt;
    boolean bool = paramSparseBooleanArray.get(paramInt, true);
    clearAnimation();
    this.d = bool;
    TextView localTextView = this.b;
    if (this.d) {}
    for (paramSparseBooleanArray = this.k;; paramSparseBooleanArray = this.j)
    {
      localTextView.setText(paramSparseBooleanArray);
      setText(paramCharSequence);
      getLayoutParams().height = -2;
      requestLayout();
      return;
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
      setDuration(MinsuExpandableTextView.c(MinsuExpandableTextView.this));
    }
    
    protected void applyTransformation(float paramFloat, Transformation paramTransformation)
    {
      int i = (int)((this.d - this.c) * paramFloat + this.c);
      MinsuExpandableTextView.this.a.setMaxHeight(i - MinsuExpandableTextView.d(MinsuExpandableTextView.this));
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


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/view/MinsuExpandableTextView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */