package com.ziroom.ziroomcustomer.minsu.view;

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
import com.ziroom.ziroomcustomer.util.ae;

public class IntellectDeviceView
  extends RelativeLayout
{
  private Context a;
  private boolean b = false;
  private ImageView c;
  private TextView d;
  
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
    Object localObject1 = LayoutInflater.from(paramContext).inflate(2130904318, this, true);
    Object localObject2 = paramContext.getTheme().obtainStyledAttributes(paramAttributeSet, R.styleable.intellect, 0, 0);
    paramAttributeSet = ((TypedArray)localObject2).getDrawable(1);
    paramContext = ((TypedArray)localObject2).getString(0);
    ((TypedArray)localObject2).getString(4);
    this.b = ((TypedArray)localObject2).getBoolean(3, false);
    ((TypedArray)localObject2).recycle();
    localObject2 = (ImageView)((View)localObject1).findViewById(2131695274);
    this.c = ((ImageView)((View)localObject1).findViewById(2131690145));
    this.d = ((TextView)((View)localObject1).findViewById(2131690146));
    localObject1 = (TextView)((View)localObject1).findViewById(2131695275);
    if (this.b)
    {
      this.c.setVisibility(0);
      if (!TextUtils.isEmpty(paramContext)) {
        break label203;
      }
      paramContext = "敬请期待";
      ((TextView)localObject1).setTextColor(getResources().getColor(2131624363));
    }
    for (;;)
    {
      ((TextView)localObject1).setText(paramContext);
      if (paramAttributeSet != null) {
        break label220;
      }
      ((ImageView)localObject2).setImageResource(2130839159);
      return;
      this.c.setVisibility(8);
      break;
      label203:
      ((TextView)localObject1).setTextColor(getResources().getColor(2131624362));
    }
    label220:
    ((ImageView)localObject2).setImageDrawable(paramAttributeSet);
  }
  
  public void setMessageText(String paramString)
  {
    if (ae.isNull(paramString))
    {
      this.d.setVisibility(8);
      return;
    }
    this.d.setVisibility(0);
    this.d.setText(paramString);
  }
  
  public void setShowMessage(boolean paramBoolean)
  {
    this.b = paramBoolean;
    if (this.b)
    {
      this.c.setVisibility(0);
      return;
    }
    this.c.setVisibility(8);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/view/IntellectDeviceView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */