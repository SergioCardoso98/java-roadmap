package basics;

public class TypeCasting {
    public void typeCasting(){
        // 1. int → String
        int num1 = 10;
        String str = String.valueOf(num1);

        System.out.println(num1);
        System.out.println(str);

        // 2. String → int
        String data = "20";
        int num2 = Integer.parseInt(data);

        System.out.println(data);
        System.out.println(num2);

        // 3. double → int
        double num3 = 10.99;
        int num4 = (int) num3;

        System.out.println(num3);
        System.out.println(num4);
    }
}
