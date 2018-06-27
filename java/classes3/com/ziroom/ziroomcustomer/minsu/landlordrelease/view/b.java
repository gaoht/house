package com.ziroom.ziroomcustomer.minsu.landlordrelease.view;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.freelxl.baselibrary.f.g;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.widget.TimePickerView;
import com.ziroom.ziroomcustomer.widget.TimePickerView.b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class b
  extends Dialog
{
  private int A;
  private int B;
  private Context a;
  private Integer b;
  private Integer c;
  private Integer d;
  private Integer e;
  private Integer f;
  private a g;
  private List<String> h;
  private List<String> i;
  private List<String> j;
  private List<String> k;
  private List<String> l;
  private TimePickerView m;
  private TimePickerView n;
  private TimePickerView o;
  private TimePickerView p;
  private TimePickerView q;
  private TextView r;
  private String s;
  private String t;
  private String u;
  private String v;
  private String w;
  private int x;
  private int y;
  private int z;
  
  public b(Context paramContext, String paramString, a parama, List<String> paramList1, List<String> paramList2, List<String> paramList3, List<String> paramList4, List<String> paramList5)
  {
    super(paramContext, 2131427692);
    this.a = paramContext;
    this.g = parama;
    this.h = paramList1;
    this.i = paramList2;
    this.j = paramList3;
    this.k = paramList4;
    this.l = paramList5;
  }
  
  public b(Context paramContext, String paramString, Integer paramInteger1, Integer paramInteger2, Integer paramInteger3, Integer paramInteger4, Integer paramInteger5, a parama, List<String> paramList1, List<String> paramList2, List<String> paramList3, List<String> paramList4, List<String> paramList5)
  {
    super(paramContext, 2131427692);
    this.a = paramContext;
    this.b = paramInteger1;
    this.c = paramInteger2;
    this.d = paramInteger3;
    this.e = paramInteger4;
    this.f = paramInteger5;
    this.g = parama;
    this.h = paramList1;
    this.i = paramList2;
    this.j = paramList3;
    this.k = paramList4;
    this.l = paramList5;
  }
  
  private void a()
  {
    View localView = LayoutInflater.from(this.a).inflate(2130903820, null);
    a(localView);
    setListener(localView);
    setContentView(localView);
  }
  
  private void a(View paramView)
  {
    this.m = ((TimePickerView)paramView.findViewById(2131693828));
    this.n = ((TimePickerView)paramView.findViewById(2131693829));
    this.o = ((TimePickerView)paramView.findViewById(2131693830));
    this.p = ((TimePickerView)paramView.findViewById(2131693831));
    this.q = ((TimePickerView)paramView.findViewById(2131693832));
    this.r = ((TextView)paramView.findViewById(2131693706));
    paramView = new ArrayList();
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    ArrayList localArrayList3 = new ArrayList();
    ArrayList localArrayList4 = new ArrayList();
    a(paramView, this.h);
    b(localArrayList1, this.i);
    c(localArrayList2, this.j);
    d(localArrayList3, this.k);
    e(localArrayList4, this.l);
    this.m.setData(paramView);
    this.n.setData(localArrayList1);
    this.o.setData(localArrayList2);
    this.p.setData(localArrayList3);
    this.q.setData(localArrayList4);
    this.m.setOnSelectListener(new TimePickerView.b()
    {
      public void onSelect(String paramAnonymousString, int paramAnonymousInt)
      {
        b.a(b.this, (String)b.a(b.this).get(paramAnonymousInt));
        b.a(b.this, paramAnonymousInt);
        b.d(b.this).showShiSelect(b.b(b.this), b.c(b.this));
      }
    });
    this.n.setOnSelectListener(new TimePickerView.b()
    {
      public void onSelect(String paramAnonymousString, int paramAnonymousInt)
      {
        b.b(b.this, (String)b.e(b.this).get(paramAnonymousInt));
        b.b(b.this, paramAnonymousInt);
        b.d(b.this).showTingSelect(b.f(b.this), b.g(b.this));
      }
    });
    this.o.setOnSelectListener(new TimePickerView.b()
    {
      public void onSelect(String paramAnonymousString, int paramAnonymousInt)
      {
        b.c(b.this, (String)b.h(b.this).get(paramAnonymousInt));
        b.c(b.this, paramAnonymousInt);
        b.d(b.this).showToiletSelect(b.i(b.this), b.j(b.this));
      }
    });
    this.p.setOnSelectListener(new TimePickerView.b()
    {
      public void onSelect(String paramAnonymousString, int paramAnonymousInt)
      {
        b.d(b.this, (String)b.k(b.this).get(paramAnonymousInt));
        b.d(b.this, paramAnonymousInt);
        b.d(b.this).showKitchenSelect(b.l(b.this), b.m(b.this));
      }
    });
    this.q.setOnSelectListener(new TimePickerView.b()
    {
      public void onSelect(String paramAnonymousString, int paramAnonymousInt)
      {
        b.e(b.this, (String)b.n(b.this).get(paramAnonymousInt));
        b.e(b.this, paramAnonymousInt);
        b.d(b.this).showBalconySelect(b.o(b.this), b.p(b.this));
      }
    });
  }
  
  private void a(List<String> paramList1, List<String> paramList2)
  {
    try
    {
      paramList2 = paramList2.iterator();
      while (paramList2.hasNext()) {
        paramList1.add((String)paramList2.next());
      }
      return;
    }
    catch (Exception paramList2)
    {
      g.textToast(this.a, "请检查网络连接");
      paramList1.add("");
      paramList1.add("");
      paramList1.add("");
      paramList1.add("");
      this.s = ((String)paramList1.get(0));
    }
  }
  
  private void b(List<String> paramList1, List<String> paramList2)
  {
    try
    {
      paramList2 = paramList2.iterator();
      while (paramList2.hasNext()) {
        paramList1.add((String)paramList2.next());
      }
      return;
    }
    catch (Exception paramList2)
    {
      g.textToast(this.a, "请检查网络连接");
      paramList1.add("");
      paramList1.add("");
      paramList1.add("");
      paramList1.add("");
      this.t = ((String)paramList1.get(0));
    }
  }
  
  private void c(List<String> paramList1, List<String> paramList2)
  {
    try
    {
      paramList2 = paramList2.iterator();
      while (paramList2.hasNext()) {
        paramList1.add((String)paramList2.next());
      }
      return;
    }
    catch (Exception paramList2)
    {
      g.textToast(this.a, "请检查网络连接");
      paramList1.add("");
      paramList1.add("");
      paramList1.add("");
      paramList1.add("");
      this.u = ((String)paramList1.get(0));
    }
  }
  
  private void d(List<String> paramList1, List<String> paramList2)
  {
    try
    {
      paramList2 = paramList2.iterator();
      while (paramList2.hasNext()) {
        paramList1.add((String)paramList2.next());
      }
      return;
    }
    catch (Exception paramList2)
    {
      g.textToast(this.a, "请检查网络连接");
      paramList1.add("");
      paramList1.add("");
      paramList1.add("");
      paramList1.add("");
      this.v = ((String)paramList1.get(0));
    }
  }
  
  private void e(List<String> paramList1, List<String> paramList2)
  {
    try
    {
      paramList2 = paramList2.iterator();
      while (paramList2.hasNext()) {
        paramList1.add((String)paramList2.next());
      }
      return;
    }
    catch (Exception paramList2)
    {
      g.textToast(this.a, "请检查网络连接");
      paramList1.add("");
      paramList1.add("");
      paramList1.add("");
      paramList1.add("");
      this.w = ((String)paramList1.get(0));
    }
  }
  
  public TextView getTv_choose()
  {
    return this.r;
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    a();
  }
  
  public void setListener(View paramView)
  {
    Button localButton = (Button)paramView.findViewById(2131691363);
    paramView = (Button)paramView.findViewById(2131690460);
    localButton.setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        b.d(b.this).getChoseHouseType(b.b(b.this), b.f(b.this), b.i(b.this), b.l(b.this), b.o(b.this));
        b.this.dismiss();
      }
    });
    paramView.setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        b.this.dismiss();
      }
    });
  }
  
  public static abstract interface a
  {
    public abstract void getChoseHouseType(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5);
    
    public abstract void showBalconySelect(String paramString, int paramInt);
    
    public abstract void showKitchenSelect(String paramString, int paramInt);
    
    public abstract void showShiSelect(String paramString, int paramInt);
    
    public abstract void showTingSelect(String paramString, int paramInt);
    
    public abstract void showToiletSelect(String paramString, int paramInt);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/landlordrelease/view/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */