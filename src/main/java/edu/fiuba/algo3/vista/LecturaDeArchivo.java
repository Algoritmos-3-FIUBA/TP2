package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.pregunta.Pregunta;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.invoke.SwitchPoint;
import java.util.LinkedList;


public class LecturaDeArchivo {
   // private final LinkedList<Pregunta> preguntas;
    private final String ARCHIVO = "src/main/java/edu/fiuba/algo3/vista/cuestionario.json";

   public LecturaDeArchivo(LinkedList<Pregunta> preguntas) {
       //JSON parser object to parse read file
       JSONParser jsonParser = new JSONParser();

       try (FileReader reader = new FileReader(ARCHIVO))
       {
           //Read JSON file
           Object obj = jsonParser.parse(reader);

           JSONArray preguntasList = (JSONArray) obj;
           //System.out.println(employeeList);

           //Iterate over employee array
           preguntasList.forEach( emp -> parseEmployeeObject( (JSONObject) emp,preguntas ) );

       } catch (FileNotFoundException e) {
           e.printStackTrace();
       } catch (IOException e) {
           e.printStackTrace();
       } catch (ParseException e) {
           e.printStackTrace();
       }
   }

    public void parseEmployeeObject(JSONObject oPregunta,LinkedList<Pregunta> preguntas)
    {
        //Get employee object within list
        JSONObject pregunta = (JSONObject) oPregunta.get("Pregunta");
        String tipo = (String) pregunta.get("tipo");
        switch(tipo) {
            case "VerdaderoFalso":
                this.instanciar(pregunta,preguntas);
            case MULTIPLE_CHOICE_WITH_PENALTY:
                return QuestionTypeLiteral.MULTIPLE_CHOICE_PENALTY;
            case MULTIPLE_CHOICE_PARTIAL:
                return QuestionTypeLiteral.MULTIPLE_CHOICE_PARTIAL;
            case TRUE_FALSE:
                return QuestionTypeLiteral.TRUE_FALSE;
            case TRUE_FALSE_WITH_PENALTY:
                return QuestionTypeLiteral.TRUE_FALSE_PENALTY;
            case ORDERED_QUESTION:
                return QuestionTypeLit
        System.out.println(first);

        //Get employee first name
        String firstName = (String) pregunta.get("nombre");
        System.out.println(firstName);

        //Get employee last name
        String lastName = (String) pregunta.get("textoOpcion1");
        System.out.println(lastName);

        //Get employee website name
        String website = (String) pregunta.get("textoOpcion2");
        System.out.println(website);

        String correct = (String) pregunta.get("opcionCorrecta");
        System.out.println(correct);
    }
}

    private void instanciar(JSONObject pregunta, LinkedList<Pregunta> preguntas) {

    }
    }
