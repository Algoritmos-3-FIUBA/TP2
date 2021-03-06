package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.opcion.ColeccionOpciones;
import edu.fiuba.algo3.modelo.opcion.OpcionCorrecta;
import edu.fiuba.algo3.modelo.opcion.OpcionIncorrecta;
import edu.fiuba.algo3.modelo.pregunta.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;


public class LecturaDeArchivo {
    private final String ARCHIVO = "src/main/java/edu/fiuba/algo3/vista/cuestionario.json";

   public LecturaDeArchivo(LinkedList<Pregunta> preguntas, HashMap<Pregunta,String> plantillaPreguntas) {
       JSONParser jsonParser = new JSONParser();

       try (FileReader reader = new FileReader(ARCHIVO))
       {
           Object obj = jsonParser.parse(reader);

           JSONArray preguntasList = (JSONArray) obj;
           for(int i=0;i< preguntasList.size();i++) {
               parseEmployeeObject((JSONObject) preguntasList.get(i),preguntas,plantillaPreguntas);
           }

       } catch (FileNotFoundException e) {
           e.printStackTrace();
       } catch (IOException e) {
           e.printStackTrace();
       } catch (ParseException e) {
           e.printStackTrace();
       }
   }

    public void parseEmployeeObject(JSONObject oPregunta,LinkedList<Pregunta> preguntas,HashMap<Pregunta,String> plantillaPreguntas)
    {
        JSONObject pregunta = (JSONObject) oPregunta.get("Pregunta");
        String tipo = (String) pregunta.get("tipo");

        switch(tipo) {
            case "VerdaderoFalsoClasico":
                this.instanciarPreguntaVoFClasica(pregunta, preguntas, plantillaPreguntas);
                break;
            case "VerdaderoFalsoPenalidad":
                this.instanciarPreguntaVoFPenalidad(pregunta, preguntas, plantillaPreguntas);
                break;
            case "MultipleChoiceClasico":
                this.instanciarPreguntaMultipleChoiceClasica(pregunta, preguntas, plantillaPreguntas);
                break;
            case "MultipleChoiceParcial":
                this.instanciarPreguntaMultipleChoiceParcial(pregunta, preguntas, plantillaPreguntas);
                break;
            case "MultipleChoicePenalidad":
                this.instanciarPreguntaMultipleChoicePenalidad(pregunta, preguntas, plantillaPreguntas);
                break;
            case "OrderedChoice":
                this.instanciarPreguntaOrderedChoice(pregunta,preguntas, plantillaPreguntas);
                break;
            case "GrupoChoice":
                this.instanciarPreguntaGrupoChoice(pregunta,preguntas, plantillaPreguntas);
                break;
        }
    }

    private void instanciarPreguntaGrupoChoice(JSONObject oPregunta, LinkedList<Pregunta> preguntas, HashMap<Pregunta,String> plantillaPreguntas) {
        LinkedList<ColeccionOpciones> gruposCorrectos = new LinkedList<ColeccionOpciones>();
        ColeccionOpciones grupo1correcto = new ColeccionOpciones((String) oPregunta.get("nombregrupo1"));
        JSONArray grupo1 = (JSONArray) oPregunta.get("grupo1");
        for (Object o : grupo1) {
            String opcion = (String) o ;
            grupo1correcto.agregarOpcion(new OpcionCorrecta(opcion));
        }
        JSONArray grupo2 = (JSONArray) oPregunta.get("grupo2");
        ColeccionOpciones grupo2correcto = new ColeccionOpciones((String) oPregunta.get("nombregrupo2"));
        for (Object o : grupo2) {
            String opcion = (String) o ;
            grupo2correcto.agregarOpcion(new OpcionCorrecta(opcion));
        }
        gruposCorrectos.add(grupo1correcto);
        gruposCorrectos.add(grupo2correcto);
        PreguntaGroupChoice pregunta = new PreguntaGroupChoice((String) oPregunta.get("nombre"),1,gruposCorrectos);
        preguntas.add(pregunta);
        plantillaPreguntas.put(pregunta,"src/main/java/edu/fiuba/algo3/vista/plantilla/GroupChoice.fxml");
   }

    private void instanciarPreguntaOrderedChoice(JSONObject oPregunta, LinkedList<Pregunta> preguntas,HashMap<Pregunta,String> plantillaPreguntas) {
       ColeccionOpciones opciones = new ColeccionOpciones();
        JSONArray correctas = (JSONArray) oPregunta.get("correctas");
        for (Object o : correctas) {
            String opcion = (String) o ;
            opciones.agregarOpcion(new OpcionCorrecta(opcion));
        }
        PreguntaOrderedChoice pregunta = new PreguntaOrderedChoice((String) oPregunta.get("nombre"),1,opciones);
        preguntas.add(pregunta);
        plantillaPreguntas.put(pregunta,"src/main/java/edu/fiuba/algo3/vista/plantilla/OrderedChoice.fxml");
    }

    private void instanciarPreguntaMultipleChoicePenalidad(JSONObject oPregunta, LinkedList<Pregunta> preguntas,HashMap<Pregunta,String> plantillaPreguntas) {
        ColeccionOpciones opciones = new ColeccionOpciones();
        JSONArray correctas = (JSONArray) oPregunta.get("correctas");
        for (Object o : correctas) {
            String opcion = (String) o ;
            opciones.agregarOpcion(new OpcionCorrecta(opcion,1));
        }
        JSONArray incorrectas = (JSONArray) oPregunta.get("incorrectas");
        for (Object o : incorrectas) {
            String opcion = (String) o ;
            opciones.agregarOpcion(new OpcionIncorrecta(opcion,-1));
        }
        PreguntaMultipleChoicePenalidad pregunta = new PreguntaMultipleChoicePenalidad((String) oPregunta.get("nombre"),opciones);
        preguntas.add(pregunta);
        plantillaPreguntas.put(pregunta,"src/main/java/edu/fiuba/algo3/vista/plantilla/MultipleChoicePenalidad.fxml");
    }

    private void instanciarPreguntaMultipleChoiceParcial(JSONObject oPregunta, LinkedList<Pregunta> preguntas,HashMap<Pregunta,String> plantillaPreguntas) {
        ColeccionOpciones opciones = new ColeccionOpciones();
        JSONArray correctas = (JSONArray) oPregunta.get("correctas");
        for (Object o : correctas) {
            String opcion = (String) o ;
            opciones.agregarOpcion(new OpcionCorrecta(opcion,1));
        }
        JSONArray incorrectas = (JSONArray) oPregunta.get("incorrectas");
        for (Object o : incorrectas) {
            String opcion = (String) o ;
            opciones.agregarOpcion(new OpcionIncorrecta(opcion,-1));
        }
        PreguntaMultipleChoiceParcial pregunta = new PreguntaMultipleChoiceParcial((String) oPregunta.get("nombre"),opciones);
        preguntas.add(pregunta);
        plantillaPreguntas.put(pregunta,"src/main/java/edu/fiuba/algo3/vista/plantilla/MultipleChoiceParcial.fxml");
    }

    private void instanciarPreguntaMultipleChoiceClasica(JSONObject oPregunta, LinkedList<Pregunta> preguntas,HashMap<Pregunta,String> plantillaPreguntas) {
       ColeccionOpciones opciones = new ColeccionOpciones();
       JSONArray correctas = (JSONArray) oPregunta.get("correctas");
       for (Object o : correctas) {
           String opcion = (String) o ;
           opciones.agregarOpcion(new OpcionCorrecta(opcion));
       }
       JSONArray incorrectas = (JSONArray) oPregunta.get("incorrectas");
       for (Object o : incorrectas) {
           String opcion = (String) o ;
           opciones.agregarOpcion(new OpcionIncorrecta(opcion));
       }
       PreguntaMultipleChoice pregunta = new PreguntaMultipleChoice((String) oPregunta.get("nombre"),1,opciones);
       preguntas.add(pregunta);
       plantillaPreguntas.put(pregunta,"src/main/java/edu/fiuba/algo3/vista/plantilla/MultipleChoiceClasico.fxml");
    }

    private void instanciarPreguntaVoFPenalidad(JSONObject oPregunta, LinkedList<Pregunta> preguntas,HashMap<Pregunta,String> plantillaPreguntas) {
        PreguntaVerdaderoFalsoPenalidad pregunta = new PreguntaVerdaderoFalsoPenalidad((String) oPregunta.get("nombre"));
        if((Boolean) oPregunta.get("opcionCorrecta")) pregunta.setFalsoOpcionCorrecta();
        else pregunta.setVerdaderoOpcionCorrecta();
        preguntas.add(pregunta);
        plantillaPreguntas.put(pregunta,"src/main/java/edu/fiuba/algo3/vista/plantilla/VerdaderoFalsoPenalidad.fxml");
    }

    private void instanciarPreguntaVoFClasica(JSONObject oPregunta, LinkedList<Pregunta> preguntas,HashMap<Pregunta,String> plantillaPreguntas) {
        PreguntaVerdaderoFalsoClasico pregunta = new PreguntaVerdaderoFalsoClasico((String) oPregunta.get("nombre"));
        if((Boolean) oPregunta.get("opcionCorrecta")) pregunta.setFalsoOpcionCorrecta();
        else pregunta.setVerdaderoOpcionCorrecta();
        preguntas.add(pregunta);
        plantillaPreguntas.put(pregunta,"src/main/java/edu/fiuba/algo3/vista/plantilla/VerdaderoFalso.fxml");
    }

}
