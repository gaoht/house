package android.support.v7.widget;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
import android.graphics.Rect;
import android.support.v7.appcompat.R.dimen;
import android.support.v7.appcompat.R.id;
import android.support.v7.appcompat.R.layout;
import android.support.v7.appcompat.R.style;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.Window;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.TextView;

class ax
{
  private final Context a;
  private final View b;
  private final TextView c;
  private final WindowManager.LayoutParams d = new WindowManager.LayoutParams();
  private final Rect e = new Rect();
  private final int[] f = new int[2];
  private final int[] g = new int[2];
  
  ax(Context paramContext)
  {
    this.a = paramContext;
    this.b = LayoutInflater.from(this.a).inflate(R.layout.tooltip, null);
    this.c = ((TextView)this.b.findViewById(R.id.message));
    this.d.setTitle(getClass().getSimpleName());
    this.d.packageName = this.a.getPackageName();
    this.d.type = 1002;
    this.d.width = -2;
    this.d.height = -2;
    this.d.format = -3;
    this.d.windowAnimations = R.style.Animation_AppCompat_Tooltip;
    this.d.flags = 24;
  }
  
  private static View a(View paramView)
  {
    for (Context localContext = paramView.getContext(); (localContext instanceof ContextWrapper); localContext = ((ContextWrapper)localContext).getBaseContext()) {
      if ((localContext instanceof Activity)) {
        return ((Activity)localContext).getWindow().getDecorView();
      }
    }
    return paramView.getRootView();
  }
  
  private void a(View paramView, int paramInt1, int paramInt2, boolean paramBoolean, WindowManager.LayoutParams paramLayoutParams)
  {
    int i = this.a.getResources().getDimensionPixelOffset(R.dimen.tooltip_precise_anchor_threshold);
    label67:
    Object localObject1;
    if (paramView.getWidth() >= i)
    {
      if (paramView.getHeight() < i) {
        break label132;
      }
      j = this.a.getResources().getDimensionPixelOffset(R.dimen.tooltip_precise_anchor_extra_offset);
      i = paramInt2 + j;
      j = paramInt2 - j;
      paramInt2 = i;
      i = j;
      paramLayoutParams.gravity = 49;
      localObject1 = this.a.getResources();
      if (!paramBoolean) {
        break label143;
      }
    }
    int k;
    label132:
    label143:
    for (int j = R.dimen.tooltip_y_offset_touch;; j = R.dimen.tooltip_y_offset_non_touch)
    {
      k = ((Resources)localObject1).getDimensionPixelOffset(j);
      localObject1 = a(paramView);
      if (localObject1 != null) {
        break label151;
      }
      Log.e("TooltipPopup", "Cannot find app view");
      return;
      paramInt1 = paramView.getWidth() / 2;
      break;
      paramInt2 = paramView.getHeight();
      i = 0;
      break label67;
    }
    label151:
    ((View)localObject1).getWindowVisibleDisplayFrame(this.e);
    Object localObject2;
    if ((this.e.left < 0) && (this.e.top < 0))
    {
      localObject2 = this.a.getResources();
      j = ((Resources)localObject2).getIdentifier("status_bar_height", "dimen", "android");
      if (j == 0) {
        break label388;
      }
    }
    label388:
    for (j = ((Resources)localObject2).getDimensionPixelSize(j);; j = 0)
    {
      localObject2 = ((Resources)localObject2).getDisplayMetrics();
      this.e.set(0, j, ((DisplayMetrics)localObject2).widthPixels, ((DisplayMetrics)localObject2).heightPixels);
      ((View)localObject1).getLocationOnScreen(this.g);
      paramView.getLocationOnScreen(this.f);
      paramView = this.f;
      paramView[0] -= this.g[0];
      paramView = this.f;
      paramView[1] -= this.g[1];
      paramLayoutParams.x = (this.f[0] + paramInt1 - this.e.width() / 2);
      paramInt1 = View.MeasureSpec.makeMeasureSpec(0, 0);
      this.b.measure(paramInt1, paramInt1);
      paramInt1 = this.b.getMeasuredHeight();
      i = i + this.f[1] - k - paramInt1;
      paramInt2 = paramInt2 + this.f[1] + k;
      if (!paramBoolean) {
        break label401;
      }
      if (i < 0) {
        break;
      }
      paramLayoutParams.y = i;
      return;
    }
    paramLayoutParams.y = paramInt2;
    return;
    label401:
    if (paramInt1 + paramInt2 <= this.e.height())
    {
      paramLayoutParams.y = paramInt2;
      return;
    }
    paramLayoutParams.y = i;
  }
  
  void a()
  {
    if (!b()) {
      return;
    }
    ((WindowManager)this.a.getSystemService("window")).removeView(this.b);
  }
  
  void a(View paramView, int paramInt1, int paramInt2, boolean paramBoolean, CharSequence paramCharSequence)
  {
    if (b()) {
      a();
    }
    this.c.setText(paramCharSequence);
    a(paramView, paramInt1, paramInt2, paramBoolean, this.d);
    ((WindowManager)this.a.getSystemService("window")).addView(this.b, this.d);
  }
  
  boolean b()
  {
    return this.b.getParent() != null;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/android/support/v7/widget/ax.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */