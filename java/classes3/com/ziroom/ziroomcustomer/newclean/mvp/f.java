package com.ziroom.ziroomcustomer.newclean.mvp;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.freelxl.baselibrary.f.g;
import com.ziroom.ziroomcustomer.e.c.l;
import com.ziroom.ziroomcustomer.e.c.m;
import com.ziroom.ziroomcustomer.e.n;
import com.ziroom.ziroomcustomer.newServiceList.utils.i;
import com.ziroom.ziroomcustomer.newServiceList.utils.j;
import com.ziroom.ziroomcustomer.newclean.b.ab;
import com.ziroom.ziroomcustomer.newclean.b.o;
import com.ziroom.ziroomcustomer.newclean.cardpay.MyGridView;
import com.ziroom.ziroomcustomer.newclean.d.ay;
import com.ziroom.ziroomcustomer.newclean.d.bi;
import com.ziroom.ziroomcustomer.newclean.d.s;
import com.ziroom.ziroomcustomer.newclean.d.u;
import com.ziroom.ziroomcustomer.widget.HorizontalListView;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class f
  implements e.a
{
  private final WeakReference<e.b> a;
  private String b;
  private String c;
  private List<bi> d = new ArrayList();
  private List<String> e = new ArrayList();
  private List<ay> f = new ArrayList();
  private ab g;
  private o h;
  private String i;
  private String j;
  private String k;
  private String l;
  private String m;
  private String n;
  private int o;
  private String p;
  
  public f(e.b paramb)
  {
    this.a = new WeakReference(paramb);
    if (paramb != null) {
      paramb.setPresenter(this);
    }
  }
  
  private void a()
  {
    n.getGeneralCleanData(((e.b)this.a.get()).getViewContext(), this.b, this.c, new com.ziroom.ziroomcustomer.e.a.a(((e.b)this.a.get()).getViewContext(), new l(u.class, new com.ziroom.ziroomcustomer.e.c.a.a()))
    {
      public void onSuccess(int paramAnonymousInt, List<u> paramAnonymousList)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousList);
        if ((paramAnonymousList != null) && (paramAnonymousList.size() > 0))
        {
          f.a(f.this).clear();
          f.b(f.this).clear();
          paramAnonymousList = paramAnonymousList.iterator();
          while (paramAnonymousList.hasNext())
          {
            Object localObject = (u)paramAnonymousList.next();
            f.b(f.this).add(((u)localObject).getDate());
            String str = i.getDayTime(((u)localObject).getDateWeek(), ((u)localObject).getDate());
            localObject = i.getCandleTime(((u)localObject).getDate());
            f.a(f.this).add(new bi(str, (String)localObject));
          }
          f.c(f.this).setData(f.a(f.this));
          f.a(f.this, (String)f.b(f.this).get(0));
          f.c(f.this).setSelectPosition(0);
          f.d(f.this);
        }
      }
    });
  }
  
  private void b()
  {
    String str = j.getUid();
    if (TextUtils.isEmpty(str)) {
      return;
    }
    n.getCleanTimePoint(((e.b)this.a.get()).getViewContext(), str, this.j, this.b, this.c, this.i, new com.ziroom.ziroomcustomer.e.a.a(((e.b)this.a.get()).getViewContext(), new m(s.class, new com.ziroom.ziroomcustomer.e.c.a.a()))
    {
      public void onSuccess(int paramAnonymousInt, s paramAnonymouss)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymouss);
        if (paramAnonymouss != null)
        {
          f.a(f.this, paramAnonymouss.getOptionDateList());
          f.f(f.this).setData(f.e(f.this));
        }
      }
    });
  }
  
  private boolean c()
  {
    return (getView() != null) && (((e.b)this.a.get()).isActive());
  }
  
  public void dataClick(int paramInt)
  {
    this.j = ((String)this.e.get(paramInt));
    this.g.setSelectPosition(paramInt);
    b();
  }
  
  public void detachView() {}
  
  public Object getView()
  {
    if (this.a != null) {
      return this.a.get();
    }
    return null;
  }
  
  public void setCommit()
  {
    if (TextUtils.isEmpty(this.j)) {
      g.textToast(((e.b)this.a.get()).getViewContext(), "请先选择日期");
    }
    while (!TextUtils.isEmpty(this.l)) {
      return;
    }
    g.textToast(((e.b)this.a.get()).getViewContext(), "请先选择时间点");
  }
  
  public void start()
  {
    if (c())
    {
      this.b = ((e.b)this.a.get()).getExtras().getStringExtra("serviceInfoId");
      this.c = ((e.b)this.a.get()).getExtras().getStringExtra("servicePmId");
      this.i = ((e.b)this.a.get()).getExtras().getStringExtra("addressId");
      this.m = ((e.b)this.a.get()).getExtras().getStringExtra("mOrderCode");
      this.n = ((e.b)this.a.get()).getExtras().getStringExtra("mOldStartTime");
      this.o = ((e.b)this.a.get()).getExtras().getIntExtra("orderStatus", -1);
      this.p = ((e.b)this.a.get()).getExtras().getStringExtra("cleanerId");
      this.g = new ab(((e.b)this.a.get()).getViewContext(), this.d);
      ((e.b)this.a.get()).getmHlData().setAdapter(this.g);
      this.h = new o(4, this.f, ((e.b)this.a.get()).getViewContext());
      ((e.b)this.a.get()).getmGvHome().setAdapter(this.h);
      a();
    }
  }
  
  public void timeClick(int paramInt)
  {
    if ("0".equals(((ay)this.f.get(paramInt)).getFlag()))
    {
      if (this.h != null) {
        this.h.setSelectPosition(paramInt);
      }
      this.k = ((ay)this.f.get(paramInt)).getDatePlan();
      this.l = ((ay)this.f.get(paramInt)).getTimePoint();
      return;
    }
    g.textToast(((e.b)this.a.get()).getViewContext(), "已约满，请选择其他时间");
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newclean/mvp/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */