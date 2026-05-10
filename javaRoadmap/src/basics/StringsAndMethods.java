package basics;

import java.util.Arrays;

public class StringsAndMethods {
    public void stringsAndMethods(){
        String string_number_one = new String("String Number One"); // created using the constructor
        String string_number_two = "String Number Two";// created using Java String Literals Java compiler will internally figure out how to create a new Java String representing the given text
        //text blocks
        String string_text_block = """
                String Text Block
                You can use "quotes" in here
                                   without escaping them
                """;
        // When concatenating Strings you have to watch out for possible performance problems.
        // string_number_three = string_number_one + string_number_two
        // Concatenating two Strings in Java will be translated by the Java compiler to something like this
        String string_number_three = new StringBuilder(string_number_one).append(string_number_two).toString();
        String[] string_array = {"one", "two", "three"};



        System.out.println("string_number_one -> " + string_number_one);
        System.out.println("string_number_two -> " + string_number_two);
        System.out.println("string_text_block -> " + string_text_block);
        System.out.println("string_number_three -> " + string_number_three);
        System.out.println("string_array -> " + Arrays.toString(string_array));
        System.out.println("string_number_one length -> " + string_number_one.length());
        System.out.println("string_number_one substring -> " + string_number_one.substring(0,11));
        System.out.println("string_number_one index of substring One -> " + string_number_one.indexOf("One"));
        System.out.println("string_number_one matches 'One' -> " + string_number_one.matches("One"));
        //Some methods
        //equals()
        //equalsIgnoreCase()
        //startsWith()
        //endsWith()
        //compareTo()
        //replace()
        //replaceFirst()

        //Escape Characters
        //\\	Translated into a single \ character in the String
        //\t	Translated into a single tab character in the string
        //\r	Translated into a single carriage return character in the string
        //\n	Translated into a single new line character in the string
        System.out.println("\t" + string_number_one + " with a tab in the beginning");






    }
}
