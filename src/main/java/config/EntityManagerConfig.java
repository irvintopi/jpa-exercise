package config;
import javax.persistence.*;
public class EntityManagerConfig {
    private static final EntityManagerFactory FACTORY = Persistence.createEntityManagerFactory("jpa_exercise_db");
    private static final javax.persistence.EntityManager ENTITY_MANAGER = FACTORY.createEntityManager();

    public static javax.persistence.EntityManager getEntityManager() {
        return ENTITY_MANAGER;
    }
}