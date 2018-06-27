package org.greenrobot.eventbus.util;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import org.greenrobot.eventbus.c;

public class ErrorDialogFragments
{
  public static int a = 0;
  public static Class<?> b;
  
  public static Dialog createDialog(Context paramContext, Bundle paramBundle, DialogInterface.OnClickListener paramOnClickListener)
  {
    paramContext = new AlertDialog.Builder(paramContext);
    paramContext.setTitle(paramBundle.getString("de.greenrobot.eventbus.errordialog.title"));
    paramContext.setMessage(paramBundle.getString("de.greenrobot.eventbus.errordialog.message"));
    if (a != 0) {
      paramContext.setIcon(a);
    }
    paramContext.setPositiveButton(17039370, paramOnClickListener);
    return paramContext.create();
  }
  
  public static void handleOnClick(DialogInterface paramDialogInterface, int paramInt, Activity paramActivity, Bundle paramBundle)
  {
    if (b != null) {}
    try
    {
      paramDialogInterface = b.newInstance();
      ErrorDialogManager.a.a.a().post(paramDialogInterface);
      if ((paramBundle.getBoolean("de.greenrobot.eventbus.errordialog.finish_after_dialog", false)) && (paramActivity != null)) {
        paramActivity.finish();
      }
      return;
    }
    catch (Exception paramDialogInterface)
    {
      throw new RuntimeException("Event cannot be constructed", paramDialogInterface);
    }
  }
  
  @TargetApi(11)
  public static class Honeycomb
    extends android.app.DialogFragment
    implements DialogInterface.OnClickListener
  {
    @Instrumented
    public void onClick(DialogInterface paramDialogInterface, int paramInt)
    {
      VdsAgent.onClick(this, paramDialogInterface, paramInt);
      ErrorDialogFragments.handleOnClick(paramDialogInterface, paramInt, getActivity(), getArguments());
    }
    
    public Dialog onCreateDialog(Bundle paramBundle)
    {
      return ErrorDialogFragments.createDialog(getActivity(), getArguments(), this);
    }
  }
  
  public static class Support
    extends android.support.v4.app.DialogFragment
    implements DialogInterface.OnClickListener
  {
    @Instrumented
    public void onClick(DialogInterface paramDialogInterface, int paramInt)
    {
      VdsAgent.onClick(this, paramDialogInterface, paramInt);
      ErrorDialogFragments.handleOnClick(paramDialogInterface, paramInt, getActivity(), getArguments());
    }
    
    public Dialog onCreateDialog(Bundle paramBundle)
    {
      return ErrorDialogFragments.createDialog(getActivity(), getArguments(), this);
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes4-dex2jar.jar!/org/greenrobot/eventbus/util/ErrorDialogFragments.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */