package com.ziroom.ziroomcustomer.newrepair.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
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

public class e
  extends Dialog
{
  TimePickerView a;
  TimePickerView b;
  private Context c;
  private a d;
  private String[] e = { "9:00-13:00", "13:00-17:00", "17:00-24:00" };
  private int f;
  private int g;
  private TextView h;
  private String i = "";
  private String j = "";
  private List<String> k;
  private List<String> l;
  private List<String> m;
  private TextView n;
  
  public e(Context paramContext, a parama, List<String> paramList1, List<String> paramList2)
  {
    super(paramContext, 2131427692);
    this.c = paramContext;
    this.d = parama;
    this.k = paramList1;
    this.l = paramList2;
  }
  
  private void a()
  {
    View localView = LayoutInflater.from(this.c).inflate(2130903840, null);
    a(localView);
    setListener(localView);
    setContentView(localView);
  }
  
  private void a(View paramView)
  {
    this.a = ((TimePickerView)paramView.findViewById(2131693853));
    this.b = ((TimePickerView)paramView.findViewById(2131693854));
    this.n = ((TextView)paramView.findViewById(2131693855));
    this.h = ((TextView)paramView.findViewById(2131693706));
    paramView = new ArrayList();
    this.m = new ArrayList();
    a(paramView, this.k);
    b(this.m, this.l);
    this.a.setData(paramView);
    this.a.setOnSelectListener(new TimePickerView.b()
    {
      public void onSelect(String paramAnonymousString, int paramAnonymousInt)
      {
        e.a(e.this, paramAnonymousString);
        e.a(e.this, paramAnonymousInt);
      }
    });
    this.b.setData(this.m);
    this.b.setOnSelectListener(new TimePickerView.b()
    {
      public void onSelect(String paramAnonymousString, int paramAnonymousInt)
      {
        e.b(e.this, paramAnonymousString);
        e.b(e.this, paramAnonymousInt);
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
      g.textToast(this.c, "请检查网络连接");
      paramList1.add("");
      paramList1.add("");
      paramList1.add("");
      paramList1.add("");
      this.f = 0;
      this.j = ((String)paramList1.get(0));
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
      g.textToast(this.c, "请检查网络连接");
      paramList1.add("");
      paramList1.add("");
      paramList1.add("");
      paramList1.add("");
      this.g = 0;
      this.i = ((String)paramList1.get(0));
    }
  }
  
  public TextView getTv_choose()
  {
    return this.h;
  }
  
  public TextView getTv_title_point()
  {
    return this.n;
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
        if (TextUtils.isEmpty(e.a(e.this)))
        {
          g.textToast(e.b(e.this), "您还未选择时间");
          e.this.dismiss();
          return;
        }
        e.e(e.this).showHour("(" + e.a(e.this) + ")", e.c(e.this), e.d(e.this));
        e.this.dismiss();
      }
    });
    paramView.setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        e.this.dismiss();
      }
    });
  }
  
  public static abstract interface a
  {
    public abstract void showHour(String paramString, int paramInt1, int paramInt2);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newrepair/dialog/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */