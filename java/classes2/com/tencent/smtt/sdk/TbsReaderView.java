package com.tencent.smtt.sdk;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.widget.FrameLayout;
import com.tencent.smtt.sdk.a.d;
import com.tencent.smtt.utils.Apn;

public class TbsReaderView
  extends FrameLayout
{
  public static final String IS_BAR_ANIMATING = "is_bar_animating";
  public static final String IS_BAR_SHOWING = "is_bar_show";
  public static final String IS_INTO_DOWNLOADING = "into_downloading";
  public static final String KEY_FILE_PATH = "filePath";
  public static final String KEY_TEMP_PATH = "tempPath";
  public static final int READER_CHANNEL_DOC_ID = 10965;
  public static final int READER_CHANNEL_PDF_ID = 10834;
  public static final int READER_CHANNEL_PPT_ID = 10833;
  public static final int READER_CHANNEL_TXT_ID = 10835;
  public static final String READER_STATISTICS_COUNT_CANCEL_LOADED_BTN = "AHNG802";
  public static final String READER_STATISTICS_COUNT_CLICK_LOADED_BTN = "AHNG801";
  public static final String READER_STATISTICS_COUNT_DOC_INTO_BROWSER = "AHNG829";
  public static final String READER_STATISTICS_COUNT_DOC_INTO_DIALOG = "AHNG827";
  public static final String READER_STATISTICS_COUNT_DOC_INTO_DOWNLOAD = "AHNG828";
  public static final String READER_STATISTICS_COUNT_DOC_SEARCH_BTN = "AHNG826";
  public static final String READER_STATISTICS_COUNT_PDF_FOLDER_BTN = "AHNG810";
  public static final String READER_STATISTICS_COUNT_PDF_INTO_BROWSER = "AHNG813";
  public static final String READER_STATISTICS_COUNT_PDF_INTO_DIALOG = "AHNG811";
  public static final String READER_STATISTICS_COUNT_PDF_INTO_DOWNLOAD = "AHNG812";
  public static final String READER_STATISTICS_COUNT_PPT_INTO_BROWSER = "AHNG809";
  public static final String READER_STATISTICS_COUNT_PPT_INTO_DIALOG = "AHNG807";
  public static final String READER_STATISTICS_COUNT_PPT_INTO_DOWNLOAD = "AHNG808";
  public static final String READER_STATISTICS_COUNT_PPT_PLAY_BTN = "AHNG806";
  public static final String READER_STATISTICS_COUNT_RETRY_BTN = "AHNG803";
  public static final String READER_STATISTICS_COUNT_TXT_INTO_BROWSER = "AHNG817";
  public static final String READER_STATISTICS_COUNT_TXT_INTO_DIALOG = "AHNG815";
  public static final String READER_STATISTICS_COUNT_TXT_INTO_DOWNLOAD = "AHNG816";
  public static final String READER_STATISTICS_COUNT_TXT_NOVEL_BTN = "AHNG814";
  public static final String TAG = "TbsReaderView";
  static boolean f = false;
  public static String gReaderPackName = "";
  public static String gReaderPackVersion = "";
  Context a = null;
  j b = null;
  Object c = null;
  ReaderCallback d = null;
  ReaderCallback e = null;
  
  public TbsReaderView(Context paramContext, ReaderCallback paramReaderCallback)
  {
    super(paramContext.getApplicationContext());
    if (!(paramContext instanceof Activity)) {
      throw new RuntimeException("error: unexpect context(none Activity)");
    }
    this.d = paramReaderCallback;
    this.a = paramContext;
    this.e = new as(this);
  }
  
  static boolean a(Context paramContext)
  {
    if (!f)
    {
      k.a(true).a(paramContext.getApplicationContext(), true, false, null);
      f = k.a(false).b();
    }
    return f;
  }
  
  public static Drawable getResDrawable(Context paramContext, int paramInt)
  {
    Drawable localDrawable = null;
    if (a(paramContext)) {
      localDrawable = j.a(paramInt);
    }
    return localDrawable;
  }
  
  public static String getResString(Context paramContext, int paramInt)
  {
    String str = "";
    if (a(paramContext)) {
      str = j.b(paramInt);
    }
    return str;
  }
  
  public static boolean isSupportExt(Context paramContext, String paramString)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (a(paramContext))
    {
      bool1 = bool2;
      if (j.a(paramContext))
      {
        bool1 = bool2;
        if (j.a(paramString)) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  boolean a()
  {
    boolean bool = false;
    try
    {
      if (this.b == null) {
        this.b = new j(this.e);
      }
      if (this.c == null) {
        this.c = this.b.a();
      }
      if (this.c != null) {
        bool = this.b.a(this.c, this.a);
      }
      return bool;
    }
    catch (NullPointerException localNullPointerException)
    {
      Log.e("TbsReaderView", "Unexpect null object!");
    }
    return false;
  }
  
  public void doCommand(Integer paramInteger, Object paramObject1, Object paramObject2)
  {
    if ((this.b != null) && (this.c != null)) {
      this.b.a(this.c, paramInteger, paramObject1, paramObject2);
    }
  }
  
  public boolean downloadPlugin(String paramString)
  {
    if (this.c == null)
    {
      Log.e("TbsReaderView", "downloadPlugin failed!");
      return false;
    }
    return this.b.a(this.c, this.a, paramString, true);
  }
  
  public void onSizeChanged(int paramInt1, int paramInt2)
  {
    if ((this.b != null) && (this.c != null)) {
      this.b.a(this.c, paramInt1, paramInt2);
    }
  }
  
  public void onStop()
  {
    if (this.b != null)
    {
      this.b.a(this.c);
      this.c = null;
    }
    this.a = null;
    f = false;
  }
  
  public void openFile(Bundle paramBundle)
  {
    boolean bool2 = true;
    if ((this.c == null) || (paramBundle == null))
    {
      Log.e("TbsReaderView", "init failed!");
      return;
    }
    boolean bool3 = d.c(this.a);
    if (!d.b(this.a))
    {
      bool1 = true;
      label43:
      paramBundle.putBoolean("browser6.0", bool1 | bool3);
      bool3 = d.a(this.a, 6101625L, 610000L);
      if (d.b(this.a)) {
        break label124;
      }
    }
    label124:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      paramBundle.putBoolean("browser6.1", bool3 | bool1);
      if (this.b.a(this.c, this.a, paramBundle, this)) {
        break;
      }
      Log.e("TbsReaderView", "OpenFile failed!");
      return;
      bool1 = false;
      break label43;
    }
  }
  
  public boolean preOpen(String paramString, boolean paramBoolean)
  {
    boolean bool2 = false;
    if (!isSupportExt(this.a, paramString))
    {
      Log.e("TbsReaderView", "not supported by:" + paramString);
      return false;
    }
    boolean bool3 = a(this.a);
    boolean bool1 = bool3;
    if (bool3)
    {
      bool3 = a();
      bool1 = bool3;
      if (paramBoolean)
      {
        bool1 = bool3;
        if (bool3)
        {
          paramBoolean = bool2;
          if (Apn.getApnType(this.a) == 3) {
            paramBoolean = true;
          }
          return this.b.a(this.c, this.a, paramString, paramBoolean);
        }
      }
    }
    return bool1;
  }
  
  public void userStatistics(String paramString)
  {
    if (this.b != null) {
      this.b.a(this.c, paramString);
    }
  }
  
  public static abstract interface ReaderCallback
  {
    public static final int COPY_SELECT_TEXT = 5003;
    public static final int GET_BAR_ANIMATING = 5000;
    public static final int GET_BAR_ISSHOWING = 5024;
    public static final int HIDDEN_BAR = 5001;
    public static final int INSTALL_QB = 5011;
    public static final int NOTIFY_CANDISPLAY = 12;
    public static final int NOTIFY_ERRORCODE = 19;
    public static final int READER_OPEN_QQ_FILE_LIST = 5031;
    public static final int READER_PDF_LIST = 5008;
    public static final int READER_PLUGIN_ACTIVITY_PAUSE = 5032;
    public static final int READER_PLUGIN_CANLOAD = 5013;
    public static final int READER_PLUGIN_COMMAND_FIXSCREEN = 5015;
    public static final int READER_PLUGIN_COMMAND_PDF_LIST = 5036;
    public static final int READER_PLUGIN_COMMAND_PPT_PLAYER = 5035;
    public static final int READER_PLUGIN_COMMAND_ROTATESCREEN = 5018;
    public static final int READER_PLUGIN_COMMAND_TEXT_FIND = 5038;
    public static final int READER_PLUGIN_COMMAND_TEXT_FIND_CLEAR = 5041;
    public static final int READER_PLUGIN_COMMAND_TEXT_FIND_NEXT = 5039;
    public static final int READER_PLUGIN_COMMAND_TEXT_FIND_PREV = 5040;
    public static final int READER_PLUGIN_DOWNLOADING = 5014;
    public static final int READER_PLUGIN_RES_DOC_GUIDE = 5029;
    public static final int READER_PLUGIN_RES_FIXSCREEN_NORMAL = 5016;
    public static final int READER_PLUGIN_RES_FIXSCREEN_PRESS = 5017;
    public static final int READER_PLUGIN_RES_PDF_GUIDE = 5023;
    public static final int READER_PLUGIN_RES_PPT_GUIDE = 5021;
    public static final int READER_PLUGIN_RES_ROTATESCREEN_NORMAL = 5019;
    public static final int READER_PLUGIN_RES_ROTATESCREEN_PRESS = 5020;
    public static final int READER_PLUGIN_RES_TXT_GUIDE = 5022;
    public static final int READER_PLUGIN_SO_ERR = 5025;
    public static final int READER_PLUGIN_SO_INTO_START = 5027;
    public static final int READER_PLUGIN_SO_PROGRESS = 5028;
    public static final int READER_PLUGIN_SO_VERSION = 5030;
    public static final int READER_PLUGIN_STATUS = 5012;
    public static final int READER_PLUGIN_TEXT_FIND_RESULT = 5042;
    public static final int READER_PPT_PLAY_MODEL = 5009;
    public static final int READER_SEARCH_IN_DOCUMENT = 5026;
    public static final int READER_TOAST = 5005;
    public static final int READER_TXT_READING_MODEL = 5010;
    public static final int SEARCH_SELECT_TEXT = 5004;
    public static final int SHOW_BAR = 5002;
    public static final int SHOW_DIALOG = 5006;
    
    public abstract void onCallBackAction(Integer paramInteger, Object paramObject1, Object paramObject2);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/tencent/smtt/sdk/TbsReaderView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */