package lesson_1;

//one-line comment

/*
more-line comment
 */

/**
 * JavaDoc comment
 */

public class Lesson1 {

   public static void main(String[] args) {
      //Hello Java!!!
      //System.out.print("Hello Java!!!\n");
     // System.out.println("Hello World!!!");
     // System.out.print("Hello World!!!");

      String myString1 = "Hello Java!!!";
      String myString2 = "Hello World!!!";

      System.out.println(myString1);
      System.out.println(myString2);
      System.out.println(myString1 + myString2);

      //целочисленные
      byte myByte = 50; // -128..+127 (1 byte)
      short myShort = 500; // -32768..+32767 (2 byte)
      int myInteger = 5269032; // -2.1млрд..+2.1млрд (4 byte)
      long myLong = 3000000000L; // -2^63..+2^63 (8 byte)

      //с плавающей точкой

      float myFloat = 956.345f; // (4 byte) - <>.0000000
      double myDouble = 956.345; // (8 byte) - <>.00000000000000

      //symbols

      char myChar = '_'; // ASCII (2 byte)

      //boolean

      boolean myBoolean = true; // false


      int a = 45;
      int b = 55;
      int c = a + b;
      //System.out.println(c);
      System.out.println(a + b);


      int age = 18;

      if (age < 18) {
         System.out.println("Don't");
      } else if (age >65) {
            System.out.println("You old!!!");
         } else {
            System.out.println("Good luck!!!");
      }


      int abc =40;
      if (abc < 10) {
         System.out.println( abc + "<10" );
      }



      /*
      a = a + 1; -> a++
      a = a - 1; -> a--
      a = a + 45; -> a += 45; (-=, *=, /=, %=)
       */

      int qwe = 100;
      int asd = 65;
      int result;

      result = myMath (qwe, asd);
      qwe++; //qwe = qwe + 1;
      result += myMath (qwe, asd);
      asd++;
      result += myMath (qwe, asd);
      qwe++;
      result += myMath (qwe, asd);
      System.out.println(result); //666
   }

   public static int myMath (int value1, int value2) {
     return value1 + value2;
   }

   public static void doSomethingNoArgs () {
      System.out.println("this is method without args");
   }
   public static void doSomethingWihtArgs () {
      System.out.println("this is method without args");
   }

}
