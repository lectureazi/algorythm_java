package f_divideandconcure.quiz;

import java.util.ArrayList;
import java.util.List;

public class Quiz {

    public static void main(String[] args) {

    }

    static void q1(){

    }

    static void q2(){
        List<Meeting> meetings = createMeetings();

    }

    private static List<Meeting> createMeetings() {
        List<Meeting> meetings = new ArrayList<Meeting>();
        meetings.add(new Meeting("개발", 1, 10));
        meetings.add(new Meeting("기획", 5, 6));
        meetings.add(new Meeting("인사", 13, 15));
        meetings.add(new Meeting("총무", 14, 17));
        meetings.add(new Meeting("QA", 8, 14));
        meetings.add(new Meeting("CS", 3, 12));
        return meetings;
    }
}
