import java.util.ArrayList;

public class Main
{

    public static ArrayList<String> DNAToCodons(String dna)
    {
        ArrayList<String> codons = new ArrayList<String>();

        for (int i = 0; i <= dna.length() - 3; i += 3) 
        {
            String codon = dna.substring(i, i + 3);
            codons.add(codon);
        }

        return codons;
    }
    public static String CodonToAminoAcid(String codon)
    {
        codon = codon.toUpperCase();

        switch(codon) 
        {
            case "TTT": case "TTC": return "F";
            case "TTA": case "TTG": case "CTT": case "CTC": case "CTA": case "CTG": return "L";
            case "ATT": case "ATC": case "ATA": return "I";
            case "ATG": return "M";
            case "GTT": case "GTC": case "GTA": case "GTG": return "V";
            case "TCT": case "TCC": case "TCA": case "TCG": case "AGT": case "AGC": return "S";
            case "CCT": case "CCC": case "CCA": case "CCG": return "P";
            case "ACT": case "ACC": case "ACA": case "ACG": return "T";
            case "GCT": case "GCC": case "GCA": case "GCG": return "A";
            case "TAT": case "TAC": return "Y";
            case "CAT": case "CAC": return "H";
            case "CAA": case "CAG": return "Q";
            case "AAT": case "AAC": return "N";
            case "AAA": case "AAG": return "K";
            case "GAT": case "GAC": return "D";
            case "GAA": case "GAG": return "E";
            case "TGT": case "TGC": return "C";
            case "TGG": return "W";
            case "CGT": case "CGC": case "CGA": case "CGG": case "AGA": case "AGG": return "R";
            case "GGT": case "GGC": case "GGA": case "GGG": return "G";
            case "TAA": case "TAG": case "TGA": return "*";
            default: return "?";
        }
    }

    public static ArrayList<String> dna_to_amino_acid(String dna)
    {
        ArrayList<String> codons = DNAToCodons(dna);
        ArrayList<String> aminoAcids = new ArrayList<String>();

        for (String codon : codons) 
        {
            aminoAcids.add(CodonToAminoAcid(codon));
        }

        return aminoAcids;
    }

    public static boolean is_match(ArrayList<String> amino_seq1, ArrayList<String> amino_seq2) {
        if (amino_seq1.size() != amino_seq2.size()) 
        {
            return false;
        }

        for (int i = 0; i < amino_seq1.size(); i++) 
        {
            if (!amino_seq1.get(i).equals(amino_seq2.get(i))) 
            {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) 
    {
        System.out.println("Program has started");

        String DNA1 = "CTGATATTGTATCCGGCCGAA";
        String DNA2 = "CTAGCCGGTGGTTATTAATAGTAAACTATTCCA";
        String DNA3 = "TTAATCCTCTACCCCGCAGAG";

        ArrayList<String> aminoSeq1 = dna_to_amino_acid(DNA1);
        ArrayList<String> aminoSeq2 = dna_to_amino_acid(DNA2);
        ArrayList<String> aminoSeq3 = dna_to_amino_acid(DNA3);

        System.out.println("Amino Acid Sequence 1: " + aminoSeq1);
        System.out.println("Amino Acid Sequence 2: " + aminoSeq2);
        System.out.println("Amino Acid Sequence 3: " + aminoSeq3);

        if (is_match(aminoSeq1, aminoSeq2)) 
        {
            System.out.println("DNA1 and DNA2 have the same amino sequences.");
        } 
        
        else 
        {
            System.out.println("DNA1 and DNA2 do NOT have the same amino sequences.");
        }

        if (is_match(aminoSeq1, aminoSeq3)) 
        {
            System.out.println("DNA1 and DNA3 have the same amino sequences.");
        } 
        
        else
        {
            System.out.println("DNA1 and DNA3 do NOT have the same amino sequences.");
        }

        if (is_match(aminoSeq2, aminoSeq3)) 
        {
            System.out.println("DNA2 and DNA3 have the same amino sequences.");
        } 
        
        else 
        {
            System.out.println("DNA2 and DNA3 do NOT have the same amino sequences.");
        }

        System.out.println("this really long Program has finally ended");
    }
}