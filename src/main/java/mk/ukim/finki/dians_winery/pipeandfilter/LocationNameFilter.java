package mk.ukim.finki.dians_winery.pipeandfilter;

import java.util.ArrayList;
import java.util.List;

public class LocationNameFilter implements Filter<String> {

    @Override
    public String execute(String input) {
        if (input == null) {
            return null;
        }
        String[] string = input.split("\t");

        List<String> output = new ArrayList<>();
        output.add(string[0]);
        output.add(string[1]);
        output.add(string[2]);

        return String.join("\t", output);
    }
}
