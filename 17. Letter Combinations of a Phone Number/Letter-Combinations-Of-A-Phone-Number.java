class Solution {
    public List<String> letterCombinations(String digits) {
        
        ArrayList<String> list = new ArrayList<>();
        if(digits.equals(""))
            return list;
        printKeypad(digits, "", list);
        return list;
    }
    public static void printKeypad(String num, String str, ArrayList<String> list) {
        if (num.length() == 0) {
            list.add(str);
//            System.out.println(str);
            return;
        }
        String st = helper(num.substring(num.length() - 1));
        for (int i = 0; i < st.length(); ++i) {
            printKeypad(num.substring(0, num.length() - 1), st.charAt(i) + str, list);
        }

    }

    public static String helper(String n) {
        switch (n) {
            case "2":
                return "abc";

            case "3":
                return "def";

            case "4":
                return "ghi";

            case "5":
                return "jkl";

            case "6":
                return "mno";

            case "7":
                return "pqrs";

            case "8":
                return "tuv";

            case "9":
                return "wxyz";

            default:
                break;
        }
        return "";
    }
}
