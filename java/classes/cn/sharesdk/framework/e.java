package cn.sharesdk.framework;

import android.os.Handler;
import cn.sharesdk.framework.b.b.a;
import com.mob.commons.eventrecoder.EventRecorder;
import com.mob.tools.log.NLog;
import com.mob.tools.utils.ReflectHelper;
import com.mob.tools.utils.ResHelper;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;

public class e
{
  public static ArrayList<Platform> a()
  {
    ArrayList localArrayList = b();
    a(localArrayList);
    return localArrayList;
  }
  
  public static HashMap<Integer, HashMap<String, Object>> a(HashMap<String, Object> paramHashMap)
  {
    if ((paramHashMap == null) || (paramHashMap.size() <= 0)) {
      return null;
    }
    Object localObject = (ArrayList)paramHashMap.get("fakelist");
    if (localObject == null) {
      return null;
    }
    paramHashMap = new HashMap();
    EventRecorder.addBegin("ShareSDK", "parseDevInfo");
    localObject = ((ArrayList)localObject).iterator();
    for (;;)
    {
      if (((Iterator)localObject).hasNext())
      {
        HashMap localHashMap = (HashMap)((Iterator)localObject).next();
        if (localHashMap == null) {
          continue;
        }
        String str = String.valueOf(localHashMap.get("snsplat"));
        try
        {
          i = ResHelper.parseInt(str);
          if (i != -1) {
            paramHashMap.put(Integer.valueOf(i), localHashMap);
          }
        }
        catch (Throwable localThrowable)
        {
          for (;;)
          {
            cn.sharesdk.framework.utils.e.b().w(localThrowable);
            int i = -1;
          }
        }
      }
    }
    EventRecorder.addEnd("ShareSDK", "parseDevInfo");
    return paramHashMap;
  }
  
  public static void a(int paramInt, Platform paramPlatform)
  {
    cn.sharesdk.framework.b.b.d locald = new cn.sharesdk.framework.b.b.d();
    switch (paramInt)
    {
    }
    for (;;)
    {
      if (paramPlatform != null) {
        locald.b = paramPlatform.getPlatformId();
      }
      paramPlatform = cn.sharesdk.framework.b.d.b();
      if (paramPlatform != null) {
        paramPlatform.a(locald);
      }
      return;
      locald.a = "SHARESDK_ENTER_SHAREMENU";
      continue;
      locald.a = "SHARESDK_CANCEL_SHAREMENU";
      continue;
      locald.a = "SHARESDK_EDIT_SHARE";
      continue;
      locald.a = "SHARESDK_FAILED_SHARE";
      continue;
      locald.a = "SHARESDK_CANCEL_SHARE";
    }
  }
  
  public static void a(Handler paramHandler)
  {
    cn.sharesdk.framework.b.d locald = cn.sharesdk.framework.b.d.b();
    if (locald != null)
    {
      locald.a(paramHandler);
      locald.a();
    }
  }
  
  public static void a(String paramString, int paramInt)
  {
    cn.sharesdk.framework.b.d locald = cn.sharesdk.framework.b.d.b();
    if (locald == null) {
      return;
    }
    a locala = new a();
    locala.b = paramString;
    locala.a = paramInt;
    locald.a(locala);
  }
  
  public static void a(ArrayList<Platform> paramArrayList)
  {
    if (paramArrayList == null) {
      return;
    }
    Collections.sort(paramArrayList, new Comparator()
    {
      public int a(Platform paramAnonymousPlatform1, Platform paramAnonymousPlatform2)
      {
        if (paramAnonymousPlatform1.getSortId() != paramAnonymousPlatform2.getSortId()) {
          return paramAnonymousPlatform1.getSortId() - paramAnonymousPlatform2.getSortId();
        }
        return paramAnonymousPlatform1.getPlatformId() - paramAnonymousPlatform2.getPlatformId();
      }
    });
  }
  
  private static ArrayList<Platform> b()
  {
    String[] arrayOfString = new String[41];
    arrayOfString[0] = "cn.sharesdk.douban.Douban";
    arrayOfString[1] = "cn.sharesdk.evernote.Evernote";
    arrayOfString[2] = "cn.sharesdk.facebook.Facebook";
    arrayOfString[3] = "cn.sharesdk.renren.Renren";
    arrayOfString[4] = "cn.sharesdk.sina.weibo.SinaWeibo";
    arrayOfString[5] = "cn.sharesdk.kaixin.KaiXin";
    arrayOfString[6] = "cn.sharesdk.linkedin.LinkedIn";
    arrayOfString[7] = "cn.sharesdk.system.email.Email";
    arrayOfString[8] = "cn.sharesdk.system.text.ShortMessage";
    arrayOfString[9] = "cn.sharesdk.tencent.qq.QQ";
    arrayOfString[10] = "cn.sharesdk.tencent.qzone.QZone";
    arrayOfString[11] = "cn.sharesdk.tencent.weibo.TencentWeibo";
    arrayOfString[12] = "cn.sharesdk.twitter.Twitter";
    arrayOfString[13] = "cn.sharesdk.wechat.friends.Wechat";
    arrayOfString[14] = "cn.sharesdk.wechat.moments.WechatMoments";
    arrayOfString[15] = "cn.sharesdk.wechat.favorite.WechatFavorite";
    arrayOfString[16] = "cn.sharesdk.youdao.YouDao";
    arrayOfString[17] = "cn.sharesdk.google.GooglePlus";
    arrayOfString[18] = "cn.sharesdk.foursquare.FourSquare";
    arrayOfString[19] = "cn.sharesdk.pinterest.Pinterest";
    arrayOfString[20] = "cn.sharesdk.flickr.Flickr";
    arrayOfString[21] = "cn.sharesdk.tumblr.Tumblr";
    arrayOfString[22] = "cn.sharesdk.dropbox.Dropbox";
    arrayOfString[23] = "cn.sharesdk.vkontakte.VKontakte";
    arrayOfString[24] = "cn.sharesdk.instagram.Instagram";
    arrayOfString[25] = "cn.sharesdk.yixin.friends.Yixin";
    arrayOfString[26] = "cn.sharesdk.yixin.moments.YixinMoments";
    arrayOfString[27] = "cn.sharesdk.mingdao.Mingdao";
    arrayOfString[28] = "cn.sharesdk.line.Line";
    arrayOfString[29] = "cn.sharesdk.kakao.story.KakaoStory";
    arrayOfString[30] = "cn.sharesdk.kakao.talk.KakaoTalk";
    arrayOfString[31] = "cn.sharesdk.whatsapp.WhatsApp";
    arrayOfString[32] = "cn.sharesdk.pocket.Pocket";
    arrayOfString[33] = "cn.sharesdk.instapaper.Instapaper";
    arrayOfString[34] = "cn.sharesdk.facebookmessenger.FacebookMessenger";
    arrayOfString[35] = "cn.sharesdk.alipay.friends.Alipay";
    arrayOfString[36] = "cn.sharesdk.alipay.moments.AlipayMoments";
    arrayOfString[37] = "cn.sharesdk.dingding.friends.Dingding";
    arrayOfString[38] = "cn.sharesdk.youtube.Youtube";
    arrayOfString[39] = "cn.sharesdk.meipai.Meipai";
    arrayOfString[40] = "cn.sharesdk.telegram.Telegram";
    ArrayList localArrayList = new ArrayList();
    int j = arrayOfString.length;
    int i = 0;
    for (;;)
    {
      String str;
      if (i < j) {
        str = arrayOfString[i];
      }
      try
      {
        localArrayList.add((Platform)ReflectHelper.newInstance(ReflectHelper.importClass(str), new Object[0]));
        i += 1;
        continue;
        return localArrayList;
      }
      catch (Throwable localThrowable)
      {
        for (;;) {}
      }
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/sharesdk/framework/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */