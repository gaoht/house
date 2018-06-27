package com.ziroom.ziroomcustomer.ziroomapartment.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.alibaba.fastjson.e;
import com.freelxl.baselibrary.d.f.a;
import com.freelxl.baselibrary.f.g;
import com.growingio.android.sdk.agent.VdsAgent;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.dialog.d.a;
import com.ziroom.ziroomcustomer.e.a.c;
import com.ziroom.ziroomcustomer.e.c.f;
import com.ziroom.ziroomcustomer.e.j;
import com.ziroom.ziroomcustomer.ziroomapartment.model.sign.ZryuSignCertType;
import com.ziroom.ziroomcustomer.ziroomapartment.model.sign.ZryuSignCertTypeList;
import com.ziroom.ziroomcustomer.ziroomapartment.model.sign.ZryuSignCotenant;
import com.ziroom.ziroomcustomer.ziroomapartment.model.sign.ZryuSignCotenantCertItem;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ZryuSignAddCotenantActivity
  extends BaseActivity
{
  private ImageView a;
  private TextView b;
  private TextView c;
  private EditText d;
  private TextView e;
  private TextView f;
  private EditText g;
  private EditText r;
  private ZryuSignCotenant s;
  private List<ZryuSignCertType> t;
  private List<String> u;
  private String v;
  private String w;
  private boolean x;
  private c y = new c(this, new com.ziroom.ziroomcustomer.e.c.d())
  {
    public void onSuccess(int paramAnonymousInt, e paramAnonymouse)
    {
      super.onSuccess(paramAnonymousInt, paramAnonymouse);
      g.textToast(ZryuSignAddCotenantActivity.this, "合租人信息保存成功！");
      if (ZryuSignAddCotenantActivity.c(ZryuSignAddCotenantActivity.this))
      {
        ZryuSignAddCotenantActivity.this.setResult(-1);
        ZryuSignAddCotenantActivity.this.finish();
        return;
      }
      paramAnonymouse = new Intent(ZryuSignAddCotenantActivity.this, ZryuSignCotenantActivity.class);
      paramAnonymouse.putExtra("contractId", ZryuSignAddCotenantActivity.d(ZryuSignAddCotenantActivity.this));
      paramAnonymouse.setFlags(536870912);
      ZryuSignAddCotenantActivity.this.startActivityAndFinish(paramAnonymouse);
    }
  };
  private c z = new c(this, new f(ZryuSignCertTypeList.class))
  {
    public void onSuccess(int paramAnonymousInt, ZryuSignCertTypeList paramAnonymousZryuSignCertTypeList)
    {
      super.onSuccess(paramAnonymousInt, paramAnonymousZryuSignCertTypeList);
      if (paramAnonymousZryuSignCertTypeList != null)
      {
        ZryuSignAddCotenantActivity.a(ZryuSignAddCotenantActivity.this, paramAnonymousZryuSignCertTypeList.getCertTypeList());
        if ((ZryuSignAddCotenantActivity.b(ZryuSignAddCotenantActivity.this) != null) && (ZryuSignAddCotenantActivity.b(ZryuSignAddCotenantActivity.this).size() > 0))
        {
          ZryuSignAddCotenantActivity.b(ZryuSignAddCotenantActivity.this, new ArrayList());
          paramAnonymousZryuSignCertTypeList = ZryuSignAddCotenantActivity.b(ZryuSignAddCotenantActivity.this).iterator();
          while (paramAnonymousZryuSignCertTypeList.hasNext())
          {
            ZryuSignCertType localZryuSignCertType = (ZryuSignCertType)paramAnonymousZryuSignCertTypeList.next();
            ZryuSignAddCotenantActivity.e(ZryuSignAddCotenantActivity.this).add(localZryuSignCertType.getName());
          }
        }
      }
    }
  };
  
  private void a()
  {
    this.a = ((ImageView)findViewById(2131689492));
    this.b = ((TextView)findViewById(2131690953));
    this.c = ((TextView)findViewById(2131689541));
    this.d = ((EditText)findViewById(2131689810));
    this.e = ((TextView)findViewById(2131692953));
    this.f = ((TextView)findViewById(2131692954));
    this.g = ((EditText)findViewById(2131692955));
    this.r = ((EditText)findViewById(2131692956));
  }
  
  private void b()
  {
    this.s = ((ZryuSignCotenant)getIntent().getParcelableExtra("cotenant"));
    this.w = getIntent().getStringExtra("contractId");
    this.x = getIntent().getBooleanExtra("isFromList", false);
    if (!TextUtils.isEmpty(this.w)) {
      j.zryuItemDeliveryCertType(this, this.w, this.z);
    }
    if (this.s != null)
    {
      this.c.setText("编辑合租人");
      this.d.setText(this.s.getName());
      if (this.s.getCertInfo() != null)
      {
        this.f.setText(this.s.getCertInfo().getName());
        this.g.setText(this.s.getCertInfo().getValue());
        this.v = this.s.getCertInfo().getCode();
      }
      this.r.setText(this.s.getPhone());
      return;
    }
    this.c.setText("添加合租人");
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903602);
    a();
    b();
  }
  
  public void onViewClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131689492: 
      finish();
      return;
    case 2131690953: 
      paramView = "";
      String str1 = VdsAgent.trackEditTextSilent(this.d).toString().trim();
      String str2 = VdsAgent.trackEditTextSilent(this.g).toString().trim();
      String str3 = VdsAgent.trackEditTextSilent(this.r).toString().trim();
      if (this.s != null) {
        paramView = this.s.getFid();
      }
      if (TextUtils.isEmpty(str1))
      {
        g.textToast(this, "请填写真实姓名!");
        return;
      }
      if (TextUtils.isEmpty(this.v))
      {
        g.textToast(this, "请选择证件类型!");
        return;
      }
      if (TextUtils.isEmpty(str2))
      {
        g.textToast(this, "请填写证件号码!");
        return;
      }
      if (TextUtils.isEmpty(str3))
      {
        g.textToast(this, "请填写联系方式!");
        return;
      }
      j.zryuItemDeliverySaveOrUpdateSharer(this, this.w, paramView, str1, this.v, str2, str3, this.y);
      return;
    }
    if ((this.t != null) && (this.t.size() > 0) && (this.u != null) && (this.u.size() == this.t.size()))
    {
      new com.ziroom.ziroomcustomer.dialog.d(this, this.u, new d.a()
      {
        public void callback(int paramAnonymousInt, String paramAnonymousString)
        {
          ZryuSignAddCotenantActivity.a(ZryuSignAddCotenantActivity.this).setText(paramAnonymousString);
          if ((ZryuSignAddCotenantActivity.b(ZryuSignAddCotenantActivity.this) != null) && (paramAnonymousInt < ZryuSignAddCotenantActivity.b(ZryuSignAddCotenantActivity.this).size()) && (ZryuSignAddCotenantActivity.b(ZryuSignAddCotenantActivity.this).get(paramAnonymousInt) != null)) {
            ZryuSignAddCotenantActivity.a(ZryuSignAddCotenantActivity.this, ((ZryuSignCertType)ZryuSignAddCotenantActivity.b(ZryuSignAddCotenantActivity.this).get(paramAnonymousInt)).getCode() + "");
          }
        }
      }).show();
      return;
    }
    g.textToast(this, "证件类型获取失败，请刷新页面！");
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/ziroomapartment/activity/ZryuSignAddCotenantActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */