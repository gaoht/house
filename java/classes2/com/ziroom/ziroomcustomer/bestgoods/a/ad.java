package com.ziroom.ziroomcustomer.bestgoods.a;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.freelxl.baselibrary.f.c;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.bestgoods.activity.YouPinGoodsListActivity;
import com.ziroom.ziroomcustomer.bestgoods.activity.YouPinGuidanceActivity;
import com.ziroom.ziroomcustomer.bestgoods.model.al.d;
import com.ziroom.ziroomcustomer.newServiceList.utils.j;
import com.ziroom.ziroomcustomer.util.n;
import com.ziroom.ziroomcustomer.webview.JsBridgeWebActivity;
import java.util.List;

public class ad
  extends BaseAdapter
{
  private Context a;
  private List<al.d> b;
  private float c;
  private float d;
  
  public ad(Context paramContext, List<al.d> paramList)
  {
    this.a = paramContext;
    this.b = paramList;
    this.c = ((j.getDisplayWidth(paramContext) - n.dip2px(paramContext, 32.0F) - n.dip2px(paramContext, 8.0F) * 2) / 3.0F);
    this.d = (this.c * 73.0F / 109.0F);
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
      paramView = LayoutInflater.from(this.a).inflate(2130904593, paramViewGroup, false);
      paramViewGroup = new a();
      paramViewGroup.b = ((TextView)paramView.findViewById(2131689541));
      paramViewGroup.a = ((SimpleDraweeView)paramView.findViewById(2131694449));
      paramView.setTag(paramViewGroup);
    }
    for (;;)
    {
      ViewGroup.LayoutParams localLayoutParams = paramViewGroup.a.getLayoutParams();
      localLayoutParams.width = ((int)this.c);
      localLayoutParams.height = ((int)this.d);
      paramViewGroup.a.setLayoutParams(localLayoutParams);
      paramViewGroup.b.setText(((al.d)this.b.get(paramInt)).getTypeNameCha());
      paramViewGroup.a.setController(c.frescoController(((al.d)this.b.get(paramInt)).getUrl()));
      paramView.setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          if (TextUtils.isEmpty(((al.d)ad.a(ad.this).get(paramInt)).getJumpUrl()))
          {
            paramAnonymousView = new Intent(ad.b(ad.this), YouPinGoodsListActivity.class);
            paramAnonymousView.putExtra("typeCode", ((al.d)ad.a(ad.this).get(paramInt)).getTypecategoryCode());
            paramAnonymousView.putExtra("typeName", ((al.d)ad.a(ad.this).get(paramInt)).getTypeNameCha());
            ((YouPinGuidanceActivity)ad.b(ad.this)).startActivityAndFinish(paramAnonymousView);
            return;
          }
          paramAnonymousView = ((al.d)ad.a(ad.this).get(paramInt)).getJumpTitle();
          String str1 = ((al.d)ad.a(ad.this).get(paramInt)).getJumpUrl();
          if (!TextUtils.isEmpty(str1)) {}
          for (boolean bool = true;; bool = false)
          {
            String str2 = ((al.d)ad.a(ad.this).get(paramInt)).getUrl();
            JsBridgeWebActivity.start(ad.b(ad.this), paramAnonymousView, str1, bool, "", str2, false);
            return;
          }
        }
      });
      return paramView;
      paramViewGroup = (a)paramView.getTag();
    }
  }
  
  public class a
  {
    public SimpleDraweeView a;
    public TextView b;
    
    public a() {}
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/bestgoods/a/ad.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */