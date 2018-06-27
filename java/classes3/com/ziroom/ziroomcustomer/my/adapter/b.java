package com.ziroom.ziroomcustomer.my.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;
import com.ziroom.ziroomcustomer.my.model.MyEvaHistoryDetailModel.EvaluateInfoBean.QuestionsBean.ChildrenBean;
import com.ziroom.ziroomcustomer.my.model.MyEvaHistoryDetailModel.EvaluateInfoBean.QuestionsBean.ChildrenBean.AnswersBean;
import com.ziroom.ziroomcustomer.my.model.MyEvaHistoryDetailModel.EvaluateInfoBean.QuestionsBean.ChildrenBean.OptionsBean;
import java.util.List;

public class b
  extends BaseAdapter
{
  private String a = b.class.getSimpleName();
  private Context b;
  private List<MyEvaHistoryDetailModel.EvaluateInfoBean.QuestionsBean.ChildrenBean> c;
  private LayoutInflater d;
  
  public b(Context paramContext, List<MyEvaHistoryDetailModel.EvaluateInfoBean.QuestionsBean.ChildrenBean> paramList)
  {
    this.c = paramList;
    this.b = paramContext;
    this.d = LayoutInflater.from(paramContext);
  }
  
  public int getCount()
  {
    if (this.c != null) {
      return this.c.size();
    }
    return 0;
  }
  
  public Object getItem(int paramInt)
  {
    return this.c.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView;
    if (paramView == null)
    {
      localView = this.d.inflate(2130904383, paramViewGroup, false);
      paramView = new a(localView);
      localView.setTag(paramView);
      paramViewGroup = paramView;
    }
    for (;;)
    {
      paramViewGroup.b.setText(((MyEvaHistoryDetailModel.EvaluateInfoBean.QuestionsBean.ChildrenBean)this.c.get(paramInt)).label);
      if ((((MyEvaHistoryDetailModel.EvaluateInfoBean.QuestionsBean.ChildrenBean)this.c.get(paramInt)).options != null) && (((MyEvaHistoryDetailModel.EvaluateInfoBean.QuestionsBean.ChildrenBean)this.c.get(paramInt)).options.size() == 3))
      {
        paramViewGroup.d.setText(((MyEvaHistoryDetailModel.EvaluateInfoBean.QuestionsBean.ChildrenBean.OptionsBean)((MyEvaHistoryDetailModel.EvaluateInfoBean.QuestionsBean.ChildrenBean)this.c.get(paramInt)).options.get(0)).desc);
        paramViewGroup.c.setText(((MyEvaHistoryDetailModel.EvaluateInfoBean.QuestionsBean.ChildrenBean.OptionsBean)((MyEvaHistoryDetailModel.EvaluateInfoBean.QuestionsBean.ChildrenBean)this.c.get(paramInt)).options.get(1)).desc);
        paramViewGroup.e.setText(((MyEvaHistoryDetailModel.EvaluateInfoBean.QuestionsBean.ChildrenBean.OptionsBean)((MyEvaHistoryDetailModel.EvaluateInfoBean.QuestionsBean.ChildrenBean)this.c.get(paramInt)).options.get(2)).desc);
        if ((((MyEvaHistoryDetailModel.EvaluateInfoBean.QuestionsBean.ChildrenBean)this.c.get(paramInt)).answers != null) && (((MyEvaHistoryDetailModel.EvaluateInfoBean.QuestionsBean.ChildrenBean)this.c.get(paramInt)).answers.size() > 0))
        {
          if (!((MyEvaHistoryDetailModel.EvaluateInfoBean.QuestionsBean.ChildrenBean.OptionsBean)((MyEvaHistoryDetailModel.EvaluateInfoBean.QuestionsBean.ChildrenBean)this.c.get(paramInt)).options.get(0)).code.equals(((MyEvaHistoryDetailModel.EvaluateInfoBean.QuestionsBean.ChildrenBean.AnswersBean)((MyEvaHistoryDetailModel.EvaluateInfoBean.QuestionsBean.ChildrenBean)this.c.get(paramInt)).answers.get(0)).optionAnswerId)) {
            break;
          }
          setButtonStatus(paramViewGroup.d, paramViewGroup.c, paramViewGroup.e);
        }
      }
      return localView;
      paramViewGroup = (a)paramView.getTag();
      localView = paramView;
    }
    if (((MyEvaHistoryDetailModel.EvaluateInfoBean.QuestionsBean.ChildrenBean.OptionsBean)((MyEvaHistoryDetailModel.EvaluateInfoBean.QuestionsBean.ChildrenBean)this.c.get(paramInt)).options.get(1)).code.equals(((MyEvaHistoryDetailModel.EvaluateInfoBean.QuestionsBean.ChildrenBean.AnswersBean)((MyEvaHistoryDetailModel.EvaluateInfoBean.QuestionsBean.ChildrenBean)this.c.get(paramInt)).answers.get(0)).optionAnswerId))
    {
      setButtonStatus(paramViewGroup.c, paramViewGroup.d, paramViewGroup.e);
      return localView;
    }
    if (((MyEvaHistoryDetailModel.EvaluateInfoBean.QuestionsBean.ChildrenBean.OptionsBean)((MyEvaHistoryDetailModel.EvaluateInfoBean.QuestionsBean.ChildrenBean)this.c.get(paramInt)).options.get(2)).code.equals(((MyEvaHistoryDetailModel.EvaluateInfoBean.QuestionsBean.ChildrenBean.AnswersBean)((MyEvaHistoryDetailModel.EvaluateInfoBean.QuestionsBean.ChildrenBean)this.c.get(paramInt)).answers.get(0)).optionAnswerId))
    {
      setButtonStatus(paramViewGroup.e, paramViewGroup.d, paramViewGroup.c);
      return localView;
    }
    setButtonGray(paramViewGroup.d);
    setButtonGray(paramViewGroup.c);
    setButtonGray(paramViewGroup.e);
    return localView;
  }
  
  public List<MyEvaHistoryDetailModel.EvaluateInfoBean.QuestionsBean.ChildrenBean> getmData()
  {
    return this.c;
  }
  
  public void setButtonGray(Button paramButton)
  {
    paramButton.setTextColor(this.b.getResources().getColor(2131624604));
    paramButton.setBackgroundResource(2130837825);
  }
  
  public void setButtonLight(Button paramButton)
  {
    paramButton.setTextColor(this.b.getResources().getColor(2131624609));
    paramButton.setBackgroundResource(2130837824);
  }
  
  public void setButtonStatus(Button paramButton1, Button paramButton2, Button paramButton3)
  {
    setButtonLight(paramButton1);
    setButtonGray(paramButton2);
    setButtonGray(paramButton3);
  }
  
  public void setDatas(List<MyEvaHistoryDetailModel.EvaluateInfoBean.QuestionsBean.ChildrenBean> paramList)
  {
    this.c = paramList;
    notifyDataSetChanged();
  }
  
  public static class a
  {
    public View a;
    public TextView b;
    public Button c;
    public Button d;
    public Button e;
    
    public a(View paramView)
    {
      this.a = paramView;
      this.b = ((TextView)paramView.findViewById(2131695383));
      this.c = ((Button)paramView.findViewById(2131695385));
      this.d = ((Button)paramView.findViewById(2131695384));
      this.e = ((Button)paramView.findViewById(2131695386));
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/my/adapter/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */