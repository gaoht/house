package com.ziroom.ziroomcustomer.newclean.b;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.TextView;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.newclean.d.be;
import com.ziroom.ziroomcustomer.newclean.d.be.a;
import com.ziroom.ziroomcustomer.newclean.d.be.b;
import com.ziroom.ziroomcustomer.util.u;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class aa
  extends BaseAdapter
{
  private Map<String, Integer> a = new HashMap();
  private be b;
  private Context c;
  private LayoutInflater d;
  
  public aa(Context paramContext, be parambe)
  {
    this.c = paramContext;
    this.d = LayoutInflater.from(this.c);
    this.b = parambe;
    u.d("QuestionnaireAdapter", "======:" + this.b);
  }
  
  public int getCount()
  {
    if ((this.b != null) && (this.b.getPointItems() != null) && (this.b.getPointItems().size() > 0)) {
      return this.b.getPointItems().size();
    }
    return 0;
  }
  
  public Object getItem(int paramInt)
  {
    return this.b.getPointItems().get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public Map<String, Integer> getSelectedData()
  {
    return this.a;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    final be.a locala = (be.a)this.b.getPointItems().get(paramInt);
    final List localList = this.b.getSelectItems();
    if (paramView == null)
    {
      paramView = this.d.inflate(2130904514, paramViewGroup, false);
      paramViewGroup = new a(null);
      paramViewGroup.a = ((TextView)paramView.findViewById(2131695659));
      paramViewGroup.b = ((TextView)paramView.findViewById(2131690409));
      paramViewGroup.c = ((RadioGroup)paramView.findViewById(2131691292));
      paramViewGroup.d = ((RadioButton)paramView.findViewById(2131695660));
      paramViewGroup.e = ((RadioButton)paramView.findViewById(2131695661));
      paramViewGroup.f = ((RadioButton)paramView.findViewById(2131695662));
      paramView.setTag(paramViewGroup);
    }
    for (;;)
    {
      paramViewGroup.a.setText(paramInt + 1 + "、");
      paramViewGroup.b.setText(locala.getFpointitem());
      if ((localList == null) || (localList.size() != 3)) {
        break;
      }
      paramViewGroup.c.setVisibility(0);
      paramViewGroup.d.setText(((be.b)localList.get(0)).getName());
      paramViewGroup.e.setText(((be.b)localList.get(1)).getName());
      paramViewGroup.f.setText(((be.b)localList.get(2)).getName());
      paramViewGroup.c.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
      {
        @Instrumented
        public void onCheckedChanged(RadioGroup paramAnonymousRadioGroup, int paramAnonymousInt)
        {
          VdsAgent.onCheckedChanged(this, paramAnonymousRadioGroup, paramAnonymousInt);
          paramAnonymousRadioGroup = null;
          switch (paramAnonymousInt)
          {
          }
          for (;;)
          {
            if (paramAnonymousRadioGroup != null) {
              aa.a(aa.this).put(locala.getFid(), Integer.valueOf(paramAnonymousRadioGroup.getValue()));
            }
            return;
            paramAnonymousRadioGroup = (be.b)localList.get(0);
            continue;
            paramAnonymousRadioGroup = (be.b)localList.get(1);
            continue;
            paramAnonymousRadioGroup = (be.b)localList.get(2);
          }
        }
      });
      return paramView;
      paramViewGroup = (a)paramView.getTag();
    }
    paramViewGroup.c.clearCheck();
    paramViewGroup.c.setVisibility(8);
    return paramView;
  }
  
  public boolean isAllSelected()
  {
    return (this.b == null) || (this.b.getPointItems() == null) || (this.b.getPointItems().size() <= 0) || (this.a.size() == this.b.getPointItems().size());
  }
  
  public void setData(be parambe)
  {
    this.b = parambe;
    notifyDataSetChanged();
  }
  
  private class a
  {
    public TextView a;
    public TextView b;
    public RadioGroup c;
    public RadioButton d;
    public RadioButton e;
    public RadioButton f;
    
    private a() {}
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newclean/b/aa.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */