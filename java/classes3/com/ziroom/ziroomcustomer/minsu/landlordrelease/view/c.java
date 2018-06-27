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
import com.ziroom.ziroomcustomer.minsu.landlordrelease.model.SingleChoseBean;
import com.ziroom.ziroomcustomer.widget.TimePickerView;
import com.ziroom.ziroomcustomer.widget.TimePickerView.b;
import java.util.ArrayList;
import java.util.List;

public class c
  extends Dialog
{
  private Context a;
  private String b;
  private a c;
  private List<SingleChoseBean> d;
  private TimePickerView e;
  private TextView f;
  private String g;
  private int h;
  
  public c(Context paramContext, String paramString, a parama, List<SingleChoseBean> paramList)
  {
    super(paramContext, 2131427692);
    this.a = paramContext;
    this.b = paramString;
    this.c = parama;
    this.d = paramList;
  }
  
  private void a()
  {
    View localView = LayoutInflater.from(this.a).inflate(2130903821, null);
    a(localView);
    setListener(localView);
    setContentView(localView);
  }
  
  private void a(View paramView)
  {
    this.e = ((TimePickerView)paramView.findViewById(2131693828));
    this.f = ((TextView)paramView.findViewById(2131693706));
    paramView = new ArrayList();
    String str = this.b;
    int i = -1;
    switch (str.hashCode())
    {
    default: 
      switch (i)
      {
      }
      break;
    }
    for (;;)
    {
      this.e.setData(paramView);
      this.e.setOnSelectListener(new TimePickerView.b()
      {
        public void onSelect(String paramAnonymousString, int paramAnonymousInt)
        {
          if ((c.a(c.this) == null) || (c.a(c.this).isEmpty())) {
            return;
          }
          c.a(c.this, ((SingleChoseBean)c.a(c.this).get(paramAnonymousInt)).getText());
          c.a(c.this, paramAnonymousInt);
        }
      });
      return;
      if (!str.equals("people_limit_shose")) {
        break;
      }
      i = 0;
      break;
      if (!str.equals("iswith_landlord_chose")) {
        break;
      }
      i = 1;
      break;
      if (!str.equals("weekend_chose")) {
        break;
      }
      i = 2;
      break;
      if (!str.equals("roomcount_chose")) {
        break;
      }
      i = 3;
      break;
      if (!str.equals("single_min_days")) {
        break;
      }
      i = 4;
      break;
      if (!str.equals("single_check_in_time")) {
        break;
      }
      i = 5;
      break;
      if (!str.equals("single_check_out_time")) {
        break;
      }
      i = 6;
      break;
      a(paramView, this.d);
      continue;
      a(paramView, this.d);
      continue;
      a(paramView, this.d);
      continue;
      a(paramView, this.d);
      continue;
      a(paramView, this.d);
      continue;
      a(paramView, this.d);
      continue;
      a(paramView, this.d);
    }
  }
  
  private void a(List<String> paramList, List<SingleChoseBean> paramList1)
  {
    int i = 0;
    try
    {
      while (i < paramList1.size())
      {
        paramList.add(((SingleChoseBean)paramList1.get(i)).getText());
        i += 1;
      }
      return;
    }
    catch (Exception paramList1)
    {
      g.textToast(this.a, "请检查网络连接");
      paramList.add("");
      paramList.add("");
      paramList.add("");
      paramList.add("");
      this.g = ((String)paramList.get(0));
    }
  }
  
  public TextView getTv_choose()
  {
    return this.f;
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
        c.d(c.this).onSingleSelect(c.b(c.this), c.c(c.this));
        c.this.dismiss();
      }
    });
    paramView.setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        c.this.dismiss();
      }
    });
  }
  
  public static abstract interface a
  {
    public abstract void onSingleSelect(String paramString, int paramInt);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/landlordrelease/view/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */