import java.util.Scanner;

public class StudentGradeCalculator {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int tot_sub = 0;
        double tot_marks = 0.0;

        System.out.print("Enter total num of subjects you have: ");
        tot_sub = s.nextInt();
        double[] sub_marks = new double[tot_sub];

        for(int i=0; i<tot_sub; i++){
            System.out.print("Enter marks obtained in subject "+ (i+1) +" (out of 100): ");
            sub_marks[i] = s.nextDouble();
            tot_marks += sub_marks[i];
        }

        double avg_percentage = tot_marks / tot_sub;

        System.out.println("\n<<<<<<<<<<<< RESULTS >>>>>>>>>>>>\n");
        System.out.println("Total marks secured: " + String.format("%.2f",tot_marks) +" out of " + tot_sub*100);
        System.out.printf("Average percentage: %.2f%% \n",avg_percentage);

       String grade;
        if(avg_percentage>=90){
           grade = "A+";
        }else if(avg_percentage>=80){
            grade = "A";
        }else if(avg_percentage>=70){
            grade = "B";
        }else if(avg_percentage>=60){
            grade = "C";
        }else if(avg_percentage>=50){
            grade = "D";
        }else if(avg_percentage>=40){
            grade = "E";
        }else{
            grade = "F";
        }

        System.out.println("Grade: "+grade);
    
        s.close();
    }
}
