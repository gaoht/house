package android.support.v4.app;

import android.app.RemoteInput;
import android.app.RemoteInput.Builder;
import android.content.ClipData;
import android.content.ClipData.Item;
import android.content.ClipDescription;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

class RemoteInputCompatApi20
{
  private static final String EXTRA_DATA_TYPE_RESULTS_DATA = "android.remoteinput.dataTypeResultsData";
  
  public static void addDataResultToIntent(RemoteInputCompatBase.RemoteInput paramRemoteInput, Intent paramIntent, Map<String, Uri> paramMap)
  {
    Intent localIntent = getClipDataIntentFromIntent(paramIntent);
    if (localIntent == null) {
      localIntent = new Intent();
    }
    for (;;)
    {
      Iterator localIterator = paramMap.entrySet().iterator();
      while (localIterator.hasNext())
      {
        paramMap = (Map.Entry)localIterator.next();
        String str = (String)paramMap.getKey();
        Uri localUri = (Uri)paramMap.getValue();
        if (str != null)
        {
          Bundle localBundle = localIntent.getBundleExtra(getExtraResultsKeyForData(str));
          paramMap = localBundle;
          if (localBundle == null) {
            paramMap = new Bundle();
          }
          paramMap.putString(paramRemoteInput.getResultKey(), localUri.toString());
          localIntent.putExtra(getExtraResultsKeyForData(str), paramMap);
        }
      }
      paramIntent.setClipData(ClipData.newIntent("android.remoteinput.results", localIntent));
      return;
    }
  }
  
  static void addResultsToIntent(RemoteInputCompatBase.RemoteInput[] paramArrayOfRemoteInput, Intent paramIntent, Bundle paramBundle)
  {
    Object localObject = getResultsFromIntent(paramIntent);
    if (localObject == null) {}
    for (;;)
    {
      int j = paramArrayOfRemoteInput.length;
      int i = 0;
      while (i < j)
      {
        localObject = paramArrayOfRemoteInput[i];
        Map localMap = getDataResultsFromIntent(paramIntent, ((RemoteInputCompatBase.RemoteInput)localObject).getResultKey());
        RemoteInput.addResultsToIntent(fromCompat(new RemoteInputCompatBase.RemoteInput[] { localObject }), paramIntent, paramBundle);
        if (localMap != null) {
          addDataResultToIntent((RemoteInputCompatBase.RemoteInput)localObject, paramIntent, localMap);
        }
        i += 1;
      }
      ((Bundle)localObject).putAll(paramBundle);
      paramBundle = (Bundle)localObject;
    }
  }
  
  static RemoteInput[] fromCompat(RemoteInputCompatBase.RemoteInput[] paramArrayOfRemoteInput)
  {
    if (paramArrayOfRemoteInput == null) {
      return null;
    }
    RemoteInput[] arrayOfRemoteInput = new RemoteInput[paramArrayOfRemoteInput.length];
    int i = 0;
    while (i < paramArrayOfRemoteInput.length)
    {
      RemoteInputCompatBase.RemoteInput localRemoteInput = paramArrayOfRemoteInput[i];
      arrayOfRemoteInput[i] = new RemoteInput.Builder(localRemoteInput.getResultKey()).setLabel(localRemoteInput.getLabel()).setChoices(localRemoteInput.getChoices()).setAllowFreeFormInput(localRemoteInput.getAllowFreeFormInput()).addExtras(localRemoteInput.getExtras()).build();
      i += 1;
    }
    return arrayOfRemoteInput;
  }
  
  private static Intent getClipDataIntentFromIntent(Intent paramIntent)
  {
    paramIntent = paramIntent.getClipData();
    if (paramIntent == null) {}
    ClipDescription localClipDescription;
    do
    {
      return null;
      localClipDescription = paramIntent.getDescription();
    } while ((!localClipDescription.hasMimeType("text/vnd.android.intent")) || (!localClipDescription.getLabel().equals("android.remoteinput.results")));
    return paramIntent.getItemAt(0).getIntent();
  }
  
  static Map<String, Uri> getDataResultsFromIntent(Intent paramIntent, String paramString)
  {
    Intent localIntent = getClipDataIntentFromIntent(paramIntent);
    if (localIntent == null) {
      return null;
    }
    paramIntent = new HashMap();
    Iterator localIterator = localIntent.getExtras().keySet().iterator();
    while (localIterator.hasNext())
    {
      String str2 = (String)localIterator.next();
      if (str2.startsWith("android.remoteinput.dataTypeResultsData"))
      {
        String str1 = str2.substring("android.remoteinput.dataTypeResultsData".length());
        if ((str1 != null) && (!str1.isEmpty()))
        {
          str2 = localIntent.getBundleExtra(str2).getString(paramString);
          if ((str2 != null) && (!str2.isEmpty())) {
            paramIntent.put(str1, Uri.parse(str2));
          }
        }
      }
    }
    if (paramIntent.isEmpty()) {
      paramIntent = null;
    }
    for (;;)
    {
      return paramIntent;
    }
  }
  
  private static String getExtraResultsKeyForData(String paramString)
  {
    return "android.remoteinput.dataTypeResultsData" + paramString;
  }
  
  static Bundle getResultsFromIntent(Intent paramIntent)
  {
    return RemoteInput.getResultsFromIntent(paramIntent);
  }
  
  static RemoteInputCompatBase.RemoteInput[] toCompat(RemoteInput[] paramArrayOfRemoteInput, RemoteInputCompatBase.RemoteInput.Factory paramFactory)
  {
    if (paramArrayOfRemoteInput == null) {
      return null;
    }
    RemoteInputCompatBase.RemoteInput[] arrayOfRemoteInput = paramFactory.newArray(paramArrayOfRemoteInput.length);
    int i = 0;
    while (i < paramArrayOfRemoteInput.length)
    {
      RemoteInput localRemoteInput = paramArrayOfRemoteInput[i];
      arrayOfRemoteInput[i] = paramFactory.build(localRemoteInput.getResultKey(), localRemoteInput.getLabel(), localRemoteInput.getChoices(), localRemoteInput.getAllowFreeFormInput(), localRemoteInput.getExtras(), null);
      i += 1;
    }
    return arrayOfRemoteInput;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/android/support/v4/app/RemoteInputCompatApi20.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */