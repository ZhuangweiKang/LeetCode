class Solution {
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) return "0";
        int max_length = num1.length() + num2.length();
        StringBuilder[] mediate_result = new StringBuilder[num2.length()];
        for (int i = num2.length()-1; i >= 0; i--) {
            StringBuilder temp = new StringBuilder("");
            int carry = 0;
            for (int j = num1.length()-1; j >= 0; j--) {
                int product = (num2.charAt(i) - '0') * (num1.charAt(j) - '0');
                product += carry;
                temp.insert(0, String.valueOf(product%10));
                carry = product / 10;
                if (j == 0) temp.insert(0, String.valueOf(carry));
            }
            for (int k = 0; k < num2.length() -1 - i; k++) temp.append("0");
            int temp_length = temp.length();
            for (int m = 0; m < max_length - temp_length; m++) temp.insert(0, "0");
            mediate_result[i] = temp;
        }
        int add_carry = 0;
        StringBuilder result = new StringBuilder("");
        for (int i = mediate_result[0].length()-1; i >= 0; i--) {
            int temp = 0;
            for (int j = mediate_result.length - 1; j >= 0; j--)
                temp += mediate_result[j].charAt(i) - '0';
            temp += add_carry;
            add_carry = temp / 10;
            result.insert(0, String.valueOf(temp % 10));
        }
        if (result.charAt(0) == '0') return result.substring(1);
        return result.toString();
    }
}