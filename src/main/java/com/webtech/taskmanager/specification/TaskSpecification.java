package com.webtech.taskmanager.specification;

import com.webtech.taskmanager.model.SearchCriteria;
import com.webtech.taskmanager.model.Task;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;

public class TaskSpecification implements Specification<Task> {

    private List<SearchCriteria> searchCriterias;

    public TaskSpecification (List<SearchCriteria> searchCriterias) {
        this.searchCriterias = searchCriterias;
    }

    @Override
    public Predicate toPredicate(Root<Task> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {

        for (SearchCriteria searchCriteria : searchCriterias) {
            if (searchCriteria.getOperation().equalsIgnoreCase(">")) {
                return criteriaBuilder.greaterThan(
                        root.get(searchCriteria.getKey()), searchCriteria.getValue().toString());
            } else if (searchCriteria.getOperation().equalsIgnoreCase(">=")) {
                return criteriaBuilder.greaterThanOrEqualTo(
                        root.get(searchCriteria.getKey()), searchCriteria.getValue().toString()
                );
            } else if (searchCriteria.getOperation().equalsIgnoreCase("<")) {
                return criteriaBuilder.lessThan(
                        root.get(searchCriteria.getKey()), searchCriteria.getValue().toString()
                );
            } else if (searchCriteria.getOperation().equalsIgnoreCase("<=")) {
                return criteriaBuilder.lessThanOrEqualTo(
                        root.get(searchCriteria.getKey()), searchCriteria.getValue().toString()
                );
            } else if (searchCriteria.getOperation().equalsIgnoreCase("=")) {
                return criteriaBuilder.equal(
                        root.get(searchCriteria.getKey()), searchCriteria.getValue().toString()
                );
            }
        }
        return null;
    }
}
