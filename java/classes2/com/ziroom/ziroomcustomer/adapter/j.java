package com.ziroom.ziroomcustomer.adapter;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.freelxl.baselibrary.f.c;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.findhouse.view.RentHouseDetailActivity;
import com.ziroom.ziroomcustomer.model.AlternateListing;
import com.ziroom.ziroomcustomer.util.ae;
import com.ziroom.ziroomcustomer.util.ah;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class j
  extends BaseAdapter
{
  private List<AlternateListing> a;
  private boolean b;
  private Context c;
  private int d;
  private float e;
  private List<String> f = new ArrayList();
  private LayoutInflater g;
  private a h;
  private int i = Color.parseColor("#FFA000");
  private int j = Color.parseColor("#999999");
  private int k = Color.parseColor("#444444");
  
  public j(Context paramContext, List<AlternateListing> paramList, a parama)
  {
    this.c = paramContext;
    this.a = paramList;
    this.h = parama;
    paramList = this.c.getApplicationContext().getResources().getDisplayMetrics();
    this.d = paramList.widthPixels;
    this.e = paramList.density;
    this.g = LayoutInflater.from(paramContext);
  }
  
  public void clearSelectIds()
  {
    this.f.clear();
  }
  
  public int getCount()
  {
    if (this.a == null) {
      return 0;
    }
    return this.a.size();
  }
  
  public List<AlternateListing> getData()
  {
    return this.a;
  }
  
  public List<String> getDeleteHouseIds()
  {
    return this.f;
  }
  
  public Object getItem(int paramInt)
  {
    return this.a.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, final ViewGroup paramViewGroup)
  {
    final AlternateListing localAlternateListing;
    Object localObject;
    boolean bool;
    if (paramView == null)
    {
      paramView = this.g.inflate(2130904389, paramViewGroup, false);
      paramViewGroup = new b();
      paramViewGroup.c = ((RelativeLayout)paramView.findViewById(2131692103));
      paramViewGroup.d = ((SimpleDraweeView)paramView.findViewById(2131691098));
      paramViewGroup.e = ((TextView)paramView.findViewById(2131690049));
      paramViewGroup.f = ((TextView)paramView.findViewById(2131689912));
      paramViewGroup.g = ((TextView)paramView.findViewById(2131695398));
      paramViewGroup.h = ((TextView)paramView.findViewById(2131689822));
      paramViewGroup.i = ((TextView)paramView.findViewById(2131695399));
      paramViewGroup.b = ((LinearLayout)paramView.findViewById(2131691838));
      paramViewGroup.a = ((CheckBox)paramView.findViewById(2131694828));
      paramViewGroup.b.getLayoutParams().width = this.d;
      paramView.setTag(paramViewGroup);
      localAlternateListing = (AlternateListing)getItem(paramInt);
      paramViewGroup.a.setOnCheckedChangeListener(null);
      if (!this.b) {
        break label479;
      }
      paramViewGroup.a.setVisibility(0);
      localObject = paramViewGroup.a;
      if ((TextUtils.isEmpty(localAlternateListing.getId())) || (!this.f.contains(localAlternateListing.getId()))) {
        break label473;
      }
      bool = true;
      label230:
      ((CheckBox)localObject).setChecked(bool);
      paramViewGroup.a.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
      {
        @Instrumented
        public void onCheckedChanged(CompoundButton paramAnonymousCompoundButton, boolean paramAnonymousBoolean)
        {
          VdsAgent.onCheckedChanged(this, paramAnonymousCompoundButton, paramAnonymousBoolean);
          if (!TextUtils.isEmpty(localAlternateListing.getId()))
          {
            if (!paramAnonymousBoolean) {
              break label98;
            }
            j.a(j.this).add(localAlternateListing.getId());
            if (j.b(j.this) != null)
            {
              paramAnonymousCompoundButton = j.b(j.this);
              if (j.c(j.this).size() != j.a(j.this).size()) {
                break label121;
              }
            }
          }
          label98:
          label121:
          for (paramAnonymousBoolean = true;; paramAnonymousBoolean = false)
          {
            paramAnonymousCompoundButton.onItemSelected(paramAnonymousBoolean);
            return;
            j.a(j.this).remove(localAlternateListing.getId());
            break;
          }
        }
      });
      label254:
      if (!this.b) {
        break label499;
      }
      localObject = new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          paramAnonymousView = paramViewGroup.a;
          if (!paramViewGroup.a.isChecked()) {}
          for (boolean bool = true;; bool = false)
          {
            paramAnonymousView.setChecked(bool);
            return;
          }
        }
      };
      paramView.setOnClickListener((View.OnClickListener)localObject);
      paramViewGroup.c.setOnClickListener((View.OnClickListener)localObject);
      label287:
      paramViewGroup.d.setController(c.frescoController(localAlternateListing.getHouse_photos()));
      paramViewGroup.e.setText(localAlternateListing.getRoom_name());
      if (localAlternateListing.getDuanzuFlag() == 1) {
        break label528;
      }
      paramViewGroup.f.setText(localAlternateListing.getSell_price() + "元/月");
      paramViewGroup.g.setText("（季付价）");
      label364:
      paramViewGroup.d.setAlpha(1.0F);
      paramViewGroup.e.setTextColor(this.k);
      paramViewGroup.f.setTextColor(this.k);
      if (TextUtils.isEmpty(localAlternateListing.getRoom_status())) {
        break label950;
      }
      if (!localAlternateListing.getRoom_status().equals("zxpzz")) {
        break label562;
      }
      paramViewGroup.h.setText("装修配置中");
      paramViewGroup.h.setTextColor(this.j);
    }
    for (;;)
    {
      if (!ae.isNull(localAlternateListing.getRelease_date())) {
        break label963;
      }
      paramViewGroup.i.setVisibility(8);
      return paramView;
      paramViewGroup = (b)paramView.getTag();
      break;
      label473:
      bool = false;
      break label230;
      label479:
      paramViewGroup.a.setVisibility(8);
      paramViewGroup.a.setChecked(false);
      break label254;
      label499:
      localObject = new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          paramAnonymousView = new Intent(j.d(j.this), RentHouseDetailActivity.class);
          paramAnonymousView.putExtra("id", localAlternateListing.getId());
          paramAnonymousView.putExtra("house_id", localAlternateListing.getHouse_id());
          j.d(j.this).startActivity(paramAnonymousView);
        }
      };
      paramView.setOnClickListener(null);
      paramViewGroup.c.setOnClickListener((View.OnClickListener)localObject);
      break label287;
      label528:
      paramViewGroup.f.setText(localAlternateListing.getShortDayRental() + "元/天");
      break label364;
      label562:
      if (localAlternateListing.getRoom_status().equals("dzz"))
      {
        paramViewGroup.h.setText("可签约");
        paramViewGroup.h.setTextColor(this.i);
      }
      else if (localAlternateListing.getRoom_status().equals("yxd"))
      {
        paramViewGroup.d.setAlpha(0.5F);
        paramViewGroup.e.setTextColor(this.j);
        paramViewGroup.f.setTextColor(this.j);
        paramViewGroup.h.setText("已下定");
        paramViewGroup.h.setTextColor(this.j);
      }
      else
      {
        if (localAlternateListing.getRoom_status().equals("ycz"))
        {
          paramViewGroup.d.setAlpha(0.5F);
          paramViewGroup.e.setTextColor(this.j);
          paramViewGroup.f.setTextColor(this.j);
          paramViewGroup.h.setText("已出租");
          if (ae.notNull(localAlternateListing.getRelease_date()))
          {
            paramViewGroup.i.setVisibility(0);
            localObject = "预计可释放日期 " + localAlternateListing.getRelease_date();
            ah.setTextColor(paramViewGroup.i, (String)localObject, 8, localAlternateListing.getRelease_date().length(), "#000000");
            paramViewGroup.h.setText("待释放");
            paramViewGroup.h.setTextColor(this.k);
          }
          for (;;)
          {
            if (ae.notNull(localAlternateListing.getIs_turn())) {
              paramViewGroup.h.setText("转租中");
            }
            paramViewGroup.h.setTextColor(this.j);
            break;
            paramViewGroup.i.setVisibility(8);
          }
        }
        if (localAlternateListing.getRoom_status().equals("tzpzz"))
        {
          paramViewGroup.h.setText("退租配置中");
          paramViewGroup.h.setTextColor(this.j);
        }
        else if (localAlternateListing.getRoom_status().equals("kyd"))
        {
          paramViewGroup.h.setText("可预定");
          paramViewGroup.h.setTextColor(this.i);
        }
        else
        {
          paramViewGroup.h.setText("");
          continue;
          label950:
          paramViewGroup.h.setText("");
        }
      }
    }
    label963:
    paramViewGroup.i.setVisibility(0);
    return paramView;
  }
  
  public void selectAll()
  {
    this.f.clear();
    if (this.a != null)
    {
      Iterator localIterator = this.a.iterator();
      while (localIterator.hasNext())
      {
        AlternateListing localAlternateListing = (AlternateListing)localIterator.next();
        this.f.add(localAlternateListing.getId());
      }
    }
    notifyDataSetChanged();
  }
  
  public void setData(List<AlternateListing> paramList)
  {
    this.a = paramList;
    notifyDataSetChanged();
  }
  
  public void setListener(a parama)
  {
    this.h = parama;
  }
  
  public void unSelectAll()
  {
    this.f.clear();
    notifyDataSetChanged();
  }
  
  public void updateToDefault()
  {
    this.f.clear();
    this.b = false;
    notifyDataSetChanged();
  }
  
  public void updateToManaging()
  {
    this.f.clear();
    this.b = true;
    notifyDataSetChanged();
  }
  
  public static abstract interface a
  {
    public abstract void onItemSelected(boolean paramBoolean);
  }
  
  static class b
  {
    CheckBox a;
    LinearLayout b;
    RelativeLayout c;
    SimpleDraweeView d;
    TextView e;
    TextView f;
    TextView g;
    TextView h;
    TextView i;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/adapter/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */