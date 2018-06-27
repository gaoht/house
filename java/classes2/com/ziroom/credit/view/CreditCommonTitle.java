package com.ziroom.credit.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.credit.R.color;
import com.ziroom.credit.R.drawable;
import com.ziroom.credit.R.id;

public class CreditCommonTitle
  extends RelativeLayout
  implements View.OnClickListener
{
  private Context a;
  private View.OnClickListener b;
  private View.OnClickListener c;
  private ImageView d;
  private TextView e;
  private TextView f;
  private ImageView g;
  private TextView h;
  private ImageView i;
  private View j;
  
  public CreditCommonTitle(Context paramContext)
  {
    super(paramContext);
    this.a = paramContext;
  }
  
  public CreditCommonTitle(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.a = paramContext;
  }
  
  public TextView getLeftText()
  {
    return this.e;
  }
  
  @Instrumented
  public void onClick(View paramView)
  {
    VdsAgent.onClick(this, paramView);
    int k = paramView.getId();
    if ((k == R.id.credit_iv_header_left_arrow) || (k == R.id.credit_leftText)) {
      if (this.c != null) {
        this.c.onClick(this.d);
      }
    }
    while (((k != R.id.credit_tv_header_right) && (k != R.id.credit_iv_my_user)) || (this.b == null)) {
      return;
    }
    this.b.onClick(this.h);
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    this.h = ((TextView)findViewById(R.id.credit_tv_header_right));
    this.f = ((TextView)findViewById(R.id.credit_tv_header_title));
    this.g = ((ImageView)findViewById(R.id.credit_iv_header_title));
    this.e = ((TextView)findViewById(R.id.credit_leftText));
    this.d = ((ImageView)findViewById(R.id.credit_iv_header_left_arrow));
    this.i = ((ImageView)findViewById(R.id.credit_iv_my_user));
    this.j = findViewById(R.id.credit_bottom_line);
    this.d.setOnClickListener(this);
    this.h.setOnClickListener(this);
    this.e.setOnClickListener(this);
    this.i.setOnClickListener(this);
  }
  
  public void rightButtonPerformClick()
  {
    this.h.performClick();
  }
  
  public void setBackground(int paramInt)
  {
    setBackgroundColor(getResources().getColor(paramInt));
  }
  
  public void setBottomLineVisible(boolean paramBoolean)
  {
    View localView = this.j;
    if (paramBoolean) {}
    for (int k = 0;; k = 8)
    {
      localView.setVisibility(k);
      return;
    }
  }
  
  public void setCreditTitleStatic(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.d.setImageResource(R.drawable.zrk_ic_back);
      this.f.setTextColor(-16777216);
      return;
    }
    this.d.setImageResource(R.drawable.zrk_ic_back_white);
    this.f.setTextColor(-1);
  }
  
  public void setLeftButtonType(int paramInt)
  {
    if (paramInt == 0)
    {
      this.d.setVisibility(0);
      setBackground(R.color.white);
      this.d.setImageResource(R.drawable.zrk_ic_back);
    }
    do
    {
      return;
      if (paramInt == 3)
      {
        this.d.setVisibility(0);
        setBackgroundColor(-1);
        this.j.setVisibility(8);
        this.f.setTextColor(-1);
        getBackground().setAlpha(0);
        this.d.setImageResource(R.drawable.zrk_ic_back_white);
        return;
      }
      if (paramInt == -1)
      {
        this.d.setVisibility(8);
        return;
      }
      if (paramInt == 1)
      {
        this.d.setVisibility(0);
        setBackground(17170445);
        this.d.setImageResource(R.drawable.zrk_ic_back_white);
        return;
      }
    } while (paramInt != 2);
    this.d.setVisibility(0);
    setBackground(R.color.white);
    this.d.setImageResource(R.drawable.zrk_ic_back);
  }
  
  public void setLeftText(CharSequence paramCharSequence, int paramInt)
  {
    this.e.setVisibility(0);
    this.e.setText(paramCharSequence);
    this.e.setTextColor(getResources().getColor(paramInt));
  }
  
  public void setLeftTextMargin(int paramInt)
  {
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.leftMargin = paramInt;
    localLayoutParams.addRule(15);
    this.e.setGravity(13);
    this.e.setLayoutParams(localLayoutParams);
  }
  
  public void setMiddleText(String paramString)
  {
    this.f.setText(paramString);
  }
  
  public void setOnLeftButtonClickListener(View.OnClickListener paramOnClickListener)
  {
    this.c = paramOnClickListener;
  }
  
  public void setOnRightButtonClickListener(View.OnClickListener paramOnClickListener)
  {
    this.b = paramOnClickListener;
  }
  
  public void setRightTextColorSize(int paramInt1, int paramInt2)
  {
    this.h.setTextColor(getResources().getColor(paramInt1));
    this.h.setTextSize(paramInt2);
  }
  
  public void showLeftText(boolean paramBoolean, String paramString)
  {
    TextView localTextView = this.e;
    if (paramBoolean) {}
    for (int k = 0;; k = 4)
    {
      localTextView.setVisibility(k);
      if (paramBoolean) {
        this.e.setText(paramString);
      }
      return;
    }
  }
  
  public void showMiddlePic()
  {
    this.g.setVisibility(0);
    this.f.setVisibility(8);
  }
  
  public void showRightIc(boolean paramBoolean, int paramInt)
  {
    int m = 0;
    Object localObject = this.h;
    if (paramBoolean)
    {
      k = 8;
      ((TextView)localObject).setVisibility(k);
      localObject = this.i;
      if (!paramBoolean) {
        break label59;
      }
    }
    label59:
    for (int k = m;; k = 8)
    {
      ((ImageView)localObject).setVisibility(k);
      if (paramBoolean) {
        this.i.setImageResource(paramInt);
      }
      return;
      k = 0;
      break;
    }
  }
  
  public void showRightText(boolean paramBoolean, String paramString)
  {
    TextView localTextView = this.h;
    if (paramBoolean) {}
    for (int k = 0;; k = 4)
    {
      localTextView.setVisibility(k);
      if (paramBoolean) {
        this.h.setText(paramString);
      }
      return;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/credit/view/CreditCommonTitle.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */