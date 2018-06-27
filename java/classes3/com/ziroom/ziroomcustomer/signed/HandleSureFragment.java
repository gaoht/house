package com.ziroom.ziroomcustomer.signed;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.freelxl.baselibrary.f.g;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.MainActivity;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.base.BaseFragment;
import com.ziroom.ziroomcustomer.e.d;
import com.ziroom.ziroomcustomer.e.l;
import com.ziroom.ziroomcustomer.home.MainFragmentActivity;
import com.ziroom.ziroomcustomer.model.Fees;
import com.ziroom.ziroomcustomer.model.GoodList;
import com.ziroom.ziroomcustomer.model.KeyCards;
import com.ziroom.ziroomcustomer.util.ae;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class HandleSureFragment
  extends BaseFragment
  implements View.OnClickListener
{
  private Context a;
  private TextView b;
  private TextView c;
  private TextView d;
  private TextView e;
  private TextView f;
  private Button g;
  private String h;
  private AlertDialog i;
  private ListView j;
  private ListView k;
  private ListView l;
  private b m;
  private a n;
  private c o;
  private List<Fees> p = new ArrayList();
  private List<GoodList> q = new ArrayList();
  private List<KeyCards> r = new ArrayList();
  private Intent s;
  private String t = null;
  private String u = null;
  private String v = null;
  private String w;
  private Handler x = new Handler(new Handler.Callback()
  {
    public boolean handleMessage(Message paramAnonymousMessage)
    {
      l locall = (l)paramAnonymousMessage.obj;
      switch (paramAnonymousMessage.what)
      {
      }
      for (;;)
      {
        return false;
        if (locall.getSuccess().booleanValue())
        {
          HandleSureFragment.a(HandleSureFragment.this, (String)locall.getObject());
          if ((ae.isNull(((MainFragmentActivity)HandleSureFragment.b(HandleSureFragment.this)).e)) && (!"2".equals(((MainFragmentActivity)HandleSureFragment.b(HandleSureFragment.this)).b.get("contractStrategy") + ""))) {
            HandleSureFragment.b(HandleSureFragment.this, HandleSureFragment.c(HandleSureFragment.this));
          }
        }
        for (;;)
        {
          HandleSureFragment.this.dismissProgress();
          break;
          new ApplicationEx().finishAllActivity();
          ((MainFragmentActivity)HandleSureFragment.b(HandleSureFragment.this)).finish();
          continue;
          HandleSureFragment.this.showToast(locall.getMessage());
        }
        if (locall.getSuccess().booleanValue())
        {
          g.textToast(HandleSureFragment.this.getActivity(), HandleSureFragment.this.getString(2131297496), 1);
          HandleSureFragment.a(HandleSureFragment.this, new Intent(HandleSureFragment.b(HandleSureFragment.this), WaitDeliveryActivity.class));
          HandleSureFragment.d(HandleSureFragment.this).putExtra("wuyewaitdone", "wuyewaitdone");
          HandleSureFragment.d(HandleSureFragment.this).putExtra("contract_part_code", HandleSureFragment.c(HandleSureFragment.this));
          HandleSureFragment.this.startActivity(HandleSureFragment.d(HandleSureFragment.this));
          HandleSureFragment.this.getActivity().finish();
        }
        for (;;)
        {
          HandleSureFragment.a(HandleSureFragment.this).dismiss();
          HandleSureFragment.this.dismissProgress();
          break;
          HandleSureFragment.this.showToast(locall.getMessage());
        }
        if (locall.getSuccess().booleanValue()) {
          if (locall.getObject() != null)
          {
            ((MainFragmentActivity)HandleSureFragment.b(HandleSureFragment.this)).b = ((HashMap)locall.getObject());
            HandleSureFragment.a(HandleSureFragment.this, (List)((MainFragmentActivity)HandleSureFragment.b(HandleSureFragment.this)).b.get("feeslist"));
            HandleSureFragment.b(HandleSureFragment.this, (List)((MainFragmentActivity)HandleSureFragment.b(HandleSureFragment.this)).b.get("goodlist"));
            HandleSureFragment.c(HandleSureFragment.this, (List)((MainFragmentActivity)HandleSureFragment.b(HandleSureFragment.this)).b.get("keycardslist"));
          }
        }
        for (;;)
        {
          HandleSureFragment.this.dismissProgress();
          break;
          HandleSureFragment.this.showToast(locall.getMessage());
        }
        HandleSureFragment.this.dismissProgress();
        if (((l)paramAnonymousMessage.obj).getSuccess().booleanValue())
        {
          paramAnonymousMessage = new Intent(HandleSureFragment.this.getActivity().getApplicationContext(), HandleWaitToDoneActivity.class);
          paramAnonymousMessage.putExtra("pay_status", "yzf");
          paramAnonymousMessage.putExtra("contract_part_code", HandleSureFragment.c(HandleSureFragment.this));
          HandleSureFragment.this.startActivity(paramAnonymousMessage);
        }
      }
    }
  });
  
  private void a(Context paramContext, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      View localView = LayoutInflater.from(paramContext).inflate(2130903785, null);
      localObject = (Button)localView.findViewById(2131692249);
      Button localButton = (Button)localView.findViewById(2131690460);
      this.i = new AlertDialog.Builder(paramContext).create();
      this.i.setView(localView, 0, 0, 0, 0);
      paramContext = this.i;
      if (!(paramContext instanceof AlertDialog)) {
        paramContext.show();
      }
      for (;;)
      {
        ((Button)localObject).setOnClickListener(new View.OnClickListener()
        {
          @Instrumented
          public void onClick(View paramAnonymousView)
          {
            VdsAgent.onClick(this, paramAnonymousView);
            HandleSureFragment.a(HandleSureFragment.this, "N", 69673);
          }
        });
        localButton.setOnClickListener(new View.OnClickListener()
        {
          @Instrumented
          public void onClick(View paramAnonymousView)
          {
            VdsAgent.onClick(this, paramAnonymousView);
            HandleSureFragment.a(HandleSureFragment.this).dismiss();
          }
        });
        return;
        VdsAgent.showDialog((AlertDialog)paramContext);
      }
    case 1: 
      localObject = LayoutInflater.from(paramContext).inflate(2130903793, null);
      ((LinearLayout)((View)localObject).findViewById(2131693728)).setVisibility(8);
      this.j = ((ListView)((View)localObject).findViewById(2131693767));
      this.j.setAdapter(this.m);
      a(paramContext, (View)localObject);
      return;
    case 2: 
      localObject = LayoutInflater.from(paramContext).inflate(2130903788, null);
      this.k = ((ListView)((View)localObject).findViewById(2131693730));
      this.k.setAdapter(this.n);
      ((LinearLayout)((View)localObject).findViewById(2131693728)).setVisibility(8);
      a(paramContext, (View)localObject);
      return;
    }
    Object localObject = LayoutInflater.from(paramContext).inflate(2130903810, null);
    ((LinearLayout)((View)localObject).findViewById(2131693728)).setVisibility(8);
    this.l = ((ListView)((View)localObject).findViewById(2131693813));
    this.l.setAdapter(this.o);
    a(paramContext, (View)localObject);
  }
  
  private void a(Context paramContext, View paramView)
  {
    this.i = new AlertDialog.Builder(paramContext).create();
    this.i.setView(paramView, 0, 0, 0, 0);
    paramContext = this.i;
    if (!(paramContext instanceof AlertDialog))
    {
      paramContext.show();
      return;
    }
    VdsAgent.showDialog((AlertDialog)paramContext);
  }
  
  private void a(View paramView)
  {
    this.b = ((TextView)paramView.findViewById(2131692065));
    this.e = ((TextView)paramView.findViewById(2131697247));
    this.d = ((TextView)paramView.findViewById(2131697248));
    this.c = ((TextView)paramView.findViewById(2131697249));
    this.f = ((TextView)paramView.findViewById(2131697622));
    this.g = ((Button)paramView.findViewById(2131697621));
    this.m = new b();
    this.n = new a();
    this.o = new c();
    this.h = ((MainFragmentActivity)this.a).c;
    if (!TextUtils.isEmpty(((MainFragmentActivity)this.a).d))
    {
      Log.e("wuyejiaoge", "*HandleSureFragment--------lease-------- ");
      if (TextUtils.isEmpty(this.h)) {
        break label277;
      }
      d();
    }
    for (;;)
    {
      if (((MainFragmentActivity)this.a).b != null) {}
      try
      {
        this.p = ((List)((MainFragmentActivity)this.a).b.get("feeslist"));
        this.q = ((List)((MainFragmentActivity)this.a).b.get("goodlist"));
        this.r = ((List)((MainFragmentActivity)this.a).b.get("keycardslist"));
        Log.e("wuyejiaoge", "*HandleSureFragment*******contract_code****** ======  " + this.h);
        return;
        label277:
        showToast("获取不到合同编号");
      }
      catch (Exception paramView)
      {
        for (;;)
        {
          Log.e("wuyejiaoge", "HandleSureFragment==initView==TypeException===  " + paramView.getMessage());
          paramView.printStackTrace();
        }
      }
    }
  }
  
  private void a(String paramString, int paramInt)
  {
    if (!TextUtils.isEmpty(this.h))
    {
      d.SundHandleConfirm(this.x, this.h, paramString, paramInt);
      showProgress("");
      return;
    }
    showToast("获取不到合同编号");
  }
  
  private void b(String paramString)
  {
    Intent localIntent = new Intent(getActivity().getApplicationContext(), HandleWaitToDoneActivity.class);
    localIntent.putExtra("pay_status", "yzf");
    localIntent.putExtra("contract_part_code", paramString);
    startActivity(localIntent);
  }
  
  private void c()
  {
    this.b.setOnClickListener(this);
    this.e.setOnClickListener(this);
    this.d.setOnClickListener(this);
    this.c.setOnClickListener(this);
    this.g.setOnClickListener(this);
    this.f.setOnClickListener(this);
  }
  
  private void d()
  {
    d.getSundHandleList(this.x, this.h);
    showProgress("");
  }
  
  @Instrumented
  public void onClick(View paramView)
  {
    VdsAgent.onClick(this, paramView);
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131692065: 
      paramView = new Intent(this.a, MainActivity.class);
      paramView.putExtra("FRAGMENT_TYPE", 7);
      startActivity(paramView);
      return;
    case 2131697247: 
      a(this.a, 1);
      return;
    case 2131697248: 
      a(this.a, 2);
      return;
    case 2131697249: 
      a(this.a, 3);
      return;
    case 2131697621: 
      a("Y", 69672);
      return;
    }
    a(this.a, 0);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = View.inflate(getActivity(), 2130905161, null);
    this.a = getActivity();
    a(paramLayoutInflater);
    c();
    return paramLayoutInflater;
  }
  
  public class a
    extends BaseAdapter
  {
    private a b;
    
    public a() {}
    
    public int getCount()
    {
      return HandleSureFragment.f(HandleSureFragment.this).size();
    }
    
    public Object getItem(int paramInt)
    {
      return HandleSureFragment.f(HandleSureFragment.this).get(paramInt);
    }
    
    public long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      if (paramView == null)
      {
        this.b = new a();
        paramView = View.inflate(HandleSureFragment.this.getActivity(), 2130904195, null);
        this.b.a = ((TextView)paramView.findViewById(2131694982));
        this.b.b = ((TextView)paramView.findViewById(2131694985));
        this.b.c = ((TextView)paramView.findViewById(2131694983));
        this.b.d = ((TextView)paramView.findViewById(2131694984));
        this.b.e = ((TextView)paramView.findViewById(2131694986));
        paramView.setTag(this.b);
        this.b.a.setText(((Fees)HandleSureFragment.f(HandleSureFragment.this).get(paramInt)).getType());
        if (TextUtils.isEmpty(((Fees)HandleSureFragment.f(HandleSureFragment.this).get(paramInt)).getBalance())) {
          break label394;
        }
        this.b.b.setText("卡显示余额" + ((Fees)HandleSureFragment.f(HandleSureFragment.this).get(paramInt)).getBalance());
        label219:
        if (!ae.notNull(((Fees)HandleSureFragment.f(HandleSureFragment.this).get(paramInt)).getPrice_unit())) {
          break label409;
        }
        this.b.c.setText(((Fees)HandleSureFragment.f(HandleSureFragment.this).get(paramInt)).getPrice() + ((Fees)HandleSureFragment.f(HandleSureFragment.this).get(paramInt)).getPrice_unit());
        label308:
        this.b.e.setText(((Fees)HandleSureFragment.f(HandleSureFragment.this).get(paramInt)).getDisplayNums());
        paramViewGroup = ((Fees)HandleSureFragment.f(HandleSureFragment.this).get(paramInt)).getIsAdvancePay();
        if (!"1".equals(paramViewGroup)) {
          break label441;
        }
        this.b.d.setText(2131296815);
      }
      label394:
      label409:
      label441:
      while (!"2".equals(paramViewGroup))
      {
        return paramView;
        this.b = ((a)paramView.getTag());
        break;
        this.b.b.setText("卡显示余额");
        break label219;
        this.b.c.setText(((Fees)HandleSureFragment.f(HandleSureFragment.this).get(paramInt)).getPrice());
        break label308;
      }
      this.b.d.setText(2131296814);
      return paramView;
    }
    
    class a
    {
      TextView a;
      TextView b;
      TextView c;
      TextView d;
      TextView e;
      
      a() {}
    }
  }
  
  public class b
    extends BaseAdapter
  {
    private a b;
    
    public b() {}
    
    public int getCount()
    {
      return HandleSureFragment.e(HandleSureFragment.this).size();
    }
    
    public Object getItem(int paramInt)
    {
      return HandleSureFragment.e(HandleSureFragment.this).get(paramInt);
    }
    
    public long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      if (paramView == null)
      {
        this.b = new a();
        paramView = View.inflate(HandleSureFragment.this.getActivity(), 2130904212, null);
        this.b.a = ((TextView)paramView.findViewById(2131695040));
        this.b.b = ((TextView)paramView.findViewById(2131695041));
        this.b.c = ((TextView)paramView.findViewById(2131695043));
        this.b.d = ((TextView)paramView.findViewById(2131695044));
        this.b.e = ((TextView)paramView.findViewById(2131695045));
        paramView.setTag(this.b);
        this.b.a.setText(((GoodList)HandleSureFragment.e(HandleSureFragment.this).get(paramInt)).getName());
        this.b.b.setText(((GoodList)HandleSureFragment.e(HandleSureFragment.this).get(paramInt)).getSums());
        this.b.c.setText(((GoodList)HandleSureFragment.e(HandleSureFragment.this).get(paramInt)).getBrand());
        this.b.d.setText(((GoodList)HandleSureFragment.e(HandleSureFragment.this).get(paramInt)).getType());
        paramInt = Integer.parseInt(((GoodList)HandleSureFragment.e(HandleSureFragment.this).get(paramInt)).getUse_status());
        if (paramInt != 1) {
          break label290;
        }
        this.b.e.setText(2131297291);
      }
      label290:
      do
      {
        return paramView;
        this.b = ((a)paramView.getTag());
        break;
        if (paramInt == 2)
        {
          this.b.e.setText(2131297024);
          return paramView;
        }
        if (paramInt == 3)
        {
          this.b.e.setText(2131296606);
          return paramView;
        }
      } while (paramInt != 4);
      this.b.e.setText(2131296605);
      return paramView;
    }
    
    class a
    {
      TextView a;
      TextView b;
      TextView c;
      TextView d;
      TextView e;
      
      a() {}
    }
  }
  
  public class c
    extends BaseAdapter
  {
    private a b;
    
    public c() {}
    
    public int getCount()
    {
      return HandleSureFragment.g(HandleSureFragment.this).size();
    }
    
    public Object getItem(int paramInt)
    {
      return HandleSureFragment.g(HandleSureFragment.this).get(paramInt);
    }
    
    public long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      if (paramView == null)
      {
        this.b = new a();
        paramViewGroup = View.inflate(HandleSureFragment.this.getActivity(), 2130904264, null);
        this.b.a = ((TextView)paramViewGroup.findViewById(2131695122));
        this.b.b = ((TextView)paramViewGroup.findViewById(2131695123));
        this.b.c = ((TextView)paramViewGroup.findViewById(2131695124));
        paramViewGroup.setTag(this.b);
        this.b.a.setText(((KeyCards)HandleSureFragment.g(HandleSureFragment.this).get(paramInt)).getName());
        this.b.b.setText(((KeyCards)HandleSureFragment.g(HandleSureFragment.this).get(paramInt)).getNums());
        paramView = ((KeyCards)HandleSureFragment.g(HandleSureFragment.this).get(paramInt)).getState();
        if (!"1".equals(paramView)) {
          break label262;
        }
        paramView = "正常 ";
      }
      for (;;)
      {
        String str = ((KeyCards)HandleSureFragment.g(HandleSureFragment.this).get(paramInt)).getOver();
        if ((TextUtils.isEmpty(str)) || (!"1".equals(str))) {
          break label313;
        }
        this.b.c.setText(paramView + "已交付");
        return paramViewGroup;
        this.b = ((a)paramView.getTag());
        paramViewGroup = paramView;
        break;
        label262:
        if ("2".equals(paramView)) {
          paramView = "丢失 ";
        } else if ("3".equals(paramView)) {
          paramView = "损坏可维修 ";
        } else if ("4".equals(paramView)) {
          paramView = "损坏不可维修 ";
        } else {
          paramView = "";
        }
      }
      label313:
      this.b.c.setText(paramView + "未交付");
      return paramViewGroup;
    }
    
    class a
    {
      TextView a;
      TextView b;
      TextView c;
      
      a() {}
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/signed/HandleSureFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */