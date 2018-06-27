package com.ziroom.ziroomcoloreggs.eggs;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.alibaba.fastjson.e;
import com.growingio.android.sdk.agent.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.ziroom.commonlib.utils.r;
import com.ziroom.ziroomcoloreggs.R.id;
import com.ziroom.ziroomcoloreggs.R.layout;
import java.util.ArrayList;
import java.util.List;

public class WebLogHttpListActivity
  extends Activity
  implements View.OnClickListener, AdapterView.OnItemClickListener
{
  ListView a;
  TextView b;
  ImageView c;
  private String d;
  private String e;
  private f f;
  private List<e> g;
  private int h = 17;
  private Runnable i;
  private Handler j = new Handler()
  {
    public void handleMessage(Message paramAnonymousMessage)
    {
      if ((paramAnonymousMessage == null) && (paramAnonymousMessage.obj == null)) {
        return;
      }
      switch (paramAnonymousMessage.what)
      {
      case 17: 
      case 18: 
      case 19: 
      default: 
        return;
      }
      paramAnonymousMessage = paramAnonymousMessage.obj.toString().split("-------------网络日志---------------");
      WebLogHttpListActivity.a(WebLogHttpListActivity.this, new ArrayList());
      int j = paramAnonymousMessage.length;
      int i = 0;
      while (i < j)
      {
        Object localObject = paramAnonymousMessage[i];
        if (r.notNull((String)localObject))
        {
          localObject = e.parseObject((String)localObject);
          WebLogHttpListActivity.d(WebLogHttpListActivity.this).add(localObject);
        }
        i += 1;
      }
      if (WebLogHttpListActivity.d(WebLogHttpListActivity.this).size() == 0)
      {
        WebLogHttpListActivity.this.b.setVisibility(0);
        WebLogHttpListActivity.this.a.setVisibility(8);
        return;
      }
      WebLogHttpListActivity.a(WebLogHttpListActivity.this, new f(WebLogHttpListActivity.d(WebLogHttpListActivity.this), WebLogHttpListActivity.this));
      WebLogHttpListActivity.this.a.setAdapter(WebLogHttpListActivity.e(WebLogHttpListActivity.this));
      WebLogHttpListActivity.this.b.setVisibility(8);
      WebLogHttpListActivity.this.a.setVisibility(0);
    }
  };
  
  private void a()
  {
    this.c = ((ImageView)findViewById(R.id.iv_back));
    this.a = ((ListView)findViewById(R.id.web_log_http_list));
    this.b = ((TextView)findViewById(R.id.web_log_http_tv));
    this.c.setOnClickListener(this);
    this.a.setOnItemClickListener(this);
    this.i = new Runnable()
    {
      public void run()
      {
        Message localMessage = new Message();
        localMessage.what = WebLogHttpListActivity.b(WebLogHttpListActivity.this);
        WebLogHttpListActivity.a(WebLogHttpListActivity.this).sendMessage(localMessage);
        if (WebLogHttpListActivity.b(WebLogHttpListActivity.this) == 17) {
          WebLogHttpListActivity.a(WebLogHttpListActivity.this, 18);
        }
        for (;;)
        {
          WebLogHttpListActivity.a(WebLogHttpListActivity.this).postDelayed(WebLogHttpListActivity.c(WebLogHttpListActivity.this), 500L);
          return;
          if (WebLogHttpListActivity.b(WebLogHttpListActivity.this) == 18) {
            WebLogHttpListActivity.a(WebLogHttpListActivity.this, 19);
          } else if (WebLogHttpListActivity.b(WebLogHttpListActivity.this) == 19) {
            WebLogHttpListActivity.a(WebLogHttpListActivity.this, 17);
          }
        }
      }
    };
    this.j.postDelayed(this.i, 500L);
  }
  
  private void a(final String paramString)
  {
    new StringBuffer();
    new Thread(new Runnable()
    {
      public void run()
      {
        StringBuffer localStringBuffer = WebLogHttpListActivity.readFileByLines(paramString);
        Message localMessage = new Message();
        localMessage.obj = localStringBuffer;
        localMessage.what = 1;
        WebLogHttpListActivity.a(WebLogHttpListActivity.this).sendMessage(localMessage);
      }
    }).start();
  }
  
  /* Error */
  public static StringBuffer readFileByLines(String paramString)
  {
    // Byte code:
    //   0: new 125	java/io/File
    //   3: dup
    //   4: aload_0
    //   5: invokespecial 127	java/io/File:<init>	(Ljava/lang/String;)V
    //   8: astore_0
    //   9: new 103	java/lang/StringBuffer
    //   12: dup
    //   13: invokespecial 104	java/lang/StringBuffer:<init>	()V
    //   16: astore 4
    //   18: getstatic 133	java/lang/System:out	Ljava/io/PrintStream;
    //   21: ldc -121
    //   23: invokevirtual 140	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   26: new 142	java/io/BufferedReader
    //   29: dup
    //   30: new 144	java/io/FileReader
    //   33: dup
    //   34: aload_0
    //   35: invokespecial 147	java/io/FileReader:<init>	(Ljava/io/File;)V
    //   38: invokespecial 150	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   41: astore_2
    //   42: iconst_1
    //   43: istore_1
    //   44: aload_2
    //   45: astore_0
    //   46: aload_2
    //   47: invokevirtual 154	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   50: astore_3
    //   51: aload_3
    //   52: ifnull +37 -> 89
    //   55: aload_2
    //   56: astore_0
    //   57: aload 4
    //   59: new 156	java/lang/StringBuilder
    //   62: dup
    //   63: invokespecial 157	java/lang/StringBuilder:<init>	()V
    //   66: ldc -97
    //   68: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   71: aload_3
    //   72: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   75: invokevirtual 166	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   78: invokevirtual 168	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   81: pop
    //   82: iload_1
    //   83: iconst_1
    //   84: iadd
    //   85: istore_1
    //   86: goto -42 -> 44
    //   89: aload_2
    //   90: astore_0
    //   91: aload_2
    //   92: invokevirtual 171	java/io/BufferedReader:close	()V
    //   95: aload_2
    //   96: ifnull +7 -> 103
    //   99: aload_2
    //   100: invokevirtual 171	java/io/BufferedReader:close	()V
    //   103: aload 4
    //   105: areturn
    //   106: astore_3
    //   107: aconst_null
    //   108: astore_2
    //   109: aload_2
    //   110: astore_0
    //   111: aload_3
    //   112: invokevirtual 174	java/io/IOException:printStackTrace	()V
    //   115: aload_2
    //   116: ifnull -13 -> 103
    //   119: aload_2
    //   120: invokevirtual 171	java/io/BufferedReader:close	()V
    //   123: aload 4
    //   125: areturn
    //   126: astore_0
    //   127: aload 4
    //   129: areturn
    //   130: astore_2
    //   131: aconst_null
    //   132: astore_0
    //   133: aload_0
    //   134: ifnull +7 -> 141
    //   137: aload_0
    //   138: invokevirtual 171	java/io/BufferedReader:close	()V
    //   141: aload_2
    //   142: athrow
    //   143: astore_0
    //   144: aload 4
    //   146: areturn
    //   147: astore_0
    //   148: goto -7 -> 141
    //   151: astore_2
    //   152: goto -19 -> 133
    //   155: astore_3
    //   156: goto -47 -> 109
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	159	0	paramString	String
    //   43	43	1	k	int
    //   41	79	2	localBufferedReader	java.io.BufferedReader
    //   130	12	2	localObject1	Object
    //   151	1	2	localObject2	Object
    //   50	22	3	str	String
    //   106	6	3	localIOException1	java.io.IOException
    //   155	1	3	localIOException2	java.io.IOException
    //   16	129	4	localStringBuffer	StringBuffer
    // Exception table:
    //   from	to	target	type
    //   18	42	106	java/io/IOException
    //   119	123	126	java/io/IOException
    //   18	42	130	finally
    //   99	103	143	java/io/IOException
    //   137	141	147	java/io/IOException
    //   46	51	151	finally
    //   57	82	151	finally
    //   91	95	151	finally
    //   111	115	151	finally
    //   46	51	155	java/io/IOException
    //   57	82	155	java/io/IOException
    //   91	95	155	java/io/IOException
  }
  
  @Instrumented
  public void onClick(View paramView)
  {
    VdsAgent.onClick(this, paramView);
    if (paramView.getId() == R.id.iv_back) {
      finish();
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    requestWindowFeature(1);
    setContentView(R.layout.web_log_http_list_activity);
    a();
    this.d = getIntent().getStringExtra("fileName");
    this.e = getIntent().getStringExtra("path");
    a(this.e);
  }
  
  @Instrumented
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    VdsAgent.onItemClick(this, paramAdapterView, paramView, paramInt, paramLong);
    paramAdapterView = new Intent(this, WebLogHttpInfoActivity.class);
    paramAdapterView.putExtra("JSONString", ((e)this.f.getmList().get(paramInt)).toJSONString());
    startActivity(paramAdapterView);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/ziroom/ziroomcoloreggs/eggs/WebLogHttpListActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */