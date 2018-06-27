package com.ziroom.ziroomcustomer.dialog;

import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
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
  extends AlertDialog
{
  TimePickerView a;
  private Context b;
  private a c;
  private List<String> d;
  private String e;
  private int f;
  private String g = "";
  private TextView h;
  
  public e(Context paramContext, a parama, List<String> paramList)
  {
    super(paramContext, 2131427692);
    this.b = paramContext;
    this.c = parama;
    this.d = paramList;
  }
  
  public e(Context paramContext, a parama, List<String> paramList, String paramString)
  {
    super(paramContext, 2131427692);
    this.b = paramContext;
    this.c = parama;
    this.d = paramList;
    this.e = paramString;
  }
  
  private void a()
  {
    Object localObject = getWindow();
    WindowManager.LayoutParams localLayoutParams = ((Window)localObject).getAttributes();
    localLayoutParams.width = -1;
    localLayoutParams.gravity = 80;
    ((Window)localObject).setAttributes(localLayoutParams);
    localObject = LayoutInflater.from(this.b).inflate(2130903850, null);
    a((View)localObject);
    setListener((View)localObject);
    setContentView((View)localObject);
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
        e.a(e.this, paramAnonymousString);
        e.a(e.this, paramAnonymousInt);
      }
    });
  }
  
  private void a(List<String> paramList)
  {
    if (this.d != null)
    {
      Iterator localIterator = this.d.iterator();
      while (localIterator.hasNext()) {
        paramList.add((String)localIterator.next());
      }
      this.h.setText(this.e);
    }
    paramList.add("");
    paramList.add("");
    paramList.add("");
    paramList.add("");
    this.g = ((String)paramList.get(0));
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
        if (TextUtils.isEmpty(e.a(e.this)))
        {
          g.textToast(e.b(e.this), "您还未做出选择", 0);
          e.this.dismiss();
          return;
        }
        e.d(e.this).showHour(e.a(e.this), e.c(e.this));
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
    public abstract void showHour(String paramString, int paramInt);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/dialog/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */