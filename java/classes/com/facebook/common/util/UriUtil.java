package com.facebook.common.util;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.net.Uri.Builder;
import android.provider.ContactsContract;
import android.provider.MediaStore.Images.Media;
import java.io.File;
import javax.annotation.Nullable;

public class UriUtil
{
  public static final String DATA_SCHEME = "data";
  public static final String HTTPS_SCHEME = "https";
  public static final String HTTP_SCHEME = "http";
  public static final String LOCAL_ASSET_SCHEME = "asset";
  private static final String LOCAL_CONTACT_IMAGE_PREFIX = Uri.withAppendedPath(ContactsContract.AUTHORITY_URI, "display_photo").getPath();
  public static final String LOCAL_CONTENT_SCHEME = "content";
  public static final String LOCAL_FILE_SCHEME = "file";
  public static final String LOCAL_RESOURCE_SCHEME = "res";
  
  @Nullable
  public static String getRealPathFromUri(ContentResolver paramContentResolver, Uri paramUri)
  {
    Object localObject = null;
    if (isLocalContentUri(paramUri)) {}
    for (;;)
    {
      try
      {
        paramUri = paramContentResolver.query(paramUri, null, null, null, null);
        if (paramUri == null) {
          break label99;
        }
        int i;
        if (paramUri == null) {
          break label79;
        }
      }
      finally
      {
        try
        {
          if (!paramUri.moveToFirst()) {
            break label99;
          }
          i = paramUri.getColumnIndex("_data");
          if (i == -1) {
            break label99;
          }
          paramContentResolver = paramUri.getString(i);
          if (paramUri != null) {
            paramUri.close();
          }
          return paramContentResolver;
        }
        finally
        {
          for (;;) {}
        }
        paramContentResolver = finally;
        paramUri = (Uri)localObject;
      }
      paramUri.close();
      label79:
      throw paramContentResolver;
      if (isLocalFileUri(paramUri)) {
        return paramUri.getPath();
      }
      return null;
      label99:
      paramContentResolver = null;
    }
  }
  
  @Nullable
  public static String getSchemeOrNull(@Nullable Uri paramUri)
  {
    if (paramUri == null) {
      return null;
    }
    return paramUri.getScheme();
  }
  
  public static Uri getUriForFile(File paramFile)
  {
    return Uri.fromFile(paramFile);
  }
  
  public static Uri getUriForResourceId(int paramInt)
  {
    return new Uri.Builder().scheme("res").path(String.valueOf(paramInt)).build();
  }
  
  public static boolean isDataUri(@Nullable Uri paramUri)
  {
    return "data".equals(getSchemeOrNull(paramUri));
  }
  
  public static boolean isLocalAssetUri(@Nullable Uri paramUri)
  {
    return "asset".equals(getSchemeOrNull(paramUri));
  }
  
  public static boolean isLocalCameraUri(Uri paramUri)
  {
    paramUri = paramUri.toString();
    return (paramUri.startsWith(MediaStore.Images.Media.EXTERNAL_CONTENT_URI.toString())) || (paramUri.startsWith(MediaStore.Images.Media.INTERNAL_CONTENT_URI.toString()));
  }
  
  public static boolean isLocalContactUri(Uri paramUri)
  {
    return (isLocalContentUri(paramUri)) && ("com.android.contacts".equals(paramUri.getAuthority())) && (!paramUri.getPath().startsWith(LOCAL_CONTACT_IMAGE_PREFIX));
  }
  
  public static boolean isLocalContentUri(@Nullable Uri paramUri)
  {
    return "content".equals(getSchemeOrNull(paramUri));
  }
  
  public static boolean isLocalFileUri(@Nullable Uri paramUri)
  {
    return "file".equals(getSchemeOrNull(paramUri));
  }
  
  public static boolean isLocalResourceUri(@Nullable Uri paramUri)
  {
    return "res".equals(getSchemeOrNull(paramUri));
  }
  
  public static boolean isNetworkUri(@Nullable Uri paramUri)
  {
    paramUri = getSchemeOrNull(paramUri);
    return ("https".equals(paramUri)) || ("http".equals(paramUri));
  }
  
  public static Uri parseUriOrNull(@Nullable String paramString)
  {
    if (paramString != null) {
      return Uri.parse(paramString);
    }
    return null;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/facebook/common/util/UriUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */