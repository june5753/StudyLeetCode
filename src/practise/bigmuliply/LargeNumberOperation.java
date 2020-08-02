package practise.bigmuliply;

public class LargeNumberOperation {

    //负号的处理还有问题
    public String operation(String numSymbol, int num2) {
        boolean hasSymbol = false;
        String num1 = numSymbol;

        if (numSymbol.startsWith("-") || numSymbol.startsWith("+")) {
            num1 = numSymbol.substring(1);
            hasSymbol = true;
        }
        char[] chars1 = num1.toCharArray();
        long[] result = new long[chars1.length];
        long[] n1 = new long[chars1.length];

        for (int i = 0; i < chars1.length; i++) {
            n1[i] = chars1[i] - '0';
        }
        for (int i = 0; i < chars1.length; i++) {
            result[i] = (long) (n1[i] * num2 * Math.pow(10, chars1.length - i - 1));
        }
        long resultlast = 0;
        for (long l : result) {
            resultlast += l;
        }
        String resultlastStr;
        if (hasSymbol) {
            resultlastStr = "" + numSymbol.substring(0, 1) + resultlast;
        } else {
            resultlastStr = "" + resultlast;
        }
        return resultlastStr;
    }
}
