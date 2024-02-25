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
            public <S extends Item> S save(S s) {
                System.out.println("save method");
                return null;
            }

            @Override
            public <S extends Item> Iterable<S> saveAll(Iterable<S> iterable) {
                return null;
            }

            @Override
            public Optional<Item> findById(Integer integer) {
                return Optional.empty();
            }

            @Override
            public boolean existsById(Integer integer) {
                return false;
            }

            @Override
            public Iterable<Item> findAll() {
                return null;
            }

            @Override
            public Iterable<Item> findAllById(Iterable<Integer> iterable) {
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
            public void delete(Item item) {
            }

            @Override
            public void deleteAllById(Iterable<? extends Integer> iterable) {

            }

            @Override
            public void deleteAll(Iterable<? extends Item> iterable) {

            }

            @Override
            public void deleteAll() {

            }
        }; // Or create an instance of your repository implementation
    }
}
