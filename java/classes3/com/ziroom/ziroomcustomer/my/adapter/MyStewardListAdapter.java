package com.ziroom.ziroomcustomer.my.adapter;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.facebook.drawee.view.SimpleDraweeView;
import com.freelxl.baselibrary.f.c;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.my.MyStewardListActivity;
import com.ziroom.ziroomcustomer.my.model.MyStewardListEntity;
import com.ziroom.ziroomcustomer.util.ae;
import com.ziroom.ziroomcustomer.util.ah;
import java.util.List;

public class MyStewardListAdapter
  extends BaseAdapter
{
  private Context a;
  private List<MyStewardListEntity> b;
  private viewHolder c;
  
  public MyStewardListAdapter(Context paramContext, List<MyStewardListEntity> paramList)
  {
    this.a = paramContext;
    this.b = paramList;
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
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(final int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null)
    {
      paramView = View.inflate(this.a, 2130904960, null);
      this.c = new viewHolder(paramView);
      paramView.setTag(this.c);
    }
    while (this.b.get(paramInt) == null)
    {
      return paramView;
      this.c = ((viewHolder)paramView.getTag());
    }
    if (ae.notNull(((MyStewardListEntity)this.b.get(paramInt)).getAddress()))
    {
      this.c.my_steward_item_address.setText("合同地址:" + ((MyStewardListEntity)this.b.get(paramInt)).getAddress());
      if (!ae.notNull(((MyStewardListEntity)this.b.get(paramInt)).getEmpName())) {
        break label321;
      }
      this.c.my_steward_item_name.setText("自如Z.O." + ((MyStewardListEntity)this.b.get(paramInt)).getEmpName());
      label197:
      this.c.my_steward_item_img.setController(c.frescoController(((MyStewardListEntity)this.b.get(paramInt)).getPic()));
      if (!ae.notNull(((MyStewardListEntity)this.b.get(paramInt)).getHouse_evaluation_introduction())) {
        break label336;
      }
      this.c.my_steward_item_text.setText(((MyStewardListEntity)this.b.get(paramInt)).getHouse_evaluation_introduction());
    }
    for (;;)
    {
      this.c.contact_housekeeper.setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          if (ae.isNull(((MyStewardListEntity)MyStewardListAdapter.a(MyStewardListAdapter.this).get(paramInt)).getPhoneMobile()))
          {
            ((MyStewardListActivity)MyStewardListAdapter.b(MyStewardListAdapter.this)).showToast("管家联系方式更换，请直接联系400客服");
            return;
          }
          ah.callPhone(MyStewardListAdapter.b(MyStewardListAdapter.this), ((MyStewardListEntity)MyStewardListAdapter.a(MyStewardListAdapter.this).get(paramInt)).getPhoneMobile());
        }
      });
      this.c.contact_housekeeper.setVisibility(0);
      return paramView;
      this.c.my_steward_item_address.setText("合同地址:");
      break;
      label321:
      this.c.my_steward_item_name.setText("自如Z.O.");
      break label197;
      label336:
      this.c.my_steward_item_text.setText("");
    }
  }
  
  class viewHolder
  {
    @BindView(2131696624)
    TextView contact_housekeeper;
    @BindView(2131697000)
    TextView my_steward_item_address;
    @BindView(2131697001)
    SimpleDraweeView my_steward_item_img;
    @BindView(2131697002)
    TextView my_steward_item_name;
    @BindView(2131697003)
    TextView my_steward_item_text;
    
    viewHolder(View paramView)
    {
      ButterKnife.bind(this, paramView);
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/my/adapter/MyStewardListAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */