package com.ziroom.ziroomcustomer.my;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.PopupWindow;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.alibaba.fastjson.a;
import com.freelxl.baselibrary.f.a.c;
import com.freelxl.baselibrary.f.h;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.commonlib.utils.SignKeyUtil;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.minsu.activity.MinsuMyActivity;
import com.ziroom.ziroomcustomer.minsu.dialog.i;
import com.ziroom.ziroomcustomer.minsu.f.k;
import com.ziroom.ziroomcustomer.minsu.f.r;
import com.ziroom.ziroomcustomer.my.adapter.MyTravelListMoreAdapter;
import com.ziroom.ziroomcustomer.my.adapter.MyTravelListMoreAdapter.a;
import com.ziroom.ziroomcustomer.my.model.MinsuOrderBean;
import com.ziroom.ziroomcustomer.my.model.MinsuOrderBean.MinsuOrderListBean;
import com.ziroom.ziroomcustomer.my.model.MyTravelMinsuAndZiRuYiOrderMo;
import com.ziroom.ziroomcustomer.my.model.OrderDataBean;
import com.ziroom.ziroomcustomer.my.model.SortIndexBean;
import com.ziroom.ziroomcustomer.my.model.ZiruyiOrderBean;
import com.ziroom.ziroomcustomer.my.model.ZiruyiOrderBean.ZiRuYiOrderListBean;
import com.ziroom.ziroomcustomer.util.ae;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class MyTravelMoreActivity
  extends BaseActivity
{
  i a;
  private MyTravelMinsuAndZiRuYiOrderMo b;
  private MinsuOrderBean c;
  private List<MinsuOrderBean.MinsuOrderListBean> d;
  private ZiruyiOrderBean e;
  private List<ZiruyiOrderBean.ZiRuYiOrderListBean> f;
  private Context g;
  @BindView(2131691904)
  RecyclerView recyclerView;
  
  private void a()
  {
    Object localObject = new HashMap();
    ((Map)localObject).put("page", Integer.valueOf(1));
    ((Map)localObject).put("limit", Integer.valueOf(10));
    ((Map)localObject).put("tenantOrderStatus", "");
    localObject = signMethod((Map)localObject);
    com.ziroom.ziroomcustomer.minsu.e.d.requestNoDES(this, com.ziroom.ziroomcustomer.minsu.b.d.f, "/orderTen/ea61d2/unCheckinMsYzOrderList", (Map)localObject, true, new Callback()
    {
      public void onFailure(Call paramAnonymousCall, IOException paramAnonymousIOException)
      {
        MyTravelMoreActivity.this.showToast(paramAnonymousIOException.getMessage());
      }
      
      public void onResponse(Call paramAnonymousCall, Response paramAnonymousResponse)
        throws IOException
      {
        try
        {
          com.freelxl.baselibrary.f.d.e("noob", paramAnonymousResponse.toString());
          MyTravelMoreActivity.a(MyTravelMoreActivity.this, (MyTravelMinsuAndZiRuYiOrderMo)new r(MyTravelMinsuAndZiRuYiOrderMo.class).parseResponse(paramAnonymousResponse));
          if (MyTravelMoreActivity.a(MyTravelMoreActivity.this) != null)
          {
            MyTravelMoreActivity.a(MyTravelMoreActivity.this, MyTravelMoreActivity.a(MyTravelMoreActivity.this).getData().getMinsuOrder());
            if (MyTravelMoreActivity.b(MyTravelMoreActivity.this) != null) {
              MyTravelMoreActivity.a(MyTravelMoreActivity.this, MyTravelMoreActivity.b(MyTravelMoreActivity.this).getOrderList());
            }
            MyTravelMoreActivity.a(MyTravelMoreActivity.this, MyTravelMoreActivity.a(MyTravelMoreActivity.this).getData().getZiruyiOrder());
            if (MyTravelMoreActivity.c(MyTravelMoreActivity.this) != null) {
              MyTravelMoreActivity.b(MyTravelMoreActivity.this, MyTravelMoreActivity.c(MyTravelMoreActivity.this).getOrderList());
            }
            MyTravelMoreActivity.d(MyTravelMoreActivity.this);
          }
          return;
        }
        catch (Exception paramAnonymousCall)
        {
          paramAnonymousCall.printStackTrace();
        }
      }
    });
  }
  
  private void a(final SortIndexBean paramSortIndexBean)
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
        if (MyTravelMoreActivity.this.getString(2131296612).equals(paramAnonymousAdapterView)) {
          if (ae.notNull(paramSortIndexBean.getPhone())) {
            k.callPhone(MyTravelMoreActivity.this, paramSortIndexBean.getPhone());
          }
        }
        for (;;)
        {
          MyTravelMoreActivity.this.a.dismiss();
          return;
          MyTravelMoreActivity.a(MyTravelMoreActivity.this, paramSortIndexBean);
        }
      }
    }, (List)localObject);
    paramSortIndexBean = this.a;
    localObject = getWindow().getDecorView();
    if (!(paramSortIndexBean instanceof PopupWindow))
    {
      paramSortIndexBean.showAtLocation((View)localObject, 80, 0, 0);
      return;
    }
    VdsAgent.showAtLocation((PopupWindow)paramSortIndexBean, (View)localObject, 80, 0, 0);
  }
  
  private void b()
  {
    final ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.d.iterator();
    while (localIterator.hasNext()) {
      localArrayList.add(((MinsuOrderBean.MinsuOrderListBean)localIterator.next()).convertToTravelOrder());
    }
    localIterator = this.f.iterator();
    while (localIterator.hasNext()) {
      localArrayList.add(((ZiruyiOrderBean.ZiRuYiOrderListBean)localIterator.next()).convertToTravelOrder());
    }
    Collections.sort(localArrayList, new Comparator()
    {
      public int compare(SortIndexBean paramAnonymousSortIndexBean1, SortIndexBean paramAnonymousSortIndexBean2)
      {
        return paramAnonymousSortIndexBean1.getSortIndex() - paramAnonymousSortIndexBean2.getSortIndex();
      }
    });
    runOnUiThread(new Runnable()
    {
      public void run()
      {
        MyTravelListMoreAdapter localMyTravelListMoreAdapter = new MyTravelListMoreAdapter();
        localMyTravelListMoreAdapter.setList(localArrayList);
        LinearLayoutManager localLinearLayoutManager = new LinearLayoutManager(MyTravelMoreActivity.e(MyTravelMoreActivity.this));
        localLinearLayoutManager.setOrientation(1);
        MyTravelMoreActivity.this.recyclerView.setLayoutManager(localLinearLayoutManager);
        localMyTravelListMoreAdapter.setListener(new MyTravelListMoreAdapter.a()
        {
          public void onClick(int paramAnonymous2Int, SortIndexBean paramAnonymous2SortIndexBean)
          {
            if (paramAnonymous2SortIndexBean.getOrderType() == 1)
            {
              MyTravelMoreActivity.b(MyTravelMoreActivity.this, paramAnonymous2SortIndexBean);
              return;
            }
            k.callPhone(MyTravelMoreActivity.this, paramAnonymous2SortIndexBean.getLandlordMobile());
          }
        });
        MyTravelMoreActivity.this.recyclerView.setAdapter(localMyTravelListMoreAdapter);
      }
    });
  }
  
  private void b(SortIndexBean paramSortIndexBean)
  {
    k.toImPage(this, paramSortIndexBean.getLandlordUid(), paramSortIndexBean.getFid(), paramSortIndexBean.getRentWay().intValue(), 2, MinsuMyActivity.class.getSimpleName());
  }
  
  public static Map<String, String> signMethod(Map paramMap)
  {
    com.ziroom.ziroomcustomer.minsu.e.d.setCommonParameter(paramMap);
    String str = c.createEncryption("DES").encrypt(a.toJSONString(paramMap), SignKeyUtil.getIvKeyFromC(), SignKeyUtil.getKeyFromC());
    paramMap = h.toMd5(a.toJSONString(paramMap).getBytes());
    HashMap localHashMap = new HashMap();
    localHashMap.put("2y5QfvAy", str);
    localHashMap.put("hPtJ39Xs", paramMap);
    return localHashMap;
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
    this.g = this;
    ButterKnife.bind(this);
    a();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/my/MyTravelMoreActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */