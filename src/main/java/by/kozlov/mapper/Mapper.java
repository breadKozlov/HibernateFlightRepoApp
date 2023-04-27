package by.kozlov.mapper;

public interface Mapper<F, T> {

    T mapFrom(F object);
}
