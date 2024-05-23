package utils;

import java.util.Random;

public class RandomMethods {

    public static String randomName(){
        String[] names={"Anna","Misha", "Jon", "Bob", "Jane"};
        return names[new Random().nextInt(names.length-1)];
    }
    public static String randomLastName(){
        String[] names={"Maxop","Swift", "Monro", "Pushkin", "Dow"};
        return names[new Random().nextInt(names.length-1)];
    }
    public static String randomEmail(){
        String[] names={"Anna","Misha", "Jon", "Bob", "Jane"};
        String[] lastNames={"Maxop","Swift", "Monro", "Pushkin", "Dow"};
        return names[new Random().nextInt(names.length-1)]+"_"+lastNames[new Random().nextInt(names.length-1)]+"@mail.com";
    }
    public static String randomPhone(int length){
        String digits = "0123456789";
        String res = "";
        for (int i = 0; i < length; i++) {
            res = res+ String.valueOf(digits.charAt( new Random().nextInt(digits.length()-1)));
        }
        return res;
    }
}
