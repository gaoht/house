package com.ziroom.ziroomcustomer.newclean.b;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.commonlibrary.widget.unifiedziroom.c.a;
import com.ziroom.commonlibrary.widget.unifiedziroom.c.b;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.newclean.activity.CleanerTimeActivity;
import com.ziroom.ziroomcustomer.newclean.d.ag;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class p
  extends BaseAdapter
{
  private Context a;
  private List<ag> b;
  private String c;
  private String d;
  private String e;
  private String f;
  private String g;
  private String h;
  private String i;
  private String j;
  private String k;
  private String l;
  private String m;
  
  public p(Context paramContext, List<ag> paramList, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11)
  {
    this.a = paramContext;
    this.b = new ArrayList();
    this.b.addAll(paramList);
    this.c = paramString1;
    this.d = paramString2;
    this.e = paramString3;
    this.f = paramString4;
    this.g = paramString5;
    this.h = paramString6;
    this.i = paramString7;
    this.j = paramString8;
    this.k = paramString9;
    this.l = paramString10;
    this.m = paramString11;
  }
  
  private void a(final ag paramag)
  {
    com.ziroom.commonlibrary.widget.unifiedziroom.c.newBuilder(this.a).setTitle("提示").setContent("查看日程表示服务者在您选定的时间已被预约，您可以预约她的其它时间").setOnConfirmClickListener(new c.b()
    {
      public void onClick(View paramAnonymousView, boolean paramAnonymousBoolean)
      {
        if (paramAnonymousBoolean)
        {
          paramAnonymousView = new Intent(p.b(p.this), CleanerTimeActivity.class);
          paramAnonymousView.putExtra("iscleaner", "iscleaner");
          paramAnonymousView.putExtra("cleanerId", paramag.getCleanerId());
          paramAnonymousView.putExtra("appointDate", p.c(p.this));
          paramAnonymousView.putExtra("serviceInfoId", p.d(p.this));
          paramAnonymousView.putExtra("servicePmId", p.e(p.this));
          paramAnonymousView.putExtra("addressId", p.f(p.this));
          paramAnonymousView.putExtra("cleanerItem", paramag);
          paramAnonymousView.putExtra("defaultName", p.g(p.this));
          paramAnonymousView.putExtra("day_index", p.h(p.this));
          paramAnonymousView.putExtra("card_index", p.i(p.this));
          paramAnonymousView.putExtra("service_price", p.j(p.this));
          paramAnonymousView.putExtra("isSelectCleaner", "isSelectCleaner");
          paramAnonymousView.putExtra("cleanType", p.k(p.this));
          paramAnonymousView.putExtra("appointDateTime", p.l(p.this));
          p.b(p.this).startActivity(paramAnonymousView);
        }
      }
    }).build().show();
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
  
  public View getView(final int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null)
    {
      paramView = View.inflate(this.a, 2130904157, null);
      paramViewGroup = new a();
      paramViewGroup.a = ((SimpleDraweeView)paramView.findViewById(2131690047));
      paramViewGroup.b = ((TextView)paramView.findViewById(2131690371));
      paramViewGroup.c = ((ImageView)paramView.findViewById(2131694914));
      paramViewGroup.d = ((TextView)paramView.findViewById(2131690384));
      paramViewGroup.e = ((TextView)paramView.findViewById(2131690372));
      paramViewGroup.f = ((TextView)paramView.findViewById(2131690373));
      paramViewGroup.g = ((TextView)paramView.findViewById(2131690381));
      paramViewGroup.h = ((TextView)paramView.findViewById(2131690374));
      paramViewGroup.i = ((TextView)paramView.findViewById(2131694915));
      paramViewGroup.j = ((TextView)paramView.findViewById(2131690048));
      paramViewGroup.k = ((RelativeLayout)paramView.findViewById(2131691572));
      paramViewGroup.l = ((TextView)paramView.findViewById(2131693953));
      paramView.setTag(paramViewGroup);
    }
    for (;;)
    {
      final ag localag = (ag)this.b.get(paramInt);
      int n = localag.getRankMedal();
      if (n == 1)
      {
        paramViewGroup.c.setBackgroundResource(2130840040);
        paramViewGroup.d.setText("金牌保洁员");
        label231:
        paramViewGroup.g.setText(localag.getHireYearNum() + "年经验");
        if (TextUtils.isEmpty(localag.getServeNum())) {
          break label636;
        }
        paramViewGroup.h.setVisibility(0);
        paramViewGroup.h.setText(localag.getServeNum() + "单");
        if (localag.getPercent() == null) {}
      }
      try
      {
        final Object localObject = new DecimalFormat("######0.0");
        paramViewGroup.i.setText(((DecimalFormat)localObject).format(localag.getPercent().doubleValue() * 100.0D) + "%");
        paramViewGroup.b.setText(localag.getName());
        paramViewGroup.a.setController(com.freelxl.baselibrary.f.c.frescoController(localag.getHeadPic()));
        paramViewGroup.e.setText(localag.getAge() + "岁");
        paramViewGroup.f.setText(localag.getNativePlace());
        paramViewGroup.f.setVisibility(0);
        localObject = this.a.getSharedPreferences("days_clean", 0);
        final boolean bool = ((SharedPreferences)localObject).getBoolean("days_is_first", true);
        if ("1".equals(localag.getFlag()))
        {
          paramViewGroup.l.setVisibility(8);
          paramViewGroup.j.setVisibility(0);
          paramViewGroup.k.setClickable(true);
          paramViewGroup.j.setText("查看日程");
          paramViewGroup.j.setTextColor(-6710887);
          paramViewGroup.j.setBackgroundResource(2130839829);
          paramViewGroup.k.setOnClickListener(new View.OnClickListener()
          {
            @Instrumented
            public void onClick(View paramAnonymousView)
            {
              VdsAgent.onClick(this, paramAnonymousView);
              paramAnonymousView = (ag)p.a(p.this).get(paramInt);
              if (bool)
              {
                localObject = localObject.edit();
                ((SharedPreferences.Editor)localObject).putBoolean("days_is_first", false);
                ((SharedPreferences.Editor)localObject).apply();
                p.this.notifyDataSetChanged();
                p.a(p.this, paramAnonymousView);
                return;
              }
              Object localObject = new Intent(p.b(p.this), CleanerTimeActivity.class);
              ((Intent)localObject).putExtra("iscleaner", "iscleaner");
              ((Intent)localObject).putExtra("cleanerId", paramAnonymousView.getCleanerId());
              ((Intent)localObject).putExtra("appointDate", p.c(p.this));
              ((Intent)localObject).putExtra("serviceInfoId", p.d(p.this));
              ((Intent)localObject).putExtra("servicePmId", p.e(p.this));
              ((Intent)localObject).putExtra("addressId", p.f(p.this));
              ((Intent)localObject).putExtra("cleanerItem", paramAnonymousView);
              ((Intent)localObject).putExtra("defaultName", p.g(p.this));
              ((Intent)localObject).putExtra("day_index", p.h(p.this));
              ((Intent)localObject).putExtra("card_index", p.i(p.this));
              ((Intent)localObject).putExtra("service_price", p.j(p.this));
              ((Intent)localObject).putExtra("isSelectCleaner", "isSelectCleaner");
              ((Intent)localObject).putExtra("cleanType", p.k(p.this));
              ((Intent)localObject).putExtra("appointDateTime", p.l(p.this));
              p.b(p.this).startActivity((Intent)localObject);
            }
          });
          return paramView;
          paramViewGroup = (a)paramView.getTag();
          continue;
          if (n == 2)
          {
            paramViewGroup.c.setBackgroundResource(2130840437);
            paramViewGroup.d.setText("银牌保洁员");
            break label231;
          }
          if (n != 3) {
            break label231;
          }
          paramViewGroup.c.setBackgroundResource(2130840436);
          paramViewGroup.d.setText("铜牌保洁员");
          break label231;
          label636:
          paramViewGroup.h.setVisibility(8);
        }
      }
      catch (Exception localException)
      {
        do
        {
          for (;;)
          {
            localException.printStackTrace();
          }
          if ("0".equals(localag.getFlag()))
          {
            paramViewGroup.l.setVisibility(8);
            paramViewGroup.j.setVisibility(0);
            paramViewGroup.k.setClickable(true);
            paramViewGroup.j.setText("立即预约");
            paramViewGroup.j.setTextColor(40960);
            paramViewGroup.j.setBackgroundResource(2130839834);
            paramViewGroup.k.setOnClickListener(new View.OnClickListener()
            {
              @Instrumented
              public void onClick(View paramAnonymousView)
              {
                VdsAgent.onClick(this, paramAnonymousView);
                paramAnonymousView = new Intent();
                paramAnonymousView.setAction("clean_time_info");
                paramAnonymousView.putExtra("appointDate", p.c(p.this));
                paramAnonymousView.putExtra("servicePmId", p.e(p.this));
                paramAnonymousView.putExtra("appointTime", p.m(p.this));
                paramAnonymousView.putExtra("cleanname", localag.getName());
                paramAnonymousView.putExtra("cleanage", localag.getAge());
                paramAnonymousView.putExtra("cleanplace", localag.getNativePlace());
                paramAnonymousView.putExtra("employeeLogicCode", localag.getCleanerId());
                paramAnonymousView.putExtra("day_index", p.h(p.this));
                paramAnonymousView.putExtra("card_index", p.i(p.this));
                paramAnonymousView.putExtra("defaultName", p.g(p.this));
                paramAnonymousView.putExtra("service_price", p.j(p.this));
                paramAnonymousView.putExtra("cleanType", p.k(p.this));
                paramAnonymousView.putExtra("appointDateTime", p.l(p.this));
                ApplicationEx.c.sendBroadcast(paramAnonymousView);
                ((Activity)p.b(p.this)).finish();
              }
            });
            return paramView;
          }
        } while (!"2".equals(localag.getFlag()));
        paramViewGroup.l.setVisibility(0);
        paramViewGroup.j.setVisibility(8);
        paramViewGroup.k.setClickable(false);
      }
    }
    return paramView;
  }
  
  public void setData(List<ag> paramList)
  {
    this.b = new ArrayList();
    this.b.addAll(paramList);
    notifyDataSetChanged();
  }
  
  public class a
  {
    public SimpleDraweeView a;
    public TextView b;
    public ImageView c;
    public TextView d;
    public TextView e;
    public TextView f;
    public TextView g;
    public TextView h;
    public TextView i;
    public TextView j;
    public RelativeLayout k;
    public TextView l;
    
    public a() {}
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newclean/b/p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */