package com.ziroom.ziroomcustomer.my;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.alibaba.fastjson.a;
import com.alibaba.fastjson.e;
import com.freelxl.baselibrary.e.i.a;
import com.freelxl.baselibrary.e.k;
import com.freelxl.baselibrary.f.d;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.e.g;
import com.ziroom.ziroomcustomer.e.j;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MyApartUnEvaAppointActivity
  extends BaseActivity
{
  private ArrayList<String> a = new ArrayList();
  private boolean b = false;
  private boolean c = false;
  private FragmentManager d;
  private MyApartUnEvaAppointFragment e;
  private MyFinishedAppointFragment f;
  @BindView(2131691866)
  FrameLayout flFrag;
  @BindView(2131689492)
  ImageView ivBack;
  @BindView(2131691888)
  TextView tvDel;
  @BindView(2131691563)
  TextView tvEdit;
  @BindView(2131691865)
  TextView tvFinished;
  @BindView(2131691864)
  TextView tvGoing;
  
  private void a()
  {
    int j = 0;
    boolean bool;
    Object localObject;
    if (!this.c)
    {
      bool = true;
      this.c = bool;
      if (!this.c) {
        break label103;
      }
      localObject = "取消";
      label27:
      this.tvEdit.setText((CharSequence)localObject);
      this.a.clear();
      this.f.showSelection(this.c);
      localObject = this.ivBack;
      if (!this.c) {
        break label110;
      }
      i = 8;
      label70:
      ((ImageView)localObject).setVisibility(i);
      localObject = this.tvDel;
      if (!this.c) {
        break label115;
      }
    }
    label103:
    label110:
    label115:
    for (int i = j;; i = 8)
    {
      ((TextView)localObject).setVisibility(i);
      return;
      bool = false;
      break;
      localObject = "编辑";
      break label27;
      i = 0;
      break label70;
    }
  }
  
  private void a(boolean paramBoolean)
  {
    int m = 2131624588;
    int k = 2130837975;
    if (this.b == paramBoolean) {
      return;
    }
    this.b = paramBoolean;
    this.c = false;
    this.tvDel.setVisibility(8);
    this.tvEdit.setText("编辑");
    this.ivBack.setVisibility(0);
    int i;
    int j;
    if (paramBoolean)
    {
      i = 2131624583;
      if (!paramBoolean) {
        break label135;
      }
      j = 2131624559;
      label67:
      if (!paramBoolean) {
        break label141;
      }
      label71:
      if (!paramBoolean) {
        break label148;
      }
    }
    for (;;)
    {
      this.tvGoing.setTextColor(getResources().getColor(j));
      this.tvGoing.setBackgroundResource(i);
      this.tvFinished.setTextColor(getResources().getColor(m));
      this.tvFinished.setBackgroundResource(k);
      b(paramBoolean);
      return;
      i = 2130837975;
      break;
      label135:
      j = 2131624588;
      break label67;
      label141:
      k = 2131624583;
      break label71;
      label148:
      m = 2131624559;
    }
  }
  
  private void b()
  {
    this.d = getSupportFragmentManager();
    FragmentTransaction localFragmentTransaction = this.d.beginTransaction();
    this.e = MyApartUnEvaAppointFragment.getInstance();
    localFragmentTransaction.replace(2131691866, this.e);
    localFragmentTransaction.commitAllowingStateLoss();
  }
  
  private void b(boolean paramBoolean)
  {
    this.a.clear();
    if (paramBoolean)
    {
      localFragmentTransaction = this.d.beginTransaction();
      this.f = MyFinishedAppointFragment.getInstance(this.a);
      localFragmentTransaction.replace(2131691866, this.f);
      localFragmentTransaction.commitAllowingStateLoss();
      this.e = null;
      return;
    }
    FragmentTransaction localFragmentTransaction = this.d.beginTransaction();
    localFragmentTransaction.replace(2131691866, MyAppointingFragment.getInstance());
    localFragmentTransaction.commitAllowingStateLoss();
    this.f = null;
  }
  
  private void e()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("uid", ApplicationEx.c.getUserId(this));
    localHashMap.put("orderIds", this.a.toString());
    g.appendCommenParams(localHashMap);
    j.delMyFinishedAppointBatch(this, new a(), localHashMap, true);
  }
  
  @OnClick({2131689492, 2131691888, 2131691563, 2131691864, 2131691865})
  @Instrumented
  public void onClick(View paramView)
  {
    VdsAgent.onClick(this, paramView);
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131689492: 
      finish();
      return;
    case 2131691888: 
      e();
      d.i("Myappoint====", "del clicked");
      return;
    case 2131691563: 
      a();
      return;
    case 2131691864: 
      a(false);
      return;
    }
    a(true);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903379);
    ButterKnife.bind(this);
    b();
  }
  
  class a
    implements i.a<String>
  {
    a() {}
    
    public void onParse(String paramString, k paramk)
    {
      try
      {
        paramString = a.parseObject(paramString);
        if ("success".equals((String)paramString.get("status")))
        {
          paramk.setSuccess(Boolean.valueOf(true));
          return;
        }
        paramk.setSuccess(Boolean.valueOf(false));
        paramk.setMessage((String)paramString.get("error_message"));
        return;
      }
      catch (Exception paramString)
      {
        paramk.setSuccess(Boolean.valueOf(false));
        paramk.setMessage("服务器异常，正在努力抢修中，请稍后再试!");
        paramString.printStackTrace();
      }
    }
    
    public void onSuccess(k paramk)
    {
      if (paramk.getSuccess().booleanValue())
      {
        MyApartUnEvaAppointActivity.a(MyApartUnEvaAppointActivity.this);
        MyApartUnEvaAppointActivity.b(MyApartUnEvaAppointActivity.this).clear();
        MyApartUnEvaAppointActivity.c(MyApartUnEvaAppointActivity.this).showSelection(false);
        MyApartUnEvaAppointActivity.c(MyApartUnEvaAppointActivity.this).reLoadData();
        return;
      }
      paramk = paramk.getMessage();
      MyApartUnEvaAppointActivity.this.showToast(paramk);
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/my/MyApartUnEvaAppointActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */