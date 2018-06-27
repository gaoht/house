package cn.testin.analysis;

import android.annotation.TargetApi;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.Toast;
import com.growingio.android.sdk.agent.VdsAgent;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@TargetApi(11)
public class bd
  extends DialogFragment
  implements bn, fh
{
  private final int a = 1000;
  private bk b;
  private bl c;
  private bm d;
  private bm e;
  private cu f;
  private int g;
  private Handler h = new Handler();
  private Runnable i;
  private ExecutorService j = Executors.newFixedThreadPool(1);
  
  private void a(String paramString)
  {
    if (Thread.currentThread() == this.h.getLooper().getThread())
    {
      paramString = Toast.makeText(a.d, paramString, 0);
      if (!(paramString instanceof Toast))
      {
        paramString.show();
        return;
      }
      VdsAgent.showToast((Toast)paramString);
      return;
    }
    this.h.post(new bi(this, paramString));
  }
  
  private View b()
  {
    Object localObject = getActivity();
    int k = al.a((Context)localObject, 20.0F);
    LinearLayout localLinearLayout1 = new LinearLayout((Context)localObject);
    localLinearLayout1.setPadding(0, k, 0, k);
    localLinearLayout1.setOrientation(1);
    localLinearLayout1.setBackgroundDrawable(c());
    localLinearLayout1.setGravity(1);
    LinearLayout localLinearLayout2 = new LinearLayout((Context)localObject);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(al.a((Context)localObject, 250.0F), -2);
    localLinearLayout2.setGravity(1);
    localLinearLayout1.addView(localLinearLayout2, localLayoutParams);
    this.d = new bm((Context)localObject);
    localLinearLayout2.addView(this.d);
    this.e = new bm((Context)localObject);
    localObject = new LinearLayout.LayoutParams(-2, -2);
    ((LinearLayout.LayoutParams)localObject).setMargins(k, 0, 0, 0);
    localLinearLayout2.addView(this.e, (ViewGroup.LayoutParams)localObject);
    this.d.a(0, "可视化");
    this.e.a(0, "集成调试");
    this.d.setOnSwitchClickListener(this);
    this.e.setOnSwitchClickListener(this);
    b(this.g);
    return localLinearLayout1;
  }
  
  private void b(int paramInt)
  {
    this.g = paramInt;
    if (this.g != 2) {
      this.h.removeCallbacks(this.i);
    }
    if (this.c != null) {
      this.c.a(paramInt);
    }
    if (Thread.currentThread() == this.h.getLooper().getThread())
    {
      d();
      return;
    }
    this.h.post(new be(this));
  }
  
  private Drawable c()
  {
    float f1 = al.a(getActivity(), 5.0F);
    ShapeDrawable localShapeDrawable = new ShapeDrawable(new RoundRectShape(new float[] { f1, f1, f1, f1, f1, f1, f1, f1 }, null, null));
    localShapeDrawable.getPaint().setColor(Color.parseColor("#b2000000"));
    return localShapeDrawable;
  }
  
  private void d()
  {
    if ((this.e == null) || (this.d == null) || (isRemoving())) {
      return;
    }
    String str;
    switch (this.g)
    {
    default: 
      str = "可视化";
      this.e.setVisibility(0);
      setCancelable(true);
    }
    for (;;)
    {
      this.d.a(this.g, str);
      return;
      str = "连接中";
      this.e.setVisibility(8);
      setCancelable(false);
      continue;
      str = "连接成功\n点击断开";
      this.e.setVisibility(8);
      setCancelable(true);
    }
  }
  
  private void e()
  {
    if (this.f != null) {
      this.f.b();
    }
  }
  
  private void f()
  {
    if (this.f != null) {
      this.f.c();
    }
  }
  
  private void g()
  {
    ay.a(getActivity()).a("请检查cn.testin.analysis.TesterActivity是否在AndroidManifest.xml文件中配置").a();
  }
  
  private void h()
  {
    this.j.execute(new bj(this));
  }
  
  public void a()
  {
    this.j.execute(new bf(this));
  }
  
  public void a(int paramInt)
  {
    this.j.execute(new bh(this, paramInt));
  }
  
  public void a(View paramView, int paramInt)
  {
    if (paramView == this.d) {
      switch (paramInt)
      {
      }
    }
    while (paramView != this.e)
    {
      return;
      f();
      return;
      b(1);
      h();
      e();
      return;
    }
    dismiss();
    try
    {
      startActivity(new Intent(getActivity(), TesterActivity.class));
      return;
    }
    catch (ActivityNotFoundException paramView)
    {
      paramView.printStackTrace();
      g();
    }
  }
  
  public void a(bk parambk)
  {
    this.b = parambk;
  }
  
  public void a(bl parambl)
  {
    this.c = parambl;
  }
  
  public void a(cu paramcu)
  {
    this.f = paramcu;
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    getDialog().requestWindowFeature(1);
    return b();
  }
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    super.onDismiss(paramDialogInterface);
    this.e = null;
    this.d = null;
    this.h.removeCallbacks(this.i);
    if (this.b != null) {
      this.b.a();
    }
  }
  
  public void onStart()
  {
    super.onStart();
    Window localWindow = getDialog().getWindow();
    localWindow.setBackgroundDrawable(new ColorDrawable(0));
    WindowManager.LayoutParams localLayoutParams = localWindow.getAttributes();
    localLayoutParams.dimAmount = 0.0F;
    localWindow.setAttributes(localLayoutParams);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/testin/analysis/bd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */