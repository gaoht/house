package com.ziroom.ziroomcustomer.minsu.activity;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextPaint;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLayoutChangeListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.TextView;
import com.freelxl.baselibrary.a.b;
import com.freelxl.baselibrary.e.i.a;
import com.freelxl.baselibrary.f.d;
import com.freelxl.baselibrary.f.g;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.collection.GrowingIO;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.commonlibrary.widget.unifiedziroom.c.a;
import com.ziroom.commonlibrary.widget.unifiedziroom.c.b;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuContactsListBean.ListUsualContactBean;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuCreateOrderBean;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuCreateOrderBean.DataBean;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuFindBookerContactsBean;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuFindBookerContactsBean.DataBean;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuFindBookerContactsBean.DataBean.BookerDetailBean;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuNeedPayV4Bean;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuNeedPayV4Bean.DataBean;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuNeedPayV4Bean.DataBean.AcItemListBean;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuNeedPayV4Bean.DataBean.CouponBean;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuNeedPayV4Bean.DataBean.DepositBean;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuNeedPayV4Bean.DataBean.LabelTipsListBean;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuNeedPayV4Bean.DataBean.NoticesBean;
import com.ziroom.ziroomcustomer.minsu.bean.OrderStatusEnum;
import com.ziroom.ziroomcustomer.minsu.f.ab;
import com.ziroom.ziroomcustomer.minsu.f.ad;
import com.ziroom.ziroomcustomer.minsu.f.v;
import com.ziroom.ziroomcustomer.minsu.view.CommonTitle;
import com.ziroom.ziroomcustomer.util.ae;
import com.ziroom.ziroomcustomer.util.m;
import com.ziroom.ziroomcustomer.widget.ListViewForScrollView;
import com.ziroom.ziroomcustomer.widget.ObservableScrollView;
import com.ziroom.ziroomcustomer.widget.ObservableScrollView.a;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class MinsuApplyActivity
  extends BaseActivity
  implements View.OnClickListener, PopupWindow.OnDismissListener, ObservableScrollView.a
{
  private TextView A;
  private LinearLayout B;
  private TextView C;
  private View D;
  private ListViewForScrollView E;
  private ArrayList<MinsuNeedPayV4Bean.DataBean.NoticesBean> F = new ArrayList();
  private Map<Integer, Integer> G = new HashMap();
  private com.freelxl.baselibrary.a.a<MinsuNeedPayV4Bean.DataBean.NoticesBean> H;
  private TextView I;
  private TextView J;
  private TextView K;
  private TextView L;
  private final int M = 1;
  private final int N = 2;
  private EditText O;
  private CheckBox P;
  private TextView Q;
  private TextView R;
  private TextView S;
  private TextView T;
  private TextView U;
  private CommonTitle V;
  private OrderStatusEnum W;
  private String X;
  private String Y;
  private String Z;
  private LinearLayout a;
  private int aa;
  private int ab = -1;
  private String ac;
  private Calendar ad;
  private Calendar ae;
  private MinsuNeedPayV4Bean af;
  private MinsuFindBookerContactsBean ag;
  private int ah;
  private int ai;
  private String aj;
  private ObservableScrollView ak;
  private boolean al = true;
  private String am = "";
  private String an = "";
  private TextView b;
  private String c;
  private LinearLayout d;
  private LinearLayout e;
  private TextView f;
  private TextView g;
  private TextView r;
  private TextView s;
  private int t = 0;
  private ListViewForScrollView u;
  private View v;
  private ArrayList<MinsuContactsListBean.ListUsualContactBean> w = new ArrayList();
  private com.freelxl.baselibrary.a.a<MinsuContactsListBean.ListUsualContactBean> x;
  private TextView y;
  private TextView z;
  
  private MinsuContactsListBean.ListUsualContactBean a(MinsuFindBookerContactsBean.DataBean.BookerDetailBean paramBookerDetailBean)
  {
    MinsuContactsListBean.ListUsualContactBean localListUsualContactBean = new MinsuContactsListBean.ListUsualContactBean();
    localListUsualContactBean.fid = paramBookerDetailBean.fid;
    localListUsualContactBean.conName = paramBookerDetailBean.conName;
    localListUsualContactBean.conTel = paramBookerDetailBean.conTel;
    localListUsualContactBean.userUid = paramBookerDetailBean.userUid;
    localListUsualContactBean.cardType = paramBookerDetailBean.cardType.intValue();
    localListUsualContactBean.cardValue = paramBookerDetailBean.cardValue;
    return localListUsualContactBean;
  }
  
  private void a()
  {
    findViewById(2131691207).addOnLayoutChangeListener(new View.OnLayoutChangeListener()
    {
      public void onLayoutChange(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, int paramAnonymousInt4, int paramAnonymousInt5, int paramAnonymousInt6, int paramAnonymousInt7, int paramAnonymousInt8)
      {
        if (paramAnonymousInt8 - paramAnonymousInt4 > 0) {
          MinsuApplyActivity.a(MinsuApplyActivity.this).smoothScrollBy(0, com.ziroom.commonlibrary.widget.gridpasswordview.c.dp2px(MinsuApplyActivity.this, 210));
        }
      }
    });
  }
  
  private void a(final String paramString1, final String paramString2, final int paramInt, final String paramString3)
  {
    com.ziroom.commonlibrary.widget.unifiedziroom.c.newBuilder(this).setTitle("提示").setContent(getString(2131296706)).setOnConfirmClickListener(new c.b()
    {
      public void onClick(View paramAnonymousView, boolean paramAnonymousBoolean)
      {
        if (paramAnonymousBoolean)
        {
          paramAnonymousView = new Intent(MinsuApplyActivity.this, MinsuFillBookerInfoActivity.class);
          paramAnonymousView.putExtra("username", paramString1);
          paramAnonymousView.putExtra("mobile", paramString2);
          paramAnonymousView.putExtra("idType", paramInt);
          paramAnonymousView.putExtra("idNumber", paramString3);
          MinsuApplyActivity.this.startActivityForResult(paramAnonymousView, 115);
          v.onClick(MinsuApplyActivity.this, "M-Go_to_fill");
          return;
        }
        MinsuApplyActivity.this.finish();
      }
    }).build().show();
  }
  
  private void a(String paramString1, String paramString2, TextView paramTextView1, TextView paramTextView2)
  {
    if ((paramString1 == null) || (paramString2 == null) || (paramTextView1 == null) || (paramTextView2 == null)) {
      return;
    }
    Object localObject1 = m.strToDate(paramString1, m.b);
    Object localObject2 = m.strToDate(paramString2, m.b);
    localObject1 = m.getFormatDate((Date)localObject1, "M月d日");
    localObject2 = m.getFormatDate((Date)localObject2, "M月d日");
    paramString1 = ad.getWeekFromDate(paramString1);
    paramString2 = ad.getWeekFromDate(paramString2);
    paramTextView1.setText((String)localObject1 + "\n" + paramString1);
    paramTextView2.setText((String)localObject2 + "\n" + paramString2);
  }
  
  private void b()
  {
    this.ak = ((ObservableScrollView)findViewById(2131689506));
    this.ak.setOnScrollChangedCallback(this);
    this.a = ((LinearLayout)findViewById(2131691209));
    this.b = ((TextView)findViewById(2131691210));
    this.b.setText(this.c);
    this.f = ((TextView)findViewById(2131691212));
    this.g = ((TextView)findViewById(2131691214));
    a(this.X, this.Y, this.f, this.g);
    this.e = ((LinearLayout)findViewById(2131691213));
    this.d = ((LinearLayout)findViewById(2131691211));
    this.r = ((TextView)findViewById(2131691215));
    this.r.setOnClickListener(this);
    this.s = ((TextView)findViewById(2131691218));
    this.s.setOnClickListener(this);
    this.u = ((ListViewForScrollView)findViewById(2131691217));
    this.v = findViewById(2131691216);
    this.y = ((TextView)findViewById(2131691219));
    this.z = ((TextView)findViewById(2131691221));
    this.z.setOnClickListener(this);
    this.A = ((TextView)findViewById(2131691222));
    this.B = ((LinearLayout)findViewById(2131691223));
    this.D = findViewById(2131691224);
    this.D.setOnClickListener(this);
    this.C = ((TextView)findViewById(2131691225));
    this.E = ((ListViewForScrollView)findViewById(2131691228));
    this.H = new com.freelxl.baselibrary.a.a(this, this.F, 2130904286)
    {
      public void convert(b paramAnonymousb, MinsuNeedPayV4Bean.DataBean.NoticesBean paramAnonymousNoticesBean)
      {
        paramAnonymousb.setText(2131695216, paramAnonymousNoticesBean.name);
        paramAnonymousb.getView(2131695215).setTag(2131689523, paramAnonymousNoticesBean);
        if (paramAnonymousNoticesBean.clickType.intValue() == 2)
        {
          if (((Integer)MinsuApplyActivity.b(MinsuApplyActivity.this).get(paramAnonymousNoticesBean.code)).intValue() == 1) {
            paramAnonymousb.setText(2131695217, MinsuApplyActivity.this.getString(2131297027));
          }
          while (((Integer)MinsuApplyActivity.b(MinsuApplyActivity.this).get(paramAnonymousNoticesBean.code)).intValue() != 0) {
            return;
          }
          paramAnonymousb.setText(2131695217, MinsuApplyActivity.this.getString(2131297165));
          return;
        }
        paramAnonymousb.setText(2131695217, MinsuApplyActivity.this.getString(2131297053));
      }
    };
    this.E.setAdapter(this.H);
    this.E.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      @Instrumented
      public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        VdsAgent.onItemClick(this, paramAnonymousAdapterView, paramAnonymousView, paramAnonymousInt, paramAnonymousLong);
        paramAnonymousAdapterView = (MinsuNeedPayV4Bean.DataBean.NoticesBean)paramAnonymousView.getTag(2131689523);
        if (paramAnonymousAdapterView.clickType.intValue() == 0) {
          return;
        }
        if (paramAnonymousAdapterView.clickType.intValue() == 2)
        {
          com.ziroom.ziroomcustomer.minsu.f.k.toMinsuInfoActivity1(MinsuApplyActivity.this, paramAnonymousAdapterView.code.intValue(), MinsuApplyActivity.c(MinsuApplyActivity.this), MinsuApplyActivity.d(MinsuApplyActivity.this), -1, 127);
          return;
        }
        com.ziroom.ziroomcustomer.minsu.f.k.toMinsuInfoActivity(MinsuApplyActivity.this, paramAnonymousAdapterView.code.intValue(), MinsuApplyActivity.c(MinsuApplyActivity.this), MinsuApplyActivity.d(MinsuApplyActivity.this));
      }
    });
    this.I = ((TextView)findViewById(2131689835));
    this.J = ((TextView)findViewById(2131690049));
    this.K = ((TextView)findViewById(2131690666));
    this.L = ((TextView)findViewById(2131691229));
    this.P = ((CheckBox)findViewById(2131689720));
    this.S = ((TextView)findViewById(2131691233));
    this.T = ((TextView)findViewById(2131691234));
    this.T.setOnClickListener(this);
    this.Q = ((TextView)findViewById(2131691236));
    this.R = ((TextView)findViewById(2131691238));
    this.U = ((TextView)findViewById(2131689956));
    this.O = ((EditText)findViewById(2131691232));
    this.O.setOnTouchListener(new View.OnTouchListener()
    {
      public boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        MinsuApplyActivity.e(MinsuApplyActivity.this).setDescendantFocusability(262144);
        MinsuApplyActivity.f(MinsuApplyActivity.this).requestFocus();
        return false;
      }
    });
    if (ae.isNull(this.aj)) {
      this.O.setHint(getString(2131297152).replace("landlord", "房东"));
    }
    for (;;)
    {
      String str = getIntent().getStringExtra("tripPurpose");
      if (ae.notNull(str)) {
        this.O.setText(str);
      }
      this.O.addTextChangedListener(new a());
      this.x = new com.freelxl.baselibrary.a.a(this, this.w, 2130904294)
      {
        public void convert(b paramAnonymousb, MinsuContactsListBean.ListUsualContactBean paramAnonymousListUsualContactBean)
        {
          paramAnonymousb.setText(2131691280, paramAnonymousListUsualContactBean.conName);
          paramAnonymousb.setText(2131695226, com.ziroom.ziroomcustomer.minsu.b.a.getTypeString(MinsuApplyActivity.this, paramAnonymousListUsualContactBean.cardType));
          paramAnonymousb.setText(2131695227, paramAnonymousListUsualContactBean.cardValue);
          paramAnonymousb.setText(2131691298, paramAnonymousListUsualContactBean.conTel);
        }
        
        public int getCount()
        {
          if (MinsuApplyActivity.g(MinsuApplyActivity.this) == 0)
          {
            if (super.getCount() >= 1) {
              return 1;
            }
            return super.getCount();
          }
          return super.getCount();
        }
      };
      this.u.setAdapter(this.x);
      this.P.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
      {
        @Instrumented
        public void onCheckedChanged(CompoundButton paramAnonymousCompoundButton, boolean paramAnonymousBoolean)
        {
          VdsAgent.onCheckedChanged(this, paramAnonymousCompoundButton, paramAnonymousBoolean);
          MinsuApplyActivity.h(MinsuApplyActivity.this).setEnabled(paramAnonymousBoolean);
          if (paramAnonymousBoolean)
          {
            MinsuApplyActivity.h(MinsuApplyActivity.this).setBackgroundColor(MinsuApplyActivity.this.getResources().getColor(2131624475));
            return;
          }
          MinsuApplyActivity.h(MinsuApplyActivity.this).setBackgroundColor(Color.parseColor("#e2e2e2"));
        }
      });
      this.S.setOnClickListener(this);
      this.e.setOnClickListener(this);
      this.d.setOnClickListener(this);
      this.U.setOnClickListener(this);
      return;
      this.O.setHint(getString(2131297152).replace("landlord", this.aj));
    }
  }
  
  private void b(final int paramInt)
  {
    com.ziroom.ziroomcustomer.minsu.e.a.findBookerContacts(this, new i.a()
    {
      public void onParse(String paramAnonymousString, com.freelxl.baselibrary.e.k paramAnonymousk) {}
      
      public void onSuccess(com.freelxl.baselibrary.e.k paramAnonymousk)
      {
        MinsuFindBookerContactsBean localMinsuFindBookerContactsBean = (MinsuFindBookerContactsBean)paramAnonymousk.getObject();
        if ((paramAnonymousk.getSuccess().booleanValue()) && (localMinsuFindBookerContactsBean != null) && (localMinsuFindBookerContactsBean.checkSuccess(MinsuApplyActivity.this)))
        {
          if (localMinsuFindBookerContactsBean.data == null) {
            return;
          }
          MinsuApplyActivity.t(MinsuApplyActivity.this).setText(localMinsuFindBookerContactsBean.data.tips);
          MinsuApplyActivity.u(MinsuApplyActivity.this).setText(localMinsuFindBookerContactsBean.data.bookerDetail.conName);
          MinsuApplyActivity.v(MinsuApplyActivity.this).setText(localMinsuFindBookerContactsBean.data.bookerDetail.conTel);
          MinsuApplyActivity.w(MinsuApplyActivity.this).setText(localMinsuFindBookerContactsBean.data.bookerDetail.cardValue);
          MinsuApplyActivity.a(MinsuApplyActivity.this, localMinsuFindBookerContactsBean);
          if ((MinsuApplyActivity.x(MinsuApplyActivity.this) == OrderStatusEnum.YD) && (localMinsuFindBookerContactsBean.data.isNeedReplenish.intValue() == 1)) {
            MinsuApplyActivity.a(MinsuApplyActivity.this, MinsuApplyActivity.y(MinsuApplyActivity.this).data.bookerDetail.conName, MinsuApplyActivity.y(MinsuApplyActivity.this).data.bookerDetail.conTel, MinsuApplyActivity.y(MinsuApplyActivity.this).data.bookerDetail.cardType.intValue(), MinsuApplyActivity.y(MinsuApplyActivity.this).data.bookerDetail.cardValue);
          }
          MinsuApplyActivity.z(MinsuApplyActivity.this).clear();
          MinsuApplyActivity.z(MinsuApplyActivity.this).add(MinsuApplyActivity.a(MinsuApplyActivity.this, localMinsuFindBookerContactsBean.data.bookerDetail));
          MinsuApplyActivity.A(MinsuApplyActivity.this).setVisibility(0);
          MinsuApplyActivity.B(MinsuApplyActivity.this).notifyDataSetChanged();
          d.e("lanzhihong", "ro======" + localMinsuFindBookerContactsBean.toString());
          return;
        }
        if (localMinsuFindBookerContactsBean == null) {}
        for (paramAnonymousk = null;; paramAnonymousk = localMinsuFindBookerContactsBean.message)
        {
          ad.shouErrorMessage(paramAnonymousk);
          if (paramInt != 2) {
            break;
          }
          MinsuApplyActivity.this.finish();
          return;
        }
      }
    });
  }
  
  private void e()
  {
    Intent localIntent = new Intent(this, MinsuWebActivity.class);
    localIntent.putExtra("title", "房客服务协议");
    localIntent.putExtra("isAnimExit", true);
    localIntent.putExtra("url", com.ziroom.ziroomcustomer.minsu.landlordrelease.c.a.d);
    startActivity(localIntent);
    com.ziroom.ziroomcustomer.minsu.f.k.animStartAlpha(this);
  }
  
  private void f()
  {
    Intent localIntent = new Intent(this, MinsuWebActivity.class);
    localIntent.putExtra("title", "平台服务协议");
    localIntent.putExtra("isAnimExit", true);
    localIntent.putExtra("url", com.ziroom.ziroomcustomer.minsu.landlordrelease.c.a.e);
    startActivity(localIntent);
    com.ziroom.ziroomcustomer.minsu.f.k.animStartAlpha(this);
  }
  
  private void g()
  {
    v.onClick(this, "M-Add_coupon");
    if ((ae.isNull(this.X)) || (ae.isNull(this.Y)))
    {
      showToast("请选择入住时间段");
      return;
    }
    Intent localIntent = new Intent(this, MinsuCouponListActivity.class);
    localIntent.putExtra("fid", this.Z);
    localIntent.putExtra("rentWay", this.aa);
    localIntent.putExtra("startTime", this.X);
    localIntent.putExtra("endTime", this.Y);
    localIntent.putExtra("couponId", this.am);
    startActivityForResult(localIntent, 116);
    com.ziroom.ziroomcustomer.minsu.f.k.animStartAlpha(this);
  }
  
  private void h()
  {
    com.ziroom.ziroomcustomer.minsu.f.k.toCustomerListPage(this, this.ah, this.w);
  }
  
  private void i()
  {
    if (this.w.size() > 0)
    {
      this.v.setVisibility(0);
      if (this.w.size() <= 1) {
        break label114;
      }
      this.s.setVisibility(0);
      if (this.t != 0) {
        break label101;
      }
      this.s.setText("查看全部");
    }
    for (;;)
    {
      int i = 0;
      while (i < this.w.size())
      {
        ((MinsuContactsListBean.ListUsualContactBean)this.w.get(i)).isShowDel = 0;
        i += 1;
      }
      this.v.setVisibility(8);
      break;
      label101:
      this.s.setText("收起");
      continue;
      label114:
      this.s.setVisibility(4);
    }
    this.x.notifyDataSetChanged();
  }
  
  private void j()
  {
    this.C.setText("添加");
    this.am = "";
  }
  
  private void k()
  {
    if (this.W != OrderStatusEnum.YD) {
      return;
    }
    n();
  }
  
  private void l()
  {
    com.ziroom.ziroomcustomer.minsu.e.a.needPayV3(this, this.Z, this.aa, this.X, this.Y, this.am, this.al, new i.a()
    {
      public void onParse(String paramAnonymousString, com.freelxl.baselibrary.e.k paramAnonymousk)
      {
        paramAnonymousk.setObject(paramAnonymousString);
        d.e("lanzhihong", "str======" + paramAnonymousString);
      }
      
      public void onSuccess(com.freelxl.baselibrary.e.k paramAnonymousk)
      {
        MinsuApplyActivity.a(MinsuApplyActivity.this, (MinsuNeedPayV4Bean)paramAnonymousk.getObject());
        if ((paramAnonymousk.getSuccess().booleanValue()) && (MinsuApplyActivity.i(MinsuApplyActivity.this) != null) && (MinsuApplyActivity.i(MinsuApplyActivity.this).checkSuccess(MinsuApplyActivity.this)))
        {
          d.e("lanzhihong", "ro======" + MinsuApplyActivity.i(MinsuApplyActivity.this).toString());
          MinsuApplyActivity.j(MinsuApplyActivity.this).setText("房租总额 (" + MinsuApplyActivity.i(MinsuApplyActivity.this).data.housingDay + "晚)");
          MinsuApplyActivity.k(MinsuApplyActivity.this).setText(" " + MinsuApplyActivity.i(MinsuApplyActivity.this).data.feeUnit + " " + ad.getPriceFormat(MinsuApplyActivity.i(MinsuApplyActivity.this).data.totalFee.intValue()));
          MinsuApplyActivity.l(MinsuApplyActivity.this).removeAllViews();
          Object localObject1;
          if ((MinsuApplyActivity.i(MinsuApplyActivity.this).data.originalPrice != null) && (MinsuApplyActivity.i(MinsuApplyActivity.this).data.originalPrice.intValue() > 0))
          {
            paramAnonymousk = new TextView(MinsuApplyActivity.this);
            localObject1 = new LinearLayout.LayoutParams(-2, -2);
            paramAnonymousk.setTextSize(12.0F);
            paramAnonymousk.setTextColor(MinsuApplyActivity.this.getResources().getColor(2131624490));
            paramAnonymousk.getPaint().setFlags(16);
            paramAnonymousk.setLayoutParams((ViewGroup.LayoutParams)localObject1);
            paramAnonymousk.setText(MinsuApplyActivity.i(MinsuApplyActivity.this).data.feeUnit + "" + ad.getPriceFormat(MinsuApplyActivity.i(MinsuApplyActivity.this).data.originalPrice.intValue()));
            MinsuApplyActivity.l(MinsuApplyActivity.this).addView(paramAnonymousk);
          }
          final Object localObject2;
          Object localObject3;
          if ((MinsuApplyActivity.i(MinsuApplyActivity.this).data.labelTipsList != null) && (MinsuApplyActivity.i(MinsuApplyActivity.this).data.labelTipsList.size() > 0))
          {
            paramAnonymousk = MinsuApplyActivity.i(MinsuApplyActivity.this).data.labelTipsList.iterator();
            while (paramAnonymousk.hasNext())
            {
              localObject1 = (MinsuNeedPayV4Bean.DataBean.LabelTipsListBean)paramAnonymousk.next();
              localObject2 = new TextView(MinsuApplyActivity.this);
              localObject3 = new LinearLayout.LayoutParams(-2, -2);
              ((TextView)localObject2).setTextSize(10.0F);
              ((TextView)localObject2).setTextColor(MinsuApplyActivity.this.getResources().getColor(2131624097));
              ((LinearLayout.LayoutParams)localObject3).setMargins(ab.dp2px(MinsuApplyActivity.this, 6.0F), 0, 0, 0);
              ((TextView)localObject2).setText(((MinsuNeedPayV4Bean.DataBean.LabelTipsListBean)localObject1).name);
              ((TextView)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject3);
              MinsuApplyActivity.l(MinsuApplyActivity.this).addView((View)localObject2);
            }
          }
          if ((MinsuApplyActivity.i(MinsuApplyActivity.this).data != null) && (MinsuApplyActivity.i(MinsuApplyActivity.this).data.acItemList != null) && (MinsuApplyActivity.i(MinsuApplyActivity.this).data.acItemList.size() > 0))
          {
            paramAnonymousk = (LinearLayout)MinsuApplyActivity.this.findViewById(2131691226);
            paramAnonymousk.removeAllViews();
            localObject1 = MinsuApplyActivity.i(MinsuApplyActivity.this).data.acItemList.iterator();
            while (((Iterator)localObject1).hasNext())
            {
              localObject2 = (MinsuNeedPayV4Bean.DataBean.AcItemListBean)((Iterator)localObject1).next();
              localObject3 = LayoutInflater.from(MinsuApplyActivity.this).inflate(2130904124, null);
              ((TextView)((View)localObject3).findViewById(2131690049)).setText(((MinsuNeedPayV4Bean.DataBean.AcItemListBean)localObject2).name);
              ((TextView)((View)localObject3).findViewById(2131691546)).setText(((MinsuNeedPayV4Bean.DataBean.AcItemListBean)localObject2).symbol + MinsuApplyActivity.i(MinsuApplyActivity.this).data.feeUnit + ((MinsuNeedPayV4Bean.DataBean.AcItemListBean)localObject2).fee);
              paramAnonymousk.addView((View)localObject3);
            }
          }
          if ((MinsuApplyActivity.i(MinsuApplyActivity.this).data != null) && (MinsuApplyActivity.i(MinsuApplyActivity.this).data.deposit != null))
          {
            paramAnonymousk = (LinearLayout)MinsuApplyActivity.this.findViewById(2131691227);
            paramAnonymousk.removeAllViews();
            localObject1 = LayoutInflater.from(MinsuApplyActivity.this).inflate(2130904125, null);
            localObject2 = MinsuApplyActivity.i(MinsuApplyActivity.this).data.deposit;
            ((TextView)((View)localObject1).findViewById(2131690049)).setText(((MinsuNeedPayV4Bean.DataBean.DepositBean)localObject2).name);
            localObject3 = (TextView)((View)localObject1).findViewById(2131692617);
            ((TextView)localObject3).setText(((MinsuNeedPayV4Bean.DataBean.DepositBean)localObject2).ruleName);
            ((TextView)localObject3).setOnClickListener(new View.OnClickListener()
            {
              @Instrumented
              public void onClick(View paramAnonymous2View)
              {
                VdsAgent.onClick(this, paramAnonymous2View);
                com.ziroom.ziroomcustomer.minsu.f.k.toMinsuInfoActivity(MinsuApplyActivity.this, localObject2.ruleCode, MinsuApplyActivity.c(MinsuApplyActivity.this), MinsuApplyActivity.d(MinsuApplyActivity.this));
              }
            });
            ((TextView)((View)localObject1).findViewById(2131690073)).setText(((MinsuNeedPayV4Bean.DataBean.DepositBean)localObject2).title1);
            ((TextView)((View)localObject1).findViewById(2131689995)).setText("-" + MinsuApplyActivity.i(MinsuApplyActivity.this).data.feeUnit + ((MinsuNeedPayV4Bean.DataBean.DepositBean)localObject2).fee);
            paramAnonymousk.addView((View)localObject1);
          }
          if ((MinsuApplyActivity.i(MinsuApplyActivity.this).data != null) && (!com.ziroom.ziroomcustomer.minsu.f.c.isNull(MinsuApplyActivity.i(MinsuApplyActivity.this).data.couponMoney)) && (!com.ziroom.ziroomcustomer.minsu.f.c.isNull(MinsuApplyActivity.i(MinsuApplyActivity.this).data.coupon)))
          {
            MinsuApplyActivity.a(MinsuApplyActivity.this, MinsuApplyActivity.i(MinsuApplyActivity.this).data.coupon.cardId);
            MinsuApplyActivity.m(MinsuApplyActivity.this).setText(MinsuApplyActivity.i(MinsuApplyActivity.this).data.couponMoney);
          }
          MinsuApplyActivity.a(MinsuApplyActivity.this, MinsuApplyActivity.i(MinsuApplyActivity.this).data.checkInLimit);
          MinsuApplyActivity.b(MinsuApplyActivity.this, MinsuApplyActivity.i(MinsuApplyActivity.this).data.minDay);
          MinsuApplyActivity.n(MinsuApplyActivity.this).clear();
          MinsuApplyActivity.n(MinsuApplyActivity.this).addAll(MinsuApplyActivity.i(MinsuApplyActivity.this).data.notices);
          MinsuApplyActivity.b(MinsuApplyActivity.this).clear();
          paramAnonymousk = MinsuApplyActivity.n(MinsuApplyActivity.this).iterator();
          while (paramAnonymousk.hasNext())
          {
            localObject1 = (MinsuNeedPayV4Bean.DataBean.NoticesBean)paramAnonymousk.next();
            if ((((MinsuNeedPayV4Bean.DataBean.NoticesBean)localObject1).clickType.intValue() == 2) && (MinsuApplyActivity.b(MinsuApplyActivity.this).get(((MinsuNeedPayV4Bean.DataBean.NoticesBean)localObject1).code) == null)) {
              MinsuApplyActivity.b(MinsuApplyActivity.this).put(((MinsuNeedPayV4Bean.DataBean.NoticesBean)localObject1).code, Integer.valueOf(0));
            }
          }
          MinsuApplyActivity.o(MinsuApplyActivity.this).notifyDataSetChanged();
          if ((MinsuApplyActivity.i(MinsuApplyActivity.this) != null) && (MinsuApplyActivity.i(MinsuApplyActivity.this).data != null))
          {
            MinsuApplyActivity.p(MinsuApplyActivity.this).setText(MinsuApplyActivity.i(MinsuApplyActivity.this).data.feeUnit + ad.getPriceFormat(MinsuApplyActivity.i(MinsuApplyActivity.this).data.orderFee));
            if (MinsuApplyActivity.i(MinsuApplyActivity.this).data.deposit != null) {
              MinsuApplyActivity.q(MinsuApplyActivity.this).setText(MinsuApplyActivity.i(MinsuApplyActivity.this).data.feeUnit + MinsuApplyActivity.i(MinsuApplyActivity.this).data.deposit.fee);
            }
          }
          return;
        }
        if (MinsuApplyActivity.i(MinsuApplyActivity.this) == null) {}
        for (paramAnonymousk = null;; paramAnonymousk = MinsuApplyActivity.i(MinsuApplyActivity.this).message)
        {
          ad.shouErrorMessage(paramAnonymousk);
          return;
        }
      }
    });
  }
  
  private void m()
  {
    Object localObject2 = this.G.entrySet().iterator();
    Object localObject1;
    while (((Iterator)localObject2).hasNext())
    {
      localObject1 = (Map.Entry)((Iterator)localObject2).next();
      if (((Integer)((Map.Entry)localObject1).getValue()).intValue() == 0)
      {
        localObject2 = new Intent(this, MinsuInfoActivity.class);
        ((Intent)localObject2).putExtra("code", (Serializable)((Map.Entry)localObject1).getKey());
        ((Intent)localObject2).putExtra("rentWay", this.aa);
        ((Intent)localObject2).putExtra("fid", this.Z);
        ((Intent)localObject2).putExtra("special", -1);
        ((Intent)localObject2).putExtra("isExitAnim", false);
        startActivityForResult((Intent)localObject2, 128);
        return;
      }
    }
    if (this.ag != null)
    {
      localObject1 = this.ag.data.bookerDetail.conTel;
      localObject2 = this.ag.data.bookerDetail.conName;
      if (this.ag.data.isNeedReplenish.intValue() == 1) {
        a((String)localObject2, (String)localObject1, this.ag.data.bookerDetail.cardType.intValue(), this.ag.data.bookerDetail.cardValue);
      }
    }
    else
    {
      showToast("用户信息错误");
      return;
    }
    if ((ae.isNull(this.X)) || (ae.isNull(this.Y)))
    {
      showToast("请选择入住时间段");
      return;
    }
    if ((this.w == null) || (this.w.isEmpty()))
    {
      showToast("请选择入住人");
      return;
    }
    if ((this.ah > 0) && (this.w.size() > this.ah))
    {
      showToast("该房源入住人数最多为" + this.ah);
      return;
    }
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.w.iterator();
    while (localIterator.hasNext()) {
      localArrayList.add(((MinsuContactsListBean.ListUsualContactBean)localIterator.next()).fid);
    }
    com.ziroom.ziroomcustomer.minsu.e.a.createOrder(this, this.Z, this.aa, (String)localObject1, (String)localObject2, localArrayList, this.X, this.Y, VdsAgent.trackEditTextSilent(this.O) + "", this.am, new i.a()
    {
      public void onParse(String paramAnonymousString, com.freelxl.baselibrary.e.k paramAnonymousk) {}
      
      public void onSuccess(com.freelxl.baselibrary.e.k paramAnonymousk)
      {
        Object localObject = (MinsuCreateOrderBean)paramAnonymousk.getObject();
        if ((paramAnonymousk.getSuccess().booleanValue()) && (localObject != null) && (((MinsuCreateOrderBean)localObject).checkSuccess(MinsuApplyActivity.this)))
        {
          d.e("lanzhihong", "ro======" + localObject.toString());
          MinsuApplyActivity.b(MinsuApplyActivity.this, ((MinsuCreateOrderBean)localObject).data.orderSn);
          paramAnonymousk = ((MinsuCreateOrderBean)localObject).data.msg;
          localObject = ((MinsuCreateOrderBean)localObject).data.phone;
          if (ae.isNull(paramAnonymousk))
          {
            paramAnonymousk = new Intent(MinsuApplyActivity.this, MinsuSignedActivity.class);
            paramAnonymousk.putExtra("orderSn", MinsuApplyActivity.r(MinsuApplyActivity.this));
            paramAnonymousk.putExtra("status", OrderStatusEnum.DZF);
            MinsuApplyActivity.this.startActivity(paramAnonymousk);
            MinsuApplyActivity.this.finish();
            return;
          }
          Intent localIntent = new Intent(MinsuApplyActivity.this, MinsuOrderSuccessfulActivity.class);
          localIntent.putExtra("orderSn", MinsuApplyActivity.r(MinsuApplyActivity.this));
          localIntent.putExtra("lName", MinsuApplyActivity.s(MinsuApplyActivity.this));
          localIntent.putExtra("msg", paramAnonymousk);
          localIntent.putExtra("phone", (String)localObject);
          localIntent.putExtra("from", "Apply");
          MinsuApplyActivity.this.startActivity(localIntent);
          MinsuApplyActivity.this.finish();
          return;
        }
        if (localObject == null) {}
        for (paramAnonymousk = null;; paramAnonymousk = ((MinsuCreateOrderBean)localObject).message)
        {
          ad.shouErrorMessage(paramAnonymousk);
          return;
        }
      }
    });
  }
  
  private void n()
  {
    com.ziroom.ziroomcustomer.minsu.f.k.toMinsuTimeSelectingActivity(this, this.X, this.Y, this.Z, this.aa, this.ai);
  }
  
  public void initTitle()
  {
    this.V = ((CommonTitle)findViewById(2131691272));
    this.V.showRightText(false, null);
    this.V.setLeftButtonType(0);
    this.V.setOnLeftButtonClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        MinsuApplyActivity.this.finish();
      }
    });
    this.V.setBottomLineAlpha(0.0F);
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    switch (paramInt1)
    {
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
              Object localObject;
              do
              {
                return;
                if (paramInt2 == -1)
                {
                  this.w.clear();
                  this.w.addAll((ArrayList)paramIntent.getSerializableExtra("contacts"));
                  localObject = new StringBuilder().append(" -- ").append(this.w).append(" size = ");
                  if (this.w == null) {}
                  for (paramIntent = " null ";; paramIntent = " - " + this.w.size())
                  {
                    d.e("err", paramIntent);
                    i();
                    return;
                  }
                }
              } while ((paramIntent == null) || (paramIntent.getSerializableExtra("dataDel") == null));
              paramIntent = (ArrayList)paramIntent.getSerializableExtra("dataDel");
              if ((this.w != null) && (this.w.size() > 0) && (paramIntent != null) && (paramIntent.size() > 0))
              {
                localObject = this.w.iterator();
                while (((Iterator)localObject).hasNext())
                {
                  MinsuContactsListBean.ListUsualContactBean localListUsualContactBean1 = (MinsuContactsListBean.ListUsualContactBean)((Iterator)localObject).next();
                  Iterator localIterator = paramIntent.iterator();
                  while (localIterator.hasNext())
                  {
                    MinsuContactsListBean.ListUsualContactBean localListUsualContactBean2 = (MinsuContactsListBean.ListUsualContactBean)localIterator.next();
                    if (localListUsualContactBean1.fid.equals(localListUsualContactBean2.fid)) {
                      ((Iterator)localObject).remove();
                    }
                  }
                }
              }
              i();
              return;
            } while (paramInt2 != -1);
            j();
            this.X = paramIntent.getStringExtra("startDate");
            this.Y = paramIntent.getStringExtra("endDate");
            a(this.X, this.Y, this.f, this.g);
          } while ((!ae.notNull(this.X)) || (!ae.notNull(this.Y)));
          l();
          return;
          if (paramInt2 == -1)
          {
            b(2);
            return;
          }
          finish();
          return;
          if (paramInt2 == -1)
          {
            this.al = false;
            this.am = paramIntent.getStringExtra("coupon");
            this.an = paramIntent.getStringExtra("couponinfo");
            this.C.setText(this.an);
            l();
            return;
          }
        } while (paramInt2 != 102);
        j();
        this.al = false;
        l();
        return;
      } while (paramInt2 != -1);
      paramInt1 = paramIntent.getIntExtra("code", -1);
      if ((paramInt1 != -1) && (((Integer)this.G.get(Integer.valueOf(paramInt1))).intValue() != 1)) {
        this.G.put(Integer.valueOf(paramInt1), Integer.valueOf(1));
      }
      this.H.notifyDataSetChanged();
      return;
    } while (paramInt2 != -1);
    paramInt1 = paramIntent.getIntExtra("code", -1);
    if ((paramInt1 != -1) && (((Integer)this.G.get(Integer.valueOf(paramInt1))).intValue() != 1)) {
      this.G.put(Integer.valueOf(paramInt1), Integer.valueOf(1));
    }
    m();
  }
  
  @Instrumented
  public void onClick(View paramView)
  {
    VdsAgent.onClick(this, paramView);
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131691427: 
      paramView = new Intent(this, MinsuHouseDetailActivity.class);
      paramView.putExtra("fid", this.Z);
      paramView.putExtra("rentWay", this.aa);
      paramView.putExtra("startTime", this.X);
      paramView.putExtra("endTime", this.Y);
      startActivity(paramView);
      return;
    case 2131691213: 
      k();
      return;
    case 2131691211: 
      k();
      return;
    case 2131689956: 
      m();
      return;
    case 2131691215: 
    case 2131691687: 
      h();
      return;
    case 2131691224: 
      g();
      return;
    case 2131691218: 
      if (this.t == 0)
      {
        this.t = 1;
        this.x.notifyDataSetChanged();
        this.s.setText("收起");
        return;
      }
      this.t = 0;
      this.x.notifyDataSetChanged();
      this.s.setText("查看全部");
      return;
    case 2131691221: 
      if ((this.af == null) || (this.af.data == null))
      {
        showToast(getResources().getString(2131297278));
        return;
      }
      paramView = new Intent(this, MinsuPriceInfoListActivity.class);
      paramView.putExtra("bean", this.af);
      startActivity(paramView);
      com.ziroom.ziroomcustomer.minsu.f.k.animStartAlpha(this);
      return;
    case 2131691234: 
      e();
      return;
    }
    f();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903260);
    this.W = ((OrderStatusEnum)getIntent().getSerializableExtra("status"));
    this.W = OrderStatusEnum.YD;
    this.Z = getIntent().getStringExtra("fid");
    this.ac = getIntent().getStringExtra("orderSn");
    this.aj = getIntent().getStringExtra("lName");
    this.c = getIntent().getStringExtra("houseName");
    this.ad = Calendar.getInstance();
    this.ad.add(1, 1);
    this.ae = Calendar.getInstance();
    this.ae.add(1, -1);
    GrowingIO.getInstance().setPageName(this, "下单页面");
    this.X = getIntent().getStringExtra("startTime");
    this.Y = getIntent().getStringExtra("endTime");
    this.aa = getIntent().getIntExtra("rentWay", 0);
    this.c = getIntent().getStringExtra("houseName");
    b();
    initTitle();
    b(1);
    l();
    a();
  }
  
  public void onDismiss() {}
  
  public void onScroll(int paramInt1, int paramInt2)
  {
    float f1 = paramInt2 / 100.0F;
    this.V.setBottomLineAlpha(f1);
  }
  
  public class a
    implements TextWatcher
  {
    public a() {}
    
    public void afterTextChanged(Editable paramEditable) {}
    
    public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
    
    public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
    {
      if (com.ziroom.ziroomcustomer.minsu.f.c.getLength(paramCharSequence.toString()) >= 256)
      {
        g.textToast(MinsuApplyActivity.this, "字数太长了！");
        paramCharSequence = paramCharSequence.subSequence(0, paramInt1) + "";
        MinsuApplyActivity.f(MinsuApplyActivity.this).setText(paramCharSequence);
        MinsuApplyActivity.f(MinsuApplyActivity.this).setSelection(paramCharSequence.length());
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/activity/MinsuApplyActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */