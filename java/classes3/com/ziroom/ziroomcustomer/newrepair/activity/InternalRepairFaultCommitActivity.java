package com.ziroom.ziroomcustomer.newrepair.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.Selection;
import android.text.Spannable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.freelxl.baselibrary.f.g;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.commonlib.utils.SignKeyUtil;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.e.j;
import com.ziroom.ziroomcustomer.e.l;
import com.ziroom.ziroomcustomer.model.Contract;
import com.ziroom.ziroomcustomer.model.InternalFaultPic;
import com.ziroom.ziroomcustomer.model.RepairWork;
import com.ziroom.ziroomcustomer.model.RepairWorkItem;
import com.ziroom.ziroomcustomer.model.UserInfo;
import com.ziroom.ziroomcustomer.newServiceList.model.LabelMo;
import com.ziroom.ziroomcustomer.newrepair.b.e;
import com.ziroom.ziroomcustomer.newrepair.b.i;
import com.ziroom.ziroomcustomer.newrepair.b.u;
import com.ziroom.ziroomcustomer.newrepair.b.v;
import com.ziroom.ziroomcustomer.newrepair.b.v.a;
import com.ziroom.ziroomcustomer.newrepair.dialog.a.a;
import com.ziroom.ziroomcustomer.util.ah;
import com.ziroom.ziroomcustomer.util.m;
import com.ziroom.ziroomcustomer.widget.ObservableScrollView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class InternalRepairFaultCommitActivity
  extends BaseActivity
  implements View.OnClickListener
{
  private Button A;
  private Context B;
  private List<Contract> C = new ArrayList();
  private UserInfo D;
  private EditText E;
  private int F = 140;
  private View G;
  private View H;
  private TextView I;
  private String J;
  private String K;
  private String L;
  private String M;
  private String N;
  private String O;
  private String P;
  private String Q;
  private String R;
  private String S;
  private String T;
  private int U;
  private String V;
  private String W;
  private String X;
  private String Y;
  private String Z;
  private ImageView a;
  private String aa;
  private String ab;
  private String ac;
  private Integer ad;
  private String ae;
  private String af;
  private List<RepairWork> ag = new ArrayList();
  private List<RepairWorkItem> ah = new ArrayList();
  private List<InternalFaultPic> ai = new ArrayList();
  private List<String> aj;
  private List<String> ak = new ArrayList();
  private List<List<String>> al = new ArrayList();
  private boolean am = false;
  private String an;
  private int ao;
  private String ap;
  private String aq;
  private ObservableScrollView b;
  private SimpleDraweeView c;
  private TextView d;
  private TextView e;
  private TextView f;
  private TextView g;
  private ImageView r;
  private RelativeLayout s;
  private TextView t;
  private View u;
  private ImageView v;
  private FrameLayout w;
  private EditText x;
  private TextView y;
  private TextView z;
  
  private void a()
  {
    this.B = this;
    this.a = ((ImageView)findViewById(2131689492));
    this.b = ((ObservableScrollView)findViewById(2131689506));
    this.c = ((SimpleDraweeView)findViewById(2131692135));
    this.d = ((TextView)findViewById(2131692136));
    this.d.setFocusable(true);
    this.d.setFocusableInTouchMode(true);
    this.d.requestFocus();
    this.e = ((TextView)findViewById(2131692137));
    this.f = ((TextView)findViewById(2131692139));
    this.G = findViewById(2131692138);
    this.H = findViewById(2131692140);
    this.I = ((TextView)findViewById(2131692141));
    this.g = ((TextView)findViewById(2131690053));
    this.r = ((ImageView)findViewById(2131692143));
    this.s = ((RelativeLayout)findViewById(2131692144));
    this.t = ((TextView)findViewById(2131692146));
    this.u = findViewById(2131692148);
    this.E = ((EditText)findViewById(2131689811));
    this.v = ((ImageView)findViewById(2131692150));
    this.w = ((FrameLayout)findViewById(2131692152));
    this.x = ((EditText)findViewById(2131692153));
    this.y = ((TextView)findViewById(2131692154));
    this.z = ((TextView)findViewById(2131692151));
    this.A = ((Button)findViewById(2131691009));
  }
  
  private void b()
  {
    this.a.setOnClickListener(this);
    this.g.setOnClickListener(this);
    this.v.setOnClickListener(this);
    this.r.setOnClickListener(this);
    this.s.setOnClickListener(this);
    this.A.setOnClickListener(this);
    this.E.addTextChangedListener(new TextWatcher()
    {
      public void afterTextChanged(Editable paramAnonymousEditable) {}
      
      public void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        if (paramAnonymousCharSequence.length() > 0)
        {
          InternalRepairFaultCommitActivity.a(InternalRepairFaultCommitActivity.this).setVisibility(0);
          return;
        }
        InternalRepairFaultCommitActivity.a(InternalRepairFaultCommitActivity.this).setVisibility(8);
      }
    });
    this.x.addTextChangedListener(new TextWatcher()
    {
      private CharSequence b;
      private int c;
      private int d;
      
      public void afterTextChanged(Editable paramAnonymousEditable)
      {
        int i = paramAnonymousEditable.length();
        InternalRepairFaultCommitActivity.c(InternalRepairFaultCommitActivity.this).setText("" + i);
        this.c = InternalRepairFaultCommitActivity.d(InternalRepairFaultCommitActivity.this).getSelectionStart();
        this.d = InternalRepairFaultCommitActivity.d(InternalRepairFaultCommitActivity.this).getSelectionEnd();
        if (this.b.length() > InternalRepairFaultCommitActivity.e(InternalRepairFaultCommitActivity.this))
        {
          paramAnonymousEditable.delete(this.c - 1, this.d);
          i = this.d;
          InternalRepairFaultCommitActivity.d(InternalRepairFaultCommitActivity.this).setText(paramAnonymousEditable);
          InternalRepairFaultCommitActivity.d(InternalRepairFaultCommitActivity.this).setSelection(i);
        }
      }
      
      public void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        this.b = paramAnonymousCharSequence;
        InternalRepairFaultCommitActivity.b(InternalRepairFaultCommitActivity.this);
      }
    });
  }
  
  private void back()
  {
    Intent localIntent = new Intent(this.B, InternalRepairFaultDescActivity.class);
    localIntent.putExtra("chosenServiceAddress", this.g.getText().toString());
    localIntent.putExtra("chosenServiceDate", this.t.getText().toString());
    localIntent.putExtra("orderData", this.an);
    localIntent.putExtra("orderPeriod", this.ao);
    localIntent.putExtra("orderTimeInterval", this.ap);
    localIntent.putExtra("connectPhone", VdsAgent.trackEditTextSilent(this.E).toString());
    localIntent.putExtra("leaveMessage", VdsAgent.trackEditTextSilent(this.x).toString());
    e locale = new e();
    locale.setChosenServiceAddress(this.g.getText().toString());
    locale.setChosenServiceDate(this.t.getText().toString());
    locale.setOrderData(this.an);
    locale.setOrderPeriod(this.ao);
    locale.setOrderTimeInterval(this.ap);
    locale.setConnectPhone(VdsAgent.trackEditTextSilent(this.E).toString());
    locale.setLeaveMessage(VdsAgent.trackEditTextSilent(this.x).toString());
    org.greenrobot.eventbus.c.getDefault().post(new com.ziroom.ziroomcustomer.newServiceList.utils.c("internal_repair_fault_commit_back_data", locale));
    setResult(-1, localIntent);
    finish();
  }
  
  private void e()
  {
    this.ab = getIntent().getStringExtra("chosenServiceAddress");
    this.af = getIntent().getStringExtra("connectPhone");
    Object localObject = getIntent().getStringExtra("leaveMessage");
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      this.x.setText((CharSequence)localObject);
      this.y.setText("" + ((String)localObject).length());
      localObject = VdsAgent.trackEditTextSilent(this.x);
      if ((localObject instanceof Spannable)) {
        Selection.setSelection((Spannable)localObject, ((CharSequence)localObject).length());
      }
      g();
    }
    this.W = getIntent().getStringExtra("isUrgencyOtherRepair");
    this.X = getIntent().getStringExtra("repairFaultDescOtherTagName");
    this.Y = getIntent().getStringExtra("repairFaultDescOtherTagId");
    this.K = getIntent().getStringExtra("isUrgencyRepair");
    if (!TextUtils.isEmpty(this.K))
    {
      if ("1".equals(this.K))
      {
        this.aa = "";
        this.ac = "";
        this.ad = null;
        this.ae = "";
      }
    }
    else
    {
      this.N = getIntent().getStringExtra("repairFaultPic");
      this.O = getIntent().getStringExtra("repairFaultName");
      this.P = getIntent().getStringExtra("repairFaultArea");
      this.S = getIntent().getStringExtra("repairFaultAreaId");
      this.Q = getIntent().getStringExtra("repairFaultDescTagName");
      this.M = getIntent().getStringExtra("repairFaultDescTagId");
      boolean bool = getIntent().getBooleanExtra("isChosenOther", false);
      this.R = getIntent().getStringExtra("repairFaultDesc");
      this.L = getIntent().getStringExtra("repairGoodsCode");
      this.T = getIntent().getStringExtra("mPicsJsonStr");
      if (TextUtils.isEmpty(this.K)) {
        break label835;
      }
      if (!"1".equals(this.K)) {
        break label803;
      }
      this.s.setVisibility(8);
      this.u.setVisibility(8);
      this.z.setVisibility(0);
      g();
      label412:
      if (!TextUtils.isEmpty(this.N)) {
        this.c.setController(com.freelxl.baselibrary.f.c.frescoController(this.N));
      }
      if (!TextUtils.isEmpty(this.O)) {
        this.d.setText(this.O);
      }
      if (!TextUtils.isEmpty(this.P)) {
        this.e.setText(this.P);
      }
      if (TextUtils.isEmpty(this.Q)) {
        break label913;
      }
      this.f.setVisibility(0);
      this.G.setVisibility(0);
      this.f.setText(this.Q);
      label515:
      if ((!bool) || (TextUtils.isEmpty(this.R))) {
        break label934;
      }
      this.H.setVisibility(0);
      this.I.setVisibility(0);
      this.I.setText(this.R);
      label556:
      this.D = ((ApplicationEx)getApplication()).getUser();
      if (TextUtils.isEmpty(this.af)) {
        break label955;
      }
      this.E.setText(this.af);
      label591:
      this.C = ApplicationEx.c.getContracts();
      if ((this.C != null) && (this.C.size() != 0))
      {
        if (this.C.size() <= 1) {
          break label979;
        }
        this.r.setVisibility(0);
        this.g.setClickable(true);
        label649:
        if (TextUtils.isEmpty(this.ab)) {
          break label999;
        }
        this.g.setText(this.ab);
      }
      label670:
      if (TextUtils.isEmpty(this.M)) {
        break label1027;
      }
      this.Z = this.M;
    }
    for (;;)
    {
      g();
      showProgressNoCancel("", 30000L);
      j.getInternalRepairTime(this.B, "", this.L, this.Z, new b(new com.ziroom.ziroomcustomer.newrepair.utils.b(v.class)));
      return;
      this.aa = getIntent().getStringExtra("chosenServiceDate");
      this.ac = getIntent().getStringExtra("orderData");
      this.ad = Integer.valueOf(getIntent().getIntExtra("orderPeriod", -1));
      this.ae = getIntent().getStringExtra("orderTimeInterval");
      break;
      label803:
      this.s.setVisibility(0);
      this.u.setVisibility(0);
      this.z.setVisibility(8);
      g();
      break label412;
      label835:
      if ("1".equals(this.W))
      {
        this.s.setVisibility(8);
        this.u.setVisibility(8);
        this.z.setVisibility(0);
        g();
        break label412;
      }
      this.s.setVisibility(0);
      this.u.setVisibility(0);
      this.z.setVisibility(8);
      g();
      break label412;
      label913:
      this.f.setVisibility(8);
      this.G.setVisibility(8);
      break label515;
      label934:
      this.H.setVisibility(8);
      this.I.setVisibility(8);
      break label556;
      label955:
      if (this.D == null) {
        break label591;
      }
      this.E.setText(this.D.getPhone());
      break label591;
      label979:
      this.r.setVisibility(8);
      this.g.setClickable(false);
      break label649;
      label999:
      localObject = ((Contract)this.C.get(0)).getAddress();
      this.g.setText((CharSequence)localObject);
      break label670;
      label1027:
      if (!TextUtils.isEmpty(this.Y)) {
        this.Z = this.Y;
      } else {
        this.Z = "";
      }
    }
  }
  
  private void f()
  {
    this.ah.clear();
    this.ag.clear();
    Object localObject1 = VdsAgent.trackEditTextSilent(this.E).toString();
    if (TextUtils.isEmpty((CharSequence)localObject1))
    {
      g.textToast(this.B, "联系电话不能为空");
      return;
    }
    if (!ah.isMobile((String)localObject1))
    {
      g.textToast(this.B, "请填写正确的电话号码");
      return;
    }
    showProgressNoCancel("", 30000L);
    Object localObject2 = new RepairWork();
    ((RepairWork)localObject2).setOrderTime(this.an);
    ((RepairWork)localObject2).setOrderTimePeriod(this.ao);
    ((RepairWork)localObject2).setOrderTimeInterval(this.ap);
    ((RepairWork)localObject2).setSupEmpId("");
    ((RepairWork)localObject2).setSupplierId("");
    Object localObject3 = new RepairWorkItem();
    ((RepairWorkItem)localObject3).setGoodsId(this.L);
    ((RepairWorkItem)localObject3).setKongJianId(this.S);
    ((RepairWorkItem)localObject3).setZhutiId("");
    ((RepairWorkItem)localObject3).setOjectId("");
    ((RepairWorkItem)localObject3).setWxgzId("");
    ((RepairWorkItem)localObject3).setPic(this.N);
    if (!TextUtils.isEmpty(this.T))
    {
      localObject4 = com.alibaba.fastjson.a.parseArray(this.T, String.class).iterator();
      while (((Iterator)localObject4).hasNext())
      {
        localObject5 = (String)((Iterator)localObject4).next();
        localObject6 = new InternalFaultPic();
        ((InternalFaultPic)localObject6).setPicUrl((String)localObject5);
        this.ai.add(localObject6);
      }
    }
    ((RepairWorkItem)localObject3).setPicList(this.ai);
    ((RepairWorkItem)localObject3).setDetailDescription(this.R);
    Object localObject4 = new LabelMo();
    ((LabelMo)localObject4).setTagName(this.Q);
    ((LabelMo)localObject4).setLogicCode(this.M);
    if (!TextUtils.isEmpty(this.K)) {
      ((LabelMo)localObject4).setIsUrgent(Integer.valueOf(this.K));
    }
    Object localObject5 = new LabelMo();
    ((LabelMo)localObject5).setTagName(this.X);
    ((LabelMo)localObject5).setLogicCode(this.Y);
    if (!TextUtils.isEmpty(this.W)) {
      ((LabelMo)localObject5).setIsUrgent(Integer.valueOf(this.W));
    }
    Object localObject6 = new ArrayList();
    if ((!TextUtils.isEmpty(this.Q)) && (!TextUtils.isEmpty(this.M)) && (!TextUtils.isEmpty(this.K))) {
      ((ArrayList)localObject6).add(localObject4);
    }
    if ((!TextUtils.isEmpty(this.X)) && (!TextUtils.isEmpty(this.Y)) && (!TextUtils.isEmpty(this.W))) {
      ((ArrayList)localObject6).add(localObject5);
    }
    ((RepairWorkItem)localObject3).setLableCode((ArrayList)localObject6);
    this.ah.add(localObject3);
    ((RepairWork)localObject2).setWxxmList(this.ah);
    this.ag.add(localObject2);
    if ((this.C.size() > 1) && (!this.C.isEmpty()) && (this.U != -1)) {}
    for (this.J = ((Contract)this.C.get(this.U)).getContract_code(); TextUtils.isEmpty(this.g.getText().toString()); this.J = ((Contract)this.C.get(0)).getContract_code())
    {
      g.textToast(this.B, "请选择服务地址");
      return;
    }
    if ((this.D != null) && (this.C != null))
    {
      localObject3 = this.D.getLogin_name_mobile();
      localObject4 = m.GetNowDate();
      localObject2 = new HashMap();
      ((Map)localObject2).put("signDate", localObject4);
      ((Map)localObject2).put("loginPhone", localObject3);
      ((Map)localObject2).put("uid", this.D.getUid());
      ((Map)localObject2).put("appVersionStr", ah.getVersion(ApplicationEx.c));
      ((Map)localObject2).put("result", ah.toMd5((SignKeyUtil.getSignKey() + (String)localObject3 + (String)localObject4).getBytes()));
      ((Map)localObject2).put("contactName", this.D.getUser_name());
      ((Map)localObject2).put("contactTel", localObject1);
      ((Map)localObject2).put("rentContractCode", this.J);
      ((Map)localObject2).put("address", this.g.getText().toString());
      ((Map)localObject2).put("isConfirm", Integer.valueOf(1));
      ((Map)localObject2).put("dataSource", Integer.valueOf(12));
      ((Map)localObject2).put("cusWords", VdsAgent.trackEditTextSilent(this.x).toString());
      ((Map)localObject2).put("city_code", com.ziroom.ziroomcustomer.base.b.d);
      ((Map)localObject2).put("workBillList", com.alibaba.fastjson.a.toJSON(this.ag));
      localObject1 = new HashMap();
      ((Map)localObject1).put("json", com.alibaba.fastjson.a.toJSONString(localObject2));
      j.makeInternalRepairOrder(this.B, (Map)localObject1, new a(new com.ziroom.ziroomcustomer.newrepair.utils.b(u.class)));
      return;
    }
    g.textToast(this.B, "登录状态异常，请重新登录");
  }
  
  private void g()
  {
    if (("1".equals(this.K)) || ("1".equals(this.W)))
    {
      if ((!TextUtils.isEmpty(this.g.getText().toString())) && (!TextUtils.isEmpty(VdsAgent.trackEditTextSilent(this.E).toString())))
      {
        this.A.setEnabled(true);
        return;
      }
      this.A.setEnabled(false);
      return;
    }
    if ((!TextUtils.isEmpty(this.g.getText().toString())) && (!TextUtils.isEmpty(this.t.getText().toString())) && (!TextUtils.isEmpty(VdsAgent.trackEditTextSilent(this.E).toString())))
    {
      this.A.setEnabled(true);
      return;
    }
    this.A.setEnabled(false);
  }
  
  private void h()
  {
    com.ziroom.ziroomcustomer.newrepair.dialog.a locala = new com.ziroom.ziroomcustomer.newrepair.dialog.a(this.B, new c(), this.ak, this.al);
    locala.setCanceledOnTouchOutside(true);
    Window localWindow = locala.getWindow();
    localWindow.getDecorView().setPadding(0, 0, 0, 0);
    WindowManager.LayoutParams localLayoutParams = localWindow.getAttributes();
    localLayoutParams.width = -1;
    localLayoutParams.height = -2;
    localWindow.setAttributes(localLayoutParams);
    localWindow.setGravity(80);
    locala.show();
    locala.getTv_choose().setText("上门时间");
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt2 == -1) && (paramInt1 == 123) && (paramIntent != null))
    {
      this.V = paramIntent.getStringExtra("addressListJsonStr");
      this.U = paramIntent.getIntExtra("addressPosition", -1);
      paramIntent = com.alibaba.fastjson.a.parseArray(this.V, i.class);
      if ((paramIntent != null) && (!paramIntent.isEmpty()))
      {
        paramIntent = ((i)paramIntent.get(this.U)).getAddress();
        this.g.setText(paramIntent);
      }
      g();
    }
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
      back();
      return;
    case 2131690053: 
    case 2131692143: 
      paramView = new Intent(this.B, InternalAddressChosenActivity.class);
      paramView.putExtra("mContractList", com.alibaba.fastjson.a.toJSONString(this.C));
      paramView.putExtra("addressListJsonStr", this.V);
      paramView.putExtra("addressChosenStr", this.g.getText().toString());
      startActivityForResult(paramView, 123);
      return;
    case 2131692144: 
      if (this.am)
      {
        h();
        return;
      }
      g.textToast(this.B, "服务异常，请稍后重试");
      return;
    case 2131692150: 
      this.E.setText("");
      return;
    }
    f();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903446);
    a();
    b();
    e();
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      back();
      return true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  class a
    extends com.freelxl.baselibrary.d.c.a<l>
  {
    public a(com.freelxl.baselibrary.d.f.a parama)
    {
      super();
    }
    
    public void onFailure(Throwable paramThrowable)
    {
      com.ziroom.ziroomcustomer.newrepair.utils.c.catchExp(paramThrowable);
      InternalRepairFaultCommitActivity.this.dismissProgress();
    }
    
    public void onSuccess(int paramInt, l paraml)
    {
      if (paraml.getSuccess().booleanValue())
      {
        InternalRepairFaultCommitActivity.this.dismissProgress();
        paraml = (u)paraml.getObject();
        g.textToast(InternalRepairFaultCommitActivity.f(InternalRepairFaultCommitActivity.this), "您已成功预约维修!");
        Intent localIntent = new Intent(InternalRepairFaultCommitActivity.f(InternalRepairFaultCommitActivity.this), InternalRepairFaultCommitSuccessActivity.class);
        localIntent.putExtra("repariInfo", paraml);
        InternalRepairFaultCommitActivity.this.startActivity(localIntent);
        InternalRepairFaultCommitActivity.this.finish();
        return;
      }
      InternalRepairFaultCommitActivity.this.dismissProgress();
      paraml = paraml.getMessage();
      g.textToast(InternalRepairFaultCommitActivity.f(InternalRepairFaultCommitActivity.this), paraml);
    }
  }
  
  private class b
    extends com.freelxl.baselibrary.d.c.a<l>
  {
    public b()
    {
      super();
    }
    
    public void onFailure(Throwable paramThrowable)
    {
      com.ziroom.ziroomcustomer.newrepair.utils.c.catchExp(paramThrowable);
      InternalRepairFaultCommitActivity.a(InternalRepairFaultCommitActivity.this, false);
      InternalRepairFaultCommitActivity.this.dismissProgress();
    }
    
    public void onSuccess(int paramInt, l paraml)
    {
      if (paraml.getSuccess().booleanValue())
      {
        InternalRepairFaultCommitActivity.this.dismissProgress();
        paraml = (v)paraml.getObject();
        if (paraml != null)
        {
          Object localObject = paraml.getNowDate();
          paraml = paraml.getAppointmentTimeList();
          if (TextUtils.isEmpty((CharSequence)localObject))
          {
            g.textToast(InternalRepairFaultCommitActivity.f(InternalRepairFaultCommitActivity.this), "服务异常，请稍后重试");
            return;
          }
          if ((paraml == null) || (paraml.isEmpty()))
          {
            g.textToast(InternalRepairFaultCommitActivity.f(InternalRepairFaultCommitActivity.this), "服务异常，请稍后重试");
            return;
          }
          InternalRepairFaultCommitActivity.a(InternalRepairFaultCommitActivity.this, new com.ziroom.ziroomcustomer.newrepair.utils.c().getServiceDateList(paraml));
          InternalRepairFaultCommitActivity.b(InternalRepairFaultCommitActivity.this, new com.ziroom.ziroomcustomer.newrepair.utils.c().getServiceAppointDateList((String)localObject, paraml));
          InternalRepairFaultCommitActivity.g(InternalRepairFaultCommitActivity.this).clear();
          localObject = paraml.iterator();
          while (((Iterator)localObject).hasNext())
          {
            v.a locala = (v.a)((Iterator)localObject).next();
            InternalRepairFaultCommitActivity.g(InternalRepairFaultCommitActivity.this).add(locala.getTime());
          }
          if (!TextUtils.isEmpty(InternalRepairFaultCommitActivity.h(InternalRepairFaultCommitActivity.this)))
          {
            InternalRepairFaultCommitActivity.i(InternalRepairFaultCommitActivity.this).setText(InternalRepairFaultCommitActivity.h(InternalRepairFaultCommitActivity.this));
            InternalRepairFaultCommitActivity.a(InternalRepairFaultCommitActivity.this, InternalRepairFaultCommitActivity.j(InternalRepairFaultCommitActivity.this));
            InternalRepairFaultCommitActivity.a(InternalRepairFaultCommitActivity.this, InternalRepairFaultCommitActivity.k(InternalRepairFaultCommitActivity.this).intValue());
            InternalRepairFaultCommitActivity.b(InternalRepairFaultCommitActivity.this, InternalRepairFaultCommitActivity.l(InternalRepairFaultCommitActivity.this));
          }
          for (;;)
          {
            InternalRepairFaultCommitActivity.b(InternalRepairFaultCommitActivity.this);
            InternalRepairFaultCommitActivity.a(InternalRepairFaultCommitActivity.this, true);
            return;
            if ("1".equals(InternalRepairFaultCommitActivity.m(InternalRepairFaultCommitActivity.this)))
            {
              InternalRepairFaultCommitActivity.c(InternalRepairFaultCommitActivity.this, "");
              InternalRepairFaultCommitActivity.d(InternalRepairFaultCommitActivity.this, "");
              InternalRepairFaultCommitActivity.a(InternalRepairFaultCommitActivity.this, null);
              InternalRepairFaultCommitActivity.e(InternalRepairFaultCommitActivity.this, "");
            }
            else
            {
              localObject = (String)InternalRepairFaultCommitActivity.n(InternalRepairFaultCommitActivity.this).get(0);
              paraml = ((v.a)paraml.get(0)).getTime();
              if ((paraml == null) || (paraml.isEmpty()))
              {
                g.textToast(InternalRepairFaultCommitActivity.f(InternalRepairFaultCommitActivity.this), "服务异常，请稍后重试");
                return;
              }
              paraml = (String)paraml.get(0);
              InternalRepairFaultCommitActivity.i(InternalRepairFaultCommitActivity.this).setText((String)localObject + " " + paraml);
              InternalRepairFaultCommitActivity.a(InternalRepairFaultCommitActivity.this, ((String)InternalRepairFaultCommitActivity.n(InternalRepairFaultCommitActivity.this).get(0)).replaceAll("/", "-"));
              InternalRepairFaultCommitActivity.a(InternalRepairFaultCommitActivity.this, 1);
              InternalRepairFaultCommitActivity.b(InternalRepairFaultCommitActivity.this, (String)((List)InternalRepairFaultCommitActivity.g(InternalRepairFaultCommitActivity.this).get(0)).get(0));
            }
          }
        }
        g.textToast(InternalRepairFaultCommitActivity.f(InternalRepairFaultCommitActivity.this), "服务异常，请稍后重试");
        InternalRepairFaultCommitActivity.a(InternalRepairFaultCommitActivity.this, false);
        return;
      }
      InternalRepairFaultCommitActivity.this.dismissProgress();
      paraml = paraml.getMessage();
      InternalRepairFaultCommitActivity.this.showToast(paraml);
      InternalRepairFaultCommitActivity.a(InternalRepairFaultCommitActivity.this, false);
    }
  }
  
  public class c
    implements a.a
  {
    public c() {}
    
    public void showHour(String paramString, int paramInt1, int paramInt2)
    {
      InternalRepairFaultCommitActivity.f(InternalRepairFaultCommitActivity.this, (String)InternalRepairFaultCommitActivity.n(InternalRepairFaultCommitActivity.this).get(paramInt1) + " " + paramString);
      InternalRepairFaultCommitActivity.i(InternalRepairFaultCommitActivity.this).setText(InternalRepairFaultCommitActivity.o(InternalRepairFaultCommitActivity.this));
      InternalRepairFaultCommitActivity.a(InternalRepairFaultCommitActivity.this, ((String)InternalRepairFaultCommitActivity.n(InternalRepairFaultCommitActivity.this).get(paramInt1)).replaceAll("/", "-"));
      InternalRepairFaultCommitActivity.a(InternalRepairFaultCommitActivity.this, paramInt2 + 1);
      InternalRepairFaultCommitActivity.b(InternalRepairFaultCommitActivity.this, (String)((List)InternalRepairFaultCommitActivity.g(InternalRepairFaultCommitActivity.this).get(paramInt1)).get(paramInt2));
      InternalRepairFaultCommitActivity.b(InternalRepairFaultCommitActivity.this);
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newrepair/activity/InternalRepairFaultCommitActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */