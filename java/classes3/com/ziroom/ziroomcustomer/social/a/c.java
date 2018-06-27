package com.ziroom.ziroomcustomer.social.a;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.freelxl.baselibrary.f.d;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.social.model.l;
import com.ziroom.ziroomcustomer.social.model.m.a;
import com.ziroom.ziroomcustomer.social.model.m.a.a;
import com.ziroom.ziroomcustomer.util.x;
import com.ziroom.ziroomcustomer.webview.JsBridgeWebActivity;
import java.util.List;

public class c
  extends BaseAdapter
{
  private Context a;
  private List<m.a> b;
  
  public c(Context paramContext, List<m.a> paramList)
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
    return this.b.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null)
    {
      paramViewGroup = new a(null);
      paramView = LayoutInflater.from(this.a).inflate(2130904537, null, false);
      paramViewGroup.a = ((SimpleDraweeView)paramView.findViewById(2131693871));
      paramViewGroup.b = ((TextView)paramView.findViewById(2131692733));
      paramViewGroup.c = ((TextView)paramView.findViewById(2131689541));
      paramViewGroup.d = ((TextView)paramView.findViewById(2131695681));
      paramViewGroup.e = ((TextView)paramView.findViewById(2131695682));
      paramViewGroup.f = ((TextView)paramView.findViewById(2131695683));
      paramViewGroup.g = ((TextView)paramView.findViewById(2131695684));
      paramViewGroup.h = ((TextView)paramView.findViewById(2131695687));
      paramViewGroup.i = ((TextView)paramView.findViewById(2131695688));
      paramViewGroup.j = ((SimpleDraweeView)paramView.findViewById(2131695685));
      paramViewGroup.k = paramView.findViewById(2131689863);
      paramView.setTag(paramViewGroup);
    }
    final m.a locala;
    for (;;)
    {
      locala = (m.a)this.b.get(paramInt);
      if (locala != null) {
        break;
      }
      return paramView;
      paramViewGroup = (a)paramView.getTag();
    }
    Object localObject2 = locala.getCover_pic();
    Object localObject1 = localObject2;
    if (!TextUtils.isEmpty((CharSequence)localObject2)) {
      localObject1 = x.makeUrl((String)localObject2);
    }
    com.freelxl.baselibrary.f.c.loadHolderImage(paramViewGroup.a, (String)localObject1);
    paramViewGroup.b.setText(locala.getType());
    paramViewGroup.c.setText(locala.getTitle());
    paramViewGroup.d.setText(locala.getView_counts() + "");
    paramViewGroup.e.setText(locala.getEnroll_counts() + "人报名");
    localObject2 = paramViewGroup.f;
    StringBuilder localStringBuilder = new StringBuilder().append("地点：");
    if (TextUtils.isEmpty(locala.getBusiness())) {}
    for (localObject1 = locala.getAddress();; localObject1 = locala.getBusiness())
    {
      ((TextView)localObject2).setText((String)localObject1);
      paramViewGroup.g.setText("时间：" + locala.getStart_time() + " - " + locala.getEnd_time());
      if (locala.getUser_info() != null) {
        break;
      }
      paramViewGroup.h.setVisibility(8);
      paramViewGroup.i.setVisibility(8);
      paramViewGroup.a.setVisibility(8);
      paramViewGroup.k.setVisibility(8);
      return paramView;
    }
    paramViewGroup.h.setVisibility(0);
    paramViewGroup.i.setVisibility(0);
    paramViewGroup.a.setVisibility(0);
    paramViewGroup.k.setVisibility(0);
    paramViewGroup.h.setText(locala.getUser_info().getNick_name());
    paramViewGroup.i.setText(locala.getUser_info().getDesc());
    localObject2 = locala.getUser_info().getHead_pic();
    localObject1 = localObject2;
    if (!TextUtils.isEmpty((CharSequence)localObject2)) {
      localObject1 = x.makeUrl((String)localObject2, 0.2F);
    }
    com.freelxl.baselibrary.f.c.loadHolderImage(paramViewGroup.j, (String)localObject1);
    paramView.setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        d.d("jdskgjfkl", "=======   " + locala.getDetail_url());
        if (locala.getShare_info() != null)
        {
          JsBridgeWebActivity.start(c.a(c.this), "", locala.getDetail_url(), true, locala.getShare_info().getContent(), locala.getShare_info().getImage(), false, true);
          return;
        }
        JsBridgeWebActivity.start(c.a(c.this), "", locala.getDetail_url(), false, "", "", false, true);
      }
    });
    return paramView;
  }
  
  private static class a
  {
    SimpleDraweeView a;
    TextView b;
    TextView c;
    TextView d;
    TextView e;
    TextView f;
    TextView g;
    TextView h;
    TextView i;
    SimpleDraweeView j;
    View k;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/social/a/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */