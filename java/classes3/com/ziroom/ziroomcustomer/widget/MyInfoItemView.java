package com.ziroom.ziroomcustomer.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.ziroom.ziroomcustomer.R.styleable;

public class MyInfoItemView
  extends LinearLayout
{
  private Context a;
  
  public MyInfoItemView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public MyInfoItemView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, -1);
  }
  
  public MyInfoItemView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.a = paramContext;
    View localView2 = LayoutInflater.from(paramContext).inflate(2130904393, this, true);
    paramContext = paramContext.getTheme().obtainStyledAttributes(paramAttributeSet, R.styleable.myinfoitem, 0, 0);
    paramAttributeSet = paramContext.getString(1);
    boolean bool = paramContext.getBoolean(2, false);
    Drawable localDrawable = paramContext.getDrawable(3);
    float f1 = paramContext.getDimension(0, -1.0F);
    String str = paramContext.getString(4);
    float f2 = paramContext.getDimension(6, -1.0F);
    float f3 = paramContext.getDimension(7, -1.0F);
    float f4 = paramContext.getDimension(5, -1.0F);
    float f5 = paramContext.getDimension(9, -1.0F);
    float f6 = paramContext.getDimension(8, -1.0F);
    paramContext.recycle();
    TextView localTextView = (TextView)localView2.findViewById(2131695418);
    View localView1 = localView2.findViewById(2131695421);
    RelativeLayout localRelativeLayout = (RelativeLayout)localView2.findViewById(2131695417);
    localView2 = localView2.findViewById(2131695420);
    if (bool) {
      localView1.setVisibility(0);
    }
    paramContext = paramAttributeSet;
    if (TextUtils.isEmpty(paramAttributeSet)) {
      paramContext = "item";
    }
    localTextView.setText(paramContext);
    localTextView.setTextColor(getResources().getColor(2131624362));
    if (f6 >= 0.0F)
    {
      paramContext = (LinearLayout.LayoutParams)localView2.getLayoutParams();
      paramContext.setMargins(0, 0, (int)f6, 0);
      localView2.setLayoutParams(paramContext);
    }
    if (f1 >= 0.0F) {
      localTextView.setTextSize(0, f1);
    }
    if (f5 >= 0.0F)
    {
      paramContext = localRelativeLayout.getLayoutParams();
      paramContext.height = ((int)f5);
      localRelativeLayout.setLayoutParams(paramContext);
    }
    if ((f2 >= 0.0F) || (f3 >= 0.0F))
    {
      paramContext = (LinearLayout.LayoutParams)localView1.getLayoutParams();
      paramContext.leftMargin = ((int)f2);
      if (f2 >= 0.0F) {
        paramContext.leftMargin = ((int)f2);
      }
      if (f3 >= 0.0F) {
        paramContext.leftMargin = ((int)f3);
      }
      localView1.setLayoutParams(paramContext);
    }
    if (f4 >= 0.0F)
    {
      paramContext = (RelativeLayout.LayoutParams)localTextView.getLayoutParams();
      paramContext.leftMargin = ((int)f4);
      localTextView.setLayoutParams(paramContext);
    }
    if (!TextUtils.isEmpty(str)) {
      localView1.setBackgroundColor(Color.parseColor(str));
    }
    if (localDrawable != null)
    {
      localDrawable.setBounds(0, 0, localDrawable.getMinimumWidth(), localDrawable.getMinimumHeight());
      localTextView.setCompoundDrawables(localDrawable, null, null, null);
      return;
    }
    localTextView.setCompoundDrawables(null, null, null, null);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/widget/MyInfoItemView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */