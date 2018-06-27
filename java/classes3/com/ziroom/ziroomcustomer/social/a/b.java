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
import com.freelxl.baselibrary.f.c;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.social.model.a;
import com.ziroom.ziroomcustomer.social.model.l;
import com.ziroom.ziroomcustomer.util.x;
import com.ziroom.ziroomcustomer.webview.JsBridgeWebActivity;
import java.util.List;

public class b
  extends BaseAdapter
{
  private Context a;
  private List<a> b;
  private LayoutInflater c;
  
  public b(Context paramContext, List<a> paramList)
  {
    this.a = paramContext;
    this.b = paramList;
    this.c = LayoutInflater.from(this.a);
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
      localObject = new a();
      paramView = this.c.inflate(2130904536, paramViewGroup, false);
      ((a)localObject).a = ((SimpleDraweeView)paramView.findViewById(2131693871));
      ((a)localObject).b = ((TextView)paramView.findViewById(2131689541));
      paramView.setTag(localObject);
    }
    final a locala;
    for (paramViewGroup = (ViewGroup)localObject;; paramViewGroup = (a)paramView.getTag())
    {
      locala = (a)this.b.get(paramInt);
      if (locala != null) {
        break;
      }
      return paramView;
    }
    String str = locala.getHead_image();
    Object localObject = str;
    if (!TextUtils.isEmpty(str)) {
      localObject = x.makeUrl(str);
    }
    c.loadHolderImage(paramViewGroup.a, (String)localObject);
    paramViewGroup.b.setText(locala.getTitle());
    paramView.setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        if (locala.getShare_info() != null)
        {
          JsBridgeWebActivity.start(b.a(b.this), "", locala.getUrl(), true, locala.getShare_info().getContent(), locala.getShare_info().getImage(), false);
          return;
        }
        JsBridgeWebActivity.start(b.a(b.this), "", locala.getUrl());
      }
    });
    return paramView;
  }
  
  public static class a
  {
    SimpleDraweeView a;
    TextView b;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/social/a/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */