package com.ziroom.ziroomcustomer.bestgoods.activity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.bestgoods.model.aj;
import com.ziroom.ziroomcustomer.bestgoods.model.aj.a;
import com.ziroom.ziroomcustomer.bestgoods.model.aj.a.a;
import com.ziroom.ziroomcustomer.e.c.a.e;
import com.ziroom.ziroomcustomer.e.c.m;
import com.ziroom.ziroomcustomer.e.n;
import com.ziroom.ziroomcustomer.newrepair.utils.ListViewForScrollView;
import java.util.List;

public class YouPinDeliverDescActivity
  extends BaseActivity
{
  private ListViewForScrollView a;
  private YouPinDeliverDescActivity b;
  private ImageView c;
  private TextView d;
  private TextView e;
  private TextView f;
  private aj g;
  private List<aj.a.a> r;
  private TextView s;
  private TextView t;
  
  private void a()
  {
    this.a = ((ListViewForScrollView)findViewById(2131692737));
    this.c = ((ImageView)findViewById(2131689492));
    this.d = ((TextView)findViewById(2131692736));
    this.s = ((TextView)findViewById(2131692738));
    this.e = ((TextView)findViewById(2131692739));
    this.f = ((TextView)findViewById(2131692740));
    this.t = ((TextView)findViewById(2131692741));
  }
  
  private void b()
  {
    this.c.setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        YouPinDeliverDescActivity.this.finish();
      }
    });
    e();
  }
  
  private void e()
  {
    n.getYouPinDeliverAreaDesc(this.b, new com.ziroom.ziroomcustomer.e.a.a(this.b, new m(aj.class, new e()))
    {
      public void onSuccess(int paramAnonymousInt, aj paramAnonymousaj)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousaj);
        if (paramAnonymousaj != null)
        {
          YouPinDeliverDescActivity.a(YouPinDeliverDescActivity.this, paramAnonymousaj);
          paramAnonymousaj = YouPinDeliverDescActivity.a(YouPinDeliverDescActivity.this).getList();
          if ((paramAnonymousaj != null) && (paramAnonymousaj.size() > 0))
          {
            paramAnonymousInt = 0;
            while (paramAnonymousInt < paramAnonymousaj.size())
            {
              String str = ((aj.a)paramAnonymousaj.get(paramAnonymousInt)).getCode();
              if ("1".equals(str))
              {
                YouPinDeliverDescActivity.b(YouPinDeliverDescActivity.this).setText(((aj.a)paramAnonymousaj.get(paramAnonymousInt)).getTypeName());
                YouPinDeliverDescActivity.c(YouPinDeliverDescActivity.this).setAdapter(new YouPinDeliverDescActivity.a(YouPinDeliverDescActivity.this));
                YouPinDeliverDescActivity.d(YouPinDeliverDescActivity.this).setText(((aj.a)paramAnonymousaj.get(paramAnonymousInt)).getAreaDetailText());
              }
              if ("0".equals(str))
              {
                YouPinDeliverDescActivity.e(YouPinDeliverDescActivity.this).setText(((aj.a)paramAnonymousaj.get(paramAnonymousInt)).getTypeName());
                YouPinDeliverDescActivity.f(YouPinDeliverDescActivity.this).setText(((aj.a.a)((aj.a)paramAnonymousaj.get(paramAnonymousInt)).getAreaDetailList().get(0)).getRegion());
                YouPinDeliverDescActivity.g(YouPinDeliverDescActivity.this).setText(((aj.a)paramAnonymousaj.get(paramAnonymousInt)).getAreaDetailText());
              }
              paramAnonymousInt += 1;
            }
          }
        }
      }
    });
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903564);
    this.b = this;
    a();
    b();
  }
  
  public class a
    extends BaseAdapter
  {
    public a() {}
    
    public int getCount()
    {
      List localList = YouPinDeliverDescActivity.a(YouPinDeliverDescActivity.this).getList();
      if ((localList != null) && (!localList.isEmpty()))
      {
        int i = 0;
        while (i < localList.size())
        {
          if ("1".equals(((aj.a)localList.get(i)).getCode())) {
            YouPinDeliverDescActivity.a(YouPinDeliverDescActivity.this, ((aj.a)localList.get(i)).getAreaDetailList());
          }
          i += 1;
        }
      }
      if (YouPinDeliverDescActivity.h(YouPinDeliverDescActivity.this) == null) {
        return 0;
      }
      return YouPinDeliverDescActivity.h(YouPinDeliverDescActivity.this).size();
    }
    
    public Object getItem(int paramInt)
    {
      return null;
    }
    
    public long getItemId(int paramInt)
    {
      return 0L;
    }
    
    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      if (paramView == null)
      {
        paramView = View.inflate(YouPinDeliverDescActivity.i(YouPinDeliverDescActivity.this), 2130904582, null);
        paramViewGroup = new a();
        paramViewGroup.a = ((TextView)paramView.findViewById(2131694971));
        paramViewGroup.b = ((TextView)paramView.findViewById(2131695819));
        paramView.setTag(paramViewGroup);
      }
      for (;;)
      {
        paramViewGroup.a.setText(((aj.a.a)YouPinDeliverDescActivity.h(YouPinDeliverDescActivity.this).get(paramInt)).getCityName());
        paramViewGroup.b.setText(((aj.a.a)YouPinDeliverDescActivity.h(YouPinDeliverDescActivity.this).get(paramInt)).getRegion());
        return paramView;
        paramViewGroup = (a)paramView.getTag();
      }
    }
    
    public class a
    {
      public TextView a;
      public TextView b;
      
      public a() {}
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/bestgoods/activity/YouPinDeliverDescActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */