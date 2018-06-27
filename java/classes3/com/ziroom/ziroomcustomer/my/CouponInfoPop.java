package com.ziroom.ziroomcustomer.my;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.freelxl.baselibrary.f.g;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;

public class CouponInfoPop
  extends PopupWindow
  implements View.OnClickListener
{
  private Context a;
  private ImageView b;
  private LinearLayout c;
  private TextView d;
  private TextView e;
  private TextView f;
  private TextView g;
  private View h;
  private String i;
  
  public CouponInfoPop(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public CouponInfoPop(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public CouponInfoPop(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.a = paramContext;
    setSoftInputMode(16);
    setWidth(-1);
    setHeight(-1);
    setAnimationStyle(2131427507);
    this.h = LayoutInflater.from(paramContext).inflate(2130905032, null);
    a();
  }
  
  private void a()
  {
    this.b = ((ImageView)this.h.findViewById(2131690588));
    this.c = ((LinearLayout)this.h.findViewById(2131697268));
    this.d = ((TextView)this.h.findViewById(2131697269));
    this.e = ((TextView)this.h.findViewById(2131693221));
    this.f = ((TextView)this.h.findViewById(2131697270));
    this.g = ((TextView)this.h.findViewById(2131689858));
    this.b.setOnClickListener(this);
    this.e.setOnClickListener(this);
    setContentView(this.h);
  }
  
  @Instrumented
  public void onClick(View paramView)
  {
    VdsAgent.onClick(this, paramView);
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131690588: 
      dismiss();
      return;
    }
    paramView = this.a;
    Context localContext = this.a;
    ((ClipboardManager)paramView.getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("simple text", this.i));
    g.textToast(this.a, "已复制此内容");
  }
  
  public void show(View paramView, String paramString1, String paramString2)
  {
    this.i = paramString1;
    if (this.i != null)
    {
      this.d.setText("兑换码：" + paramString1);
      this.c.setVisibility(0);
      if (!TextUtils.isEmpty(paramString2)) {
        break label99;
      }
      this.f.setVisibility(8);
      this.g.setVisibility(8);
    }
    for (;;)
    {
      if ((this instanceof PopupWindow)) {
        break label126;
      }
      super.showAtLocation(paramView, 0, 0, 0);
      return;
      this.c.setVisibility(8);
      break;
      label99:
      this.g.setText(paramString2);
      this.f.setVisibility(0);
      this.g.setVisibility(0);
    }
    label126:
    VdsAgent.showAtLocation((PopupWindow)this, paramView, 0, 0, 0);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/my/CouponInfoPop.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */