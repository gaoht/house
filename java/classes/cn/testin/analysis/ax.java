package cn.testin.analysis;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

@TargetApi(11)
public class ax
  extends DialogFragment
{
  private gs a;
  private gq b;
  
  private View a()
  {
    Activity localActivity = getActivity();
    FrameLayout localFrameLayout = new FrameLayout(localActivity);
    this.a = new gs(localActivity);
    Object localObject = new ViewGroup.LayoutParams(-1, -1);
    localFrameLayout.addView(this.a, (ViewGroup.LayoutParams)localObject);
    localObject = new LinearLayout(localActivity);
    ((LinearLayout)localObject).setOrientation(1);
    localFrameLayout.addView((View)localObject, new ViewGroup.LayoutParams(-1, -2));
    TextView localTextView = new TextView(localActivity);
    localTextView.setText("扫描版本二维码");
    localTextView.setTextColor(-1);
    localTextView.setGravity(1);
    localTextView.setTextSize(2, 18.0F);
    localTextView.setPadding(0, al.a(localActivity, 20.0F), 0, 0);
    ((LinearLayout)localObject).addView(localTextView);
    localTextView = new TextView(localActivity);
    localTextView.setTextColor(-1);
    localTextView.setGravity(1);
    localTextView.setText("请将取景框对准二维码即可自动扫描");
    localTextView.setTextSize(2, 14.0F);
    localTextView.setPadding(0, al.a(localActivity, 10.0F), 0, 0);
    ((LinearLayout)localObject).addView(localTextView);
    if (this.b != null) {
      this.a.setDelegate(this.b);
    }
    return localFrameLayout;
  }
  
  public void a(gq paramgq)
  {
    this.b = paramgq;
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    getDialog().requestWindowFeature(1);
    return a();
  }
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    this.a.h();
    super.onDismiss(paramDialogInterface);
  }
  
  public void onPause()
  {
    this.a.d();
    super.onPause();
  }
  
  public void onResume()
  {
    super.onResume();
    this.a.c();
    this.a.a();
    this.a.e();
  }
  
  public void onStart()
  {
    super.onStart();
    Window localWindow = getDialog().getWindow();
    localWindow.setBackgroundDrawable(new ColorDrawable(0));
    WindowManager.LayoutParams localLayoutParams = localWindow.getAttributes();
    localLayoutParams.dimAmount = 0.0F;
    localWindow.setAttributes(localLayoutParams);
    localWindow.setLayout(-1, -1);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/testin/analysis/ax.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */