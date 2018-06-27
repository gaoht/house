package com.ziroom.ziroomcustomer.my;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.alibaba.fastjson.b;
import com.alibaba.fastjson.e;
import com.freelxl.baselibrary.f.g;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.adapter.j.a;
import com.ziroom.ziroomcustomer.base.BaseFragment;
import com.ziroom.ziroomcustomer.e.a.f;
import com.ziroom.ziroomcustomer.e.c.o;
import com.ziroom.ziroomcustomer.e.c.p;
import com.ziroom.ziroomcustomer.model.AlternateListing;
import com.ziroom.ziroomcustomer.my.widget.a.b;
import com.ziroom.ziroomcustomer.widget.ListViewForScrollView;
import java.util.Iterator;
import java.util.List;

public class MyAlternateListFragment
  extends BaseFragment
{
  public String a = "1";
  private ListViewForScrollView b;
  private LinearLayout c;
  private TextView d;
  private ImageView e;
  private com.ziroom.ziroomcustomer.adapter.j f;
  private Context g;
  private View h;
  private RelativeLayout i;
  private CheckBox j;
  private Button k;
  private TextView l;
  
  private void c()
  {
    this.b = ((ListViewForScrollView)this.h.findViewById(2131689817));
    this.c = ((LinearLayout)this.h.findViewById(2131689818));
    this.d = ((TextView)this.h.findViewById(2131690822));
    this.e = ((ImageView)this.h.findViewById(2131690082));
    this.i = ((RelativeLayout)this.h.findViewById(2131691826));
    this.j = ((CheckBox)this.h.findViewById(2131691827));
    this.k = ((Button)this.h.findViewById(2131691828));
    this.l = ((TextView)this.h.findViewById(2131690827));
    final Object localObject = new CompoundButton.OnCheckedChangeListener()
    {
      @Instrumented
      public void onCheckedChanged(CompoundButton paramAnonymousCompoundButton, boolean paramAnonymousBoolean)
      {
        VdsAgent.onCheckedChanged(this, paramAnonymousCompoundButton, paramAnonymousBoolean);
        if (paramAnonymousBoolean)
        {
          MyAlternateListFragment.a(MyAlternateListFragment.this).selectAll();
          return;
        }
        MyAlternateListFragment.a(MyAlternateListFragment.this).unSelectAll();
      }
    };
    this.f = new com.ziroom.ziroomcustomer.adapter.j(this.g, null, new j.a()
    {
      public void onItemSelected(boolean paramAnonymousBoolean)
      {
        MyAlternateListFragment.b(MyAlternateListFragment.this).setOnCheckedChangeListener(null);
        MyAlternateListFragment.b(MyAlternateListFragment.this).setChecked(paramAnonymousBoolean);
        MyAlternateListFragment.b(MyAlternateListFragment.this).setOnCheckedChangeListener(localObject);
      }
    });
    this.j.setOnCheckedChangeListener((CompoundButton.OnCheckedChangeListener)localObject);
    this.b.setAdapter(this.f);
    this.k.setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        MyAlternateListFragment.c(MyAlternateListFragment.this);
      }
    });
    this.l.setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        paramAnonymousView = new com.ziroom.ziroomcustomer.my.widget.a(MyAlternateListFragment.d(MyAlternateListFragment.this));
        Window localWindow = paramAnonymousView.getWindow();
        WindowManager.LayoutParams localLayoutParams = localWindow.getAttributes();
        localLayoutParams.width = MyAlternateListFragment.this.getResources().getDisplayMetrics().widthPixels;
        localLayoutParams.gravity = 80;
        localWindow.setAttributes(localLayoutParams);
        paramAnonymousView.setFilterListener(new a.b()
        {
          public void onFilter(String paramAnonymous2String, int paramAnonymous2Int)
          {
            MyAlternateListFragment.this.a = (paramAnonymous2Int + "");
            MyAlternateListFragment.e(MyAlternateListFragment.this);
          }
        });
        paramAnonymousView.show();
      }
    });
    localObject = getResources().getDisplayMetrics();
    int m = (int)((((DisplayMetrics)localObject).heightPixels - ((DisplayMetrics)localObject).density * 180.0F) * 0.33F);
    localObject = new LinearLayout.LayoutParams(-1, -2);
    ((LinearLayout.LayoutParams)localObject).setMargins(0, m, 0, 0);
    this.c.setLayoutParams((ViewGroup.LayoutParams)localObject);
  }
  
  private void d()
  {
    com.ziroom.ziroomcustomer.e.j.getAlternateList(this.g, this.a, new f(this.g, new p(AlternateListing.class))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        super.onFailure(paramAnonymousThrowable);
        MyAlternateListFragment.a(MyAlternateListFragment.this).setData(null);
        MyAlternateListFragment.f(MyAlternateListFragment.this).setImageResource(2130840089);
        paramAnonymousThrowable = new SpannableString("网络故障，点击刷新");
        paramAnonymousThrowable.setSpan(new ClickableSpan()
        {
          @Instrumented
          public void onClick(View paramAnonymous2View)
          {
            VdsAgent.onClick(this, paramAnonymous2View);
            MyAlternateListFragment.e(MyAlternateListFragment.this);
          }
          
          public void updateDrawState(TextPaint paramAnonymous2TextPaint)
          {
            paramAnonymous2TextPaint.setUnderlineText(true);
          }
        }, 5, paramAnonymousThrowable.length(), 33);
        MyAlternateListFragment.g(MyAlternateListFragment.this).setText(paramAnonymousThrowable);
        MyAlternateListFragment.g(MyAlternateListFragment.this).setMovementMethod(LinkMovementMethod.getInstance());
        MyAlternateListFragment.i(MyAlternateListFragment.this).setEmptyView(MyAlternateListFragment.h(MyAlternateListFragment.this));
      }
      
      public void onSuccess(int paramAnonymousInt, List<AlternateListing> paramAnonymousList)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousList);
        MyAlternateListFragment.f(MyAlternateListFragment.this).setImageResource(2130840085);
        MyAlternateListFragment.g(MyAlternateListFragment.this).setText("收藏夹是空的");
        MyAlternateListFragment.i(MyAlternateListFragment.this).setEmptyView(MyAlternateListFragment.h(MyAlternateListFragment.this));
        MyAlternateListFragment.a(MyAlternateListFragment.this).setData(paramAnonymousList);
      }
    });
  }
  
  private void e()
  {
    if ((this.f == null) || (this.f.getDeleteHouseIds() == null) || (this.f.getDeleteHouseIds().isEmpty()))
    {
      g.textToast(this.g, "请先选择一个房源～");
      return;
    }
    Object localObject = new b();
    Iterator localIterator = this.f.getDeleteHouseIds().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      e locale = new e();
      locale.put("house_code", str);
      locale.put("del_time", Long.valueOf(System.currentTimeMillis()));
      ((b)localObject).add(locale);
    }
    localObject = ((b)localObject).toJSONString();
    com.ziroom.ziroomcustomer.e.j.delAlternate(this.g, (String)localObject, new f(this.g, new o())
    {
      public void onSuccess(int paramAnonymousInt, e paramAnonymouse)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymouse);
        if (paramAnonymouse != null) {}
        for (paramAnonymousInt = 1;; paramAnonymousInt = 0)
        {
          if ((paramAnonymousInt & paramAnonymouse.containsKey("del_counts")) != 0)
          {
            if (MyAlternateListFragment.a(MyAlternateListFragment.this) != null) {
              MyAlternateListFragment.a(MyAlternateListFragment.this).clearSelectIds();
            }
            MyAlternateListFragment.e(MyAlternateListFragment.this);
            g.textToast(MyAlternateListFragment.d(MyAlternateListFragment.this), "删除成功！");
          }
          return;
        }
      }
    });
  }
  
  public static MyAlternateListFragment getInstance()
  {
    return new MyAlternateListFragment();
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.h = paramLayoutInflater.inflate(2130903366, paramViewGroup, false);
    this.g = getActivity();
    c();
    d();
    return this.h;
  }
  
  public void updateStatus(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.i.setVisibility(0);
      this.l.setVisibility(8);
      this.f.updateToManaging();
      return;
    }
    this.i.setVisibility(8);
    this.l.setVisibility(0);
    this.f.updateToDefault();
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/my/MyAlternateListFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */