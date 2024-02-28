package com.zbhg.mcp.firstProject.models;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Optional;

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
}
