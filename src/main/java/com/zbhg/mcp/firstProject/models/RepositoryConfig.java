package com.zbhg.mcp.firstProject.models;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@Configuration
public class RepositoryConfig {

    @Bean
    public ItemRepository itemRepository() {
        return new ItemRepository() {
            @Override
            public <S extends ItemEntity> S save(S s) {
                return null;
            }

            @Override
            public <S extends ItemEntity> Iterable<S> saveAll(Iterable<S> iterable) {
                return null;
            }

            @Override
            public Optional<ItemEntity> findById(Integer integer) {
                return Optional.empty();
            }

            @Override
            public boolean existsById(Integer integer) {
                return false;
            }

            @Override
            public Iterable<ItemEntity> findAll() {
                return null;
            }

            @Override
            public Iterable<ItemEntity> findAllById(Iterable<Integer> iterable) {
                return null;
            }

            @Override
            public long count() {
                return 0;
            }

            @Override
            public void deleteById(Integer integer) {
            }

            @Override
            public void delete(ItemEntity item) {
            }

            @Override
            public void deleteAllById(Iterable<? extends Integer> iterable) {

            }

            @Override
            public void deleteAll(Iterable<? extends ItemEntity> iterable) {

            }

            @Override
            public void deleteAll() {

            }
        }; // Or create an instance of your repository implementation
    }

    @Bean
    public CustomerRepository customerRepository() {
        return new CustomerRepository() {
            @Override
            public <S extends CustomerEntity> S save(S entity) {
                return null;
            }

            @Override
            public <S extends CustomerEntity> Iterable<S> saveAll(Iterable<S> entities) {
                return null;
            }

            @Override
            public Optional<CustomerEntity> findById(Integer integer) {
                return Optional.empty();
            }

            @Override
            public boolean existsById(Integer integer) {
                return false;
            }

            @Override
            public Iterable<CustomerEntity> findAll() {
                return null;
            }

            @Override
            public Iterable<CustomerEntity> findAllById(Iterable<Integer> integers) {
                return null;
            }

            @Override
            public long count() {
                return 0;
            }

            @Override
            public void deleteById(Integer integer) {

            }

            @Override
            public void delete(CustomerEntity entity) {

            }

            @Override
            public void deleteAllById(Iterable<? extends Integer> integers) {

            }

            @Override
            public void deleteAll(Iterable<? extends CustomerEntity> entities) {

            }

            @Override
            public void deleteAll() {

            }
        };
    }

    @Bean
    public SaleRepository saleRepository() {
        return new SaleRepository() {
            @Override
            public void flush() {

            }

            @Override
            public <S extends SaleEntity> S saveAndFlush(S entity) {
                return null;
            }

            @Override
            public <S extends SaleEntity> List<S> saveAllAndFlush(Iterable<S> entities) {
                return null;
            }

            @Override
            public void deleteAllInBatch(Iterable<SaleEntity> entities) {

            }

            @Override
            public void deleteAllByIdInBatch(Iterable<Integer> integers) {

            }

            @Override
            public void deleteAllInBatch() {

            }

            @Override
            public SaleEntity getOne(Integer integer) {
                return null;
            }

            @Override
            public SaleEntity getById(Integer integer) {
                return null;
            }

            @Override
            public SaleEntity getReferenceById(Integer integer) {
                return null;
            }

            @Override
            public <S extends SaleEntity> List<S> findAll(Example<S> example) {
                return null;
            }

            @Override
            public <S extends SaleEntity> List<S> findAll(Example<S> example, Sort sort) {
                return null;
            }

            @Override
            public <S extends SaleEntity> List<S> saveAll(Iterable<S> entities) {
                return null;
            }

            @Override
            public List<SaleEntity> findAll() {
                return null;
            }

            @Override
            public List<SaleEntity> findAllById(Iterable<Integer> integers) {
                return null;
            }

            @Override
            public <S extends SaleEntity> S save(S entity) {
                return null;
            }

            @Override
            public Optional<SaleEntity> findById(Integer integer) {
                return Optional.empty();
            }

            @Override
            public boolean existsById(Integer integer) {
                return false;
            }

            @Override
            public long count() {
                return 0;
            }

            @Override
            public void deleteById(Integer integer) {

            }

            @Override
            public void delete(SaleEntity entity) {

            }

            @Override
            public void deleteAllById(Iterable<? extends Integer> integers) {

            }

            @Override
            public void deleteAll(Iterable<? extends SaleEntity> entities) {

            }

            @Override
            public void deleteAll() {

            }

            @Override
            public List<SaleEntity> findAll(Sort sort) {
                return null;
            }

            @Override
            public Page<SaleEntity> findAll(Pageable pageable) {
                return null;
            }

            @Override
            public <S extends SaleEntity> Optional<S> findOne(Example<S> example) {
                return Optional.empty();
            }

            @Override
            public <S extends SaleEntity> Page<S> findAll(Example<S> example, Pageable pageable) {
                return null;
            }

            @Override
            public <S extends SaleEntity> long count(Example<S> example) {
                return 0;
            }

            @Override
            public <S extends SaleEntity> boolean exists(Example<S> example) {
                return false;
            }

            @Override
            public <S extends SaleEntity, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
                return null;
            }
        };
    }

    @Bean
    public SaleLineItemRepository saleLineItemRepository() {
        return new SaleLineItemRepository() {
            @Override
            public void flush() {

            }

            @Override
            public <S extends SaleLineItemEntity> S saveAndFlush(S entity) {
                return null;
            }

            @Override
            public <S extends SaleLineItemEntity> List<S> saveAllAndFlush(Iterable<S> entities) {
                return null;
            }

            @Override
            public void deleteAllInBatch(Iterable<SaleLineItemEntity> entities) {

            }

            @Override
            public void deleteAllByIdInBatch(Iterable<Integer> integers) {

            }

            @Override
            public void deleteAllInBatch() {

            }

            @Override
            public SaleLineItemEntity getOne(Integer integer) {
                return null;
            }

            @Override
            public SaleLineItemEntity getById(Integer integer) {
                return null;
            }

            @Override
            public SaleLineItemEntity getReferenceById(Integer integer) {
                return null;
            }

            @Override
            public <S extends SaleLineItemEntity> List<S> findAll(Example<S> example) {
                return null;
            }

            @Override
            public <S extends SaleLineItemEntity> List<S> findAll(Example<S> example, Sort sort) {
                return null;
            }

            @Override
            public <S extends SaleLineItemEntity> List<S> saveAll(Iterable<S> entities) {
                return null;
            }

            @Override
            public List<SaleLineItemEntity> findAll() {
                return null;
            }

            @Override
            public List<SaleLineItemEntity> findAllById(Iterable<Integer> integers) {
                return null;
            }

            @Override
            public <S extends SaleLineItemEntity> S save(S entity) {
                return null;
            }

            @Override
            public Optional<SaleLineItemEntity> findById(Integer integer) {
                return Optional.empty();
            }

            @Override
            public boolean existsById(Integer integer) {
                return false;
            }

            @Override
            public long count() {
                return 0;
            }

            @Override
            public void deleteById(Integer integer) {

            }

            @Override
            public void delete(SaleLineItemEntity entity) {

            }

            @Override
            public void deleteAllById(Iterable<? extends Integer> integers) {

            }

            @Override
            public void deleteAll(Iterable<? extends SaleLineItemEntity> entities) {

            }

            @Override
            public void deleteAll() {

            }

            @Override
            public List<SaleLineItemEntity> findAll(Sort sort) {
                return null;
            }

            @Override
            public Page<SaleLineItemEntity> findAll(Pageable pageable) {
                return null;
            }

            @Override
            public <S extends SaleLineItemEntity> Optional<S> findOne(Example<S> example) {
                return Optional.empty();
            }

            @Override
            public <S extends SaleLineItemEntity> Page<S> findAll(Example<S> example, Pageable pageable) {
                return null;
            }

            @Override
            public <S extends SaleLineItemEntity> long count(Example<S> example) {
                return 0;
            }

            @Override
            public <S extends SaleLineItemEntity> boolean exists(Example<S> example) {
                return false;
            }

            @Override
            public <S extends SaleLineItemEntity, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
                return null;
            }
        };
    }
}
