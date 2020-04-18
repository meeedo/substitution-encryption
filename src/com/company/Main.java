package com.company;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.channels.FileLockInterruptionException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static ArrayList<String> readfile(File file) throws IOException {
        ArrayList<String> temp = new ArrayList<String>();
        BufferedReader br = new BufferedReader(new FileReader(file));

        String st;
        while ((st = br.readLine()) != null) {
            temp.add(st);
        }
        return temp;
    }
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);
        System.out.println("enter the data to be encrypted : ");
        String data = scanner.nextLine();
        String cypher = encryption(data);
        System.out.println(cypher);

        System.out.println("enter the data to be decrypted : ");
        String encrypted = scanner.nextLine();
        String originaltext = decryption(encrypted);
        System.out.println(originaltext);
    }
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public static String encryption (String data ) throws IOException {
        ArrayList<String> dectionaryen = new ArrayList<String>();
        ArrayList<Character> finaldataen = new ArrayList<Character>();
        ArrayList<Character> finalcodeen = new ArrayList<Character>();
        File file = new File("C:\\Users\\RS3\\Desktop\\file.txt");
        dectionaryen = readfile(file);
        String alpha , code;
        alpha = dectionaryen.get(0);
        code = dectionaryen.get(1);
        for (int  i = 0 ; i < alpha.length() ; i++)
        {
            finaldataen.add(alpha.charAt(i));
            finalcodeen.add(code.charAt(i));
        }
        String cyphertext = new String();

        for (int i = 0 ; i < data.length() ; i++)
        {
            for (int j = 0 ; j < finaldataen.size() ; j ++) {
                if (  finaldataen.get(j).equals(data.charAt(i)) )
                {
                    cyphertext += finalcodeen.get(j);
                }
            }
        }
        return cyphertext;
    }
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
public static String decryption (String data ) throws IOException {
    ArrayList<String> dectionaryde = new ArrayList<String>();
    ArrayList<Character> finaldatade = new ArrayList<Character>();
    ArrayList<Character> finalcodede = new ArrayList<Character>();
    File file = new File("C:\\Users\\RS3\\Desktop\\file.txt");
    dectionaryde = readfile(file);
    String alpha , code;
    alpha = dectionaryde.get(0);
    code = dectionaryde.get(1);
    for (int  i = 0 ; i < alpha.length() ; i++)
    {
        finaldatade.add(alpha.charAt(i));
        finalcodede.add(code.charAt(i));
    }
    String originaltext = new String();


    for (int i = 0 ; i < data.length() ; i++)
    {
        for (int j = 0 ; j < finalcodede.size() ; j ++) {
            if (  finalcodede.get(j).equals(data.charAt(i)) )
            {
                originaltext += finaldatade.get(j);
            }
        }
    }
    return originaltext;
}
}
