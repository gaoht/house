package com.ziroom.ziroomcustomer.minsu.dialog;

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
import com.ziroom.ziroomcustomer.minsu.bean.MinsuAppointmentPhotographerTimeBean;
import com.ziroom.ziroomcustomer.minsu.bean.MinsuAppointmentPhotographerTimeBean.TimesBean;
import com.ziroom.ziroomcustomer.ziroomstation.dialog.a.a;
import com.ziroom.ziroomcustomer.ziroomstation.widget.TimePickerView;
import com.ziroom.ziroomcustomer.ziroomstation.widget.TimePickerView.b;
import java.util.ArrayList;
import java.util.List;

public class c
  extends Dialog
{
  private Context a;
  private LinearLayout b;
  private String c;
  private List<TimePickerView> d;
  private a.a e;
  private TextView f;
  private MinsuAppointmentPhotographerTimeBean g;
  private List<String> h;
  private List<String> i;
  private TimePickerView j;
  private TimePickerView k;
  
  public c(Context paramContext, String paramString, a.a parama, MinsuAppointmentPhotographerTimeBean paramMinsuAppointmentPhotographerTimeBean)
  {
    super(paramContext, 2131427692);
    this.a = paramContext;
    this.g = paramMinsuAppointmentPhotographerTimeBean;
    if (paramString == null) {}
    for (this.c = "";; this.c = paramString)
    {
      this.e = parama;
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
    int n = 0;
    this.f = ((TextView)paramView.findViewById(2131693706));
    this.h = new ArrayList();
    this.i = new ArrayList();
    int m = 0;
    while (m < this.g.getTimes().size())
    {
      this.h.add(((MinsuAppointmentPhotographerTimeBean.TimesBean)this.g.getTimes().get(m)).getMonthAndDay());
      m += 1;
    }
    this.i.addAll(((MinsuAppointmentPhotographerTimeBean.TimesBean)this.g.getTimes().get(0)).getTime());
    m = n;
    while (m < 4)
    {
      this.h.add("");
      this.i.add("");
      m += 1;
    }
    this.b = ((LinearLayout)paramView.findViewById(2131693707));
    b();
    this.f.setText(this.c);
  }
  
  private void b()
  {
    this.d = new ArrayList();
    this.b.removeAllViews();
    ViewGroup localViewGroup = (ViewGroup)LayoutInflater.from(this.a).inflate(2130903779, this.b, false);
    this.j = ((TimePickerView)localViewGroup.findViewById(2131693708));
    this.j.setTag(Integer.valueOf(0));
    ArrayList localArrayList = new ArrayList();
    localArrayList.addAll(this.h);
    this.j.setData(localArrayList);
    if (localArrayList.size() > 0) {
      this.j.setCurrentText((String)localArrayList.get(0));
    }
    this.d.add(this.j);
    localViewGroup.removeAllViews();
    this.b.addView(this.j);
    localViewGroup = (ViewGroup)LayoutInflater.from(this.a).inflate(2130903779, this.b, false);
    this.k = ((TimePickerView)localViewGroup.findViewById(2131693708));
    this.k.setTag(Integer.valueOf(1));
    localArrayList = new ArrayList();
    localArrayList.addAll(this.i);
    this.k.setData(localArrayList);
    if (localArrayList.size() > 0) {
      this.k.setCurrentText((String)localArrayList.get(0));
    }
    this.d.add(this.k);
    localViewGroup.removeAllViews();
    this.b.addView(this.k);
    this.j.setOnSelectListener(new TimePickerView.b()
    {
      public void onSelect(String paramAnonymousString, int paramAnonymousInt)
      {
        if ((c.f(c.this).getTimes().size() > paramAnonymousInt) && (paramAnonymousInt >= 0))
        {
          c.d(c.this).clear();
          c.d(c.this).addAll(((MinsuAppointmentPhotographerTimeBean.TimesBean)c.f(c.this).getTimes().get(paramAnonymousInt)).getTime());
          c.d(c.this).add("");
          c.d(c.this).add("");
          c.d(c.this).add("");
          c.d(c.this).add("");
          paramAnonymousString = new ArrayList();
          paramAnonymousString.addAll(c.d(c.this));
          c.g(c.this).setData(paramAnonymousString);
          c.g(c.this).setCurrentText((String)paramAnonymousString.get(0));
        }
      }
    });
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
        paramAnonymousView = new int[2];
        int i = 0;
        if (i < 2)
        {
          if (TextUtils.isEmpty(((TimePickerView)c.a(c.this).get(i)).getCurrentText()))
          {
            g.textToast(c.b(c.this), "您第" + (i + 1) + "个选择框中未选择");
            c.this.dismiss();
            return;
          }
          paramAnonymousView[i] = 0;
          String str = ((TimePickerView)c.a(c.this).get(i)).getCurrentText();
          int j = 0;
          label112:
          if (j < c.c(c.this).size())
          {
            if (((String)c.c(c.this).get(j)).equals(str)) {
              paramAnonymousView[i] = j;
            }
          }
          else {
            j = 0;
          }
          for (;;)
          {
            if (j < c.d(c.this).size())
            {
              if (((String)c.d(c.this).get(j)).equals(str)) {
                paramAnonymousView[i] = j;
              }
            }
            else
            {
              i += 1;
              break;
              j += 1;
              break label112;
            }
            j += 1;
          }
        }
        if (c.e(c.this) != null) {
          c.e(c.this).callback(paramAnonymousView);
        }
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
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/dialog/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */