package com.ziroom.ziroomcustomer.newchat.chatcenter;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.text.ClipboardManager;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.util.ah;
import java.util.List;

public class n
  extends BaseAdapter
{
  private Context a;
  private List<f> b;
  private String c;
  private PopupWindow d;
  private ClipboardManager e;
  
  public n(Context paramContext, List<f> paramList, String paramString)
  {
    this.a = paramContext;
    this.b = paramList;
    this.c = paramString;
    this.e = ((ClipboardManager)paramContext.getSystemService("clipboard"));
  }
  
  private void a(TextView paramTextView)
  {
    this.d = new PopupWindow(this.a);
    this.d.setBackgroundDrawable(new ColorDrawable(0));
    this.d.setOutsideTouchable(true);
    Object localObject = View.inflate(this.a, 2130905180, null);
    ((TextView)((View)localObject).findViewById(2131693221)).setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        n.b(n.this).setText(this.a);
        n.c(n.this).dismiss();
      }
    });
    this.d.setContentView((View)localObject);
    this.d.setWidth(-2);
    this.d.setHeight(-2);
    localObject = new int[2];
    paramTextView.getLocationInWindow((int[])localObject);
    PopupWindow localPopupWindow = this.d;
    int i = localObject[0] + 20;
    int j = localObject[1] - 90;
    if (!(localPopupWindow instanceof PopupWindow))
    {
      localPopupWindow.showAtLocation(paramTextView, 48, i, j);
      return;
    }
    VdsAgent.showAtLocation((PopupWindow)localPopupWindow, paramTextView, 48, i, j);
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
  
  public View getView(int paramInt, View paramView, final ViewGroup paramViewGroup)
  {
    if (paramView == null)
    {
      paramView = View.inflate(this.a, 2130904145, null);
      paramViewGroup = new a();
      paramViewGroup.a = ((TextView)paramView.findViewById(2131690053));
      paramViewGroup.b = ((TextView)paramView.findViewById(2131694884));
      paramViewGroup.c = ((TextView)paramView.findViewById(2131690049));
      paramViewGroup.d = ((TextView)paramView.findViewById(2131694885));
      paramViewGroup.e = ((TextView)paramView.findViewById(2131689926));
      paramViewGroup.f = ((TextView)paramView.findViewById(2131694886));
      paramViewGroup.g = ((TextView)paramView.findViewById(2131694887));
      paramView.setTag(paramViewGroup);
    }
    for (;;)
    {
      final f localf = (f)this.b.get(paramInt);
      paramViewGroup.a.setText(this.c);
      paramViewGroup.b.setText(localf.getServiceSupplier());
      paramViewGroup.c.setText(localf.getBroadbandHandler());
      paramViewGroup.d.setText(localf.getBroadbandPassword());
      paramViewGroup.e.setText(localf.getSupplierPhone());
      paramViewGroup.f.setText(localf.getStartDate());
      paramViewGroup.g.setText(localf.getEndDate());
      paramViewGroup.e.setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          if (!TextUtils.isEmpty(localf.getSupplierPhone())) {
            ah.callPhone(n.a(n.this), localf.getSupplierPhone());
          }
        }
      });
      paramViewGroup.e.setOnLongClickListener(new View.OnLongClickListener()
      {
        public boolean onLongClick(View paramAnonymousView)
        {
          n.a(n.this, paramViewGroup.e);
          return true;
        }
      });
      paramViewGroup.c.setOnLongClickListener(new View.OnLongClickListener()
      {
        public boolean onLongClick(View paramAnonymousView)
        {
          n.a(n.this, paramViewGroup.c);
          return true;
        }
      });
      paramViewGroup.d.setOnLongClickListener(new View.OnLongClickListener()
      {
        public boolean onLongClick(View paramAnonymousView)
        {
          n.a(n.this, paramViewGroup.d);
          return true;
        }
      });
      return paramView;
      paramViewGroup = (a)paramView.getTag();
    }
  }
  
  public class a
  {
    public TextView a;
    public TextView b;
    public TextView c;
    public TextView d;
    public TextView e;
    public TextView f;
    public TextView g;
    
    public a() {}
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/newchat/chatcenter/n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */