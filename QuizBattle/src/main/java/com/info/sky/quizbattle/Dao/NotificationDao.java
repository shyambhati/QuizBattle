package com.info.sky.quizbattle.Dao;

import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.info.sky.quizbattle.entity.NotificationEntity;


@Repository
@Transactional
public interface NotificationDao extends JpaRepository<NotificationEntity, Integer>{

}
