package com.ziroom.ziroomcustomer.minsu.landlordrelease;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
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
import com.ziroom.ziroomcustomer.minsu.f.aa;
import com.ziroom.ziroomcustomer.minsu.landlordrelease.base.BaseLandlordReleaseFragment;
import com.ziroom.ziroomcustomer.minsu.landlordrelease.d.c;
import com.ziroom.ziroomcustomer.minsu.landlordrelease.model.SaveLLReleaseRoomBasicBean;
import com.ziroom.ziroomcustomer.minsu.landlordrelease.model.SaveLLReleaseRoomBasicBean.DataBean;
import com.ziroom.ziroomcustomer.minsu.landlordrelease.model.SingleChoseBean;
import com.ziroom.ziroomcustomer.minsu.landlordrelease.model.roombasic.FacilitiesChildDataBean;
import com.ziroom.ziroomcustomer.minsu.landlordrelease.model.roombasic.LLReleaseRoomAmenitiesBean;
import com.ziroom.ziroomcustomer.minsu.landlordrelease.model.roombasic.LLReleaseRoomBasicBean;
import com.ziroom.ziroomcustomer.minsu.landlordrelease.model.roombasic.LLReleaseRoomBasicBean.LLReleaseRoomBasicDataBean;
import com.ziroom.ziroomcustomer.minsu.landlordrelease.model.roombasic.LLReleaseRoomBasicBean.LLReleaseRoomBasicDataBean.HouseFacilityBean;
import com.ziroom.ziroomcustomer.minsu.landlordrelease.model.roombasic.LLReleaseRoomBasicBean.LLReleaseRoomBasicDataBean.HouseRoomTypeBean;
import com.ziroom.ziroomcustomer.minsu.landlordrelease.model.roombasic.LLReleaseRoomBasicBean.LLReleaseRoomBasicDataBean.WithLandlordBean;
import com.ziroom.ziroomcustomer.minsu.landlordrelease.model.roombasic.LLReleaseRoomBasicBean.LLReleaseRoomBasicDataBean.WithLandlordBean.WithLandlordDataBean;
import com.ziroom.ziroomcustomer.minsu.landlordrelease.model.roombasic.RoomFacilityGroupBean;
import com.ziroom.ziroomcustomer.minsu.landlordrelease.model.roombasic.RoomFacilityGroupBean.FacilitiesBean;
import com.ziroom.ziroomcustomer.minsu.landlordrelease.view.ReleaseUsageAndTipsView;
import com.ziroom.ziroomcustomer.minsu.landlordrelease.view.b.a;
import com.ziroom.ziroomcustomer.util.af;
import com.ziroom.ziroomcustomer.widget.ObservableScrollView;
import com.ziroom.ziroomcustomer.widget.ObservableScrollView.a;
import com.ziroom.ziroomcustomer.ziroomstation.dialog.a.b;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class LLReleaseRoomSecondStepTwoFragment
  extends BaseLandlordReleaseFragment
  implements View.OnClickListener, com.ziroom.ziroomcustomer.minsu.landlordrelease.base.a
{
  private List<LLReleaseRoomBasicBean.LLReleaseRoomBasicDataBean.WithLandlordBean.WithLandlordDataBean> A;
  private int B;
  private String C;
  private int D;
  private int E;
  private int F;
  private int G;
  private int H;
  private com.ziroom.ziroomcustomer.ziroomstation.dialog.a I;
  private ObservableScrollView J;
  private boolean K = false;
  private boolean L = false;
  private boolean M = false;
  private com.ziroom.ziroomcustomer.minsu.landlordrelease.view.b N;
  private BroadcastReceiver O = new BroadcastReceiver()
  {
    public void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
    {
      if (paramAnonymousIntent.getIntExtra("type", 0) == 17) {
        LLReleaseRoomSecondStepTwoFragment.g(LLReleaseRoomSecondStepTwoFragment.this);
      }
    }
  };
  private MinsuReleaseActivity b;
  private ImageView c;
  private View d;
  private RelativeLayout e;
  private TextView f;
  private RelativeLayout g;
  private TextView h;
  private RelativeLayout i;
  private TextView j;
  private c k;
  private com.ziroom.ziroomcustomer.minsu.landlordrelease.a.b l;
  private Button m;
  private LLReleaseRoomBasicBean n;
  private LLReleaseRoomBasicBean.LLReleaseRoomBasicDataBean.HouseFacilityBean o;
  private LLReleaseRoomBasicBean.LLReleaseRoomBasicDataBean.WithLandlordBean p;
  private LLReleaseRoomBasicBean.LLReleaseRoomBasicDataBean.HouseRoomTypeBean q;
  private List<RoomFacilityGroupBean> r;
  private ArrayList<String> s = new ArrayList();
  private ArrayList<String> t = new ArrayList();
  private ArrayList<String> u = new ArrayList();
  private ArrayList<String> v = new ArrayList();
  private ArrayList<String> w = new ArrayList();
  private List<SingleChoseBean> x = new ArrayList();
  private ReleaseUsageAndTipsView y;
  private int z = 777;
  
  private void a(Integer paramInteger1, Integer paramInteger2, Integer paramInteger3, Integer paramInteger4, Integer paramInteger5)
  {
    int i3 = 0;
    int i4 = 1;
    if (i() == 1)
    {
      i1 = 1;
      while (i1 <= paramInteger1.intValue())
      {
        this.s.add(i1 + "室");
        i1 += 1;
      }
    }
    int i1 = 2;
    while (i1 <= paramInteger1.intValue())
    {
      this.s.add(i1 + "室");
      i1 += 1;
    }
    if (i() == 1)
    {
      i2 = 1;
      for (;;)
      {
        i1 = i4;
        if (i2 > paramInteger2.intValue()) {
          break;
        }
        this.t.add(i2 + "厅");
        i2 += 1;
      }
    }
    int i2 = 0;
    for (;;)
    {
      i1 = i4;
      if (i2 > paramInteger2.intValue()) {
        break;
      }
      this.t.add(i2 + "厅");
      i2 += 1;
    }
    while (i1 <= paramInteger3.intValue())
    {
      this.u.add(i1 + "卫");
      i1 += 1;
    }
    i1 = 0;
    for (;;)
    {
      i2 = i3;
      if (i1 > paramInteger4.intValue()) {
        break;
      }
      this.v.add(i1 + "厨");
      i1 += 1;
    }
    while (i2 <= paramInteger5.intValue())
    {
      this.w.add(i2 + "阳台");
      i2 += 1;
    }
  }
  
  private void d()
  {
    this.c.setOnClickListener(this);
    this.e.setOnClickListener(this);
    this.g.setOnClickListener(this);
    this.i.setOnClickListener(this);
    this.m.setOnClickListener(this);
    this.J.setOnScrollChangedCallback(new ObservableScrollView.a()
    {
      public void onScroll(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        float f = paramAnonymousInt2 / 100.0F;
        LLReleaseRoomSecondStepTwoFragment.a(LLReleaseRoomSecondStepTwoFragment.this).setAlpha(f);
      }
    });
  }
  
  private void d(String paramString)
  {
    if (paramString.equals("is_with_landlord_live")) {
      if (this.I != null) {
        this.I.show();
      }
    }
    while (!paramString.equals("house_type")) {
      return;
    }
    if (this.N != null)
    {
      this.N.show();
      return;
    }
    this.N = new com.ziroom.ziroomcustomer.minsu.landlordrelease.view.b(this.b, "multi_chose", Integer.valueOf(this.D), Integer.valueOf(this.E), Integer.valueOf(this.F), Integer.valueOf(this.G), Integer.valueOf(this.H), new a(null), this.s, this.t, this.u, this.v, this.w);
    this.N.setCanceledOnTouchOutside(true);
    paramString = this.N.getWindow();
    paramString.getDecorView().setPadding(0, 0, 0, 0);
    WindowManager.LayoutParams localLayoutParams = paramString.getAttributes();
    localLayoutParams.width = -1;
    localLayoutParams.height = -2;
    paramString.setAttributes(localLayoutParams);
    paramString.setGravity(80);
    this.N.show();
    this.N.getTv_choose().setText("");
  }
  
  private void e()
  {
    d();
    n();
  }
  
  private void m()
  {
    this.k = new c(this);
    this.a.register(this.k);
    this.l = com.ziroom.ziroomcustomer.minsu.landlordrelease.a.b.getInstance(this.a);
  }
  
  private void n()
  {
    this.l.getLandlordReleaseRoomBasicInfo(this, this.b, k(), j(), Integer.valueOf(h()), Integer.valueOf(i()));
  }
  
  public static LLReleaseRoomSecondStepTwoFragment newInstance()
  {
    Bundle localBundle = new Bundle();
    LLReleaseRoomSecondStepTwoFragment localLLReleaseRoomSecondStepTwoFragment = new LLReleaseRoomSecondStepTwoFragment();
    localLLReleaseRoomSecondStepTwoFragment.setArguments(localBundle);
    return localLLReleaseRoomSecondStepTwoFragment;
  }
  
  private void o()
  {
    Object localObject = com.alibaba.fastjson.a.parseArray(aa.getString(this.b, "roomFacilityGroup", ""), RoomFacilityGroupBean.class);
    if (this.r != null)
    {
      if (this.r.size() != ((List)localObject).size()) {
        this.K = false;
      }
    }
    else
    {
      localObject = aa.getString(this.b, "withLandlordText", "");
      if (TextUtils.isEmpty(this.h.getText().toString())) {
        break label373;
      }
      if (!this.h.getText().toString().equals(localObject)) {
        break label365;
      }
      this.L = false;
      label106:
      localObject = aa.getString(this.b, "roomType", "");
      if (TextUtils.isEmpty(this.j.getText().toString())) {
        break label389;
      }
      if (!this.j.getText().toString().equals(localObject)) {
        break label381;
      }
      this.M = false;
    }
    for (;;)
    {
      if ((!this.K) && (!this.L) && (!this.M)) {
        break label397;
      }
      d.newBuilder(this.b).setOnConfirmClickListener(new d.b()
      {
        public void onLeftClick(View paramAnonymousView) {}
        
        public void onRightClick(View paramAnonymousView)
        {
          LLReleaseRoomSecondStepTwoFragment.e(LLReleaseRoomSecondStepTwoFragment.this);
        }
      }).setTitle(getResources().getString(2131297090)).setContent(getResources().getString(2131297089)).setButtonText("取消", "确定").show();
      return;
      int i1 = 0;
      for (;;)
      {
        if (i1 >= this.r.size()) {
          break label363;
        }
        List localList1 = ((RoomFacilityGroupBean)this.r.get(i1)).getFacilitiesList().getList();
        List localList2 = ((RoomFacilityGroupBean)((List)localObject).get(i1)).getFacilitiesList().getList();
        int i2 = 0;
        for (;;)
        {
          if (i2 < localList1.size()) {
            if (((FacilitiesChildDataBean)localList1.get(i2)).isSelect() == ((FacilitiesChildDataBean)localList2.get(i2)).isSelect())
            {
              this.K = false;
              i2 += 1;
            }
            else
            {
              this.K = true;
              break;
            }
          }
        }
        i1 += 1;
      }
      label363:
      break;
      label365:
      this.L = true;
      break label106;
      label373:
      this.L = false;
      break label106;
      label381:
      this.M = true;
      continue;
      label389:
      this.M = false;
    }
    label397:
    g();
  }
  
  private void p()
  {
    if ((!TextUtils.isEmpty(this.f.getText().toString())) && (!TextUtils.isEmpty(this.h.getText().toString())) && (!TextUtils.isEmpty(this.j.getText().toString())))
    {
      this.m.setEnabled(true);
      this.m.setBackgroundResource(2130839597);
      return;
    }
    this.m.setEnabled(false);
    this.m.setBackgroundResource(2130837946);
  }
  
  protected void a(com.ziroom.ziroomcustomer.flux.a.a parama)
  {
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
    label656:
    do
    {
      do
      {
        return;
        if (!parama.equals("house_room_basic")) {
          break;
        }
        i1 = 0;
        break;
        if (!parama.equals("house_room_basic_error")) {
          break;
        }
        i1 = 1;
        break;
        if (!parama.equals("save_house_room_basic")) {
          break;
        }
        i1 = 2;
        break;
        if (!parama.equals("save_house_room_basic_error")) {
          break;
        }
        i1 = 3;
        break;
        this.n = this.k.getmLLReleaseRoomBasicBean();
      } while ((this.n == null) || (this.n.getData() == null));
      parama = this.n.getData();
      this.o = parama.getHouseFacility();
      if (this.o != null) {
        this.C = this.o.getValue();
      }
      this.p = parama.getIsTogetherLandlordList();
      this.q = parama.getHouseModel();
      this.r = parama.getHouseFacilityGroup();
      Object localObject1 = com.alibaba.fastjson.a.toJSONString(this.r);
      aa.putString(this.b, "roomFacilityGroup", (String)localObject1);
      localObject1 = new StringBuffer();
      Object localObject2;
      if ((this.r != null) && (!this.r.isEmpty()))
      {
        i1 = 0;
        while (i1 < this.r.size())
        {
          localObject2 = ((RoomFacilityGroupBean)this.r.get(i1)).getFacilitiesList().getList();
          if (localObject2 != null)
          {
            i2 = 0;
            while (i2 < ((List)localObject2).size())
            {
              if (((FacilitiesChildDataBean)((List)localObject2).get(i2)).isSelect())
              {
                String str = ((FacilitiesChildDataBean)((List)localObject2).get(i2)).getText();
                ((StringBuffer)localObject1).append(str + "、");
              }
              i2 += 1;
            }
          }
          i1 += 1;
        }
        if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (((StringBuffer)localObject1).length() >= 1)) {
          ((StringBuffer)localObject1).deleteCharAt(((StringBuffer)localObject1).length() - 1);
        }
        if (!TextUtils.isEmpty((CharSequence)localObject1)) {
          break label656;
        }
        this.f.setHint("请选择客人可以使用的便利设施");
      }
      while (this.p != null)
      {
        this.A = this.p.getList();
        if ((this.A != null) && (!this.A.isEmpty()))
        {
          i1 = 0;
          for (;;)
          {
            if (i1 < this.A.size())
            {
              if (((LLReleaseRoomBasicBean.LLReleaseRoomBasicDataBean.WithLandlordBean.WithLandlordDataBean)this.A.get(i1)).isSelect())
              {
                localObject1 = ((LLReleaseRoomBasicBean.LLReleaseRoomBasicDataBean.WithLandlordBean.WithLandlordDataBean)this.A.get(i1)).getText();
                if (!TextUtils.isEmpty((CharSequence)localObject1))
                {
                  this.h.setText((CharSequence)localObject1);
                  aa.putString(this.b, "withLandlordText", (String)localObject1);
                  this.h.setTextColor(Color.parseColor("#444444"));
                }
                this.B = ((LLReleaseRoomBasicBean.LLReleaseRoomBasicDataBean.WithLandlordBean.WithLandlordDataBean)this.A.get(i1)).getValue();
              }
              localObject1 = new SingleChoseBean();
              ((SingleChoseBean)localObject1).setText(((LLReleaseRoomBasicBean.LLReleaseRoomBasicDataBean.WithLandlordBean.WithLandlordDataBean)this.A.get(i1)).getText());
              this.x.add(localObject1);
              i1 += 1;
              continue;
              this.f.setText((CharSequence)localObject1);
              this.f.setTextColor(Color.parseColor("#444444"));
              break;
            }
          }
          localObject1 = new ArrayList();
          localObject2 = this.x.iterator();
          while (((Iterator)localObject2).hasNext()) {
            ((List)localObject1).add(((SingleChoseBean)((Iterator)localObject2).next()).getText());
          }
          this.I = new com.ziroom.ziroomcustomer.ziroomstation.dialog.a(this.b, "", new a.b()
          {
            public void callBack(HashMap<Integer, String> paramAnonymousHashMap)
            {
              LLReleaseRoomSecondStepTwoFragment.b(LLReleaseRoomSecondStepTwoFragment.this).setText((CharSequence)paramAnonymousHashMap.get(Integer.valueOf(0)));
              LLReleaseRoomSecondStepTwoFragment.b(LLReleaseRoomSecondStepTwoFragment.this).setTextColor(Color.parseColor("#444444"));
              Iterator localIterator = LLReleaseRoomSecondStepTwoFragment.c(LLReleaseRoomSecondStepTwoFragment.this).iterator();
              while (localIterator.hasNext())
              {
                LLReleaseRoomBasicBean.LLReleaseRoomBasicDataBean.WithLandlordBean.WithLandlordDataBean localWithLandlordDataBean = (LLReleaseRoomBasicBean.LLReleaseRoomBasicDataBean.WithLandlordBean.WithLandlordDataBean)localIterator.next();
                if (localWithLandlordDataBean.getText().equals(paramAnonymousHashMap.get(Integer.valueOf(0)))) {
                  LLReleaseRoomSecondStepTwoFragment.a(LLReleaseRoomSecondStepTwoFragment.this, localWithLandlordDataBean.getValue());
                }
              }
              LLReleaseRoomSecondStepTwoFragment.d(LLReleaseRoomSecondStepTwoFragment.this);
            }
          }, new List[] { localObject1 });
        }
      }
      this.D = parama.getRoomNum();
      this.E = parama.getParlorNum();
      this.F = parama.getToiletNum();
      this.G = parama.getKitchenNum();
      this.H = parama.getBalconyNum();
      i1 = parama.getMaxRoom();
      int i2 = parama.getMaxParlor();
      int i3 = parama.getMaxToilet();
      int i4 = parama.getMaxKitchen();
      int i5 = parama.getMaxBalcony();
      if (this.D == 0)
      {
        this.j.setHint("请选择整套房子的户型");
        this.j.setHintTextColor(Color.parseColor("#999999"));
      }
      for (;;)
      {
        a(Integer.valueOf(i1), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5));
        p();
        return;
        parama = this.D + "室" + this.E + "厅" + this.F + "卫" + this.G + "厨" + this.H + "阳台";
        aa.putString(this.b, "roomType", parama);
        this.j.setText(parama);
        this.j.setTextColor(Color.parseColor("#444444"));
      }
      this.J.setVisibility(8);
      this.m.setVisibility(8);
      this.y.setVisibility(8);
      showToast(this.k.getRoomPriceBasicErrorMsg());
      return;
      parama = this.k.getmSaveLLReleaseRoomBasicBean();
    } while (parama == null);
    if (parama.getStatus() == 0)
    {
      if (parama.getData() != null)
      {
        setRoomFid(parama.getData().getRoomFid());
        a(parama.getData().getRoomType());
      }
      f();
      return;
    }
    showToast(parama.getMessage());
    return;
    showToast(this.k.getSaveLLReleaseRoomBasicErrorMsg());
  }
  
  protected View c()
  {
    View localView = LayoutInflater.from(this.b).inflate(2130903962, null);
    this.c = ((ImageView)localView.findViewById(2131689492));
    this.d = localView.findViewById(2131689863);
    this.J = ((ObservableScrollView)localView.findViewById(2131689506));
    this.e = ((RelativeLayout)localView.findViewById(2131694642));
    this.f = ((TextView)localView.findViewById(2131694210));
    this.g = ((RelativeLayout)localView.findViewById(2131694643));
    this.h = ((TextView)localView.findViewById(2131694645));
    this.i = ((RelativeLayout)localView.findViewById(2131694646));
    this.j = ((TextView)localView.findViewById(2131693029));
    this.m = ((Button)localView.findViewById(2131691053));
    this.y = ((ReleaseUsageAndTipsView)localView.findViewById(2131689893));
    return localView;
  }
  
  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    paramBundle = new IntentFilter();
    paramBundle.addAction("com.ziroom.commonlibrary.login.broadcast");
    LocalBroadcastManager.getInstance(this.b).registerReceiver(this.O, paramBundle);
    if (i() == 1)
    {
      this.h.setText("是");
      this.h.setTextColor(Color.parseColor("#444444"));
      this.y.setVisibility(8);
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt2 == this.z) && (paramInt1 == 123))
    {
      String str = paramIntent.getExtras().getString("chosenAmentiesStr");
      this.C = paramIntent.getExtras().getString("chosenAmentiesValue");
      paramIntent = (List)paramIntent.getExtras().getSerializable("groupList");
      if ((paramIntent != null) && (!paramIntent.isEmpty()))
      {
        paramInt1 = 0;
        while (paramInt1 < paramIntent.size())
        {
          List localList = ((LLReleaseRoomAmenitiesBean)paramIntent.get(paramInt1)).getChildList();
          ((RoomFacilityGroupBean)this.r.get(paramInt1)).getFacilitiesList().setList(localList);
          paramInt1 += 1;
        }
      }
      if (!TextUtils.isEmpty(str))
      {
        this.f.setText(str);
        this.f.setTextColor(Color.parseColor("#444444"));
      }
      p();
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
      return;
    case 2131689492: 
      o();
      return;
    case 2131694642: 
      paramView = new Intent(this.b, RoomAmenitiesActivity.class);
      Bundle localBundle = new Bundle();
      localBundle.putSerializable("amenitiesData", (Serializable)this.r);
      paramView.putExtras(localBundle);
      startActivityForResult(paramView, 123);
      return;
    case 2131694643: 
      d("is_with_landlord_live");
      return;
    case 2131694646: 
      d("house_type");
      return;
    }
    if (!ApplicationEx.c.isLoginState())
    {
      com.ziroom.commonlibrary.login.a.startLoginActivity(this.b);
      af.showToast(this.b, "请先登录");
      return;
    }
    if (TextUtils.isEmpty(this.C))
    {
      showToast("请选择客人可以使用的便利设施");
      return;
    }
    this.l.saveLandlordReleaseRoomBasicInfo(this, this.b, k(), j(), Integer.valueOf(h()), Integer.valueOf(i()), this.B, this.C, this.D, this.E, this.F, this.G, this.H);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.b = ((MinsuReleaseActivity)getActivity());
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    m();
    return c();
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    LocalBroadcastManager.getInstance(this.b).unregisterReceiver(this.O);
  }
  
  public void onDestroyView()
  {
    this.a.unregister(this.k);
    super.onDestroyView();
  }
  
  public void onLoginBack(boolean paramBoolean1, boolean paramBoolean2) {}
  
  public void onResume()
  {
    super.onResume();
    p();
  }
  
  public void onStart()
  {
    super.onStart();
    this.y.setCode("TIP_WRITE_ROOM_MSG");
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    e();
  }
  
  private class a
    implements b.a
  {
    private a() {}
    
    public void getChoseHouseType(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
    {
      LLReleaseRoomSecondStepTwoFragment.f(LLReleaseRoomSecondStepTwoFragment.this).setText(paramString1 + paramString2 + paramString3 + paramString4 + paramString5);
      LLReleaseRoomSecondStepTwoFragment.f(LLReleaseRoomSecondStepTwoFragment.this).setTextColor(Color.parseColor("#444444"));
      if (!TextUtils.isEmpty(paramString1))
      {
        paramString1 = paramString1.split("室");
        LLReleaseRoomSecondStepTwoFragment.b(LLReleaseRoomSecondStepTwoFragment.this, Integer.valueOf(paramString1[0]).intValue());
      }
      if (!TextUtils.isEmpty(paramString2))
      {
        paramString1 = paramString2.split("厅");
        LLReleaseRoomSecondStepTwoFragment.c(LLReleaseRoomSecondStepTwoFragment.this, Integer.valueOf(paramString1[0]).intValue());
      }
      if (!TextUtils.isEmpty(paramString3))
      {
        paramString1 = paramString3.split("卫");
        LLReleaseRoomSecondStepTwoFragment.d(LLReleaseRoomSecondStepTwoFragment.this, Integer.valueOf(paramString1[0]).intValue());
      }
      if (!TextUtils.isEmpty(paramString4))
      {
        paramString1 = paramString4.split("厨");
        LLReleaseRoomSecondStepTwoFragment.e(LLReleaseRoomSecondStepTwoFragment.this, Integer.valueOf(paramString1[0]).intValue());
      }
      if (!TextUtils.isEmpty(paramString5))
      {
        paramString1 = paramString5.split("阳台");
        LLReleaseRoomSecondStepTwoFragment.f(LLReleaseRoomSecondStepTwoFragment.this, Integer.valueOf(paramString1[0]).intValue());
      }
      LLReleaseRoomSecondStepTwoFragment.d(LLReleaseRoomSecondStepTwoFragment.this);
    }
    
    public void showBalconySelect(String paramString, int paramInt) {}
    
    public void showKitchenSelect(String paramString, int paramInt) {}
    
    public void showShiSelect(String paramString, int paramInt) {}
    
    public void showTingSelect(String paramString, int paramInt) {}
    
    public void showToiletSelect(String paramString, int paramInt) {}
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/landlordrelease/LLReleaseRoomSecondStepTwoFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */