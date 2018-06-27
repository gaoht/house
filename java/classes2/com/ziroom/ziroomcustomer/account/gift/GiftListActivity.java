package com.ziroom.ziroomcustomer.account.gift;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.account.model.GiftDrawBase;
import com.ziroom.ziroomcustomer.account.model.GiftListBase;
import com.ziroom.ziroomcustomer.account.model.GiftListBase.DataBean;
import com.ziroom.ziroomcustomer.account.model.GiftUnDrawBase;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.payment.d.b;
import com.ziroom.ziroomcustomer.payment.d.i;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GiftListActivity
  extends BaseActivity
{
  private TextView a;
  private ImageView b;
  private ListView c;
  private a d;
  private List<GiftDrawBase> e = new ArrayList();
  private boolean f = false;
  
  private void a()
  {
    b.getGifListResult(this, new i(this, new com.ziroom.ziroomcustomer.payment.d.a(GiftListBase.class))
    {
      public void onSuccess(int paramAnonymousInt, GiftListBase paramAnonymousGiftListBase)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousGiftListBase);
        paramAnonymousInt = paramAnonymousGiftListBase.getData().getUndrawCount();
        if (paramAnonymousInt != 0) {
          GiftListActivity.b(GiftListActivity.this).setText("共有" + paramAnonymousInt + "个未领取的返现红包");
        }
        for (;;)
        {
          GiftListActivity.c(GiftListActivity.this).clear();
          Iterator localIterator = paramAnonymousGiftListBase.getData().getUndraws().iterator();
          while (localIterator.hasNext())
          {
            GiftUnDrawBase localGiftUnDrawBase = (GiftUnDrawBase)localIterator.next();
            GiftDrawBase localGiftDrawBase = new GiftDrawBase();
            localGiftDrawBase.setEffectDate(localGiftUnDrawBase.getEffectDate());
            localGiftDrawBase.setMarketCode(localGiftUnDrawBase.getMarketCode());
            localGiftDrawBase.setMarketName(localGiftUnDrawBase.getMarketName());
            localGiftDrawBase.setRecordId(localGiftUnDrawBase.getRecordId());
            GiftListActivity.c(GiftListActivity.this).add(localGiftDrawBase);
          }
          GiftListActivity.b(GiftListActivity.this).setText("无未领取的返现红包");
        }
        GiftListActivity.c(GiftListActivity.this).addAll(paramAnonymousGiftListBase.getData().getDraws());
        GiftListActivity.d(GiftListActivity.this).notifyDataSetChanged();
      }
    });
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 == 201)
    {
      this.f = true;
      a();
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903382);
    this.a = ((TextView)findViewById(2131689857));
    this.b = ((ImageView)findViewById(2131689492));
    this.c = ((ListView)findViewById(2131691892));
    this.b.setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        if (GiftListActivity.a(GiftListActivity.this)) {
          GiftListActivity.this.setResult(-1);
        }
        GiftListActivity.this.finish();
      }
    });
    this.d = new a(this, this.e);
    this.c.setAdapter(this.d);
    a();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/account/gift/GiftListActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */