package com.ziroom.ziroomcustomer.findhouse.view;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.findhouse.a.c;
import com.ziroom.ziroomcustomer.findhouse.presenter.model.RentHouseDetail.ActivityArray;
import com.ziroom.ziroomcustomer.util.ae;
import com.ziroom.ziroomcustomer.webview.JsBridgeWebActivity;
import java.util.List;

public class HouseActivityPop
  extends PopupWindow
  implements View.OnClickListener
{
  private ListView a;
  private View b;
  private TextView c;
  private Context d;
  private List<RentHouseDetail.ActivityArray> e;
  
  public HouseActivityPop(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public HouseActivityPop(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public HouseActivityPop(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    setSoftInputMode(16);
    setWidth(-1);
    setHeight(-1);
    this.b = LayoutInflater.from(paramContext).inflate(2130905203, null);
    this.d = paramContext;
    a();
  }
  
  private void a()
  {
    this.c = ((TextView)this.b.findViewById(2131697712));
    this.a = ((ListView)this.b.findViewById(2131697711));
    this.c.setOnClickListener(this);
    this.a.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      @Instrumented
      public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        VdsAgent.onItemClick(this, paramAnonymousAdapterView, paramAnonymousView, paramAnonymousInt, paramAnonymousLong);
        if ((HouseActivityPop.a(HouseActivityPop.this) != null) && (HouseActivityPop.a(HouseActivityPop.this).size() > 0) && (ae.notNull(((RentHouseDetail.ActivityArray)HouseActivityPop.a(HouseActivityPop.this).get(paramAnonymousInt)).getLink()))) {
          JsBridgeWebActivity.start(HouseActivityPop.b(HouseActivityPop.this), null, ((RentHouseDetail.ActivityArray)HouseActivityPop.a(HouseActivityPop.this).get(paramAnonymousInt)).getLink());
        }
      }
    });
    setContentView(this.b);
  }
  
  @Instrumented
  public void onClick(View paramView)
  {
    VdsAgent.onClick(this, paramView);
    switch (paramView.getId())
    {
    default: 
      return;
    }
    dismiss();
  }
  
  public void show(View paramView, List<RentHouseDetail.ActivityArray> paramList)
  {
    this.e = paramList;
    if ((paramList != null) && (paramList.size() > 0))
    {
      paramList = new c(paramList, this.d);
      this.a.setAdapter(paramList);
      setBackgroundDrawable(new ColorDrawable(-1342177280));
      if (!(this instanceof PopupWindow)) {
        super.showAtLocation(paramView, 0, 0, 0);
      }
    }
    else
    {
      return;
    }
    VdsAgent.showAtLocation((PopupWindow)this, paramView, 0, 0, 0);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcustomer/findhouse/view/HouseActivityPop.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */