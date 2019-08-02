package dao;

import entity.Player;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Gyp
 */
public class PlayerDAO extends GenericDAO<Player>
{

    public PlayerDAO() 
    {
        super(Player.class);
    }

    public List<Player>  findAll()
    {
        return findResults("Player.findAll", null);
    }

    public Player findByID( int id){
        Map<String, Object> map = new HashMap<>();
        map.put("id", id);
        return findResult( "Player.findById", map);
    }
 
    public  List<Player> findByFirstName(String firstName)
    {
        Map<String, Object>map = new HashMap<>();
        map.put("first_name", firstName);
        return findResults("Player.findByFirstName", map);
    }


    public List<Player> findByLastName(String lastName )
    {
        Map<String, Object>map = new HashMap<>();
        map.put("last_name", lastName);
        return findResults("Player.findByLastName", map);
    } 
    
    public List<Player> findByJoined(Date date)
    {
        Map<String, Object>map = new HashMap<>();
        map.put("joined", date);
        return findResults("Player.findByJoined", map);
    } 
    
       public Player findByEmail(String email)
    {
        Map<String, Object>map = new HashMap<>();
        map.put("email", email);
        return findResult("Player.findByEmail", map);
    } 
    
}
