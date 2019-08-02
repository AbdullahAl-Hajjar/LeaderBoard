package logic;

import dao.PlayerDAO;
import entity.Player;
import entity.Username;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Clock;
import java.time.Instant;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.eclipse.jdt.core.compiler.InvalidInputException;


/**
 *
 * @author Gyp
 */
public class PlayerLogic extends GenericLogic<Player, PlayerDAO>
{ 
    public static final String ID  = "id";
    public static final String FIRST_NAME = "firstName";
    public static final String LAST_NAME = "lastName";
    public static final String JOINED = "joined";
    public static final String EMAIL = "email";
   

    public PlayerLogic()
    {
     super(new PlayerDAO());
    }
    

    public List<Player> getAllPlayers()
    {
        return get(() ->dao().findAll());
    }

    public Player getPlayerWithId(int id)
    {
        return get(()->dao().findByID(id));
    }
    
    
    public List<Player> getPlayersWithFirstName(String firstName)
    {
        return get(()->dao().findByFirstName(firstName));
    }

    public List<Player> getPlayersWIthLastName(String lastName)
    {
        return get(()->dao().findByLastName(lastName));
    }

    public List<Player> getPlayersJoinedOn(Date date)
    {
        return get(()->dao().findByJoined(date));
    }

    public Player getPlayerWithEmail(String email)
    {
        return get(()->dao().findByEmail(email));
    }


    @Override
    public Player createEntity(Map<String, String[]> parameterMap)
    {
        Player player = new Player();
        Date date = Date.from(Instant.now(Clock.systemDefaultZone()));
        
        String regex = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
        Pattern pattern = Pattern.compile(regex);
         Matcher matcher = pattern.matcher( parameterMap.get(EMAIL)[0]);
        
        //https://howtodoinjava.com/regex/java-regex-validate-email-address/ regex String pattern source 
        
        if(parameterMap.get(FIRST_NAME)[0].isEmpty()
       || parameterMap.get(LAST_NAME)[0].isEmpty())
        {
            throw new NullPointerException();
        }
        
        else if(parameterMap.get(FIRST_NAME)[0].matches("[0-9]+") 
                || parameterMap.get(LAST_NAME)[0].matches("[0-9]+")
                || parameterMap.get(FIRST_NAME)[0].length() > 45
                ||parameterMap.get(LAST_NAME)[0].length() > 45) 
        {
            throw new NullPointerException();
        }
        
        else if(parameterMap.get(EMAIL)[0].length() >= 60
                || matcher.matches() == false
                || parameterMap.get(ID)[0].matches(".*[a-zA-Z]+.*"))
        {
            throw new IllegalArgumentException();
        }
            
         else  if(parameterMap.containsKey(ID))
                {
                   player.setId(Integer.valueOf(parameterMap.get(ID)[0]));
                }
        player.setFirstName(parameterMap.get(FIRST_NAME)[0]); 
        player.setLastName(parameterMap.get(LAST_NAME)[0]); 
     player.setEmail(parameterMap.get(EMAIL)[0]);
     
     if(parameterMap.containsKey(JOINED))
     {      try
         {
           SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
         date = formatter.parse(parameterMap.get(JOINED)[0]);
        player.setJoined(date); 
         }catch (ParseException e) 
         {
     }
       
     }
     else
     {
    player.setJoined(date);
     }
     
        return player;
    }
    
    
    public void deleteCourses(String[] entity)
    {
          PlayerLogic logic = new PlayerLogic();
            List<Player> list=  logic.getAllPlayers();

            for(int i = 0;i<entity.length ; i++)
            {
                if(entity[i] != null)
                {
                    String playerID = entity[i];
                    
                    for(Player player : list)
                    {
                                  if(player.getId().toString().equals(playerID))
                                  {
                                      delete(player);
                                  }
                    }
                }      
            }
    
        }
    
}
