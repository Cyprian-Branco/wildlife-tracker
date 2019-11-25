import models.Endangered;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static spark.Spark.*;

public class App {
    public static void main(String[] args){
        staticFileLocation("/public");

        get("/", (request, response) -> {
            Map<String , Object> model = new HashMap<>();
            return new ModelAndView(model, "index.hbs");
        }, new HandlebarsTemplateEngine());

        get("/endangered/new", ((request, response) -> {
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "endangered-form.hbs");
        }), new HandlebarsTemplateEngine());

        post("/endangered/new", ((request, response) -> {
            Map<String, Object> model = new HashMap<>();
            String name = request.queryParams("name");
            String age = request.queryParams("age");
            String health = request.queryParams("health");
            Endangered newEndangeredAnimal = new Endangered(name,age,health);
            newEndangeredAnimal.save();
            response.redirect("/");
            return null;
        }), new HandlebarsTemplateEngine());

        get("/endangered", ((request, response) -> {
            Map<String, Object> model = new HashMap<>();
            List<Endangered> endangeredAnimals = Endangered.all();
            model.put("endangeredAnimals", endangeredAnimals);
            return new ModelAndView(model, "endangered-list.hbs");
        }), new HandlebarsTemplateEngine());
    }
}

