package com.ziroom.ziroomcustomer.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.ziroom.ziroomcustomer.R.styleable;

public class IntellectHomeView
  extends RelativeLayout
{
  private Context a;
  private ImageView b;
  private TextView c;
  
  public IntellectHomeView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public IntellectHomeView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, -1);
  }
  
  public IntellectHomeView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.a = paramContext;
    float f = this.a.getResources().getDisplayMetrics().density;
    View localView = LayoutInflater.from(paramContext).inflate(2130904392, this, true);
    TypedArray localTypedArray = paramContext.getTheme().obtainStyledAttributes(paramAttributeSet, R.styleable.intellect, 0, 0);
    paramAttributeSet = localTypedArray.getDrawable(1);
    paramInt = localTypedArray.getColor(2, Color.parseColor("#999999"));
    paramContext = localTypedArray.getString(0);
    localTypedArray.recycle();
    this.b = ((ImageView)localView.findViewById(2131695274));
    this.c = ((TextView)localView.findViewById(2131695275));
    this.c.setTextColor(paramInt);
    if (TextUtils.isEmpty(paramContext)) {
      paramContext = "敬请期待";
    }
    for (;;)
    {
      this.c.setTextSize(2, 11.0F);
      this.c.setText(paramContext);
      paramContext = (LinearLayout.LayoutParams)this.b.getLayoutParams();
      paramContext.height = ((int)(22.0F * f));
      paramContext.width = ((int)(22.0F * f));
      this.b.setLayoutParams(paramContext);
      this.b.setScaleType(ImageView.ScaleType.FIT_CENTER);
      if (paramAttributeSet == null)
      {
        this.b.setImageResource(2130839159);
        return;
      }
      this.b.setImageDrawable(paramAttributeSet);
      return;
    }
  }
  
  public void setImg(int paramInt)
  {
    this.b.setImageResource(paramInt);
  }
  
  public void setText(String paramString)
  {
    this.c.setText(paramString);
  }
  
  public void setTextColor(String paramString)
  {
    this.c.setTextColor(Color.parseColor(paramString));
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/widget/IntellectHomeView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */