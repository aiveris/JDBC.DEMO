package Mindaugas.JDBC.DEMO;

public class StringFormatExample {
    public static void main(String args[]) {
        String[] names = {"Jonas", "Valentinovieninikas", "Besikiskiakopusteliaudamasis", "Petras"};

        // 0. - simple format of simple table - bad example
        for(int i = 0; i < names.length; i++){
            System.out.println("|" + names[i] + "|");
        }

        // 1. - rewrite bad example with the format string in a primitive way
        for(int i = 0; i < names.length; i++){
            System.out.format("|%30s|\n", names[i]);
        }

        // 2. - expose a parameter that would dictate which side we want to justify the text with
        for(int i = 0; i < names.length; i++){
            String justification = "-";
            System.out.format("|%" + justification + "30s|\n", names[i]);
        }

        // 3. - expose the parameter which would tell how long the column needs to be
        for(int i = 0; i < names.length; i++){
            int len = 30;
            System.out.format("|%-" + len + "s|\n", names[i]);
        }

        // 4. - make the calculation of how long each column needs to be dynamic (findMax for that column)
        // Left as a homework
    }
}