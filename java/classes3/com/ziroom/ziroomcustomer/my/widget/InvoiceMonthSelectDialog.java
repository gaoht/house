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
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.my.model.InvoiceAvailableInfo.MonthInfo;
import com.ziroom.ziroomcustomer.util.ah;
import java.util.ArrayList;
import java.util.Iterator;

public class InvoiceMonthSelectDialog
  extends DialogFragment
  implements View.OnClickListener
{
  ArrayList<InvoiceAvailableInfo.MonthInfo> a;
  private Context b;
  private View c;
  private LinearLayout d;
  private TextView e;
  private ImageView f;
  private ArrayList<Integer> g = new ArrayList();
  private a h;
  
  private void a()
  {
    this.d = ((LinearLayout)this.c.findViewById(2131693808));
    this.e = ((TextView)this.c.findViewById(2131693809));
    this.f = ((ImageView)this.c.findViewById(2131690588));
    int i = 0;
    while (i < this.a.size())
    {
      InvoiceRentMonthCheckBox localInvoiceRentMonthCheckBox = new InvoiceRentMonthCheckBox(this.b);
      localInvoiceRentMonthCheckBox.setContent((InvoiceAvailableInfo.MonthInfo)this.a.get(i));
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, ah.dip2px(this.b, 62.0F));
      localLayoutParams.gravity = 16;
      localInvoiceRentMonthCheckBox.setOnCheckChangeListener(new CompoundButton.OnCheckedChangeListener()
      {
        @Instrumented
        public void onCheckedChanged(CompoundButton paramAnonymousCompoundButton, boolean paramAnonymousBoolean)
        {
          VdsAgent.onCheckedChanged(this, paramAnonymousCompoundButton, paramAnonymousBoolean);
          int j;
          Iterator localIterator;
          if (paramAnonymousBoolean)
          {
            j = InvoiceMonthSelectDialog.a(InvoiceMonthSelectDialog.this).indexOfChild((View)paramAnonymousCompoundButton.getParent());
            localIterator = InvoiceMonthSelectDialog.b(InvoiceMonthSelectDialog.this).iterator();
            do
            {
              if (!localIterator.hasNext()) {
                break;
              }
              i = ((Integer)localIterator.next()).intValue();
            } while ((i != j - 1) && (i != j + 1));
          }
          for (int i = 1;; i = 0)
          {
            if (i == 0)
            {
              localIterator = InvoiceMonthSelectDialog.b(InvoiceMonthSelectDialog.this).iterator();
              while (localIterator.hasNext())
              {
                i = ((Integer)localIterator.next()).intValue();
                if (InvoiceMonthSelectDialog.a(InvoiceMonthSelectDialog.this).getChildAt(i) != paramAnonymousCompoundButton.getParent()) {
                  ((InvoiceRentMonthCheckBox)InvoiceMonthSelectDialog.a(InvoiceMonthSelectDialog.this).getChildAt(i)).setChecked(false);
                }
              }
              InvoiceMonthSelectDialog.b(InvoiceMonthSelectDialog.this).clear();
            }
            InvoiceMonthSelectDialog.b(InvoiceMonthSelectDialog.this).add(Integer.valueOf(j));
            return;
          }
        }
      });
      this.d.addView(localInvoiceRentMonthCheckBox, localLayoutParams);
      i += 1;
    }
    this.e.setOnClickListener(this);
    this.f.setOnClickListener(this);
  }
  
  private void b()
  {
    getDialog().requestWindowFeature(1);
    getDialog().getWindow().setGravity(17);
    getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(0));
    getDialog().getWindow().getDecorView().setPadding(0, 0, 0, 0);
    getDialog().getWindow().setLayout(-1, -1);
    getDialog().setCanceledOnTouchOutside(true);
    getDialog().setCancelable(true);
  }
  
  public static InvoiceMonthSelectDialog getInstance(ArrayList<InvoiceAvailableInfo.MonthInfo> paramArrayList)
  {
    InvoiceMonthSelectDialog localInvoiceMonthSelectDialog = new InvoiceMonthSelectDialog();
    Bundle localBundle = new Bundle();
    localBundle.putSerializable("monthInfoList", paramArrayList);
    localInvoiceMonthSelectDialog.setArguments(localBundle);
    return localInvoiceMonthSelectDialog;
  }
  
  @Instrumented
  public void onClick(View paramView)
  {
    VdsAgent.onClick(this, paramView);
    switch (paramView.getId())
    {
    default: 
    case 2131693809: 
      do
      {
        return;
        paramView = new ArrayList();
        int i = 0;
        while (i < this.d.getChildCount())
        {
          if (((InvoiceRentMonthCheckBox)this.d.getChildAt(i)).isChecked()) {
            paramView.add(this.a.get(i));
          }
          i += 1;
        }
      } while (this.h == null);
      this.h.onMonthSelect(paramView);
      dismiss();
      return;
    }
    dismiss();
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.b = getActivity();
    this.c = paramLayoutInflater.inflate(2130903808, paramViewGroup);
    this.a = ((ArrayList)getArguments().getSerializable("monthInfoList"));
    b();
    a();
    return this.c;
  }
  
  public void setOnMonthSelectListener(a parama)
  {
    this.h = parama;
  }
  
  public static abstract interface a
  {
    public abstract void onMonthSelect(ArrayList<InvoiceAvailableInfo.MonthInfo> paramArrayList);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/my/widget/InvoiceMonthSelectDialog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */