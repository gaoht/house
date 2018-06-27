package com.ziroom.ziroomcustomer.minsu.activity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import com.freelxl.baselibrary.f.g;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.hyphenate.chat.EMClient;
import com.hyphenate.chat.EMGroupManager;
import com.hyphenate.chat.EMGroupManager.EMGroupStyle;
import com.hyphenate.chat.EMGroupOptions;
import com.hyphenate.exceptions.HyphenateException;
import com.ziroom.ziroomcustomer.base.BaseActivity;

public class MinsuTestActivity
  extends BaseActivity
  implements View.OnClickListener
{
  private void a()
  {
    findViewById(2131691699).setOnClickListener(this);
    findViewById(2131691701).setOnClickListener(this);
    findViewById(2131691703).setOnClickListener(this);
  }
  
  private void b()
  {
    String str1 = VdsAgent.trackEditTextSilent((EditText)findViewById(2131689810)).toString();
    if (TextUtils.isEmpty(str1))
    {
      g.textToast(this, " name = null");
      return;
    }
    String str2 = VdsAgent.trackEditTextSilent((EditText)findViewById(2131691698)).toString();
    EMGroupOptions localEMGroupOptions = new EMGroupOptions();
    localEMGroupOptions.maxUsers = 300;
    localEMGroupOptions.inviteNeedConfirm = false;
    localEMGroupOptions.style = EMGroupManager.EMGroupStyle.EMGroupStylePrivateMemberCanInvite;
    try
    {
      EMClient.getInstance().groupManager().createGroup(str1, str2, new String[] { "app_f44f328f-ed58-4f45-8e6a-6ab8f60b8b0a" }, "test ssssss", localEMGroupOptions);
      return;
    }
    catch (HyphenateException localHyphenateException)
    {
      localHyphenateException.printStackTrace();
    }
  }
  
  private void e()
  {
    String str = VdsAgent.trackEditTextSilent((EditText)findViewById(2131691700)).toString();
    if (TextUtils.isEmpty(str))
    {
      g.textToast(this, " id = null");
      return;
    }
    try
    {
      EMClient.getInstance().groupManager().leaveGroup(str);
      return;
    }
    catch (HyphenateException localHyphenateException)
    {
      localHyphenateException.printStackTrace();
    }
  }
  
  private void f()
  {
    String str = VdsAgent.trackEditTextSilent((EditText)findViewById(2131691702)).toString();
    if (TextUtils.isEmpty(str))
    {
      g.textToast(this, " id = null");
      return;
    }
    try
    {
      EMClient.getInstance().groupManager().destroyGroup(str);
      return;
    }
    catch (HyphenateException localHyphenateException)
    {
      localHyphenateException.printStackTrace();
    }
  }
  
  private void g()
  {
    String str1 = VdsAgent.trackEditTextSilent((EditText)findViewById(2131691704)).toString();
    String str2 = VdsAgent.trackEditTextSilent((EditText)findViewById(2131691705)).toString();
    if (TextUtils.isEmpty(str1))
    {
      g.textToast(this, " id = null");
      return;
    }
    try
    {
      EMClient.getInstance().groupManager().removeUserFromGroup(str1, str2);
      return;
    }
    catch (HyphenateException localHyphenateException)
    {
      localHyphenateException.printStackTrace();
    }
  }
  
  @Instrumented
  public void onClick(View paramView)
  {
    VdsAgent.onClick(this, paramView);
    switch (paramView.getId())
    {
    case 2131691700: 
    case 2131691702: 
    case 2131691704: 
    case 2131691705: 
    default: 
      return;
    case 2131691699: 
      b();
      return;
    case 2131691701: 
      e();
      return;
    case 2131691703: 
      f();
      return;
    }
    g();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903334);
    a();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/activity/MinsuTestActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */