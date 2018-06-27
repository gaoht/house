package com.ziroom.ziroomcustomer.minsu.f;

import android.content.Context;
import android.os.Environment;
import android.text.TextUtils;
import android.util.Log;
import com.airbnb.lottie.LottieAnimationView;
import com.airbnb.lottie.aw;
import com.airbnb.lottie.aw.a;
import com.airbnb.lottie.bf;
import com.ziroom.ziroomcustomer.base.ApplicationEx;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import org.greenrobot.eventbus.c;

public class m
{
  public static String a = Environment.getExternalStorageDirectory().getAbsolutePath() + "/ziroom";
  
  private static String a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append(paramString1);
    localStringBuffer.append(File.separator);
    localStringBuffer.append(paramString2);
    localStringBuffer.append(File.separator);
    if (paramString3.contains("/"))
    {
      paramString1 = paramString3.split("/");
      int j = paramString1.length;
      int i = 0;
      if (i < j)
      {
        paramString2 = paramString1[i];
        if (!paramString2.endsWith(".json"))
        {
          localStringBuffer.append(paramString2);
          localStringBuffer.append(File.separator);
        }
        for (;;)
        {
          i += 1;
          break;
          localStringBuffer.append(paramString4);
          localStringBuffer.append("_");
          localStringBuffer.append(paramString2);
        }
      }
    }
    else
    {
      localStringBuffer.append(paramString4);
      localStringBuffer.append("_");
      localStringBuffer.append(paramString3);
    }
    return localStringBuffer.toString();
  }
  
  private static String a(String... paramVarArgs)
  {
    StringBuffer localStringBuffer = new StringBuffer(a);
    localStringBuffer.append(File.separator);
    int j = paramVarArgs.length;
    int i = 0;
    while (i < j)
    {
      localStringBuffer.append(paramVarArgs[i]);
      localStringBuffer.append(File.separator);
      i += 1;
    }
    return localStringBuffer.toString();
  }
  
  private static void a(File paramFile, String paramString1, String paramString2)
  {
    File localFile = new File(paramFile, paramString1);
    try
    {
      if ((!localFile.exists()) && (localFile.createNewFile())) {
        a(localFile, paramString2, paramFile.getPath(), paramString1);
      }
      return;
    }
    catch (IOException paramFile)
    {
      paramFile.printStackTrace();
      return;
    }
    catch (Exception paramFile)
    {
      paramFile.printStackTrace();
    }
  }
  
  private static void a(File paramFile, String paramString1, final String paramString2, final String paramString3)
  {
    com.freelxl.baselibrary.d.a.get(paramString1).enqueue(new com.ziroom.ziroomcustomer.e.a.b(ApplicationEx.c, new com.freelxl.baselibrary.d.f.b(paramFile))
    {
      public void onFailure(Throwable paramAnonymousThrowable) {}
      
      public void onSuccess(int paramAnonymousInt, File paramAnonymousFile)
      {
        if ((paramAnonymousFile.exists()) && (paramAnonymousFile.isFile()))
        {
          paramAnonymousFile = new g(1, paramAnonymousFile, paramString2, paramString3);
          c.getDefault().post(paramAnonymousFile);
        }
      }
    });
  }
  
  private static boolean a(File paramFile)
  {
    int i = 0;
    if ((paramFile == null) || (!paramFile.exists()) || (!paramFile.isDirectory())) {
      return false;
    }
    File[] arrayOfFile = paramFile.listFiles();
    int j = arrayOfFile.length;
    if (i < j)
    {
      File localFile = arrayOfFile[i];
      if (localFile.isFile()) {
        localFile.delete();
      }
      for (;;)
      {
        i += 1;
        break;
        if (localFile.isDirectory()) {
          a(localFile);
        }
      }
    }
    paramFile.delete();
    return true;
  }
  
  private static boolean a(String paramString)
  {
    return a(new File(paramString));
  }
  
  public static boolean deleteSingleFile(String paramString)
  {
    paramString = new File(paramString);
    if ((paramString.isFile()) && (paramString.exists()))
    {
      paramString.delete();
      return true;
    }
    return false;
  }
  
  public static void downZipSource(String paramString1, String paramString2, String paramString3)
  {
    paramString1 = a(new String[] { paramString1 });
    a(paramString1);
    paramString1 = new File(paramString1);
    if ((!paramString1.exists()) && (paramString1.mkdirs())) {
      a(paramString1, paramString3, paramString2);
    }
  }
  
  public static ArrayList<String> getAllFileNames(String paramString)
  {
    paramString = new File(paramString);
    if (paramString.exists())
    {
      File[] arrayOfFile = paramString.listFiles();
      if ((arrayOfFile != null) && (arrayOfFile.length > 0))
      {
        ArrayList localArrayList = new ArrayList();
        int j = arrayOfFile.length;
        int i = 0;
        paramString = localArrayList;
        if (i >= j) {
          return paramString;
        }
        paramString = arrayOfFile[i];
        if (paramString.isFile()) {
          localArrayList.add(paramString.getName());
        }
        for (;;)
        {
          i += 1;
          break;
          if (paramString.isDirectory()) {
            getAllFileNames(paramString.getPath());
          }
        }
      }
    }
    paramString = null;
    return paramString;
  }
  
  public static String getLocalLottieFilePath()
  {
    int i = 0;
    Object localObject1 = new File(a(new String[] { "lottie", "jsonfile" }));
    if (((File)localObject1).exists())
    {
      localObject1 = ((File)localObject1).listFiles();
      int j = localObject1.length;
      while (i < j)
      {
        Object localObject2 = localObject1[i];
        if (((File)localObject2).getPath().endsWith(".json")) {
          return ((File)localObject2).getPath();
        }
        i += 1;
      }
    }
    return null;
  }
  
  public static String getLottieVersion()
  {
    String str = "0";
    Object localObject2 = getAllFileNames(a(new String[] { "lottie", "jsonfile" }));
    Object localObject1 = str;
    if (localObject2 != null)
    {
      localObject2 = ((ArrayList)localObject2).iterator();
      localObject1 = str;
      if (((Iterator)localObject2).hasNext())
      {
        localObject1 = (String)((Iterator)localObject2).next();
        if (!((String)localObject1).contains("_")) {
          break label90;
        }
        localObject1 = ((String)localObject1).split("_");
        if ((localObject1 == null) || (localObject1.length <= 0)) {
          break label90;
        }
        str = localObject1[0];
      }
    }
    label90:
    for (;;)
    {
      break;
      return (String)localObject1;
    }
  }
  
  public static boolean loadLottieFromScCard(Context paramContext, LottieAnimationView paramLottieAnimationView, String paramString)
  {
    Object localObject = null;
    try
    {
      if (!TextUtils.isEmpty(paramString)) {
        paramString = new FileInputStream(paramString);
      }
      for (;;)
      {
        aw.a.fromInputStream(paramContext, paramString, new bf()
        {
          public void onCompositionLoaded(aw paramAnonymousaw)
          {
            if (paramAnonymousaw != null)
            {
              this.a.setVisibility(0);
              this.a.setComposition(paramAnonymousaw);
              this.a.loop(true);
              this.a.playAnimation();
            }
          }
        });
        return true;
        String str = a(new String[] { "lottie", "jsonfile" });
        ArrayList localArrayList = getAllFileNames(str);
        paramString = (String)localObject;
        if (localArrayList != null)
        {
          paramString = (String)localObject;
          if (localArrayList.size() > 0) {
            paramString = new FileInputStream(str + (String)localArrayList.get(0));
          }
        }
      }
      return false;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
  }
  
  public static String unZip(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    String str1 = "";
    ZipInputStream localZipInputStream;
    for (;;)
    {
      Object localObject1;
      try
      {
        localZipInputStream = new ZipInputStream(new BufferedInputStream(new FileInputStream(paramString1)));
        localObject2 = localZipInputStream.getNextEntry();
        if (localObject2 == null) {
          break;
        }
        Log.i("LottieUtils", "=" + localObject2);
        localObject1 = new byte['က'];
        String str2 = ((ZipEntry)localObject2).getName();
        if (((ZipEntry)localObject2).isDirectory())
        {
          localObject1 = str2.substring(0, str2.length() - 1);
          localObject1 = new File(paramString2 + File.separator + paramString3 + File.separator + (String)localObject1);
          if (((File)localObject1).exists()) {
            continue;
          }
          ((File)localObject1).mkdirs();
          continue;
        }
        str1 = a(paramString2, paramString3, str2, paramString4);
      }
      catch (Exception paramString1)
      {
        paramString1.printStackTrace();
        return null;
      }
      Object localObject2 = new File(str1);
      if (!((File)localObject2).exists())
      {
        ((File)localObject2).getParentFile().mkdirs();
        ((File)localObject2).createNewFile();
      }
      localObject2 = new BufferedOutputStream(new FileOutputStream((File)localObject2), 4096);
      for (;;)
      {
        int i = localZipInputStream.read((byte[])localObject1, 0, 4096);
        if (i == -1) {
          break;
        }
        ((BufferedOutputStream)localObject2).write((byte[])localObject1, 0, i);
      }
      ((BufferedOutputStream)localObject2).flush();
      ((BufferedOutputStream)localObject2).close();
    }
    localZipInputStream.close();
    deleteSingleFile(paramString1);
    return str1;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes3-dex2jar.jar!/com/ziroom/ziroomcustomer/minsu/f/m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */