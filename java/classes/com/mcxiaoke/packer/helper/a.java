package com.mcxiaoke.packer.helper;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import java.io.File;
import java.io.IOException;

public final class a
{
  public static String getChannel(Context paramContext)
  {
    try
    {
      paramContext = getChannelOrThrow(paramContext);
      return paramContext;
    }
    catch (Exception paramContext) {}
    return "";
  }
  
  public static String getChannel(File paramFile)
  {
    try
    {
      paramFile = com.mcxiaoke.packer.a.a.readChannel(paramFile);
      return paramFile;
    }
    catch (Exception paramFile) {}
    return "";
  }
  
  public static String getChannelOrThrow(Context paramContext)
    throws IOException
  {
    try
    {
      paramContext = com.mcxiaoke.packer.a.a.readChannel(new File(paramContext.getApplicationInfo().sourceDir));
      return paramContext;
    }
    finally
    {
      paramContext = finally;
      throw paramContext;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/mcxiaoke/packer/helper/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */