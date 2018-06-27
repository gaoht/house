package com.ziroom.ziroomcustomer.newclean.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.e.c.l;
import com.ziroom.ziroomcustomer.e.n;
import com.ziroom.ziroomcustomer.newclean.b.f;
import com.ziroom.ziroomcustomer.newclean.d.k;
import com.ziroom.ziroomcustomer.widget.XListView;
import com.ziroom.ziroomcustomer.widget.XListView.a;
import java.util.ArrayList;
import java.util.List;

public class BiweeklyCleanAllEvalListActivity
  extends BaseActivity
  implements XListView.a
{
  private XListView a;
  private List<k> b = new ArrayList();
  private List<k> c = new ArrayList();
  private f d;
  private int e = 1;
  
  private void a()
  {
    this.a = ((XListView)findViewById(2131690040));
    this.a.setPullLoadEnable(false);
    this.a.setPullRefreshEnable(true);
    this.a.setXListViewListener(this);
    findViewById(2131689492).setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        BiweeklyCleanAllEvalListActivity.this.finish();
      }
    });
    this.d = new f(this, this.b);
    this.a.setAdapter(this.d);
  }
  
  private void b()
  {
    this.a.stopRefresh();
    this.a.stopLoadMore();
    this.a.setRefreshTime("刚刚");
  }
  
  private void b(int paramInt)
  {
    n.getBiweeklyCleanerAllEvalList(this, getIntent().getStringExtra("cleanerId"), paramInt, 8, new com.freelxl.baselibrary.d.c.a(new l(k.class, new com.ziroom.ziroomcustomer.e.c.a.a()))
    {
      public void onFailure(Throwable paramAnonymousThrowable) {}
      
      public void onSuccess(int paramAnonymousInt, List<k> paramAnonymousList)
      {
        if (paramAnonymousList != null)
        {
          BiweeklyCleanAllEvalListActivity.a(BiweeklyCleanAllEvalListActivity.this, paramAnonymousList);
          BiweeklyCleanAllEvalListActivity.b(BiweeklyCleanAllEvalListActivity.this).addAll(BiweeklyCleanAllEvalListActivity.a(BiweeklyCleanAllEvalListActivity.this));
        }
        BiweeklyCleanAllEvalListActivity.c(BiweeklyCleanAllEvalListActivity.this).setPullLoadEnable(true);
        BiweeklyCleanAllEvalListActivity.d(BiweeklyCleanAllEvalListActivity.this).notifyDataSetChanged();
        BiweeklyCleanAllEvalListActivity.e(BiweeklyCleanAllEvalListActivity.this);
      }
    });
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903112);
    a();
    b(1);
  }
  
  public void onLoadMore()
  {
    int i = this.e + 1;
    this.e = i;
    b(i);
  }
  
  public void onRefresh()
  {
    this.a.setPullLoadEnable(false);
    this.e = 1;
    this.b.clear();
    this.d.notifyDataSetChanged();
    b(1);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newclean/activity/BiweeklyCleanAllEvalListActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */