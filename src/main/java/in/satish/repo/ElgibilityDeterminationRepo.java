package in.satish.repo;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import in.satish.entity.ElgibilityDetermination;

public interface ElgibilityDeterminationRepo extends JpaRepository<ElgibilityDetermination, Serializable>{

}
