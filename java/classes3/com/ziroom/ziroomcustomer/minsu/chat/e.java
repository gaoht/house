package com.ziroom.ziroomcustomer.minsu.chat;

import android.app.Activity;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.Filter.FilterResults;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import com.alibaba.fastjson.a;
import com.facebook.drawee.view.SimpleDraweeView;
import com.hyphenate.chat.EMClient;
import com.hyphenate.chat.EMConversation;
import com.hyphenate.chat.EMConversation.EMConversationType;
import com.hyphenate.chat.EMGroup;
import com.hyphenate.chat.EMGroupManager;
import com.hyphenate.chat.EMMessage;
import com.hyphenate.chat.EMPushManager;
import com.hyphenate.chat.EMTextMessageBody;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.home.view.recyclerview2gallery.b;
import com.ziroom.ziroomcustomer.minsu.chat.d.i;
import com.ziroom.ziroomcustomer.minsu.f.ab;
import com.ziroom.ziroomcustomer.newchat.SmileUtils;
import com.ziroom.ziroomcustomer.util.ae;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class e
  extends ArrayAdapter<EMConversation>
{
  protected int a;
  protected int b;
  protected int c;
  protected int d;
  protected int e;
  protected float f;
  private Activity g;
  private List<EMConversation> h;
  private List<EMConversation> i;
  private a j;
  private boolean k;
  private int l = -1;
  private int m = -1;
  private int n = -1;
  private int o = -1;
  private MinsuChatListView.a p;
  
  public e(Activity paramActivity, int paramInt, List<EMConversation> paramList)
  {
    super(paramActivity, paramInt, paramList);
    this.g = paramActivity;
    this.h = paramList;
    this.i = new ArrayList();
    this.i.addAll(paramList);
  }
  
  private void a(b paramb, EMConversation paramEMConversation)
  {
    int i1 = paramEMConversation.getUnreadMsgCount();
    if (i1 > 0)
    {
      paramb.b.setVisibility(0);
      paramb.b.setText(String.valueOf(i1));
      if (a(paramEMConversation))
      {
        paramb.b.setBackgroundResource(2130840308);
        return;
      }
      paramb.b.setBackgroundResource(2130839083);
      return;
    }
    paramb.b.setVisibility(8);
  }
  
  private boolean a(EMConversation paramEMConversation)
  {
    List localList = EMClient.getInstance().pushManager().getNoPushGroups();
    if (localList != null) {
      return localList.contains(paramEMConversation.conversationId());
    }
    return false;
  }
  
  /* Error */
  private void b(b paramb, EMConversation paramEMConversation)
  {
    // Byte code:
    //   0: invokestatic 109	com/hyphenate/chat/EMClient:getInstance	()Lcom/hyphenate/chat/EMClient;
    //   3: invokevirtual 136	com/hyphenate/chat/EMClient:groupManager	()Lcom/hyphenate/chat/EMGroupManager;
    //   6: aload_2
    //   7: invokevirtual 123	com/hyphenate/chat/EMConversation:conversationId	()Ljava/lang/String;
    //   10: invokevirtual 142	com/hyphenate/chat/EMGroupManager:getGroup	(Ljava/lang/String;)Lcom/hyphenate/chat/EMGroup;
    //   13: astore_2
    //   14: aload_2
    //   15: ifnull +92 -> 107
    //   18: aload_2
    //   19: invokevirtual 147	com/hyphenate/chat/EMGroup:getGroupName	()Ljava/lang/String;
    //   22: astore_3
    //   23: aload_1
    //   24: getfield 149	com/ziroom/ziroomcustomer/minsu/chat/e$b:a	Landroid/widget/TextView;
    //   27: aload_3
    //   28: invokevirtual 95	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   31: aload_2
    //   32: invokevirtual 152	com/hyphenate/chat/EMGroup:getDescription	()Ljava/lang/String;
    //   35: astore_3
    //   36: aload_3
    //   37: invokestatic 158	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   40: ifne +67 -> 107
    //   43: ldc -96
    //   45: astore 4
    //   47: aload_3
    //   48: invokestatic 166	com/alibaba/fastjson/a:parseObject	(Ljava/lang/String;)Lcom/alibaba/fastjson/e;
    //   51: ldc -88
    //   53: invokevirtual 174	com/alibaba/fastjson/e:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   56: astore_2
    //   57: aload_3
    //   58: invokestatic 166	com/alibaba/fastjson/a:parseObject	(Ljava/lang/String;)Lcom/alibaba/fastjson/e;
    //   61: ldc -80
    //   63: invokevirtual 174	com/alibaba/fastjson/e:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   66: astore_3
    //   67: aload_2
    //   68: invokestatic 158	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   71: ifne +28 -> 99
    //   74: aload_1
    //   75: getfield 179	com/ziroom/ziroomcustomer/minsu/chat/e$b:e	Lcom/facebook/drawee/view/SimpleDraweeView;
    //   78: ldc -76
    //   80: invokevirtual 186	com/facebook/drawee/view/SimpleDraweeView:getTag	(I)Ljava/lang/Object;
    //   83: astore 4
    //   85: aload 4
    //   87: ifnull +35 -> 122
    //   90: aload_2
    //   91: aload 4
    //   93: invokevirtual 189	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   96: ifeq +26 -> 122
    //   99: aload_1
    //   100: getfield 191	com/ziroom/ziroomcustomer/minsu/chat/e$b:g	Landroid/widget/TextView;
    //   103: aload_3
    //   104: invokevirtual 95	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   107: return
    //   108: astore_3
    //   109: ldc -96
    //   111: astore_2
    //   112: aload_3
    //   113: invokevirtual 194	java/lang/Exception:printStackTrace	()V
    //   116: aload 4
    //   118: astore_3
    //   119: goto -52 -> 67
    //   122: aload_1
    //   123: getfield 179	com/ziroom/ziroomcustomer/minsu/chat/e$b:e	Lcom/facebook/drawee/view/SimpleDraweeView;
    //   126: ldc -76
    //   128: aload_2
    //   129: invokevirtual 198	com/facebook/drawee/view/SimpleDraweeView:setTag	(ILjava/lang/Object;)V
    //   132: aload_1
    //   133: getfield 179	com/ziroom/ziroomcustomer/minsu/chat/e$b:e	Lcom/facebook/drawee/view/SimpleDraweeView;
    //   136: getstatic 203	com/ziroom/ziroomcustomer/base/ApplicationEx:c	Lcom/ziroom/ziroomcustomer/base/ApplicationEx;
    //   139: invokestatic 209	com/ziroom/ziroomcustomer/minsu/f/d:getRoundingHierarchy	(Landroid/content/Context;)Lcom/facebook/drawee/generic/GenericDraweeHierarchy;
    //   142: invokevirtual 213	com/facebook/drawee/view/SimpleDraweeView:setHierarchy	(Lcom/facebook/drawee/interfaces/DraweeHierarchy;)V
    //   145: aload_1
    //   146: getfield 179	com/ziroom/ziroomcustomer/minsu/chat/e$b:e	Lcom/facebook/drawee/view/SimpleDraweeView;
    //   149: aload_2
    //   150: invokestatic 219	com/freelxl/baselibrary/f/c:frescoController	(Ljava/lang/String;)Lcom/facebook/drawee/controller/AbstractDraweeController;
    //   153: invokevirtual 223	com/facebook/drawee/view/SimpleDraweeView:setController	(Lcom/facebook/drawee/interfaces/DraweeController;)V
    //   156: goto -57 -> 99
    //   159: astore_3
    //   160: goto -48 -> 112
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	163	0	this	e
    //   0	163	1	paramb	b
    //   0	163	2	paramEMConversation	EMConversation
    //   22	82	3	str	String
    //   108	5	3	localException1	Exception
    //   118	1	3	localObject1	Object
    //   159	1	3	localException2	Exception
    //   45	72	4	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   47	57	108	java/lang/Exception
    //   57	67	159	java/lang/Exception
  }
  
  public Filter getFilter()
  {
    if (this.j == null) {
      this.j = new a(this.h);
    }
    return this.j;
  }
  
  public EMConversation getItem(int paramInt)
  {
    if (paramInt < this.h.size()) {
      return (EMConversation)this.h.get(paramInt);
    }
    return null;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    String str1 = null;
    View localView1 = paramView;
    if (paramView == null) {
      localView1 = LayoutInflater.from(getContext()).inflate(2130904914, paramViewGroup, false);
    }
    paramViewGroup = (b)localView1.getTag();
    if (paramViewGroup == null)
    {
      paramViewGroup = new b(null);
      paramViewGroup.a = ((TextView)localView1.findViewById(2131690566));
      paramViewGroup.b = ((TextView)localView1.findViewById(2131696900));
      paramViewGroup.c = ((TextView)localView1.findViewById(2131696901));
      paramViewGroup.d = ((TextView)localView1.findViewById(2131689792));
      paramViewGroup.e = ((SimpleDraweeView)localView1.findViewById(2131696899));
      paramViewGroup.f = ((RelativeLayout)localView1.findViewById(2131696898));
      paramViewGroup.g = ((TextView)localView1.findViewById(2131694558));
      localView1.setTag(paramViewGroup);
    }
    for (;;)
    {
      Object localObject2 = getItem(paramInt);
      paramView = ((EMConversation)localObject2).getType();
      paramViewGroup.e.setTag(2131689528, ((EMConversation)localObject2).conversationId());
      paramViewGroup.a.setTag(2131689528, ((EMConversation)localObject2).conversationId());
      if (paramView == EMConversation.EMConversationType.GroupChat)
      {
        b(paramViewGroup, (EMConversation)localObject2);
        a(paramViewGroup, (EMConversation)localObject2);
        if (((EMConversation)localObject2).getAllMessages().size() == 0) {
          break label872;
        }
        localObject1 = ((EMConversation)localObject2).getLastMessage();
        paramView = (View)localObject1;
        if (EMConversation.EMConversationType.Chat != ((EMConversation)localObject2).getType()) {
          break label968;
        }
        int i1 = ((EMConversation)localObject2).getAllMessages().size();
        paramInt = 1;
        paramView = (View)localObject1;
        label274:
        if (paramInt >= i1) {
          break label968;
        }
        paramView = (EMMessage)((EMConversation)localObject2).getAllMessages().get(((EMConversation)localObject2).getAllMessages().size() - paramInt);
        if ("3".equals(paramView.getStringAttribute("msgType", ""))) {
          break label750;
        }
      }
      label750:
      label872:
      label968:
      View localView2;
      for (Object localObject1 = paramView;; localView2 = paramView)
      {
        if (this.p != null) {
          str1 = this.p.onSetItemSecondaryText((EMMessage)localObject1);
        }
        if (localObject1 != null) {}
        do
        {
          do
          {
            do
            {
              do
              {
                try
                {
                  if (("1".equals(((EMMessage)localObject1).getStringAttribute("msgType", ""))) || ("1".equals(((EMMessage)localObject1).getStringAttribute("houseCard", ""))))
                  {
                    paramView = (EMTextMessageBody)((EMMessage)localObject1).getBody();
                    str2 = ((EMMessage)localObject1).getStringAttribute("startDate", "");
                    str3 = ((EMMessage)localObject1).getStringAttribute("endDate", "");
                    localObject2 = paramView.getMessage();
                    paramView = (View)localObject2;
                    if (j.isImError((String)localObject2)) {
                      paramView = "";
                    }
                    localObject2 = ((EMMessage)localObject1).getStringAttribute("personNum", "");
                    if (!TextUtils.isEmpty(paramView))
                    {
                      paramView = str2 + "至" + str3 + "," + (String)localObject2 + "位房客," + paramView;
                      paramInt = (b.getScreenWidth(this.g) - ab.dp2px(this.g, 126.0F)) * 6 / 10;
                      localObject2 = TextUtils.ellipsize(paramView, paramViewGroup.c.getPaint(), paramInt, TextUtils.TruncateAt.END);
                      localObject2 = SmileUtils.getSmiledText(this.g, (CharSequence)localObject2);
                      paramViewGroup.c.setText((CharSequence)localObject2, TextView.BufferType.SPANNABLE);
                      if (str1 != null)
                      {
                        paramView = TextUtils.ellipsize(paramView, paramViewGroup.c.getPaint(), paramInt, TextUtils.TruncateAt.END);
                        paramView = SmileUtils.getSmiledText(this.g, paramView);
                        paramViewGroup.c.setText(paramView, TextView.BufferType.SPANNABLE);
                      }
                    }
                  }
                }
                catch (Exception paramView)
                {
                  try
                  {
                    for (;;)
                    {
                      String str2;
                      String str3;
                      paramView = ((EMMessage)localObject1).getStringAttribute("houseName", "");
                      if (ae.notNull(paramView)) {
                        paramViewGroup.g.setText(paramView);
                      }
                      paramViewGroup.d.setText(i.getTimestampString(new Date(((EMMessage)localObject1).getMsgTime())));
                      return localView1;
                      localObject1 = ((EMConversation)localObject2).getLastMessage().getUserName();
                      c.setUserInfo(this.g, (String)localObject1, paramViewGroup.e, paramViewGroup.a);
                      paramViewGroup.b.setBackgroundResource(2130839083);
                      if (((EMConversation)localObject2).getUnreadMsgCount() > 0)
                      {
                        paramViewGroup.b.setText(String.valueOf(((EMConversation)localObject2).getUnreadMsgCount()));
                        paramViewGroup.b.setVisibility(0);
                        break;
                      }
                      paramViewGroup.b.setVisibility(4);
                      break;
                      paramInt += 1;
                      break label274;
                      paramView = str2 + "至" + str3 + "," + (String)localObject2 + "位房客";
                      continue;
                      if ((localObject1 != null) && ("2".equals(((EMMessage)localObject1).getStringAttribute("msgType", "")))) {
                        paramView = "房源推荐消息";
                      } else {
                        paramView = j.getMessageDigest((EMMessage)localObject1, ApplicationEx.c);
                      }
                    }
                    paramView = paramView;
                    paramView.printStackTrace();
                    paramView = j.getMessageDigest((EMMessage)localObject1, ApplicationEx.c);
                  }
                  catch (Exception paramView)
                  {
                    for (;;)
                    {
                      paramView.printStackTrace();
                    }
                  }
                }
                paramViewGroup.c.setText("暂无消息");
              } while (paramView != EMConversation.EMConversationType.GroupChat);
              paramView = EMClient.getInstance().groupManager().getGroup(((EMConversation)localObject2).conversationId());
            } while (paramView == null);
            localObject1 = paramView.getDescription();
          } while (TextUtils.isEmpty((CharSequence)localObject1));
          paramView = "";
          try
          {
            localObject1 = a.parseObject((String)localObject1).getString("projectName");
            paramView = (View)localObject1;
          }
          catch (Exception localException)
          {
            for (;;)
            {
              localException.printStackTrace();
            }
          }
        } while (TextUtils.isEmpty(paramView));
        paramViewGroup.g.setText(paramView);
        return localView1;
      }
    }
  }
  
  public void notifyDataSetChanged()
  {
    super.notifyDataSetChanged();
    if (!this.k)
    {
      this.i.clear();
      this.i.addAll(this.h);
      this.k = false;
    }
  }
  
  public void setCvsListHelper(MinsuChatListView.a parama)
  {
    this.p = parama;
  }
  
  public void setPrimaryColor(int paramInt)
  {
    this.a = paramInt;
  }
  
  public void setPrimarySize(int paramInt)
  {
    this.d = paramInt;
  }
  
  public void setSecondaryColor(int paramInt)
  {
    this.b = paramInt;
  }
  
  public void setSecondarySize(int paramInt)
  {
    this.e = paramInt;
  }
  
  public void setTimeColor(int paramInt)
  {
    this.c = paramInt;
  }
  
  public void setTimeSize(float paramFloat)
  {
    this.f = paramFloat;
  }
  
  private class a
    extends Filter
  {
    List<EMConversation> a = null;
    
    public a()
    {
      List localList;
      this.a = localList;
    }
    
    protected Filter.FilterResults performFiltering(CharSequence paramCharSequence)
    {
      Filter.FilterResults localFilterResults = new Filter.FilterResults();
      if (this.a == null) {
        this.a = new ArrayList();
      }
      if ((paramCharSequence == null) || (paramCharSequence.length() == 0))
      {
        localFilterResults.values = e.a(e.this);
        localFilterResults.count = e.a(e.this).size();
        return localFilterResults;
      }
      String str = paramCharSequence.toString();
      int k = this.a.size();
      ArrayList localArrayList = new ArrayList();
      int i = 0;
      if (i < k)
      {
        EMConversation localEMConversation = (EMConversation)this.a.get(i);
        paramCharSequence = localEMConversation.getLastMessage().getUserName();
        EMGroup localEMGroup = EMClient.getInstance().groupManager().getGroup(paramCharSequence);
        if (localEMGroup != null)
        {
          paramCharSequence = localEMGroup.getGroupName();
          label155:
          if (!paramCharSequence.startsWith(str)) {
            break label187;
          }
          localArrayList.add(localEMConversation);
        }
        label187:
        label233:
        for (;;)
        {
          i += 1;
          break;
          paramCharSequence = c.getUserName(paramCharSequence);
          break label155;
          paramCharSequence = paramCharSequence.split(" ");
          int m = paramCharSequence.length;
          int j = 0;
          for (;;)
          {
            if (j >= m) {
              break label233;
            }
            if (paramCharSequence[j].startsWith(str))
            {
              localArrayList.add(localEMConversation);
              break;
            }
            j += 1;
          }
        }
      }
      localFilterResults.values = localArrayList;
      localFilterResults.count = localArrayList.size();
      return localFilterResults;
    }
    
    protected void publishResults(CharSequence paramCharSequence, Filter.FilterResults paramFilterResults)
    {
      e.b(e.this).clear();
      e.b(e.this).addAll((List)paramFilterResults.values);
      if (paramFilterResults.count > 0)
      {
        e.a(e.this, true);
        e.this.notifyDataSetChanged();
        return;
      }
      e.this.notifyDataSetInvalidated();
    }
  }
  
  private static class b
  {
    TextView a;
    TextView b;
    TextView c;
    TextView d;
    SimpleDraweeView e;
    RelativeLayout f;
    TextView g;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/chat/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */