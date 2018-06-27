package com.ziroom.ziroomcustomer.account.gift;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.account.model.GiftDrawBase;
import com.ziroom.ziroomcustomer.account.model.GiftListItemBase;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.payment.d.i;
import java.text.DecimalFormat;
import java.util.List;

public class a
  extends com.freelxl.baselibrary.a.a<GiftDrawBase>
  implements View.OnClickListener
{
  Context d;
  
  public a(Context paramContext, List<GiftDrawBase> paramList)
  {
    super(paramContext, paramList, 2130904118);
    this.d = paramContext;
  }
  
  private String a(String paramString)
  {
    Object localObject;
    if ((paramString == null) || (paramString.equals("")))
    {
      localObject = "";
      return (String)localObject;
    }
    String str = "";
    int i = 0;
    for (;;)
    {
      localObject = str;
      if (i >= paramString.length()) {
        break;
      }
      str = str + paramString.substring(i, i + 1) + "   ";
      i += 1;
    }
  }
  
  private void a(String paramString1, String paramString2)
  {
    com.ziroom.ziroomcustomer.payment.d.b.getOpenGiftResult((Activity)this.d, paramString1, paramString2, new i(this.d, new com.ziroom.ziroomcustomer.payment.d.a(GiftListItemBase.class))
    {
      public void onSuccess(int paramAnonymousInt, GiftListItemBase paramAnonymousGiftListItemBase)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousGiftListItemBase);
        Bundle localBundle = new Bundle();
        localBundle.putSerializable("giftBase", paramAnonymousGiftListItemBase.getData());
        paramAnonymousGiftListItemBase = new Intent(this.b, GiftDetailsActivity.class);
        paramAnonymousGiftListItemBase.putExtras(localBundle);
        ((BaseActivity)this.b).startActivityForResult(paramAnonymousGiftListItemBase, 201);
      }
    });
  }
  
  public void convert(com.freelxl.baselibrary.a.b paramb, GiftDrawBase paramGiftDrawBase) {}
  
  public void convert(com.freelxl.baselibrary.a.b paramb, GiftDrawBase paramGiftDrawBase, int paramInt)
  {
    super.convert(paramb, paramGiftDrawBase, paramInt);
    if (paramGiftDrawBase.getAmount() > 0.0D)
    {
      DecimalFormat localDecimalFormat = new DecimalFormat("######0.00");
      paramb.setVisibility(2131694817, 8);
      paramb.setVisibility(2131694820, 0);
      paramb.setText(2131689846, "￥" + localDecimalFormat.format(paramGiftDrawBase.getAmount()));
      paramb.setText(2131690084, a(paramGiftDrawBase.getMarketName()));
      return;
    }
    paramb.setVisibility(2131694817, 0);
    paramb.setVisibility(2131694820, 8);
    paramb.setOnClickListener(2131692908, this);
    paramb.setText(2131689852, paramGiftDrawBase.getEffectDate() + "");
    paramb.setText(2131689541, a(paramGiftDrawBase.getMarketName()));
    paramb.setTag(2131692908, paramGiftDrawBase);
  }
  
  @Instrumented
  public void onClick(View paramView)
  {
    VdsAgent.onClick(this, paramView);
    paramView = (GiftDrawBase)paramView.getTag();
    a(paramView.getRecordId() + "", paramView.getMarketCode());
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/account/gift/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */