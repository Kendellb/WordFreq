import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class WordFreq {

    private static LinkedHashMap<String, Integer> sortedMap = new LinkedHashMap<>();
    Map<String,Integer> mp=new TreeMap<>();
     public void count_freq(String[] arr) {



         for (String s : arr) {
             if ( mp.containsKey(s) ) {
                 mp.put(s, mp.get(s) + 1);
             } else {
                 mp.put(s, 1);
             }
         }

         //from geeksforgeeks
         sortedMap = mp.entrySet()
                 .stream()
                 .sorted(Map.Entry.comparingByValue())
                 .collect(Collectors.toMap(
                         Map.Entry::getKey,
                         Map.Entry::getValue,
                         (oldValue, newValue) -> oldValue, LinkedHashMap::new));

}

    public static void main(String[] args) throws IOException {
        WordFreq wf = new WordFreq();

        FileReader file = new FileReader("/home/kendell/Documents/ComputerNetworks/Word-Frequency/Word-Frequency/src/TheHoundOfTheBaskervilles.txt");
        BufferedReader br = new BufferedReader(file);

        String line;
        double overAllCount = 0;
        while ((line = br.readLine()) != null) {
            String[] words = line.split(" ");
            for(int i = 0; i< words.length;i++){
                words[i] = words[i].toLowerCase();
                words[i] = words[i].replaceAll("[^\\sa-zA-Z0-9]", "");
                words[i] = words[i].replaceAll("\\p{Punct}", "");

            }
            overAllCount = overAllCount + words.length;
            wf.count_freq(words);
        }

        double percentage = 0;
        Set<String> set = sortedMap.keySet();

        List<String> alKeys = new ArrayList<String> (sortedMap.keySet());

        Collections.reverse(alKeys);

        for (String strKey : alKeys) {
            percentage = (sortedMap.get(strKey)/overAllCount) * 100;
            String result = String.format("%.2f", percentage);

            System.out.println("Word: " + strKey +
                    "  Freq.:  " + sortedMap.get(strKey) + "  Percentage:  " + result + "%" );
        }

    }
}
