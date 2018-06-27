package com.ziroom.ziroomcustomer.newrepair.activity;

import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.text.format.DateFormat;
import android.text.format.Time;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.dialog.g.a;
import com.ziroom.ziroomcustomer.e.l;
import com.ziroom.ziroomcustomer.e.o;
import com.ziroom.ziroomcustomer.model.RepairWork;
import com.ziroom.ziroomcustomer.model.RepairWorkItem;
import com.ziroom.ziroomcustomer.model.UserInfo;
import com.ziroom.ziroomcustomer.newServiceList.utils.i;
import com.ziroom.ziroomcustomer.newrepair.b.q;
import com.ziroom.ziroomcustomer.newrepair.b.r;
import com.ziroom.ziroomcustomer.newrepair.b.w;
import com.ziroom.ziroomcustomer.newrepair.dialog.b;
import com.ziroom.ziroomcustomer.newrepair.dialog.d;
import com.ziroom.ziroomcustomer.newrepair.dialog.e;
import com.ziroom.ziroomcustomer.newrepair.dialog.e.a;
import com.ziroom.ziroomcustomer.util.ae;
import com.ziroom.ziroomcustomer.util.h;
import com.ziroom.ziroomcustomer.util.m;
import com.ziroom.ziroomcustomer.util.u;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class RepairNewItemActivity
  extends BaseActivity
  implements View.OnClickListener
{
  private List<String> A = new ArrayList();
  private d B;
  private String C;
  private String D;
  private int E = -1;
  private Context F;
  private String G = "";
  private String H = "";
  private String I = "";
  private ArrayList<String> J = new ArrayList(3);
  private Intent K;
  private List<r> L = new ArrayList();
  private List<w> M;
  private List<q> N;
  private int O;
  private String P;
  private String Q;
  private String[] R = { "今天", "明天", "后天", "07月24日", "07月25日", "07月26日", "07月27日" };
  private String[] S = { "9:00-13:00", "13:00-17:00", "17:00-24:00" };
  private List<String> T = new ArrayList();
  private List<String> U = new ArrayList();
  private String V;
  private String W;
  private List<String> X;
  private UserInfo Y;
  private String Z;
  TextView[] a = new TextView[3];
  private String aa;
  private String ab;
  private ArrayList<RepairWorkItem> ac = new ArrayList();
  private RepairWorkItem ad;
  private RepairWork ae;
  private String af;
  private String ag;
  private String ah;
  private String ai;
  private String aj;
  private String ak;
  private int al;
  private String am;
  private int an;
  private int ao;
  private String ap;
  private Handler aq = new Handler()
  {
    public void handleMessage(Message paramAnonymousMessage)
    {
      Object localObject = (l)paramAnonymousMessage.obj;
      switch (paramAnonymousMessage.what)
      {
      default: 
        return;
      case 4144: 
        RepairNewItemActivity.this.dismissProgress();
        if (((l)localObject).getSuccess().booleanValue())
        {
          RepairNewItemActivity.d(RepairNewItemActivity.this, (String)((l)localObject).getObject());
          u.e("imageurl: ", RepairNewItemActivity.q(RepairNewItemActivity.this));
          RepairNewItemActivity.this.showPhoto(RepairNewItemActivity.q(RepairNewItemActivity.this), RepairNewItemActivity.r(RepairNewItemActivity.this));
          return;
        }
        com.freelxl.baselibrary.f.g.textToast(RepairNewItemActivity.c(RepairNewItemActivity.this), "图片上传失败！");
        return;
      case 8343: 
        RepairNewItemActivity.this.dismissProgress();
        if (((l)localObject).getSuccess().booleanValue())
        {
          paramAnonymousMessage = (List)((l)localObject).getObject();
          RepairNewItemActivity.d(RepairNewItemActivity.this, (String)paramAnonymousMessage.get(0));
          u.e("imageurl: ", RepairNewItemActivity.q(RepairNewItemActivity.this));
          RepairNewItemActivity.this.showPhoto(RepairNewItemActivity.q(RepairNewItemActivity.this), RepairNewItemActivity.r(RepairNewItemActivity.this));
          return;
        }
        com.freelxl.baselibrary.f.g.textToast(RepairNewItemActivity.c(RepairNewItemActivity.this), "图片上传失败！");
        return;
      case 4197: 
        RepairNewItemActivity.this.dismissProgress();
        if (((l)localObject).getSuccess().booleanValue())
        {
          RepairNewItemActivity.a(RepairNewItemActivity.this, (List)((l)localObject).getObject());
          paramAnonymousMessage = RepairNewItemActivity.n(RepairNewItemActivity.this).iterator();
          while (paramAnonymousMessage.hasNext())
          {
            localObject = (r)paramAnonymousMessage.next();
            RepairNewItemActivity.k(RepairNewItemActivity.this).add(((r)localObject).getName());
          }
        }
        com.freelxl.baselibrary.f.g.textToast(RepairNewItemActivity.c(RepairNewItemActivity.this), ((l)localObject).getMessage());
        return;
      case 4198: 
        RepairNewItemActivity.this.dismissProgress();
        if (((l)localObject).getSuccess().booleanValue())
        {
          RepairNewItemActivity.b(RepairNewItemActivity.this, (List)((l)localObject).getObject());
          RepairNewItemActivity.o(RepairNewItemActivity.this).clear();
          paramAnonymousMessage = RepairNewItemActivity.p(RepairNewItemActivity.this).iterator();
          while (paramAnonymousMessage.hasNext())
          {
            localObject = (w)paramAnonymousMessage.next();
            RepairNewItemActivity.o(RepairNewItemActivity.this).add(((w)localObject).getName());
          }
          RepairNewItemActivity.s(RepairNewItemActivity.this);
          return;
        }
        com.freelxl.baselibrary.f.g.textToast(RepairNewItemActivity.c(RepairNewItemActivity.this), ((l)localObject).getMessage());
        return;
      case 4201: 
        RepairNewItemActivity.this.dismissProgress();
        if (((l)localObject).getSuccess().booleanValue())
        {
          RepairNewItemActivity.c(RepairNewItemActivity.this, (List)((l)localObject).getObject());
          return;
        }
        com.freelxl.baselibrary.f.g.textToast(RepairNewItemActivity.c(RepairNewItemActivity.this), ((l)localObject).getMessage());
        return;
      case 4133: 
        paramAnonymousMessage = (l)paramAnonymousMessage.obj;
        if (paramAnonymousMessage.getSuccess().booleanValue())
        {
          paramAnonymousMessage = (Map)paramAnonymousMessage.getObject();
          RepairNewItemActivity.e(RepairNewItemActivity.this, (String)paramAnonymousMessage.get("startTime"));
          paramAnonymousMessage = (String)paramAnonymousMessage.get("endTime");
          RepairNewItemActivity.d(RepairNewItemActivity.this, new i().getSevenDateList(RepairNewItemActivity.t(RepairNewItemActivity.this)));
          RepairNewItemActivity.e(RepairNewItemActivity.this, new i().getAppointDateList(m.GetNowDate(), RepairNewItemActivity.t(RepairNewItemActivity.this)));
          RepairNewItemActivity.u(RepairNewItemActivity.this);
        }
        for (;;)
        {
          RepairNewItemActivity.this.dismissProgress();
          return;
          com.freelxl.baselibrary.f.g.textToast(RepairNewItemActivity.c(RepairNewItemActivity.this), ((l)localObject).getMessage());
        }
      case 65608: 
        paramAnonymousMessage = (l)paramAnonymousMessage.obj;
        if (paramAnonymousMessage.getSuccess().booleanValue())
        {
          RepairNewItemActivity.f(RepairNewItemActivity.this, (String)paramAnonymousMessage.getObject());
          return;
        }
        com.freelxl.baselibrary.f.g.textToast(RepairNewItemActivity.c(RepairNewItemActivity.this), ((l)localObject).getMessage());
        return;
      }
      paramAnonymousMessage = (l)paramAnonymousMessage.obj;
      if (paramAnonymousMessage.getSuccess().booleanValue())
      {
        paramAnonymousMessage = (Map)paramAnonymousMessage.getObject();
        RepairNewItemActivity.g(RepairNewItemActivity.this, (String)paramAnonymousMessage.get("supEmpId"));
        RepairNewItemActivity.h(RepairNewItemActivity.this, (String)paramAnonymousMessage.get("supplierId"));
      }
      for (;;)
      {
        RepairNewItemActivity.this.dismissProgress();
        return;
        com.freelxl.baselibrary.f.g.textToast(RepairNewItemActivity.c(RepairNewItemActivity.this), ((l)localObject).getMessage());
      }
    }
  };
  private BroadcastReceiver ar = new BroadcastReceiver()
  {
    public void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
    {
      if (paramAnonymousIntent.getAction().equals("repair_delete")) {
        RepairNewItemActivity.this.finish();
      }
    }
  };
  private View.OnClickListener as = new View.OnClickListener()
  {
    @Instrumented
    public void onClick(View paramAnonymousView)
    {
      VdsAgent.onClick(this, paramAnonymousView);
      RepairNewItemActivity.v(RepairNewItemActivity.this).dismiss();
      switch (paramAnonymousView.getId())
      {
      default: 
        return;
      case 2131692507: 
        RepairNewItemActivity.this.takePhoto();
        return;
      }
      RepairNewItemActivity.this.selectPhoto();
    }
  };
  ImageView[] b = new ImageView[3];
  private ImageView c;
  private RelativeLayout d;
  private TextView e;
  private RelativeLayout f;
  private TextView g;
  private RelativeLayout r;
  private TextView s;
  private RelativeLayout t;
  private TextView u;
  private EditText v;
  private ImageView w;
  private Button x;
  private List<String> y = new ArrayList();
  private List<String> z = new ArrayList();
  
  private void a()
  {
    this.ap = getIntent().getStringExtra("ContractCode");
    o.getRepairPlace(this, this.aq, this.ap);
    o.getRepairEngineer(this, this.aq);
    showProgress("");
    int i = 0;
    while (i < this.S.length)
    {
      this.U.add(this.S[i]);
      i += 1;
    }
  }
  
  private void a(Intent paramIntent)
  {
    Object localObject = new StringBuilder();
    new DateFormat();
    this.C = (DateFormat.format("yyyyMMddhhmmss", Calendar.getInstance(Locale.CHINA)) + ".jpg");
    paramIntent = paramIntent.getData();
    if (paramIntent == null) {
      return;
    }
    localObject = getContentResolver();
    try
    {
      paramIntent = BitmapFactory.decodeStream(((ContentResolver)localObject).openInputStream(paramIntent));
      h.saveBitmap(paramIntent, this.C, 50);
      paramIntent.recycle();
      return;
    }
    catch (FileNotFoundException paramIntent)
    {
      paramIntent.printStackTrace();
    }
  }
  
  private void a(RepairWork paramRepairWork)
  {
    String[] arrayOfString1 = ((RepairWorkItem)paramRepairWork.getWxxmList().get(0)).getImage();
    String[] arrayOfString2 = ((RepairWorkItem)paramRepairWork.getWxxmList().get(0)).getUrl();
    this.e.setText(((RepairWorkItem)paramRepairWork.getWxxmList().get(0)).getKongJian());
    this.g.setText(((RepairWorkItem)paramRepairWork.getWxxmList().get(0)).getZhuti());
    this.s.setText(((RepairWorkItem)paramRepairWork.getWxxmList().get(0)).getWxgz());
    this.u.setText(paramRepairWork.getOrderTime().replaceAll("-", "/") + " " + i.getYdTime(paramRepairWork.getOrderTimePeriod()));
    this.v.setText(((RepairWorkItem)paramRepairWork.getWxxmList().get(0)).getDetailDescription());
    this.g.setTextColor(Color.parseColor("#111111"));
    this.e.setTextColor(Color.parseColor("#111111"));
    this.s.setTextColor(Color.parseColor("#111111"));
    this.u.setTextColor(Color.parseColor("#111111"));
    this.v.setTextColor(Color.parseColor("#111111"));
    if ((arrayOfString1 != null) && (arrayOfString1.length != 0))
    {
      int i = 0;
      while (i < arrayOfString1.length)
      {
        try
        {
          Object localObject = h.tryGetBitmap(arrayOfString1[i], 100, 10000);
          if ((localObject != null) && (localObject != null))
          {
            localObject = new BitmapDrawable((Bitmap)localObject);
            this.a[i].setBackgroundDrawable((Drawable)localObject);
            this.a[i].setText("");
            this.b[i].setVisibility(0);
            this.ad.getImage()[i] = arrayOfString1[i];
            this.ad.getUrl()[i] = arrayOfString2[i];
          }
        }
        catch (Exception localException)
        {
          for (;;)
          {
            localException.printStackTrace();
          }
        }
        i += 1;
      }
    }
    this.P = ((RepairWorkItem)paramRepairWork.getWxxmList().get(0)).getKongJianId();
    this.Q = ((RepairWorkItem)paramRepairWork.getWxxmList().get(0)).getZhutiId();
    this.ai = ((RepairWorkItem)paramRepairWork.getWxxmList().get(0)).getOjectId();
    this.ah = ((RepairWorkItem)paramRepairWork.getWxxmList().get(0)).getOject();
    this.aj = ((RepairWorkItem)paramRepairWork.getWxxmList().get(0)).getCue();
    this.ag = ((RepairWorkItem)paramRepairWork.getWxxmList().get(0)).getWxgzId();
    this.af = ((RepairWorkItem)paramRepairWork.getWxxmList().get(0)).getWxgz();
    this.ak = paramRepairWork.getOrderTime();
    this.al = paramRepairWork.getOrderTimePeriod();
    this.am = paramRepairWork.getSupplierId();
    this.Z = paramRepairWork.getSupEmpId();
    this.aa = paramRepairWork.getLockSupEmpId();
    this.ab = paramRepairWork.getLockSupplierId();
    this.an = paramRepairWork.getQuery_object_index();
    this.ao = paramRepairWork.getQuery_reason_index();
  }
  
  private void b()
  {
    this.c = ((ImageView)findViewById(2131689492));
    this.d = ((RelativeLayout)findViewById(2131697400));
    this.e = ((TextView)findViewById(2131697396));
    this.f = ((RelativeLayout)findViewById(2131697402));
    this.g = ((TextView)findViewById(2131689922));
    this.r = ((RelativeLayout)findViewById(2131697404));
    this.s = ((TextView)findViewById(2131697397));
    this.t = ((RelativeLayout)findViewById(2131697406));
    this.u = ((TextView)findViewById(2131697408));
    this.v = ((EditText)findViewById(2131697411));
    this.a[0] = ((TextView)findViewById(2131692501));
    this.a[1] = ((TextView)findViewById(2131697413));
    this.a[2] = ((TextView)findViewById(2131697415));
    this.b[0] = ((ImageView)findViewById(2131697412));
    this.b[1] = ((ImageView)findViewById(2131697414));
    this.b[2] = ((ImageView)findViewById(2131697416));
    this.w = ((ImageView)findViewById(2131691648));
    this.x = ((Button)findViewById(2131689843));
    Object localObject = new IntentFilter();
    ((IntentFilter)localObject).addAction("repair_delete");
    registerReceiver(this.ar, (IntentFilter)localObject);
    this.ad = new RepairWorkItem();
    this.ae = new RepairWork();
    if (getIntent().getStringExtra("isRepairItem") != null)
    {
      localObject = getIntent().getStringExtra("isRepairItem");
      this.O = getIntent().getExtras().getInt("index");
      this.ae = ((RepairWork)getIntent().getSerializableExtra("repairWork"));
      a(this.ae);
      if ("repairItem".equals(localObject))
      {
        this.w.setVisibility(0);
        this.w.setOnClickListener(new View.OnClickListener()
        {
          @Instrumented
          public void onClick(View paramAnonymousView)
          {
            VdsAgent.onClick(this, paramAnonymousView);
            RepairNewItemActivity.this.showItemIsEmpty();
          }
        });
      }
    }
  }
  
  private void e()
  {
    this.d.setOnClickListener(this);
    this.f.setOnClickListener(this);
    this.r.setOnClickListener(this);
    this.t.setOnClickListener(this);
    this.c.setOnClickListener(this);
    this.x.setOnClickListener(this);
    this.a[0].setOnClickListener(this);
    this.a[1].setOnClickListener(this);
    this.a[2].setOnClickListener(this);
    this.b[0].setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        RepairNewItemActivity.this.a[0].setBackgroundResource(2130839895);
        RepairNewItemActivity.this.a[0].setText("上传图片");
        RepairNewItemActivity.this.b[0].setVisibility(8);
        RepairNewItemActivity.a(RepairNewItemActivity.this).getImage()[0] = "";
        RepairNewItemActivity.a(RepairNewItemActivity.this).getUrl()[0] = "";
      }
    });
    this.b[1].setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        RepairNewItemActivity.this.a[1].setBackgroundResource(2130839895);
        RepairNewItemActivity.this.a[1].setText("上传图片");
        RepairNewItemActivity.this.b[1].setVisibility(8);
        RepairNewItemActivity.a(RepairNewItemActivity.this).getImage()[1] = "";
        RepairNewItemActivity.a(RepairNewItemActivity.this).getUrl()[1] = "";
      }
    });
    this.b[2].setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        RepairNewItemActivity.this.a[2].setBackgroundResource(2130839895);
        RepairNewItemActivity.this.a[2].setText("上传图片");
        RepairNewItemActivity.this.b[2].setVisibility(8);
        RepairNewItemActivity.a(RepairNewItemActivity.this).getImage()[2] = "";
        RepairNewItemActivity.a(RepairNewItemActivity.this).getUrl()[2] = "";
      }
    });
  }
  
  private void f()
  {
    final Dialog localDialog = new Dialog(this, 2131427591);
    View localView = getLayoutInflater().inflate(2130903648, null);
    TextView localTextView1 = (TextView)localView.findViewById(2131691289);
    TextView localTextView2 = (TextView)localView.findViewById(2131691288);
    ((TextView)localView.findViewById(2131693113)).setText("确定取消维修项目？");
    localTextView1.setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        localDialog.dismiss();
        RepairNewItemActivity.this.finish();
      }
    });
    localTextView2.setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        localDialog.dismiss();
      }
    });
    localDialog.setContentView(localView);
    if (!(localDialog instanceof Dialog))
    {
      localDialog.show();
      return;
    }
    VdsAgent.showDialog((Dialog)localDialog);
  }
  
  private void g()
  {
    if (this.g.getText().toString() != null)
    {
      if ("电器".equals(this.g.getText().toString()))
      {
        this.U.clear();
        i = 0;
        while (i < this.S.length - 1)
        {
          this.U.add(this.S[i]);
          i += 1;
        }
      }
      this.U.clear();
      int i = 0;
      while (i < this.S.length)
      {
        this.U.add(this.S[i]);
        i += 1;
      }
    }
    e locale = new e(this, new c(), this.T, this.U);
    locale.setCanceledOnTouchOutside(true);
    Window localWindow = locale.getWindow();
    localWindow.getDecorView().setPadding(0, 0, 0, 0);
    WindowManager.LayoutParams localLayoutParams = localWindow.getAttributes();
    localLayoutParams.width = -1;
    localLayoutParams.height = -2;
    localWindow.setAttributes(localLayoutParams);
    localWindow.setGravity(80);
    locale.show();
    this.t.setClickable(true);
    locale.getTv_choose().setText("预约时间");
  }
  
  private void h()
  {
    if (this.Q == null) {
      com.freelxl.baselibrary.f.g.textToast(this.F, "请选择上面选项");
    }
    for (;;)
    {
      return;
      this.t.setClickable(false);
      Iterator localIterator = this.N.iterator();
      while (localIterator.hasNext())
      {
        q localq = (q)localIterator.next();
        if (this.Q.equals(localq.getKjId()))
        {
          this.Z = localq.getEmpTypeId();
          this.am = localq.getKjId();
          o.getRepairTime(this, this.aq, this.Z);
          showProgress("");
        }
      }
    }
  }
  
  private void i()
  {
    j();
    Intent localIntent = new Intent(this, RepairNewActivity.class);
    localIntent.putExtra("repairWorkItem", this.ad);
    localIntent.putExtra("repairWork", this.ae);
    localIntent.putExtra("order_time", this.u.getText().toString());
    Bundle localBundle = new Bundle();
    localBundle.putInt("index_item", this.O);
    localIntent.putExtras(localBundle);
    setResult(-1, localIntent);
    finish();
  }
  
  private void j()
  {
    this.ad.setKongJianId(this.P);
    this.ad.setKongJian(this.e.getText().toString());
    this.ad.setZhutiId(this.Q);
    this.ad.setZhuti(this.g.getText().toString());
    this.ad.setOjectId(this.ai);
    this.ad.setOject(this.ah);
    this.ad.setCue(this.aj);
    this.ad.setWxgzId(this.ag);
    this.ad.setWxgz(this.af);
    this.ad.setDetailDescription(VdsAgent.trackEditTextSilent(this.v).toString());
    this.ac.add(this.ad);
    this.ae.setOrderTime(this.ak);
    this.ae.setOrderTimePeriod(this.al);
    this.ae.setSupplierId(this.am);
    this.ae.setSupEmpId(this.Z);
    this.ae.setLockSupEmpId(this.aa);
    this.ae.setLockSupplierId(this.ab);
    this.ae.setQuery_object_index(this.an);
    this.ae.setQuery_reason_index(this.ao);
    this.ae.setWxxmList(this.ac);
  }
  
  private void k()
  {
    if ((this.y != null) && (this.y.size() != 0))
    {
      com.ziroom.ziroomcustomer.dialog.g localg = new com.ziroom.ziroomcustomer.dialog.g(this, new a(), null, this.y);
      localg.setCanceledOnTouchOutside(true);
      Window localWindow = localg.getWindow();
      localWindow.getDecorView().setPadding(0, 0, 0, 0);
      WindowManager.LayoutParams localLayoutParams = localWindow.getAttributes();
      localLayoutParams.width = -1;
      localLayoutParams.height = -2;
      localWindow.setAttributes(localLayoutParams);
      localWindow.setGravity(80);
      localg.show();
      localg.getTv_choose().setText("维修空间");
    }
  }
  
  private void l()
  {
    if ((this.z != null) && (this.z.size() != 0))
    {
      com.ziroom.ziroomcustomer.dialog.g localg = new com.ziroom.ziroomcustomer.dialog.g(this, new b(), null, this.z);
      localg.setCanceledOnTouchOutside(true);
      Window localWindow = localg.getWindow();
      localWindow.getDecorView().setPadding(0, 0, 0, 0);
      WindowManager.LayoutParams localLayoutParams = localWindow.getAttributes();
      localLayoutParams.width = -1;
      localLayoutParams.height = -2;
      localWindow.setAttributes(localLayoutParams);
      localWindow.setGravity(80);
      localg.show();
      localg.getTv_choose().setText("维修类型");
    }
  }
  
  private void m()
  {
    this.K = new Intent(this, RepairReasonActivity.class);
    this.K.putExtra("place_code", this.P);
    this.K.putExtra("type_code", this.Q);
    Bundle localBundle = new Bundle();
    localBundle.putInt("query_object_index", this.an);
    localBundle.putInt("query_reason_index", this.ao);
    this.K.putExtras(localBundle);
    startActivityForResult(this.K, 3);
    o.getRepairArticle(this, this.aq, this.P, this.Q);
  }
  
  private void n()
  {
    this.B = new d(this, this.as);
    d locald = this.B;
    View localView = findViewById(2131690092);
    if (!(locald instanceof PopupWindow))
    {
      locald.showAtLocation(localView, 81, 0, 0);
      return;
    }
    VdsAgent.showAtLocation((PopupWindow)locald, localView, 81, 0, 0);
  }
  
  public int GetNowHourTime()
  {
    Time localTime = new Time();
    localTime.setToNow();
    return localTime.hour;
  }
  
  public boolean checkInputBack()
  {
    boolean bool = true;
    if ("选择维修空间".equals(this.e.getText().toString())) {
      bool = false;
    }
    return bool;
  }
  
  public boolean checkInputValue()
  {
    boolean bool = true;
    if ("选择维修空间".equals(this.e.getText().toString())) {
      bool = false;
    }
    if ("选择维修类型".equals(this.g.getText().toString())) {
      bool = false;
    }
    if ("选择故障原因".equals(this.s.getText().toString())) {
      bool = false;
    }
    if ("选择预约时间".equals(this.u.getText().toString())) {
      bool = false;
    }
    if ("输入备注信息".equals(VdsAgent.trackEditTextSilent(this.v).toString())) {
      return false;
    }
    return bool;
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt1 == 1) && (paramInt2 == -1)) {
      uploadPhoto();
    }
    for (;;)
    {
      if ((paramInt1 == 3) && (paramInt2 == -1))
      {
        this.af = paramIntent.getStringExtra("repair_reason");
        this.ag = paramIntent.getStringExtra("repair_reason_code");
        this.ah = paramIntent.getStringExtra("repair_object_name");
        this.ai = paramIntent.getStringExtra("repair_object_code");
        this.aj = paramIntent.getStringExtra("repair_object_cue");
        Object localObject = paramIntent.getExtras();
        this.an = ((Bundle)localObject).getInt("query_object_index");
        this.ao = ((Bundle)localObject).getInt("query_reason_index");
        this.s.setText(paramIntent.getStringExtra("repair_reason"));
        localObject = this.e.getText().toString();
        this.v.setText((String)localObject + paramIntent.getStringExtra("repair_reason"));
        this.s.setTextColor(Color.parseColor("#111111"));
        this.v.setTextColor(Color.parseColor("#111111"));
      }
      return;
      if ((paramInt1 == 2) && (paramInt2 == -1) && (paramIntent != null))
      {
        a(paramIntent);
        uploadPhoto();
      }
    }
  }
  
  @Instrumented
  public void onClick(View paramView)
  {
    VdsAgent.onClick(this, paramView);
    switch (paramView.getId())
    {
    }
    do
    {
      do
      {
        do
        {
          return;
          k();
          return;
          if (this.P == null)
          {
            com.freelxl.baselibrary.f.g.textToast(this.F, "请输入维修空间");
            return;
          }
          o.getRepairType(this, this.aq, this.P);
          showProgress("");
          return;
          if (this.Q == null)
          {
            com.freelxl.baselibrary.f.g.textToast(this.F, "请输入维修类型");
            return;
          }
          m();
          return;
          h();
          return;
          if (!checkInputValue())
          {
            com.freelxl.baselibrary.f.g.textToast(this.F, "维修项目信息填写不完整，请补充完整，谢谢！");
            return;
          }
          i();
          return;
          if (!checkInputBack())
          {
            finish();
            return;
          }
          f();
          return;
        } while (!ae.isNull(this.G));
        this.E = 1;
        n();
        return;
      } while (!ae.isNull(this.H));
      this.E = 2;
      n();
      return;
    } while (!ae.isNull(this.I));
    this.E = 3;
    n();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130905094);
    this.F = this;
    this.Y = ApplicationEx.c.getUser();
    b();
    a();
    e();
  }
  
  public void onDestroy()
  {
    unregisterReceiver(this.ar);
    super.onDestroy();
  }
  
  public void selectPhoto()
  {
    Intent localIntent = new Intent("android.intent.action.GET_CONTENT");
    localIntent.addCategory("android.intent.category.OPENABLE");
    localIntent.setType("image/*");
    startActivityForResult(Intent.createChooser(localIntent, "选择图片"), 2);
  }
  
  public void showItemIsEmpty()
  {
    b localb = new b(this, this.O);
    localb.setCanceledOnTouchOutside(true);
    localb.show();
  }
  
  public void showPhoto(String paramString, int paramInt)
  {
    if (paramInt == 1)
    {
      this.a[0].setText("");
      this.b[0].setVisibility(0);
      this.b[0].setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          RepairNewItemActivity.i(RepairNewItemActivity.this, "");
          RepairNewItemActivity.this.a[0].setBackgroundResource(2130839895);
          RepairNewItemActivity.this.a[0].setText("上传图片");
          RepairNewItemActivity.this.b[0].setVisibility(4);
          RepairNewItemActivity.a(RepairNewItemActivity.this).getImage()[0] = "";
          RepairNewItemActivity.a(RepairNewItemActivity.this).getUrl()[0] = "";
        }
      });
    }
    for (;;)
    {
      if (!ae.isNull(this.C)) {}
      try
      {
        paramString = h.tryGetBitmap(this.C, 100, 10000);
        if ((paramString != null) && (paramString != null))
        {
          paramString = new BitmapDrawable(paramString);
          this.a[(paramInt - 1)].setBackgroundDrawable(paramString);
          this.ad.getImage()[(paramInt - 1)] = this.C;
          this.ad.getUrl()[(paramInt - 1)] = this.D;
        }
        return;
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
      }
      if (paramInt == 2)
      {
        this.a[1].setText("");
        this.b[1].setVisibility(0);
        this.b[1].setOnClickListener(new View.OnClickListener()
        {
          @Instrumented
          public void onClick(View paramAnonymousView)
          {
            VdsAgent.onClick(this, paramAnonymousView);
            RepairNewItemActivity.j(RepairNewItemActivity.this, "");
            RepairNewItemActivity.this.a[1].setBackgroundResource(2130839895);
            RepairNewItemActivity.this.a[1].setText("上传图片");
            RepairNewItemActivity.this.b[1].setVisibility(4);
            RepairNewItemActivity.a(RepairNewItemActivity.this).getImage()[1] = "";
            RepairNewItemActivity.a(RepairNewItemActivity.this).getUrl()[1] = "";
          }
        });
      }
      else if (paramInt == 3)
      {
        this.a[2].setText("");
        this.b[2].setVisibility(0);
        this.b[2].setOnClickListener(new View.OnClickListener()
        {
          @Instrumented
          public void onClick(View paramAnonymousView)
          {
            VdsAgent.onClick(this, paramAnonymousView);
            RepairNewItemActivity.k(RepairNewItemActivity.this, "");
            RepairNewItemActivity.this.a[2].setBackgroundResource(2130839895);
            RepairNewItemActivity.this.a[2].setText("上传图片");
            RepairNewItemActivity.this.b[2].setVisibility(4);
            RepairNewItemActivity.a(RepairNewItemActivity.this).getImage()[2] = "";
            RepairNewItemActivity.a(RepairNewItemActivity.this).getUrl()[2] = "";
          }
        });
      }
    }
  }
  
  public void takePhoto()
  {
    Intent localIntent = new Intent("android.media.action.IMAGE_CAPTURE");
    Object localObject = new StringBuilder();
    new DateFormat();
    this.C = (DateFormat.format("yyyyMMddhhmmss", Calendar.getInstance(Locale.CHINA)) + ".jpg");
    localObject = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/images/");
    if (!((File)localObject).exists()) {
      ((File)localObject).mkdirs();
    }
    localIntent.putExtra("output", Uri.fromFile(new File((File)localObject, this.C)));
    startActivityForResult(localIntent, 1);
  }
  
  public void uploadPhoto()
  {
    showProgress("图片上传中...");
    Bitmap localBitmap = h.tryGetBitmap(this.C, 1280, 500000);
    if (localBitmap != null)
    {
      h.saveBitmap(localBitmap, this.C, 100);
      localBitmap.recycle();
      o.uploadImage(this, this.aq, this.C, h.getBitmapByte(this.C));
    }
  }
  
  class a
    implements g.a
  {
    a() {}
    
    public void showHour(String paramString, int paramInt)
    {
      if ((RepairNewItemActivity.k(RepairNewItemActivity.this) != null) && (RepairNewItemActivity.k(RepairNewItemActivity.this).size() != 0))
      {
        RepairNewItemActivity.l(RepairNewItemActivity.this).setText((CharSequence)RepairNewItemActivity.k(RepairNewItemActivity.this).get(paramInt));
        RepairNewItemActivity.b(RepairNewItemActivity.this).setText("选择维修类型");
        RepairNewItemActivity.m(RepairNewItemActivity.this).setText("选择故障原因");
        RepairNewItemActivity.d(RepairNewItemActivity.this).setText("选择预约时间");
        RepairNewItemActivity.b(RepairNewItemActivity.this).setTextColor(-6579301);
        RepairNewItemActivity.m(RepairNewItemActivity.this).setTextColor(-6579301);
        RepairNewItemActivity.d(RepairNewItemActivity.this).setTextColor(-6579301);
        RepairNewItemActivity.b(RepairNewItemActivity.this, 0);
        RepairNewItemActivity.c(RepairNewItemActivity.this, -1);
        RepairNewItemActivity.b(RepairNewItemActivity.this, ((r)RepairNewItemActivity.n(RepairNewItemActivity.this).get(paramInt)).getCode());
        RepairNewItemActivity.l(RepairNewItemActivity.this).setTextColor(Color.parseColor("#111111"));
      }
    }
  }
  
  class b
    implements g.a
  {
    b() {}
    
    public void showHour(String paramString, int paramInt)
    {
      if ((RepairNewItemActivity.o(RepairNewItemActivity.this) != null) && (RepairNewItemActivity.o(RepairNewItemActivity.this).size() != 0))
      {
        RepairNewItemActivity.b(RepairNewItemActivity.this).setText((CharSequence)RepairNewItemActivity.o(RepairNewItemActivity.this).get(paramInt));
        RepairNewItemActivity.m(RepairNewItemActivity.this).setText("选择故障原因");
        RepairNewItemActivity.d(RepairNewItemActivity.this).setText("选择预约时间");
        RepairNewItemActivity.m(RepairNewItemActivity.this).setTextColor(-6579301);
        RepairNewItemActivity.d(RepairNewItemActivity.this).setTextColor(-6579301);
        RepairNewItemActivity.b(RepairNewItemActivity.this, 0);
        RepairNewItemActivity.c(RepairNewItemActivity.this, -1);
        RepairNewItemActivity.c(RepairNewItemActivity.this, ((w)RepairNewItemActivity.p(RepairNewItemActivity.this).get(paramInt)).getCode());
        RepairNewItemActivity.b(RepairNewItemActivity.this).setTextColor(Color.parseColor("#111111"));
      }
    }
  }
  
  public class c
    implements e.a
  {
    public c() {}
    
    public void showHour(String paramString, int paramInt1, int paramInt2)
    {
      if ((RepairNewItemActivity.b(RepairNewItemActivity.this).getText().toString() != null) && (("锁类".equals(RepairNewItemActivity.b(RepairNewItemActivity.this).getText().toString())) || ("疏通".equals(RepairNewItemActivity.b(RepairNewItemActivity.this).getText().toString()))))
      {
        int i = RepairNewItemActivity.this.GetNowHourTime();
        if ((i > 12) && (paramInt1 == 0) && (paramInt2 == 0))
        {
          com.freelxl.baselibrary.f.g.textToast(RepairNewItemActivity.c(RepairNewItemActivity.this), "该时间段不可选");
          RepairNewItemActivity.d(RepairNewItemActivity.this).setText("选择预约时间");
          return;
        }
        if ((i > 16) && (paramInt1 == 0) && (paramInt2 == 1))
        {
          com.freelxl.baselibrary.f.g.textToast(RepairNewItemActivity.c(RepairNewItemActivity.this), "该时间段不可选");
          RepairNewItemActivity.d(RepairNewItemActivity.this).setText("选择预约时间");
          return;
        }
      }
      RepairNewItemActivity.d(RepairNewItemActivity.this).setText((String)RepairNewItemActivity.e(RepairNewItemActivity.this).get(paramInt1) + " " + paramString);
      RepairNewItemActivity.a(RepairNewItemActivity.this, ((String)RepairNewItemActivity.e(RepairNewItemActivity.this).get(paramInt1)).replaceAll("/", "-"));
      RepairNewItemActivity.a(RepairNewItemActivity.this, paramInt2 + 1);
      if (RepairNewItemActivity.f(RepairNewItemActivity.this) != null)
      {
        o.lockRepairCapacity(RepairNewItemActivity.this, RepairNewItemActivity.g(RepairNewItemActivity.this), m.GetNowDate(), RepairNewItemActivity.f(RepairNewItemActivity.this).getLogin_name_mobile(), RepairNewItemActivity.h(RepairNewItemActivity.this), RepairNewItemActivity.i(RepairNewItemActivity.this), paramInt2 + 1, "", "", "", 1, 1, RepairNewItemActivity.j(RepairNewItemActivity.this));
        RepairNewItemActivity.this.showProgress("");
      }
      RepairNewItemActivity.d(RepairNewItemActivity.this).setTextColor(Color.parseColor("#111111"));
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newrepair/activity/RepairNewItemActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */