class Solution {
    public String addBinary(String a, String b) {
        int diff = a.length() - b.length();
        StringBuilder buffer = new StringBuilder("");
        for (int i = 0; i < Math.abs(diff); i++) buffer.append("0");
        if (diff < 0)
            a = buffer.append(a).toString();
        else
            b = buffer.append(b).toString();
        a = "0" + a;
        b = "0" + b;

        int[] result = new int[a.length()];
        for (int i = a.length()-1; i >= 1 ; i--) {
            int bitAdd = Character.getNumericValue(a.charAt(i)) + Character.getNumericValue(b.charAt(i));
            if (result[i] + bitAdd == 1)
                result[i] = 1;
            else if (result[i] + bitAdd == 2) {
                result[i] = 0;
                result[i-1] = 1;
            }else if (result[i] + bitAdd == 3) {
                result[i] = 1;
                result[i-1] = 1;
            }
        }

        StringBuilder resultStr = new StringBuilder("");
        for (int i = 0; i < result.length; i++) {
            if (i == 0 && result[0] == 0) continue;
            resultStr.append(String.valueOf(result[i]));
        }

        return resultStr.toString();
    }
}