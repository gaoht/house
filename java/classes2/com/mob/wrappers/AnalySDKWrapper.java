package com.mob.wrappers;

import com.mob.analysdk.AnalySDK;
import com.mob.analysdk.User;
import com.mob.analysdk.User.Gender;
import com.mob.tools.proguard.PublicMemberKeeper;
import com.mob.tools.utils.ReflectHelper;
import java.util.Date;
import java.util.HashMap;

public class AnalySDKWrapper
  implements PublicMemberKeeper
{
  private static int state;
  
  public static User identifyUser()
  {
    return new User(null);
  }
  
  private static boolean isAvailable()
  {
    boolean bool = true;
    for (;;)
    {
      try
      {
        int i = state;
        if (i == 0) {}
        try
        {
          ReflectHelper.importClass("com.mob.analysdk.AnalySDK");
          state = 1;
          i = state;
          if (i == 1) {
            return bool;
          }
        }
        catch (Throwable localThrowable)
        {
          state = -1;
          continue;
        }
        bool = false;
      }
      finally {}
    }
  }
  
  public static Location setLocation()
  {
    return new Location(null);
  }
  
  public static Event trackEvent()
  {
    return new Event(null);
  }
  
  private static abstract interface Committer
  {
    public abstract void commit();
  }
  
  public static final class Event
    extends AnalySDKWrapper.MapCreator<Event, String, Object>
    implements PublicMemberKeeper
  {
    private String eventName;
    
    public void commit()
    {
      if (AnalySDKWrapper.access$300())
      {
        if (this.map.isEmpty()) {
          AnalySDK.trackEvent(this.eventName);
        }
      }
      else {
        return;
      }
      AnalySDK.trackEvent(this.eventName, this.map);
    }
    
    public Event withName(String paramString)
    {
      this.eventName = paramString;
      return this;
    }
  }
  
  public static enum GenderWrapper
  {
    Man,  Woman;
    
    private GenderWrapper() {}
  }
  
  public static final class Location
    implements PublicMemberKeeper, AnalySDKWrapper.Committer
  {
    private double latitude;
    private double longitude;
    
    public void commit()
    {
      if (AnalySDKWrapper.access$300()) {
        AnalySDK.setLocation(this.longitude, this.latitude);
      }
    }
    
    public Location latitude(double paramDouble)
    {
      this.latitude = paramDouble;
      return this;
    }
    
    public Location longitude(double paramDouble)
    {
      this.longitude = paramDouble;
      return this;
    }
  }
  
  private static abstract class MapCreator<SubClass extends MapCreator, K, V>
    implements AnalySDKWrapper.Committer
  {
    protected HashMap<K, V> map = new HashMap();
    
    public AnalySDKWrapper.MapItem<SubClass, K, V> setField(K paramK)
    {
      return new AnalySDKWrapper.MapItem(this, paramK, null);
    }
  }
  
  public static final class MapItem<CreatorClass extends AnalySDKWrapper.MapCreator, K, V>
    implements PublicMemberKeeper
  {
    private AnalySDKWrapper.MapCreator creator;
    private K fieldName;
    
    private MapItem(AnalySDKWrapper.MapCreator paramMapCreator, K paramK)
    {
      this.creator = paramMapCreator;
      this.fieldName = paramK;
    }
    
    public CreatorClass widthValue(V paramV)
    {
      this.creator.map.put(this.fieldName, paramV);
      return this.creator;
    }
  }
  
  public static final class User
    extends AnalySDKWrapper.MapCreator<User, String, String>
    implements PublicMemberKeeper
  {
    private Date birthday;
    private String city;
    private String country;
    private Date firstAccessTime;
    private AnalySDKWrapper.GenderWrapper gender;
    private String name;
    private String province;
    private long registryTime;
    private String retistryChannel;
    private String userId;
    
    public void commit()
    {
      User localUser;
      if (AnalySDKWrapper.access$300())
      {
        localUser = new User();
        localUser.name = this.name;
        localUser.birthday = this.birthday;
        if (this.gender != AnalySDKWrapper.GenderWrapper.Man) {
          break label112;
        }
        localUser.gender = User.Gender.Man;
      }
      for (;;)
      {
        localUser.firstAccessTime = this.firstAccessTime;
        localUser.retistryChannel = this.retistryChannel;
        localUser.country = this.country;
        localUser.province = this.province;
        localUser.city = this.city;
        localUser.registryTime = this.registryTime;
        localUser.others = this.map;
        AnalySDK.identifyUser(this.userId, localUser);
        return;
        label112:
        if (this.gender == AnalySDKWrapper.GenderWrapper.Woman) {
          localUser.gender = User.Gender.Woman;
        }
      }
    }
    
    public User setBirthday(Date paramDate)
    {
      this.birthday = paramDate;
      return this;
    }
    
    public User setCity(String paramString)
    {
      this.city = paramString;
      return this;
    }
    
    public User setCountry(String paramString)
    {
      this.country = paramString;
      return this;
    }
    
    public User setFirstAccessTime(Date paramDate)
    {
      this.firstAccessTime = paramDate;
      return this;
    }
    
    public User setGender(AnalySDKWrapper.GenderWrapper paramGenderWrapper)
    {
      this.gender = paramGenderWrapper;
      return this;
    }
    
    public User setName(String paramString)
    {
      this.name = paramString;
      return this;
    }
    
    public User setProvince(String paramString)
    {
      this.province = paramString;
      return this;
    }
    
    public User setRegistryTime(long paramLong)
    {
      this.registryTime = paramLong;
      return this;
    }
    
    public User setRetistryChannel(String paramString)
    {
      this.retistryChannel = paramString;
      return this;
    }
    
    public User withID(String paramString)
    {
      this.userId = paramString;
      return this;
    }
  }
}


/* Location:              /Users/gaoht/Downloads/zirom/classes2-dex2jar.jar!/com/mob/wrappers/AnalySDKWrapper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */