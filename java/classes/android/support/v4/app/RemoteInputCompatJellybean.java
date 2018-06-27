package android.support.v4.app;

import android.content.ClipData;
import android.content.ClipData.Item;
import android.content.ClipDescription;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

class RemoteInputCompatJellybean
{
  private static final String EXTRA_DATA_TYPE_RESULTS_DATA = "android.remoteinput.dataTypeResultsData";
  private static final String KEY_ALLOWED_DATA_TYPES = "allowedDataTypes";
  private static final String KEY_ALLOW_FREE_FORM_INPUT = "allowFreeFormInput";
  private static final String KEY_CHOICES = "choices";
  private static final String KEY_EXTRAS = "extras";
  private static final String KEY_LABEL = "label";
  private static final String KEY_RESULT_KEY = "resultKey";
  
  public static void addDataResultToIntent(RemoteInput paramRemoteInput, Intent paramIntent, Map<String, Uri> paramMap)
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
    Intent localIntent = getClipDataIntentFromIntent(paramIntent);
    if (localIntent == null) {
      localIntent = new Intent();
    }
    for (;;)
    {
      Bundle localBundle = localIntent.getBundleExtra("android.remoteinput.resultsData");
      if (localBundle == null) {
        localBundle = new Bundle();
      }
      for (;;)
      {
        int j = paramArrayOfRemoteInput.length;
        int i = 0;
        while (i < j)
        {
          RemoteInputCompatBase.RemoteInput localRemoteInput = paramArrayOfRemoteInput[i];
          Object localObject = paramBundle.get(localRemoteInput.getResultKey());
          if ((localObject instanceof CharSequence)) {
            localBundle.putCharSequence(localRemoteInput.getResultKey(), (CharSequence)localObject);
          }
          i += 1;
        }
        localIntent.putExtra("android.remoteinput.resultsData", localBundle);
        paramIntent.setClipData(ClipData.newIntent("android.remoteinput.results", localIntent));
        return;
      }
    }
  }
  
  static RemoteInputCompatBase.RemoteInput fromBundle(Bundle paramBundle, RemoteInputCompatBase.RemoteInput.Factory paramFactory)
  {
    Object localObject = paramBundle.getStringArrayList("allowedDataTypes");
    HashSet localHashSet = new HashSet();
    if (localObject != null)
    {
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        localHashSet.add((String)((Iterator)localObject).next());
      }
    }
    return paramFactory.build(paramBundle.getString("resultKey"), paramBundle.getCharSequence("label"), paramBundle.getCharSequenceArray("choices"), paramBundle.getBoolean("allowFreeFormInput"), paramBundle.getBundle("extras"), localHashSet);
  }
  
  static RemoteInputCompatBase.RemoteInput[] fromBundleArray(Bundle[] paramArrayOfBundle, RemoteInputCompatBase.RemoteInput.Factory paramFactory)
  {
    if (paramArrayOfBundle == null) {
      return null;
    }
    RemoteInputCompatBase.RemoteInput[] arrayOfRemoteInput = paramFactory.newArray(paramArrayOfBundle.length);
    int i = 0;
    while (i < paramArrayOfBundle.length)
    {
      arrayOfRemoteInput[i] = fromBundle(paramArrayOfBundle[i], paramFactory);
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
    paramIntent = getClipDataIntentFromIntent(paramIntent);
    if (paramIntent == null) {
      return null;
    }
    return (Bundle)paramIntent.getExtras().getParcelable("android.remoteinput.resultsData");
  }
  
  static Bundle toBundle(RemoteInputCompatBase.RemoteInput paramRemoteInput)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("resultKey", paramRemoteInput.getResultKey());
    localBundle.putCharSequence("label", paramRemoteInput.getLabel());
    localBundle.putCharSequenceArray("choices", paramRemoteInput.getChoices());
    localBundle.putBoolean("allowFreeFormInput", paramRemoteInput.getAllowFreeFormInput());
    localBundle.putBundle("extras", paramRemoteInput.getExtras());
    Object localObject = paramRemoteInput.getAllowedDataTypes();
    if ((localObject != null) && (!((Set)localObject).isEmpty()))
    {
      paramRemoteInput = new ArrayList(((Set)localObject).size());
      localObject = ((Set)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        paramRemoteInput.add((String)((Iterator)localObject).next());
      }
      localBundle.putStringArrayList("allowedDataTypes", paramRemoteInput);
    }
    return localBundle;
  }
  
  static Bundle[] toBundleArray(RemoteInputCompatBase.RemoteInput[] paramArrayOfRemoteInput)
  {
    if (paramArrayOfRemoteInput == null) {
      return null;
    }
    Bundle[] arrayOfBundle = new Bundle[paramArrayOfRemoteInput.length];
    int i = 0;
    while (i < paramArrayOfRemoteInput.length)
    {
      arrayOfBundle[i] = toBundle(paramArrayOfRemoteInput[i]);
      i += 1;
    }
    return arrayOfBundle;
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/android/support/v4/app/RemoteInputCompatJellybean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */