package com.ziroom.ziroomcustomer.minsu.landlordrelease;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.alibaba.fastjson.e;
import com.freelxl.baselibrary.f.g;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.commonlibrary.widget.unifiedziroom.d;
import com.ziroom.commonlibrary.widget.unifiedziroom.d.a;
import com.ziroom.commonlibrary.widget.unifiedziroom.d.b;
import com.ziroom.ziroomcustomer.flux.view.BaseFluxFragment;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuBaseJson;
import com.ziroom.ziroomcustomer.minsu.f.ad;
import com.ziroom.ziroomcustomer.minsu.landlordrelease.model.LLRManagerStep2RoomBean;
import com.ziroom.ziroomcustomer.minsu.landlordrelease.model.LLRManagerStep2RoomBean.DataBean;
import com.ziroom.ziroomcustomer.minsu.landlordrelease.model.LLRManagerStep2RoomBean.DataBean.HouseAroundDescBean;
import com.ziroom.ziroomcustomer.minsu.landlordrelease.model.LLRManagerStep2RoomBean.DataBean.HouseDescBean;
import com.ziroom.ziroomcustomer.minsu.landlordrelease.model.LLRManagerStep2RoomBean.DataBean.HouseFacilityBean;
import com.ziroom.ziroomcustomer.minsu.landlordrelease.model.LLRManagerStep2RoomBean.DataBean.IsTogetherLandlordBean;
import com.ziroom.ziroomcustomer.minsu.landlordrelease.model.LLRManagerStep2RoomBean.DataBean.RentRoomNumBean;
import com.ziroom.ziroomcustomer.minsu.landlordrelease.model.LLRManagerStep2RoomBean.DataBean.RoomNameBean;
import com.ziroom.ziroomcustomer.minsu.landlordrelease.model.SingleChoseBean;
import com.ziroom.ziroomcustomer.minsu.landlordrelease.model.housedesec.HouseDeasCommonDataBean;
import com.ziroom.ziroomcustomer.minsu.landlordrelease.model.housedesec.HouseDescBaseData;
import com.ziroom.ziroomcustomer.minsu.landlordrelease.model.housedesec.LandlordReleaseHouseDescBean;
import com.ziroom.ziroomcustomer.minsu.landlordrelease.model.roombasic.FacilitiesChildDataBean;
import com.ziroom.ziroomcustomer.minsu.landlordrelease.model.roombasic.LLReleaseRoomBasicBean;
import com.ziroom.ziroomcustomer.minsu.landlordrelease.model.roombasic.LLReleaseRoomBasicBean.LLReleaseRoomBasicDataBean;
import com.ziroom.ziroomcustomer.minsu.landlordrelease.model.roombasic.LLReleaseRoomBasicBean.LLReleaseRoomBasicDataBean.HouseFacilityBean;
import com.ziroom.ziroomcustomer.minsu.landlordrelease.model.roombasic.LLReleaseRoomBasicBean.LLReleaseRoomBasicDataBean.HouseRoomTypeBean;
import com.ziroom.ziroomcustomer.minsu.landlordrelease.model.roombasic.LLReleaseRoomBasicBean.LLReleaseRoomBasicDataBean.WithLandlordBean;
import com.ziroom.ziroomcustomer.minsu.landlordrelease.model.roombasic.LLReleaseRoomBasicBean.LLReleaseRoomBasicDataBean.WithLandlordBean.WithLandlordDataBean;
import com.ziroom.ziroomcustomer.minsu.landlordrelease.model.roombasic.RoomFacilityGroupBean;
import com.ziroom.ziroomcustomer.minsu.landlordrelease.model.roombasic.RoomFacilityGroupBean.FacilitiesBean;
import com.ziroom.ziroomcustomer.minsu.landlordrelease.view.CommonSaveDescInfoActivity;
import com.ziroom.ziroomcustomer.minsu.landlordrelease.view.ReleaseUsageAndTipsView;
import com.ziroom.ziroomcustomer.minsu.landlordrelease.view.b.a;
import com.ziroom.ziroomcustomer.minsu.landlordrelease.view.c.a;
import com.ziroom.ziroomcustomer.minsu.view.CommonTitle;
import com.ziroom.ziroomcustomer.widget.ObservableScrollView;
import com.ziroom.ziroomcustomer.widget.ObservableScrollView.a;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LLRManagerStepSecondRoomFragment
  extends BaseFluxFragment
  implements View.OnClickListener, com.ziroom.ziroomcustomer.minsu.landlordrelease.base.a
{
  private RelativeLayout A;
  private TextView B;
  private RelativeLayout C;
  private TextView D;
  private RelativeLayout E;
  private TextView F;
  private TextView G;
  private LLReleaseRoomBasicBean H;
  private LLReleaseRoomBasicBean.LLReleaseRoomBasicDataBean.HouseFacilityBean I;
  private LLReleaseRoomBasicBean.LLReleaseRoomBasicDataBean.WithLandlordBean J;
  private LLReleaseRoomBasicBean.LLReleaseRoomBasicDataBean.HouseRoomTypeBean K;
  private List<RoomFacilityGroupBean> L;
  private ArrayList<String> M = new ArrayList();
  private ArrayList<String> N = new ArrayList();
  private ArrayList<String> O = new ArrayList();
  private ArrayList<String> P = new ArrayList();
  private ArrayList<String> Q = new ArrayList();
  private List<SingleChoseBean> R = new ArrayList();
  private int S;
  private int T;
  private int U;
  private int V;
  private int W;
  private int X = 777;
  private List<LLReleaseRoomBasicBean.LLReleaseRoomBasicDataBean.WithLandlordBean.WithLandlordDataBean> Y;
  private int Z;
  private String aa;
  private int ab;
  private int ac;
  private int ad;
  private int ae;
  private int af;
  private int ag = 0;
  private RelativeLayout ah;
  private TextView ai;
  private TextView aj;
  private TextView ak;
  private ArrayList<SingleChoseBean> al = new ArrayList();
  private LLRManagerStep2RoomBean am;
  private boolean an;
  private com.ziroom.ziroomcustomer.minsu.landlordrelease.view.c ao;
  private com.ziroom.ziroomcustomer.minsu.landlordrelease.view.b ap;
  private Map<String, Boolean> aq = new HashMap();
  private com.ziroom.ziroomcustomer.minsu.landlordrelease.d.c ar;
  private com.ziroom.ziroomcustomer.minsu.landlordrelease.a.b as;
  private String b;
  private String c;
  private int d;
  private CommonTitle e;
  private ObservableScrollView f;
  private ReleaseUsageAndTipsView g;
  private View h;
  private RelativeLayout i;
  private RelativeLayout j;
  private TextView k;
  private RelativeLayout l;
  private TextView m;
  private TextView n;
  private TextView o;
  private TextView p;
  private String q;
  private LandlordReleaseHouseDescBean r;
  private HouseDeasCommonDataBean s;
  private HouseDeasCommonDataBean t;
  private HouseDeasCommonDataBean u;
  private String v;
  private String w;
  private String x = "";
  private boolean y = false;
  private boolean z = false;
  
  private void a(Integer paramInteger1, Integer paramInteger2, Integer paramInteger3, Integer paramInteger4, Integer paramInteger5)
  {
    int i3 = 0;
    int i4 = 1;
    if (this.ag == 1)
    {
      i1 = 1;
      while (i1 <= paramInteger1.intValue())
      {
        this.M.add(i1 + "室");
        i1 += 1;
      }
    }
    int i1 = 2;
    while (i1 <= paramInteger1.intValue())
    {
      this.M.add(i1 + "室");
      i1 += 1;
    }
    if (this.ag == 1)
    {
      i2 = 1;
      for (;;)
      {
        i1 = i4;
        if (i2 > paramInteger2.intValue()) {
          break;
        }
        this.N.add(i2 + "厅");
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
      this.N.add(i2 + "厅");
      i2 += 1;
    }
    while (i1 <= paramInteger3.intValue())
    {
      this.O.add(i1 + "卫");
      i1 += 1;
    }
    i1 = 0;
    for (;;)
    {
      i2 = i3;
      if (i1 > paramInteger4.intValue()) {
        break;
      }
      this.P.add(i1 + "厨");
      i1 += 1;
    }
    while (i2 <= paramInteger5.intValue())
    {
      this.Q.add(i2 + "阳台");
      i2 += 1;
    }
  }
  
  private void b(String paramString)
  {
    if (paramString.equals("is_with_landlord_live")) {
      if (this.ao != null) {
        this.ao.show();
      }
    }
    while (!paramString.equals("house_type"))
    {
      return;
      this.ao = new com.ziroom.ziroomcustomer.minsu.landlordrelease.view.c(getActivity(), "iswith_landlord_chose", new a(null), this.R);
      this.ao.setCanceledOnTouchOutside(true);
      paramString = this.ao.getWindow();
      paramString.getDecorView().setPadding(0, 0, 0, 0);
      localLayoutParams = paramString.getAttributes();
      localLayoutParams.width = -1;
      localLayoutParams.height = -2;
      paramString.setAttributes(localLayoutParams);
      paramString.setGravity(80);
      this.ao.show();
      this.ao.getTv_choose().setText("");
      return;
    }
    if (this.ap != null)
    {
      this.ap.show();
      return;
    }
    this.ap = new com.ziroom.ziroomcustomer.minsu.landlordrelease.view.b(getActivity(), "multi_chose", new b(null), this.M, this.N, this.O, this.P, this.Q);
    this.ap.setCanceledOnTouchOutside(true);
    paramString = this.ap.getWindow();
    paramString.getDecorView().setPadding(0, 0, 0, 0);
    WindowManager.LayoutParams localLayoutParams = paramString.getAttributes();
    localLayoutParams.width = -1;
    localLayoutParams.height = -2;
    paramString.setAttributes(localLayoutParams);
    paramString.setGravity(80);
    this.ap.show();
    this.ap.getTv_choose().setText("");
  }
  
  private void c()
  {
    e();
    d();
    i();
  }
  
  private void d()
  {
    this.j.setOnClickListener(this);
    this.l.setOnClickListener(this);
    this.A.setOnClickListener(this);
    this.C.setOnClickListener(this);
    this.E.setOnClickListener(this);
    this.ah.setOnClickListener(this);
    this.aj.setOnClickListener(this);
    this.ak.setOnClickListener(this);
    this.f.setOnScrollChangedCallback(new ObservableScrollView.a()
    {
      public void onScroll(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        float f = paramAnonymousInt2 / 100.0F;
        LLRManagerStepSecondRoomFragment.a(LLRManagerStepSecondRoomFragment.this).setBottomLineAlpha(f);
      }
    });
  }
  
  private void e()
  {
    f();
    View localView = getView();
    this.f = ((ObservableScrollView)localView.findViewById(2131690150));
    this.g = ((ReleaseUsageAndTipsView)localView.findViewById(2131689893));
    this.g.setCode("TIP_HOW_WRITE_MANAGE_ROOM_MSG");
    this.h = localView.findViewById(2131694658);
    this.i = ((RelativeLayout)localView.findViewById(2131694192));
    this.j = ((RelativeLayout)localView.findViewById(2131694194));
    this.k = ((TextView)localView.findViewById(2131694660));
    this.l = ((RelativeLayout)localView.findViewById(2131694197));
    this.m = ((TextView)localView.findViewById(2131694663));
    localView.findViewById(2131694664).setVisibility(8);
    this.n = ((TextView)localView.findViewById(2131694657));
    this.o = ((TextView)localView.findViewById(2131694659));
    this.p = ((TextView)localView.findViewById(2131694662));
    if (this.d == 0) {}
    for (;;)
    {
      this.A = ((RelativeLayout)localView.findViewById(2131694642));
      this.B = ((TextView)localView.findViewById(2131694210));
      this.C = ((RelativeLayout)localView.findViewById(2131694643));
      this.D = ((TextView)localView.findViewById(2131694645));
      this.E = ((RelativeLayout)localView.findViewById(2131694646));
      this.F = ((TextView)localView.findViewById(2131693029));
      this.ah = ((RelativeLayout)localView.findViewById(2131694202));
      this.ai = ((TextView)localView.findViewById(2131694204));
      this.aj = ((TextView)localView.findViewById(2131694290));
      this.ak = ((TextView)localView.findViewById(2131691496));
      localView.findViewById(2131694289).setOnClickListener(this);
      this.G = ((TextView)localView.findViewById(2131694288));
      return;
      if (this.d == 1)
      {
        this.i.setVisibility(8);
        this.h.setVisibility(8);
      }
    }
  }
  
  private void f()
  {
    this.e = ((CommonTitle)getView().findViewById(2131691272));
    this.e.setLeftButtonType(0);
    this.e.setOnLeftButtonClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        LLRManagerStepSecondRoomFragment.b(LLRManagerStepSecondRoomFragment.this);
      }
    });
    this.e.showRightText(true, getString(2131297412));
    this.e.setBottomLineAlpha(0.0F);
    this.e.setOnRightButtonClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        LLRManagerStepSecondRoomFragment.c(LLRManagerStepSecondRoomFragment.this);
      }
    });
  }
  
  private void g()
  {
    if (this.aq.containsValue(Boolean.valueOf(true)))
    {
      d.newBuilder(getActivity()).setOnConfirmClickListener(new d.b()
      {
        public void onLeftClick(View paramAnonymousView) {}
        
        public void onRightClick(View paramAnonymousView)
        {
          LLRManagerStepSecondRoomFragment.this.getActivity().finish();
        }
      }).setTitle(getResources().getString(2131297090)).setContent(getResources().getString(2131297089)).setButtonText("取消", "确定").show();
      return;
    }
    getActivity().finish();
  }
  
  public static LLRManagerStepSecondRoomFragment getInstance(Bundle paramBundle)
  {
    LLRManagerStepSecondRoomFragment localLLRManagerStepSecondRoomFragment = new LLRManagerStepSecondRoomFragment();
    localLLRManagerStepSecondRoomFragment.setArguments(paramBundle);
    return localLLRManagerStepSecondRoomFragment;
  }
  
  private void h()
  {
    this.ar = new com.ziroom.ziroomcustomer.minsu.landlordrelease.d.c(this);
    this.a.register(this.ar);
    this.as = com.ziroom.ziroomcustomer.minsu.landlordrelease.a.b.getInstance(this.a);
  }
  
  private void i()
  {
    this.as.initDescAndBaseInfoSublet(this, getActivity(), this.b, this.c);
  }
  
  private void j()
  {
    String str1;
    String str2;
    if ((this.r != null) && (this.r.getData() != null))
    {
      this.s = this.r.getData().getHouseName();
      this.t = this.r.getData().getHouseDesc();
      this.u = this.r.getData().getHouseAroundDesc();
      if (this.t != null)
      {
        str1 = this.t.getValue();
        str2 = this.t.getText();
        this.v = this.t.getExplain();
        if (TextUtils.isEmpty(str1)) {
          break label184;
        }
        this.k.setText(str1);
        this.k.setTextColor(Color.parseColor("#444444"));
      }
    }
    for (;;)
    {
      if (this.u != null)
      {
        str1 = this.u.getValue();
        str2 = this.u.getText();
        this.w = this.u.getExplain();
        if (TextUtils.isEmpty(str1)) {
          break;
        }
        this.m.setText(str1);
        this.m.setTextColor(Color.parseColor("#444444"));
      }
      return;
      label184:
      if (!TextUtils.isEmpty(str2))
      {
        this.k.setHint(str2);
        this.k.setTextColor(Color.parseColor("#999999"));
      }
    }
    this.m.setHint(str2);
    this.m.setTextColor(Color.parseColor("#999999"));
  }
  
  private void k()
  {
    if (this.ag == 1) {}
    for (Intent localIntent = new Intent(getActivity(), AloneRoomInfoActivitySR.class);; localIntent = new Intent(getActivity(), AloneRoomInfoActivity.class))
    {
      localIntent.putExtra("position", 0);
      localIntent.putExtra("houseBaseFid", this.b);
      localIntent.putExtra("roomFid", this.c);
      localIntent.putExtra("rentWay", this.d);
      localIntent.putExtra("rentRoomNum", this.am.data.roomNum);
      startActivityForResult(localIntent, 123);
      return;
    }
  }
  
  private void l()
  {
    String str1 = this.k.getText().toString();
    if (TextUtils.isEmpty(str1))
    {
      g.textToast(getActivity(), "请输入房源描述");
      return;
    }
    String str2 = this.m.getText().toString();
    if (TextUtils.isEmpty(str2))
    {
      g.textToast(getActivity(), "请输入周边情况");
      return;
    }
    if (TextUtils.isEmpty(this.aa))
    {
      showToast("请选择客人可以使用的便利设施");
      return;
    }
    this.as.saveDescAndBaseInfoSublet(this, getActivity(), this.b, this.c, this.d, str1, str2, Integer.valueOf(this.Z), this.aa, Integer.valueOf(this.ab), Integer.valueOf(this.ac), Integer.valueOf(this.ad), Integer.valueOf(this.ae), Integer.valueOf(this.af));
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
    label651:
    label671:
    label910:
    do
    {
      do
      {
        return;
        if (!parama.equals("ll_r_manager_step_2_room")) {
          break;
        }
        i1 = 0;
        break;
        if (!parama.equals("hous_desc_error")) {
          break;
        }
        i1 = 1;
        break;
        if (!parama.equals("ll_r_manager_step_2_room_save")) {
          break;
        }
        i1 = 2;
        break;
        if (!parama.equals("ll_r_manager_step_2_room_save_error")) {
          break;
        }
        i1 = 3;
        break;
        this.q = this.ar.getLlrManagerStep2RoomBean();
        this.am = ((LLRManagerStep2RoomBean)e.parseObject(this.q, LLRManagerStep2RoomBean.class));
        parama = e.parseObject(this.q);
        if ((parama == null) || (parama.get("data") == null))
        {
          if (this.q == null) {}
          for (parama = "";; parama = parama.get("message") + "")
          {
            ad.shouErrorMessage(parama);
            return;
          }
        }
        this.r = ((LandlordReleaseHouseDescBean)e.parseObject(this.q, LandlordReleaseHouseDescBean.class));
        j();
        if ((this.am != null) && (this.am.data != null))
        {
          this.ag = this.am.data.roomType;
          if (this.ag != 1) {
            break label651;
          }
          this.G.setText("客厅信息");
          this.ah.setVisibility(8);
          if (this.am.data.houseDesc != null) {
            this.o.setText(this.am.data.houseDesc.auditMsg);
          }
          if (this.am.data.houseAroundDesc != null) {
            this.p.setText(this.am.data.houseAroundDesc.auditMsg);
          }
        }
        this.H = ((LLReleaseRoomBasicBean)e.parseObject(this.q, LLReleaseRoomBasicBean.class));
        if ((this.H != null) && (this.H.getData() != null))
        {
          parama = this.H.getData();
          this.I = parama.getHouseFacility();
          this.J = parama.getIsTogetherLandlordList();
          this.K = parama.getHouseModel();
          this.L = parama.getHouseFacilityGroup();
          Object localObject = new StringBuffer();
          StringBuffer localStringBuffer = new StringBuffer();
          if ((this.L != null) && (!this.L.isEmpty()))
          {
            i1 = 0;
            for (;;)
            {
              if (i1 >= this.L.size()) {
                break label671;
              }
              List localList = ((RoomFacilityGroupBean)this.L.get(i1)).getFacilitiesList().getList();
              if (localList != null)
              {
                i2 = 0;
                for (;;)
                {
                  if (i2 < localList.size())
                  {
                    if (((FacilitiesChildDataBean)localList.get(i2)).isSelect())
                    {
                      String str = ((FacilitiesChildDataBean)localList.get(i2)).getText();
                      ((StringBuffer)localObject).append(str + "、");
                      localStringBuffer.append(((FacilitiesChildDataBean)localList.get(i2)).getValue() + ",");
                    }
                    i2 += 1;
                    continue;
                    this.G.setText("房间信息");
                    break;
                  }
                }
              }
              i1 += 1;
            }
            if ((!TextUtils.isEmpty((CharSequence)localObject)) && (((StringBuffer)localObject).length() >= 1)) {
              ((StringBuffer)localObject).deleteCharAt(((StringBuffer)localObject).length() - 1);
            }
            if ((!TextUtils.isEmpty(localStringBuffer)) && (localStringBuffer.length() >= 1)) {
              this.aa = localStringBuffer.toString();
            }
            if (!TextUtils.isEmpty((CharSequence)localObject)) {
              break label910;
            }
          }
          while (this.J != null)
          {
            this.Y = this.J.getList();
            if ((this.Y == null) || (this.Y.isEmpty())) {
              break;
            }
            i1 = 0;
            while (i1 < this.Y.size())
            {
              if (((LLReleaseRoomBasicBean.LLReleaseRoomBasicDataBean.WithLandlordBean.WithLandlordDataBean)this.Y.get(i1)).isSelect())
              {
                localObject = ((LLReleaseRoomBasicBean.LLReleaseRoomBasicDataBean.WithLandlordBean.WithLandlordDataBean)this.Y.get(i1)).getText();
                if (!TextUtils.isEmpty((CharSequence)localObject)) {
                  this.D.setText((CharSequence)localObject);
                }
                this.Z = ((LLReleaseRoomBasicBean.LLReleaseRoomBasicDataBean.WithLandlordBean.WithLandlordDataBean)this.Y.get(i1)).getValue();
              }
              localObject = new SingleChoseBean();
              ((SingleChoseBean)localObject).setText(((LLReleaseRoomBasicBean.LLReleaseRoomBasicDataBean.WithLandlordBean.WithLandlordDataBean)this.Y.get(i1)).getText());
              this.R.add(localObject);
              i1 += 1;
            }
            this.B.setText((CharSequence)localObject);
          }
          this.S = parama.getRoomNum();
          this.T = parama.getParlorNum();
          this.U = parama.getToiletNum();
          this.V = parama.getKitchenNum();
          this.W = parama.getBalconyNum();
          i1 = parama.getMaxRoom();
          int i2 = parama.getMaxParlor();
          int i3 = parama.getMaxToilet();
          int i4 = parama.getMaxKitchen();
          int i5 = parama.getMaxBalcony();
          if (this.K != null)
          {
            parama = this.K.getText();
            localObject = this.K.getValue();
            if (!TextUtils.isEmpty((CharSequence)localObject))
            {
              localObject = ((String)localObject).split(",");
              if ((localObject.length >= 1) && (!TextUtils.isEmpty(localObject[0]))) {
                this.ab = Integer.parseInt(localObject[0]);
              }
              if ((localObject.length >= 2) && (!TextUtils.isEmpty(localObject[1]))) {
                this.ac = Integer.parseInt(localObject[1]);
              }
              if ((localObject.length >= 3) && (!TextUtils.isEmpty(localObject[2]))) {
                this.ad = Integer.parseInt(localObject[2]);
              }
              if ((localObject.length >= 4) && (!TextUtils.isEmpty(localObject[3]))) {
                this.ae = Integer.parseInt(localObject[3]);
              }
              if ((localObject.length >= 5) && (!TextUtils.isEmpty(localObject[4]))) {
                this.af = Integer.parseInt(localObject[4]);
              }
            }
            if (!TextUtils.isEmpty(parama)) {
              this.F.setText(parama);
            }
            a(Integer.valueOf(i1), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5));
          }
        }
      } while (this.am == null);
      parama = this.am.data;
    } while (parama == null);
    this.ai.setText(parama.rentRoomNum.value + "间");
    this.aj.setText(this.am.data.roomName.value);
    this.an = this.am.data.roomName.isEdit;
    if (this.an) {
      getView().findViewById(2131694291).setVisibility(0);
    }
    while (1 == this.am.data.roomStatus)
    {
      this.ak.setText("已完成");
      return;
      getView().findViewById(2131694291).setVisibility(8);
    }
    this.ak.setText("未完成");
    return;
    parama = this.ar.getLlrManagerStep2RoomSaveResult();
    if (parama.checkSuccess(getActivity()))
    {
      showToast("保存成功");
      getActivity().finish();
      return;
    }
    if (parama == null) {}
    for (parama = "";; parama = parama.message)
    {
      ad.shouErrorMessage(parama);
      return;
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    String str;
    if (paramInt2 == 4096)
    {
      str = paramIntent.getStringExtra("saveDesc");
      if (paramInt1 != 234) {
        break label199;
      }
      this.k.setText(str);
      this.k.setTextColor(Color.parseColor("#444444"));
      this.aq.put("desc", Boolean.valueOf(true));
    }
    for (;;)
    {
      if ((paramInt2 == this.X) && (paramInt1 == 123))
      {
        str = paramIntent.getStringExtra("chosenAmentiesStr");
        this.aa = paramIntent.getStringExtra("chosenAmentiesValue");
        if (!TextUtils.isEmpty(str))
        {
          this.B.setText(str);
          this.B.setTextColor(Color.parseColor("#444444"));
        }
        this.aq.put("amenities", Boolean.valueOf(true));
      }
      if ((paramInt2 == -1) && (paramInt1 == 123) && (paramIntent.getBooleanExtra("isAloneRoomFinish", false)))
      {
        str = paramIntent.getStringExtra("roomName");
        paramIntent.getStringExtra("roomFid");
        this.aj.setText(str);
      }
      return;
      label199:
      if (paramInt1 == 456)
      {
        this.m.setText(str);
        this.m.setTextColor(Color.parseColor("#444444"));
        this.aq.put("surround", Boolean.valueOf(true));
      }
    }
  }
  
  public boolean onBackPressed()
  {
    g();
    return false;
  }
  
  @Instrumented
  public void onClick(View paramView)
  {
    VdsAgent.onClick(this, paramView);
    switch (paramView.getId())
    {
    case 2131691053: 
    default: 
    case 2131694194: 
    case 2131694197: 
      do
      {
        do
        {
          return;
        } while (this.t == null);
        if (this.t.isEdit())
        {
          paramView = new Intent(getActivity(), CommonSaveDescInfoActivity.class);
          paramView.putExtra("titleName", "房源描述");
          paramView.putExtra("editTextHint", this.v);
          paramView.putExtra("saveDescText", this.k.getText() + "");
          paramView.putExtra("editMaxNum", 1000);
          paramView.putExtra("editMinNum", 100);
          startActivityForResult(paramView, 234);
          return;
        }
        showToast(getString(2131297167));
        return;
      } while (this.u == null);
      if (this.u.isEdit())
      {
        paramView = new Intent(getActivity(), CommonSaveDescInfoActivity.class);
        paramView.putExtra("titleName", "周边情况");
        paramView.putExtra("editTextHint", this.w);
        paramView.putExtra("saveDescText", this.m.getText() + "");
        paramView.putExtra("editMaxNum", 1000);
        paramView.putExtra("editMinNum", 100);
        startActivityForResult(paramView, 456);
        return;
      }
      showToast(getString(2131297167));
      return;
    case 2131694642: 
      if ((this.am != null) && (this.am.data != null) && (this.am.data.houseFacility != null) && (this.am.data.houseFacility.isEdit))
      {
        paramView = new Intent(getActivity(), RoomAmenitiesActivity.class);
        Bundle localBundle = new Bundle();
        localBundle.putSerializable("amenitiesData", (Serializable)this.L);
        paramView.putExtras(localBundle);
        startActivityForResult(paramView, 123);
        return;
      }
      showToast(getString(2131297167));
      return;
    case 2131694643: 
      if ((this.am != null) && (this.am.data != null) && (this.am.data.isTogetherLandlord != null) && (this.am.data.isTogetherLandlord.isEdit))
      {
        b("is_with_landlord_live");
        return;
      }
      showToast(getString(2131297167));
      return;
    case 2131694646: 
      if ((this.K != null) && (!this.K.isEdit()))
      {
        if (!TextUtils.isEmpty(this.H.getData().getImmutableMsg()))
        {
          showToast(this.H.getData().getImmutableMsg());
          return;
        }
        showToast(getString(2131297167));
        return;
      }
      b("house_type");
      return;
    case 2131694202: 
      showToast("房间数量不可修改");
      return;
    }
    if (this.an)
    {
      k();
      return;
    }
    showToast(getString(2131297167));
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    h();
    return paramLayoutInflater.inflate(2130903960, null);
  }
  
  public void onDestroyView()
  {
    this.a.unregister(this.ar);
    super.onDestroyView();
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    c();
  }
  
  public void setArguments(Bundle paramBundle)
  {
    super.setArguments(paramBundle);
    if (paramBundle != null)
    {
      this.b = paramBundle.getString("houseBaseFid");
      this.c = paramBundle.getString("roomFid");
      this.d = paramBundle.getInt("rentWay");
    }
  }
  
  private class a
    implements c.a
  {
    private a() {}
    
    public void onSingleSelect(String paramString, int paramInt)
    {
      LLRManagerStepSecondRoomFragment.d(LLRManagerStepSecondRoomFragment.this).setText(paramString);
      LLRManagerStepSecondRoomFragment.d(LLRManagerStepSecondRoomFragment.this).setTextColor(Color.parseColor("#444444"));
      LLRManagerStepSecondRoomFragment.a(LLRManagerStepSecondRoomFragment.this, ((LLReleaseRoomBasicBean.LLReleaseRoomBasicDataBean.WithLandlordBean.WithLandlordDataBean)LLRManagerStepSecondRoomFragment.e(LLRManagerStepSecondRoomFragment.this).get(paramInt)).getValue());
      LLRManagerStepSecondRoomFragment.f(LLRManagerStepSecondRoomFragment.this).put("isTogether", Boolean.valueOf(true));
    }
  }
  
  private class b
    implements b.a
  {
    private b() {}
    
    public void getChoseHouseType(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
    {
      if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)) && (!TextUtils.isEmpty(paramString3)) && (!TextUtils.isEmpty(paramString4)) && (!TextUtils.isEmpty(paramString5)))
      {
        String[] arrayOfString = paramString1.split("室");
        LLRManagerStepSecondRoomFragment.b(LLRManagerStepSecondRoomFragment.this, Integer.valueOf(arrayOfString[0]).intValue());
        LLRManagerStepSecondRoomFragment.f(LLRManagerStepSecondRoomFragment.this).put("houseType", Boolean.valueOf(true));
        arrayOfString = paramString2.split("厅");
        LLRManagerStepSecondRoomFragment.c(LLRManagerStepSecondRoomFragment.this, Integer.valueOf(arrayOfString[0]).intValue());
        LLRManagerStepSecondRoomFragment.f(LLRManagerStepSecondRoomFragment.this).put("houseType", Boolean.valueOf(true));
        arrayOfString = paramString3.split("卫");
        LLRManagerStepSecondRoomFragment.d(LLRManagerStepSecondRoomFragment.this, Integer.valueOf(arrayOfString[0]).intValue());
        LLRManagerStepSecondRoomFragment.f(LLRManagerStepSecondRoomFragment.this).put("houseType", Boolean.valueOf(true));
        arrayOfString = paramString4.split("厨");
        LLRManagerStepSecondRoomFragment.e(LLRManagerStepSecondRoomFragment.this, Integer.valueOf(arrayOfString[0]).intValue());
        LLRManagerStepSecondRoomFragment.f(LLRManagerStepSecondRoomFragment.this).put("houseType", Boolean.valueOf(true));
        arrayOfString = paramString5.split("阳台");
        LLRManagerStepSecondRoomFragment.f(LLRManagerStepSecondRoomFragment.this, Integer.valueOf(arrayOfString[0]).intValue());
        LLRManagerStepSecondRoomFragment.f(LLRManagerStepSecondRoomFragment.this).put("houseType", Boolean.valueOf(true));
        LLRManagerStepSecondRoomFragment.g(LLRManagerStepSecondRoomFragment.this).setText(paramString1 + paramString2 + paramString3 + paramString4 + paramString5);
        LLRManagerStepSecondRoomFragment.g(LLRManagerStepSecondRoomFragment.this).setTextColor(Color.parseColor("#444444"));
        LLRManagerStepSecondRoomFragment.f(LLRManagerStepSecondRoomFragment.this).put("houseType", Boolean.valueOf(true));
      }
    }
    
    public void showBalconySelect(String paramString, int paramInt) {}
    
    public void showKitchenSelect(String paramString, int paramInt) {}
    
    public void showShiSelect(String paramString, int paramInt) {}
    
    public void showTingSelect(String paramString, int paramInt) {}
    
    public void showToiletSelect(String paramString, int paramInt) {}
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/landlordrelease/LLRManagerStepSecondRoomFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */