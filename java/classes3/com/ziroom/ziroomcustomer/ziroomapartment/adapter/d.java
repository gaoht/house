package com.ziroom.ziroomcustomer.ziroomapartment.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.ziroomapartment.model.ZryuEvaluateGetModel.DataBean.QuestionsBean.ChildrenBean;
import com.ziroom.ziroomcustomer.ziroomapartment.model.ZryuEvaluateGetModel.DataBean.QuestionsBean.ChildrenBean.OptionsBean;
import java.util.Iterator;
import java.util.List;

public class d
  extends BaseAdapter
{
  private String a = d.class.getSimpleName();
  private Context b;
  private List<ZryuEvaluateGetModel.DataBean.QuestionsBean.ChildrenBean> c;
  private LayoutInflater d;
  private boolean e = true;
  
  public d(Context paramContext, List<ZryuEvaluateGetModel.DataBean.QuestionsBean.ChildrenBean> paramList)
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
  
  public View getView(final int paramInt, View paramView, final ViewGroup paramViewGroup)
  {
    View localView;
    if (paramView == null)
    {
      localView = this.d.inflate(2130904610, paramViewGroup, false);
      paramView = new a(localView);
      localView.setTag(paramView);
      paramViewGroup = paramView;
      paramViewGroup.b.setText(((ZryuEvaluateGetModel.DataBean.QuestionsBean.ChildrenBean)this.c.get(paramInt)).label);
      if (!"是".equals(((ZryuEvaluateGetModel.DataBean.QuestionsBean.ChildrenBean)this.c.get(paramInt)).curSelDesc)) {
        break label152;
      }
      setButtonStatus(paramViewGroup.d, paramViewGroup.c);
    }
    for (;;)
    {
      if (this.e)
      {
        paramViewGroup.d.setOnClickListener(new View.OnClickListener()
        {
          @Instrumented
          public void onClick(View paramAnonymousView)
          {
            VdsAgent.onClick(this, paramAnonymousView);
            if (!"是".equals(((ZryuEvaluateGetModel.DataBean.QuestionsBean.ChildrenBean)d.a(d.this).get(paramInt)).curSelDesc))
            {
              paramAnonymousView = ((ZryuEvaluateGetModel.DataBean.QuestionsBean.ChildrenBean)d.a(d.this).get(paramInt)).options.iterator();
              while (paramAnonymousView.hasNext())
              {
                ZryuEvaluateGetModel.DataBean.QuestionsBean.ChildrenBean.OptionsBean localOptionsBean = (ZryuEvaluateGetModel.DataBean.QuestionsBean.ChildrenBean.OptionsBean)paramAnonymousView.next();
                if ("是".equals(localOptionsBean.desc))
                {
                  ((ZryuEvaluateGetModel.DataBean.QuestionsBean.ChildrenBean)d.a(d.this).get(paramInt)).curSelCode = localOptionsBean.code;
                  ((ZryuEvaluateGetModel.DataBean.QuestionsBean.ChildrenBean)d.a(d.this).get(paramInt)).curSelDesc = localOptionsBean.desc;
                }
              }
              d.this.setButtonStatus(paramViewGroup.d, paramViewGroup.c);
            }
          }
        });
        paramViewGroup.c.setOnClickListener(new View.OnClickListener()
        {
          @Instrumented
          public void onClick(View paramAnonymousView)
          {
            VdsAgent.onClick(this, paramAnonymousView);
            if (!"否".equals(((ZryuEvaluateGetModel.DataBean.QuestionsBean.ChildrenBean)d.a(d.this).get(paramInt)).curSelDesc))
            {
              paramAnonymousView = ((ZryuEvaluateGetModel.DataBean.QuestionsBean.ChildrenBean)d.a(d.this).get(paramInt)).options.iterator();
              while (paramAnonymousView.hasNext())
              {
                ZryuEvaluateGetModel.DataBean.QuestionsBean.ChildrenBean.OptionsBean localOptionsBean = (ZryuEvaluateGetModel.DataBean.QuestionsBean.ChildrenBean.OptionsBean)paramAnonymousView.next();
                if ("否".equals(localOptionsBean.desc))
                {
                  ((ZryuEvaluateGetModel.DataBean.QuestionsBean.ChildrenBean)d.a(d.this).get(paramInt)).curSelCode = localOptionsBean.code;
                  ((ZryuEvaluateGetModel.DataBean.QuestionsBean.ChildrenBean)d.a(d.this).get(paramInt)).curSelDesc = localOptionsBean.desc;
                }
              }
              d.this.setButtonStatus(paramViewGroup.c, paramViewGroup.d);
            }
          }
        });
      }
      return localView;
      paramViewGroup = (a)paramView.getTag();
      localView = paramView;
      break;
      label152:
      if ("否".equals(((ZryuEvaluateGetModel.DataBean.QuestionsBean.ChildrenBean)this.c.get(paramInt)).curSelDesc))
      {
        setButtonStatus(paramViewGroup.c, paramViewGroup.d);
      }
      else
      {
        setButtonGray(paramViewGroup.c);
        setButtonGray(paramViewGroup.d);
      }
    }
  }
  
  public List<ZryuEvaluateGetModel.DataBean.QuestionsBean.ChildrenBean> getmData()
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
    paramButton.setTextColor(this.b.getResources().getColor(2131624583));
    paramButton.setBackgroundResource(2130837906);
  }
  
  public void setButtonStatus(Button paramButton1, Button paramButton2)
  {
    setButtonLight(paramButton1);
    setButtonGray(paramButton2);
  }
  
  public void setDatas(List<ZryuEvaluateGetModel.DataBean.QuestionsBean.ChildrenBean> paramList)
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


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/ziroomapartment/adapter/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */