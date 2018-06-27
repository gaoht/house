package com.hyphenate.chat;

import com.hyphenate.util.EMLog;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

public class MessageEncoder
{
  public static final String ATTR_ACTION = "action";
  public static final String ATTR_ADDRESS = "addr";
  public static final String ATTR_EXT = "ext";
  public static final String ATTR_FILENAME = "filename";
  public static final String ATTR_FILE_LENGTH = "file_length";
  public static final String ATTR_FROM = "from";
  public static final String ATTR_IMG_HEIGHT = "height";
  public static final String ATTR_IMG_WIDTH = "width";
  public static final String ATTR_LATITUDE = "lat";
  public static final String ATTR_LENGTH = "length";
  public static final String ATTR_LOCALURL = "localurl";
  public static final String ATTR_LONGITUDE = "lng";
  public static final String ATTR_MSG = "msg";
  public static final String ATTR_PARAM = "param";
  public static final String ATTR_SECRET = "secret";
  public static final String ATTR_SIZE = "size";
  public static final String ATTR_THUMBNAIL = "thumb";
  public static final String ATTR_THUMBNAIL_SECRET = "thumb_secret";
  public static final String ATTR_THUMB_LOCALURL = "thumblocalurl";
  public static final String ATTR_TO = "to";
  public static final String ATTR_TYPE = "type";
  private static final String ATTR_TYPE_CMD = "cmd";
  private static final String ATTR_TYPE_IMG = "img";
  private static final String ATTR_TYPE_LOCATION = "loc";
  private static final String ATTR_TYPE_TXT = "txt";
  private static final String ATTR_TYPE_VIDEO = "video";
  private static final String ATTR_TYPE_VOICE = "audio";
  private static final String ATTR_TYPE_file = "file";
  public static final String ATTR_URL = "url";
  private static final String TAG = "encoder";
  
  public static EMMessage getMsgFromJson(String paramString)
  {
    Object localObject3;
    Object localObject4;
    JSONObject localJSONObject;
    Object localObject2;
    for (;;)
    {
      try
      {
        localObject3 = new JSONObject(paramString);
        localObject4 = new EMContact(((JSONObject)localObject3).getString("from"));
        EMContact localEMContact = new EMContact(((JSONObject)localObject3).getString("to"));
        paramString = ((JSONObject)localObject3).getJSONArray("bodies");
        if (paramString.length() < 1)
        {
          EMLog.d("encoder", "wrong msg without body");
          return null;
        }
        localJSONObject = paramString.getJSONObject(0);
        localObject1 = localJSONObject.getString("type");
        paramString = EMMessage.Type.TXT;
        if (((String)localObject1).equals("txt"))
        {
          paramString = EMMessage.Type.TXT;
          if (!((EMContact)localObject4).username.equals(EMClient.getInstance().getCurrentUser())) {
            break label344;
          }
          paramString = EMMessage.createSendMessage(paramString);
          if (!((String)localObject1).equals("txt")) {
            break;
          }
          paramString.addBody(new EMTextMessageBody(localJSONObject.getString("msg").replaceAll("%22", "\"")));
          if (paramString != null)
          {
            paramString.setFrom(((EMContact)localObject4).getUsername());
            paramString.setTo(localEMContact.getUsername());
          }
          if (!((JSONObject)localObject3).has("ext")) {
            break label1076;
          }
          localObject1 = ((JSONObject)localObject3).getJSONObject("ext");
          localObject2 = ((JSONObject)localObject1).keys();
          label194:
          if (!((Iterator)localObject2).hasNext()) {
            break label1076;
          }
          localObject3 = (String)((Iterator)localObject2).next();
          localObject4 = ((JSONObject)localObject1).get((String)localObject3);
          if (!(localObject4 instanceof String)) {
            break label951;
          }
          paramString.setAttribute((String)localObject3, (String)localObject4);
          continue;
        }
        if (!((String)localObject1).equals("img")) {
          break label264;
        }
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        return null;
      }
      paramString = EMMessage.Type.IMAGE;
      continue;
      label264:
      if (((String)localObject1).equals("file"))
      {
        paramString = EMMessage.Type.FILE;
      }
      else if (((String)localObject1).equals("video"))
      {
        paramString = EMMessage.Type.VIDEO;
      }
      else if (((String)localObject1).equals("audio"))
      {
        paramString = EMMessage.Type.VOICE;
      }
      else if (((String)localObject1).equals("loc"))
      {
        paramString = EMMessage.Type.LOCATION;
      }
      else if (((String)localObject1).equals("cmd"))
      {
        paramString = EMMessage.Type.CMD;
        continue;
        label344:
        paramString = EMMessage.createReceiveMessage(paramString);
      }
    }
    String str;
    if (((String)localObject1).equals("img"))
    {
      localObject2 = localJSONObject.getString("url");
      str = localJSONObject.getString("filename");
      if (!localJSONObject.has("thumb")) {
        break label1078;
      }
    }
    label951:
    label1076:
    label1078:
    for (Object localObject1 = localJSONObject.getString("thumb");; localObject1 = localObject2)
    {
      localObject1 = new EMImageMessageBody(str, (String)localObject2, (String)localObject1);
      if (localJSONObject.has("localurl")) {
        ((EMImageMessageBody)localObject1).setLocalUrl(localJSONObject.getString("localurl"));
      }
      if (localJSONObject.has("secret")) {
        ((EMImageMessageBody)localObject1).setSecret(localJSONObject.getString("secret"));
      }
      if (localJSONObject.has("thumb_secret")) {
        ((EMImageMessageBody)localObject1).setThumbnailSecret(localJSONObject.getString("thumb_secret"));
      }
      if (localJSONObject.has("size"))
      {
        localObject2 = localJSONObject.getJSONObject("size");
        ((EMImageMessageBody)localObject1).setSize(((JSONObject)localObject2).getInt("width"), ((JSONObject)localObject2).getInt("height"));
      }
      paramString.addBody((EMMessageBody)localObject1);
      break;
      if (((String)localObject1).equals("file"))
      {
        localObject1 = localJSONObject.getString("url");
        localObject1 = new EMNormalFileMessageBody(localJSONObject.getString("filename"), (String)localObject1);
        ((EMNormalFileMessageBody)localObject1).setFileLength(Integer.parseInt(localJSONObject.getString("file_length")));
        if (localJSONObject.has("localurl")) {
          ((EMNormalFileMessageBody)localObject1).setLocalUrl(localJSONObject.getString("localurl"));
        }
        if (localJSONObject.has("secret")) {
          ((EMNormalFileMessageBody)localObject1).setSecret(localJSONObject.getString("secret"));
        }
        paramString.addBody((EMMessageBody)localObject1);
        break;
      }
      if (((String)localObject1).equals("video"))
      {
        localObject1 = localJSONObject.getString("url");
        localObject1 = new EMVideoMessageBody(localJSONObject.getString("filename"), (String)localObject1, localJSONObject.getString("thumb"), localJSONObject.getInt("length"));
        if (localJSONObject.has("localurl")) {
          ((EMVideoMessageBody)localObject1).setLocalUrl(localJSONObject.getString("localurl"));
        }
        if (localJSONObject.has("file_length")) {
          ((EMVideoMessageBody)localObject1).setFileLength(localJSONObject.getLong("file_length"));
        }
        if (localJSONObject.has("thumblocalurl")) {
          ((EMVideoMessageBody)localObject1).setLocalThumb(localJSONObject.getString("thumblocalurl"));
        }
        if (localJSONObject.has("secret")) {
          ((EMVideoMessageBody)localObject1).setSecret(localJSONObject.getString("secret"));
        }
        if (localJSONObject.has("thumb_secret")) {
          ((EMVideoMessageBody)localObject1).setThumbnailSecret(localJSONObject.getString("thumb_secret"));
        }
        if (localJSONObject.has("size"))
        {
          localObject2 = localJSONObject.getJSONObject("size");
          ((EMVideoMessageBody)localObject1).setThumbnailSize(((JSONObject)localObject2).getInt("width"), ((JSONObject)localObject2).getInt("height"));
        }
        paramString.addBody((EMMessageBody)localObject1);
        break;
      }
      if (((String)localObject1).equals("audio"))
      {
        localObject1 = localJSONObject.getString("url");
        localObject1 = new EMVoiceMessageBody(localJSONObject.getString("filename"), (String)localObject1, localJSONObject.getInt("length"));
        if (localJSONObject.has("localurl")) {
          ((EMVoiceMessageBody)localObject1).setLocalUrl(localJSONObject.getString("localurl"));
        }
        if (localJSONObject.has("secret")) {
          ((EMVoiceMessageBody)localObject1).setSecret(localJSONObject.getString("secret"));
        }
        paramString.addBody((EMMessageBody)localObject1);
        break;
      }
      if (((String)localObject1).equals("loc"))
      {
        paramString.addBody(new EMLocationMessageBody(localJSONObject.getString("addr"), localJSONObject.getDouble("lat"), localJSONObject.getDouble("lng")));
        break;
      }
      if (!((String)localObject1).equals("cmd")) {
        break;
      }
      break;
      if ((localObject4 instanceof Integer))
      {
        paramString.setAttribute((String)localObject3, ((Integer)localObject4).intValue());
        break label194;
      }
      if ((localObject4 instanceof Boolean))
      {
        paramString.setAttribute((String)localObject3, ((Boolean)localObject4).booleanValue());
        break label194;
      }
      if ((localObject4 instanceof JSONObject))
      {
        paramString.setAttribute((String)localObject3, (JSONObject)localObject4);
        break label194;
      }
      if ((localObject4 instanceof JSONArray))
      {
        paramString.setAttribute((String)localObject3, (JSONArray)localObject4);
        break label194;
      }
      EMLog.e("msg", "unknow additonal msg attr:" + localObject4.getClass().getName());
      break label194;
      return paramString;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/hyphenate/chat/MessageEncoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */