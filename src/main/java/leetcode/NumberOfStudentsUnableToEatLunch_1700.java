package main.java.leetcode;

/*
Question: 1700. Number of Students Unable to Eat Lunch
Link: https://leetcode.com/problems/number-of-students-unable-to-eat-lunch/
 */
public class NumberOfStudentsUnableToEatLunch_1700 {
    public static void main(String[] args) {
        var obj = new NumberOfStudentsUnableToEatLunch_1700();
        System.out.println(obj.countStudents(new int[]{1, 1, 0, 0}, new int[]{0, 1, 0, 1}));
    }

    public int countStudents(int[] students, int[] sandwiches) {
        int circularStudents = 0;
        int squareStudents = 0;
        for (int i = 0; i < students.length; i++) {
            if (students[i] == 0) {
                circularStudents++;
            } else {
                squareStudents++;
            }
        }

        for (int i = 0; i < sandwiches.length; i++) {
            if (sandwiches[i] == 0 && circularStudents > 0) {
                circularStudents--;
            } else if (sandwiches[i] == 1 && squareStudents > 0) {
                squareStudents--;
            } else {
                return circularStudents + squareStudents;
            }
        }
        return circularStudents + squareStudents;
    }
}
