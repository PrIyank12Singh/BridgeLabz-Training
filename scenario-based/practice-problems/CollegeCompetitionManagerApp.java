import java.util.*;

class ProjectTeam {

    String teamId;
    String section;
    String domain;
    String projectName;
    int projectScore;

    ProjectTeam(String teamId, String section,
                String domain, String projectName,
                int projectScore) {

        this.teamId = teamId;
        this.section = section;
        this.domain = domain;
        this.projectName = projectName;
        this.projectScore = projectScore;
    }
}

class CompetitionManager {

    List<ProjectTeam> teamList = new ArrayList<>();

    void registerTeam(String teamId, String section,
                      String domain, String projectName,
                      int score) {

        for (ProjectTeam t : teamList) {
            if (t.teamId.equals(teamId))
                return;
        }

        teamList.add(
                new ProjectTeam(teamId, section, domain, projectName, score)
        );
    }

    void reviseScore(String teamId, int newScore) {

        for (ProjectTeam t : teamList) {
            if (t.teamId.equals(teamId)) {

                t.projectScore = newScore;
                System.out.println("REVISED " + teamId + " " + newScore);
                return;
            }
        }

        System.out.println("team is not available");
    }

    void filterByDomain(String domain) {

        boolean found = false;

        for (ProjectTeam t : teamList) {

            if (t.domain.equals(domain)) {

                System.out.println(
                        t.teamId + " " +
                        t.section + " " +
                        t.domain + " " +
                        t.projectName + " " +
                        t.projectScore
                );

                found = true;
            }
        }

        if (!found)
            System.out.println(
                    "Team is not available for the domain: " + domain
            );
    }

    void qualifyTeams(int cutoff) {

        boolean found = false;

        for (ProjectTeam t : teamList) {

            if (t.projectScore >= cutoff) {

                System.out.println(
                        t.teamId + " " +
                        t.section + " " +
                        t.domain + " " +
                        t.projectName + " " +
                        t.projectScore
                );

                found = true;
            }
        }

        if (!found)
            System.out.println("No team qualified");
    }
}

public class CollegeCompetitionManagerApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        CompetitionManager manager = new CompetitionManager();

        while (n-- > 0) {

            String line = sc.nextLine();
            String[] p = line.split(" ");

            switch (p[0]) {

                case "REGISTER":
                    manager.registerTeam(
                            p[1], p[2], p[3], p[4],
                            Integer.parseInt(p[5])
                    );
                    break;

                case "REVISE":
                    manager.reviseScore(
                            p[1],
                            Integer.parseInt(p[2])
                    );
                    break;

                case "FILTERDOMAIN":
                    manager.filterByDomain(p[1]);
                    break;

                case "QUALIFY":
                    manager.qualifyTeams(
                            Integer.parseInt(p[1])
                    );
                    break;
            }
        }
    }
}