package com.unionpay.mobile.android.upwidget;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.unionpay.mobile.android.global.b;
import com.unionpay.mobile.android.utils.f;
import java.util.ArrayList;

public final class g
  extends LinearLayout
{
  private Context a;
  private c b;
  private ArrayList<AdapterView.OnItemClickListener> c = new ArrayList();
  private ArrayList<View.OnClickListener> d = new ArrayList();
  private AdapterView.OnItemClickListener e = new h(this);
  private View.OnClickListener f = new i(this);
  
  public g(Context paramContext, c paramc)
  {
    super(paramContext);
    this.a = paramContext;
    this.b = paramc;
    paramContext = new RelativeLayout(this.a);
    Object localObject = new RelativeLayout.LayoutParams(-1, -2);
    ((RelativeLayout.LayoutParams)localObject).addRule(12, -1);
    paramc = new LinearLayout(this.a);
    paramc.setOrientation(1);
    paramc.setBackgroundColor(-1);
    paramc.setId(paramc.hashCode());
    paramContext.addView(paramc, (ViewGroup.LayoutParams)localObject);
    localObject = new RelativeLayout.LayoutParams(-1, -1);
    LinearLayout localLinearLayout = new LinearLayout(this.a);
    ((RelativeLayout.LayoutParams)localObject).addRule(10, -1);
    ((RelativeLayout.LayoutParams)localObject).addRule(2, paramc.getId());
    paramContext.addView(localLinearLayout, (ViewGroup.LayoutParams)localObject);
    localLinearLayout.setOnClickListener(this.f);
    int i = f.a(this.a, 1.0F);
    localObject = new LinearLayout.LayoutParams(-1, -2);
    int j = b.a;
    ((LinearLayout.LayoutParams)localObject).bottomMargin = j;
    ((LinearLayout.LayoutParams)localObject).topMargin = j;
    localObject = new LinearLayout.LayoutParams(-1, i);
    localLinearLayout = new LinearLayout(this.a);
    localLinearLayout.setBackgroundColor(-3355444);
    paramc.addView(localLinearLayout, (ViewGroup.LayoutParams)localObject);
    new LinearLayout.LayoutParams(-1, -2);
    localObject = new ListView(this.a);
    ((ListView)localObject).setDivider(null);
    a((ListView)localObject, this.b);
    ((ListView)localObject).setAdapter(this.b);
    ((ListView)localObject).setCacheColorHint(-1);
    ((ListView)localObject).setOnItemClickListener(this.e);
    new LinearLayout.LayoutParams(-1, -2);
    paramc.addView((View)localObject);
    addView(paramContext);
  }
  
  private void a(ListView paramListView, ListAdapter paramListAdapter)
  {
    if ((paramListView == null) || (paramListAdapter == null)) {}
    ViewGroup.LayoutParams localLayoutParams;
    do
    {
      return;
      localLayoutParams = paramListView.getLayoutParams();
    } while (localLayoutParams == null);
    Object localObject = new Rect();
    ((Activity)this.a).getWindow().getDecorView().getWindowVisibleDisplayFrame((Rect)localObject);
    int m = ((Rect)localObject).height();
    int j = 0;
    int i = 0;
    int k;
    for (;;)
    {
      k = i;
      if (j >= paramListAdapter.getCount()) {
        break;
      }
      localObject = paramListAdapter.getView(j, null, paramListView);
      ((View)localObject).measure(0, 0);
      i += ((View)localObject).getMeasuredHeight();
      k = i;
      if (i > m) {
        break;
      }
      j += 1;
    }
    localLayoutParams.height = Math.min(k, m);
    paramListView.setLayoutParams(localLayoutParams);
  }
  
  public final void a(View.OnClickListener paramOnClickListener)
  {
    this.d.add(paramOnClickListener);
  }
  
  public final void a(AdapterView.OnItemClickListener paramOnItemClickListener)
  {
    this.c.add(paramOnItemClickListener);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/unionpay/mobile/android/upwidget/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */