package com.ziroom.ziroomcoloreggs.eggs;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.ziroom.ziroomcoloreggs.R.id;
import com.ziroom.ziroomcoloreggs.R.layout;

public class ErrorLogInfoActivity
  extends Activity
{
  EditText a;
  TextView b;
  ImageView c;
  private String d;
  private String e;
  private int f = 17;
  private Runnable g;
  private Handler h = new Handler()
  {
    public void handleMessage(Message paramAnonymousMessage)
    {
      if ((paramAnonymousMessage == null) && (paramAnonymousMessage.obj == null)) {
        return;
      }
      switch (paramAnonymousMessage.what)
      {
      default: 
        return;
      case 1: 
        ErrorLogInfoActivity.b(ErrorLogInfoActivity.this).removeCallbacks(ErrorLogInfoActivity.c(ErrorLogInfoActivity.this));
        ErrorLogInfoActivity.this.a.setVisibility(0);
        ErrorLogInfoActivity.this.a.setText(paramAnonymousMessage.obj.toString());
        ErrorLogInfoActivity.this.b.setVisibility(8);
        return;
      case 17: 
        ErrorLogInfoActivity.this.b.setText("正在加载日志...");
        return;
      case 18: 
        ErrorLogInfoActivity.this.b.setText("正在加载日志.");
        return;
      }
      ErrorLogInfoActivity.this.b.setText("正在加载日志..");
    }
  };
  
  private void a()
  {
    this.c = ((ImageView)findViewById(R.id.iv_back));
    this.a = ((EditText)findViewById(R.id.error_log_info_ev));
    this.b = ((TextView)findViewById(R.id.error_log_info_tv));
    this.g = new Runnable()
    {
      public void run()
      {
        Message localMessage = new Message();
        localMessage.what = ErrorLogInfoActivity.a(ErrorLogInfoActivity.this);
        ErrorLogInfoActivity.b(ErrorLogInfoActivity.this).sendMessage(localMessage);
        if (ErrorLogInfoActivity.a(ErrorLogInfoActivity.this) == 17) {
          ErrorLogInfoActivity.a(ErrorLogInfoActivity.this, 18);
        }
        for (;;)
        {
          ErrorLogInfoActivity.b(ErrorLogInfoActivity.this).postDelayed(ErrorLogInfoActivity.c(ErrorLogInfoActivity.this), 500L);
          return;
          if (ErrorLogInfoActivity.a(ErrorLogInfoActivity.this) == 18) {
            ErrorLogInfoActivity.a(ErrorLogInfoActivity.this, 19);
          } else if (ErrorLogInfoActivity.a(ErrorLogInfoActivity.this) == 19) {
            ErrorLogInfoActivity.a(ErrorLogInfoActivity.this, 17);
          }
        }
      }
    };
    this.h.postDelayed(this.g, 500L);
  }
  
  private void a(final String paramString)
  {
    new StringBuffer();
    new Thread(new Runnable()
    {
      public void run()
      {
        Message localMessage = new Message();
        localMessage.obj = ErrorLogInfoActivity.a(ErrorLogInfoActivity.this, paramString);
        localMessage.what = 1;
        ErrorLogInfoActivity.b(ErrorLogInfoActivity.this).sendMessage(localMessage);
      }
    }).start();
  }
  
  /* Error */
  private StringBuffer b(String paramString)
  {
    // Byte code:
    //   0: new 101	java/io/File
    //   3: dup
    //   4: aload_1
    //   5: invokespecial 103	java/io/File:<init>	(Ljava/lang/String;)V
    //   8: astore_1
    //   9: new 84	java/lang/StringBuffer
    //   12: dup
    //   13: invokespecial 85	java/lang/StringBuffer:<init>	()V
    //   16: astore 5
    //   18: new 105	java/io/BufferedReader
    //   21: dup
    //   22: new 107	java/io/FileReader
    //   25: dup
    //   26: aload_1
    //   27: invokespecial 110	java/io/FileReader:<init>	(Ljava/io/File;)V
    //   30: invokespecial 113	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   33: astore_3
    //   34: iconst_1
    //   35: istore_2
    //   36: aload_3
    //   37: astore_1
    //   38: aload_3
    //   39: invokevirtual 117	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   42: astore 4
    //   44: aload 4
    //   46: ifnull +38 -> 84
    //   49: aload_3
    //   50: astore_1
    //   51: aload 5
    //   53: new 119	java/lang/StringBuilder
    //   56: dup
    //   57: invokespecial 120	java/lang/StringBuilder:<init>	()V
    //   60: ldc 122
    //   62: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   65: aload 4
    //   67: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   70: invokevirtual 129	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   73: invokevirtual 131	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   76: pop
    //   77: iload_2
    //   78: iconst_1
    //   79: iadd
    //   80: istore_2
    //   81: goto -45 -> 36
    //   84: aload_3
    //   85: astore_1
    //   86: aload_3
    //   87: invokevirtual 134	java/io/BufferedReader:close	()V
    //   90: aload_3
    //   91: ifnull +7 -> 98
    //   94: aload_3
    //   95: invokevirtual 134	java/io/BufferedReader:close	()V
    //   98: aload 5
    //   100: areturn
    //   101: astore 4
    //   103: aconst_null
    //   104: astore_3
    //   105: aload_3
    //   106: astore_1
    //   107: aload 4
    //   109: invokevirtual 137	java/io/IOException:printStackTrace	()V
    //   112: aload_3
    //   113: ifnull -15 -> 98
    //   116: aload_3
    //   117: invokevirtual 134	java/io/BufferedReader:close	()V
    //   120: aload 5
    //   122: areturn
    //   123: astore_1
    //   124: aload 5
    //   126: areturn
    //   127: astore_3
    //   128: aconst_null
    //   129: astore_1
    //   130: aload_1
    //   131: ifnull +7 -> 138
    //   134: aload_1
    //   135: invokevirtual 134	java/io/BufferedReader:close	()V
    //   138: aload_3
    //   139: athrow
    //   140: astore_1
    //   141: aload 5
    //   143: areturn
    //   144: astore_1
    //   145: goto -7 -> 138
    //   148: astore_3
    //   149: goto -19 -> 130
    //   152: astore 4
    //   154: goto -49 -> 105
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	157	0	this	ErrorLogInfoActivity
    //   0	157	1	paramString	String
    //   35	46	2	i	int
    //   33	84	3	localBufferedReader	java.io.BufferedReader
    //   127	12	3	localObject1	Object
    //   148	1	3	localObject2	Object
    //   42	24	4	str	String
    //   101	7	4	localIOException1	java.io.IOException
    //   152	1	4	localIOException2	java.io.IOException
    //   16	126	5	localStringBuffer	StringBuffer
    // Exception table:
    //   from	to	target	type
    //   18	34	101	java/io/IOException
    //   116	120	123	java/io/IOException
    //   18	34	127	finally
    //   94	98	140	java/io/IOException
    //   134	138	144	java/io/IOException
    //   38	44	148	finally
    //   51	77	148	finally
    //   86	90	148	finally
    //   107	112	148	finally
    //   38	44	152	java/io/IOException
    //   51	77	152	java/io/IOException
    //   86	90	152	java/io/IOException
  }
  
  public void onClic(View paramView)
  {
    if (paramView.getId() == R.id.iv_back) {
      finish();
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    requestWindowFeature(1);
    setContentView(R.layout.error_log_info_activity);
    this.d = getIntent().getStringExtra("fileName");
    this.e = getIntent().getStringExtra("path");
    a();
    a(this.e);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcoloreggs/eggs/ErrorLogInfoActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */