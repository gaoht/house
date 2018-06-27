package com.ziroom.ziroomcustomer.social.a;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import com.facebook.drawee.view.SimpleDraweeView;
import com.freelxl.baselibrary.f.c;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.ziroomcustomer.social.activity.zz.ZzSocialChatDetailActivity;
import com.ziroom.ziroomcustomer.social.model.j;
import java.util.List;

public class e
  extends BaseAdapter
{
  private List<j> a;
  private Context b;
  private b c;
  
  public e(Context paramContext, List<j> paramList)
  {
    this.a = paramList;
    this.b = paramContext;
  }
  
  public int getCount()
  {
    if (this.a == null) {
      return 0;
    }
    return this.a.size();
  }
  
  public Object getItem(int paramInt)
  {
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public View getView(final int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    final j localj;
    if (paramView == null)
    {
      paramView = View.inflate(this.b, 2130904540, null);
      paramViewGroup = new a();
      paramViewGroup.a = ((SimpleDraweeView)paramView.findViewById(2131694931));
      paramViewGroup.b = ((TextView)paramView.findViewById(2131695690));
      paramViewGroup.c = ((TextView)paramView.findViewById(2131695691));
      paramViewGroup.d = ((TextView)paramView.findViewById(2131695692));
      paramViewGroup.e = ((TextView)paramView.findViewById(2131691194));
      paramViewGroup.f = ((TextView)paramView.findViewById(2131690394));
      paramView.setTag(paramViewGroup);
      localj = (j)this.a.get(paramInt);
      if (paramViewGroup.a.getTag() != null) {
        break label282;
      }
      if (!TextUtils.isEmpty(localj.getHeadPic()))
      {
        paramViewGroup.a.setTag(localj.getHeadPic());
        paramViewGroup.a.setController(c.frescoController(localj.getHeadPic()));
      }
      label170:
      if (localj.getLastSpan() != null) {
        break label341;
      }
      paramViewGroup.d.setText(localj.getLastMessage());
      label190:
      paramViewGroup.e.setText(localj.getLastTime());
      paramViewGroup.c.setText(localj.getLiveNess());
      paramViewGroup.b.setText(localj.getNickName());
      if (localj.getUnReadSize() <= 0) {
        break label359;
      }
      paramViewGroup.f.setVisibility(0);
    }
    for (;;)
    {
      paramView.setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          paramAnonymousView = new Intent(e.a(e.this), ZzSocialChatDetailActivity.class);
          paramAnonymousView.putExtra("toChatUid", localj.getToChatUid());
          paramAnonymousView.putExtra("toChatPic", localj.getHeadPic());
          paramAnonymousView.putExtra("toChatName", localj.getNickName());
          paramAnonymousView.putExtra("isFrom", "isFrom_friendlist");
          e.a(e.this).startActivity(paramAnonymousView);
        }
      });
      paramView.setOnLongClickListener(new View.OnLongClickListener()
      {
        public boolean onLongClick(View paramAnonymousView)
        {
          if (e.b(e.this) != null) {
            e.b(e.this).deleteCurrentFriend(paramInt);
          }
          return true;
        }
      });
      return paramView;
      paramViewGroup = (a)paramView.getTag();
      break;
      label282:
      if ((TextUtils.isEmpty(localj.getHeadPic())) || (paramViewGroup.a.getTag().equals(localj.getHeadPic()))) {
        break label170;
      }
      paramViewGroup.a.setTag(localj.getHeadPic());
      paramViewGroup.a.setController(c.frescoController(localj.getHeadPic()));
      break label170;
      label341:
      paramViewGroup.d.setText(localj.getLastSpan(), TextView.BufferType.SPANNABLE);
      break label190;
      label359:
      paramViewGroup.f.setVisibility(8);
    }
  }
  
  public void setOnItemLongClickListener(b paramb)
  {
    this.c = paramb;
  }
  
  public class a
  {
    public SimpleDraweeView a;
    public TextView b;
    public TextView c;
    public TextView d;
    public TextView e;
    public TextView f;
    
    public a() {}
  }
  
  public static abstract interface b
  {
    public abstract void deleteCurrentFriend(int paramInt);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/social/a/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */