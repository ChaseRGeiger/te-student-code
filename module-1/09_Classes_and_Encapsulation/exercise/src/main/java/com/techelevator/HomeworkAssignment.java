package com.techelevator;

public class HomeworkAssignment {

    private int earnedMarks;
    private int possibleMarks;
    private String submitterName;


    public HomeworkAssignment(int possibleMarks, String submitterName){
        this.possibleMarks = possibleMarks;
        this.submitterName = submitterName;
    }

    public int getEarnedMarks(){
        return this.earnedMarks;
    }

    public void setEarnedMarks(int earnedMarks){
        this.earnedMarks = earnedMarks;
    }

    public String getSubmitterName() {
        return submitterName;
    }

    public int getPossibleMarks() {
        return possibleMarks;
    }

    public String getLetterGrade() {
        double letterGradeNum = (double) earnedMarks / possibleMarks;
        if(letterGradeNum >= .90){
            return  "A";

        }
        else if(letterGradeNum >= .80){
            return "B";

        }
        else if(letterGradeNum >= .70){
            return "C";

        }
        else if(letterGradeNum >= .60){
            return "D";

        }
        else{
            return "F";

        }

    }
}
