package com.ziroom.ziroomcustomer.account;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.newchat.MessageChooseActivity;
import com.ziroom.ziroomcustomer.util.ac;
import com.ziroom.ziroomcustomer.util.ah;

public class ContactusDialog
  extends DialogFragment
{
  @OnClick({2131693709, 2131693710, 2131693711})
  @Instrumented
  public void onClick(View paramView)
  {
    VdsAgent.onClick(this, paramView);
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131693709: 
      startActivity(new Intent(getContext(), MessageChooseActivity.class));
      dismiss();
      return;
    case 2131693710: 
      ah.callPhone(getContext(), "4001001111,107010");
      dismiss();
      return;
    }
    dismiss();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
  }
  
  public Dialog onCreateDialog(Bundle paramBundle)
  {
    paramBundle = super.onCreateDialog(paramBundle);
    paramBundle.getWindow().requestFeature(1);
    return paramBundle;
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2130903781, paramViewGroup, false);
    ButterKnife.bind(this, paramLayoutInflater);
    paramViewGroup = getDialog().getWindow();
    paramViewGroup.setGravity(80);
    paramViewGroup.setWindowAnimations(2131427944);
    paramViewGroup.getDecorView().setPadding(0, 0, 0, 0);
    paramViewGroup.getDecorView().setBackgroundColor(Color.parseColor("#FFFFFFFF"));
    return paramLayoutInflater;
  }
  
  public void onResume()
  {
    int i = ac.getScreenWidth(getContext());
    getDialog().getWindow().setLayout(i, -2);
    super.onResume();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/account/ContactusDialog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */