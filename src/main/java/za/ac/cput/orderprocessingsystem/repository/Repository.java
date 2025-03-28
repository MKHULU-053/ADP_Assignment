package za.ac.cput.orderprocessingsystem.repository;

public interface Repository <T, ID>{
    T create(T t);
    T read(ID id);
    T update(T t);
    void delete(ID id);
}
