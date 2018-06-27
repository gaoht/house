package com.ziroom.ziroomcustomer.my;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.alibaba.fastjson.e;
import com.freelxl.baselibrary.f.g;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.widget.TimePickerView;
import com.ziroom.ziroomcustomer.widget.TimePickerView.b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class a
  extends Dialog
{
  TimePickerView a;
  TimePickerView b;
  private Context c;
  private a d;
  private List<e> e;
  private List<String> f;
  private List<String> g;
  private int h;
  private int i;
  private String j = "";
  private String k = "";
  private String l = "";
  private TextView m;
  private int n;
  
  public a(Context paramContext, a parama, List<e> paramList, int paramInt)
  {
    super(paramContext, 2131427692);
    this.c = paramContext;
    this.d = parama;
    this.e = paramList;
    this.n = paramInt;
  }
  
  private void a()
  {
    View localView = LayoutInflater.from(this.c).inflate(2130904110, null);
    a(localView);
    setListener(localView);
    setContentView(localView);
  }
  
  private void a(View paramView)
  {
    this.a = ((TimePickerView)paramView.findViewById(2131694784));
    this.b = ((TimePickerView)paramView.findViewById(2131694785));
    this.m = ((TextView)paramView.findViewById(2131693706));
    a(this.e);
    this.a.setData(this.f);
    if (this.g != null) {
      this.b.setData(this.g);
    }
    this.a.setOnSelectListener(new TimePickerView.b()
    {
      public void onSelect(String paramAnonymousString, int paramAnonymousInt)
      {
        a.a(a.this, paramAnonymousString);
        a.a(a.this, paramAnonymousInt);
        a.b(a.this, (String)((e)a.a(a.this).get(paramAnonymousInt)).get("date"));
        a.this.b.setData((List)((e)a.a(a.this).get(paramAnonymousInt)).get("time"));
        a.c(a.this, (String)((List)((e)a.a(a.this).get(paramAnonymousInt)).get("time")).get(0));
      }
    });
    this.b.setOnSelectListener(new TimePickerView.b()
    {
      public void onSelect(String paramAnonymousString, int paramAnonymousInt)
      {
        a.c(a.this, paramAnonymousString);
        a.b(a.this, paramAnonymousInt);
      }
    });
  }
  
  private void a(List<e> paramList)
  {
    e locale;
    if (paramList != null) {
      try
      {
        Iterator localIterator = paramList.iterator();
        for (;;)
        {
          if (localIterator.hasNext())
          {
            locale = (e)localIterator.next();
            if (this.f != null)
            {
              this.f.add(locale.get("name").toString());
              continue;
              this.f.add("");
            }
          }
        }
      }
      catch (Exception paramList)
      {
        g.textToast(this.c, "系统时间异常", 0);
      }
    }
    for (;;)
    {
      this.f.add("");
      this.f.add("");
      this.f.add("");
      this.j = ((String)this.f.get(0));
      this.l = ((String)((e)this.e.get(0)).get("date"));
      if (this.g != null) {
        this.k = ((String)this.g.get(0));
      }
      return;
      this.f = new ArrayList();
      this.f.add(locale.get("name").toString());
      break;
      if ((this.f != null) && (this.f.size() > 0)) {
        this.g = ((List)((e)paramList.get(0)).get("time"));
      } else {
        this.f = new ArrayList();
      }
    }
  }
  
  public TextView getTv_choose()
  {
    return this.m;
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
        if (TextUtils.isEmpty(a.b(a.this)))
        {
          g.textToast(a.c(a.this), "您还未选择条件", 0);
          a.this.dismiss();
          return;
        }
        a.i(a.this).showHour(a.b(a.this), a.d(a.this), a.e(a.this), a.f(a.this), a.g(a.this), a.h(a.this));
        a.this.dismiss();
      }
    });
    paramView.setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        a.this.dismiss();
      }
    });
  }
  
  public static abstract interface a
  {
    public abstract void showHour(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, int paramInt3);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/my/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */