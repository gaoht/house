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
import android.view.View.OnFocusChangeListener;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.EditText;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnGroupClickListener;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.alibaba.fastjson.e;
import com.freelxl.baselibrary.f.g;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.commonlibrary.widget.unifiedziroom.d.a;
import com.ziroom.ziroomcustomer.flux.view.BaseFluxFragment;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuBaseJson;
import com.ziroom.ziroomcustomer.minsu.f.ad;
import com.ziroom.ziroomcustomer.minsu.landlordrelease.model.HouseBedListBean;
import com.ziroom.ziroomcustomer.minsu.landlordrelease.model.SaveHouseRoomListBean;
import com.ziroom.ziroomcustomer.minsu.landlordrelease.model.SingleChoseBean;
import com.ziroom.ziroomcustomer.minsu.landlordrelease.model.housedesec.HouseDeasCommonDataBean;
import com.ziroom.ziroomcustomer.minsu.landlordrelease.model.housedesec.HouseDescBaseData;
import com.ziroom.ziroomcustomer.minsu.landlordrelease.model.housedesec.LandlordReleaseHouseDescBean;
import com.ziroom.ziroomcustomer.minsu.landlordrelease.model.houseprice.BedAllTypeListDataBean;
import com.ziroom.ziroomcustomer.minsu.landlordrelease.model.houseprice.BedTypeListBean;
import com.ziroom.ziroomcustomer.minsu.landlordrelease.model.houseprice.CheckInLimitBean;
import com.ziroom.ziroomcustomer.minsu.landlordrelease.model.houseprice.CheckInLimitBean.CheckInLimitDataBean;
import com.ziroom.ziroomcustomer.minsu.landlordrelease.model.houseprice.FacilitiesListBean;
import com.ziroom.ziroomcustomer.minsu.landlordrelease.model.houseprice.FacilitiesListDataBean;
import com.ziroom.ziroomcustomer.minsu.landlordrelease.model.houseprice.HouseFacilityGroupBean;
import com.ziroom.ziroomcustomer.minsu.landlordrelease.model.houseprice.HouseGroupListBean;
import com.ziroom.ziroomcustomer.minsu.landlordrelease.model.houseprice.LandlordReleaseHousePriceBasicBean;
import com.ziroom.ziroomcustomer.minsu.landlordrelease.model.houseprice.LandlordReleaseHousePriceBasicData;
import com.ziroom.ziroomcustomer.minsu.landlordrelease.model.houseprice.LandlordReleaseHousePriceBasicData.CleaningFeesBean;
import com.ziroom.ziroomcustomer.minsu.landlordrelease.model.houseprice.LandlordReleaseHousePriceBasicData.HouseAreaBean;
import com.ziroom.ziroomcustomer.minsu.landlordrelease.model.houseprice.LandlordReleaseHousePriceBasicData.HouseFacilityBean;
import com.ziroom.ziroomcustomer.minsu.landlordrelease.model.houseprice.LandlordReleaseHousePriceBasicData.HouseModelBean;
import com.ziroom.ziroomcustomer.minsu.landlordrelease.model.houseprice.LandlordReleaseHousePriceBasicData.HouseRoomListBean;
import com.ziroom.ziroomcustomer.minsu.landlordrelease.model.houseprice.LandlordReleaseHousePriceBasicData.HouseRoomListBean.HouseHaveBedListDataBean;
import com.ziroom.ziroomcustomer.minsu.landlordrelease.model.houseprice.LandlordReleaseHousePriceBasicData.LeasePriceBean;
import com.ziroom.ziroomcustomer.minsu.landlordrelease.model.houseprice.LandlordReleaseHousePriceBasicData.SevenDiscountRateBean;
import com.ziroom.ziroomcustomer.minsu.landlordrelease.model.houseprice.LandlordReleaseHousePriceBasicData.ThirtyDiscountRateBean;
import com.ziroom.ziroomcustomer.minsu.landlordrelease.model.houseprice.LandlordReleaseHousePriceBasicData.WeekendPriceBean;
import com.ziroom.ziroomcustomer.minsu.landlordrelease.model.houseprice.WeekendListBean;
import com.ziroom.ziroomcustomer.minsu.landlordrelease.model.houseprice.WeekendListBean.WeekendLisDataBean;
import com.ziroom.ziroomcustomer.minsu.landlordrelease.view.CommonSaveDescInfoActivity;
import com.ziroom.ziroomcustomer.minsu.landlordrelease.view.ExpandableListViewForScrollView;
import com.ziroom.ziroomcustomer.minsu.landlordrelease.view.ReleaseUsageAndTipsView;
import com.ziroom.ziroomcustomer.minsu.landlordrelease.view.b.a;
import com.ziroom.ziroomcustomer.minsu.landlordrelease.view.c.a;
import com.ziroom.ziroomcustomer.minsu.view.CommonTitle;
import com.ziroom.ziroomcustomer.widget.ObservableScrollView;
import com.ziroom.ziroomcustomer.widget.ObservableScrollView.a;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class LLRManagerStepSecondHouseFragment
  extends BaseFluxFragment
  implements View.OnClickListener, com.ziroom.ziroomcustomer.minsu.landlordrelease.base.a
{
  private TextView A;
  private RelativeLayout B;
  private TextView C;
  private RelativeLayout D;
  private TextView E;
  private RelativeLayout F;
  private TextView G;
  private TextView H;
  private TextView I;
  private TextView J;
  private ExpandableListViewForScrollView K;
  private LandlordReleaseHousePriceBasicBean L;
  private LandlordReleaseHousePriceBasicData.HouseAreaBean M;
  private LandlordReleaseHousePriceBasicData.HouseFacilityBean N;
  private CheckInLimitBean O;
  private LandlordReleaseHousePriceBasicData.HouseModelBean P;
  private LandlordReleaseHousePriceBasicData.LeasePriceBean Q;
  private LandlordReleaseHousePriceBasicData R;
  private List<HouseFacilityGroupBean> S;
  private ArrayList<String> T = new ArrayList();
  private ArrayList<String> U = new ArrayList();
  private ArrayList<String> V = new ArrayList();
  private ArrayList<String> W = new ArrayList();
  private ArrayList<String> X = new ArrayList();
  private List<CheckInLimitBean.CheckInLimitDataBean> Y;
  private List<SingleChoseBean> Z = new ArrayList();
  private Map<String, ArrayList<BedAllTypeListDataBean>> aA = new HashMap();
  private Map<String, BedAllTypeListDataBean> aB = new HashMap();
  private boolean aC = false;
  private ArrayList<BedAllTypeListDataBean> aD = new ArrayList();
  private String aE;
  private String aF;
  private int aG;
  private int aH = -2;
  private com.ziroom.ziroomcustomer.minsu.landlordrelease.view.c aI;
  private com.ziroom.ziroomcustomer.minsu.landlordrelease.view.b aJ;
  private Map<String, Boolean> aK = new HashMap();
  private com.ziroom.ziroomcustomer.minsu.landlordrelease.d.c aL;
  private com.ziroom.ziroomcustomer.minsu.landlordrelease.a.b aM;
  private CheckInLimitBean.CheckInLimitDataBean aa;
  private Integer ab;
  private Integer ac;
  private Integer ad;
  private Integer ae;
  private Integer af;
  private List<HouseGroupListBean> ag = new ArrayList();
  private com.ziroom.ziroomcustomer.minsu.landlordrelease.b.d ah;
  private int ai;
  private int aj;
  private String ak;
  private String al;
  private double am;
  private double an;
  private double ao;
  private int ap;
  private int aq;
  private List<String> ar = new ArrayList();
  private String as;
  private String at;
  private String au;
  private LandlordReleaseHousePriceBasicData.WeekendPriceBean av;
  private LandlordReleaseHousePriceBasicData.SevenDiscountRateBean aw;
  private LandlordReleaseHousePriceBasicData.ThirtyDiscountRateBean ax;
  private LandlordReleaseHousePriceBasicData.CleaningFeesBean ay;
  private List<LandlordReleaseHousePriceBasicData.HouseRoomListBean> az = new ArrayList();
  private CommonTitle b;
  private ReleaseUsageAndTipsView c;
  private ObservableScrollView d;
  private View e;
  private RelativeLayout f;
  private EditText g;
  private RelativeLayout h;
  private TextView i;
  private RelativeLayout j;
  private TextView k;
  private String l;
  private LandlordReleaseHouseDescBean m;
  private HouseDeasCommonDataBean n;
  private HouseDeasCommonDataBean o;
  private HouseDeasCommonDataBean p;
  private String q;
  private String r;
  private String s = "";
  private boolean t = false;
  private boolean u = false;
  private String v;
  private RelativeLayout w;
  private EditText x;
  private TextView y;
  private RelativeLayout z;
  
  private void a(Integer paramInteger1, Integer paramInteger2, Integer paramInteger3, Integer paramInteger4, Integer paramInteger5)
  {
    int i4 = 1;
    int i3 = 0;
    String str = this.P.getText();
    if (!TextUtils.isEmpty(str))
    {
      this.G.setText(str);
      this.G.setTextColor(Color.parseColor("#444444"));
    }
    int i1 = 1;
    while (i1 <= paramInteger1.intValue())
    {
      this.T.add(i1 + "室");
      i1 += 1;
    }
    i1 = 0;
    int i2;
    for (;;)
    {
      i2 = i4;
      if (i1 > paramInteger2.intValue()) {
        break;
      }
      this.U.add(i1 + "厅");
      i1 += 1;
    }
    while (i2 <= paramInteger3.intValue())
    {
      this.V.add(i2 + "卫");
      i2 += 1;
    }
    i1 = 0;
    for (;;)
    {
      i2 = i3;
      if (i1 > paramInteger4.intValue()) {
        break;
      }
      this.W.add(i1 + "厨");
      i1 += 1;
    }
    while (i2 <= paramInteger5.intValue())
    {
      this.X.add(i2 + "阳台");
      i2 += 1;
    }
  }
  
  private void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    this.as = (paramString1.replaceAll("室", "") + "," + paramString2.replaceAll("厅", "") + "," + paramString3.replaceAll("卫", "") + "," + paramString4.replaceAll("厨", "") + "," + paramString5.replaceAll("阳台", ""));
    this.G.setText(paramString1 + paramString2 + paramString3 + paramString4 + paramString5);
    this.G.setTextColor(Color.parseColor("#444444"));
    int i3 = Integer.valueOf(paramString1.split("室")[0]).intValue();
    int i2 = this.ag.size();
    int i1 = i2;
    if (i2 != 0)
    {
      if (i3 > i2) {
        i1 = i2;
      }
    }
    else {
      while (i1 < i3)
      {
        paramString1 = new HouseGroupListBean();
        paramString1.setHouseGroupTitle("房间" + (i1 + 1));
        this.ag.add(paramString1);
        i1 += 1;
      }
    }
    if (i3 < i2)
    {
      i1 = this.ag.size();
      while (i1 > i3)
      {
        this.aA.remove(i1 + "");
        paramString1 = (HouseGroupListBean)this.ag.remove(i1 - 1);
        if (!TextUtils.isEmpty(paramString1.getRoomFid())) {
          this.ar.add(paramString1.getRoomFid());
        }
        i1 -= 1;
      }
      this.ah.notifyDataSetChanged();
      o();
      this.aK.put("houseType", Boolean.valueOf(true));
    }
  }
  
  private void b(String paramString)
  {
    if (paramString.equals("people_limit")) {
      if (this.aI != null) {
        this.aI.show();
      }
    }
    while (!paramString.equals("house_type"))
    {
      return;
      this.aI = new com.ziroom.ziroomcustomer.minsu.landlordrelease.view.c(getActivity(), "people_limit_shose", new a(null), this.Z);
      this.aI.setCanceledOnTouchOutside(true);
      paramString = this.aI.getWindow();
      paramString.getDecorView().setPadding(0, 0, 0, 0);
      localLayoutParams = paramString.getAttributes();
      localLayoutParams.width = -1;
      localLayoutParams.height = -2;
      paramString.setAttributes(localLayoutParams);
      paramString.setGravity(80);
      this.aI.show();
      this.aI.getTv_choose().setText("");
      return;
    }
    if (this.aJ != null)
    {
      this.aJ.show();
      return;
    }
    this.aJ = new com.ziroom.ziroomcustomer.minsu.landlordrelease.view.b(getActivity(), "multi_chose", this.ab, this.ac, this.ad, this.ae, this.af, new b(null), this.T, this.U, this.V, this.W, this.X);
    this.aJ.setCanceledOnTouchOutside(true);
    paramString = this.aJ.getWindow();
    paramString.getDecorView().setPadding(0, 0, 0, 0);
    WindowManager.LayoutParams localLayoutParams = paramString.getAttributes();
    localLayoutParams.width = -1;
    localLayoutParams.height = -2;
    paramString.setAttributes(localLayoutParams);
    paramString.setGravity(80);
    this.aJ.show();
    this.aJ.getTv_choose().setText("");
  }
  
  private void c()
  {
    e();
    d();
    i();
  }
  
  private void d()
  {
    this.h.setOnClickListener(this);
    this.j.setOnClickListener(this);
    this.w.setOnClickListener(this);
    this.z.setOnClickListener(this);
    this.B.setOnClickListener(this);
    this.D.setOnClickListener(this);
    this.F.setOnClickListener(this);
    this.x.setOnFocusChangeListener(new View.OnFocusChangeListener()
    {
      public void onFocusChange(View paramAnonymousView, boolean paramAnonymousBoolean)
      {
        if (!paramAnonymousBoolean)
        {
          paramAnonymousView = VdsAgent.trackEditTextSilent(LLRManagerStepSecondHouseFragment.a(LLRManagerStepSecondHouseFragment.this)).toString().trim();
          if (!TextUtils.isEmpty(paramAnonymousView)) {
            try
            {
              if (paramAnonymousView.contains("平米")) {
                return;
              }
              LLRManagerStepSecondHouseFragment.a(LLRManagerStepSecondHouseFragment.this).setInputType(1);
              LLRManagerStepSecondHouseFragment.a(LLRManagerStepSecondHouseFragment.this).setText(paramAnonymousView + "平米");
              return;
            }
            catch (NumberFormatException paramAnonymousView) {}
          }
        }
        else
        {
          paramAnonymousView = VdsAgent.trackEditTextSilent(LLRManagerStepSecondHouseFragment.a(LLRManagerStepSecondHouseFragment.this)).toString();
          if ((!TextUtils.isEmpty(paramAnonymousView)) && (paramAnonymousView.contains("平米")))
          {
            paramAnonymousView = paramAnonymousView.replaceAll("平米", "");
            LLRManagerStepSecondHouseFragment.a(LLRManagerStepSecondHouseFragment.this).setText(paramAnonymousView);
            LLRManagerStepSecondHouseFragment.a(LLRManagerStepSecondHouseFragment.this).setInputType(2);
            LLRManagerStepSecondHouseFragment.a(LLRManagerStepSecondHouseFragment.this).setSelection(paramAnonymousView.length());
          }
        }
      }
    });
    this.d.setOnScrollChangedCallback(new ObservableScrollView.a()
    {
      public void onScroll(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        float f = paramAnonymousInt2 / 100.0F;
        LLRManagerStepSecondHouseFragment.b(LLRManagerStepSecondHouseFragment.this).setBottomLineAlpha(f);
      }
    });
  }
  
  private void e()
  {
    f();
    View localView = getView();
    this.c = ((ReleaseUsageAndTipsView)localView.findViewById(2131689893));
    this.c.setCode("TIP_HOW_WRITE_MANAGE_ROOM_MSG");
    this.d = ((ObservableScrollView)localView.findViewById(2131690150));
    this.e = localView.findViewById(2131694658);
    this.f = ((RelativeLayout)localView.findViewById(2131694192));
    this.g = ((EditText)localView.findViewById(2131694193));
    this.h = ((RelativeLayout)localView.findViewById(2131694194));
    this.i = ((TextView)localView.findViewById(2131694660));
    this.j = ((RelativeLayout)localView.findViewById(2131694197));
    this.k = ((TextView)localView.findViewById(2131694663));
    this.H = ((TextView)localView.findViewById(2131694662));
    this.I = ((TextView)localView.findViewById(2131694659));
    this.J = ((TextView)localView.findViewById(2131694657));
    if (this.aG == 0) {}
    for (;;)
    {
      this.w = ((RelativeLayout)localView.findViewById(2131694649));
      this.x = ((EditText)localView.findViewById(2131694651));
      this.y = ((TextView)localView.findViewById(2131694652));
      this.z = ((RelativeLayout)localView.findViewById(2131694653));
      this.A = ((TextView)localView.findViewById(2131694210));
      this.B = ((RelativeLayout)localView.findViewById(2131694654));
      this.B.setVisibility(8);
      localView.findViewById(2131694656).setVisibility(8);
      localView.findViewById(2131694664).setVisibility(8);
      this.C = ((TextView)localView.findViewById(2131689878));
      this.D = ((RelativeLayout)localView.findViewById(2131689885));
      this.E = ((TextView)localView.findViewById(2131689888));
      this.F = ((RelativeLayout)localView.findViewById(2131694212));
      this.G = ((TextView)localView.findViewById(2131694215));
      ((TextView)localView.findViewById(2131694648)).setText("基础信息");
      this.K = ((ExpandableListViewForScrollView)localView.findViewById(2131694216));
      this.ah = new com.ziroom.ziroomcustomer.minsu.landlordrelease.b.d(getActivity(), this.ag);
      this.K.setAdapter(this.ah);
      this.K.setGroupIndicator(null);
      this.K.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener()
      {
        @Instrumented
        public boolean onGroupClick(ExpandableListView paramAnonymousExpandableListView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          VdsAgent.onGroupClick(this, paramAnonymousExpandableListView, paramAnonymousView, paramAnonymousInt, paramAnonymousLong);
          VdsAgent.handleClickResult(new Boolean(true));
          return true;
        }
      });
      this.ah.setmGroupItemClickListener(new com.ziroom.ziroomcustomer.minsu.landlordrelease.b.d.b()
      {
        public void onGroupClickPosition(int paramAnonymousInt)
        {
          Intent localIntent = new Intent(LLRManagerStepSecondHouseFragment.this.getActivity(), HouseBedInfoActivity.class);
          Bundle localBundle = new Bundle();
          localBundle.putInt("groupClickPosition", paramAnonymousInt);
          if (LLRManagerStepSecondHouseFragment.c(LLRManagerStepSecondHouseFragment.this).get(paramAnonymousInt + "") != null) {
            localBundle.putSerializable("bedTypeList", (Serializable)LLRManagerStepSecondHouseFragment.c(LLRManagerStepSecondHouseFragment.this).get(paramAnonymousInt + ""));
          }
          for (;;)
          {
            localIntent.putExtras(localBundle);
            LLRManagerStepSecondHouseFragment.this.startActivityForResult(localIntent, 345);
            return;
            localBundle.putSerializable("bedTypeList", LLRManagerStepSecondHouseFragment.d(LLRManagerStepSecondHouseFragment.this));
          }
        }
      });
      int i1 = 0;
      while (i1 < this.ag.size())
      {
        this.K.expandGroup(i1);
        i1 += 1;
      }
      if (this.aG == 1)
      {
        this.f.setVisibility(8);
        this.e.setVisibility(8);
      }
    }
  }
  
  private void f()
  {
    this.b = ((CommonTitle)getView().findViewById(2131691272));
    this.b.setLeftButtonType(0);
    this.b.setBottomLineAlpha(0.0F);
    this.b.setOnLeftButtonClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        LLRManagerStepSecondHouseFragment.e(LLRManagerStepSecondHouseFragment.this);
      }
    });
    this.b.showRightText(true, getString(2131297412));
    this.b.setOnRightButtonClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        LLRManagerStepSecondHouseFragment.f(LLRManagerStepSecondHouseFragment.this);
      }
    });
  }
  
  private void g()
  {
    if (p())
    {
      com.ziroom.commonlibrary.widget.unifiedziroom.d.newBuilder(getActivity()).setOnConfirmClickListener(new com.ziroom.commonlibrary.widget.unifiedziroom.d.b()
      {
        public void onLeftClick(View paramAnonymousView) {}
        
        public void onRightClick(View paramAnonymousView)
        {
          LLRManagerStepSecondHouseFragment.this.getActivity().finish();
        }
      }).setTitle(getResources().getString(2131297090)).setContent(getResources().getString(2131297089)).setButtonText("取消", "确定").show();
      return;
    }
    getActivity().finish();
  }
  
  public static LLRManagerStepSecondHouseFragment getInstance(Bundle paramBundle)
  {
    LLRManagerStepSecondHouseFragment localLLRManagerStepSecondHouseFragment = new LLRManagerStepSecondHouseFragment();
    localLLRManagerStepSecondHouseFragment.setArguments(paramBundle);
    return localLLRManagerStepSecondHouseFragment;
  }
  
  private void h()
  {
    this.aL = new com.ziroom.ziroomcustomer.minsu.landlordrelease.d.c(this);
    this.a.register(this.aL);
    this.aM = com.ziroom.ziroomcustomer.minsu.landlordrelease.a.b.getInstance(this.a);
  }
  
  private void i()
  {
    this.aM.initDescAndBaseInfoEntire(this, getActivity(), this.aE);
  }
  
  private void j()
  {
    String str1;
    String str2;
    if ((this.m != null) && (this.m.getData() != null))
    {
      this.n = this.m.getData().getHouseName();
      this.o = this.m.getData().getHouseDesc();
      this.p = this.m.getData().getHouseAroundDesc();
      if (this.n != null)
      {
        str1 = this.n.getValue();
        this.v = this.n.getText();
        if (TextUtils.isEmpty(str1)) {
          break label261;
        }
        this.g.setText(str1);
        this.g.setTextColor(Color.parseColor("#444444"));
        if (!this.n.isEdit()) {
          break label288;
        }
        this.g.setEnabled(true);
        this.g.setClickable(true);
      }
      if (this.o != null)
      {
        str1 = this.o.getValue();
        str2 = this.o.getText();
        this.q = this.o.getExplain();
        if (TextUtils.isEmpty(str1)) {
          break label305;
        }
        this.i.setText(str1);
        this.i.setTextColor(Color.parseColor("#444444"));
      }
    }
    for (;;)
    {
      if (this.p != null)
      {
        str1 = this.p.getValue();
        str2 = this.p.getText();
        this.r = this.p.getExplain();
        if (TextUtils.isEmpty(str1)) {
          break label336;
        }
        this.k.setText(str1);
        this.k.setTextColor(Color.parseColor("#444444"));
      }
      return;
      label261:
      this.g.setHint(this.v);
      this.g.setTextColor(Color.parseColor("#999999"));
      break;
      label288:
      this.g.setEnabled(false);
      this.g.setClickable(false);
      return;
      label305:
      if (!TextUtils.isEmpty(str2))
      {
        this.i.setHint(str2);
        this.i.setTextColor(Color.parseColor("#999999"));
      }
    }
    label336:
    this.k.setHint(str2);
    this.k.setTextColor(Color.parseColor("#999999"));
  }
  
  private void k()
  {
    int i3 = 0;
    if ((this.L != null) && (this.L.getData() != null))
    {
      this.R = this.L.getData();
      this.M = this.R.getHouseArea();
      if (this.M != null)
      {
        i1 = this.M.getValue();
        if (i1 != 0)
        {
          this.x.setText(i1 + "平米");
          this.y.setText(i1 + "平米");
        }
      }
      if (!this.R.getHouseArea().isEdit())
      {
        this.x.setVisibility(8);
        this.y.setVisibility(0);
        this.y.setOnClickListener(this);
      }
      this.N = this.R.getHouseFacility();
      this.S = this.R.getGroupFacilityList();
      Object localObject1 = new StringBuffer();
      Object localObject2 = new StringBuffer();
      if ((this.S != null) && (!this.S.isEmpty()))
      {
        i1 = 0;
        while (i1 < this.S.size())
        {
          localObject3 = ((HouseFacilityGroupBean)this.S.get(i1)).getFacilitiesList().getList();
          if (localObject3 != null)
          {
            i2 = 0;
            while (i2 < ((List)localObject3).size())
            {
              if (((FacilitiesListDataBean)((List)localObject3).get(i2)).isSelect())
              {
                localObject4 = ((FacilitiesListDataBean)((List)localObject3).get(i2)).getText();
                ((StringBuffer)localObject1).append((String)localObject4 + "、");
                ((StringBuffer)localObject2).append(((FacilitiesListDataBean)((List)localObject3).get(i2)).getValue()).append(",");
              }
              i2 += 1;
            }
          }
          i1 += 1;
        }
        if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (((StringBuffer)localObject1).length() >= 1))
        {
          ((StringBuffer)localObject1).deleteCharAt(((StringBuffer)localObject1).length() - 1);
          this.au = ((StringBuffer)localObject2).toString();
        }
        if (!TextUtils.isEmpty((CharSequence)localObject1)) {
          break label559;
        }
      }
      for (;;)
      {
        m();
        l();
        this.O = this.R.getCheckInLimit();
        if (this.O == null) {
          break label603;
        }
        this.Y = this.O.getList();
        i1 = 0;
        while (i1 < this.Y.size())
        {
          localObject1 = new SingleChoseBean();
          ((SingleChoseBean)localObject1).setText(((CheckInLimitBean.CheckInLimitDataBean)this.Y.get(i1)).getText());
          ((SingleChoseBean)localObject1).setIsChosen(((CheckInLimitBean.CheckInLimitDataBean)this.Y.get(i1)).isSelect());
          if (((SingleChoseBean)localObject1).isChosen()) {
            this.aa = ((CheckInLimitBean.CheckInLimitDataBean)this.Y.get(i1));
          }
          this.Z.add(localObject1);
          i1 += 1;
        }
        label559:
        this.A.setText((CharSequence)localObject1);
      }
      this.E.setText("" + this.aa.getText());
      label603:
      this.ab = this.R.getRoomNum();
      this.ac = this.R.getParlorNum();
      this.ad = this.R.getToiletNum();
      this.ae = this.R.getKitchenNum();
      this.af = this.R.getBalconyNum();
      localObject1 = this.R.getMaxRoom();
      localObject2 = this.R.getMaxParlor();
      Object localObject3 = this.R.getMaxToilet();
      Object localObject4 = this.R.getMaxKitchen();
      Object localObject5 = this.R.getMaxBalcony();
      this.P = this.R.getHouseModel();
      if (this.P != null)
      {
        this.as = this.P.getValue();
        a((Integer)localObject1, (Integer)localObject2, (Integer)localObject3, (Integer)localObject4, (Integer)localObject5);
      }
      this.az.clear();
      this.az.addAll(this.R.getHouseRoomList());
      this.aD.clear();
      this.aD.addAll(this.R.getBedTypeList().getList());
      this.aB.clear();
      if ((this.aD != null) && (this.aD.size() > 0))
      {
        localObject1 = this.aD.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (BedAllTypeListDataBean)((Iterator)localObject1).next();
          this.aB.put(((BedAllTypeListDataBean)localObject2).getValue(), localObject2);
        }
      }
      this.ag.clear();
      int i1 = 0;
      int i2 = i3;
      if (i1 < this.az.size())
      {
        localObject1 = (LandlordReleaseHousePriceBasicData.HouseRoomListBean)this.az.get(i1);
        localObject2 = new HouseGroupListBean();
        localObject3 = new ArrayList();
        localObject4 = new ArrayList();
        localObject5 = this.aD.iterator();
        while (((Iterator)localObject5).hasNext()) {
          ((ArrayList)localObject4).add(((BedAllTypeListDataBean)((Iterator)localObject5).next()).cloneBean());
        }
        localObject5 = new ArrayList();
        ((List)localObject5).addAll(((LandlordReleaseHousePriceBasicData.HouseRoomListBean)localObject1).getBedList());
        localObject5 = ((List)localObject5).iterator();
        for (;;)
        {
          LandlordReleaseHousePriceBasicData.HouseRoomListBean.HouseHaveBedListDataBean localHouseHaveBedListDataBean;
          if (((Iterator)localObject5).hasNext())
          {
            localHouseHaveBedListDataBean = (LandlordReleaseHousePriceBasicData.HouseRoomListBean.HouseHaveBedListDataBean)((Iterator)localObject5).next();
            if ((!TextUtils.isEmpty(localHouseHaveBedListDataBean.getText())) || (localHouseHaveBedListDataBean.getValue() <= 0)) {}
          }
          else
          {
            ((HouseGroupListBean)localObject2).setRoomFid(((LandlordReleaseHousePriceBasicData.HouseRoomListBean)localObject1).getRoomFid());
            ((HouseGroupListBean)localObject2).setHouseBedList((List)localObject3);
            this.ag.add(localObject2);
            this.aA.put(i1 + "", localObject4);
            i1 += 1;
            break;
          }
          Object localObject6 = new HouseBedListBean();
          ((HouseBedListBean)localObject6).setHouseBedNum(localHouseHaveBedListDataBean.getValue());
          ((HouseBedListBean)localObject6).setValue(localHouseHaveBedListDataBean.getText());
          if (this.aB.get(localHouseHaveBedListDataBean.getText()) != null) {
            ((HouseBedListBean)localObject6).setHouseBedTitile(((BedAllTypeListDataBean)this.aB.get(localHouseHaveBedListDataBean.getText())).getText());
          }
          ((List)localObject3).add(localObject6);
          localObject6 = ((ArrayList)localObject4).iterator();
          while (((Iterator)localObject6).hasNext())
          {
            BedAllTypeListDataBean localBedAllTypeListDataBean = (BedAllTypeListDataBean)((Iterator)localObject6).next();
            if (localBedAllTypeListDataBean.getValue().equals(localHouseHaveBedListDataBean.getText())) {
              localBedAllTypeListDataBean.setCount(localHouseHaveBedListDataBean.getValue());
            }
          }
        }
      }
      while (i2 < this.ag.size())
      {
        ((HouseGroupListBean)this.ag.get(i2)).setHouseGroupTitle("房间" + (i2 + 1));
        i2 += 1;
      }
      o();
    }
  }
  
  private void l()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if (this.ai != 0) {
      localStringBuilder.append("基础价格：" + this.ai + "元/晚").append("\n");
    }
    if (TextUtils.isEmpty(this.ak)) {}
    for (;;)
    {
      if (this.an != 0.0D) {
        localStringBuilder.append("满7天折扣:" + this.an + "折").append("\n");
      }
      if (this.ao != 0.0D) {
        localStringBuilder.append("满30天折扣:" + this.ao + "折").append("\n");
      }
      if (this.aj != 0) {
        localStringBuilder.append("清洁费").append(this.aj).append("元").append("\n");
      }
      if (localStringBuilder.length() > 0) {
        break;
      }
      return;
      if (this.av != null) {
        localStringBuilder.append(this.al + ":" + this.am + "元/晚").append("\n");
      }
    }
    this.C.setText(localStringBuilder.subSequence(0, localStringBuilder.length() - 1).toString());
  }
  
  private void m()
  {
    this.Q = this.R.getLeasePrice();
    if (this.Q != null) {
      this.ai = this.Q.getValue();
    }
    this.av = this.R.getWeekendPrice();
    if (this.av != null) {
      this.am = this.av.getValue();
    }
    Object localObject = this.R.getWeekendList();
    int i1;
    if ((localObject != null) && (((WeekendListBean)localObject).getList() != null))
    {
      localObject = ((WeekendListBean)localObject).getList();
      if ((localObject != null) && (!((List)localObject).isEmpty())) {
        i1 = 0;
      }
    }
    for (;;)
    {
      if (i1 < ((List)localObject).size())
      {
        if (((WeekendListBean.WeekendLisDataBean)((List)localObject).get(i1)).isSelect())
        {
          this.ak = ((WeekendListBean.WeekendLisDataBean)((List)localObject).get(i1)).getValue();
          this.al = String.valueOf(((WeekendListBean.WeekendLisDataBean)((List)localObject).get(i1)).getText());
        }
      }
      else
      {
        this.aw = this.R.getSevenDiscountRate();
        if (this.aw != null) {
          this.an = this.aw.getValue().doubleValue();
        }
        this.ax = this.R.getThirtyDiscountRate();
        if (this.ax != null) {
          this.ao = this.ax.getValue().doubleValue();
        }
        this.ay = this.R.getCleaningFees();
        if (this.ay != null) {
          this.aj = this.ay.getValue();
        }
        return;
      }
      i1 += 1;
    }
  }
  
  private void n()
  {
    this.s = VdsAgent.trackEditTextSilent(this.g).toString();
    if (TextUtils.isEmpty(this.s))
    {
      g.textToast(getActivity(), "请输入房源名称");
      return;
    }
    if (this.s.length() < 10)
    {
      g.textToast(getActivity(), "请至少输入10个字的房源名称");
      return;
    }
    String str1 = this.i.getText().toString();
    if (TextUtils.isEmpty(str1))
    {
      g.textToast(getActivity(), "请输入房源描述");
      return;
    }
    String str2 = this.k.getText().toString();
    if (TextUtils.isEmpty(str2))
    {
      g.textToast(getActivity(), "请输入周边情况");
      return;
    }
    Double localDouble = Double.valueOf(0.0D);
    Object localObject1 = VdsAgent.trackEditTextSilent(this.x).toString();
    if (!TextUtils.isEmpty((CharSequence)localObject1)) {
      localDouble = Double.valueOf(Double.parseDouble(((String)localObject1).replaceAll("平米", "")));
    }
    if (this.aa != null) {}
    for (int i1 = this.aa.getValue();; i1 = 0)
    {
      if (TextUtils.isEmpty(this.as))
      {
        showToast("请选择户型");
        return;
      }
      localObject1 = new ArrayList();
      Iterator localIterator = this.ag.iterator();
      while (localIterator.hasNext())
      {
        Object localObject2 = (HouseGroupListBean)localIterator.next();
        SaveHouseRoomListBean localSaveHouseRoomListBean = new SaveHouseRoomListBean();
        localSaveHouseRoomListBean.setFid(((HouseGroupListBean)localObject2).getRoomFid());
        if (((HouseGroupListBean)localObject2).getHouseBedList() != null)
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localObject2 = ((HouseGroupListBean)localObject2).getHouseBedList().iterator();
          while (((Iterator)localObject2).hasNext())
          {
            HouseBedListBean localHouseBedListBean = (HouseBedListBean)((Iterator)localObject2).next();
            localStringBuilder.append(localHouseBedListBean.getValue()).append("_").append(localHouseBedListBean.getHouseBedNum()).append(",");
          }
          localSaveHouseRoomListBean.setBedMsg(localStringBuilder.toString());
        }
        ((List)localObject1).add(localSaveHouseRoomListBean);
      }
      this.aM.saveDescAndBaseInfoEntire(this, getActivity(), this.aE, this.aF, this.aG, this.s, str1, str2, localDouble, this.au, Integer.valueOf(i1), this.as, (List)localObject1, this.ar);
      return;
    }
  }
  
  private void o()
  {
    int i3 = 0;
    int i4 = this.K.getCount();
    int i1 = 0;
    int i2;
    for (;;)
    {
      i2 = i3;
      if (i1 >= i4) {
        break;
      }
      this.K.expandGroup(i1);
      i1 += 1;
    }
    while (i2 < this.ag.size())
    {
      this.K.expandGroup(i2);
      i2 += 1;
    }
    this.ah.notifyDataSetChanged();
  }
  
  private boolean p()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.m != null)
    {
      bool1 = bool2;
      if (this.L != null)
      {
        if (VdsAgent.trackEditTextSilent(this.g).toString().equals(this.m.getData().getHouseName().getValue())) {
          break label53;
        }
        bool1 = true;
      }
    }
    return bool1;
    label53:
    if (!this.i.getText().toString().equals(this.m.getData().getHouseDesc().getValue())) {
      return true;
    }
    if (!this.k.getText().toString().equals(this.m.getData().getHouseAroundDesc().getValue())) {
      return true;
    }
    Double localDouble = Double.valueOf(0.0D);
    String str = VdsAgent.trackEditTextSilent(this.x).toString();
    if (!TextUtils.isEmpty(str)) {
      localDouble = Double.valueOf(Double.parseDouble(str.replaceAll("平米", "")));
    }
    if (localDouble.doubleValue() != this.L.getData().getHouseArea().getValue()) {
      return true;
    }
    return this.aK.containsValue(Boolean.valueOf(true));
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
      case 1: 
      default: 
        return;
        if (parama.equals("ll_r_manager_step_2_house"))
        {
          i1 = 0;
          continue;
          if (parama.equals("ll_r_manager_step_2_house_error"))
          {
            i1 = 1;
            continue;
            if (parama.equals("ll_r_manager_step_2_house_save"))
            {
              i1 = 2;
              continue;
              if (parama.equals("ll_r_manager_step_2_house_save_error")) {
                i1 = 3;
              }
            }
          }
        }
        break;
      }
    }
    this.l = this.aL.getLlrManagerStep2HouseBean();
    parama = e.parseObject(this.l);
    if ((parama == null) || (parama.get("data") == null))
    {
      if (this.l == null) {}
      for (parama = "";; parama = parama.get("message") + "")
      {
        ad.shouErrorMessage(parama);
        return;
      }
    }
    this.m = ((LandlordReleaseHouseDescBean)e.parseObject(this.l, LandlordReleaseHouseDescBean.class));
    j();
    if ((this.m != null) && (this.m.getData() != null))
    {
      if (this.m.getData().getHouseName() != null) {
        this.J.setText(this.m.getData().getHouseName().getAuditMsg());
      }
      if (this.m.getData().getHouseDesc() != null) {
        this.I.setText(this.m.getData().getHouseDesc().getAuditMsg());
      }
      if (this.m.getData().getHouseAroundDesc() != null) {
        this.H.setText(this.m.getData().getHouseAroundDesc().getAuditMsg());
      }
    }
    this.L = ((LandlordReleaseHousePriceBasicBean)e.parseObject(this.l, LandlordReleaseHousePriceBasicBean.class));
    k();
    return;
    parama = this.aL.getLlrManagerStep2HouseSaveResult();
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
    int i1 = 0;
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    Object localObject;
    if (paramInt2 == 4096)
    {
      localObject = paramIntent.getStringExtra("saveDesc");
      if (paramInt1 != 234) {
        break label242;
      }
      this.i.setText((CharSequence)localObject);
      this.i.setTextColor(Color.parseColor("#444444"));
      this.t = true;
    }
    while (paramInt2 == -1)
    {
      if (paramInt1 == 345)
      {
        localObject = (ArrayList)paramIntent.getExtras().getSerializable("bedTypeList");
        int i2 = paramIntent.getExtras().getInt("groupClickPosition");
        this.aA.put(i2 + "", localObject);
        ArrayList localArrayList = new ArrayList();
        paramInt2 = 0;
        for (;;)
        {
          if (paramInt2 < ((ArrayList)localObject).size())
          {
            if (((BedAllTypeListDataBean)((ArrayList)localObject).get(paramInt2)).getCount() > 0)
            {
              HouseBedListBean localHouseBedListBean = new HouseBedListBean();
              localHouseBedListBean.setHouseBedTitile(((BedAllTypeListDataBean)((ArrayList)localObject).get(paramInt2)).getText());
              localHouseBedListBean.setHouseBedNum(((BedAllTypeListDataBean)((ArrayList)localObject).get(paramInt2)).getCount());
              localHouseBedListBean.setValue(((BedAllTypeListDataBean)((ArrayList)localObject).get(paramInt2)).getValue());
              localArrayList.add(localHouseBedListBean);
            }
            paramInt2 += 1;
            continue;
            label242:
            if (paramInt1 != 456) {
              break;
            }
            this.k.setText((CharSequence)localObject);
            this.k.setTextColor(Color.parseColor("#444444"));
            this.u = true;
            break;
          }
        }
        ((HouseGroupListBean)this.ag.get(i2)).setHouseBedList(localArrayList);
        paramInt2 = i1;
        while (paramInt2 < this.ag.size())
        {
          ((HouseGroupListBean)this.ag.get(paramInt2)).setHouseGroupTitle("房间" + (paramInt2 + 1));
          paramInt2 += 1;
        }
        o();
        this.aK.put("roombed", Boolean.valueOf(true));
      }
      if (paramInt1 == 123)
      {
        this.at = paramIntent.getStringExtra("chosenAmentiesStr");
        this.au = paramIntent.getStringExtra("houseFacility");
        if (!TextUtils.isEmpty(this.at)) {
          this.A.setText(this.at);
        }
        this.aK.put("houseFacility", Boolean.valueOf(true));
      }
      if (paramInt1 == 234)
      {
        this.ai = paramIntent.getIntExtra("leasePrice", -1);
        this.ap = paramIntent.getIntExtra("weekendPriceSwitch", -1);
        this.ak = paramIntent.getStringExtra("weekendPriceType");
        this.al = paramIntent.getStringExtra("weekendPriceTypeD");
        this.am = paramIntent.getDoubleExtra("weekendPriceVal", -1.0D);
        this.aq = paramIntent.getIntExtra("fullDayRateSwitch", -1);
        this.an = paramIntent.getDoubleExtra("sevenDiscountRate", -1.0D);
        this.ao = paramIntent.getDoubleExtra("thirtyDiscountRate", -1.0D);
        this.aj = paramIntent.getIntExtra("cleaningFees", -1);
        l();
        this.aK.put("price", Boolean.valueOf(true));
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
    case 2131694652: 
    case 2131694193: 
    case 2131694194: 
    case 2131694197: 
      do
      {
        do
        {
          return;
          g.textToast(getActivity(), "已上架房源无法修改");
          return;
          if ((this.n != null) && (!this.n.isEdit())) {
            break;
          }
        } while (this.o == null);
        if (this.o.isEdit())
        {
          paramView = new Intent(getActivity(), CommonSaveDescInfoActivity.class);
          paramView.putExtra("titleName", "房源描述");
          paramView.putExtra("editTextHint", this.q);
          paramView.putExtra("saveDescText", this.i.getText() + "");
          paramView.putExtra("editMaxNum", 1000);
          paramView.putExtra("editMinNum", 100);
          startActivityForResult(paramView, 234);
          return;
          g.textToast(getActivity(), getString(2131297167));
          return;
        }
        g.textToast(getActivity(), getString(2131297167));
        return;
      } while (this.p == null);
      if (this.p.isEdit())
      {
        paramView = new Intent(getActivity(), CommonSaveDescInfoActivity.class);
        paramView.putExtra("titleName", "周边情况");
        paramView.putExtra("editTextHint", this.r);
        paramView.putExtra("saveDescText", this.k.getText() + "");
        paramView.putExtra("editMaxNum", 1000);
        paramView.putExtra("editMinNum", 100);
        startActivityForResult(paramView, 456);
        return;
      }
      g.textToast(getActivity(), getString(2131297167));
      return;
    case 2131694653: 
      if (this.L.getData().getHouseFacility().isEdit())
      {
        paramView = new Intent(getActivity(), HouseAmenitiesActivity.class);
        Bundle localBundle = new Bundle();
        localBundle.putSerializable("amenitiesData", (Serializable)this.S);
        paramView.putExtras(localBundle);
        startActivityForResult(paramView, 123);
        return;
      }
      g.textToast(getActivity(), getString(2131297167));
      return;
    case 2131694654: 
      paramView = new Intent(getActivity(), HousePriceSettingActivity.class);
      paramView.putExtra("basicData", this.R);
      startActivityForResult(paramView, 234);
      return;
    case 2131689885: 
      if (this.L.getData().getCheckInLimit().isEdit())
      {
        b("people_limit");
        return;
      }
      g.textToast(getActivity(), getString(2131297167));
      return;
    }
    if (this.L.getData().getHouseModel().isEdit())
    {
      b("house_type");
      return;
    }
    if (this.aH == 1)
    {
      g.textToast(getActivity(), "已上架房源无法修改");
      return;
    }
    g.textToast(getActivity(), getString(2131297167));
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    h();
    return paramLayoutInflater.inflate(2130903959, null);
  }
  
  public void onDestroyView()
  {
    this.a.unregister(this.aL);
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
      this.aE = paramBundle.getString("houseBaseFid");
      this.aF = paramBundle.getString("roomFid");
      this.aG = paramBundle.getInt("rentWay");
      this.aH = paramBundle.getInt("status");
    }
  }
  
  private class a
    implements c.a
  {
    private a() {}
    
    public void onSingleSelect(String paramString, int paramInt)
    {
      LLRManagerStepSecondHouseFragment.a(LLRManagerStepSecondHouseFragment.this, (CheckInLimitBean.CheckInLimitDataBean)LLRManagerStepSecondHouseFragment.g(LLRManagerStepSecondHouseFragment.this).get(paramInt));
      LLRManagerStepSecondHouseFragment.h(LLRManagerStepSecondHouseFragment.this).setText(paramString);
      LLRManagerStepSecondHouseFragment.h(LLRManagerStepSecondHouseFragment.this).setTextColor(Color.parseColor("#444444"));
      LLRManagerStepSecondHouseFragment.i(LLRManagerStepSecondHouseFragment.this).put("limit", Boolean.valueOf(true));
    }
  }
  
  private class b
    implements b.a
  {
    private b() {}
    
    public void getChoseHouseType(final String paramString1, final String paramString2, final String paramString3, final String paramString4, final String paramString5)
    {
      if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)) && (!TextUtils.isEmpty(paramString3)) && (!TextUtils.isEmpty(paramString4)) && (!TextUtils.isEmpty(paramString5)))
      {
        int i = Integer.valueOf(paramString1.split("室")[0]).intValue();
        int j = LLRManagerStepSecondHouseFragment.j(LLRManagerStepSecondHouseFragment.this).size();
        if (i < j)
        {
          StringBuilder localStringBuilder = new StringBuilder("将会删除");
          while (i < j)
          {
            localStringBuilder.append(((HouseGroupListBean)LLRManagerStepSecondHouseFragment.j(LLRManagerStepSecondHouseFragment.this).get(i)).getHouseGroupTitle()).append("、");
            i += 1;
          }
          com.ziroom.commonlibrary.widget.unifiedziroom.d.newBuilder(LLRManagerStepSecondHouseFragment.this.getActivity()).setOnConfirmClickListener(new com.ziroom.commonlibrary.widget.unifiedziroom.d.b()
          {
            public void onLeftClick(View paramAnonymousView) {}
            
            public void onRightClick(View paramAnonymousView)
            {
              LLRManagerStepSecondHouseFragment.a(LLRManagerStepSecondHouseFragment.this, paramString1, paramString2, paramString3, paramString4, paramString5);
            }
          }).setContent(localStringBuilder.substring(0, localStringBuilder.length() - 1)).setButtonText("取消", "确定").show();
        }
      }
      else
      {
        return;
      }
      LLRManagerStepSecondHouseFragment.a(LLRManagerStepSecondHouseFragment.this, paramString1, paramString2, paramString3, paramString4, paramString5);
    }
    
    public void showBalconySelect(String paramString, int paramInt) {}
    
    public void showKitchenSelect(String paramString, int paramInt) {}
    
    public void showShiSelect(String paramString, int paramInt) {}
    
    public void showTingSelect(String paramString, int paramInt) {}
    
    public void showToiletSelect(String paramString, int paramInt) {}
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/landlordrelease/LLRManagerStepSecondHouseFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */