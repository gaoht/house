package com.ziroom.ziroomcustomer.newrepair.a;

import android.content.Intent;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.dialog.g;
import com.ziroom.ziroomcustomer.dialog.g.a;
import com.ziroom.ziroomcustomer.e.j;
import com.ziroom.ziroomcustomer.e.l;
import com.ziroom.ziroomcustomer.model.RepairWork;
import com.ziroom.ziroomcustomer.model.RepairWorkItem;
import com.ziroom.ziroomcustomer.model.UserInfo;
import com.ziroom.ziroomcustomer.newServiceList.model.LabelMo;
import com.ziroom.ziroomcustomer.newrepair.activity.InternalRepairActivity;
import com.ziroom.ziroomcustomer.newrepair.activity.SpecialNeedActivity;
import com.ziroom.ziroomcustomer.newrepair.b.p;
import com.ziroom.ziroomcustomer.newrepair.b.r;
import com.ziroom.ziroomcustomer.newrepair.b.v;
import com.ziroom.ziroomcustomer.newrepair.b.v.a;
import com.ziroom.ziroomcustomer.newrepair.b.w;
import com.ziroom.ziroomcustomer.newrepair.dialog.a.a;
import com.ziroom.ziroomcustomer.newrepair.utils.b;
import com.ziroom.ziroomcustomer.widget.LabeledEditText;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class c
  extends BaseAdapter
{
  private UserInfo a;
  private BaseActivity b;
  private String c;
  private b d;
  private ArrayList<RepairWork> e = new ArrayList();
  private List<r> f = new ArrayList();
  private List<String> g = new ArrayList();
  private List<w> h;
  private List<String> i = new ArrayList();
  private List<p> j;
  private List<String> k = new ArrayList();
  private ArrayList<LabelMo> l = new ArrayList();
  private List<String> m;
  private List<String> n = new ArrayList();
  private List<List<String>> o = new ArrayList();
  private c p;
  
  public c(BaseActivity paramBaseActivity, String paramString)
  {
    this.b = paramBaseActivity;
    this.a = ApplicationEx.c.getUser();
    this.c = paramString;
    paramBaseActivity = new RepairWork();
    paramString = new ArrayList();
    paramString.add(new RepairWorkItem());
    paramBaseActivity.setWxxmList(paramString);
    this.e.add(paramBaseActivity);
    a(null, 0);
  }
  
  private void a(k paramk, int paramInt)
  {
    this.b.showProgressNoCancel("", 30000L);
    j.getRepairPlace(this.b, this.c, new f(paramk, paramInt, new com.ziroom.ziroomcustomer.newrepair.utils.a(r.class, false)));
  }
  
  private void b(k paramk, int paramInt)
  {
    if ((this.f == null) || (this.f.size() == 0))
    {
      this.b.showToast("正在获取维修区域，请稍后");
      paramk.e.setClickable(false);
      a(paramk, paramInt);
      return;
    }
    c(paramk, paramInt);
  }
  
  private void c(k paramk, int paramInt)
  {
    if ((this.g != null) && (this.g.size() != 0))
    {
      paramk = new g(this.b, new d(paramk, paramInt), null, this.g);
      paramk.setCanceledOnTouchOutside(true);
      Window localWindow = paramk.getWindow();
      localWindow.getDecorView().setPadding(0, 0, 0, 0);
      WindowManager.LayoutParams localLayoutParams = localWindow.getAttributes();
      localLayoutParams.width = -1;
      localLayoutParams.height = -2;
      localWindow.setAttributes(localLayoutParams);
      localWindow.setGravity(80);
      paramk.show();
      paramk.getTv_choose().setText("报修区域");
    }
  }
  
  private void d(k paramk, int paramInt)
  {
    String str = ((RepairWorkItem)((RepairWork)this.e.get(paramInt)).getWxxmList().get(0)).getKongJianId();
    if (TextUtils.isEmpty(str))
    {
      this.b.showToast("请选择报修区域");
      return;
    }
    paramk.f.setClickable(false);
    j.getRepairType(this.b, str, new h(paramk, paramInt, new com.ziroom.ziroomcustomer.newrepair.utils.a(w.class, false)));
    this.b.showProgressNoCancel("", 30000L);
  }
  
  private void e(k paramk, int paramInt)
  {
    if ((this.i != null) && (this.i.size() != 0))
    {
      paramk = new g(this.b, new j(paramk, paramInt), null, this.i);
      paramk.setCanceledOnTouchOutside(true);
      Window localWindow = paramk.getWindow();
      localWindow.getDecorView().setPadding(0, 0, 0, 0);
      WindowManager.LayoutParams localLayoutParams = localWindow.getAttributes();
      localLayoutParams.width = -1;
      localLayoutParams.height = -2;
      localWindow.setAttributes(localLayoutParams);
      localWindow.setGravity(80);
      paramk.show();
      paramk.getTv_choose().setText("维修类型");
    }
  }
  
  private void f(k paramk, int paramInt)
  {
    String str1 = ((RepairWorkItem)((RepairWork)this.e.get(paramInt)).getWxxmList().get(0)).getKongJianId();
    String str2 = ((RepairWorkItem)((RepairWork)this.e.get(paramInt)).getWxxmList().get(0)).getZhutiId();
    if (TextUtils.isEmpty(str2))
    {
      this.b.showToast("请选择维修类型");
      return;
    }
    paramk.g.setClickable(false);
    j.getRepairArticle(this.b, str1, str2, new e(paramk, paramInt, new com.ziroom.ziroomcustomer.newrepair.utils.a(p.class, false)));
    this.b.showProgressNoCancel("", 30000L);
  }
  
  private void g(k paramk, int paramInt)
  {
    if ((this.k != null) && (this.k.size() != 0))
    {
      paramk = new g(this.b, new a(paramk, paramInt), null, this.k);
      paramk.setCanceledOnTouchOutside(true);
      Window localWindow = paramk.getWindow();
      localWindow.getDecorView().setPadding(0, 0, 0, 0);
      WindowManager.LayoutParams localLayoutParams = localWindow.getAttributes();
      localLayoutParams.width = -1;
      localLayoutParams.height = -2;
      localWindow.setAttributes(localLayoutParams);
      localWindow.setGravity(80);
      paramk.show();
      paramk.getTv_choose().setText("维修项目");
    }
  }
  
  private void h(k paramk, int paramInt)
  {
    String str = ((RepairWorkItem)((RepairWork)this.e.get(paramInt)).getWxxmList().get(0)).getOjectId();
    if (TextUtils.isEmpty(str))
    {
      this.b.showToast("请选择维修项目");
      return;
    }
    paramk.h.setClickable(false);
    j.getRepairRemark(this.b, str, new i(paramk, paramInt, new com.ziroom.ziroomcustomer.newrepair.utils.a(LabelMo.class, false, "list")));
    this.b.showProgressNoCancel("", 30000L);
  }
  
  private void i(k paramk, int paramInt)
  {
    String str = ((RepairWorkItem)((RepairWork)this.e.get(paramInt)).getWxxmList().get(0)).getZhutiId();
    if (TextUtils.isEmpty(((RepairWorkItem)((RepairWork)this.e.get(paramInt)).getWxxmList().get(0)).getOjectId()))
    {
      this.b.showToast("请选择维修项目");
      return;
    }
    paramk.d.setClickable(false);
    j.getRepairTime(this.b, str, new g(paramk, paramInt, new b(v.class)));
    this.b.showProgressNoCancel("", 30000L);
  }
  
  private void j(k paramk, int paramInt)
  {
    com.ziroom.ziroomcustomer.newrepair.dialog.a locala = new com.ziroom.ziroomcustomer.newrepair.dialog.a(this.b, new m(paramk, paramInt), this.n, this.o);
    locala.setCanceledOnTouchOutside(true);
    Window localWindow = locala.getWindow();
    localWindow.getDecorView().setPadding(0, 0, 0, 0);
    WindowManager.LayoutParams localLayoutParams = localWindow.getAttributes();
    localLayoutParams.width = -1;
    localLayoutParams.height = -2;
    localWindow.setAttributes(localLayoutParams);
    localWindow.setGravity(80);
    locala.show();
    paramk.d.setClickable(true);
    locala.getTv_choose().setText("上门时间");
  }
  
  public void addData()
  {
    RepairWork localRepairWork = new RepairWork();
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new RepairWorkItem());
    localRepairWork.setWxxmList(localArrayList);
    this.e.add(localRepairWork);
    notifyDataSetChanged();
  }
  
  public void cancelData()
  {
    if (this.e.size() > 1)
    {
      this.e.remove(this.e.size() - 1);
      notifyDataSetChanged();
    }
  }
  
  public void checkAllData()
  {
    boolean bool2 = true;
    boolean bool3 = false;
    int i1 = 0;
    boolean bool1 = true;
    for (;;)
    {
      if (i1 < this.e.size())
      {
        if (!((RepairWork)this.e.get(i1)).isDone())
        {
          if (i1 != this.e.size() - 1) {
            bool1 = false;
          }
        }
        else
        {
          i1 += 1;
          continue;
        }
        bool1 = bool3;
        if (this.e.size() > 1)
        {
          bool2 = false;
          bool1 = bool3;
        }
      }
    }
    for (;;)
    {
      this.d.onDataChange(bool1, bool2);
      return;
    }
  }
  
  public boolean checkData(int paramInt)
  {
    boolean bool1 = true;
    RepairWork localRepairWork = (RepairWork)this.e.get(paramInt);
    RepairWorkItem localRepairWorkItem = (RepairWorkItem)localRepairWork.getWxxmList().get(0);
    if (TextUtils.isEmpty(localRepairWorkItem.getOject())) {
      bool1 = false;
    }
    boolean bool2 = bool1;
    if (bool1)
    {
      bool2 = bool1;
      if (TextUtils.isEmpty(localRepairWork.getOrderTime())) {
        bool2 = false;
      }
    }
    if ((bool2) && (TextUtils.isEmpty(localRepairWorkItem.getDetailDescription())) && ((localRepairWorkItem.getLableCode() == null) || (localRepairWorkItem.getLableCode().size() == 0))) {}
    for (bool1 = false;; bool1 = bool2)
    {
      localRepairWork.setDone(bool1);
      checkAllData();
      notifyDataSetChanged();
      return bool1;
    }
  }
  
  public int getCount()
  {
    return this.e.size();
  }
  
  public ArrayList<RepairWork> getData()
  {
    return this.e;
  }
  
  public Object getItem(int paramInt)
  {
    return this.e.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(final int paramInt, View paramView, final ViewGroup paramViewGroup)
  {
    View localView;
    label320:
    label406:
    Object localObject;
    if (paramView == null)
    {
      localView = LayoutInflater.from(this.b).inflate(2130904249, null);
      paramViewGroup = new k(null);
      paramViewGroup.a = ((RelativeLayout)localView.findViewById(2131695101));
      paramViewGroup.b = ((TextView)localView.findViewById(2131689541));
      paramViewGroup.c = ((TextView)localView.findViewById(2131691888));
      paramViewGroup.d = ((LabeledEditText)localView.findViewById(2131692192));
      paramViewGroup.e = ((LabeledEditText)localView.findViewById(2131695102));
      paramViewGroup.f = ((LabeledEditText)localView.findViewById(2131695103));
      paramViewGroup.g = ((LabeledEditText)localView.findViewById(2131695104));
      paramViewGroup.h = ((LabeledEditText)localView.findViewById(2131695105));
      localView.setTag(paramViewGroup);
      checkData(paramInt);
      if ((1 >= this.e.size()) || (paramInt >= this.e.size() - 1)) {
        break label776;
      }
      paramViewGroup.a.setVisibility(0);
      paramViewGroup.b.setText(((RepairWorkItem)((RepairWork)this.e.get(paramInt)).getWxxmList().get(0)).getKongJian() + "·" + ((RepairWorkItem)((RepairWork)this.e.get(paramInt)).getWxxmList().get(0)).getZhuti() + ((RepairWorkItem)((RepairWork)this.e.get(paramInt)).getWxxmList().get(0)).getOject());
      paramViewGroup.c.setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          c.this.showDeleteDialog(paramViewGroup, paramInt);
        }
      });
      if (TextUtils.isEmpty(((RepairWork)this.e.get(paramInt)).getOrderTime())) {
        break label976;
      }
      paramViewGroup.d.setText(((RepairWork)this.e.get(paramInt)).getOrderTime().replaceAll("-", "/") + " " + ((RepairWork)this.e.get(paramInt)).getOrderTimeInterval());
      paramViewGroup.e.setText(((RepairWorkItem)((RepairWork)this.e.get(paramInt)).getWxxmList().get(0)).getKongJian());
      paramViewGroup.f.setText(((RepairWorkItem)((RepairWork)this.e.get(paramInt)).getWxxmList().get(0)).getZhuti());
      paramViewGroup.g.setText(((RepairWorkItem)((RepairWork)this.e.get(paramInt)).getWxxmList().get(0)).getOject());
      localObject = ((RepairWorkItem)((RepairWork)this.e.get(paramInt)).getWxxmList().get(0)).getPic();
      String str = ((RepairWorkItem)((RepairWork)this.e.get(paramInt)).getWxxmList().get(0)).getDetailDescription();
      if (TextUtils.isEmpty((String)localObject + str)) {
        break label1020;
      }
      paramView = "";
      if ((TextUtils.isEmpty((CharSequence)localObject)) || (TextUtils.isEmpty(str))) {
        break label988;
      }
      paramView = "" + (String)localObject + ",";
      label633:
      localObject = paramView;
      if (!TextUtils.isEmpty(str)) {
        localObject = paramView + str;
      }
      paramViewGroup.h.setText((String)localObject);
    }
    for (;;)
    {
      paramViewGroup.e.setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          c.a(c.this, paramViewGroup, paramInt);
        }
      });
      paramViewGroup.f.setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          c.b(c.this, paramViewGroup, paramInt);
        }
      });
      paramViewGroup.g.setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          c.c(c.this, paramViewGroup, paramInt);
        }
      });
      paramViewGroup.d.setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          c.d(c.this, paramViewGroup, paramInt);
        }
      });
      paramViewGroup.h.setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          c.e(c.this, paramViewGroup, paramInt);
        }
      });
      return localView;
      paramViewGroup = (k)paramView.getTag();
      localView = paramView;
      break;
      label776:
      if ((1 < this.e.size()) && (paramInt == this.e.size() - 1) && (((RepairWork)this.e.get(paramInt)).isDone()))
      {
        paramViewGroup.a.setVisibility(0);
        paramViewGroup.b.setText(((RepairWorkItem)((RepairWork)this.e.get(paramInt)).getWxxmList().get(0)).getKongJian() + "·" + ((RepairWorkItem)((RepairWork)this.e.get(paramInt)).getWxxmList().get(0)).getZhuti() + ((RepairWorkItem)((RepairWork)this.e.get(paramInt)).getWxxmList().get(0)).getOject());
        paramViewGroup.c.setOnClickListener(new View.OnClickListener()
        {
          @Instrumented
          public void onClick(View paramAnonymousView)
          {
            VdsAgent.onClick(this, paramAnonymousView);
            c.this.showDeleteDialog(paramViewGroup, paramInt);
          }
        });
        break label320;
      }
      paramViewGroup.a.setVisibility(8);
      paramViewGroup.b.setText("");
      break label320;
      label976:
      paramViewGroup.d.setText("");
      break label406;
      label988:
      if (TextUtils.isEmpty((CharSequence)localObject)) {
        break label633;
      }
      paramView = "" + (String)localObject;
      break label633;
      label1020:
      paramViewGroup.h.setText("");
    }
  }
  
  public void reSetData(String paramString)
  {
    this.c = paramString;
    this.e.clear();
    paramString = new RepairWork();
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new RepairWorkItem());
    paramString.setWxxmList(localArrayList);
    this.e.add(paramString);
    notifyDataSetChanged();
  }
  
  public void setOnDataChangeListener(b paramb)
  {
    this.d = paramb;
  }
  
  public void setOnRepairTypeListener(c paramc)
  {
    this.p = paramc;
  }
  
  public void setRemarkData(Intent paramIntent)
  {
    int i1 = paramIntent.getIntExtra("position", -1);
    String str1 = paramIntent.getStringExtra("TagStr");
    String str2 = paramIntent.getStringExtra("Remark");
    paramIntent = paramIntent.getParcelableArrayListExtra("TagList");
    ((RepairWorkItem)((RepairWork)this.e.get(i1)).getWxxmList().get(0)).setDetailDescription(str2);
    ((RepairWorkItem)((RepairWork)this.e.get(i1)).getWxxmList().get(0)).setLableCode(paramIntent);
    ((RepairWorkItem)((RepairWork)this.e.get(i1)).getWxxmList().get(0)).setPic(str1);
    notifyDataSetChanged();
  }
  
  public void showDeleteDialog(final k paramk, final int paramInt)
  {
    com.ziroom.commonlibrary.widget.unifiedziroom.c.newBuilder(this.b).setTitle("提示").setContent("确定删除该报修项？").setOnConfirmClickListener(new com.ziroom.commonlibrary.widget.unifiedziroom.c.b()
    {
      public void onClick(View paramAnonymousView, boolean paramAnonymousBoolean)
      {
        if (paramAnonymousBoolean) {
          new c.l(c.this, paramk, paramInt).itemDelete();
        }
      }
    }).build().show();
  }
  
  class a
    implements g.a
  {
    c.k a;
    int b;
    
    public a(c.k paramk, int paramInt)
    {
      this.a = paramk;
      this.b = paramInt;
    }
    
    public void showHour(String paramString, int paramInt)
    {
      if ((c.l(c.this) != null) && (c.l(c.this).size() != 0))
      {
        paramString = (String)c.l(c.this).get(paramInt);
        if (!paramString.equals(((RepairWorkItem)((RepairWork)c.c(c.this).get(this.b)).getWxxmList().get(0)).getOject()))
        {
          this.a.g.setText(paramString);
          this.a.d.setText("");
          this.a.h.setText("");
          ((RepairWorkItem)((RepairWork)c.c(c.this).get(this.b)).getWxxmList().get(0)).setOjectId(((p)c.k(c.this).get(paramInt)).getCode());
          ((RepairWorkItem)((RepairWork)c.c(c.this).get(this.b)).getWxxmList().get(0)).setOject(paramString);
          ((RepairWorkItem)((RepairWork)c.c(c.this).get(this.b)).getWxxmList().get(0)).setCue(((p)c.k(c.this).get(paramInt)).getCue());
          ((RepairWork)c.c(c.this).get(this.b)).setQuery_object_index(paramInt);
          ((RepairWorkItem)((RepairWork)c.c(c.this).get(this.b)).getWxxmList().get(0)).setDetailDescription("");
          ((RepairWorkItem)((RepairWork)c.c(c.this).get(this.b)).getWxxmList().get(0)).setLableCode(null);
          ((RepairWorkItem)((RepairWork)c.c(c.this).get(this.b)).getWxxmList().get(0)).setPic("");
          ((RepairWork)c.c(c.this).get(this.b)).setOrderTime("");
          ((RepairWorkItem)((RepairWork)c.c(c.this).get(this.b)).getWxxmList().get(0)).setWxgzId("");
          ((RepairWorkItem)((RepairWork)c.c(c.this).get(this.b)).getWxxmList().get(0)).setWxgz("");
          ((RepairWork)c.c(c.this).get(this.b)).setQuery_reason_index(-1);
          c.this.checkData(this.b);
        }
      }
    }
  }
  
  public static abstract interface b
  {
    public abstract void onDataChange(boolean paramBoolean1, boolean paramBoolean2);
  }
  
  public static abstract interface c
  {
    public abstract void getRepairTypeListData(List<RepairWork> paramList);
  }
  
  class d
    implements g.a
  {
    c.k a;
    int b;
    
    public d(c.k paramk, int paramInt)
    {
      this.a = paramk;
      this.b = paramInt;
    }
    
    public void showHour(String paramString, int paramInt)
    {
      if ((c.e(c.this) != null) && (c.e(c.this).size() != 0))
      {
        paramString = (String)c.e(c.this).get(paramInt);
        if (!paramString.equals(((RepairWorkItem)((RepairWork)c.c(c.this).get(this.b)).getWxxmList().get(0)).getKongJian()))
        {
          this.a.e.setText(paramString);
          this.a.f.setText("");
          this.a.g.setText("");
          this.a.d.setText("");
          this.a.h.setText("");
          ((RepairWorkItem)((RepairWork)c.c(c.this).get(this.b)).getWxxmList().get(0)).setKongJianId(((r)c.d(c.this).get(paramInt)).getCode());
          ((RepairWorkItem)((RepairWork)c.c(c.this).get(this.b)).getWxxmList().get(0)).setKongJian(paramString);
          ((RepairWorkItem)((RepairWork)c.c(c.this).get(this.b)).getWxxmList().get(0)).setZhuti("");
          ((RepairWorkItem)((RepairWork)c.c(c.this).get(this.b)).getWxxmList().get(0)).setZhutiId("");
          ((RepairWorkItem)((RepairWork)c.c(c.this).get(this.b)).getWxxmList().get(0)).setOject("");
          ((RepairWorkItem)((RepairWork)c.c(c.this).get(this.b)).getWxxmList().get(0)).setOjectId("");
          ((RepairWorkItem)((RepairWork)c.c(c.this).get(this.b)).getWxxmList().get(0)).setDetailDescription("");
          ((RepairWorkItem)((RepairWork)c.c(c.this).get(this.b)).getWxxmList().get(0)).setLableCode(null);
          ((RepairWorkItem)((RepairWork)c.c(c.this).get(this.b)).getWxxmList().get(0)).setPic("");
          ((RepairWork)c.c(c.this).get(this.b)).setOrderTime("");
          c.this.checkData(this.b);
        }
      }
    }
  }
  
  class e
    extends com.freelxl.baselibrary.d.c.a<l>
  {
    c.k b;
    int c;
    
    public e(c.k paramk, int paramInt, com.freelxl.baselibrary.d.f.a parama)
    {
      super();
      this.b = paramk;
      this.c = paramInt;
    }
    
    public void onFailure(Throwable paramThrowable)
    {
      com.ziroom.ziroomcustomer.newrepair.utils.c.catchExp(paramThrowable);
      c.b(c.this).dismissProgress();
      this.b.g.setClickable(true);
    }
    
    public void onSuccess(int paramInt, l paraml)
    {
      if (paraml.getSuccess().booleanValue())
      {
        c.e(c.this, (List)paraml.getObject());
        if ((c.k(c.this) != null) && (c.k(c.this).size() > 0))
        {
          c.l(c.this).clear();
          paraml = c.k(c.this).iterator();
          while (paraml.hasNext())
          {
            p localp = (p)paraml.next();
            c.l(c.this).add(localp.getName());
          }
          c.h(c.this, this.b, this.c);
        }
      }
      for (;;)
      {
        this.b.g.setClickable(true);
        c.b(c.this).dismissProgress();
        return;
        paraml = paraml.getMessage();
        c.b(c.this).showToast(paraml);
      }
    }
  }
  
  class f
    extends com.freelxl.baselibrary.d.c.a<l>
  {
    c.k b;
    int c;
    
    public f(c.k paramk, int paramInt, com.freelxl.baselibrary.d.f.a parama)
    {
      super();
      this.c = paramInt;
      this.b = paramk;
    }
    
    public void onFailure(Throwable paramThrowable)
    {
      c.b(c.this).dismissProgress();
      if (this.b != null) {
        this.b.e.setClickable(true);
      }
      com.ziroom.ziroomcustomer.newrepair.utils.c.catchExp(paramThrowable);
    }
    
    public void onSuccess(int paramInt, l paraml)
    {
      if (paraml.getSuccess().booleanValue())
      {
        c.a(c.this, (List)paraml.getObject());
        if ((c.d(c.this) != null) && (c.d(c.this).size() > 0))
        {
          c.e(c.this).clear();
          paraml = c.d(c.this).iterator();
          while (paraml.hasNext())
          {
            r localr = (r)paraml.next();
            c.e(c.this).add(localr.getName());
          }
        }
      }
      else
      {
        paraml = paraml.getMessage();
        c.b(c.this).showToast(paraml);
      }
      if (this.b != null) {
        this.b.e.setClickable(true);
      }
      c.b(c.this).dismissProgress();
    }
  }
  
  class g
    extends com.freelxl.baselibrary.d.c.a<l>
  {
    c.k b;
    int c;
    
    public g(c.k paramk, int paramInt, com.freelxl.baselibrary.d.f.a parama)
    {
      super();
      this.b = paramk;
      this.c = paramInt;
    }
    
    public void onFailure(Throwable paramThrowable)
    {
      com.ziroom.ziroomcustomer.newrepair.utils.c.catchExp(paramThrowable);
      c.b(c.this).dismissProgress();
      this.b.d.setClickable(true);
    }
    
    public void onSuccess(int paramInt, l paraml)
    {
      if (paraml.getSuccess().booleanValue())
      {
        Object localObject = (v)paraml.getObject();
        paraml = ((v)localObject).getNowDate();
        localObject = ((v)localObject).getAppointmentTimeList();
        ((v.a)((List)localObject).get(0)).getDate();
        c.b(c.this, new com.ziroom.ziroomcustomer.newrepair.utils.c().getServiceDateList((List)localObject));
        c.c(c.this, new com.ziroom.ziroomcustomer.newrepair.utils.c().getServiceAppointDateList(paraml, (List)localObject));
        c.f(c.this).clear();
        paraml = ((List)localObject).iterator();
        while (paraml.hasNext())
        {
          localObject = (v.a)paraml.next();
          c.f(c.this).add(((v.a)localObject).getTime());
        }
        c.f(c.this, this.b, this.c);
      }
      for (;;)
      {
        c.b(c.this).dismissProgress();
        this.b.d.setClickable(true);
        return;
        paraml = paraml.getMessage();
        c.b(c.this).showToast(paraml);
      }
    }
  }
  
  class h
    extends com.freelxl.baselibrary.d.c.a<l>
  {
    c.k b;
    int c;
    
    public h(c.k paramk, int paramInt, com.freelxl.baselibrary.d.f.a parama)
    {
      super();
      this.b = paramk;
      this.c = paramInt;
    }
    
    public void onFailure(Throwable paramThrowable)
    {
      com.ziroom.ziroomcustomer.newrepair.utils.c.catchExp(paramThrowable);
      c.b(c.this).dismissProgress();
      this.b.f.setClickable(true);
    }
    
    public void onSuccess(int paramInt, l paraml)
    {
      if (paraml.getSuccess().booleanValue())
      {
        c.d(c.this, (List)paraml.getObject());
        if ((c.h(c.this) != null) && (c.h(c.this).size() > 0))
        {
          c.i(c.this).clear();
          paraml = c.h(c.this).iterator();
          while (paraml.hasNext())
          {
            w localw = (w)paraml.next();
            c.i(c.this).add(localw.getName());
          }
          c.g(c.this, this.b, this.c);
        }
      }
      for (;;)
      {
        c.b(c.this).dismissProgress();
        this.b.f.setClickable(true);
        return;
        paraml = paraml.getMessage();
        c.b(c.this).showToast(paraml);
      }
    }
  }
  
  class i
    extends com.freelxl.baselibrary.d.c.a<l>
  {
    c.k b;
    int c;
    
    public i(c.k paramk, int paramInt, com.freelxl.baselibrary.d.f.a parama)
    {
      super();
      this.b = paramk;
      this.c = paramInt;
    }
    
    public void onFailure(Throwable paramThrowable)
    {
      com.ziroom.ziroomcustomer.newrepair.utils.c.catchExp(paramThrowable);
      c.b(c.this).dismissProgress();
      this.b.h.setClickable(true);
    }
    
    public void onSuccess(int paramInt, l paraml)
    {
      if (paraml.getSuccess().booleanValue())
      {
        c.a(c.this).clear();
        c.a(c.this, (ArrayList)paraml.getObject());
        paraml = new Intent(c.b(c.this), SpecialNeedActivity.class);
        paraml.putExtra("lastInput", ((RepairWorkItem)((RepairWork)c.c(c.this).get(this.c)).getWxxmList().get(0)).getDetailDescription());
        paraml.putExtra("lastTag", ((RepairWorkItem)((RepairWork)c.c(c.this).get(this.c)).getWxxmList().get(0)).getPic());
        paraml.putExtra("position", this.c);
        paraml.putExtra("title", "故障描述");
        paraml.putExtra("hint", "请填写故障描述");
        paraml.putExtra("isRequired", true);
        paraml.putParcelableArrayListExtra("taglist", c.a(c.this));
        c.b(c.this).startActivityForResult(paraml, InternalRepairActivity.a);
      }
      for (;;)
      {
        this.b.h.setClickable(true);
        c.b(c.this).dismissProgress();
        return;
        paraml = paraml.getMessage();
        c.b(c.this).showToast(paraml);
      }
    }
  }
  
  class j
    implements g.a
  {
    c.k a;
    int b;
    
    public j(c.k paramk, int paramInt)
    {
      this.a = paramk;
      this.b = paramInt;
    }
    
    public void showHour(String paramString, int paramInt)
    {
      if ((c.i(c.this) != null) && (c.i(c.this).size() != 0))
      {
        paramString = (String)c.i(c.this).get(paramInt);
        c.j(c.this).getRepairTypeListData(c.c(c.this));
        if (!paramString.equals(((RepairWorkItem)((RepairWork)c.c(c.this).get(this.b)).getWxxmList().get(0)).getZhuti()))
        {
          this.a.f.setText(paramString);
          this.a.g.setText("");
          this.a.d.setText("");
          this.a.h.setText("");
          ((RepairWorkItem)((RepairWork)c.c(c.this).get(this.b)).getWxxmList().get(0)).setZhutiId(((w)c.h(c.this).get(paramInt)).getCode());
          ((RepairWorkItem)((RepairWork)c.c(c.this).get(this.b)).getWxxmList().get(0)).setZhuti(paramString);
          ((RepairWorkItem)((RepairWork)c.c(c.this).get(this.b)).getWxxmList().get(0)).setOject("");
          ((RepairWorkItem)((RepairWork)c.c(c.this).get(this.b)).getWxxmList().get(0)).setOjectId("");
          ((RepairWorkItem)((RepairWork)c.c(c.this).get(this.b)).getWxxmList().get(0)).setDetailDescription("");
          ((RepairWorkItem)((RepairWork)c.c(c.this).get(this.b)).getWxxmList().get(0)).setLableCode(null);
          ((RepairWorkItem)((RepairWork)c.c(c.this).get(this.b)).getWxxmList().get(0)).setPic("");
          ((RepairWork)c.c(c.this).get(this.b)).setOrderTime("");
          c.this.checkData(this.b);
        }
      }
    }
  }
  
  private static class k
  {
    public RelativeLayout a;
    public TextView b;
    public TextView c;
    public LabeledEditText d;
    public LabeledEditText e;
    public LabeledEditText f;
    public LabeledEditText g;
    public LabeledEditText h;
  }
  
  public class l
  {
    c.k a;
    int b;
    
    public l(c.k paramk, int paramInt)
    {
      this.a = paramk;
      this.b = paramInt;
    }
    
    public void itemDelete()
    {
      c.c(c.this).remove(this.b);
      c.this.notifyDataSetChanged();
    }
  }
  
  public class m
    implements a.a
  {
    c.k a;
    int b;
    
    public m(c.k paramk, int paramInt)
    {
      this.a = paramk;
      this.b = paramInt;
    }
    
    public void showHour(String paramString, int paramInt1, int paramInt2)
    {
      this.a.d.setText((String)c.g(c.this).get(paramInt1) + " " + paramString);
      paramString = ((String)c.g(c.this).get(paramInt1)).replaceAll("/", "-");
      ((RepairWork)c.c(c.this).get(this.b)).setOrderTime(paramString);
      ((RepairWork)c.c(c.this).get(this.b)).setOrderTimePeriod(paramInt2 + 1);
      ((RepairWork)c.c(c.this).get(this.b)).setOrderTimeInterval((String)((List)c.f(c.this).get(paramInt1)).get(paramInt2));
      c.this.checkData(this.b);
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newrepair/a/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */