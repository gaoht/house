package com.ziroom.ziroomcustomer.util.c;

import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.drawable.BitmapDrawable;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.ImageView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import com.ziroom.ziroomcustomer.e.j;
import com.ziroom.ziroomcustomer.util.ad;
import com.ziroom.ziroomcustomer.util.ae;
import java.io.File;

public class g
{
  public static String a = h.a;
  private static a b;
  
  /* Error */
  private static String a(String paramString)
  {
    // Byte code:
    //   0: new 24	java/io/File
    //   3: dup
    //   4: aload_0
    //   5: invokespecial 27	java/io/File:<init>	(Ljava/lang/String;)V
    //   8: astore_0
    //   9: aload_0
    //   10: invokevirtual 31	java/io/File:exists	()Z
    //   13: ifne +5 -> 18
    //   16: aconst_null
    //   17: areturn
    //   18: new 33	java/lang/StringBuffer
    //   21: dup
    //   22: invokespecial 34	java/lang/StringBuffer:<init>	()V
    //   25: astore_3
    //   26: new 36	java/io/BufferedReader
    //   29: dup
    //   30: new 38	java/io/FileReader
    //   33: dup
    //   34: aload_0
    //   35: invokespecial 41	java/io/FileReader:<init>	(Ljava/io/File;)V
    //   38: invokespecial 44	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   41: astore_1
    //   42: aload_1
    //   43: astore_0
    //   44: aload_1
    //   45: invokevirtual 48	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   48: astore_2
    //   49: aload_2
    //   50: ifnull +34 -> 84
    //   53: aload_1
    //   54: astore_0
    //   55: aload_3
    //   56: aload_2
    //   57: invokevirtual 52	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   60: pop
    //   61: goto -19 -> 42
    //   64: astore_2
    //   65: aload_1
    //   66: astore_0
    //   67: aload_2
    //   68: invokevirtual 55	java/io/IOException:printStackTrace	()V
    //   71: aload_1
    //   72: ifnull +7 -> 79
    //   75: aload_1
    //   76: invokevirtual 58	java/io/BufferedReader:close	()V
    //   79: aload_3
    //   80: invokevirtual 61	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   83: areturn
    //   84: aload_1
    //   85: astore_0
    //   86: aload_1
    //   87: invokevirtual 58	java/io/BufferedReader:close	()V
    //   90: aload_1
    //   91: ifnull -12 -> 79
    //   94: aload_1
    //   95: invokevirtual 58	java/io/BufferedReader:close	()V
    //   98: goto -19 -> 79
    //   101: astore_0
    //   102: goto -23 -> 79
    //   105: astore_1
    //   106: aconst_null
    //   107: astore_0
    //   108: aload_0
    //   109: ifnull +7 -> 116
    //   112: aload_0
    //   113: invokevirtual 58	java/io/BufferedReader:close	()V
    //   116: aload_1
    //   117: athrow
    //   118: astore_0
    //   119: goto -40 -> 79
    //   122: astore_0
    //   123: goto -7 -> 116
    //   126: astore_1
    //   127: goto -19 -> 108
    //   130: astore_2
    //   131: aconst_null
    //   132: astore_1
    //   133: goto -68 -> 65
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	136	0	paramString	String
    //   41	54	1	localBufferedReader	java.io.BufferedReader
    //   105	12	1	localObject1	Object
    //   126	1	1	localObject2	Object
    //   132	1	1	localObject3	Object
    //   48	9	2	str	String
    //   64	4	2	localIOException1	java.io.IOException
    //   130	1	2	localIOException2	java.io.IOException
    //   25	55	3	localStringBuffer	StringBuffer
    // Exception table:
    //   from	to	target	type
    //   44	49	64	java/io/IOException
    //   55	61	64	java/io/IOException
    //   86	90	64	java/io/IOException
    //   94	98	101	java/io/IOException
    //   26	42	105	finally
    //   75	79	118	java/io/IOException
    //   112	116	122	java/io/IOException
    //   44	49	126	finally
    //   55	61	126	finally
    //   67	71	126	finally
    //   86	90	126	finally
    //   26	42	130	java/io/IOException
  }
  
  private static boolean a()
  {
    boolean bool2 = false;
    try
    {
      e locale = getMainTitle();
      boolean bool1 = bool2;
      if (locale != null)
      {
        bool1 = bool2;
        if (locale.getImages() != null) {
          bool1 = a(locale.getImages());
        }
      }
      return bool1;
    }
    catch (Exception localException)
    {
      localException.getLocalizedMessage();
    }
    return false;
  }
  
  private static boolean a(c.a parama)
  {
    return (parama != null) && (c(parama.getResource_refreshJson()));
  }
  
  private static boolean a(d.b paramb)
  {
    if ((paramb == null) || (!b(paramb.getImage_minsu_button_normal()))) {}
    while ((!b(paramb.getImage_minsu_button_selected())) || (!b(paramb.getImage_personalCenter_button_normal())) || (!b(paramb.getImage_personalCenter_button_selected())) || (!b(paramb.getImage_service_button_normal())) || (!b(paramb.getImage_service_button_selected())) || (!b(paramb.getImage_yj_button_normal())) || (!b(paramb.getImage_zryu_button_selected())) || (!b(paramb.getImage_zryu_button_normal())) || (!b(paramb.getImage_yj_button_selected()))) {
      return false;
    }
    return true;
  }
  
  private static boolean a(e.b paramb)
  {
    if ((paramb == null) || (!b(paramb.getImage_logo()))) {}
    while ((!b(paramb.getImage_message())) || (!b(paramb.getImage_selectCity_indicate()))) {
      return false;
    }
    return true;
  }
  
  private static boolean a(f.b paramb)
  {
    if ((paramb == null) || (!b(paramb.getImage_header_background()))) {}
    while ((!b(paramb.getImage_buttons_background())) || (!b(paramb.getImage_navi_switchoverLandlord_normal())) || (!b(paramb.getImage_navi_switchoverLandlord_slide())) || (!b(paramb.getImage_navi_message_normal())) || (!b(paramb.getImage_navi_message_slide())) || (!b(paramb.getImage_myActivities())) || (!b(paramb.getImage_selfCreditIcon())) || (!b(paramb.getImage_selfCreditArrow())) || (!b(paramb.getImage_collection())) || (!b(paramb.getImage_appointment())) || (!b(paramb.getImage_order())) || (!b(paramb.getImage_evaluation())) || (!b(paramb.getImage_balance())) || (!b(paramb.getImage_userPortrait()))) {
      return false;
    }
    return true;
  }
  
  private static boolean b()
  {
    boolean bool2 = false;
    try
    {
      d locald = getMainTab();
      boolean bool1 = bool2;
      if (locald != null)
      {
        bool1 = bool2;
        if (locald.getImages() != null) {
          bool1 = a(locald.getImages());
        }
      }
      return bool1;
    }
    catch (Exception localException)
    {
      localException.getLocalizedMessage();
    }
    return false;
  }
  
  private static boolean b(String paramString)
  {
    if (ae.isNull(paramString)) {
      return false;
    }
    return new File(h.a + ad.getSkinSign(ApplicationEx.c) + "/" + paramString + ".png").exists();
  }
  
  private static boolean c()
  {
    boolean bool2 = false;
    try
    {
      f localf = getMyZiroom();
      boolean bool1 = bool2;
      if (localf != null)
      {
        bool1 = bool2;
        if (localf.getImages() != null) {
          bool1 = a(localf.getImages());
        }
      }
      return bool1;
    }
    catch (Exception localException)
    {
      localException.getLocalizedMessage();
    }
    return false;
  }
  
  private static boolean c(String paramString)
  {
    if (ae.isNull(paramString)) {
      return false;
    }
    return new File(h.a + ad.getSkinSign(ApplicationEx.c) + "/" + paramString).exists();
  }
  
  public static boolean checkSkin()
  {
    if (!a()) {}
    while ((!b()) || (!c()) || (!d())) {
      return false;
    }
    return true;
  }
  
  public static void checkUpdata(String paramString)
  {
    try
    {
      j.checkSkin(ApplicationEx.c, paramString, new g.1(ApplicationEx.c, new com.ziroom.ziroomcustomer.e.c.d()));
      return;
    }
    catch (Exception paramString)
    {
      paramString.getLocalizedMessage();
    }
  }
  
  private static boolean d()
  {
    boolean bool2 = false;
    try
    {
      c localc = getLoadingJson();
      boolean bool1 = bool2;
      if (localc != null)
      {
        bool1 = bool2;
        if (localc.getResources() != null) {
          bool1 = a(localc.getResources());
        }
      }
      return bool1;
    }
    catch (Exception localException)
    {
      localException.getLocalizedMessage();
    }
    return false;
  }
  
  public static a getConfig()
  {
    if (b == null)
    {
      String str = a(h.a + ad.getSkinSign(ApplicationEx.c) + "/config.json");
      if (ae.isNull(str)) {
        return null;
      }
      b = (a)com.alibaba.fastjson.a.parseObject(str, a.class);
    }
    return b;
  }
  
  public static c getLoadingJson()
  {
    a locala = getConfig();
    if (locala != null) {
      return locala.getJson_loading();
    }
    return null;
  }
  
  public static d getMainTab()
  {
    a locala = getConfig();
    if (locala != null) {
      return locala.getHome_tabbar();
    }
    return null;
  }
  
  public static e getMainTitle()
  {
    try
    {
      Object localObject = getConfig();
      if (localObject != null)
      {
        localObject = ((a)localObject).getHome_navi();
        return (e)localObject;
      }
    }
    catch (Exception localException)
    {
      localException.getLocalizedMessage();
    }
    return null;
  }
  
  public static f getMyZiroom()
  {
    a locala = getConfig();
    if (locala != null) {
      return locala.getPersonal_center();
    }
    return null;
  }
  
  public static void setBackground(View paramView, String paramString)
  {
    try
    {
      BitmapFactory.Options localOptions = new BitmapFactory.Options();
      int i = ApplicationEx.c.getResources().getInteger(2131558401);
      localOptions.inTargetDensity = ApplicationEx.c.getResources().getDisplayMetrics().densityDpi;
      localOptions.inDensity = (i * 160);
      paramView.setBackground(new BitmapDrawable(BitmapFactory.decodeFile(h.a + ad.getSkinSign(ApplicationEx.c) + "/" + paramString + ".png", localOptions)));
      return;
    }
    catch (Exception paramView)
    {
      paramView.getLocalizedMessage();
    }
  }
  
  public static void setFresco(SimpleDraweeView paramSimpleDraweeView, String paramString)
  {
    try
    {
      paramSimpleDraweeView.setController(com.freelxl.baselibrary.f.c.frescoFromFileController(new File(h.a + ad.getSkinSign(ApplicationEx.c) + "/" + paramString + ".png")));
      return;
    }
    catch (Exception paramSimpleDraweeView)
    {
      paramSimpleDraweeView.getLocalizedMessage();
    }
  }
  
  public static void setImage(ImageView paramImageView, String paramString)
  {
    try
    {
      BitmapFactory.Options localOptions = new BitmapFactory.Options();
      int i = ApplicationEx.c.getResources().getInteger(2131558401);
      localOptions.inTargetDensity = ApplicationEx.c.getResources().getDisplayMetrics().densityDpi;
      localOptions.inDensity = (i * 160);
      paramImageView.setImageBitmap(BitmapFactory.decodeFile(h.a + ad.getSkinSign(ApplicationEx.c) + "/" + paramString + ".png", localOptions));
      return;
    }
    catch (Exception paramImageView)
    {
      paramImageView.getLocalizedMessage();
    }
  }
  
  public static void test()
  {
    h.downloadPdf("http://test.rengfou.com/skin/and3x_test1.zip", "test", "test", "test.zip");
    ad.saveSkinTag(ApplicationEx.c, "test");
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/ziroom/ziroomcustomer/util/c/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */