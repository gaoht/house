package com.ziroom.ziroomcustomer.newServiceList.b;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListAdapter;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.newServiceList.a.k;
import com.ziroom.ziroomcustomer.newServiceList.a.k.b;
import com.ziroom.ziroomcustomer.newServiceList.model.az;
import com.ziroom.ziroomcustomer.newServiceList.utils.g;
import com.ziroom.ziroomcustomer.newServiceList.view.RectTopAngleView;
import com.ziroom.ziroomcustomer.newclean.activity.GeneralCleaningActivity;
import com.ziroom.ziroomcustomer.newmovehouse.activity.MovingIndexActivity;
import com.ziroom.ziroomcustomer.newrepair.utils.ListViewForScrollView;
import com.ziroom.ziroomcustomer.util.ac;
import com.ziroom.ziroomcustomer.util.n;
import java.util.ArrayList;
import java.util.List;

public class a
  extends Dialog
{
  private Context a;
  private ListViewForScrollView b;
  private ImageView c;
  private List<az> d = new ArrayList();
  private LinearLayout e;
  private RectTopAngleView f;
  private View g;
  private View h;
  
  public a(Context paramContext, List<az> paramList)
  {
    super(paramContext, 2131427591);
    this.a = paramContext;
    this.d = paramList;
    setDefaultSetting();
  }
  
  private void a()
  {
    View localView = LayoutInflater.from(this.a).inflate(2130903846, null);
    this.e = ((LinearLayout)localView.findViewById(2131693872));
    this.b = ((ListViewForScrollView)localView.findViewById(2131693874));
    this.c = ((ImageView)localView.findViewById(2131690588));
    this.f = ((RectTopAngleView)localView.findViewById(2131693873));
    this.g = localView.findViewById(2131690379);
    this.h = localView.findViewById(2131692133);
    b();
    setContentView(localView);
  }
  
  private void b()
  {
    int i = ac.getScreenHeight(this.a);
    Object localObject = (LinearLayout.LayoutParams)this.h.getLayoutParams();
    ((LinearLayout.LayoutParams)localObject).height = (i * 70 / 667);
    this.h.setLayoutParams((ViewGroup.LayoutParams)localObject);
    localObject = (LinearLayout.LayoutParams)this.g.getLayoutParams();
    ((LinearLayout.LayoutParams)localObject).height = (i * 126 / 667);
    this.g.setLayoutParams((ViewGroup.LayoutParams)localObject);
    localObject = (LinearLayout.LayoutParams)this.e.getLayoutParams();
    ((LinearLayout.LayoutParams)localObject).height = (i * 391 / 667);
    this.e.setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.c.setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        a.this.dismiss();
      }
    });
    this.f.setImageResource(2130840394);
    localObject = new k(this.a, this.d);
    this.b.setAdapter((ListAdapter)localObject);
    ((k)localObject).setOnCommitListener(new k.b()
    {
      public void commit(int paramAnonymousInt)
      {
        a.this.dismiss();
        ApplicationEx.c.isLoginState();
        az localaz = (az)a.a(a.this).get(paramAnonymousInt);
        if ("2c9085f24af1d728014b004be6b50d3b".equals(localaz.getFirstCategoryCode()))
        {
          localIntent = new Intent(a.b(a.this), GeneralCleaningActivity.class);
          localIntent.putExtra("ServiceInfoId", localaz.getSecondCategoryCode());
          localIntent.putExtra("ServiceInfoName", g.getCleanNameByCode(localaz.getSecondCategoryCode()));
          a.b(a.this).startActivity(localIntent);
        }
        while (!"2c9085f248ba3f3a0148bb151aca0003".equals(localaz.getFirstCategoryCode())) {
          return;
        }
        Intent localIntent = new Intent(a.b(a.this), MovingIndexActivity.class);
        localIntent.putExtra("productCode", localaz.getSecondCategoryCode());
        a.b(a.this).startActivity(localIntent);
      }
    });
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    a();
  }
  
  public void setDefaultSetting()
  {
    setCanceledOnTouchOutside(false);
    Window localWindow = getWindow();
    localWindow.getDecorView().setPadding(0, 0, 0, 0);
    WindowManager.LayoutParams localLayoutParams = localWindow.getAttributes();
    int i = ac.getScreenWidth(this.a);
    ac.getScreenHeight(this.a);
    localLayoutParams.width = (i - n.dip2px(this.a, 88.0F));
    localLayoutParams.height = -1;
    localWindow.setAttributes(localLayoutParams);
    localWindow.setGravity(48);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newServiceList/b/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */