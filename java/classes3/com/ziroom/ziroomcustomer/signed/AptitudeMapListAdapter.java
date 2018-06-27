package com.ziroom.ziroomcustomer.signed;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.ziroom.ziroomcustomer.util.s;
import java.util.List;

public class AptitudeMapListAdapter
  extends BaseAdapter
{
  int a = -1;
  private Context b;
  private List<a> c;
  private ViewHolder d;
  private boolean e;
  private a f;
  private int g = 0;
  
  public AptitudeMapListAdapter(Context paramContext, List<a> paramList)
  {
    this.b = paramContext;
    this.c = paramList;
  }
  
  public AptitudeMapListAdapter(Context paramContext, boolean paramBoolean, List<a> paramList)
  {
    this.b = paramContext;
    this.e = paramBoolean;
    this.c = paramList;
  }
  
  public int getCount()
  {
    if (s.isEmpty(this.c)) {
      return 0;
    }
    return this.c.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.c.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public a getOnClick()
  {
    return this.f;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    paramViewGroup = (a)this.c.get(paramInt);
    if (paramView == null)
    {
      paramView = View.inflate(this.b, 2130903654, null);
      this.d = new ViewHolder(paramView);
      paramView.setTag(this.d);
      this.d.aptitude_address_title.setText(paramViewGroup.getName());
      this.d.aptitude_address_content.setText(paramViewGroup.getAddress());
      if (this.a != 1) {
        break label138;
      }
      this.d.aptitude_address_leftIcon.setVisibility(0);
    }
    for (;;)
    {
      if ((paramInt != this.g) || (this.e)) {
        break label153;
      }
      this.d.aptitude_address_check.setVisibility(0);
      return paramView;
      this.d = ((ViewHolder)paramView.getTag());
      break;
      label138:
      this.d.aptitude_address_leftIcon.setVisibility(8);
    }
    label153:
    this.d.aptitude_address_check.setVisibility(8);
    return paramView;
  }
  
  public List<a> getmList()
  {
    return this.c;
  }
  
  public void setCurrentPos(int paramInt)
  {
    this.g = paramInt;
  }
  
  public void setCurrentType(int paramInt)
  {
    this.a = paramInt;
  }
  
  public void setOnClick(a parama)
  {
    this.f = parama;
  }
  
  public void setmList(List<a> paramList)
  {
    this.c = paramList;
    notifyDataSetChanged();
  }
  
  static class ViewHolder
  {
    @BindView(2131693147)
    ImageView aptitude_address_check;
    @BindView(2131693146)
    TextView aptitude_address_content;
    @BindView(2131693144)
    ImageView aptitude_address_leftIcon;
    @BindView(2131693145)
    TextView aptitude_address_title;
    
    ViewHolder(View paramView)
    {
      ButterKnife.bind(this, paramView);
    }
  }
  
  static abstract interface a
  {
    public abstract void onClick(a parama);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/signed/AptitudeMapListAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */