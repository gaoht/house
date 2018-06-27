package com.unionpay.mobile.android.views.order;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.unionpay.mobile.android.global.b;
import com.unionpay.mobile.android.nocard.views.bh;
import com.unionpay.mobile.android.utils.f;
import com.unionpay.mobile.android.utils.j;
import com.unionpay.mobile.android.widgets.ad;
import org.json.JSONArray;
import org.json.JSONObject;

public final class m
  extends RelativeLayout
{
  private Context a;
  private ImageView b;
  private LinearLayout c;
  private LinearLayout d;
  private Drawable e;
  private Drawable f;
  
  public m(Context paramContext)
  {
    super(paramContext);
    this.a = paramContext;
    int i = f.a(paramContext, 10.0F);
    setPadding(i, i, i, i);
    setBackgroundColor(-1);
    setOnClickListener(new n(this));
    int j = f.a(paramContext, 15.0F);
    this.b = new ImageView(paramContext);
    this.b.setId(this.b.hashCode());
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(j, j);
    localLayoutParams.addRule(11, -1);
    localLayoutParams.addRule(12, -1);
    addView(this.b, localLayoutParams);
    this.c = new LinearLayout(paramContext);
    this.c.setOrientation(1);
    paramContext = new RelativeLayout.LayoutParams(-1, -2);
    paramContext.rightMargin = i;
    paramContext.addRule(9, -1);
    paramContext.addRule(15, -1);
    paramContext.addRule(0, this.b.getId());
    addView(this.c, paramContext);
  }
  
  public final void a(Drawable paramDrawable1, Drawable paramDrawable2)
  {
    this.e = paramDrawable1;
    this.f = paramDrawable2;
  }
  
  public final void a(boolean paramBoolean, JSONArray paramJSONArray, JSONObject paramJSONObject)
  {
    int j = 2;
    this.c.removeAllViews();
    if (this.f != null) {
      this.b.setBackgroundDrawable(this.f);
    }
    int i;
    if ((paramJSONArray == null) || (paramJSONArray.length() == 0))
    {
      i = 0;
      if ((paramBoolean) || (paramJSONArray == null)) {
        break label249;
      }
      if (paramJSONArray.length() <= 2) {
        break label86;
      }
      i = j;
    }
    label86:
    label249:
    for (;;)
    {
      if ((paramJSONArray == null) || (i == 0))
      {
        j.c("uppay", "init order detail = null!!!");
        return;
        i = 1;
        break;
        i = paramJSONArray.length();
        continue;
      }
      LinearLayout localLinearLayout = bh.a(this.a, paramJSONArray, 0, i);
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -2);
      this.c.addView(localLinearLayout, localLayoutParams);
      j = paramJSONArray.length();
      this.d = bh.a(this.a, paramJSONArray, i, j);
      if (paramJSONObject != null)
      {
        paramJSONArray = new ad(this.a, paramJSONObject, "");
        paramJSONArray.g();
        paramJSONArray.a(b.m);
        paramJSONObject = new LinearLayout.LayoutParams(-1, -2);
        paramJSONObject.topMargin = f.a(this.a, 8.0F);
        this.d.addView(paramJSONArray, paramJSONObject);
      }
      this.d.setVisibility(8);
      paramJSONArray = new LinearLayout.LayoutParams(-1, -2);
      this.c.addView(this.d, paramJSONArray);
      return;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/unionpay/mobile/android/views/order/m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */