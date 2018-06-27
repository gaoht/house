package com.ziroom.ziroomcustomer.ziroomapartment.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;
import com.ziroom.ziroomcustomer.ziroomapartment.model.ZryuEvaHistoryDetailModel.DataBean.QuestionsBean.ChildrenBean;
import com.ziroom.ziroomcustomer.ziroomapartment.model.ZryuEvaHistoryDetailModel.DataBean.QuestionsBean.ChildrenBean.AnswersBean;
import java.util.List;

public class c
  extends BaseAdapter
{
  private String a = c.class.getSimpleName();
  private Context b;
  private List<ZryuEvaHistoryDetailModel.DataBean.QuestionsBean.ChildrenBean> c;
  private LayoutInflater d;
  
  public c(Context paramContext, List<ZryuEvaHistoryDetailModel.DataBean.QuestionsBean.ChildrenBean> paramList)
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
      localView = this.d.inflate(2130904610, paramViewGroup, false);
      paramView = new a(localView);
      localView.setTag(paramView);
      paramViewGroup = paramView;
    }
    for (;;)
    {
      paramViewGroup.b.setText(((ZryuEvaHistoryDetailModel.DataBean.QuestionsBean.ChildrenBean)this.c.get(paramInt)).label);
      if (!"是".equals(((ZryuEvaHistoryDetailModel.DataBean.QuestionsBean.ChildrenBean.AnswersBean)((ZryuEvaHistoryDetailModel.DataBean.QuestionsBean.ChildrenBean)this.c.get(paramInt)).answers.get(0)).label)) {
        break;
      }
      setButtonStatus(paramViewGroup.d, paramViewGroup.c);
      return localView;
      paramViewGroup = (a)paramView.getTag();
      localView = paramView;
    }
    if ("否".equals(((ZryuEvaHistoryDetailModel.DataBean.QuestionsBean.ChildrenBean.AnswersBean)((ZryuEvaHistoryDetailModel.DataBean.QuestionsBean.ChildrenBean)this.c.get(paramInt)).answers.get(0)).label))
    {
      setButtonStatus(paramViewGroup.c, paramViewGroup.d);
      return localView;
    }
    setButtonGray(paramViewGroup.c);
    setButtonGray(paramViewGroup.d);
    return localView;
  }
  
  public List<ZryuEvaHistoryDetailModel.DataBean.QuestionsBean.ChildrenBean> getmData()
  {
    return this.c;
  }
  
  public void setButtonGray(Button paramButton)
  {
    paramButton.setTextColor(this.b.getResources().getColor(2131624599));
    paramButton.setBackgroundResource(2130837905);
  }
  
  public void setButtonLight(Button paramButton)
  {
    if ("否".equals(paramButton.getText().toString().trim()))
    {
      paramButton.setTextColor(this.b.getResources().getColor(2131624599));
      paramButton.setBackgroundResource(2130837905);
      return;
    }
    paramButton.setTextColor(this.b.getResources().getColor(2131624599));
    paramButton.setBackgroundResource(2130837905);
  }
  
  public void setButtonStatus(Button paramButton1, Button paramButton2)
  {
    paramButton1.setVisibility(0);
    setButtonLight(paramButton1);
    paramButton2.setVisibility(8);
  }
  
  public void setDatas(List<ZryuEvaHistoryDetailModel.DataBean.QuestionsBean.ChildrenBean> paramList)
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
    
    public a(View paramView)
    {
      this.a = paramView;
      this.b = ((TextView)paramView.findViewById(2131695383));
      this.c = ((Button)paramView.findViewById(2131695385));
      this.d = ((Button)paramView.findViewById(2131695384));
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/ziroomapartment/adapter/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */