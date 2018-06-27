package com.ziroom.ziroomcustomer.newServiceList.b;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.EditText;
import android.widget.TextView;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.base.a;
import com.ziroom.ziroomcustomer.e.o;
import com.ziroom.ziroomcustomer.newServiceList.model.aj.a;
import com.ziroom.ziroomcustomer.newmovehouse.widget.FlowLayout;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class d
  extends a
  implements View.OnClickListener
{
  private Context a;
  private Handler b;
  private EditText c;
  private FlowLayout d;
  private View e;
  private String f = "";
  private List<aj.a> g;
  private String h;
  private String i;
  private String j;
  private String k;
  private Map<String, String> l;
  private TextView m;
  
  public d(Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
    this.a = paramContext;
  }
  
  private Map<String, String> a(String paramString)
  {
    HashMap localHashMap = new HashMap();
    if (paramString.length() < 1) {}
    for (;;)
    {
      return localHashMap;
      paramString = paramString.split(",");
      if ((paramString != null) && (paramString.length > 0))
      {
        int i1 = paramString.length;
        int n = 0;
        while (n < i1)
        {
          aj.a locala = b(paramString[n]);
          localHashMap.put(String.valueOf(locala.getTagKey()), locala.getTagValue());
          n += 1;
        }
      }
    }
  }
  
  private void a()
  {
    this.c = ((EditText)findViewById(2131693726));
    this.d = ((FlowLayout)findViewById(2131690332));
    this.m = ((TextView)findViewById(2131690003));
    this.e = findViewById(2131693727);
    this.e.setOnClickListener(this);
  }
  
  private float b()
  {
    return (getWindow().getDecorView().getDisplay().getHeight() - getWindow().getDecorView().getHeight()) / 2;
  }
  
  private aj.a b(String paramString)
  {
    if ((this.g != null) && (this.g.size() > 0))
    {
      Iterator localIterator = this.g.iterator();
      while (localIterator.hasNext())
      {
        aj.a locala = (aj.a)localIterator.next();
        if (locala.getTagValue().equals(paramString)) {
          return locala;
        }
      }
    }
    return null;
  }
  
  private float c()
  {
    return (getWindow().getDecorView().getDisplay().getHeight() + getWindow().getDecorView().getHeight()) / 2;
  }
  
  public View getBtn_cancel_commit()
  {
    return this.e;
  }
  
  public EditText getEt_reason()
  {
    return this.c;
  }
  
  public FlowLayout getFl_tag()
  {
    return this.d;
  }
  
  public String getTagStr()
  {
    return this.f;
  }
  
  public TextView getTv_num()
  {
    return this.m;
  }
  
  @Instrumented
  public void onClick(View paramView)
  {
    VdsAgent.onClick(this, paramView);
    if (paramView != null) {}
    switch (paramView.getId())
    {
    default: 
      return;
    }
    this.l = a(this.f);
    this.h = VdsAgent.trackEditTextSilent(this.c).toString();
    o.cancelNewMHOrder(this.a, this.b, this.l, this.h, this.i, this.j, System.currentTimeMillis());
    dismiss();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903787);
    a();
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 0)
    {
      if ((paramMotionEvent.getRawY() < b()) || (paramMotionEvent.getRawY() > c())) {
        dismiss();
      }
      if ((getCurrentFocus() == null) || (getCurrentFocus().getWindowToken() == null)) {}
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void setBtn_cancel_commit(View paramView)
  {
    this.e = paramView;
  }
  
  public void setCancelerId(String paramString)
  {
    this.i = paramString;
  }
  
  public void setEt_reason(EditText paramEditText)
  {
    this.c = paramEditText;
  }
  
  public void setHandler(Handler paramHandler)
  {
    this.b = paramHandler;
  }
  
  public void setServiceInfoId(String paramString)
  {
    this.k = paramString;
  }
  
  public void setTagList(List<aj.a> paramList)
  {
    this.g = paramList;
  }
  
  public void setTagStr(String paramString)
  {
    this.f = paramString;
  }
  
  public void setTv_num(TextView paramTextView)
  {
    this.m = paramTextView;
  }
  
  public void setWorkOrderId(String paramString)
  {
    this.j = paramString;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newServiceList/b/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */