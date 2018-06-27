package com.ziroom.ziroomcustomer.minsu.dialog;

import android.app.Dialog;
import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.util.ac;

public class a
  implements View.OnClickListener
{
  private Context a;
  private String b;
  private a c;
  private Dialog d;
  
  public a(Context paramContext, String paramString)
  {
    this.a = paramContext;
    this.b = paramString;
    a();
  }
  
  private void a()
  {
    this.d = new Dialog(this.a, 2131427825);
    View localView = LayoutInflater.from(this.a).inflate(2130903815, null);
    this.d.requestWindowFeature(1);
    this.d.setContentView(localView);
    localView.getLayoutParams().width = (ac.getScreenWidth(this.a) * 2 / 3);
    ((TextView)this.d.findViewById(2131691097)).setText(this.b);
    this.d.findViewById(2131693804).setOnClickListener(this);
    this.d.findViewById(2131693820).setOnClickListener(this);
    setTitle("");
  }
  
  public void dismiss()
  {
    this.d.dismiss();
  }
  
  public TextView getContentTextView()
  {
    return (TextView)this.d.findViewById(2131691097);
  }
  
  public boolean isShow()
  {
    return this.d.isShowing();
  }
  
  @Instrumented
  public void onClick(View paramView)
  {
    VdsAgent.onClick(this, paramView);
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      this.d.dismiss();
      return;
      if (this.c != null)
      {
        this.c.onCancel();
        continue;
        if (this.c != null) {
          this.c.onSure();
        }
      }
    }
  }
  
  public a setBtnCancelText(String paramString)
  {
    ((TextView)this.d.findViewById(2131693804)).setText(paramString);
    return this;
  }
  
  public a setBtnCancelTextColor(int paramInt)
  {
    ((TextView)this.d.findViewById(2131693804)).setTextColor(paramInt);
    return this;
  }
  
  public a setBtnOkText(String paramString)
  {
    ((TextView)this.d.findViewById(2131693820)).setText(paramString);
    return this;
  }
  
  public a setBtnOkTextColor(int paramInt)
  {
    ((TextView)this.d.findViewById(2131693820)).setTextColor(paramInt);
    return this;
  }
  
  public a setCancelable(boolean paramBoolean)
  {
    this.d.setCancelable(paramBoolean);
    return this;
  }
  
  public a setContent(String paramString)
  {
    this.b = paramString;
    ((TextView)this.d.findViewById(2131691097)).setText(paramString);
    return this;
  }
  
  public a setContentColor(int paramInt)
  {
    ((TextView)this.d.findViewById(2131691097)).setTextColor(paramInt);
    return this;
  }
  
  public a setContextTextSize(int paramInt)
  {
    ((TextView)this.d.findViewById(2131691097)).setTextSize(2, paramInt);
    return this;
  }
  
  public a setOnConfirmListener(a parama)
  {
    this.c = parama;
    return this;
  }
  
  public a setTitle(String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || ("null".equalsIgnoreCase(paramString)))
    {
      this.d.findViewById(2131691597).setVisibility(8);
      return this;
    }
    this.d.findViewById(2131691597).setVisibility(0);
    ((TextView)this.d.findViewById(2131689533)).setText(paramString);
    this.d.setTitle("标题栏");
    return this;
  }
  
  public a setTitleColor(int paramInt)
  {
    ((TextView)this.d.findViewById(2131689533)).setTextColor(paramInt);
    return this;
  }
  
  public void show()
  {
    Dialog localDialog = this.d;
    if (!(localDialog instanceof Dialog))
    {
      localDialog.show();
      return;
    }
    VdsAgent.showDialog((Dialog)localDialog);
  }
  
  public a showCancel(boolean paramBoolean)
  {
    int j = 0;
    View localView = this.d.findViewById(2131693804);
    if (paramBoolean)
    {
      i = 0;
      localView.setVisibility(i);
      localView = this.d.findViewById(2131689578);
      if (!paramBoolean) {
        break label56;
      }
    }
    label56:
    for (int i = j;; i = 8)
    {
      localView.setVisibility(i);
      return this;
      i = 8;
      break;
    }
  }
  
  public static abstract interface a
  {
    public abstract void onCancel();
    
    public abstract void onSure();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/dialog/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */