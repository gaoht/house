package com.ziroom.ziroomcustomer.findhouse.widget;

import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.util.ae;
import com.ziroom.ziroomcustomer.util.af;

public class ZhuanBookCodeDialog
  extends DialogFragment
  implements View.OnClickListener
{
  public static ZhuanBookCodeDialog a;
  private Context b;
  private View c;
  private TextView d;
  private TextView e;
  private TextView f;
  private TextView g;
  private TextView h;
  private PasswordInputView i;
  private String j;
  private String k;
  private String l;
  private View.OnClickListener m;
  private a n;
  
  private void a()
  {
    this.d = ((TextView)this.c.findViewById(2131689541));
    this.e = ((TextView)this.c.findViewById(2131690073));
    this.f = ((TextView)this.c.findViewById(2131693772));
    this.g = ((TextView)this.c.findViewById(2131690169));
    this.h = ((TextView)this.c.findViewById(2131689997));
    this.i = ((PasswordInputView)this.c.findViewById(2131693920));
    this.d.setText(this.j);
    this.e.setText(this.k);
    if (ae.isNull(this.l)) {
      this.f.setVisibility(8);
    }
    for (;;)
    {
      this.f.setOnClickListener(this);
      this.g.setOnClickListener(this);
      this.h.setOnClickListener(this);
      return;
      this.f.setVisibility(0);
      this.f.setText(this.l);
    }
  }
  
  private void b()
  {
    getDialog().getWindow().requestFeature(1);
    getDialog().getWindow().getDecorView().setPadding(0, 0, 0, 0);
    float f1 = this.b.getResources().getDisplayMetrics().density;
    int i1 = (int)(this.b.getResources().getDisplayMetrics().widthPixels - f1 * 32.0F * 2.0F);
    getDialog().getWindow().setLayout(i1, -2);
    getDialog().getWindow().getDecorView().setBackgroundColor(this.b.getResources().getColor(2131624576));
  }
  
  public static ZhuanBookCodeDialog getInstance(Bundle paramBundle)
  {
    a = new ZhuanBookCodeDialog();
    a.setArguments(paramBundle);
    return a;
  }
  
  public static ZhuanBookCodeDialog setLinkListener(View.OnClickListener paramOnClickListener)
  {
    a.m = paramOnClickListener;
    return a;
  }
  
  public static ZhuanBookCodeDialog setOKListener(a parama)
  {
    a.n = parama;
    return a;
  }
  
  @Instrumented
  public void onClick(View paramView)
  {
    VdsAgent.onClick(this, paramView);
    switch (paramView.getId())
    {
    default: 
    case 2131693772: 
      do
      {
        return;
      } while (this.m == null);
      this.m.onClick(paramView);
      return;
    case 2131690169: 
      dismiss();
      return;
    }
    String str = this.i.getPassword();
    if ((TextUtils.isEmpty(str)) || (str.length() < 6))
    {
      af.showToast(this.b, "请填写正确的预订码哦～");
      return;
    }
    if (this.n != null) {
      this.n.onClick(paramView, str);
    }
    dismiss();
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.b = getActivity();
    this.c = paramLayoutInflater.inflate(2130903869, paramViewGroup);
    paramLayoutInflater = getArguments();
    if (paramLayoutInflater != null)
    {
      this.j = paramLayoutInflater.getString("title");
      this.k = paramLayoutInflater.getString("desc");
      this.l = paramLayoutInflater.getString("linkStr");
    }
    b();
    a();
    return this.c;
  }
  
  public static abstract interface a
  {
    public abstract void onClick(View paramView, String paramString);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/findhouse/widget/ZhuanBookCodeDialog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */