package strings.easy;

/*
    Write a function that takes in a non-empty string and returns its run-length encoding.
    e.g. "AAA" -> 3A

    However, for edge cases of 10 or greater run-lengths we need to handle it a certain way.
    e.g. "AAAAAAAAAAAA" (12 As) cannot be 12A as 12A can be interpreted as "1AA". In order to avoid confusion,
    return "9A3A".

    Sample Input: string = "AAAAAAAAAAAAABBCCCCDD";

    Sample Output: "9A4A2B4C2D"
*/

public class RunLengthEncoding {

    public static void main(String[] args) {
        String str = "AAAAAAAAAAAAABBCCCCDD";
        String result = runLengthEncoding(str);
        System.out.println(result);
    }

    /**
     * @param str - the string input
     * @return - string run-length of encoding
     */
    public static String runLengthEncoding(String str) {
        StringBuilder outputList = new StringBuilder();
        int currentRunLength = 1;

        for (int i = 1; i < str.length(); i++) {
            char currentChar = str.charAt(i);
            char prevChar = str.charAt(i - 1);

            if ((currentChar != prevChar) || (currentRunLength == 9)) {
                outputList.append(currentRunLength);
                outputList.append(prevChar);
                currentRunLength = 0;    // reset run length. can be 0 since it's not the start
            }
            currentRunLength += 1;    // increment count if current == prev
        }
        outputList.append(currentRunLength);
        outputList.append(str.charAt(str.length() - 1));

        return outputList.toString();    // convert back to string
    }

}

/*
    1. Create a StringBuilder to store output.
    2. Input string is guaranteed to be non-empty so length run count will be at least 1 (init. length = 1).
    3. Traverse the string comparing the current letter with the previous letter.
    4. If the prev and current do not match, or if the current length is 9,
        Add length to output along with associated letter. Reset the length to 0.
     5. Else, the length = length + 1.
     6. To handle the last run,
        Add length to output along with associated letter. Reset the length to 0.
        Return output.
*/

