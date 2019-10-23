package fr.licinfo.algoTri;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	
    	int[] tabAtrier = {45,1,10,25,5,32,72,11,23,114,121,32,71,85,35,3,7};
    	int[] tabAtrier2 = {451,1,110,25,75,132,712,45,213,11,21,312,171,55,315,34,17};
    	int[] tabAtrier3 = {20,23,78,5,26,23,20,42,232,110,142,123,78,32,45,32,98,74,52};
    			
        System.out.println( "ALGORITHME DE TRI" );
        
        AlgoTri algotri = new AlgoTri();
        
        //algotri.triInsertion(tabAtrier);
        
        //algotri.triSelection(tabAtrier2);
        
        //algotri.triBulle(tabAtrier3);
        
        //algotri.triFusion(tabAtrier2);
        algotri.triRapide(tabAtrier3);
    }
}
