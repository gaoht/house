package com.ziroom.ziroomcustomer.findhouse.view;

import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.model.BookingOrderTextEntity;

public class BookingOrderDialog
  extends DialogFragment
  implements View.OnClickListener
{
  private BookingOrderTextEntity a;
  private a b;
  
  public static BookingOrderDialog getInstance(BookingOrderTextEntity paramBookingOrderTextEntity)
  {
    Bundle localBundle = new Bundle();
    localBundle.putSerializable("order", paramBookingOrderTextEntity);
    paramBookingOrderTextEntity = new BookingOrderDialog();
    paramBookingOrderTextEntity.setArguments(localBundle);
    return paramBookingOrderTextEntity;
  }
  
  @Instrumented
  public void onClick(View paramView)
  {
    VdsAgent.onClick(this, paramView);
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131693192: 
      if (this.b == null)
      {
        dismiss();
        return;
      }
      this.b.comfirmSign();
      return;
    }
    dismiss();
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    getDialog().getWindow().requestFeature(1);
    this.a = ((BookingOrderTextEntity)getArguments().getSerializable("order"));
    paramLayoutInflater = paramLayoutInflater.inflate(2130903660, null);
    paramViewGroup = (TextView)paramLayoutInflater.findViewById(2131693190);
    paramBundle = (TextView)paramLayoutInflater.findViewById(2131693192);
    TextView localTextView = (TextView)paramLayoutInflater.findViewById(2131693191);
    if (this.a == null) {
      return paramLayoutInflater;
    }
    paramViewGroup.setText(this.a.getContent1() + this.a.getDate() + this.a.getContent2());
    paramBundle.setText("确定");
    localTextView.setText("取消");
    paramBundle.setOnClickListener(this);
    localTextView.setOnClickListener(this);
    return paramLayoutInflater;
  }
  
  public void setOnComfirmSignListener(a parama)
  {
    this.b = parama;
  }
  
  public static abstract interface a
  {
    public abstract void comfirmSign();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/findhouse/view/BookingOrderDialog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */