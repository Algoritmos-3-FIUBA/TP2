package edu.fiuba.algo3.vista;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;


public class LecturaDeArchivo {
   // private final LinkedList<Pregunta> preguntas;
    private final String ARCHIVO = "src/main/java/edu/fiuba/algo3/vista/cuestionario.json";

   public LecturaDeArchivo() {
        //JSON parser object to parse read file
        JSONParser jsonParser = new JSONParser();

        try (FileReader reader = new FileReader(Paths.get(ARCHIVO).toUri().toString()))
        {
            //Read JSON file
            Object obj = jsonParser.parse(reader);
            JSONArray preguntaList = (JSONArray) obj;
            System.out.println(preguntaList);

            //Iterate over employee array
            preguntaList.forEach( emp -> parseEmployeeObject( (JSONObject) emp ) );

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    private void parseEmployeeObject(JSONObject preguntas) {

            JSONArray preguntasVerdaderoFalso = (JSONArray) preguntas.get("PreguntasVerdaderoFalso");

            JSONObject pregunta1 = (JSONObject) preguntasVerdaderoFalso.get(0);

            String firstName = (String) pregunta1.get("nombre");
            System.out.println(firstName);

            /*//Get employee object within list
            JSONObject employeeObject = (JSONObject) pregunta.get("PreguntaVerdaderoFalso");

            //Get employee first name
            String firstName = (String) employeeObject.get("firstName");
            System.out.println(firstName);

            //Get employee last name
            String lastName = (String) employeeObject.get("lastName");
            System.out.println(lastName);

            //Get employee website name
            String website = (String) employeeObject.get("website");
            System.out.println(website);*/

    }
}
