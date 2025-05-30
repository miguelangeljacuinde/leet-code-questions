package strings.easy;

/*
    Given a non-empty string of lowercase letters and a non-negative int representing a key,
    write a function that returns a new string obtained by shifting every letter in the input by k
    positions in the alphabet, where k is the key.

    Note: Letters should wrap around the alphabet; in other words, the letter 'z' shifted by one
    returns the letter 'a'.

    Input: string = "xyz"
                  key = 2

    Output: "zab"
 */

public class CaesarCipherEncryptor {
    public static void main(String[] args) {
        String string = "xyz";
        int key = 2;

        System.out.println(caesarCypherEncryptor(string, key));
    }

    /**
     * @param str - the input string
     * @param key - the input key
     * @return - caesar cipher encrypted string
     */
    public static String caesarCypherEncryptor(String str, int key) {
        char[] output = new char[str.length()];
        int newKey = key % 26;

        for (int i = 0; i < str.length(); i++) {
            output[i] = getNewLetter(str.charAt(i), newKey);
        }
        return new String(output);
    }

    /**
     * @param letter - input string letter at idx
     * @param key    - the input key
     * @return - the encrypted letter
     */
    public static char getNewLetter(char letter, int key) {
        int newLetterCode = letter + key;
        return newLetterCode <= 122 ? (char) newLetterCode : (char) (96 + newLetterCode % 122);
    }

}

/*
    1. Init. a char output array of size input string length.
    2. Init. a new key = input key % 26. In case you get a really large key % 26.
    3. Traverse the string, fetch new letter (encoded letter).
        New letter = input letter + key.
        a. If the new letter <= 122 return the new letter.
        b. Else, return new letter + 96 % 122.
    4. Return the encoded string.
*/