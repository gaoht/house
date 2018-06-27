package com.ziroom.ziroomcustomer.minsu.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.widget.TimePickerView;
import com.ziroom.ziroomcustomer.widget.TimePickerView.b;
import java.util.List;

public class g
  extends Dialog
{
  private Context a;
  private a b;
  private String c = "";
  private TimePickerView d;
  private List<String> e;
  
  public g(Context paramContext, List<String> paramList, a parama)
  {
    super(paramContext, 2131427692);
    this.a = paramContext;
    this.b = parama;
    this.e = paramList;
  }
  
  private void a()
  {
    View localView = LayoutInflater.from(this.a).inflate(2130903822, null);
    a(localView);
    setListener(localView);
    setContentView(localView);
  }
  
  private void a(View paramView)
  {
    this.d = ((TimePickerView)paramView.findViewById(2131693833));
    a(this.e);
    this.c = ((String)this.e.get(0));
    this.d.setData(this.e);
    this.d.setOnSelectListener(new TimePickerView.b()
    {
      public void onSelect(String paramAnonymousString, int paramAnonymousInt)
      {
        g.a(g.this, paramAnonymousString);
      }
    });
  }
  
  private void a(List<String> paramList)
  {
    paramList.add("");
    paramList.add("");
    paramList.add("");
    paramList.add("");
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
        if (TextUtils.isEmpty(g.a(g.this)))
        {
          com.freelxl.baselibrary.f.g.textToast(g.b(g.this), "您还未选择");
          g.this.dismiss();
          return;
        }
        g.c(g.this).onAuthInfoSelected(g.a(g.this));
        g.this.dismiss();
      }
    });
    paramView.setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        g.this.dismiss();
      }
    });
  }
  
  public static abstract interface a
  {
    public abstract void onAuthInfoSelected(String paramString);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/dialog/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */