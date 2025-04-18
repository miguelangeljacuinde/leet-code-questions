package stacks.mid;

import java.util.Stack;

/*
    You are given an absolute path for a Unix-style file system, which always begins with a slash "/". Your task is to
    transform this absolute path into its simplified canonical path.

    The rules of a Unix-style file system are as follows:

    1. A single period "." represents the current directory.
    2. A double period  ".." represents the previous/parent directory.
    3. Multiple consecutive slashes such as "//" and "///" are treated as a single slash "/".
    4. Any sequence of periods that does not match the rules above should be treated as a valid directory or file name.
        For example, "..." and "...." are valid directory names.

    The simplified canonical path should follow these rules:
    1. The path must start with a single slash "/".
    2. Directories within the path must be separated by exactly one slash "/".
    3. The path must not end with a slash "/", unless it is the root directory.
    4. The path must not have any single or double periods used to denote current or parent directories.

    Return the simplified canonical path.

    Example 1:
        Sample Input: path = "/home/user/Documents/../Pictures"

        Sample Output: "/home/user/Pictures"

    Example 2:
        Sample Input: path = "/../"

        Sample Output: "/"

    Example 3:
        Sample Input: path = "/.../a/../b/c/../d/./"

        Sample Output: "/.../b/d/"
*/

public class SimplifyPath {
    public static void main(String[] args) {
        String path1 = "/home/user/Documents/../Pictures";
        System.out.println("Original path: " + path1);
        System.out.println("Simplified path: " + simplifyPath(path1));
        System.out.println();

        String path2 = "/../";
        System.out.println("Original path: " + path2);
        System.out.println("Simplified path: " + simplifyPath(path2));
        System.out.println();

        String path3 = "/home/";
        System.out.println("Original path: " + path3);
        System.out.println("Simplified path: " + simplifyPath(path3));
        System.out.println();

        String path4 = "/.../a/../b/c/../d/./";
        System.out.println("Original path: " + path4);
        System.out.println("Simplified path: " + simplifyPath(path4));
        System.out.println();
    }

    /**
     * @param path - the input path
     * @return - the simplified canonical path
     */
    public static String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        String[] directories = path.split("/");

        for (String dir : directories) {
            if (dir.equals(".") || dir.isEmpty()) {
                continue;
            }
            else if (dir.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                stack.push(dir);
            }
        }
        return "/" + String.join("/", stack);
    }

}

/*
    O(n) time | O(n) space
        n = length of the input path.
    1. Initialize a stack to hold the output path.
    2. Initialize a String array by splitting the input path with "/".
    3. Traverse each directory in the created String array.
        a. If current directory = "." or is empty, we continue traversing.
        b. Else if the current directory = "..", check if the stack is empty.
            i. If the stack is empty, continue.
            ii. Else, pop the stack.
        c. Else push the current directory into the stack.
    4. Return the stack using the join function to join each directory with "/".
        a. Don't forget to include the initial "/".
*/