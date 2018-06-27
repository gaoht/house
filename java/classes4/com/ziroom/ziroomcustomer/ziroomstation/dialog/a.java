package com.ziroom.ziroomcustomer.ziroomstation.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.freelxl.baselibrary.f.g;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.ziroomstation.widget.TimePickerView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class a
  extends Dialog
{
  private Context a;
  private HashMap<Integer, String> b;
  private LinearLayout c;
  private int d;
  private List<String>[] e;
  private String f;
  private List<TimePickerView> g;
  private b h;
  private a i;
  private TextView j;
  
  public a(Context paramContext, String paramString, a parama, List<String>... paramVarArgs)
  {
    super(paramContext, 2131427692);
    this.a = paramContext;
    this.d = paramVarArgs.length;
    this.e = paramVarArgs;
    if (paramString == null) {}
    for (this.f = "";; this.f = paramString)
    {
      this.i = parama;
      setDefaultSetting();
      return;
    }
  }
  
  public a(Context paramContext, String paramString, b paramb, List<String>... paramVarArgs)
  {
    super(paramContext, 2131427692);
    this.a = paramContext;
    this.d = paramVarArgs.length;
    this.e = paramVarArgs;
    if (paramString == null) {}
    for (this.f = "";; this.f = paramString)
    {
      this.h = paramb;
      setDefaultSetting();
      return;
    }
  }
  
  private void a()
  {
    View localView = LayoutInflater.from(this.a).inflate(2130903778, null);
    a(localView);
    setListener(localView);
    setContentView(localView);
  }
  
  private void a(View paramView)
  {
    this.b = new HashMap();
    this.j = ((TextView)paramView.findViewById(2131693706));
    int k = 0;
    while (k < this.d)
    {
      this.e[k].add("");
      this.e[k].add("");
      this.e[k].add("");
      this.e[k].add("");
      k += 1;
    }
    this.c = ((LinearLayout)paramView.findViewById(2131693707));
    b();
    this.j.setText(this.f);
  }
  
  private void b()
  {
    this.g = new ArrayList();
    this.c.removeAllViews();
    int k = 0;
    while (k < this.d)
    {
      ViewGroup localViewGroup = (ViewGroup)LayoutInflater.from(this.a).inflate(2130903779, this.c, false);
      TimePickerView localTimePickerView = (TimePickerView)localViewGroup.findViewById(2131693708);
      localTimePickerView.setTag(Integer.valueOf(k));
      localTimePickerView.setData(this.e[k]);
      if (this.e[k].size() > 0) {
        localTimePickerView.setCurrentText((String)this.e[k].get(0));
      }
      this.g.add(localTimePickerView);
      localViewGroup.removeAllViews();
      this.c.addView(localTimePickerView);
      k += 1;
    }
  }
  
  public TextView getTv_choose()
  {
    return this.j;
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    a();
  }
  
  public void setDefaultSetting()
  {
    setCanceledOnTouchOutside(true);
    Window localWindow = getWindow();
    localWindow.getDecorView().setPadding(0, 0, 0, 0);
    WindowManager.LayoutParams localLayoutParams = localWindow.getAttributes();
    localLayoutParams.width = -1;
    localLayoutParams.height = -2;
    localWindow.setAttributes(localLayoutParams);
    localWindow.getDecorView().setBackgroundColor(-1);
    localWindow.setGravity(80);
    localWindow.setGravity(80);
    ((WindowManager)this.a.getSystemService("window")).getDefaultDisplay().getWidth();
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
        paramAnonymousView = new int[a.a(a.this)];
        int i = 0;
        while (i < a.a(a.this))
        {
          if (TextUtils.isEmpty(((TimePickerView)a.b(a.this).get(i)).getCurrentText()))
          {
            g.textToast(a.c(a.this), "您第" + (i + 1) + "个选择框中未选择");
            a.this.dismiss();
            return;
          }
          a.d(a.this).put(Integer.valueOf(i), ((TimePickerView)a.b(a.this).get(i)).getCurrentText());
          paramAnonymousView[i] = ((TimePickerView)a.b(a.this).get(i)).getCurrentIndex();
          i += 1;
        }
        if (a.e(a.this) != null) {
          a.e(a.this).callBack(a.d(a.this));
        }
        if (a.f(a.this) != null) {
          a.f(a.this).callback(paramAnonymousView);
        }
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
    public abstract void callback(int[] paramArrayOfInt);
  }
  
  public static abstract interface b
  {
    public abstract void callBack(HashMap<Integer, String> paramHashMap);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes4-dex2jar.jar!/com/ziroom/ziroomcustomer/ziroomstation/dialog/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */