package com.ziroom.ziroomcustomer.newclean.cardpay.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.freelxl.baselibrary.e.i.a;
import com.freelxl.baselibrary.f.d;
import com.freelxl.baselibrary.f.g;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.commonlibrary.widget.unifiedziroom.e;
import com.ziroom.commonlibrary.widget.unifiedziroom.e.a;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.e.n;
import com.ziroom.ziroomcustomer.model.UserInfo;
import com.ziroom.ziroomcustomer.newclean.cardpay.adapter.a.a;
import com.ziroom.ziroomcustomer.newclean.cardpay.model.CanBuyCard;
import com.ziroom.ziroomcustomer.widget.ListViewForScrollView;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CleanStoredCardBuyHalfPennyActivity
  extends BaseActivity
  implements a.a
{
  private ImageView a;
  private ListViewForScrollView b;
  private String c;
  private Context d;
  private com.ziroom.ziroomcustomer.newclean.cardpay.adapter.a e;
  private List<CanBuyCard> f = new ArrayList();
  private String g;
  private i.a r = new i.a()
  {
    public void onParse(String paramAnonymousString, com.freelxl.baselibrary.e.k paramAnonymousk)
    {
      d.d("CleanStoredCardBuyHalfPennyActivity", "====" + com.ziroom.ziroomcustomer.util.k.decrypt(paramAnonymousString));
      paramAnonymousString = com.alibaba.fastjson.a.parseObject(com.ziroom.ziroomcustomer.util.k.decrypt(paramAnonymousString));
      String str = (String)paramAnonymousString.get("status");
      if (("0".equals(str)) || ("success".equals(str)))
      {
        if (paramAnonymousString.get("data") != null) {
          paramAnonymousk.setObject(com.alibaba.fastjson.a.parseArray(paramAnonymousString.get("data").toString(), CanBuyCard.class));
        }
        paramAnonymousk.setSuccess(Boolean.valueOf(true));
        return;
      }
      if ("2".equals(str))
      {
        paramAnonymousk.setMessage((String)paramAnonymousString.get("message"));
        paramAnonymousk.setSuccess(Boolean.valueOf(false));
        paramAnonymousk.setCode("2");
        return;
      }
      paramAnonymousk.setMessage((String)paramAnonymousString.get("message"));
      paramAnonymousk.setSuccess(Boolean.valueOf(false));
    }
    
    public void onSuccess(com.freelxl.baselibrary.e.k paramAnonymousk)
    {
      if (paramAnonymousk.getSuccess().booleanValue())
      {
        CleanStoredCardBuyHalfPennyActivity.a(CleanStoredCardBuyHalfPennyActivity.this, (List)paramAnonymousk.getObject());
        if ((CleanStoredCardBuyHalfPennyActivity.a(CleanStoredCardBuyHalfPennyActivity.this) != null) && (CleanStoredCardBuyHalfPennyActivity.a(CleanStoredCardBuyHalfPennyActivity.this).size() > 0))
        {
          CleanStoredCardBuyHalfPennyActivity.a(CleanStoredCardBuyHalfPennyActivity.this, new com.ziroom.ziroomcustomer.newclean.cardpay.adapter.a(CleanStoredCardBuyHalfPennyActivity.b(CleanStoredCardBuyHalfPennyActivity.this), CleanStoredCardBuyHalfPennyActivity.a(CleanStoredCardBuyHalfPennyActivity.this)));
          CleanStoredCardBuyHalfPennyActivity.d(CleanStoredCardBuyHalfPennyActivity.this).setAdapter(CleanStoredCardBuyHalfPennyActivity.c(CleanStoredCardBuyHalfPennyActivity.this));
          CleanStoredCardBuyHalfPennyActivity.e(CleanStoredCardBuyHalfPennyActivity.this);
        }
        return;
      }
      CleanStoredCardBuyHalfPennyActivity.d(CleanStoredCardBuyHalfPennyActivity.this).setVisibility(8);
      if ("2".equals(paramAnonymousk.getCode()))
      {
        paramAnonymousk = paramAnonymousk.getMessage();
        e.newBuilder(CleanStoredCardBuyHalfPennyActivity.b(CleanStoredCardBuyHalfPennyActivity.this)).setTitle("提示").setButtonText("我知道了").setContent(paramAnonymousk).setOnClickListener(new View.OnClickListener()
        {
          @Instrumented
          public void onClick(View paramAnonymous2View)
          {
            VdsAgent.onClick(this, paramAnonymous2View);
            CleanStoredCardBuyHalfPennyActivity.this.finish();
          }
        }).build().show();
        return;
      }
      g.textToast(CleanStoredCardBuyHalfPennyActivity.this, "服务异常");
    }
  };
  
  private void a()
  {
    this.a = ((ImageView)findViewById(2131689492));
    this.b = ((ListViewForScrollView)findViewById(2131690335));
  }
  
  private void b()
  {
    this.a.setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        CleanStoredCardBuyHalfPennyActivity.this.finish();
      }
    });
  }
  
  private void e()
  {
    f();
  }
  
  private void f()
  {
    UserInfo localUserInfo = ApplicationEx.c.getUser();
    if (localUserInfo != null) {}
    for (this.c = localUserInfo.getUid();; this.c = "")
    {
      n.getCanBuyCleanStoredCard(this, this.r, this.c, 1);
      return;
    }
  }
  
  private void g()
  {
    if (this.e == null) {
      return;
    }
    this.e.setOnclickPositionListener(this);
  }
  
  public void getClickView(int paramInt)
  {
    int i = ((CanBuyCard)this.f.get(paramInt)).getCid();
    Intent localIntent = new Intent(this.d, CleanStoredCardPayActivity.class);
    localIntent.putExtra("valueCardTypeId", i);
    localIntent.putExtra("accountName", this.g);
    localIntent.putExtra("storedCardName", ((CanBuyCard)this.f.get(paramInt)).getShowName());
    localIntent.putExtra("storedCardValid", ((CanBuyCard)this.f.get(paramInt)).getValidMonth());
    localIntent.putExtra("storedCardMoney", Long.parseLong(((CanBuyCard)this.f.get(paramInt)).getRechargeAmount()) / 100L + "");
    localIntent.putExtra("storedCardGiveMoney", ((CanBuyCard)this.f.get(paramInt)).getGiftCount().longValue() / 100L + "");
    startActivity(localIntent);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903152);
    this.d = this;
    a();
    b();
    e();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newclean/cardpay/activity/CleanStoredCardBuyHalfPennyActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */