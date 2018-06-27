package com.ziroom.ziroomcustomer.ziroomstation.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;
import com.ziroom.ziroomcustomer.ziroomstation.model.GetEvaluateInfoModel.QuestionsBean.ChildrenBean.OptionsBean;

public class TagTextView
  extends TextView
{
  GetEvaluateInfoModel.QuestionsBean.ChildrenBean.OptionsBean a;
  
  public TagTextView(Context paramContext)
  {
    super(paramContext);
  }
  
  public TagTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public TagTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public GetEvaluateInfoModel.QuestionsBean.ChildrenBean.OptionsBean getTagBean()
  {
    return this.a;
  }
  
  public void setTagBean(GetEvaluateInfoModel.QuestionsBean.ChildrenBean.OptionsBean paramOptionsBean)
  {
    this.a = paramOptionsBean;
    setText(paramOptionsBean.desc);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes4-dex2jar.jar!/com/ziroom/ziroomcustomer/ziroomstation/widget/TagTextView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */