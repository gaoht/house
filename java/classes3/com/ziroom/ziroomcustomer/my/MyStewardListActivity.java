package com.ziroom.ziroomcustomer.my;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListAdapter;
import android.widget.ListView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.commonlibrary.widget.unifiedziroom.BasicZiroomToolBar;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.e.a.f;
import com.ziroom.ziroomcustomer.e.c.n;
import com.ziroom.ziroomcustomer.e.e.p;
import com.ziroom.ziroomcustomer.e.g;
import com.ziroom.ziroomcustomer.e.q;
import com.ziroom.ziroomcustomer.my.adapter.MyStewardListAdapter;
import com.ziroom.ziroomcustomer.my.model.MyStewardListEntity;
import com.ziroom.ziroomcustomer.util.ae;
import com.ziroom.ziroomcustomer.util.u;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyStewardListActivity
  extends BaseActivity
{
  private Context a;
  private Unbinder b;
  private List<MyStewardListEntity> c;
  @BindView(2131689787)
  BasicZiroomToolBar mBztb;
  @BindView(2131697005)
  ListView my_steward_list;
  
  private void a()
  {
    this.my_steward_list.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      @Instrumented
      public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        VdsAgent.onItemClick(this, paramAnonymousAdapterView, paramAnonymousView, paramAnonymousInt, paramAnonymousLong);
        paramAnonymousAdapterView = new Intent(MyStewardListActivity.a(MyStewardListActivity.this), MyStewardInfoActivity.class);
        if (MyStewardListActivity.b(MyStewardListActivity.this).get(paramAnonymousInt) != null) {
          paramAnonymousAdapterView.putExtra("contractCode", ((MyStewardListEntity)MyStewardListActivity.b(MyStewardListActivity.this).get(paramAnonymousInt)).getContractCode() + "");
        }
        MyStewardListActivity.this.startActivity(paramAnonymousAdapterView);
      }
    });
  }
  
  private void b()
  {
    Object localObject = getIntent().getStringExtra("stewardList");
    if (ae.notNull((String)localObject))
    {
      this.c = com.alibaba.fastjson.a.parseArray((String)localObject, MyStewardListEntity.class);
      localObject = new MyStewardListAdapter(this.a, this.c);
      this.my_steward_list.setAdapter((ListAdapter)localObject);
      return;
    }
    e();
  }
  
  private void e()
  {
    com.freelxl.baselibrary.d.a.isLog(true);
    HashMap localHashMap = new HashMap();
    localHashMap.put("token", com.ziroom.commonlibrary.login.a.getToken(this.a));
    com.freelxl.baselibrary.d.a.get(q.R + e.p.a).tag(this).params(g.getCommonHouseSign(localHashMap)).enqueue(new f(this, new n())
    {
      public void onSuccess(int paramAnonymousInt, com.alibaba.fastjson.b paramAnonymousb)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousb);
        u.d("OKHttp", "===" + paramAnonymousb.toString());
        MyStewardListActivity.a(MyStewardListActivity.this, com.alibaba.fastjson.a.parseArray(paramAnonymousb.toString(), MyStewardListEntity.class));
        if (MyStewardListActivity.b(MyStewardListActivity.this) != null)
        {
          if (MyStewardListActivity.b(MyStewardListActivity.this).size() == 1)
          {
            paramAnonymousb = new Intent(MyStewardListActivity.a(MyStewardListActivity.this), MyStewardInfoActivity.class);
            paramAnonymousb.putExtra("contractCode", ((MyStewardListEntity)MyStewardListActivity.b(MyStewardListActivity.this).get(0)).getContractCode() + "");
            MyStewardListActivity.this.startActivity(paramAnonymousb);
            MyStewardListActivity.this.finish();
            return;
          }
          paramAnonymousb = new MyStewardListAdapter(MyStewardListActivity.a(MyStewardListActivity.this), MyStewardListActivity.b(MyStewardListActivity.this));
          MyStewardListActivity.this.my_steward_list.setAdapter(paramAnonymousb);
          return;
        }
        MyStewardListActivity.this.showToast("");
      }
    });
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130904961);
    this.a = this;
    this.b = ButterKnife.bind(this);
    this.mBztb.setTitle("我的管家");
    b();
    a();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/my/MyStewardListActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */