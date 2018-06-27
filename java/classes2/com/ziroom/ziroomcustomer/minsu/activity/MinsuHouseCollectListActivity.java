package com.ziroom.ziroomcustomer.minsu.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.freelxl.baselibrary.e.i.a;
import com.freelxl.baselibrary.e.k;
import com.freelxl.baselibrary.f.d;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.minsu.adapter.l;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuHouseCollectBean;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuHouseCollectBean.DataBean;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuHouseCollectBean.DataBean.RowsBean;
import com.ziroom.ziroomcustomer.minsu.f.ad;
import com.ziroom.ziroomcustomer.minsu.f.v;
import com.ziroom.ziroomcustomer.minsu.view.CommonTitle;
import com.ziroom.ziroomcustomer.util.u;
import com.ziroom.ziroomcustomer.widget.XListView;
import com.ziroom.ziroomcustomer.widget.XListView.a;
import java.util.ArrayList;
import java.util.List;

public class MinsuHouseCollectListActivity
  extends BaseActivity
{
  private XListView a;
  private com.ziroom.ziroomcustomer.minsu.a.a<MinsuHouseCollectBean.DataBean.RowsBean> b;
  private List<MinsuHouseCollectBean.DataBean.RowsBean> c = new ArrayList();
  private CommonTitle d;
  
  private void a()
  {
    this.a = ((XListView)findViewById(2131691217));
    this.a.setPullLoadEnable(false);
    this.a.setPullRefreshEnable(true);
    this.a.setXListViewListener(new XListView.a()
    {
      public void onLoadMore() {}
      
      public void onRefresh()
      {
        MinsuHouseCollectListActivity.a(MinsuHouseCollectListActivity.this);
      }
    });
    this.b = new l(this, this.c);
    this.a.setAdapter(this.b);
    this.a.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      @Instrumented
      public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        VdsAgent.onItemClick(this, paramAnonymousAdapterView, paramAnonymousView, paramAnonymousInt, paramAnonymousLong);
        v.onClick(MinsuHouseCollectListActivity.this, "M-Collectionhouse");
        if ((MinsuHouseCollectListActivity.b(MinsuHouseCollectListActivity.this).getDatas() == null) || (MinsuHouseCollectListActivity.b(MinsuHouseCollectListActivity.this).getDatas().size() <= paramAnonymousInt - 1)) {}
        do
        {
          return;
          paramAnonymousView = (MinsuHouseCollectBean.DataBean.RowsBean)MinsuHouseCollectListActivity.b(MinsuHouseCollectListActivity.this).getDatas().get(paramAnonymousInt - 1);
        } while ((paramAnonymousView.houseStatus.intValue() == 41) || (paramAnonymousView.houseStatus.intValue() == 50));
        if (paramAnonymousView.isTop50Online == 1) {}
        for (paramAnonymousAdapterView = new Intent(MinsuHouseCollectListActivity.this, MinsuTopHouseDetailActivity.class);; paramAnonymousAdapterView = new Intent(MinsuHouseCollectListActivity.this, MinsuHouseDetailActivity.class))
        {
          paramAnonymousAdapterView.putExtra("fid", paramAnonymousView.fid);
          paramAnonymousAdapterView.putExtra("rentWay", paramAnonymousView.rentWay);
          MinsuHouseCollectListActivity.this.startActivityForResult(paramAnonymousAdapterView, 119);
          return;
        }
      }
    });
  }
  
  private void b()
  {
    com.ziroom.ziroomcustomer.minsu.e.a.collHouseList(this, new i.a()
    {
      public void onParse(String paramAnonymousString, k paramAnonymousk)
      {
        u.e("lanzhihong", "str======" + paramAnonymousString);
        paramAnonymousk.setObject(paramAnonymousString);
        MinsuHouseCollectListActivity.this.dismissProgress();
      }
      
      public void onSuccess(k paramAnonymousk)
      {
        MinsuHouseCollectListActivity.c(MinsuHouseCollectListActivity.this);
        MinsuHouseCollectBean localMinsuHouseCollectBean = (MinsuHouseCollectBean)paramAnonymousk.getObject();
        if ((paramAnonymousk.getSuccess().booleanValue()) && (localMinsuHouseCollectBean != null) && (localMinsuHouseCollectBean.checkSuccess(MinsuHouseCollectListActivity.this)))
        {
          d.e("lanzhihong", "ro======" + localMinsuHouseCollectBean.toString());
          if (localMinsuHouseCollectBean.data.total < 1)
          {
            MinsuHouseCollectListActivity.this.showToast("没有更多数据");
            return;
          }
          MinsuHouseCollectListActivity.b(MinsuHouseCollectListActivity.this).getDatas().clear();
          MinsuHouseCollectListActivity.b(MinsuHouseCollectListActivity.this).addDatas(localMinsuHouseCollectBean.data.rows);
          MinsuHouseCollectListActivity.b(MinsuHouseCollectListActivity.this).notifyDataSetChanged();
          MinsuHouseCollectListActivity.this.dismissProgress();
          return;
        }
        if (localMinsuHouseCollectBean == null) {}
        for (paramAnonymousk = null;; paramAnonymousk = localMinsuHouseCollectBean.message)
        {
          ad.shouErrorMessage(paramAnonymousk);
          break;
        }
      }
    });
  }
  
  private void e()
  {
    this.a.stopRefresh();
    this.a.stopLoadMore();
    this.a.setRefreshTime("刚刚");
  }
  
  public void initTitle()
  {
    this.d = ((CommonTitle)findViewById(2131691272));
    this.d.showRightText(false, null);
    this.d.setMiddleText(getString(2131297234));
    this.d.setLeftButtonType(0);
    this.d.setOnLeftButtonClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        MinsuHouseCollectListActivity.this.finish();
      }
    });
    this.d.showRightText(false, "");
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    switch (paramInt1)
    {
    default: 
      break;
    }
    label145:
    for (;;)
    {
      return;
      if (paramInt2 == 101)
      {
        String str = paramIntent.getStringExtra("fid");
        paramInt2 = paramIntent.getIntExtra("rentWay", -1);
        int i = this.c.size();
        paramInt1 = 0;
        for (;;)
        {
          if (paramInt1 >= i) {
            break label145;
          }
          MinsuHouseCollectBean.DataBean.RowsBean localRowsBean = (MinsuHouseCollectBean.DataBean.RowsBean)this.c.get(paramInt1);
          if ((localRowsBean.rentWay.intValue() == paramInt2) && (localRowsBean.fid.equals(str)))
          {
            if (paramIntent.getBooleanExtra("isCollect", true)) {
              break;
            }
            this.c.remove(localRowsBean);
            this.b.notifyDataSetChanged();
            return;
          }
          paramInt1 += 1;
        }
      }
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903278);
    a();
    initTitle();
    b();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/activity/MinsuHouseCollectListActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */