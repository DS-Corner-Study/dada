package com.springboot.advanced_jpa.data.repository;

import com.springboot.advanced_jpa.data.entity.Product;
import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ProductRepository extends JpaRepository<Product, Long> {

    // find...By
    Optional<Product> findByNumber(Long number);
    List<Product> findAllByName(String name);
    Product queryByNumber(Long number);

    // exists...By
    boolean existsByNumber(Long number);

    // count...By
    long countByName(String name);

    // delete...By, remove...By
    void deleteByNumber(Long number);
    long removeByName(String name);

    // First<number>, Top<number>
    List<Product> findFirst5ByName(String name);
    List<Product> findTop10ByName(String name);

    // Is, Equals (생략 가능)
    // findByNumber 메소드와 동일하게 동작
    Product findByNumberIs(Long number);
    Product findByNumberEquals(Long number);

    // (Is)Not
    Product findByNumberIsNot(Long number);
    Product findByNumberNot(Long number);

    // (Is)Null, (Is)NotNull
    List<Product> findByUpdatedAtNull();
    List<Product> findByUpdatedAtIsNull();
    List<Product> findByUpdatedAtNotNull();
    List<Product> findByUpdatedAtIsNotNull();

    // And, Or
    Product findByNumberAndName(Long number, String name);
    Product findByNumberOrName(Long number, String name);

    // (Is)GreaterThan, (Is)LessThan, (Is)Between
    List<Product> findByPriceIsGreaterThan(Long price);
    List<Product> findByPriceGreaterThan(Long price);
    List<Product> findByPriceGreaterThanEqual(Long price);
    List<Product> findByPriceIsLessThan(Long price);
    List<Product> findByPriceLessThan(Long price);
    List<Product> findByPriceLessThanEqual(Long price);
    List<Product> findByPriceIsBetween(Long lowPrice, Long highPrice);
    List<Product> findByPriceBetween(Long lowPrice, Long highPrice);

    // (Is)Like, (Is)Containing, (Is)StartingWith, (Is)EndingWith
    List<Product> findByNameLike(String name);
    List<Product> findByNameIsLike(String name);

    List<Product> findByNameContains(String name);
    List<Product> findByNameContaining(String name);
    List<Product> findByNameIsContaining(String name);

    List<Product> findByNameStartsWith(String name);
    List<Product> findByNameStartingWith(String name);
    List<Product> findByNameIsStartingWith(String name);

    List<Product> findByNameEndsWith(String name);
    List<Product> findByNameEndingWith(String name);
    List<Product> findByNameIsEndingWith(String name);

    // Asc : 오름차순, Desc : 내림차순 (예제 8.13)
    List<Product> findByNameOrderByNumberAsc(String name);
    List<Product> findByNameOrderByNumberDesc(String name);

    // 여러 정렬 기준 사용 & And를 붙이지 X
   List<Product> findByNameOrderByPriceAscStockDesc(String name);

    // 매개변수를 활용한 정렬 방법
    List<Product> findByName(String name, Sort sort);


    Page<Product> findByName(String name, Pageable pageable);

    @Query("SELECT p FROM Product p WHERE p.name = ?1")
    List<Product> findByName(String name);

    @Query("SELECT p FROM Product p WHERE p.name = :name")
    List<Product> findByNameParam(@Param("name") String name);

    @Query("SELECT p.name, p.price, p.stock FROM Product p WHERE p.name = :name")
    List<Object[]> findByNameParam2(@Param("name") String name);


}
