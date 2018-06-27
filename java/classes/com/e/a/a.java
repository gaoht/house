package com.e.a;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.FrameLayout.LayoutParams;
import java.lang.reflect.Method;

public class a
{
  private static String a;
  private final c b;
  private boolean c;
  private boolean d;
  private boolean e;
  private View f;
  private View g;
  
  static
  {
    if (Build.VERSION.SDK_INT >= 19) {}
    try
    {
      Method localMethod = Class.forName("android.os.SystemProperties").getDeclaredMethod("get", new Class[] { String.class });
      localMethod.setAccessible(true);
      a = (String)localMethod.invoke(null, new Object[] { "qemu.hw.mainkeys" });
      return;
    }
    catch (Throwable localThrowable)
    {
      a = null;
    }
  }
  
  @TargetApi(19)
  public a(Activity paramActivity)
  {
    Window localWindow = paramActivity.getWindow();
    ViewGroup localViewGroup = (ViewGroup)localWindow.getDecorView();
    Object localObject;
    if (Build.VERSION.SDK_INT >= 19) {
      localObject = paramActivity.obtainStyledAttributes(new int[] { 16843759, 16843760 });
    }
    try
    {
      this.c = ((TypedArray)localObject).getBoolean(0, false);
      this.d = ((TypedArray)localObject).getBoolean(1, false);
      ((TypedArray)localObject).recycle();
      localObject = localWindow.getAttributes();
      if ((0x4000000 & ((WindowManager.LayoutParams)localObject).flags) != 0) {
        this.c = true;
      }
      if ((((WindowManager.LayoutParams)localObject).flags & 0x8000000) != 0) {
        this.d = true;
      }
      this.b = new c(paramActivity, this.c, this.d, null);
      if (!this.b.c()) {
        this.d = false;
      }
      if (this.c) {
        a(paramActivity, localViewGroup);
      }
      if (this.d) {
        b(paramActivity, localViewGroup);
      }
      return;
    }
    finally
    {
      ((TypedArray)localObject).recycle();
    }
  }
  
  private void a(Context paramContext, ViewGroup paramViewGroup)
  {
    this.f = new View(paramContext);
    paramContext = new FrameLayout.LayoutParams(-1, this.b.b());
    paramContext.gravity = 48;
    if ((this.d) && (!this.b.a())) {
      paramContext.rightMargin = this.b.e();
    }
    this.f.setLayoutParams(paramContext);
    this.f.setBackgroundColor(-1728053248);
    this.f.setVisibility(8);
    paramViewGroup.addView(this.f);
  }
  
  private void b(Context paramContext, ViewGroup paramViewGroup)
  {
    this.g = new View(paramContext);
    if (this.b.a()) {
      paramContext = new FrameLayout.LayoutParams(-1, this.b.d());
    }
    for (paramContext.gravity = 80;; paramContext.gravity = 5)
    {
      this.g.setLayoutParams(paramContext);
      this.g.setBackgroundColor(-1728053248);
      this.g.setVisibility(8);
      paramViewGroup.addView(this.g);
      return;
      paramContext = new FrameLayout.LayoutParams(this.b.e(), -1);
    }
  }
  
  public void a(int paramInt)
  {
    if (this.c) {
      this.f.setBackgroundColor(paramInt);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.e = paramBoolean;
    View localView;
    if (this.c)
    {
      localView = this.f;
      if (!paramBoolean) {
        break label29;
      }
    }
    label29:
    for (int i = 0;; i = 8)
    {
      localView.setVisibility(i);
      return;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/e/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */