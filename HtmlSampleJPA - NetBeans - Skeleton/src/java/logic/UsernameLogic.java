package logic;


import dao.UsernameDAO;
import entity.Username;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;





public class UsernameLogic extends GenericLogic<Username,UsernameDAO> {
    
    public static final String PLAYER_ID = "id";
    public static final String USERNAME = "username";

    public UsernameLogic() { 
        super( new UsernameDAO());
    }
    
    public List<Username> getAll(){
        return get(()->dao().findAll());
    }
    
    public Username getByID( int playerID){
        return get(()->dao().findByPlayerID(playerID));
    }
    
    public List<Username> getByUserName( String username){
        return get(()->dao().findByUsername(username));
    }

    
    @Override
    public Username createEntity(Map<String, String[]> parameterMap) {
   Username user = new Username();
   
        if(parameterMap.isEmpty())
        {
           throw new NullPointerException();
        }
        
          else if(parameterMap.get(USERNAME)[0].matches("[0-9]+")
                  || parameterMap.get(USERNAME)[0].length() > 45)
        {
            throw new IllegalArgumentException();
        }
   
          else if(parameterMap.containsKey(PLAYER_ID))
                {
                        user.setPlayerid(Integer.valueOf(parameterMap.get(PLAYER_ID)[0]));
                }
  
        user.setUsername(parameterMap.get(USERNAME)[0]);
        return user;
    }
    
    public void deleteCourses(String[] entity)
    {
            UsernameLogic logic = new UsernameLogic();
            List<Username> list=  logic.getAll();

            for(int i = 0;i<entity.length ; i++)
            {
                if(entity[i] != null)
                {
                    String userName = entity[i];
                    
                    for(Username user : list)
                    {
                                  if(user.getPlayerid().toString().equals(userName))
                                  {
                                      delete(user);
                                  }
                    }
                }      
            }
    
        }
}
