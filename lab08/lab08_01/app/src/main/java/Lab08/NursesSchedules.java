package Lab08;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class NursesSchedules {
    public static void main(String args[]) throws IOException {
        for(int i = 1; i <= 6; i++)
            create_nurses_schedules(i);
    }

    public static void create_nurses_schedules(int nurseNumber) throws IOException {
        Patient p = new Patient();

        String[] names = {"Margaret Atwood", "Alexander Solzhenitsyn", "Charles Dickens", "Williams Wordsworth", "Homer", "Socrates"};
        String[] shifts = {"8 am to 4 pm", "4 pm to midnight",  "midnight to 8 am"};

        LocalTime shiftBlock1 = LocalTime.of(8, 0, 0);
        LocalTime shiftBlock2 = LocalTime.of(16, 0, 0);
        LocalTime shiftBlock3 = LocalTime.of(0, 0, 0);

        Nurse n = new Nurse();
        n.setName(names[nurseNumber - 1]);
        if(nurseNumber % 2 == 0)
            n.setShift(shifts[(nurseNumber / 2) - 1]);
        else
            n.setShift(shifts[((nurseNumber + 1) / 2) - 1]);

        Random rand = new Random();
        int randomPatientNumber = rand.nextInt((20 - 1) + 1) + 1;
        int randomHourNumber = rand.nextInt((7 - 1) + 1) + 1;

        LocalTime shiftedBlock;
        if(nurseNumber == 1 || nurseNumber == 2)
            shiftedBlock = shiftBlock1.plusHours(randomHourNumber);
        else if(nurseNumber == 3 || nurseNumber == 4)
            shiftedBlock = shiftBlock2.plusHours(randomHourNumber);
        else
            shiftedBlock = shiftBlock3.plusHours(randomHourNumber);

        String file = "n" + nurseNumber + "_schedule.txt";
        FileWriter myWriter = new FileWriter(file);
        myWriter.write(
                "Nurse Name: " + n.getName() + "\n" +
                        "Schedule Shift: " + n.getShift() + "\n" +
                        "Patient Number: " + randomPatientNumber + "\n" +
                        "Description Of Care: " + p.needs[randomPatientNumber % 2] + "\n" +
                        "Time Of Care: " + shiftedBlock.format(DateTimeFormatter.ofPattern("h a"))
        );

        myWriter.close();
    }
}