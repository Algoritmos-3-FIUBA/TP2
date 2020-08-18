package edu.fiuba.algo3.vista;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;



public class LecturaDeArchivo {
   // private final LinkedList<Pregunta> preguntas;
    private final String ARCHIVO = "src/main/java/edu/fiuba/algo3/vista/cuestionario.json";

   public LecturaDeArchivo() {
       //JSON parser object to parse read file
       JSONParser jsonParser = new JSONParser();

       try (FileReader reader = new FileReader(ARCHIVO))
       {
           //Read JSON file
           Object obj = jsonParser.parse(reader);

           JSONArray employeeList = (JSONArray) obj;
           System.out.println(employeeList);

           //Iterate over employee array
           employeeList.forEach( emp -> parseEmployeeObject( (JSONObject) emp ) );

       } catch (FileNotFoundException e) {
           e.printStackTrace();
       } catch (IOException e) {
           e.printStackTrace();
       } catch (ParseException e) {
           e.printStackTrace();
       }
   }

    private static void parseEmployeeObject(JSONObject employee)
    {
        //Get employee object within list
        JSONObject employeeObject = (JSONObject) employee.get("Pregunta");
       // System.out.println(employeeObject.toString());

        String first = (String) employeeObject.get("tipo");
        System.out.println(first);

        //Get employee first name
        String firstName = (String) employeeObject.get("nombre");
        System.out.println(firstName);

        //Get employee last name
        String lastName = (String) employeeObject.get("textoOpcion1");
        System.out.println(lastName);

        //Get employee website name
        String website = (String) employeeObject.get("textoOpcion2");
        System.out.println(website);

        String correct = (String) employeeObject.get("opcionCorrecta");
        System.out.println(correct);
    }
}
