package com.ziroom.ziroomcustomer.my.widget;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.CheckBox;
import android.widget.TextView;
import com.freelxl.baselibrary.f.g;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;

public class InvoiceOpenTipsDialog
  extends DialogFragment
  implements View.OnClickListener
{
  private Context a;
  private View b;
  private TextView c;
  private CheckBox d;
  
  private void a() {}
  
  private void b()
  {
    this.c = ((TextView)this.b.findViewById(2131693809));
    this.d = ((CheckBox)this.b.findViewById(2131690215));
    this.c.setOnClickListener(this);
  }
  
  private void c()
  {
    getDialog().requestWindowFeature(1);
    getDialog().getWindow().setGravity(17);
    getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(0));
    getDialog().getWindow().getDecorView().setPadding(0, 0, 0, 0);
    getDialog().getWindow().setLayout(-1, -1);
    getDialog().setCanceledOnTouchOutside(true);
    getDialog().setCancelable(true);
  }
  
  public static InvoiceOpenTipsDialog getInstance(String paramString1, String paramString2)
  {
    InvoiceOpenTipsDialog localInvoiceOpenTipsDialog = new InvoiceOpenTipsDialog();
    Bundle localBundle = new Bundle();
    localBundle.putSerializable("title", paramString1);
    localBundle.putSerializable("content", paramString2);
    localInvoiceOpenTipsDialog.setArguments(localBundle);
    return localInvoiceOpenTipsDialog;
  }
  
  @Instrumented
  public void onClick(View paramView)
  {
    VdsAgent.onClick(this, paramView);
    switch (paramView.getId())
    {
    default: 
      return;
    }
    if (this.d.isChecked())
    {
      dismiss();
      return;
    }
    g.textToast(this.a, "请勾选“我已阅读并悉知开票须知");
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.a = getActivity();
    this.b = paramLayoutInflater.inflate(2130904767, paramViewGroup);
    getArguments();
    c();
    b();
    a();
    return this.b;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/my/widget/InvoiceOpenTipsDialog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */