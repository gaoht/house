package com.ziroom.ziroomcustomer.newchat.chatcenter;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.model.UserInfo;
import com.ziroom.ziroomcustomer.newchat.chatcenter.activity.ComplainDetailActivity;
import java.util.List;

public class e
  extends BaseAdapter
{
  private Context a;
  private List<l> b;
  private UserInfo c;
  
  public e(Context paramContext, List<l> paramList)
  {
    this.a = paramContext;
    this.b = paramList;
    this.c = ApplicationEx.c.getUser();
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
    final l locall;
    if (paramView == null)
    {
      paramView = View.inflate(this.a, 2130904387, null);
      paramViewGroup = new a();
      paramViewGroup.a = ((TextView)paramView.findViewById(2131689852));
      paramViewGroup.b = ((TextView)paramView.findViewById(2131690407));
      paramViewGroup.c = ((TextView)paramView.findViewById(2131695389));
      paramViewGroup.d = ((TextView)paramView.findViewById(2131695396));
      paramViewGroup.e = ((RelativeLayout)paramView.findViewById(2131695395));
      paramViewGroup.f = paramView.findViewById(2131695394);
      paramViewGroup.g = ((TextView)paramView.findViewById(2131695393));
      paramViewGroup.i = ((RelativeLayout)paramView.findViewById(2131695391));
      paramViewGroup.h = ((TextView)paramView.findViewById(2131695392));
      paramView.setTag(paramViewGroup);
      locall = (l)this.b.get(paramInt);
      paramViewGroup.a.setText(locall.getSubmitDate());
      paramViewGroup.b.setText(locall.getState());
      paramViewGroup.c.setText(locall.getComplainProblem());
      if (locall.getLastGjjl() == null) {
        break label349;
      }
      if (TextUtils.isEmpty(locall.getLastGjjl().getContent())) {
        break label328;
      }
      paramViewGroup.e.setVisibility(0);
      paramViewGroup.f.setVisibility(0);
      paramViewGroup.d.setText(locall.getLastGjjl().getContent());
      label247:
      if (TextUtils.isEmpty(locall.getQuesUpgState())) {
        break label433;
      }
    }
    for (;;)
    {
      try
      {
        paramInt = Integer.parseInt(locall.getQuesUpgState());
        if (paramInt != 2) {
          continue;
        }
        paramViewGroup.i.setVisibility(0);
        paramViewGroup.h.setText("受理倒计时：");
        paramViewGroup.g.setText(locall.getLittleTime());
      }
      catch (Exception paramViewGroup)
      {
        label328:
        label349:
        paramViewGroup.printStackTrace();
        continue;
        paramViewGroup.i.setVisibility(0);
        paramViewGroup.h.setText("处理倒计时：");
        paramViewGroup.g.setText(locall.getLittleTime());
        continue;
      }
      paramView.setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          paramAnonymousView = new Intent(e.a(e.this), ComplainDetailActivity.class);
          paramAnonymousView.putExtra("consultId", locall.getConsultId());
          e.a(e.this).startActivity(paramAnonymousView);
        }
      });
      return paramView;
      paramViewGroup = (a)paramView.getTag();
      break;
      paramViewGroup.e.setVisibility(8);
      paramViewGroup.f.setVisibility(8);
      break label247;
      paramViewGroup.e.setVisibility(8);
      paramViewGroup.f.setVisibility(8);
      break label247;
      if ((paramInt == 5) || (paramInt == 6)) {
        paramViewGroup.i.setVisibility(8);
      } else {
        label433:
        paramViewGroup.i.setVisibility(8);
      }
    }
  }
  
  public class a
  {
    public TextView a;
    public TextView b;
    public TextView c;
    public TextView d;
    public RelativeLayout e;
    public View f;
    public TextView g;
    public TextView h;
    public RelativeLayout i;
    
    public a() {}
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newchat/chatcenter/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */