import java.util.ArrayList;

public class Main
{

    public static ArrayList<String> DNAToCodons(String dna)
    {
        ArrayList<String> codons = new ArrayList<String>();

        for (int i = 0; i < dna.length() - 2; i += 3) 
        {
            String codon = dna.substring(i, i + 3);
            codons.add(codon);
        }

        return codons;
    }
    public static void main(String[] args) 
    {
        System.out.println("Program has started");

        String dna = "ATGCGATAA"; 

        ArrayList<String> codons = DNAToCodons(dna);

        System.out.println("Codons:");
        for (String codon : codons) 
        {
            System.out.println(codon);
        }
        System.out.println("Program has ended");
    }
}
