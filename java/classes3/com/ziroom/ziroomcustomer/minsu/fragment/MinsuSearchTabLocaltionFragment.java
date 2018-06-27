package com.ziroom.ziroomcustomer.minsu.fragment;

import android.app.Activity;
import android.content.Context;
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
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.freelxl.baselibrary.e.i.a;
import com.freelxl.baselibrary.e.k;
import com.freelxl.baselibrary.f.g;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.commonlibrary.widget.rangebar.RangeBar;
import com.ziroom.commonlibrary.widget.rangebar.RangeBar.a;
import com.ziroom.ziroomcustomer.base.BaseFragment;
import com.ziroom.ziroomcustomer.minsu.adapter.d.a;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuInitSearchBase;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuInitSearchBase.DataBean;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuInitSearchBase.DataBean.HouseTypeListBean;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuInitSearchBase.DataBean.LongTermLeaseDiscountBean;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuInitSearchBase.DataBean.LongTermLeaseDiscountBean.ValuesBean;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuSearchConditionBean;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuSearchConditionBean.DataBean;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuSearchConditionBean.DataBean.CommercialRegionBean;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuSearchConditionBean.DataBean.DistrictBean;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuSearchConditionBean.DataBean.DistrictBean.DistrictsBean;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuSearchConditionBean.DataBean.SceneryRegionBean;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuSearchConditionBean.DataBean.SubwayBean;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuSearchConditionBean.DataBean.SubwayBean.ListBean;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuSearchConditionBean.DataBean.SubwayBean.ListBean.StationsBean;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuSearchHouseInfoBean;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuSearchSortBean;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuSearchSortBean.DataBean;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuSearchSortBean.DataBean.SortListBean;
import com.ziroom.ziroomcustomer.minsu.d.f;
import com.ziroom.ziroomcustomer.minsu.f.ab;
import com.ziroom.ziroomcustomer.minsu.f.ad;
import com.ziroom.ziroomcustomer.minsu.f.v;
import com.ziroom.ziroomcustomer.minsu.mapsojourn.model.b;
import com.ziroom.ziroomcustomer.minsu.view.CommonTitle;
import com.ziroom.ziroomcustomer.util.ae;
import com.ziroom.ziroomcustomer.util.u;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class MinsuSearchTabLocaltionFragment
  extends BaseFragment
  implements View.OnClickListener
{
  private int A = -1;
  private com.ziroom.ziroomcustomer.minsu.searchlist.base.c B;
  private com.ziroom.ziroomcustomer.minsu.adapter.d C;
  private com.ziroom.ziroomcustomer.minsu.adapter.d D;
  private com.ziroom.ziroomcustomer.minsu.adapter.d E;
  private com.ziroom.ziroomcustomer.minsu.adapter.d F;
  private com.ziroom.ziroomcustomer.minsu.adapter.d G;
  private com.ziroom.ziroomcustomer.minsu.adapter.d H;
  private com.ziroom.ziroomcustomer.minsu.adapter.d I;
  private int J = -1;
  private CommonTitle K;
  private CompoundButton.OnCheckedChangeListener L = new CompoundButton.OnCheckedChangeListener()
  {
    @Instrumented
    public void onCheckedChanged(CompoundButton paramAnonymousCompoundButton, boolean paramAnonymousBoolean)
    {
      VdsAgent.onCheckedChanged(this, paramAnonymousCompoundButton, paramAnonymousBoolean);
      paramAnonymousCompoundButton = (MinsuInitSearchBase.DataBean.HouseTypeListBean)paramAnonymousCompoundButton.getTag();
      u.i("info", "tag = " + paramAnonymousCompoundButton.toString() + " isChecked = " + paramAnonymousBoolean);
      if (paramAnonymousBoolean)
      {
        MinsuSearchTabLocaltionFragment.t(MinsuSearchTabLocaltionFragment.this).add(paramAnonymousCompoundButton.getKey());
        return;
      }
      MinsuSearchTabLocaltionFragment.t(MinsuSearchTabLocaltionFragment.this).remove(paramAnonymousCompoundButton.getKey());
    }
  };
  private CompoundButton.OnCheckedChangeListener M = new CompoundButton.OnCheckedChangeListener()
  {
    @Instrumented
    public void onCheckedChanged(CompoundButton paramAnonymousCompoundButton, boolean paramAnonymousBoolean)
    {
      VdsAgent.onCheckedChanged(this, paramAnonymousCompoundButton, paramAnonymousBoolean);
      paramAnonymousCompoundButton = (MinsuInitSearchBase.DataBean.LongTermLeaseDiscountBean.ValuesBean)paramAnonymousCompoundButton.getTag();
      u.i("info", "value.name = " + paramAnonymousCompoundButton.getName() + " isChecked = " + paramAnonymousBoolean);
      if (paramAnonymousBoolean)
      {
        MinsuSearchTabLocaltionFragment.u(MinsuSearchTabLocaltionFragment.this).add(paramAnonymousCompoundButton.getValue());
        return;
      }
      MinsuSearchTabLocaltionFragment.u(MinsuSearchTabLocaltionFragment.this).remove(paramAnonymousCompoundButton.getValue());
    }
  };
  private int N = -1;
  private int O = -1;
  private int P = -1;
  private final int Q = 1;
  private final int R = 2;
  private final int S = 0;
  private final int T = 1;
  private List<String> U = new ArrayList();
  private List<MinsuInitSearchBase.DataBean.HouseTypeListBean> V;
  private List<CheckBox> W;
  private MinsuInitSearchBase.DataBean.LongTermLeaseDiscountBean X;
  private List<MinsuInitSearchBase.DataBean.LongTermLeaseDiscountBean.ValuesBean> Y;
  private List<String> Z = new ArrayList();
  private View a;
  private List<CheckBox> aa;
  private RangeBar ab;
  private TextView ac;
  private TextView ad;
  private CheckBox ae;
  private CheckBox af;
  private CheckBox ag;
  private CheckBox ah;
  private TextView ai;
  private TextView aj;
  private TextView ak;
  private TextView al;
  private CheckBox am;
  private CheckBox an;
  private CheckBox ao;
  private CheckBox ap;
  private CheckBox aq;
  private StringBuilder ar = new StringBuilder();
  private String as;
  private LinearLayout at;
  private TextView au;
  private TextView av;
  private ListView b;
  private ListView c;
  private ListView d;
  private Context e;
  private boolean[] f = new boolean[3];
  private LinearLayout g;
  private LinearLayout h;
  private LinearLayout i;
  private LinearLayout j;
  private TextView k;
  private TextView l;
  private TextView m;
  private TextView n;
  private LinearLayout o;
  private LinearLayout p;
  private LinearLayout q;
  private boolean r = false;
  private List<Map> s;
  private List<Map> t;
  private List<Map> u;
  private List<Map> v;
  private List<Map> w;
  private List<Map> x;
  private List<Map> y;
  private int z = -1;
  
  private Bundle a(Bundle paramBundle)
  {
    Bundle localBundle = paramBundle;
    if (paramBundle == null) {
      localBundle = new Bundle();
    }
    localBundle.putSerializable("locationAdapter", this.C);
    localBundle.putSerializable("districtAdapter", this.D);
    localBundle.putSerializable("business_circleAdapter", this.E);
    localBundle.putSerializable("attractionsAdapter", this.F);
    localBundle.putSerializable("subwayAdapter", this.G);
    localBundle.putSerializable("subwayStationsAdapter", this.H);
    localBundle.putSerializable("sortAdapter", this.I);
    localBundle.putInt("selection", this.z);
    localBundle.putInt("lastSelection", this.A);
    if (this.w != null) {
      localBundle.putSerializable("subwayStations", (Serializable)this.w);
    }
    return localBundle;
  }
  
  private CheckBox a(int paramInt1, int paramInt2)
  {
    CheckBox localCheckBox = new CheckBox(this.e);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    if (paramInt2 == 1) {
      localLayoutParams.addRule(14);
    }
    for (;;)
    {
      localLayoutParams.setMargins(0, f(10), 0, 0);
      localLayoutParams.height = ((int)getResources().getDimension(2131231208));
      localCheckBox.setPadding(f(12), 0, f(12), 0);
      localCheckBox.setLayoutParams(localLayoutParams);
      localCheckBox.setMinWidth(f(72));
      localCheckBox.setLines(1);
      localCheckBox.setText(((MinsuInitSearchBase.DataBean.HouseTypeListBean)this.V.get(paramInt1 * 3 + paramInt2)).getText());
      localCheckBox.setButtonDrawable(getResources().getDrawable(17170445));
      localCheckBox.setBackgroundResource(2130839068);
      localCheckBox.setGravity(17);
      localCheckBox.setTextColor(getResources().getColorStateList(2131624642));
      localCheckBox.setTextSize(0, getResources().getDimensionPixelSize(2131230917));
      localCheckBox.setTag(this.V.get(paramInt1 * 3 + paramInt2));
      localCheckBox.setChecked(this.U.contains(((MinsuInitSearchBase.DataBean.HouseTypeListBean)this.V.get(paramInt1 * 3 + paramInt2)).getKey()));
      localCheckBox.setOnCheckedChangeListener(this.L);
      return localCheckBox;
      if (paramInt2 == 2) {
        localLayoutParams.addRule(11);
      }
    }
  }
  
  private void a(int paramInt)
  {
    toggle(true);
    c(paramInt);
    switch (paramInt)
    {
    default: 
      return;
    case 6: 
      m();
      return;
    case 4: 
      a(true);
      this.K.showRightText(true, "重置");
      this.K.setOnRightButtonClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          MinsuSearchTabLocaltionFragment.this.getActivity().setResult(11);
          MinsuSearchTabLocaltionFragment.this.getActivity().finish();
        }
      });
      return;
    case 5: 
      g();
      return;
    case 0: 
      h();
      return;
    case 1: 
      i();
      return;
    case 2: 
      j();
      return;
    case 3: 
      k();
      return;
    }
    l();
  }
  
  private void a(View paramView)
  {
    paramView.findViewById(2131697483).setOnClickListener(this);
    paramView.findViewById(2131697487).setOnClickListener(this);
    paramView.findViewById(2131697491).setOnClickListener(this);
    e locale = new e();
    this.af = ((CheckBox)paramView.findViewById(2131697486));
    this.af.setOnCheckedChangeListener(locale);
    this.ag = ((CheckBox)paramView.findViewById(2131697490));
    this.ag.setOnCheckedChangeListener(locale);
    this.ah = ((CheckBox)paramView.findViewById(2131697494));
    this.ah.setOnCheckedChangeListener(locale);
    this.aj = ((TextView)paramView.findViewById(2131697493));
    this.ai = ((TextView)paramView.findViewById(2131697492));
    this.ak = ((TextView)paramView.findViewById(2131697484));
    this.al = ((TextView)paramView.findViewById(2131697485));
  }
  
  private void a(LinearLayout paramLinearLayout, boolean paramBoolean)
  {
    int i1 = 0;
    View localView;
    if (i1 < paramLinearLayout.getChildCount())
    {
      localView = paramLinearLayout.getChildAt(i1);
      if (!(localView instanceof ImageView)) {}
    }
    for (paramLinearLayout = (ImageView)localView;; paramLinearLayout = null)
    {
      if (paramLinearLayout != null) {
        paramLinearLayout.setSelected(paramBoolean);
      }
      return;
      i1 += 1;
      break;
    }
  }
  
  private void a(MinsuInitSearchBase paramMinsuInitSearchBase, boolean paramBoolean)
  {
    int i1 = 8;
    this.V = paramMinsuInitSearchBase.getData().getHouseTypeList();
    this.W = new ArrayList();
    u.i("info", "info__bean = " + paramMinsuInitSearchBase.toString());
    if (this.V.size() <= 0) {
      this.a.findViewById(2131697495).setVisibility(8);
    }
    for (;;)
    {
      return;
      paramMinsuInitSearchBase = this.a.findViewById(2131697495);
      if (paramBoolean) {
        i1 = 0;
      }
      paramMinsuInitSearchBase.setVisibility(i1);
      paramMinsuInitSearchBase = (LinearLayout)this.a.findViewById(2131697497);
      paramMinsuInitSearchBase.removeAllViews();
      int i3 = this.V.size() / 3;
      i1 = 0;
      while (i1 < i3 + 1)
      {
        RelativeLayout localRelativeLayout = q();
        int i2 = 0;
        while (i2 < 3)
        {
          if (i1 * 3 + i2 < this.V.size())
          {
            CheckBox localCheckBox = a(i1, i2);
            this.W.add(localCheckBox);
            localRelativeLayout.addView(localCheckBox);
          }
          i2 += 1;
        }
        paramMinsuInitSearchBase.addView(localRelativeLayout);
        i1 += 1;
      }
    }
  }
  
  private void a(final c paramc)
  {
    if (!com.ziroom.ziroomcustomer.minsu.f.c.isNullList(this.y))
    {
      paramc.onSuccess();
      return;
    }
    com.ziroom.ziroomcustomer.minsu.e.a.getSort((Activity)this.e, com.ziroom.ziroomcustomer.minsu.b.c.a, new i.a()
    {
      public void onParse(String paramAnonymousString, k paramAnonymousk) {}
      
      public void onSuccess(k paramAnonymousk)
      {
        Object localObject = (MinsuSearchSortBean)paramAnonymousk.getObject();
        if ((paramAnonymousk.getSuccess().booleanValue()) && (localObject != null) && (((MinsuSearchSortBean)localObject).checkSuccessNoLogin()))
        {
          MinsuSearchTabLocaltionFragment.a(MinsuSearchTabLocaltionFragment.this, new ArrayList());
          paramAnonymousk = ((MinsuSearchSortBean)localObject).data.sortList.iterator();
          while (paramAnonymousk.hasNext())
          {
            localObject = (MinsuSearchSortBean.DataBean.SortListBean)paramAnonymousk.next();
            HashMap localHashMap = new HashMap();
            localHashMap.put("name", ((MinsuSearchSortBean.DataBean.SortListBean)localObject).name);
            localHashMap.put("code", ((MinsuSearchSortBean.DataBean.SortListBean)localObject).code);
            MinsuSearchTabLocaltionFragment.j(MinsuSearchTabLocaltionFragment.this).add(localHashMap);
          }
          paramc.onSuccess();
          return;
        }
        if (localObject == null) {}
        for (paramAnonymousk = null;; paramAnonymousk = ((MinsuSearchSortBean)localObject).message)
        {
          ad.shouErrorMessage(paramAnonymousk);
          return;
        }
      }
    });
  }
  
  private void a(final boolean paramBoolean)
  {
    Object localObject1 = this.a.findViewById(2131694316);
    if (paramBoolean) {}
    CheckBox localCheckBox;
    Object localObject2;
    for (int i1 = 0;; i1 = 8)
    {
      ((View)localObject1).setVisibility(i1);
      if (((this.V == null) || (this.W == null)) && ((this.Y == null) || (this.aa == null))) {
        break label208;
      }
      if ((this.V == null) || (this.W == null)) {
        break;
      }
      localObject1 = this.W.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localCheckBox = (CheckBox)((Iterator)localObject1).next();
        localObject2 = (MinsuInitSearchBase.DataBean.HouseTypeListBean)localCheckBox.getTag();
        localCheckBox.setChecked(this.U.contains(((MinsuInitSearchBase.DataBean.HouseTypeListBean)localObject2).getKey()));
      }
    }
    if ((this.Y != null) && (this.aa != null))
    {
      localObject1 = this.aa.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localCheckBox = (CheckBox)((Iterator)localObject1).next();
        localObject2 = (MinsuInitSearchBase.DataBean.LongTermLeaseDiscountBean.ValuesBean)localCheckBox.getTag();
        localCheckBox.setChecked(this.Z.contains(((MinsuInitSearchBase.DataBean.LongTermLeaseDiscountBean.ValuesBean)localObject2).getValue()));
        continue;
        label208:
        localObject1 = f.getInstance((Activity)this.e).getData();
        if (localObject1 == null) {
          break label239;
        }
        a((MinsuInitSearchBase)localObject1, paramBoolean);
        b((MinsuInitSearchBase)localObject1, paramBoolean);
      }
    }
    return;
    label239:
    f.getInstance((Activity)this.e).init(this.B.getCityCode(), new com.ziroom.ziroomcustomer.minsu.f.s((Activity)this.e, new com.freelxl.baselibrary.d.f.d(MinsuInitSearchBase.class))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        super.onFailure(paramAnonymousThrowable);
        if ("info__e.msg = " + paramAnonymousThrowable == null) {}
        for (paramAnonymousThrowable = "nul";; paramAnonymousThrowable = paramAnonymousThrowable.getMessage())
        {
          u.i("info", paramAnonymousThrowable);
          MinsuSearchTabLocaltionFragment.s(MinsuSearchTabLocaltionFragment.this).findViewById(2131697495).setVisibility(8);
          return;
        }
      }
      
      public void onSuccess(int paramAnonymousInt, MinsuInitSearchBase paramAnonymousMinsuInitSearchBase)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousMinsuInitSearchBase);
        if ((paramAnonymousMinsuInitSearchBase == null) || (!paramAnonymousMinsuInitSearchBase.checkSuccessNoLogin()) || (paramAnonymousMinsuInitSearchBase.getData() == null) || (paramAnonymousMinsuInitSearchBase.getData().getHouseTypeList() == null) || (paramAnonymousMinsuInitSearchBase.getData().getHouseTypeList().size() == 0)) {
          return;
        }
        MinsuSearchTabLocaltionFragment.a(MinsuSearchTabLocaltionFragment.this, paramAnonymousMinsuInitSearchBase, paramBoolean);
        MinsuSearchTabLocaltionFragment.b(MinsuSearchTabLocaltionFragment.this, paramAnonymousMinsuInitSearchBase, paramBoolean);
      }
    });
  }
  
  private void b(int paramInt)
  {
    boolean[] arrayOfBoolean = this.f;
    if ((paramInt == 0) && (this.f[0] == 0))
    {
      i1 = 1;
      arrayOfBoolean[0] = i1;
      arrayOfBoolean = this.f;
      if ((paramInt != 1) || (this.f[1] != 0)) {
        break label161;
      }
      i1 = 1;
      label45:
      arrayOfBoolean[1] = i1;
      arrayOfBoolean = this.f;
      if ((paramInt != 2) || (this.f[2] != 0)) {
        break label166;
      }
    }
    label161:
    label166:
    for (int i1 = 1;; i1 = 0)
    {
      arrayOfBoolean[2] = i1;
      a(this.h, this.f[0]);
      a(this.i, this.f[1]);
      a(this.j, this.f[2]);
      this.k.setSelected(this.f[0]);
      this.l.setSelected(this.f[1]);
      this.m.setSelected(this.f[2]);
      return;
      i1 = 0;
      break;
      i1 = 0;
      break label45;
    }
  }
  
  private void b(int paramInt1, int paramInt2)
  {
    u.e("rangbar", "left = " + paramInt1 + " -- " + paramInt2);
    this.N = paramInt1;
    this.O = paramInt2;
    c(paramInt1, paramInt2);
  }
  
  private void b(Bundle paramBundle)
  {
    if (paramBundle != null)
    {
      this.C = ((com.ziroom.ziroomcustomer.minsu.adapter.d)paramBundle.getSerializable("locationAdapter"));
      this.D = ((com.ziroom.ziroomcustomer.minsu.adapter.d)paramBundle.getSerializable("districtAdapter"));
      this.E = ((com.ziroom.ziroomcustomer.minsu.adapter.d)paramBundle.getSerializable("business_circleAdapter"));
      this.F = ((com.ziroom.ziroomcustomer.minsu.adapter.d)paramBundle.getSerializable("attractionsAdapter"));
      this.G = ((com.ziroom.ziroomcustomer.minsu.adapter.d)paramBundle.getSerializable("subwayAdapter"));
      this.H = ((com.ziroom.ziroomcustomer.minsu.adapter.d)paramBundle.getSerializable("subwayStationsAdapter"));
      this.I = ((com.ziroom.ziroomcustomer.minsu.adapter.d)paramBundle.getSerializable("sortAdapter"));
      this.z = paramBundle.getInt("selection", -1);
      this.A = paramBundle.getInt("lastSelection", -1);
      this.w = ((List)paramBundle.getSerializable("subwayStations"));
    }
  }
  
  private void b(View paramView)
  {
    this.am = ((CheckBox)paramView.findViewById(2131697501));
    this.an = ((CheckBox)paramView.findViewById(2131697502));
    this.ao = ((CheckBox)paramView.findViewById(2131697503));
    this.ap = ((CheckBox)paramView.findViewById(2131697504));
    this.aq = ((CheckBox)paramView.findViewById(2131697505));
    paramView = new b();
    this.am.setOnCheckedChangeListener(paramView);
    this.an.setOnCheckedChangeListener(paramView);
    this.ao.setOnCheckedChangeListener(paramView);
    this.ap.setOnCheckedChangeListener(paramView);
    this.aq.setOnCheckedChangeListener(paramView);
  }
  
  private void b(MinsuInitSearchBase paramMinsuInitSearchBase, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.X = paramMinsuInitSearchBase.getData().getLongTermLeaseDiscount();
      if (this.X != null)
      {
        this.aa = new ArrayList();
        this.Y = this.X.getValues();
        if (!com.ziroom.ziroomcustomer.util.s.isEmpty(this.Y)) {
          break label86;
        }
        this.a.findViewById(2131697474).setVisibility(8);
      }
      for (;;)
      {
        return;
        this.a.findViewById(2131697474).setVisibility(8);
        return;
        label86:
        this.a.findViewById(2131697474).setVisibility(0);
        ((TextView)this.a.findViewById(2131697475)).setText(this.X.getTitle());
        paramMinsuInitSearchBase = (LinearLayout)this.a.findViewById(2131697476);
        paramMinsuInitSearchBase.removeAllViews();
        int i1 = 0;
        while (i1 < this.Y.size())
        {
          RelativeLayout localRelativeLayout = (RelativeLayout)LayoutInflater.from(this.e).inflate(2130905115, null);
          TextView localTextView1 = (TextView)localRelativeLayout.findViewById(2131697506);
          TextView localTextView2 = (TextView)localRelativeLayout.findViewById(2131697507);
          CheckBox localCheckBox = (CheckBox)localRelativeLayout.findViewById(2131697508);
          localTextView1.setText(((MinsuInitSearchBase.DataBean.LongTermLeaseDiscountBean.ValuesBean)this.Y.get(i1)).getName());
          localTextView2.setText(((MinsuInitSearchBase.DataBean.LongTermLeaseDiscountBean.ValuesBean)this.Y.get(i1)).getTips());
          localCheckBox.setTag(this.Y.get(i1));
          localCheckBox.setChecked(this.Z.contains(((MinsuInitSearchBase.DataBean.LongTermLeaseDiscountBean.ValuesBean)this.Y.get(i1)).getValue()));
          localCheckBox.setOnCheckedChangeListener(this.M);
          paramMinsuInitSearchBase.addView(localRelativeLayout);
          this.aa.add(localCheckBox);
          i1 += 1;
        }
      }
    }
    this.a.findViewById(2131697474).setVisibility(8);
  }
  
  private void b(final c paramc)
  {
    if ((!com.ziroom.ziroomcustomer.minsu.f.c.isNullList(this.s)) && (!com.ziroom.ziroomcustomer.minsu.f.c.isNullList(this.t)) && (!com.ziroom.ziroomcustomer.minsu.f.c.isNullList(this.u)) && (!com.ziroom.ziroomcustomer.minsu.f.c.isNullList(this.v)))
    {
      paramc.onSuccess();
      return;
    }
    com.ziroom.ziroomcustomer.minsu.e.a.getLocationSort((Activity)this.e, com.ziroom.ziroomcustomer.minsu.b.c.a, new com.ziroom.ziroomcustomer.minsu.f.s((Activity)this.e, new com.freelxl.baselibrary.d.f.d(MinsuSearchConditionBean.class))
    {
      public void onSuccess(int paramAnonymousInt, MinsuSearchConditionBean paramAnonymousMinsuSearchConditionBean)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousMinsuSearchConditionBean);
        if ((paramAnonymousMinsuSearchConditionBean != null) && (paramAnonymousMinsuSearchConditionBean.checkSuccessNoLogin()))
        {
          MinsuSearchTabLocaltionFragment.c(MinsuSearchTabLocaltionFragment.this, new ArrayList());
          Object localObject1;
          Object localObject2;
          HashMap localHashMap;
          if ((paramAnonymousMinsuSearchConditionBean.data.district != null) && (paramAnonymousMinsuSearchConditionBean.data.district.districts != null) && (!paramAnonymousMinsuSearchConditionBean.data.district.districts.isEmpty()))
          {
            MinsuSearchTabLocaltionFragment.d(MinsuSearchTabLocaltionFragment.this, new ArrayList());
            localObject1 = paramAnonymousMinsuSearchConditionBean.data.district.districts.iterator();
            while (((Iterator)localObject1).hasNext())
            {
              localObject2 = (MinsuSearchConditionBean.DataBean.DistrictBean.DistrictsBean)((Iterator)localObject1).next();
              localHashMap = new HashMap();
              localHashMap.put("code", ((MinsuSearchConditionBean.DataBean.DistrictBean.DistrictsBean)localObject2).code);
              localHashMap.put("name", ((MinsuSearchConditionBean.DataBean.DistrictBean.DistrictsBean)localObject2).name);
              MinsuSearchTabLocaltionFragment.n(MinsuSearchTabLocaltionFragment.this).add(localHashMap);
            }
            localObject1 = new HashMap();
            ((Map)localObject1).put("name", paramAnonymousMinsuSearchConditionBean.data.district.name);
            ((Map)localObject1).put("code", Integer.valueOf(0));
            ((Map)localObject1).put("index", Integer.valueOf(paramAnonymousMinsuSearchConditionBean.data.district.index));
            MinsuSearchTabLocaltionFragment.b(MinsuSearchTabLocaltionFragment.this).add(localObject1);
          }
          if ((paramAnonymousMinsuSearchConditionBean.data.commercialRegion != null) && (paramAnonymousMinsuSearchConditionBean.data.commercialRegion.list != null) && (!paramAnonymousMinsuSearchConditionBean.data.commercialRegion.list.isEmpty()))
          {
            MinsuSearchTabLocaltionFragment.e(MinsuSearchTabLocaltionFragment.this, new ArrayList());
            localObject1 = paramAnonymousMinsuSearchConditionBean.data.commercialRegion.list.iterator();
            while (((Iterator)localObject1).hasNext())
            {
              localObject2 = (String)((Iterator)localObject1).next();
              localHashMap = new HashMap();
              localHashMap.put("code", localObject2);
              localHashMap.put("name", localObject2);
              MinsuSearchTabLocaltionFragment.d(MinsuSearchTabLocaltionFragment.this).add(localHashMap);
            }
            localObject1 = new HashMap();
            ((Map)localObject1).put("name", paramAnonymousMinsuSearchConditionBean.data.commercialRegion.name);
            ((Map)localObject1).put("code", Integer.valueOf(1));
            ((Map)localObject1).put("index", Integer.valueOf(paramAnonymousMinsuSearchConditionBean.data.commercialRegion.index));
            MinsuSearchTabLocaltionFragment.b(MinsuSearchTabLocaltionFragment.this).add(localObject1);
          }
          if ((paramAnonymousMinsuSearchConditionBean.data.sceneryRegion != null) && (paramAnonymousMinsuSearchConditionBean.data.sceneryRegion.list != null) && (!paramAnonymousMinsuSearchConditionBean.data.sceneryRegion.list.isEmpty()))
          {
            MinsuSearchTabLocaltionFragment.f(MinsuSearchTabLocaltionFragment.this, new ArrayList());
            localObject1 = paramAnonymousMinsuSearchConditionBean.data.sceneryRegion.list.iterator();
            while (((Iterator)localObject1).hasNext())
            {
              localObject2 = (String)((Iterator)localObject1).next();
              localHashMap = new HashMap();
              localHashMap.put("code", localObject2);
              localHashMap.put("name", localObject2);
              MinsuSearchTabLocaltionFragment.h(MinsuSearchTabLocaltionFragment.this).add(localHashMap);
            }
            localObject1 = new HashMap();
            ((Map)localObject1).put("name", paramAnonymousMinsuSearchConditionBean.data.sceneryRegion.name);
            ((Map)localObject1).put("code", Integer.valueOf(2));
            ((Map)localObject1).put("index", Integer.valueOf(paramAnonymousMinsuSearchConditionBean.data.sceneryRegion.index));
            MinsuSearchTabLocaltionFragment.b(MinsuSearchTabLocaltionFragment.this).add(localObject1);
          }
          if ((paramAnonymousMinsuSearchConditionBean.data.subway != null) && (paramAnonymousMinsuSearchConditionBean.data.subway.list != null) && (!paramAnonymousMinsuSearchConditionBean.data.subway.list.isEmpty()))
          {
            MinsuSearchTabLocaltionFragment.g(MinsuSearchTabLocaltionFragment.this, new ArrayList());
            localObject1 = paramAnonymousMinsuSearchConditionBean.data.subway.list.iterator();
            while (((Iterator)localObject1).hasNext())
            {
              localObject2 = (MinsuSearchConditionBean.DataBean.SubwayBean.ListBean)((Iterator)localObject1).next();
              localHashMap = new HashMap();
              localHashMap.put("code", ((MinsuSearchConditionBean.DataBean.SubwayBean.ListBean)localObject2).stations);
              localHashMap.put("lineFid", ((MinsuSearchConditionBean.DataBean.SubwayBean.ListBean)localObject2).lineFid);
              localHashMap.put("name", ((MinsuSearchConditionBean.DataBean.SubwayBean.ListBean)localObject2).name);
              MinsuSearchTabLocaltionFragment.p(MinsuSearchTabLocaltionFragment.this).add(localHashMap);
            }
            localObject1 = new HashMap();
            ((Map)localObject1).put("name", paramAnonymousMinsuSearchConditionBean.data.subway.name);
            ((Map)localObject1).put("code", Integer.valueOf(3));
            ((Map)localObject1).put("index", Integer.valueOf(paramAnonymousMinsuSearchConditionBean.data.subway.index));
            MinsuSearchTabLocaltionFragment.b(MinsuSearchTabLocaltionFragment.this).add(localObject1);
          }
          paramAnonymousMinsuSearchConditionBean = new MinsuSearchTabLocaltionFragment.a(MinsuSearchTabLocaltionFragment.this);
          Collections.sort(MinsuSearchTabLocaltionFragment.b(MinsuSearchTabLocaltionFragment.this), paramAnonymousMinsuSearchConditionBean);
          paramc.onSuccess();
          return;
        }
        if (paramAnonymousMinsuSearchConditionBean == null) {}
        for (paramAnonymousMinsuSearchConditionBean = null;; paramAnonymousMinsuSearchConditionBean = paramAnonymousMinsuSearchConditionBean.message)
        {
          ad.shouErrorMessage(paramAnonymousMinsuSearchConditionBean);
          return;
        }
      }
    });
  }
  
  private void b(String paramString)
  {
    if (this.ar.length() == 0)
    {
      this.ar.append(paramString);
      return;
    }
    this.ar.append(",");
    this.ar.append(paramString);
  }
  
  private void c()
  {
    this.as = getArguments().getString("from");
    d();
    f();
  }
  
  private void c(int paramInt)
  {
    this.g.setVisibility(0);
    switch (paramInt)
    {
    default: 
      return;
    case 6: 
      this.o.setVisibility(0);
      a(false);
      return;
    case 4: 
      this.o.setVisibility(8);
      a(true);
      return;
    case 5: 
      this.o.setVisibility(0);
      a(false);
      this.b.setVisibility(0);
      this.c.setVisibility(8);
      this.d.setVisibility(8);
      return;
    case 0: 
      this.o.setVisibility(0);
      a(false);
      this.b.setVisibility(0);
      this.c.setVisibility(0);
      this.d.setVisibility(8);
      localLayoutParams = new LinearLayout.LayoutParams(-2, -1, 3.0F);
      localLayoutParams.weight = 2.0F;
      this.b.setLayoutParams(localLayoutParams);
      localLayoutParams = new LinearLayout.LayoutParams(-2, -1, 17.0F);
      localLayoutParams.weight = 1.0F;
      this.c.setLayoutParams(localLayoutParams);
      return;
    case 1: 
      this.o.setVisibility(0);
      a(false);
      this.b.setVisibility(0);
      this.c.setVisibility(0);
      this.d.setVisibility(8);
      localLayoutParams = new LinearLayout.LayoutParams(-2, -1, 3.0F);
      localLayoutParams.weight = 2.0F;
      this.b.setLayoutParams(localLayoutParams);
      localLayoutParams = new LinearLayout.LayoutParams(-2, -1, 17.0F);
      localLayoutParams.weight = 1.0F;
      this.c.setLayoutParams(localLayoutParams);
      return;
    case 2: 
      this.o.setVisibility(0);
      a(false);
      this.b.setVisibility(0);
      this.c.setVisibility(0);
      this.d.setVisibility(8);
      localLayoutParams = new LinearLayout.LayoutParams(-2, -1, 3.0F);
      localLayoutParams.weight = 2.0F;
      this.b.setLayoutParams(localLayoutParams);
      localLayoutParams = new LinearLayout.LayoutParams(-2, -1, 17.0F);
      localLayoutParams.weight = 1.0F;
      this.c.setLayoutParams(localLayoutParams);
      return;
    case 3: 
      this.o.setVisibility(0);
      a(false);
      this.b.setVisibility(0);
      this.c.setVisibility(0);
      this.d.setVisibility(0);
      localLayoutParams = new LinearLayout.LayoutParams(-2, -1, 17.0F);
      localLayoutParams.weight = 1.0F;
      this.b.setLayoutParams(localLayoutParams);
      localLayoutParams = new LinearLayout.LayoutParams(-2, -1, 17.0F);
      localLayoutParams.weight = 1.0F;
      this.c.setLayoutParams(localLayoutParams);
      localLayoutParams = new LinearLayout.LayoutParams(-2, -1, 17.0F);
      localLayoutParams.weight = 1.0F;
      this.d.setLayoutParams(localLayoutParams);
      return;
    }
    this.o.setVisibility(0);
    a(false);
    this.b.setVisibility(0);
    this.c.setVisibility(0);
    this.d.setVisibility(0);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -1, 17.0F);
    localLayoutParams.weight = 1.0F;
    this.b.setLayoutParams(localLayoutParams);
    localLayoutParams = new LinearLayout.LayoutParams(-2, -1, 17.0F);
    localLayoutParams.weight = 1.0F;
    this.c.setLayoutParams(localLayoutParams);
    localLayoutParams = new LinearLayout.LayoutParams(-2, -1, 17.0F);
    localLayoutParams.weight = 1.0F;
    this.d.setLayoutParams(localLayoutParams);
  }
  
  private void c(int paramInt1, int paramInt2)
  {
    this.ac.setText(d(paramInt1, paramInt2));
  }
  
  private void c(View paramView)
  {
    paramView.findViewById(2131697478).setOnClickListener(this);
    d locald = new d();
    this.ae = ((CheckBox)paramView.findViewById(2131697481));
    this.ae.setOnCheckedChangeListener(locald);
  }
  
  private void c(String paramString)
  {
    if ("0".equals(paramString))
    {
      this.af.setChecked(true);
      this.ah.setChecked(false);
      return;
    }
    if ("1".equals(paramString))
    {
      this.ag.setChecked(true);
      return;
    }
    if (("0,1".equals(paramString)) || ("1,0".equals(paramString)))
    {
      this.ag.setChecked(true);
      this.af.setChecked(true);
      return;
    }
    this.af.setChecked(false);
    this.ag.setChecked(false);
  }
  
  private String d(int paramInt1, int paramInt2)
  {
    if (((paramInt1 == 0) || (paramInt1 == -1)) && ((paramInt2 == 120) || (paramInt2 == -1))) {
      return this.e.getString(2131297339);
    }
    if ((paramInt1 == 0) || (paramInt1 == -1)) {
      return this.e.getString(2131297340).replace("price", paramInt2 * 10 + "");
    }
    if ((paramInt2 == 120) || (paramInt2 == -1)) {
      return this.e.getString(2131297341).replace("price", paramInt1 * 10 + "");
    }
    return this.e.getString(2131297342).replace("min", "" + paramInt1 * 10).replace("max", "" + paramInt2 * 10);
  }
  
  private void d()
  {
    e();
    this.b = ((ListView)this.a.findViewById(2131694313));
    this.c = ((ListView)this.a.findViewById(2131694314));
    this.d = ((ListView)this.a.findViewById(2131694315));
    this.g = ((LinearLayout)this.a.findViewById(2131691838));
    this.h = ((LinearLayout)this.a.findViewById(2131694308));
    this.i = ((LinearLayout)this.a.findViewById(2131690325));
    this.j = ((LinearLayout)this.a.findViewById(2131694310));
    this.q = ((LinearLayout)this.a.findViewById(2131694307));
    this.k = ((TextView)this.a.findViewById(2131694309));
    this.l = ((TextView)this.a.findViewById(2131690326));
    this.m = ((TextView)this.a.findViewById(2131690900));
    this.n = ((TextView)this.a.findViewById(2131690175));
    this.o = ((LinearLayout)this.a.findViewById(2131694312));
    this.p = ((LinearLayout)this.a.findViewById(2131694306));
    o();
  }
  
  private void d(int paramInt)
  {
    this.z = paramInt;
  }
  
  private String e(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 0: 
      return this.k.getText().toString();
    case 1: 
      return this.l.getText().toString();
    }
    return this.m.getText().toString();
  }
  
  private void e()
  {
    this.K = ((CommonTitle)this.a.findViewById(2131691272));
    CommonTitle localCommonTitle = (CommonTitle)this.a.findViewById(2131691272);
    localCommonTitle.setMiddleText(k(this.J));
    localCommonTitle.showRightText(false, null);
    localCommonTitle.setLeftButtonType(4);
    localCommonTitle.setBottomLineVisible(false);
    localCommonTitle.setMiddleText(k(this.J));
    localCommonTitle.setOnLeftButtonClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        MinsuSearchTabLocaltionFragment.this.getActivity().setResult(0);
        MinsuSearchTabLocaltionFragment.this.getActivity().finish();
      }
    });
  }
  
  private int f(int paramInt)
  {
    return ad.dp2px(this.e, paramInt);
  }
  
  private void f()
  {
    this.h.setOnClickListener(this);
    this.i.setOnClickListener(this);
    this.j.setOnClickListener(this);
  }
  
  private void g()
  {
    a(new c()
    {
      public void onSuccess()
      {
        if (MinsuSearchTabLocaltionFragment.i(MinsuSearchTabLocaltionFragment.this) == null) {
          MinsuSearchTabLocaltionFragment.d(MinsuSearchTabLocaltionFragment.this, new com.ziroom.ziroomcustomer.minsu.adapter.d(MinsuSearchTabLocaltionFragment.j(MinsuSearchTabLocaltionFragment.this), d.a.b));
        }
        MinsuSearchTabLocaltionFragment.m(MinsuSearchTabLocaltionFragment.this).setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
          @Instrumented
          public void onItemClick(AdapterView<?> paramAnonymous2AdapterView, View paramAnonymous2View, int paramAnonymous2Int, long paramAnonymous2Long)
          {
            VdsAgent.onItemClick(this, paramAnonymous2AdapterView, paramAnonymous2View, paramAnonymous2Int, paramAnonymous2Long);
            MinsuSearchTabLocaltionFragment.i(MinsuSearchTabLocaltionFragment.this).setSelectedPosition(paramAnonymous2Int);
            paramAnonymous2AdapterView = (String)((Map)MinsuSearchTabLocaltionFragment.j(MinsuSearchTabLocaltionFragment.this).get(paramAnonymous2Int)).get("code");
            MinsuSearchTabLocaltionFragment.k(MinsuSearchTabLocaltionFragment.this).setText((String)((Map)MinsuSearchTabLocaltionFragment.j(MinsuSearchTabLocaltionFragment.this).get(paramAnonymous2Int)).get("name"));
            v.onClick(MinsuSearchTabLocaltionFragment.l(MinsuSearchTabLocaltionFragment.this), "M-Search_sort" + (paramAnonymous2Int + 1));
            MinsuSearchTabLocaltionFragment.e(MinsuSearchTabLocaltionFragment.this).setSortType(paramAnonymous2AdapterView);
            com.ziroom.ziroomcustomer.minsu.searchlist.base.c.getInstance().setSortPosition(paramAnonymous2Int);
            com.ziroom.ziroomcustomer.minsu.searchlist.base.c.getInstance().setSortPositionName((String)((Map)MinsuSearchTabLocaltionFragment.j(MinsuSearchTabLocaltionFragment.this).get(paramAnonymous2Int)).get("name"));
            MinsuSearchTabLocaltionFragment.this.getData(0);
          }
        });
        int i = com.ziroom.ziroomcustomer.minsu.searchlist.base.c.getInstance().getSortPosition();
        MinsuSearchTabLocaltionFragment.i(MinsuSearchTabLocaltionFragment.this).setSelectedPosition(i);
        MinsuSearchTabLocaltionFragment.i(MinsuSearchTabLocaltionFragment.this).notifyDataSetChanged();
        MinsuSearchTabLocaltionFragment.m(MinsuSearchTabLocaltionFragment.this).setAdapter(MinsuSearchTabLocaltionFragment.i(MinsuSearchTabLocaltionFragment.this));
      }
    });
  }
  
  private void g(int paramInt)
  {
    if ((paramInt & 0x2) != 0) {
      this.am.setChecked(true);
    }
    if ((paramInt & 0x4) != 0) {
      this.an.setChecked(true);
    }
    if ((paramInt & 0x8) != 0) {
      this.ao.setChecked(true);
    }
    if ((paramInt & 0x10) != 0) {
      this.ap.setChecked(true);
    }
    if ((paramInt & 0x1) != 0) {
      this.aq.setChecked(true);
    }
  }
  
  private void h()
  {
    if (com.ziroom.ziroomcustomer.minsu.f.c.isNullList(this.s))
    {
      g.textToast(this.e, "暂无数据,请稍后重试");
      this.c.setVisibility(4);
      return;
    }
    if (this.D == null)
    {
      this.D = new com.ziroom.ziroomcustomer.minsu.adapter.d(this.s, d.a.a);
      this.c.setOnItemClickListener(new AdapterView.OnItemClickListener()
      {
        @Instrumented
        public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          VdsAgent.onItemClick(this, paramAnonymousAdapterView, paramAnonymousView, paramAnonymousInt, paramAnonymousLong);
          MinsuSearchTabLocaltionFragment.b(MinsuSearchTabLocaltionFragment.this, paramAnonymousInt);
          MinsuSearchTabLocaltionFragment.a(MinsuSearchTabLocaltionFragment.this, MinsuSearchTabLocaltionFragment.c(MinsuSearchTabLocaltionFragment.this, MinsuSearchTabLocaltionFragment.a(MinsuSearchTabLocaltionFragment.this).getSelectedPosition()));
          paramAnonymousAdapterView = (String)((Map)MinsuSearchTabLocaltionFragment.n(MinsuSearchTabLocaltionFragment.this).get(paramAnonymousInt)).get("code");
          MinsuSearchTabLocaltionFragment.f(MinsuSearchTabLocaltionFragment.this).setText(((Map)MinsuSearchTabLocaltionFragment.n(MinsuSearchTabLocaltionFragment.this).get(paramAnonymousInt)).get("name") + "");
          MinsuSearchTabLocaltionFragment.e(MinsuSearchTabLocaltionFragment.this).setAreaCode(paramAnonymousAdapterView);
          MinsuSearchTabLocaltionFragment.e(MinsuSearchTabLocaltionFragment.this).setLineFid(null);
          MinsuSearchTabLocaltionFragment.e(MinsuSearchTabLocaltionFragment.this).setHotReginScenic("");
          MinsuSearchTabLocaltionFragment.e(MinsuSearchTabLocaltionFragment.this).setHotReginBusiness("");
          MinsuSearchTabLocaltionFragment.e(MinsuSearchTabLocaltionFragment.this).setLineFid("");
          MinsuSearchTabLocaltionFragment.this.getData(0);
        }
      });
      this.c.setAdapter(this.D);
      return;
    }
    if (this.A == 0)
    {
      int i1 = n();
      if (i1 >= 0) {
        this.D.setSelectedPosition(i1);
      }
    }
    for (;;)
    {
      this.D.notifyDataSetChanged();
      break;
      this.D.setSelectedPosition(-1);
    }
  }
  
  private void h(int paramInt)
  {
    if (this.P == paramInt) {}
    do
    {
      return;
      this.P = paramInt;
      if (paramInt == 1)
      {
        this.ae.setChecked(true);
        return;
      }
      if (paramInt == 2)
      {
        this.ae.setChecked(false);
        return;
      }
    } while (paramInt != -1);
    this.ae.setChecked(false);
  }
  
  private void i()
  {
    if (com.ziroom.ziroomcustomer.minsu.f.c.isNullList(this.t))
    {
      g.textToast(this.e, "暂无数据,请稍后重试");
      this.c.setVisibility(4);
      return;
    }
    if (this.E == null) {
      this.E = new com.ziroom.ziroomcustomer.minsu.adapter.d(this.t, d.a.a);
    }
    for (;;)
    {
      this.c.setOnItemClickListener(new AdapterView.OnItemClickListener()
      {
        @Instrumented
        public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          VdsAgent.onItemClick(this, paramAnonymousAdapterView, paramAnonymousView, paramAnonymousInt, paramAnonymousLong);
          MinsuSearchTabLocaltionFragment.b(MinsuSearchTabLocaltionFragment.this, paramAnonymousInt);
          MinsuSearchTabLocaltionFragment.a(MinsuSearchTabLocaltionFragment.this, MinsuSearchTabLocaltionFragment.c(MinsuSearchTabLocaltionFragment.this, MinsuSearchTabLocaltionFragment.a(MinsuSearchTabLocaltionFragment.this).getSelectedPosition()));
          paramAnonymousAdapterView = (String)((Map)MinsuSearchTabLocaltionFragment.d(MinsuSearchTabLocaltionFragment.this).get(paramAnonymousInt)).get("code");
          MinsuSearchTabLocaltionFragment.f(MinsuSearchTabLocaltionFragment.this).setText(((Map)MinsuSearchTabLocaltionFragment.d(MinsuSearchTabLocaltionFragment.this).get(paramAnonymousInt)).get("name") + "");
          MinsuSearchTabLocaltionFragment.e(MinsuSearchTabLocaltionFragment.this).setHotReginBusiness(paramAnonymousAdapterView);
          MinsuSearchTabLocaltionFragment.e(MinsuSearchTabLocaltionFragment.this).setAreaCode("");
          MinsuSearchTabLocaltionFragment.e(MinsuSearchTabLocaltionFragment.this).setHotReginScenic("");
          MinsuSearchTabLocaltionFragment.e(MinsuSearchTabLocaltionFragment.this).setLineFid("");
          MinsuSearchTabLocaltionFragment.this.getData(0);
        }
      });
      this.c.setAdapter(this.E);
      return;
      if (this.A == 1)
      {
        int i1 = n();
        if (i1 >= 0) {
          this.E.setSelectedPosition(i1);
        }
        this.E.notifyDataSetChanged();
      }
      else
      {
        this.E.setSelectedPosition(-1);
      }
    }
  }
  
  private void i(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      v.onClick(this.e, "M-Search_positionxingzheng");
      return;
    case 1: 
      v.onClick(this.e, "M-Search_positionshangquan");
      return;
    case 2: 
      v.onClick(this.e, "M-Search_positionjingdian");
      return;
    }
    v.onClick(this.e, "M-Search_positionmetro");
  }
  
  private int j(int paramInt)
  {
    return ((Integer)((Map)this.x.get(paramInt)).get("code")).intValue();
  }
  
  private void j()
  {
    if (com.ziroom.ziroomcustomer.minsu.f.c.isNullList(this.u))
    {
      g.textToast(this.e, "暂无数据,请稍后重试");
      this.c.setVisibility(4);
      return;
    }
    if (this.F == null)
    {
      this.F = new com.ziroom.ziroomcustomer.minsu.adapter.d(this.u, d.a.a);
      this.c.setOnItemClickListener(new AdapterView.OnItemClickListener()
      {
        @Instrumented
        public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          VdsAgent.onItemClick(this, paramAnonymousAdapterView, paramAnonymousView, paramAnonymousInt, paramAnonymousLong);
          MinsuSearchTabLocaltionFragment.b(MinsuSearchTabLocaltionFragment.this, paramAnonymousInt);
          MinsuSearchTabLocaltionFragment.a(MinsuSearchTabLocaltionFragment.this, MinsuSearchTabLocaltionFragment.c(MinsuSearchTabLocaltionFragment.this, MinsuSearchTabLocaltionFragment.a(MinsuSearchTabLocaltionFragment.this).getSelectedPosition()));
          paramAnonymousAdapterView = (String)((Map)MinsuSearchTabLocaltionFragment.h(MinsuSearchTabLocaltionFragment.this).get(paramAnonymousInt)).get("code");
          MinsuSearchTabLocaltionFragment.f(MinsuSearchTabLocaltionFragment.this).setText(((Map)MinsuSearchTabLocaltionFragment.h(MinsuSearchTabLocaltionFragment.this).get(paramAnonymousInt)).get("name") + "");
          MinsuSearchTabLocaltionFragment.e(MinsuSearchTabLocaltionFragment.this).setHotReginScenic(paramAnonymousAdapterView);
          MinsuSearchTabLocaltionFragment.e(MinsuSearchTabLocaltionFragment.this).setAreaCode("");
          MinsuSearchTabLocaltionFragment.e(MinsuSearchTabLocaltionFragment.this).setHotReginBusiness("");
          MinsuSearchTabLocaltionFragment.e(MinsuSearchTabLocaltionFragment.this).setLineFid("");
          MinsuSearchTabLocaltionFragment.this.getData(0);
        }
      });
      this.c.setAdapter(this.F);
      return;
    }
    if (this.A == 2)
    {
      int i1 = n();
      if (i1 >= 0) {
        this.F.setSelectedPosition(i1);
      }
    }
    for (;;)
    {
      this.F.notifyDataSetChanged();
      break;
      this.F.setSelectedPosition(-1);
    }
  }
  
  private String k(int paramInt)
  {
    if (paramInt >= 3) {
      return "";
    }
    return new String[] { "位置", "更多筛选", "排序" }[paramInt];
  }
  
  private void k()
  {
    if (com.ziroom.ziroomcustomer.minsu.f.c.isNullList(this.v))
    {
      g.textToast(this.e, "暂无数据,请稍后重试");
      this.c.setVisibility(4);
      return;
    }
    if (this.G == null) {
      this.G = new com.ziroom.ziroomcustomer.minsu.adapter.d(this.v, d.a.b);
    }
    for (;;)
    {
      this.c.setOnItemClickListener(new AdapterView.OnItemClickListener()
      {
        @Instrumented
        public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          VdsAgent.onItemClick(this, paramAnonymousAdapterView, paramAnonymousView, paramAnonymousInt, paramAnonymousLong);
          MinsuSearchTabLocaltionFragment.o(MinsuSearchTabLocaltionFragment.this).setSelectedPosition(paramAnonymousInt);
          MinsuSearchTabLocaltionFragment.a(MinsuSearchTabLocaltionFragment.this, MinsuSearchTabLocaltionFragment.c(MinsuSearchTabLocaltionFragment.this, MinsuSearchTabLocaltionFragment.a(MinsuSearchTabLocaltionFragment.this).getSelectedPosition()));
          MinsuSearchTabLocaltionFragment.b(MinsuSearchTabLocaltionFragment.this, paramAnonymousInt);
          if ((MinsuSearchTabLocaltionFragment.p(MinsuSearchTabLocaltionFragment.this) != null) && (MinsuSearchTabLocaltionFragment.p(MinsuSearchTabLocaltionFragment.this).size() > paramAnonymousInt))
          {
            MinsuSearchTabLocaltionFragment.b(MinsuSearchTabLocaltionFragment.this, new ArrayList());
            Object localObject = (List)((Map)MinsuSearchTabLocaltionFragment.p(MinsuSearchTabLocaltionFragment.this).get(paramAnonymousInt)).get("code");
            paramAnonymousAdapterView = (String)((Map)MinsuSearchTabLocaltionFragment.p(MinsuSearchTabLocaltionFragment.this).get(paramAnonymousInt)).get("lineFid");
            paramAnonymousView = (String)((Map)MinsuSearchTabLocaltionFragment.p(MinsuSearchTabLocaltionFragment.this).get(paramAnonymousInt)).get("name");
            localObject = ((List)localObject).iterator();
            while (((Iterator)localObject).hasNext())
            {
              MinsuSearchConditionBean.DataBean.SubwayBean.ListBean.StationsBean localStationsBean = (MinsuSearchConditionBean.DataBean.SubwayBean.ListBean.StationsBean)((Iterator)localObject).next();
              HashMap localHashMap = new HashMap();
              localHashMap.put("name", localStationsBean.name);
              localHashMap.put("code", localStationsBean.code + "");
              localHashMap.put("lineFid", paramAnonymousAdapterView);
              localHashMap.put("lineName", paramAnonymousView);
              MinsuSearchTabLocaltionFragment.q(MinsuSearchTabLocaltionFragment.this).add(localHashMap);
            }
            MinsuSearchTabLocaltionFragment.e(MinsuSearchTabLocaltionFragment.this, null);
            MinsuSearchTabLocaltionFragment.d(MinsuSearchTabLocaltionFragment.this, 7);
          }
        }
      });
      this.c.setAdapter(this.G);
      return;
      if (this.A == 3)
      {
        int i1 = n();
        if (i1 >= 0) {
          this.G.setSelectedPosition(i1);
        }
        this.G.notifyDataSetChanged();
        if (this.w != null) {
          l();
        }
      }
      else
      {
        this.G.setSelectedPosition(-1);
        if (this.H != null)
        {
          this.H.setSelectedPosition(-1);
          this.H.notifyDataSetChanged();
        }
      }
    }
  }
  
  private void l()
  {
    if (com.ziroom.ziroomcustomer.minsu.f.c.isNullList(this.w))
    {
      g.textToast(this.e, "无地铁站点,请稍后重试!");
      return;
    }
    if (this.H == null) {
      this.H = new com.ziroom.ziroomcustomer.minsu.adapter.d(this.w, d.a.b);
    }
    this.d.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      @Instrumented
      public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        VdsAgent.onItemClick(this, paramAnonymousAdapterView, paramAnonymousView, paramAnonymousInt, paramAnonymousLong);
        MinsuSearchTabLocaltionFragment.r(MinsuSearchTabLocaltionFragment.this).setSelectedPosition(paramAnonymousInt);
        paramAnonymousAdapterView = (Map)MinsuSearchTabLocaltionFragment.q(MinsuSearchTabLocaltionFragment.this).get(paramAnonymousInt);
        if (Integer.parseInt(paramAnonymousAdapterView.get("code").toString()) == 0)
        {
          MinsuSearchTabLocaltionFragment.e(MinsuSearchTabLocaltionFragment.this).setLineFid((String)paramAnonymousAdapterView.get("lineFid"));
          MinsuSearchTabLocaltionFragment.f(MinsuSearchTabLocaltionFragment.this).setText((String)paramAnonymousAdapterView.get("lineName"));
        }
        for (;;)
        {
          MinsuSearchTabLocaltionFragment.e(MinsuSearchTabLocaltionFragment.this).setAreaCode("");
          MinsuSearchTabLocaltionFragment.e(MinsuSearchTabLocaltionFragment.this).setHotReginScenic("");
          MinsuSearchTabLocaltionFragment.e(MinsuSearchTabLocaltionFragment.this).setHotReginBusiness("");
          MinsuSearchTabLocaltionFragment.this.getData(0);
          return;
          MinsuSearchTabLocaltionFragment.e(MinsuSearchTabLocaltionFragment.this).setLineFid("");
          MinsuSearchTabLocaltionFragment.f(MinsuSearchTabLocaltionFragment.this).setText((String)paramAnonymousAdapterView.get("name"));
        }
      }
    });
    int i1 = this.H.getSelectedPosition();
    if (i1 >= 0) {
      this.H.setSelectedPosition(i1);
    }
    this.d.setAdapter(this.H);
  }
  
  private void m()
  {
    b(new c()
    {
      public void onSuccess()
      {
        if ((MinsuSearchTabLocaltionFragment.b(MinsuSearchTabLocaltionFragment.this) == null) || (MinsuSearchTabLocaltionFragment.b(MinsuSearchTabLocaltionFragment.this).size() <= 0)) {
          return;
        }
        if (MinsuSearchTabLocaltionFragment.a(MinsuSearchTabLocaltionFragment.this) == null) {
          MinsuSearchTabLocaltionFragment.a(MinsuSearchTabLocaltionFragment.this, new com.ziroom.ziroomcustomer.minsu.adapter.d(MinsuSearchTabLocaltionFragment.b(MinsuSearchTabLocaltionFragment.this), d.a.b));
        }
        MinsuSearchTabLocaltionFragment.m(MinsuSearchTabLocaltionFragment.this).setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
          @Instrumented
          public void onItemClick(AdapterView<?> paramAnonymous2AdapterView, View paramAnonymous2View, int paramAnonymous2Int, long paramAnonymous2Long)
          {
            VdsAgent.onItemClick(this, paramAnonymous2AdapterView, paramAnonymous2View, paramAnonymous2Int, paramAnonymous2Long);
            if ((!com.ziroom.ziroomcustomer.minsu.f.c.isNullList(MinsuSearchTabLocaltionFragment.b(MinsuSearchTabLocaltionFragment.this))) && (MinsuSearchTabLocaltionFragment.b(MinsuSearchTabLocaltionFragment.this).size() > paramAnonymous2Int))
            {
              paramAnonymous2AdapterView = (Integer)((Map)MinsuSearchTabLocaltionFragment.b(MinsuSearchTabLocaltionFragment.this).get(paramAnonymous2Int)).get("code");
              MinsuSearchTabLocaltionFragment.d(MinsuSearchTabLocaltionFragment.this, paramAnonymous2AdapterView.intValue());
            }
            MinsuSearchTabLocaltionFragment.a(MinsuSearchTabLocaltionFragment.this).setSelectedPosition(paramAnonymous2Int);
            MinsuSearchTabLocaltionFragment.e(MinsuSearchTabLocaltionFragment.this, paramAnonymous2Int);
          }
        });
        MinsuSearchTabLocaltionFragment.m(MinsuSearchTabLocaltionFragment.this).setAdapter(MinsuSearchTabLocaltionFragment.a(MinsuSearchTabLocaltionFragment.this));
        int j = MinsuSearchTabLocaltionFragment.a(MinsuSearchTabLocaltionFragment.this).getSelectedPosition();
        int i = j;
        if (j == -1) {
          i = 0;
        }
        MinsuSearchTabLocaltionFragment.a(MinsuSearchTabLocaltionFragment.this).setSelectedPosition(i);
        Integer localInteger = (Integer)((Map)MinsuSearchTabLocaltionFragment.b(MinsuSearchTabLocaltionFragment.this).get(i)).get("code");
        MinsuSearchTabLocaltionFragment.d(MinsuSearchTabLocaltionFragment.this, localInteger.intValue());
      }
    });
  }
  
  private int n()
  {
    return this.z;
  }
  
  public static MinsuSearchTabLocaltionFragment newInstance(Bundle paramBundle)
  {
    MinsuSearchTabLocaltionFragment localMinsuSearchTabLocaltionFragment = new MinsuSearchTabLocaltionFragment();
    Bundle localBundle = paramBundle;
    if (paramBundle == null) {
      localBundle = new Bundle();
    }
    localMinsuSearchTabLocaltionFragment.setArguments(localBundle);
    return localMinsuSearchTabLocaltionFragment;
  }
  
  private void o()
  {
    s();
    t();
    a(this.a);
    b(this.a);
    c(this.a);
    u();
    p();
  }
  
  private void p()
  {
    if ((this.B != null) && (this.a != null) && ((!com.ziroom.ziroomcustomer.minsu.f.c.isNull(this.B.getMultiRentWay())) || (!com.ziroom.ziroomcustomer.minsu.f.c.isNull(com.ziroom.ziroomcustomer.minsu.searchlist.base.c.getInstance().getIsLandTogether())) || (!com.ziroom.ziroomcustomer.minsu.f.c.isNull(this.B.getPriceStart())) || (!com.ziroom.ziroomcustomer.minsu.f.c.isNull(this.B.getPriceEnd())) || (!com.ziroom.ziroomcustomer.minsu.f.c.isNull(this.B.getOrderType())) || (!com.ziroom.ziroomcustomer.minsu.f.c.isNull(this.B.getPersonCount())) || (!com.ziroom.ziroomcustomer.minsu.f.c.isNull(this.B.getRoomCount())) || (!com.ziroom.ziroomcustomer.minsu.f.c.isNull(this.B.getHouseType())) || (!com.ziroom.ziroomcustomer.minsu.f.c.isNull(this.B.getLongTermDiscount())) || (!com.ziroom.ziroomcustomer.minsu.f.c.isNull(this.B.getJiaxinDiscount())))) {
      resetView();
    }
  }
  
  private RelativeLayout q()
  {
    RelativeLayout localRelativeLayout = new RelativeLayout(this.e);
    new RelativeLayout.LayoutParams(-1, -2);
    localRelativeLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
    localRelativeLayout.setFocusable(true);
    localRelativeLayout.setFocusableInTouchMode(true);
    return localRelativeLayout;
  }
  
  private void r()
  {
    this.ar.delete(0, this.ar.length());
    if ((this.af.isChecked()) || (this.ag.isChecked())) {}
    for (int i1 = 1;; i1 = 0)
    {
      if (this.af.isChecked()) {
        b("0");
      }
      if (this.ag.isChecked()) {
        b("1");
      }
      int i2;
      int i4;
      if (this.ar.length() > 0)
      {
        this.B.setMultiRentWay(this.ar.toString());
        i2 = i1;
        if (com.ziroom.ziroomcustomer.minsu.searchlist.base.c.getInstance().getIsLandTogether() != null)
        {
          i2 = i1;
          if (com.ziroom.ziroomcustomer.minsu.searchlist.base.c.getInstance().getIsLandTogether().intValue() == 1) {
            i2 = i1 + 1;
          }
        }
        if (this.P == -1) {
          break label444;
        }
        this.B.setOrderType(Integer.valueOf(this.P));
        i4 = i2 + 1;
        label153:
        if (!this.am.isChecked()) {
          break label820;
        }
        i2 = 2;
      }
      for (int i3 = 1;; i3 = 0)
      {
        i1 = i2;
        if (this.an.isChecked())
        {
          i1 = i2 | 0x4;
          i3 = 1;
        }
        i2 = i1;
        if (this.ao.isChecked())
        {
          i2 = i1 | 0x8;
          i3 = 1;
        }
        i1 = i2;
        if (this.ap.isChecked())
        {
          i1 = i2 | 0x10;
          i3 = 1;
        }
        i2 = i1;
        if (this.aq.isChecked())
        {
          i2 = i1 | 0x1;
          i3 = 1;
        }
        label256:
        Object localObject1;
        Object localObject2;
        Object localObject3;
        if (i2 > 0)
        {
          this.B.setRoomCount(Integer.valueOf(i2));
          localObject1 = "-1";
          if (this.N == -1) {
            break label469;
          }
          this.B.setPriceStart(Integer.valueOf(this.N * 10 * 100));
          localObject2 = String.valueOf(this.N * 10);
          localObject1 = localObject2;
          if (this.N == 0) {
            break label477;
          }
          i1 = 1;
          localObject3 = localObject2;
          label318:
          if (this.O == -1) {
            break label511;
          }
          localObject1 = String.valueOf(this.O * 10);
          if (this.O * 10 != 1200) {
            break label486;
          }
          this.B.setPriceEnd(null);
        }
        Object localObject4;
        for (;;)
        {
          i1 = i4 + i3 + i1;
          if (this.U.size() == 0) {
            break label626;
          }
          localObject2 = new StringBuilder();
          localObject4 = this.U.iterator();
          while (((Iterator)localObject4).hasNext()) {
            ((StringBuilder)localObject2).append((String)((Iterator)localObject4).next()).append(",");
          }
          this.B.setMultiRentWay(null);
          break;
          label444:
          this.B.setOrderType(null);
          i4 = i2;
          break label153;
          this.B.setRoomCount(null);
          break label256;
          label469:
          this.B.setPriceStart(null);
          label477:
          i1 = 0;
          localObject3 = localObject1;
          break label318;
          label486:
          this.B.setPriceEnd(Integer.valueOf(this.O * 10 * 100));
          i1 = 1;
          continue;
          label511:
          this.B.setPriceEnd(null);
          localObject1 = "-1";
        }
        this.B.setHouseType(((StringBuilder)localObject2).substring(0, ((StringBuilder)localObject2).length() - 1));
        i1 += 1;
        if (this.Z.size() > 0)
        {
          StringBuilder localStringBuilder = new StringBuilder();
          Iterator localIterator = this.Z.iterator();
          localObject2 = null;
          label586:
          if (localIterator.hasNext())
          {
            localObject4 = (String)localIterator.next();
            if ("ProductRulesEnum020001".equals(localObject4)) {
              localObject2 = localObject4;
            }
            for (;;)
            {
              break label586;
              label626:
              this.B.setHouseType(null);
              break;
              localStringBuilder.append((String)localObject4).append(",");
            }
          }
          if (!TextUtils.isEmpty((CharSequence)localObject2))
          {
            this.B.setJiaxinDiscount((String)localObject2);
            if (localStringBuilder.length() <= 0) {
              break label784;
            }
            this.B.setLongTermDiscount(localStringBuilder.substring(0, localStringBuilder.length() - 1));
            label699:
            i1 += 1;
          }
        }
        for (;;)
        {
          v.onClick(this.e, "M-Search_pricechose", "start=" + (String)localObject3 + "&end=" + (String)localObject1);
          if (!"map".equals(this.as)) {
            break label814;
          }
          org.greenrobot.eventbus.c.getDefault().post(new b(-1));
          return;
          this.B.setJiaxinDiscount(null);
          break;
          label784:
          this.B.setLongTermDiscount(null);
          break label699;
          this.B.setLongTermDiscount(null);
          this.B.setJiaxinDiscount(null);
        }
        label814:
        getData(i1);
        return;
        label820:
        i2 = 0;
      }
    }
  }
  
  private void s()
  {
    this.ad = ((TextView)this.a.findViewById(2131690826));
    this.ad.setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        MinsuSearchTabLocaltionFragment.v(MinsuSearchTabLocaltionFragment.this);
      }
    });
  }
  
  private void t()
  {
    this.ab = ((RangeBar)this.a.findViewById(2131691679));
    this.ac = ((TextView)this.a.findViewById(2131697305));
    this.ab.setTickCount(121);
    this.ab.setTickHeight(0.0F);
    this.ab.setConnectingLineWeight(1.0F);
    int[] arrayOfInt = new int[5];
    int[] tmp66_64 = arrayOfInt;
    tmp66_64[0] = 2131697469;
    int[] tmp72_66 = tmp66_64;
    tmp72_66[1] = 2131697470;
    int[] tmp78_72 = tmp72_66;
    tmp78_72[2] = 2131697471;
    int[] tmp84_78 = tmp78_72;
    tmp84_78[3] = 2131697472;
    int[] tmp90_84 = tmp84_78;
    tmp90_84[4] = 2131697473;
    tmp90_84;
    float f1 = ab.length((TextView)this.a.findViewById(2131697469), "¥5000");
    int i2 = arrayOfInt.length;
    int i1 = 0;
    while (i1 < i2)
    {
      int i3 = arrayOfInt[i1];
      ab.width(this.a.findViewById(i3), (int)(f1 + 0.5D));
      i1 += 1;
    }
    ((TextView)this.a.findViewById(2131697470)).setText("¥300");
    ((TextView)this.a.findViewById(2131697471)).setText("¥600");
    ((TextView)this.a.findViewById(2131697472)).setText("¥900");
    this.ab.setOnRangeBarChangeListener(new RangeBar.a()
    {
      public void onIndexChangeListener(RangeBar paramAnonymousRangeBar, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        MinsuSearchTabLocaltionFragment.a(MinsuSearchTabLocaltionFragment.this, paramAnonymousInt1, paramAnonymousInt2);
      }
    });
    this.N = -1;
    this.O = -1;
  }
  
  private void u()
  {
    this.at = ((LinearLayout)this.a.findViewById(2131691636));
    if ("map".equals(this.as))
    {
      this.K.setVisibility(8);
      this.at.setVisibility(0);
      this.ad.setVisibility(8);
      this.au = ((TextView)this.a.findViewById(2131691637));
      this.av = ((TextView)this.a.findViewById(2131691638));
      this.au.setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          MinsuSearchTabLocaltionFragment.e(MinsuSearchTabLocaltionFragment.this).clearMinsuMapFilter();
          MinsuSearchTabLocaltionFragment.this.reStoreMapUI();
          org.greenrobot.eventbus.c.getDefault().post(new b(11));
        }
      });
      this.av.setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          MinsuSearchTabLocaltionFragment.v(MinsuSearchTabLocaltionFragment.this);
        }
      });
      return;
    }
    this.at.setVisibility(8);
    this.ad.setVisibility(0);
  }
  
  protected void a(Context paramContext, String paramString)
  {
    super.a(paramContext, paramString);
  }
  
  public void closeView()
  {
    this.f[0] = false;
    this.f[1] = false;
    this.f[2] = false;
    a(this.h, this.f[0]);
    a(this.i, this.f[1]);
    a(this.j, this.f[2]);
    toggle(false);
  }
  
  public void getData(int paramInt)
  {
    Intent localIntent = new Intent();
    Bundle localBundle = new Bundle();
    localBundle.putInt("index", this.J);
    localBundle.putInt("confCount", paramInt);
    localBundle.putString("text", e(this.J));
    localIntent.putExtras(a(localBundle));
    getActivity().setResult(-1, localIntent);
    getActivity().finish();
  }
  
  public void initData(int paramInt)
  {
    this.J = paramInt;
    this.B = com.ziroom.ziroomcustomer.minsu.searchlist.base.c.getInstance();
  }
  
  public void initData(MinsuSearchHouseInfoBean paramMinsuSearchHouseInfoBean, int paramInt)
  {
    this.J = paramInt;
    this.B = com.ziroom.ziroomcustomer.minsu.searchlist.base.c.getInstance();
  }
  
  @Instrumented
  public void onClick(View paramView)
  {
    VdsAgent.onClick(this, paramView);
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131694308: 
      b(0);
      if (this.f[0] != 0)
      {
        a(6);
        return;
      }
      toggle(false);
      return;
    case 2131690325: 
      b(1);
      if (this.f[1] != 0)
      {
        a(4);
        return;
      }
      toggle(false);
      return;
    }
    b(2);
    if (this.f[2] != 0)
    {
      a(5);
      return;
    }
    toggle(false);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = getArguments();
    if (paramBundle != null) {
      b(paramBundle);
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    this.e = getActivity();
    this.a = paramLayoutInflater.inflate(2130903966, paramViewGroup, false);
    return this.a;
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    c();
    if (this.J != -1) {}
    switch (this.J)
    {
    default: 
      return;
    case 0: 
      a(6);
      return;
    case 1: 
      a(4);
      return;
    }
    a(5);
  }
  
  public void reStoreMapUI()
  {
    resetMoreView();
    a(true);
  }
  
  public void resetMoreView()
  {
    int i3 = -1;
    int i2 = 0;
    if ((this.B != null) && (this.a != null))
    {
      c(this.B.getMultiRentWay());
      if ((com.ziroom.ziroomcustomer.minsu.searchlist.base.c.getInstance().getIsLandTogether() != null) && (com.ziroom.ziroomcustomer.minsu.searchlist.base.c.getInstance().getIsLandTogether().intValue() == 1))
      {
        this.ah.setChecked(true);
        this.af.setChecked(false);
        if (this.B.getPriceStart() != null) {
          break label285;
        }
        i1 = -1;
        label79:
        this.N = i1;
        if (this.B.getPriceEnd() != null) {
          break label305;
        }
        i1 = -1;
        label96:
        this.O = i1;
        if (this.N <= -1) {
          this.N = 0;
        }
        if (this.O <= -1) {
          this.O = 120;
        }
        this.ab.setThumbIndices(this.N, this.O);
        c(this.N, this.O);
        if (this.B.getOrderType() != null) {
          break label325;
        }
        i1 = i3;
        label167:
        h(i1);
        if (this.B.getRoomCount() != null) {
          break label339;
        }
      }
      String[] arrayOfString;
      String str;
      label285:
      label305:
      label325:
      label339:
      for (int i1 = 0;; i1 = this.B.getRoomCount().intValue())
      {
        g(i1);
        if (com.ziroom.ziroomcustomer.minsu.f.c.isNull(this.B.getHouseType())) {
          break label353;
        }
        if (this.U.size() != 0) {
          this.U.clear();
        }
        arrayOfString = this.B.getHouseType().split(",");
        i3 = arrayOfString.length;
        i1 = 0;
        while (i1 < i3)
        {
          str = arrayOfString[i1];
          this.U.add(str);
          i1 += 1;
        }
        this.ah.setChecked(false);
        break;
        i1 = this.B.getPriceStart().intValue() / 100 / 10;
        break label79;
        i1 = this.B.getPriceEnd().intValue() / 100 / 10;
        break label96;
        i1 = this.B.getOrderType().intValue();
        break label167;
      }
      label353:
      this.U.clear();
      this.Z.clear();
      if (!com.ziroom.ziroomcustomer.minsu.f.c.isNull(this.B.getLongTermDiscount()))
      {
        arrayOfString = this.B.getLongTermDiscount().split(",");
        i3 = arrayOfString.length;
        i1 = i2;
        while (i1 < i3)
        {
          str = arrayOfString[i1];
          this.Z.add(str);
          i1 += 1;
        }
      }
      if (!com.ziroom.ziroomcustomer.minsu.f.c.isNull(this.B.getJiaxinDiscount())) {
        this.Z.add(this.B.getJiaxinDiscount());
      }
    }
  }
  
  public void resetTab()
  {
    d(-1);
    if (this.C != null) {
      this.C.setSelectedPosition(0);
    }
    if (this.I != null) {
      this.I.setSelectedPosition(-1);
    }
    if (this.D != null) {
      this.D.setSelectedPosition(-1);
    }
    if (this.E != null) {
      this.E.setSelectedPosition(-1);
    }
    if (this.F != null) {
      this.F.setSelectedPosition(-1);
    }
    if (this.G != null) {
      this.G.setSelectedPosition(-1);
    }
    if (this.H != null) {
      this.H.setSelectedPosition(-1);
    }
  }
  
  public void resetText()
  {
    this.k.setText("位置");
    this.l.setText("筛选");
    this.m.setText("排序");
  }
  
  public void resetView()
  {
    if ((this.B != null) && (this.a != null))
    {
      c(this.B.getMultiRentWay());
      if ((com.ziroom.ziroomcustomer.minsu.searchlist.base.c.getInstance().getIsLandTogether() != null) && (com.ziroom.ziroomcustomer.minsu.searchlist.base.c.getInstance().getIsLandTogether().intValue() == 1))
      {
        this.ah.setChecked(true);
        this.af.setChecked(false);
        if ((!com.ziroom.ziroomcustomer.minsu.f.c.isNull(this.B.getPriceStart())) || (!com.ziroom.ziroomcustomer.minsu.f.c.isNull(this.B.getPriceEnd())))
        {
          if (this.B.getPriceStart() != null) {
            break label363;
          }
          i1 = -1;
          label101:
          this.N = i1;
          if (this.B.getPriceEnd() != null) {
            break label383;
          }
        }
      }
      String[] arrayOfString;
      int i2;
      String str;
      label363:
      label383:
      for (int i1 = -1;; i1 = this.B.getPriceEnd().intValue() / 100 / 10)
      {
        this.O = i1;
        if (this.N <= -1) {
          this.N = 0;
        }
        if (this.O <= -1) {
          this.O = 120;
        }
        this.ab.setThumbIndices(this.N, this.O);
        if ((!com.ziroom.ziroomcustomer.minsu.f.c.isNull(this.B.getPriceStart())) || (!com.ziroom.ziroomcustomer.minsu.f.c.isNull(this.B.getPriceEnd()))) {
          c(this.N, this.O);
        }
        if ((!com.ziroom.ziroomcustomer.minsu.f.c.isNull(this.B.getOrderType())) && (this.B.getOrderType().intValue() != 0)) {
          h(this.B.getOrderType().intValue());
        }
        if (!com.ziroom.ziroomcustomer.minsu.f.c.isNull(this.B.getRoomCount())) {
          g(this.B.getRoomCount().intValue());
        }
        if (com.ziroom.ziroomcustomer.minsu.f.c.isNull(this.B.getHouseType())) {
          break label403;
        }
        if (this.U.size() != 0) {
          this.U.clear();
        }
        arrayOfString = this.B.getHouseType().split(",");
        i2 = arrayOfString.length;
        i1 = 0;
        while (i1 < i2)
        {
          str = arrayOfString[i1];
          this.U.add(str);
          i1 += 1;
        }
        this.ah.setChecked(false);
        break;
        i1 = this.B.getPriceStart().intValue() / 100 / 10;
        break label101;
      }
      label403:
      this.U.clear();
      this.Z.clear();
      if (!com.ziroom.ziroomcustomer.minsu.f.c.isNull(this.B.getLongTermDiscount()))
      {
        arrayOfString = this.B.getLongTermDiscount().split(",");
        i2 = arrayOfString.length;
        i1 = 0;
        while (i1 < i2)
        {
          str = arrayOfString[i1];
          this.Z.add(str);
          i1 += 1;
        }
      }
      if (!com.ziroom.ziroomcustomer.minsu.f.c.isNull(this.B.getJiaxinDiscount())) {
        this.Z.add(this.B.getJiaxinDiscount());
      }
    }
  }
  
  public void setData(final MinsuSearchHouseInfoBean paramMinsuSearchHouseInfoBean)
  {
    resetView();
    paramMinsuSearchHouseInfoBean = this.B.getHotReginBusiness();
    if (!ae.isNull(paramMinsuSearchHouseInfoBean)) {
      b(new c()
      {
        public void onSuccess()
        {
          int j = 0;
          MinsuSearchTabLocaltionFragment.a(MinsuSearchTabLocaltionFragment.this, 1);
          if (MinsuSearchTabLocaltionFragment.a(MinsuSearchTabLocaltionFragment.this) == null) {
            MinsuSearchTabLocaltionFragment.a(MinsuSearchTabLocaltionFragment.this, new com.ziroom.ziroomcustomer.minsu.adapter.d(MinsuSearchTabLocaltionFragment.b(MinsuSearchTabLocaltionFragment.this), d.a.b));
          }
          int i = 0;
          while (i < MinsuSearchTabLocaltionFragment.b(MinsuSearchTabLocaltionFragment.this).size())
          {
            if (Integer.parseInt(((Map)MinsuSearchTabLocaltionFragment.b(MinsuSearchTabLocaltionFragment.this).get(i)).get("code").toString()) == 1) {
              MinsuSearchTabLocaltionFragment.a(MinsuSearchTabLocaltionFragment.this).setSelectedPosition(i);
            }
            i += 1;
          }
          i = j;
          if (MinsuSearchTabLocaltionFragment.c(MinsuSearchTabLocaltionFragment.this) == null)
          {
            MinsuSearchTabLocaltionFragment.b(MinsuSearchTabLocaltionFragment.this, new com.ziroom.ziroomcustomer.minsu.adapter.d(MinsuSearchTabLocaltionFragment.d(MinsuSearchTabLocaltionFragment.this), d.a.a));
            i = j;
          }
          while (i < MinsuSearchTabLocaltionFragment.d(MinsuSearchTabLocaltionFragment.this).size())
          {
            if (paramMinsuSearchHouseInfoBean.equals(((Map)MinsuSearchTabLocaltionFragment.d(MinsuSearchTabLocaltionFragment.this).get(i)).get("name")))
            {
              MinsuSearchTabLocaltionFragment.e(MinsuSearchTabLocaltionFragment.this).setHotReginBusiness(((Map)MinsuSearchTabLocaltionFragment.d(MinsuSearchTabLocaltionFragment.this).get(i)).get("code") + "");
              MinsuSearchTabLocaltionFragment.f(MinsuSearchTabLocaltionFragment.this).setText(((Map)MinsuSearchTabLocaltionFragment.d(MinsuSearchTabLocaltionFragment.this).get(i)).get("name") + "");
              MinsuSearchTabLocaltionFragment.c(MinsuSearchTabLocaltionFragment.this).setSelectedPosition(i);
              MinsuSearchTabLocaltionFragment.b(MinsuSearchTabLocaltionFragment.this, i);
            }
            i += 1;
          }
        }
      });
    }
    paramMinsuSearchHouseInfoBean = this.B.getHotReginScenic();
    if (!ae.isNull(paramMinsuSearchHouseInfoBean)) {
      b(new c()
      {
        public void onSuccess()
        {
          int j = 0;
          MinsuSearchTabLocaltionFragment.a(MinsuSearchTabLocaltionFragment.this, 2);
          if (MinsuSearchTabLocaltionFragment.a(MinsuSearchTabLocaltionFragment.this) == null) {
            MinsuSearchTabLocaltionFragment.a(MinsuSearchTabLocaltionFragment.this, new com.ziroom.ziroomcustomer.minsu.adapter.d(MinsuSearchTabLocaltionFragment.b(MinsuSearchTabLocaltionFragment.this), d.a.b));
          }
          int i = 0;
          while (i < MinsuSearchTabLocaltionFragment.b(MinsuSearchTabLocaltionFragment.this).size())
          {
            if (Integer.parseInt(((Map)MinsuSearchTabLocaltionFragment.b(MinsuSearchTabLocaltionFragment.this).get(i)).get("code").toString()) == 2) {
              MinsuSearchTabLocaltionFragment.a(MinsuSearchTabLocaltionFragment.this).setSelectedPosition(i);
            }
            i += 1;
          }
          i = j;
          if (MinsuSearchTabLocaltionFragment.g(MinsuSearchTabLocaltionFragment.this) == null)
          {
            MinsuSearchTabLocaltionFragment.c(MinsuSearchTabLocaltionFragment.this, new com.ziroom.ziroomcustomer.minsu.adapter.d(MinsuSearchTabLocaltionFragment.h(MinsuSearchTabLocaltionFragment.this), d.a.a));
            i = j;
          }
          while (i < MinsuSearchTabLocaltionFragment.h(MinsuSearchTabLocaltionFragment.this).size())
          {
            if (paramMinsuSearchHouseInfoBean.equals(((Map)MinsuSearchTabLocaltionFragment.h(MinsuSearchTabLocaltionFragment.this).get(i)).get("name")))
            {
              MinsuSearchTabLocaltionFragment.e(MinsuSearchTabLocaltionFragment.this).setHotReginBusiness(((Map)MinsuSearchTabLocaltionFragment.h(MinsuSearchTabLocaltionFragment.this).get(i)).get("code") + "");
              MinsuSearchTabLocaltionFragment.f(MinsuSearchTabLocaltionFragment.this).setText(((Map)MinsuSearchTabLocaltionFragment.h(MinsuSearchTabLocaltionFragment.this).get(i)).get("name") + "");
              MinsuSearchTabLocaltionFragment.g(MinsuSearchTabLocaltionFragment.this).setSelectedPosition(i);
              MinsuSearchTabLocaltionFragment.b(MinsuSearchTabLocaltionFragment.this, i);
            }
            i += 1;
          }
        }
      });
    }
  }
  
  public void setNoDataView(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.n.setVisibility(0);
      this.g.setVisibility(8);
      return;
    }
    this.n.setVisibility(8);
  }
  
  public void toggle(boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      this.r = false;
      if ((this.g != null) && (this.g.getVisibility() == 0))
      {
        this.g.setVisibility(8);
        b(4);
      }
      return;
    }
    this.r = true;
    this.g.setVisibility(0);
  }
  
  public class a
    implements Comparator
  {
    public a() {}
    
    public int compare(Object paramObject1, Object paramObject2)
    {
      paramObject1 = (Map)paramObject1;
      paramObject2 = (Map)paramObject2;
      return ((Integer)((Map)paramObject1).get("index")).compareTo((Integer)((Map)paramObject2).get("index"));
    }
  }
  
  class b
    implements CompoundButton.OnCheckedChangeListener
  {
    b() {}
    
    @Instrumented
    public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
    {
      VdsAgent.onCheckedChanged(this, paramCompoundButton, paramBoolean);
      Object localObject = null;
      switch (paramCompoundButton.getId())
      {
      default: 
        paramCompoundButton = (CompoundButton)localObject;
      }
      for (;;)
      {
        v.onClick(MinsuSearchTabLocaltionFragment.l(MinsuSearchTabLocaltionFragment.this), paramCompoundButton);
        return;
        paramCompoundButton = "M-Search_oneroom";
        continue;
        paramCompoundButton = "M-Search_tworoom";
        continue;
        paramCompoundButton = "M-Search_threeroom";
        continue;
        paramCompoundButton = "M-Search_fourroom";
        continue;
        paramCompoundButton = "M-Search_fourplusroom";
      }
    }
  }
  
  public static abstract interface c
  {
    public abstract void onSuccess();
  }
  
  public class d
    implements CompoundButton.OnCheckedChangeListener
  {
    public d() {}
    
    @Instrumented
    public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
    {
      VdsAgent.onCheckedChanged(this, paramCompoundButton, paramBoolean);
      if (paramBoolean) {
        switch (paramCompoundButton.getId())
        {
        }
      }
      while (MinsuSearchTabLocaltionFragment.w(MinsuSearchTabLocaltionFragment.this).isChecked())
      {
        return;
        MinsuSearchTabLocaltionFragment.f(MinsuSearchTabLocaltionFragment.this, 1);
        v.onClick(MinsuSearchTabLocaltionFragment.this.getContext(), "M-Real_time_order");
        return;
      }
      MinsuSearchTabLocaltionFragment.f(MinsuSearchTabLocaltionFragment.this, -1);
    }
  }
  
  public class e
    implements CompoundButton.OnCheckedChangeListener
  {
    public e() {}
    
    @Instrumented
    public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
    {
      VdsAgent.onCheckedChanged(this, paramCompoundButton, paramBoolean);
      if (paramBoolean)
      {
        switch (paramCompoundButton.getId())
        {
        case 2131697490: 
        default: 
          return;
        case 2131697486: 
          MinsuSearchTabLocaltionFragment.x(MinsuSearchTabLocaltionFragment.this).setChecked(false);
          MinsuSearchTabLocaltionFragment.x(MinsuSearchTabLocaltionFragment.this).setClickable(false);
          MinsuSearchTabLocaltionFragment.x(MinsuSearchTabLocaltionFragment.this).setAlpha(0.5F);
          MinsuSearchTabLocaltionFragment.y(MinsuSearchTabLocaltionFragment.this).setTextColor(Color.parseColor("#7f999999"));
          MinsuSearchTabLocaltionFragment.z(MinsuSearchTabLocaltionFragment.this).setTextColor(Color.parseColor("#7f999999"));
          com.ziroom.ziroomcustomer.minsu.searchlist.base.c.getInstance().setIsLandTogether(null);
          return;
        }
        MinsuSearchTabLocaltionFragment.A(MinsuSearchTabLocaltionFragment.this).setChecked(false);
        MinsuSearchTabLocaltionFragment.A(MinsuSearchTabLocaltionFragment.this).setClickable(false);
        MinsuSearchTabLocaltionFragment.B(MinsuSearchTabLocaltionFragment.this).setTextColor(Color.parseColor("#7f999999"));
        MinsuSearchTabLocaltionFragment.C(MinsuSearchTabLocaltionFragment.this).setTextColor(Color.parseColor("#7f999999"));
        com.ziroom.ziroomcustomer.minsu.searchlist.base.c.getInstance().setIsLandTogether(Integer.valueOf(1));
        return;
      }
      switch (paramCompoundButton.getId())
      {
      case 2131697490: 
      default: 
        return;
      case 2131697486: 
        MinsuSearchTabLocaltionFragment.x(MinsuSearchTabLocaltionFragment.this).setClickable(true);
        MinsuSearchTabLocaltionFragment.x(MinsuSearchTabLocaltionFragment.this).setAlpha(1.0F);
        MinsuSearchTabLocaltionFragment.y(MinsuSearchTabLocaltionFragment.this).setTextColor(Color.parseColor("#444444"));
        MinsuSearchTabLocaltionFragment.z(MinsuSearchTabLocaltionFragment.this).setTextColor(Color.parseColor("#999999"));
        return;
      }
      MinsuSearchTabLocaltionFragment.A(MinsuSearchTabLocaltionFragment.this).setClickable(true);
      com.ziroom.ziroomcustomer.minsu.searchlist.base.c.getInstance().setIsLandTogether(null);
      MinsuSearchTabLocaltionFragment.B(MinsuSearchTabLocaltionFragment.this).setTextColor(Color.parseColor("#444444"));
      MinsuSearchTabLocaltionFragment.C(MinsuSearchTabLocaltionFragment.this).setTextColor(Color.parseColor("#999999"));
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/fragment/MinsuSearchTabLocaltionFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */