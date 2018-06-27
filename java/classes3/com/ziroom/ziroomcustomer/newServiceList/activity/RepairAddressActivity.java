package com.ziroom.ziroomcustomer.newServiceList.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.alibaba.fastjson.a;
import com.baidu.location.BDLocation;
import com.freelxl.baselibrary.e.i.a;
import com.freelxl.baselibrary.e.k;
import com.freelxl.baselibrary.f.g;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.commonlibrary.widget.unifiedziroom.c;
import com.ziroom.commonlibrary.widget.unifiedziroom.c.a;
import com.ziroom.commonlibrary.widget.unifiedziroom.c.b;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.base.b;
import com.ziroom.ziroomcustomer.e.j;
import com.ziroom.ziroomcustomer.newServiceList.a.e;
import com.ziroom.ziroomcustomer.newServiceList.model.AddressMo;
import com.ziroom.ziroomcustomer.util.ad;
import com.ziroom.ziroomcustomer.widget.XListView;
import com.ziroom.ziroomcustomer.widget.XListView.a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RepairAddressActivity
  extends BaseActivity
  implements View.OnClickListener, XListView.a
{
  private ImageView a;
  private XListView b;
  private Intent c;
  private e d;
  private Context e;
  private List<AddressMo> f = new ArrayList();
  private TextView g;
  private int r = 1;
  private boolean s = false;
  
  private void a()
  {
    b();
    this.b.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      @Instrumented
      public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        VdsAgent.onItemClick(this, paramAnonymousAdapterView, paramAnonymousView, paramAnonymousInt, paramAnonymousLong);
        if (((AddressMo)RepairAddressActivity.a(RepairAddressActivity.this).get(paramAnonymousInt - 1)).getCityCode() != null)
        {
          if (b.d.equals(((AddressMo)RepairAddressActivity.a(RepairAddressActivity.this).get(paramAnonymousInt - 1)).getCityCode()))
          {
            paramAnonymousAdapterView = new Intent();
            paramAnonymousAdapterView.putExtra("address", (Parcelable)RepairAddressActivity.a(RepairAddressActivity.this).get(paramAnonymousInt - 1));
            paramAnonymousAdapterView.putExtra("isSampleCity", "Yes");
            RepairAddressActivity.this.setResult(-1, paramAnonymousAdapterView);
            RepairAddressActivity.this.finish();
          }
        }
        else {
          return;
        }
        if (RepairAddressActivity.b(RepairAddressActivity.this))
        {
          RepairAddressActivity.a(RepairAddressActivity.this, (AddressMo)RepairAddressActivity.a(RepairAddressActivity.this).get(paramAnonymousInt - 1));
          return;
        }
        RepairAddressActivity.b(RepairAddressActivity.this, (AddressMo)RepairAddressActivity.a(RepairAddressActivity.this).get(paramAnonymousInt - 1));
      }
    });
  }
  
  private void a(AddressMo paramAddressMo)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("address", paramAddressMo);
    setResult(-1, localIntent);
    finish();
  }
  
  private void b()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("page", Integer.valueOf(1));
    localHashMap.put("pageSize", Integer.valueOf(1000));
    j.getServiceAddressList(this.e, localHashMap, new a());
  }
  
  private void b(final AddressMo paramAddressMo)
  {
    c.newBuilder(this.e).setTitle("提示").setContent("您所选地址的城市和现在您的城市不一致!将切换城市").setOnConfirmClickListener(new c.b()
    {
      public void onClick(View paramAnonymousView, boolean paramAnonymousBoolean)
      {
        if (paramAnonymousBoolean)
        {
          b.changeCity(paramAddressMo.getCityCode());
          if (!TextUtils.isEmpty(RepairAddressActivity.this.getLocationCity()))
          {
            if (!"110000".equals(paramAddressMo.getCityCode())) {
              break label115;
            }
            ad.putCityLocaton(RepairAddressActivity.e(RepairAddressActivity.this), "beijing", "北京");
            ad.putCityLocaton(RepairAddressActivity.e(RepairAddressActivity.this), "zdcity", "北京");
          }
        }
        for (;;)
        {
          paramAnonymousView = new Intent();
          paramAnonymousView.putExtra("address", paramAddressMo);
          paramAnonymousView.putExtra("isSampleCity", "No");
          RepairAddressActivity.this.setResult(-1, paramAnonymousView);
          RepairAddressActivity.this.finish();
          return;
          label115:
          if ("310000".equals(paramAddressMo.getCityCode()))
          {
            ad.putCityLocaton(RepairAddressActivity.e(RepairAddressActivity.this), "shanghai", "上海");
            ad.putCityLocaton(RepairAddressActivity.e(RepairAddressActivity.this), "zdcity", "上海");
          }
          else if ("440300".equals(paramAddressMo.getCityCode()))
          {
            ad.putCityLocaton(RepairAddressActivity.e(RepairAddressActivity.this), "shenzhen", "深圳");
            ad.putCityLocaton(RepairAddressActivity.e(RepairAddressActivity.this), "zdcity", "深圳");
          }
        }
      }
    }).build().show();
  }
  
  private void e()
  {
    this.a = ((ImageView)findViewById(2131689492));
    this.g = ((TextView)findViewById(2131689953));
    this.b = ((XListView)findViewById(2131690196));
    this.a.setOnClickListener(this);
    this.g.setOnClickListener(this);
    this.d = new e(this.e, this.f);
    this.b.setAdapter(this.d);
    this.b.setPullLoadEnable(false);
    this.b.setPullRefreshEnable(true);
    this.b.setXListViewListener(this);
    this.s = getIntent().getBooleanExtra("isAllCity", false);
  }
  
  private void f()
  {
    this.c = new Intent(this, ModifyNewAddressActivity.class);
    this.c.putExtra("isAllCity", this.s);
    startActivityForResult(this.c, 1);
  }
  
  private void g()
  {
    this.b.stopRefresh();
    this.b.stopLoadMore();
    this.b.setRefreshTime("刚刚");
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
      this.f.clear();
      this.d.notifyDataSetChanged();
      showProgress("");
      b();
    }
    if ((paramInt1 == 2) && (paramInt2 == -1))
    {
      this.f.clear();
      this.d.notifyDataSetChanged();
      showProgress("");
      b();
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
      setResult(0, new Intent());
      finish();
      return;
    }
    f();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903135);
    this.e = this;
    showProgress("");
    e();
    a();
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      setResult(0, new Intent());
      finish();
    }
    return super.onKeyUp(paramInt, paramKeyEvent);
  }
  
  public void onLoadMore() {}
  
  public void onRefresh()
  {
    this.b.setPullLoadEnable(false);
    this.r = 1;
    this.f.clear();
    this.d.notifyDataSetChanged();
    showProgress("");
    b();
  }
  
  class a
    implements i.a<String>
  {
    a() {}
    
    public void onParse(String paramString, k paramk)
    {
      paramString = a.parseObject(paramString);
      if ("0".equals((String)paramString.get("status")))
      {
        paramString = a.parseArray(paramString.get("data").toString(), AddressMo.class);
        paramk.setSuccess(Boolean.valueOf(true));
        paramk.setObject(paramString);
        return;
      }
      paramk.setSuccess(Boolean.valueOf(false));
      paramk.setMessage((String)paramString.get("message"));
    }
    
    public void onSuccess(k paramk)
    {
      if (paramk.getSuccess().booleanValue())
      {
        paramk = (ArrayList)paramk.getObject();
        if ((paramk != null) && (paramk.size() > 0))
        {
          RepairAddressActivity.a(RepairAddressActivity.this, paramk);
          RepairAddressActivity.c(RepairAddressActivity.this).setList(RepairAddressActivity.a(RepairAddressActivity.this));
          RepairAddressActivity.d(RepairAddressActivity.this);
        }
        for (;;)
        {
          RepairAddressActivity.this.dismissProgress();
          return;
          if ((RepairAddressActivity.a(RepairAddressActivity.this) != null) && (RepairAddressActivity.a(RepairAddressActivity.this).size() > 0)) {
            g.textToast(RepairAddressActivity.e(RepairAddressActivity.this), "数据获取失败，请重新刷新");
          }
        }
      }
      paramk = paramk.getMessage();
      if (paramk != null) {
        g.textToast(RepairAddressActivity.e(RepairAddressActivity.this), paramk);
      }
      for (;;)
      {
        RepairAddressActivity.this.dismissProgress();
        return;
        g.textToast(RepairAddressActivity.e(RepairAddressActivity.this), "服务器访问失败，请稍后再试");
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newServiceList/activity/RepairAddressActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */