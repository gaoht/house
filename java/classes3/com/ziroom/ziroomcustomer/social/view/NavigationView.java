package com.ziroom.ziroomcustomer.social.view;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.LayoutParams;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import java.util.Arrays;
import java.util.List;

public class NavigationView
  extends RadioGroup
{
  private Context a;
  private a b;
  
  public NavigationView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public NavigationView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.a = paramContext;
    a();
  }
  
  private RadioButton a(String paramString)
  {
    RadioButton localRadioButton = new RadioButton(this.a);
    RadioGroup.LayoutParams localLayoutParams = new RadioGroup.LayoutParams(0, -1);
    localLayoutParams.weight = 1.0F;
    localRadioButton.setLayoutParams(localLayoutParams);
    localRadioButton.setTextSize(2, 14.0F);
    localRadioButton.setTextColor(this.a.getResources().getColorStateList(2131624647));
    localRadioButton.setText(paramString);
    localRadioButton.setGravity(17);
    localRadioButton.setButtonDrawable(null);
    localRadioButton.setBackgroundResource(2130839483);
    return localRadioButton;
  }
  
  private void a()
  {
    setOrientation(0);
    setBackgroundColor(this.a.getResources().getColor(2131624583));
  }
  
  public void setChecked(int paramInt)
  {
    if (getChildCount() < 1) {
      return;
    }
    int i = paramInt;
    if (paramInt > getChildCount() - 1) {
      i = getChildCount() - 1;
    }
    ((RadioButton)getChildAt(i)).setChecked(true);
  }
  
  public void setOnNaviChangeListener(a parama)
  {
    this.b = parama;
  }
  
  public void setTitles(List<String> paramList)
  {
    if ((paramList == null) || (paramList.size() < 1)) {
      setVisibility(8);
    }
    for (;;)
    {
      return;
      removeAllViews();
      final int i = 0;
      while (i < paramList.size())
      {
        RadioButton localRadioButton = a((String)paramList.get(i));
        localRadioButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
        {
          @Instrumented
          public void onCheckedChanged(CompoundButton paramAnonymousCompoundButton, boolean paramAnonymousBoolean)
          {
            VdsAgent.onCheckedChanged(this, paramAnonymousCompoundButton, paramAnonymousBoolean);
            if ((paramAnonymousBoolean) && (NavigationView.a(NavigationView.this) != null)) {
              NavigationView.a(NavigationView.this).onNaviChanged(i);
            }
          }
        });
        addView(localRadioButton);
        i += 1;
      }
    }
  }
  
  public void setTitles(List<String> paramList, int paramInt)
  {
    setTitles(paramList);
    setChecked(paramInt);
  }
  
  public void setTitles(String[] paramArrayOfString)
  {
    if ((paramArrayOfString == null) || (paramArrayOfString.length < 1))
    {
      setVisibility(8);
      return;
    }
    setTitles(Arrays.asList(paramArrayOfString));
  }
  
  public void setTitles(String[] paramArrayOfString, int paramInt)
  {
    setTitles(paramArrayOfString);
    setChecked(paramInt);
  }
  
  public static abstract interface a
  {
    public abstract void onNaviChanged(int paramInt);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/social/view/NavigationView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */