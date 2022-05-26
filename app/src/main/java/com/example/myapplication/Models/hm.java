package com.example.myapplication.Models;

import java.util.*;
import java.util.Locale;
import java.util.Scanner;

public class hm {

    interface Vigenere {
        void Vigenere();
    }

    interface DE_Vigenere  {
        void DE_Vigenere();
    }

    interface Vernam  {
        void Vernam();
    }

    interface DE_Vernam  {
        void DE_Vernam();
    }

        public String vigenere  ( String str )  {
            String res = "";
//          Scanner in = new Scanner(System.in);
//          System.out.print("Введите пожалуйста слово , котрое хотели бы зашифровать - ");
//          String Str = in.nextLine().toUpperCase(Locale.ROOT);
            String Str = str.toUpperCase(Locale.ROOT);
            System.out.print("Ваше слово - " + Str + "\n");
 //         System.out.print("Введите пожалуйста ключ шифрования - ");
  //        String key = in.nextLine().toUpperCase(Locale.ROOT);
            String key = "123".toUpperCase(Locale.ROOT);
            int x = 0;
            for (int i = 0; i < Str.length(); i++) {
                int cint =  Str.charAt(i);
                if (cint < 91 && cint > 64) {
                    res += (char) ((cint + (int) key.charAt(x++) - 130) % 26 + 65);
                    if (x == key.length())
                        x = 0;
                } else
                    res += Str.charAt(i);
            }
            return res;
          //  System.out.print( "Результат - " + res + "\n-------------------------------\n" );
        };

        public String DE_Vigenere  ( String str )  {
            String res = "";
            //Scanner in = new Scanner(System.in);
           // System.out.print("Введите пожалуйста слово , котрое хотели бы расшифровать - ");
            String Str = str.toUpperCase(Locale.ROOT);
           // String Str = in.nextLine().toUpperCase(Locale.ROOT);
          //  System.out.print("Введите пожалуйста ключ шифрования - ");
           // String keyw = in.nextLine().toUpperCase(Locale.ROOT);
            String keyw = "123".toUpperCase(Locale.ROOT);
            int x = 0;
            for (int i = 0; i < Str.length() ; i++) {
                if (Character.isLetter(Str.charAt(i))) {
                    int tmp = ((int) (Str.charAt(i)) - (int) keyw.charAt(x++) )  % 26;
                    if (tmp>=0)
                        res += (char)(tmp + 65);
                    else res+= (char)(91 + tmp);
                    if (x == keyw.length())
                        x = 0;
                }
                else
                    res += Str.charAt(i);
            }
            return res;
            //System.out.print( "Результат - " + res + "\n-------------------------------\n" );
        };

        public void Vernam  ()  {
            String res = "";
            Scanner in = new Scanner(System.in);
            System.out.print("Введите пожалуйста слово , котрое хотели бы зашифровать - ");
            String Str = in.nextLine().replace(" ", "").toUpperCase(Locale.ROOT);
            System.out.print("Ваше слово - " + Str + "\n");
            System.out.print("Введите пожалуйста ключ шифрования - ");
            String key = in.nextLine().toUpperCase(Locale.ROOT);
            int x = 0;
            for (int i = 0; i < Str.length() ; i++) {
                int cint = Str.charAt(i);
                if (cint < 91 && cint > 64)
                    res += (char)((cint + (int)key.charAt(x++) - 130) % 26 + 65);
                else
                    res += Str.charAt(i);
            }
            System.out.println( "Результат - " + res + "\n-------------------------------");
        };

        public void DE_Vernam () {
            String res = "";
            Scanner in = new Scanner(System.in);
            System.out.print("Введите пожалуйста слово , котрое хотели бы расшифровать - ");
            String Str = in.nextLine().toUpperCase(Locale.ROOT);
            System.out.print("Введите пожалуйста ключ шифрования - ");
            String keyw = in.nextLine().toUpperCase(Locale.ROOT);

            int x = 0;
            for (int i = 0; i < Str.length() ; i++) {
                int tmp = ((int) Str.charAt(i) - (int)keyw.charAt(x++)) % 26;
                if (tmp >= 0)
                    res += (char)(tmp + 65);
                else res += (char)(91 + tmp);
            }
            System.out.print( "Результат - " + res + "\n-------------------------------\n" );
        };

//    public static void main(String[] args) {
//        System.out.println("Шифрование методом Вижнера \n-------------------------------");
//        vigenere.Vigenere();// message - " Parola Mea " ;  key - " BEC "
//        System.out.println("ДЕШифрование методом Вижнера \n-------------------------------");
//        de_Vigenere.DE_Vigenere(); // message - " QETPPC NIC "  ; key - " BEC "
//        System.out.println("Шифрование методом Вернама \n-------------------------------");
//        vernam.Vernam(); // message - " la multi ani " ;  key - " VIDAGTSROL "
//        System.out.println("ДЕШифрование методом Вернама \n-------------------------------");
//        de_vernam.DE_Vernam(); // message - "  GIPURMARBT " ;  key - " VIDAGTSROL "
//    }

}
