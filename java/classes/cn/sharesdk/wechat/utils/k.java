package cn.sharesdk.wechat.utils;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.os.Bundle;
import android.text.TextUtils;
import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.Platform.ShareParams;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.utils.e;
import cn.sharesdk.framework.utils.f;
import cn.sharesdk.wechat.friends.Wechat;
import com.mob.MobSDK;
import com.mob.tools.log.NLog;
import com.mob.tools.network.NetworkHelper;
import com.mob.tools.utils.BitmapHelper;
import com.mob.tools.utils.DeviceHelper;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.OutputStream;
import java.util.HashMap;

public class k
{
  private static k a;
  private i b = new i();
  private j c;
  private String d;
  private String e;
  private boolean f;
  private int g;
  
  private Bitmap a(Bitmap paramBitmap, double paramDouble)
  {
    int i = paramBitmap.getWidth();
    int j = paramBitmap.getHeight();
    paramDouble = Math.sqrt(paramDouble);
    return Bitmap.createScaledBitmap(paramBitmap, (int)(i / paramDouble), (int)(j / paramDouble), true);
  }
  
  public static k a()
  {
    if (a == null) {
      a = new k();
    }
    return a;
  }
  
  private void a(Context paramContext, String paramString1, String paramString2, Bitmap paramBitmap, int paramInt, j paramj)
    throws Throwable
  {
    WXImageObject localWXImageObject = new WXImageObject();
    Object localObject = new ByteArrayOutputStream();
    paramBitmap.compress(Bitmap.CompressFormat.JPEG, 85, (OutputStream)localObject);
    ((ByteArrayOutputStream)localObject).flush();
    ((ByteArrayOutputStream)localObject).close();
    localWXImageObject.imageData = ((ByteArrayOutputStream)localObject).toByteArray();
    localObject = new WXMediaMessage();
    ((WXMediaMessage)localObject).mediaObject = localWXImageObject;
    if (paramInt != 0)
    {
      ((WXMediaMessage)localObject).title = paramString1;
      ((WXMediaMessage)localObject).description = paramString2;
    }
    ((WXMediaMessage)localObject).thumbData = a(paramContext, paramBitmap);
    a((WXMediaMessage)localObject, "img", paramInt, paramj);
  }
  
  private void a(Context paramContext, String paramString1, String paramString2, String paramString3, int paramInt, j paramj)
    throws Throwable
  {
    WXImageObject localWXImageObject = new WXImageObject();
    if (paramString3.startsWith("/data/")) {
      localWXImageObject.imageData = d(paramString3);
    }
    for (;;)
    {
      WXMediaMessage localWXMediaMessage = new WXMediaMessage();
      localWXMediaMessage.mediaObject = localWXImageObject;
      if (paramInt != 0)
      {
        localWXMediaMessage.title = paramString1;
        localWXMediaMessage.description = paramString2;
      }
      localWXMediaMessage.thumbData = a(paramContext, paramString3);
      a(localWXMediaMessage, "img", paramInt, paramj);
      return;
      localWXImageObject.imagePath = paramString3;
    }
  }
  
  private void a(Context paramContext, String paramString1, String paramString2, String paramString3, Bitmap paramBitmap, int paramInt, j paramj)
    throws Throwable
  {
    WXVideoObject localWXVideoObject = new WXVideoObject();
    localWXVideoObject.videoUrl = paramString3;
    paramString3 = new WXMediaMessage();
    paramString3.title = paramString1;
    paramString3.description = paramString2;
    paramString3.mediaObject = localWXVideoObject;
    paramString3.thumbData = a(paramContext, paramBitmap);
    a(paramString3, "video", paramInt, paramj);
  }
  
  private void a(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt, j paramj)
    throws Throwable
  {
    WXVideoObject localWXVideoObject = new WXVideoObject();
    localWXVideoObject.videoUrl = paramString3;
    paramString3 = new WXMediaMessage();
    paramString3.title = paramString1;
    paramString3.description = paramString2;
    paramString3.mediaObject = localWXVideoObject;
    paramString3.thumbData = a(paramContext, paramString4);
    a(paramString3, "video", paramInt, paramj);
  }
  
  private void a(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, Bitmap paramBitmap, int paramInt, j paramj)
    throws Throwable
  {
    WXMusicObject localWXMusicObject = new WXMusicObject();
    localWXMusicObject.musicUrl = paramString4;
    localWXMusicObject.musicDataUrl = paramString3;
    paramString3 = new WXMediaMessage();
    paramString3.title = paramString1;
    paramString3.description = paramString2;
    paramString3.mediaObject = localWXMusicObject;
    paramString3.thumbData = a(paramContext, paramBitmap);
    a(paramString3, "music", paramInt, paramj);
  }
  
  private void a(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt, j paramj)
    throws Throwable
  {
    WXMusicObject localWXMusicObject = new WXMusicObject();
    localWXMusicObject.musicUrl = paramString4;
    localWXMusicObject.musicDataUrl = paramString3;
    paramString3 = new WXMediaMessage();
    paramString3.title = paramString1;
    paramString3.description = paramString2;
    paramString3.mediaObject = localWXMusicObject;
    paramString3.thumbData = a(paramContext, paramString5);
    a(paramString3, "music", paramInt, paramj);
  }
  
  private void a(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, Bitmap paramBitmap, int paramInt, j paramj)
    throws Throwable
  {
    WXMiniProgramObject localWXMiniProgramObject = new WXMiniProgramObject();
    localWXMiniProgramObject.webpageUrl = paramString1;
    if ((!TextUtils.isEmpty(paramString2)) && (paramString2.endsWith("@app")))
    {
      localWXMiniProgramObject.userName = paramString2;
      if (!TextUtils.isEmpty(paramString3))
      {
        paramString1 = paramString3.split("\\?");
        if (paramString1.length <= 1) {
          break label205;
        }
      }
    }
    label205:
    for (paramString1 = paramString1[0] + ".html?" + paramString1[1];; paramString1 = paramString1[0] + ".html")
    {
      localWXMiniProgramObject.path = paramString1;
      localWXMiniProgramObject.withShareTicket = this.f;
      localWXMiniProgramObject.miniprogramType = this.g;
      paramString1 = new WXMediaMessage();
      paramString1.title = paramString4;
      paramString1.mediaObject = localWXMiniProgramObject;
      paramString1.description = paramString5;
      if ((paramBitmap == null) || (paramBitmap.isRecycled())) {
        break label281;
      }
      paramString1.thumbData = a(paramContext, paramBitmap);
      if (paramString1.thumbData != null) {
        break label230;
      }
      throw new RuntimeException("checkArgs fail, thumbData is null");
      localWXMiniProgramObject.userName = (paramString2 + "@app");
      break;
    }
    label230:
    if (paramString1.thumbData.length > 32768) {
      throw new RuntimeException("checkArgs fail, thumbData is too large: " + paramString1.thumbData.length + " > " + 32768);
    }
    label281:
    a(paramString1, "webpage", paramInt, paramj);
  }
  
  private void a(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, int paramInt, j paramj)
    throws Throwable
  {
    WXMiniProgramObject localWXMiniProgramObject = new WXMiniProgramObject();
    localWXMiniProgramObject.miniprogramType = this.g;
    localWXMiniProgramObject.webpageUrl = paramString1;
    if ((!TextUtils.isEmpty(paramString2)) && (paramString2.endsWith("@app")))
    {
      localWXMiniProgramObject.userName = paramString2;
      if (!TextUtils.isEmpty(paramString3))
      {
        paramString1 = paramString3.split("\\?");
        if (paramString1.length <= 1) {
          break label196;
        }
      }
    }
    label196:
    for (paramString1 = paramString1[0] + ".html?" + paramString1[1];; paramString1 = paramString1[0] + ".html")
    {
      localWXMiniProgramObject.path = paramString1;
      localWXMiniProgramObject.withShareTicket = this.f;
      localWXMiniProgramObject.miniprogramType = this.g;
      paramString1 = new WXMediaMessage();
      paramString1.title = paramString4;
      paramString1.mediaObject = localWXMiniProgramObject;
      paramString1.description = paramString5;
      paramString1.thumbData = a(paramContext, paramString6);
      a(paramString1, "webpage", paramInt, paramj);
      return;
      localWXMiniProgramObject.userName = (paramString2 + "@app");
      break;
    }
  }
  
  private void a(WXMediaMessage paramWXMediaMessage, String paramString, int paramInt, j paramj)
    throws Throwable
  {
    Object localObject1 = DeviceHelper.getInstance(MobSDK.getContext());
    String str = ((DeviceHelper)localObject1).getPackageName() + ".wxapi.WXEntryActivity";
    try
    {
      localObject1 = Class.forName(str);
      if ((localObject1 != null) && (!WechatHandlerActivity.class.isAssignableFrom((Class)localObject1))) {
        new Throwable(str + " does not extend from " + WechatHandlerActivity.class.getName()).printStackTrace();
      }
      localObject1 = new d();
      ((d)localObject1).d = (paramString + System.currentTimeMillis());
      ((d)localObject1).a = paramWXMediaMessage;
      ((d)localObject1).b = paramInt;
      this.c = paramj;
      this.b.a((l)localObject1);
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        e.b().d(localThrowable);
        Object localObject2 = null;
      }
    }
  }
  
  private void a(String paramString1, String paramString2)
    throws Throwable
  {
    h.a locala = new h.a();
    locala.a = paramString1;
    locala.b = paramString2;
    locala.c = this.g;
    this.b.b(locala);
  }
  
  private void a(String paramString1, String paramString2, int paramInt, j paramj)
    throws Throwable
  {
    WXTextObject localWXTextObject = new WXTextObject();
    localWXTextObject.text = paramString2;
    WXMediaMessage localWXMediaMessage = new WXMediaMessage();
    localWXMediaMessage.title = paramString1;
    localWXMediaMessage.mediaObject = localWXTextObject;
    localWXMediaMessage.description = paramString2;
    a(localWXMediaMessage, "text", paramInt, paramj);
  }
  
  private byte[] a(Context paramContext, Bitmap paramBitmap)
    throws Throwable
  {
    if (paramBitmap == null) {
      throw new RuntimeException("checkArgs fail, thumbData is null");
    }
    if (paramBitmap.isRecycled()) {
      throw new RuntimeException("checkArgs fail, thumbData is recycled");
    }
    return a(paramContext, paramBitmap, Bitmap.CompressFormat.PNG);
  }
  
  private byte[] a(Context paramContext, Bitmap paramBitmap, Bitmap.CompressFormat paramCompressFormat)
    throws Throwable
  {
    if (paramBitmap == null) {
      throw new RuntimeException("checkArgs fail, thumbData is null");
    }
    if (paramBitmap.isRecycled()) {
      throw new RuntimeException("checkArgs fail, thumbData is recycled");
    }
    paramContext = new ByteArrayOutputStream();
    paramBitmap.compress(paramCompressFormat, 100, paramContext);
    paramContext.flush();
    paramContext.close();
    paramContext = paramContext.toByteArray();
    for (int i = paramContext.length; i > 32768; i = paramContext.length)
    {
      paramBitmap = a(paramBitmap, i / 32768.0D);
      paramContext = new ByteArrayOutputStream();
      paramBitmap.compress(paramCompressFormat, 100, paramContext);
      paramContext.flush();
      paramContext.close();
      paramContext = paramContext.toByteArray();
    }
    return paramContext;
  }
  
  private byte[] a(Context paramContext, String paramString)
    throws Throwable
  {
    if (!new File(paramString).exists()) {
      throw new FileNotFoundException();
    }
    Bitmap.CompressFormat localCompressFormat = BitmapHelper.getBmpFormat(paramString);
    return a(paramContext, BitmapHelper.getBitmap(paramString), localCompressFormat);
  }
  
  private void b(Context paramContext, String paramString1, String paramString2, Bitmap paramBitmap, int paramInt, j paramj)
    throws Throwable
  {
    WXEmojiObject localWXEmojiObject = new WXEmojiObject();
    paramContext = a(paramContext, paramBitmap);
    localWXEmojiObject.emojiData = paramContext;
    paramBitmap = new WXMediaMessage();
    paramBitmap.title = paramString1;
    paramBitmap.mediaObject = localWXEmojiObject;
    paramBitmap.description = paramString2;
    paramBitmap.thumbData = paramContext;
    a(paramBitmap, "emoji", paramInt, paramj);
  }
  
  private void b(Context paramContext, String paramString1, String paramString2, String paramString3, int paramInt, j paramj)
    throws Throwable
  {
    WXEmojiObject localWXEmojiObject = new WXEmojiObject();
    localWXEmojiObject.emojiPath = paramString3;
    WXMediaMessage localWXMediaMessage = new WXMediaMessage();
    localWXMediaMessage.title = paramString1;
    localWXMediaMessage.mediaObject = localWXEmojiObject;
    localWXMediaMessage.description = paramString2;
    localWXMediaMessage.thumbData = a(paramContext, paramString3);
    a(localWXMediaMessage, "emoji", paramInt, paramj);
  }
  
  private void b(Context paramContext, String paramString1, String paramString2, String paramString3, Bitmap paramBitmap, int paramInt, j paramj)
    throws Throwable
  {
    WXWebpageObject localWXWebpageObject = new WXWebpageObject();
    localWXWebpageObject.webpageUrl = paramString3;
    paramString3 = new WXMediaMessage();
    paramString3.title = paramString1;
    paramString3.description = paramString2;
    paramString3.mediaObject = localWXWebpageObject;
    if ((paramBitmap != null) && (!paramBitmap.isRecycled()))
    {
      paramString3.thumbData = a(paramContext, paramBitmap);
      if (paramString3.thumbData == null) {
        throw new RuntimeException("checkArgs fail, thumbData is null");
      }
      if (paramString3.thumbData.length > 32768) {
        throw new RuntimeException("checkArgs fail, thumbData is too large: " + paramString3.thumbData.length + " > " + 32768);
      }
    }
    a(paramString3, "webpage", paramInt, paramj);
  }
  
  private void b(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt, j paramj)
    throws Throwable
  {
    WXWebpageObject localWXWebpageObject = new WXWebpageObject();
    localWXWebpageObject.webpageUrl = paramString3;
    paramString3 = new WXMediaMessage();
    paramString3.title = paramString1;
    paramString3.description = paramString2;
    paramString3.mediaObject = localWXWebpageObject;
    if ((paramString4 != null) && (new File(paramString4).exists()))
    {
      paramString3.thumbData = a(paramContext, paramString4);
      if (paramString3.thumbData == null) {
        throw new RuntimeException("checkArgs fail, thumbData is null");
      }
      if (paramString3.thumbData.length > 32768) {
        throw new RuntimeException("checkArgs fail, thumbData is too large: " + paramString3.thumbData.length + " > " + 32768);
      }
    }
    a(paramString3, "webpage", paramInt, paramj);
  }
  
  private void b(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, Bitmap paramBitmap, int paramInt, j paramj)
    throws Throwable
  {
    WXAppExtendObject localWXAppExtendObject = new WXAppExtendObject();
    localWXAppExtendObject.filePath = paramString3;
    localWXAppExtendObject.extInfo = paramString4;
    paramString3 = new WXMediaMessage();
    paramString3.title = paramString1;
    paramString3.description = paramString2;
    paramString3.mediaObject = localWXAppExtendObject;
    paramString3.thumbData = a(paramContext, paramBitmap);
    a(paramString3, "appdata", paramInt, paramj);
  }
  
  private void b(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt, j paramj)
    throws Throwable
  {
    WXAppExtendObject localWXAppExtendObject = new WXAppExtendObject();
    localWXAppExtendObject.filePath = paramString3;
    localWXAppExtendObject.extInfo = paramString4;
    paramString3 = new WXMediaMessage();
    paramString3.title = paramString1;
    paramString3.description = paramString2;
    paramString3.mediaObject = localWXAppExtendObject;
    paramString3.thumbData = a(paramContext, paramString5);
    a(paramString3, "appdata", paramInt, paramj);
  }
  
  private void c(Context paramContext, String paramString1, String paramString2, String paramString3, Bitmap paramBitmap, int paramInt, j paramj)
    throws Throwable
  {
    WXFileObject localWXFileObject = new WXFileObject();
    localWXFileObject.filePath = paramString3;
    paramString3 = new WXMediaMessage();
    paramString3.title = paramString1;
    paramString3.description = paramString2;
    paramString3.mediaObject = localWXFileObject;
    paramString3.thumbData = a(paramContext, paramBitmap);
    a(paramString3, "filedata", paramInt, paramj);
  }
  
  private void c(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt, j paramj)
    throws Throwable
  {
    WXFileObject localWXFileObject = new WXFileObject();
    localWXFileObject.filePath = paramString3;
    paramString3 = new WXMediaMessage();
    paramString3.title = paramString1;
    paramString3.description = paramString2;
    paramString3.mediaObject = localWXFileObject;
    paramString3.thumbData = a(paramContext, paramString4);
    a(paramString3, "filedata", paramInt, paramj);
  }
  
  private byte[] d(String paramString)
  {
    try
    {
      paramString = new FileInputStream(paramString);
      ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
      byte[] arrayOfByte = new byte['Ѐ'];
      for (int i = paramString.read(arrayOfByte); i > 0; i = paramString.read(arrayOfByte)) {
        localByteArrayOutputStream.write(arrayOfByte, 0, i);
      }
      localByteArrayOutputStream.flush();
      paramString.close();
      localByteArrayOutputStream.close();
      paramString = localByteArrayOutputStream.toByteArray();
      return paramString;
    }
    catch (Throwable paramString)
    {
      e.b().d(paramString);
    }
    return null;
  }
  
  public void a(int paramInt)
  {
    this.g = paramInt;
  }
  
  public void a(j paramj)
    throws Throwable
  {
    this.c = paramj;
    paramj = new a();
    paramj.a = "snsapi_userinfo";
    paramj.b = "sharesdk_wechat_auth";
    this.b.a(paramj);
  }
  
  public void a(j paramj, Platform.ShareParams paramShareParams, PlatformActionListener paramPlatformActionListener)
    throws Throwable
  {
    Platform localPlatform = paramj.b();
    if (((Integer)paramShareParams.get("scene", Integer.class)).intValue() == 1) {}
    for (paramj = "com.tencent.mm.ui.tools.ShareToTimeLineUI";; paramj = "com.tencent.mm.ui.tools.ShareImgUI")
    {
      f localf = new f();
      localf.a("com.tencent.mm", paramj);
      localf.a(paramShareParams, localPlatform);
      paramj = new HashMap();
      paramj.put("ShareParams", paramShareParams);
      paramPlatformActionListener.onComplete(localPlatform, 9, paramj);
      return;
    }
  }
  
  public void a(String paramString)
  {
    this.e = paramString;
  }
  
  public void a(boolean paramBoolean)
  {
    this.f = paramBoolean;
  }
  
  public boolean a(WechatHandlerActivity paramWechatHandlerActivity)
  {
    return this.b.a(paramWechatHandlerActivity, this.c);
  }
  
  public void b(j paramj)
    throws Throwable
  {
    Object localObject1 = paramj.b();
    Object localObject2 = paramj.a();
    PlatformActionListener localPlatformActionListener = paramj.c();
    int j = ((Platform.ShareParams)localObject2).getShareType();
    int i = j;
    if (j == 11)
    {
      i = j;
      if (e() < 620756993) {
        i = 4;
      }
    }
    String str1 = ((Platform.ShareParams)localObject2).getTitle();
    String str2 = ((Platform.ShareParams)localObject2).getText();
    j = ((Platform.ShareParams)localObject2).getScence();
    String str3 = ((Platform.ShareParams)localObject2).getImagePath();
    String str4 = ((Platform.ShareParams)localObject2).getImageUrl();
    Bitmap localBitmap = ((Platform.ShareParams)localObject2).getImageData();
    String str6 = ((Platform.ShareParams)localObject2).getMusicUrl();
    String str7 = ((Platform.ShareParams)localObject2).getUrl();
    String str5 = ((Platform.ShareParams)localObject2).getFilePath();
    localObject2 = ((Platform.ShareParams)localObject2).getExtInfo();
    switch (i)
    {
    case 3: 
    case 10: 
    default: 
      if (localPlatformActionListener != null) {
        localPlatformActionListener.onError((Platform)localObject1, 9, new IllegalArgumentException("shareType = " + i));
      }
      return;
    case 1: 
      a(str1, str2, j, paramj);
      return;
    case 2: 
      if ((str3 != null) && (str3.length() > 0))
      {
        a(MobSDK.getContext(), str1, str2, str3, j, paramj);
        return;
      }
      if ((localBitmap != null) && (!localBitmap.isRecycled()))
      {
        a(MobSDK.getContext(), str1, str2, localBitmap, j, paramj);
        return;
      }
      if ((str4 != null) && (str4.length() > 0))
      {
        str3 = BitmapHelper.downloadBitmap(MobSDK.getContext(), str4);
        a(MobSDK.getContext(), str1, str2, str3, j, paramj);
        return;
      }
      a(MobSDK.getContext(), str1, str2, "", j, paramj);
      return;
    case 5: 
      localObject1 = ((Platform)localObject1).getShortLintk(str6 + " " + str7, false);
      str5 = localObject1.split(" ")[0];
      localObject1 = localObject1.split(" ")[1];
      if ((str3 != null) && (str3.length() > 0))
      {
        a(MobSDK.getContext(), str1, str2, str5, (String)localObject1, str3, j, paramj);
        return;
      }
      if ((localBitmap != null) && (!localBitmap.isRecycled()))
      {
        a(MobSDK.getContext(), str1, str2, str5, (String)localObject1, localBitmap, j, paramj);
        return;
      }
      if ((str4 != null) && (str4.length() > 0))
      {
        str3 = BitmapHelper.downloadBitmap(MobSDK.getContext(), str4);
        a(MobSDK.getContext(), str1, str2, str5, (String)localObject1, str3, j, paramj);
        return;
      }
      a(MobSDK.getContext(), str1, str2, str5, (String)localObject1, "", j, paramj);
      return;
    case 6: 
      str5 = ((Platform)localObject1).getShortLintk(str7, false);
      paramj.a().setUrl(str5);
      if ((str3 != null) && (str3.length() > 0))
      {
        a(MobSDK.getContext(), str1, str2, str5, str3, j, paramj);
        return;
      }
      if ((localBitmap != null) && (!localBitmap.isRecycled()))
      {
        a(MobSDK.getContext(), str1, str2, str5, localBitmap, j, paramj);
        return;
      }
      if ((str4 != null) && (str4.length() > 0))
      {
        str3 = BitmapHelper.downloadBitmap(MobSDK.getContext(), str4);
        a(MobSDK.getContext(), str1, str2, str5, str3, j, paramj);
        return;
      }
      a(MobSDK.getContext(), str1, str2, str5, "", j, paramj);
      return;
    case 4: 
      str5 = ((Platform)localObject1).getShortLintk(str7, false);
      paramj.a().setUrl(str5);
      if ((str3 != null) && (str3.length() > 0))
      {
        b(MobSDK.getContext(), str1, str2, str5, str3, j, paramj);
        return;
      }
      if ((localBitmap != null) && (!localBitmap.isRecycled()))
      {
        b(MobSDK.getContext(), str1, str2, str5, localBitmap, j, paramj);
        return;
      }
      if ((str4 != null) && (str4.length() > 0))
      {
        str3 = BitmapHelper.downloadBitmap(MobSDK.getContext(), str4);
        b(MobSDK.getContext(), str1, str2, str5, str3, j, paramj);
        return;
      }
      b(MobSDK.getContext(), str1, str2, str5, "", j, paramj);
      return;
    case 7: 
      if (j == 1) {
        throw new Throwable("WechatMoments does not support SAHRE_APP");
      }
      if (j == 2) {
        throw new Throwable("WechatFavorite does not support SAHRE_APP");
      }
      if ((str3 != null) && (str3.length() > 0))
      {
        b(MobSDK.getContext(), str1, str2, str5, (String)localObject2, str3, j, paramj);
        return;
      }
      if ((localBitmap != null) && (!localBitmap.isRecycled()))
      {
        b(MobSDK.getContext(), str1, str2, str5, (String)localObject2, localBitmap, j, paramj);
        return;
      }
      if ((str4 != null) && (str4.length() > 0))
      {
        str3 = BitmapHelper.downloadBitmap(MobSDK.getContext(), str4);
        b(MobSDK.getContext(), str1, str2, str5, (String)localObject2, str3, j, paramj);
        return;
      }
      b(MobSDK.getContext(), str1, str2, str5, (String)localObject2, "", j, paramj);
      return;
    case 8: 
      if (j == 1) {
        throw new Throwable("WechatMoments does not support SHARE_FILE");
      }
      if ((str3 != null) && (str3.length() > 0))
      {
        c(MobSDK.getContext(), str1, str2, str5, str3, j, paramj);
        return;
      }
      if ((localBitmap != null) && (!localBitmap.isRecycled()))
      {
        c(MobSDK.getContext(), str1, str2, str5, localBitmap, j, paramj);
        return;
      }
      if ((str4 != null) && (str4.length() > 0))
      {
        str3 = BitmapHelper.downloadBitmap(MobSDK.getContext(), str4);
        c(MobSDK.getContext(), str1, str2, str5, str3, j, paramj);
        return;
      }
      c(MobSDK.getContext(), str1, str2, str5, "", j, paramj);
      return;
    case 9: 
      if (j == 1) {
        throw new Throwable("WechatMoments does not support SHARE_EMOJI");
      }
      if (j == 2) {
        throw new Throwable("WechatFavorite does not support SHARE_EMOJI");
      }
      if ((str3 != null) && (str3.length() > 0))
      {
        b(MobSDK.getContext(), str1, str2, str3, j, paramj);
        return;
      }
      if ((str4 != null) && (str4.length() > 0))
      {
        str3 = new NetworkHelper().downloadCache(MobSDK.getContext(), str4, "images", true, null);
        b(MobSDK.getContext(), str1, str2, str3, j, paramj);
        return;
      }
      if ((localBitmap != null) && (!localBitmap.isRecycled()))
      {
        b(MobSDK.getContext(), str1, str2, localBitmap, j, paramj);
        return;
      }
      b(MobSDK.getContext(), str1, str2, "", j, paramj);
      return;
    case 11: 
      if (j == 1) {
        throw new Throwable("WechatMoments does not support SAHRE_WXMINIPROGRAM");
      }
      if (j == 2) {
        throw new Throwable("WechatFavorite does not support SAHRE_WXMINIPROGRAM");
      }
      if ((TextUtils.isEmpty(this.d)) || (TextUtils.isEmpty(this.e)))
      {
        localPlatformActionListener.onError((Platform)localObject1, 9, new Throwable("checkArgs fail, UserName or Path is invalid"));
        return;
      }
      str5 = ((Platform)localObject1).getShortLintk(str7, false);
      paramj.a().setUrl(str5);
      if ((str3 != null) && (str3.length() > 0))
      {
        a(MobSDK.getContext(), str5, this.d, this.e, str1, str2, str3, j, paramj);
        return;
      }
      if ((localBitmap != null) && (!localBitmap.isRecycled()))
      {
        a(MobSDK.getContext(), str5, this.d, this.e, str1, str2, localBitmap, j, paramj);
        return;
      }
      if ((str4 != null) && (str4.length() > 0))
      {
        str3 = BitmapHelper.downloadBitmap(MobSDK.getContext(), str4);
        a(MobSDK.getContext(), str5, this.d, this.e, str1, str2, str3, j, paramj);
        return;
      }
      a(MobSDK.getContext(), str5, this.d, this.e, str1, str2, "", j, paramj);
      return;
    }
    if ((TextUtils.isEmpty(this.d)) || (TextUtils.isEmpty(this.e)))
    {
      localPlatformActionListener.onError((Platform)localObject1, 9, new Throwable("checkArgs fail, UserName or Path is invalid"));
      return;
    }
    a(this.d, this.e);
  }
  
  public void b(String paramString)
  {
    this.d = paramString;
  }
  
  public boolean b()
  {
    return this.b.a();
  }
  
  public boolean c()
  {
    return this.b.b();
  }
  
  public boolean c(String paramString)
  {
    return this.b.a(paramString);
  }
  
  public boolean d()
  {
    return this.b.c();
  }
  
  public final int e()
  {
    if (!new Wechat().isClientValid()) {
      return 0;
    }
    try
    {
      int i = MobSDK.getContext().getPackageManager().getApplicationInfo("com.tencent.mm", 128).metaData.getInt("com.tencent.mm.BuildInfo.OPEN_SDK_VERSION", 0);
      return i;
    }
    catch (Exception localException) {}
    return 0;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/cn/sharesdk/wechat/utils/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */