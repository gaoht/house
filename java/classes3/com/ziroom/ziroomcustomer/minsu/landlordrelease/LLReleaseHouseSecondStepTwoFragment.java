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
import android.view.View.OnFocusChangeListener;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnGroupClickListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.freelxl.baselibrary.f.g;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.commonlibrary.widget.unifiedziroom.d.a;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.minsu.f.ad;
import com.ziroom.ziroomcustomer.minsu.landlordrelease.base.BaseLandlordReleaseFragment;
import com.ziroom.ziroomcustomer.minsu.landlordrelease.model.HouseBedListBean;
import com.ziroom.ziroomcustomer.minsu.landlordrelease.model.LandlordReleaseAmenitiesBean;
import com.ziroom.ziroomcustomer.minsu.landlordrelease.model.SaveHouseRoomListBean;
import com.ziroom.ziroomcustomer.minsu.landlordrelease.model.SingleChoseBean;
import com.ziroom.ziroomcustomer.minsu.landlordrelease.model.housedesec.LLSaveHouseDescBean;
import com.ziroom.ziroomcustomer.minsu.landlordrelease.model.housedesec.LLSaveHouseDescBean.SaveHouseDescData;
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
import com.ziroom.ziroomcustomer.minsu.landlordrelease.view.ExpandableListViewForScrollView;
import com.ziroom.ziroomcustomer.minsu.landlordrelease.view.ReleaseUsageAndTipsView;
import com.ziroom.ziroomcustomer.minsu.landlordrelease.view.b.a;
import com.ziroom.ziroomcustomer.minsu.landlordrelease.view.c.a;
import com.ziroom.ziroomcustomer.util.af;
import com.ziroom.ziroomcustomer.widget.ObservableScrollView;
import com.ziroom.ziroomcustomer.widget.ObservableScrollView.a;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class LLReleaseHouseSecondStepTwoFragment
  extends BaseLandlordReleaseFragment
  implements View.OnClickListener, com.ziroom.ziroomcustomer.minsu.landlordrelease.base.a
{
  private List<HouseFacilityGroupBean> A;
  private ArrayList<String> B = new ArrayList();
  private ArrayList<String> C = new ArrayList();
  private ArrayList<String> D = new ArrayList();
  private ArrayList<String> E = new ArrayList();
  private ArrayList<String> F = new ArrayList();
  private List<CheckInLimitBean.CheckInLimitDataBean> G;
  private List<SingleChoseBean> H = new ArrayList();
  private CheckInLimitBean.CheckInLimitDataBean I;
  private Integer J;
  private Integer K;
  private Integer L;
  private Integer M;
  private Integer N;
  private List<HouseGroupListBean> O = new ArrayList();
  private com.ziroom.ziroomcustomer.minsu.landlordrelease.b.d P;
  private int Q;
  private int R;
  private String S;
  private String T;
  private int U;
  private double V;
  private double W;
  private int X;
  private int Y;
  private List<String> Z = new ArrayList();
  private String aa;
  private String ab;
  private String ac;
  private ReleaseUsageAndTipsView ad;
  private LandlordReleaseHousePriceBasicData.WeekendPriceBean ae;
  private LandlordReleaseHousePriceBasicData.SevenDiscountRateBean af;
  private LandlordReleaseHousePriceBasicData.ThirtyDiscountRateBean ag;
  private LandlordReleaseHousePriceBasicData.CleaningFeesBean ah;
  private View ai;
  private List<LandlordReleaseHousePriceBasicData.HouseRoomListBean> aj = new ArrayList();
  private Map<String, ArrayList<BedAllTypeListDataBean>> ak = new HashMap();
  private Map<String, BedAllTypeListDataBean> al = new HashMap();
  private List<BedAllTypeListDataBean> am;
  private com.ziroom.ziroomcustomer.minsu.landlordrelease.view.c an;
  private Map<String, Boolean> ao = new HashMap();
  private TextView ap;
  private com.ziroom.ziroomcustomer.minsu.landlordrelease.view.b aq;
  private InputMethodManager ar;
  private BroadcastReceiver as = new BroadcastReceiver()
  {
    public void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
    {
      if (paramAnonymousIntent.getIntExtra("type", 0) == 17) {
        LLReleaseHouseSecondStepTwoFragment.n(LLReleaseHouseSecondStepTwoFragment.this);
      }
    }
  };
  private boolean at = false;
  private boolean au = false;
  private boolean av = false;
  private boolean aw = false;
  private MinsuReleaseActivity b;
  private ImageView c;
  private RelativeLayout d;
  private EditText e;
  private RelativeLayout f;
  private TextView g;
  private RelativeLayout h;
  private TextView i;
  private RelativeLayout j;
  private TextView k;
  private RelativeLayout l;
  private TextView m;
  private Button n;
  private ObservableScrollView o;
  private View p;
  private ExpandableListViewForScrollView q;
  private com.ziroom.ziroomcustomer.minsu.landlordrelease.d.c r;
  private com.ziroom.ziroomcustomer.minsu.landlordrelease.a.b s;
  private LandlordReleaseHousePriceBasicBean t;
  private LandlordReleaseHousePriceBasicData.HouseAreaBean u;
  private LandlordReleaseHousePriceBasicData.HouseFacilityBean v;
  private CheckInLimitBean w;
  private LandlordReleaseHousePriceBasicData.HouseModelBean x;
  private LandlordReleaseHousePriceBasicData.LeasePriceBean y;
  private LandlordReleaseHousePriceBasicData z;
  
  private boolean A()
  {
    if ((this.z == null) || (this.z.getHouseRoomList() == null) || (this.z.getHouseRoomList().size() == 0)) {
      return this.O.size() > 0;
    }
    List localList1 = this.z.getHouseRoomList();
    int i1 = 0;
    for (;;)
    {
      if (i1 >= this.O.size()) {
        break label258;
      }
      Object localObject = (LandlordReleaseHousePriceBasicData.HouseRoomListBean)localList1.get(i1);
      if (!((HouseGroupListBean)this.O.get(i1)).getRoomFid().equals(((LandlordReleaseHousePriceBasicData.HouseRoomListBean)localObject).getRoomFid())) {
        break;
      }
      List localList2 = ((HouseGroupListBean)this.O.get(i1)).getHouseBedList();
      localObject = ((LandlordReleaseHousePriceBasicData.HouseRoomListBean)localObject).getBedList();
      int i2 = 0;
      for (;;)
      {
        if (i2 >= localList2.size()) {
          break label251;
        }
        HouseBedListBean localHouseBedListBean = (HouseBedListBean)localList2.get(i2);
        int i3 = 0;
        int i4 = 0;
        for (;;)
        {
          if (i3 >= ((List)localObject).size()) {
            break label231;
          }
          LandlordReleaseHousePriceBasicData.HouseRoomListBean.HouseHaveBedListDataBean localHouseHaveBedListDataBean = (LandlordReleaseHousePriceBasicData.HouseRoomListBean.HouseHaveBedListDataBean)((List)localObject).get(i3);
          if (localHouseBedListBean.getValue().equals(localHouseHaveBedListDataBean.getText()))
          {
            if (localHouseBedListBean.getHouseBedNum() != localHouseHaveBedListDataBean.getValue()) {
              break;
            }
            i4 = 1;
          }
          i3 += 1;
        }
        label231:
        if ((i4 == 0) && (localHouseBedListBean.getHouseBedNum() > 0)) {
          break;
        }
        i2 += 1;
      }
      label251:
      i1 += 1;
    }
    label258:
    return false;
  }
  
  private com.ziroom.ziroomcustomer.minsu.landlordrelease.view.c a(String paramString, List<SingleChoseBean> paramList, c.a parama)
  {
    paramString = new com.ziroom.ziroomcustomer.minsu.landlordrelease.view.c(this.b, paramString, parama, paramList);
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
  
  private void a(Integer paramInteger1, Integer paramInteger2, Integer paramInteger3, Integer paramInteger4, Integer paramInteger5)
  {
    int i4 = 1;
    int i3 = 0;
    int i1 = 1;
    while (i1 <= paramInteger1.intValue())
    {
      this.B.add(i1 + "室");
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
      this.C.add(i1 + "厅");
      i1 += 1;
    }
    while (i2 <= paramInteger3.intValue())
    {
      this.D.add(i2 + "卫");
      i2 += 1;
    }
    i1 = 0;
    for (;;)
    {
      i2 = i3;
      if (i1 > paramInteger4.intValue()) {
        break;
      }
      this.E.add(i1 + "厨");
      i1 += 1;
    }
    while (i2 <= paramInteger5.intValue())
    {
      this.F.add(i2 + "阳台");
      i2 += 1;
    }
  }
  
  private void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    this.aa = (paramString1.replaceAll("室", "") + "," + paramString2.replaceAll("厅", "") + "," + paramString3.replaceAll("卫", "") + "," + paramString4.replaceAll("厨", "") + "," + paramString5.replaceAll("阳台", ""));
    this.ao.put("houseModel", Boolean.valueOf(true));
    this.aw = true;
    this.m.setText(paramString1 + paramString2 + paramString3 + paramString4 + paramString5);
    this.m.setTextColor(Color.parseColor("#444444"));
    int i3 = Integer.valueOf(paramString1.split("室")[0]).intValue();
    int i2 = this.O.size();
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
        this.O.add(paramString1);
        i1 += 1;
      }
    }
    if (i3 < i2)
    {
      i1 = this.O.size();
      while (i1 > i3)
      {
        this.ak.remove(i1 + "");
        paramString1 = (HouseGroupListBean)this.O.remove(i1 - 1);
        if (!TextUtils.isEmpty(paramString1.getRoomFid())) {
          this.Z.add(paramString1.getRoomFid());
        }
        i1 -= 1;
      }
      this.P.notifyDataSetChanged();
      y();
    }
  }
  
  private void d()
  {
    this.q.setGroupIndicator(null);
    o();
    e();
  }
  
  private void d(String paramString)
  {
    if (paramString.equals("people_limit")) {
      if (this.an != null) {
        this.an.show();
      }
    }
    while (!paramString.equals("house_type")) {
      return;
    }
    if (this.aq != null)
    {
      this.aq.show();
      return;
    }
    this.aq = new com.ziroom.ziroomcustomer.minsu.landlordrelease.view.b(this.b, "multi_chose", this.J, this.K, this.L, this.M, this.N, new b(null), this.B, this.C, this.D, this.E, this.F);
    this.aq.setCanceledOnTouchOutside(true);
    paramString = this.aq.getWindow();
    paramString.getDecorView().setPadding(0, 0, 0, 0);
    WindowManager.LayoutParams localLayoutParams = paramString.getAttributes();
    localLayoutParams.width = -1;
    localLayoutParams.height = -2;
    paramString.setAttributes(localLayoutParams);
    paramString.setGravity(80);
    this.aq.show();
    this.aq.getTv_choose().setText("");
  }
  
  private void e()
  {
    this.c.setOnClickListener(this);
    this.d.setOnClickListener(this);
    this.f.setOnClickListener(this);
    this.h.setOnClickListener(this);
    this.j.setOnClickListener(this);
    this.l.setOnClickListener(this);
    this.n.setOnClickListener(this);
    this.e.setOnFocusChangeListener(new View.OnFocusChangeListener()
    {
      public void onFocusChange(View paramAnonymousView, boolean paramAnonymousBoolean)
      {
        String str;
        if (!paramAnonymousBoolean)
        {
          str = VdsAgent.trackEditTextSilent(LLReleaseHouseSecondStepTwoFragment.a(LLReleaseHouseSecondStepTwoFragment.this)).toString().trim();
          if (!TextUtils.isEmpty(str)) {
            try
            {
              if (str.contains("平米")) {
                return;
              }
              LLReleaseHouseSecondStepTwoFragment.a(LLReleaseHouseSecondStepTwoFragment.this).setInputType(1);
              LLReleaseHouseSecondStepTwoFragment.a(LLReleaseHouseSecondStepTwoFragment.this).setText(str + "平米");
              if (LLReleaseHouseSecondStepTwoFragment.b(LLReleaseHouseSecondStepTwoFragment.this) == null) {
                return;
              }
              LLReleaseHouseSecondStepTwoFragment.b(LLReleaseHouseSecondStepTwoFragment.this).hideSoftInputFromWindow(paramAnonymousView.getWindowToken(), 0);
              return;
            }
            catch (NumberFormatException paramAnonymousView) {}
          }
        }
        else
        {
          str = VdsAgent.trackEditTextSilent(LLReleaseHouseSecondStepTwoFragment.a(LLReleaseHouseSecondStepTwoFragment.this)).toString();
          if ((!TextUtils.isEmpty(str)) && (str.contains("平米")))
          {
            str = str.replaceAll("平米", "");
            LLReleaseHouseSecondStepTwoFragment.a(LLReleaseHouseSecondStepTwoFragment.this).setText(str);
            LLReleaseHouseSecondStepTwoFragment.a(LLReleaseHouseSecondStepTwoFragment.this).setInputType(2);
            LLReleaseHouseSecondStepTwoFragment.a(LLReleaseHouseSecondStepTwoFragment.this).setSelection(str.length());
            if (LLReleaseHouseSecondStepTwoFragment.b(LLReleaseHouseSecondStepTwoFragment.this) != null) {
              LLReleaseHouseSecondStepTwoFragment.b(LLReleaseHouseSecondStepTwoFragment.this).showSoftInput(paramAnonymousView, 2);
            }
          }
        }
      }
    });
    this.e.addTextChangedListener(new TextWatcher()
    {
      public void afterTextChanged(Editable paramAnonymousEditable) {}
      
      public void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        LLReleaseHouseSecondStepTwoFragment.c(LLReleaseHouseSecondStepTwoFragment.this).put("houseArea", Boolean.valueOf(true));
        LLReleaseHouseSecondStepTwoFragment.d(LLReleaseHouseSecondStepTwoFragment.this);
      }
    });
    this.o.setOnScrollChangedCallback(new ObservableScrollView.a()
    {
      public void onScroll(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        float f = paramAnonymousInt2 / 100.0F;
        LLReleaseHouseSecondStepTwoFragment.e(LLReleaseHouseSecondStepTwoFragment.this).setAlpha(f);
      }
    });
  }
  
  private void m()
  {
    this.r = new com.ziroom.ziroomcustomer.minsu.landlordrelease.d.c(this);
    this.a.register(this.r);
    this.s = com.ziroom.ziroomcustomer.minsu.landlordrelease.a.b.getInstance(this.a);
  }
  
  private void n()
  {
    this.a.unregister(this.r);
  }
  
  public static LLReleaseHouseSecondStepTwoFragment newInstance()
  {
    Bundle localBundle = new Bundle();
    LLReleaseHouseSecondStepTwoFragment localLLReleaseHouseSecondStepTwoFragment = new LLReleaseHouseSecondStepTwoFragment();
    localLLReleaseHouseSecondStepTwoFragment.setArguments(localBundle);
    return localLLReleaseHouseSecondStepTwoFragment;
  }
  
  private void o()
  {
    this.s.getLandlordReleaseHousePrice(this, this.b, k(), j(), Integer.valueOf(h()));
  }
  
  private void p()
  {
    int i3 = 0;
    if ((this.t != null) && (this.t.getData() != null))
    {
      this.z = this.t.getData();
      this.u = this.z.getHouseArea();
      if (this.u != null)
      {
        i1 = this.u.getValue();
        if (i1 != 0)
        {
          this.e.setText(i1 + "平米");
          this.ao.put("houseArea", Boolean.valueOf(false));
        }
      }
      this.v = this.z.getHouseFacility();
      this.A = this.z.getGroupFacilityList();
      localObject1 = new StringBuffer();
      Object localObject2 = new StringBuffer();
      if ((this.A != null) && (!this.A.isEmpty()))
      {
        i1 = 0;
        while (i1 < this.A.size())
        {
          localObject3 = ((HouseFacilityGroupBean)this.A.get(i1)).getFacilitiesList().getList();
          if (localObject3 != null)
          {
            int i2 = 0;
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
          this.ac = ((StringBuffer)localObject2).toString();
        }
        if (!TextUtils.isEmpty((CharSequence)localObject1)) {
          break label545;
        }
      }
      for (;;)
      {
        r();
        q();
        this.w = this.z.getCheckInLimit();
        if (this.w == null) {
          break label581;
        }
        this.G = this.w.getList();
        i1 = 0;
        while (i1 < this.G.size())
        {
          localObject1 = new SingleChoseBean();
          ((SingleChoseBean)localObject1).setText(((CheckInLimitBean.CheckInLimitDataBean)this.G.get(i1)).getText());
          ((SingleChoseBean)localObject1).setIsChosen(((CheckInLimitBean.CheckInLimitDataBean)this.G.get(i1)).isSelect());
          if (((CheckInLimitBean.CheckInLimitDataBean)this.G.get(i1)).isSelect())
          {
            localObject2 = ((CheckInLimitBean.CheckInLimitDataBean)this.G.get(i1)).getText();
            if (!TextUtils.isEmpty((CharSequence)localObject2))
            {
              this.k.setText((CharSequence)localObject2);
              this.au = true;
            }
          }
          this.H.add(localObject1);
          i1 += 1;
        }
        label545:
        this.g.setText((CharSequence)localObject1);
      }
      this.an = a("people_limit_shose", this.H, new a(null));
      label581:
      this.J = this.z.getRoomNum();
      this.K = this.z.getParlorNum();
      this.L = this.z.getToiletNum();
      this.M = this.z.getKitchenNum();
      this.N = this.z.getBalconyNum();
      localObject1 = this.z.getMaxRoom();
      localObject2 = this.z.getMaxParlor();
      Object localObject3 = this.z.getMaxToilet();
      Object localObject4 = this.z.getMaxKitchen();
      Object localObject5 = this.z.getMaxBalcony();
      this.x = this.z.getHouseModel();
      if (this.J.intValue() == 0) {
        this.m.setHint("请选择整套房子的户型");
      }
      for (;;)
      {
        if (this.x != null)
        {
          this.aa = this.x.getValue();
          a((Integer)localObject1, (Integer)localObject2, (Integer)localObject3, (Integer)localObject4, (Integer)localObject5);
        }
        this.aj.clear();
        this.aj.addAll(this.z.getHouseRoomList());
        this.am = this.z.getBedTypeList().getList();
        if ((this.am == null) || (this.am.size() <= 0)) {
          break;
        }
        this.al.clear();
        localObject1 = this.am.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (BedAllTypeListDataBean)((Iterator)localObject1).next();
          this.al.put(((BedAllTypeListDataBean)localObject2).getValue(), localObject2);
        }
        this.aw = true;
        this.m.setText(this.J + "室" + this.K + "厅" + this.L + "卫" + this.M + "厨" + this.N + "阳台");
      }
      this.O.clear();
      int i1 = 0;
      if (i1 < this.aj.size())
      {
        localObject1 = (LandlordReleaseHousePriceBasicData.HouseRoomListBean)this.aj.get(i1);
        localObject2 = new HouseGroupListBean();
        localObject3 = new ArrayList();
        localObject5 = new ArrayList();
        ((List)localObject5).addAll(((LandlordReleaseHousePriceBasicData.HouseRoomListBean)localObject1).getBedList());
        localObject4 = new ArrayList();
        Object localObject6 = this.am.iterator();
        while (((Iterator)localObject6).hasNext()) {
          ((ArrayList)localObject4).add(((BedAllTypeListDataBean)((Iterator)localObject6).next()).cloneBean());
        }
        localObject5 = ((List)localObject5).iterator();
        for (;;)
        {
          if (((Iterator)localObject5).hasNext())
          {
            localObject6 = (LandlordReleaseHousePriceBasicData.HouseRoomListBean.HouseHaveBedListDataBean)((Iterator)localObject5).next();
            if ((!TextUtils.isEmpty(((LandlordReleaseHousePriceBasicData.HouseRoomListBean.HouseHaveBedListDataBean)localObject6).getText())) || (((LandlordReleaseHousePriceBasicData.HouseRoomListBean.HouseHaveBedListDataBean)localObject6).getValue() <= 0)) {}
          }
          else
          {
            ((HouseGroupListBean)localObject2).setRoomFid(((LandlordReleaseHousePriceBasicData.HouseRoomListBean)localObject1).getRoomFid());
            ((HouseGroupListBean)localObject2).setHouseBedList((List)localObject3);
            this.O.add(localObject2);
            this.ak.put(i1 + "", localObject4);
            i1 += 1;
            break;
          }
          this.av = true;
          Object localObject7 = new HouseBedListBean();
          ((HouseBedListBean)localObject7).setHouseBedNum(((LandlordReleaseHousePriceBasicData.HouseRoomListBean.HouseHaveBedListDataBean)localObject6).getValue());
          ((HouseBedListBean)localObject7).setValue(((LandlordReleaseHousePriceBasicData.HouseRoomListBean.HouseHaveBedListDataBean)localObject6).getText());
          if (this.al.get(((LandlordReleaseHousePriceBasicData.HouseRoomListBean.HouseHaveBedListDataBean)localObject6).getText()) != null) {
            ((HouseBedListBean)localObject7).setHouseBedTitile(((BedAllTypeListDataBean)this.al.get(((LandlordReleaseHousePriceBasicData.HouseRoomListBean.HouseHaveBedListDataBean)localObject6).getText())).getText());
          }
          ((List)localObject3).add(localObject7);
          localObject7 = ((ArrayList)localObject4).iterator();
          while (((Iterator)localObject7).hasNext())
          {
            BedAllTypeListDataBean localBedAllTypeListDataBean = (BedAllTypeListDataBean)((Iterator)localObject7).next();
            if (localBedAllTypeListDataBean.getValue().equals(((LandlordReleaseHousePriceBasicData.HouseRoomListBean.HouseHaveBedListDataBean)localObject6).getText())) {
              localBedAllTypeListDataBean.setCount(((LandlordReleaseHousePriceBasicData.HouseRoomListBean.HouseHaveBedListDataBean)localObject6).getValue());
            }
          }
        }
      }
      this.P = new com.ziroom.ziroomcustomer.minsu.landlordrelease.b.d(this.b, this.O);
      this.q.setAdapter(this.P);
      this.q.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener()
      {
        @Instrumented
        public boolean onGroupClick(ExpandableListView paramAnonymousExpandableListView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          VdsAgent.onGroupClick(this, paramAnonymousExpandableListView, paramAnonymousView, paramAnonymousInt, paramAnonymousLong);
          VdsAgent.handleClickResult(new Boolean(true));
          return true;
        }
      });
      this.P.setmGroupItemClickListener(new com.ziroom.ziroomcustomer.minsu.landlordrelease.b.d.b()
      {
        public void onGroupClickPosition(int paramAnonymousInt)
        {
          Intent localIntent = new Intent(LLReleaseHouseSecondStepTwoFragment.f(LLReleaseHouseSecondStepTwoFragment.this), HouseBedInfoActivity.class);
          Bundle localBundle = new Bundle();
          localBundle.putInt("groupClickPosition", paramAnonymousInt);
          if (LLReleaseHouseSecondStepTwoFragment.g(LLReleaseHouseSecondStepTwoFragment.this).get(paramAnonymousInt + "") != null) {
            localBundle.putSerializable("bedTypeList", (Serializable)LLReleaseHouseSecondStepTwoFragment.g(LLReleaseHouseSecondStepTwoFragment.this).get(paramAnonymousInt + ""));
          }
          for (;;)
          {
            localIntent.putExtras(localBundle);
            LLReleaseHouseSecondStepTwoFragment.this.startActivityForResult(localIntent, 345);
            return;
            localBundle.putSerializable("bedTypeList", (Serializable)LLReleaseHouseSecondStepTwoFragment.h(LLReleaseHouseSecondStepTwoFragment.this));
          }
        }
      });
      i1 = i3;
      while (i1 < this.O.size())
      {
        this.q.expandGroup(i1);
        ((HouseGroupListBean)this.O.get(i1)).setHouseGroupTitle("房间" + (i1 + 1));
        i1 += 1;
      }
      z();
      return;
    }
    if (this.t == null) {}
    for (Object localObject1 = "";; localObject1 = this.t.message)
    {
      ad.shouErrorMessage((String)localObject1);
      return;
    }
  }
  
  private void q()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if (this.Q != 0) {
      localStringBuilder.append("基础价格：" + this.Q + "元/晚").append("\n");
    }
    if ((this.X == 1) && (this.U != 0) && (!TextUtils.isEmpty(this.T))) {
      localStringBuilder.append(this.T + "：" + this.U + "元/晚").append("\n");
    }
    if (this.Y == 1)
    {
      if (this.V != 0.0D) {
        localStringBuilder.append("满7天折扣：" + this.V + "折").append("\n");
      }
      if (this.W != 0.0D) {
        localStringBuilder.append("满30天折扣：" + this.W + "折").append("\n");
      }
    }
    if (this.R != 0) {
      localStringBuilder.append("清洁费：").append(this.R).append("元").append("\n");
    }
    if (localStringBuilder.length() <= 0) {
      return;
    }
    this.i.setText(localStringBuilder.subSequence(0, localStringBuilder.length() - 1).toString());
  }
  
  private void r()
  {
    this.y = this.z.getLeasePrice();
    if (this.y != null)
    {
      this.Q = this.y.getValue();
      if (this.Q != 0) {
        this.at = true;
      }
    }
    this.ae = this.z.getWeekendPrice();
    if (this.ae != null) {
      this.U = this.ae.getValue();
    }
    Object localObject = this.z.getWeekendList();
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
          this.S = ((WeekendListBean.WeekendLisDataBean)((List)localObject).get(i1)).getValue();
          this.T = String.valueOf(((WeekendListBean.WeekendLisDataBean)((List)localObject).get(i1)).getText());
        }
      }
      else
      {
        this.af = this.z.getSevenDiscountRate();
        if (this.af != null) {
          this.V = this.af.getValue().doubleValue();
        }
        this.ag = this.z.getThirtyDiscountRate();
        if (this.ag != null) {
          this.W = this.ag.getValue().doubleValue();
        }
        this.ah = this.z.getCleaningFees();
        if (this.ah != null) {
          this.R = this.ah.getValue();
        }
        return;
      }
      i1 += 1;
    }
  }
  
  private void s()
  {
    Iterator localIterator = this.ao.entrySet().iterator();
    int i1 = 0;
    if (localIterator.hasNext())
    {
      if (!((Boolean)((Map.Entry)localIterator.next()).getValue()).booleanValue()) {
        break label127;
      }
      i1 = 1;
    }
    label127:
    for (;;)
    {
      break;
      if ((i1 != 0) || (A()))
      {
        com.ziroom.commonlibrary.widget.unifiedziroom.d.newBuilder(this.b).setOnConfirmClickListener(new com.ziroom.commonlibrary.widget.unifiedziroom.d.b()
        {
          public void onLeftClick(View paramAnonymousView) {}
          
          public void onRightClick(View paramAnonymousView)
          {
            LLReleaseHouseSecondStepTwoFragment.i(LLReleaseHouseSecondStepTwoFragment.this);
          }
        }).setTitle(getResources().getString(2131297090)).setContent(getResources().getString(2131297089)).setButtonText("取消", "确定").show();
        return;
      }
      g();
      return;
    }
  }
  
  private Bundle t()
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("houseBaseFid", k());
    localBundle.putString("roomFid", j());
    localBundle.putInt("rentWay", h());
    localBundle.putInt("priceTag", 1);
    localBundle.putInt("leasePrice", this.Q);
    localBundle.putInt("weekendPriceSwitch", this.X);
    localBundle.putString("weekendPriceType", this.S);
    localBundle.putString("weekendPriceTypeD", this.T);
    localBundle.putInt("weekendPriceVal", this.U);
    localBundle.putInt("fullDayRateSwitch", this.Y);
    localBundle.putDouble("sevenDiscountRate", this.V);
    localBundle.putDouble("thirtyDiscountRate", this.W);
    localBundle.putInt("cleaningFees", this.R);
    localBundle.putInt("maxPrice", this.t.getData().getMaxPrice());
    localBundle.putInt("minPrice", this.t.getData().getMinPrice());
    localBundle.putSerializable("weekendList", this.t.getData().getWeekendList());
    return localBundle;
  }
  
  private void u()
  {
    if (!ApplicationEx.c.isLoginState())
    {
      com.ziroom.commonlibrary.login.a.startLoginActivity(this.b);
      af.showToast(this.b, "请先登录");
      return;
    }
    Object localObject = VdsAgent.trackEditTextSilent(this.e) + "";
    Integer localInteger = null;
    if (TextUtils.isEmpty((CharSequence)localObject))
    {
      g.textToast(getActivity(), "请输入房源面积");
      return;
    }
    if (!TextUtils.isEmpty((CharSequence)localObject)) {
      localInteger = Integer.valueOf(VdsAgent.trackEditTextSilent(this.e).toString().replace("平米", ""));
    }
    int i1 = 0;
    if (this.I != null) {
      i1 = this.I.getValue();
    }
    if (TextUtils.isEmpty(this.aa))
    {
      showToast("请选择户型");
      return;
    }
    localObject = w();
    if (!this.av)
    {
      showToast("请填写床位信息");
      return;
    }
    this.s.saveLLReleaseHousePrice(this, this.b, k(), j(), h(), localInteger, this.ac, this.Q, this.R, this.X, this.S, this.U, this.Y, this.V, this.W, Integer.valueOf(i1), this.aa, (List)localObject, this.Z);
  }
  
  private void v()
  {
    w();
    com.ziroom.commonlibrary.widget.unifiedziroom.d.newBuilder(this.b).setButtonText("取消", "确定").setContent("您已添加" + x() + "张床，是否继续发布房源？").setTitle("请确认床位信息").setOnConfirmClickListener(new com.ziroom.commonlibrary.widget.unifiedziroom.d.b()
    {
      public void onLeftClick(View paramAnonymousView) {}
      
      public void onRightClick(View paramAnonymousView)
      {
        LLReleaseHouseSecondStepTwoFragment.j(LLReleaseHouseSecondStepTwoFragment.this);
      }
    }).show();
  }
  
  private List<SaveHouseRoomListBean> w()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.O.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (HouseGroupListBean)localIterator.next();
      SaveHouseRoomListBean localSaveHouseRoomListBean = new SaveHouseRoomListBean();
      localSaveHouseRoomListBean.setFid(((HouseGroupListBean)localObject).getRoomFid());
      if (((HouseGroupListBean)localObject).getHouseBedList() != null)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localObject = ((HouseGroupListBean)localObject).getHouseBedList().iterator();
        while (((Iterator)localObject).hasNext())
        {
          HouseBedListBean localHouseBedListBean = (HouseBedListBean)((Iterator)localObject).next();
          localStringBuilder.append(localHouseBedListBean.getValue()).append("_").append(localHouseBedListBean.getHouseBedNum()).append(",");
          if (localHouseBedListBean.getHouseBedNum() > 0) {
            this.av = true;
          }
        }
        localSaveHouseRoomListBean.setBedMsg(localStringBuilder.toString());
      }
      localArrayList.add(localSaveHouseRoomListBean);
    }
    return localArrayList;
  }
  
  private int x()
  {
    int i2;
    if ((this.O == null) || (this.O.size() == 0))
    {
      i2 = 0;
      return i2;
    }
    Iterator localIterator = this.O.iterator();
    for (int i1 = 0;; i1 = i2)
    {
      i2 = i1;
      if (!localIterator.hasNext()) {
        break;
      }
      Object localObject = (HouseGroupListBean)localIterator.next();
      i2 = i1;
      if (((HouseGroupListBean)localObject).getHouseBedList() != null)
      {
        localObject = ((HouseGroupListBean)localObject).getHouseBedList().iterator();
        for (;;)
        {
          i2 = i1;
          if (!((Iterator)localObject).hasNext()) {
            break;
          }
          HouseBedListBean localHouseBedListBean = (HouseBedListBean)((Iterator)localObject).next();
          if (localHouseBedListBean.getHouseBedNum() > 0) {
            i1 += localHouseBedListBean.getHouseBedNum();
          }
        }
      }
    }
  }
  
  private void y()
  {
    int i1 = 0;
    this.av = false;
    int i2 = this.q.getCount();
    while (i1 < i2)
    {
      this.q.expandGroup(i1);
      i1 += 1;
    }
    this.P.notifyDataSetChanged();
    if ((this.O != null) && (this.O.size() > 0)) {
      this.ai.setVisibility(8);
    }
  }
  
  private void z()
  {
    w();
    if ((!TextUtils.isEmpty(VdsAgent.trackEditTextSilent(this.e).toString())) && (!TextUtils.isEmpty(this.g.getText().toString())) && (this.at) && (this.au) && (this.av) && (this.aw))
    {
      this.n.setEnabled(true);
      this.n.setBackgroundResource(2130839597);
      return;
    }
    this.n.setEnabled(false);
    this.n.setBackgroundResource(2130837946);
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
    do
    {
      return;
      if (!parama.equals("house_price_basic")) {
        break;
      }
      i1 = 0;
      break;
      if (!parama.equals("house_price_basic_error")) {
        break;
      }
      i1 = 1;
      break;
      if (!parama.equals("save_house_price_basic")) {
        break;
      }
      i1 = 2;
      break;
      if (!parama.equals("save_house_price_basic_error")) {
        break;
      }
      i1 = 3;
      break;
      this.t = this.r.getmLandlordReleaseHousePriceBasicBean();
      p();
      this.o.scrollTo(0, 0);
      return;
      this.o.setVisibility(8);
      this.n.setVisibility(8);
      this.ad.setVisibility(8);
      showToast(this.r.getHousePriceBasicErrorMsg());
      return;
      parama = this.r.getmLLSaveHousePriceBean();
    } while (parama == null);
    LLSaveHouseDescBean.SaveHouseDescData localSaveHouseDescData = parama.getData();
    if (localSaveHouseDescData != null)
    {
      if (!TextUtils.isEmpty(localSaveHouseDescData.getHouseBaseFid()))
      {
        f();
        this.ao.clear();
        return;
      }
      g.textToast(this.b, parama.message);
      return;
    }
    g.textToast(this.b, parama.message);
    return;
    showToast(this.r.getSaveHousePriceBasicErrorMsg());
  }
  
  protected View c()
  {
    View localView = LayoutInflater.from(this.b).inflate(2130903957, null);
    this.ap = ((TextView)localView.findViewById(2131694280));
    this.c = ((ImageView)localView.findViewById(2131689492));
    this.d = ((RelativeLayout)localView.findViewById(2131694649));
    this.e = ((EditText)localView.findViewById(2131694651));
    this.f = ((RelativeLayout)localView.findViewById(2131694653));
    this.g = ((TextView)localView.findViewById(2131694210));
    this.h = ((RelativeLayout)localView.findViewById(2131694654));
    this.i = ((TextView)localView.findViewById(2131689878));
    this.j = ((RelativeLayout)localView.findViewById(2131689885));
    this.k = ((TextView)localView.findViewById(2131689888));
    this.l = ((RelativeLayout)localView.findViewById(2131694212));
    this.m = ((TextView)localView.findViewById(2131694215));
    this.q = ((ExpandableListViewForScrollView)localView.findViewById(2131694216));
    this.n = ((Button)localView.findViewById(2131691053));
    this.ad = ((ReleaseUsageAndTipsView)localView.findViewById(2131689893));
    this.ai = localView.findViewById(2131694281);
    this.o = ((ObservableScrollView)localView.findViewById(2131689506));
    this.p = localView.findViewById(2131689863);
    this.ar = ((InputMethodManager)this.b.getSystemService("input_method"));
    return localView;
  }
  
  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    paramBundle = new IntentFilter();
    paramBundle.addAction("com.ziroom.commonlibrary.login.broadcast");
    LocalBroadcastManager.getInstance(this.b).registerReceiver(this.as, paramBundle);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    int i1 = 0;
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt2 == -1)
    {
      Object localObject1;
      Object localObject2;
      if (paramInt1 == 345)
      {
        localObject1 = (ArrayList)paramIntent.getExtras().getSerializable("bedTypeList");
        int i2 = paramIntent.getExtras().getInt("groupClickPosition");
        this.ak.put(i2 + "", localObject1);
        localObject2 = new ArrayList();
        paramInt2 = 0;
        while (paramInt2 < ((ArrayList)localObject1).size())
        {
          if (((BedAllTypeListDataBean)((ArrayList)localObject1).get(paramInt2)).getCount() > 0)
          {
            HouseBedListBean localHouseBedListBean = new HouseBedListBean();
            localHouseBedListBean.setHouseBedTitile(((BedAllTypeListDataBean)((ArrayList)localObject1).get(paramInt2)).getText());
            localHouseBedListBean.setHouseBedNum(((BedAllTypeListDataBean)((ArrayList)localObject1).get(paramInt2)).getCount());
            localHouseBedListBean.setValue(((BedAllTypeListDataBean)((ArrayList)localObject1).get(paramInt2)).getValue());
            ((List)localObject2).add(localHouseBedListBean);
          }
          paramInt2 += 1;
        }
        paramInt2 = 0;
        while (paramInt2 < this.O.size())
        {
          ((HouseGroupListBean)this.O.get(paramInt2)).setHouseGroupTitle("房间" + (paramInt2 + 1));
          paramInt2 += 1;
        }
        ((HouseGroupListBean)this.O.get(i2)).setHouseBedList((List)localObject2);
        y();
      }
      if (paramInt1 == 123)
      {
        this.ab = paramIntent.getStringExtra("chosenAmentiesStr");
        this.ac = paramIntent.getStringExtra("houseFacility");
        this.ao.put("houseFacility", Boolean.valueOf(true));
        localObject1 = (List)paramIntent.getExtras().getSerializable("groupList");
        if ((localObject1 != null) && (!((List)localObject1).isEmpty()))
        {
          paramInt2 = i1;
          while (paramInt2 < ((List)localObject1).size())
          {
            localObject2 = ((LandlordReleaseAmenitiesBean)((List)localObject1).get(paramInt2)).getChildList();
            ((HouseFacilityGroupBean)this.A.get(paramInt2)).getFacilitiesList().setList((List)localObject2);
            paramInt2 += 1;
          }
        }
        if (!TextUtils.isEmpty(this.ab)) {
          this.g.setText(this.ab);
        }
      }
      if (paramInt1 == 234)
      {
        this.Q = paramIntent.getIntExtra("leasePrice", -1);
        this.X = paramIntent.getIntExtra("weekendPriceSwitch", -1);
        this.S = paramIntent.getStringExtra("weekendPriceType");
        this.T = paramIntent.getStringExtra("weekendPriceTypeD");
        this.U = paramIntent.getIntExtra("weekendPriceVal", -1);
        this.Y = paramIntent.getIntExtra("fullDayRateSwitch", -1);
        this.V = paramIntent.getDoubleExtra("sevenDiscountRate", -1.0D);
        this.W = paramIntent.getDoubleExtra("thirtyDiscountRate", -1.0D);
        this.R = paramIntent.getIntExtra("cleaningFees", -1);
        if (this.Q != -1) {
          this.at = true;
        }
        q();
        this.ao.put("price", Boolean.valueOf(true));
      }
      z();
    }
  }
  
  public boolean onBackPressed()
  {
    s();
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
      s();
      return;
    case 2131694653: 
      paramView = new Intent(this.b, HouseAmenitiesActivity.class);
      Bundle localBundle = new Bundle();
      localBundle.putSerializable("amenitiesData", (Serializable)this.A);
      paramView.putExtras(localBundle);
      startActivityForResult(paramView, 123);
      return;
    case 2131694654: 
      paramView = new Intent(this.b, HousePriceSettingActivity.class);
      paramView.putExtras(t());
      startActivityForResult(paramView, 234);
      return;
    case 2131689885: 
      d("people_limit");
      return;
    case 2131694212: 
      d("house_type");
      return;
    }
    v();
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
    LocalBroadcastManager.getInstance(this.b).unregisterReceiver(this.as);
  }
  
  public void onDestroyView()
  {
    n();
    super.onDestroyView();
  }
  
  public void onLoginBack(boolean paramBoolean1, boolean paramBoolean2) {}
  
  public void onResume()
  {
    super.onResume();
    this.ap.setFocusable(true);
    this.ap.setFocusableInTouchMode(true);
    this.ap.requestFocus();
    z();
  }
  
  public void onStart()
  {
    super.onStart();
    this.ad.setCode("TIP_WRITE_ROOM_MSG");
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    d();
  }
  
  private class a
    implements c.a
  {
    private a() {}
    
    public void onSingleSelect(String paramString, int paramInt)
    {
      if ((LLReleaseHouseSecondStepTwoFragment.k(LLReleaseHouseSecondStepTwoFragment.this) != null) || (!LLReleaseHouseSecondStepTwoFragment.k(LLReleaseHouseSecondStepTwoFragment.this).isEmpty()))
      {
        LLReleaseHouseSecondStepTwoFragment.a(LLReleaseHouseSecondStepTwoFragment.this, (CheckInLimitBean.CheckInLimitDataBean)LLReleaseHouseSecondStepTwoFragment.k(LLReleaseHouseSecondStepTwoFragment.this).get(paramInt));
        LLReleaseHouseSecondStepTwoFragment.l(LLReleaseHouseSecondStepTwoFragment.this).setText(paramString);
        LLReleaseHouseSecondStepTwoFragment.l(LLReleaseHouseSecondStepTwoFragment.this).setTextColor(Color.parseColor("#444444"));
        LLReleaseHouseSecondStepTwoFragment.c(LLReleaseHouseSecondStepTwoFragment.this).put("checkInLimit", Boolean.valueOf(true));
        LLReleaseHouseSecondStepTwoFragment.a(LLReleaseHouseSecondStepTwoFragment.this, true);
        LLReleaseHouseSecondStepTwoFragment.d(LLReleaseHouseSecondStepTwoFragment.this);
      }
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
        int j = LLReleaseHouseSecondStepTwoFragment.m(LLReleaseHouseSecondStepTwoFragment.this).size();
        if (i >= j) {
          break label194;
        }
        StringBuilder localStringBuilder = new StringBuilder("将会删除");
        while (i < j)
        {
          localStringBuilder.append(((HouseGroupListBean)LLReleaseHouseSecondStepTwoFragment.m(LLReleaseHouseSecondStepTwoFragment.this).get(i)).getHouseGroupTitle()).append("、");
          i += 1;
        }
        com.ziroom.commonlibrary.widget.unifiedziroom.d.newBuilder(LLReleaseHouseSecondStepTwoFragment.f(LLReleaseHouseSecondStepTwoFragment.this)).setOnConfirmClickListener(new com.ziroom.commonlibrary.widget.unifiedziroom.d.b()
        {
          public void onLeftClick(View paramAnonymousView) {}
          
          public void onRightClick(View paramAnonymousView)
          {
            LLReleaseHouseSecondStepTwoFragment.a(LLReleaseHouseSecondStepTwoFragment.this, paramString1, paramString2, paramString3, paramString4, paramString5);
          }
        }).setContent(localStringBuilder.substring(0, localStringBuilder.length() - 1)).setButtonText("取消", "确定").show();
      }
      for (;;)
      {
        LLReleaseHouseSecondStepTwoFragment.d(LLReleaseHouseSecondStepTwoFragment.this);
        return;
        label194:
        LLReleaseHouseSecondStepTwoFragment.a(LLReleaseHouseSecondStepTwoFragment.this, paramString1, paramString2, paramString3, paramString4, paramString5);
      }
    }
    
    public void showBalconySelect(String paramString, int paramInt) {}
    
    public void showKitchenSelect(String paramString, int paramInt) {}
    
    public void showShiSelect(String paramString, int paramInt) {}
    
    public void showTingSelect(String paramString, int paramInt) {}
    
    public void showToiletSelect(String paramString, int paramInt) {}
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/landlordrelease/LLReleaseHouseSecondStepTwoFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */