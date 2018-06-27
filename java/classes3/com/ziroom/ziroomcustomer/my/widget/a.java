package com.ziroom.ziroomcustomer.my.widget;

import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;

public class a
  extends Dialog
{
  ListView a;
  private Context b;
  private View c;
  private String[] d = { "全部", "可签约", "待释放", "可预订", "已出租" };
  private int[] e = { 1, 2, 3, 4, 5 };
  private b f;
  
  public a(Context paramContext)
  {
    this(paramContext, 2131427567);
  }
  
  public a(Context paramContext, int paramInt)
  {
    super(paramContext, 2131427567);
    this.b = paramContext;
    requestWindowFeature(1);
    Window localWindow = getWindow();
    setCanceledOnTouchOutside(true);
    setCancelable(true);
    WindowManager.LayoutParams localLayoutParams = localWindow.getAttributes();
    localLayoutParams.width = paramContext.getResources().getDisplayMetrics().widthPixels;
    localLayoutParams.gravity = 80;
    localWindow.setAttributes(localLayoutParams);
    this.c = LayoutInflater.from(paramContext).inflate(2130903766, null);
    a();
  }
  
  private void a()
  {
    this.a = ((ListView)this.c.findViewById(2131693675));
    this.a.setAdapter(new a());
    setContentView(this.c);
  }
  
  public void setFilterListener(b paramb)
  {
    this.f = paramb;
  }
  
  class a
    extends BaseAdapter
  {
    LayoutInflater a = LayoutInflater.from(a.a(a.this));
    
    public a() {}
    
    public int getCount()
    {
      return a.b(a.this).length;
    }
    
    public Object getItem(int paramInt)
    {
      return a.b(a.this)[paramInt];
    }
    
    public long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public View getView(final int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      if (paramView == null) {
        paramView = this.a.inflate(2130904123, null);
      }
      for (;;)
      {
        ((TextView)paramView).setText(a.b(a.this)[paramInt]);
        paramView.setOnClickListener(new View.OnClickListener()
        {
          @Instrumented
          public void onClick(View paramAnonymousView)
          {
            VdsAgent.onClick(this, paramAnonymousView);
            if (a.c(a.this) != null) {
              a.c(a.this).onFilter(a.b(a.this)[paramInt], a.d(a.this)[paramInt]);
            }
            a.this.dismiss();
          }
        });
        return paramView;
      }
    }
  }
  
  public static abstract interface b
  {
    public abstract void onFilter(String paramString, int paramInt);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/my/widget/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */