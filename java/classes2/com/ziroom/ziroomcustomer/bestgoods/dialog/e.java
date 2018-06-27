package com.ziroom.ziroomcustomer.bestgoods.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.freelxl.baselibrary.f.c;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.bestgoods.model.at;
import com.ziroom.ziroomcustomer.bestgoods.model.at.a;
import com.ziroom.ziroomcustomer.e.c.m;
import com.ziroom.ziroomcustomer.util.ac;
import java.util.List;

public class e
  extends Dialog
{
  private Context a;
  private ListView b;
  private TextView c;
  private List<at.a> d;
  private String e;
  private TextView f;
  
  public e(Context paramContext, String paramString)
  {
    super(paramContext, 2131427591);
    this.a = paramContext;
    this.e = paramString;
    setDefaultSetting();
  }
  
  private void a()
  {
    View localView = LayoutInflater.from(this.a).inflate(2130903867, null);
    this.b = ((ListView)localView.findViewById(2131693910));
    this.c = ((TextView)localView.findViewById(2131693688));
    this.f = ((TextView)localView.findViewById(2131689541));
    b();
    setContentView(localView);
  }
  
  private void b()
  {
    this.c.setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        e.this.dismiss();
      }
    });
    c();
  }
  
  private void c()
  {
    com.ziroom.ziroomcustomer.e.n.requestYouPinPromise(this.a, this.e, new com.ziroom.ziroomcustomer.e.a.a(this.a, new m(at.class, new com.ziroom.ziroomcustomer.e.c.a.e()))
    {
      public void onSuccess(int paramAnonymousInt, at paramAnonymousat)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousat);
        if (paramAnonymousat != null)
        {
          e.a(e.this).setText(paramAnonymousat.getProductSerTitle());
          e.a(e.this, paramAnonymousat.getProductSerTypeList());
          e.b(e.this).setAdapter(new e.a(e.this));
        }
      }
    });
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
    localWindow.setWindowAnimations(2131427962);
    WindowManager.LayoutParams localLayoutParams = localWindow.getAttributes();
    localLayoutParams.width = -1;
    localLayoutParams.height = (ac.getScreenHeight(this.a) - com.ziroom.ziroomcustomer.util.n.dip2px(this.a, 150.0F));
    localWindow.setAttributes(localLayoutParams);
    localWindow.getDecorView().setBackgroundColor(-1);
    localWindow.setGravity(80);
  }
  
  public class a
    extends BaseAdapter
  {
    public a() {}
    
    public int getCount()
    {
      if (e.c(e.this) == null) {
        return 0;
      }
      return e.c(e.this).size();
    }
    
    public Object getItem(int paramInt)
    {
      return null;
    }
    
    public long getItemId(int paramInt)
    {
      return 0L;
    }
    
    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      if (paramView == null)
      {
        paramView = View.inflate(e.d(e.this), 2130904513, null);
        paramViewGroup = new a();
        paramViewGroup.b = ((SimpleDraweeView)paramView.findViewById(2131693178));
        paramViewGroup.a = ((TextView)paramView.findViewById(2131693945));
        paramView.setTag(paramViewGroup);
      }
      for (;;)
      {
        paramViewGroup.b.setController(c.frescoController(((at.a)e.c(e.this).get(paramInt)).getServiceUrl()));
        paramViewGroup.a.setText(((at.a)e.c(e.this).get(paramInt)).getServiceText());
        return paramView;
        paramViewGroup = (a)paramView.getTag();
      }
    }
    
    public class a
    {
      public TextView a;
      public SimpleDraweeView b;
      
      public a() {}
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/bestgoods/dialog/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */