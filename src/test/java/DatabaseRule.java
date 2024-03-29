import models.DB;
import org.junit.rules.ExternalResource;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

public class DatabaseRule extends ExternalResource {
    @Override
    protected void before(){
        DB.sql2o = new Sql2o("jdbc:postgresql://localhost:5432/wildlife_tracker", "postgres", "Blackhole2123");
    }
    @Override
    protected void after(){
        try(Connection con = DB.sql2o.open()){
            String deleteAnimalQuery = "DELETE FROM animals *;";
            String deleteSightingQuery = "DELETE FROM sightings *;";
            con.createQuery(deleteAnimalQuery).executeUpdate();
            con.createQuery(deleteSightingQuery).executeUpdate();
        }
    }
}
