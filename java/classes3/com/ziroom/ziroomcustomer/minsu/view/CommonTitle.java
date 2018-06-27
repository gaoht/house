package com.ziroom.ziroomcustomer.minsu.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.util.ac;
import com.ziroom.ziroomcustomer.util.u;
import com.ziroom.ziroomcustomer.widget.ObservableScrollView;
import com.ziroom.ziroomcustomer.widget.ObservableScrollView.a;

public class CommonTitle
  extends RelativeLayout
  implements View.OnClickListener
{
  private Context a;
  private View.OnClickListener b;
  private View.OnClickListener c;
  private View.OnClickListener d;
  private ImageView e;
  private TextView f;
  private TextView g;
  private View h;
  private ImageView i;
  private TextView j;
  private ImageView k;
  private ImageView l;
  private View m;
  
  public CommonTitle(Context paramContext)
  {
    super(paramContext);
    this.a = paramContext;
  }
  
  public CommonTitle(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.a = paramContext;
  }
  
  public TextView getLeftText()
  {
    return this.f;
  }
  
  public View getView(int paramInt)
  {
    return findViewById(paramInt);
  }
  
  @Instrumented
  public void onClick(View paramView)
  {
    VdsAgent.onClick(this, paramView);
    switch (paramView.getId())
    {
    }
    do
    {
      do
      {
        do
        {
          return;
        } while (this.d == null);
        this.d.onClick(this.e);
        return;
      } while (this.b == null);
      this.b.onClick(this.j);
      return;
    } while (this.c == null);
    this.c.onClick(paramView);
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    this.h = findViewById(2131694590);
    this.j = ((TextView)findViewById(2131694576));
    this.g = ((TextView)findViewById(2131694574));
    this.i = ((ImageView)findViewById(2131694575));
    this.f = ((TextView)findViewById(2131691400));
    this.e = ((ImageView)findViewById(2131691399));
    this.k = ((ImageView)findViewById(2131690751));
    this.m = findViewById(2131690079);
    this.e.setOnClickListener(this);
    this.j.setOnClickListener(this);
    this.f.setOnClickListener(this);
    this.k.setOnClickListener(this);
  }
  
  public void rightButtonPerformClick()
  {
    this.j.performClick();
  }
  
  public void setBackground(int paramInt)
  {
    setBackgroundColor(getResources().getColor(paramInt));
  }
  
  public void setBottomLineAlpha(float paramFloat)
  {
    if (this.m != null) {
      this.m.setAlpha(paramFloat);
    }
  }
  
  public void setBottomLineVisible(boolean paramBoolean)
  {
    View localView;
    if (this.m != null)
    {
      localView = this.m;
      if (!paramBoolean) {
        break label24;
      }
    }
    label24:
    for (int n = 0;; n = 8)
    {
      localView.setVisibility(n);
      return;
    }
  }
  
  public void setHeaderAlpha(float paramFloat)
  {
    if (this.h != null) {
      this.h.setAlpha(paramFloat);
    }
  }
  
  public void setLeftButtonType(int paramInt)
  {
    if (paramInt == 0)
    {
      this.e.setVisibility(0);
      this.e.setImageResource(2130840141);
    }
    do
    {
      return;
      if (paramInt == -1)
      {
        this.e.setVisibility(8);
        return;
      }
      if (paramInt == 1)
      {
        this.e.setVisibility(0);
        this.e.setImageResource(2130840142);
        return;
      }
      if (paramInt == 2)
      {
        this.e.setVisibility(0);
        this.e.setImageResource(2130840141);
        return;
      }
    } while (paramInt != 4);
    this.e.setVisibility(0);
    this.e.setImageResource(2130840322);
  }
  
  public void setLeftText(CharSequence paramCharSequence, int paramInt)
  {
    this.f.setVisibility(0);
    this.f.setText(paramCharSequence);
    this.f.setTextColor(getResources().getColor(paramInt));
  }
  
  public void setLeftTextMargin(int paramInt)
  {
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.leftMargin = paramInt;
    localLayoutParams.addRule(15);
    this.f.setGravity(13);
    this.f.setLayoutParams(localLayoutParams);
  }
  
  public void setMiddleText(String paramString)
  {
    this.g.setText(paramString);
  }
  
  public void setOnLeftButtonClickListener(View.OnClickListener paramOnClickListener)
  {
    this.d = paramOnClickListener;
  }
  
  public void setOnRightButtonClickListener(View.OnClickListener paramOnClickListener)
  {
    this.b = paramOnClickListener;
  }
  
  public void setRightIv2ndListener(View.OnClickListener paramOnClickListener)
  {
    this.l.setOnClickListener(this);
    this.c = paramOnClickListener;
  }
  
  public void setRightTextColorSize(int paramInt1, int paramInt2)
  {
    this.j.setTextColor(getResources().getColor(paramInt1));
    this.j.setTextSize(paramInt2);
  }
  
  public void showLeftText(boolean paramBoolean, String paramString)
  {
    TextView localTextView = this.f;
    if (paramBoolean) {}
    for (int n = 0;; n = 4)
    {
      localTextView.setVisibility(n);
      if (paramBoolean) {
        this.f.setText(paramString);
      }
      return;
    }
  }
  
  public void showMiddlePic()
  {
    this.i.setVisibility(0);
    this.g.setVisibility(8);
  }
  
  public void showRightIc(boolean paramBoolean, int paramInt)
  {
    int i1 = 0;
    Object localObject = this.j;
    if (paramBoolean)
    {
      n = 8;
      ((TextView)localObject).setVisibility(n);
      localObject = this.k;
      if (!paramBoolean) {
        break label59;
      }
    }
    label59:
    for (int n = i1;; n = 8)
    {
      ((ImageView)localObject).setVisibility(n);
      if (paramBoolean) {
        this.k.setImageResource(paramInt);
      }
      return;
      n = 0;
      break;
    }
  }
  
  public void showRightIv2nd(boolean paramBoolean, int paramInt)
  {
    if (this.l == null) {
      this.l = ((ImageView)findViewById(2131694591));
    }
    ImageView localImageView = this.l;
    if (paramBoolean) {}
    for (int n = 0;; n = 8)
    {
      localImageView.setVisibility(n);
      if (paramBoolean) {
        this.l.setImageResource(paramInt);
      }
      return;
    }
  }
  
  public void showRightText(boolean paramBoolean, String paramString)
  {
    TextView localTextView = this.j;
    if (paramBoolean) {}
    for (int n = 0;; n = 4)
    {
      localTextView.setVisibility(n);
      if (paramBoolean) {
        this.j.setText(paramString);
      }
      return;
    }
  }
  
  public void showTopLine(ListView paramListView)
  {
    paramListView.setOnScrollListener(new AbsListView.OnScrollListener()
    {
      public void onScroll(AbsListView paramAnonymousAbsListView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        paramAnonymousInt2 = 0;
        if (paramAnonymousInt1 == 0)
        {
          paramAnonymousAbsListView = paramAnonymousAbsListView.getChildAt(0);
          if (paramAnonymousAbsListView == null) {}
          for (paramAnonymousInt1 = paramAnonymousInt2;; paramAnonymousInt1 = paramAnonymousAbsListView.getTop())
          {
            float f2 = Math.abs(paramAnonymousInt1) / 100.0F;
            paramAnonymousAbsListView = CommonTitle.this;
            float f1 = f2;
            if (f2 > 1.0F) {
              f1 = 1.0F;
            }
            paramAnonymousAbsListView.setBottomLineAlpha(f1);
            return;
          }
        }
        CommonTitle.this.setBottomLineAlpha(1.0F);
      }
      
      public void onScrollStateChanged(AbsListView paramAnonymousAbsListView, int paramAnonymousInt) {}
    });
  }
  
  public void showTopLine(ObservableScrollView paramObservableScrollView)
  {
    paramObservableScrollView.setOnScrollChangedCallback(new ObservableScrollView.a()
    {
      public void onScroll(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        if (paramAnonymousInt2 / 500.0F > 0.85D)
        {
          CommonTitle.this.setBottomLineVisible(true);
          return;
        }
        CommonTitle.this.setBottomLineVisible(false);
      }
    });
  }
  
  public void updateTitleWidth()
  {
    if (this.l == null) {
      return;
    }
    this.l.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener()
    {
      public void onGlobalLayout()
      {
        Rect localRect = new Rect();
        CommonTitle.a(CommonTitle.this).getGlobalVisibleRect(localRect);
        int i = ac.getScreenWidth(CommonTitle.b(CommonTitle.this)) - localRect.left;
        u.e("error", "mr = ong " + i);
        RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)CommonTitle.c(CommonTitle.this).getLayoutParams();
        localLayoutParams.setMargins(i, 0, i, 0);
        CommonTitle.c(CommonTitle.this).setLayoutParams(localLayoutParams);
        if (localRect.left != 0) {
          CommonTitle.a(CommonTitle.this).getViewTreeObserver().removeOnGlobalLayoutListener(this);
        }
      }
    });
    Object localObject = new Rect();
    this.l.getGlobalVisibleRect((Rect)localObject);
    int n = ac.getScreenWidth(this.a) - ((Rect)localObject).left;
    if (((Rect)localObject).left != 0)
    {
      u.e("error", "mr -------- " + n);
      localObject = (RelativeLayout.LayoutParams)this.f.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).setMargins(n, 0, n, 0);
      this.f.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    this.f.setEllipsize(TextUtils.TruncateAt.END);
  }
  
  public void updateTitleWidth2()
  {
    if (this.j == null) {
      return;
    }
    this.j.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener()
    {
      public void onGlobalLayout()
      {
        Rect localRect = new Rect();
        CommonTitle.d(CommonTitle.this).getGlobalVisibleRect(localRect);
        int i = ac.getScreenWidth(CommonTitle.b(CommonTitle.this)) - localRect.left;
        u.e("error", "mr = ong " + i);
        RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)CommonTitle.e(CommonTitle.this).getLayoutParams();
        localLayoutParams.setMargins(i, 0, i, 0);
        CommonTitle.e(CommonTitle.this).setLayoutParams(localLayoutParams);
        if (localRect.left != 0) {
          CommonTitle.d(CommonTitle.this).getViewTreeObserver().removeOnGlobalLayoutListener(this);
        }
      }
    });
    Object localObject = new Rect();
    this.j.getGlobalVisibleRect((Rect)localObject);
    int n = ac.getScreenWidth(this.a) - ((Rect)localObject).left;
    if (((Rect)localObject).left != 0)
    {
      u.e("error", "mr -------- " + n);
      localObject = (RelativeLayout.LayoutParams)this.f.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).setMargins(n, 0, n, 0);
      this.f.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    this.f.setEllipsize(TextUtils.TruncateAt.END);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/view/CommonTitle.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */