class Solution {
    public String complexNumberMultiply(String num1, String num2) {

        String[] p1 = num1.split("\\+|i");
        String[] p2 = num2.split("\\+|i");

        int a = Integer.parseInt(p1[0]);
        int b = Integer.parseInt(p1[1]);
        int c = Integer.parseInt(p2[0]);
        int d = Integer.parseInt(p2[1]);

        int real = a * c - b * d;
        int imag = a * d + b * c;

        return real + "+" + imag + "i";
    }
}
