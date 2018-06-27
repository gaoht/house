package com.ziroom.ziroomcustomer.intellect;

import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.commonlibrary.widget.gridpasswordview.GridPasswordView;

public class IntellectDialogFragment
  extends DialogFragment
{
  View.OnClickListener a;
  int b = -1;
  private String c;
  private GridPasswordView d;
  
  public static IntellectDialogFragment newInstance(String paramString)
  {
    IntellectDialogFragment localIntellectDialogFragment = new IntellectDialogFragment();
    Bundle localBundle = new Bundle();
    localBundle.putString("msg", paramString);
    localIntellectDialogFragment.setArguments(localBundle);
    return localIntellectDialogFragment;
  }
  
  public String getPwd()
  {
    return this.d.getPassWord();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.c = getArguments().getString("msg");
    setStyle(1, 2131427587);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2130903803, paramViewGroup, false);
    paramViewGroup = (TextView)paramLayoutInflater.findViewById(2131689850);
    this.d = ((GridPasswordView)paramLayoutInflater.findViewById(2131691708));
    this.d.setPasswordVisibility(true);
    if (this.c != null) {
      paramViewGroup.setText(this.c);
    }
    paramViewGroup = (Button)paramLayoutInflater.findViewById(2131692249);
    paramBundle = (Button)paramLayoutInflater.findViewById(2131690460);
    paramViewGroup.setOnClickListener(this.a);
    if (this.b != IntellectLockFragment.c) {
      this.d.setVisibility(8);
    }
    paramBundle.setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        IntellectDialogFragment.this.dismiss();
      }
    });
    return paramLayoutInflater;
  }
  
  public void setDialogStyle(int paramInt)
  {
    this.b = paramInt;
  }
  
  public void setOnclickListener(View.OnClickListener paramOnClickListener)
  {
    this.a = paramOnClickListener;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/intellect/IntellectDialogFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */