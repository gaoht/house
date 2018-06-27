package com.ziroom.ziroomcustomer.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.widget.TimePickerView;
import com.ziroom.ziroomcustomer.widget.TimePickerView.b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class g
  extends Dialog
{
  TimePickerView a;
  private Context b;
  private a c;
  private List<String> d;
  private List<String> e;
  private int f;
  private String g = "";
  private TextView h;
  
  public g(Context paramContext, a parama, List<String> paramList1, List<String> paramList2)
  {
    super(paramContext, 2131427692);
    this.b = paramContext;
    this.c = parama;
    this.d = paramList1;
    this.e = paramList2;
  }
  
  private void a()
  {
    View localView = LayoutInflater.from(this.b).inflate(2130903850, null);
    a(localView);
    setListener(localView);
    setContentView(localView);
  }
  
  private void a(View paramView)
  {
    this.a = ((TimePickerView)paramView.findViewById(2131693854));
    this.h = ((TextView)paramView.findViewById(2131693706));
    paramView = new ArrayList();
    a(paramView);
    this.a.setData(paramView);
    this.a.setOnSelectListener(new TimePickerView.b()
    {
      public void onSelect(String paramAnonymousString, int paramAnonymousInt)
      {
        if ("2 小时".equals(paramAnonymousString)) {
          g.a(g.this).setText("房间面积 ≤80平米的推荐时长");
        }
        for (;;)
        {
          g.a(g.this, paramAnonymousString);
          g.a(g.this, paramAnonymousInt);
          return;
          if (("3 小时".equals(paramAnonymousString)) || ("4 小时".equals(paramAnonymousString))) {
            g.a(g.this).setText("房间面积80-130平米时的推荐时长");
          } else if (("5 小时".equals(paramAnonymousString)) || ("6 小时".equals(paramAnonymousString))) {
            g.a(g.this).setText("房间面积 ≥130平米时的推荐时长");
          }
        }
      }
    });
  }
  
  private void a(List<String> paramList)
  {
    try
    {
      if (this.d != null)
      {
        Iterator localIterator1 = this.d.iterator();
        while (localIterator1.hasNext())
        {
          paramList.add((String)localIterator1.next());
          continue;
          paramList.add("");
        }
      }
    }
    catch (Exception localException)
    {
      com.freelxl.baselibrary.f.g.textToast(this.b, "请检查网络连接", 0);
    }
    for (;;)
    {
      paramList.add("");
      paramList.add("");
      paramList.add("");
      this.g = ((String)paramList.get(0));
      return;
      this.h.setText("预约项目");
      continue;
      Iterator localIterator2 = this.e.iterator();
      while (localIterator2.hasNext()) {
        paramList.add((String)localIterator2.next());
      }
    }
  }
  
  public TextView getTv_choose()
  {
    return this.h;
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
        if (TextUtils.isEmpty(g.b(g.this)))
        {
          com.freelxl.baselibrary.f.g.textToast(g.c(g.this), "您还未选择时间", 0);
          g.this.dismiss();
          return;
        }
        g.e(g.this).showHour(g.b(g.this), g.d(g.this));
        g.this.dismiss();
      }
    });
    paramView.setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        g.this.dismiss();
      }
    });
  }
  
  public static abstract interface a
  {
    public abstract void showHour(String paramString, int paramInt);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/dialog/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */