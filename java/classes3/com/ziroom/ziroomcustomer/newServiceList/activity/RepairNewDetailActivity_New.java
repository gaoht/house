package com.ziroom.ziroomcustomer.newServiceList.activity;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.alibaba.fastjson.a;
import com.facebook.drawee.view.SimpleDraweeView;
import com.freelxl.baselibrary.e.i.a;
import com.freelxl.baselibrary.e.k;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.MainActivity;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.dialog.c.a;
import com.ziroom.ziroomcustomer.e.l;
import com.ziroom.ziroomcustomer.e.o;
import com.ziroom.ziroomcustomer.model.UserInfo;
import com.ziroom.ziroomcustomer.newServiceList.b.d;
import com.ziroom.ziroomcustomer.newServiceList.model.ah.a;
import com.ziroom.ziroomcustomer.newServiceList.model.ah.b;
import com.ziroom.ziroomcustomer.newServiceList.model.ah.c;
import com.ziroom.ziroomcustomer.newServiceList.model.aj.a;
import com.ziroom.ziroomcustomer.newServiceList.model.ap;
import com.ziroom.ziroomcustomer.newServiceList.model.q;
import com.ziroom.ziroomcustomer.newServiceList.view.ElasticScrollView;
import com.ziroom.ziroomcustomer.newServiceList.view.ElasticScrollView.a;
import com.ziroom.ziroomcustomer.newmovehouse.model.MHPayInfo;
import com.ziroom.ziroomcustomer.newmovehouse.widget.FlowLayout;
import com.ziroom.ziroomcustomer.util.ae;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RepairNewDetailActivity_New
  extends BaseActivity
  implements View.OnClickListener, ElasticScrollView.a
{
  private ImageView A;
  private ImageView B;
  private TextView C;
  private ImageView D;
  private ImageView E;
  private ImageView F;
  private ImageView G;
  private View H;
  private View I;
  private View J;
  private View K;
  private View L;
  private String M;
  private FlowLayout N;
  private FlowLayout O;
  private Button P;
  private d Q;
  private ListView R;
  private TextView S;
  private ElasticScrollView T;
  private RelativeLayout U;
  private ImageView V;
  private LinearLayout W;
  private ImageView X;
  private ImageView Y;
  private ImageView Z;
  String a = "#F56400";
  private Handler aA = new Handler()
  {
    public void handleMessage(final Message paramAnonymousMessage)
    {
      Object localObject = (l)paramAnonymousMessage.obj;
      switch (paramAnonymousMessage.what)
      {
      default: 
        return;
      case 69959: 
        if (((l)localObject).getSuccess().booleanValue())
        {
          RepairNewDetailActivity_New.a(RepairNewDetailActivity_New.this, (com.ziroom.ziroomcustomer.newServiceList.model.ah)((l)localObject).getObject());
          RepairNewDetailActivity_New.a(RepairNewDetailActivity_New.this).onRefreshComplete();
          RepairNewDetailActivity_New.b(RepairNewDetailActivity_New.this);
        }
        for (;;)
        {
          RepairNewDetailActivity_New.this.dismissProgress();
          return;
          com.freelxl.baselibrary.f.g.textToast(RepairNewDetailActivity_New.c(RepairNewDetailActivity_New.this), ((l)localObject).getMessage());
        }
      case 69969: 
        if (((l)localObject).getSuccess().booleanValue())
        {
          com.freelxl.baselibrary.f.g.textToast(RepairNewDetailActivity_New.c(RepairNewDetailActivity_New.this), "验收完成");
          if (RepairNewDetailActivity_New.d(RepairNewDetailActivity_New.this) != null) {
            RepairNewDetailActivity_New.d(RepairNewDetailActivity_New.this).removeAllViews();
          }
          o.getNewRepairDetail(RepairNewDetailActivity_New.c(RepairNewDetailActivity_New.this), RepairNewDetailActivity_New.e(RepairNewDetailActivity_New.this), RepairNewDetailActivity_New.f(RepairNewDetailActivity_New.this).getUid(), Long.valueOf(System.currentTimeMillis()), RepairNewDetailActivity_New.f(RepairNewDetailActivity_New.this).getLogin_name_mobile(), 12, RepairNewDetailActivity_New.g(RepairNewDetailActivity_New.this), "", "2");
        }
        for (;;)
        {
          RepairNewDetailActivity_New.this.dismissProgress();
          return;
          com.freelxl.baselibrary.f.g.textToast(RepairNewDetailActivity_New.c(RepairNewDetailActivity_New.this), ((l)localObject).getMessage());
        }
      case 8212: 
        if (!((l)localObject).getSuccess().booleanValue()) {
          RepairNewDetailActivity_New.h(RepairNewDetailActivity_New.this).dismiss();
        }
        if (((l)localObject).getSuccess().booleanValue())
        {
          RepairNewDetailActivity_New.h(RepairNewDetailActivity_New.this).show();
          RepairNewDetailActivity_New.a(RepairNewDetailActivity_New.this, (List)((l)localObject).getObject());
          if ((RepairNewDetailActivity_New.i(RepairNewDetailActivity_New.this) != null) && (RepairNewDetailActivity_New.i(RepairNewDetailActivity_New.this).size() > 0))
          {
            RepairNewDetailActivity_New.b(RepairNewDetailActivity_New.this, RepairNewDetailActivity_New.i(RepairNewDetailActivity_New.this));
            RepairNewDetailActivity_New.h(RepairNewDetailActivity_New.this).setTagList(RepairNewDetailActivity_New.i(RepairNewDetailActivity_New.this));
            RepairNewDetailActivity_New.h(RepairNewDetailActivity_New.this).getEt_reason().addTextChangedListener(new TextWatcher()
            {
              private CharSequence b;
              private int c;
              private int d;
              
              public void afterTextChanged(Editable paramAnonymous2Editable)
              {
                int i = paramAnonymous2Editable.length();
                RepairNewDetailActivity_New.h(RepairNewDetailActivity_New.this).getTv_num().setText("" + i);
                this.c = RepairNewDetailActivity_New.h(RepairNewDetailActivity_New.this).getEt_reason().getSelectionStart();
                this.d = RepairNewDetailActivity_New.h(RepairNewDetailActivity_New.this).getEt_reason().getSelectionEnd();
                if (this.b.length() > RepairNewDetailActivity_New.j(RepairNewDetailActivity_New.this))
                {
                  paramAnonymous2Editable.delete(this.c - 1, this.d);
                  i = this.d;
                  RepairNewDetailActivity_New.h(RepairNewDetailActivity_New.this).getEt_reason().setText(paramAnonymous2Editable);
                  RepairNewDetailActivity_New.h(RepairNewDetailActivity_New.this).getEt_reason().setSelection(i);
                }
              }
              
              public void beforeTextChanged(CharSequence paramAnonymous2CharSequence, int paramAnonymous2Int1, int paramAnonymous2Int2, int paramAnonymous2Int3) {}
              
              public void onTextChanged(CharSequence paramAnonymous2CharSequence, int paramAnonymous2Int1, int paramAnonymous2Int2, int paramAnonymous2Int3)
              {
                this.b = paramAnonymous2CharSequence;
              }
            });
            RepairNewDetailActivity_New.h(RepairNewDetailActivity_New.this).getBtn_cancel_commit().setOnClickListener(new View.OnClickListener()
            {
              @Instrumented
              public void onClick(View paramAnonymous2View)
              {
                VdsAgent.onClick(this, paramAnonymous2View);
                paramAnonymous2View = ApplicationEx.c.getUser();
                String str = VdsAgent.trackEditTextSilent(RepairNewDetailActivity_New.h(RepairNewDetailActivity_New.this).getEt_reason()).toString().trim();
                if (RepairNewDetailActivity_New.k(RepairNewDetailActivity_New.this))
                {
                  o.getExterRepairCancleOrder(RepairNewDetailActivity_New.c(RepairNewDetailActivity_New.this), RepairNewDetailActivity_New.e(RepairNewDetailActivity_New.this), paramAnonymous2View.getUid(), Long.valueOf(System.currentTimeMillis()), paramAnonymous2View.getLogin_name_mobile(), 12, RepairNewDetailActivity_New.l(RepairNewDetailActivity_New.this).getLogicCode(), "2", ((aj.a)RepairNewDetailActivity_New.i(RepairNewDetailActivity_New.this).get(RepairNewDetailActivity_New.m(RepairNewDetailActivity_New.this))).getTagValue(), ((aj.a)RepairNewDetailActivity_New.i(RepairNewDetailActivity_New.this).get(RepairNewDetailActivity_New.m(RepairNewDetailActivity_New.this))).getTagKey() + "", str);
                  return;
                }
                o.getExterRepairCancleOrder(RepairNewDetailActivity_New.c(RepairNewDetailActivity_New.this), RepairNewDetailActivity_New.e(RepairNewDetailActivity_New.this), paramAnonymous2View.getUid(), Long.valueOf(System.currentTimeMillis()), paramAnonymous2View.getLogin_name_mobile(), 12, RepairNewDetailActivity_New.l(RepairNewDetailActivity_New.this).getLogicCode(), "2", "", "", str);
              }
            });
          }
        }
        for (;;)
        {
          RepairNewDetailActivity_New.this.dismissProgress();
          return;
          if (((l)localObject).getObject() != null)
          {
            paramAnonymousMessage = (String)((l)localObject).getObject();
            localObject = ((l)localObject).getMessage();
            com.ziroom.ziroomcustomer.dialog.c.newBuilder(RepairNewDetailActivity_New.c(RepairNewDetailActivity_New.this)).setButtonText("联系师傅").setSecondButtonText("继续维修").setContent((String)localObject).setCanceledOnTouchOutside(true).setOnButtonClickListener(new View.OnClickListener()
            {
              @Instrumented
              public void onClick(View paramAnonymous2View)
              {
                VdsAgent.onClick(this, paramAnonymous2View);
                if (!paramAnonymousMessage.isEmpty()) {
                  com.ziroom.ziroomcustomer.util.ah.callPhone(RepairNewDetailActivity_New.c(RepairNewDetailActivity_New.this), paramAnonymousMessage);
                }
              }
            }).build().show();
          }
          else
          {
            com.freelxl.baselibrary.f.g.textToast(RepairNewDetailActivity_New.c(RepairNewDetailActivity_New.this), ((l)localObject).getMessage());
          }
        }
      }
      if (((l)localObject).getSuccess().booleanValue())
      {
        paramAnonymousMessage = new Intent();
        paramAnonymousMessage.setAction("external_repair_order_delete");
        RepairNewDetailActivity_New.this.sendBroadcast(paramAnonymousMessage);
        com.freelxl.baselibrary.f.g.textToast(RepairNewDetailActivity_New.c(RepairNewDetailActivity_New.this), "取消成功！");
        RepairNewDetailActivity_New.h(RepairNewDetailActivity_New.this).dismiss();
        RepairNewDetailActivity_New.this.finish();
      }
      for (;;)
      {
        RepairNewDetailActivity_New.this.dismissProgress();
        return;
        com.freelxl.baselibrary.f.g.textToast(RepairNewDetailActivity_New.c(RepairNewDetailActivity_New.this), ((l)localObject).getMessage());
      }
    }
  };
  private ImageView aa;
  private ImageView ab;
  private TextView ac;
  private TextView ad;
  private TextView ae;
  private TextView af;
  private TextView ag;
  private SimpleDraweeView ah;
  private String ai;
  private String aj;
  private FlowLayout ak;
  private int al;
  private int am = -1;
  private int an;
  private boolean ao;
  private boolean ap = true;
  private int aq;
  private int ar = -1;
  private boolean as = false;
  private List<ah.b> at;
  private List<ah.a> au;
  private RelativeLayout av;
  private TextView aw;
  private SimpleDraweeView ax;
  private List<aj.a> ay;
  private int az = 150;
  int b = -1;
  private UserInfo c;
  private Context d;
  private com.ziroom.ziroomcustomer.newServiceList.model.ah e;
  private TextView f;
  private TextView g;
  private TextView r;
  private TextView s;
  private TextView t;
  private TextView u;
  private TextView v;
  private EditText w;
  private RelativeLayout x;
  private TextView y;
  private TextView z;
  
  private void a()
  {
    this.P = ((Button)findViewById(2131690461));
    this.B = ((ImageView)findViewById(2131689492));
    this.C = ((TextView)findViewById(2131690421));
    this.T = ((ElasticScrollView)findViewById(2131691910));
    this.ax = ((SimpleDraweeView)findViewById(2131690027));
    View localView = LayoutInflater.from(this).inflate(2130904674, null);
    this.f = ((TextView)localView.findViewById(2131690367));
    this.g = ((TextView)localView.findViewById(2131696024));
    this.s = ((TextView)localView.findViewById(2131694698));
    this.r = ((TextView)localView.findViewById(2131689922));
    this.t = ((TextView)localView.findViewById(2131690053));
    this.u = ((TextView)localView.findViewById(2131690048));
    this.v = ((TextView)localView.findViewById(2131696026));
    this.ak = ((FlowLayout)localView.findViewById(2131691005));
    this.w = ((EditText)localView.findViewById(2131692950));
    this.y = ((TextView)localView.findViewById(2131690371));
    this.z = ((TextView)localView.findViewById(2131696029));
    this.A = ((ImageView)localView.findViewById(2131691963));
    this.D = ((ImageView)localView.findViewById(2131692114));
    this.E = ((ImageView)localView.findViewById(2131692115));
    this.F = ((ImageView)localView.findViewById(2131692117));
    this.G = ((ImageView)localView.findViewById(2131692119));
    this.H = localView.findViewById(2131692113);
    this.I = localView.findViewById(2131690395);
    this.J = localView.findViewById(2131692116);
    this.K = localView.findViewById(2131692118);
    this.L = localView.findViewById(2131692120);
    this.S = ((TextView)localView.findViewById(2131695900));
    this.R = ((ListView)localView.findViewById(2131695992));
    this.ac = ((TextView)localView.findViewById(2131690909));
    this.ad = ((TextView)localView.findViewById(2131692121));
    this.ae = ((TextView)localView.findViewById(2131692122));
    this.af = ((TextView)localView.findViewById(2131692123));
    this.ag = ((TextView)localView.findViewById(2131694267));
    this.x = ((RelativeLayout)localView.findViewById(2131690369));
    this.U = ((RelativeLayout)localView.findViewById(2131695988));
    this.W = ((LinearLayout)localView.findViewById(2131695991));
    this.aw = ((TextView)localView.findViewById(2131695989));
    this.X = ((ImageView)localView.findViewById(2131690054));
    this.Y = ((ImageView)localView.findViewById(2131690055));
    this.Z = ((ImageView)localView.findViewById(2131690056));
    this.aa = ((ImageView)localView.findViewById(2131690057));
    this.ab = ((ImageView)localView.findViewById(2131690058));
    this.av = ((RelativeLayout)localView.findViewById(2131696030));
    this.N = ((FlowLayout)localView.findViewById(2131696031));
    this.O = ((FlowLayout)localView.findViewById(2131696032));
    this.V = ((ImageView)localView.findViewById(2131695990));
    this.ah = ((SimpleDraweeView)localView.findViewById(2131690047));
    this.T.addChild(localView);
    this.w.setInputType(3);
  }
  
  private void a(String paramString, int paramInt)
  {
    Button localButton = new Button(this);
    localButton.setText(paramString);
    localButton.setTag(Boolean.valueOf(false));
    localButton.setTextSize(12.0F);
    localButton.setPadding(10, 0, 10, 0);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
    localLayoutParams.setMargins(10, 10, 10, 0);
    localButton.setLayoutParams(localLayoutParams);
    if (paramInt == 1)
    {
      localButton.setTextColor(getResources().getColor(2131624516));
      localButton.setBackgroundResource(2130839371);
      if (paramString != null) {
        this.N.addView(localButton);
      }
    }
    if (paramInt == 2)
    {
      localButton.setTextColor(getResources().getColor(2131624513));
      localButton.setBackgroundResource(2130839353);
      if (paramString != null) {
        this.O.addView(localButton);
      }
    }
  }
  
  private void a(List<aj.a> paramList)
  {
    if ((paramList != null) && (paramList.size() > 0))
    {
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        e(((aj.a)paramList.next()).getTagValue());
      }
    }
  }
  
  private void a(List<String> paramList, int paramInt)
  {
    if ((paramList != null) && (paramList.size() > 0))
    {
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        a((String)paramList.next(), paramInt);
      }
    }
  }
  
  private void a(boolean paramBoolean)
  {
    int k = 0;
    int j = 0;
    int i = 0;
    this.ap = false;
    if (paramBoolean)
    {
      if ((this.e.getPositiveLabels().size() == 0) && (this.e.getNegativeLabels().size() != 0)) {
        this.N.setVisibility(8);
      }
      while (i < this.au.size())
      {
        a(h(((ah.a)this.au.get(i)).getEvaluateValue()), 2);
        i += 1;
        continue;
        if ((this.e.getPositiveLabels().size() != 0) && (this.e.getNegativeLabels().size() == 0))
        {
          this.O.setVisibility(8);
          i = k;
        }
        while (i < this.at.size())
        {
          a(h(((ah.b)this.at.get(i)).getEvaluateValue()), 1);
          i += 1;
          continue;
          List localList;
          if ((this.e.getPositiveLabels().size() != 0) && (this.e.getNegativeLabels().size() != 0))
          {
            localList = this.e.getPositiveLabels();
            i = 0;
            while (i < localList.size())
            {
              a(h(((ah.b)localList.get(i)).getEvaluateValue()), 1);
              i += 1;
            }
            localList = this.e.getNegativeLabels();
            i = j;
          }
          while (i < localList.size())
          {
            a(h(((ah.a)localList.get(i)).getEvaluateValue()), 2);
            i += 1;
            continue;
            if ((this.e.getPositiveLabels().size() != 0) || (this.e.getNegativeLabels().size() != 0)) {
              break;
            }
          }
        }
      }
      return;
    }
    a(null, -1);
  }
  
  private void b()
  {
    this.T.setonRefreshListener(this);
    this.B.setOnClickListener(this);
    this.C.setOnClickListener(this);
    this.U.setOnClickListener(this);
  }
  
  private void b(int paramInt)
  {
    if ((paramInt == 5) || (paramInt == 10))
    {
      this.H.setBackgroundColor(Color.parseColor(this.a));
      this.I.setBackgroundColor(Color.parseColor(this.a));
      this.D.setImageResource(2130838940);
      this.E.setImageResource(2130838940);
      this.ac.setTextColor(Color.parseColor(this.a));
      this.ad.setTextColor(Color.parseColor(this.a));
    }
    do
    {
      return;
      if ((paramInt == 15) || (paramInt == 20))
      {
        this.H.setBackgroundColor(Color.parseColor(this.a));
        this.I.setBackgroundColor(Color.parseColor(this.a));
        this.J.setBackgroundColor(Color.parseColor(this.a));
        this.D.setImageResource(2130838940);
        this.E.setImageResource(2130838940);
        this.F.setImageResource(2130838940);
        this.ac.setTextColor(Color.parseColor(this.a));
        this.ad.setTextColor(Color.parseColor(this.a));
        this.ae.setTextColor(Color.parseColor(this.a));
        return;
      }
      if (paramInt == 30)
      {
        this.H.setBackgroundColor(Color.parseColor(this.a));
        this.I.setBackgroundColor(Color.parseColor(this.a));
        this.J.setBackgroundColor(Color.parseColor(this.a));
        this.K.setBackgroundColor(Color.parseColor(this.a));
        this.L.setBackgroundColor(Color.parseColor(this.a));
        this.D.setImageResource(2130838940);
        this.E.setImageResource(2130838940);
        this.F.setImageResource(2130838940);
        this.G.setImageResource(2130838940);
        this.ac.setTextColor(Color.parseColor(this.a));
        this.ad.setTextColor(Color.parseColor(this.a));
        this.ae.setTextColor(Color.parseColor(this.a));
        this.af.setTextColor(Color.parseColor(this.a));
        return;
      }
    } while (paramInt != 35);
    this.af.setText("已取消");
  }
  
  private void c(int paramInt)
  {
    if (paramInt == 1)
    {
      this.X.setVisibility(0);
      this.Y.setVisibility(0);
      this.Z.setVisibility(0);
      this.aa.setVisibility(0);
      this.ab.setVisibility(0);
      this.Y.setBackgroundResource(2130839907);
      this.Z.setBackgroundResource(2130839907);
      this.aa.setBackgroundResource(2130839907);
      this.ab.setBackgroundResource(2130839907);
    }
    do
    {
      return;
      if (paramInt == 2)
      {
        this.X.setVisibility(0);
        this.Y.setVisibility(0);
        this.Z.setVisibility(0);
        this.aa.setVisibility(0);
        this.ab.setVisibility(0);
        this.Z.setBackgroundResource(2130839907);
        this.aa.setBackgroundResource(2130839907);
        this.ab.setBackgroundResource(2130839907);
        return;
      }
      if (paramInt == 3)
      {
        this.X.setVisibility(0);
        this.Y.setVisibility(0);
        this.Z.setVisibility(0);
        this.aa.setVisibility(0);
        this.ab.setVisibility(0);
        this.aa.setBackgroundResource(2130839907);
        this.ab.setBackgroundResource(2130839907);
        return;
      }
      if (paramInt == 4)
      {
        this.X.setVisibility(0);
        this.Y.setVisibility(0);
        this.Z.setVisibility(0);
        this.aa.setVisibility(0);
        this.ab.setVisibility(0);
        this.ab.setBackgroundResource(2130839907);
        return;
      }
    } while (paramInt != 5);
    this.X.setVisibility(0);
    this.Y.setVisibility(0);
    this.Z.setVisibility(0);
    this.aa.setVisibility(0);
    this.ab.setVisibility(0);
  }
  
  private void d(String paramString)
  {
    Button localButton = new Button(this);
    localButton.setText(paramString);
    localButton.setTag(Boolean.valueOf(false));
    localButton.setTextColor(getResources().getColor(2131624097));
    localButton.setTextSize(12.0F);
    localButton.setPadding(10, 0, 10, 0);
    localButton.setBackgroundResource(2130839367);
    paramString = new LinearLayout.LayoutParams(-2, -2);
    paramString.setMargins(10, 10, 10, 0);
    localButton.setLayoutParams(paramString);
    this.ak.addView(localButton);
  }
  
  private void e()
  {
    this.c = ((ApplicationEx)getApplication()).getUser();
    if (this.c == null) {
      return;
    }
    this.ai = getIntent().getStringExtra("serviceType");
    this.aj = getIntent().getStringExtra("maintainOrderCode");
    o.getNewRepairDetail(this.d, this.aA, this.c.getUid(), Long.valueOf(System.currentTimeMillis()), this.c.getLogin_name_mobile(), 12, this.aj, "", "2");
    showProgress("");
  }
  
  private void e(String paramString)
  {
    Button localButton = new Button(this);
    localButton.setText(paramString);
    localButton.setTag(Boolean.valueOf(false));
    localButton.setTextColor(getResources().getColor(2131624516));
    localButton.setTextSize(12.0F);
    localButton.setPadding(10, 0, 10, 0);
    localButton.setBackgroundResource(2130839371);
    paramString = new LinearLayout.LayoutParams(-2, -2);
    paramString.setMargins(10, 10, 10, 0);
    localButton.setLayoutParams(paramString);
    localButton.setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        paramAnonymousView = (Button)paramAnonymousView;
        String str = paramAnonymousView.getText().toString();
        if (!((Boolean)paramAnonymousView.getTag()).booleanValue())
        {
          int i = 0;
          int j = 0;
          while (i < RepairNewDetailActivity_New.i(RepairNewDetailActivity_New.this).size())
          {
            if (str.equals(((aj.a)RepairNewDetailActivity_New.i(RepairNewDetailActivity_New.this).get(i)).getTagValue())) {
              j = i;
            }
            i += 1;
          }
          if (RepairNewDetailActivity_New.m(RepairNewDetailActivity_New.this) != -1)
          {
            Button localButton = (Button)RepairNewDetailActivity_New.h(RepairNewDetailActivity_New.this).getFl_tag().getChildAt(RepairNewDetailActivity_New.m(RepairNewDetailActivity_New.this));
            localButton.setBackgroundResource(2130839371);
            localButton.setTextColor(RepairNewDetailActivity_New.this.getResources().getColor(2131624516));
            RepairNewDetailActivity_New.a(RepairNewDetailActivity_New.this, str);
            localButton.setTag(Boolean.valueOf(false));
          }
          RepairNewDetailActivity_New.b(RepairNewDetailActivity_New.this, j);
          RepairNewDetailActivity_New.b(RepairNewDetailActivity_New.this, true);
          paramAnonymousView.setBackgroundResource(2130839376);
          paramAnonymousView.setTextColor(RepairNewDetailActivity_New.this.getResources().getColor(2131624583));
          RepairNewDetailActivity_New.b(RepairNewDetailActivity_New.this, str);
          paramAnonymousView.setTag(Boolean.valueOf(true));
          return;
        }
        paramAnonymousView.setBackgroundResource(2130839371);
        paramAnonymousView.setTextColor(RepairNewDetailActivity_New.this.getResources().getColor(2131624516));
        RepairNewDetailActivity_New.a(RepairNewDetailActivity_New.this, str);
        RepairNewDetailActivity_New.b(RepairNewDetailActivity_New.this, false);
        paramAnonymousView.setTag(Boolean.valueOf(false));
      }
    });
    this.Q.getFl_tag().addView(localButton);
  }
  
  private void f()
  {
    List localList = this.e.getProductTagEntityList();
    if (localList != null)
    {
      int i = 0;
      while (i < localList.size())
      {
        d(((ah.c)localList.get(i)).getTagName());
        i += 1;
      }
    }
  }
  
  private void f(String paramString)
  {
    String str = this.M;
    if (ae.isNull(str)) {}
    for (;;)
    {
      this.M = paramString;
      return;
      paramString = str + "," + paramString;
    }
  }
  
  private void g()
  {
    this.f.setText(this.ai);
    this.g.setText(this.e.getOrderStatusName());
    Object localObject = this.e.getPlanTime();
    if (localObject != null)
    {
      localObject = ((String)localObject).substring(0, 16);
      this.s.setText((CharSequence)localObject);
    }
    this.r.setText(this.e.getCategoryName() + "-" + this.e.getProductName());
    this.t.setText(this.e.getAddess());
    this.u.setText(this.e.getLogicCode());
    this.P.setVisibility(8);
    this.am = this.e.getIsEvaluate();
    if (this.e.getUserMessage() != null)
    {
      this.v.setText(this.e.getUserMessage());
      f();
      h();
      if ((this.e.getIsPay() == 1) && ((this.e.getOrderStatus() == 15) || (this.e.getOrderStatus() == 20) || (this.e.getOrderStatus() == 25)))
      {
        this.S.setText("已支付");
        this.w.setText(this.e.getActualPayment() + "");
        this.P.setVisibility(0);
        this.P.setText("验收确认");
        this.P.setOnClickListener(new View.OnClickListener()
        {
          @Instrumented
          public void onClick(View paramAnonymousView)
          {
            VdsAgent.onClick(this, paramAnonymousView);
            o.getAcceptConfirm(RepairNewDetailActivity_New.c(RepairNewDetailActivity_New.this), RepairNewDetailActivity_New.e(RepairNewDetailActivity_New.this), RepairNewDetailActivity_New.f(RepairNewDetailActivity_New.this).getUid(), Long.valueOf(System.currentTimeMillis()), RepairNewDetailActivity_New.f(RepairNewDetailActivity_New.this).getLogin_name_mobile(), 12, RepairNewDetailActivity_New.l(RepairNewDetailActivity_New.this).getLogicCode(), "2");
          }
        });
      }
      if (this.e.getOrderStatus() == 30)
      {
        this.S.setText("已支付");
        this.w.setText(this.e.getActualPayment() + "");
        this.P.setText("去评价");
        this.P.setVisibility(0);
        this.P.setOnClickListener(new View.OnClickListener()
        {
          @Instrumented
          public void onClick(View paramAnonymousView)
          {
            VdsAgent.onClick(this, paramAnonymousView);
            paramAnonymousView = new Intent(RepairNewDetailActivity_New.c(RepairNewDetailActivity_New.this), RepairEvalActivity.class);
            paramAnonymousView.putExtra("maintainOrderCode", RepairNewDetailActivity_New.l(RepairNewDetailActivity_New.this).getLogicCode());
            paramAnonymousView.putExtra("servicerCode", RepairNewDetailActivity_New.l(RepairNewDetailActivity_New.this).getServicerCode());
            paramAnonymousView.putExtra("repairPrice", RepairNewDetailActivity_New.l(RepairNewDetailActivity_New.this).getActualPayment() + "");
            RepairNewDetailActivity_New.this.startActivity(paramAnonymousView);
          }
        });
      }
      if (this.e.getIsEvaluate() != 1) {
        break label698;
      }
      this.U.setVisibility(0);
      this.w.setText(this.e.getActualPayment() + "");
      this.P.setVisibility(0);
      this.S.setText("已支付");
      this.P.setText("再来一单");
      this.P.setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          paramAnonymousView = new Intent(RepairNewDetailActivity_New.c(RepairNewDetailActivity_New.this), MainActivity.class);
          RepairNewDetailActivity_New.this.startActivity(paramAnonymousView);
          RepairNewDetailActivity_New.this.finish();
        }
      });
    }
    for (;;)
    {
      if (this.e.getOrderStatus() == 1)
      {
        this.H.setBackgroundColor(Color.parseColor(this.a));
        this.D.setImageResource(2130838940);
        this.ac.setTextColor(Color.parseColor(this.a));
      }
      if ((this.e.getOrderStatus() == 15) || (this.e.getOrderStatus() == 20) || (this.e.getOrderStatus() == 30)) {
        i();
      }
      b(this.e.getOrderStatus());
      localObject = this.e.getRecords();
      localObject = new com.ziroom.ziroomcustomer.newServiceList.a.g(this.d, (List)localObject);
      this.R.setAdapter((ListAdapter)localObject);
      this.an = this.e.getOrderStatus();
      if ((this.an != 1) && (this.an != 5) && (this.an != 10) && ((this.an != 15) || (this.e.getIsPay() != 0))) {
        break label710;
      }
      this.C.setVisibility(0);
      return;
      if (this.e.getUserMessage() != null) {
        break;
      }
      this.v.setText("");
      break;
      label698:
      this.U.setVisibility(8);
    }
    label710:
    this.C.setVisibility(8);
  }
  
  private void g(String paramString)
  {
    String str2 = this.M;
    String str1 = str2;
    if (ae.notNull(str2))
    {
      str1 = str2.replace(paramString, "").replace(",,", ",");
      paramString = str1;
      if (str1.indexOf(",") == 0)
      {
        paramString = str1;
        if (str1.length() > 1) {
          paramString = str1.substring(1);
        }
      }
      int i = paramString.lastIndexOf(",");
      str1 = paramString;
      if (i > 0)
      {
        str1 = paramString;
        if (i == paramString.length() - 1) {
          str1 = paramString.substring(0, i);
        }
      }
    }
    this.M = str1;
  }
  
  private List<String> h(String paramString)
  {
    paramString = paramString.split(";");
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < paramString.length)
    {
      localArrayList.add(paramString[i]);
      i += 1;
    }
    return localArrayList;
  }
  
  private void h()
  {
    this.w.setBackgroundResource(2130839193);
    this.w.setEnabled(false);
    this.al = (this.e.getOrderPrice() - this.e.getCouponPrice());
    if (this.al <= 0) {
      this.al = 0;
    }
    this.w.setText(this.al + " ");
    if ((this.al <= 0) && (this.e.getIsPay() == 0) && ((this.e.getOrderStatus() == 15) || (this.e.getOrderStatus() == 20) || (this.e.getOrderStatus() == 25)))
    {
      this.P.setVisibility(0);
      this.P.setText("立即支付");
      this.w.setEnabled(true);
      this.w.setBackgroundResource(2130839193);
      this.P.setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          paramAnonymousView = VdsAgent.trackEditTextSilent(RepairNewDetailActivity_New.n(RepairNewDetailActivity_New.this)).toString().trim();
          if ("".equals(paramAnonymousView))
          {
            com.freelxl.baselibrary.f.g.textToast(RepairNewDetailActivity_New.c(RepairNewDetailActivity_New.this), "金额只能为整数");
            return;
          }
          if (!Pattern.compile("[0-9]*").matcher(paramAnonymousView).matches())
          {
            com.freelxl.baselibrary.f.g.textToast(RepairNewDetailActivity_New.c(RepairNewDetailActivity_New.this), "金额只能为整数");
            RepairNewDetailActivity_New.n(RepairNewDetailActivity_New.this).setText(" ");
            return;
          }
          RepairNewDetailActivity_New.a(RepairNewDetailActivity_New.this, Integer.parseInt(paramAnonymousView));
          if (RepairNewDetailActivity_New.o(RepairNewDetailActivity_New.this) > 0)
          {
            paramAnonymousView = new Intent(RepairNewDetailActivity_New.c(RepairNewDetailActivity_New.this), RepairPayActivtiy.class);
            localObject1 = new MHPayInfo("", RepairNewDetailActivity_New.l(RepairNewDetailActivity_New.this).getServicerOrderCode(), RepairNewDetailActivity_New.o(RepairNewDetailActivity_New.this), "", RepairNewDetailActivity_New.l(RepairNewDetailActivity_New.this).getConnectionName(), RepairNewDetailActivity_New.l(RepairNewDetailActivity_New.this).getLogicCode(), RepairNewDetailActivity_New.l(RepairNewDetailActivity_New.this).getPlanTime(), "", RepairNewDetailActivity_New.l(RepairNewDetailActivity_New.this).getAddess());
            localObject2 = new q();
            ((q)localObject2).setGoodsOrderCode(RepairNewDetailActivity_New.l(RepairNewDetailActivity_New.this).getServicerGoodsOrderCode());
            ((q)localObject2).setOrderPrice(String.valueOf(RepairNewDetailActivity_New.l(RepairNewDetailActivity_New.this).getCouponPrice() + RepairNewDetailActivity_New.o(RepairNewDetailActivity_New.this)));
            ArrayList localArrayList = new ArrayList();
            localArrayList.add(localObject2);
            paramAnonymousView.putExtra("positiveLabels", a.toJSONString(localArrayList));
            paramAnonymousView.putExtra("payInfo", (Serializable)localObject1);
            RepairNewDetailActivity_New.this.startActivityForResult(paramAnonymousView, 1);
            return;
          }
          paramAnonymousView = new HashMap();
          paramAnonymousView.put("billid", RepairNewDetailActivity_New.l(RepairNewDetailActivity_New.this).getServicerOrderCode());
          paramAnonymousView.put("money", Integer.valueOf(RepairNewDetailActivity_New.p(RepairNewDetailActivity_New.this)));
          paramAnonymousView.put("payKind", Integer.valueOf(1));
          Object localObject1 = new ArrayList();
          Object localObject2 = new HashMap();
          ((Map)localObject2).put("goodsOrderCode", RepairNewDetailActivity_New.l(RepairNewDetailActivity_New.this).getServicerGoodsOrderCode());
          ((Map)localObject2).put("orderPrice", Integer.valueOf(RepairNewDetailActivity_New.l(RepairNewDetailActivity_New.this).getOrderPrice()));
          ((List)localObject1).add(localObject2);
          paramAnonymousView.put("strGoodsOrderPrices", a.toJSONString(localObject1));
          RepairNewDetailActivity_New.a(RepairNewDetailActivity_New.this, true);
          com.ziroom.ziroomcustomer.e.j.PayOrder(RepairNewDetailActivity_New.c(RepairNewDetailActivity_New.this), paramAnonymousView, new RepairNewDetailActivity_New.a(RepairNewDetailActivity_New.this), RepairNewDetailActivity_New.q(RepairNewDetailActivity_New.this));
        }
      });
    }
    for (;;)
    {
      if (this.e != null)
      {
        if (!TextUtils.isEmpty(this.e.getServicerCode())) {
          break;
        }
        this.ax.setVisibility(8);
      }
      return;
      if ((this.al > 0) && (this.e.getIsPay() == 0) && ((this.e.getOrderStatus() == 15) || (this.e.getOrderStatus() == 20) || (this.e.getOrderStatus() == 25)))
      {
        this.w.setBackgroundResource(2130839193);
        this.w.setEnabled(true);
        this.P.setVisibility(0);
        this.P.setText("立即支付");
        this.P.setOnClickListener(new View.OnClickListener()
        {
          @Instrumented
          public void onClick(View paramAnonymousView)
          {
            VdsAgent.onClick(this, paramAnonymousView);
            paramAnonymousView = VdsAgent.trackEditTextSilent(RepairNewDetailActivity_New.n(RepairNewDetailActivity_New.this)).toString().trim();
            if ("".equals(paramAnonymousView))
            {
              com.freelxl.baselibrary.f.g.textToast(RepairNewDetailActivity_New.c(RepairNewDetailActivity_New.this), "金额只能为整数");
              return;
            }
            if (!Pattern.compile("[0-9]*").matcher(paramAnonymousView).matches())
            {
              com.freelxl.baselibrary.f.g.textToast(RepairNewDetailActivity_New.c(RepairNewDetailActivity_New.this), "金额只能为整数");
              RepairNewDetailActivity_New.n(RepairNewDetailActivity_New.this).setText(" ");
              return;
            }
            RepairNewDetailActivity_New.a(RepairNewDetailActivity_New.this, Integer.parseInt(paramAnonymousView));
            if (RepairNewDetailActivity_New.o(RepairNewDetailActivity_New.this) >= RepairNewDetailActivity_New.p(RepairNewDetailActivity_New.this))
            {
              paramAnonymousView = new Intent(RepairNewDetailActivity_New.c(RepairNewDetailActivity_New.this), RepairPayActivtiy.class);
              MHPayInfo localMHPayInfo = new MHPayInfo("", RepairNewDetailActivity_New.l(RepairNewDetailActivity_New.this).getServicerOrderCode(), RepairNewDetailActivity_New.o(RepairNewDetailActivity_New.this), "", RepairNewDetailActivity_New.l(RepairNewDetailActivity_New.this).getConnectionName(), RepairNewDetailActivity_New.l(RepairNewDetailActivity_New.this).getLogicCode(), RepairNewDetailActivity_New.l(RepairNewDetailActivity_New.this).getPlanTime(), "", RepairNewDetailActivity_New.l(RepairNewDetailActivity_New.this).getAddess());
              q localq = new q();
              localq.setGoodsOrderCode(RepairNewDetailActivity_New.l(RepairNewDetailActivity_New.this).getServicerGoodsOrderCode());
              localq.setOrderPrice(String.valueOf(RepairNewDetailActivity_New.l(RepairNewDetailActivity_New.this).getOrderPrice() + RepairNewDetailActivity_New.o(RepairNewDetailActivity_New.this) - RepairNewDetailActivity_New.p(RepairNewDetailActivity_New.this)));
              ArrayList localArrayList = new ArrayList();
              localArrayList.add(localq);
              paramAnonymousView.putExtra("positiveLabels", a.toJSONString(localArrayList));
              paramAnonymousView.putExtra("payInfo", localMHPayInfo);
              RepairNewDetailActivity_New.this.startActivityForResult(paramAnonymousView, 1);
              return;
            }
            com.freelxl.baselibrary.f.g.textToast(RepairNewDetailActivity_New.c(RepairNewDetailActivity_New.this), "修改后的金额，不能低于原始金额");
          }
        });
      }
    }
    Bundle localBundle = new Bundle();
    localBundle.putString("thumbType", "repair");
    localBundle.putString("showType", "detail");
    localBundle.putString("orderCode", this.e.getLogicCode());
    localBundle.putString("orderNum", this.e.getLogicCode());
    localBundle.putString("employeeCode", this.e.getServicerCode());
    com.ziroom.ziroomcustomer.newServiceList.utils.j.setServantThumb(this.d, this.ax, localBundle);
  }
  
  private void i()
  {
    this.x.setVisibility(0);
    if (this.e.getServicerName() != null) {
      this.y.setText(this.e.getServicerName());
    }
    for (;;)
    {
      this.z.setText("累计服务" + this.e.getServiceNum() + "次");
      if (!TextUtils.isEmpty(this.e.getServicerHeadPath())) {
        this.ah.setController(com.freelxl.baselibrary.f.c.frescoController(this.e.getServicerHeadPath()));
      }
      this.A.setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          com.ziroom.ziroomcustomer.util.ah.callPhone(RepairNewDetailActivity_New.c(RepairNewDetailActivity_New.this), RepairNewDetailActivity_New.l(RepairNewDetailActivity_New.this).getServicerPhone());
        }
      });
      return;
      this.y.setText("");
    }
  }
  
  private void j()
  {
    if (this.am == 1)
    {
      this.am = 0;
      this.W.setVisibility(0);
      this.aw.setText("收起评价");
      this.V.setImageResource(2130839909);
      c(this.e.getScore());
      this.at = this.e.getPositiveLabels();
      this.au = this.e.getNegativeLabels();
      if ((this.at == null) && (this.au == null)) {
        this.av.setVisibility(8);
      }
    }
    while (this.am != 0)
    {
      return;
      a(this.ap);
      return;
    }
    this.am = 1;
    this.W.setVisibility(8);
    this.aw.setText("查看评价");
    this.V.setImageResource(2130839906);
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    switch (paramInt1)
    {
    }
    do
    {
      return;
    } while (paramInt2 != 512);
    showProgress(" ");
    new Thread()
    {
      public void run()
      {
        super.run();
        try
        {
          Thread.sleep(3000L);
          org.greenrobot.eventbus.c.getDefault().post(new com.ziroom.ziroomcustomer.newServiceList.utils.c("refresh_service_order_list", null));
          return;
        }
        catch (InterruptedException localInterruptedException)
        {
          localInterruptedException.printStackTrace();
        }
      }
    }.start();
    if (this.ak != null) {
      this.ak.removeAllViews();
    }
    o.getNewRepairDetail(this.d, this.aA, this.c.getUid(), Long.valueOf(System.currentTimeMillis()), this.c.getLogin_name_mobile(), 12, this.aj, "", "2");
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
      finish();
      return;
    case 2131690421: 
      this.Q = new d(this, 2131427591);
      this.Q.setHandler(this.aA);
      this.Q.setCancelerId(this.c.getUid());
      o.getExternalRepairCancleDicTag(this.d, this.aA, this.c.getUid(), Long.valueOf(System.currentTimeMillis()), this.c.getLogin_name_mobile(), 12, this.aj, "2");
      return;
    }
    j();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903445);
    this.d = this;
    a();
    b();
    e();
  }
  
  public void onRefresh()
  {
    if (this.ak != null) {
      this.ak.removeAllViews();
    }
    o.getNewRepairDetail(this.d, this.aA, this.c.getUid(), Long.valueOf(System.currentTimeMillis()), this.c.getLogin_name_mobile(), 12, this.aj, "", "2");
  }
  
  protected void onRestart()
  {
    super.onRestart();
    if (this.ak != null) {
      this.ak.removeAllViews();
    }
    o.getNewRepairDetail(this.d, this.aA, this.c.getUid(), Long.valueOf(System.currentTimeMillis()), this.c.getLogin_name_mobile(), 12, this.aj, "", "2");
    showProgress("");
  }
  
  public void onScroll(int paramInt) {}
  
  public class a
    implements i.a<String>
  {
    public a() {}
    
    public void onParse(String paramString, k paramk)
    {
      paramString = a.parseObject(paramString);
      if ("0".equals((String)paramString.get("status")))
      {
        if (RepairNewDetailActivity_New.q(RepairNewDetailActivity_New.this)) {
          paramk.setObject(null);
        }
        for (;;)
        {
          paramk.setSuccess(Boolean.valueOf(true));
          return;
          ap localap = (ap)a.parseObject(paramString.get("data").toString(), ap.class);
          localap.set_package((String)a.parseObject(paramString.get("data").toString()).get("package"));
          paramk.setObject(localap);
        }
      }
      paramk.setSuccess(Boolean.valueOf(false));
      paramk.setMessage((String)paramString.get("message"));
    }
    
    public void onSuccess(k paramk)
    {
      if (paramk.getSuccess().booleanValue())
      {
        if (RepairNewDetailActivity_New.q(RepairNewDetailActivity_New.this))
        {
          com.freelxl.baselibrary.f.g.textToast(RepairNewDetailActivity_New.c(RepairNewDetailActivity_New.this), "0元购订单支付成功!");
          if (RepairNewDetailActivity_New.d(RepairNewDetailActivity_New.this) != null) {
            RepairNewDetailActivity_New.d(RepairNewDetailActivity_New.this).removeAllViews();
          }
          o.getNewRepairDetail(RepairNewDetailActivity_New.c(RepairNewDetailActivity_New.this), RepairNewDetailActivity_New.e(RepairNewDetailActivity_New.this), RepairNewDetailActivity_New.f(RepairNewDetailActivity_New.this).getUid(), Long.valueOf(System.currentTimeMillis()), RepairNewDetailActivity_New.f(RepairNewDetailActivity_New.this).getLogin_name_mobile(), 12, RepairNewDetailActivity_New.g(RepairNewDetailActivity_New.this), "", "2");
          new Thread()
          {
            public void run()
            {
              super.run();
              try
              {
                Thread.sleep(3000L);
                org.greenrobot.eventbus.c.getDefault().post(new com.ziroom.ziroomcustomer.newServiceList.utils.c("refresh_service_order_list", null));
                return;
              }
              catch (InterruptedException localInterruptedException)
              {
                localInterruptedException.printStackTrace();
              }
            }
          }.start();
          RepairNewDetailActivity_New.this.dismissProgress();
        }
        return;
      }
      paramk = paramk.getMessage();
      if (paramk != null) {
        com.freelxl.baselibrary.f.g.textToast(RepairNewDetailActivity_New.c(RepairNewDetailActivity_New.this), paramk);
      }
      for (;;)
      {
        RepairNewDetailActivity_New.this.dismissProgress();
        return;
        com.freelxl.baselibrary.f.g.textToast(RepairNewDetailActivity_New.c(RepairNewDetailActivity_New.this), "支付失败，请重试");
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newServiceList/activity/RepairNewDetailActivity_New.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */