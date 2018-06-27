package com.ziroom.ziroomcustomer.newclean.c;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class a
  extends Dialog
{
  private Context a;
  private List<com.ziroom.ziroomcustomer.newclean.d.a> b = new ArrayList();
  private TextView c;
  private TextView d;
  
  public a(Context paramContext, List<com.ziroom.ziroomcustomer.newclean.d.a> paramList)
  {
    super(paramContext, 2131427692);
    this.a = paramContext;
    this.b = paramList;
    setDefaultSetting();
  }
  
  private void a()
  {
    View localView = LayoutInflater.from(this.a).inflate(2130903495, null);
    ListView localListView = (ListView)localView.findViewById(2131689844);
    this.d = ((TextView)localView.findViewById(2131689840));
    this.c = ((TextView)localView.findViewById(2131692407));
    LinearLayout localLinearLayout = (LinearLayout)localView.findViewById(2131692406);
    a(this.b);
    localListView.setAdapter(new b());
    localLinearLayout.setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        a.this.dismiss();
      }
    });
    setContentView(localView);
  }
  
  private void a(List<com.ziroom.ziroomcustomer.newclean.d.a> paramList)
  {
    paramList = paramList.iterator();
    int j = 0;
    int i = 0;
    if (paramList.hasNext())
    {
      com.ziroom.ziroomcustomer.newclean.d.a locala = (com.ziroom.ziroomcustomer.newclean.d.a)paramList.next();
      if (locala.isIsArea() == true) {
        j = 1;
      }
      if (locala.getAreaFlag() != 1) {
        break label150;
      }
      int k = locala.getPrice();
      i = locala.getNumber() * k + i;
    }
    label150:
    for (;;)
    {
      break;
      if (j == 1)
      {
        this.d.setText("待确认");
        this.d.setTextColor(40960);
        this.c.setVisibility(8);
        return;
      }
      this.c.setText(i + "");
      this.d.setVisibility(0);
      this.d.setTextColor(-12303292);
      return;
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    a();
  }
  
  public void setDefaultSetting()
  {
    setCanceledOnTouchOutside(true);
    Window localWindow = getWindow();
    localWindow.getDecorView().setPadding(0, 0, 0, 0);
    WindowManager.LayoutParams localLayoutParams = localWindow.getAttributes();
    localLayoutParams.width = -1;
    localLayoutParams.height = -1;
    localWindow.setAttributes(localLayoutParams);
    localWindow.getDecorView().setBackgroundColor(-1);
    localWindow.setGravity(80);
  }
  
  public class a
  {
    public TextView a;
    public TextView b;
    
    public a() {}
  }
  
  class b
    extends BaseAdapter
  {
    b() {}
    
    public int getCount()
    {
      return a.a(a.this).size();
    }
    
    public Object getItem(int paramInt)
    {
      return a.a(a.this).get(paramInt);
    }
    
    public long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      com.ziroom.ziroomcustomer.newclean.d.a locala;
      if (paramView == null)
      {
        paramView = View.inflate(a.b(a.this), 2130904116, null);
        paramViewGroup = new a.a(a.this);
        paramViewGroup.a = ((TextView)paramView.findViewById(2131690049));
        paramViewGroup.b = ((TextView)paramView.findViewById(2131689912));
        paramView.setTag(paramViewGroup);
        locala = (com.ziroom.ziroomcustomer.newclean.d.a)a.a(a.this).get(paramInt);
        if (locala.getAreaFlag() != 0) {
          break label121;
        }
        paramViewGroup.a.setText(locala.getName());
        paramViewGroup.b.setText("待确认");
      }
      label121:
      while (1 != locala.getAreaFlag())
      {
        return paramView;
        paramViewGroup = (a.a)paramView.getTag();
        break;
      }
      paramViewGroup.a.setText(locala.getName() + "*" + locala.getNumber());
      paramViewGroup = paramViewGroup.b;
      StringBuilder localStringBuilder = new StringBuilder();
      paramInt = locala.getPrice();
      paramViewGroup.setText(locala.getNumber() * paramInt + "元");
      return paramView;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newclean/c/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */