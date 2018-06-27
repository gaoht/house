package com.ziroom.ziroomcustomer.minsu.landlordrelease;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.freelxl.baselibrary.f.g;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.commonlibrary.widget.unifiedziroom.d;
import com.ziroom.commonlibrary.widget.unifiedziroom.d.a;
import com.ziroom.commonlibrary.widget.unifiedziroom.d.b;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.minsu.landlordrelease.base.BaseLandlordReleaseFragment;
import com.ziroom.ziroomcustomer.minsu.landlordrelease.d.c;
import com.ziroom.ziroomcustomer.minsu.landlordrelease.model.housedesec.HouseDeasCommonDataBean;
import com.ziroom.ziroomcustomer.minsu.landlordrelease.model.housedesec.HouseDescBaseData;
import com.ziroom.ziroomcustomer.minsu.landlordrelease.model.housedesec.LLSaveHouseDescBean;
import com.ziroom.ziroomcustomer.minsu.landlordrelease.model.housedesec.LLSaveHouseDescBean.SaveHouseDescData;
import com.ziroom.ziroomcustomer.minsu.landlordrelease.model.housedesec.LandlordReleaseHouseDescBean;
import com.ziroom.ziroomcustomer.minsu.landlordrelease.view.CommonSaveDescInfoActivity;
import com.ziroom.ziroomcustomer.minsu.landlordrelease.view.ReleaseUsageAndTipsView;
import com.ziroom.ziroomcustomer.util.af;
import com.ziroom.ziroomcustomer.widget.ObservableScrollView;
import com.ziroom.ziroomcustomer.widget.ObservableScrollView.a;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class LLReleaseSecondStepOneFragment
  extends BaseLandlordReleaseFragment
  implements View.OnClickListener, com.ziroom.ziroomcustomer.minsu.landlordrelease.base.a
{
  private String A;
  private String B = "";
  private boolean C = false;
  private boolean D = false;
  private String E;
  private Map<String, Boolean> F = new HashMap();
  private BroadcastReceiver G = new BroadcastReceiver()
  {
    public void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
    {
      if (paramAnonymousIntent.getIntExtra("type", 0) == 17) {
        LLReleaseSecondStepOneFragment.e(LLReleaseSecondStepOneFragment.this);
      }
    }
  };
  private ImageView b;
  private ObservableScrollView c;
  private RelativeLayout d;
  private EditText e;
  private RelativeLayout f;
  private TextView g;
  private RelativeLayout h;
  private TextView i;
  private TextView j;
  private TextView k;
  private TextView l;
  private c m;
  private com.ziroom.ziroomcustomer.minsu.landlordrelease.a.b n;
  private LandlordReleaseHouseDescBean o;
  private HouseDeasCommonDataBean p;
  private HouseDeasCommonDataBean q;
  private HouseDeasCommonDataBean r;
  private Button s;
  private MinsuReleaseActivity t;
  private TextView u;
  private int v;
  private View w;
  private View x;
  private ReleaseUsageAndTipsView y;
  private String z;
  
  private void d()
  {
    this.v = h();
    if (this.v == 0) {
      this.u.setText("第2步：描述及价格（1/2）");
    }
    for (;;)
    {
      e();
      m();
      do
      {
        return;
      } while (this.v != 1);
      this.d.setVisibility(8);
      this.w.setVisibility(8);
      this.u.setText("第2步：描述及价格（1/3）");
    }
  }
  
  private void e()
  {
    this.b.setOnClickListener(this);
    this.d.setOnClickListener(this);
    this.f.setOnClickListener(this);
    this.h.setOnClickListener(this);
    this.s.setOnClickListener(this);
    this.e.addTextChangedListener(new TextWatcher()
    {
      public void afterTextChanged(Editable paramAnonymousEditable) {}
      
      public void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        LLReleaseSecondStepOneFragment.a(LLReleaseSecondStepOneFragment.this);
        LLReleaseSecondStepOneFragment.b(LLReleaseSecondStepOneFragment.this).put("houseName", Boolean.valueOf(true));
      }
    });
    this.c.setOnScrollChangedCallback(new ObservableScrollView.a()
    {
      public void onScroll(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        float f = paramAnonymousInt2 / 100.0F;
        if (LLReleaseSecondStepOneFragment.c(LLReleaseSecondStepOneFragment.this) != null) {
          LLReleaseSecondStepOneFragment.c(LLReleaseSecondStepOneFragment.this).setAlpha(f);
        }
      }
    });
  }
  
  private void m()
  {
    this.n.getLandlordReleaseHouseDesc(this, this.t, k(), j(), Integer.valueOf(this.v));
  }
  
  private void n()
  {
    this.m = new c(this);
    this.a.register(this.m);
    this.n = com.ziroom.ziroomcustomer.minsu.landlordrelease.a.b.getInstance(this.a);
  }
  
  public static LLReleaseSecondStepOneFragment newInstance()
  {
    Bundle localBundle = new Bundle();
    LLReleaseSecondStepOneFragment localLLReleaseSecondStepOneFragment = new LLReleaseSecondStepOneFragment();
    localLLReleaseSecondStepOneFragment.setArguments(localBundle);
    return localLLReleaseSecondStepOneFragment;
  }
  
  private void o()
  {
    String str2;
    if ((this.o != null) && (this.o.getData() != null))
    {
      this.p = this.o.getData().getHouseName();
      this.q = this.o.getData().getHouseDesc();
      this.r = this.o.getData().getHouseAroundDesc();
      String str1;
      if (this.p != null)
      {
        str1 = this.p.getValue();
        this.E = this.p.getText();
        if (TextUtils.isEmpty(str1)) {
          break label242;
        }
        this.e.setText(str1);
        this.e.setTextColor(Color.parseColor("#444444"));
      }
      if (this.q != null)
      {
        str1 = this.q.getValue();
        str2 = this.q.getText();
        this.z = this.q.getExplain();
        if (TextUtils.isEmpty(str1)) {
          break label269;
        }
        this.g.setText(str1);
        this.g.setTextColor(Color.parseColor("#444444"));
      }
      label175:
      if (this.r != null)
      {
        str1 = this.r.getValue();
        str2 = this.r.getText();
        this.A = this.r.getExplain();
        if (TextUtils.isEmpty(str1)) {
          break label300;
        }
        this.i.setText(str1);
        this.i.setTextColor(Color.parseColor("#444444"));
      }
    }
    for (;;)
    {
      r();
      return;
      label242:
      this.e.setHint(this.E);
      this.e.setHintTextColor(Color.parseColor("#999999"));
      break;
      label269:
      if (TextUtils.isEmpty(str2)) {
        break label175;
      }
      this.g.setHint(str2);
      this.g.setTextColor(Color.parseColor("#999999"));
      break label175;
      label300:
      this.i.setHint(str2);
      this.i.setTextColor(Color.parseColor("#999999"));
    }
  }
  
  private void p()
  {
    Iterator localIterator = this.F.entrySet().iterator();
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
    } while (!((Boolean)((Map.Entry)localIterator.next()).getValue()).booleanValue());
    for (int i1 = 1;; i1 = 0)
    {
      if (i1 != 0)
      {
        d.newBuilder(this.t).setOnConfirmClickListener(new d.b()
        {
          public void onLeftClick(View paramAnonymousView) {}
          
          public void onRightClick(View paramAnonymousView)
          {
            LLReleaseSecondStepOneFragment.d(LLReleaseSecondStepOneFragment.this);
          }
        }).setTitle(getResources().getString(2131297090)).setContent(getResources().getString(2131297089)).setButtonText("取消", "确定").show();
        return;
      }
      g();
      return;
    }
  }
  
  private void q()
  {
    if (!ApplicationEx.c.isLoginState())
    {
      com.ziroom.commonlibrary.login.a.startLoginActivity(this.t);
      af.showToast(this.t, "请先登录");
      return;
    }
    if (h() == 0)
    {
      this.B = VdsAgent.trackEditTextSilent(this.e).toString();
      if (TextUtils.isEmpty(this.B))
      {
        g.textToast(this.t, "请填写房源名称");
        return;
      }
      if (this.B.length() < 10)
      {
        g.textToast(this.t, "房源名称不能少于10个字");
        return;
      }
    }
    String str1 = this.g.getText().toString();
    if (TextUtils.isEmpty(str1))
    {
      g.textToast(this.t, "请填写房源描述");
      return;
    }
    String str2 = this.i.getText().toString();
    if (TextUtils.isEmpty(str2))
    {
      g.textToast(this.t, "请填写周边情况");
      return;
    }
    this.n.saveHouseDesc(this, this.t, k(), Integer.valueOf(h()), this.B, str1, str2);
  }
  
  private void r()
  {
    if (this.v == 0)
    {
      if ((!TextUtils.isEmpty(VdsAgent.trackEditTextSilent(this.e).toString())) && (!TextUtils.isEmpty(this.g.getText().toString())) && (!TextUtils.isEmpty(this.i.getText().toString())))
      {
        this.s.setEnabled(true);
        this.s.setBackgroundResource(2130839597);
        return;
      }
      if ((!TextUtils.isEmpty(VdsAgent.trackEditTextSilent(this.e).toString())) && (this.C) && (this.D))
      {
        this.s.setBackgroundResource(2130839597);
        this.s.setEnabled(true);
        return;
      }
      this.s.setBackgroundResource(2130837946);
      this.s.setEnabled(false);
      return;
    }
    if ((this.C) && (this.D))
    {
      this.s.setEnabled(true);
      this.s.setBackgroundResource(2130839597);
      return;
    }
    if ((!TextUtils.isEmpty(this.g.getText().toString())) && (!TextUtils.isEmpty(this.i.getText().toString())))
    {
      this.s.setEnabled(true);
      this.s.setBackgroundResource(2130839597);
      return;
    }
    this.s.setEnabled(false);
    this.s.setBackgroundResource(2130837946);
  }
  
  protected void a(com.ziroom.ziroomcustomer.flux.a.a parama)
  {
    parama = parama.getType();
    int i1 = -1;
    switch (parama.hashCode())
    {
    }
    for (;;)
    {
      switch (i1)
      {
      default: 
        return;
        if (parama.equals("hous_desc"))
        {
          i1 = 0;
          continue;
          if (parama.equals("hous_desc_error"))
          {
            i1 = 1;
            continue;
            if (parama.equals("house_save_desc"))
            {
              i1 = 2;
              continue;
              if (parama.equals("house_save_desc_error")) {
                i1 = 3;
              }
            }
          }
        }
        break;
      }
    }
    this.o = this.m.getmLandlordReleaseHouseDescBean();
    o();
    this.F.put("houseName", Boolean.valueOf(false));
    return;
    this.c.setVisibility(8);
    this.s.setVisibility(8);
    this.y.setVisibility(8);
    showToast(this.m.getHouseDescErrorMsg());
    return;
    parama = this.m.getmLLSaveHouseDescBean();
    LLSaveHouseDescBean.SaveHouseDescData localSaveHouseDescData = parama.getData();
    if (localSaveHouseDescData != null)
    {
      if (!TextUtils.isEmpty(localSaveHouseDescData.getHouseBaseFid()))
      {
        f();
        this.F.clear();
        return;
      }
      g.textToast(this.t, "服务异常，请稍后重试");
      return;
    }
    g.textToast(this.t, parama.message);
    return;
    showToast(this.m.getHouseSaveErrorMsg());
  }
  
  protected View c()
  {
    View localView = LayoutInflater.from(this.t).inflate(2130903963, null);
    this.b = ((ImageView)localView.findViewById(2131689492));
    this.c = ((ObservableScrollView)localView.findViewById(2131689506));
    this.w = localView.findViewById(2131694658);
    this.u = ((TextView)localView.findViewById(2131694294));
    this.d = ((RelativeLayout)localView.findViewById(2131694192));
    this.e = ((EditText)localView.findViewById(2131694193));
    this.f = ((RelativeLayout)localView.findViewById(2131694194));
    this.g = ((TextView)localView.findViewById(2131694660));
    this.h = ((RelativeLayout)localView.findViewById(2131694197));
    this.i = ((TextView)localView.findViewById(2131694663));
    this.x = localView.findViewById(2131689863);
    this.j = ((TextView)localView.findViewById(2131694662));
    this.k = ((TextView)localView.findViewById(2131694659));
    this.l = ((TextView)localView.findViewById(2131694657));
    this.s = ((Button)localView.findViewById(2131691053));
    this.s.setEnabled(false);
    this.y = ((ReleaseUsageAndTipsView)localView.findViewById(2131689893));
    return localView;
  }
  
  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    paramBundle = new IntentFilter();
    paramBundle.addAction("com.ziroom.commonlibrary.login.broadcast");
    LocalBroadcastManager.getInstance(this.t).registerReceiver(this.G, paramBundle);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt2 == 4096)
    {
      paramIntent = paramIntent.getStringExtra("saveDesc");
      if (paramInt1 != 234) {
        break label73;
      }
      this.g.setText(paramIntent);
      this.g.setTextColor(Color.parseColor("#444444"));
      this.C = true;
      this.F.put("houseDesc", Boolean.valueOf(true));
    }
    label73:
    while (paramInt1 != 456) {
      return;
    }
    this.i.setText(paramIntent);
    this.i.setTextColor(Color.parseColor("#444444"));
    this.D = true;
    this.F.put("houseAroundDesc", Boolean.valueOf(true));
  }
  
  public boolean onBackPressed()
  {
    p();
    return false;
  }
  
  @Instrumented
  public void onClick(View paramView)
  {
    VdsAgent.onClick(this, paramView);
    switch (paramView.getId())
    {
    default: 
    case 2131689492: 
    case 2131694193: 
    case 2131694194: 
    case 2131694197: 
      do
      {
        do
        {
          return;
          p();
          return;
          if (this.p != null)
          {
            if (!this.p.isEdit()) {
              break;
            }
            this.e.setEnabled(true);
            this.e.setClickable(true);
          }
        } while (this.q == null);
        if (this.q.isEdit())
        {
          paramView = new Intent(this.t, CommonSaveDescInfoActivity.class);
          paramView.putExtra("titleName", "房源描述");
          paramView.putExtra("editTextHint", this.z);
          paramView.putExtra("saveDescText", this.g.getText() + "");
          paramView.putExtra("editMaxNum", 1000);
          paramView.putExtra("editMinNum", 100);
          paramView.putExtra("saveDescText", this.g.getText().toString());
          startActivityForResult(paramView, 234);
          return;
          this.e.setEnabled(false);
          this.e.setClickable(false);
          showToast("不可编辑");
          return;
        }
        showToast("不可编辑");
        return;
      } while (this.r == null);
      if (this.r.isEdit())
      {
        paramView = new Intent(this.t, CommonSaveDescInfoActivity.class);
        paramView.putExtra("titleName", "周边情况");
        paramView.putExtra("editTextHint", this.A);
        paramView.putExtra("saveDescText", this.i.getText() + "");
        paramView.putExtra("editMaxNum", 1000);
        paramView.putExtra("editMinNum", 100);
        paramView.putExtra("saveDescText", this.i.getText().toString());
        startActivityForResult(paramView, 456);
        return;
      }
      showToast("不可编辑");
      return;
    }
    q();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.t = ((MinsuReleaseActivity)getActivity());
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    n();
    return c();
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    LocalBroadcastManager.getInstance(this.t).unregisterReceiver(this.G);
  }
  
  public void onDestroyView()
  {
    this.a.unregister(this.m);
    super.onDestroyView();
  }
  
  public void onLoginBack(boolean paramBoolean1, boolean paramBoolean2) {}
  
  public void onResume()
  {
    super.onResume();
    r();
  }
  
  public void onStart()
  {
    super.onStart();
    this.y.setCode("TIP_HOW_WRITE_DESC");
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    d();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/landlordrelease/LLReleaseSecondStepOneFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */