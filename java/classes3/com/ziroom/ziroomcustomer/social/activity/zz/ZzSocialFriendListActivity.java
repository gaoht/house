package com.ziroom.ziroomcustomer.social.activity.zz;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.os.Bundle;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.freelxl.baselibrary.f.g;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.hyphenate.EMCallBack;
import com.hyphenate.EMConnectionListener;
import com.hyphenate.EMMessageListener;
import com.hyphenate.chat.EMChatManager;
import com.hyphenate.chat.EMClient;
import com.hyphenate.chat.EMCmdMessageBody;
import com.hyphenate.chat.EMConversation;
import com.hyphenate.chat.EMMessage;
import com.hyphenate.chat.EMMessage.ChatType;
import com.hyphenate.chat.EMMessage.Direct;
import com.hyphenate.chat.EMMessage.Type;
import com.hyphenate.chat.EMTextMessageBody;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.base.BaseActivity;
import com.ziroom.ziroomcustomer.dialog.c;
import com.ziroom.ziroomcustomer.dialog.c.a;
import com.ziroom.ziroomcustomer.e.c.f;
import com.ziroom.ziroomcustomer.e.n;
import com.ziroom.ziroomcustomer.model.UserInfo;
import com.ziroom.ziroomcustomer.newServiceList.utils.i;
import com.ziroom.ziroomcustomer.newchat.SmileUtils;
import com.ziroom.ziroomcustomer.social.a.e.b;
import com.ziroom.ziroomcustomer.social.model.x;
import com.ziroom.ziroomcustomer.social.model.z;
import com.ziroom.ziroomcustomer.social.model.z.a;
import com.ziroom.ziroomcustomer.social.model.z.a.a;
import com.ziroom.ziroomcustomer.util.u;
import com.ziroom.ziroomcustomer.widget.XListView;
import com.ziroom.ziroomcustomer.widget.XListView.a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class ZzSocialFriendListActivity
  extends BaseActivity
  implements XListView.a
{
  private static com.ziroom.ziroomcustomer.social.view.e v;
  private ZzSocialFriendListActivity a;
  private XListView b;
  private ImageView c;
  private List<String> d = new ArrayList();
  private List<com.ziroom.ziroomcustomer.social.model.j> e = new ArrayList();
  private com.ziroom.ziroomcustomer.social.a.e f;
  private EMMessageListener g;
  private boolean r = false;
  private LinearLayout s;
  private TextView t;
  private a u = null;
  private String w;
  private Map<String, EMConversation> x;
  
  private void b()
  {
    this.b = ((XListView)findViewById(2131693096));
    this.c = ((ImageView)findViewById(2131689492));
    this.s = ((LinearLayout)findViewById(2131693097));
    this.t = ((TextView)findViewById(2131693098));
  }
  
  private void b(final int paramInt)
  {
    EMMessage localEMMessage = EMMessage.createSendMessage(EMMessage.Type.CMD);
    localEMMessage.setChatType(EMMessage.ChatType.Chat);
    localEMMessage.setAttribute("domainFlag", com.ziroom.ziroomcustomer.minsu.chat.j.getDomainFlag());
    localEMMessage.setAttribute("ziroomType", 203);
    localEMMessage.setAttribute("ziroomFlag", "ZIROOM_CHANGZU_IM");
    EMCmdMessageBody localEMCmdMessageBody = new EMCmdMessageBody("shieldFriend");
    localEMMessage.setTo(((com.ziroom.ziroomcustomer.social.model.j)this.e.get(paramInt)).getToChatName());
    localEMMessage.addBody(localEMCmdMessageBody);
    EMClient.getInstance().chatManager().sendMessage(localEMMessage);
    localEMMessage.setMessageStatusCallback(new EMCallBack()
    {
      public void onError(int paramAnonymousInt, String paramAnonymousString)
      {
        ZzSocialFriendListActivity.this.runOnUiThread(new Runnable()
        {
          public void run() {}
        });
      }
      
      public void onProgress(int paramAnonymousInt, String paramAnonymousString) {}
      
      public void onSuccess()
      {
        ZzSocialFriendListActivity.this.runOnUiThread(new Runnable()
        {
          public void run()
          {
            if ((ZzSocialFriendListActivity.a(ZzSocialFriendListActivity.this) != null) && (ZzSocialFriendListActivity.a(ZzSocialFriendListActivity.this).size() > 0))
            {
              Iterator localIterator = ZzSocialFriendListActivity.a(ZzSocialFriendListActivity.this).entrySet().iterator();
              while (localIterator.hasNext())
              {
                Object localObject = (Map.Entry)localIterator.next();
                String str = (String)((Map.Entry)localObject).getKey();
                localObject = (EMConversation)((Map.Entry)localObject).getValue();
                if (((com.ziroom.ziroomcustomer.social.model.j)ZzSocialFriendListActivity.b(ZzSocialFriendListActivity.this).get(ZzSocialFriendListActivity.2.this.a)).getToChatUid().equals(str.substring(4, str.length())))
                {
                  ((EMConversation)localObject).clearAllMessages();
                  EMClient.getInstance().chatManager().deleteConversation(((com.ziroom.ziroomcustomer.social.model.j)ZzSocialFriendListActivity.b(ZzSocialFriendListActivity.this).get(ZzSocialFriendListActivity.2.this.a)).getToChatName(), true);
                }
              }
            }
            g.textToast(ZzSocialFriendListActivity.c(ZzSocialFriendListActivity.this), "好友已删除");
            ZzSocialFriendListActivity.b(ZzSocialFriendListActivity.this).remove(ZzSocialFriendListActivity.2.this.a);
            ZzSocialFriendListActivity.d(ZzSocialFriendListActivity.this).notifyDataSetChanged();
          }
        });
      }
    });
  }
  
  private void e()
  {
    this.u = new a(null);
    EMClient.getInstance().addConnectionListener(this.u);
    this.c.setOnClickListener(new View.OnClickListener()
    {
      @Instrumented
      public void onClick(View paramAnonymousView)
      {
        VdsAgent.onClick(this, paramAnonymousView);
        ZzSocialFriendListActivity.this.finish();
      }
    });
    this.b.setXListViewListener(this);
    this.b.setPullRefreshEnable(true);
    this.b.setPullLoadEnable(false);
    this.f = new com.ziroom.ziroomcustomer.social.a.e(this.a, this.e);
    this.b.setAdapter(this.f);
    setFreezeDialog();
    com.ziroom.ziroomcustomer.social.b.d.refreshZzLive(this.a);
    f();
  }
  
  private void f()
  {
    this.e.clear();
    this.d.clear();
    if (EMClient.getInstance().isLoggedInBefore() == true)
    {
      this.x = EMClient.getInstance().chatManager().getAllConversations();
      u.d("sdjfkldsj", "========= conversations  " + com.alibaba.fastjson.a.toJSONString(this.x));
      if ((this.x != null) && (this.x.size() > 0))
      {
        localIterator = this.x.entrySet().iterator();
        if (localIterator.hasNext())
        {
          Object localObject1 = (Map.Entry)localIterator.next();
          String str = (String)((Map.Entry)localObject1).getKey();
          Object localObject3 = (EMConversation)((Map.Entry)localObject1).getValue();
          for (;;)
          {
            Object localObject2;
            try
            {
              localObject1 = ((EMConversation)localObject3).getLastMessage();
              localObject2 = ((EMMessage)localObject1).getStringAttribute("ziroomFlag");
              u.d("sdjfkldsj", "=========  workInfo " + (String)localObject2);
              if (!"ZIROOM_CHANGZU_IM".equals(localObject2)) {
                break;
              }
              localObject2 = new com.ziroom.ziroomcustomer.social.model.j();
              if (!TextUtils.isEmpty(str)) {
                ((com.ziroom.ziroomcustomer.social.model.j)localObject2).setUid(str.substring(4, str.length()));
              }
              ((com.ziroom.ziroomcustomer.social.model.j)localObject2).setLastMsgTime(((EMMessage)localObject1).getMsgTime());
              ((com.ziroom.ziroomcustomer.social.model.j)localObject2).setLastTime(i.getTimestampString(new Date(((EMMessage)localObject1).getMsgTime())));
              ((com.ziroom.ziroomcustomer.social.model.j)localObject2).setToChatName(str);
              ((com.ziroom.ziroomcustomer.social.model.j)localObject2).setToChatUid(str.substring(4, str.length()));
              ((com.ziroom.ziroomcustomer.social.model.j)localObject2).setUnReadSize(((EMConversation)localObject3).getUnreadMsgCount());
              str = ((EMMessage)localObject1).getStringAttribute("toHeadUrl", "");
              ((com.ziroom.ziroomcustomer.social.model.j)localObject2).setHeadPic(str);
              localObject3 = ((EMMessage)localObject1).getStringAttribute("toNicName", "");
              ((com.ziroom.ziroomcustomer.social.model.j)localObject2).setNickName((String)localObject3);
              u.d("sdjgkl", "=====  friendBean toChatPic = " + str + "     toChatName=" + (String)localObject3);
              str = ((EMMessage)localObject1).getStringAttribute("showMsgTxt", "");
              if (((EMMessage)localObject1).getType() != EMMessage.Type.TXT) {
                break label526;
              }
              localObject3 = Integer.valueOf(((EMMessage)localObject1).getIntAttribute("ziroomType", 100));
              if (localObject3 == null) {
                break label509;
              }
              if (((Integer)localObject3).intValue() != 100) {
                break label460;
              }
              localObject1 = (EMTextMessageBody)((EMMessage)localObject1).getBody();
              ((com.ziroom.ziroomcustomer.social.model.j)localObject2).setLastSpan(SmileUtils.getSmiledText(this.a, ((EMTextMessageBody)localObject1).getMessage()));
              ((com.ziroom.ziroomcustomer.social.model.j)localObject2).setLastMessage(((EMTextMessageBody)localObject1).getMessage());
              this.e.add(localObject2);
            }
            catch (Exception localException)
            {
              localException.printStackTrace();
            }
            break;
            label460:
            if (((Integer)localObject3).intValue() == 101)
            {
              if (localException.direct() == EMMessage.Direct.SEND) {
                ((com.ziroom.ziroomcustomer.social.model.j)localObject2).setLastMessage("你们可以开始聊天了，打个招呼吧");
              } else {
                ((com.ziroom.ziroomcustomer.social.model.j)localObject2).setLastMessage("ta想认识你，打个招呼吧");
              }
            }
            else
            {
              ((com.ziroom.ziroomcustomer.social.model.j)localObject2).setLastMessage(str);
              continue;
              label509:
              ((com.ziroom.ziroomcustomer.social.model.j)localObject2).setLastMessage(((EMTextMessageBody)localException.getBody()).getMessage());
              continue;
              label526:
              if (localException.getType() == EMMessage.Type.IMAGE) {
                ((com.ziroom.ziroomcustomer.social.model.j)localObject2).setLastMessage(str);
              }
            }
          }
        }
      }
    }
    if (this.r)
    {
      this.r = false;
      this.b.stopRefresh();
      this.b.stopLoadMore();
      this.b.setRefreshTime("刚刚");
    }
    Collections.sort(this.e, new Comparator()
    {
      public int compare(com.ziroom.ziroomcustomer.social.model.j paramAnonymousj1, com.ziroom.ziroomcustomer.social.model.j paramAnonymousj2)
      {
        return new Long(paramAnonymousj2.getLastMsgTime()).compareTo(new Long(paramAnonymousj1.getLastMsgTime()));
      }
    });
    Iterator localIterator = this.e.iterator();
    while (localIterator.hasNext())
    {
      com.ziroom.ziroomcustomer.social.model.j localj = (com.ziroom.ziroomcustomer.social.model.j)localIterator.next();
      this.d.add(localj.getUid());
    }
    u.d("uidList", "========  " + com.alibaba.fastjson.a.toJSONString(this.d));
    if ((this.d != null) && (this.d.size() == 0))
    {
      this.s.setVisibility(0);
      this.b.setVisibility(8);
      this.t.getPaint().setFlags(8);
      this.t.getPaint().setAntiAlias(true);
      this.t.setOnClickListener(new View.OnClickListener()
      {
        @Instrumented
        public void onClick(View paramAnonymousView)
        {
          VdsAgent.onClick(this, paramAnonymousView);
          ZzSocialFriendListActivity.this.finish();
        }
      });
    }
    for (;;)
    {
      g();
      return;
      this.b.setVisibility(0);
      this.s.setVisibility(8);
    }
  }
  
  private void g()
  {
    com.ziroom.ziroomcustomer.minsu.e.a.requestImUserInfo(this.a, this.d, new com.freelxl.baselibrary.d.c.a(new com.freelxl.baselibrary.d.f.d(z.class))
    {
      public void onFailure(Throwable paramAnonymousThrowable) {}
      
      public void onSuccess(int paramAnonymousInt, z paramAnonymousz)
      {
        if ((paramAnonymousz != null) && ("0".equals(paramAnonymousz.getStatus())) && (paramAnonymousz.getData() != null))
        {
          if ((paramAnonymousz.getData().getUserInfoList() != null) && (paramAnonymousz.getData().getUserInfoList().size() > 0) && (ZzSocialFriendListActivity.b(ZzSocialFriendListActivity.this) != null) && (ZzSocialFriendListActivity.b(ZzSocialFriendListActivity.this).size() > 0))
          {
            int j = paramAnonymousz.getData().getUserInfoList().size();
            paramAnonymousInt = 0;
            while (paramAnonymousInt < j)
            {
              z.a.a locala = (z.a.a)paramAnonymousz.getData().getUserInfoList().get(paramAnonymousInt);
              int i = 0;
              while (i < ZzSocialFriendListActivity.b(ZzSocialFriendListActivity.this).size())
              {
                if (locala.getUid().equals(((com.ziroom.ziroomcustomer.social.model.j)ZzSocialFriendListActivity.b(ZzSocialFriendListActivity.this).get(i)).getUid()))
                {
                  ((com.ziroom.ziroomcustomer.social.model.j)ZzSocialFriendListActivity.b(ZzSocialFriendListActivity.this).get(i)).setHeadPic(locala.getUserPicUrl());
                  ((com.ziroom.ziroomcustomer.social.model.j)ZzSocialFriendListActivity.b(ZzSocialFriendListActivity.this).get(i)).setLiveNess(locala.getLiveness());
                  ((com.ziroom.ziroomcustomer.social.model.j)ZzSocialFriendListActivity.b(ZzSocialFriendListActivity.this).get(i)).setNickName(locala.getNickName());
                }
                i += 1;
              }
              paramAnonymousInt += 1;
            }
          }
          ZzSocialFriendListActivity.d(ZzSocialFriendListActivity.this).notifyDataSetChanged();
          ZzSocialFriendListActivity.d(ZzSocialFriendListActivity.this).setOnItemLongClickListener(new e.b()
          {
            public void deleteCurrentFriend(final int paramAnonymous2Int)
            {
              c.newBuilder(ZzSocialFriendListActivity.c(ZzSocialFriendListActivity.this)).setContent("你确定删除该好友？").setButtonText("确认").setSecondButtonText("取消").setOnButtonClickListener(new View.OnClickListener()
              {
                @Instrumented
                public void onClick(View paramAnonymous3View)
                {
                  VdsAgent.onClick(this, paramAnonymous3View);
                  paramAnonymous3View = ApplicationEx.c.getUser();
                  if (paramAnonymous3View != null) {
                    ZzSocialFriendListActivity.a(ZzSocialFriendListActivity.this, paramAnonymous3View.getUid());
                  }
                  paramAnonymous3View = ((com.ziroom.ziroomcustomer.social.model.j)ZzSocialFriendListActivity.b(ZzSocialFriendListActivity.this).get(paramAnonymous2Int)).getToChatUid();
                  n.deleteSocialZzFriend(ZzSocialFriendListActivity.c(ZzSocialFriendListActivity.this), ZzSocialFriendListActivity.f(ZzSocialFriendListActivity.this), paramAnonymous3View, new com.ziroom.ziroomcustomer.e.a.d(ZzSocialFriendListActivity.c(ZzSocialFriendListActivity.this), new f(String.class))
                  {
                    public void onFailure(Throwable paramAnonymous4Throwable)
                    {
                      g.textToast(ZzSocialFriendListActivity.c(ZzSocialFriendListActivity.this), paramAnonymous4Throwable.getMessage());
                      dismissProgress();
                    }
                    
                    public void onSuccess(int paramAnonymous4Int, String paramAnonymous4String)
                    {
                      super.onSuccess(paramAnonymous4Int, paramAnonymous4String);
                      dismissProgress();
                      ZzSocialFriendListActivity.a(ZzSocialFriendListActivity.this, ZzSocialFriendListActivity.5.1.1.this.a);
                    }
                  });
                }
              }).build().show();
            }
          });
        }
      }
    });
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903638);
    this.a = this;
    b();
    e();
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    if (this.g != null) {
      EMClient.getInstance().chatManager().removeMessageListener(this.g);
    }
    if (this.u != null) {
      EMClient.getInstance().removeConnectionListener(this.u);
    }
  }
  
  public void onLoadMore() {}
  
  public void onRefresh()
  {
    this.r = true;
    f();
  }
  
  protected void onRestart()
  {
    super.onRestart();
    f();
  }
  
  protected void onResume()
  {
    super.onResume();
    if (EMClient.getInstance().isLoggedInBefore() == true)
    {
      if (this.g == null) {
        this.g = new b();
      }
      EMClient.getInstance().chatManager().addMessageListener(this.g);
      return;
    }
    g.textToast(this.a, "服务器异常，请稍后再试");
  }
  
  protected void onStop()
  {
    super.onStop();
  }
  
  public void setFreezeDialog()
  {
    n.getSocialZzFreezeInfo(this.a, new com.ziroom.ziroomcustomer.e.a.d(this.a, new f(x.class))
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        super.onFailure(paramAnonymousThrowable);
      }
      
      public void onSuccess(int paramAnonymousInt, x paramAnonymousx)
      {
        super.onSuccess(paramAnonymousInt, paramAnonymousx);
        if ((paramAnonymousx != null) && (paramAnonymousx.getFreeze() != null) && (paramAnonymousx.getFreeze().intValue() == 1))
        {
          ZzSocialFriendListActivity.a(new com.ziroom.ziroomcustomer.social.view.e(ZzSocialFriendListActivity.c(ZzSocialFriendListActivity.this), paramAnonymousx));
          ZzSocialFriendListActivity.a().show();
          ZzSocialFriendListActivity.a().setOnDismissListener(new DialogInterface.OnDismissListener()
          {
            public void onDismiss(DialogInterface paramAnonymous2DialogInterface)
            {
              ZzSocialFriendListActivity.this.finish();
            }
          });
        }
      }
    });
  }
  
  private class a
    implements EMConnectionListener
  {
    private a() {}
    
    public void onConnected()
    {
      ZzSocialFriendListActivity.this.runOnUiThread(new Runnable()
      {
        public void run()
        {
          u.e("huanxin", "ChatActivity----MyConnectionListener ----onConnected----- ");
        }
      });
    }
    
    public void onDisconnected(final int paramInt)
    {
      ZzSocialFriendListActivity.this.runOnUiThread(new Runnable()
      {
        public void run()
        {
          if (paramInt == 207)
          {
            u.e("huanxin", "ChatActivity-----MyConnectionListener -------显示帐号已经被移除 ");
            ApplicationEx.c.setImconnect(false);
          }
          do
          {
            do
            {
              return;
            } while (paramInt != 206);
            u.e("huanxin", "ChatActivity----MyConnectionListener -------显示帐号在其他设备登陆dialog ");
            ApplicationEx.c.setImconnect(false);
          } while (EMClient.getInstance().isLoggedInBefore() != true);
          ZzSocialFriendListActivity.this.finish();
        }
      });
    }
  }
  
  class b
    implements EMMessageListener
  {
    b() {}
    
    public void onCmdMessageReceived(List<EMMessage> paramList) {}
    
    public void onMessageChanged(EMMessage paramEMMessage, Object paramObject) {}
    
    public void onMessageDelivered(List<EMMessage> paramList) {}
    
    public void onMessageRead(List<EMMessage> paramList) {}
    
    public void onMessageRecalled(List<EMMessage> paramList) {}
    
    public void onMessageReceived(List<EMMessage> paramList)
    {
      ZzSocialFriendListActivity.this.runOnUiThread(new Runnable()
      {
        public void run()
        {
          ZzSocialFriendListActivity.e(ZzSocialFriendListActivity.this);
        }
      });
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/social/activity/zz/ZzSocialFriendListActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */