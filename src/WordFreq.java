import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class WordFreq {

    private static LinkedHashMap<String, Integer> sortedMap = new LinkedHashMap<>();
    Map<String,Integer> mp=new TreeMap<>();
     public void count_freq(String[] arr) {



    // Loop to iterate over the words
        for(int i=0;i<arr.length;i++){
        // Condition to check if the
        // array element is present
        // the hash-map
        if(mp.containsKey(arr[i])) {
            mp.put(arr[i], mp.get(arr[i])+1);
        }
        else {
            mp.put(arr[i],1);
        }
    }

         /*ArrayList<Integer> list = new ArrayList<>();
         for (Map.Entry<String, Integer> entry : mp.entrySet()) {
             list.add(entry.getValue());
         }

         Collections.sort(list);
         for (int num : list) {
             for (Map.Entry<String, Integer> entry : mp.entrySet()) {
                 if (entry.getValue().equals(num)) {
                     sortedMap.put(entry.getKey(), num);
                 }
             }
         }*/
         //sortedMap = (LinkedHashMap<String, Integer>) MapUtil.sortByValue(mp);
         sortedMap = mp.entrySet()
                 .stream()
                 .sorted(Map.Entry.comparingByValue())
                 .collect(Collectors.toMap(
                         Map.Entry::getKey,
                         Map.Entry::getValue,
                         (oldValue, newValue) -> oldValue, LinkedHashMap::new));

    // Loop to iterate over the
    // elements of the map
    /*    for(Map.Entry<String,Integer> entry:
            mp.entrySet())
    {
        System.out.println(entry.getKey()+
                " - "+entry.getValue());
    }
     */
}

    public static void main(String[] args) throws IOException {
        //insert file
        //run method
        //print output
        WordFreq wf = new WordFreq();

        FileReader file = new FileReader("/home/kendell/Documents/ComputerNetworks/Word-Frequency/Word-Frequency/src/example.txt");
        BufferedReader br = new BufferedReader(file);

        String line;
        int overAllCount = 0;
        while ((line = br.readLine()) != null) {
            String[] words = line.split(" ");
            for(int i = 0; i< words.length;i++){
                words[i] = words[i].toLowerCase();
                words[i] = words[i].replaceAll("[^\\sa-zA-Z0-9]", "");
                words[i] = words[i].replaceAll("\\p{Punct}", "");
            }
            overAllCount = overAllCount + words.length;
            wf.count_freq(words);
            //System.out.println(Arrays.toString(words));
            //split into lines
            //put the words into an array
            //using a HashMap to count the frequency of the words.
            //get the count of the whole text to get the percentage of the usage
        }
        //System.out.println(sortedMap);
        for (Map.Entry<String, Integer> en : sortedMap.entrySet()) {
            System.out.println("Word:  " + en.getKey() +
                    "\n Freq.:  " + en.getValue() + "\n Percentage:  " + en.getValue()/overAllCount);
        }
        //System.out.println("Word Count: " + overAllCount);
    }
}
