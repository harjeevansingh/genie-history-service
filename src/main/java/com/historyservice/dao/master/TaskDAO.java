package com.historyservice.dao.master;

import com.historyservice.entities.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author harjeevanSingh
 */

public interface TaskDAO extends JpaRepository<Task, Long>{
    List<Task> findAllByOrderByIdDesc();
}
