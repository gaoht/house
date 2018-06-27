package com.ziroom.ziroomcustomer.newclean.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ImageView;
import android.widget.ListView;
import com.baidu.location.BDLocation;
import com.freelxl.baselibrary.f.g;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.commonlibrary.widget.unifiedziroom.c.a;
import com.ziroom.commonlibrary.widget.unifiedziroom.c.b;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.base.b;
import com.ziroom.ziroomcustomer.e.a.d;
import com.ziroom.ziroomcustomer.e.c.e;
import com.ziroom.ziroomcustomer.e.n;
import com.ziroom.ziroomcustomer.model.UserInfo;
import com.ziroom.ziroomcustomer.util.ad;
import com.ziroom.ziroomcustomer.util.ah;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BedroomAddressActivity
  extends BaseActivity
{
  private BedroomAddressActivity a;
  private ImageView b;
  private ListView c;
  private List<com.ziroom.ziroomcustomer.newclean.d.c> d = new ArrayList();
  private com.ziroom.ziroomcustomer.newclean.b.a e;
  private String f;
  private String g = "";
  private boolean r = false;
  
  private void a()
  {
    this.b = ((ImageView)findViewById(2131689492));
    this.c = ((ListView)findViewById(2131689954));
  }
  
  private void a(final com.ziroom.ziroomcustomer.newclean.d.c paramc)
  {
    com.ziroom.commonlibrary.widget.unifiedziroom.c.newBuilder(this.a).setTitle("提示").setContent("您所选地址的城市和现在您的城市不一致!将切换城市").setOnConfirmClickListener(new c.b()
    {
      public void onClick(View paramAnonymousView, boolean paramAnonymousBoolean)
      {
        if (paramAnonymousBoolean)
        {
          b.changeCity(paramc.getCityCode());
          if (!TextUtils.isEmpty(BedroomAddressActivity.this.getLocationCity()))
          {
            if (!"110000".equals(paramc.getCityCode())) {
              break label115;
            }
            ad.putCityLocaton(BedroomAddressActivity.d(BedroomAddressActivity.this), "beijing", "北京");
            ad.putCityLocaton(BedroomAddressActivity.d(BedroomAddressActivity.this), "zdcity", "北京");
          }
        }
        for (;;)
        {
          paramAnonymousView = new Intent();
          paramAnonymousView.putExtra("addressList", paramc);
          paramAnonymousView.putExtra("isSampleCity", "No");
          BedroomAddressActivity.this.setResult(-1, paramAnonymousView);
          BedroomAddressActivity.this.finish();
          return;
          label115:
          if ("310000".equals(paramc.getCityCode()))
          {
            ad.putCityLocaton(BedroomAddressActivity.d(BedroomAddressActivity.this), "shanghai", "上海");
            ad.putCityLocaton(BedroomAddressActivity.d(BedroomAddressActivity.this), "zdcity", "上海");
          }
          else if ("440300".equals(paramc.getCityCode()))
          {
            ad.putCityLocaton(BedroomAddressActivity.d(BedroomAddressActivity.this), "shenzhen", "深圳");
            ad.putCityLocaton(BedroomAddressActivity.d(BedroomAddressActivity.this), "zdcity", "深圳");
          }
        }
      }
    }).build().show();
  }
  
  private void b()
  {
    this.f = getIntent().getStringExtra("addressId");
    this.e = new com.ziroom.ziroomcustomer.newclean.b.a(this.a, this.d);
    this.c.setAdapter(this.e);
    e();
  }
  
  private void e()
  {
    Object localObject = ApplicationEx.c.getUser();
    if (localObject == null)
    {
      g.textToast(this.a, "请重新登录");
      return;
    }
    String str = "";
    if (!TextUtils.isEmpty(((UserInfo)localObject).getRealName())) {
      str = ((UserInfo)localObject).getRealName();
    }
    localObject = ((UserInfo)localObject).getUid();
    n.requestBedroomAddress(this.a, str, (String)localObject, new d(this.a, new e(com.ziroom.ziroomcustomer.newclean.d.c.class))
    {
      public void onSuccess(int paramAnonymousInt, List<com.ziroom.ziroomcustomer.newclean.d.c> paramAnonymousList)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousList);
        if (paramAnonymousList != null)
        {
          BedroomAddressActivity.a(BedroomAddressActivity.this).addAll(paramAnonymousList);
          BedroomAddressActivity.b(BedroomAddressActivity.this).notifyDataSetChanged();
        }
      }
    });
  }
  
  private void f()
  {
    this.b.setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        BedroomAddressActivity.c(BedroomAddressActivity.this);
      }
    });
    this.c.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      @Instrumented
      public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        VdsAgent.onItemClick(this, paramAnonymousAdapterView, paramAnonymousView, paramAnonymousInt, paramAnonymousLong);
        if (((com.ziroom.ziroomcustomer.newclean.d.c)BedroomAddressActivity.a(BedroomAddressActivity.this).get(paramAnonymousInt)).getCityCode() != null)
        {
          paramAnonymousAdapterView = ((com.ziroom.ziroomcustomer.newclean.d.c)BedroomAddressActivity.a(BedroomAddressActivity.this).get(paramAnonymousInt)).getLinkPhone();
          if ((TextUtils.isEmpty(paramAnonymousAdapterView)) || (!ah.isMobile(paramAnonymousAdapterView))) {
            g.textToast(BedroomAddressActivity.d(BedroomAddressActivity.this), "电话号码不正确，请修改！");
          }
        }
        else
        {
          return;
        }
        if (b.d.equals(((com.ziroom.ziroomcustomer.newclean.d.c)BedroomAddressActivity.a(BedroomAddressActivity.this).get(paramAnonymousInt)).getCityCode()))
        {
          paramAnonymousAdapterView = new Intent();
          paramAnonymousAdapterView.putExtra("addressList", (Serializable)BedroomAddressActivity.a(BedroomAddressActivity.this).get(paramAnonymousInt));
          paramAnonymousAdapterView.putExtra("isSampleCity", "Yes");
          BedroomAddressActivity.this.setResult(-1, paramAnonymousAdapterView);
          BedroomAddressActivity.this.finish();
          return;
        }
        BedroomAddressActivity.a(BedroomAddressActivity.this, (com.ziroom.ziroomcustomer.newclean.d.c)BedroomAddressActivity.a(BedroomAddressActivity.this).get(paramAnonymousInt));
      }
    });
    this.c.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener()
    {
      public boolean onItemLongClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        g.textToast(BedroomAddressActivity.d(BedroomAddressActivity.this), "自如合同地址不能删除");
        return true;
      }
    });
  }
  
  private void g()
  {
    if (this.r)
    {
      Intent localIntent = new Intent();
      Iterator localIterator;
      if ((this.d != null) && (this.d.size() > 0)) {
        localIterator = this.d.iterator();
      }
      while (localIterator.hasNext())
      {
        com.ziroom.ziroomcustomer.newclean.d.c localc = (com.ziroom.ziroomcustomer.newclean.d.c)localIterator.next();
        if (localc.getAddressId().equals(this.g))
        {
          localIntent.putExtra("addressList", localc);
          continue;
          localIntent.putExtra("isHasModifyDate", "yes");
        }
      }
      localIntent.putExtra("isSampleCity", "Yes");
      setResult(-1, localIntent);
      finish();
      return;
    }
    setResult(0, new Intent());
    finish();
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
    if ((paramInt1 == 3) && (paramInt2 == -1))
    {
      paramIntent = paramIntent.getStringExtra("modify_addressId");
      if ((!TextUtils.isEmpty(this.f)) && (this.f.equals(paramIntent)))
      {
        this.g = paramIntent;
        this.r = true;
      }
      this.d.clear();
      this.e.notifyDataSetChanged();
      e();
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903103);
    this.a = this;
    a();
    b();
    f();
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      g();
      return true;
    }
    return super.onKeyUp(paramInt, paramKeyEvent);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newclean/activity/BedroomAddressActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */