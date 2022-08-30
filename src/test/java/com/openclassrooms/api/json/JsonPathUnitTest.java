package com.openclassrooms.api.json;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.Map;

import org.junit.BeforeClass;
import org.junit.Test;

import com.jayway.jsonpath.JsonPath;

import net.minidev.json.JSONArray;

public class JsonPathUnitTest {

	
	private static String json;
    private static File jsonFile = new File("src/main/resources/test.json");

    private static String readFile(File file, Charset charset) throws IOException {
        return new String(Files.readAllBytes(file.toPath()), charset);
    }

    @BeforeClass
    public static void init() throws IOException {
        json = readFile(jsonFile, StandardCharsets.UTF_8);
    }

    @Test
    public void shouldMatchCountOfObjects() {
        Map<String, String> objectMap = JsonPath.read(json, "$");
        assertEquals(3, objectMap.keySet()
            .size());
    }

    @Test
    public void shouldMatchCountOfArrays() {
        JSONArray jsonArray = JsonPath.read(json, "$.items.book[*]");
        assertEquals(2, jsonArray.size());
    }

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    /*
     *  
     * Comment 
     * 
     * //mockMvc.perform(get("/persons")).andExpect(status().isOk()).andExpect(jsonPath("$[0].firstName",is("John")));
     * 
     * 
     * 
     * $[0] : le premier élément du Array 
     * Le contenu de chaque case de cet Array est un objet --> "$[0].lastName", is("Boyd") : verify 
     * 
     * {}: Object 
     * [] : array 
     * 
     * Nous souhaitons accéder à "firstName": "Jacob" :
     * 
     * 
     *  **************************************************************
     *  N.B
     *  
     * Ce qu'on doit comprendre : 
     * Un objet JSON peut être stocké dans son propre fichier qui se présente simplement sous la forme 
     * d'un fichier texte avec l'extension .json et le MIME type application/json
     * 
     * JSON est un format de données semblable à la syntaxe des objets JavaScript
     * 
     * Objet Json Data ( stocké dans un fichier texte data.json ) 
     * 
     * On charge cet objet dans la classe Java au sein d'une variable appelée ----->  Data 
     * pour accéder à ces données, on utilise à l'aide de la notation point / crochets
     * 
     * Variable Data ( Objet Data ( data.json contient les données de l'objet Json Data ) 
     * 
     * Data ['persons'][1]['email']  -->  "drk@email.com"  ( email du 2eme personne -Jacob- , première personne ['persons'][0]
     * 
     * Data ['medicalrecords'][0]['medications'][1] --> "hydrapermazol:100mg"
     * 
     * 
     * 1- On part de la variable Data 
     * 2- à l'intérieur de laquelle on veut accéder à la propriété persons donc on écrit   Data.persons.
     * 3- persons contient un tableau renfermant des objets. on veut accéder au second de ces objets, donc on utilise [1].
     * 4- À l'intérieur de cet objet, on souhaite accéder à la propriété email.
     * 
     * Pour MedicalRecord: 
     * meme étapes avec une étape de plus 
     * 
     * 5- Enfin, à l'intérieur de cette propriété medications, on trouve un nouveau tableau. 
     * on veut obtenir le deusième, donc nous tapons [1].

     * 
     * On veut accéder au paramètre person --> Data.persons  : le contenu de Array persons Data.persons[0]
     * 
     */
}
