package models;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.sql2o.Sql2o;

import java.net.URI;

public class DB {
    private static URI dbUri;
    public static Sql2o sql2o;
    static Logger logger = LoggerFactory.getLogger(DB.class);
    static {
        try {
            if(System.getenv("DATABASE_URL") == NULL){
                dbUri = new URI("")
            }
        }
    }
}
