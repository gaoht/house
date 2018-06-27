package com.ziroom.ziroomcustomer.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.ziroom.ziroomcustomer.R.styleable;

public class IntellectDeviceView
  extends RelativeLayout
{
  private Context a;
  private ImageView b;
  private TextView c;
  
  public IntellectDeviceView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public IntellectDeviceView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, -1);
  }
  
  public IntellectDeviceView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.a = paramContext;
    View localView = LayoutInflater.from(paramContext).inflate(2130904392, this, true);
    TypedArray localTypedArray = paramContext.getTheme().obtainStyledAttributes(paramAttributeSet, R.styleable.intellect, 0, 0);
    paramAttributeSet = localTypedArray.getDrawable(1);
    paramContext = localTypedArray.getString(0);
    localTypedArray.recycle();
    this.b = ((ImageView)localView.findViewById(2131695274));
    this.c = ((TextView)localView.findViewById(2131695275));
    if (TextUtils.isEmpty(paramContext))
    {
      paramContext = "敬请期待";
      this.c.setTextColor(getResources().getColor(2131624363));
    }
    for (;;)
    {
      this.c.setText(paramContext);
      if (paramAttributeSet != null) {
        break;
      }
      this.b.setImageResource(2130839159);
      return;
      this.c.setTextColor(getResources().getColor(2131624362));
    }
    this.b.setImageDrawable(paramAttributeSet);
  }
  
  public ImageView getIv()
  {
    return this.b;
  }
  
  public TextView getTv()
  {
    return this.c;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/widget/IntellectDeviceView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */