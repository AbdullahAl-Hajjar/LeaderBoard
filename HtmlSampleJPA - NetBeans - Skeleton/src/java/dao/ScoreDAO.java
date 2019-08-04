
package dao;

import entity.Score;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



public class ScoreDAO extends GenericDAO<Score>
{

    public ScoreDAO() 
    {
        super(Score.class);
    }
    
    
    public List<Score> findAll()
    {
        return findResults("Score.findAll", null);
    }
    

    
    public Score findByID( int id){
        Map<String, Object> map = new HashMap<>();
        map.put("id", id);
        return findResult( "Score.findById", map);
    }
 
   
    
    public  List<Score> findByScore(int score)
    {
        Map<String, Object>map = new HashMap<>();
        map.put("first_name", score);
        return findResults("Score.findByScore", map);
    }

    
    public List<Score> findBySubmission(Date date)
    {
        Map<String, Object>map = new HashMap<>();
        map.put("submission", date);
        return findResults("Score.findBySubmission", map);
    } 
    
       public List<Score> findByPlayerID(int playerid)
    {
        Map<String, Object>map = new HashMap<>();
        map.put("Player_id", playerid);
        return findResults("findByPlayerID", map);
    } 
    
}
