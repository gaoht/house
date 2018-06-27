package com.ziroom.ziroomcustomer.findhouse.view;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.findhouse.presenter.model.PayType;
import com.ziroom.ziroomcustomer.findhouse.presenter.model.PayType.DetailsBean;
import com.ziroom.ziroomcustomer.signed.BoundCardActivity;
import com.ziroom.ziroomcustomer.util.s;
import com.ziroom.ziroomcustomer.webview.JsBridgeWebActivity;
import java.util.Iterator;
import java.util.List;

public class RentHouseDetailPayTypePop
  extends PopupWindow
  implements View.OnClickListener
{
  private ImageView a;
  private LinearLayout b;
  private LinearLayout c;
  private View d;
  private Context e;
  
  public RentHouseDetailPayTypePop(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public RentHouseDetailPayTypePop(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public RentHouseDetailPayTypePop(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    setSoftInputMode(16);
    setWidth(-1);
    setHeight(-1);
    setAnimationStyle(2131427507);
    this.d = LayoutInflater.from(paramContext).inflate(2130905038, null);
    this.e = paramContext;
    a();
  }
  
  private void a()
  {
    this.a = ((ImageView)this.d.findViewById(2131697275));
    this.b = ((LinearLayout)this.d.findViewById(2131697282));
    this.c = ((LinearLayout)this.d.findViewById(2131691089));
    this.a.setOnClickListener(this);
    setContentView(this.d);
  }
  
  @Instrumented
  public void onClick(View paramView)
  {
    VdsAgent.onClick(this, paramView);
    switch (paramView.getId())
    {
    default: 
      return;
    }
    dismiss();
  }
  
  public void show(View paramView, PayType paramPayType)
  {
    if (paramPayType == null) {
      return;
    }
    List localList = paramPayType.getReminder();
    paramPayType = paramPayType.getDetails();
    if (!s.isEmpty(paramPayType))
    {
      paramPayType = paramPayType.iterator();
      if (paramPayType.hasNext())
      {
        final PayType.DetailsBean localDetailsBean = (PayType.DetailsBean)paramPayType.next();
        RelativeLayout localRelativeLayout = (RelativeLayout)LayoutInflater.from(this.e).inflate(2130905039, null);
        TextView localTextView1 = (TextView)localRelativeLayout.findViewById(2131697285);
        TextView localTextView2 = (TextView)localRelativeLayout.findViewById(2131697284);
        TextView localTextView3 = (TextView)localRelativeLayout.findViewById(2131689533);
        TextView localTextView4 = (TextView)localRelativeLayout.findViewById(2131693772);
        ImageView localImageView = (ImageView)localRelativeLayout.findViewById(2131697283);
        localTextView3.setText(localDetailsBean.getTitle());
        localTextView2.setText("¥" + localDetailsBean.getRent_fee() + localDetailsBean.getRent_fee_unit());
        localTextView1.setText("押金： ¥" + localDetailsBean.getDeposit() + localDetailsBean.getDeposit_unit() + "  服务费： ¥" + localDetailsBean.getService_fee() + localDetailsBean.getService_fee_unit());
        if (!TextUtils.isEmpty(localDetailsBean.getLink_title()))
        {
          localTextView4.setVisibility(0);
          localTextView4.setText(localDetailsBean.getLink_title());
          localTextView4.setOnClickListener(new View.OnClickListener()
          {
            @Instrumented
            public void onClick(View paramAnonymousView)
            {
              VdsAgent.onClick(this, paramAnonymousView);
              if ((localDetailsBean.getLink_type() != null) && ("0".equals(localDetailsBean.getLink_type()))) {
                if ("bindcard".equals(localDetailsBean.getLink()))
                {
                  paramAnonymousView = new Intent(RentHouseDetailPayTypePop.a(RentHouseDetailPayTypePop.this), BoundCardActivity.class);
                  paramAnonymousView.putExtra("mBoundCardType", 1);
                  paramAnonymousView.putExtra("is_pre_bind", true);
                  RentHouseDetailPayTypePop.a(RentHouseDetailPayTypePop.this).startActivity(paramAnonymousView);
                }
              }
              while ((localDetailsBean.getLink_type() == null) || (!"1".equals(localDetailsBean.getLink_type()))) {
                return;
              }
              JsBridgeWebActivity.start(RentHouseDetailPayTypePop.a(RentHouseDetailPayTypePop.this), localDetailsBean.getTitle(), localDetailsBean.getLink(), false, null, null, false);
            }
          });
          label273:
          if (TextUtils.isEmpty(localDetailsBean.getMore_link())) {
            break label327;
          }
          localImageView.setVisibility(0);
          localImageView.setOnClickListener(new View.OnClickListener()
          {
            @Instrumented
            public void onClick(View paramAnonymousView)
            {
              VdsAgent.onClick(this, paramAnonymousView);
              if ((localDetailsBean.getMore_link_type() != null) && ("0".equals(localDetailsBean.getMore_link_type()))) {}
              while ((localDetailsBean.getMore_link_type() == null) || (!"1".equals(localDetailsBean.getMore_link_type()))) {
                return;
              }
              JsBridgeWebActivity.start(RentHouseDetailPayTypePop.a(RentHouseDetailPayTypePop.this), localDetailsBean.getTitle(), localDetailsBean.getMore_link(), false, null, null, false);
            }
          });
        }
        for (;;)
        {
          this.c.addView(localRelativeLayout);
          break;
          localTextView4.setVisibility(8);
          break label273;
          label327:
          localImageView.setVisibility(8);
        }
      }
    }
    if (!s.isEmpty(localList))
    {
      int i = 0;
      while (i < localList.size())
      {
        paramPayType = new TextView(ApplicationEx.c);
        paramPayType.setText((CharSequence)localList.get(i));
        paramPayType.setTextColor(Color.parseColor("#999999"));
        paramPayType.setTextSize(14.0F);
        paramPayType.setPadding(36, 24, 36, 0);
        paramPayType.setBackground(null);
        this.b.addView(paramPayType);
        i += 1;
      }
    }
    if (!(this instanceof PopupWindow))
    {
      super.showAtLocation(paramView, 0, 0, 0);
      return;
    }
    VdsAgent.showAtLocation((PopupWindow)this, paramView, 0, 0, 0);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/findhouse/view/RentHouseDetailPayTypePop.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */