package com.hyphenate.util;

import android.content.Context;
import android.os.Environment;
import java.io.File;

public class PathUtil
{
  public static final String filePathName = "/file/";
  public static final String historyPathName = "/chat/";
  public static final String imagePathName = "/image/";
  private static PathUtil instance = null;
  public static final String meetingPathName = "/meeting/";
  public static final String netdiskDownloadPathName = "/netdisk/";
  public static String pathPrefix;
  private static File storageDir = null;
  public static final String videoPathName = "/video/";
  public static final String voicePathName = "/voice/";
  private File filePath;
  private File historyPath = null;
  private File imagePath = null;
  private File videoPath = null;
  private File voicePath = null;
  
  private static File generateFiePath(String paramString1, String paramString2, Context paramContext)
  {
    if (paramString1 == null) {}
    for (paramString1 = pathPrefix + paramString2 + "/file/";; paramString1 = pathPrefix + paramString1 + "/" + paramString2 + "/file/") {
      return new File(getStorageDir(paramContext), paramString1);
    }
  }
  
  private static File generateHistoryPath(String paramString1, String paramString2, Context paramContext)
  {
    if (paramString1 == null) {}
    for (paramString1 = pathPrefix + paramString2 + "/chat/";; paramString1 = pathPrefix + paramString1 + "/" + paramString2 + "/chat/") {
      return new File(getStorageDir(paramContext), paramString1);
    }
  }
  
  private static File generateImagePath(String paramString1, String paramString2, Context paramContext)
  {
    if (paramString1 == null) {}
    for (paramString1 = pathPrefix + paramString2 + "/image/";; paramString1 = pathPrefix + paramString1 + "/" + paramString2 + "/image/") {
      return new File(getStorageDir(paramContext), paramString1);
    }
  }
  
  private static File generateVideoPath(String paramString1, String paramString2, Context paramContext)
  {
    if (paramString1 == null) {}
    for (paramString1 = pathPrefix + paramString2 + "/video/";; paramString1 = pathPrefix + paramString1 + "/" + paramString2 + "/video/") {
      return new File(getStorageDir(paramContext), paramString1);
    }
  }
  
  private static File generateVoicePath(String paramString1, String paramString2, Context paramContext)
  {
    if (paramString1 == null) {}
    for (paramString1 = pathPrefix + paramString2 + "/voice/";; paramString1 = pathPrefix + paramString1 + "/" + paramString2 + "/voice/") {
      return new File(getStorageDir(paramContext), paramString1);
    }
  }
  
  public static PathUtil getInstance()
  {
    if (instance == null) {
      instance = new PathUtil();
    }
    return instance;
  }
  
  private static File getStorageDir(Context paramContext)
  {
    if (storageDir == null)
    {
      File localFile = Environment.getExternalStorageDirectory();
      if (localFile.exists()) {
        return localFile;
      }
      storageDir = paramContext.getFilesDir();
    }
    return storageDir;
  }
  
  public static File getTempPath(File paramFile)
  {
    return new File(paramFile.getAbsoluteFile() + ".tmp");
  }
  
  public File getFilePath()
  {
    return this.filePath;
  }
  
  public File getHistoryPath()
  {
    return this.historyPath;
  }
  
  public File getImagePath()
  {
    return this.imagePath;
  }
  
  public File getVideoPath()
  {
    return this.videoPath;
  }
  
  public File getVoicePath()
  {
    return this.voicePath;
  }
  
  public void initDirs(String paramString1, String paramString2, Context paramContext)
  {
    String str = paramContext.getPackageName();
    pathPrefix = "/Android/data/" + str + "/";
    this.voicePath = generateVoicePath(paramString1, paramString2, paramContext);
    if (!this.voicePath.exists()) {
      this.voicePath.mkdirs();
    }
    this.imagePath = generateImagePath(paramString1, paramString2, paramContext);
    if (!this.imagePath.exists()) {
      this.imagePath.mkdirs();
    }
    this.historyPath = generateHistoryPath(paramString1, paramString2, paramContext);
    if (!this.historyPath.exists()) {
      this.historyPath.mkdirs();
    }
    this.videoPath = generateVideoPath(paramString1, paramString2, paramContext);
    if (!this.videoPath.exists()) {
      this.videoPath.mkdirs();
    }
    this.filePath = generateFiePath(paramString1, paramString2, paramContext);
    if (!this.filePath.exists()) {
      this.filePath.mkdirs();
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/hyphenate/util/PathUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */