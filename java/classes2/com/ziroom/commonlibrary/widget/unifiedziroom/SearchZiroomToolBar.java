package com.ziroom.commonlibrary.widget.unifiedziroom;

import android.content.Context;
import android.graphics.Color;
import android.os.Build.VERSION;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import com.freelxl.baselibrary.f.b;
import com.ziroom.commonlibrary.R.drawable;
import com.ziroom.commonlibrary.R.id;

public class SearchZiroomToolBar
  extends BasicZiroomToolBar
{
  private LinearLayout c;
  private EditText d;
  
  public SearchZiroomToolBar(Context paramContext)
  {
    super(paramContext);
  }
  
  public SearchZiroomToolBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramAttributeSet);
  }
  
  public SearchZiroomToolBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramAttributeSet);
  }
  
  private void c()
  {
    RelativeLayout.LayoutParams localLayoutParams;
    int i;
    if (this.c != null)
    {
      localLayoutParams = (RelativeLayout.LayoutParams)this.c.getLayoutParams();
      if (this.b.getVisibility() != 0) {
        break label75;
      }
      i = b.dip2px(getContext(), 12.0F);
      if (this.a.getVisibility() != 0) {
        break label88;
      }
    }
    label75:
    label88:
    for (int j = b.dip2px(getContext(), 12.0F);; j = b.dip2px(getContext(), 18.0F))
    {
      localLayoutParams.setMargins(i, 0, j, 0);
      this.c.setLayoutParams(localLayoutParams);
      return;
      i = b.dip2px(getContext(), 18.0F);
      break;
    }
  }
  
  protected void a()
  {
    this.c = new LinearLayout(getContext());
    this.c.setBackgroundResource(R.drawable.shape_search_bg_radius_16_f5f5f5);
    this.c.setOrientation(0);
    Object localObject = new RelativeLayout.LayoutParams(-1, b.dip2px(getContext(), 32.0F));
    ((RelativeLayout.LayoutParams)localObject).addRule(15);
    ((RelativeLayout.LayoutParams)localObject).addRule(1, R.id.iv_back);
    ((RelativeLayout.LayoutParams)localObject).addRule(0, R.id.ll_button_container);
    ((RelativeLayout.LayoutParams)localObject).setMargins(b.dip2px(getContext(), 18.0F), 0, b.dip2px(getContext(), 18.0F), 0);
    addView(this.c, (ViewGroup.LayoutParams)localObject);
    localObject = new ImageView(getContext());
    ((ImageView)localObject).setImageResource(R.drawable.minsu_search_icon);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(b.dip2px(getContext(), 24.0F), b.dip2px(getContext(), 24.0F));
    localLayoutParams.setMargins(b.dip2px(getContext(), 6.0F), 0, b.dip2px(getContext(), 6.0F), 0);
    localLayoutParams.gravity = 16;
    this.c.addView((View)localObject, localLayoutParams);
    this.d = new EditText(getContext());
    this.d.setHint("你想住哪儿");
    this.d.setHintTextColor(Color.parseColor("#999999"));
    this.d.setTextColor(Color.parseColor("#444444"));
    this.d.setTextSize(2, 14.0F);
    this.d.setPadding(0, 0, 0, 0);
    if (Build.VERSION.SDK_INT >= 16) {
      this.d.setBackground(null);
    }
    for (;;)
    {
      localObject = new LinearLayout.LayoutParams(-1, -2);
      ((LinearLayout.LayoutParams)localObject).gravity = 16;
      this.c.addView(this.d, (ViewGroup.LayoutParams)localObject);
      c();
      return;
      this.d.setBackgroundDrawable(null);
    }
  }
  
  protected void a(AttributeSet paramAttributeSet)
  {
    super.a(paramAttributeSet);
  }
  
  public void addTextChangedListener(TextWatcher paramTextWatcher)
  {
    if (paramTextWatcher != null) {
      this.d.addTextChangedListener(paramTextWatcher);
    }
  }
  
  protected void b()
  {
    super.b();
    c();
  }
  
  public BasicZiroomToolBar.TextButton newButton(String paramString, View.OnClickListener paramOnClickListener)
  {
    paramString = super.newButton(paramString, paramOnClickListener);
    paramString.setTextColor(Color.parseColor("#999999"));
    return paramString;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/commonlibrary/widget/unifiedziroom/SearchZiroomToolBar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */