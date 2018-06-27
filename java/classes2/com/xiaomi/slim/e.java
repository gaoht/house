package com.xiaomi.slim;

import com.xiaomi.smack.l;
import com.xiaomi.smack.packet.d;
import java.io.ByteArrayInputStream;
import java.io.InputStreamReader;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

public class e
{
  private XmlPullParser a;
  
  e()
  {
    try
    {
      this.a = XmlPullParserFactory.newInstance().newPullParser();
      this.a.setFeature("http://xmlpull.org/v1/doc/features.html#process-namespaces", true);
      return;
    }
    catch (XmlPullParserException localXmlPullParserException) {}
  }
  
  d a(byte[] paramArrayOfByte, com.xiaomi.smack.a parama)
  {
    this.a.setInput(new InputStreamReader(new ByteArrayInputStream(paramArrayOfByte)));
    this.a.next();
    int i = this.a.getEventType();
    paramArrayOfByte = this.a.getName();
    if (i == 2)
    {
      if (paramArrayOfByte.equals("message")) {
        return com.xiaomi.smack.util.a.a(this.a);
      }
      if (paramArrayOfByte.equals("iq")) {
        return com.xiaomi.smack.util.a.a(this.a, parama);
      }
      if (paramArrayOfByte.equals("presence")) {
        return com.xiaomi.smack.util.a.b(this.a);
      }
      if (!this.a.getName().equals("stream")) {
        break label130;
      }
    }
    for (;;)
    {
      return null;
      label130:
      if (this.a.getName().equals("error")) {
        throw new l(com.xiaomi.smack.util.a.c(this.a));
      }
      if (this.a.getName().equals("warning"))
      {
        this.a.next();
        if (!this.a.getName().equals("multi-login")) {}
      }
      else if (!this.a.getName().equals("bind")) {}
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/xiaomi/slim/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */