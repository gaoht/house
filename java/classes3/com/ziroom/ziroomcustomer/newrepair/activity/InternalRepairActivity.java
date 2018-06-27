package com.ziroom.ziroomcustomer.newrepair.activity;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.AbsListView.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.freelxl.baselibrary.f.g;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.commonlib.utils.SignKeyUtil;
import com.ziroom.commonlibrary.widget.unifiedziroom.c.a;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.e.j;
import com.ziroom.ziroomcustomer.e.l;
import com.ziroom.ziroomcustomer.model.Contract;
import com.ziroom.ziroomcustomer.model.RepairWork;
import com.ziroom.ziroomcustomer.model.RepairWorkItem;
import com.ziroom.ziroomcustomer.model.UserInfo;
import com.ziroom.ziroomcustomer.newrepair.a.c.c;
import com.ziroom.ziroomcustomer.newrepair.b.u;
import com.ziroom.ziroomcustomer.util.ae;
import com.ziroom.ziroomcustomer.util.ah;
import com.ziroom.ziroomcustomer.util.m;
import com.ziroom.ziroomcustomer.util.n;
import com.ziroom.ziroomcustomer.widget.LabeledEditText;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class InternalRepairActivity
  extends BaseActivity
  implements View.OnClickListener, c.c
{
  public static int a = 444;
  private com.ziroom.ziroomcustomer.newrepair.a.c A;
  private List<RepairWork> B = new ArrayList();
  private Dialog C;
  private boolean D;
  private List<RepairWork> E;
  private String F;
  private boolean G = false;
  private Context b;
  private Intent c;
  private UserInfo d;
  private ImageView e;
  private LabeledEditText f;
  private Button g;
  private LabeledEditText r;
  private ListView s;
  private ImageView t;
  private List<Contract> u = new ArrayList();
  private a v;
  private int w;
  private Contract x;
  private String y;
  private TextView z;
  
  private void a()
  {
    this.e.setOnClickListener(this);
    this.g.setOnClickListener(this);
    this.t.setOnClickListener(this);
  }
  
  private void b()
  {
    this.u = ApplicationEx.c.getContracts();
    if ((this.u != null) && (this.u.size() != 0))
    {
      this.f.setText(((Contract)this.u.get(0)).getAddress());
      this.x = ((Contract)this.u.get(0));
      this.y = this.x.getContract_code();
      if ((this.u == null) || (this.u.size() <= 1)) {
        break label334;
      }
      this.f.setOnClickListener(this);
    }
    for (;;)
    {
      this.d = ((ApplicationEx)getApplication()).getUser();
      if (this.d != null) {
        this.r.setText(this.d.getLogin_name_mobile());
      }
      AbsListView.LayoutParams localLayoutParams = new AbsListView.LayoutParams(-1, -2);
      this.z = new TextView(this.b);
      this.z.setText("增加报修项");
      this.z.setTextColor(getResources().getColor(2131624046));
      this.z.setGravity(17);
      this.z.setPadding(0, n.dip2px(this.b, 24.0F), 0, n.dip2px(this.b, 24.0F));
      this.z.setTextSize(14.0F);
      this.z.setLayoutParams(localLayoutParams);
      this.s.addFooterView(this.z, null, true);
      this.z.setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          if ("增加报修项".equals(InternalRepairActivity.a(InternalRepairActivity.this).getText()))
          {
            if (InternalRepairActivity.b(InternalRepairActivity.this).getData().size() >= 5)
            {
              g.textToast(InternalRepairActivity.c(InternalRepairActivity.this), "维修项添加请勿超过五项");
              return;
            }
            InternalRepairActivity.b(InternalRepairActivity.this).addData();
            InternalRepairActivity.a(InternalRepairActivity.this).setText("取消添加");
          }
          for (;;)
          {
            InternalRepairActivity.d(InternalRepairActivity.this).setSelection(InternalRepairActivity.b(InternalRepairActivity.this).getCount() - 1);
            return;
            if (InternalRepairActivity.b(InternalRepairActivity.this).getData().size() >= 2)
            {
              InternalRepairActivity.b(InternalRepairActivity.this).cancelData();
              InternalRepairActivity.a(InternalRepairActivity.this).setText("增加报修项");
            }
          }
        }
      });
      this.z.setClickable(false);
      this.A = new com.ziroom.ziroomcustomer.newrepair.a.c(this, this.y);
      this.A.setOnRepairTypeListener(this);
      this.A.setOnDataChangeListener(new com.ziroom.ziroomcustomer.newrepair.a.c.b()
      {
        public void onDataChange(boolean paramAnonymousBoolean1, boolean paramAnonymousBoolean2)
        {
          InternalRepairActivity.a(InternalRepairActivity.this, paramAnonymousBoolean1);
          if (InternalRepairActivity.e(InternalRepairActivity.this))
          {
            InternalRepairActivity.f(InternalRepairActivity.this).setBackgroundColor(InternalRepairActivity.this.getResources().getColor(2131624516));
            InternalRepairActivity.f(InternalRepairActivity.this).setClickable(true);
          }
          while (!paramAnonymousBoolean2)
          {
            InternalRepairActivity.a(InternalRepairActivity.this).setText("取消添加");
            InternalRepairActivity.a(InternalRepairActivity.this).setTextColor(InternalRepairActivity.this.getResources().getColor(2131624097));
            InternalRepairActivity.a(InternalRepairActivity.this).setClickable(true);
            return;
            InternalRepairActivity.f(InternalRepairActivity.this).setBackgroundColor(InternalRepairActivity.this.getResources().getColor(2131624046));
            InternalRepairActivity.f(InternalRepairActivity.this).setClickable(false);
          }
          InternalRepairActivity.a(InternalRepairActivity.this).setText("增加报修项");
          if ((InternalRepairActivity.b(InternalRepairActivity.this).getData().size() == 1) && (!InternalRepairActivity.e(InternalRepairActivity.this)))
          {
            InternalRepairActivity.a(InternalRepairActivity.this).setTextColor(InternalRepairActivity.this.getResources().getColor(2131624046));
            InternalRepairActivity.a(InternalRepairActivity.this).setClickable(false);
            return;
          }
          InternalRepairActivity.a(InternalRepairActivity.this).setTextColor(InternalRepairActivity.this.getResources().getColor(2131624097));
          InternalRepairActivity.a(InternalRepairActivity.this).setClickable(true);
        }
      });
      this.s.setAdapter(this.A);
      return;
      label334:
      this.f.getmImgRight().setVisibility(4);
    }
  }
  
  private void e()
  {
    this.e = ((ImageView)findViewById(2131690048));
    this.t = ((ImageView)findViewById(2131689492));
    this.f = ((LabeledEditText)findViewById(2131689981));
    this.r = ((LabeledEditText)findViewById(2131689983));
    this.s = ((ListView)findViewById(2131690998));
    this.g = ((Button)findViewById(2131690996));
  }
  
  private void f()
  {
    this.C = new Dialog(this.b, 2131427591);
    this.C.setContentView(2130903807);
    this.C.setCanceledOnTouchOutside(true);
    Object localObject = this.C.getWindow().getAttributes();
    ((WindowManager.LayoutParams)localObject).gravity = 17;
    this.C.getWindow().setAttributes((WindowManager.LayoutParams)localObject);
    ((TextView)this.C.findViewById(2131693806)).setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        InternalRepairActivity.g(InternalRepairActivity.this).dismiss();
        InternalRepairActivity.a(InternalRepairActivity.this, null);
      }
    });
    localObject = this.C;
    if (!(localObject instanceof Dialog))
    {
      ((Dialog)localObject).show();
      return;
    }
    VdsAgent.showDialog((Dialog)localObject);
  }
  
  private void g()
  {
    if (!this.D)
    {
      this.g.setClickable(true);
      return;
    }
    this.F = this.r.getText().toString();
    if ((ae.isNull(this.F)) || (!ah.isMobile(this.F)))
    {
      g.textToast(this.b, "请填写正确的电话号码");
      this.g.setClickable(true);
      return;
    }
    this.B = this.A.getData();
    int i = 0;
    for (;;)
    {
      if (i < this.E.size())
      {
        String str = ((RepairWorkItem)((RepairWork)this.E.get(i)).getWxxmList().get(0)).getZhutiId();
        if ((str.equals("2c9085f4338ddc420133907f9a770214")) || (str.equals("2c9085f73f5c1a0a013f7585e75557be"))) {
          this.G = true;
        }
      }
      else
      {
        if (!this.G) {
          break;
        }
        com.ziroom.commonlibrary.widget.unifiedziroom.c.newBuilder(this.b).setTitle("提示").setContent("人为原因导致的物品损坏，我们会向您收取相应的维修费用。如：杂物掉入导致马桶堵塞、钥匙断在锁眼等。\n是否继续预约？").setOnConfirmClickListener(new com.ziroom.commonlibrary.widget.unifiedziroom.c.b()
        {
          public void onClick(View paramAnonymousView, boolean paramAnonymousBoolean)
          {
            if (paramAnonymousBoolean) {
              InternalRepairActivity.h(InternalRepairActivity.this);
            }
          }
        }).build().show();
        return;
      }
      this.G = false;
      i += 1;
    }
    h();
  }
  
  private void h()
  {
    if ((this.d != null) && (this.x != null))
    {
      Object localObject1 = this.d.getLogin_name_mobile();
      Object localObject2 = m.GetNowDate();
      HashMap localHashMap = new HashMap();
      localHashMap.put("signDate", localObject2);
      localHashMap.put("loginPhone", localObject1);
      localHashMap.put("uid", this.d.getUid());
      localHashMap.put("appVersionStr", ah.getVersion(ApplicationEx.c));
      localHashMap.put("result", ah.toMd5((SignKeyUtil.getSignKey() + (String)localObject1 + (String)localObject2).getBytes()));
      localHashMap.put("contactName", this.d.getUser_name());
      localHashMap.put("contactTel", this.F);
      localHashMap.put("rentContractCode", this.y);
      localHashMap.put("address", ((Contract)this.u.get(this.w)).getAddress());
      localHashMap.put("isConfirm", Integer.valueOf(1));
      localHashMap.put("dataSource", Integer.valueOf(12));
      localHashMap.put("city_code", com.ziroom.ziroomcustomer.base.b.d);
      Iterator localIterator1 = this.B.iterator();
      while (localIterator1.hasNext())
      {
        localObject1 = (RepairWork)localIterator1.next();
        ((RepairWork)localObject1).setSupEmpId(((RepairWork)localObject1).getLockSupEmpId());
        ((RepairWork)localObject1).setSupplierId(((RepairWork)localObject1).getLockSupplierId());
        Iterator localIterator2 = ((RepairWork)localObject1).getWxxmList().iterator();
        while (localIterator2.hasNext())
        {
          RepairWorkItem localRepairWorkItem = (RepairWorkItem)localIterator2.next();
          if ((ae.isNull(localRepairWorkItem.getPic())) && (localRepairWorkItem.getUrl() != null))
          {
            localObject2 = "";
            int i = 0;
            if (i < localRepairWorkItem.getUrl().length)
            {
              localObject1 = localObject2;
              if (ae.notNull(localRepairWorkItem.getUrl()[i])) {
                if (!ae.isNull((String)localObject2)) {
                  break label413;
                }
              }
              label413:
              for (localObject1 = localRepairWorkItem.getUrl()[i];; localObject1 = (String)localObject2 + "," + localRepairWorkItem.getUrl()[i])
              {
                i += 1;
                localObject2 = localObject1;
                break;
              }
            }
            localRepairWorkItem.setPic((String)localObject2);
            localRepairWorkItem.setImage(null);
            localRepairWorkItem.setUrl(null);
          }
        }
      }
      localHashMap.put("workBillList", com.alibaba.fastjson.a.toJSON(this.B));
      localObject1 = new HashMap();
      ((Map)localObject1).put("json", com.alibaba.fastjson.a.toJSONString(localHashMap));
      j.makeInternalRepairOrder(this.b, (Map)localObject1, new b(new com.ziroom.ziroomcustomer.newrepair.utils.b(u.class)));
      showProgressNoCancel("", 30000L);
      return;
    }
    g.textToast(this.b, "登录状态异常，请重新登录");
    this.g.setClickable(true);
  }
  
  private void i()
  {
    this.C = new Dialog(this, 2131427692);
    Object localObject1 = getLayoutInflater().inflate(2130903838, null);
    Object localObject2 = (ListView)((View)localObject1).findViewById(2131693805);
    Object localObject3 = (TextView)((View)localObject1).findViewById(2131691288);
    this.v = new a();
    ((ListView)localObject2).setAdapter(this.v);
    ((TextView)localObject3).setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        InternalRepairActivity.g(InternalRepairActivity.this).dismiss();
      }
    });
    this.C.setCanceledOnTouchOutside(true);
    localObject2 = this.C.getWindow();
    ((Window)localObject2).getDecorView().setPadding(0, 0, 0, 0);
    localObject3 = ((Window)localObject2).getAttributes();
    ((WindowManager.LayoutParams)localObject3).width = -1;
    ((WindowManager.LayoutParams)localObject3).height = -2;
    ((Window)localObject2).setAttributes((WindowManager.LayoutParams)localObject3);
    ((Window)localObject2).setGravity(80);
    this.C.setContentView((View)localObject1);
    localObject1 = this.C;
    if (!(localObject1 instanceof Dialog))
    {
      ((Dialog)localObject1).show();
      return;
    }
    VdsAgent.showDialog((Dialog)localObject1);
  }
  
  private void j()
  {
    com.ziroom.commonlibrary.widget.unifiedziroom.c.newBuilder(this).setTitle("退出提示").setContent("您确定不报修就退出么？").setOnConfirmClickListener(new com.ziroom.commonlibrary.widget.unifiedziroom.c.b()
    {
      public void onClick(View paramAnonymousView, boolean paramAnonymousBoolean)
      {
        if (paramAnonymousBoolean) {
          InternalRepairActivity.this.finish();
        }
      }
    }).build().show();
  }
  
  public void getRepairTypeListData(List<RepairWork> paramList)
  {
    this.E = paramList;
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt1 == a) && (paramInt2 == -1)) {
      this.A.setRemarkData(paramIntent);
    }
  }
  
  @Instrumented
  public void onClick(View paramView)
  {
    VdsAgent.onClick(this, paramView);
    switch (paramView.getId())
    {
    default: 
    case 2131690048: 
    case 2131689981: 
      do
      {
        return;
        f();
        return;
      } while (this.u.size() <= 1);
      i();
      return;
    case 2131690996: 
      g();
      return;
    }
    j();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903225);
    this.b = this;
    e();
    a();
    b();
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      j();
      return true;
    }
    return super.onKeyUp(paramInt, paramKeyEvent);
  }
  
  public class a
    extends BaseAdapter
  {
    public a() {}
    
    public int getCount()
    {
      return InternalRepairActivity.k(InternalRepairActivity.this).size();
    }
    
    public Object getItem(int paramInt)
    {
      return null;
    }
    
    public long getItemId(int paramInt)
    {
      return 0L;
    }
    
    public View getView(final int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      if (paramView == null)
      {
        paramView = View.inflate(InternalRepairActivity.this, 2130904470, null);
        paramViewGroup = new a();
        paramViewGroup.a = ((TextView)paramView.findViewById(2131693248));
        paramView.setTag(paramViewGroup);
      }
      for (;;)
      {
        paramViewGroup.a.setText(((Contract)InternalRepairActivity.k(InternalRepairActivity.this).get(paramInt)).getAddress());
        paramViewGroup.a.setOnClickListener(new View.OnClickListener()
        {
          @Instrumented
          public void onClick(View paramAnonymousView)
          {
            VdsAgent.onClick(this, paramAnonymousView);
            InternalRepairActivity.a(InternalRepairActivity.this, paramInt);
            InternalRepairActivity.a.this.notifyDataSetChanged();
            InternalRepairActivity.l(InternalRepairActivity.this).setText(((Contract)InternalRepairActivity.k(InternalRepairActivity.this).get(paramInt)).getAddress());
            InternalRepairActivity.a(InternalRepairActivity.this, (Contract)InternalRepairActivity.k(InternalRepairActivity.this).get(paramInt));
            InternalRepairActivity.a(InternalRepairActivity.this, InternalRepairActivity.m(InternalRepairActivity.this).getContract_code());
            InternalRepairActivity.f(InternalRepairActivity.this).setBackgroundColor(InternalRepairActivity.this.getResources().getColor(2131624046));
            InternalRepairActivity.b(InternalRepairActivity.this).reSetData(InternalRepairActivity.n(InternalRepairActivity.this));
            InternalRepairActivity.g(InternalRepairActivity.this).dismiss();
          }
        });
        if (InternalRepairActivity.j(InternalRepairActivity.this) != paramInt) {
          break;
        }
        paramViewGroup.a.setTextColor(-695296);
        return paramView;
        paramViewGroup = (a)paramView.getTag();
      }
      paramViewGroup.a.setTextColor(-15658735);
      return paramView;
    }
    
    public class a
    {
      public TextView a;
      
      public a() {}
    }
  }
  
  class b
    extends com.freelxl.baselibrary.d.c.a<l>
  {
    public b(com.freelxl.baselibrary.d.f.a parama)
    {
      super();
    }
    
    public void onFailure(Throwable paramThrowable)
    {
      com.ziroom.ziroomcustomer.newrepair.utils.c.catchExp(paramThrowable);
      g.textToast(InternalRepairActivity.c(InternalRepairActivity.this), "提交订单失败，请稍后重试!");
      InternalRepairActivity.f(InternalRepairActivity.this).setClickable(true);
      InternalRepairActivity.this.dismissProgress();
    }
    
    public void onSuccess(int paramInt, l paraml)
    {
      InternalRepairActivity.this.dismissProgress();
      if (paraml.getSuccess().booleanValue())
      {
        g.textToast(InternalRepairActivity.c(InternalRepairActivity.this), "您已成功预约维修!");
        InternalRepairActivity.a(InternalRepairActivity.this, new Intent(InternalRepairActivity.this, RepairSubmitSuccessActivity.class));
        InternalRepairActivity.i(InternalRepairActivity.this).putExtra("RepairList", "repairItemList");
        paraml = (u)paraml.getObject();
        InternalRepairActivity.i(InternalRepairActivity.this).putExtra("repariInfo", paraml);
        paraml = new Bundle();
        paraml.putInt("query_index_contract", InternalRepairActivity.j(InternalRepairActivity.this));
        InternalRepairActivity.i(InternalRepairActivity.this).putExtras(paraml);
        InternalRepairActivity.this.startActivity(InternalRepairActivity.i(InternalRepairActivity.this));
        InternalRepairActivity.f(InternalRepairActivity.this).setClickable(true);
        InternalRepairActivity.this.finish();
        return;
      }
      InternalRepairActivity.f(InternalRepairActivity.this).setClickable(true);
      paraml = paraml.getMessage();
      InternalRepairActivity.this.showToast(paraml);
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newrepair/activity/InternalRepairActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */