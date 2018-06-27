package com.hyphenate.util;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.webkit.MimeTypeMap;
import android.widget.Toast;
import com.growingio.android.sdk.agent.VdsAgent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class FileUtils
{
  public static String[] fileTypes = { "apk", "avi", "bmp", "chm", "dll", "doc", "docx", "dos", "gif", "html", "jpeg", "jpg", "movie", "mp3", "dat", "mp4", "mpe", "mpeg", "mpg", "pdf", "png", "ppt", "pptx", "rar", "txt", "wav", "wma", "wmv", "xls", "xlsx", "xml", "zip" };
  
  public static String getMIMEType(File paramFile)
  {
    paramFile = paramFile.getName();
    paramFile = paramFile.substring(paramFile.lastIndexOf(".") + 1, paramFile.length()).toLowerCase();
    return MimeTypeMap.getSingleton().getMimeTypeFromExtension(paramFile);
  }
  
  public static String getMIMEType(String paramString)
  {
    paramString = paramString.substring(paramString.lastIndexOf(".") + 1, paramString.length()).toLowerCase();
    return MimeTypeMap.getSingleton().getMimeTypeFromExtension(paramString);
  }
  
  public static File[] loadFiles(File paramFile)
  {
    Object localObject1 = paramFile.listFiles();
    paramFile = (File)localObject1;
    if (localObject1 == null) {
      paramFile = new File[0];
    }
    localObject1 = new ArrayList();
    ArrayList localArrayList = new ArrayList();
    int j = paramFile.length;
    int i = 0;
    if (i < j)
    {
      Object localObject2 = paramFile[i];
      if (((File)localObject2).isDirectory()) {
        ((ArrayList)localObject1).add(localObject2);
      }
      for (;;)
      {
        i += 1;
        break;
        if (((File)localObject2).isFile()) {
          localArrayList.add(localObject2);
        }
      }
    }
    paramFile = new MyComparator();
    Collections.sort((List)localObject1, paramFile);
    Collections.sort(localArrayList, paramFile);
    paramFile = new File[((ArrayList)localObject1).size() + localArrayList.size()];
    System.arraycopy(((ArrayList)localObject1).toArray(new File[((ArrayList)localObject1).size()]), 0, paramFile, 0, ((ArrayList)localObject1).size());
    System.arraycopy(localArrayList.toArray(new File[localArrayList.size()]), 0, paramFile, ((ArrayList)localObject1).size(), localArrayList.size());
    return paramFile;
  }
  
  public static void openFile(Uri paramUri, String paramString, Activity paramActivity)
  {
    Intent localIntent = new Intent();
    localIntent.addFlags(268435456);
    localIntent.setAction("android.intent.action.VIEW");
    localIntent.setDataAndType(paramUri, paramString);
    try
    {
      paramActivity.startActivity(localIntent);
      return;
    }
    catch (Exception paramUri)
    {
      paramUri.printStackTrace();
      paramUri = Toast.makeText(paramActivity, "Can't find proper app to open this file", 1);
      if (!(paramUri instanceof Toast))
      {
        paramUri.show();
        return;
      }
      VdsAgent.showToast((Toast)paramUri);
    }
  }
  
  public static void openFile(File paramFile, Activity paramActivity)
  {
    Intent localIntent = new Intent();
    localIntent.addFlags(268435456);
    localIntent.setAction("android.intent.action.VIEW");
    String str = getMIMEType(paramFile);
    localIntent.setDataAndType(Uri.fromFile(paramFile), str);
    try
    {
      paramActivity.startActivity(localIntent);
      return;
    }
    catch (Exception paramFile)
    {
      paramFile.printStackTrace();
      paramFile = Toast.makeText(paramActivity, "Can't find proper app to open this file", 1);
      if (!(paramFile instanceof Toast))
      {
        paramFile.show();
        return;
      }
      VdsAgent.showToast((Toast)paramFile);
    }
  }
  
  public static Object readObjectFromFile(File paramFile)
    throws Exception
  {
    try
    {
      paramFile = new ObjectInputStream(new FileInputStream(paramFile)).readObject();
      return paramFile;
    }
    finally
    {
      paramFile = finally;
      throw paramFile;
    }
  }
  
  public static void saveObjectToFile(Object paramObject, File paramFile)
    throws Exception
  {
    try
    {
      paramFile = new ObjectOutputStream(new FileOutputStream(paramFile));
      paramFile.writeObject(paramObject);
      paramFile.flush();
      paramFile.close();
      return;
    }
    finally
    {
      paramObject = finally;
      throw ((Throwable)paramObject);
    }
  }
  
  public static class MyComparator
    implements Comparator<File>
  {
    public int compare(File paramFile1, File paramFile2)
    {
      return paramFile1.getName().compareTo(paramFile2.getName());
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/hyphenate/util/FileUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */