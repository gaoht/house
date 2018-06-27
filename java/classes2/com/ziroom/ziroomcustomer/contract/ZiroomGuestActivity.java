package com.ziroom.ziroomcustomer.contract;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Gallery;
import android.widget.TextView;
import com.freelxl.baselibrary.f.g;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.e.d;
import com.ziroom.ziroomcustomer.e.l;
import com.ziroom.ziroomcustomer.life.ZirukeDetailActivity;
import com.ziroom.ziroomcustomer.model.HomeIndex;
import com.ziroom.ziroomcustomer.util.ah;
import java.util.ArrayList;
import java.util.List;

public class ZiroomGuestActivity
  extends BaseActivity
  implements View.OnClickListener
{
  private Gallery a;
  private Context b;
  private ArrayList<HomeIndex> c = new ArrayList();
  private TextView d;
  private TextView e;
  private TextView f;
  private Handler g = new Handler()
  {
    public void handleMessage(Message paramAnonymousMessage)
    {
      l locall = (l)paramAnonymousMessage.obj;
      switch (paramAnonymousMessage.what)
      {
      default: 
        return;
      }
      if (locall.getSuccess().booleanValue())
      {
        paramAnonymousMessage = new ArrayList();
        ZiroomGuestActivity.a(ZiroomGuestActivity.this, (ArrayList)locall.getObject());
        if ((ZiroomGuestActivity.e(ZiroomGuestActivity.this) != null) && (ZiroomGuestActivity.e(ZiroomGuestActivity.this).size() > 0))
        {
          int i = 0;
          while (i < ZiroomGuestActivity.e(ZiroomGuestActivity.this).size())
          {
            paramAnonymousMessage.add(ZiroomGuestActivity.e(ZiroomGuestActivity.this).get(i));
            i += 1;
          }
          ZiroomGuestActivity.a(ZiroomGuestActivity.this).setmList(paramAnonymousMessage);
          ZiroomGuestActivity.a(ZiroomGuestActivity.this).notifyDataSetChanged();
        }
      }
      for (;;)
      {
        ZiroomGuestActivity.this.dismissProgress();
        return;
        ZiroomGuestActivity.this.showToast(locall.getMessage());
      }
    }
  };
  private c r;
  
  public void initView()
  {
    this.f = ((TextView)findViewById(2131697835));
    this.f.setOnClickListener(this);
    this.a = ((Gallery)findViewById(2131697837));
    this.d = ((TextView)findViewById(2131697838));
    this.e = ((TextView)findViewById(2131697839));
    this.r = new c(this.b, this.c);
    this.a.setAdapter(this.r);
    this.a.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
    {
      @Instrumented
      public void onItemSelected(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        VdsAgent.onItemSelected(this, paramAnonymousAdapterView, paramAnonymousView, paramAnonymousInt, paramAnonymousLong);
        ZiroomGuestActivity.b(ZiroomGuestActivity.this).setText(((HomeIndex)ZiroomGuestActivity.a(ZiroomGuestActivity.this).getmList().get(paramAnonymousInt)).getTitle());
        ZiroomGuestActivity.c(ZiroomGuestActivity.this).setText(((HomeIndex)ZiroomGuestActivity.a(ZiroomGuestActivity.this).getmList().get(paramAnonymousInt)).getSubtitle());
      }
      
      public void onNothingSelected(AdapterView<?> paramAnonymousAdapterView) {}
    });
    this.a.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      @Instrumented
      public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        VdsAgent.onItemClick(this, paramAnonymousAdapterView, paramAnonymousView, paramAnonymousInt, paramAnonymousLong);
        paramAnonymousAdapterView = new Intent(ZiroomGuestActivity.d(ZiroomGuestActivity.this), ZirukeDetailActivity.class);
        paramAnonymousAdapterView.putExtra("url", ((HomeIndex)ZiroomGuestActivity.a(ZiroomGuestActivity.this).getmList().get(paramAnonymousInt)).getUrl());
        paramAnonymousAdapterView.putExtra("title", ((HomeIndex)ZiroomGuestActivity.a(ZiroomGuestActivity.this).getmList().get(paramAnonymousInt)).getTitle());
        paramAnonymousAdapterView.putExtra("pic", ((HomeIndex)ZiroomGuestActivity.a(ZiroomGuestActivity.this).getmList().get(paramAnonymousInt)).getPic());
        ZiroomGuestActivity.this.startActivity(paramAnonymousAdapterView);
      }
    });
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
    finish();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130905243);
    this.b = this;
    initView();
    if (!ah.checkNet(this.b))
    {
      g.textToast(this, "网络请求失败，请检查您的网络设置", 0);
      return;
    }
    d.getGuest(this.g);
    showProgress("");
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/contract/ZiroomGuestActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */