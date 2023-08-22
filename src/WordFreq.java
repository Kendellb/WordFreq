import java.io.*;
import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class WordFreq {
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

    // Loop to iterate over the
    // elements of the map
        for(Map.Entry<String,Integer> entry:
            mp.entrySet())
    {
        System.out.println(entry.getKey()+
                " - "+entry.getValue());
    }
}

    public static void main(String[] args) throws IOException {
        //insert file
        //run method
        //print output
        WordFreq wf = new WordFreq();

        FileReader file = new FileReader("/home/kendell/Documents/ComputerNetworks/Word-Frequency/Word-Frequency/src/TheHoundOfTheBaskervilles.txt");
        BufferedReader br = new BufferedReader(file);

        String line;
        int overAllCount = 0;
        while ((line = br.readLine()) != null) {
            String[] words = line.split(" ");
            overAllCount = overAllCount + words.length;
            //Test
            wf.count_freq(words);
            //System.out.println(Arrays.toString(words));
            //split into lines
            //put the words into an array
            //using a HashMap to count the frequency of the words.
            //get the count of the whole text to get the percentage of the usage
        }
        System.out.println("Word Count: " + overAllCount);
    }
}
