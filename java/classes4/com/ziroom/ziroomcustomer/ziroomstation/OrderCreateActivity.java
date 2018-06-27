package com.ziroom.ziroomcustomer.ziroomstation;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Animatable;
import android.os.Bundle;
import android.text.Editable;
import android.text.Html;
import android.text.TextUtils;
import android.view.Display;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLayoutChangeListener;
import android.view.WindowManager;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.drawee.drawable.ScalingUtils.ScaleType;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.view.SimpleDraweeView;
import com.freelxl.baselibrary.e.i.a;
import com.freelxl.baselibrary.e.k;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.commonlibrary.widget.unifiedziroom.d.a;
import com.ziroom.commonlibrary.widget.unifiedziroom.d.b;
import com.ziroom.ziroomcustomer.activity.ListViewForScrollView;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.e.q;
import com.ziroom.ziroomcustomer.model.UserInfo;
import com.ziroom.ziroomcustomer.util.af;
import com.ziroom.ziroomcustomer.util.ah;
import com.ziroom.ziroomcustomer.util.m;
import com.ziroom.ziroomcustomer.util.n;
import com.ziroom.ziroomcustomer.util.s;
import com.ziroom.ziroomcustomer.util.w;
import com.ziroom.ziroomcustomer.widget.LabeledEditText;
import com.ziroom.ziroomcustomer.widget.LabeledEditText.a;
import com.ziroom.ziroomcustomer.ziroomstation.adapter.e;
import com.ziroom.ziroomcustomer.ziroomstation.adapter.f;
import com.ziroom.ziroomcustomer.ziroomstation.c.a.a;
import com.ziroom.ziroomcustomer.ziroomstation.dialog.c.a;
import com.ziroom.ziroomcustomer.ziroomstation.dialog.c.b;
import com.ziroom.ziroomcustomer.ziroomstation.model.DaysPrice;
import com.ziroom.ziroomcustomer.ziroomstation.model.OrderCreateResult;
import com.ziroom.ziroomcustomer.ziroomstation.model.OrderCreateResult.DataEntity;
import com.ziroom.ziroomcustomer.ziroomstation.model.OrderMoneyDetails;
import com.ziroom.ziroomcustomer.ziroomstation.model.OrderMoneyDetails.DataBean;
import com.ziroom.ziroomcustomer.ziroomstation.model.OrderMoneyDetails.DataBean.ListOrderPriceVoBean;
import com.ziroom.ziroomcustomer.ziroomstation.model.OrderMoneyDetails.DataBean.ListOrderPriceVoBean.ListHouseTypePriceBean;
import com.ziroom.ziroomcustomer.ziroomstation.model.StationBaseData;
import com.ziroom.ziroomcustomer.ziroomstation.model.StationBaseData.DataEntity;
import com.ziroom.ziroomcustomer.ziroomstation.model.StationBookOrder;
import com.ziroom.ziroomcustomer.ziroomstation.model.StationBookOrder.DataBean;
import com.ziroom.ziroomcustomer.ziroomstation.model.StationCoupon;
import com.ziroom.ziroomcustomer.ziroomstation.model.StationCoupon.DataEntity;
import com.ziroom.ziroomcustomer.ziroomstation.model.StationOrderCreateHouseEntity;
import com.ziroom.ziroomcustomer.ziroomstation.model.StationRuleBean;
import com.ziroom.ziroomcustomer.ziroomstation.model.StationRuleBean.DataBean;
import com.ziroom.ziroomcustomer.ziroomstation.model.TypePrice;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class OrderCreateActivity
  extends BaseActivity
  implements View.OnClickListener
{
  private static int ac;
  private static int ad;
  private TextView A;
  private TextView B;
  private TextView C;
  private LabeledEditText D;
  private LabeledEditText E;
  private LabeledEditText F;
  private ListViewForScrollView G;
  private ListViewForScrollView H;
  private CheckBox I;
  private LinearLayout J;
  private e K;
  private f L;
  private com.ziroom.ziroomcustomer.ziroomstation.c.a M;
  private StationBaseData N;
  private Context O;
  private String P;
  private String Q;
  private float R;
  private String S;
  private long T;
  private long U;
  private SimpleDateFormat V = new SimpleDateFormat("yyyy年MM月dd日");
  private SimpleDateFormat W = new SimpleDateFormat("yyyy-MM-dd");
  private boolean X = false;
  private OrderCreateResult Y;
  private StationCoupon Z;
  d.a a;
  private StationCoupon.DataEntity aa;
  private String ab;
  private boolean ae = false;
  private boolean af = false;
  private boolean ag = false;
  private boolean ah = false;
  private String ai;
  private String aj;
  private ArrayList<DaysPrice> ak;
  private List<StationOrderCreateHouseEntity> al;
  private String am;
  private float an;
  private com.ziroom.ziroomcustomer.ziroomstation.dialog.c ao;
  private boolean ap = false;
  private String b = OrderCreateActivity.class.getSimpleName();
  private View c;
  private View d;
  private View e;
  private View f;
  private View g;
  private View r;
  private View s;
  private View t;
  private View u;
  private View v;
  private SimpleDraweeView w;
  private TextView x;
  private TextView y;
  private TextView z;
  
  private void a(String paramString1, String paramString2)
  {
    this.a = com.ziroom.commonlibrary.widget.unifiedziroom.d.newBuilder(this).setOnConfirmClickListener(new d.b()
    {
      public void onLeftClick(View paramAnonymousView) {}
      
      public void onRightClick(View paramAnonymousView)
      {
        OrderCreateActivity.f(OrderCreateActivity.this);
      }
    }).setTitle(paramString1).setContent(paramString2).setButtonText("取消", "确定");
  }
  
  private void b()
  {
    w.onEventToZiroomAndUmeng("zinn_booking");
    com.ziroom.ziroomcustomer.ziroomstation.b.c.submitStationOrder(this.O, com.ziroom.ziroomcustomer.ziroomstation.b.b.buildSubmitOrder(this.O, this.S, "", new SimpleDateFormat("yyyy-MM-dd").format(new Date(this.T)), new SimpleDateFormat("yyyy-MM-dd").format(new Date(this.U)), this.D.getText().toString(), this.E.getText().toString(), this.F.getText().toString(), this.ab, this.aa, null, this.an, this.M.getmHouseLt(), this.M.getmUserLt()), new i.a()
    {
      public void onParse(String paramAnonymousString, k paramAnonymousk) {}
      
      public void onSuccess(k paramAnonymousk)
      {
        OrderCreateActivity.a(OrderCreateActivity.this, (OrderCreateResult)paramAnonymousk.getObject());
        if ((OrderCreateActivity.g(OrderCreateActivity.this) != null) && ("200".equals(OrderCreateActivity.g(OrderCreateActivity.this).getError_code()))) {
          if ("null".equals(OrderCreateActivity.g(OrderCreateActivity.this).getData().getPayOrderNumber()))
          {
            paramAnonymousk = new Intent(OrderCreateActivity.this, OrderDetailActivity.class);
            paramAnonymousk.putExtra("orderBid", OrderCreateActivity.g(OrderCreateActivity.this).getData().getOrderBid());
            OrderCreateActivity.this.startActivity(paramAnonymousk);
            OrderCreateActivity.this.finish();
          }
        }
        while ((OrderCreateActivity.g(OrderCreateActivity.this) == null) || (TextUtils.isEmpty(OrderCreateActivity.g(OrderCreateActivity.this).getError_message())))
        {
          return;
          OrderCreateActivity.a(OrderCreateActivity.this, new com.ziroom.ziroomcustomer.ziroomstation.dialog.c(OrderCreateActivity.c(OrderCreateActivity.this), OrderCreateActivity.g(OrderCreateActivity.this).getData().getPayOrderNumber(), OrderCreateActivity.h(OrderCreateActivity.this).getTotalPrice(), new c.b()
          {
            public void callback()
            {
              Intent localIntent = new Intent(OrderCreateActivity.this, OrderDetailActivity.class);
              localIntent.putExtra("orderBid", OrderCreateActivity.g(OrderCreateActivity.this).getData().getOrderBid());
              OrderCreateActivity.this.startActivity(localIntent);
              OrderCreateActivity.this.finish();
            }
          }, 2));
          OrderCreateActivity.i(OrderCreateActivity.this).show();
          return;
        }
        af.showToast(OrderCreateActivity.c(OrderCreateActivity.this), OrderCreateActivity.g(OrderCreateActivity.this).getError_message());
      }
    }, true);
  }
  
  private void d(String paramString)
  {
    paramString = com.ziroom.ziroomcustomer.ziroomstation.b.b.buildRules(this.O, this.S, paramString);
    com.freelxl.baselibrary.d.a.post(q.T + com.ziroom.ziroomcustomer.ziroomstation.b.d.I).params(paramString).enqueue(new com.freelxl.baselibrary.d.c.a(new com.freelxl.baselibrary.d.f.d(StationRuleBean.class))
    {
      public void onFailure(Throwable paramAnonymousThrowable) {}
      
      public void onSuccess(int paramAnonymousInt, StationRuleBean paramAnonymousStationRuleBean)
      {
        paramAnonymousStationRuleBean = paramAnonymousStationRuleBean.getData();
        if ((paramAnonymousStationRuleBean != null) && (paramAnonymousStationRuleBean.size() > 0))
        {
          OrderCreateActivity.a(OrderCreateActivity.this, ((StationRuleBean.DataBean)paramAnonymousStationRuleBean.get(0)).getContent());
          OrderCreateActivity.b(OrderCreateActivity.this, ((StationRuleBean.DataBean)paramAnonymousStationRuleBean.get(0)).getTitle());
        }
      }
    });
  }
  
  private void e()
  {
    this.c = findViewById(2131690078);
    this.d = findViewById(2131693446);
    this.w = ((SimpleDraweeView)findViewById(2131693445));
    ((GenericDraweeHierarchy)this.w.getHierarchy()).setActualImageScaleType(ScalingUtils.ScaleType.FIT_XY);
    this.x = ((TextView)findViewById(2131690434));
    this.y = ((TextView)findViewById(2131693448));
    this.z = ((TextView)findViewById(2131693449));
    this.G = ((ListViewForScrollView)findViewById(2131693451));
    this.H = ((ListViewForScrollView)findViewById(2131693457));
    this.e = findViewById(2131693458);
    this.f = findViewById(2131693460);
    this.e.setVisibility(8);
    this.f.setVisibility(0);
    this.D = ((LabeledEditText)findViewById(2131693452));
    this.E = ((LabeledEditText)findViewById(2131693454));
    this.D.setBottomHint(Html.fromHtml("<font color='#999999'>联系人</font><font color='#FF6262'>*</font>"));
    this.D.setTopHint(Html.fromHtml("<font color='#999999'>联系人</font><font color='#FF6262'>*</font>"));
    this.E.setBottomHint(Html.fromHtml("<font color='#999999'>手机号</font><font color='#FF6262'>*</font>"));
    this.E.setTopHint(Html.fromHtml("<font color='#999999'>手机号</font><font color='#FF6262'>*</font>"));
    this.g = findViewById(2131693469);
    this.r = findViewById(2131693467);
    this.A = ((TextView)findViewById(2131693468));
    this.I = ((CheckBox)findViewById(2131693465));
    this.s = findViewById(2131693466);
    this.t = findViewById(2131693461);
    this.F = ((LabeledEditText)findViewById(2131693456));
    this.B = ((TextView)findViewById(2131693464));
    this.v = findViewById(2131691738);
    this.u = findViewById(2131690425);
    this.J = ((LinearLayout)findViewById(2131693450));
    this.C = ((TextView)findViewById(2131693447));
  }
  
  private void f()
  {
    com.ziroom.ziroomcustomer.ziroomstation.b.c.getBaseData(this.O, new a(null), com.ziroom.ziroomcustomer.ziroomstation.b.b.buildGetBaseData(this), true);
    Object localObject = getIntent();
    this.P = ((Intent)localObject).getExtras().getString("projectPicUrl", "");
    this.w.setController(com.freelxl.baselibrary.f.c.frescoController(this.P, new BaseControllerListener()
    {
      public void onFailure(String paramAnonymousString, Throwable paramAnonymousThrowable)
      {
        super.onFailure(paramAnonymousString, paramAnonymousThrowable);
        OrderCreateActivity.j(OrderCreateActivity.this).setVisibility(0);
      }
      
      public void onFinalImageSet(String paramAnonymousString, Object paramAnonymousObject, Animatable paramAnonymousAnimatable)
      {
        super.onFinalImageSet(paramAnonymousString, paramAnonymousObject, paramAnonymousAnimatable);
        OrderCreateActivity.j(OrderCreateActivity.this).setVisibility(8);
      }
    }));
    this.ak = ((ArrayList)((Intent)localObject).getSerializableExtra("dayRoomInfos"));
    this.Q = ((Intent)localObject).getExtras().getString("projectName", "自如驿");
    this.x.setText(this.Q);
    this.S = ((Intent)localObject).getExtras().getString("projectBid", "");
    this.T = ((Intent)localObject).getExtras().getLong("startDate");
    this.y.setText(this.V.format(new Date(this.T)));
    this.U = ((Intent)localObject).getExtras().getLong("endDate");
    this.z.setText(this.V.format(new Date(this.U)));
    int i = (int)m.getDaysBetween(new Date(this.T), new Date(this.U));
    this.C.setText("共" + i + "晚");
    localObject = ApplicationEx.c.getUser();
    if (localObject != null)
    {
      if (!TextUtils.isEmpty(((UserInfo)localObject).getUser_name())) {
        this.D.setText(((UserInfo)localObject).getUser_name());
      }
      if (!TextUtils.isEmpty(((UserInfo)localObject).getLogin_name_mobile())) {
        this.E.setText(((UserInfo)localObject).getLogin_name_mobile());
      }
      if (!TextUtils.isEmpty(((UserInfo)localObject).getLogin_name_email())) {
        this.F.setText(((UserInfo)localObject).getLogin_name_email());
      }
    }
    else
    {
      this.al = new ArrayList();
      if (s.isEmpty(this.ak)) {
        break label651;
      }
      i = 0;
    }
    for (;;)
    {
      if (i >= ((DaysPrice)this.ak.get(0)).typePriceList.size()) {
        break label651;
      }
      int j = 0;
      int k = 0;
      for (;;)
      {
        if (j < this.ak.size())
        {
          k += (int)((TypePrice)((DaysPrice)this.ak.get(j)).typePriceList.get(i)).typePrice;
          j += 1;
          continue;
          if (TextUtils.isEmpty(((UserInfo)localObject).getEmail())) {
            break;
          }
          this.F.setText(((UserInfo)localObject).getEmail());
          break;
        }
      }
      this.al.add(new StationOrderCreateHouseEntity(((TypePrice)((DaysPrice)this.ak.get(0)).typePriceList.get(i)).availableCount, ((TypePrice)((DaysPrice)this.ak.get(0)).typePriceList.get(i)).num, ((TypePrice)((DaysPrice)this.ak.get(0)).typePriceList.get(i)).roomName + "/" + ((TypePrice)((DaysPrice)this.ak.get(0)).typePriceList.get(i)).typeName, k, ((TypePrice)((DaysPrice)this.ak.get(0)).typePriceList.get(i)).houseTypeBid, 0));
      i += 1;
    }
    label651:
    d("100");
  }
  
  private void g()
  {
    this.J.setOnClickListener(this);
    this.c.setOnClickListener(this);
    this.e.setOnClickListener(this);
    this.r.setOnClickListener(this);
    this.I.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
    {
      @Instrumented
      public void onCheckedChanged(CompoundButton paramAnonymousCompoundButton, boolean paramAnonymousBoolean)
      {
        VdsAgent.onCheckedChanged(this, paramAnonymousCompoundButton, paramAnonymousBoolean);
        OrderCreateActivity.a(OrderCreateActivity.this, paramAnonymousBoolean);
        if ((OrderCreateActivity.h(OrderCreateActivity.this) != null) && (OrderCreateActivity.h(OrderCreateActivity.this).getmInterface() != null)) {
          OrderCreateActivity.h(OrderCreateActivity.this).getmInterface().refresh();
        }
        OrderCreateActivity.b(OrderCreateActivity.this, true);
      }
    });
    this.s.setOnClickListener(this);
    this.t.setOnClickListener(this);
    this.g.setOnClickListener(this);
    this.D.addTextChangedListener(new LabeledEditText.a()
    {
      public void afterTextChanged(Editable paramAnonymousEditable)
      {
        if ((OrderCreateActivity.h(OrderCreateActivity.this) != null) && (OrderCreateActivity.h(OrderCreateActivity.this).getmInterface() != null)) {
          OrderCreateActivity.h(OrderCreateActivity.this).getmInterface().refresh();
        }
        OrderCreateActivity.c(OrderCreateActivity.this, true);
      }
      
      public void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
    });
    this.E.addTextChangedListener(new LabeledEditText.a()
    {
      public void afterTextChanged(Editable paramAnonymousEditable)
      {
        if ((OrderCreateActivity.h(OrderCreateActivity.this) != null) && (OrderCreateActivity.h(OrderCreateActivity.this).getmInterface() != null)) {
          OrderCreateActivity.h(OrderCreateActivity.this).getmInterface().refresh();
        }
        OrderCreateActivity.d(OrderCreateActivity.this, true);
      }
      
      public void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
    });
    this.F.addTextChangedListener(new LabeledEditText.a()
    {
      public void afterTextChanged(Editable paramAnonymousEditable)
      {
        OrderCreateActivity.e(OrderCreateActivity.this, true);
      }
      
      public void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
    });
  }
  
  private boolean h()
  {
    if ((TextUtils.isEmpty(this.D.getText().toString().trim())) || (TextUtils.isEmpty(this.E.getText().toString().trim())) || (this.M == null)) {}
    do
    {
      return false;
      if (this.R == 0.0F)
      {
        af.showToast(this.O, "入住人数量不能为0！");
        return false;
      }
      if (!this.X)
      {
        af.showToast(this.O, "请同意入住规则才能提交订单！");
        return false;
      }
      if (!com.ziroom.ziroomcustomer.ziroomstation.utils.i.checkMobilePhone(this.E.getText().toString().trim()))
      {
        af.showToast(ApplicationEx.c, "手机号格式错误，请核实后重新填写");
        return false;
      }
    } while (!this.M.checkIdentityCard());
    if ((!TextUtils.isEmpty(this.F.getText().toString())) && (!com.ziroom.ziroomcustomer.ziroomstation.utils.i.checkEmail(this.F.getText().toString())))
    {
      af.showToast(this.O, "邮箱格式错误，请核实后重新填写");
      return false;
    }
    return true;
  }
  
  private void i()
  {
    if (this.M != null) {
      if (this.an <= this.M.getCouponPrice()) {
        break label74;
      }
    }
    label74:
    for (float f1 = this.an - this.M.getCouponPrice();; f1 = 0.0F)
    {
      this.R = f1;
      this.A.setText("¥" + (int)this.R);
      return;
    }
  }
  
  private void j()
  {
    if (this.ah) {
      w.onEventToZiroomAndUmeng("zinn_book_agree");
    }
    if (this.af) {
      w.onEventToZiroomAndUmeng("zinn_book_email");
    }
    if (this.ae) {
      w.onEventToZiroomAndUmeng("zinn_book_name");
    }
    if (this.ag) {
      w.onEventToZiroomAndUmeng("zinn_book_telnum");
    }
  }
  
  private void k()
  {
    Map localMap = com.ziroom.ziroomcustomer.ziroomstation.b.b.buildOrderMoney(this.O, this.S, "", new SimpleDateFormat("yyyy-MM-dd").format(new Date(this.T)), new SimpleDateFormat("yyyy-MM-dd").format(new Date(this.U)), this.ab, this.aa, this.al);
    com.ziroom.ziroomcustomer.ziroomstation.b.c.getOrderMoney(this.O, localMap, new i.a()
    {
      public void onParse(String paramAnonymousString, k paramAnonymousk) {}
      
      public void onSuccess(k paramAnonymousk)
      {
        Object localObject1 = (OrderMoneyDetails)paramAnonymousk.getObject();
        if ((localObject1 != null) && ("200".equals(((OrderMoneyDetails)localObject1).getError_code())))
        {
          OrderCreateActivity.a(OrderCreateActivity.this, ((OrderMoneyDetails)localObject1).getData().getAmount());
          OrderCreateActivity.c(OrderCreateActivity.this, ((OrderMoneyDetails)localObject1).getData().getPromptStr());
          paramAnonymousk = new ArrayList();
          Object localObject2 = ((OrderMoneyDetails)localObject1).getData().getListOrderPriceVo();
          if (s.isEmpty((List)localObject2)) {}
          do
          {
            return;
            int i = 0;
            int j;
            if (i < ((List)localObject2).size())
            {
              DaysPrice localDaysPrice = new DaysPrice();
              localDaysPrice.dayDate = m.changeFormatToDate(((OrderMoneyDetails.DataBean.ListOrderPriceVoBean)((List)localObject2).get(i)).getOrderDay(), m.b, m.l);
              ArrayList localArrayList = new ArrayList();
              List localList = ((OrderMoneyDetails.DataBean.ListOrderPriceVoBean)((OrderMoneyDetails)localObject1).getData().getListOrderPriceVo().get(i)).getListHouseTypePrice();
              if (s.isEmpty(localList)) {}
              for (;;)
              {
                i += 1;
                break;
                j = 0;
                while (j < localList.size())
                {
                  TypePrice localTypePrice = new TypePrice();
                  localTypePrice.roomName = ((OrderMoneyDetails.DataBean.ListOrderPriceVoBean.ListHouseTypePriceBean)localList.get(j)).getHouseTypeParentShowName();
                  localTypePrice.typeName = ((OrderMoneyDetails.DataBean.ListOrderPriceVoBean.ListHouseTypePriceBean)localList.get(j)).getHouseTypeName();
                  localTypePrice.isPreferential = ((OrderMoneyDetails.DataBean.ListOrderPriceVoBean.ListHouseTypePriceBean)localList.get(j)).getIsPreferential();
                  localTypePrice.typePrice = ((OrderMoneyDetails.DataBean.ListOrderPriceVoBean.ListHouseTypePriceBean)localList.get(j)).getPrice();
                  localTypePrice.num = ((OrderMoneyDetails.DataBean.ListOrderPriceVoBean.ListHouseTypePriceBean)localList.get(j)).getQuantity();
                  localTypePrice.houseTypeBid = ((OrderMoneyDetails.DataBean.ListOrderPriceVoBean.ListHouseTypePriceBean)localList.get(j)).getHouseTypeBid();
                  localArrayList.add(localTypePrice);
                  j += 1;
                }
                localDaysPrice.typePriceList = localArrayList;
                paramAnonymousk.add(localDaysPrice);
              }
            }
            localObject1 = new ArrayList();
            i = 0;
            while (i < ((DaysPrice)paramAnonymousk.get(0)).typePriceList.size())
            {
              j = 0;
              int k = 0;
              while (j < paramAnonymousk.size())
              {
                k += (int)((TypePrice)((DaysPrice)OrderCreateActivity.m(OrderCreateActivity.this).get(j)).typePriceList.get(i)).typePrice;
                j += 1;
              }
              ((List)localObject1).add(new StationOrderCreateHouseEntity(((TypePrice)((DaysPrice)paramAnonymousk.get(0)).typePriceList.get(i)).availableCount, ((TypePrice)((DaysPrice)paramAnonymousk.get(0)).typePriceList.get(i)).num, ((TypePrice)((DaysPrice)paramAnonymousk.get(0)).typePriceList.get(i)).roomName + "/" + ((TypePrice)((DaysPrice)paramAnonymousk.get(0)).typePriceList.get(i)).typeName, k, ((TypePrice)((DaysPrice)paramAnonymousk.get(0)).typePriceList.get(i)).houseTypeBid, 0));
              i += 1;
            }
            localObject2 = new ArrayList();
            ((List)localObject2).addAll(OrderCreateActivity.a(OrderCreateActivity.this).getData().getCredentialType());
            OrderCreateActivity.a(OrderCreateActivity.this, new com.ziroom.ziroomcustomer.ziroomstation.c.a(OrderCreateActivity.c(OrderCreateActivity.this), (List)localObject2, (List)localObject1, new a.a()
            {
              public void refresh()
              {
                OrderCreateActivity.n(OrderCreateActivity.this).notifyDataSetChanged();
                OrderCreateActivity.o(OrderCreateActivity.this).notifyDataSetChanged();
                OrderCreateActivity.p(OrderCreateActivity.this);
                if ((OrderCreateActivity.h(OrderCreateActivity.this) != null) && (!TextUtils.isEmpty(OrderCreateActivity.q(OrderCreateActivity.this).getText().toString().trim())) && (!TextUtils.isEmpty(OrderCreateActivity.r(OrderCreateActivity.this).getText().toString().trim())) && (OrderCreateActivity.s(OrderCreateActivity.this)) && (OrderCreateActivity.h(OrderCreateActivity.this).getTotalPrice() != 0))
                {
                  OrderCreateActivity.t(OrderCreateActivity.this).setBackgroundResource(2130838257);
                  return;
                }
                OrderCreateActivity.t(OrderCreateActivity.this).setBackgroundColor(Color.parseColor("#d1d1d1"));
              }
            }, paramAnonymousk));
            OrderCreateActivity.a(OrderCreateActivity.this, new e(OrderCreateActivity.c(OrderCreateActivity.this), OrderCreateActivity.h(OrderCreateActivity.this)));
            OrderCreateActivity.u(OrderCreateActivity.this).setAdapter(OrderCreateActivity.n(OrderCreateActivity.this));
            OrderCreateActivity.a(OrderCreateActivity.this, new f(OrderCreateActivity.c(OrderCreateActivity.this), OrderCreateActivity.h(OrderCreateActivity.this)));
            OrderCreateActivity.v(OrderCreateActivity.this).setAdapter(OrderCreateActivity.o(OrderCreateActivity.this));
            OrderCreateActivity.this.requestTickets();
            OrderCreateActivity.a(OrderCreateActivity.this, true);
            OrderCreateActivity.w(OrderCreateActivity.this).setChecked(true);
          } while ((OrderCreateActivity.h(OrderCreateActivity.this) == null) || (OrderCreateActivity.h(OrderCreateActivity.this).getmInterface() == null));
          OrderCreateActivity.h(OrderCreateActivity.this).getmInterface().refresh();
          return;
        }
        af.showToast(OrderCreateActivity.c(OrderCreateActivity.this), ((OrderMoneyDetails)localObject1).getError_message());
      }
    }, false);
  }
  
  public void getHintInfo()
  {
    com.ziroom.ziroomcustomer.ziroomstation.b.c.getStationBookOrderInfo(this.O, com.ziroom.ziroomcustomer.ziroomstation.b.b.buildBookOrderInfo(this, this.S, this.ab), new i.a()
    {
      public void onParse(String paramAnonymousString, k paramAnonymousk) {}
      
      public void onSuccess(k paramAnonymousk)
      {
        paramAnonymousk = (StationBookOrder)paramAnonymousk.getObject();
        if ((paramAnonymousk != null) && ("200".equals(paramAnonymousk.getError_code())) && (paramAnonymousk.getData() != null) && (!TextUtils.isEmpty(paramAnonymousk.getData().getCheckInRules()))) {
          OrderCreateActivity.a(OrderCreateActivity.this, paramAnonymousk.getData().getCheckInTitle(), paramAnonymousk.getData().getCheckInRules());
        }
      }
    }, true);
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramInt2 == -1) && (paramInt1 == 1))
    {
      StationCoupon.DataEntity localDataEntity = (StationCoupon.DataEntity)paramIntent.getExtras().getSerializable("couponItem");
      if (localDataEntity != null)
      {
        this.aa = localDataEntity;
        this.B.setText("¥ " + this.aa.getAmount());
        if (this.M != null) {
          this.M.setCouponPrice(this.aa.getAmount());
        }
        i();
      }
    }
    if ((this.ao != null) && (!this.ap))
    {
      this.ap = true;
      this.ao.getCallback().doInActivityResult(this.O, paramInt1, paramInt2, paramIntent);
    }
  }
  
  @Instrumented
  public void onClick(View paramView)
  {
    VdsAgent.onClick(this, paramView);
    if (paramView != null) {
      switch (paramView.getId())
      {
      }
    }
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              return;
              if ((!TextUtils.isEmpty(this.ai)) && (!TextUtils.isEmpty(this.aj)))
              {
                paramView = new Intent(this, StationInfoActivity.class);
                paramView.putExtra("content", this.ai);
                paramView.putExtra("title", this.aj);
                startActivity(paramView);
                overridePendingTransition(2130968591, 2130968592);
                return;
              }
              af.showToast(this.O, "数据刷新中，请稍后...");
              return;
              finish();
              return;
            } while (this.M == null);
            this.M.addOtherUser();
            this.L.setmList(this.M.getmUserLt());
            w.onEventToZiroomAndUmeng("zinn_book_checkin_add");
            return;
          } while (!h());
          if (!ah.checkNet(this.O))
          {
            af.showToast(this.O, 2131297483);
            return;
          }
        } while (this.M == null);
        if (this.a != null)
        {
          this.a.show();
          return;
        }
        b();
        return;
      } while ((this.M == null) || (this.M.getDaysPriceList() == null) || (this.M.getDaysPriceList().size() <= 0));
      new com.ziroom.ziroomcustomer.ziroomstation.projectdetail.view.b(this.O, this.M.getDaysPriceList(), this.an, this.am, new com.ziroom.ziroomcustomer.ziroomstation.a.a()
      {
        public void callback(int paramAnonymousInt)
        {
          w.onDuration("zinn_book_price_duration", paramAnonymousInt);
        }
      }).showPriceWindow();
      w.onEventToZiroomAndUmeng("zinn_book_price");
      return;
      paramView = new Intent(this, StationWebActivity.class);
      paramView.putExtra("url", "http://www.ziroom.com/zhuanti/zry/ht/ruzhu.html");
      paramView.putExtra("title", "入住与退款规则");
      startActivity(paramView);
      return;
    } while (this.M == null);
    paramView = new Intent(this, StationCouponActivity.class);
    paramView.putExtra("projectBid", this.S);
    paramView.putExtra("startDate", this.W.format(new Date(this.T)));
    paramView.putExtra("endDate", this.W.format(new Date(this.U)));
    paramView.putExtra("HouseList", com.alibaba.fastjson.a.toJSONString(this.M.getmHouseLt()));
    startActivityForResult(paramView, 1);
    w.onEventToZiroomAndUmeng("zinn_book_sale");
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903702);
    this.O = this;
    if (ApplicationEx.c.getUser() != null) {
      this.ab = ApplicationEx.c.getUser().getUid();
    }
    e();
    g();
    f();
    com.ziroom.ziroomcustomer.minsu.f.i.StationHouseDetail(this, this.S);
    ac = getWindowManager().getDefaultDisplay().getHeight();
    ad = ac / 3;
  }
  
  protected void onDestroy()
  {
    j();
    super.onDestroy();
  }
  
  protected void onResume()
  {
    a("zinn_booking_duration");
    super.onResume();
    this.u.addOnLayoutChangeListener(new View.OnLayoutChangeListener()
    {
      public void onLayoutChange(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, int paramAnonymousInt4, int paramAnonymousInt5, int paramAnonymousInt6, int paramAnonymousInt7, int paramAnonymousInt8)
      {
        if ((paramAnonymousInt8 != 0) && (paramAnonymousInt4 != 0) && (paramAnonymousInt8 - paramAnonymousInt4 > OrderCreateActivity.a()))
        {
          paramAnonymousView = OrderCreateActivity.k(OrderCreateActivity.this).getLayoutParams();
          paramAnonymousView.height = 0;
          OrderCreateActivity.k(OrderCreateActivity.this).setLayoutParams(paramAnonymousView);
        }
        while ((paramAnonymousInt8 == 0) || (paramAnonymousInt4 == 0) || (paramAnonymousInt4 - paramAnonymousInt8 <= OrderCreateActivity.a())) {
          return;
        }
        paramAnonymousView = OrderCreateActivity.k(OrderCreateActivity.this).getLayoutParams();
        paramAnonymousView.height = n.dip2px(OrderCreateActivity.c(OrderCreateActivity.this), 52.0F);
        OrderCreateActivity.k(OrderCreateActivity.this).setLayoutParams(paramAnonymousView);
        OrderCreateActivity.l(OrderCreateActivity.this).clearFocus();
      }
    });
  }
  
  public void requestTickets()
  {
    com.ziroom.ziroomcustomer.ziroomstation.b.c.getStationTickets(this.O, com.ziroom.ziroomcustomer.ziroomstation.b.b.buildStationTickets(this, this.S, this.ab, this.W.format(new Date(this.T)), this.W.format(new Date(this.U)), this.M.getmHouseLt()), new i.a()
    {
      public void onParse(String paramAnonymousString, k paramAnonymousk) {}
      
      public void onSuccess(k paramAnonymousk)
      {
        int i = 0;
        OrderCreateActivity.a(OrderCreateActivity.this, (StationCoupon)paramAnonymousk.getObject());
        if ((OrderCreateActivity.d(OrderCreateActivity.this) != null) && ("200".equals(OrderCreateActivity.d(OrderCreateActivity.this).getError_code())))
        {
          int k;
          for (int j = 0; i < OrderCreateActivity.d(OrderCreateActivity.this).getData().size(); j = k)
          {
            k = j;
            if (((StationCoupon.DataEntity)OrderCreateActivity.d(OrderCreateActivity.this).getData().get(i)).isIsUsable()) {
              k = j + 1;
            }
            i += 1;
          }
          OrderCreateActivity.e(OrderCreateActivity.this).setText(j + "张可用");
        }
      }
    }, true);
  }
  
  private class a
    implements i.a<String>
  {
    private a() {}
    
    public void onParse(String paramString, k paramk) {}
    
    public void onSuccess(k paramk)
    {
      OrderCreateActivity.a(OrderCreateActivity.this, (StationBaseData)paramk.getObject());
      if ((OrderCreateActivity.a(OrderCreateActivity.this) != null) && ("200".equals(OrderCreateActivity.a(OrderCreateActivity.this).getError_code())))
      {
        OrderCreateActivity.b(OrderCreateActivity.this);
        OrderCreateActivity.this.getHintInfo();
      }
      while ((paramk.getObject() == null) || (TextUtils.isEmpty(((StationBaseData)paramk.getObject()).getError_message()))) {
        return;
      }
      af.showToast(OrderCreateActivity.c(OrderCreateActivity.this), ((StationBaseData)paramk.getObject()).getError_message());
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes4-dex2jar.jar!/com/ziroom/ziroomcustomer/ziroomstation/OrderCreateActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */