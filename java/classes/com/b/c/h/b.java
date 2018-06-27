package com.b.c.h;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class b
  extends com.b.c.b
{
  protected static final HashMap<Integer, String> e = new HashMap();
  
  static
  {
    e.put(Integer.valueOf(256), "Enveloped Record Version");
    e.put(Integer.valueOf(261), "Destination");
    e.put(Integer.valueOf(276), "File Format");
    e.put(Integer.valueOf(278), "File Version");
    e.put(Integer.valueOf(286), "Service Identifier");
    e.put(Integer.valueOf(296), "Envelope Number");
    e.put(Integer.valueOf(306), "Product Identifier");
    e.put(Integer.valueOf(316), "Envelope Priority");
    e.put(Integer.valueOf(326), "Date Sent");
    e.put(Integer.valueOf(336), "Time Sent");
    e.put(Integer.valueOf(346), "Coded Character Set");
    e.put(Integer.valueOf(356), "Unique Object Name");
    e.put(Integer.valueOf(376), "ARM Identifier");
    e.put(Integer.valueOf(378), "ARM Version");
    e.put(Integer.valueOf(512), "Application Record Version");
    e.put(Integer.valueOf(515), "Object Type Reference");
    e.put(Integer.valueOf(516), "Object Attribute Reference");
    e.put(Integer.valueOf(517), "Object Name");
    e.put(Integer.valueOf(519), "Edit Status");
    e.put(Integer.valueOf(520), "Editorial Update");
    e.put(Integer.valueOf(522), "Urgency");
    e.put(Integer.valueOf(524), "Subject Reference");
    e.put(Integer.valueOf(527), "Category");
    e.put(Integer.valueOf(532), "Supplemental Category(s)");
    e.put(Integer.valueOf(534), "Fixture Identifier");
    e.put(Integer.valueOf(537), "Keywords");
    e.put(Integer.valueOf(538), "Content Location Code");
    e.put(Integer.valueOf(539), "Content Location Name");
    e.put(Integer.valueOf(542), "Release Date");
    e.put(Integer.valueOf(547), "Release Time");
    e.put(Integer.valueOf(549), "Expiration Date");
    e.put(Integer.valueOf(550), "Expiration Time");
    e.put(Integer.valueOf(552), "Special Instructions");
    e.put(Integer.valueOf(554), "Action Advised");
    e.put(Integer.valueOf(557), "Reference Service");
    e.put(Integer.valueOf(559), "Reference Date");
    e.put(Integer.valueOf(562), "Reference Number");
    e.put(Integer.valueOf(567), "Date Created");
    e.put(Integer.valueOf(572), "Time Created");
    e.put(Integer.valueOf(574), "Digital Date Created");
    e.put(Integer.valueOf(575), "Digital Time Created");
    e.put(Integer.valueOf(577), "Originating Program");
    e.put(Integer.valueOf(582), "Program Version");
    e.put(Integer.valueOf(587), "Object Cycle");
    e.put(Integer.valueOf(592), "By-line");
    e.put(Integer.valueOf(597), "By-line Title");
    e.put(Integer.valueOf(602), "City");
    e.put(Integer.valueOf(604), "Sub-location");
    e.put(Integer.valueOf(607), "Province/State");
    e.put(Integer.valueOf(612), "Country/Primary Location Code");
    e.put(Integer.valueOf(613), "Country/Primary Location Name");
    e.put(Integer.valueOf(615), "Original Transmission Reference");
    e.put(Integer.valueOf(617), "Headline");
    e.put(Integer.valueOf(622), "Credit");
    e.put(Integer.valueOf(627), "Source");
    e.put(Integer.valueOf(628), "Copyright Notice");
    e.put(Integer.valueOf(630), "Contact");
    e.put(Integer.valueOf(632), "Caption/Abstract");
    e.put(Integer.valueOf(633), "Local Caption");
    e.put(Integer.valueOf(634), "Caption Writer/Editor");
    e.put(Integer.valueOf(637), "Rasterized Caption");
    e.put(Integer.valueOf(642), "Image Type");
    e.put(Integer.valueOf(643), "Image Orientation");
    e.put(Integer.valueOf(647), "Language Identifier");
    e.put(Integer.valueOf(662), "Audio Type");
    e.put(Integer.valueOf(663), "Audio Sampling Rate");
    e.put(Integer.valueOf(664), "Audio Sampling Resolution");
    e.put(Integer.valueOf(665), "Audio Duration");
    e.put(Integer.valueOf(666), "Audio Outcue");
    e.put(Integer.valueOf(696), "Job Identifier");
    e.put(Integer.valueOf(697), "Master Document Identifier");
    e.put(Integer.valueOf(698), "Short Document Identifier");
    e.put(Integer.valueOf(699), "Unique Document Identifier");
    e.put(Integer.valueOf(700), "Owner Identifier");
    e.put(Integer.valueOf(712), "Object Data Preview File Format");
    e.put(Integer.valueOf(713), "Object Data Preview File Format Version");
    e.put(Integer.valueOf(714), "Object Data Preview Data");
  }
  
  public b()
  {
    setDescriptor(new a(this));
  }
  
  private Date a(int paramInt1, int paramInt2)
  {
    Object localObject = getString(paramInt1);
    String str = getString(paramInt2);
    if (localObject == null) {}
    while (str == null) {
      return null;
    }
    try
    {
      localObject = new SimpleDateFormat("yyyyMMddHHmmssZ").parse((String)localObject + str);
      return (Date)localObject;
    }
    catch (ParseException localParseException) {}
    return null;
  }
  
  protected HashMap<Integer, String> a()
  {
    return e;
  }
  
  public Date getDateCreated()
  {
    return a(567, 572);
  }
  
  public Date getDateSent()
  {
    return a(326, 336);
  }
  
  public Date getDigitalDateCreated()
  {
    return a(574, 575);
  }
  
  public Date getExpirationDate()
  {
    return a(549, 550);
  }
  
  public List<String> getKeywords()
  {
    String[] arrayOfString = getStringArray(537);
    if (arrayOfString == null) {
      return null;
    }
    return Arrays.asList(arrayOfString);
  }
  
  public String getName()
  {
    return "IPTC";
  }
  
  public Date getReleaseDate()
  {
    return a(542, 547);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/b/c/h/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */