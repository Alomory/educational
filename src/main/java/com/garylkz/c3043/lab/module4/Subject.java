package com.garylkz.c3043.lab.module4;

/*
Activity 3
----------
Create an enumeration called as Subject
Details of enum declaration consist of following information:
1. Enum constant -> Arguments
2. CSE3501 -> ("Software Engineering Basic", "BCS(SE)")
3. CSE3502 -> ("Software Requirements Engineering", "BCS(SE)")
4. CSE3503 -> ("Software Architecture", "BCS(SE)")
5. CSE3504 -> ("Software Testing", "BCS(SE)")
6. MMM3401->("Principle of Maritime Management", "BSC(IM)")
7. CSA3501->("Maritime Informatics Technology and Application", "BSC(IM)")

The constructor for enum Subject has a signature of subject name and course name
The enum Subject has a getter for subject name and course name

For testing purposes, create new main class known as SubjectEnumTest() and write the following
implementation to test the enum Subject:
1. Display all the subjects.
2. Display the subject between subject code CSE3501 to CSE3503.
3. Display the subject code CSE3502 and CSE3504.
 */

import java.util.Arrays;

public enum Subject {
    CSE3501("Software Engineering Basic", "BCS(SE)"),
    CSE3502("Software Requirements Engineering", "BCS(SE)"),
    CSE3503("Software Architecture", "BCS(SE)"),
    CSE3504("Software Testing", "BCS(SE)"),
    MMM3401("Principle of Maritime Management", "BSC(IM)"),
    CSA3501("Maritime Informatics Technology and Application", "BSC(IM)") ;

    private final String subjectName;
    private final String departmentCode;

    Subject(String subjectName, String departmentCode) {
        this.subjectName = subjectName;
        this.departmentCode = departmentCode;
    }

    public String toString() {
         return subjectName + ", " + departmentCode;
    }

    public static void main(String[] args) {
        // 1. Display all the subjects.
        Subject[] subjects = Subject.class.getEnumConstants();
        for (Subject subject : subjects) System.out.println(subject);
        System.out.println();
        // 2. Display the subject between subject code CSE3501 to CSE3503.
        Subject[] first3 = Arrays.copyOfRange(subjects, 0, 3);
        for (Subject subject : first3) System.out.println(subject);
        System.out.println();
        // 3. Display the subject code CSE3502 and CSE3504.
        System.out.println(Subject.CSE3502);
        System.out.println(Subject.CSE3504 + "\n");
    }
}
