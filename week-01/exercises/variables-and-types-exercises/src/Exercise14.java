public class Exercise14 {
        public static void main(String[] args) {
            int gradeLevel = 12;
            boolean isSenior = gradeLevel == 12;
            boolean isInterestedInVolunteering = true;
            boolean shouldSendVolunteerInfo = isSenior && isInterestedInVolunteering;

            System.out.println("Grade Level: " + gradeLevel);
            System.out.println("Is Senior: " + isSenior);
            System.out.println("Is Interested in Volunteering: " + isInterestedInVolunteering);
            System.out.println("Should Send Volunteer Info: " + shouldSendVolunteerInfo);


        }
    }

