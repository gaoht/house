package com.ziroom.ziroomcustomer.my;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewStub;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.adapter.MyWillPayAdapter.b;
import com.ziroom.ziroomcustomer.base.BaseFragment;
import com.ziroom.ziroomcustomer.e.d;
import com.ziroom.ziroomcustomer.e.l;
import com.ziroom.ziroomcustomer.model.NotPayEntity;
import com.ziroom.ziroomcustomer.my.adapter.FriendlyWillPayAdapter;
import com.ziroom.ziroomcustomer.util.n;
import java.util.List;

public class MyWillPayFriendlyBillFragment
  extends BaseFragment
  implements MyWillPayAdapter.b
{
  private Context a;
  private ListView b;
  private ViewStub c;
  private View d;
  private FriendlyWillPayAdapter e;
  private List<NotPayEntity> f;
  private Handler g = new Handler()
  {
    public void handleMessage(Message paramAnonymousMessage)
    {
      l locall = (l)paramAnonymousMessage.obj;
      switch (paramAnonymousMessage.what)
      {
      }
      for (;;)
      {
        MyWillPayFriendlyBillFragment.this.dismissProgress();
        return;
        if (locall.getSuccess().booleanValue())
        {
          MyWillPayFriendlyBillFragment.a(MyWillPayFriendlyBillFragment.this, (List)locall.getObject());
          if ((MyWillPayFriendlyBillFragment.a(MyWillPayFriendlyBillFragment.this) != null) && (MyWillPayFriendlyBillFragment.a(MyWillPayFriendlyBillFragment.this).size() > 0))
          {
            if (MyWillPayFriendlyBillFragment.b(MyWillPayFriendlyBillFragment.this).getVisibility() == 0)
            {
              MyWillPayFriendlyBillFragment.b(MyWillPayFriendlyBillFragment.this).setVisibility(8);
              MyWillPayFriendlyBillFragment.c(MyWillPayFriendlyBillFragment.this).setVisibility(0);
            }
            MyWillPayFriendlyBillFragment.a(MyWillPayFriendlyBillFragment.this, new FriendlyWillPayAdapter(MyWillPayFriendlyBillFragment.d(MyWillPayFriendlyBillFragment.this), MyWillPayFriendlyBillFragment.a(MyWillPayFriendlyBillFragment.this)));
            MyWillPayFriendlyBillFragment.c(MyWillPayFriendlyBillFragment.this).setAdapter(MyWillPayFriendlyBillFragment.e(MyWillPayFriendlyBillFragment.this));
          }
          else
          {
            MyWillPayFriendlyBillFragment.this.showError("暂无订单");
          }
        }
        else
        {
          MyWillPayFriendlyBillFragment.this.showError(locall.getMessage());
        }
      }
    }
  };
  
  public static MyWillPayFriendlyBillFragment getInstance()
  {
    return new MyWillPayFriendlyBillFragment();
  }
  
  public void loadData()
  {
    showProgress("");
    d.getNotPayEntity(this.g);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.a = getActivity();
    this.d = paramLayoutInflater.inflate(2130903888, paramViewGroup, false);
    this.c = ((ViewStub)this.d.findViewById(2131690620));
    this.b = ((ListView)this.d.findViewById(2131689817));
    ((ViewGroup.MarginLayoutParams)this.b.getLayoutParams()).setMargins(n.dip2px(this.a, 14.0F), 0, n.dip2px(this.a, 14.0F), 0);
    loadData();
    return this.d;
  }
  
  public void showError(String paramString)
  {
    this.c.setVisibility(0);
    ((TextView)this.d.findViewById(2131690822)).setText(paramString);
    ((LinearLayout)this.d.findViewById(2131694408)).setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
      }
    });
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/my/MyWillPayFriendlyBillFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */