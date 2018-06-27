package com.ziroom.ziroomcustomer.signed;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.alibaba.fastjson.b;
import com.alibaba.fastjson.e;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.util.ae;
import com.ziroom.ziroomcustomer.util.w;
import java.util.ArrayList;
import java.util.List;

public class j
  extends BaseAdapter
{
  private Context a;
  private b b;
  private List<Integer> c = new ArrayList();
  private List<Integer> d = new ArrayList();
  private a e;
  private b f;
  private String g;
  private String h;
  
  public j(Context paramContext, List<Integer> paramList1, List<Integer> paramList2, b paramb)
  {
    this.a = paramContext;
    this.c = paramList1;
    this.d = paramList2;
    this.f = paramb;
  }
  
  public int getCount()
  {
    return this.d.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.d.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(final int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    label202:
    int i;
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.a).inflate(2130905022, null);
      this.b = new b(null);
      b.a(this.b, (CheckBox)paramView.findViewById(2131697237));
      b.a(this.b, paramView.findViewById(2131697233));
      b.a(this.b, (TextView)paramView.findViewById(2131697238));
      b.b(this.b, (TextView)paramView.findViewById(2131697241));
      b.a(this.b, (ImageView)paramView.findViewById(2131697242));
      b.a(this.b, (LineBreakLayout)paramView.findViewById(2131694030));
      b.a(this.b, (LinearLayout)paramView.findViewById(2131697236));
      b.b(this.b, (LinearLayout)paramView.findViewById(2131697239));
      paramView.setTag(this.b);
      if (((Integer)this.c.get(paramInt)).intValue() != 0) {
        break label393;
      }
      b.a(this.b).setChecked(false);
      if (this.f == null) {
        break label481;
      }
      i = 0;
      if (i >= this.f.size()) {
        break label481;
      }
      paramViewGroup = this.f.getJSONObject(i);
      if (!paramViewGroup.get("payment").equals(this.d.get(paramInt) + "")) {
        break label466;
      }
      if (1 != paramViewGroup.getInteger("isHot").intValue()) {
        break label407;
      }
      b.b(this.b).setVisibility(0);
    }
    label298:
    ArrayList localArrayList;
    int j;
    for (;;)
    {
      if (paramViewGroup.get("tags") != null)
      {
        paramViewGroup = paramViewGroup.getJSONArray("tags");
        localArrayList = new ArrayList();
        b.c(this.b).setLables(null);
        localArrayList.clear();
        j = 0;
        for (;;)
        {
          if (j < paramViewGroup.size())
          {
            localArrayList.add((String)paramViewGroup.get(j));
            j += 1;
            continue;
            this.b = ((b)paramView.getTag());
            break;
            label393:
            b.a(this.b).setChecked(true);
            break label202;
            label407:
            b.b(this.b).setVisibility(8);
            break label298;
          }
        }
        b.c(this.b).setLables(localArrayList, false);
        b.c(this.b).setEnabled(false);
        b.c(this.b).setVisibility(0);
      }
    }
    for (;;)
    {
      i += 1;
      break;
      label466:
      b.b(this.b).setVisibility(8);
    }
    label481:
    if (1 == ((Integer)this.d.get(paramInt)).intValue())
    {
      b.d(this.b).setText("押一付一");
      b.e(this.b).setVisibility(8);
      isCount(paramInt);
    }
    for (;;)
    {
      b.e(this.b).setTag(Integer.valueOf(paramInt));
      b.f(this.b).setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          if (j.d(j.this) != null) {
            j.d(j.this).onItemClick(paramInt);
          }
        }
      });
      b.a(this.b).setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          int i = 0;
          if (i < j.this.getCount())
          {
            if (paramInt == i)
            {
              j.e(j.this).set(i, Integer.valueOf(1));
              label44:
              if (((Integer)j.e(j.this).get(paramInt)).intValue() != 0) {
                break label111;
              }
              j.b.a(j.f(j.this)).setChecked(false);
            }
            for (;;)
            {
              i += 1;
              break;
              j.e(j.this).set(i, Integer.valueOf(0));
              break label44;
              label111:
              j.b.a(j.f(j.this)).setChecked(true);
            }
          }
          if (j.d(j.this) != null) {
            j.d(j.this).onCheck(j.e(j.this));
          }
          j.this.notifyDataSetChanged();
        }
      });
      return paramView;
      if (3 == ((Integer)this.d.get(paramInt)).intValue())
      {
        b.d(this.b).setText("押一付三");
        b.e(this.b).setVisibility(8);
        isCount(paramInt);
      }
      else if (6 == ((Integer)this.d.get(paramInt)).intValue())
      {
        b.e(this.b).setVisibility(8);
        b.d(this.b).setText("押一付六");
        isCount(paramInt);
      }
      else if (12 == ((Integer)this.d.get(paramInt)).intValue())
      {
        b.e(this.b).setVisibility(8);
        b.d(this.b).setText("押一付十二");
        isCount(paramInt);
      }
      else if (99 == ((Integer)this.d.get(paramInt)).intValue())
      {
        b.d(this.b).setText("一次性付清");
        b.e(this.b).setVisibility(8);
        isCount(paramInt);
      }
      else if (100 == ((Integer)this.d.get(paramInt)).intValue())
      {
        b.d(this.b).setText("自如白条");
        b.e(this.b).setVisibility(0);
        b.e(this.b).setText("查看详情");
        b.e(this.b).setOnClickListener(new View.OnClickListener()
        {
          @Instrumented
          public void onClick(View paramAnonymousView)
          {
            VdsAgent.onClick(this, paramAnonymousView);
            paramAnonymousView = new Intent(j.a(j.this), SignedJDPayWebActivity.class);
            paramAnonymousView.putExtra("url", j.b(j.this));
            paramAnonymousView.putExtra("title", "自如白条");
            paramAnonymousView.putExtra("pic", "https://is2-ssl.mzstatic.com/image/thumb/Purple3/v4/39/0a/84/390a84de-1d34-a651-d937-58ab617b0a5c/mzl.lovpnqpk.png/1024x1024ss-80.png");
            j.a(j.this).startActivity(paramAnonymousView);
            w.onEvent(j.a(j.this), "signup_payment_iou_detail");
          }
        });
        isCount(paramInt);
        if (this.f != null)
        {
          i = 0;
          while (i < this.f.size())
          {
            paramViewGroup = this.f.getJSONObject(i);
            if (paramViewGroup.get("payment").equals("isBlank"))
            {
              if (1 == paramViewGroup.getInteger("isHot").intValue())
              {
                b.b(this.b).setVisibility(0);
                if (!ae.notNull(paramViewGroup.getString("linkUrl"))) {
                  break label1075;
                }
                b.e(this.b).setVisibility(0);
                this.g = paramViewGroup.getString("linkUrl");
              }
              for (;;)
              {
                label986:
                if (paramViewGroup.get("tags") != null)
                {
                  paramViewGroup = paramViewGroup.getJSONArray("tags");
                  localArrayList = new ArrayList();
                  b.c(this.b).setLables(null);
                  j = 0;
                  for (;;)
                  {
                    if (j < paramViewGroup.size())
                    {
                      localArrayList.add((String)paramViewGroup.get(j));
                      j += 1;
                      continue;
                      b.b(this.b).setVisibility(8);
                      break;
                      label1075:
                      b.e(this.b).setVisibility(8);
                      break label986;
                    }
                  }
                  b.c(this.b).setLables(localArrayList, false);
                  b.c(this.b).setEnabled(false);
                  b.c(this.b).setVisibility(0);
                }
              }
            }
            i += 1;
          }
        }
      }
      else if (101 == ((Integer)this.d.get(paramInt)).intValue())
      {
        b.d(this.b).setText("自如客专享分期");
        b.e(this.b).setVisibility(0);
        b.e(this.b).setText("查看详情");
        b.e(this.b).setOnClickListener(new View.OnClickListener()
        {
          @Instrumented
          public void onClick(View paramAnonymousView)
          {
            VdsAgent.onClick(this, paramAnonymousView);
            paramAnonymousView = new Intent(j.a(j.this), SignedJDPayWebActivity.class);
            paramAnonymousView.putExtra("url", j.c(j.this));
            paramAnonymousView.putExtra("title", "自如客专享分期");
            paramAnonymousView.putExtra("pic", "https://is2-ssl.mzstatic.com/image/thumb/Purple3/v4/39/0a/84/390a84de-1d34-a651-d937-58ab617b0a5c/mzl.lovpnqpk.png/1024x1024ss-80.png");
            j.a(j.this).startActivity(paramAnonymousView);
          }
        });
        isCount(paramInt);
        if (this.f != null)
        {
          i = 0;
          while (i < this.f.size())
          {
            paramViewGroup = this.f.getJSONObject(i);
            if (paramViewGroup.get("payment").equals("isZWhite"))
            {
              if (1 == paramViewGroup.getInteger("isHot").intValue())
              {
                b.b(this.b).setVisibility(0);
                if (!ae.notNull(paramViewGroup.getString("linkUrl"))) {
                  break label1410;
                }
                b.e(this.b).setVisibility(0);
                this.h = paramViewGroup.getString("linkUrl");
              }
              for (;;)
              {
                label1321:
                if (paramViewGroup.get("tags") != null)
                {
                  paramViewGroup = paramViewGroup.getJSONArray("tags");
                  localArrayList = new ArrayList();
                  b.c(this.b).setLables(null);
                  j = 0;
                  for (;;)
                  {
                    if (j < paramViewGroup.size())
                    {
                      localArrayList.add((String)paramViewGroup.get(j));
                      j += 1;
                      continue;
                      b.b(this.b).setVisibility(8);
                      break;
                      label1410:
                      b.e(this.b).setVisibility(8);
                      break label1321;
                    }
                  }
                  b.c(this.b).setLables(localArrayList, false);
                  b.c(this.b).setEnabled(false);
                  b.c(this.b).setVisibility(0);
                }
              }
            }
            i += 1;
          }
        }
      }
    }
  }
  
  public List<Integer> getmCheck()
  {
    return this.c;
  }
  
  public List<Integer> getmList()
  {
    return this.d;
  }
  
  public a getmOnCheck()
  {
    return this.e;
  }
  
  public void isCount(int paramInt) {}
  
  public void setmCheck(List<Integer> paramList)
  {
    this.c = paramList;
  }
  
  public void setmList(List<Integer> paramList)
  {
    this.d = paramList;
  }
  
  public void setmOnCheck(a parama)
  {
    this.e = parama;
  }
  
  public static abstract interface a
  {
    public abstract void onCheck(List<Integer> paramList);
    
    public abstract void onItemClick(int paramInt);
  }
  
  private class b
  {
    private View b;
    private CheckBox c;
    private TextView d;
    private TextView e;
    private ImageView f;
    private LineBreakLayout g;
    private LinearLayout h;
    private LinearLayout i;
    
    private b() {}
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/signed/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */