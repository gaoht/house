package com.ziroom.ziroomcustomer.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.util.u;
import java.util.List;

public class d
  extends Dialog
{
  private Context a;
  private ListView b;
  private List<String> c;
  private Button d;
  private a e;
  
  public d(Context paramContext, List<String> paramList, a parama)
  {
    super(paramContext, 2131427692);
    this.a = paramContext;
    this.c = paramList;
    this.e = parama;
    setDefaultSetting();
  }
  
  private void a()
  {
    View localView = LayoutInflater.from(this.a).inflate(2130903780, null);
    a(localView);
    setContentView(localView);
  }
  
  private void a(View paramView)
  {
    this.b = ((ListView)paramView.findViewById(2131689817));
    this.d = ((Button)paramView.findViewById(2131690460));
    this.b.setAdapter(new ArrayAdapter(this.a, 2130904186, this.c));
    this.b.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      @Instrumented
      public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        VdsAgent.onItemClick(this, paramAnonymousAdapterView, paramAnonymousView, paramAnonymousInt, paramAnonymousLong);
        u.d("", "==========*******" + paramAnonymousInt);
        d.b(d.this).callback(paramAnonymousInt, (String)d.a(d.this).get(paramAnonymousInt));
        d.this.dismiss();
      }
    });
    this.d.setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        d.this.dismiss();
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
    WindowManager.LayoutParams localLayoutParams = localWindow.getAttributes();
    localLayoutParams.width = -1;
    localWindow.setAttributes(localLayoutParams);
    localWindow.getDecorView().setBackgroundColor(-1);
    localWindow.setGravity(80);
  }
  
  public static abstract interface a
  {
    public abstract void callback(int paramInt, String paramString);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/dialog/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */