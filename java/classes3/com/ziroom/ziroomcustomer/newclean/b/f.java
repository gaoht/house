package com.ziroom.ziroomcustomer.newclean.b;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.ziroom.ziroomcustomer.newServiceList.utils.j;
import com.ziroom.ziroomcustomer.newServiceList.view.LvNestListView;
import com.ziroom.ziroomcustomer.newclean.d.k;
import com.ziroom.ziroomcustomer.newmovehouse.widget.FlowLayout;
import java.util.ArrayList;
import java.util.List;

public class f
  extends BaseAdapter
{
  private Context a;
  private List<k> b;
  
  public f(Context paramContext, List<k> paramList)
  {
    this.a = paramContext;
    this.b = paramList;
  }
  
  public int getCount()
  {
    return this.b.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.b.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject;
    List localList;
    ArrayList localArrayList1;
    ArrayList localArrayList2;
    if (paramView == null)
    {
      paramView = View.inflate(this.a, 2130904139, null);
      paramViewGroup = new a();
      paramViewGroup.a = ((FlowLayout)paramView.findViewById(2131694869));
      paramViewGroup.b = ((TextView)paramView.findViewById(2131689852));
      paramViewGroup.c = ((FlowLayout)paramView.findViewById(2131694870));
      paramViewGroup.d = ((TextView)paramView.findViewById(2131694871));
      paramViewGroup.e = ((ImageView)paramView.findViewById(2131690054));
      paramViewGroup.f = ((ImageView)paramView.findViewById(2131690055));
      paramViewGroup.g = ((ImageView)paramView.findViewById(2131690056));
      paramViewGroup.h = ((ImageView)paramView.findViewById(2131690057));
      paramViewGroup.i = ((ImageView)paramView.findViewById(2131690058));
      paramViewGroup.j = ((LvNestListView)paramView.findViewById(2131694872));
      paramView.setTag(paramViewGroup);
      localObject = (k)this.b.get(paramInt);
      if (TextUtils.isEmpty(((k)localObject).getTags())) {
        break label527;
      }
      paramViewGroup.a.setVisibility(8);
      localList = j.getCutApart(((k)localObject).getTags(), ";");
      localArrayList1 = new ArrayList();
      localArrayList2 = new ArrayList();
      if (localList.size() > 0)
      {
        paramViewGroup.a.setVisibility(0);
        paramViewGroup.a.removeAllViews();
        if (localList.size() >= 4) {
          break label423;
        }
        paramViewGroup.c.setVisibility(8);
        j.addFlke(this.a, localList, paramViewGroup.a);
      }
      label282:
      paramViewGroup.b.setText(((k)localObject).getEvaluateDate());
      if (TextUtils.isEmpty(((k)localObject).getEvaluateContent())) {
        break label548;
      }
      paramViewGroup.d.setVisibility(0);
      paramViewGroup.d.setText(((k)localObject).getEvaluateContent());
      if (TextUtils.isEmpty(((k)localObject).getSocre())) {
        break label570;
      }
    }
    for (;;)
    {
      try
      {
        j.getStar(Integer.parseInt(((k)localObject).getSocre()), paramViewGroup.e, paramViewGroup.f, paramViewGroup.g, paramViewGroup.h, paramViewGroup.i);
        if (((k)localObject).getSlaveEntities() == null) {
          break label597;
        }
        paramViewGroup.j.setVisibility(0);
        localObject = new h(this.a, ((k)localObject).getSlaveEntities());
        paramViewGroup.j.setAdapter((ListAdapter)localObject);
        return paramView;
        paramViewGroup = (a)paramView.getTag();
        break;
        label423:
        paramViewGroup.c.setVisibility(0);
        paramViewGroup.c.removeAllViews();
        paramInt = 0;
        if (paramInt < localList.size())
        {
          if (paramInt < 3)
          {
            localArrayList1.add(localList.get(paramInt));
            paramInt += 1;
            continue;
          }
          localArrayList2.add(localList.get(paramInt));
          continue;
        }
        j.addFlke(this.a, localArrayList1, paramViewGroup.a);
        j.addShowFlke(this.a, localArrayList2, paramViewGroup.c);
        break label282;
        label527:
        paramViewGroup.a.setVisibility(8);
        paramViewGroup.c.setVisibility(8);
        break label282;
        label548:
        paramViewGroup.d.setVisibility(8);
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        continue;
      }
      label570:
      j.getStar(5, paramViewGroup.e, paramViewGroup.f, paramViewGroup.g, paramViewGroup.h, paramViewGroup.i);
    }
    label597:
    paramViewGroup.j.setVisibility(8);
    return paramView;
  }
  
  public class a
  {
    public FlowLayout a;
    public TextView b;
    public FlowLayout c;
    public TextView d;
    public ImageView e;
    public ImageView f;
    public ImageView g;
    public ImageView h;
    public ImageView i;
    public LvNestListView j;
    
    public a() {}
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newclean/b/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */