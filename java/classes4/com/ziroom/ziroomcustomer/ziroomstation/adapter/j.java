package com.ziroom.ziroomcustomer.ziroomstation.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.ziroom.ziroomcustomer.util.u;
import com.ziroom.ziroomcustomer.ziroomstation.StationEvaluateActivity.b;
import com.ziroom.ziroomcustomer.ziroomstation.model.GetEvaluateInfoModel.QuestionsBean.ChildrenBean;
import com.ziroom.ziroomcustomer.ziroomstation.model.GetEvaluateInfoModel.QuestionsBean.ChildrenBean.OptionsBean;
import com.ziroom.ziroomcustomer.ziroomstation.utils.b;
import com.ziroom.ziroomcustomer.ziroomstation.widget.StationEvaluteButton;
import com.ziroom.ziroomcustomer.ziroomstation.widget.StationEvaluteButton.a;
import java.util.Iterator;
import java.util.List;

public class j
  extends BaseAdapter
{
  private String a = j.class.getSimpleName();
  private Context b;
  private List<GetEvaluateInfoModel.QuestionsBean.ChildrenBean> c;
  private LayoutInflater d;
  private String[] e = b.a;
  private StationEvaluateActivity.b f;
  
  public j(List<GetEvaluateInfoModel.QuestionsBean.ChildrenBean> paramList, Context paramContext, StationEvaluateActivity.b paramb)
  {
    this.c = paramList;
    this.b = paramContext;
    this.f = paramb;
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
  
  public View getView(final int paramInt, View paramView, final ViewGroup paramViewGroup)
  {
    View localView;
    if (paramView == null)
    {
      localView = this.d.inflate(2130904543, paramViewGroup, false);
      paramView = new a(localView);
      localView.setTag(paramView);
      paramViewGroup = paramView;
    }
    for (;;)
    {
      paramViewGroup.b.setText(((GetEvaluateInfoModel.QuestionsBean.ChildrenBean)this.c.get(paramInt)).label);
      paramViewGroup.c.initRatingBtn(null, 2130839775, 2130839774, new StationEvaluteButton.a()
      {
        public void onSwitch(int paramAnonymousInt)
        {
          if (j.a(j.this) != null) {
            j.a(j.this).checked();
          }
          if ((paramAnonymousInt >= 1) && (paramAnonymousInt <= 5))
          {
            paramViewGroup.d.setText(j.b(j.this)[(paramAnonymousInt - 1)]);
            ((GetEvaluateInfoModel.QuestionsBean.ChildrenBean)j.c(j.this).get(paramInt)).curScore = (paramAnonymousInt + "");
            Iterator localIterator = ((GetEvaluateInfoModel.QuestionsBean.ChildrenBean)j.c(j.this).get(paramInt)).options.iterator();
            while (localIterator.hasNext())
            {
              GetEvaluateInfoModel.QuestionsBean.ChildrenBean.OptionsBean localOptionsBean = (GetEvaluateInfoModel.QuestionsBean.ChildrenBean.OptionsBean)localIterator.next();
              if ((paramAnonymousInt + "").equals(localOptionsBean.desc))
              {
                ((GetEvaluateInfoModel.QuestionsBean.ChildrenBean)j.c(j.this).get(paramInt)).curScoreCode = localOptionsBean.code;
                u.i(j.d(j.this), "赋值mData.get(i).curScore" + ((GetEvaluateInfoModel.QuestionsBean.ChildrenBean)j.c(j.this).get(paramInt)).curScore + ";mData.get(i).curScoreCode" + ((GetEvaluateInfoModel.QuestionsBean.ChildrenBean)j.c(j.this).get(paramInt)).curScoreCode);
              }
            }
            u.i(j.d(j.this), "得分state:" + paramAnonymousInt + ";mData.get(i).curScore" + ((GetEvaluateInfoModel.QuestionsBean.ChildrenBean)j.c(j.this).get(paramInt)).curScore + ";mData.get(i).curScoreCode" + ((GetEvaluateInfoModel.QuestionsBean.ChildrenBean)j.c(j.this).get(paramInt)).curScoreCode);
          }
        }
      });
      return localView;
      paramViewGroup = (a)paramView.getTag();
      localView = paramView;
    }
  }
  
  public List<GetEvaluateInfoModel.QuestionsBean.ChildrenBean> getmData()
  {
    return this.c;
  }
  
  public void setDatas(List<GetEvaluateInfoModel.QuestionsBean.ChildrenBean> paramList)
  {
    this.c = paramList;
    notifyDataSetChanged();
  }
  
  public static class a
  {
    public View a;
    public TextView b;
    public StationEvaluteButton c;
    public TextView d;
    public RelativeLayout e;
    
    public a(View paramView)
    {
      this.a = paramView;
      this.b = ((TextView)paramView.findViewById(2131695695));
      this.c = ((StationEvaluteButton)paramView.findViewById(2131691856));
      this.d = ((TextView)paramView.findViewById(2131695696));
      this.e = ((RelativeLayout)paramView.findViewById(2131695694));
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes4-dex2jar.jar!/com/ziroom/ziroomcustomer/ziroomstation/adapter/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */