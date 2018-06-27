package com.ziroom.ziroomcustomer.sharedlife.a;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.sharedlife.activity.SharedLifeEquipmentDetailActivity;
import com.ziroom.ziroomcustomer.sharedlife.activity.SharedLifeIntellectLockActivity;
import com.ziroom.ziroomcustomer.util.ac;
import com.ziroom.ziroomcustomer.util.n;
import java.util.List;

public class c
  extends BaseAdapter
{
  private Context a;
  private List<com.ziroom.ziroomcustomer.sharedlife.c.c.a> b;
  private String c;
  private int d;
  
  public c(Context paramContext, List<com.ziroom.ziroomcustomer.sharedlife.c.c.a> paramList, String paramString)
  {
    this.a = paramContext;
    this.b = paramList;
    this.c = paramString;
    this.d = ac.getScreenWidth(paramContext);
  }
  
  public int getCount()
  {
    if (this.b == null) {
      return 0;
    }
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
    final com.ziroom.ziroomcustomer.sharedlife.c.c.a locala;
    String str;
    RelativeLayout.LayoutParams localLayoutParams;
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.a).inflate(2130904521, paramViewGroup, false);
      paramViewGroup = new a();
      paramViewGroup.f = ((RelativeLayout)paramView.findViewById(2131693872));
      paramViewGroup.a = ((SimpleDraweeView)paramView.findViewById(2131694449));
      paramViewGroup.b = ((TextView)paramView.findViewById(2131689541));
      paramViewGroup.c = ((TextView)paramView.findViewById(2131690073));
      paramViewGroup.d = paramView.findViewById(2131690279);
      paramViewGroup.e = paramView.findViewById(2131689974);
      paramViewGroup.g = ((LinearLayout)paramView.findViewById(2131695664));
      paramView.setTag(paramViewGroup);
      locala = (com.ziroom.ziroomcustomer.sharedlife.c.c.a)this.b.get(paramInt);
      str = locala.getDeviceType();
      paramInt = n.dip2px(this.a, 60.0F);
      localLayoutParams = (RelativeLayout.LayoutParams)paramViewGroup.a.getLayoutParams();
      localLayoutParams.height = paramInt;
      if (!"ZR0204".equals(str)) {
        break label368;
      }
      localLayoutParams.width = (paramInt * 46 / 58);
      label190:
      paramViewGroup.a.setLayoutParams(localLayoutParams);
      if (!TextUtils.isEmpty(locala.getPicUrl())) {
        paramViewGroup.a.setController(com.freelxl.baselibrary.f.c.frescoController(locala.getPicUrl()));
      }
      if (paramViewGroup.a.getTag() != null) {
        break label458;
      }
      paramViewGroup.a.setTag(locala.getPicUrl());
      paramViewGroup.a.setController(com.freelxl.baselibrary.f.c.frescoController(locala.getPicUrl()));
      label262:
      paramViewGroup.b.setText(locala.getDeviceTypeName() + locala.getDeviceNumber());
      paramViewGroup.c.setText(locala.getDeviceUsingStatus());
      paramInt = locala.getDeviceUsingStatusCode();
      if (paramInt != 1) {
        break label506;
      }
      paramViewGroup.e.setBackgroundResource(2130839977);
      label327:
      if (paramInt != 3) {
        break label557;
      }
      paramViewGroup.f.setBackgroundResource(2130840017);
    }
    for (;;)
    {
      paramView.setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          if (TextUtils.isEmpty(locala.getIsNotLock()))
          {
            paramAnonymousView = new Intent(c.a(c.this), SharedLifeEquipmentDetailActivity.class);
            paramAnonymousView.putExtra("deviceUuid", locala.getDeviceUuid());
            paramAnonymousView.putExtra("deviceTypeName", locala.getDeviceTypeName() + locala.getDeviceNumber());
            paramAnonymousView.putExtra("deviceType", locala.getDeviceType());
            paramAnonymousView.putExtra("rentContractCode", c.b(c.this));
            c.a(c.this).startActivity(paramAnonymousView);
            return;
          }
          paramAnonymousView = new Intent(c.a(c.this), SharedLifeIntellectLockActivity.class);
          paramAnonymousView.putExtra("deviceUuid", locala.getDeviceUuid());
          paramAnonymousView.putExtra("rentContractCode", c.b(c.this));
          paramAnonymousView.putExtra("deviceTypeName", locala.getDeviceTypeName() + locala.getDeviceNumber());
          c.a(c.this).startActivity(paramAnonymousView);
        }
      });
      return paramView;
      paramViewGroup = (a)paramView.getTag();
      break;
      label368:
      if ("ZR0203".equals(str))
      {
        localLayoutParams.width = (paramInt * 46 / 58);
        break label190;
      }
      if ("ZR0202".equals(str))
      {
        localLayoutParams.width = (paramInt * 49 / 65);
        break label190;
      }
      if ("ZR0201".equals(str))
      {
        localLayoutParams.width = (paramInt * 57 / 57);
        break label190;
      }
      localLayoutParams.width = (paramInt * 46 / 58);
      break label190;
      label458:
      if (locala.getPicUrl().equals(paramViewGroup.a.getTag())) {
        break label262;
      }
      paramViewGroup.a.setTag(locala.getPicUrl());
      paramViewGroup.a.setController(com.freelxl.baselibrary.f.c.frescoController(locala.getPicUrl()));
      break label262;
      label506:
      if (paramInt == 2)
      {
        paramViewGroup.e.setBackgroundResource(2130839993);
        break label327;
      }
      if (paramInt == 3)
      {
        paramViewGroup.e.setBackgroundResource(2130839993);
        break label327;
      }
      if (paramInt != 4) {
        break label327;
      }
      paramViewGroup.e.setBackgroundResource(2130839992);
      break label327;
      label557:
      paramViewGroup.f.setBackgroundColor(-1);
    }
  }
  
  public class a
  {
    public SimpleDraweeView a;
    public TextView b;
    public TextView c;
    public View d;
    public View e;
    public RelativeLayout f;
    public LinearLayout g;
    
    public a() {}
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/sharedlife/a/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */