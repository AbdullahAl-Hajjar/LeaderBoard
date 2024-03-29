package dao;

import java.util.Objects;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;


@WebListener
public class EMFactory implements ServletContextListener{
    
    private static EntityManagerFactory emFactory;
    
    @Override
    public void contextInitialized(ServletContextEvent sce){
        if(emFactory==null)
            emFactory = Persistence.createEntityManagerFactory("JPA-Tomcat-ScoreDB");
    }
 
    @Override
    public void contextDestroyed(ServletContextEvent sce){
        if(emFactory!=null)
            emFactory.close();
    }
    
    public static EntityManagerFactory getEMFactory(){
        Objects.requireNonNull(emFactory, "Entity Manager Factory not initilized");
        return emFactory;
    }
}
