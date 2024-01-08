package com.example.searchengine;
import com.example.searchengine.MapImplementation.UnsortedTableMap;
import java.io.File;
import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class FileOperations {
    public static UnsortedTableMap<String,String>map=new UnsortedTableMap<String,String>();
    List<String>allFiles=new ArrayList<String>();

    public UnsortedTableMap<String,String> ReadAndFillMap() throws IOException {


        File file=new File("EnglishData");
        File[] listFiles = file.listFiles();
        UnsortedTableMap<String,String>map=new UnsortedTableMap<String,String>();

        String temp;
        for (File current:listFiles)
        {
            try(BufferedReader br = new BufferedReader(new FileReader(current.getPath()))) {
                while ((temp=br.readLine())!=null)
                {
                    temp=temp.replaceAll("[\\p{P}\\p{S}]"," ");
                    temp=temp.toLowerCase();
                    String []line=temp.split("\\s");

                    for (int i = 0; i <line.length; i++) {

                        if (!map.isEmpty())
                        {
                            //if the element exist in the map
                            if (map.get(line[i])!=null)
                            {
                                if (!map.get(line[i]).contains(current.getName())){
                                    map.put(line[i], map.get(line[i])+","+current.getName());
                                }
                            }
                            else
                            {
                                map.put(line[i], current.getName());
                            }
                        }
                        //map is empty
                        else
                        {
                            map.put(line[i], current.getName());
                        }
                    }
                }
            }
            catch (IOException e) {
                System.out.println("Exception!!");
            }
            allFiles.add(current.getName());
        }
        return map;
    }

//    public String similarWords(String current)
//    {
//        if (current.startsWith("+")||current.startsWith("-"))
//        {
//            current=current.substring(1);
//        }
//        StringBuilder similar=new StringBuilder();
//        ArrayList<Character>currentWord=new ArrayList<Character>();
//        for (int i = 0; i <current.length() ; i++) {
//            currentWord.add(current.charAt(i));
//        }
//
//        for (String word:map.KeySet())
//        {
//            ArrayList<Character>temp=new ArrayList<Character>();
//            for (int i = 0; i <word.length() ; i++) {
//                temp.add(word.charAt(i));
//            }
//            if (currentWord.size()> temp.size())
//            {
//
//            }
//            else if (currentWord.size()< temp.size())
//            {
//
//            }
//            else
//            {
//
//            }
//        }
//
//    }

    public String queryPerformer(String query,UnsortedTableMap<String,String>map) throws IllegalStateException
    {

        UnsortedTableMap<String,String>myMap = map;
        query=query.toLowerCase();
        String [] queries=query.split(" ");

        String result="";
        List<String> OrList=new ArrayList<>();

        for (int i = 0; i <queries.length ; i++) {

            if (queries[i].equals("dream")){}
            //And
            if (!queries[i].startsWith("-") && !queries[i].startsWith("+"))
            {
                //founded
                if (myMap.get(queries[i])!=null)
                {
                    //first ((And)) Word we arrive
                    if (result.equals(""))
                    {
                        result=myMap.get(queries[i]);
                    }
                    //other ((And)) Words
                    else
                    {
                        if (!myMap.get(queries[i]).equals(result))
                        {
                            String [] temp=result.split(",");
                            StringBuilder temp1= new StringBuilder();
                            String newQuery= myMap.get(queries[i]);
                            for (int j = 0; j < temp.length ; j++) {
                                if (newQuery.contains(temp[j])){
                                    temp1.append(temp[j]).append(",");}
                            }
                            result= temp1.substring(0, temp1.length()-1);
                        }
                    }
                }
                //not founded
                else
                {
                    //------------------------------------------------------------------------
                    throw new IllegalStateException("This Word does not exist in Documents!!");
                }
            }
            //Not
            else if (queries[i].startsWith("-"))
            {

                //first ((Not)) Word we arrive
                if (result.equals(""))
                {
                    if (myMap.get(queries[i].substring(1))!=null)
                    {
                        String not=myMap.get(queries[i].substring(1));
                        StringBuilder temp=new StringBuilder();
                        for (String cur:allFiles)
                        {
                            if (!not.contains(cur))
                            {
                               temp.append(cur).append(",");
                            }
                        }
                        result= temp.substring(0, temp.length()-1);
                    }
                }
                //other ((Not)) Words
                else
                {
                    if (myMap.get(queries[i].substring(1))!=null)
                    {
                        if (!myMap.get(queries[i].substring(1)).equals(result))
                        {
                            String [] temp=result.split(",");
                            StringBuilder temp1= new StringBuilder();
                            String temp2= myMap.get(queries[i].substring(1));
                            for (int j = 0; j < temp.length ; j++) {
                                if (!temp2.contains(temp[j])){
                                    temp1.append(temp[j]).append(",");}
                            }
                            if (temp1.length()>0){
                                result= temp1.substring(0, temp1.length()-1);
                            }
                            else if (temp2.contains(temp[0]))
                            {
                                result="";
                            }
                        }
                        else
                        {
                            //all the documents with other words has this word!!
                            result="";
                        }
                    }
                }
            }
            //Or
            else if (queries[i].startsWith("+"))
            {
                if (myMap.get(queries[i].substring(1))!=null)
                {
                    if (!myMap.get(queries[i].substring(1)).equals(result))
                    {
                        //add all Documents with this word to a list
                        String [] temp=myMap.get(queries[i].substring(1)).split(",");
                        for (int j = 0; j < temp.length ; j++) {
                            if (!OrList.contains(temp[j])){
                                OrList.add(temp[j]);}
                        }
                    }
                    else
                    {
                        //all the documents has atLeast one of these words!!
                    }
                }
            }

        }
        String []order;
        if (OrList.size()>0)
        {
            order=result.split(",");
            result="";
            for (String current:order)
            {
                if (OrList.contains(current))
                {
                    result+=current+",";
                }
            }
        }
        order=result.split(",");
        result=order.length+"\n"+result;
        return result;
    }

}

