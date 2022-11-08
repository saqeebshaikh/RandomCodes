public class RunLengthEncodingDemo {
    /*
    Input  - aaabbaabccc
    Output - 3a2b2a1b3c
     */

    public static void main(String[] args) {
        System.out.println(myRLE("abcabc"));
    }

    private static String myRLE(String input) {
        StringBuilder outputBuilder = new StringBuilder();
        int count = 1;
        for(int i=0; i<input.length(); i++) {
            final char currentChar = input.charAt(i);
            System.out.println("Current char :: "+currentChar+", index :: "+i);
            if(i+1 == input.length()) {
                 return outputBuilder.append(count).append(currentChar).toString();
            }
            if(currentChar == input.charAt(i+1)) {
                count++;
            } else {
                outputBuilder.append(count).append(currentChar);
                System.out.println("Adding :: "+outputBuilder);
                count=1;
            }
        }
        return outputBuilder.toString();
    }
}
