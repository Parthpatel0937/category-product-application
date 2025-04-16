package com.parth.productapp.category;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CategoryRepository extends JpaRepository<Category, Long>
       // PagingAndSortingRepository<Category, Long>
{
}
