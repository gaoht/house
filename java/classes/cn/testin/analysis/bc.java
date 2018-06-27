package cn.testin.analysis;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.ProgressBar;
import com.growingio.android.sdk.agent.VdsAgent;

@TargetApi(11)
public class bc
  extends DialogFragment
{
  private static bc a;
  
  public static void a()
  {
    a.dismiss();
  }
  
  public static void a(Activity paramActivity)
  {
    if (a == null) {
      a = new bc();
    }
    bc localbc = a;
    paramActivity = paramActivity.getFragmentManager();
    if (!(localbc instanceof DialogFragment))
    {
      localbc.show(paramActivity, "LoadingFragment");
      return;
    }
    VdsAgent.showDialogFragment((DialogFragment)localbc, paramActivity, "LoadingFragment");
  }
  
  private View b()
  {
    Object localObject = getActivity();
    int i = al.a((Context)localObject, 15.0F);
    localObject = new ProgressBar((Context)localObject);
    ((ProgressBar)localObject).setIndeterminate(false);
    ((ProgressBar)localObject).setBackgroundDrawable(null);
    ((ProgressBar)localObject).setProgressDrawable(null);
    ((ProgressBar)localObject).setPadding(i, i, i, i);
    ((ProgressBar)localObject).setBackgroundDrawable(c());
    setCancelable(false);
    return (View)localObject;
  }
  
  private Drawable c()
  {
    float f = al.a(getActivity(), 5.0F);
    ShapeDrawable localShapeDrawable = new ShapeDrawable(new RoundRectShape(new float[] { f, f, f, f, f, f, f, f }, null, null));
    localShapeDrawable.getPaint().setColor(Color.parseColor("#b2000000"));
    return localShapeDrawable;
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    getDialog().requestWindowFeature(1);
    return b();
  }
  
  public void onStart()
  {
    super.onStart();
    Window localWindow = getDialog().getWindow();
    localWindow.setBackgroundDrawable(null);
    WindowManager.LayoutParams localLayoutParams = localWindow.getAttributes();
    localLayoutParams.dimAmount = 0.0F;
    localWindow.setAttributes(localLayoutParams);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/testin/analysis/bc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */