package com.b.c.h;

import com.b.b.p;
import com.b.c.g;

public class a
  extends g<b>
{
  public a(b paramb)
  {
    super(paramb);
  }
  
  public String getByLineDescription()
  {
    return ((b)this.a).getString(592);
  }
  
  public String getByLineTitleDescription()
  {
    return ((b)this.a).getString(597);
  }
  
  public String getCaptionDescription()
  {
    return ((b)this.a).getString(632);
  }
  
  public String getCategoryDescription()
  {
    return ((b)this.a).getString(527);
  }
  
  public String getCityDescription()
  {
    return ((b)this.a).getString(602);
  }
  
  public String getCopyrightNoticeDescription()
  {
    return ((b)this.a).getString(628);
  }
  
  public String getCountryOrPrimaryLocationDescription()
  {
    return ((b)this.a).getString(613);
  }
  
  public String getCreditDescription()
  {
    return ((b)this.a).getString(622);
  }
  
  public String getDateCreatedDescription()
  {
    return getDateDescription(567);
  }
  
  public String getDateDescription(int paramInt)
  {
    String str2 = ((b)this.a).getString(paramInt);
    String str1;
    if (str2 == null) {
      str1 = null;
    }
    do
    {
      return str1;
      str1 = str2;
    } while (str2.length() != 8);
    return str2.substring(0, 4) + ':' + str2.substring(4, 6) + ':' + str2.substring(6);
  }
  
  public String getDateSentDescription()
  {
    return getDateDescription(326);
  }
  
  public String getDescription(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return super.getDescription(paramInt);
    case 567: 
      return getDateCreatedDescription();
    case 574: 
      return getDigitalDateCreatedDescription();
    case 326: 
      return getDateSentDescription();
    case 549: 
      return getExpirationDateDescription();
    case 550: 
      return getExpirationTimeDescription();
    case 276: 
      return getFileFormatDescription();
    case 537: 
      return getKeywordsDescription();
    case 559: 
      return getReferenceDateDescription();
    case 542: 
      return getReleaseDateDescription();
    case 547: 
      return getReleaseTimeDescription();
    case 572: 
      return getTimeCreatedDescription();
    case 575: 
      return getDigitalTimeCreatedDescription();
    }
    return getTimeSentDescription();
  }
  
  public String getDigitalDateCreatedDescription()
  {
    return getDateDescription(574);
  }
  
  public String getDigitalTimeCreatedDescription()
  {
    return getTimeDescription(575);
  }
  
  public String getExpirationDateDescription()
  {
    return getDateDescription(549);
  }
  
  public String getExpirationTimeDescription()
  {
    return getTimeDescription(550);
  }
  
  public String getFileFormatDescription()
  {
    Integer localInteger = ((b)this.a).getInteger(276);
    if (localInteger == null) {
      return null;
    }
    switch (localInteger.intValue())
    {
    default: 
      return String.format("Unknown (%d)", new Object[] { localInteger });
    case 0: 
      return "No ObjectData";
    case 1: 
      return "IPTC-NAA Digital Newsphoto Parameter Record";
    case 2: 
      return "IPTC7901 Recommended Message Format";
    case 3: 
      return "Tagged Image File Format (Adobe/Aldus Image data)";
    case 4: 
      return "Illustrator (Adobe Graphics data)";
    case 5: 
      return "AppleSingle (Apple Computer Inc)";
    case 6: 
      return "NAA 89-3 (ANPA 1312)";
    case 7: 
      return "MacBinary II";
    case 8: 
      return "IPTC Unstructured Character Oriented File Format (UCOFF)";
    case 9: 
      return "United Press International ANPA 1312 variant";
    case 10: 
      return "United Press International Down-Load Message";
    case 11: 
      return "JPEG File Interchange (JFIF)";
    case 12: 
      return "Photo-CD Image-Pac (Eastman Kodak)";
    case 13: 
      return "Bit Mapped Graphics File [.BMP] (Microsoft)";
    case 14: 
      return "Digital Audio File [.WAV] (Microsoft & Creative Labs)";
    case 15: 
      return "Audio plus Moving Video [.AVI] (Microsoft)";
    case 16: 
      return "PC DOS/Windows Executable Files [.COM][.EXE]";
    case 17: 
      return "Compressed Binary File [.ZIP] (PKWare Inc)";
    case 18: 
      return "Audio Interchange File Format AIFF (Apple Computer Inc)";
    case 19: 
      return "RIFF Wave (Microsoft Corporation)";
    case 20: 
      return "Freehand (Macromedia/Aldus)";
    case 21: 
      return "Hypertext Markup Language [.HTML] (The Internet Society)";
    case 22: 
      return "MPEG 2 Audio Layer 2 (Musicom), ISO/IEC";
    case 23: 
      return "MPEG 2 Audio Layer 3, ISO/IEC";
    case 24: 
      return "Portable Document File [.PDF] Adobe";
    case 25: 
      return "News Industry Text Format (NITF)";
    case 26: 
      return "Tape Archive [.TAR]";
    case 27: 
      return "Tidningarnas Telegrambyra NITF version (TTNITF DTD)";
    case 28: 
      return "Ritzaus Bureau NITF version (RBNITF DTD)";
    }
    return "Corel Draw [.CDR]";
  }
  
  public String getHeadlineDescription()
  {
    return ((b)this.a).getString(617);
  }
  
  public String getKeywordsDescription()
  {
    String[] arrayOfString = ((b)this.a).getStringArray(537);
    if (arrayOfString == null) {
      return null;
    }
    return p.join(arrayOfString, ";");
  }
  
  public String getObjectNameDescription()
  {
    return ((b)this.a).getString(517);
  }
  
  public String getOriginalTransmissionReferenceDescription()
  {
    return ((b)this.a).getString(615);
  }
  
  public String getOriginatingProgramDescription()
  {
    return ((b)this.a).getString(577);
  }
  
  public String getProvinceOrStateDescription()
  {
    return ((b)this.a).getString(607);
  }
  
  public String getRecordVersionDescription()
  {
    return ((b)this.a).getString(512);
  }
  
  public String getReferenceDateDescription()
  {
    return getDateDescription(559);
  }
  
  public String getReleaseDateDescription()
  {
    return getDateDescription(542);
  }
  
  public String getReleaseTimeDescription()
  {
    return getTimeDescription(547);
  }
  
  public String getSourceDescription()
  {
    return ((b)this.a).getString(627);
  }
  
  public String getSpecialInstructionsDescription()
  {
    return ((b)this.a).getString(552);
  }
  
  public String getSupplementalCategoriesDescription()
  {
    return ((b)this.a).getString(532);
  }
  
  public String getTimeCreatedDescription()
  {
    return getTimeDescription(572);
  }
  
  public String getTimeDescription(int paramInt)
  {
    String str2 = ((b)this.a).getString(paramInt);
    String str1;
    if (str2 == null) {
      str1 = null;
    }
    do
    {
      return str1;
      if (str2.length() == 6) {
        break;
      }
      str1 = str2;
    } while (str2.length() != 11);
    return str2.substring(0, 2) + ':' + str2.substring(2, 4) + ':' + str2.substring(4);
  }
  
  public String getTimeSentDescription()
  {
    return getTimeDescription(336);
  }
  
  public String getUrgencyDescription()
  {
    return ((b)this.a).getString(522);
  }
  
  public String getWriterDescription()
  {
    return ((b)this.a).getString(634);
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes-dex2jar.jar!/com/b/c/h/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */