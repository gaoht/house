package com.growingio.android.sdk.circle;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.ScrollView;
import android.widget.Switch;
import android.widget.TextView;
import com.growingio.android.sdk.a.g;
import com.growingio.android.sdk.circle.a.a;
import com.growingio.android.sdk.collection.GConfig;
import com.growingio.android.sdk.collection.GrowingIO;
import com.growingio.android.sdk.utils.Util;

@TargetApi(11)
public class d
  extends DialogFragment
{
  private boolean a = false;
  private a b = a.b();
  
  private void b()
  {
    g.c().e();
  }
  
  c a()
  {
    return c.e();
  }
  
  public void dismiss()
  {
    super.dismiss();
    if (this.b.c()) {
      this.b.d();
    }
  }
  
  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    paramBundle = getResources().getDisplayMetrics();
    getDialog().getWindow().setLayout((int)(paramBundle.widthPixels - paramBundle.density * 40.0F), -2);
  }
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    super.onCancel(paramDialogInterface);
    if (!this.a) {
      c.e().g();
    }
    if (this.b.c()) {
      this.b.d();
    }
  }
  
  @SuppressLint({"SetTextI18n"})
  @TargetApi(17)
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    if (this.b.c()) {
      this.b.e();
    }
    getDialog().requestWindowFeature(1);
    paramViewGroup = paramLayoutInflater.getContext();
    paramLayoutInflater = new ScrollView(paramViewGroup);
    paramLayoutInflater.setBackgroundColor(-1052689);
    paramBundle = new LinearLayout(paramViewGroup);
    paramLayoutInflater.addView(paramBundle);
    paramBundle.setOrientation(1);
    Object localObject1 = new TextView(paramViewGroup);
    ((TextView)localObject1).setText("圈选");
    ((TextView)localObject1).setTextSize(18.0F);
    ((TextView)localObject1).setGravity(17);
    ((TextView)localObject1).setBackgroundColor(-13325603);
    paramBundle.addView((View)localObject1, -1, Util.a(paramViewGroup, 56.0F));
    localObject1 = new LinearLayout(paramViewGroup);
    ((LinearLayout)localObject1).setOrientation(1);
    Object localObject2 = new Switch(paramViewGroup);
    ((Switch)localObject2).setText("开启热图");
    ((Switch)localObject2).setTextColor(-13421773);
    ((Switch)localObject2).setTextSize(16.0F);
    ((Switch)localObject2).setVisibility(0);
    ((Switch)localObject2).setChecked(a.b().c());
    ((Switch)localObject2).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
    {
      public void onCheckedChanged(CompoundButton paramAnonymousCompoundButton, boolean paramAnonymousBoolean)
      {
        d.a(d.this).a(paramAnonymousBoolean);
      }
    });
    Object localObject3 = new Switch(paramViewGroup);
    ((Switch)localObject3).setText("显示已圈选");
    ((Switch)localObject3).setTextColor(-13421773);
    ((Switch)localObject3).setTextSize(16.0F);
    ((Switch)localObject3).setVisibility(0);
    ((Switch)localObject3).setChecked(GConfig.s().u());
    ((Switch)localObject3).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
    {
      public void onCheckedChanged(CompoundButton paramAnonymousCompoundButton, boolean paramAnonymousBoolean)
      {
        c.e().a(paramAnonymousBoolean);
        if (paramAnonymousBoolean) {
          d.b(d.this);
        }
      }
    });
    ((LinearLayout)localObject1).addView((View)localObject2, -1, Util.a(paramViewGroup, 60.0F));
    ((LinearLayout)localObject1).addView((View)localObject3, -1, Util.a(paramViewGroup, 60.0F));
    new View(paramViewGroup).setBackgroundColor(-4605511);
    localObject2 = new RelativeLayout(paramViewGroup);
    localObject3 = new TextView(paramViewGroup);
    ((TextView)localObject3).setText("提示: 拖动小红点进行圈选");
    ((TextView)localObject3).setTextColor(-5921371);
    ((TextView)localObject3).setId(View.generateViewId());
    ((TextView)localObject3).setTextSize(12.0F);
    Object localObject4 = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject4).addRule(14);
    ((RelativeLayout)localObject2).addView((View)localObject3, (ViewGroup.LayoutParams)localObject4);
    localObject4 = new TextView(paramViewGroup);
    ((TextView)localObject4).setTextSize(12.0F);
    ((TextView)localObject4).setTextColor(-5921371);
    ((TextView)localObject4).setText("版本: " + GrowingIO.getVersion());
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.topMargin = Util.a(paramViewGroup, 5.0F);
    localLayoutParams.addRule(5, ((TextView)localObject3).getId());
    localLayoutParams.addRule(3, ((TextView)localObject3).getId());
    ((RelativeLayout)localObject2).addView((View)localObject4, localLayoutParams);
    localObject3 = new LinearLayout.LayoutParams(-1, -2);
    ((LinearLayout.LayoutParams)localObject3).topMargin = Util.a(paramViewGroup, 10.0F);
    ((LinearLayout.LayoutParams)localObject3).bottomMargin = ((LinearLayout.LayoutParams)localObject3).topMargin;
    ((LinearLayout)localObject1).addView((View)localObject2, (ViewGroup.LayoutParams)localObject3);
    localObject2 = new LinearLayout.LayoutParams(-1, -2);
    ((LinearLayout.LayoutParams)localObject2).leftMargin = Util.a(paramViewGroup, 15.0F);
    ((LinearLayout.LayoutParams)localObject2).rightMargin = ((LinearLayout.LayoutParams)localObject2).leftMargin;
    paramBundle.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
    localObject1 = new View(paramViewGroup);
    ((View)localObject1).setBackgroundColor(-4605511);
    paramBundle.addView((View)localObject1, -1, Util.a(paramViewGroup, 1.0F));
    localObject1 = new LinearLayout(paramViewGroup);
    ((LinearLayout)localObject1).setOrientation(0);
    paramBundle.addView((View)localObject1);
    paramBundle = new TextView(paramViewGroup);
    paramBundle.setText("返回圈选");
    paramBundle.setTextColor(-13421773);
    paramBundle.setGravity(17);
    localObject2 = new TextView(paramViewGroup);
    ((TextView)localObject2).setText("退出圈选");
    ((TextView)localObject2).setTextColor(-13421773);
    ((TextView)localObject2).setGravity(17);
    localObject3 = new View(paramViewGroup);
    ((View)localObject3).setBackgroundColor(-4605511);
    localObject4 = new LinearLayout.LayoutParams(-1, Util.a(paramViewGroup, 48.0F));
    ((LinearLayout.LayoutParams)localObject4).weight = 1.0F;
    ((LinearLayout)localObject1).addView(paramBundle, (ViewGroup.LayoutParams)localObject4);
    ((LinearLayout)localObject1).addView((View)localObject3, new LinearLayout.LayoutParams(Util.a(paramViewGroup, 1.0F), -1));
    paramViewGroup = new LinearLayout.LayoutParams(-1, Util.a(paramViewGroup, 48.0F));
    paramViewGroup.weight = 1.0F;
    ((LinearLayout)localObject1).addView((View)localObject2, paramViewGroup);
    ((TextView)localObject2).setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        d.this.dismiss();
        d.this.a().k();
        d.this.a().m();
      }
    });
    paramBundle.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        d.this.dismiss();
        d.this.a().g();
      }
    });
    return paramLayoutInflater;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/growingio/android/sdk/circle/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */