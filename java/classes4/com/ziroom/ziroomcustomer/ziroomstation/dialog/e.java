package com.ziroom.ziroomcustomer.ziroomstation.dialog;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;

public class e
{
  private Context a;
  private View b;
  private ListView c;
  private PopupWindow d;
  private RelativeLayout e;
  private String[] f;
  private String g;
  private TextView h;
  private b i;
  
  public e(String paramString, b paramb, String[] paramArrayOfString, Context paramContext, View paramView)
  {
    this.a = paramContext;
    this.b = paramView;
    this.f = paramArrayOfString;
    this.g = paramString;
    this.i = paramb;
  }
  
  private void a(View paramView)
  {
    this.c = ((ListView)paramView.findViewById(2131697343));
    this.h = ((TextView)paramView.findViewById(2131689541));
    this.h.setText(this.g);
    this.e = ((RelativeLayout)paramView.findViewById(2131697271));
    paramView = new ArrayAdapter(this.a, 2130904027, 2131690909, this.f);
    this.c.setAdapter(paramView);
    this.c.setOnItemClickListener(new a());
    this.e.setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        e.this.dismiss();
      }
    });
  }
  
  public void dismiss()
  {
    if ((this.d != null) && (this.d.isShowing())) {
      this.d.dismiss();
    }
  }
  
  public PopupWindow getWindow()
  {
    return this.d;
  }
  
  public void showPopwindow()
  {
    Object localObject = ((LayoutInflater)this.a.getSystemService("layout_inflater")).inflate(2130905064, null);
    a((View)localObject);
    this.d = new PopupWindow((View)localObject, -1, -1);
    this.d.setFocusable(true);
    localObject = new ColorDrawable(-167772161);
    this.d.setBackgroundDrawable((Drawable)localObject);
    localObject = this.d;
    View localView = this.b;
    if (!(localObject instanceof PopupWindow)) {
      ((PopupWindow)localObject).showAsDropDown(localView);
    }
    for (;;)
    {
      this.d.setOnDismissListener(new PopupWindow.OnDismissListener()
      {
        public void onDismiss() {}
      });
      return;
      VdsAgent.showAsDropDown((PopupWindow)localObject, localView);
    }
  }
  
  class a
    implements AdapterView.OnItemClickListener
  {
    a() {}
    
    @Instrumented
    public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
    {
      VdsAgent.onItemClick(this, paramAdapterView, paramView, paramInt, paramLong);
      e.a(e.this).onClickStation(paramInt);
      e.this.dismiss();
    }
  }
  
  public static abstract interface b
  {
    public abstract void onClickStation(int paramInt);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes4-dex2jar.jar!/com/ziroom/ziroomcustomer/ziroomstation/dialog/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */