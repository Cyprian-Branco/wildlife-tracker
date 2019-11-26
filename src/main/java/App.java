import models.Animal;
import models.Endangered;
import models.Sighting;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static spark.Spark.*;

public class App {
    public static void main(String[] args){
        staticFileLocation("/public");
        ProcessBuilder process = new ProcessBuilder();
        Integer port;

        // This tells our app that if Heroku sets a port for us, we need to use that port.
        // Otherwise, if they do not, continue using port 4567.

        if (process.environment().get("PORT") != null) {
            port = Integer.parseInt(process.environment().get("PORT"));
        } else {
            port = 4567;
        }


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
            Endangered newEndangered = new Endangered(name,age,health);
            newEndangered.save();
            response.redirect("/");
            return null;
        }), new HandlebarsTemplateEngine());

        get("/endangered", ((request, response) -> {
            Map<String, Object> model = new HashMap<>();
            List<Endangered> endangered = Endangered.all();
            model.put("endangered ", endangered);
            return new ModelAndView(model, "endangered-list.hbs");
        }), new HandlebarsTemplateEngine());

        get("/sighting/new", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            List<Endangered> endangered = Endangered.all();
            List<Object> animals = new ArrayList<Object>();
            for (int i = 0; i < endangered.size(); i++) {
                animals.add(Endangered.all().get(i));
            }
            model.put("animals",animals );
            return new ModelAndView(model, "sighting-form.hbs");
        }, new HandlebarsTemplateEngine());
        post("/sighting/new", ((request, response) -> {
            Map<String, Object> model = new HashMap<>();
            String ranger = request.queryParams("ranger");
            int animalId = Integer.parseInt(request.queryParams("animalId"));
            String location = request.queryParams("location");
            Sighting sighting = new Sighting(ranger,animalId,location);
            sighting.save();
            response.redirect("index.hbs");
            return null;
        }), new HandlebarsTemplateEngine());
        get("/sightings", ((request, response) -> {
            Map<String, Object> model = new HashMap<>();
            List<Sighting> sightings =Sighting.all();
            model.put("Animal", Animal.class);
            model.put("sightings", sightings);
            return new ModelAndView(model, "sighting-view.hbs");
        }), new HandlebarsTemplateEngine());

        get("/sightings/:id/delete", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            Sighting.find(Integer.parseInt(request.params(":id"))).delete();
            response.redirect("/sightings");
            return null;
        }, new HandlebarsTemplateEngine());
    }
}

