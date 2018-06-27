package com.ziroom.ziroomcustomer.bestgoods.activity;

import android.content.Context;
import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.widget.ImageView;
import android.widget.TextView;
import com.ziroom.ziroomcustomer.bestgoods.fragment.YouPinOrderDetailFragment;
import com.ziroom.ziroomcustomer.bestgoods.fragment.YouPinOrderProgressFragment;
import com.ziroom.ziroomcustomer.bestgoods.model.ao;
import com.ziroom.ziroomcustomer.e.c.a.e;
import com.ziroom.ziroomcustomer.e.c.m;
import com.ziroom.ziroomcustomer.e.n;
import com.ziroom.ziroomcustomer.newServiceList.activity.ServiceDetailActivity;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class YouPinOrderDetailsActivity
  extends ServiceDetailActivity
{
  private Context r;
  private String s;
  private ao t;
  private String u;
  private List<a> v;
  
  private void b()
  {
    if ((this.v != null) && (this.v.size() > 0))
    {
      Iterator localIterator = this.v.iterator();
      while (localIterator.hasNext()) {
        ((a)localIterator.next()).onYpDetailsData(this.t);
      }
    }
  }
  
  protected void a()
  {
    super.a();
    this.r = this;
    this.s = getIntent().getStringExtra("orderCode");
    this.u = getIntent().getStringExtra("imgUrl");
    this.e.setVisibility(8);
    this.b.setText("自如优品");
    this.c.setText("订单进度");
    this.g.add(YouPinOrderProgressFragment.newInstance());
    this.g.add(YouPinOrderDetailFragment.newInstance(this.s, this.u));
    this.a.setCurrentItem(1);
    getServerData();
  }
  
  public void addOnYouPinOrderDetailsDataListener(a parama)
  {
    if (this.v == null) {
      this.v = new ArrayList();
    }
    this.v.add(parama);
  }
  
  public void getServerData()
  {
    n.getYouPinOrderDetailsInfo(this.r, this.s, new com.ziroom.ziroomcustomer.e.a.a(this.r, new m(ao.class, new e()))
    {
      public void onSuccess(int paramAnonymousInt, ao paramAnonymousao)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousao);
        YouPinOrderDetailsActivity.a(YouPinOrderDetailsActivity.this, paramAnonymousao);
        if (YouPinOrderDetailsActivity.a(YouPinOrderDetailsActivity.this) != null) {
          YouPinOrderDetailsActivity.b(YouPinOrderDetailsActivity.this);
        }
      }
    });
  }
  
  public static abstract interface a
  {
    public abstract void onYpDetailsData(ao paramao);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/bestgoods/activity/YouPinOrderDetailsActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */