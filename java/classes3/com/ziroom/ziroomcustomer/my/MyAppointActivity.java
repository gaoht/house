package com.ziroom.ziroomcustomer.my;

import android.content.Intent;
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
import com.ziroom.ziroomcustomer.util.u;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MyAppointActivity
  extends BaseActivity
{
  private String a = MyAppointActivity.class.getSimpleName();
  private ArrayList<String> b = new ArrayList();
  private boolean c = false;
  private boolean d = false;
  private FragmentManager e;
  private MyAppointingFragment f;
  @BindView(2131691866)
  FrameLayout flFrag;
  private MyFinishedAppointFragment g;
  @BindView(2131689492)
  ImageView ivBack;
  private String r;
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
    if (!this.d)
    {
      bool = true;
      this.d = bool;
      if (!this.d) {
        break label103;
      }
      localObject = "取消";
      label27:
      this.tvEdit.setText((CharSequence)localObject);
      this.b.clear();
      this.g.showSelection(this.d);
      localObject = this.ivBack;
      if (!this.d) {
        break label110;
      }
      i = 8;
      label70:
      ((ImageView)localObject).setVisibility(i);
      localObject = this.tvDel;
      if (!this.d) {
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
    this.c = paramBoolean;
    this.d = false;
    this.tvDel.setVisibility(8);
    this.tvEdit.setText("编辑");
    this.ivBack.setVisibility(0);
    int i;
    int j;
    if (paramBoolean)
    {
      i = 2131624583;
      if (!paramBoolean) {
        break label126;
      }
      j = 2131624599;
      label58:
      if (!paramBoolean) {
        break label132;
      }
      label62:
      if (!paramBoolean) {
        break label139;
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
      label126:
      j = 2131624588;
      break label58;
      label132:
      k = 2131624583;
      break label62;
      label139:
      m = 2131624599;
    }
  }
  
  private void b()
  {
    this.r = getIntent().getStringExtra("tabIndex");
    this.e = getSupportFragmentManager();
    FragmentTransaction localFragmentTransaction = this.e.beginTransaction();
    this.f = MyAppointingFragment.getInstance();
    localFragmentTransaction.replace(2131691866, this.f);
    localFragmentTransaction.commitAllowingStateLoss();
    u.i(this.a, "tabIndex:" + this.r);
    if ("1".equals(this.r)) {
      a(true);
    }
  }
  
  private void b(boolean paramBoolean)
  {
    this.b.clear();
    if (paramBoolean)
    {
      localFragmentTransaction = this.e.beginTransaction();
      this.g = MyFinishedAppointFragment.getInstance(this.b);
      localFragmentTransaction.replace(2131691866, this.g);
      localFragmentTransaction.commitAllowingStateLoss();
      this.f = null;
      return;
    }
    FragmentTransaction localFragmentTransaction = this.e.beginTransaction();
    localFragmentTransaction.replace(2131691866, MyAppointingFragment.getInstance());
    localFragmentTransaction.commitAllowingStateLoss();
    this.g = null;
  }
  
  private void e()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("uid", ApplicationEx.c.getUserId(this));
    localHashMap.put("orderIds", this.b.toString());
    g.appendCommenParams(localHashMap);
    j.delMyFinishedAppointBatch(this, new a(), localHashMap, true);
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt2 == 4660) {
      a(this.c);
    }
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
    setContentView(2130903380);
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
        MyAppointActivity.a(MyAppointActivity.this);
        MyAppointActivity.b(MyAppointActivity.this).clear();
        MyAppointActivity.c(MyAppointActivity.this).showSelection(false);
        MyAppointActivity.c(MyAppointActivity.this).reLoadData();
        return;
      }
      paramk = paramk.getMessage();
      MyAppointActivity.this.showToast(paramk);
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/my/MyAppointActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */