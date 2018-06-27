package com.ziroom.ziroomcustomer.findhouse.view;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RadioButton;
import com.ziroom.ziroomcustomer.findhouse.model.SelectBean;
import com.ziroom.ziroomcustomer.findhouse.model.SelectCondition.SelectType;
import java.util.HashSet;

public class b
{
  public static void clearSelect(ViewGroup paramViewGroup)
  {
    int i = 0;
    if (i < paramViewGroup.getChildCount())
    {
      if ((paramViewGroup.getChildAt(i) instanceof CheckBox)) {
        ((CheckBox)paramViewGroup.getChildAt(i)).setChecked(false);
      }
      for (;;)
      {
        i += 1;
        break;
        if ((paramViewGroup.getChildAt(i) instanceof RadioButton)) {
          ((RadioButton)paramViewGroup.getChildAt(i)).setChecked(false);
        }
      }
    }
  }
  
  public static CheckBox getCheckBox(Context paramContext)
  {
    return getCheckBox(paramContext, 2130839489, 2131624647);
  }
  
  public static CheckBox getCheckBox(Context paramContext, int paramInt1, int paramInt2)
  {
    float f = paramContext.getResources().getDisplayMetrics().density;
    CheckBox localCheckBox = new CheckBox(paramContext);
    localCheckBox.setTextSize(2, 14.0F);
    localCheckBox.setButtonDrawable(2131624576);
    localCheckBox.setGravity(17);
    localCheckBox.setSingleLine(true);
    localCheckBox.setSingleLine(true);
    localCheckBox.setEllipsize(null);
    localCheckBox.setBackgroundResource(paramInt1);
    localCheckBox.setTextColor(paramContext.getResources().getColorStateList(paramInt2));
    paramInt1 = (int)(8.0F * f);
    paramInt2 = (int)(f * 1.0F);
    localCheckBox.setPadding(paramInt2, paramInt1, paramInt2, paramInt1);
    paramContext = new LinearLayout.LayoutParams(0, -2);
    paramContext.weight = 1.0F;
    paramContext.leftMargin = paramInt1;
    paramContext.rightMargin = paramInt1;
    localCheckBox.setLayoutParams(paramContext);
    localCheckBox.setIncludeFontPadding(false);
    return localCheckBox;
  }
  
  public static String getTypeShow(ViewGroup paramViewGroup)
  {
    if ((paramViewGroup == null) || (paramViewGroup.getChildCount() < 1)) {
      return "";
    }
    int i = 0;
    while (i < paramViewGroup.getChildCount())
    {
      View localView = paramViewGroup.getChildAt(i);
      if (((localView instanceof CheckBox)) && (((CheckBox)localView).isChecked())) {
        return ((SelectCondition.SelectType)localView.getTag()).getShow();
      }
      i += 1;
    }
    return "";
  }
  
  public static String getTypeTitle(ViewGroup paramViewGroup)
  {
    if ((paramViewGroup == null) || (paramViewGroup.getChildCount() < 1)) {
      return "";
    }
    int i = 0;
    while (i < paramViewGroup.getChildCount())
    {
      View localView = paramViewGroup.getChildAt(i);
      if (((localView instanceof CheckBox)) && (((CheckBox)localView).isChecked())) {
        return ((SelectCondition.SelectType)localView.getTag()).getTitle();
      }
      i += 1;
    }
    return "";
  }
  
  public static String joinString(ViewGroup paramViewGroup)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    if (i < paramViewGroup.getChildCount())
    {
      Object localObject = paramViewGroup.getChildAt(i);
      if ((((localObject instanceof CheckBox)) && (((CheckBox)localObject).isChecked())) || (((localObject instanceof RadioButton)) && (((RadioButton)localObject).isChecked()) && ((((View)localObject).getTag() instanceof SelectBean))))
      {
        localObject = (SelectBean)((View)localObject).getTag();
        if (localObject != null) {
          break label87;
        }
      }
      for (;;)
      {
        i += 1;
        break;
        label87:
        localStringBuilder.append(((SelectBean)localObject).getValue()).append("|");
      }
    }
    if (localStringBuilder.length() == 0) {
      return "";
    }
    localStringBuilder.deleteCharAt(localStringBuilder.length() - 1);
    return localStringBuilder.toString();
  }
  
  public static String joinTypeString(ViewGroup paramViewGroup)
  {
    if (paramViewGroup == null) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    while (i < paramViewGroup.getChildCount())
    {
      Object localObject = paramViewGroup.getChildAt(i);
      if ((((localObject instanceof CheckBox)) && (((CheckBox)localObject).isChecked())) || (((localObject instanceof RadioButton)) && (((RadioButton)localObject).isChecked())))
      {
        localObject = (SelectCondition.SelectType)((View)localObject).getTag();
        if (localObject != null) {
          localStringBuilder.append(((SelectCondition.SelectType)localObject).getValue()).append("|");
        }
      }
      i += 1;
    }
    if (localStringBuilder.length() == 0) {
      return "";
    }
    return localStringBuilder.toString();
  }
  
  public static void setTypeState(ViewGroup paramViewGroup, HashSet<Integer> paramHashSet)
  {
    if ((paramViewGroup == null) || (paramViewGroup.getChildCount() < 1)) {}
    for (;;)
    {
      return;
      int i = 0;
      while (i < paramViewGroup.getChildCount())
      {
        Object localObject = paramViewGroup.getChildAt(i);
        if (((localObject instanceof CheckBox)) && (((CheckBox)localObject).isChecked()))
        {
          localObject = (SelectCondition.SelectType)((View)localObject).getTag();
          if (localObject != null)
          {
            paramHashSet.add(Integer.valueOf(((SelectCondition.SelectType)localObject).getType()));
            return;
          }
        }
        i += 1;
      }
    }
  }
  
  public static void setViewSelecet(String paramString, ViewGroup paramViewGroup)
  {
    if ((paramViewGroup == null) || (paramViewGroup.getChildCount() < 1) || (paramString == null)) {}
    for (;;)
    {
      return;
      paramString = paramString.split("\\|");
      if ((paramString != null) && (paramString.length >= 1))
      {
        int i = 0;
        while (i < paramViewGroup.getChildCount())
        {
          View localView = paramViewGroup.getChildAt(i);
          int j;
          Object localObject;
          if ((localView.getTag() != null) && ((localView.getTag() instanceof SelectCondition.SelectType)))
          {
            j = 0;
            if (j < paramString.length)
            {
              localObject = ((SelectCondition.SelectType)localView.getTag()).getValue();
              if ((!TextUtils.isEmpty(paramString[j])) && (paramString[j].equals(localObject)))
              {
                if (!(localView instanceof CheckBox)) {
                  break label135;
                }
                ((CheckBox)localView).setChecked(true);
              }
              for (;;)
              {
                j += 1;
                break;
                label135:
                if ((localView instanceof RadioButton)) {
                  ((RadioButton)localView).setChecked(true);
                }
              }
            }
          }
          else if ((localView.getTag() != null) && ((localView.getTag() instanceof SelectBean)))
          {
            j = 0;
            if (j < paramString.length)
            {
              localObject = (SelectBean)localView.getTag();
              if (localObject == null) {}
              for (;;)
              {
                j += 1;
                break;
                if ((!TextUtils.isEmpty(paramString[j])) && (paramString[j].equals(((SelectBean)localObject).getValue()))) {
                  if ((localView instanceof CheckBox)) {
                    ((CheckBox)localView).setChecked(true);
                  } else if ((localView instanceof RadioButton)) {
                    ((RadioButton)localView).setChecked(true);
                  }
                }
              }
            }
          }
          else
          {
            j = 0;
            if (j < paramString.length)
            {
              if ((!TextUtils.isEmpty(paramString[j])) && (paramString[j].equals(localView.getTag().toString())))
              {
                if (!(localView instanceof CheckBox)) {
                  break label325;
                }
                ((CheckBox)localView).setChecked(true);
              }
              for (;;)
              {
                j += 1;
                break;
                label325:
                if ((localView instanceof RadioButton)) {
                  ((RadioButton)localView).setChecked(true);
                }
              }
            }
          }
          i += 1;
        }
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/findhouse/view/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */