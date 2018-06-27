package com.ziroom.ziroomcustomer.newclean.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.location.BDLocation;
import com.freelxl.baselibrary.e.i.a;
import com.freelxl.baselibrary.f.g;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.commonlibrary.widget.unifiedziroom.c.a;
import com.ziroom.commonlibrary.widget.unifiedziroom.c.b;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.base.b;
import com.ziroom.ziroomcustomer.e.c.m;
import com.ziroom.ziroomcustomer.e.l;
import com.ziroom.ziroomcustomer.e.n;
import com.ziroom.ziroomcustomer.e.o;
import com.ziroom.ziroomcustomer.model.UserInfo;
import com.ziroom.ziroomcustomer.newclean.d.r;
import com.ziroom.ziroomcustomer.util.ad;
import com.ziroom.ziroomcustomer.util.ah;
import com.ziroom.ziroomcustomer.util.w;
import com.ziroom.ziroomcustomer.widget.XListView;
import com.ziroom.ziroomcustomer.widget.XListView.a;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CleanAddressActivity
  extends BaseActivity
  implements View.OnClickListener, XListView.a
{
  public static CleanAddressActivity a = null;
  private boolean A = true;
  private String B;
  private int C;
  private boolean D = false;
  private int E = 0;
  private boolean F = false;
  private boolean G = false;
  private Handler H = new Handler()
  {
    public void handleMessage(Message paramAnonymousMessage)
    {
      l locall = (l)paramAnonymousMessage.obj;
      switch (paramAnonymousMessage.what)
      {
      }
      do
      {
        return;
        if (!locall.getSuccess().booleanValue()) {
          break;
        }
        if (locall.getObject() != null)
        {
          CleanAddressActivity.a(CleanAddressActivity.this, (List)locall.getObject());
          CleanAddressActivity.a(CleanAddressActivity.this).addAll(CleanAddressActivity.f(CleanAddressActivity.this));
          CleanAddressActivity.g(CleanAddressActivity.this).setPullLoadEnable(true);
          CleanAddressActivity.h(CleanAddressActivity.this);
          CleanAddressActivity.i(CleanAddressActivity.this);
        }
      } while ((locall.getObject() != null) || (CleanAddressActivity.a(CleanAddressActivity.this).size() <= 0));
      CleanAddressActivity.h(CleanAddressActivity.this);
      CleanAddressActivity.g(CleanAddressActivity.this).setPullLoadEnable(false);
      return;
      g.textToast(CleanAddressActivity.b(CleanAddressActivity.this), locall.getMessage());
    }
  };
  private ImageView b;
  private XListView c;
  private Intent d;
  private List<r> e = new ArrayList();
  private r f = new r();
  private com.ziroom.ziroomcustomer.newclean.b.i g;
  private Context r;
  private UserInfo s;
  private List<com.ziroom.ziroomcustomer.newclean.d.c> t = new ArrayList();
  private TextView u;
  private List<com.ziroom.ziroomcustomer.newclean.d.c> v;
  private int w = 1;
  private String x;
  private String y;
  private String z;
  
  private void a()
  {
    this.b = ((ImageView)findViewById(2131689492));
    this.u = ((TextView)findViewById(2131689953));
    this.c = ((XListView)findViewById(2131690196));
    this.b.setOnClickListener(this);
    this.u.setOnClickListener(this);
    this.z = getIntent().getStringExtra("isZu");
    if ((!TextUtils.isEmpty(this.z)) && ("isZu".equals(this.z)))
    {
      this.A = false;
      this.u.setVisibility(8);
      this.c.setPullLoadEnable(false);
      this.c.setPullRefreshEnable(false);
    }
    for (;;)
    {
      this.g = new com.ziroom.ziroomcustomer.newclean.b.i(this.r, this.t, this.A);
      this.c.setAdapter(this.g);
      return;
      this.A = true;
      this.u.setVisibility(0);
      this.c.setPullLoadEnable(false);
      this.c.setPullRefreshEnable(true);
      this.c.setXListViewListener(this);
    }
  }
  
  private void a(final com.ziroom.ziroomcustomer.newclean.d.c paramc)
  {
    com.ziroom.ziroomcustomer.newclean.periodclean.a.validMatchSupplierScopeByCoord(this, Double.parseDouble(paramc.getLongitude()), Double.parseDouble(paramc.getLatitude()), new com.ziroom.ziroomcustomer.e.a.d(this, new com.ziroom.ziroomcustomer.e.c.d())
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        super.onFailure(paramAnonymousThrowable);
      }
      
      public void onSuccess(int paramAnonymousInt, Object paramAnonymousObject)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousObject);
        paramAnonymousObject = new Intent();
        ((Intent)paramAnonymousObject).putExtra("addressList", paramc);
        ((Intent)paramAnonymousObject).putExtra("isSampleCity", "Yes");
        CleanAddressActivity.this.setResult(-1, (Intent)paramAnonymousObject);
        CleanAddressActivity.this.finish();
      }
    });
  }
  
  private void b()
  {
    this.F = getIntent().getBooleanExtra("isFromGeneral", false);
    this.y = getIntent().getStringExtra("isOnly");
    this.s = ApplicationEx.c.getUser();
    this.B = getIntent().getStringExtra("serviceInfoId");
    if (getIntent().getBooleanExtra("isFromEmpty", false))
    {
      String str = getIntent().getStringExtra("cleanAddressData");
      if (!TextUtils.isEmpty(str))
      {
        this.v = com.alibaba.fastjson.a.parseArray(str, com.ziroom.ziroomcustomer.newclean.d.c.class);
        this.t.addAll(this.v);
        this.g.notifyDataSetChanged();
      }
    }
    for (;;)
    {
      this.c.setOnItemClickListener(new AdapterView.OnItemClickListener()
      {
        @Instrumented
        public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          VdsAgent.onItemClick(this, paramAnonymousAdapterView, paramAnonymousView, paramAnonymousInt, paramAnonymousLong);
          if (((com.ziroom.ziroomcustomer.newclean.d.c)CleanAddressActivity.a(CleanAddressActivity.this).get(paramAnonymousInt - 1)).getCityCode() != null)
          {
            paramAnonymousAdapterView = ((com.ziroom.ziroomcustomer.newclean.d.c)CleanAddressActivity.a(CleanAddressActivity.this).get(paramAnonymousInt - 1)).getLinkPhone();
            if ((TextUtils.isEmpty(paramAnonymousAdapterView)) || (!ah.isMobile(paramAnonymousAdapterView))) {
              g.textToast(CleanAddressActivity.b(CleanAddressActivity.this), "电话号码不正确，请修改！");
            }
          }
          else
          {
            return;
          }
          if (b.d.equals(((com.ziroom.ziroomcustomer.newclean.d.c)CleanAddressActivity.a(CleanAddressActivity.this).get(paramAnonymousInt - 1)).getCityCode()))
          {
            paramAnonymousAdapterView = (com.ziroom.ziroomcustomer.newclean.d.c)CleanAddressActivity.a(CleanAddressActivity.this).get(paramAnonymousInt - 1);
            CleanAddressActivity.a(CleanAddressActivity.this, paramAnonymousAdapterView);
            return;
          }
          CleanAddressActivity.b(CleanAddressActivity.this, (com.ziroom.ziroomcustomer.newclean.d.c)CleanAddressActivity.a(CleanAddressActivity.this).get(paramAnonymousInt - 1));
        }
      });
      this.c.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener()
      {
        public boolean onItemLongClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, final int paramAnonymousInt, long paramAnonymousLong)
        {
          com.ziroom.commonlibrary.widget.unifiedziroom.c.newBuilder(CleanAddressActivity.b(CleanAddressActivity.this)).setTitle("提示").setContent("确认要删除改地址吗？").setOnConfirmClickListener(new c.b()
          {
            public void onClick(View paramAnonymous2View, boolean paramAnonymous2Boolean)
            {
              if (paramAnonymous2Boolean) {
                CleanAddressActivity.a(CleanAddressActivity.this, paramAnonymousInt);
              }
            }
          }).build().show();
          return true;
        }
      });
      return;
      c(1);
      continue;
      c(1);
    }
  }
  
  private void b(final int paramInt)
  {
    Object localObject = ApplicationEx.c.getUser();
    if (localObject == null) {
      return;
    }
    localObject = ((UserInfo)localObject).getUid();
    String str = ((com.ziroom.ziroomcustomer.newclean.d.c)this.t.get(paramInt - 1)).getFid();
    if ((!TextUtils.isEmpty(this.y)) && (str.equals(this.y))) {
      this.G = true;
    }
    if ((!TextUtils.isEmpty(this.z)) && ("isZu".equals(this.z)))
    {
      com.ziroom.ziroomcustomer.newclean.periodclean.a.DeleteZhengzuAddress(this, str, new com.ziroom.ziroomcustomer.e.a.d(this, new com.ziroom.ziroomcustomer.e.c.i())
      {
        public void onSuccess(int paramAnonymousInt, Object paramAnonymousObject)
        {
          super.onSuccess(paramAnonymousInt, paramAnonymousObject);
          CleanAddressActivity.a(CleanAddressActivity.this).remove(paramInt - 1);
          CleanAddressActivity.c(CleanAddressActivity.this).notifyDataSetChanged();
          if (CleanAddressActivity.d(CleanAddressActivity.this))
          {
            CleanAddressActivity.a(CleanAddressActivity.this, true);
            if (CleanAddressActivity.e(CleanAddressActivity.this)) {
              org.greenrobot.eventbus.c.getDefault().post(new com.ziroom.ziroomcustomer.newServiceList.utils.c("general_clean_address_delete", null));
            }
          }
        }
      });
      return;
    }
    n.requestDeleteCleanAddress(this.r, str, (String)localObject, new com.ziroom.ziroomcustomer.e.a.a(this, new m(String.class, new com.ziroom.ziroomcustomer.e.c.a.a()))
    {
      public void onSuccess(int paramAnonymousInt, String paramAnonymousString)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousString);
        CleanAddressActivity.a(CleanAddressActivity.this).remove(paramInt - 1);
        CleanAddressActivity.c(CleanAddressActivity.this).notifyDataSetChanged();
        if (CleanAddressActivity.d(CleanAddressActivity.this))
        {
          CleanAddressActivity.a(CleanAddressActivity.this, true);
          if (CleanAddressActivity.e(CleanAddressActivity.this)) {
            org.greenrobot.eventbus.c.getDefault().post(new com.ziroom.ziroomcustomer.newServiceList.utils.c("general_clean_address_delete", null));
          }
        }
      }
    });
  }
  
  private void b(final com.ziroom.ziroomcustomer.newclean.d.c paramc)
  {
    com.ziroom.commonlibrary.widget.unifiedziroom.c.newBuilder(this.r).setTitle("提示").setContent("您所选地址的城市和现在您的城市不一致!将切换城市").setOnConfirmClickListener(new c.b()
    {
      public void onClick(View paramAnonymousView, boolean paramAnonymousBoolean)
      {
        if (paramAnonymousBoolean)
        {
          b.changeCity(paramc.getCityCode());
          if (!TextUtils.isEmpty(CleanAddressActivity.this.getLocationCity()))
          {
            if (!"110000".equals(paramc.getCityCode())) {
              break label115;
            }
            ad.putCityLocaton(CleanAddressActivity.b(CleanAddressActivity.this), "beijing", "北京");
            ad.putCityLocaton(CleanAddressActivity.b(CleanAddressActivity.this), "zdcity", "北京");
          }
        }
        for (;;)
        {
          paramAnonymousView = new Intent();
          paramAnonymousView.putExtra("addressList", paramc);
          paramAnonymousView.putExtra("isSampleCity", "No");
          CleanAddressActivity.this.setResult(-1, paramAnonymousView);
          CleanAddressActivity.this.finish();
          return;
          label115:
          if ("310000".equals(paramc.getCityCode()))
          {
            ad.putCityLocaton(CleanAddressActivity.b(CleanAddressActivity.this), "shanghai", "上海");
            ad.putCityLocaton(CleanAddressActivity.b(CleanAddressActivity.this), "zdcity", "上海");
          }
          else if ("440300".equals(paramc.getCityCode()))
          {
            ad.putCityLocaton(CleanAddressActivity.b(CleanAddressActivity.this), "shenzhen", "深圳");
            ad.putCityLocaton(CleanAddressActivity.b(CleanAddressActivity.this), "zdcity", "深圳");
          }
        }
      }
    }).build().show();
  }
  
  private void c(int paramInt)
  {
    this.s = ApplicationEx.c.getUser();
    if (this.s != null)
    {
      if ((!TextUtils.isEmpty(this.z)) && ("isZu".equals(this.z))) {
        n.getZuAddressList(this.r, this.s.getUid(), new a(), false);
      }
    }
    else {
      return;
    }
    o.getNewGeneralAList(this.r, this.H, paramInt, 8, this.s.getUid());
  }
  
  private void e()
  {
    this.d = new Intent(this, ModifyNewAddressActivity.class);
    startActivityForResult(this.d, 1);
  }
  
  private void f()
  {
    if ((this.t != null) && (!TextUtils.isEmpty(this.y)))
    {
      int i = 0;
      while (i < this.t.size())
      {
        if (this.y.equals(((com.ziroom.ziroomcustomer.newclean.d.c)this.t.get(i)).getFid())) {
          this.C = i;
        }
        i += 1;
      }
    }
    this.g.notifyDataSetChanged();
  }
  
  private void g()
  {
    this.c.stopRefresh();
    this.c.stopLoadMore();
    this.c.setRefreshTime("刚刚");
  }
  
  public String getLocationCity()
  {
    String str2 = "";
    BDLocation localBDLocation = ApplicationEx.c.getLocation();
    String str1 = str2;
    if (localBDLocation != null)
    {
      str1 = str2;
      if (localBDLocation.getCity() != null) {
        str1 = localBDLocation.getCity().replace("市", "");
      }
    }
    return str1;
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt1 == 1) && (paramInt2 == -1))
    {
      this.t.clear();
      this.g.notifyDataSetChanged();
      this.s = ApplicationEx.c.getUser();
      c(1);
    }
    if ((paramInt1 == 2) && (paramInt2 == -1))
    {
      this.x = paramIntent.getStringExtra("modifyPosition");
      this.t.clear();
      this.g.notifyDataSetChanged();
      c(1);
    }
  }
  
  @Instrumented
  public void onClick(View paramView)
  {
    VdsAgent.onClick(this, paramView);
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131689492: 
      if ((!TextUtils.isEmpty(this.x)) && (!TextUtils.isEmpty(this.y))) {
        if ((b.d.equals(((com.ziroom.ziroomcustomer.newclean.d.c)this.t.get(Integer.valueOf(this.x).intValue())).getCityCode())) && (this.y.equals(((com.ziroom.ziroomcustomer.newclean.d.c)this.t.get(Integer.valueOf(this.x).intValue())).getFid())))
        {
          paramView = new Intent();
          paramView.putExtra("addressList", (Serializable)this.t.get(Integer.valueOf(this.x).intValue()));
          paramView.putExtra("isSampleCity", "Yes");
          setResult(-1, paramView);
          finish();
        }
      }
      for (;;)
      {
        w.onEvent(this.r, "dailyaddress_return");
        return;
        setResult(0, new Intent());
        finish();
        continue;
        setResult(0, new Intent());
        finish();
      }
    }
    e();
    w.onEvent(this.r, "dailyaddress_add");
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903135);
    a = this;
    this.r = this;
    a();
    b();
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      if ((TextUtils.isEmpty(this.x)) || (TextUtils.isEmpty(this.y))) {
        break label179;
      }
      if ((!b.d.equals(((com.ziroom.ziroomcustomer.newclean.d.c)this.t.get(Integer.valueOf(this.x).intValue())).getCityCode())) || (!this.y.equals(((com.ziroom.ziroomcustomer.newclean.d.c)this.t.get(Integer.valueOf(this.x).intValue())).getFid()))) {
        break label160;
      }
      Intent localIntent = new Intent();
      localIntent.putExtra("addressList", (Serializable)this.t.get(Integer.valueOf(this.x).intValue()));
      localIntent.putExtra("isSampleCity", "Yes");
      setResult(-1, localIntent);
      finish();
    }
    for (;;)
    {
      return super.onKeyUp(paramInt, paramKeyEvent);
      label160:
      setResult(0, new Intent());
      finish();
      continue;
      label179:
      setResult(0, new Intent());
      finish();
    }
  }
  
  public void onLoadMore()
  {
    int i = this.w + 1;
    this.w = i;
    c(i);
  }
  
  public void onRefresh()
  {
    this.c.setPullLoadEnable(false);
    this.w = 1;
    this.t.clear();
    this.g.notifyDataSetChanged();
    c(1);
  }
  
  class a
    implements i.a<String>
  {
    a() {}
    
    public void onParse(String paramString, com.freelxl.baselibrary.e.k paramk)
    {
      paramString = com.alibaba.fastjson.a.parseObject(com.ziroom.ziroomcustomer.util.k.decrypt(paramString));
      String str = (String)paramString.get("status");
      if (("0".equals(str)) || ("success".equals(str)))
      {
        if (paramString.get("data") != null) {
          paramk.setObject(com.alibaba.fastjson.a.parseArray(paramString.get("data").toString(), com.ziroom.ziroomcustomer.newclean.d.c.class));
        }
        paramk.setSuccess(Boolean.valueOf(true));
        return;
      }
      paramk.setSuccess(Boolean.valueOf(false));
    }
    
    public void onSuccess(com.freelxl.baselibrary.e.k paramk)
    {
      if (paramk.getSuccess().booleanValue())
      {
        if (paramk.getObject() != null)
        {
          CleanAddressActivity.a(CleanAddressActivity.this, (List)paramk.getObject());
          CleanAddressActivity.a(CleanAddressActivity.this).addAll(CleanAddressActivity.f(CleanAddressActivity.this));
          CleanAddressActivity.g(CleanAddressActivity.this).setPullLoadEnable(true);
          CleanAddressActivity.h(CleanAddressActivity.this);
          CleanAddressActivity.i(CleanAddressActivity.this);
        }
        if ((paramk.getObject() == null) && (CleanAddressActivity.a(CleanAddressActivity.this).size() > 0))
        {
          CleanAddressActivity.h(CleanAddressActivity.this);
          CleanAddressActivity.g(CleanAddressActivity.this).setPullLoadEnable(false);
        }
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newclean/activity/CleanAddressActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */