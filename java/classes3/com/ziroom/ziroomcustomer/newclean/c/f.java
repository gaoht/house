package com.ziroom.ziroomcustomer.newclean.c;

import android.app.Dialog;
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

public class f
  extends Dialog
{
  private Context a;
  private Button b;
  private Button c;
  private TextView d;
  private TimePickerView e;
  private a f;
  private List<String> g;
  private int h;
  private String i = "";
  
  public f(Context paramContext, List<String> paramList)
  {
    super(paramContext, 2131427692);
    this.a = paramContext;
    this.g = paramList;
    setDefaultSetting();
  }
  
  private void a()
  {
    View localView = LayoutInflater.from(this.a).inflate(2130903850, null);
    this.b = ((Button)localView.findViewById(2131690460));
    this.d = ((TextView)localView.findViewById(2131693706));
    this.c = ((Button)localView.findViewById(2131691363));
    this.e = ((TimePickerView)localView.findViewById(2131693854));
    b();
    setContentView(localView);
  }
  
  private void b()
  {
    this.d.setText("服务时长");
    ArrayList localArrayList = new ArrayList();
    localArrayList.clear();
    try
    {
      if (this.g != null)
      {
        Iterator localIterator = this.g.iterator();
        while (localIterator.hasNext()) {
          localArrayList.add((String)localIterator.next());
        }
      }
      return;
    }
    catch (Exception localException)
    {
      g.textToast(this.a, "请检查网络连接", 0);
      localArrayList.add("");
      localArrayList.add("");
      localArrayList.add("");
      localArrayList.add("");
      this.i = ((String)localArrayList.get(0));
      this.e.setData(localArrayList);
      this.e.setOnSelectListener(new TimePickerView.b()
      {
        public void onSelect(String paramAnonymousString, int paramAnonymousInt)
        {
          f.a(f.this, paramAnonymousString);
          f.a(f.this, paramAnonymousInt);
        }
      });
      this.c.setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          if (TextUtils.isEmpty(f.a(f.this)))
          {
            g.textToast(f.b(f.this), "您还未选择时间", 0);
            f.this.dismiss();
            return;
          }
          f.d(f.this).showHour(f.a(f.this), f.c(f.this));
          f.this.dismiss();
        }
      });
      this.b.setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          f.this.dismiss();
        }
      });
    }
  }
  
  public TextView getTv_choose()
  {
    return this.d;
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    a();
  }
  
  public void setDefaultSetting()
  {
    setCanceledOnTouchOutside(true);
    setCanceledOnTouchOutside(true);
    Window localWindow = getWindow();
    localWindow.getDecorView().setPadding(0, 0, 0, 0);
    WindowManager.LayoutParams localLayoutParams = localWindow.getAttributes();
    localLayoutParams.width = -1;
    localLayoutParams.height = -2;
    localWindow.setAttributes(localLayoutParams);
    localWindow.getDecorView().setBackgroundColor(-1);
    localWindow.setGravity(80);
  }
  
  public void setmListener(a parama)
  {
    this.f = parama;
  }
  
  public static abstract interface a
  {
    public abstract void showHour(String paramString, int paramInt);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newclean/c/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */