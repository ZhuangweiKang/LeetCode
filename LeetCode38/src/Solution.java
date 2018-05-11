class Solution {
    public String countAndSay(int n) {
        if (n == 1) return "1";
        String temp = "1";
        for (int i = 2; i <= n; i++) {
            temp = countAndSayHelper(temp);
        }
        return temp;
    }

    private String countAndSayHelper(String temp) {
        char[] chrArray = temp.toCharArray();
        char x = chrArray[0];
        int count = 0;
        StringBuffer result = new StringBuffer("");
        for (char chr: chrArray) {
            if (x != chr) {
                result.append(Integer.toString(count)).append(String.valueOf(x));
                x = chr;
                count = 0;
            }
            count++;
        }
        result.append(Integer.toString(count)).append(String.valueOf(x));
        return result.toString();
    }
}