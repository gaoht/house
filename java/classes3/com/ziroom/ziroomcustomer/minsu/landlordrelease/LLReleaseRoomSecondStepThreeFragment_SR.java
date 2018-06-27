package com.ziroom.ziroomcustomer.minsu.landlordrelease;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.ViewGroup;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
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
import com.ziroom.ziroomcustomer.minsu.f.aa;
import com.ziroom.ziroomcustomer.minsu.landlordrelease.base.BaseLandlordReleaseFragment;
import com.ziroom.ziroomcustomer.minsu.landlordrelease.model.AloneRoomBedTypeListDataBean;
import com.ziroom.ziroomcustomer.minsu.landlordrelease.model.SaveAloneRoomInitInfoBean;
import com.ziroom.ziroomcustomer.minsu.landlordrelease.model.SaveAloneRoomInitInfoBean.SaveAloneRoomData;
import com.ziroom.ziroomcustomer.minsu.landlordrelease.model.SingleChoseBean;
import com.ziroom.ziroomcustomer.minsu.landlordrelease.model.aloneroominfo.AloneRoomAreaBean;
import com.ziroom.ziroomcustomer.minsu.landlordrelease.model.aloneroominfo.AloneRoomBedTypeListBean;
import com.ziroom.ziroomcustomer.minsu.landlordrelease.model.aloneroominfo.AloneRoomBedTypeMsgListBean;
import com.ziroom.ziroomcustomer.minsu.landlordrelease.model.aloneroominfo.AloneRoomInitInfoBean;
import com.ziroom.ziroomcustomer.minsu.landlordrelease.model.aloneroominfo.AloneRoomInitInfoDataBean;
import com.ziroom.ziroomcustomer.minsu.landlordrelease.model.aloneroominfo.AloneRoomInitInfoDataBean.AloneRoomCleaningFeesBean;
import com.ziroom.ziroomcustomer.minsu.landlordrelease.model.aloneroominfo.AloneRoomInitInfoDataBean.AloneRoomLeasePriceBean;
import com.ziroom.ziroomcustomer.minsu.landlordrelease.model.aloneroominfo.AloneRoomInitInfoDataBean.AloneRoomSevenDiscountRateBean;
import com.ziroom.ziroomcustomer.minsu.landlordrelease.model.aloneroominfo.AloneRoomInitInfoDataBean.AloneRoomThirtyDiscountRateBean;
import com.ziroom.ziroomcustomer.minsu.landlordrelease.model.aloneroominfo.AloneRoomInitInfoDataBean.AloneRoomWeekendPriceBean;
import com.ziroom.ziroomcustomer.minsu.landlordrelease.model.aloneroominfo.AloneRoomLimitPersonListBean;
import com.ziroom.ziroomcustomer.minsu.landlordrelease.model.aloneroominfo.AloneRoomLimitPersonListBean.AloneRoomLimitPersonListDataBean;
import com.ziroom.ziroomcustomer.minsu.landlordrelease.model.aloneroominfo.AloneRoomNameBean;
import com.ziroom.ziroomcustomer.minsu.landlordrelease.model.houseprice.WeekendListBean;
import com.ziroom.ziroomcustomer.minsu.landlordrelease.model.houseprice.WeekendListBean.WeekendLisDataBean;
import com.ziroom.ziroomcustomer.minsu.landlordrelease.view.c.a;
import com.ziroom.ziroomcustomer.newServiceList.view.LimitEditText;
import com.ziroom.ziroomcustomer.widget.ListViewForScrollView;
import com.ziroom.ziroomcustomer.widget.ObservableScrollView;
import com.ziroom.ziroomcustomer.widget.ObservableScrollView.a;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class LLReleaseRoomSecondStepThreeFragment_SR
  extends BaseLandlordReleaseFragment
  implements View.OnClickListener, com.ziroom.ziroomcustomer.minsu.landlordrelease.base.a
{
  private String A;
  private int B;
  private int C;
  private int D;
  private int E;
  private int F;
  private String G;
  private double H;
  private double I;
  private int J;
  private int K;
  private TextView L;
  private Integer M;
  private String N;
  private String O;
  private AloneRoomInitInfoDataBean.AloneRoomLeasePriceBean P;
  private AloneRoomInitInfoDataBean.AloneRoomWeekendPriceBean Q;
  private AloneRoomInitInfoDataBean.AloneRoomSevenDiscountRateBean R;
  private AloneRoomInitInfoDataBean.AloneRoomThirtyDiscountRateBean S;
  private WeekendListBean T;
  private AloneRoomInitInfoDataBean.AloneRoomCleaningFeesBean U;
  private int V;
  private List<AloneRoomBedTypeMsgListBean> W;
  private int X;
  private boolean Y = false;
  private boolean Z = false;
  private String aa;
  private Integer ab;
  private List<AloneRoomBedTypeListDataBean> ac;
  private com.ziroom.ziroomcustomer.minsu.landlordrelease.view.c ad;
  private TextView ae;
  private boolean af = false;
  private boolean ag = false;
  private boolean ah = false;
  private boolean ai = false;
  private boolean aj = false;
  private int ak;
  private int al;
  protected TextView b;
  protected TextView c;
  protected TextView d;
  protected TextView e;
  private ImageView f;
  private View g;
  private ObservableScrollView h;
  private LimitEditText i;
  private EditText j;
  private TextView k;
  private RelativeLayout l;
  private RelativeLayout m;
  private TextView n;
  private TextView o;
  private TextView p;
  private ListViewForScrollView q;
  private com.ziroom.ziroomcustomer.minsu.landlordrelease.d.c r;
  private com.ziroom.ziroomcustomer.minsu.landlordrelease.a.b s;
  private Activity t;
  private AloneRoomInitInfoBean u;
  private RelativeLayout v;
  private AloneRoomBedTypeListBean w;
  private List<SingleChoseBean> x = new ArrayList();
  private List<AloneRoomLimitPersonListBean.AloneRoomLimitPersonListDataBean> y;
  private String z;
  
  private com.ziroom.ziroomcustomer.minsu.landlordrelease.view.c a(String paramString, List<SingleChoseBean> paramList, c.a parama)
  {
    paramString = new com.ziroom.ziroomcustomer.minsu.landlordrelease.view.c(this.t, paramString, parama, paramList);
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
  
  private void d(String paramString)
  {
    Object localObject = new StringBuilder();
    if (this.D != 0) {
      ((StringBuilder)localObject).append("基础价格：" + this.D + "元/晚").append("\n");
    }
    if ((this.J == 1) && (this.F != 0) && (!TextUtils.isEmpty(this.O))) {
      ((StringBuilder)localObject).append(this.O + "：" + this.F + "元/晚").append("\n");
    }
    if (this.K == 1)
    {
      if (this.H != 0.0D) {
        ((StringBuilder)localObject).append("满7天折扣：" + this.H + "折").append("\n");
      }
      if (this.I != 0.0D) {
        ((StringBuilder)localObject).append("满30天折扣：" + this.I + "折").append("\n");
      }
    }
    if (this.E != 0) {
      ((StringBuilder)localObject).append("清洁费：").append(this.E).append("元").append("\n");
    }
    if (((StringBuilder)localObject).length() <= 0)
    {
      this.L.setHint("请填写基础价格、周末价格、长期住宿折扣、清洁费等");
      this.L.setTextColor(Color.parseColor("#999999"));
    }
    do
    {
      return;
      localObject = ((StringBuilder)localObject).subSequence(0, ((StringBuilder)localObject).length() - 1).toString();
      this.L.setText((CharSequence)localObject);
      this.L.setTextColor(Color.parseColor("#444444"));
    } while (!paramString.equals("first"));
    aa.putString(this.t, "roomPrice", (String)localObject);
  }
  
  private void m()
  {
    this.f.setOnClickListener(this);
    this.b.setOnClickListener(this);
    this.l.setOnClickListener(this);
    this.m.setOnClickListener(this);
    this.o.setOnClickListener(this);
    this.f.setOnClickListener(this);
    this.h.setOnScrollChangedCallback(new ObservableScrollView.a()
    {
      public void onScroll(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        float f = paramAnonymousInt2 / 100.0F;
        LLReleaseRoomSecondStepThreeFragment_SR.a(LLReleaseRoomSecondStepThreeFragment_SR.this).setAlpha(f);
      }
    });
  }
  
  private void n()
  {
    this.z = k();
    this.A = j();
    this.B = h();
    this.C = 1;
  }
  
  public static LLReleaseRoomSecondStepThreeFragment_SR newInstance()
  {
    Bundle localBundle = new Bundle();
    LLReleaseRoomSecondStepThreeFragment_SR localLLReleaseRoomSecondStepThreeFragment_SR = new LLReleaseRoomSecondStepThreeFragment_SR();
    localLLReleaseRoomSecondStepThreeFragment_SR.setArguments(localBundle);
    return localLLReleaseRoomSecondStepThreeFragment_SR;
  }
  
  private void o()
  {
    this.r = new com.ziroom.ziroomcustomer.minsu.landlordrelease.d.c(this);
    this.a.register(this.r);
    this.s = com.ziroom.ziroomcustomer.minsu.landlordrelease.a.b.getInstance(this.a);
  }
  
  private void p()
  {
    this.j.setOnFocusChangeListener(new View.OnFocusChangeListener()
    {
      public void onFocusChange(View paramAnonymousView, boolean paramAnonymousBoolean)
      {
        if (!paramAnonymousBoolean)
        {
          paramAnonymousView = VdsAgent.trackEditTextSilent(LLReleaseRoomSecondStepThreeFragment_SR.c(LLReleaseRoomSecondStepThreeFragment_SR.this)).toString().trim();
          if (!TextUtils.isEmpty(paramAnonymousView)) {
            try
            {
              if (paramAnonymousView.contains("平米")) {
                return;
              }
              LLReleaseRoomSecondStepThreeFragment_SR.c(LLReleaseRoomSecondStepThreeFragment_SR.this).setInputType(1);
              LLReleaseRoomSecondStepThreeFragment_SR.c(LLReleaseRoomSecondStepThreeFragment_SR.this).setText(paramAnonymousView + "平米");
              LLReleaseRoomSecondStepThreeFragment_SR.c(LLReleaseRoomSecondStepThreeFragment_SR.this).setTextColor(Color.parseColor("#444444"));
              return;
            }
            catch (NumberFormatException paramAnonymousView) {}
          }
        }
        else
        {
          paramAnonymousView = VdsAgent.trackEditTextSilent(LLReleaseRoomSecondStepThreeFragment_SR.c(LLReleaseRoomSecondStepThreeFragment_SR.this)).toString();
          if ((!TextUtils.isEmpty(paramAnonymousView)) && (paramAnonymousView.contains("平米")))
          {
            paramAnonymousView = paramAnonymousView.replaceAll("平米", "");
            LLReleaseRoomSecondStepThreeFragment_SR.c(LLReleaseRoomSecondStepThreeFragment_SR.this).setText(paramAnonymousView);
            LLReleaseRoomSecondStepThreeFragment_SR.c(LLReleaseRoomSecondStepThreeFragment_SR.this).setInputType(2);
            LLReleaseRoomSecondStepThreeFragment_SR.c(LLReleaseRoomSecondStepThreeFragment_SR.this).setSelection(paramAnonymousView.length());
            paramAnonymousView = (InputMethodManager)LLReleaseRoomSecondStepThreeFragment_SR.b(LLReleaseRoomSecondStepThreeFragment_SR.this).getSystemService("input_method");
            paramAnonymousView.showSoftInput(LLReleaseRoomSecondStepThreeFragment_SR.c(LLReleaseRoomSecondStepThreeFragment_SR.this), 2);
            paramAnonymousView.toggleSoftInput(2, 1);
          }
        }
      }
    });
  }
  
  private void q()
  {
    if (this.P != null) {
      this.D = this.P.getValue();
    }
    if (this.Q != null) {
      this.F = this.Q.getValue();
    }
    List localList;
    int i1;
    if ((this.T != null) && (this.T.getList() != null))
    {
      localList = this.T.getList();
      if ((localList != null) && (!localList.isEmpty())) {
        i1 = 0;
      }
    }
    for (;;)
    {
      if (i1 < localList.size())
      {
        if (((WeekendListBean.WeekendLisDataBean)localList.get(i1)).isSelect())
        {
          this.G = ((WeekendListBean.WeekendLisDataBean)localList.get(i1)).getValue();
          this.O = ((WeekendListBean.WeekendLisDataBean)localList.get(i1)).getText();
        }
      }
      else
      {
        if (this.R != null) {
          this.H = this.R.getValue();
        }
        if (this.S != null) {
          this.I = this.S.getValue();
        }
        if (this.U != null) {
          this.E = this.U.getValue();
        }
        return;
      }
      i1 += 1;
    }
  }
  
  private void r()
  {
    Object localObject = aa.getString(this.t, "aloneRoonName", "");
    if (!TextUtils.isEmpty(this.i.getText().toString())) {
      if (this.i.getText().toString().equals(localObject))
      {
        this.af = false;
        localObject = aa.getString(this.t, "aloneRoomArea", "");
        if (VdsAgent.trackEditTextSilent(this.j).toString().isEmpty()) {
          break label410;
        }
        if (VdsAgent.trackEditTextSilent(this.j).toString().contains("平米"))
        {
          if (!VdsAgent.trackEditTextSilent(this.j).toString().replace("平米", "").equals(localObject)) {
            break label402;
          }
          this.ag = false;
        }
        label132:
        localObject = aa.getString(this.t, "roomPrice", "");
        if (TextUtils.isEmpty(this.L.getText().toString())) {
          break label426;
        }
        if (!this.L.getText().toString().equals(localObject)) {
          break label418;
        }
        this.ah = false;
        label188:
        localObject = aa.getString(this.t, "peopleLimit", "");
        if (TextUtils.isEmpty(this.n.getText().toString())) {
          break label442;
        }
        if (!this.n.getText().toString().equals(localObject)) {
          break label434;
        }
        this.ai = false;
        label244:
        localObject = com.alibaba.fastjson.a.parseArray(aa.getString(this.t, "bedTypeMsgListString", ""), AloneRoomBedTypeMsgListBean.class);
        if (this.W != null)
        {
          if (this.W.size() == ((List)localObject).size()) {
            break label450;
          }
          this.aj = false;
        }
      }
    }
    for (;;)
    {
      if ((!this.af) && (!this.ag) && (!this.ah) && (!this.ai) && (!this.aj)) {
        break label517;
      }
      d.newBuilder(this.t).setOnConfirmClickListener(new d.b()
      {
        public void onLeftClick(View paramAnonymousView) {}
        
        public void onRightClick(View paramAnonymousView)
        {
          LLReleaseRoomSecondStepThreeFragment_SR.d(LLReleaseRoomSecondStepThreeFragment_SR.this);
        }
      }).setTitle(getResources().getString(2131297090)).setContent(getResources().getString(2131297089)).setButtonText("取消", "确定").show();
      return;
      this.af = true;
      break;
      this.af = false;
      break;
      label402:
      this.ag = true;
      break label132;
      label410:
      this.ag = false;
      break label132;
      label418:
      this.ah = true;
      break label188;
      label426:
      this.ah = false;
      break label188;
      label434:
      this.ai = true;
      break label244;
      label442:
      this.ai = false;
      break label244;
      label450:
      int i1 = 0;
      while (i1 < this.W.size())
      {
        if (((AloneRoomBedTypeMsgListBean)this.W.get(i1)).getNum() != ((AloneRoomBedTypeMsgListBean)((List)localObject).get(i1)).getNum()) {
          break label509;
        }
        this.aj = false;
        i1 += 1;
      }
      continue;
      label509:
      this.aj = true;
    }
    label517:
    g();
  }
  
  private void s()
  {
    int i1 = 0;
    int i2 = 0;
    while (i1 < this.W.size())
    {
      i2 += ((AloneRoomBedTypeMsgListBean)this.W.get(i1)).getNum();
      i1 += 1;
    }
    if (i2 > 0)
    {
      this.o.setText("修改");
      return;
    }
    this.o.setText("添加");
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
      do
      {
        return;
        if (!parama.equals("alone_room_init")) {
          break;
        }
        i1 = 0;
        break;
        if (!parama.equals("alone_room_init_error")) {
          break;
        }
        i1 = 1;
        break;
        if (!parama.equals("save_alone_room_init")) {
          break;
        }
        i1 = 2;
        break;
        if (!parama.equals("save_alone_room_init_error")) {
          break;
        }
        i1 = 3;
        break;
        this.u = this.r.getmAloneRoomInitInfoBean();
      } while ((this.u == null) || (this.u.getData() == null));
      parama = this.u.getData();
      Object localObject2 = parama.getRoomName();
      localObject1 = parama.getHouseArea();
      this.P = parama.getLeasePrice();
      this.Q = parama.getWeekendPrice();
      this.R = parama.getSevenDiscountRate();
      this.J = parama.getWeekendPriceSwitch();
      this.S = parama.getThirtyDiscountRate();
      this.K = parama.getFullDayRateSwitch();
      this.T = parama.getWeekendList();
      this.w = parama.getBedTypeList();
      this.W = parama.getBedTypeMsgList();
      this.ak = parama.getMinPrice();
      this.al = parama.getMaxPrice();
      Object localObject3 = com.alibaba.fastjson.a.toJSONString(this.W);
      aa.putString(this.t, "bedTypeMsgListString", (String)localObject3);
      localObject3 = parama.getLimitPersonList();
      if (localObject3 != null)
      {
        this.y = ((AloneRoomLimitPersonListBean)localObject3).getList();
        if ((this.y != null) && (!this.y.isEmpty()))
        {
          i1 = 0;
          while (i1 < this.y.size())
          {
            localObject3 = new SingleChoseBean();
            ((SingleChoseBean)localObject3).setText(((AloneRoomLimitPersonListBean.AloneRoomLimitPersonListDataBean)this.y.get(i1)).getText());
            this.x.add(localObject3);
            if (((AloneRoomLimitPersonListBean.AloneRoomLimitPersonListDataBean)this.y.get(i1)).isSelect())
            {
              localObject3 = ((AloneRoomLimitPersonListBean.AloneRoomLimitPersonListDataBean)this.y.get(i1)).getText();
              this.M = Integer.valueOf(((AloneRoomLimitPersonListBean.AloneRoomLimitPersonListDataBean)this.y.get(i1)).getValue());
              this.n.setText((CharSequence)localObject3);
              aa.putString(this.t, "peopleLimit", (String)localObject3);
            }
            i1 += 1;
          }
        }
      }
      this.U = parama.getCleaningFees();
      this.V = parama.getCleaningFeesPer();
      if (localObject2 != null)
      {
        this.p.setText(((AloneRoomNameBean)localObject2).getAuditMsg());
        localObject2 = ((AloneRoomNameBean)localObject2).getValue();
        aa.putString(this.t, "aloneRoonName", (String)localObject2);
        if (!TextUtils.isEmpty((CharSequence)localObject2))
        {
          this.i.setText((CharSequence)localObject2);
          this.i.setTextColor(Color.parseColor("#444444"));
        }
      }
      if (localObject1 != null)
      {
        i1 = (int)((AloneRoomAreaBean)localObject1).getValue();
        if (i1 != 0)
        {
          this.j.setText(i1 + "平米");
          this.k.setText(i1 + "平米");
          aa.putString(this.t, "aloneRoomArea", String.valueOf(i1));
          this.i.setTextColor(Color.parseColor("#444444"));
        }
        if (!((AloneRoomAreaBean)localObject1).isEdit())
        {
          this.j.setVisibility(8);
          this.k.setVisibility(0);
          this.k.setOnClickListener(new View.OnClickListener()
          {
            @Instrumented
            public void onClick(View paramAnonymousView)
            {
              VdsAgent.onClick(this, paramAnonymousView);
              g.textToast(LLReleaseRoomSecondStepThreeFragment_SR.b(LLReleaseRoomSecondStepThreeFragment_SR.this), "已上架房源无法修改");
            }
          });
          this.v.setOnClickListener(new View.OnClickListener()
          {
            @Instrumented
            public void onClick(View paramAnonymousView)
            {
              VdsAgent.onClick(this, paramAnonymousView);
              g.textToast(LLReleaseRoomSecondStepThreeFragment_SR.b(LLReleaseRoomSecondStepThreeFragment_SR.this), "已上架房源无法修改");
            }
          });
        }
      }
      p();
      q();
      d("first");
      this.X = parama.getMaxBedNumLimit();
      if (this.w != null) {
        this.ac = this.w.getList();
      }
      s();
      parama = new com.ziroom.ziroomcustomer.minsu.adapter.a(this.t, this.ac, this.W);
      this.q.setAdapter(parama);
      this.ad = a("people_limit_shose", this.x, new a(null));
      return;
      this.h.setVisibility(8);
      this.b.setVisibility(8);
      showToast(this.r.getAloneRoomInitInfoErrorMsg());
      return;
      parama = this.r.getmSaveAloneRoomInitInfoBean();
    } while (parama == null);
    i1 = parama.getStatus();
    Object localObject1 = parama.getData();
    if (localObject1 != null) {
      this.N = ((SaveAloneRoomInitInfoBean.SaveAloneRoomData)localObject1).getRoomFid();
    }
    if (i1 == 0)
    {
      f();
      return;
    }
    showToast(parama.getMessage() + "");
    return;
    showToast(this.r.getSaveAloneRoomInitInfoErrorMsg());
  }
  
  protected View c()
  {
    View localView = LayoutInflater.from(this.t).inflate(2130903893, null);
    this.f = ((ImageView)localView.findViewById(2131689492));
    this.g = localView.findViewById(2131689863);
    this.b = ((TextView)localView.findViewById(2131689862));
    this.d = ((TextView)localView.findViewById(2131693950));
    this.e = ((TextView)localView.findViewById(2131693951));
    this.c = ((TextView)localView.findViewById(2131693949));
    this.h = ((ObservableScrollView)localView.findViewById(2131689506));
    this.i = ((LimitEditText)localView.findViewById(2131689869));
    this.j = ((EditText)localView.findViewById(2131689873));
    this.k = ((TextView)localView.findViewById(2131689874));
    this.l = ((RelativeLayout)localView.findViewById(2131689875));
    this.L = ((TextView)localView.findViewById(2131689878));
    this.m = ((RelativeLayout)localView.findViewById(2131689885));
    this.n = ((TextView)localView.findViewById(2131689888));
    this.o = ((TextView)localView.findViewById(2131689891));
    this.q = ((ListViewForScrollView)localView.findViewById(2131689892));
    this.p = ((TextView)localView.findViewById(2131689868));
    this.v = ((RelativeLayout)localView.findViewById(2131689870));
    return localView;
  }
  
  protected void d()
  {
    this.s.getAloneRoomInfo(this, this.t, this.z, this.A, Integer.valueOf(this.B), this.C);
  }
  
  protected void e()
  {
    String str = this.i.getText().toString();
    if (TextUtils.isEmpty(str))
    {
      showToast("请输入房间名称");
      return;
    }
    if (str.length() < 10)
    {
      showToast("房间名称不少于10个字");
      return;
    }
    Object localObject = VdsAgent.trackEditTextSilent(this.j).toString();
    if (TextUtils.isEmpty((CharSequence)localObject))
    {
      showToast("请填写该房间的面积");
      return;
    }
    if (((String)localObject).contains("平米")) {
      this.aa = ((String)localObject).replace("平米", "");
    }
    for (this.ab = Integer.valueOf(this.aa); this.D == 0; this.ab = Integer.valueOf((String)localObject))
    {
      showToast("请填写基础价格");
      return;
    }
    if ((this.J == 1) && (this.F == 0))
    {
      showToast("请填写周末价格");
      return;
    }
    if ((this.K == 1) && (this.H == 0.0D) && (this.I == 0.0D))
    {
      showToast("请填写住宿折扣");
      return;
    }
    if (TextUtils.isEmpty(this.n.getText().toString()))
    {
      showToast("请填写标价可住人数");
      return;
    }
    int i2 = 0;
    int i1 = i2;
    if (this.W != null)
    {
      i1 = i2;
      if (!this.W.isEmpty())
      {
        i1 = 0;
        i2 = 0;
        while (i2 < this.W.size())
        {
          i1 += ((AloneRoomBedTypeMsgListBean)this.W.get(i2)).getNum();
          i2 += 1;
        }
      }
    }
    if (i1 == 0)
    {
      showToast("请为房间添加床位");
      return;
    }
    localObject = new StringBuffer();
    if ((this.W != null) && (!this.W.isEmpty()))
    {
      i1 = 0;
      while (i1 < this.W.size())
      {
        ((StringBuffer)localObject).append(((AloneRoomBedTypeMsgListBean)this.W.get(i1)).toString()).append(",");
        i1 += 1;
      }
    }
    if (((StringBuffer)localObject).length() > 0) {
      ((StringBuffer)localObject).deleteCharAt(((StringBuffer)localObject).length() - 1);
    }
    localObject = ((StringBuffer)localObject).toString();
    this.s.saveAloneRoomInfo(this, this.t, this.z, this.A, Integer.valueOf(this.B), Integer.valueOf(this.C), str, this.ab, Integer.valueOf(this.D), Integer.valueOf(this.J), Integer.valueOf(this.F), Integer.valueOf(this.K), this.G, this.H, this.I, Integer.valueOf(this.E), Integer.valueOf(0), this.M, (String)localObject);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt2 == -1)
    {
      if (paramInt1 == 666)
      {
        this.Y = true;
        this.D = paramIntent.getIntExtra("leasePrice", -1);
        this.E = paramIntent.getIntExtra("cleaningFees", -1);
        this.F = paramIntent.getIntExtra("weekendPriceVal", -1);
        this.H = paramIntent.getDoubleExtra("sevenDiscountRate", -1.0D);
        this.I = paramIntent.getDoubleExtra("thirtyDiscountRate", -1.0D);
        this.J = paramIntent.getIntExtra("weekendPriceSwitch", -1);
        this.K = paramIntent.getIntExtra("fullDayRateSwitch", -1);
        this.G = paramIntent.getStringExtra("weekendPriceType");
        this.O = paramIntent.getStringExtra("weekendPriceTypeD");
        d("second");
      }
      if (paramInt1 == 999)
      {
        this.W = ((List)paramIntent.getExtras().getSerializable("bedTypeMsgList"));
        s();
        paramIntent = new com.ziroom.ziroomcustomer.minsu.adapter.a(this.t, this.ac, this.W);
        this.q.setAdapter(paramIntent);
      }
    }
  }
  
  public boolean onBackPressed()
  {
    r();
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
    case 2131689875: 
    case 2131689885: 
      do
      {
        return;
        r();
        return;
        paramView = new Intent(this.t, HousePriceSettingActivity.class);
        paramView.putExtra("houseBaseFid", this.z);
        paramView.putExtra("rentWay", this.B);
        paramView.putExtra("roomFid", this.A);
        paramView.putExtra("priceTag", 1);
        paramView.putExtra("leasePrice", this.D);
        paramView.putExtra("weekendPriceSwitch", this.J);
        paramView.putExtra("weekendPriceType", this.G);
        paramView.putExtra("weekendPriceTypeD", this.O);
        paramView.putExtra("weekendPriceVal", this.F);
        paramView.putExtra("fullDayRateSwitch", this.K);
        paramView.putExtra("sevenDiscountRate", this.H);
        paramView.putExtra("thirtyDiscountRate", this.I);
        paramView.putExtra("cleaningFees", this.E);
        paramView.putExtra("maxPrice", this.al);
        paramView.putExtra("minPrice", this.ak);
        startActivityForResult(paramView, 666);
        return;
      } while (this.ad == null);
      this.ad.show();
      this.ae = this.ad.getTv_choose();
      this.ae.setText("");
      return;
    case 2131689891: 
      paramView = new Intent(this.t, RoomBedInfoActivity.class);
      Bundle localBundle = new Bundle();
      localBundle.putInt("maxBedNumLimit", this.X);
      localBundle.putSerializable("bedTypeList", this.w);
      localBundle.putSerializable("bedTypeMsgList", (Serializable)this.W);
      paramView.putExtras(localBundle);
      startActivityForResult(paramView, 999);
      return;
    }
    e();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.t = getActivity();
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    o();
    return c();
  }
  
  public void onLoginBack(boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((paramBoolean1) && (paramBoolean2))
    {
      m();
      n();
      d();
    }
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    m();
    n();
    d();
  }
  
  public void setHouseBaseFid(String paramString)
  {
    this.z = paramString;
  }
  
  public void setRentWay(int paramInt)
  {
    this.B = paramInt;
  }
  
  public void setRoomFid(String paramString)
  {
    this.A = paramString;
  }
  
  private class a
    implements c.a
  {
    private a() {}
    
    public void onSingleSelect(String paramString, int paramInt)
    {
      LLReleaseRoomSecondStepThreeFragment_SR.e(LLReleaseRoomSecondStepThreeFragment_SR.this).setText(paramString);
      LLReleaseRoomSecondStepThreeFragment_SR.e(LLReleaseRoomSecondStepThreeFragment_SR.this).setTextColor(Color.parseColor("#444444"));
      if ((LLReleaseRoomSecondStepThreeFragment_SR.f(LLReleaseRoomSecondStepThreeFragment_SR.this) == null) || (LLReleaseRoomSecondStepThreeFragment_SR.f(LLReleaseRoomSecondStepThreeFragment_SR.this).isEmpty())) {
        return;
      }
      LLReleaseRoomSecondStepThreeFragment_SR.a(LLReleaseRoomSecondStepThreeFragment_SR.this, Integer.valueOf(((AloneRoomLimitPersonListBean.AloneRoomLimitPersonListDataBean)LLReleaseRoomSecondStepThreeFragment_SR.f(LLReleaseRoomSecondStepThreeFragment_SR.this).get(paramInt)).getValue()));
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/landlordrelease/LLReleaseRoomSecondStepThreeFragment_SR.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */