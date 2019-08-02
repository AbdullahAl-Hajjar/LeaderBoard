package logic;


import dao.ScoreDAO;
import entity.Player;
import entity.Score;
import java.io.PrintWriter;
import java.time.Clock;
import java.time.Instant;
import java.time.LocalDate;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Gyp
 */
public class ScoreLogic extends GenericLogic<Score, ScoreDAO>
 {
    
    public static final String ID = "scoreid" ;
    public static final String SCORE  = "score";
    public static final String PLAYER_ID = "id";
    public static final String SUBMISSION =  "submission";
  
    
    public ScoreLogic()
    {
     super(new ScoreDAO());
    }
    
    
     public List<Score> getAll()
    {
        return get(()->dao().findAll());
    }

    public Score getById(int id)
    {
        return get(()->dao().findByID(id));
    }
    
    
    public List<Score> getScoresWith(int score)
    {
        return get(()->dao().findByScore(score));
    }


    public List<Score> getScoreOnDate(Date submission )
    {
        return get(()->dao().findBySubmission(submission ));
    }

    public List<Score> getScoresForPlayerID(int playerid)
    {
        return get(()->dao().findByPlayerID(playerid));
    }
    
     public Score createEntity(Map<String, String[]> parameterMap)
    {
        
        Score score = new Score();
        Date date = Date.from(Instant.now(Clock.systemDefaultZone()));
          PlayerLogic playerlogic = new PlayerLogic();
         
          
        if(parameterMap.isEmpty())
        {
           throw new NullPointerException();
        }
   
        else if(parameterMap.get(SCORE)[0].matches(".*[a-zA-Z]+.*"))
        {
            throw new IllegalArgumentException();
        }
        
        else if(parameterMap.containsKey(ID))
                {
                    score.setId(Integer.valueOf(parameterMap.get(ID)[0]));
                 }
        score.setScore(Integer.valueOf(parameterMap.get(SCORE)[0]));
              
      Player player = playerlogic.getPlayerWithId(Integer.valueOf(parameterMap.get(PLAYER_ID)[0]));    

          score.setPlayerid(player);
        score.setSubmission(date);
        
                
        return score;
    }
     
         public void deleteCourses(String[] entity)
    {
          ScoreLogic logic = new ScoreLogic();
            List<Score> list=  logic.getAll();

            for(int i = 0;i<entity.length ; i++)
            {
                if(entity[i] != null)
                {
                    String scoreID = entity[i];
                    
                    for(Score score : list)
                    {
                                  if(score.getPlayerid().getId().toString().equals(scoreID))
                                  {
                                      delete(score);
                                  }
                    }
                }      
            }
    
        }
         
   
     
    
}
