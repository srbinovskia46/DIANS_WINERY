package mk.ukim.finki.dians_winery.pipeandfilter;

public interface Filter<T> {

    T execute(T input);

}