package com.ziroom.ziroomcustomer.my.adapter;

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
import com.ziroom.ziroomcustomer.my.model.MyEvaluateGetModel.EvaluateInfoBean.QuestionsBean.ChildrenBean;
import com.ziroom.ziroomcustomer.my.model.MyEvaluateGetModel.EvaluateInfoBean.QuestionsBean.ChildrenBean.OptionsBean;
import java.util.List;

public class a
  extends BaseAdapter
{
  private String a = a.class.getSimpleName();
  private Context b;
  private List<MyEvaluateGetModel.EvaluateInfoBean.QuestionsBean.ChildrenBean> c;
  private LayoutInflater d;
  private boolean e = true;
  
  public a(Context paramContext, List<MyEvaluateGetModel.EvaluateInfoBean.QuestionsBean.ChildrenBean> paramList)
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
      localView = this.d.inflate(2130904383, paramViewGroup, false);
      paramView = new a(localView);
      localView.setTag(paramView);
      paramViewGroup = paramView;
      paramViewGroup.b.setText(((MyEvaluateGetModel.EvaluateInfoBean.QuestionsBean.ChildrenBean)this.c.get(paramInt)).label);
      if ((((MyEvaluateGetModel.EvaluateInfoBean.QuestionsBean.ChildrenBean)this.c.get(paramInt)).options != null) && (((MyEvaluateGetModel.EvaluateInfoBean.QuestionsBean.ChildrenBean)this.c.get(paramInt)).options.size() == 3))
      {
        paramViewGroup.d.setText(((MyEvaluateGetModel.EvaluateInfoBean.QuestionsBean.ChildrenBean.OptionsBean)((MyEvaluateGetModel.EvaluateInfoBean.QuestionsBean.ChildrenBean)this.c.get(paramInt)).options.get(0)).desc);
        paramViewGroup.c.setText(((MyEvaluateGetModel.EvaluateInfoBean.QuestionsBean.ChildrenBean.OptionsBean)((MyEvaluateGetModel.EvaluateInfoBean.QuestionsBean.ChildrenBean)this.c.get(paramInt)).options.get(1)).desc);
        paramViewGroup.e.setText(((MyEvaluateGetModel.EvaluateInfoBean.QuestionsBean.ChildrenBean.OptionsBean)((MyEvaluateGetModel.EvaluateInfoBean.QuestionsBean.ChildrenBean)this.c.get(paramInt)).options.get(2)).desc);
        if (!((MyEvaluateGetModel.EvaluateInfoBean.QuestionsBean.ChildrenBean.OptionsBean)((MyEvaluateGetModel.EvaluateInfoBean.QuestionsBean.ChildrenBean)this.c.get(paramInt)).options.get(0)).desc.equals(((MyEvaluateGetModel.EvaluateInfoBean.QuestionsBean.ChildrenBean)this.c.get(paramInt)).curSelDesc)) {
          break label348;
        }
        setButtonStatus(paramViewGroup.d, paramViewGroup.c, paramViewGroup.e);
      }
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
            if (!((MyEvaluateGetModel.EvaluateInfoBean.QuestionsBean.ChildrenBean.OptionsBean)((MyEvaluateGetModel.EvaluateInfoBean.QuestionsBean.ChildrenBean)a.a(a.this).get(paramInt)).options.get(0)).desc.equals(((MyEvaluateGetModel.EvaluateInfoBean.QuestionsBean.ChildrenBean)a.a(a.this).get(paramInt)).curSelDesc))
            {
              ((MyEvaluateGetModel.EvaluateInfoBean.QuestionsBean.ChildrenBean)a.a(a.this).get(paramInt)).curSelCode = ((MyEvaluateGetModel.EvaluateInfoBean.QuestionsBean.ChildrenBean.OptionsBean)((MyEvaluateGetModel.EvaluateInfoBean.QuestionsBean.ChildrenBean)a.a(a.this).get(paramInt)).options.get(0)).code;
              ((MyEvaluateGetModel.EvaluateInfoBean.QuestionsBean.ChildrenBean)a.a(a.this).get(paramInt)).curSelDesc = ((MyEvaluateGetModel.EvaluateInfoBean.QuestionsBean.ChildrenBean.OptionsBean)((MyEvaluateGetModel.EvaluateInfoBean.QuestionsBean.ChildrenBean)a.a(a.this).get(paramInt)).options.get(0)).desc;
            }
            a.this.setButtonStatus(paramViewGroup.d, paramViewGroup.c, paramViewGroup.e);
          }
        });
        paramViewGroup.c.setOnClickListener(new View.OnClickListener()
        {
          @Instrumented
          public void onClick(View paramAnonymousView)
          {
            VdsAgent.onClick(this, paramAnonymousView);
            if (!((MyEvaluateGetModel.EvaluateInfoBean.QuestionsBean.ChildrenBean.OptionsBean)((MyEvaluateGetModel.EvaluateInfoBean.QuestionsBean.ChildrenBean)a.a(a.this).get(paramInt)).options.get(1)).desc.equals(((MyEvaluateGetModel.EvaluateInfoBean.QuestionsBean.ChildrenBean)a.a(a.this).get(paramInt)).curSelDesc))
            {
              ((MyEvaluateGetModel.EvaluateInfoBean.QuestionsBean.ChildrenBean)a.a(a.this).get(paramInt)).curSelCode = ((MyEvaluateGetModel.EvaluateInfoBean.QuestionsBean.ChildrenBean.OptionsBean)((MyEvaluateGetModel.EvaluateInfoBean.QuestionsBean.ChildrenBean)a.a(a.this).get(paramInt)).options.get(1)).code;
              ((MyEvaluateGetModel.EvaluateInfoBean.QuestionsBean.ChildrenBean)a.a(a.this).get(paramInt)).curSelDesc = ((MyEvaluateGetModel.EvaluateInfoBean.QuestionsBean.ChildrenBean.OptionsBean)((MyEvaluateGetModel.EvaluateInfoBean.QuestionsBean.ChildrenBean)a.a(a.this).get(paramInt)).options.get(1)).desc;
            }
            a.this.setButtonStatus(paramViewGroup.c, paramViewGroup.d, paramViewGroup.e);
          }
        });
        paramViewGroup.e.setOnClickListener(new View.OnClickListener()
        {
          @Instrumented
          public void onClick(View paramAnonymousView)
          {
            VdsAgent.onClick(this, paramAnonymousView);
            if (!((MyEvaluateGetModel.EvaluateInfoBean.QuestionsBean.ChildrenBean.OptionsBean)((MyEvaluateGetModel.EvaluateInfoBean.QuestionsBean.ChildrenBean)a.a(a.this).get(paramInt)).options.get(2)).desc.equals(((MyEvaluateGetModel.EvaluateInfoBean.QuestionsBean.ChildrenBean)a.a(a.this).get(paramInt)).curSelDesc))
            {
              ((MyEvaluateGetModel.EvaluateInfoBean.QuestionsBean.ChildrenBean)a.a(a.this).get(paramInt)).curSelCode = ((MyEvaluateGetModel.EvaluateInfoBean.QuestionsBean.ChildrenBean.OptionsBean)((MyEvaluateGetModel.EvaluateInfoBean.QuestionsBean.ChildrenBean)a.a(a.this).get(paramInt)).options.get(2)).code;
              ((MyEvaluateGetModel.EvaluateInfoBean.QuestionsBean.ChildrenBean)a.a(a.this).get(paramInt)).curSelDesc = ((MyEvaluateGetModel.EvaluateInfoBean.QuestionsBean.ChildrenBean.OptionsBean)((MyEvaluateGetModel.EvaluateInfoBean.QuestionsBean.ChildrenBean)a.a(a.this).get(paramInt)).options.get(2)).desc;
            }
            a.this.setButtonStatus(paramViewGroup.e, paramViewGroup.d, paramViewGroup.c);
          }
        });
      }
      return localView;
      paramViewGroup = (a)paramView.getTag();
      localView = paramView;
      break;
      label348:
      if (((MyEvaluateGetModel.EvaluateInfoBean.QuestionsBean.ChildrenBean.OptionsBean)((MyEvaluateGetModel.EvaluateInfoBean.QuestionsBean.ChildrenBean)this.c.get(paramInt)).options.get(1)).desc.equals(((MyEvaluateGetModel.EvaluateInfoBean.QuestionsBean.ChildrenBean)this.c.get(paramInt)).curSelDesc))
      {
        setButtonStatus(paramViewGroup.c, paramViewGroup.d, paramViewGroup.e);
      }
      else if (((MyEvaluateGetModel.EvaluateInfoBean.QuestionsBean.ChildrenBean.OptionsBean)((MyEvaluateGetModel.EvaluateInfoBean.QuestionsBean.ChildrenBean)this.c.get(paramInt)).options.get(2)).desc.equals(((MyEvaluateGetModel.EvaluateInfoBean.QuestionsBean.ChildrenBean)this.c.get(paramInt)).curSelDesc))
      {
        setButtonStatus(paramViewGroup.e, paramViewGroup.d, paramViewGroup.c);
      }
      else
      {
        setButtonGray(paramViewGroup.d);
        setButtonGray(paramViewGroup.c);
        setButtonGray(paramViewGroup.e);
      }
    }
  }
  
  public List<MyEvaluateGetModel.EvaluateInfoBean.QuestionsBean.ChildrenBean> getmData()
  {
    return this.c;
  }
  
  public void setButtonGray(Button paramButton)
  {
    paramButton.setTextColor(this.b.getResources().getColor(2131624601));
    paramButton.setBackgroundResource(2130837822);
  }
  
  public void setButtonLight(Button paramButton)
  {
    paramButton.setTextColor(this.b.getResources().getColor(2131624609));
    paramButton.setBackgroundResource(2130837823);
  }
  
  public void setButtonStatus(Button paramButton1, Button paramButton2, Button paramButton3)
  {
    setButtonLight(paramButton1);
    setButtonGray(paramButton2);
    setButtonGray(paramButton3);
  }
  
  public void setDatas(List<MyEvaluateGetModel.EvaluateInfoBean.QuestionsBean.ChildrenBean> paramList)
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


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/my/adapter/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */