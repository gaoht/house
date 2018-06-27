package com.ziroom.ziroomcustomer.minsu.landlordrelease.view;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnKeyListener;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.view.inputmethod.InputMethodManager;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.minsu.f.k;
import com.ziroom.ziroomcustomer.minsu.landlordrelease.model.UsageTipsBean.DataBean.TipMsgBean.SubTitleContentsBean;
import com.ziroom.ziroomcustomer.widget.ListViewForScrollView;
import com.ziroom.ziroomcustomer.widget.ObservableScrollView;
import com.ziroom.ziroomcustomer.widget.ObservableScrollView.a;
import java.util.ArrayList;
import java.util.List;

public class ReleaseUsageTipsPop
  extends PopupWindow
{
  private ListViewForScrollView a;
  private TextView b;
  private TextView c;
  private ImageView d;
  private ObservableScrollView e;
  private View f;
  private Context g;
  private View h;
  private a i;
  private List<UsageTipsBean.DataBean.TipMsgBean.SubTitleContentsBean> j = new ArrayList();
  
  public ReleaseUsageTipsPop(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ReleaseUsageTipsPop(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ReleaseUsageTipsPop(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    setHeight(-1);
    setWidth(-1);
    setAnimationStyle(2131427934);
    this.h = LayoutInflater.from(paramContext).inflate(2130904907, null);
    this.g = paramContext;
    a();
  }
  
  private void a()
  {
    this.a = ((ListViewForScrollView)this.h.findViewById(2131696873));
    this.d = ((ImageView)this.h.findViewById(2131696871));
    this.b = ((TextView)this.h.findViewById(2131696877));
    this.c = ((TextView)this.h.findViewById(2131696872));
    this.e = ((ObservableScrollView)this.h.findViewById(2131690150));
    this.f = this.h.findViewById(2131689863);
    this.e.setOnScrollChangedCallback(new ObservableScrollView.a()
    {
      public void onScroll(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        float f = paramAnonymousInt2 / 100.0F;
        ReleaseUsageTipsPop.a(ReleaseUsageTipsPop.this).setAlpha(f);
      }
    });
    this.d.setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        ReleaseUsageTipsPop.this.dismiss();
      }
    });
    this.b.setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        k.contactIM((BaseActivity)ReleaseUsageTipsPop.b(ReleaseUsageTipsPop.this));
      }
    });
    this.h.setOnKeyListener(new View.OnKeyListener()
    {
      public boolean onKey(View paramAnonymousView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
      {
        if ((paramAnonymousKeyEvent.getAction() == 0) && (paramAnonymousInt == 4)) {
          ReleaseUsageTipsPop.this.dismiss();
        }
        return false;
      }
    });
    this.i = new a();
    this.a.setAdapter(this.i);
    setContentView(this.h);
  }
  
  public void show(View paramView, List<UsageTipsBean.DataBean.TipMsgBean.SubTitleContentsBean> paramList, String paramString)
  {
    if ((this.g instanceof Activity))
    {
      Activity localActivity = (Activity)this.g;
      Window localWindow = localActivity.getWindow();
      if ((localWindow != null) && (localWindow.getAttributes().softInputMode != 2) && (localActivity.getCurrentFocus() != null)) {
        ((InputMethodManager)localActivity.getSystemService("input_method")).hideSoftInputFromWindow(localActivity.getCurrentFocus().getWindowToken(), 0);
      }
    }
    if ((this.j == null) || (this.j.size() < 1))
    {
      this.j = paramList;
      this.i.notifyDataSetChanged();
    }
    if (!TextUtils.isEmpty(paramString)) {
      this.c.setText(paramString);
    }
    setAnimationStyle(2131427507);
    if (!(this instanceof PopupWindow))
    {
      super.showAtLocation(paramView, 17, 0, 0);
      return;
    }
    VdsAgent.showAtLocation((PopupWindow)this, paramView, 17, 0, 0);
  }
  
  class a
    extends BaseAdapter
  {
    a() {}
    
    public int getCount()
    {
      if (ReleaseUsageTipsPop.c(ReleaseUsageTipsPop.this) == null) {
        return 0;
      }
      return ReleaseUsageTipsPop.c(ReleaseUsageTipsPop.this).size();
    }
    
    public Object getItem(int paramInt)
    {
      return ReleaseUsageTipsPop.c(ReleaseUsageTipsPop.this).get(paramInt);
    }
    
    public long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      if (paramView == null)
      {
        paramView = LayoutInflater.from(ReleaseUsageTipsPop.b(ReleaseUsageTipsPop.this)).inflate(2130904267, null);
        paramViewGroup = new a();
        paramViewGroup.a = ((TextView)paramView.findViewById(2131695130));
        paramViewGroup.b = ((TextView)paramView.findViewById(2131695131));
        paramView.setTag(paramViewGroup);
        if (!TextUtils.isEmpty(((UsageTipsBean.DataBean.TipMsgBean.SubTitleContentsBean)ReleaseUsageTipsPop.c(ReleaseUsageTipsPop.this).get(paramInt)).getSubTitle())) {
          break label134;
        }
        paramViewGroup.a.setVisibility(8);
      }
      for (;;)
      {
        paramViewGroup.b.setText(((UsageTipsBean.DataBean.TipMsgBean.SubTitleContentsBean)ReleaseUsageTipsPop.c(ReleaseUsageTipsPop.this).get(paramInt)).getSubContent());
        return paramView;
        paramViewGroup = (a)paramView.getTag();
        break;
        label134:
        paramViewGroup.a.setVisibility(0);
        paramViewGroup.a.setText(((UsageTipsBean.DataBean.TipMsgBean.SubTitleContentsBean)ReleaseUsageTipsPop.c(ReleaseUsageTipsPop.this).get(paramInt)).getSubTitle());
      }
    }
    
    class a
    {
      TextView a;
      TextView b;
      
      a() {}
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/landlordrelease/view/ReleaseUsageTipsPop.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */