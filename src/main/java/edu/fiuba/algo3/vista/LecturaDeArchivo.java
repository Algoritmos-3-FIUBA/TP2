package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.ColeccionOpciones;
import edu.fiuba.algo3.modelo.opcion.Opcion;
import edu.fiuba.algo3.modelo.opcion.OpcionCorrecta;
import edu.fiuba.algo3.modelo.opcion.OpcionIncorrecta;
import edu.fiuba.algo3.modelo.pregunta.Pregunta;
import edu.fiuba.algo3.modelo.pregunta.PreguntaMultipleChoice;
import edu.fiuba.algo3.modelo.pregunta.PreguntaVerdaderoFalsoClasico;
import edu.fiuba.algo3.modelo.pregunta.PreguntaVerdaderoFalsoPenalidad;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.invoke.SwitchPoint;
import java.util.Collection;
import java.util.Iterator;
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
           /*preguntasList.forEach( emp -> parseEmployeeObject( (JSONObject) emp,preguntas ) );
            while(preguntasList.isEmpty())
            parseEmployeeObject((JSONObject) preguntasList.get(1),preguntas);
           */ // loop array
           //JSONArray cars = (JSONArray) jsonObject.get("cars");
           //Iterator<String> iterator = preguntasList.iterator();
           for (int i=0;i< preguntasList.size();i++) {
               parseEmployeeObject((JSONObject) preguntasList.get(i),preguntas);
               //parseEmployeeObject((JSONObject) iterator,preguntas);
           }

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
        System.out.println(tipo);

        switch(tipo) {
            case "VerdaderoFalsoClasico":
                this.instanciarPreguntaVoFClasica(pregunta, preguntas);
                break;
            case "VerdaderoFalsoPenalidad":
                this.instanciarPreguntaVoFPenalidad(pregunta, preguntas);
                break;
            case "MultipleChoiseClasico":
                this.instanciarPreguntaMultipleChoiseClasica(pregunta, preguntas);
                break;
            case "MultipleChoiseParcial":
                //this.instanciarPreguntaVoFClasica(pregunta, preguntas);
                break;
            case "MultipleChoisePenalidad":
                //this.instanciarPreguntaVoFClasica(pregunta, preguntas);
                break;
            case "OrderedChoise":
                //this.instanciarPreguntaVoFClasica(pregunta, preguntas);
                break;
        }
        System.out.println(preguntas.size());
        //Get employee first name
       /* String firstName = (String) pregunta.get("nombre");
        System.out.println(firstName);

        //Get employee last name
        String lastName = (String) pregunta.get("textoOpcion1");
        System.out.println(lastName);

        //Get employee website name
        String website = (String) pregunta.get("textoOpcion2");
        System.out.println(website);

        String correct = (String) pregunta.get("opcionCorrecta");
        System.out.println(correct);*/
    }

    private void instanciarPreguntaMultipleChoiseClasica(JSONObject oPregunta, LinkedList<Pregunta> preguntas) {
        ColeccionOpciones opciones = new ColeccionOpciones();
        JSONArray correctas = (JSONArray) oPregunta.get("correctas");
        //Iterator<String> iterator = correctas.iterator();
        for (Object o : correctas) {
            String opcion = (String) o ;
            opciones.agregarOpcion(new OpcionCorrecta(opcion));
        }
        JSONArray incorrectas = (JSONArray) oPregunta.get("incorrectas");
        //Iterator<String> iterator = correctas.iterator();
        for (Object o : correctas) {
            String opcion = (String) o ;
            opciones.agregarOpcion(new OpcionIncorrecta(opcion));
        }
       PreguntaMultipleChoice pregunta = new PreguntaMultipleChoice((String) oPregunta.get("nombre"),1,opciones);
       System.out.println( pregunta.getNombrePregunta());
        preguntas.add(pregunta);
    }

    private void instanciarPreguntaVoFPenalidad(JSONObject oPregunta, LinkedList<Pregunta> preguntas) {
        PreguntaVerdaderoFalsoPenalidad pregunta = new PreguntaVerdaderoFalsoPenalidad((String) oPregunta.get("nombre"));
        if((Boolean) oPregunta.get("opcionCorrecta")) pregunta.setVerdaderoOpcionCorrecta();
        else pregunta.setFalsoOpcionCorrecta();
        preguntas.add(pregunta);
        System.out.println(pregunta.getNombrePregunta());
    }


    private void instanciarPreguntaVoFClasica(JSONObject oPregunta, LinkedList<Pregunta> preguntas) {
        PreguntaVerdaderoFalsoClasico pregunta = new PreguntaVerdaderoFalsoClasico((String) oPregunta.get("nombre"));
        if((Boolean) oPregunta.get("opcionCorrecta")) pregunta.setVerdaderoOpcionCorrecta();
        else pregunta.setFalsoOpcionCorrecta();
        preguntas.add(pregunta);
        System.out.println(pregunta.getNombrePregunta());
    }


}
