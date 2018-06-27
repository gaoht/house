package com.ziroom.ziroomcustomer.newServiceList.view;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class b
  extends Dialog
{
  RepairTimePickerView a;
  RepairTimePickerView b;
  private Context c;
  private a d;
  private int e;
  private int f;
  private TextView g;
  private String h = "";
  private String i = "";
  private List<String> j;
  private List<List<String>> k;
  private List<List<String>> l;
  private TextView m;
  
  public b(Context paramContext, a parama, List<String> paramList, List<List<String>> paramList1)
  {
    super(paramContext, 2131427692);
    this.c = paramContext;
    this.d = parama;
    this.j = paramList;
    this.k = paramList1;
  }
  
  private void a()
  {
    View localView = LayoutInflater.from(this.c).inflate(2130903833, null);
    this.a = ((RepairTimePickerView)localView.findViewById(2131693853));
    this.b = ((RepairTimePickerView)localView.findViewById(2131693854));
    this.m = ((TextView)localView.findViewById(2131693855));
    this.g = ((TextView)localView.findViewById(2131693706));
    b();
    setListener(localView);
    setContentView(localView);
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
      Toast.makeText(this.c, "请检查网络连接", 0);
      paramList1.add("");
      paramList1.add("");
      paramList1.add("");
      paramList1.add("");
      this.e = 0;
      this.i = ((String)paramList1.get(0));
    }
  }
  
  private void b()
  {
    ArrayList localArrayList = new ArrayList();
    this.l = new ArrayList();
    a(localArrayList, this.j);
    b(this.l, this.k);
    this.a.setData(localArrayList);
    this.a.setOnSelectListener(new RepairTimePickerView.b()
    {
      public void onSelect(String paramAnonymousString, int paramAnonymousInt)
      {
        b.a(b.this, paramAnonymousString);
        b.a(b.this, paramAnonymousInt);
        b.b(b.this, 0);
        b.this.b.setSelected(b.a(b.this));
        b.this.b.setData((List)b.b(b.this).get(paramAnonymousInt));
        b.b(b.this, (String)((List)b.b(b.this).get(paramAnonymousInt)).get(b.a(b.this)));
      }
    });
    this.b.setData((List)this.l.get(0));
    this.b.setOnSelectListener(new RepairTimePickerView.b()
    {
      public void onSelect(String paramAnonymousString, int paramAnonymousInt)
      {
        b.b(b.this, paramAnonymousString);
        b.b(b.this, paramAnonymousInt);
      }
    });
  }
  
  private void b(List<List<String>> paramList1, List<List<String>> paramList2)
  {
    int n = 0;
    for (;;)
    {
      ArrayList localArrayList;
      try
      {
        if (n < paramList2.size())
        {
          localArrayList = new ArrayList();
          Iterator localIterator = ((List)paramList2.get(n)).iterator();
          if (!localIterator.hasNext()) {
            break label110;
          }
          localArrayList.add((String)localIterator.next());
          continue;
        }
        localArrayList.add("");
      }
      catch (Exception paramList2)
      {
        Toast.makeText(this.c, "请检查网络连接", 0);
        this.f = 0;
        this.h = ((String)((List)paramList1.get(0)).get(0));
        return;
      }
      label110:
      localArrayList.add("");
      localArrayList.add("");
      localArrayList.add("");
      paramList1.add(localArrayList);
      n += 1;
    }
  }
  
  public TextView getTv_choose()
  {
    return this.g;
  }
  
  public TextView getTv_title_point()
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
        if (TextUtils.isEmpty(b.c(b.this)))
        {
          paramAnonymousView = Toast.makeText(b.d(b.this), "您还未选择时间", 0);
          if (!(paramAnonymousView instanceof Toast)) {
            paramAnonymousView.show();
          }
          for (;;)
          {
            b.this.dismiss();
            return;
            VdsAgent.showToast((Toast)paramAnonymousView);
          }
        }
        b.f(b.this).showHour(b.c(b.this), b.e(b.this));
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
    public abstract void showHour(String paramString, int paramInt);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newServiceList/view/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */