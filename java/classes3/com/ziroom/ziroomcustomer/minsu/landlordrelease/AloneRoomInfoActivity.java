package com.ziroom.ziroomcustomer.minsu.landlordrelease;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
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
import com.ziroom.ziroomcustomer.flux.view.BaseFluxActivity;
import com.ziroom.ziroomcustomer.minsu.f.aa;
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
import com.ziroom.ziroomcustomer.minsu.landlordrelease.model.aloneroominfo.AloneRoomIsToiletListBean;
import com.ziroom.ziroomcustomer.minsu.landlordrelease.model.aloneroominfo.AloneRoomIsToiletListBean.AloneRoomIsToiletListDataBean;
import com.ziroom.ziroomcustomer.minsu.landlordrelease.model.aloneroominfo.AloneRoomLimitPersonListBean;
import com.ziroom.ziroomcustomer.minsu.landlordrelease.model.aloneroominfo.AloneRoomLimitPersonListBean.AloneRoomLimitPersonListDataBean;
import com.ziroom.ziroomcustomer.minsu.landlordrelease.model.aloneroominfo.AloneRoomNameBean;
import com.ziroom.ziroomcustomer.minsu.landlordrelease.model.houseprice.WeekendListBean;
import com.ziroom.ziroomcustomer.minsu.landlordrelease.model.houseprice.WeekendListBean.WeekendLisDataBean;
import com.ziroom.ziroomcustomer.minsu.landlordrelease.view.ReleaseUsageAndTipsView;
import com.ziroom.ziroomcustomer.minsu.landlordrelease.view.c.a;
import com.ziroom.ziroomcustomer.newServiceList.view.LimitEditText;
import com.ziroom.ziroomcustomer.widget.ListViewForScrollView;
import com.ziroom.ziroomcustomer.widget.ObservableScrollView;
import com.ziroom.ziroomcustomer.widget.ObservableScrollView.a;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class AloneRoomInfoActivity
  extends BaseFluxActivity
  implements View.OnClickListener
{
  private com.ziroom.ziroomcustomer.minsu.landlordrelease.d.c A;
  private com.ziroom.ziroomcustomer.minsu.landlordrelease.a.b B;
  private AloneRoomInfoActivity C;
  private AloneRoomInitInfoBean D;
  private AloneRoomBedTypeListBean E;
  private List<SingleChoseBean> F = new ArrayList();
  private List<SingleChoseBean> G = new ArrayList();
  private List<AloneRoomIsToiletListBean.AloneRoomIsToiletListDataBean> H;
  private List<AloneRoomLimitPersonListBean.AloneRoomLimitPersonListDataBean> I;
  private String J;
  private String K;
  private int L;
  private int M;
  private int N;
  private int O;
  private int P;
  private String Q;
  private double R;
  private double S;
  private int T;
  private int U;
  private TextView V;
  private Integer W;
  private Integer X;
  private int Y;
  private String Z;
  private int aA;
  private ReleaseUsageAndTipsView aa;
  private String ab;
  private AloneRoomInitInfoDataBean.AloneRoomLeasePriceBean ac;
  private AloneRoomInitInfoDataBean.AloneRoomWeekendPriceBean ad;
  private AloneRoomInitInfoDataBean.AloneRoomSevenDiscountRateBean ae;
  private AloneRoomInitInfoDataBean.AloneRoomThirtyDiscountRateBean af;
  private WeekendListBean ag;
  private AloneRoomInitInfoDataBean.AloneRoomCleaningFeesBean ah;
  private int ai;
  private List<AloneRoomBedTypeMsgListBean> aj;
  private int ak;
  private boolean al = false;
  private boolean am = false;
  private String an;
  private Integer ao;
  private List<AloneRoomBedTypeListDataBean> ap;
  private com.ziroom.ziroomcustomer.minsu.landlordrelease.view.c aq;
  private com.ziroom.ziroomcustomer.minsu.landlordrelease.view.c ar;
  private TextView as;
  private boolean at = false;
  private boolean au = false;
  private boolean av = false;
  private boolean aw = false;
  private boolean ax = false;
  private boolean ay = false;
  private int az;
  private ImageView b;
  private View c;
  private TextView d;
  private ObservableScrollView e;
  private LimitEditText f;
  private EditText g;
  private TextView r;
  private RelativeLayout s;
  private RelativeLayout t;
  private TextView u;
  private RelativeLayout v;
  private TextView w;
  private TextView x;
  private TextView y;
  private ListViewForScrollView z;
  
  private com.ziroom.ziroomcustomer.minsu.landlordrelease.view.c a(String paramString, List<SingleChoseBean> paramList, c.a parama)
  {
    paramString = new com.ziroom.ziroomcustomer.minsu.landlordrelease.view.c(this.C, paramString, parama, paramList);
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
  
  private void a()
  {
    this.C = this;
    this.b = ((ImageView)findViewById(2131689492));
    this.c = findViewById(2131689863);
    this.d = ((TextView)findViewById(2131689862));
    this.e = ((ObservableScrollView)findViewById(2131689506));
    this.f = ((LimitEditText)findViewById(2131689869));
    this.g = ((EditText)findViewById(2131689873));
    this.r = ((TextView)findViewById(2131689874));
    this.s = ((RelativeLayout)findViewById(2131689875));
    this.V = ((TextView)findViewById(2131689878));
    this.t = ((RelativeLayout)findViewById(2131689880));
    this.u = ((TextView)findViewById(2131689883));
    this.v = ((RelativeLayout)findViewById(2131689885));
    this.w = ((TextView)findViewById(2131689888));
    this.x = ((TextView)findViewById(2131689891));
    this.z = ((ListViewForScrollView)findViewById(2131689892));
    this.aa = ((ReleaseUsageAndTipsView)findViewById(2131689893));
    this.aa.setVisibility(8);
    this.y = ((TextView)findViewById(2131689868));
  }
  
  private void b()
  {
    this.b.setOnClickListener(this);
    this.d.setOnClickListener(this);
    this.s.setOnClickListener(this);
    this.t.setOnClickListener(this);
    this.v.setOnClickListener(this);
    this.x.setOnClickListener(this);
    this.b.setOnClickListener(this);
    this.e.setOnScrollChangedCallback(new ObservableScrollView.a()
    {
      public void onScroll(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        float f = paramAnonymousInt2 / 100.0F;
        AloneRoomInfoActivity.a(AloneRoomInfoActivity.this).setAlpha(f);
      }
    });
  }
  
  private void d(String paramString)
  {
    Object localObject = new StringBuilder();
    if (this.N != 0) {
      ((StringBuilder)localObject).append("基础价格：" + this.N + "元/晚").append("\n");
    }
    if ((this.T == 1) && (this.P != 0) && (!TextUtils.isEmpty(this.ab))) {
      ((StringBuilder)localObject).append(this.ab + "：" + this.P + "元/晚").append("\n");
    }
    if (this.U == 1)
    {
      if (this.R != 0.0D) {
        ((StringBuilder)localObject).append("满7天折扣：" + this.R + "折").append("\n");
      }
      if (this.S != 0.0D) {
        ((StringBuilder)localObject).append("满30天折扣：" + this.S + "折").append("\n");
      }
    }
    if (this.O != 0) {
      ((StringBuilder)localObject).append("清洁费：").append(this.O).append("元").append("\n");
    }
    if (((StringBuilder)localObject).length() <= 0)
    {
      this.V.setHint("请填写基础价格、周末价格、长期住宿折扣、清洁费等");
      this.V.setTextColor(Color.parseColor("#999999"));
    }
    do
    {
      return;
      localObject = ((StringBuilder)localObject).subSequence(0, ((StringBuilder)localObject).length() - 1).toString();
      this.V.setText((CharSequence)localObject);
      this.V.setTextColor(Color.parseColor("#444444"));
    } while (!paramString.equals("first"));
    aa.putString(this.C, "roomPrice", (String)localObject);
  }
  
  private void e()
  {
    this.Y = getIntent().getIntExtra("position", -1);
    this.J = getIntent().getStringExtra("houseBaseFid");
    this.K = getIntent().getStringExtra("roomFid");
    this.L = getIntent().getIntExtra("rentWay", -1);
    this.M = getIntent().getIntExtra("rentRoomNum", -1);
    f();
    g();
  }
  
  private void f()
  {
    this.A = new com.ziroom.ziroomcustomer.minsu.landlordrelease.d.c(this);
    this.a.register(this.A);
    this.B = com.ziroom.ziroomcustomer.minsu.landlordrelease.a.b.getInstance(this.a);
  }
  
  private void g()
  {
    this.B.getAloneRoomInfo(this, this.C, this.J, this.K, Integer.valueOf(this.L), this.M);
  }
  
  private void h()
  {
    this.g.setOnFocusChangeListener(new View.OnFocusChangeListener()
    {
      public void onFocusChange(View paramAnonymousView, boolean paramAnonymousBoolean)
      {
        if (!paramAnonymousBoolean)
        {
          paramAnonymousView = VdsAgent.trackEditTextSilent(AloneRoomInfoActivity.b(AloneRoomInfoActivity.this)).toString().trim();
          if (!TextUtils.isEmpty(paramAnonymousView)) {
            try
            {
              if (paramAnonymousView.contains("平米")) {
                return;
              }
              AloneRoomInfoActivity.b(AloneRoomInfoActivity.this).setInputType(1);
              AloneRoomInfoActivity.b(AloneRoomInfoActivity.this).setText(paramAnonymousView + "平米");
              AloneRoomInfoActivity.b(AloneRoomInfoActivity.this).setTextColor(Color.parseColor("#444444"));
              return;
            }
            catch (NumberFormatException paramAnonymousView) {}
          }
        }
        else
        {
          paramAnonymousView = VdsAgent.trackEditTextSilent(AloneRoomInfoActivity.b(AloneRoomInfoActivity.this)).toString();
          if ((!TextUtils.isEmpty(paramAnonymousView)) && (paramAnonymousView.contains("平米")))
          {
            paramAnonymousView = paramAnonymousView.replaceAll("平米", "");
            AloneRoomInfoActivity.b(AloneRoomInfoActivity.this).setText(paramAnonymousView);
            AloneRoomInfoActivity.b(AloneRoomInfoActivity.this).setInputType(2);
            AloneRoomInfoActivity.b(AloneRoomInfoActivity.this).setSelection(paramAnonymousView.length());
            paramAnonymousView = (InputMethodManager)AloneRoomInfoActivity.this.getSystemService("input_method");
            paramAnonymousView.showSoftInput(AloneRoomInfoActivity.b(AloneRoomInfoActivity.this), 2);
            paramAnonymousView.toggleSoftInput(2, 1);
          }
        }
      }
    });
  }
  
  private void i()
  {
    if (this.ac != null) {
      this.N = this.ac.getValue();
    }
    if (this.ad != null) {
      this.P = this.ad.getValue();
    }
    List localList;
    int i;
    if ((this.ag != null) && (this.ag.getList() != null))
    {
      localList = this.ag.getList();
      if ((localList != null) && (!localList.isEmpty())) {
        i = 0;
      }
    }
    for (;;)
    {
      if (i < localList.size())
      {
        if (((WeekendListBean.WeekendLisDataBean)localList.get(i)).isSelect())
        {
          this.Q = ((WeekendListBean.WeekendLisDataBean)localList.get(i)).getValue();
          this.ab = ((WeekendListBean.WeekendLisDataBean)localList.get(i)).getText();
        }
      }
      else
      {
        if (this.ae != null) {
          this.R = this.ae.getValue();
        }
        if (this.af != null) {
          this.S = this.af.getValue();
        }
        if (this.ah != null) {
          this.O = this.ah.getValue();
        }
        return;
      }
      i += 1;
    }
  }
  
  private void j()
  {
    Object localObject = aa.getString(this.C, "aloneRoonName", "");
    if (!TextUtils.isEmpty(this.f.getText().toString())) {
      if (this.f.getText().toString().equals(localObject))
      {
        this.at = false;
        localObject = aa.getString(this.C, "aloneRoomArea", "");
        if (VdsAgent.trackEditTextSilent(this.g).toString().isEmpty()) {
          break label466;
        }
        if (VdsAgent.trackEditTextSilent(this.g).toString().contains("平米"))
        {
          if (!VdsAgent.trackEditTextSilent(this.g).toString().replace("平米", "").equals(localObject)) {
            break label458;
          }
          this.au = false;
        }
        label132:
        localObject = aa.getString(this.C, "roomPrice", "");
        if (TextUtils.isEmpty(this.V.getText().toString())) {
          break label482;
        }
        if (!this.V.getText().toString().equals(localObject)) {
          break label474;
        }
        this.av = false;
        label188:
        localObject = aa.getString(this.C, "independentToilet", "");
        if (TextUtils.isEmpty(this.u.getText().toString())) {
          break label498;
        }
        if (!this.u.getText().toString().equals(localObject)) {
          break label490;
        }
        this.aw = false;
        label244:
        localObject = aa.getString(this.C, "peopleLimit", "");
        if (TextUtils.isEmpty(this.w.getText().toString())) {
          break label514;
        }
        if (!this.w.getText().toString().equals(localObject)) {
          break label506;
        }
        this.ax = false;
        label300:
        localObject = com.alibaba.fastjson.a.parseArray(aa.getString(this.C, "bedTypeMsgListString", ""), AloneRoomBedTypeMsgListBean.class);
        if (this.aj.size() == ((List)localObject).size()) {
          break label522;
        }
        this.ay = false;
      }
    }
    for (;;)
    {
      if ((!this.at) && (!this.au) && (!this.av) && (!this.aw) && (!this.ax) && (!this.ay)) {
        break label589;
      }
      d.newBuilder(this.C).setOnConfirmClickListener(new d.b()
      {
        public void onLeftClick(View paramAnonymousView) {}
        
        public void onRightClick(View paramAnonymousView)
        {
          AloneRoomInfoActivity.this.finish();
        }
      }).setTitle(getResources().getString(2131297090)).setContent(getResources().getString(2131297089)).setButtonText("取消", "确定").show();
      return;
      this.at = true;
      break;
      this.at = false;
      break;
      label458:
      this.au = true;
      break label132;
      label466:
      this.au = false;
      break label132;
      label474:
      this.av = true;
      break label188;
      label482:
      this.av = false;
      break label188;
      label490:
      this.aw = true;
      break label244;
      label498:
      this.aw = false;
      break label244;
      label506:
      this.ax = true;
      break label300;
      label514:
      this.ax = false;
      break label300;
      label522:
      int i = 0;
      while (i < this.aj.size())
      {
        if (((AloneRoomBedTypeMsgListBean)this.aj.get(i)).getNum() != ((AloneRoomBedTypeMsgListBean)((List)localObject).get(i)).getNum()) {
          break label581;
        }
        this.ay = false;
        i += 1;
      }
      continue;
      label581:
      this.ay = true;
    }
    label589:
    finish();
  }
  
  private void k()
  {
    String str = this.f.getText().toString();
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
    Object localObject = VdsAgent.trackEditTextSilent(this.g).toString();
    if (TextUtils.isEmpty((CharSequence)localObject))
    {
      showToast("请填写该房间的面积");
      return;
    }
    if (((String)localObject).contains("平米")) {
      this.an = ((String)localObject).replace("平米", "");
    }
    for (this.ao = Integer.valueOf(this.an); this.N == 0; this.ao = Integer.valueOf((String)localObject))
    {
      showToast("请填写基础价格");
      return;
    }
    if ((this.T == 1) && (this.P == 0))
    {
      showToast("请填写周末价格");
      return;
    }
    if ((this.U == 1) && (this.R == 0.0D) && (this.S == 0.0D))
    {
      showToast("请填写住宿折扣");
      return;
    }
    if (TextUtils.isEmpty(this.u.getText().toString()))
    {
      showToast("请填写是否有独立卫生间");
      return;
    }
    if (TextUtils.isEmpty(this.w.getText().toString()))
    {
      showToast("请填写标价可住人数");
      return;
    }
    int j = 0;
    int i = j;
    if (this.aj != null)
    {
      i = j;
      if (!this.aj.isEmpty())
      {
        i = 0;
        j = 0;
        while (j < this.aj.size())
        {
          i += ((AloneRoomBedTypeMsgListBean)this.aj.get(j)).getNum();
          j += 1;
        }
      }
    }
    if (i == 0)
    {
      showToast("请为房间添加床位");
      return;
    }
    localObject = new StringBuffer();
    if ((this.aj != null) && (!this.aj.isEmpty()))
    {
      i = 0;
      while (i < this.aj.size())
      {
        ((StringBuffer)localObject).append(((AloneRoomBedTypeMsgListBean)this.aj.get(i)).toString()).append(",");
        i += 1;
      }
    }
    if (((StringBuffer)localObject).length() > 0) {
      ((StringBuffer)localObject).deleteCharAt(((StringBuffer)localObject).length() - 1);
    }
    localObject = ((StringBuffer)localObject).toString();
    this.B.saveAloneRoomInfo(this, this.C, this.J, this.K, Integer.valueOf(this.L), Integer.valueOf(this.M), str, this.ao, Integer.valueOf(this.N), Integer.valueOf(this.T), Integer.valueOf(this.P), Integer.valueOf(this.U), this.Q, this.R, this.S, Integer.valueOf(this.O), this.W, this.X, (String)localObject);
  }
  
  private void l()
  {
    int i = 0;
    int j = 0;
    while (i < this.aj.size())
    {
      j += ((AloneRoomBedTypeMsgListBean)this.aj.get(i)).getNum();
      i += 1;
    }
    if (j > 0)
    {
      this.x.setText("修改");
      return;
    }
    this.x.setText("添加");
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt2 == -1)
    {
      if (paramInt1 == 666)
      {
        this.al = true;
        this.N = paramIntent.getIntExtra("leasePrice", -1);
        this.O = paramIntent.getIntExtra("cleaningFees", -1);
        this.P = paramIntent.getIntExtra("weekendPriceVal", -1);
        this.R = paramIntent.getDoubleExtra("sevenDiscountRate", -1.0D);
        this.S = paramIntent.getDoubleExtra("thirtyDiscountRate", -1.0D);
        this.T = paramIntent.getIntExtra("weekendPriceSwitch", -1);
        this.U = paramIntent.getIntExtra("fullDayRateSwitch", -1);
        this.Q = paramIntent.getStringExtra("weekendPriceType");
        this.ab = paramIntent.getStringExtra("weekendPriceTypeD");
        d("second");
      }
      if (paramInt1 == 999)
      {
        this.aj = ((List)paramIntent.getExtras().getSerializable("bedTypeMsgList"));
        l();
        paramIntent = new com.ziroom.ziroomcustomer.minsu.adapter.a(this.C, this.ap, this.aj);
        this.z.setAdapter(paramIntent);
      }
    }
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
    case 2131689880: 
    case 2131689885: 
      do
      {
        do
        {
          return;
          j();
          return;
          paramView = new Intent(this.C, HousePriceSettingActivity.class);
          paramView.putExtra("houseBaseFid", this.J);
          paramView.putExtra("maxPrice", this.aA);
          paramView.putExtra("minPrice", this.az);
          paramView.putExtra("priceTag", 1);
          paramView.putExtra("leasePrice", this.N);
          paramView.putExtra("weekendPriceSwitch", this.T);
          paramView.putExtra("weekendPriceType", this.Q);
          paramView.putExtra("weekendPriceTypeD", this.ab);
          paramView.putExtra("weekendPriceVal", this.P);
          paramView.putExtra("weekendList", this.ag);
          paramView.putExtra("fullDayRateSwitch", this.U);
          paramView.putExtra("sevenDiscountRate", this.R);
          paramView.putExtra("thirtyDiscountRate", this.S);
          paramView.putExtra("cleaningFees", this.O);
          paramView.putExtra("rentWay", this.L);
          paramView.putExtra("weekendList", this.ag);
          startActivityForResult(paramView, 666);
          return;
        } while (this.ar == null);
        this.ar.show();
        this.as = this.ar.getTv_choose();
        this.as.setText("");
        return;
      } while (this.aq == null);
      this.aq.show();
      this.as = this.aq.getTv_choose();
      this.as.setText("");
      return;
    case 2131689891: 
      paramView = new Intent(this.C, RoomBedInfoActivity.class);
      Bundle localBundle = new Bundle();
      localBundle.putInt("maxBedNumLimit", this.ak);
      localBundle.putSerializable("bedTypeList", this.E);
      localBundle.putSerializable("bedTypeMsgList", (Serializable)this.aj);
      paramView.putExtras(localBundle);
      startActivityForResult(paramView, 999);
      return;
    }
    k();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903089);
    a();
    b();
    e();
  }
  
  protected void onEventHandle(com.ziroom.ziroomcustomer.flux.a.a parama)
  {
    parama = parama.getType();
    switch (parama.hashCode())
    {
    default: 
      i = -1;
      label54:
      switch (i)
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
        i = 0;
        break label54;
        if (!parama.equals("alone_room_init_error")) {
          break;
        }
        i = 1;
        break label54;
        if (!parama.equals("save_alone_room_init")) {
          break;
        }
        i = 2;
        break label54;
        if (!parama.equals("save_alone_room_init_error")) {
          break;
        }
        i = 3;
        break label54;
        this.D = this.A.getmAloneRoomInitInfoBean();
      } while ((this.D == null) || (this.D.getData() == null));
      parama = this.D.getData();
      Object localObject2 = parama.getRoomName();
      localObject1 = parama.getHouseArea();
      this.ac = parama.getLeasePrice();
      this.ad = parama.getWeekendPrice();
      this.ae = parama.getSevenDiscountRate();
      this.T = parama.getWeekendPriceSwitch();
      this.af = parama.getThirtyDiscountRate();
      this.U = parama.getFullDayRateSwitch();
      this.ag = parama.getWeekendList();
      this.E = parama.getBedTypeList();
      this.aj = parama.getBedTypeMsgList();
      this.az = parama.getMinPrice();
      this.aA = parama.getMaxPrice();
      Object localObject3 = com.alibaba.fastjson.a.toJSONString(this.aj);
      aa.putString(this.C, "bedTypeMsgListString", (String)localObject3);
      localObject3 = parama.getLimitPersonList();
      if (localObject3 != null)
      {
        this.I = ((AloneRoomLimitPersonListBean)localObject3).getList();
        if ((this.I != null) && (!this.I.isEmpty()))
        {
          i = 0;
          while (i < this.I.size())
          {
            localObject3 = new SingleChoseBean();
            ((SingleChoseBean)localObject3).setText(((AloneRoomLimitPersonListBean.AloneRoomLimitPersonListDataBean)this.I.get(i)).getText());
            this.F.add(localObject3);
            if (((AloneRoomLimitPersonListBean.AloneRoomLimitPersonListDataBean)this.I.get(i)).isSelect())
            {
              localObject3 = ((AloneRoomLimitPersonListBean.AloneRoomLimitPersonListDataBean)this.I.get(i)).getText();
              this.X = Integer.valueOf(((AloneRoomLimitPersonListBean.AloneRoomLimitPersonListDataBean)this.I.get(i)).getValue());
              this.w.setText((CharSequence)localObject3);
              aa.putString(this.C, "peopleLimit", (String)localObject3);
            }
            i += 1;
          }
        }
      }
      localObject3 = parama.getIsToiletList();
      if (localObject3 != null)
      {
        this.H = ((AloneRoomIsToiletListBean)localObject3).getList();
        if ((this.H != null) && (!this.H.isEmpty()))
        {
          i = 0;
          while (i < this.H.size())
          {
            localObject3 = new SingleChoseBean();
            ((SingleChoseBean)localObject3).setText(((AloneRoomIsToiletListBean.AloneRoomIsToiletListDataBean)this.H.get(i)).getText());
            this.G.add(localObject3);
            if (((AloneRoomIsToiletListBean.AloneRoomIsToiletListDataBean)this.H.get(i)).isSelect())
            {
              localObject3 = ((AloneRoomIsToiletListBean.AloneRoomIsToiletListDataBean)this.H.get(i)).getValue();
              String str = ((AloneRoomIsToiletListBean.AloneRoomIsToiletListDataBean)this.H.get(i)).getText();
              if (!TextUtils.isEmpty((CharSequence)localObject3)) {
                this.W = Integer.valueOf((String)localObject3);
              }
              this.u.setText(str);
              aa.putString(this.C, "independentToilet", str);
            }
            i += 1;
          }
        }
      }
      this.ah = parama.getCleaningFees();
      this.ai = parama.getCleaningFeesPer();
      if (localObject2 != null)
      {
        this.y.setText(((AloneRoomNameBean)localObject2).getAuditMsg());
        localObject2 = ((AloneRoomNameBean)localObject2).getValue();
        aa.putString(this.C, "aloneRoonName", (String)localObject2);
        if (!TextUtils.isEmpty((CharSequence)localObject2))
        {
          this.f.setText((CharSequence)localObject2);
          this.f.setTextColor(Color.parseColor("#444444"));
        }
      }
      if (localObject1 != null)
      {
        i = (int)((AloneRoomAreaBean)localObject1).getValue();
        if (i != 0)
        {
          this.g.setText(i + "平米");
          this.r.setText(i + "平米");
          aa.putString(this.C, "aloneRoomArea", String.valueOf(i));
          this.f.setTextColor(Color.parseColor("#444444"));
        }
        if (!((AloneRoomAreaBean)localObject1).isEdit())
        {
          this.g.setVisibility(8);
          this.r.setVisibility(0);
          this.r.setOnClickListener(new View.OnClickListener()
          {
            @Instrumented
            public void onClick(View paramAnonymousView)
            {
              VdsAgent.onClick(this, paramAnonymousView);
              g.textToast(AloneRoomInfoActivity.this, "已上架房源无法修改");
            }
          });
          findViewById(2131689870).setOnClickListener(new View.OnClickListener()
          {
            @Instrumented
            public void onClick(View paramAnonymousView)
            {
              VdsAgent.onClick(this, paramAnonymousView);
              g.textToast(AloneRoomInfoActivity.this, "已上架房源无法修改");
            }
          });
        }
      }
      h();
      i();
      d("first");
      this.ak = parama.getMaxBedNumLimit();
      if (this.E != null) {
        this.ap = this.E.getList();
      }
      l();
      parama = new com.ziroom.ziroomcustomer.minsu.adapter.a(this.C, this.ap, this.aj);
      this.z.setAdapter(parama);
      this.ar = a("people_limit_shose", this.G, new b(null));
      this.aq = a("people_limit_shose", this.F, new a(null));
      return;
      this.e.setVisibility(8);
      this.d.setVisibility(8);
      showToast(this.A.getAloneRoomInitInfoErrorMsg());
      return;
      parama = this.A.getmSaveAloneRoomInitInfoBean();
    } while (parama == null);
    int i = parama.getStatus();
    Object localObject1 = parama.getData();
    if (localObject1 != null) {
      this.Z = ((SaveAloneRoomInitInfoBean.SaveAloneRoomData)localObject1).getRoomFid();
    }
    if (i == 0)
    {
      parama = new Intent(this.C, MinsuReleaseActivity.class);
      parama.putExtra("isAloneRoomFinish", true);
      parama.putExtra("roomName", this.f.getText().toString());
      parama.putExtra("roomFid", this.Z);
      parama.putExtra("position", this.Y);
      setResult(-1, parama);
      finish();
      return;
    }
    showToast(parama.getMessage() + "");
    return;
    showToast(this.A.getSaveAloneRoomInitInfoErrorMsg());
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      j();
      return true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  protected void onStart()
  {
    super.onStart();
    this.aa.setCode("TIP_WRITE_ROOM_MSG");
  }
  
  private class a
    implements c.a
  {
    private a() {}
    
    public void onSingleSelect(String paramString, int paramInt)
    {
      AloneRoomInfoActivity.c(AloneRoomInfoActivity.this).setText(paramString);
      AloneRoomInfoActivity.c(AloneRoomInfoActivity.this).setTextColor(Color.parseColor("#444444"));
      if ((AloneRoomInfoActivity.d(AloneRoomInfoActivity.this) == null) || (AloneRoomInfoActivity.d(AloneRoomInfoActivity.this).isEmpty())) {
        return;
      }
      AloneRoomInfoActivity.a(AloneRoomInfoActivity.this, Integer.valueOf(((AloneRoomLimitPersonListBean.AloneRoomLimitPersonListDataBean)AloneRoomInfoActivity.d(AloneRoomInfoActivity.this).get(paramInt)).getValue()));
    }
  }
  
  private class b
    implements c.a
  {
    private b() {}
    
    public void onSingleSelect(String paramString, int paramInt)
    {
      AloneRoomInfoActivity.e(AloneRoomInfoActivity.this).setText(paramString);
      AloneRoomInfoActivity.e(AloneRoomInfoActivity.this).setTextColor(Color.parseColor("#444444"));
      if ((AloneRoomInfoActivity.f(AloneRoomInfoActivity.this) == null) || (AloneRoomInfoActivity.f(AloneRoomInfoActivity.this).isEmpty())) {}
      do
      {
        return;
        paramString = ((AloneRoomIsToiletListBean.AloneRoomIsToiletListDataBean)AloneRoomInfoActivity.f(AloneRoomInfoActivity.this).get(paramInt)).getValue();
      } while (TextUtils.isEmpty(paramString));
      AloneRoomInfoActivity.b(AloneRoomInfoActivity.this, Integer.valueOf(paramString));
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/landlordrelease/AloneRoomInfoActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */