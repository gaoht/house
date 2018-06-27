package com.ziroom.ziroomcustomer.payment.views;

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
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.util.ac;
import com.ziroom.ziroomcustomer.util.u;

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
  private ImageView h;
  private TextView i;
  private ImageView j;
  private ImageView k;
  private View l;
  
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
      this.b.onClick(this.i);
      return;
    } while (this.c == null);
    this.c.onClick(paramView);
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    this.i = ((TextView)findViewById(2131694576));
    this.g = ((TextView)findViewById(2131694574));
    this.h = ((ImageView)findViewById(2131694575));
    this.f = ((TextView)findViewById(2131691400));
    this.e = ((ImageView)findViewById(2131691399));
    this.j = ((ImageView)findViewById(2131690751));
    this.l = findViewById(2131690079);
    this.e.setOnClickListener(this);
    this.i.setOnClickListener(this);
    this.f.setOnClickListener(this);
    this.j.setOnClickListener(this);
  }
  
  public void rightButtonPerformClick()
  {
    this.i.performClick();
  }
  
  public void setBackground(int paramInt)
  {
    setBackgroundColor(getResources().getColor(paramInt));
  }
  
  public void setBottomLineVisible(boolean paramBoolean)
  {
    View localView = this.l;
    if (paramBoolean) {}
    for (int m = 0;; m = 8)
    {
      localView.setVisibility(m);
      return;
    }
  }
  
  public void setLeftButtonType(int paramInt)
  {
    if (paramInt == 0)
    {
      this.e.setVisibility(0);
      setBackground(2131624583);
      this.e.setImageResource(2130840142);
    }
    do
    {
      return;
      if (paramInt == 3)
      {
        this.e.setVisibility(0);
        setBackground(2131624583);
        this.e.setImageResource(2130840141);
        return;
      }
      if (paramInt == -1)
      {
        this.e.setVisibility(8);
        return;
      }
      if (paramInt == 1)
      {
        this.e.setVisibility(0);
        setBackground(17170445);
        this.e.setImageResource(2130840142);
        return;
      }
    } while (paramInt != 2);
    this.e.setVisibility(0);
    setBackground(2131624583);
    this.e.setImageResource(2130840141);
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
    this.k.setOnClickListener(this);
    this.c = paramOnClickListener;
  }
  
  public void setRightTextColorSize(int paramInt1, int paramInt2)
  {
    this.i.setTextColor(getResources().getColor(paramInt1));
    this.i.setTextSize(paramInt2);
  }
  
  public void showLeftText(boolean paramBoolean, String paramString)
  {
    TextView localTextView = this.f;
    if (paramBoolean) {}
    for (int m = 0;; m = 4)
    {
      localTextView.setVisibility(m);
      if (paramBoolean) {
        this.f.setText(paramString);
      }
      return;
    }
  }
  
  public void showMiddlePic()
  {
    this.h.setVisibility(0);
    this.g.setVisibility(8);
  }
  
  public void showRightIc(boolean paramBoolean, int paramInt)
  {
    int n = 0;
    Object localObject = this.i;
    if (paramBoolean)
    {
      m = 8;
      ((TextView)localObject).setVisibility(m);
      localObject = this.j;
      if (!paramBoolean) {
        break label59;
      }
    }
    label59:
    for (int m = n;; m = 8)
    {
      ((ImageView)localObject).setVisibility(m);
      if (paramBoolean) {
        this.j.setImageResource(paramInt);
      }
      return;
      m = 0;
      break;
    }
  }
  
  public void showRightIv2nd(boolean paramBoolean, int paramInt)
  {
    if (this.k == null) {
      this.k = ((ImageView)findViewById(2131694591));
    }
    ImageView localImageView = this.k;
    if (paramBoolean) {}
    for (int m = 0;; m = 8)
    {
      localImageView.setVisibility(m);
      if (paramBoolean) {
        this.k.setImageResource(paramInt);
      }
      return;
    }
  }
  
  public void showRightText(boolean paramBoolean, String paramString)
  {
    TextView localTextView = this.i;
    if (paramBoolean) {}
    for (int m = 0;; m = 4)
    {
      localTextView.setVisibility(m);
      if (paramBoolean) {
        this.i.setText(paramString);
      }
      return;
    }
  }
  
  public void updateTitleWidth()
  {
    if (this.k == null) {
      return;
    }
    this.k.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener()
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
    this.k.getGlobalVisibleRect((Rect)localObject);
    int m = ac.getScreenWidth(this.a) - ((Rect)localObject).left;
    if (((Rect)localObject).left != 0)
    {
      u.e("error", "mr -------- " + m);
      localObject = (RelativeLayout.LayoutParams)this.f.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).setMargins(m, 0, m, 0);
      this.f.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    this.f.setEllipsize(TextUtils.TruncateAt.END);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/payment/views/CommonTitle.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */