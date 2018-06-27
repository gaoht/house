package com.ziroom.ziroomcustomer.minsu.landlordrelease;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.commonlibrary.widget.unifiedziroom.d;
import com.ziroom.commonlibrary.widget.unifiedziroom.d.a;
import com.ziroom.commonlibrary.widget.unifiedziroom.d.b;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.minsu.adapter.e;
import com.ziroom.ziroomcustomer.minsu.adapter.e.a;
import com.ziroom.ziroomcustomer.minsu.adapter.e.b;
import com.ziroom.ziroomcustomer.minsu.landlordrelease.base.BaseLandlordReleaseFragment;
import com.ziroom.ziroomcustomer.minsu.landlordrelease.model.HouseRoomListBean;
import com.ziroom.ziroomcustomer.minsu.landlordrelease.model.LLReleaseRoomHaveBean;
import com.ziroom.ziroomcustomer.minsu.landlordrelease.model.LLReleaseRoomHaveBean.LLReleaseRoomHaveDataBean;
import com.ziroom.ziroomcustomer.minsu.landlordrelease.model.LLReleaseRoomHaveBean.LLReleaseRoomHaveDataBean.RentRoomNumBean;
import com.ziroom.ziroomcustomer.minsu.landlordrelease.model.SaveLLReleaseRoomHaveBean;
import com.ziroom.ziroomcustomer.minsu.landlordrelease.model.SingleChoseBean;
import com.ziroom.ziroomcustomer.minsu.landlordrelease.view.ReleaseUsageAndTipsView;
import com.ziroom.ziroomcustomer.minsu.landlordrelease.view.c.a;
import com.ziroom.ziroomcustomer.util.af;
import com.ziroom.ziroomcustomer.widget.ListViewForScrollView;
import com.ziroom.ziroomcustomer.widget.ObservableScrollView;
import com.ziroom.ziroomcustomer.widget.ObservableScrollView.a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class LLReleaseRoomSecondStepThreeFragment
  extends BaseLandlordReleaseFragment
  implements View.OnClickListener, com.ziroom.ziroomcustomer.minsu.landlordrelease.base.a
{
  e b;
  int c;
  ArrayList<String> d = new ArrayList();
  private ImageView e;
  private View f;
  private ObservableScrollView g;
  private RelativeLayout h;
  private TextView i;
  private ListViewForScrollView j;
  private Button k;
  private MinsuReleaseActivity l;
  private com.ziroom.ziroomcustomer.minsu.landlordrelease.d.c m;
  private com.ziroom.ziroomcustomer.minsu.landlordrelease.a.b n;
  private LLReleaseRoomHaveBean o;
  private ArrayList<SingleChoseBean> p = new ArrayList();
  private ReleaseUsageAndTipsView q;
  private List<HouseRoomListBean> r;
  private TextView s;
  private com.ziroom.ziroomcustomer.minsu.landlordrelease.view.c t;
  private Map<String, Boolean> u = new HashMap();
  
  private com.ziroom.ziroomcustomer.minsu.landlordrelease.view.c a(String paramString, List<SingleChoseBean> paramList, c.a parama)
  {
    paramString = new com.ziroom.ziroomcustomer.minsu.landlordrelease.view.c(this.l, paramString, parama, paramList);
    paramString.setCanceledOnTouchOutside(true);
    paramList = paramString.getWindow();
    paramList.getDecorView().setPadding(0, 0, 0, 0);
    parama = paramList.getAttributes();
    parama.width = -1;
    parama.height = -2;
    paramList.setAttributes(parama);
    paramList.setGravity(80);
    return paramString;
  }
  
  private void d()
  {
    e();
    m();
  }
  
  private void d(String paramString)
  {
    this.c = Integer.valueOf(paramString.split("间")[0]).intValue();
    if (this.c > 0)
    {
      this.i.setText(this.c + "间");
      if (this.r != null) {
        break label141;
      }
      this.r = new ArrayList();
    }
    for (;;)
    {
      this.b = new e(this.l, new b(null), new a(null), this.r);
      this.j.setAdapter(this.b);
      q();
      this.u.put("roomNum", Boolean.valueOf(true));
      return;
      label141:
      int i1;
      if (this.r.size() < this.c)
      {
        i1 = this.r.size() + 1;
        while (i1 <= this.c)
        {
          paramString = new HouseRoomListBean();
          paramString.setText("房间" + i1);
          this.r.add(paramString);
          i1 += 1;
        }
      }
      else if (this.r.size() > this.c)
      {
        int i2 = this.r.size();
        int i3 = this.c;
        i1 = 0;
        while (i1 < i2 - i3)
        {
          paramString = (HouseRoomListBean)this.r.remove(this.r.size() - 1);
          if (!TextUtils.isEmpty(paramString.getValue())) {
            this.d.add(paramString.getValue());
          }
          i1 += 1;
        }
      }
    }
  }
  
  private void e()
  {
    this.e.setOnClickListener(this);
    this.h.setOnClickListener(this);
    this.k.setOnClickListener(this);
    this.g.setOnScrollChangedCallback(new ObservableScrollView.a()
    {
      public void onScroll(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        float f = paramAnonymousInt2 / 100.0F;
        LLReleaseRoomSecondStepThreeFragment.a(LLReleaseRoomSecondStepThreeFragment.this).setAlpha(f);
      }
    });
  }
  
  private void m()
  {
    com.ziroom.ziroomcustomer.minsu.landlordrelease.a.b localb = this.n;
    MinsuReleaseActivity localMinsuReleaseActivity = this.l;
    String str2 = k();
    if (com.ziroom.ziroomcustomer.minsu.f.c.isNull(j())) {}
    for (String str1 = "";; str1 = j())
    {
      localb.getLandlordReleaseRoomListInfo(this, localMinsuReleaseActivity, str2, str1, Integer.valueOf(h()));
      return;
    }
  }
  
  private void n()
  {
    this.m = new com.ziroom.ziroomcustomer.minsu.landlordrelease.d.c(this);
    this.a.register(this.m);
    this.n = com.ziroom.ziroomcustomer.minsu.landlordrelease.a.b.getInstance(this.a);
  }
  
  public static LLReleaseRoomSecondStepThreeFragment newInstance()
  {
    Bundle localBundle = new Bundle();
    LLReleaseRoomSecondStepThreeFragment localLLReleaseRoomSecondStepThreeFragment = new LLReleaseRoomSecondStepThreeFragment();
    localLLReleaseRoomSecondStepThreeFragment.setArguments(localBundle);
    return localLLReleaseRoomSecondStepThreeFragment;
  }
  
  private void o()
  {
    Iterator localIterator = this.u.entrySet().iterator();
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
        d.newBuilder(getActivity()).setOnConfirmClickListener(new d.b()
        {
          public void onLeftClick(View paramAnonymousView) {}
          
          public void onRightClick(View paramAnonymousView)
          {
            LLReleaseRoomSecondStepThreeFragment.g(LLReleaseRoomSecondStepThreeFragment.this);
          }
        }).setTitle(getResources().getString(2131297090)).setContent(getResources().getString(2131297089)).setButtonText("取消", "确定").show();
        return;
      }
      g();
      return;
    }
  }
  
  private boolean p()
  {
    if ((this.r == null) || (this.r.size() == 0)) {}
    while (this.c != this.r.size()) {
      return false;
    }
    Iterator localIterator = this.r.iterator();
    HouseRoomListBean localHouseRoomListBean;
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      localHouseRoomListBean = (HouseRoomListBean)localIterator.next();
    } while ((!TextUtils.isEmpty(localHouseRoomListBean.getValue())) && (!TextUtils.isEmpty(localHouseRoomListBean.getText())));
    for (boolean bool = false;; bool = true) {
      return bool;
    }
  }
  
  private void q()
  {
    if (p())
    {
      this.k.setEnabled(true);
      this.k.setBackgroundResource(2130839597);
      return;
    }
    this.k.setEnabled(false);
    this.k.setBackgroundResource(2130837946);
  }
  
  protected void a(com.ziroom.ziroomcustomer.flux.a.a parama)
  {
    int i2 = 1;
    parama = parama.getType();
    int i1 = -1;
    switch (parama.hashCode())
    {
    default: 
      switch (i1)
      {
      }
      break;
    }
    label388:
    do
    {
      do
      {
        do
        {
          return;
          if (!parama.equals("house_room_have_list")) {
            break;
          }
          i1 = 0;
          break;
          if (!parama.equals("house_room_have_list_error")) {
            break;
          }
          i1 = 1;
          break;
          if (!parama.equals("house_room_save_have_list")) {
            break;
          }
          i1 = 2;
          break;
          if (!parama.equals("house_room_save_have_list_ERROR")) {
            break;
          }
          i1 = 3;
          break;
          this.o = this.m.getmLLReleaseRoomHaveBean();
        } while (this.o == null);
        parama = this.o.getData();
      } while (parama == null);
      int i3 = parama.getMaxRentRoomNum();
      LLReleaseRoomHaveBean.LLReleaseRoomHaveDataBean.RentRoomNumBean localRentRoomNumBean = parama.getRentRoomNum();
      if ((localRentRoomNumBean != null) && (localRentRoomNumBean.isIsEdit()))
      {
        this.h.setEnabled(true);
        if (localRentRoomNumBean != null)
        {
          this.c = localRentRoomNumBean.getValue();
          if (this.c != 0) {
            break label388;
          }
          this.i.setHint("发布房源后，房间数量无法修改");
        }
      }
      for (;;)
      {
        this.r = parama.getHouseRoomList();
        i1 = i2;
        if (this.r != null)
        {
          i1 = i2;
          if (!this.r.isEmpty())
          {
            this.b = new e(this.l, new b(null), new a(null), this.r);
            this.j.setAdapter(this.b);
            i1 = i2;
          }
        }
        while (i1 <= i3)
        {
          parama = new SingleChoseBean();
          parama.setText(i1 + "间");
          this.p.add(parama);
          i1 += 1;
        }
        this.h.setEnabled(false);
        break;
        this.i.setText(this.c + "间");
      }
      this.t = a("roomcount_chose", this.p, new c(null));
      q();
      return;
      this.g.setVisibility(8);
      this.k.setVisibility(8);
      this.q.setVisibility(8);
      showToast(this.m.getRoomHaveListErrorMsg());
      return;
      parama = this.m.getmSaveLLReleaseRoomHaveBean();
    } while ((parama == null) || (Integer.parseInt(parama.getStatus()) != 0));
    f();
    return;
    showToast(this.m.getSaveLLReleaseRoomHaveErrorMsg());
  }
  
  protected View c()
  {
    View localView = LayoutInflater.from(this.l).inflate(2130903961, null);
    this.e = ((ImageView)localView.findViewById(2131689492));
    this.f = localView.findViewById(2131689863);
    this.g = ((ObservableScrollView)localView.findViewById(2131689506));
    this.h = ((RelativeLayout)localView.findViewById(2131694202));
    this.s = ((TextView)localView.findViewById(2131694203));
    this.i = ((TextView)localView.findViewById(2131694204));
    this.j = ((ListViewForScrollView)localView.findViewById(2131694205));
    this.k = ((Button)localView.findViewById(2131691053));
    this.q = ((ReleaseUsageAndTipsView)localView.findViewById(2131689893));
    return localView;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt2 == -1) && (paramInt1 == 123) && (paramIntent.getBooleanExtra("isAloneRoomFinish", false)))
    {
      String str1 = paramIntent.getStringExtra("roomName");
      String str2 = paramIntent.getStringExtra("roomFid");
      paramInt1 = paramIntent.getIntExtra("position", -1);
      paramIntent = (HouseRoomListBean)this.r.get(paramInt1);
      paramIntent.setIsEdit(true);
      paramIntent.setText(str1);
      paramIntent.setValue(str2);
      paramIntent.status = "已完成";
      this.b.notifyDataSetChanged();
      q();
      this.u.put("roomStatus", Boolean.valueOf(true));
    }
  }
  
  public boolean onBackPressed()
  {
    o();
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
    case 2131694202: 
      do
      {
        return;
        o();
        return;
      } while (this.t == null);
      this.t.show();
      return;
    }
    if (!ApplicationEx.c.isLoginState())
    {
      com.ziroom.commonlibrary.login.a.startLoginActivity(this.l);
      af.showToast(this.l, "请先登录");
      return;
    }
    d.newBuilder(this.l).setTitle("请确认床位信息").setContent("您已发布" + this.c + "个独立房间，是否继续发布房源？").setOnConfirmClickListener(new d.b()
    {
      public void onLeftClick(View paramAnonymousView) {}
      
      public void onRightClick(View paramAnonymousView)
      {
        LLReleaseRoomSecondStepThreeFragment.f(LLReleaseRoomSecondStepThreeFragment.this).updateRoomNumAndRoomMsgInfo(LLReleaseRoomSecondStepThreeFragment.this, LLReleaseRoomSecondStepThreeFragment.b(LLReleaseRoomSecondStepThreeFragment.this), LLReleaseRoomSecondStepThreeFragment.c(LLReleaseRoomSecondStepThreeFragment.this), LLReleaseRoomSecondStepThreeFragment.d(LLReleaseRoomSecondStepThreeFragment.this), Integer.valueOf(LLReleaseRoomSecondStepThreeFragment.e(LLReleaseRoomSecondStepThreeFragment.this)), LLReleaseRoomSecondStepThreeFragment.this.c, LLReleaseRoomSecondStepThreeFragment.this.d);
      }
    }).setButtonText("取消", "确定").show();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.l = ((MinsuReleaseActivity)getActivity());
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    n();
    return c();
  }
  
  public void onDestroyView()
  {
    this.a.unregister(this.m);
    super.onDestroyView();
  }
  
  public void onLoginBack(boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((paramBoolean1) && (paramBoolean2)) {
      d();
    }
  }
  
  public void onStart()
  {
    super.onStart();
    this.q.setCode("TIP_HOW_PUBLISH_MULTI_ROOM");
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    d();
  }
  
  private class a
    implements e.a
  {
    private a() {}
    
    public void OnItemLongClickListener(int paramInt)
    {
      if ((LLReleaseRoomSecondStepThreeFragment.i(LLReleaseRoomSecondStepThreeFragment.this) == null) || (LLReleaseRoomSecondStepThreeFragment.i(LLReleaseRoomSecondStepThreeFragment.this).get(paramInt) == null)) {
        return;
      }
      final HouseRoomListBean localHouseRoomListBean = (HouseRoomListBean)LLReleaseRoomSecondStepThreeFragment.i(LLReleaseRoomSecondStepThreeFragment.this).get(paramInt);
      d.newBuilder(LLReleaseRoomSecondStepThreeFragment.this.getActivity()).setOnConfirmClickListener(new d.b()
      {
        public void onLeftClick(View paramAnonymousView) {}
        
        public void onRightClick(View paramAnonymousView)
        {
          if (!TextUtils.isEmpty(localHouseRoomListBean.getValue())) {
            LLReleaseRoomSecondStepThreeFragment.this.d.add(localHouseRoomListBean.getValue());
          }
          LLReleaseRoomSecondStepThreeFragment.i(LLReleaseRoomSecondStepThreeFragment.this).remove(localHouseRoomListBean);
          LLReleaseRoomSecondStepThreeFragment.this.c = LLReleaseRoomSecondStepThreeFragment.i(LLReleaseRoomSecondStepThreeFragment.this).size();
          LLReleaseRoomSecondStepThreeFragment.k(LLReleaseRoomSecondStepThreeFragment.this).setText(LLReleaseRoomSecondStepThreeFragment.this.c + "间");
          LLReleaseRoomSecondStepThreeFragment.this.b.notifyDataSetChanged();
          LLReleaseRoomSecondStepThreeFragment.l(LLReleaseRoomSecondStepThreeFragment.this);
        }
      }).setContent("删除房间后数据无法恢复，请确认是否继续删除？").setTitle("提示").setButtonText("取消", "确定").show();
    }
  }
  
  private class b
    implements e.b
  {
    private b() {}
    
    public void onRoomHaveItemClickListener(int paramInt)
    {
      Intent localIntent = new Intent(LLReleaseRoomSecondStepThreeFragment.b(LLReleaseRoomSecondStepThreeFragment.this), AloneRoomInfoActivity.class);
      localIntent.putExtra("position", paramInt);
      localIntent.putExtra("houseBaseFid", LLReleaseRoomSecondStepThreeFragment.h(LLReleaseRoomSecondStepThreeFragment.this));
      if ((LLReleaseRoomSecondStepThreeFragment.i(LLReleaseRoomSecondStepThreeFragment.this) != null) && (LLReleaseRoomSecondStepThreeFragment.i(LLReleaseRoomSecondStepThreeFragment.this).size() > paramInt)) {
        localIntent.putExtra("roomFid", ((HouseRoomListBean)LLReleaseRoomSecondStepThreeFragment.i(LLReleaseRoomSecondStepThreeFragment.this).get(paramInt)).getValue());
      }
      localIntent.putExtra("rentWay", LLReleaseRoomSecondStepThreeFragment.j(LLReleaseRoomSecondStepThreeFragment.this));
      localIntent.putExtra("rentRoomNum", LLReleaseRoomSecondStepThreeFragment.this.c);
      LLReleaseRoomSecondStepThreeFragment.this.startActivityForResult(localIntent, 123);
    }
  }
  
  private class c
    implements c.a
  {
    private c() {}
    
    public void onSingleSelect(final String paramString, int paramInt)
    {
      if (TextUtils.isEmpty(paramString)) {
        return;
      }
      int i = Integer.valueOf(paramString.split("间")[0]).intValue();
      if ((i > 0) && (LLReleaseRoomSecondStepThreeFragment.i(LLReleaseRoomSecondStepThreeFragment.this) != null) && (LLReleaseRoomSecondStepThreeFragment.i(LLReleaseRoomSecondStepThreeFragment.this).size() > i))
      {
        StringBuilder localStringBuilder = new StringBuilder("您的操作将会导致");
        int j = LLReleaseRoomSecondStepThreeFragment.i(LLReleaseRoomSecondStepThreeFragment.this).size();
        paramInt = 0;
        while (paramInt < j - i)
        {
          HouseRoomListBean localHouseRoomListBean = (HouseRoomListBean)LLReleaseRoomSecondStepThreeFragment.i(LLReleaseRoomSecondStepThreeFragment.this).remove(LLReleaseRoomSecondStepThreeFragment.i(LLReleaseRoomSecondStepThreeFragment.this).size() - 1);
          localStringBuilder.append("第").append("" + (i + 1 + paramInt)).append("个、");
          paramInt += 1;
        }
        d.newBuilder(LLReleaseRoomSecondStepThreeFragment.this.getActivity()).setOnConfirmClickListener(new d.b()
        {
          public void onLeftClick(View paramAnonymousView) {}
          
          public void onRightClick(View paramAnonymousView)
          {
            LLReleaseRoomSecondStepThreeFragment.a(LLReleaseRoomSecondStepThreeFragment.this, paramString);
          }
        }).setTitle("提示").setContent(localStringBuilder.substring(0, localStringBuilder.length() - 1) + "房间数据丢失，请确认是否继续修改？").setButtonText("取消", "确定").show();
        return;
      }
      LLReleaseRoomSecondStepThreeFragment.a(LLReleaseRoomSecondStepThreeFragment.this, paramString);
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/landlordrelease/LLReleaseRoomSecondStepThreeFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */