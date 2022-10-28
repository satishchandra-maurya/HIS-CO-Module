package in.satish.repo;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import in.satish.entity.CoTriggers;

public interface CoTriggersRepo extends JpaRepository<CoTriggers, Serializable>{

}
