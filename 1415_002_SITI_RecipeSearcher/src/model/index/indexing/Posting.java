package model.index.indexing;

import java.util.ArrayList;

public class Posting 
{
    /*
    * Identificador �nico del Posting.
    */
    private String id;
    
    /*
    * Frecuencia de aparici�n del t�rmino en el documento
    */
    private int frec;
    
    /*
    * lista de posiciones del termino
    */
    private ArrayList<Long> termPos;
    
    /**
    * Posting(String documentID, int frec)
    * Constructor de la clase.
    * @param documentID String identificador �nico del documento en el que aparece un t�rmino.
    * @param frec Integer frecuencia de aparici�n del t�rmino en el documento.
    */
    public Posting(String documentID, int frec)
    {
        this.id=documentID;
        this.frec=frec;
        this.termPos = new ArrayList<Long>();
    }
    
    /**
    * int getTermFrequency()
    * Getter.
    * @return int frecuencia del t�rmino en el documento
    */
    public int getTermFrequency()
    {
        return this.frec;
    }
}
