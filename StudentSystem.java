import java.util.*;

class Learner {
    int learnerId;
    String fullName;
    String emailAddress;
    List<Subject> enrolledSubjects = new ArrayList<>();

    public Learner(int learnerId, String fullName, String emailAddress) {
        this.learnerId = learnerId;
        this.fullName = fullName;
        this.emailAddress = emailAddress;
    }

    void enrollSubject(Subject subject) {
        enrolledSubjects.add(subject);
    }

    void listSubjects() {
        System.out.println("Subjects Enrolled:");
        for (Subject s : enrolledSubjects) {
            System.out.println("- " + s.subjectName);
        }
    }
}

class Subject {
    String subjectCode;
    String subjectName;
    boolean trainingCompleted;

    public Subject(String subjectCode, String subjectName) {
        this.subjectCode = subjectCode;
        this.subjectName = subjectName;
        this.trainingCompleted = false;
    }
}

class Assessment {
    String subjectCode;
    int marksScored;

    public Assessment(String subjectCode, int marksScored) {
        this.subjectCode = subjectCode;
        this.marksScored = marksScored;
    }
}

class ReportCard {
    Learner learner;
    Map<String, Integer> subjectMarks = new HashMap<>();

    void recordAssessment(Assessment assessment) {
        subjectMarks.put(assessment.subjectCode, assessment.marksScored);
    }

    void displayReport() {
        System.out.println("Report Card:");
        for (String sub : subjectMarks.keySet()) {
            System.out.println(sub + ": " + subjectMarks.get(sub));
        }
    }
}

class SchoolAdmin {
    List<Learner> learners = new ArrayList<>();
    List<Subject> subjects = new ArrayList<>();
    Map<Integer, ReportCard> reportCards = new HashMap<>();

    void addLearner(String name, String email) {
        int id = learners.size() + 1;
        Learner l = new Learner(id, name, email);
        learners.add(l);
        System.out.println("Learner Registered: " + name + " with ID: " + id);
    }

    void addSubject(String code, String name) {
        subjects.add(new Subject(code, name));
        System.out.println("Subject Added: " + name);
    }

    void assignTraining(int learnerId, String subjectCode) {
        Learner l = getLearnerById(learnerId);
        Subject s = getSubjectByCode(subjectCode);
        if (l != null && s != null) {
            s.trainingCompleted = true;
            l.enrollSubject(s);
            System.out.println("Learner " + l.fullName + " trained in " + s.subjectName);
        }
    }

    void recordMarks(int learnerId, String subjectCode, int marks) {
        Learner l = getLearnerById(learnerId);
        if (l != null) {
            ReportCard r = reportCards.getOrDefault(l.learnerId, new ReportCard());
            r.learner = l;
            r.recordAssessment(new Assessment(subjectCode, marks));
            reportCards.put(l.learnerId, r);
            System.out.println("Assessment recorded for " + l.fullName);
        }
    }

    void showReport(int learnerId) {
        ReportCard r = reportCards.get(learnerId);
        if (r != null) {
            r.displayReport();
        } else {
            System.out.println("No report found.");
        }
    }

    Learner getLearnerById(int id) {
        for (Learner l : learners) {
            if (l.learnerId == id) return l;
        }
        return null;
    }

    Subject getSubjectByCode(String code) {
        for (Subject s : subjects) {
            if (s.subjectCode.equalsIgnoreCase(code)) return s;
        }
        return null;
    }
}

public class StudentSystem {
    public static void main(String[] args) {
        SchoolAdmin admin = new SchoolAdmin();
        Scanner scanner = new Scanner(System.in);
        int option;

        do {
            System.out.println("\n=== Learner Management Portal ===");
            System.out.println("1. Register Learner");
            System.out.println("2. Add Subject");
            System.out.println("3. Assign Training");
            System.out.println("4. Record Assessment");
            System.out.println("5. Show Report Card");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");
            option = scanner.nextInt();

            switch (option) {
                case 1:
                    scanner.nextLine();
                    System.out.print("Learner Name: ");
                    String learnerName = scanner.nextLine();
                    System.out.print("Email Address: ");
                    String learnerEmail = scanner.nextLine();
                    admin.addLearner(learnerName, learnerEmail);
                    break;

                case 2:
                    scanner.nextLine();
                    System.out.print("Subject Code: ");
                    String subjectCode = scanner.nextLine();
                    System.out.print("Subject Name: ");
                    String subjectName = scanner.nextLine();
                    admin.addSubject(subjectCode, subjectName);
                    break;

                case 3:
                    System.out.print("Learner ID: ");
                    int learnerId = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Subject Code: ");
                    String subCode = scanner.nextLine();
                    admin.assignTraining(learnerId, subCode);
                    break;

                case 4:
                    System.out.print("Learner ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Subject Code: ");
                    String sub = scanner.nextLine();
                    System.out.print("Marks: ");
                    int marks = scanner.nextInt();
                    admin.recordMarks(id, sub, marks);
                    break;

                case 5:
                    System.out.print("Learner ID: ");
                    int reportId = scanner.nextInt();
                    admin.showReport(reportId);
                    break;

                case 0:
                    System.out.println("Session ended.");
                    break;
            }
        } while (option != 0);

        scanner.close();
    }
}
