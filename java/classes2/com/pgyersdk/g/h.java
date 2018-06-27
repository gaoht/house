package com.pgyersdk.g;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.os.Environment;
import com.growingio.android.sdk.agent.VdsAgent;
import com.maa.android.agent.instrumentation.Instrumented;
import com.mato.sdk.instrumentation.HttpInstrumentation;
import com.pgyersdk.b.b;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.UUID;

@Instrumented
public class h
  extends AsyncTask
{
  protected Context a;
  protected g b;
  protected String c;
  protected String d;
  protected String e;
  protected ProgressDialog f;
  private String g;
  
  public h(Context paramContext, String paramString, g paramg)
  {
    this.a = paramContext;
    this.c = paramString;
    this.d = (UUID.randomUUID() + ".apk");
    this.e = (Environment.getExternalStorageDirectory().getAbsolutePath() + "/Download");
    this.b = paramg;
    this.g = null;
  }
  
  protected Long a(Void... paramVarArgs)
  {
    int i;
    try
    {
      paramVarArgs = a(new URL(a()), 6);
      paramVarArgs.connect();
      i = paramVarArgs.getContentLength();
      paramVarArgs.getContentType();
      localObject = new File(this.e);
      if ((!((File)localObject).mkdirs()) && (!((File)localObject).exists())) {
        throw new IOException("Could not create the dir(s):" + ((File)localObject).getAbsolutePath());
      }
    }
    catch (Exception paramVarArgs)
    {
      paramVarArgs.printStackTrace();
      return Long.valueOf(0L);
    }
    Object localObject = new File((File)localObject, this.d);
    paramVarArgs = new BufferedInputStream(paramVarArgs.getInputStream());
    localObject = new FileOutputStream((File)localObject);
    byte[] arrayOfByte = new byte['Ѐ'];
    long l = 0L;
    for (;;)
    {
      int j = paramVarArgs.read(arrayOfByte);
      if (j == -1) {
        break;
      }
      l += j;
      publishProgress(new Integer[] { Integer.valueOf(Math.round((float)l * 100.0F / i)) });
      ((OutputStream)localObject).write(arrayOfByte, 0, j);
    }
    ((OutputStream)localObject).flush();
    ((OutputStream)localObject).close();
    paramVarArgs.close();
    return Long.valueOf(l);
  }
  
  protected String a()
  {
    return this.c;
  }
  
  protected URLConnection a(URL paramURL, int paramInt)
  {
    Object localObject;
    if (!(paramURL instanceof URL))
    {
      localObject = paramURL.openConnection();
      localObject = (HttpURLConnection)localObject;
      a((HttpURLConnection)localObject);
      int i = ((HttpURLConnection)localObject).getResponseCode();
      if (((i == 301) || (i == 302) || (i == 303)) && (paramInt != 0)) {
        break label72;
      }
    }
    label72:
    URL localURL;
    do
    {
      return (URLConnection)localObject;
      localObject = HttpInstrumentation.openConnection((URL)paramURL);
      break;
      localURL = new URL(((HttpURLConnection)localObject).getHeaderField("Location"));
    } while (paramURL.getProtocol().equals(localURL.getProtocol()));
    ((HttpURLConnection)localObject).disconnect();
    return a(localURL, paramInt - 1);
  }
  
  protected void a(Long paramLong)
  {
    if (this.f != null) {}
    try
    {
      this.f.dismiss();
      if (paramLong.longValue() > 0L)
      {
        this.b.a(this);
        paramLong = new Intent("android.intent.action.VIEW");
        paramLong.setDataAndType(Uri.fromFile(new File(this.e, this.d)), "application/vnd.android.package-archive");
        paramLong.setFlags(268435456);
        if (this.a != null) {
          this.a.startActivity(paramLong);
        }
        return;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        try
        {
          AlertDialog.Builder localBuilder = new AlertDialog.Builder(this.a);
          localBuilder.setTitle(b.a(this.b, 256));
          if (this.g == null)
          {
            paramLong = b.a(this.b, 257);
            localBuilder.setMessage(paramLong);
            localBuilder.setNegativeButton(b.a(this.b, 258), new i(this));
            localBuilder.setPositiveButton(b.a(this.b, 259), new j(this));
            paramLong = localBuilder.create();
            if (!(paramLong instanceof AlertDialog)) {
              paramLong.show();
            }
          }
          else
          {
            paramLong = this.g;
            continue;
          }
          VdsAgent.showDialog((AlertDialog)paramLong);
          return;
        }
        catch (Exception paramLong) {}
        localException = localException;
      }
    }
  }
  
  protected void a(HttpURLConnection paramHttpURLConnection)
  {
    paramHttpURLConnection.addRequestProperty("User-Agent", "HockeySDK/Android");
    paramHttpURLConnection.setInstanceFollowRedirects(true);
    if (Build.VERSION.SDK_INT <= 9) {
      paramHttpURLConnection.setRequestProperty("connection", "close");
    }
  }
  
  protected void a(Integer... paramVarArgs)
  {
    try
    {
      ProgressDialog localProgressDialog;
      if (this.f == null)
      {
        this.f = new ProgressDialog(this.a);
        this.f.setProgressStyle(1);
        this.f.setMessage(b.a(260));
        this.f.setCancelable(false);
        localProgressDialog = this.f;
        if ((localProgressDialog instanceof ProgressDialog)) {
          break label81;
        }
        localProgressDialog.show();
      }
      for (;;)
      {
        this.f.setProgress(paramVarArgs[0].intValue());
        return;
        label81:
        VdsAgent.showDialog((ProgressDialog)localProgressDialog);
      }
      return;
    }
    catch (Exception paramVarArgs) {}
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/pgyersdk/g/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */