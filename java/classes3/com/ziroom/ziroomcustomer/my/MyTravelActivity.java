package com.ziroom.ziroomcustomer.my;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.h;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.PopupWindow;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.minsu.activity.MinsuMyActivity;
import com.ziroom.ziroomcustomer.minsu.dialog.i;
import com.ziroom.ziroomcustomer.minsu.f.k;
import com.ziroom.ziroomcustomer.my.adapter.MyTravelListAdapter;
import com.ziroom.ziroomcustomer.my.adapter.MyTravelListAdapter.a;
import com.ziroom.ziroomcustomer.my.model.MyTravelOrder;
import com.ziroom.ziroomcustomer.util.ae;
import com.ziroom.ziroomcustomer.ziroomstation.utils.h;
import java.util.ArrayList;
import java.util.List;

public class MyTravelActivity
  extends BaseActivity
{
  i a;
  @BindView(2131691904)
  RecyclerView recyclerView;
  
  private void a(final MyTravelOrder paramMyTravelOrder)
  {
    final Object localObject = new ArrayList();
    ((List)localObject).add(getString(2131296612));
    ((List)localObject).add(getString(2131296632));
    this.a = new i(this, new AdapterView.OnItemClickListener()
    {
      @Instrumented
      public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        VdsAgent.onItemClick(this, paramAnonymousAdapterView, paramAnonymousView, paramAnonymousInt, paramAnonymousLong);
        paramAnonymousAdapterView = (String)localObject.get(paramAnonymousInt);
        if (MyTravelActivity.this.getString(2131296612).equals(paramAnonymousAdapterView)) {
          if (ae.notNull(paramMyTravelOrder.phone)) {
            k.callPhone(MyTravelActivity.this, paramMyTravelOrder.landlordMobile);
          }
        }
        for (;;)
        {
          MyTravelActivity.this.a.dismiss();
          return;
          MyTravelActivity.b(MyTravelActivity.this, paramMyTravelOrder);
        }
      }
    }, (List)localObject);
    paramMyTravelOrder = this.a;
    localObject = getWindow().getDecorView();
    if (!(paramMyTravelOrder instanceof PopupWindow))
    {
      paramMyTravelOrder.showAtLocation((View)localObject, 80, 0, 0);
      return;
    }
    VdsAgent.showAtLocation((PopupWindow)paramMyTravelOrder, (View)localObject, 80, 0, 0);
  }
  
  private void b(MyTravelOrder paramMyTravelOrder)
  {
    k.toImPage(this, paramMyTravelOrder.landlordUid, paramMyTravelOrder.fid, paramMyTravelOrder.rentWay, 2, MinsuMyActivity.class.getSimpleName());
  }
  
  @OnClick({2131689492})
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
    setContentView(2130903385);
    ButterKnife.bind(this);
    Object localObject = getIntent().getStringExtra("list");
    paramBundle = new MyTravelListAdapter();
    paramBundle.setList(h.parseArray((String)localObject, MyTravelOrder.class));
    localObject = new LinearLayoutManager(this);
    ((LinearLayoutManager)localObject).setOrientation(1);
    this.recyclerView.setLayoutManager((RecyclerView.h)localObject);
    paramBundle.setListener(new MyTravelListAdapter.a()
    {
      public void onClick(int paramAnonymousInt, MyTravelOrder paramAnonymousMyTravelOrder)
      {
        if (paramAnonymousMyTravelOrder.orderType == 1)
        {
          MyTravelActivity.a(MyTravelActivity.this, paramAnonymousMyTravelOrder);
          return;
        }
        k.callPhone(MyTravelActivity.this, paramAnonymousMyTravelOrder.phone);
      }
    });
    this.recyclerView.setAdapter(paramBundle);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/my/MyTravelActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */