package com.ziroom.ziroomcustomer.newclean.b;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.model.UserInfo;
import com.ziroom.ziroomcustomer.newclean.activity.ModifyNewAddressActivity;
import com.ziroom.ziroomcustomer.newclean.d.c;
import com.ziroom.ziroomcustomer.util.w;
import com.ziroom.ziroomcustomer.widget.LabeledEditText;
import java.util.List;

public class i
  extends BaseAdapter
{
  private Context a;
  private List<c> b;
  private boolean c;
  private UserInfo d;
  
  public i(Context paramContext, List<c> paramList, boolean paramBoolean)
  {
    this.a = paramContext;
    this.b = paramList;
    this.c = paramBoolean;
    this.d = ApplicationEx.c.getUser();
  }
  
  public int getCount()
  {
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
    final c localc;
    if (paramView == null)
    {
      paramView = View.inflate(this.a, 2130904397, null);
      paramViewGroup = new a();
      paramViewGroup.a = ((LabeledEditText)paramView.findViewById(2131690053));
      paramViewGroup.b = ((ImageView)paramView.findViewById(2131695440));
      paramViewGroup.c = ((RelativeLayout)paramView.findViewById(2131695437));
      paramViewGroup.d = ((RelativeLayout)paramView.findViewById(2131695439));
      paramViewGroup.e = ((RelativeLayout)paramView.findViewById(2131695438));
      paramView.setTag(paramViewGroup);
      localc = (c)this.b.get(paramInt);
      paramViewGroup.a.setText(localc.getLinkPhone(), localc.getVillage() + localc.getDetAddress());
      if ((!"2".equals(localc.getDataSource())) && (this.c)) {
        break label241;
      }
      paramViewGroup.a.setText(localc.getLinkPhone(), "整租·" + localc.getVillage() + localc.getDetAddress());
    }
    for (;;)
    {
      paramViewGroup.d.setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          paramAnonymousView = new Intent(i.a(i.this), ModifyNewAddressActivity.class);
          paramAnonymousView.putExtra("modify", "modify");
          paramAnonymousView.putExtra("addressList", localc);
          paramAnonymousView.putExtra("modify_position", paramInt + "");
          if (("2".equals(localc.getDataSource())) || (!i.b(i.this))) {
            paramAnonymousView.putExtra("isZhengzu", "isZhengzu");
          }
          ((Activity)i.a(i.this)).startActivityForResult(paramAnonymousView, 2);
          w.onEvent(i.a(i.this), "dailyaddress_edit");
        }
      });
      return paramView;
      paramViewGroup = (a)paramView.getTag();
      break;
      label241:
      paramViewGroup.e.setVisibility(8);
      paramViewGroup.d.setVisibility(0);
    }
  }
  
  public class a
  {
    public LabeledEditText a;
    public ImageView b;
    public RelativeLayout c;
    public RelativeLayout d;
    public RelativeLayout e;
    
    public a() {}
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newclean/b/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */