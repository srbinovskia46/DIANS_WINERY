package mk.ukim.finki.dians_winery.pipeandfilter;

public class FilterUnnamed implements Filter<String>{

    @Override
    public String execute(String input) {
        String[] string = input.split("\t");
        if (string.length < 3 || string[2].equals("")) {
            return null;
        }
        return input;
    }
}
